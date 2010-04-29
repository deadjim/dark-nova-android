// 
//  BuyEquipmentViewController.h
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

#import <UIKit/UIKit.h>

typedef enum {
	ePirateHull,
	ePirateShield,
	ePirateWeapon
} PirateMode;

@interface BuyEquipmentViewController : UIViewController <UIAlertViewDelegate> {
	
	PirateMode  pirateMode;
	int fee;
	int amount;
	
	IBOutlet UILabel *equipmentName0;
	IBOutlet UILabel *equipmentName1;
	IBOutlet UILabel *equipmentName2;
	IBOutlet UILabel *equipmentName3;
	IBOutlet UILabel *equipmentName4;	
	IBOutlet UILabel *equipmentName5;
	IBOutlet UILabel *equipmentName6;
	IBOutlet UILabel *equipmentName7;
	IBOutlet UILabel *equipmentName8;
	IBOutlet UILabel *equipmentName9;
	IBOutlet UIButton *buy0;
	IBOutlet UIButton *buy1;
	IBOutlet UIButton *buy2;
	IBOutlet UIButton *buy3;
	IBOutlet UIButton *buy4;
	IBOutlet UIButton *buy5;
	IBOutlet UIButton *buy6;
	IBOutlet UIButton *buy7;
	IBOutlet UIButton *buy8;
	IBOutlet UIButton *buy9;
	IBOutlet UILabel *equipmentPrice0;
	IBOutlet UILabel *equipmentPrice1;
	IBOutlet UILabel *equipmentPrice2;
	IBOutlet UILabel *equipmentPrice3;
	IBOutlet UILabel *equipmentPrice4;
	IBOutlet UILabel *equipmentPrice5;
	IBOutlet UILabel *equipmentPrice6;
	IBOutlet UILabel *equipmentPrice7;
	IBOutlet UILabel *equipmentPrice8;
	IBOutlet UILabel *equipmentPrice9;
	IBOutlet UILabel *cash;
	
	IBOutlet UIButton *pirateWeapon;
	IBOutlet UIButton *pirateShield;
	IBOutlet UIButton *pirateHull;
	
}

@property (nonatomic, retain) IBOutlet UILabel *equipmentName0;
@property (nonatomic, retain) IBOutlet UILabel *equipmentName1;
@property (nonatomic, retain) IBOutlet UILabel *equipmentName2;
@property (nonatomic, retain) IBOutlet UILabel *equipmentName3;
@property (nonatomic, retain) IBOutlet UILabel *equipmentName4;	
@property (nonatomic, retain) IBOutlet UILabel *equipmentName5;
@property (nonatomic, retain) IBOutlet UILabel *equipmentName6;
@property (nonatomic, retain) IBOutlet UILabel *equipmentName7;
@property (nonatomic, retain) IBOutlet UILabel *equipmentName8;
@property (nonatomic, retain) IBOutlet UILabel *equipmentName9;
@property (nonatomic, retain) IBOutlet UIButton *buy0;
@property (nonatomic, retain) IBOutlet UIButton *buy1;
@property (nonatomic, retain) IBOutlet UIButton *buy2;
@property (nonatomic, retain) IBOutlet UIButton *buy3;
@property (nonatomic, retain) IBOutlet UIButton *buy4;
@property (nonatomic, retain) IBOutlet UIButton *buy5;
@property (nonatomic, retain) IBOutlet UIButton *buy6;
@property (nonatomic, retain) IBOutlet UIButton *buy7;
@property (nonatomic, retain) IBOutlet UIButton *buy8;
@property (nonatomic, retain) IBOutlet UIButton *buy9;
@property (nonatomic, retain) IBOutlet UILabel *equipmentPrice0;
@property (nonatomic, retain) IBOutlet UILabel *equipmentPrice1;
@property (nonatomic, retain) IBOutlet UILabel *equipmentPrice2;
@property (nonatomic, retain) IBOutlet UILabel *equipmentPrice3;
@property (nonatomic, retain) IBOutlet UILabel *equipmentPrice4;
@property (nonatomic, retain) IBOutlet UILabel *equipmentPrice5;
@property (nonatomic, retain) IBOutlet UILabel *equipmentPrice6;
@property (nonatomic, retain) IBOutlet UILabel *equipmentPrice7;
@property (nonatomic, retain) IBOutlet UILabel *equipmentPrice8;
@property (nonatomic, retain) IBOutlet UILabel *equipmentPrice9;
@property (nonatomic, retain) IBOutlet UILabel *cash;
@property (nonatomic, retain) IBOutlet UIButton *pirateWeapon;
@property (nonatomic, retain) IBOutlet UIButton *pirateShield;
@property (nonatomic, retain) IBOutlet UIButton *pirateHull;

-(void) updateView;

-(IBAction) pressBuy0;
-(IBAction) pressBuy1;
-(IBAction) pressBuy2;
-(IBAction) pressBuy3;
-(IBAction) pressBuy4;
-(IBAction) pressBuy5;
-(IBAction) pressBuy6;
-(IBAction) pressBuy7;
-(IBAction) pressBuy8;
-(IBAction) pressBuy9;
-(IBAction)closeViewAction;

-(IBAction)pirateHullAction;
-(IBAction)pirateWeaponAction;
-(IBAction)pirateShieldAction;


@end
