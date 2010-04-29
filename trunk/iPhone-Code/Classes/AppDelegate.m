//
//  AppDelegate.m
//
//  Copyright (C) Dead Jim Studios 2009-2010, All rights reserved.
//
// This file is Part of Dark Nova.
//
// Dark Nova is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Dark Nova is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Dark Nova.  If not, see <http://www.gnu.org/licenses/>.
//
//

#import <UIKit/UIKit.h>
#import "AppDelegate.h"
#import "StartGameViewController.h"
#import "Player.h"
#import "MainToolBar.h"

#import "SoundEngine.h"
#import "SoundManager.h"


#define kListenerDistance			1.0	


@implementation AppDelegate

+ (AppDelegate *)sharedAppDelegate
{
    return (AppDelegate *) [UIApplication sharedApplication].delegate;
}

@synthesize window, commandView;
@synthesize navigationController, mainToolbar, startToolbar;
@synthesize fromOptions, sellBadge, sellBadgeLabel, shipYardBadge, passengerBadge;
@synthesize gamePlayer, isGameLoaded, memNoticeCounter;


BOOL bStartNewGame;

#pragma mark -
#pragma mark Init Defaults
+ (void) initialize {
	if(self == [AppDelegate class]) {
		
		NSNumber *VolumeValue = [NSNumber numberWithFloat:0.5];
		NSNumber *BoolValTrue = [NSNumber numberWithBool:YES];
		NSNumber *BoolValFalse = [NSNumber numberWithBool:NO];
		NSString *DeviceType = [[UIDevice currentDevice] model];
		
		NSDictionary *resourceDict = [NSDictionary dictionaryWithObjectsAndKeys:
									  BoolValTrue,@"isFirstRun",
									  BoolValTrue,@"didAutoLoad",
									  BoolValFalse,@"autoLoadGame",
									  BoolValFalse,@"loadFromMemory",
									  BoolValFalse,@"leftHandEncounter",
									  BoolValTrue,@"musicEnabled",
									  VolumeValue,@"musicVolume",
									  BoolValTrue,@"soundEnabled",
									  BoolValTrue,@"speechAlerts",
									  DeviceType,@"deviceType",nil];
		
		[[NSUserDefaults standardUserDefaults] registerDefaults:resourceDict];
	}
}

-(BOOL)fileDoesExist:(NSString *)fileName {
	NSArray *filePaths = NSSearchPathForDirectoriesInDomains (NSDocumentDirectory, NSUserDomainMask, YES); 
	NSString *recordingDirectory = [filePaths objectAtIndex: 0];
	NSString *file = [NSString stringWithFormat:@"%@/%@.save", recordingDirectory, fileName];
	if ([[NSFileManager defaultManager] fileExistsAtPath:file]) {
		return TRUE;		
	}
	return FALSE;
}


#pragma mark -
#pragma mark Audio Work
-(BOOL)isSoundFilePresent:(NSString *)fileName {	
	if ([[NSFileManager defaultManager] fileExistsAtPath:[[NSBundle mainBundle] pathForResource:fileName ofType:nil]])
		return TRUE;
	
	return FALSE;
}

-(void)switchTrack {
#if TARGET_CPU_ARM
	if (_musicIsPlaying) {
		SoundEngine_PauseBackgroundMusic();
		SoundEngine_UnloadBackgroundMusicTrack();
		if (ambianceIsPlaying) {
			if ([self isSoundFilePresent:@"Encounter.m4a"])
				SoundEngine_LoadBackgroundMusicTrack([[[NSBundle mainBundle] pathForResource:@"Encounter" ofType:@"m4a"] UTF8String], FALSE, FALSE);
		}
		else {
			if ([self isSoundFilePresent:@"Ambiance.m4a"])
				SoundEngine_LoadBackgroundMusicTrack([[[NSBundle mainBundle] pathForResource:@"Ambiance" ofType:@"m4a"] UTF8String], FALSE, FALSE);
		}
		SoundEngine_StartBackgroundMusic();
		ambianceIsPlaying = !ambianceIsPlaying;
	}
#endif
}

-(void)stopMusic {
	if(_musicIsPlaying) {
		SoundEngine_PauseBackgroundMusic();
		_musicIsPlaying = FALSE;
	}
}

