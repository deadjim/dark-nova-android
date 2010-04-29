//
//  SellCargoView.m
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

#import "SellCargoView.h"
#import "AppDelegate.h"
#import "Player.h"
#import "AlertModalWindow.h"


@implementation SellCargoView

@synthesize cargo1, cargo10, cargo2, cargo3, cargo4, cargo5, cargo6, cargo7, cargo8, cargo9;
@synthesize maxCargo1, maxCargo10, maxCargo2, maxCargo3, maxCargo4, maxCargo5, maxCargo6, maxCargo7;
@synthesize maxCargo8, maxCargo9, cargoPrice1, cargoPrice2, cargoPrice3, cargoPrice4, cargoPrice5;
@synthesize cargoPrice6, cargoPrice7, cargoPrice8, cargoPrice9, cargoPrice10, cargoBay, cash;
@synthesize navigationBar;

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
	[navigationBar release];
	
	[super dealloc];
}


- (void)awakeFromNib {
	navigationBar.hidden = TRUE;
	bJettison = FALSE;
	bOpponent = FALSE;
}


-(void)setTitleToButton:(UIButton*) cargo num:(int)num maxButton:(UIButton*)maxButton{
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
		cargo.text=@"no trade";
	else
		cargo.text = [NSString stringWithFormat:@"%i", num];
}

-(void) UpdateView {

	[[AppDelegate sharedAppDelegate]updateToolBar];

	cash.text = [NSString stringWithFormat:@"Cash: %i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer]credits]];	
	
	[self setTitleToLabel:cargoPrice1 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getSellPrice:0]];
	[self setTitleToLabel:cargoPrice2 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getSellPrice:1]];
	[self setTitleToLabel:cargoPrice3 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getSellPrice:2]];	
	[self setTitleToLabel:cargoPrice4 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getSellPrice:3]];
	[self setTitleToLabel:cargoPrice5 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getSellPrice:4]];
	[self setTitleToLabel:cargoPrice6 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getSellPrice:5]];
	[self setTitleToLabel:cargoPrice7 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getSellPrice:6]];
	[self setTitleToLabel:cargoPrice8 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getSellPrice:7]];	
	[self setTitleToLabel:cargoPrice9 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getSellPrice:8]];
	[self setTitleToLabel:cargoPrice10 num:[[[AppDelegate sharedAppDelegate]gamePlayer] getSellPrice:9]];
	
	cargoBay.text = [NSString stringWithFormat:@"Bay: %i/%i", [[[AppDelegate sharedAppDelegate]gamePlayer] filledCargoBays], [[[AppDelegate sharedAppDelegate]gamePlayer] totalCargoBays] ];	
	
	if (bOpponent) {
		for (int i = 0; i < MAXTRADEITEM; ++i)
			sellCargoViewValue[i] = [[[AppDelegate sharedAppDelegate]gamePlayer] getOpponentAmountToSell:i];
	}
	else {
		for (int i = 0; i < MAXTRADEITEM; ++i)
			sellCargoViewValue[i] = [[[AppDelegate sharedAppDelegate]gamePlayer] getAmountToSell:i];
	}
	
	[self setTitleToButton:cargo1 num:sellCargoViewValue[0] maxButton:maxCargo1];
	[self setTitleToButton:cargo2 num:sellCargoViewValue[1] maxButton:maxCargo2];
	[self setTitleToButton:cargo3 num:sellCargoViewValue[2] maxButton:maxCargo3];
	[self setTitleToButton:cargo4 num:sellCargoViewValue[3] maxButton:maxCargo4];
	[self setTitleToButton:cargo5 num:sellCargoViewValue[4] maxButton:maxCargo5];
	[self setTitleToButton:cargo6 num:sellCargoViewValue[5] maxButton:maxCargo6];
	[self setTitleToButton:cargo7 num:sellCargoViewValue[6] maxButton:maxCargo7];
	[self setTitleToButton:cargo8 num:sellCargoViewValue[7] maxButton:maxCargo8];
	[self setTitleToButton:cargo9 num:sellCargoViewValue[8] maxButton:maxCargo9];
	[self setTitleToButton:cargo10 num:sellCargoViewValue[9] maxButton:maxCargo10];
	
}
-(void) offsetControl:(UIView*) p {
	CGRect frame = CGRectMake(p.frame.origin.x, p.frame.origin.y + 40, p.frame.size.width,p.frame.size.height);
	[p setFrame:frame];
	CGAffineTransform transform = CGAffineTransformMakeTranslation(0, 40);
	p.transform = transform;
}

