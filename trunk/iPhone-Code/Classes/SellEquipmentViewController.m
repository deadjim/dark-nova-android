//
//  SellEquipmentViewController.m
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

#import "SellEquipmentViewController.h"
#import "AppDelegate.h"
#import "Player.h"



@implementation SellEquipmentViewController

@synthesize weaponName0, weaponName1, weaponName2, weaponPrice0, weaponPrice1;
@synthesize weaponPrice2, weaponSell0, weaponSell1, weaponSell2;
@synthesize shieldName0, shieldName1, shieldName2, shieldPrice0, shieldPrice1;
@synthesize shieldPrice2, shieldSell0, shieldSell1, shieldSell2;
@synthesize gadgetName0, gadgetName1, gadgetName2, gadgetPrice0, gadgetPrice1;
@synthesize gadgetPrice2, gadgetSell0, gadgetSell1, gadgetSell2;
@synthesize noWeapons, noShield, noGadgets, cash;


-(void)dealloc {
	
	[weaponName0 release];
	[weaponName1 release];
	[weaponName2 release];
	[weaponPrice0 release];
	[weaponPrice1 release];
	[weaponPrice2 release];
	[weaponSell0 release];
	[weaponSell1 release];
	[weaponSell2 release];
	
	[shieldName0 release];
	[shieldName1 release];
	[shieldName2 release];
	[shieldPrice0 release];
	[shieldPrice1 release];
	[shieldPrice2 release];
	[shieldSell0 release];
	[shieldSell1 release];
	[shieldSell2 release];
	
	[gadgetName0 release];
	[gadgetName1 release];
	[gadgetName2 release];
	[gadgetPrice0 release];
	[gadgetPrice1 release];
	[gadgetPrice2 release];
	[gadgetSell0 release];
	[gadgetSell1 release];
	[gadgetSell2 release];
	
	[noWeapons release];
	[noShield release];
	[noGadgets release];
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
	}
	return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
}

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}



-(void)updateButtonAndLabels:(int)index button:(UIButton*)button labelName:(UILabel*)labelName labelPrice:(UILabel*)labelPrice counter:(int*)counter {

	if ([[[AppDelegate sharedAppDelegate]gamePlayer] getSellEquipmentPrice:index] > 0) {
		labelName.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipEquipmentName:index];		
		button.hidden = FALSE;
		labelName.hidden = FALSE;
		labelPrice.hidden = FALSE;
		labelPrice.text = [NSString stringWithFormat:@"%i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer] getSellEquipmentPrice:index]];
		(*counter)++;
	}
	else {
		button.hidden = TRUE;
		labelName.hidden = TRUE;
		labelPrice.hidden = TRUE;
	}
}


-(void)UpdateView {
	int weapons = 0, shields = 0, gadgets = 0;
	[self updateButtonAndLabels:0 button:weaponSell0 labelName:weaponName0 labelPrice:weaponPrice0 counter:&weapons];
	[self updateButtonAndLabels:1 button:weaponSell1 labelName:weaponName1 labelPrice:weaponPrice1 counter:&weapons];
	[self updateButtonAndLabels:2 button:weaponSell2 labelName:weaponName2 labelPrice:weaponPrice2 counter:&weapons];

	if (weapons == 0)
		noWeapons.hidden = FALSE;
	else 
		noWeapons.hidden = TRUE;

	[self updateButtonAndLabels:3 button:shieldSell0 labelName:shieldName0 labelPrice:shieldPrice0 counter:&shields];
	[self updateButtonAndLabels:4 button:shieldSell1 labelName:shieldName1 labelPrice:shieldPrice1 counter:&shields];
	[self updateButtonAndLabels:5 button:shieldSell2 labelName:shieldName2 labelPrice:shieldPrice2 counter:&shields];
	
	if (shields == 0)
		noShield.hidden = FALSE;
	else 
		noShield.hidden = TRUE;

	[self updateButtonAndLabels:6 button:gadgetSell0 labelName:gadgetName0 labelPrice:gadgetPrice0 counter:&gadgets];
	[self updateButtonAndLabels:7 button:gadgetSell1 labelName:gadgetName1 labelPrice:gadgetPrice1 counter:&gadgets];
	[self updateButtonAndLabels:8 button:gadgetSell2 labelName:gadgetName2 labelPrice:gadgetPrice2 counter:&gadgets];
	
	if (gadgets == 0)
		noGadgets.hidden = FALSE;
	else 
		noGadgets.hidden = TRUE;
	
	cash.text = [NSString stringWithFormat:@"Cash: %i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer]credits]];		
}


- (void)loadView {
	[super loadView];
	[self UpdateView];
}


- (void)viewDidAppear:(BOOL)animated {
	[super viewDidAppear:animated];
	[self UpdateView];
}


- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
	int button = buttonIndex;
	
	if (button == 1) {
		[[[AppDelegate sharedAppDelegate]gamePlayer] sellEquipment:numSellItem];
		[self UpdateView];	
	} 	
}


-(void) sellItem:(int)index {
	numSellItem = index;

	UIAlertView * view = [[UIAlertView alloc] initWithTitle:@"Sell Equipment" message:@"Are you sure you want to\nsell this item?" delegate:self cancelButtonTitle:@"No" otherButtonTitles:@"Yes", nil];
	[view show];
	[view release];
}

-(IBAction) sellWeapon0 {
	[self sellItem:0];
}

-(IBAction) sellWeapon1 {
	[self sellItem:1];	
}

-(IBAction) sellWeapon2 {
	[self sellItem:2];	
}

-(IBAction) sellShield0 {
	[self sellItem:3];	
}

-(IBAction) sellShield1 {
	[self sellItem:4];	
}

-(IBAction) sellShield2 {
	[self sellItem:5];	
}

-(IBAction) sellGadget0 {
	[self sellItem:6];	
}

-(IBAction) sellGadget1 {
	[self sellItem:7];	
}

-(IBAction) sellGadget2 {
	[self sellItem:8];	
}


@end
