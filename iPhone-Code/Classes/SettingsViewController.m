//
//  SettingsViewController.m
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

#import "SettingsViewController.h"
#import "HelpViewController.h"
#import "AppDelegate.h"
#import "SoundManager.h"


@implementation SettingsViewController

@synthesize delegate;

@synthesize tableList, myTableView, deviceType, myEmpty;
@synthesize cell4, cell5, cell6, cell7, cell8, cell9,  cell10;
@synthesize cell11, cell12, cell13, cell14, cell15, cell16, cell17, cell18;
@synthesize emptyCargoBaysSlider, fullTankSwitch, hullRepairSwitch, buyNewsSwitch, loanRemindersSwitch;
@synthesize	reserveWarpSwitch, alwaysPoliceSwitch, alwaysPiratesSwitch, alwaysTradersSwitch, ignoreDealersSwitch;
@synthesize	continuousFleeingSwitch, continuousFightingSwitch, stopTrackingSwitch, rangeToTrackedSwitch;


- (void)dealloc {
	[cell4 release];
	[cell5 release];
	[cell6 release];
	[cell7 release];
	[cell8 release];
	[cell9 release];
	[cell10 release];
	[cell11 release];
	[cell12 release];
	[cell13 release];
	[cell14 release];
	[cell15 release];
	[cell16 release];
	[cell17 release];
	[cell18 release];
	
	[tableList release];
	[deviceType release];
		
	[myEmpty release];

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
	if(_extraSoundsOn)
		[[SoundManager sharedSound] playSoundWithId:kSwitchClick];
}


- (IBAction)done {
	[self.delegate settingsViewControllerDidFinish:self];	
	[self dismissModalViewControllerAnimated:YES];
}


- (IBAction)emptyCargoBaysSlider:(id)sender {
	float newHealth = self.emptyCargoBaysSlider.value;
	self.myEmpty.text = [NSString stringWithFormat:@"%i", (int)newHealth];
	[[[AppDelegate sharedAppDelegate] gamePlayer] setLeaveEmpty:(int)newHealth];
	
}

- (IBAction)fullTankSwitch:(id)sender {
	[self playClickSound];
	[[[AppDelegate sharedAppDelegate] gamePlayer] setAutoFuel:[sender isOn]];
}
- (IBAction)hullRepairSwitch:(id)sender {
	[self playClickSound];
	[[[AppDelegate sharedAppDelegate] gamePlayer] setAutoRepair:[sender isOn]];
}
- (IBAction)buyNewsSwitch:(id)sender {
	[self playClickSound];
	[[[AppDelegate sharedAppDelegate] gamePlayer] setNewsAutoPay:[sender isOn]];
}
- (IBAction)loanRemindersSwitch:(id)sender {
	[self playClickSound];
	[[[AppDelegate sharedAppDelegate] gamePlayer] setRemindLoans:[sender isOn]];
}
- (IBAction)reserveWarpSwitch:(id)sender {
	[self playClickSound];
	[[[AppDelegate sharedAppDelegate] gamePlayer] setReserveMoney:[sender isOn]];
}
- (IBAction)alwaysPoliceSwitch:(id)sender {
	[self playClickSound];
	[[[AppDelegate sharedAppDelegate] gamePlayer] setAlwaysIgnorePolice:[sender isOn]];
}
- (IBAction)alwaysPiratesSwitch:(id)sender {
	[self playClickSound];
	[[[AppDelegate sharedAppDelegate] gamePlayer] setAlwaysIgnorePirates:[sender isOn]];
}
- (IBAction)alwaysTradersSwitch:(id)sender {
	[self playClickSound];
	[[[AppDelegate sharedAppDelegate] gamePlayer] setAlwaysIgnoreTraders:[sender isOn]];
}
- (IBAction)ignoreDealersSwitch:(id)sender {
	[self playClickSound];
	[[[AppDelegate sharedAppDelegate] gamePlayer] setAlwaysIgnoreTradeInOrbit:[sender isOn]];
}
- (IBAction)continuousFleeingSwitch:(id)sender {
	[self playClickSound];
	[[[AppDelegate sharedAppDelegate] gamePlayer] setShouldAutoFlee:[sender isOn]];
}
- (IBAction)continuousFightingSwitch:(id)sender {
	[self playClickSound];
	[[[AppDelegate sharedAppDelegate] gamePlayer] setShouldAutoAttack:[sender isOn]];
}
- (IBAction)stopTrackingSwitch:(id)sender {
	[self playClickSound];
	[[[AppDelegate sharedAppDelegate] gamePlayer] setTrackAutoOff:[sender isOn]];
}
- (IBAction)rangeToTrackedSwitch:(id)sender {
	[self playClickSound];
	[[[AppDelegate sharedAppDelegate] gamePlayer] setShowTrackedRange:[sender isOn]];
}