-(void) setOpponentType {
	bOpponent = TRUE;
	navigationBar.hidden = FALSE;
	[[[navigationBar items] objectAtIndex:0] setTitle:@"Plunder"];
	[UIView beginAnimations:@"ss" context:nil];
	[UIView setAnimationDelay:0];
	[self offsetControl:cargo1];
	[self offsetControl:cargo2];
	[self offsetControl:cargo3];
	[self offsetControl:cargo4];
	[self offsetControl:cargo5];
	[self offsetControl:cargo6];
	[self offsetControl:cargo7];	
	[self offsetControl:cargo8];	
	[self offsetControl:cargo9];
	[self offsetControl:cargo10];
	
	[self offsetControl:maxCargo1];
	[self offsetControl:maxCargo2];
	[self offsetControl:maxCargo3];
	[self offsetControl:maxCargo4];
	[self offsetControl:maxCargo5];
	[self offsetControl:maxCargo6];
	[self offsetControl:maxCargo7];	
	[self offsetControl:maxCargo8];	
	[self offsetControl:maxCargo9];
	[self offsetControl:maxCargo10];
	
	[self offsetControl:cargoPrice1];
	[self offsetControl:cargoPrice2];
	[self offsetControl:cargoPrice3];
	[self offsetControl:cargoPrice4];
	[self offsetControl:cargoPrice5];
	[self offsetControl:cargoPrice6];
	[self offsetControl:cargoPrice7];	
	[self offsetControl:cargoPrice8];	
	[self offsetControl:cargoPrice9];
	[self offsetControl:cargoPrice10];
	
	[self offsetControl:cargoName1];
	[self offsetControl:cargoName2];
	[self offsetControl:cargoName3];
	[self offsetControl:cargoName4];
	[self offsetControl:cargoName5];
	[self offsetControl:cargoName6];
	[self offsetControl:cargoName7];	
	[self offsetControl:cargoName8];	
	[self offsetControl:cargoName9];
	[self offsetControl:cargoName10];
	
	cash.hidden = TRUE;
	cargoBay.hidden = TRUE;
	[UIView commitAnimations];
	[self UpdateView];
	[self setNeedsDisplay];
	
}

-(void)setJettisonType {
	bJettison = TRUE;
	navigationBar.hidden = FALSE;
	[UIView beginAnimations:@"ss" context:nil];
	[UIView setAnimationDelay:0];
	[self offsetControl:cargo1];
	[self offsetControl:cargo2];
	[self offsetControl:cargo3];
	[self offsetControl:cargo4];
	[self offsetControl:cargo5];
	[self offsetControl:cargo6];
	[self offsetControl:cargo7];	
	[self offsetControl:cargo8];	
	[self offsetControl:cargo9];
	[self offsetControl:cargo10];
	
	[self offsetControl:maxCargo1];
	[self offsetControl:maxCargo2];
	[self offsetControl:maxCargo3];
	[self offsetControl:maxCargo4];
	[self offsetControl:maxCargo5];
	[self offsetControl:maxCargo6];
	[self offsetControl:maxCargo7];	
	[self offsetControl:maxCargo8];	
	[self offsetControl:maxCargo9];
	[self offsetControl:maxCargo10];
	
	[self offsetControl:cargoPrice1];
	[self offsetControl:cargoPrice2];
	[self offsetControl:cargoPrice3];
	[self offsetControl:cargoPrice4];
	[self offsetControl:cargoPrice5];
	[self offsetControl:cargoPrice6];
	[self offsetControl:cargoPrice7];	
	[self offsetControl:cargoPrice8];	
	[self offsetControl:cargoPrice9];
	[self offsetControl:cargoPrice10];

	[self offsetControl:cargoName1];
	[self offsetControl:cargoName2];
	[self offsetControl:cargoName3];
	[self offsetControl:cargoName4];
	[self offsetControl:cargoName5];
	[self offsetControl:cargoName6];
	[self offsetControl:cargoName7];	
	[self offsetControl:cargoName8];	
	[self offsetControl:cargoName9];
	[self offsetControl:cargoName10];
	
	cash.hidden = TRUE;
	cargoBay.hidden = TRUE;
	[UIView commitAnimations];
	[self setNeedsDisplay];
	
}

- (void)didMoveToWindow {
	
	[super didMoveToWindow];
	[self UpdateView];
}

