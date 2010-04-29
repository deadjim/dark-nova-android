// 
//  BuyEquipmentViewController.m
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

#import "BuyEquipmentViewController.h"
#import "AppDelegate.h"
#import "Player.h"


@implementation BuyEquipmentViewController

@synthesize equipmentName0, equipmentName1, equipmentName2, equipmentName3, equipmentName4;	
@synthesize equipmentName5, equipmentName6, equipmentName7, equipmentName8, equipmentName9;
@synthesize buy0, buy1, buy2, buy3, buy4, buy5, buy6, buy7, buy8, buy9, cash;
@synthesize equipmentPrice0, equipmentPrice1, equipmentPrice2, equipmentPrice3, equipmentPrice4;
@synthesize equipmentPrice5, equipmentPrice6, equipmentPrice7, equipmentPrice8, equipmentPrice9;
@synthesize pirateWeapon, pirateShield, pirateHull;


-(void)dealloc {
	
	[equipmentName0 release];
	[equipmentName1 release];
	[equipmentName2 release];
	[equipmentName3 release];
	[equipmentName4 release];
	[equipmentName5 release];
	[equipmentName6 release];
	[equipmentName7 release];
	[equipmentName8 release];
	[equipmentName9 release];
	
	[equipmentPrice0 release];
	[equipmentPrice1 release];
	[equipmentPrice2 release];
	[equipmentPrice3 release];
	[equipmentPrice4 release];
	[equipmentPrice5 release];
	[equipmentPrice6 release];
	[equipmentPrice7 release];
	[equipmentPrice8 release];
	[equipmentPrice9 release];
	
	[buy0 release];
	[buy1 release];
	[buy2 release];
	[buy3 release];
	[buy4 release];
	[buy5 release];
	[buy6 release];
	[buy7 release];
	[buy8 release];
	[buy9 release];
	[cash release];
	
	[pirateWeapon release];
	[pirateShield release];
	[pirateHull release];
	
	[super dealloc];
}


-(IBAction)closeViewAction {
	[self dismissModalViewControllerAnimated:YES];
	[[AppDelegate sharedAppDelegate]setGameMode];
}

-(IBAction)pirateHullAction {
	pirateMode = ePirateHull;
	if([[[AppDelegate sharedAppDelegate]gamePlayer]getShipHullMax] < 150)
		fee = 2500;
	else 
		fee = 6500;
	
	amount = (int)([[[AppDelegate sharedAppDelegate]gamePlayer]getShipHullMax] * 0.25);
	NSString *message = [[NSString alloc] initWithFormat:@"The pirate hull upgrade will increase your hull strength by 25%%. The cost is %i credits. Do you want to purchase and install it?", fee];
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Pirate Hull Upgrade"
													message:message
												   delegate:self cancelButtonTitle:@"No" otherButtonTitles:@"Yes", nil];
	[alert show];
	[alert release];
	[message release];

}

-(IBAction)pirateWeaponAction {
	pirateMode = ePirateWeapon;
	amount = 50;
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]maxWeaponUpgradePrice])
		fee = 6500;
	else 
		fee = 2500;

	NSString *message = [[NSString alloc] initWithFormat:@"The pirate weapon upgrade will increase the strength of the first weapon you have installed by 25%%. The cost is %i credits. Do you want to purchase and install it?", fee];
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Pirate Weapon Upgrade"
													message:message
												   delegate:self cancelButtonTitle:@"No" otherButtonTitles:@"Yes", nil];
	[alert show];
	[alert release];
	[message release];
	
}

-(IBAction)pirateShieldAction {
	pirateMode = ePirateShield;
	amount = 50;
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]maxShieldUpgradePrice])
		fee = 6500;
	else 
		fee = 2500;
	
	NSString *message = [[NSString alloc] initWithFormat:@"The pirate shield upgrade will increase the strength of the first shield you have installed by 25%%. The cost is %i credits. Do you want to purchase and install it?", fee];
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Pirate Upgrade"
													message:message
												   delegate:self cancelButtonTitle:@"No" otherButtonTitles:@"Yes", nil];
	[alert show];
	[alert release];
	[message release];
	
}

