//
//  PricesView.m
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

#import "PricesView.h"
#import "AppDelegate.h"
#import "Player.h"


@implementation PricesView

@synthesize water, furs, food, ore, games, firearms, medicine, machines, warpButton;
@synthesize narcotics, robots, bays, resources, absolutePricesButton, cash;
@synthesize systemInfoButton, shortRangeChartButton, galacticChartButton, prevButton, nextButton;		


-(void)dealloc {
	[water release];
	[furs release];
	[food release];
	[ore release];
	[games release];
	[firearms release];
	[medicine release];
	[machines release];
	[narcotics release];
	[robots release];
	[bays release];
	[resources release];
	[absolutePricesButton release];		
	[cash release];
	[warpButton release];
	[systemInfoButton release];
	[shortRangeChartButton release];
	[galacticChartButton release];
	[prevButton release];
	[nextButton release];

	[super dealloc];
}	

-(void)setTheView {
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]leftHandIsOn]) {
		self.resources.frame = CGRectMake(104.0, 9.0, 207.0, 21.0);	
		self.nextButton.frame = CGRectMake(54.0, 2.0, 45.0, 35.0);
		self.prevButton.frame = CGRectMake(4.0, 2.0, 45.0, 35.0);
		self.absolutePricesButton.frame = CGRectMake(150.0, 226.0, 161.0, 32.0);		
		self.systemInfoButton.frame = CGRectMake(150.0, 261.0, 161.0, 32.0);		
		self.shortRangeChartButton.frame = CGRectMake(150.0, 296.0, 161.0, 32.0);		
		self.galacticChartButton.frame = CGRectMake(150.0, 331.0, 161.0, 32.0);		
		self.bays.frame = CGRectMake(10.0, 231.0, 127.0, 21.0);
		self.cash.frame = CGRectMake(10.0, 259.0, 127.0, 21.0);
		self.warpButton.frame = CGRectMake(42.0, 298.0, 82.0, 60.0);
	}
	else {
		self.resources.frame = CGRectMake(10.0, 9.0, 207.0, 21.0);	
		self.nextButton.frame = CGRectMake(270.0, 2.0, 45.0, 35.0);
		self.prevButton.frame = CGRectMake(220.0, 2.0, 45.0, 35.0);
		self.absolutePricesButton.frame = CGRectMake(10.0, 226.0, 161.0, 32.0);		
		self.systemInfoButton.frame = CGRectMake(10.0, 261.0, 161.0, 32.0);		
		self.shortRangeChartButton.frame = CGRectMake(10.0, 296.0, 161.0, 32.0);		
		self.galacticChartButton.frame = CGRectMake(10.0, 331.0, 161.0, 32.0);		
		self.bays.frame = CGRectMake(179.0, 231.0, 127.0, 21.0);
		self.cash.frame = CGRectMake(179.0, 259.0, 127.0, 21.0);
		self.warpButton.frame = CGRectMake(211.0, 298.0, 82.0, 60.0);
	}
	
}


-(void) updateTheView {
	
	[[AppDelegate sharedAppDelegate]updateToolBar];
	[self setTheView];
	
	Player *pPlayer = [[AppDelegate sharedAppDelegate]gamePlayer];
	NSString *tmp;
	tmp = [pPlayer getSolarSystemSpecalResources:pPlayer.warpSystem];
	resources.text  = tmp;
	tmp =  [NSString stringWithFormat:@"Bays: %i/%i", [[[AppDelegate sharedAppDelegate]gamePlayer] filledCargoBays], [[[AppDelegate sharedAppDelegate]gamePlayer] totalCargoBays]];	
	bays.text = tmp; 
	cash.text = [NSString stringWithFormat:@"Cash: %i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer]credits]];		
	
	if (absolutePrices) {
		[absolutePricesButton setTitle:@"Price Differences" forState:UIControlStateNormal];
		[absolutePricesButton setTitle:@"Price Differences" forState:UIControlStateHighlighted];		
	}
	else {
		[absolutePricesButton setTitle:@"Absolute Prices" forState:UIControlStateNormal];
		[absolutePricesButton setTitle:@"Absolute Prices" forState:UIControlStateHighlighted];				
	}

	int bold;
	tmp = [pPlayer getPriceDifference:0 difference:!absolutePrices realPrice:&itemsPrice[0] maxCount:&itemsMax[0] isSmart:&bold];
	water.text = tmp; 
	tmp = [pPlayer getPriceDifference:1 difference:!absolutePrices realPrice:&itemsPrice[1] maxCount:&itemsMax[1] isSmart:&bold];
	food.text = tmp;
	tmp = [pPlayer getPriceDifference:2 difference:!absolutePrices realPrice:&itemsPrice[2] maxCount:&itemsMax[2] isSmart:&bold];
	furs.text = tmp;
	tmp = [pPlayer getPriceDifference:3 difference:!absolutePrices realPrice:&itemsPrice[3] maxCount:&itemsMax[3] isSmart:&bold];
	ore.text = tmp;
	tmp = [pPlayer getPriceDifference:4 difference:!absolutePrices realPrice:&itemsPrice[4] maxCount:&itemsMax[4] isSmart:&bold];
	games.text = tmp;
	tmp = [pPlayer getPriceDifference:5 difference:!absolutePrices realPrice:&itemsPrice[5] maxCount:&itemsMax[5] isSmart:&bold];
	firearms.text = tmp;
	tmp = [pPlayer getPriceDifference:6 difference:!absolutePrices realPrice:&itemsPrice[6] maxCount:&itemsMax[6] isSmart:&bold];
	medicine.text = tmp;
	tmp = [pPlayer getPriceDifference:7 difference:!absolutePrices realPrice:&itemsPrice[7] maxCount:&itemsMax[7] isSmart:&bold];
	machines.text = tmp;
	tmp = [pPlayer getPriceDifference:8 difference:!absolutePrices realPrice:&itemsPrice[8] maxCount:&itemsMax[8] isSmart:&bold];
	narcotics.text = tmp;
	tmp = [pPlayer getPriceDifference:9 difference:!absolutePrices realPrice:&itemsPrice[9] maxCount:&itemsMax[9] isSmart:&bold];
	robots.text = tmp;
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] wormholeTax:[[[AppDelegate sharedAppDelegate]gamePlayer]currentSystem] b:[[[AppDelegate sharedAppDelegate]gamePlayer]warpSystem]] > 0) {
		[self.warpButton setBackgroundImage:[UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"WormHole.png" ofType:nil]] forState:UIControlStateNormal];
	}
	else {
		[self.warpButton setBackgroundImage:[UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"HyperWARP.png" ofType:nil]] forState:UIControlStateNormal];
	}
	
}

