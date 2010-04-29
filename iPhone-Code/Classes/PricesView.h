//
//  PricesView.h
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

@interface PricesView : UIView<UIAlertViewDelegate> {
	
	IBOutlet UILabel *water;
	IBOutlet UILabel *furs;
	IBOutlet UILabel *food;
	IBOutlet UILabel *ore;	
	IBOutlet UILabel *games;
	IBOutlet UILabel *firearms;
	IBOutlet UILabel *medicine;
	IBOutlet UILabel *machines;
	IBOutlet UILabel *narcotics;	
	IBOutlet UILabel *robots;
	IBOutlet UILabel *resources;	
	IBOutlet UIButton *absolutePricesButton;		
	IBOutlet UIButton *systemInfoButton;		
	IBOutlet UIButton *shortRangeChartButton;		
	IBOutlet UIButton *galacticChartButton;		
	IBOutlet UILabel *bays;
	IBOutlet UILabel *cash;
	IBOutlet UIButton *warpButton;
	IBOutlet UIButton *nextButton;
	IBOutlet UIButton *prevButton;
	
	BOOL absolutePrices;
	int itemsPrice[10];
	int itemsMax[10];
	
	int activeTradeItem;
}

@property (nonatomic, retain) IBOutlet UIButton *warpButton;
@property (nonatomic, retain) IBOutlet UILabel *water;
@property (nonatomic, retain) IBOutlet UILabel *furs;
@property (nonatomic, retain) IBOutlet UILabel *food;
@property (nonatomic, retain) IBOutlet UILabel *ore;	
@property (nonatomic, retain) IBOutlet UILabel *games;
@property (nonatomic, retain) IBOutlet UILabel *firearms;
@property (nonatomic, retain) IBOutlet UILabel *medicine;
@property (nonatomic, retain) IBOutlet UILabel *machines;
@property (nonatomic, retain) IBOutlet UILabel *narcotics;	
@property (nonatomic, retain) IBOutlet UILabel *robots;
@property (nonatomic, retain) IBOutlet UILabel *bays;
@property (nonatomic, retain) IBOutlet UILabel *resources;	
@property (nonatomic, retain) IBOutlet UIButton *absolutePricesButton;		
@property (nonatomic, retain) IBOutlet UIButton *systemInfoButton;		
@property (nonatomic, retain) IBOutlet UIButton *shortRangeChartButton;		
@property (nonatomic, retain) IBOutlet UIButton *galacticChartButton;		
@property (nonatomic, retain) IBOutlet UILabel *cash;
@property (nonatomic, retain) IBOutlet UIButton *nextButton;
@property (nonatomic, retain) IBOutlet UIButton *prevButton;


-(IBAction) buyWater;
-(IBAction) buyFurs;
-(IBAction) buyFood;
-(IBAction) buyOre;
-(IBAction) buyGames;
-(IBAction) buyFirearms;
-(IBAction) buyMedicine;
-(IBAction) buyMachines;
-(IBAction) buyNarcotics;
-(IBAction) buyRobots;
-(IBAction) showAbsolutePrices;

-(void) updateTheView;
-(void) setTheView;


@end
