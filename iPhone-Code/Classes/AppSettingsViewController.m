//
//  AppSettingsViewController.m
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

#import "AppSettingsViewController.h"
#import "AppDelegate.h"
#import "SoundManager.h"


@implementation AppSettingsViewController

@synthesize delegate;

@synthesize tableList, myTableView, deviceType, textColor, speechAlertsSwitch;
@synthesize cell00, cell0, cell0a, cell1, cell2, cell3, cell1a;
@synthesize textColorControl, encounterTextColorSwitch, leftHandEncountersSwitch, gameSoundsSwitch;
@synthesize myVolume, backgroundMusicSwitch, backgroundVolumeSlider, autoLoadGameSwitch;

- (void)dealloc {
	[cell00 release];
	[cell0 release];
	[cell0a release];
	[cell1 release];
	[cell2 release];
	[cell3 release];
	[cell1a release];
	
	[tableList release];
	[deviceType release];
		
	[myVolume release];
	[textColor release];

	[myTableView release];
	[super dealloc];
	
}

// The designated initializer.  Override if you create the controller programmatically and want to perform customization that is not appropriate for viewDidLoad.
- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
    if (self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil]) {

    }
    return self;
}

- (void)playClickSound {
	if(_soundsIsOn)
		[[SoundManager sharedSound] playSoundWithId:kSwitchClick];
}


- (IBAction)done {
	[defaults synchronize];
	
	[self.delegate appSettingsViewControllerDidFinish:self];	
	[self dismissModalViewControllerAnimated:YES];
}

-(void)autoLoadNotice {
	[[[AppDelegate sharedAppDelegate]gamePlayer]showUserNotice:aAlert];		
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Notice" message:@"Please remember to periodically save your game. The Auto Load feature, while a great time saver does not update any of your saved games. If your game ends you can only load the last 'manually' saved copy of your game (AutoSave games are lost with your ship)."
												   delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles: nil];
	[alert show];
	[alert release];
	didShowNotice = TRUE;
}

- (IBAction)autoLoadGameSwitch:(id)sender {
	[self playClickSound];
	if ([sender isOn]) {
		if(!didShowNotice)
			[self autoLoadNotice];
		[defaults setBool:TRUE forKey:@"autoLoadGame"];
	} else {
		[defaults setBool:FALSE forKey:@"autoLoadGame"];
	}
}
- (IBAction)backgroundVolumeSlider:(id)sender {
	float newHealth = self.backgroundVolumeSlider.value;
	self.myVolume.text = [NSString stringWithFormat:@"%0.0f%%", newHealth * 100];
	[[AppDelegate sharedAppDelegate] musicVolume:newHealth];
	
}
- (IBAction)backgroundMusicSwitch:(id)sender {
	[self playClickSound];
	if ([sender isOn]) {
		[[[AppDelegate sharedAppDelegate] gamePlayer] enableMusic];
	} else {
		[[[AppDelegate sharedAppDelegate] gamePlayer] disableMusic];
	}
}
- (IBAction)leftHandEncountersSwitch:(id)sender {
	[self playClickSound];
	if ([sender isOn]) {
		[[[AppDelegate sharedAppDelegate] gamePlayer] enableLeftHandEncounter];
	} else {
		[[[AppDelegate sharedAppDelegate] gamePlayer] disableLeftHandEncounter];
	}
}
- (IBAction)gameSoundsSwitch:(id)sender {
	[self playClickSound];
	if ([sender isOn]) {
		[[[AppDelegate sharedAppDelegate] gamePlayer] enableSound];
		_soundsIsOn = TRUE;
	} else {
		[[[AppDelegate sharedAppDelegate] gamePlayer] disableSound];
		_soundsIsOn = FALSE;
	}
}
- (IBAction)speechAlertsSwitch:(id)sender {
	[self playClickSound];
	if ([sender isOn]) {
		[[[AppDelegate sharedAppDelegate] gamePlayer] enableSpeech];
		[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"TalkingAlertsEnabled.caf"];
	} else {
		[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"TalkingAlertsDisabled.caf"];
		[[[AppDelegate sharedAppDelegate] gamePlayer] disableSpeech];
	}
}
-(void)setLabelColor: (int)choice {
	switch (choice) {
		case 0:
			textColor.textColor = [UIColor greenColor];
			break;
		case 1:
			textColor.textColor = [UIColor blueColor];
			break;
		case 2:
			textColor.textColor = [UIColor redColor];
			break;
		default:
			textColor.textColor = [UIColor whiteColor];
			break;
	}
}	
- (IBAction)encounterTextColorSwitch:(id)sender {
	[self playClickSound];
	if ([sender isOn]) {
		[defaults setBool:TRUE forKey:@"useCustomTextColor"];
		[self setLabelColor:[defaults integerForKey:@"encounterTextColorValue"]];
		self.textColorControl.hidden = FALSE;
	} else {
		[defaults setBool:FALSE forKey:@"useCustomTextColor"];
		self.textColorControl.hidden = TRUE;
		[self setLabelColor:4];
	}
}
- (void)textColorSegment:(id)sender {
	self.textColorControl.selectedSegmentIndex = [sender selectedSegmentIndex];
	[self.textColorControl setEnabled:TRUE forSegmentAtIndex:[sender selectedSegmentIndex]];
	[defaults setInteger:[sender selectedSegmentIndex] forKey:@"encounterTextColorValue"];
	[self setLabelColor:[sender selectedSegmentIndex]];
}