-(void)readDefaults {
	
    defaults = [NSUserDefaults standardUserDefaults];
	_extraSoundsOn = [defaults boolForKey:@"soundEnabled"];

	if ([[[AppDelegate sharedAppDelegate] gamePlayer]autoFuel]) {
		[self.fullTankSwitch setOn: YES animated: NO];
	} else {
		[self.fullTankSwitch setOn: NO animated: NO];
	}
	if ([[[AppDelegate sharedAppDelegate] gamePlayer]autoRepair]) {
		[self.hullRepairSwitch setOn: YES animated: NO];
	} else {
		[self.hullRepairSwitch setOn: NO animated: NO];
	}
	if ([[[AppDelegate sharedAppDelegate] gamePlayer]newsAutoPay]) {
		[self.buyNewsSwitch setOn: YES animated: NO];
	} else {
		[self.buyNewsSwitch setOn: NO animated: NO];
	}
	if ([[[AppDelegate sharedAppDelegate] gamePlayer]remindLoans]) {
		[self.loanRemindersSwitch setOn: YES animated: NO];
	} else {
		[self.loanRemindersSwitch setOn: NO animated: NO];
	}
	
	if ([[[AppDelegate sharedAppDelegate] gamePlayer]reserveMoney]) {
		[self.reserveWarpSwitch setOn: YES animated: NO];
	} else {
		[self.reserveWarpSwitch setOn: NO animated: NO];
	}
	emptyCargoBaysSlider.value = (float)[[[AppDelegate sharedAppDelegate] gamePlayer]leaveEmpty];
	self.myEmpty.text = [NSString stringWithFormat:@"%i", (int)emptyCargoBaysSlider.value];
	
	if ([[[AppDelegate sharedAppDelegate] gamePlayer]alwaysIgnorePolice]) {
		[self.alwaysPoliceSwitch setOn: YES animated: NO];
	} else {
		[self.alwaysPoliceSwitch setOn: NO animated: NO];
	}
	if ([[[AppDelegate sharedAppDelegate] gamePlayer]alwaysIgnorePirates]) {
		[self.alwaysPiratesSwitch setOn: YES animated: NO];
	} else {
		[self.alwaysPiratesSwitch setOn: NO animated: NO];
	}
	if ([[[AppDelegate sharedAppDelegate] gamePlayer]alwaysIgnoreTraders]) {
		[self.alwaysTradersSwitch setOn: YES animated: NO];
	} else {
		[self.alwaysTradersSwitch setOn: NO animated: NO];
	}
	if ([[[AppDelegate sharedAppDelegate] gamePlayer]alwaysIgnoreTradeInOrbit]) {
		[self.ignoreDealersSwitch setOn: YES animated: NO];
	} else {
		[self.ignoreDealersSwitch setOn: NO animated: NO];
	}
	if ([[[AppDelegate sharedAppDelegate] gamePlayer]shouldAutoAttack]) {
		[self.continuousFightingSwitch setOn: YES animated: NO];
	} else {
		[self.continuousFightingSwitch setOn: NO animated: NO];
	}
	if ([[[AppDelegate sharedAppDelegate] gamePlayer]shouldAutoFlee]) {
		[self.continuousFleeingSwitch setOn: YES animated: NO];
	} else {
		[self.continuousFleeingSwitch setOn: NO animated: NO];
	}
	
	if ([[[AppDelegate sharedAppDelegate] gamePlayer]trackAutoOff]) {
		[self.stopTrackingSwitch setOn: YES animated: NO];
	} else {
		[self.stopTrackingSwitch setOn: NO animated: NO];
	}
	if ([[[AppDelegate sharedAppDelegate] gamePlayer]showTrackedRange]) {
		[self.rangeToTrackedSwitch setOn: YES animated: NO];
	} else {
		[self.rangeToTrackedSwitch setOn: NO animated: NO];
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

- (void)showmeachware {
	HelpViewController *targetViewController = [[HelpViewController alloc] initWithNibName:@"Help" bundle:nil];
	targetViewController.location = [NSURL URLWithString:@"http://www.darknova.net/"];
	[self presentModalViewController:targetViewController animated:YES];
	targetViewController.theTitle.text = @"Dead Jim Studios";
	[targetViewController release];
	
}


#pragma mark Table Selection 
- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
	int section = [indexPath section];
	int row = [indexPath row];
	
	switch (section) {
		case 1:
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


- (NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section {
    
	switch (section) {
		case 0:
			return @"Arrival Automation";
		case 1:
			return @"Departure Settings";
		case 2:
			return @"Encounter Automation";
		case 3:
			return @"Tracking Settings";
		default:
			return nil;
	}	
	
	return @"Header";
}



- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
	return 5;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
	
	switch (section) {
		case 0:
			return 4;
		case 1:
			return 2;
		case 2:
			return 6;
		case 3:
			return 2;
		case 4:
			return 1;
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
					return cell4;
					break;
				case 1:
					return cell5;
					break;
				case 2:
					return cell6;
					break;
				case 3:
					return cell7;
					break;
			}
			break;
		case 1:
			switch (row) {					
				case 0:
					return cell8;
					break;
				case 1:
					return cell9;
					break;
			}
			break;					
		case 2:
			switch (row) {
				case 0:
					return cell10;
					break;
				case 1:
					return cell11;
					break;
				case 2:
					return cell12;
					break;
				case 3:
					return cell13;
					break;
				case 4:
					return cell14;
					break;
				case 5:
					return cell15;
					break;
			}
			break;
		case 3:
			switch (row) {
				case 0:
					return cell16;
					break;
				case 1:
					return cell17;
					break;
			}
			break;					
		case 4:
			switch (row) {
				case 0:
					return cell18;
					break;
			}
			break;					
		default:
			break;
	}
	return nil;
}

- (void)tableView:(UITableView *)aTableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
	
	switch ([indexPath section]) {
		case 4:
			[self showmeachware];
			break;
		default:
			break;
	}

	[aTableView deselectRowAtIndexPath:indexPath animated:NO];
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
