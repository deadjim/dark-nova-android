// 
//  BuyShipViewController.h
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
#import "GameDefines.h"


@interface BuyShipViewController : UIViewController <UIAlertViewDelegate> {

	IBOutlet UIButton *ship1;
    IBOutlet UIButton *ship10;
    IBOutlet UIButton *ship2;
    IBOutlet UIButton *ship3;
    IBOutlet UIButton *ship4;
    IBOutlet UIButton *ship5;
    IBOutlet UIButton *ship6;
    IBOutlet UIButton *ship7;
    IBOutlet UIButton *ship8;
    IBOutlet UIButton *ship9;
    IBOutlet UIButton *shipInfo1;
    IBOutlet UIButton *shipInfo10;
    IBOutlet UIButton *shipInfo2;
    IBOutlet UIButton *shipInfo3;
    IBOutlet UIButton *shipInfo4;
    IBOutlet UIButton *shipInfo5;
    IBOutlet UIButton *shipInfo6;
    IBOutlet UIButton *shipInfo7;
    IBOutlet UIButton *shipInfo8;
    IBOutlet UIButton *shipInfo9;
	IBOutlet UILabel *shipPrice1;
	IBOutlet UILabel *shipPrice2;	
	IBOutlet UILabel *shipPrice3;
	IBOutlet UILabel *shipPrice4;
	IBOutlet UILabel *shipPrice5;
	IBOutlet UILabel *shipPrice6;
	IBOutlet UILabel *shipPrice7;
	IBOutlet UILabel *shipPrice8;	
	IBOutlet UILabel *shipPrice9;
	IBOutlet UILabel *shipPrice10;
	
	IBOutlet UILabel *shipName1;
	IBOutlet UILabel *shipName2;	
	IBOutlet UILabel *shipName3;
	IBOutlet UILabel *shipName4;
	IBOutlet UILabel *shipName5;
	IBOutlet UILabel *shipName6;
	IBOutlet UILabel *shipName7;
	IBOutlet UILabel *shipName8;	
	IBOutlet UILabel *shipName9;
	IBOutlet UILabel *shipName10;
	IBOutlet UILabel *cash;
	
	int					buyShipViewValue[MAXTRADEITEM];
	int					activeShipItem;
	
}

@property (nonatomic, retain) IBOutlet UIButton *ship1;
@property (nonatomic, retain) IBOutlet UIButton *ship10;
@property (nonatomic, retain) IBOutlet UIButton *ship2;
@property (nonatomic, retain) IBOutlet UIButton *ship3;
@property (nonatomic, retain) IBOutlet UIButton *ship4;
@property (nonatomic, retain) IBOutlet UIButton *ship5;
@property (nonatomic, retain) IBOutlet UIButton *ship6;
@property (nonatomic, retain) IBOutlet UIButton *ship7;
@property (nonatomic, retain) IBOutlet UIButton *ship8;
@property (nonatomic, retain) IBOutlet UIButton *ship9;
@property (nonatomic, retain) IBOutlet UIButton *shipInfo1;
@property (nonatomic, retain) IBOutlet UIButton *shipInfo10;
@property (nonatomic, retain) IBOutlet UIButton *shipInfo2;
@property (nonatomic, retain) IBOutlet UIButton *shipInfo3;
@property (nonatomic, retain) IBOutlet UIButton *shipInfo4;
@property (nonatomic, retain) IBOutlet UIButton *shipInfo5;
@property (nonatomic, retain) IBOutlet UIButton *shipInfo6;
@property (nonatomic, retain) IBOutlet UIButton *shipInfo7;
@property (nonatomic, retain) IBOutlet UIButton *shipInfo8;
@property (nonatomic, retain) IBOutlet UIButton *shipInfo9;
@property (nonatomic, retain) IBOutlet UILabel *shipPrice1;
@property (nonatomic, retain) IBOutlet UILabel *shipPrice2;	
@property (nonatomic, retain) IBOutlet UILabel *shipPrice3;
@property (nonatomic, retain) IBOutlet UILabel *shipPrice4;
@property (nonatomic, retain) IBOutlet UILabel *shipPrice5;
@property (nonatomic, retain) IBOutlet UILabel *shipPrice6;
@property (nonatomic, retain) IBOutlet UILabel *shipPrice7;
@property (nonatomic, retain) IBOutlet UILabel *shipPrice8;	
@property (nonatomic, retain) IBOutlet UILabel *shipPrice9;
@property (nonatomic, retain) IBOutlet UILabel *shipPrice10;

@property (nonatomic, retain) IBOutlet UILabel *shipName1;
@property (nonatomic, retain) IBOutlet UILabel *shipName2;	
@property (nonatomic, retain) IBOutlet UILabel *shipName3;
@property (nonatomic, retain) IBOutlet UILabel *shipName4;
@property (nonatomic, retain) IBOutlet UILabel *shipName5;
@property (nonatomic, retain) IBOutlet UILabel *shipName6;
@property (nonatomic, retain) IBOutlet UILabel *shipName7;
@property (nonatomic, retain) IBOutlet UILabel *shipName8;	
@property (nonatomic, retain) IBOutlet UILabel *shipName9;
@property (nonatomic, retain) IBOutlet UILabel *shipName10;
@property (nonatomic, retain) IBOutlet UILabel *cash;

-(IBAction) buyShip1;
-(IBAction) buyShip2;
-(IBAction) buyShip3;
-(IBAction) buyShip4;
-(IBAction) buyShip5;
-(IBAction) buyShip6;
-(IBAction) buyShip7;
-(IBAction) buyShip8;
-(IBAction) buyShip9;
-(IBAction) buyShip10;

-(void)updateView;

-(IBAction) infoShip1;
-(IBAction) infoShip2;
-(IBAction) infoShip3;
-(IBAction) infoShip4;
-(IBAction) infoShip5;
-(IBAction) infoShip6;
-(IBAction) infoShip7;
-(IBAction) infoShip8;
-(IBAction) infoShip9;
-(IBAction) infoShip10;
-(IBAction)closeViewAction;

@end