-(void)startMusic {
	if(!_musicIsPlaying) {
		SoundEngine_StartBackgroundMusic();
		_musicIsPlaying = TRUE;
	}
}
-(void)loadMusic {
	if ([self isSoundFilePresent:@"Ambiance.m4a"]) {
		SoundEngine_LoadBackgroundMusicTrack([[[NSBundle mainBundle] pathForResource:@"Ambiance" ofType:@"m4a"] UTF8String], TRUE, FALSE);
		ambianceIsPlaying = TRUE;
		if ([defaults floatForKey:@"musicVolume"] < 0) {
			[defaults setFloat:0.5 forKey:@"musicVolume"];
			[defaults synchronize];
		}
		SoundEngine_SetBackgroundMusicVolume([defaults floatForKey:@"musicVolume"]);
		
		if ([defaults boolForKey:@"musicEnabled"]) {
			SoundEngine_StartBackgroundMusic();
			_musicIsPlaying = TRUE;
		}
	}
	else {
		UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"System Error" message:@"Unable to locate background sound file. Please reinstall the application." delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
		[alert show];
		[alert release];		
	}


}

-(void)musicVolume: (float)newVolume {
	SoundEngine_SetBackgroundMusicVolume(newVolume);
	[defaults setFloat:newVolume forKey:@"musicVolume"];
	[defaults synchronize];
}

- (void)loadAudioSystemSounds {
    [[SoundManager sharedSound] startAudio:self];	
}

- (void) pauseSoundSystem {
	if ([defaults boolForKey:@"musicEnabled"]) 
		SoundEngine_StopBackgroundMusic(FALSE);
	
	SoundEngine_UnloadBackgroundMusicTrack();
	SoundEngine_Teardown();
	NSLog(@"Sound System was shut down...");
}

- (void) restartSoundSystem {
	
	AudioSessionInitialize (NULL,NULL,NULL,NULL);
	UInt32 sessionCategory = kAudioSessionCategory_SoloAmbientSound;
	int audio_ret = AudioSessionSetProperty( kAudioSessionProperty_AudioCategory, sizeof( sessionCategory ), &sessionCategory );
	audio_ret |= AudioSessionSetActive(YES);	
	SoundEngine_Initialize(44100);
	SoundEngine_SetListenerPosition(0.0, 0.0, kListenerDistance);		
	[self loadMusic];
	NSLog(@"Sound System was (re)launched...");
	
}	

- (void)applicationWillResignActive:(UIApplication *)application {
	[self pauseSoundSystem];
}

- (void)applicationDidBecomeActive:(UIApplication *)application {
	[self restartSoundSystem];
}

-(void)initTheGame {
	gamePlayer = [[Player alloc] initEmpty];
	[gamePlayer initGlobals];
	bStartNewGame = TRUE;
	fromOptions = FALSE;
	memNoticeCounter = 0;
	
}

-(void)playSoundMemoryNotice {
	if ([defaults boolForKey:@"speechAlerts"])
		[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"GameHasBeenRestored.caf"];
	else 
		[[SoundManager sharedSound] playSoundWithId:kLedLum];
}
-(void)playSoundAutoLoadNotice {
	if ([defaults boolForKey:@"speechAlerts"])
		[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"GameHasBeenRestored.caf"];
	else 
		[[SoundManager sharedSound] playSoundWithId:kPling];
}

-(void)removeMemorySaveFile {
	if([self fileDoesExist:@"MemorySave"]) {
		[[[AppDelegate sharedAppDelegate] gamePlayer]eraseSaveFile:@"MemorySave"];
		[defaults setBool:FALSE forKey:@"loadFromMemory"];
		[defaults synchronize];
	}
}
-(void)loadAfterMemoryWarning {
	if([self fileDoesExist:@"MemorySave"]) {
		[[[AppDelegate sharedAppDelegate] gamePlayer] loadTheGame:@"MemorySave"];
		[self performSelector:@selector(removeMemorySaveFile) withObject:self afterDelay:0.8];
		UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Notice" message:@"Your game has been restored.\nIf you continue to experience low memory notices please consider restarting your device." delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
		[alert show];
		[alert release];
		[self performSelector:@selector(playSoundMemoryNotice) withObject:self afterDelay:0.8];
	}
}