-(void)readDefaults {
	
    defaults = [NSUserDefaults standardUserDefaults];

	_soundsIsOn = [defaults boolForKey:@"soundEnabled"];
	
	if ([defaults boolForKey:@"autoLoadGame"]) {
		[self.autoLoadGameSwitch setOn: YES animated: NO];
	} else {
		[self.autoLoadGameSwitch setOn: NO animated: NO];
	}

	backgroundVolumeSlider.value = ([defaults floatForKey:@"musicVolume"]);
	if (backgroundVolumeSlider.value < 0.05)
		backgroundVolumeSlider.value = 0.5f;
	self.myVolume.text = [NSString stringWithFormat:@"%0.0f%%", backgroundVolumeSlider.value * 100];
	
	textColorControl.selectedSegmentIndex = ([defaults integerForKey:@"encounterTextColorValue"]);
	if (textColorControl.selectedSegmentIndex < 0)
		textColorControl.selectedSegmentIndex = 0;

	if ([defaults boolForKey:@"useCustomTextColor"]) {
		[self.encounterTextColorSwitch setOn: YES animated: NO];
		self.textColorControl.hidden = FALSE;
		[self setLabelColor:textColorControl.selectedSegmentIndex];
	} else {
		[self.encounterTextColorSwitch setOn: NO animated: NO];
		self.textColorControl.hidden = TRUE;
		[self setLabelColor:4];
	}
	if (_soundsIsOn) {
		[self.gameSoundsSwitch setOn: YES animated: NO];
	} else {
		[self.gameSoundsSwitch setOn: NO animated: NO];
	}
	if ([defaults boolForKey:@"speechAlerts"]) {
		[self.speechAlertsSwitch setOn: YES animated: NO];
	} else {
		[self.speechAlertsSwitch setOn: NO animated: NO];
	}
	if ([defaults boolForKey:@"leftHandEncounter"]) {
		[self.leftHandEncountersSwitch setOn: YES animated: NO];
	} else {
		[self.leftHandEncountersSwitch setOn: NO animated: NO];
	}
	if ([defaults boolForKey:@"musicEnabled"]) {
		[self.backgroundMusicSwitch setOn: YES animated: NO];
	} else {
		[self.backgroundMusicSwitch setOn: NO animated: NO];
	}
	
}


- (void)viewDidLoad {
	
	self.title = @"Settings";
	
    [super viewDidLoad];

	UIBarButtonItem *backBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@"Close" style:UIBarButtonItemStyleBordered target:self action:@selector(done)];
    self.navigationItem.backBarButtonItem = backBarButtonItem;
    [backBarButtonItem release];
	
	[self readDefaults];
	
}


#pragma mark Table Selection 

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
	int section = [indexPath section];
	int row = [indexPath row];
	
	switch (section) {
		case 0:
			switch (row) {
				case 2:
					return 70.0f;
				case 6:
					return 90.0f;
				default:
					return 44.0f;
					break;
			}
		case 2:
			switch (row) {
				case 1:
					return 70.0f;
				default:
					return 44.0f;
					break;
			}
		default:
			return 44.0f;
	}
}


- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
	return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
	
	switch (section) {
		case 0:
			return 7;
		default:
			return 1;
	}	
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
	
	NSInteger row = [indexPath row];
	NSInteger section = [indexPath section];
	
	switch (section) {
		case 0:
			switch (row) {
				case 0:
					return cell00;
					break;
				case 1:
					return cell0;
					break;
				case 2:
					return cell0a;
					break;
				case 3:
					return cell1;
					break;
				case 4:
					return cell1a;
					break;
				case 5:
					return cell2;
					break;
				case 6:
					return cell3;
					break;
			}
			break;
		default:
			break;
	}
	return nil;
}


- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}

- (void)viewDidUnload {
	[super viewDidUnload];
	// Release any retained subviews of the main view.
	// e.g. self.myOutlet = nil;
}


@end
