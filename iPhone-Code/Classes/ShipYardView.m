//
//  ShipYardView.m
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

#import "ShipYardView.h"
#import "AppDelegate.h"
#import "Player.h"
#import "AlertModalWindow.h"
#import "BuyShipViewController.h"


@implementation ShipYardView

@synthesize fuelAmount, fuelCost, hullStrength, needRepairs, newShipsInfo, escapePod;
@synthesize buyFuel, buyFullTank, buyRepair, buyFullRepair, totalCash;
@synthesize buyEscapePod, shipInfo, buyNewShip;

-(void)dealloc {
	
	[fuelAmount release];
	[fuelCost release];
	[hullStrength release];
	[needRepairs release];
	[newShipsInfo release];
	[escapePod release];
	[buyFuel release];
	[buyFullTank release];
	[buyRepair release];
	[buyFullRepair release];
	[totalCash release];
	[buyEscapePod release];
	[shipInfo release];
	[buyNewShip release];
	
	[super dealloc];
}

-(void) UpdateView {

	[[AppDelegate sharedAppDelegate]updateToolBar];
	podPrice = ([[[AppDelegate sharedAppDelegate]gamePlayer]gameDifficulty]+1)*600;
	
	totalCash.text = [NSString stringWithFormat:@"Cash: %i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer]credits]];	
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] getFuel] < [[[AppDelegate sharedAppDelegate]gamePlayer] getFuelTanks]) {
		buyFuel.hidden = FALSE;
		buyFullTank.hidden = FALSE;
	} else {
		buyFuel.hidden = TRUE;
		buyFullTank.hidden = TRUE;
	}
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] getShipHull] < [[[AppDelegate sharedAppDelegate]gamePlayer] getHullStrength])  {
		buyRepair.hidden = FALSE;
		buyFullRepair.hidden = FALSE;
	} else {
		buyRepair.hidden = TRUE;
		buyFullRepair.hidden = TRUE;
	}
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemTechLevelInt] >= [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentShipTechLevel]) {
		buyNewShip.hidden = FALSE;
		shipInfo.hidden = TRUE;
	} else {
		buyNewShip.hidden = TRUE;
		shipInfo.hidden = FALSE;
	}
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemTechLevelInt] < [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentShipTechLevel] || [[[AppDelegate sharedAppDelegate]gamePlayer] toSpend] < 2000 || [[[AppDelegate sharedAppDelegate]gamePlayer] escapePod]) {
		buyEscapePod.hidden = TRUE;
		
	} else {
		buyEscapePod.hidden = FALSE;
	}
	
	fuelAmount.text = [NSString stringWithFormat:@"You have fuel to fly %i parsec%@", [[[AppDelegate sharedAppDelegate]gamePlayer] getFuel],[[[AppDelegate sharedAppDelegate]gamePlayer] getFuel] > 1 ? @"s." : @"." ];	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] getFuel] < [[[AppDelegate sharedAppDelegate]gamePlayer] getFuelTanks]) {
		int cost = ([[[AppDelegate sharedAppDelegate]gamePlayer] getFuelTanks] - [[[AppDelegate sharedAppDelegate]gamePlayer] getFuel]) * [[[AppDelegate sharedAppDelegate]gamePlayer] getFuelCost];
		fuelCost.text = [NSString stringWithFormat:@"A full tank costs %i cr.", cost];	
	}
	else {
		fuelCost.text = @"Your tank cannot hold more fuel.";
	}
	
	hullStrength.text = [NSString stringWithFormat:@"Your hull strength is at %i%%.", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipHull] * 100 / [[[AppDelegate sharedAppDelegate]gamePlayer] getHullStrength]];	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] getShipHull] <  [[[AppDelegate sharedAppDelegate]gamePlayer] getHullStrength]) {
		int cost = (-[[[AppDelegate sharedAppDelegate]gamePlayer] getShipHull] +  [[[AppDelegate sharedAppDelegate]gamePlayer] getHullStrength]) * [[[AppDelegate sharedAppDelegate]gamePlayer] getRepairCost];
		needRepairs.text = [NSString stringWithFormat:@"Full repair will cost %i cr.", cost];	
	}
	else {
		needRepairs.text = @"No repairs are needed.";
	}	
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemTechLevelInt] >= [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentShipTechLevel]) {
		newShipsInfo.text =@"There are new ships for sale.";
	}
	else {
		newShipsInfo.text =@"No new ships for sale.";		
	}
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] escapePod]) 
		escapePod.text = @"You have an escape pod installed.";
	else 
		if ([[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemTechLevelInt] < [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentShipTechLevel])
			escapePod.text =@"No escape pods for sale.";
		else if ([[[AppDelegate sharedAppDelegate]gamePlayer] toSpend] < podPrice) 
			escapePod.text = [NSString stringWithFormat:@"You need %i cr. for an escape pod.", podPrice];
		else
			escapePod.text = [NSString stringWithFormat:@"You can buy an escape pod for %i cr.", podPrice];
	
}

