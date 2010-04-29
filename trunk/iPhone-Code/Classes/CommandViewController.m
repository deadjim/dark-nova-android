// 
//  CommandViewController.m
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

#import "CommandViewController.h"
#import "AppDelegate.h"

#import "SaveGameViewController.h"
#import "BuyCargoViewController.h"
#import "CommanderTabBarStatus.h"
#import "BankViewController.h"
#import "SellEquipmentViewController.h"
#import "BuyEquipmentViewController.h"
#import "PersonnelRosterViewController.h"
#import "GalacticChartViewController.h"
#import "GameOptionsViewController.h"


@implementation CommandViewController

@synthesize lowMemoryNotice, commanderLabel;
@synthesize saveGameButton, loadGameButton, gameOptionsButton, buyCargoButton, commanderStatusButton;
@synthesize buyEquipmentButton, sellEquipmentButton, personnelRosterButton, bankButton, galacticChartButton;


-(void)dealloc {
	[lowMemoryNotice release];
	[commanderLabel release];
	
	[saveGameButton release];
	[loadGameButton release];
	[gameOptionsButton release];
	[buyCargoButton release];
	[commanderStatusButton release];
	[buyEquipmentButton release];
	[sellEquipmentButton release];
	[personnelRosterButton release];
	[bankButton release];
	[galacticChartButton release];
	
	[super dealloc];
}

-(id)initGlobals {
    return self;
	
}

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {
		self.title = @"Commanders PAD";
	}
	return [self initGlobals];
}


- (void) updateCommanderText {
	self.commanderLabel.text = [NSString stringWithFormat:@"Commander: %@", [[[AppDelegate sharedAppDelegate]gamePlayer]pilotName]];	
}

// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad {
    [super viewDidLoad];
	[[AppDelegate sharedAppDelegate]updateToolBar];
	[self updateCommanderText];
	
    UIBarButtonItem *backBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@"Back" style:UIBarButtonItemStyleBordered target:nil action:nil];
    self.navigationItem.backBarButtonItem = backBarButtonItem;
    [backBarButtonItem release];
}

- (void)didReceiveMemoryWarning {
	
	NSLog(@"CommandView Memory Warning");
	++memWarnCount;
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
	
}

-(void) reloadToolBarAction {
	[[AppDelegate sharedAppDelegate] loadMainToolBar];
}

-(void) reloadToolBarNotice {
	
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Low Memory Notice" 
													message:@"We received a low memory notice. Tap 'Reload' below to display the toolbar. If we receive another memory warning, the next notice\nwill offer to save and automatically\nrelaunch your game." 
												   delegate:self cancelButtonTitle:@"Reload" otherButtonTitles:nil];
	[alert show];
	[alert release];
}

-(void) saveAndRestartAction {
	[[[AppDelegate sharedAppDelegate] gamePlayer] saveTheGame:@"MemorySave"];

	[[NSUserDefaults standardUserDefaults] setBool:TRUE forKey:@"loadFromMemory"];
	[[NSUserDefaults standardUserDefaults] synchronize];
	[[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"http://darknova.net/auto/HyperWARP.html"]];
}

-(void) saveAndRestartNotice {
	
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Low Memory Notice" 
													message:@"Your device is low on memory, tap 'Relaunch Now' below to automatically save your game, exit and then relaunch the game." 
												   delegate:self cancelButtonTitle:@"Relaunch Now" otherButtonTitles:nil];
	[alert show];
	[alert release];
}

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex  {

	if(isLitePopup) {
		if (buttonIndex == 1)
			[[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"http://darknova.net/hyperwarp.html"]];
	}
	else {
		if (buttonIndex == 0) {
			if(memWarnCount > 1)
				[self saveAndRestartAction];
			else
				[self reloadToolBarAction];
		}		
	}
}

-(IBAction) lowMemoryButtonPressed {
	[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"AlertLowMemory.caf"];
	isLitePopup = FALSE;
		
	if(memWarnCount > 1)
		[self saveAndRestartNotice];
	else
		[self reloadToolBarNotice];	
}

-(IBAction) purchase {
	isLitePopup = TRUE;
	UIAlertView *myAlertView = [[UIAlertView alloc] initWithTitle:@"Full Version"  message:@"Thank you for your interest in the the full version of Hyper WARP. Would you like to purchase the full version now?" delegate:self cancelButtonTitle:@"No" otherButtonTitles:@"Yes",nil];	
	[myAlertView show];
	[myAlertView release];	
}

