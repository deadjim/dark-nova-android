//
//  PersonnelRosterViewController.m
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

#import "PersonnelRosterViewController.h"
#import "AppDelegate.h"
#import "Player.h"


@implementation PersonnelRosterViewController

@synthesize fire0, fire1, fire2, Price0, Price1, Price2, Trader0, Trader1, Trader2;
@synthesize Fighter0, Fighter1, Fighter2, Engineer0, Engineer1, Engineer2;
@synthesize Pilot0, Pilot1, Pilot2, Vacancy0, Vacancy1, Vacancy2, PilotName0, PilotName1, PilotName2;


-(void)dealloc {
	
	[fire0 release];
	[fire1 release];
	[fire2 release];
	[Price0 release];
	[Price1 release];
	[Price2 release];
	[Trader0 release];
	[Trader1 release];
	[Trader2 release];
	
	[Fighter0 release];
	[Fighter1 release];
	[Fighter2 release];
	[Engineer0 release];
	[Engineer1 release];
	[Engineer2 release];
	[Pilot0 release];
	[Pilot1 release];
	[Pilot2 release];
	
	[Vacancy0 release];
	[Vacancy1 release];
	[Vacancy2 release];
	[PilotName0 release];
	[PilotName1 release];
	[PilotName2 release];
	[cash release];
	
	[super dealloc];
}


-(IBAction)closeViewAction {
	[self dismissModalViewControllerAnimated:YES];
	[[AppDelegate sharedAppDelegate]setGameMode];
}

-(void)viewDidDisappear:(BOOL)animated {
	[super viewDidDisappear:YES];
}


- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {
		self.title = @"Personnel Roster";		
	}
	return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    UIBarButtonItem *backBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@"Back" style:UIBarButtonItemStyleBordered target:nil action:nil];
    self.navigationItem.backBarButtonItem = backBarButtonItem;
    [backBarButtonItem release];
}
- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}


-(void) UpdateView {
	
	cash.text = [NSString stringWithFormat:@"Cash: %i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer]credits]];
	
	fire0.hidden = TRUE;
	fire1.hidden = TRUE;
	fire2.hidden = TRUE;
	Price0.hidden = TRUE;
	Price1.hidden = TRUE;
	Price2.hidden = TRUE;
	Trader0.hidden = TRUE;
	Trader1.hidden = TRUE;
	Trader2.hidden = TRUE;
	Fighter0.hidden = TRUE;
	Fighter1.hidden = TRUE;
	Fighter2.hidden = TRUE;
	Engineer0.hidden = TRUE;
	Engineer1.hidden = TRUE;
	Engineer2.hidden = TRUE;
	Pilot0.hidden = TRUE;
	Pilot1.hidden = TRUE;
	Pilot2.hidden = TRUE;
	Vacancy0.hidden = TRUE;
	Vacancy1.hidden = TRUE;
	Vacancy2.hidden = TRUE;
	PilotName0.hidden = TRUE;
	PilotName1.hidden = TRUE;
	PilotName2.hidden = TRUE;
	
	[[[AppDelegate sharedAppDelegate]gamePlayer] updateRosterWindow:self];
}

- (void)loadView
{
	[super loadView];
	[self UpdateView];
}

- (void)viewDidAppear:(BOOL)animated {
	
	[super viewDidAppear:animated];
	[self UpdateView];
}

-(IBAction) pressFire0 {
	[[[AppDelegate sharedAppDelegate]gamePlayer] fireMercenary:1];
	[self UpdateView];
	
}

-(IBAction) pressFire1 {
	[[[AppDelegate sharedAppDelegate]gamePlayer] fireMercenary:2];
	[self UpdateView];
	
}

-(IBAction) pressFire2 {
	[[[AppDelegate sharedAppDelegate]gamePlayer] hireMercenaryFromRoster];
	[self UpdateView];
}


@end
