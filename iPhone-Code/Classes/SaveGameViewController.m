//
//  SaveGameViewController.m
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

#import "SaveGameViewController.h"
#import "AppDelegate.h"
#import "Player.h"
#import "SaveGameCell.h"
#import "SoundManager.h"


@implementation SaveGameViewController

@synthesize myTableView;
@synthesize addNewButton, doneButton, saveBar,loadBar;


-(void) dealloc {
	[menuList dealloc];
	[menuListAdditional dealloc];
	[menuName dealloc];
	[addNewButton release];
	[doneButton release];
	[saveBar release];
	[loadBar release];
	
	[myTableView release];
	
	[super dealloc];
}


-(IBAction)closeViewAction {
	[self dismissModalViewControllerAnimated:YES];
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
		loadBar.hidden = TRUE;
		saveBar.hidden = TRUE;
		myTableView.frame = CGRectMake(0.0, 0.0, 320.0, 416.0);
	}

	self.title = NSLocalizedString(@"Load Saved Game", @"");
	
	menuList = [[NSMutableArray alloc] init];
	menuListAdditional = [[NSMutableArray alloc] init];
	menuName = [[NSMutableArray alloc] init];	
	
	loadMode = TRUE;

}

-(void) updateTable {
	[menuName removeAllObjects];	
	[menuList removeAllObjects];
	[menuListAdditional removeAllObjects];
	[[[AppDelegate sharedAppDelegate] gamePlayer] showSavedGames:menuList name:menuName additional:menuListAdditional];

	[self.myTableView reloadData];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
	self.myTableView.rowHeight = 60;

	[self updateTable];
}


- (void)showSavedNotice {
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Game Saved" message:nil delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
	[alert show];
	[alert release];
	if (![[[AppDelegate sharedAppDelegate]gamePlayer]isSpeechEnabled]) {
		[[SoundManager sharedSound] playSoundWithId:kPling];
	}
	[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"GameSaved.caf"];
	didLoadOrSave = TRUE;

}

- (void)showLoadNotice {
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Game Loaded" message:nil delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
	[alert show];
	[alert release];
	if (![[[AppDelegate sharedAppDelegate]gamePlayer]isSpeechEnabled]) {
		[[SoundManager sharedSound] playSoundWithId:kPling];
	}
	[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"GameLoaded.caf"];
	didLoadOrSave = TRUE;

}

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}

- (void)noDeleteAutoSave {
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Notice" message:@"You cannot delete the AutoSave game file." delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles: nil];
	[alert show];
	[alert release];
	
}

- (void)reallyDelete {
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Please Confirm" 
													message:@"You cannot recover a deleted game. Are you sure you want to delete this saved game?" 
												   delegate:self cancelButtonTitle:@"No" otherButtonTitles:@"Yes", nil];
	[alert show];
	[alert release];

}

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex  {

	if (didLoadOrSave) {
		[self dismissModalViewControllerAnimated:YES];
	}
	else 
		[self editButton];

	if (buttonIndex == 1) {
		[[[AppDelegate sharedAppDelegate]gamePlayer]eraseSaveFile:[NSString stringWithFormat:@"%i", activeSaveNumber]];
		[[[AppDelegate sharedAppDelegate]gamePlayer] updateFileNames];
		[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"FileDeleted.caf"];
		[self updateTable];
	}
	
}


#pragma mark Editing
- (void)setEditing:(BOOL)editing animated:(BOOL)animated {

		[super setEditing:editing animated:animated];
		[myTableView beginUpdates];
		[myTableView setEditing:editing animated:YES];
		[myTableView endUpdates];

}



- (void)tableView:(UITableView *)aTableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle 
forRowAtIndexPath:(NSIndexPath *)indexPath {

	if([[AppDelegate sharedAppDelegate]fromOptions]) {
		if (editingStyle == UITableViewCellEditingStyleDelete) {
			activeSaveNumber = (indexPath.row + 1);
			if ([[menuName objectAtIndex:indexPath.row] hasSuffix:@"(AutoSave)"])
				[self noDeleteAutoSave];
			else 
				[self reallyDelete];
		}
	}
}


-(IBAction)editButton {
	if (!isEditing) {
		[self setEditing:TRUE animated:YES];
		doneButton.title  = @"Done";
	}
	else {
		[self setEditing:FALSE animated:YES];
		doneButton.title = @"Edit";
	}

	isEditing = !isEditing;
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
	if ([[menuName objectAtIndex:indexPath.row] isEqualToString:[[[AppDelegate sharedAppDelegate]gamePlayer]newestSavedGame]]) {
		cell.nameLabel.textColor = [UIColor blueColor];
	}
	else 
		cell.nameLabel.textColor = [UIColor blackColor];

	cell.infoLabel.text = [menuListAdditional objectAtIndex:indexPath.row];	
    return cell;
}

- (NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section {

	if (section == 0) {
		if ([menuList count])
			return @"Saved Games";
		else 
			return @"No Saved Games";
	}
	return @"";
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {

	[myTableView deselectRowAtIndexPath:indexPath animated:YES];
	
	activeSaveNumber = indexPath.row;
	if (loadMode) {
		if(![[AppDelegate sharedAppDelegate]fromOptions]) {
			[self.view removeFromSuperview];
		}
		[[[AppDelegate sharedAppDelegate] gamePlayer] loadTheGame:[menuList objectAtIndex:indexPath.row]];
		[self showLoadNotice];
	}
	else {
		[[[AppDelegate sharedAppDelegate] gamePlayer] saveTheGame:[menuList objectAtIndex:indexPath.row]];
		[self showSavedNotice];
	}
}


- (NSString *)tableView:(UITableView *)tableView titleForFooterInSection:(NSInteger)section {
	if (section == 0)
		if ([menuList count])
			return @"(the most recent game is in blue)\n©2010 Dead Jim Studios";
		else 
			return @"";
	else
		return @"";
}


#pragma mark Set Modes
-(void)setRetireMode {
	[self setEditing:FALSE animated:NO];
}

-(void)setSaveGameMode {
	self.title =@"Save Game";
	loadMode = FALSE;
	saveBar.hidden = FALSE;
	loadBar.hidden = TRUE;	
	[self updateTable];
}

-(void)setLoadGameMode {
	loadMode = TRUE;
	self.title =@"Load Game";
	[self setEditing:FALSE animated:YES];
	saveBar.hidden = TRUE;
	loadBar.hidden = FALSE;
}

- (IBAction)action:(id)sender {
	activeSaveNumber = [self.myTableView numberOfRowsInSection:0];
	NSString *newName = [NSString stringWithFormat:@"%i", activeSaveNumber];
	[[[AppDelegate sharedAppDelegate] gamePlayer] saveTheGame:newName];
	[self updateTable];
	[self showSavedNotice];
}

@end