- (void)didMoveToWindow {
	absolutePrices = FALSE;
	[super didMoveToWindow];
	[self updateTheView];
}

-(void) pressedCargoMax:(unsigned int) num {
	[[[AppDelegate sharedAppDelegate]gamePlayer] buyCargo:num Amount:itemsMax[num]];
	[self updateTheView];
}

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
	int button = buttonIndex;
	
	if (button == 1) {
		unsigned int val = (int)[[(AlertModalWindow*)alertView mySlider]value];
		[[[AppDelegate sharedAppDelegate]gamePlayer] buyCargo:activeTradeItem Amount:val];
		[self updateTheView];	
	} else if (button == 2) {
		[self pressedCargoMax:activeTradeItem];
	}
	
}

-(void) BuyItem:(int)num {
	activeTradeItem = num;	
	NSString *message = [NSString stringWithFormat:@"At %i credts each, you can\nafford %i unit(s).",[[[AppDelegate sharedAppDelegate]gamePlayer] getBuyPrice:activeTradeItem], itemsMax[activeTradeItem]];
	int alertOffset = 0;
	if([message length] > 36)
		alertOffset = 22;
	int maxQty = [[[AppDelegate sharedAppDelegate]gamePlayer] getAmountToBuy:activeTradeItem];
	int emptyCargoBays = ([[[AppDelegate sharedAppDelegate]gamePlayer]totalCargoBays] - [[[AppDelegate sharedAppDelegate]gamePlayer] filledCargoBays]);
	if (emptyCargoBays <= 0) {
		[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"AllCargoBaysAreFull.caf"];
		UIAlertView *view = [[UIAlertView alloc] initWithTitle:@"Ship Full" message:@"You have no empty cargo bays." delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
		[view show];
		[view release];		
		
	}
	else if (maxQty > 0) {
		message = [message stringByAppendingFormat:@"\nHow many do you want to buy?\n\n\n\n"];	
		AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Buy Items" yoffset:alertOffset 
																		buyValue:min(emptyCargoBays,maxQty) minValue:min(emptyCargoBays,1) message:message  
																		delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Purchase"];
		
		[myAlertView show];
		[myAlertView release];
	}
	else {
		[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"ItemDepleted.caf"];
		UIAlertView *view = [[UIAlertView alloc] initWithTitle:@"Item Depleted" message:@"There are zero units of this item available to purchase." delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
		[view show];
		[view release];		
	}

}


-(IBAction) buyWater {
	[self BuyItem:0];
}

-(IBAction) buyFood {
	[self BuyItem:1];	
}

-(IBAction) buyFurs {
	[self BuyItem:2];	
}

-(IBAction) buyOre {
	[self BuyItem:3];	
}

-(IBAction) buyGames {
	[self BuyItem:4];	
}

-(IBAction) buyFirearms {
	[self BuyItem:5];	
}

-(IBAction) buyMedicine {
	[self BuyItem:6];	
}

-(IBAction) buyMachines {
	[self BuyItem:7];	
}

-(IBAction) buyNarcotics {
	[self BuyItem:8];	
}

-(IBAction) buyRobots {
	[self BuyItem:9];	
}

-(IBAction) showAbsolutePrices {
	absolutePrices = !absolutePrices;
	[self updateTheView];
}


@end
