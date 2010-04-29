//
//  ShipYardView.h
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

@interface ShipYardView : UIView {

	IBOutlet UILabel *fuelAmount;
	IBOutlet UILabel *fuelCost;
	IBOutlet UILabel *hullStrength;
	IBOutlet UILabel *needRepairs;
	IBOutlet UILabel *newShipsInfo;
	IBOutlet UILabel *escapePod;
	
	IBOutlet UIButton *buyFuel;
	IBOutlet UIButton *buyFullTank;
	IBOutlet UIButton *buyRepair;
	IBOutlet UIButton *buyFullRepair;
	IBOutlet UILabel *totalCash;
	
	IBOutlet UIButton *buyEscapePod;
	IBOutlet UIButton *shipInfo;
	IBOutlet UIButton *buyNewShip;
	
	int mode;
	int podPrice;
}

@property (nonatomic, retain) IBOutlet UILabel *fuelAmount;
@property (nonatomic, retain) IBOutlet UILabel *fuelCost;
@property (nonatomic, retain) IBOutlet UILabel *hullStrength;
@property (nonatomic, retain) IBOutlet UILabel *needRepairs;
@property (nonatomic, retain) IBOutlet UILabel *newShipsInfo;
@property (nonatomic, retain) IBOutlet UILabel *escapePod;

@property (nonatomic, retain) IBOutlet UIButton *buyFuel;
@property (nonatomic, retain) IBOutlet UIButton *buyFullTank;
@property (nonatomic, retain) IBOutlet UIButton *buyRepair;
@property (nonatomic, retain) IBOutlet UIButton *buyFullRepair;
@property (nonatomic, retain) IBOutlet UILabel *totalCash;

@property (nonatomic, retain) IBOutlet UIButton *buyEscapePod;
@property (nonatomic, retain) IBOutlet UIButton *shipInfo;
@property (nonatomic, retain) IBOutlet UIButton *buyNewShip;


-(IBAction) buyFuelAction;
-(IBAction) buyFullFuelAction;
-(IBAction) buyRepairAction;
-(IBAction) buyFullRepairAction;
-(IBAction) buyEscapePodAction;

@end
