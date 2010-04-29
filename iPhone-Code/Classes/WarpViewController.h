//
//  WarpViewController.h
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

#import "PricesView.h"
#import "WarpSystemInfoView.h"

@interface WarpViewController : UIViewController  {

	IBOutlet PricesView *pricesViewInst;
	IBOutlet WarpSystemInfoView *sysInfoViewInst;
	
}

@property (nonatomic, retain) IBOutlet PricesView *pricesViewInst;
@property (nonatomic, retain) IBOutlet WarpSystemInfoView *sysInfoViewInst;

-(void) updateTitle;
-(IBAction) showSystemInformation;
-(IBAction) showPricesInformation;
-(IBAction) showShortRangeChart;
-(IBAction) doWarp;
-(IBAction) nextPlanet;
-(IBAction) prevPlanet;
-(IBAction) galacticChart;

@end