-(void) pressedCargo:(unsigned int) num {
	activeTradeItem = num;	
	bDump = FALSE;
	if (bJettison) {
		NSString *message = [NSString stringWithFormat:@"You can jettison up to %i unit(s).\nYou paid about %i cr. per unit.\nHow many will you dump\n\n\n\n",
							 sellCargoViewValue[activeTradeItem], ([[[AppDelegate sharedAppDelegate]gamePlayer] getBuyingPrice:activeTradeItem]/sellCargoViewValue[activeTradeItem])];
		
		AlertModalWindow *myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Discard Items" yoffset:23 buyValue:sellCargoViewValue[activeTradeItem]
																	   minValue:0 message:message  
																	   delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Discard"];
		
		
		[myAlertView show];
		[myAlertView release];
	}
	else if (bOpponent) {
		NSString *message = [NSString stringWithFormat:@"You can take up to %i unit(s).\nHow many do you want to plunder?\n\n\n\n",
				   sellCargoViewValue[activeTradeItem]];
		
		AlertModalWindow *myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Plunder Items" yoffset:0 buyValue:sellCargoViewValue[activeTradeItem] 
																	   minValue:1 message:message  
																		delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Plunder"];

		[myAlertView show];
		[myAlertView release];
	}
	else {
		if ([[[AppDelegate sharedAppDelegate]gamePlayer] getSellPrice:activeTradeItem] > 0) {
			NSString *message = [NSString stringWithFormat:@"You can sell up to %i unit(s).\nYou paid about %i cr. per unit.\nYour %@ per unit is %i cr.\nHow many do you want to sell?\n\n\n\n",
								 sellCargoViewValue[activeTradeItem], ([[[AppDelegate sharedAppDelegate]gamePlayer] getBuyingPrice:activeTradeItem]/sellCargoViewValue[activeTradeItem]), 
								 [[[AppDelegate sharedAppDelegate]gamePlayer] getBuyingPrice:activeTradeItem] / sellCargoViewValue[activeTradeItem] > [[[AppDelegate sharedAppDelegate]gamePlayer] getSellPrice:activeTradeItem] ? 
								 @"loss" : @"profit", ABS([[[AppDelegate sharedAppDelegate]gamePlayer] getBuyingPrice:activeTradeItem] / sellCargoViewValue[activeTradeItem] - [[[AppDelegate sharedAppDelegate]gamePlayer] getSellPrice:activeTradeItem])];
			
			AlertModalWindow *myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Sell Items" yoffset:40 buyValue:sellCargoViewValue[activeTradeItem] 
																		   minValue:1 message:message  
																		   delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Sell"];
			
			[myAlertView show];
			[myAlertView release];			
		}
		else {
			AlertModalWindow *myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Item Not Traded - Dump?" yoffset:40 buyValue:sellCargoViewValue[activeTradeItem] 
																		   minValue:1 message:@"This item is not traded here.\nYou will receive NO CREDITS\nif you dump these items.\nHow many do you want to dump?\n\n\n\n"  
																		   delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Dump"];
			
			[myAlertView show];
			[myAlertView release];			
			bDump = TRUE;
			[[[AppDelegate sharedAppDelegate]gamePlayer] playSpeechFile:@"ItemNotTraded.caf"];

		}
	}
	
}

-(void) pressedCargoMax:(unsigned int) num {
	if (bJettison) {
		[self removeFromSuperview];
		[[[AppDelegate sharedAppDelegate]gamePlayer] sellCargo:num Amount:sellCargoViewValue[num] Operation:SELLCARGO];
		[[[AppDelegate sharedAppDelegate]gamePlayer] continuePlunder];		
	} 
	else 
		if (bOpponent) {
			[self removeFromSuperview];
			[[[AppDelegate sharedAppDelegate]gamePlayer] plunderItems:num count:sellCargoViewValue[num]];
			[[[AppDelegate sharedAppDelegate]gamePlayer] continuePlunder];		
		}
		else {
			[[[AppDelegate sharedAppDelegate]gamePlayer] sellCargo:num Amount:sellCargoViewValue[num] Operation:SELLCARGO];
			[self UpdateView];
		}

}

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
	int button = buttonIndex;
	if (button == 1) {
		unsigned int val = (int)[[(AlertModalWindow*)alertView mySlider]value];
		if (bJettison) {
			[self removeFromSuperview];
			[[[AppDelegate sharedAppDelegate]gamePlayer] sellCargo:activeTradeItem Amount:val Operation:SELLCARGO];
			[[[AppDelegate sharedAppDelegate]gamePlayer] continuePlunder];			
		}
		else if (bOpponent) {
				[self removeFromSuperview];
				[[[AppDelegate sharedAppDelegate]gamePlayer] plunderItems:activeTradeItem count:val];
				[[[AppDelegate sharedAppDelegate]gamePlayer] continuePlunder];
		}
		else if (bDump) {
			[[[AppDelegate sharedAppDelegate]gamePlayer] sellCargo:activeTradeItem Amount:val Operation:DUMPCARGO];
			[self UpdateView];	
		}
		else {
			[[[AppDelegate sharedAppDelegate]gamePlayer] sellCargo:activeTradeItem Amount:val Operation:SELLCARGO];
			[[[AppDelegate sharedAppDelegate]gamePlayer] playSpeechFile:@"ItemSold.caf"];
			[self UpdateView];	
		}
	}
	
}


-(IBAction) pressCargo1  {
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
