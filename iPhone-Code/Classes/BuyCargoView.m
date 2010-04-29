// 
//  BuyCargoView.m
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

#import "BuyCargoView.h"
#import "AppDelegate.h"
#import "Player.h"
#import "AlertModalWindow.h"


@implementation BuyCargoView

@synthesize cargo1, cargo10, cargo2, cargo3, cargo4, cargo5, cargo6, cargo7, cargo8, cargo9;
@synthesize maxCargo1, maxCargo10, maxCargo2, maxCargo3, maxCargo4, maxCargo5, maxCargo6, maxCargo7;
@synthesize maxCargo8, maxCargo9, cargoPrice1, cargoPrice2, cargoPrice3, cargoPrice4, cargoPrice5;
@synthesize cargoPrice6, cargoPrice7, cargoPrice8, cargoPrice9, cargoPrice10, cargoBay, cash;


-(void)dealloc {
	
	[cargo1 release];
	[cargo10 release];
	[cargo2 release];
	[cargo3 release];
	[cargo4 release];
	[cargo5 release];
	[cargo6 release];
	[cargo7 release];
	[cargo8 release];
	[cargo9 release];
	
	[maxCargo1 release];
	[maxCargo2 release];
	[maxCargo3 release];
	[maxCargo4 release];
	[maxCargo5 release];
	[maxCargo6 release];
	[maxCargo7 release];
	[maxCargo8 release];
	[maxCargo9 release];
	[maxCargo10 release];
	
	[cargoPrice10 release];
	[cargoPrice1 release];
	[cargoPrice2 release];
	[cargoPrice3 release];
	[cargoPrice4 release];
	[cargoPrice5 release];
	[cargoPrice6 release];
	[cargoPrice7 release];
	[cargoPrice8 release];
	[cargoPrice9 release];
	[cargoBay release];
	[cash release];
	
	[super dealloc];
}


-(void)setTitleToButton:(UIButton*) cargo num:(int)num maxButton:(UIButton*)maxButton {
	if (num > 0) {
		[cargo setTitle: [NSString stringWithFormat:@"%i",num] forState:UIControlStateNormal];
		cargo.hidden = FALSE;
		maxButton.hidden = FALSE;
	}
	else {
		cargo.hidden = TRUE;
		maxButton.hidden = TRUE;
	}

}

-(void)setTitleToLabel:(UILabel*) cargo num:(int)num {
	if (num ==  0)
		cargo.text=@"not sold";
	else
		cargo.text = [NSString stringWithFormat:@"%i", num];
}

-(void) UpdateView {
	cash.text = [NSString stringWithFormat:@"Cash: %i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer]credits]];	
	
	[self setTitleToLabel:cargoPrice1 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getBuyPrice:0]];
	[self setTitleToLabel:cargoPrice2 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getBuyPrice:1]];
	[self setTitleToLabel:cargoPrice3 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getBuyPrice:2]];	
	[self setTitleToLabel:cargoPrice4 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getBuyPrice:3]];
	[self setTitleToLabel:cargoPrice5 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getBuyPrice:4]];
	[self setTitleToLabel:cargoPrice6 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getBuyPrice:5]];
	[self setTitleToLabel:cargoPrice7 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getBuyPrice:6]];
	[self setTitleToLabel:cargoPrice8 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getBuyPrice:7]];	
	[self setTitleToLabel:cargoPrice9 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getBuyPrice:8]];
	[self setTitleToLabel:cargoPrice10 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getBuyPrice:9]];
	
	cargoBay.text = [NSString stringWithFormat:@"Bay: %i/%i", [[[AppDelegate sharedAppDelegate]gamePlayer] filledCargoBays], [[[AppDelegate sharedAppDelegate]gamePlayer] totalCargoBays]];	
	
	for (int i = 0; i < MAXTRADEITEM; ++i)
		buyCargoViewValue[i] = [[[AppDelegate sharedAppDelegate]gamePlayer] getAmountToBuy:i];
	
	[self setTitleToButton:cargo1 num:buyCargoViewValue[0] maxButton:maxCargo1];
	[self setTitleToButton:cargo2 num:buyCargoViewValue[1] maxButton:maxCargo2];
	[self setTitleToButton:cargo3 num:buyCargoViewValue[2] maxButton:maxCargo3];
	[self setTitleToButton:cargo4 num:buyCargoViewValue[3] maxButton:maxCargo4];
	[self setTitleToButton:cargo5 num:buyCargoViewValue[4] maxButton:maxCargo5];
	[self setTitleToButton:cargo6 num:buyCargoViewValue[5] maxButton:maxCargo6];
	[self setTitleToButton:cargo7 num:buyCargoViewValue[6] maxButton:maxCargo7];
	[self setTitleToButton:cargo8 num:buyCargoViewValue[7] maxButton:maxCargo8];
	[self setTitleToButton:cargo9 num:buyCargoViewValue[8] maxButton:maxCargo9];
	[self setTitleToButton:cargo10 num:buyCargoViewValue[9] maxButton:maxCargo10];
	
}

