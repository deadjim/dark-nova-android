//
//  AppDelegate.h
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
#import "HelloWindowViewController.h"
#import "Player.h"
#include <AudioToolbox/AudioToolbox.h>

#import "AlertModalWindow.h"
#import "AlertModalTextWindow.h"
#import "StartGameViewController.h"
#import "StartGameToolBar.h"

#import "CommandViewController.h"
#import "SaveGameViewController.h"
#import "HelpViewController.h"
#import "ShipInfoViewController.h"
#import "BuyShipViewController.h"
#import "JumpStartViewController.h"

@class Player;
@class mainTabBar;
@class CommandViewController;
@class MainToolBar;
@class GameViewController;

enum {
	kSound_Background = 0,
	kNumSounds
};


@interface AppDelegate : NSObject <UIApplicationDelegate> {
	IBOutlet UIWindow				*window;
	IBOutlet UINavigationController	*navigationController;
	IBOutlet MainToolBar			*mainToolbar;
	IBOutlet StartGameToolBar		*startToolbar;
	IBOutlet UIView					*sellBadge;
	IBOutlet UILabel				*sellBadgeLabel;
	IBOutlet UIView					*shipYardBadge;
	IBOutlet UIView					*passengerBadge;

	UInt32							_sounds[kNumSounds];
	BOOL							_musicIsPlaying;
	BOOL							ambianceIsPlaying;

	HelpViewController *helpWindow;
	IBOutlet CommandViewController	*commandView;
	StartGameViewController			*newGame;
	SaveGameViewController			*saveGame;
	JumpStartViewController			*jumpStart;

	Player							*gamePlayer;
	BOOL							isGameLoaded;
	NSUserDefaults					*defaults;
	BOOL	fromOptions;
	int		memNoticeCounter;

	int									*tempMemory0;
	int									*tempMemory1;
	int									*tempMemory2;
	int									*tempMemory3;
	int									*tempMemory4;
	int									*tempMemory5;
	float								memoryToFree;
	int									myFreeMem;
	int									myTotalMem;
	BOOL								_runLoop;

	
}
+ (AppDelegate *)sharedAppDelegate;

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) CommandViewController *commandView;
@property (nonatomic, retain) IBOutlet StartGameToolBar *startToolbar;
@property (nonatomic, retain) UINavigationController *navigationController;
@property (nonatomic, retain) IBOutlet MainToolBar *mainToolbar;
@property (nonatomic, retain) Player *gamePlayer;
@property (nonatomic, retain) IBOutlet UIView *sellBadge;
@property (nonatomic, retain) IBOutlet UILabel *sellBadgeLabel;
@property (nonatomic, retain) IBOutlet UIView *shipYardBadge;
@property (nonatomic, retain) IBOutlet UIView *passengerBadge;

@property BOOL isGameLoaded;
@property BOOL fromOptions;
@property int memNoticeCounter;

-(void)switchBarToGame;
-(void)setGameMode;
-(void)updateToolBar;

-(void)stopMusic;
-(void)startMusic;
-(void)musicVolume: (float)newVolume;

-(IBAction)commandCommand;

-(IBAction)loadJumpStart;
-(IBAction)startNewGame;
-(IBAction)loadGame;
-(IBAction)help;
-(IBAction)shipYardCommand;
-(IBAction)sellCargoAction;
-(IBAction)systemInfoCommand;
-(IBAction)navigateAction;

-(void)loadMainToolBar;
-(void)showStartGame;
-(void)hideBadges;
-(void)switchTrack;


@end