-(void)alertView:(UIAlertView *)alertView clickedButtonAtIndex:(NSInteger)buttonIndex {

	if (buttonIndex == 1) {
		switch (pirateMode) {
			case 0:
				[[[AppDelegate sharedAppDelegate]gamePlayer]pirateUpgradeHull:amount cost:fee];
				break;
			case 1:
				[[[AppDelegate sharedAppDelegate]gamePlayer]pirateUpgradeShield:amount cost:fee];
				break;
			case 2:
				[[[AppDelegate sharedAppDelegate]gamePlayer]pirateUpgradeWeapon:amount cost:fee];
				break;
			default:
				break;
		}

	}
	[self updateView];
}

-(void)viewDidDisappear:(BOOL)animated {
	[super viewDidDisappear:YES];
}

- (void)awakeFromNib {
	self.title = @"Buy Equipment";	
}

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {
		self.title = @"Buy Equipment";				
	}
	return self;
}

-(void)updateButtonAndLabels:(int)index button:(UIButton*)button labelName:(UILabel*)labelName labelPrice:(UILabel*)labelPrice {
	labelName.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getEquipmentName:index];
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] getEquipmentPrice:index] > 0) {
		button.hidden = FALSE;
		labelPrice.text = [NSString stringWithFormat:@"%i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer] getEquipmentPrice:index]];
	}
	else {
		button.hidden = TRUE;
		labelPrice.text = @"not sold";
	}
}

- (void)viewDidLoad {
    [super viewDidLoad];
	[self updateView];
}
- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}


-(void) updateView {
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]getCurrentSystemPirateLevel] > 5) {
		if([[[AppDelegate sharedAppDelegate]gamePlayer]canUpgradeHull])
			self.pirateHull.hidden = FALSE;
		else 
			self.pirateHull.hidden = TRUE;
			
		if([[[AppDelegate sharedAppDelegate]gamePlayer]canUpgradeShield])
			self.pirateShield.hidden = FALSE;
		else 
			self.pirateShield.hidden = TRUE;
			
		if([[[AppDelegate sharedAppDelegate]gamePlayer]canUpgradeWeapon])
			self.pirateWeapon.hidden = FALSE;		
		else 
			self.pirateWeapon.hidden = TRUE;		
	}
	
	[self updateButtonAndLabels:0 button:buy0 labelName:equipmentName0 labelPrice:equipmentPrice0];
	[self updateButtonAndLabels:1 button:buy1 labelName:equipmentName1 labelPrice:equipmentPrice1];
	[self updateButtonAndLabels:2 button:buy2 labelName:equipmentName2 labelPrice:equipmentPrice2];
	[self updateButtonAndLabels:3 button:buy3 labelName:equipmentName3 labelPrice:equipmentPrice3];
	[self updateButtonAndLabels:4 button:buy4 labelName:equipmentName4 labelPrice:equipmentPrice4];
	[self updateButtonAndLabels:5 button:buy5 labelName:equipmentName5 labelPrice:equipmentPrice5];
	[self updateButtonAndLabels:6 button:buy6 labelName:equipmentName6 labelPrice:equipmentPrice6];	
	[self updateButtonAndLabels:7 button:buy7 labelName:equipmentName7 labelPrice:equipmentPrice7];
	[self updateButtonAndLabels:8 button:buy8 labelName:equipmentName8 labelPrice:equipmentPrice8];
	[self updateButtonAndLabels:9 button:buy9 labelName:equipmentName9 labelPrice:equipmentPrice9];
	
	cash.text = [NSString stringWithFormat:@"Cash: %i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer]credits]];	
}

-(void)buyEquipment:(int)index {
	[[[AppDelegate sharedAppDelegate]gamePlayer] tryToBuyEquipment:index controller:self];
	[self updateView];
}


-(IBAction) pressBuy0; {
	[self buyEquipment:0];
}

-(IBAction) pressBuy1 {
	[self buyEquipment:1];	
}

-(IBAction) pressBuy2 {
	[self buyEquipment:2];	
}

-(IBAction) pressBuy3 {
	[self buyEquipment:3];	
}

-(IBAction) pressBuy4 {
	[self buyEquipment:4];	
}

-(IBAction) pressBuy5 {
	[self buyEquipment:5];	
}

-(IBAction) pressBuy6 {
	[self buyEquipment:6];	
}

-(IBAction) pressBuy7 {
	[self buyEquipment:7];	
}

-(IBAction) pressBuy8 {
	[self buyEquipment:8];	
}

-(IBAction) pressBuy9 {
	[self buyEquipment:9];	
}


@end
