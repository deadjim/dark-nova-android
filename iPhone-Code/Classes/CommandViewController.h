// 
//  CommandViewController.h
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

#import "SellCargoViewController.h"
#import "SystemInfoViewController.h"
#import "ShortRangeChartViewController.h"
#import "ShipYardViewController.h"


@interface CommandViewController : UIViewController <UIAlertViewDelegate> {
	
	IBOutlet UIButton *lowMemoryNotice;
	IBOutlet UILabel *commanderLabel;
	
	IBOutlet UIButton *saveGameButton;
	IBOutlet UIButton *loadGameButton;
	IBOutlet UIButton *gameOptionsButton;
	IBOutlet UIButton *buyCargoButton;
	IBOutlet UIButton *commanderStatusButton;
	IBOutlet UIButton *buyEquipmentButton;
	IBOutlet UIButton *sellEquipmentButton;
	IBOutlet UIButton *personnelRosterButton;
	IBOutlet UIButton *bankButton;
	IBOutlet UIButton *galacticChartButton;	
	
	SellCargoViewController *sellCargoViewControllerImpl;
	ShipYardViewController *shipYardViewControllerImpl;
	SystemInfoViewController *systemInfoViewControllerImpl;
	ShortRangeChartViewController *shortRangeChartViewControllerImpl;
	BOOL isLitePopup;	
	int memWarnCount;
}

@property (nonatomic, retain) IBOutlet UIButton *lowMemoryNotice;
@property (nonatomic, retain) IBOutlet UILabel *commanderLabel;
@property (nonatomic, retain) IBOutlet UIButton *saveGameButton;
@property (nonatomic, retain) IBOutlet UIButton *loadGameButton;
@property (nonatomic, retain) IBOutlet UIButton *gameOptionsButton;
@property (nonatomic, retain) IBOutlet UIButton *buyCargoButton;
@property (nonatomic, retain) IBOutlet UIButton *commanderStatusButton;
@property (nonatomic, retain) IBOutlet UIButton *buyEquipmentButton;
@property (nonatomic, retain) IBOutlet UIButton *sellEquipmentButton;
@property (nonatomic, retain) IBOutlet UIButton *personnelRosterButton;
@property (nonatomic, retain) IBOutlet UIButton *bankButton;
@property (nonatomic, retain) IBOutlet UIButton *galacticChartButton;


-(void) updateCommanderText;
-(IBAction) personnelRoster;
-(IBAction) systemInformation;
-(IBAction) shortRangeChart;
-(IBAction) sellCargo;
-(IBAction) shipYard;

-(IBAction) saveGame;
-(IBAction) loadGame;
-(IBAction) gameOptions;
-(IBAction) buyCargo;
-(IBAction) buyEquipment;
-(IBAction) sellEquipment;
-(IBAction) bank;
-(IBAction) commanderStatus;
-(IBAction) galacticChart;

-(IBAction) lowMemoryButtonPressed;
-(IBAction) purchase;


@end
