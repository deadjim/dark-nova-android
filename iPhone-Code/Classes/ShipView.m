//
//  ShipView.m
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

#import "ShipView.h"
#import "AppDelegate.h"
#import "Player.h"

@implementation ShipView

@synthesize shipImage, shipName, label, shipHull, shipSize, shipRange;


-(void)dealloc {

	[label release];
	[shipName release];
	[shipImage release];
	[shipHull release];
	[shipSize release];
	[shipRange release];
	
	[super dealloc];
}

-(void)update  {
	
	self.label.text = [[[AppDelegate sharedAppDelegate]gamePlayer] drawCurrentShipForm];	
	self.shipImage.image = [UIImage imageNamed:[[[AppDelegate sharedAppDelegate]gamePlayer] getShipImageName:[[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentShipType]]];
	self.shipName.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipName:[[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentShipType]];
	self.shipSize.text = [NSString stringWithFormat:@"Size : [%@]",[[[AppDelegate sharedAppDelegate]gamePlayer] getShipSize:[[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentShipType]]];
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]canUpgradeHull])
		self.shipHull.text = [NSString stringWithFormat:@"Hull Strength : [%i]", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipHull]];
	else 
		self.shipHull.text = [NSString stringWithFormat:@"Pirate Hull : [%i]", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipHull]];
	self.shipRange.text = [NSString stringWithFormat:@"Range : [%i] parsec%@", [[[AppDelegate sharedAppDelegate]gamePlayer] getFuel],[[[AppDelegate sharedAppDelegate]gamePlayer] getFuel] > 1 ? @"s" : @"" ];	

}

- (void)viewDidAppear:(BOOL)animated  {
	[self update];
}

- (void)didMoveToWindow {
	[super didMoveToWindow];
	[self update];
}

@end