- (void)viewDidAppear:(BOOL)animated  {
	[self UpdateView];
}

- (void)didMoveToWindow {
	
	[super didMoveToWindow];
	[self UpdateView];
}

-(void) pressedCargo:(unsigned int) num {
	activeTradeItem = num;	
	NSString *message = [NSString stringWithFormat:@"At %i credits each, you can\nafford %i unit(s).",[[[AppDelegate sharedAppDelegate]gamePlayer] getBuyPrice:activeTradeItem], buyCargoViewValue[activeTradeItem]];
	int alertOffset = 0;
	if([message length] > 36)
		alertOffset = 22;
	int emptyCargoBays = ([[[AppDelegate sharedAppDelegate]gamePlayer]totalCargoBays] - [[[AppDelegate sharedAppDelegate]gamePlayer] filledCargoBays]);
	int maxQty = [[[AppDelegate sharedAppDelegate]gamePlayer] getAmountToBuy:activeTradeItem];
	if (emptyCargoBays > 0) {
		int emptyCargoBays = ([[[AppDelegate sharedAppDelegate]gamePlayer]totalCargoBays] - [[[AppDelegate sharedAppDelegate]gamePlayer] filledCargoBays]);
		message = [message stringByAppendingFormat:@"\nHow many do you want to buy?\n\n\n\n"];	
		AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Buy Items" yoffset:alertOffset 
																		buyValue:min(emptyCargoBays,maxQty) minValue:min(emptyCargoBays,1) message:message  
																		delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Purchase"];
		
		[myAlertView show];
		[myAlertView release];
	}
	else {
		UIAlertView *view = [[UIAlertView alloc] initWithTitle:@"Cargo Bays Full" message:@"All of your cargo bays are full." delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
		[view show];
		[view release];		
		[[[AppDelegate sharedAppDelegate]gamePlayer]showUserNotice:aAlert];		
	}
	
}

-(void) pressedCargoMax:(unsigned int) num {
	[[[AppDelegate sharedAppDelegate]gamePlayer] buyCargo:num Amount:buyCargoViewValue[num]];
	[self UpdateView];
	
}

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
	int button = buttonIndex;
	
	if (button == 1) {
		unsigned int val = (int)[[(AlertModalWindow*)alertView mySlider]value];
		[[[AppDelegate sharedAppDelegate]gamePlayer] buyCargo:activeTradeItem Amount:val];
		[self UpdateView];	
	} else if (button == 2) {
		
		[self pressedCargoMax:activeTradeItem];
	}
		
}


-(IBAction) pressCargo1 {
	[self pressedCargo:0];
}

-(IBAction) pressCargo2 {
	[self pressedCargo:1];
}

-(IBAction) pressCargo3 {
	[self pressedCargo:2];
}

-(IBAction) pressCargo4 {
	[self pressedCargo:3];
}

-(IBAction) pressCargo5 {
	[self pressedCargo:4];
}

-(IBAction) pressCargo6 {
	[self pressedCargo:5];
}

-(IBAction) pressCargo7; {
	[self pressedCargo:6];
}


-(IBAction) pressCargo8 {
	[self pressedCargo:7];
}

-(IBAction) pressCargo9 {
	[self pressedCargo:8];
}

-(IBAction) pressCargo10 {
	[self pressedCargo:9];
}

-(IBAction) pressMaxCargo1 {
	[self pressedCargoMax:0];
}

-(IBAction) pressMaxCargo2 {
	[self pressedCargoMax:1];
}

-(IBAction) pressMaxCargo3 {
	[self pressedCargoMax:2];
}

-(IBAction) pressMaxCargo4 {
	[self pressedCargoMax:3];
}

-(IBAction) pressMaxCargo5 {
	[self pressedCargoMax:4];
}

-(IBAction) pressMaxCargo6 {
	[self pressedCargoMax:5];
}

-(IBAction) pressMaxCargo7 {
	[self pressedCargoMax:6];
}


-(IBAction) pressMaxCargo8 {
	[self pressedCargoMax:7];
}

-(IBAction) pressMaxCargo9 {
	[self pressedCargoMax:8];
}

-(IBAction) pressMaxCargo10 {
	[self pressedCargoMax:9];
}

@end