-(void)removeAutoLoadFile {
	if([self fileDoesExist:@"AutoLoad"]) {
		[[[AppDelegate sharedAppDelegate] gamePlayer]eraseSaveFile:@"AutoLoad"];
	}
	
}
-(void)autoLoadSavedGame {
	if (![defaults boolForKey:@"didAutoLoad"]) {
		if([self fileDoesExist:@"AutoLoad"]) {
			[[[AppDelegate sharedAppDelegate] gamePlayer] loadTheGame:@"AutoLoad"];
			[self performSelector:@selector(removeAutoLoadFile) withObject:self afterDelay:0.8];
			[defaults setBool:TRUE forKey:@"didAutoLoad"];
			[defaults synchronize];
			UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Notice" message:@"Your game has been restored." delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
			[alert show];
			[alert release];
			[self performSelector:@selector(playSoundAutoLoadNotice) withObject:self afterDelay:0.8];
		}
	}
}

-(void)contAppLoading {
	if ([defaults boolForKey:@"loadFromMemory"]) {
		[self loadAfterMemoryWarning];
	}
	else if ([defaults boolForKey:@"autoLoadGame"]) {
		[self autoLoadSavedGame];
	}
	else {
		[self removeAutoLoadFile];
		if ([defaults boolForKey:@"isFirstRun"]) {
			[[[AppDelegate sharedAppDelegate]gamePlayer]playSoundFile:@"WelcomeToHyperWarpReady.caf"];
			[defaults setBool:FALSE forKey:@"isFirstRun"];
			[defaults synchronize];			
		}
		else 
			[[[AppDelegate sharedAppDelegate]gamePlayer]playSoundFile:@"WelcomeToHyperWarp.caf"];
		
	}	
}


- (void)loadMainToolBar {
	[mainToolbar sizeToFit];
	CGFloat toolbarHeight = [mainToolbar frame].size.height;
	CGRect mainViewBounds = navigationController.view.bounds;
	[mainToolbar setFrame:CGRectMake(CGRectGetMinX(mainViewBounds),
									 CGRectGetMinY(mainViewBounds) + CGRectGetHeight(mainViewBounds) - (toolbarHeight ) + 2.0,
									 CGRectGetWidth(mainViewBounds),
									 toolbarHeight)];
	[[navigationController view] addSubview:mainToolbar];
	
	self.shipYardBadge.frame = CGRectMake(103.0, 430.0, 32.0, 32.0);
	[[navigationController view] addSubview:shipYardBadge];
	
	self.sellBadge.frame = CGRectMake(165.0, 430.0, 32.0, 32.0);
	[[navigationController view] addSubview:sellBadge];
	
	self.passengerBadge.frame = CGRectMake(294.0, 430.0, 26.0, 26.0);
	[[navigationController view] addSubview:passengerBadge];
}

#pragma mark didFinishLaunching
- (void)applicationDidFinishLaunching:(UIApplication *)application {
	defaults = [NSUserDefaults standardUserDefaults];
	
	[self initTheGame];
	[window makeKeyAndVisible];

	[window addSubview:navigationController.view];		
	[self showStartGame];

	[self performSelector:@selector(loadAudioSystemSounds) withObject:nil afterDelay:0.0];
	
	[self loadMainToolBar];
	
	self.mainToolbar.hidden = TRUE;
	[self hideBadges];
	
	[startToolbar sizeToFit];
	CGFloat toolbarHeight = [startToolbar frame].size.height;
	CGRect mainViewBounds = navigationController.view.bounds;
	[startToolbar setFrame:CGRectMake(CGRectGetMinX(mainViewBounds),
									  CGRectGetMinY(mainViewBounds) + CGRectGetHeight(mainViewBounds) - (toolbarHeight ) + 2.0,
									  CGRectGetWidth(mainViewBounds),
									  toolbarHeight)];
	[[navigationController view] addSubview:startToolbar];
	self.startToolbar.hidden = FALSE;
	
	[self contAppLoading];
	
}

-(void)showStartGame {
	isGameLoaded = FALSE;
	bStartNewGame = TRUE;

	[self hideBadges];
	self.mainToolbar.hidden = TRUE;
	self.startToolbar.hidden = FALSE;

	HelloWindowViewController *helloWindow = [[[HelloWindowViewController alloc] initWithNibName:@"HelloWindow" bundle:nil] autorelease];
	NSArray* arr = [NSArray arrayWithObjects:helloWindow, nil];
	[self.navigationController setViewControllers:arr];
}

-(void)switchBarToGame {
	if(!fromOptions) {
		if (bStartNewGame) {
			bStartNewGame = FALSE;
			self.mainToolbar.hidden = FALSE;
			[self updateToolBar];
			self.startToolbar.hidden = TRUE;
		}
	}
}

-(void)hideBadges {
	self.sellBadge.hidden = TRUE;
	self.shipYardBadge.hidden = TRUE;
	self.passengerBadge.hidden = TRUE;
}

