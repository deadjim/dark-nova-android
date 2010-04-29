//
//  ShipInfoView.h
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

@interface ShipInfoView : UIView  {
	
	IBOutlet UILabel *nameLabel;
	IBOutlet UILabel *sizeLabel;
	IBOutlet UILabel *cargoBaysLabel;
	IBOutlet UILabel *rangeLabel;
	IBOutlet UILabel *hullStrengthLabel;
	IBOutlet UILabel *weaponSlotsLabel;
	IBOutlet UILabel *shieldSlotsLabel;
	IBOutlet UILabel *gadgetSlotsLabel;
	IBOutlet UILabel *crewQuartersLabel;
	IBOutlet UIButton *doneButton;
	IBOutlet UIImageView *shipImage;
	
	int ship;
}
@property int ship;

@property (nonatomic, retain) IBOutlet UILabel *nameLabel;
@property (nonatomic, retain) IBOutlet UILabel *sizeLabel;
@property (nonatomic, retain) IBOutlet UILabel *cargoBaysLabel;
@property (nonatomic, retain) IBOutlet UILabel *rangeLabel;
@property (nonatomic, retain) IBOutlet UILabel *hullStrengthLabel;
@property (nonatomic, retain) IBOutlet UILabel *weaponSlotsLabel;
@property (nonatomic, retain) IBOutlet UILabel *shieldSlotsLabel;
@property (nonatomic, retain) IBOutlet UILabel *gadgetSlotsLabel;
@property (nonatomic, retain) IBOutlet UILabel *crewQuartersLabel;
@property (nonatomic, retain) IBOutlet UIButton *doneButton;
@property (nonatomic, retain) IBOutlet UIImageView *shipImage;

-(IBAction) done;

@end
