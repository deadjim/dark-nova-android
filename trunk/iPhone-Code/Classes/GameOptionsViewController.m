// 
//  GameOptionsViewController.m
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

#import "GameOptionsViewController.h"
#import "SoundManager.h"
#import "CommandViewController.h"

#import "AppSettingsViewController.h"
#import "AppDelegate.h"
#import "Player.h"
#import "SettingsViewController.h"
#import "HelpViewController.h"
#import "HighScoresViewController.h"
#import "CreditsViewController.h"


@implementation GameOptionsViewController

@synthesize delegate;

@synthesize tableList, myTableView, deviceType;
@synthesize cell0, cell1, cell4, cell5, cell6, cell7, cell2, cell3;


- (void)dealloc {
	// lots to add here!
	[cell0 release];
	[cell1 release];
	[cell2 release];
	[cell3 release];
	[cell4 release];
	[cell5 release];
	[cell6 release];
	[cell7 release];

	[tableList release];
	[deviceType release];
	
	[myTableView release];
	[super dealloc];
	
}

// The designated initializer.  Override if you create the controller programmatically and want to perform customization that is not appropriate for viewDidLoad.
- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
    if (self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil]) {

    }
    return self;
}


- (IBAction)done {
	[self dismissModalViewControllerAnimated:YES];
	[[AppDelegate sharedAppDelegate]setGameMode];
	
}

-(IBAction)closeViewAction {
	[self dismissModalViewControllerAnimated:YES];
	[[AppDelegate sharedAppDelegate]setGameMode];
}

- (void)showLoadNotice {
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Game File Loaded" message:nil delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
	[alert show];
	[alert release];
	[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"GameFileLoaded.caf"];

}


-(void)viewDidDisappear:(BOOL)animated {
	[super viewDidDisappear:YES];
	[[AppDelegate sharedAppDelegate]updateToolBar];
	[[[AppDelegate sharedAppDelegate]commandView]updateCommanderText];
}


- (void)viewDidLoad {
	
	self.title = @"Settings";	
    [super viewDidLoad];

	UIBarButtonItem *backBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@"Close" style:UIBarButtonItemStyleBordered target:self action:@selector(done)];
    self.navigationItem.backBarButtonItem = backBarButtonItem;
    [backBarButtonItem release];
	
	retireAlert=[[[UIAlertView alloc] initWithTitle:@"Retire" message:@"The AutoSave game will be deleted. Do you really want to retire?" delegate:self cancelButtonTitle:@"No" otherButtonTitles:@"Yes", nil] retain];
		
}


- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex  {
	
	if(alertView == retireAlert) {
		if (buttonIndex == 1) {
			[self dismissModalViewControllerAnimated:YES];
			[[[AppDelegate sharedAppDelegate] gamePlayer] showRetiredForm];
		}
	} 
}

#pragma mark Table Selection 
- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath {

	return 44.0f;
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
	return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
	return 8;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
	
	NSInteger row = [indexPath row];
	NSInteger section = [indexPath section];
	
	switch (section) {
		case 0:
			switch (row) {
				case 0:
					return cell0;
					break;
				case 1:
					return cell1;
					break;
				case 2:
					return cell6;
					break;
				case 3:
					return cell4;
					break;
				case 4:
					return cell3;
					break;
				case 5:
					return cell5;
					break;
				case 6:
					return cell2;
					break;
				case 7:
					return cell7;
					break;
			}
			break;
	}
	return nil;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
	
	[myTableView deselectRowAtIndexPath:[myTableView indexPathForSelectedRow] animated:YES];

	switch(indexPath.row) {
		case 0: 
		{
			AppSettingsViewController *targetViewController = [[AppSettingsViewController alloc] initWithNibName:@"AppSettingsView" bundle:nil];
			[self presentModalViewController:targetViewController animated:YES];
			[targetViewController release];
		}	
			break;
		case 1: 
		{
			SettingsViewController *targetViewController = [[SettingsViewController alloc] initWithNibName:@"SettingsView" bundle:nil];
			[self presentModalViewController:targetViewController animated:YES];
			[targetViewController release];
		}	
			break;
		case 2:
		{	
			HighScoresViewController *targetViewController = [[HighScoresViewController alloc] initWithNibName:@"HighScores" bundle:nil];
			[self presentModalViewController:targetViewController animated:YES];
			[targetViewController setToolbar];
			[targetViewController release];
		}
			break;
		case 3:
		{
			[retireAlert show];	
		}
			break;
		case 4: 
		{
			HelpViewController *targetViewController = [[HelpViewController alloc] initWithNibName:@"Help" bundle:nil];
			NSString *filePath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:@"HTML/QuickStart.html"];
			targetViewController.location = [NSURL fileURLWithPath:filePath];
			[self presentModalViewController:targetViewController animated:YES];
			targetViewController.theTitle.text = @"Quick Start";
			[targetViewController release];
		}
			break;
		case 5: 
		{
			HelpViewController *targetViewController = [[HelpViewController alloc] initWithNibName:@"Help" bundle:nil];
			NSString *filePath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:@"HTML/Guide.html"];
			targetViewController.location = [NSURL fileURLWithPath:filePath];
			[self presentModalViewController:targetViewController animated:YES];
			targetViewController.theTitle.text = @"Users Guide";
			[targetViewController release];
		}
			break;
		case 6: 
		{
			HelpViewController *targetViewController = [[HelpViewController alloc] initWithNibName:@"Help" bundle:nil];
			NSString *filePath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:@"HTML/Tips.html"];
			targetViewController.location = [NSURL fileURLWithPath:filePath];
			[self presentModalViewController:targetViewController animated:YES];
			targetViewController.theTitle.text = @"Tips & FAQ";
			[targetViewController release];
		}
			break;
		case 7: 
		{
			CreditsViewController *targetViewController = [[CreditsViewController alloc] initWithNibName:@"Credits" bundle:nil];
			NSString *filePath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:@"HTML/Credits.html"];
			targetViewController.location = [NSURL fileURLWithPath:filePath];
			targetViewController.title = @"Credits";			
			[self presentModalViewController:targetViewController animated:YES];
			[targetViewController release];
		}
			break;
	}
}


- (NSString *)tableView:(UITableView *)tableView titleForFooterInSection:(NSInteger)section {
	if (section == 0)
		return @"©2010 Dead Jim Studios";
	else
		return @"";
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
