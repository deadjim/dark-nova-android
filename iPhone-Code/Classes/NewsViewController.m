// 
//  NewsViewController.m
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

#import "NewsViewController.h"
#import "AppDelegate.h"
#import "Player.h"
#import "LogViewController.h"

@implementation NewsViewController
@synthesize text, saveToLog;


-(void)dealloc {
	[text release];
	[saveToLog release];
	[super dealloc];
}

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {
		self.title = @"System News";				
	}
	
	return self;
}

- (void)viewDidAppear:(BOOL)animated {	
	[super viewDidAppear:animated];
	if([[[AppDelegate sharedAppDelegate]gamePlayer] alreadyLoggedNews])
		saveToLog.hidden = TRUE;
	else {
		saveToLog.hidden = FALSE;
	}

}

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}

-(IBAction)showLogPressed {
	LogViewController *vc = [[LogViewController alloc] initWithNibName:@"Log" bundle:nil];
	[self presentModalViewController:vc animated:YES];
	[vc release];	
	[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"CommandersLog.caf"];
}

-(IBAction)saveToLogPressed {
	[[[AppDelegate sharedAppDelegate]gamePlayer] appendPilotLog:text.text];
	saveToLog.hidden = TRUE;
}


@end
