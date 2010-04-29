//
//  JumpStartViewController.m
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

#import "JumpStartViewController.h"
#import "AppDelegate.h"
#import "Player.h"
#import "SaveGameCell.h"
#import "SoundManager.h"
#import "AlertModalTextWindow.h"


@implementation JumpStartViewController

@synthesize myTableView;
@synthesize addNewButton, doneButton;


-(void) dealloc {
	[menuList dealloc];
	[menuListAdditional dealloc];
	[menuName dealloc];
	[addNewButton release];
	[doneButton release];
	
	[myTableView release];
	
	[super dealloc];
}


-(void)viewDidDisappear:(BOOL)animated {
	[super viewDidDisappear:YES];
	[[AppDelegate sharedAppDelegate]updateToolBar];
	[[[AppDelegate sharedAppDelegate]commandView]updateCommanderText];
}

- (void)viewDidLoad {
    [super viewDidLoad];
	didLoadOrSave = FALSE;
	
	if(![[AppDelegate sharedAppDelegate]fromOptions]) {
		myTableView.frame = CGRectMake(0.0, 0.0, 320.0, 416.0);
	}
	
	self.title = NSLocalizedString(@"Load Jump Start Game", @"");
	
	menuList = [[NSMutableArray alloc] init];
	menuListAdditional = [[NSMutableArray alloc] init];
	menuName = [[NSMutableArray alloc] init];
	loadMode = TRUE;
	
}

-(void) updateTable {
	[menuName removeAllObjects];	
	[menuList removeAllObjects];
	[menuListAdditional removeAllObjects];
	[[[AppDelegate sharedAppDelegate] gamePlayer] showJumpStartGames:menuList name:menuName additional:menuListAdditional];
	
	[self.myTableView reloadData];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
	self.myTableView.rowHeight = 60;
	
	[self updateTable];
}


- (void)showLoadNotice {	
	if (![[[AppDelegate sharedAppDelegate]gamePlayer]isSpeechEnabled]) {
		[[SoundManager sharedSound] playSoundWithId:kPling];
	}
	[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"GameLoaded.caf"];
	AlertModalTextWindow *myAlertView = [[AlertModalTextWindow alloc] initWithTitle:@"New Pilot" yoffset:70 message:@"Enter a new pilot name.\n\n"  
																		   delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Okay"  thirdButtonTitle:nil];
	
	[myAlertView show];
	[myAlertView release];
	
}

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}


- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex  {
	
	if (buttonIndex == 1) {
		NSString *value = [[(AlertModalTextWindow*)alertView myTextField] text];
		if ([value length] > 0) {
			[[[AppDelegate sharedAppDelegate]gamePlayer]setPilotName:value];
			[[[AppDelegate sharedAppDelegate]commandView]updateCommanderText];
		}
	}
	[[[AppDelegate sharedAppDelegate] gamePlayer] saveTheGame:@"AutoSave"];
	[self.view removeFromSuperview];
	
}


#pragma mark Table view methods
- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 2;
}


- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
	
	if (section == 0)
		return [menuList count];
	
	return 0;
	
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
	SaveGameCell *cell = (SaveGameCell*)[tableView dequeueReusableCellWithIdentifier:kDisplayCell_ID];
	if (cell == nil) {
		cell = [[[SaveGameCell alloc] initWithFrame:CGRectZero reuseIdentifier:kDisplayCell_ID] autorelease];
	}
	
	cell.accessoryType = UITableViewCellAccessoryNone;
	cell.nameLabel.text = [menuName objectAtIndex:indexPath.row];
	cell.nameLabel.textColor = [UIColor blackColor];
	cell.infoLabel.text = [menuListAdditional objectAtIndex:indexPath.row];
	
    return cell;
}

- (NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section {
	
	if (section == 0) {
		if ([menuList count])
			return @"Available Jump Start Games";
		else 
			return @"No Saved Games";
	}
	return @"";
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
	
	[myTableView deselectRowAtIndexPath:indexPath animated:YES];
	[[[AppDelegate sharedAppDelegate] gamePlayer] loadJumpGame:[menuList objectAtIndex:indexPath.row]];
	[self showLoadNotice];
	
}


- (NSString *)tableView:(UITableView *)tableView titleForFooterInSection:(NSInteger)section {
	if (section == 0)
		if ([menuList count])
			return @"©2010 Dead Jim Studios";
		else 
			return @"";
		else
			return @"";
}


#pragma mark Set Modes
-(void)setRetireMode {
}

-(void)setSaveGameMode {
	self.title =@"Save Game";
	loadMode = FALSE;
	[self updateTable];
}

-(void)setLoadGameMode {
	loadMode = TRUE;
	self.title =@"Load Game";
	[self setEditing:FALSE animated:YES];
}

@end
