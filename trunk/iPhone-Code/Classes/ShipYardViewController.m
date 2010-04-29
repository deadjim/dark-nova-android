//
//  ShipYardViewController.m
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

#import "ShipYardViewController.h"
#import "BuyShipViewController.h"
#import "AppDelegate.h"
#import "ShipInfoViewController.h"


@implementation ShipYardViewController


- (void)awakeFromNib {
	self.title = @"Ship Yard";	
}

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {
		self.title = @"Ship Yard";				
	}
	return self;
}

-(IBAction) buyNewShipAction {
	BuyShipViewController *buyShipViewController = [[BuyShipViewController alloc] initWithNibName:@"BuyShip" bundle:nil];
	[self presentModalViewController:buyShipViewController animated:YES];
	[buyShipViewController release];
}

-(IBAction) showShipInfoAction {
	ShipInfoViewController *vc = [[ShipInfoViewController alloc] initWithNibName:@"ShipInfo" bundle:nil];
	[vc setShip:[[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentShipType]];
	[self presentModalViewController:vc animated:YES];
	[vc release];
	
}

- (void)viewDidAppear:(BOOL)animated  {
	[super viewDidAppear:YES];
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