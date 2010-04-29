//
//  StatusView.h
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

@interface StatusView : UIView {
	
	IBOutlet	UILabel*		pilotName;
	IBOutlet	UILabel*		pilotSkill;	
	IBOutlet	UILabel*		traderSkill;
	IBOutlet	UILabel*		fighterSkill;
	IBOutlet	UILabel*		engineerSkill;
	IBOutlet	UILabel*		kills;
	IBOutlet	UILabel*		time;
	IBOutlet	UILabel*		cash;
	IBOutlet	UILabel*		debt;
	IBOutlet	UILabel*		netWorth;
	IBOutlet	UILabel*		transport;
	IBOutlet	UILabel*		reputation;
	IBOutlet	UILabel*		policeRecord;
	IBOutlet	UILabel*		difficulty;
	IBOutlet	UILabel*		totalPassengers;
	IBOutlet	UILabel*		totalPEPPassengers;


}


@property (nonatomic, retain) 	IBOutlet	UILabel*		pilotName;
@property (nonatomic, retain) 	IBOutlet	UILabel*		pilotSkill;	
@property (nonatomic, retain) 	IBOutlet	UILabel*		traderSkill;
@property (nonatomic, retain)	IBOutlet	UILabel*		fighterSkill;
@property (nonatomic, retain) 	IBOutlet	UILabel*		engineerSkill;
@property (nonatomic, retain) 	IBOutlet	UILabel*		kills;
@property (nonatomic, retain) 	IBOutlet	UILabel*		time;
@property (nonatomic, retain) 	IBOutlet	UILabel*		cash;
@property (nonatomic, retain) 	IBOutlet	UILabel*		debt;
@property (nonatomic, retain)	IBOutlet	UILabel*		netWorth;
@property (nonatomic, retain) 	IBOutlet	UILabel*		transport;
@property (nonatomic, retain) 	IBOutlet	UILabel*		reputation;
@property (nonatomic, retain) 	IBOutlet	UILabel*		policeRecord;
@property (nonatomic, retain) 	IBOutlet	UILabel*		difficulty;
@property (nonatomic, retain) 	IBOutlet	UILabel*		totalPassengers;
@property (nonatomic, retain) 	IBOutlet	UILabel*		totalPEPPassengers;


-(void)updateView;

@end
