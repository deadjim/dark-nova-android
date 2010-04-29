//
//  WarpSystemInfoView.h
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

@interface WarpSystemInfoView : UIView {
	
	IBOutlet	UILabel *systemName;
	IBOutlet	UILabel *systemSize;
	IBOutlet	UILabel *systemTechLevel;
	IBOutlet	UILabel *systemGoverment;
	IBOutlet	UILabel *systemDistance;
	IBOutlet	UILabel *systemPolice;	
	IBOutlet	UILabel *systemPirates;
	IBOutlet	UILabel *systemMessage;
	IBOutlet	UILabel *systemCost;	
	IBOutlet	UIButton *specific;

	IBOutlet UIButton *warpButton;
	IBOutlet UIButton *nextButton;
	IBOutlet UIButton *prevButton;
	IBOutlet UIButton *avpButton;		
	IBOutlet UIButton *shortRangeChartButton;		
	IBOutlet UIButton *galacticChartButton;		
	
}

@property (nonatomic, retain) IBOutlet  UIButton *warpButton;
@property (nonatomic, retain) IBOutlet	UILabel *systemName;
@property (nonatomic, retain) IBOutlet	UILabel *systemSize;
@property (nonatomic, retain) IBOutlet	UILabel *systemTechLevel;
@property (nonatomic, retain) IBOutlet	UILabel *systemGoverment;
@property (nonatomic, retain) IBOutlet	UILabel *systemDistance;
@property (nonatomic, retain) IBOutlet	UILabel *systemPolice;	
@property (nonatomic, retain) IBOutlet	UILabel *systemPirates;
@property (nonatomic, retain) IBOutlet	UILabel *systemMessage;
@property (nonatomic, retain) IBOutlet	UILabel *systemCost;	
@property (nonatomic, retain) IBOutlet	UIButton *specific;

@property (nonatomic, retain) IBOutlet UIButton *nextButton;
@property (nonatomic, retain) IBOutlet UIButton *prevButton;
@property (nonatomic, retain) IBOutlet UIButton *avpButton;		
@property (nonatomic, retain) IBOutlet UIButton *shortRangeChartButton;		
@property (nonatomic, retain) IBOutlet UIButton *galacticChartButton;		


-(IBAction) pressSpecific;
-(void) updateTheView;
-(void) setTheView;

@end
