//
//  ShipInfoView.m
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

#import "ShipInfoView.h"
#import "AppDelegate.h"
#import "Player.h"


@implementation ShipInfoView

@synthesize ship, nameLabel, sizeLabel, cargoBaysLabel, rangeLabel, hullStrengthLabel;
@synthesize weaponSlotsLabel, shieldSlotsLabel, gadgetSlotsLabel, crewQuartersLabel, doneButton, shipImage;


-(void)dealloc {
	
	[nameLabel release];
	[sizeLabel release];
	[cargoBaysLabel release];
	[rangeLabel release];
	[hullStrengthLabel release];
	[weaponSlotsLabel release];
	[shieldSlotsLabel release];
	[gadgetSlotsLabel release];
	[crewQuartersLabel release];
	[doneButton release];
	[shipImage release];
		
	[super dealloc];
}


-(void)updateViewForShip:(int)shipIndex {

	nameLabel.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipName:shipIndex]; 
	sizeLabel.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipSize:shipIndex];
	cargoBaysLabel.text =  [NSString stringWithFormat:@"%i", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipCargoBays:shipIndex]];
	rangeLabel.text = [NSString stringWithFormat:@"%i parsecs", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipRange:shipIndex]];	
	hullStrengthLabel.text = [NSString stringWithFormat:@"%i", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipHullStrength:shipIndex]];	
	weaponSlotsLabel.text = [NSString stringWithFormat:@"%i", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipWeaponSlots:shipIndex]];
	shieldSlotsLabel.text = [NSString stringWithFormat:@"%i", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipShieldSlots:shipIndex]];
	gadgetSlotsLabel.text = [NSString stringWithFormat:@"%i", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipGadgetSlots:shipIndex]];
	crewQuartersLabel.text = [NSString stringWithFormat:@"%i", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipCrewQuarters:shipIndex]];			
	shipImage.image = [UIImage imageNamed:[[[AppDelegate sharedAppDelegate]gamePlayer] getShipImageNameBg:shipIndex]];

}

- (void)didMoveToWindow {
	[super didMoveToWindow];
	[self updateViewForShip:ship];
}

- (void)viewDidAppear:(BOOL)animated  {
	[self updateViewForShip:ship];
}

-(IBAction) done {
	///[self removeFromSuperview];
}

@end
