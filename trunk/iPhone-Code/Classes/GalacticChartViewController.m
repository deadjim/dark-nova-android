// 
//  GalacticChartViewController.m
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

#import "GalacticChartViewController.h"
#import "AppDelegate.h"
#import "ViewerViewController.h"


@implementation GalacticChartViewController

@synthesize cheatSystems, cheatQuests;


-(void)dealloc {
		
	[super dealloc];
	
}

-(IBAction)closeViewAction {
	[self dismissModalViewControllerAnimated:YES];
}

-(void)performHyperWarp {
	[[[AppDelegate sharedAppDelegate]gamePlayer]setWarpSystem:[[[AppDelegate sharedAppDelegate]gamePlayer]currentGalaxySystem]];
	[[[AppDelegate sharedAppDelegate]gamePlayer] doWarp:TRUE];
	[[[AppDelegate sharedAppDelegate]gamePlayer]setCanSuperWarp:FALSE];	
}
-(IBAction)jump {
	[self closeViewAction];
	[self performSelector:@selector(performHyperWarp) withObject:self afterDelay:0.7];
}

-(void)viewDidDisappear:(BOOL)animated {
	[super viewDidDisappear:YES];
}


- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {
		self.title = @"Galactic Chart";
	}
	return self;
}

-(void)cheatViewer:(NSString *)cheat {
	ViewerViewController *vc = [[ViewerViewController alloc] initWithNibName:@"Viewer" bundle:nil];
	[self presentModalViewController:vc animated:YES];
	[vc setTheText:cheat];
	[vc release];
	NSLog(@"cheatViewer called");
}

-(IBAction)showAllSystemsCheat {
	[self cheatViewer:[[[AppDelegate sharedAppDelegate]gamePlayer]allSystems]];
	self.cheatSystems.hidden = TRUE;
}
-(IBAction)showAllQuestCheat {
	[self cheatViewer:[[[AppDelegate sharedAppDelegate]gamePlayer]allSpecialEvents]];
	self.cheatQuests.hidden = TRUE;
}

// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad {
    [super viewDidLoad];
}

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}


@end
