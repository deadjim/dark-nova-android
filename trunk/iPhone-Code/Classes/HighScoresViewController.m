// 
//  HighScoresViewController.m
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

#import "HighScoresViewController.h"
#import "AppDelegate.h"
#import "Player.h"

static NSString *kCellIdentifier = @"MyCell";


@implementation HighScoresViewController

@synthesize navBar, tableView;

-(IBAction)closeViewAction {
	[self dismissModalViewControllerAnimated:YES];
}

-(IBAction)clearScores {
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Clear HighScores" message:@"Do you want to clear high scores?" delegate:self cancelButtonTitle:@"No" otherButtonTitles:@"Yes", nil];
	[alert show];
	[alert release];
}

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex  {
	
	if (buttonIndex == 1) { 
		[[[AppDelegate sharedAppDelegate] gamePlayer] clearHighScores];
		[self closeViewAction];
	}    
 
}

-(void)viewDidDisappear:(BOOL)animated {
	[super viewDidDisappear:YES];
	
}

-(void)dealloc {
	[navBar release];
	[tableView release];
	
	[super dealloc];
}

- (void)awakeFromNib {	
	// construct the array of page descriptions we will use (each desc is a dictionary)
	menuList = [[NSMutableArray alloc] init];
	self.title =@"High Scores";
	
	[[[AppDelegate sharedAppDelegate] gamePlayer] fillHighScores:menuList];

}

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {
		self.awakeFromNib;
	}
	return self;
}

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}


#pragma mark UIViewController delegate methods

- (void)viewWillAppear:(BOOL)animated {
	// this UIViewController is about to re-appear, make sure we remove the current selection in our table view
	[[AppDelegate sharedAppDelegate]updateToolBar];
	
	NSIndexPath *tableSelection = [tableView indexPathForSelectedRow];
	[tableView deselectRowAtIndexPath:tableSelection animated:NO];
}


#pragma mark UITableView delegate methods
// tell our table how many sections or groups it will have (always 1 in our case)
- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
	return [menuList count] ? [menuList count] : 1;
}

// the table's selection has changed, switch to that item's UIViewController
- (void)tableView:(UITableView *)aTableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
	[aTableView deselectRowAtIndexPath:indexPath animated:NO];
}



#pragma mark UITableView datasource methods

// tell our table how many rows it will have, in our case the size of our menuList
- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
	return 1;
}

// tell our table what kind of cell to use and its title for the given row
- (UITableViewCell *)tableView:(UITableView *)tableView1 cellForRowAtIndexPath:(NSIndexPath *)indexPath {
	
	UITableViewCell *cell = [tableView1 dequeueReusableCellWithIdentifier:kCellIdentifier];
	if (cell == nil) {
		cell = [[[UITableViewCell alloc] initWithFrame:CGRectZero reuseIdentifier:kCellIdentifier] autorelease];
		cell.textLabel.font = [UIFont systemFontOfSize:10.0];
		cell.selectionStyle = UITableViewCellSelectionStyleNone;
	}
	
	if ([menuList count])
		cell.textLabel.text = [[menuList objectAtIndex:indexPath.section] objectForKey:@"line"];
	else
		cell.textLabel.text = @"Empty";
	
	cell.accessoryType = UITableViewCellAccessoryNone;
	return cell;
}

- (NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section {
	if ([menuList count])
		return [NSString stringWithFormat:@"%i. %@", section+1, [[menuList objectAtIndex:section] objectForKey:@"title"]];
	else
		return @"Empty";
}

- (NSString *)tableView:(UITableView *)tableView titleForFooterInSection:(NSInteger)section {
	if (section == ([menuList count]-1))
		return @"©2010 Dead Jim Studios";
	else
		return @"";
}

#pragma mark Set Modes
-(void)setToolbar {
	navBar.hidden = FALSE;
	tableView.frame = CGRectMake(0.0, 44.0, 320.0, 416.0);
}

@end
