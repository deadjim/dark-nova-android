//
//  WarpViewController.m
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

#import "WarpViewController.h"
#import "AppDelegate.h"
#import "Player.h"
#import "GalacticChartViewController.h"


@implementation WarpViewController

@synthesize pricesViewInst, sysInfoViewInst;

-(void)dealloc {
	[pricesViewInst release];
	[sysInfoViewInst release];
	
	[super dealloc];
}

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {
		self.title = [[[AppDelegate sharedAppDelegate]gamePlayer] getWarpSystemName];
		
	}
	return self;
}

// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
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

-(void) updateTitle {
	self.title = [[[AppDelegate sharedAppDelegate]gamePlayer] getWarpSystemName];
}

-(IBAction) showSystemInformation {
	[self updateTitle];
	[sysInfoViewInst updateTheView];
	self.view = sysInfoViewInst;
}

-(IBAction) showPricesInformation {
	[self updateTitle];
	[pricesViewInst updateTheView];	
	self.view = pricesViewInst;
}


-(IBAction) showShortRangeChart {
	[[[AppDelegate sharedAppDelegate]navigationController]popViewControllerAnimated:YES];
}

-(IBAction) doWarp {
	[[[AppDelegate sharedAppDelegate]gamePlayer]doWarp:FALSE];
}


-(IBAction) nextPlanet {
	[[[AppDelegate sharedAppDelegate]gamePlayer] setWarpSystem: [[[AppDelegate sharedAppDelegate]gamePlayer] nextSystemWithinRange:[[[AppDelegate sharedAppDelegate]gamePlayer]warpSystem] Back:FALSE]];
	[self updateTitle];
	if (self.view == sysInfoViewInst)
		[sysInfoViewInst updateTheView];
	[pricesViewInst updateTheView];
}

-(IBAction) prevPlanet {
	[[[AppDelegate sharedAppDelegate]gamePlayer] setWarpSystem: [[[AppDelegate sharedAppDelegate]gamePlayer] nextSystemWithinRange:[[[AppDelegate sharedAppDelegate]gamePlayer]warpSystem] Back:TRUE]];
	[self updateTitle];
	if (self.view == sysInfoViewInst)
		[sysInfoViewInst updateTheView];
	[pricesViewInst updateTheView];	
}

-(IBAction) galacticChart {
	GalacticChartViewController *galacticChartViewController = [[GalacticChartViewController alloc] initWithNibName:@"GalacticChart" bundle:nil];
	[self.navigationController presentModalViewController:galacticChartViewController animated:YES];
	[galacticChartViewController release];
}

@end
