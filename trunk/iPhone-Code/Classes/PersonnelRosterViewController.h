//
//  PersonnelRosterViewController.h
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

@interface PersonnelRosterViewController : UIViewController {
	
	IBOutlet UILabel *cash;
	IBOutlet UIButton *fire0;
	IBOutlet UILabel *Price0;
	IBOutlet UILabel *Trader0;
	IBOutlet UILabel *Fighter0;
	IBOutlet UILabel *Engineer0;
	IBOutlet UILabel *Pilot0;
	IBOutlet UILabel *Vacancy0;
	IBOutlet UILabel *PilotName0;
	
	IBOutlet UIButton *fire1;
	IBOutlet UILabel *Price1;
	IBOutlet UILabel *Trader1;
	IBOutlet UILabel *Fighter1;
	IBOutlet UILabel *Engineer1;
	IBOutlet UILabel *Pilot1;
	IBOutlet UILabel *Vacancy1;
	IBOutlet UILabel *PilotName1;
	
	IBOutlet UIButton *fire2;
	IBOutlet UILabel *Price2;
	IBOutlet UILabel *Trader2;
	IBOutlet UILabel *Fighter2;
	IBOutlet UILabel *Engineer2;
	IBOutlet UILabel *Pilot2;
	IBOutlet UILabel *Vacancy2;	
	IBOutlet UILabel *PilotName2;	
}

@property (nonatomic, retain) IBOutlet UIButton *fire0;
@property (nonatomic, retain) IBOutlet UILabel *Price0;
@property (nonatomic, retain) IBOutlet UILabel *Trader0;
@property (nonatomic, retain) IBOutlet UILabel *Fighter0;
@property (nonatomic, retain) IBOutlet UILabel *Engineer0;
@property (nonatomic, retain) IBOutlet UILabel *Pilot0;
@property (nonatomic, retain) IBOutlet UILabel *Vacancy0;
@property (nonatomic, retain) IBOutlet UILabel *PilotName0;

@property (nonatomic, retain) IBOutlet UIButton *fire1;
@property (nonatomic, retain) IBOutlet UILabel *Price1;
@property (nonatomic, retain) IBOutlet UILabel *Trader1;
@property (nonatomic, retain) IBOutlet UILabel *Fighter1;
@property (nonatomic, retain) IBOutlet UILabel *Engineer1;
@property (nonatomic, retain) IBOutlet UILabel *Pilot1;
@property (nonatomic, retain) IBOutlet UILabel *Vacancy1;
@property (nonatomic, retain) IBOutlet UILabel *PilotName1;

@property (nonatomic, retain) IBOutlet UIButton *fire2;
@property (nonatomic, retain) IBOutlet UILabel *Price2;
@property (nonatomic, retain) IBOutlet UILabel *Trader2;
@property (nonatomic, retain) IBOutlet UILabel *Fighter2;
@property (nonatomic, retain) IBOutlet UILabel *Engineer2;
@property (nonatomic, retain) IBOutlet UILabel *Pilot2;
@property (nonatomic, retain) IBOutlet UILabel *Vacancy2;
@property (nonatomic, retain) IBOutlet UILabel *PilotName2;

-(IBAction) pressFire0;
-(IBAction) pressFire1;
-(IBAction) pressFire2;
-(IBAction)closeViewAction;


@end
