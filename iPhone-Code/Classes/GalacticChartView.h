// 
//  GalacticChartView.h
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

@interface GalacticChartView :UIView  {
	
	CGImageRef redDot;
	CGImageRef greenDot;
	CGImageRef blueDot;
	CGImageRef targetDot;
	
	CGSize		redDotSize;
	CGSize		blueDotSize;
	CGSize		greenDotSize;
	CGSize		targetDotSize;
	
	CGImageRef background;
	CGSize		backgroundSize;
	
	IBOutlet UIButton *nextSystem;
	IBOutlet UIButton *prevSystem;
	IBOutlet UIButton *jumpButton;	
	IBOutlet UILabel *systemName;
	IBOutlet UILabel *systemType;	

	int Index;
	BOOL skipAlert;
	IBOutlet UIButton *cheatSystems;
	IBOutlet UIButton *cheatQuests;
	
}

@property (nonatomic, retain) IBOutlet UIButton *nextSystem;
@property (nonatomic, retain) IBOutlet UIButton *prevSystem;
@property (nonatomic, retain) IBOutlet UIButton *jumpButton;	
@property (nonatomic, retain) IBOutlet UILabel *systemName;
@property (nonatomic, retain) IBOutlet UILabel *systemType;	
@property (nonatomic, retain) IBOutlet UIButton *cheatSystems;
@property (nonatomic, retain) IBOutlet UIButton *cheatQuests;

-(IBAction)selectNextSystem; 
-(IBAction)selectPrevSystem; 
-(IBAction)findSystem; 

@end