-(void)setGameMode {
	self.mainToolbar.hidden = FALSE;
	[self updateToolBar];
	self.startToolbar.hidden = TRUE;	
}

-(void)updateToolBar {
	if (! bStartNewGame) {
		if ([[[AppDelegate sharedAppDelegate]gamePlayer]filledCargoBays] > 0) {
			self.sellBadge.hidden = FALSE;
			self.sellBadgeLabel.text = [NSString stringWithFormat:@"%i",[[[AppDelegate sharedAppDelegate]gamePlayer]filledCargoBays]];
		}
		else {
			self.sellBadge.hidden = TRUE;
		}	
		if (([[[AppDelegate sharedAppDelegate]gamePlayer] getFuel] < [[[AppDelegate sharedAppDelegate]gamePlayer] getFuelTanks]) || ([[[AppDelegate sharedAppDelegate]gamePlayer] getShipHull] < [[[AppDelegate sharedAppDelegate]gamePlayer] getHullStrength])) {
			self.shipYardBadge.hidden = FALSE;
		}
		else {
			self.shipYardBadge.hidden = TRUE;
		}
		if ([[[AppDelegate sharedAppDelegate]gamePlayer]transportPassengers]) {
			self.passengerBadge.hidden = FALSE;
		}
		else {
			self.passengerBadge.hidden = TRUE;
		}
	}
}

-(IBAction)commandCommand {
	
	if (commandView != navigationController.topViewController) {
		if (!commandView)
			commandView = [[CommandViewController alloc] initWithNibName:@"Commands" bundle:nil];
		
		NSArray *array = [NSArray arrayWithObjects:commandView, nil];
		self.navigationController.viewControllers = array;
	}
}

-(IBAction)shipYardCommand {
	[self commandCommand];
	[commandView shipYard];
}

-(IBAction)sellCargoAction {
	[self commandCommand];
	[commandView sellCargo];
}

-(IBAction)systemInfoCommand {
	[self commandCommand];
	[commandView systemInformation];
}

-(IBAction)navigateAction {
	[self commandCommand];
	[commandView shortRangeChart];
}


-(void)dealloc {
	[window release];
	[sellBadge release];
	[sellBadgeLabel release];
	[shipYardBadge release];
	[passengerBadge release];
	
	SoundEngine_Teardown();	
	[super dealloc];
}

#pragma mark -
#pragma mark Application Subsystem	
- (void)applicationWillTerminate:(UIApplication *)application {
	if (![defaults boolForKey:@"loadFromMemory"]) {
		if (!bStartNewGame) { 
			if ([defaults boolForKey:@"autoLoadGame"]) {
				[[[AppDelegate sharedAppDelegate] gamePlayer] saveTheGame:@"AutoLoad"];
				[defaults setBool:FALSE forKey:@"didAutoLoad"];
				[defaults synchronize];
			}
		}
	}
}

-(IBAction) startNewGame {
	if (!newGame)
		newGame = [[StartGameViewController alloc] initWithNibName:@"NewGame" bundle:nil];
	NSArray *array = [NSArray arrayWithObjects:newGame, nil];	
	self.navigationController.viewControllers = array;
	
}

-(IBAction)loadJumpStart {
	if (!jumpStart)
		jumpStart = [[JumpStartViewController alloc] initWithNibName:@"JumpStart" bundle:nil];
	isGameLoaded = TRUE;
	NSArray *array = [NSArray arrayWithObjects:jumpStart, nil];	
	self.navigationController.viewControllers = array;
	[saveGame setRetireMode];
}

-(IBAction) loadGame {	
	if (!saveGame)
		saveGame = [[SaveGameViewController alloc] initWithNibName:@"SaveGames" bundle:nil];
	isGameLoaded = TRUE;
	NSArray *array = [NSArray arrayWithObjects:saveGame, nil];	
	self.navigationController.viewControllers = array;
	[saveGame setRetireMode];
}

-(IBAction) help {
	if (!helpWindow)
		helpWindow	= [[HelpViewController alloc] initWithNibName:@"Help" bundle:nil];
	
	NSString *filePath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:@"HTML/QuickStart.html"];
	helpWindow.location = [NSURL fileURLWithPath:filePath];
	helpWindow.title = @"Quick Start";
	NSArray *array = [NSArray arrayWithObjects:helpWindow, nil];	
	self.navigationController.viewControllers = array;
	helpWindow.theTitle.hidden = TRUE;	
	
}


@end