#pragma mark Modal Views
-(IBAction) saveGame {
	[[AppDelegate sharedAppDelegate]setFromOptions:TRUE];
	SaveGameViewController *saveGameViewController = [[SaveGameViewController alloc] initWithNibName:@"SaveGames" bundle:nil];
	[self.navigationController presentModalViewController:saveGameViewController animated:YES];
	[saveGameViewController setSaveGameMode];		
	[saveGameViewController release];
}

-(IBAction) loadGame {
	SaveGameViewController *saveGameViewController = [[SaveGameViewController alloc] initWithNibName:@"SaveGames" bundle:nil];
	[[AppDelegate sharedAppDelegate]setFromOptions:TRUE];
	[self.navigationController presentModalViewController:saveGameViewController animated:YES];
	[saveGameViewController setLoadGameMode];		
	[saveGameViewController release];
}

-(IBAction) gameOptions {
	[[AppDelegate sharedAppDelegate]setFromOptions:TRUE];
	GameOptionsViewController *gameViewController = [[GameOptionsViewController alloc] initWithNibName:@"GameOptions" bundle:nil];		
	[self.navigationController presentModalViewController:gameViewController animated:YES];
	[gameViewController release];
}

-(IBAction) buyCargo {
	BuyCargoViewController *buyCargoViewController = [[BuyCargoViewController alloc] initWithNibName:@"BuyCargo" bundle:nil];		
	[self.navigationController presentModalViewController:buyCargoViewController animated:YES];
	[buyCargoViewController release];
}

-(IBAction) buyEquipment {
	BuyEquipmentViewController *buyEquipmentViewController = [[BuyEquipmentViewController alloc] initWithNibName:@"BuyEquipment" bundle:nil];
	[self.navigationController presentModalViewController:buyEquipmentViewController animated:YES];
	[buyEquipmentViewController release];
}

-(IBAction) sellEquipment {
	SellEquipmentViewController *sellEquipmentViewController = [[SellEquipmentViewController alloc] initWithNibName:@"SellEquipment" bundle:nil];
	[self.navigationController presentModalViewController:sellEquipmentViewController animated:YES];
	[sellEquipmentViewController release];
}

-(IBAction) personnelRoster {
	PersonnelRosterViewController *personnelRosterViewController = [[PersonnelRosterViewController alloc] initWithNibName:@"PersonnelRoster" bundle:nil];
	[self.navigationController presentModalViewController:personnelRosterViewController animated:YES];
	[personnelRosterViewController release];
}

-(IBAction) bank {
	BankViewController *bankViewController = [[BankViewController alloc] initWithNibName:@"Bank" bundle:nil];
	[self.navigationController presentModalViewController:bankViewController animated:YES];
	[bankViewController updateView];
	[bankViewController release];
}

-(IBAction) commanderStatus {
	CommanderTabBarStatus *commanderTabBarStatus = [[CommanderTabBarStatus alloc] initWithNibName:@"CommanderTabBarStatus" bundle:nil];
	[self.navigationController presentModalViewController:commanderTabBarStatus animated:YES];
	[commanderTabBarStatus release];
	
}

-(IBAction) galacticChart {
	GalacticChartViewController *galacticChartViewController = [[GalacticChartViewController alloc] initWithNibName:@"GalacticChart" bundle:nil];
	[self.navigationController presentModalViewController:galacticChartViewController animated:YES];
	[galacticChartViewController release];
}

#pragma mark Retained Views
-(IBAction) shipYard {
	if(!shipYardViewControllerImpl) {
		shipYardViewControllerImpl = [[[ShipYardViewController alloc] initWithNibName:@"ShipYard" bundle:nil] retain];
	}
	[self.navigationController pushViewController:shipYardViewControllerImpl animated:YES];
}

-(IBAction) sellCargo {
	if(!sellCargoViewControllerImpl) {
		sellCargoViewControllerImpl = [[[SellCargoViewController alloc] initWithNibName:@"SellCargo" bundle:nil] retain];
	}	
	[self.navigationController pushViewController:sellCargoViewControllerImpl animated:YES];
}

-(IBAction) systemInformation {
	if (!systemInfoViewControllerImpl) {
		systemInfoViewControllerImpl = [[[SystemInfoViewController alloc] initWithNibName:@"SystemInfo" bundle:nil] retain];
	}
	[self.navigationController pushViewController:systemInfoViewControllerImpl animated:YES];
}

-(IBAction) shortRangeChart {
	if (!shortRangeChartViewControllerImpl) {
		shortRangeChartViewControllerImpl = [[[ShortRangeChartViewController alloc] initWithNibName:@"ShortRangeChart" bundle:nil] retain];
	}
	[self.navigationController pushViewController:shortRangeChartViewControllerImpl animated:YES];
}

@end