- (void)viewDidAppear:(BOOL)animated  {
	[self UpdateView];
}

- (void)didMoveToWindow {
	[super didMoveToWindow];
	[self UpdateView];
}

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
	int button = buttonIndex;
	
	if (button == 1) {
		unsigned int val = (int)[[(AlertModalWindow*)alertView mySlider]value];
		if (mode == 1)
			[[[AppDelegate sharedAppDelegate]gamePlayer] buyFuel:val];
		else 
			[[[AppDelegate sharedAppDelegate]gamePlayer] buyRepairs:val];
		[self UpdateView];	
	} else if (button == 2) {
		if (mode == 1)
			[[[AppDelegate sharedAppDelegate]gamePlayer] buyFuel:9999];
		else 
			[[[AppDelegate sharedAppDelegate]gamePlayer] buyRepairs:9999];
	}
		[self UpdateView];
}

-(IBAction) buyFuelAction {
	mode = 1;
	NSString * message = [NSString stringWithFormat:@"How much do you want to\nspend on fuel?\n\n\n\n"];	
	int cost = ([[[AppDelegate sharedAppDelegate]gamePlayer] getFuelTanks] - [[[AppDelegate sharedAppDelegate]gamePlayer] getFuel]) * [[[AppDelegate sharedAppDelegate]gamePlayer] getFuelCost];
	AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Buy Fuel" yoffset:1 buyValue:cost minValue:1 message:message  
																	delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Purchase"];

	[myAlertView show];
	[myAlertView release];
}

-(IBAction) buyFullFuelAction {
	[[[AppDelegate sharedAppDelegate]gamePlayer] buyFuel:9999];
	[self UpdateView];
}

-(IBAction) buyRepairAction {
	mode = 2;
	NSString * message = [NSString stringWithFormat:@"How much do you want to\nspend on repairs?\n\n\n\n"];	
	int cost = (-[[[AppDelegate sharedAppDelegate]gamePlayer] getShipHull] +  [[[AppDelegate sharedAppDelegate]gamePlayer] getHullStrength]) * [[[AppDelegate sharedAppDelegate]gamePlayer] getRepairCost];
	AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Repairs" yoffset:0 buyValue:cost minValue:1 message:message  
																	delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Purchase"];

	[myAlertView show];
	[myAlertView release];
}

-(IBAction) buyFullRepairAction {
	[[[AppDelegate sharedAppDelegate]gamePlayer] buyRepairs:9999];	
	[self UpdateView];
}


-(IBAction) buyEscapePodAction {
	[[[AppDelegate sharedAppDelegate]gamePlayer]setEscapePod:TRUE];
	[[[AppDelegate sharedAppDelegate]gamePlayer]setCredits: ([[[AppDelegate sharedAppDelegate]gamePlayer]credits] - podPrice)];
	[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"EscapePodInstalled.caf"];
	[self UpdateView];
}


@end
