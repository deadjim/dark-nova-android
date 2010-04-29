//
//  WarpSystemInfoView.m
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

#import "WarpSystemInfoView.h"
#import "AppDelegate.h"
#import "Player.h"

@implementation WarpSystemInfoView

@synthesize systemName, systemSize, systemTechLevel, systemGoverment, systemDistance;
@synthesize systemPolice, systemPirates, systemMessage, systemCost, specific, warpButton;
@synthesize nextButton, prevButton, avpButton, shortRangeChartButton, galacticChartButton;		

-(void)dealloc {
	[systemName release];
	[systemSize release];
	[systemTechLevel release];
	[systemGoverment release];
	[systemDistance release];
	[systemPolice release];
	[systemPirates release];
	[systemMessage release];
	[systemCost release];
	[specific release];
	[warpButton release];
	[nextButton release];
	[prevButton release];
	[avpButton release];
	[shortRangeChartButton release];
	[galacticChartButton release];
	
	[super dealloc];
}

-(void)setTheView {
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]leftHandIsOn]) {
		self.nextButton.frame = CGRectMake(54.0, 2.0, 45.0, 35.0);
		self.prevButton.frame = CGRectMake(4.0, 2.0, 45.0, 35.0);
		self.avpButton.frame = CGRectMake(150.0, 261.0, 161.0, 32.0);		
		self.shortRangeChartButton.frame = CGRectMake(150.0, 296.0, 161.0, 32.0);		
		self.galacticChartButton.frame = CGRectMake(150.0, 331.0, 161.0, 32.0);		
		self.warpButton.frame = CGRectMake(42.0, 298.0, 82.0, 60.0);
	}
	else {
		self.nextButton.frame = CGRectMake(270.0, 2.0, 45.0, 35.0);
		self.prevButton.frame = CGRectMake(220.0, 2.0, 45.0, 35.0);
		self.avpButton.frame = CGRectMake(10.0, 261.0, 161.0, 32.0);		
		self.shortRangeChartButton.frame = CGRectMake(10.0, 296.0, 161.0, 32.0);		
		self.galacticChartButton.frame = CGRectMake(10.0, 331.0, 161.0, 32.0);		
		self.warpButton.frame = CGRectMake(211.0, 298.0, 82.0, 60.0);
	}
	
}



-(void) updateTheView {

	[self setTheView];
	NSString *tmp = [[[AppDelegate sharedAppDelegate]gamePlayer] getWarpSystemSize];
	systemSize.text = tmp;
	tmp= [[[AppDelegate sharedAppDelegate]gamePlayer] getWarpSystemTechLevel];	
	systemTechLevel.text = tmp;
	tmp = [[[AppDelegate sharedAppDelegate]gamePlayer] getWarpSystemPolitics];	
	systemGoverment.text = tmp;
	tmp = [[[AppDelegate sharedAppDelegate]gamePlayer] getWarpSystemPirates];
	systemPirates.text = tmp;
	tmp = [[[AppDelegate sharedAppDelegate]gamePlayer] getWarpSystemPolice];
	systemPolice.text = tmp;
	systemDistance.text = [NSString stringWithFormat:@"%i parsecs", [[[AppDelegate sharedAppDelegate]gamePlayer] realDistance: [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemIndex] b:[[[AppDelegate sharedAppDelegate]gamePlayer]warpSystem]]];

	int cost = [[[AppDelegate sharedAppDelegate]gamePlayer] mercenaryMoney] + [[[AppDelegate sharedAppDelegate]gamePlayer] insuranceMoney] + [[[AppDelegate sharedAppDelegate]gamePlayer] wormholeTax:[[[AppDelegate sharedAppDelegate]gamePlayer]currentSystem]  b:[[[AppDelegate sharedAppDelegate]gamePlayer]warpSystem]];
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]debt] > 0) {
		int IncDebt = max(1, [[[AppDelegate sharedAppDelegate]gamePlayer]debt] / 10);
		cost += IncDebt;
	}
	systemCost.text = [NSString stringWithFormat:@"%i cr.", cost];

	if ([[[AppDelegate sharedAppDelegate]gamePlayer] wormholeTax:[[[AppDelegate sharedAppDelegate]gamePlayer]currentSystem] b:[[[AppDelegate sharedAppDelegate]gamePlayer]warpSystem]] > 0) {
		[self.warpButton setBackgroundImage:[UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"WormHole.png" ofType:nil]] forState:UIControlStateNormal];
	}
	else {
		[self.warpButton setBackgroundImage:[UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"HyperWARP.png" ofType:nil]] forState:UIControlStateNormal];
	}
		
}

- (void)didMoveToWindow {
	[super didMoveToWindow];
	[self updateTheView];
}

-(IBAction) pressSpecific {
	int cost = [[[AppDelegate sharedAppDelegate]gamePlayer] mercenaryMoney] + [[[AppDelegate sharedAppDelegate]gamePlayer] insuranceMoney] + [[[AppDelegate sharedAppDelegate]gamePlayer] wormholeTax:[[[AppDelegate sharedAppDelegate]gamePlayer]currentSystem]  b:[[[AppDelegate sharedAppDelegate]gamePlayer]warpSystem]];
	
	int IncDebt = 0;
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]debt] > 0)
	{
		IncDebt =  max(1, [[[AppDelegate sharedAppDelegate]gamePlayer]debt] / 10);
		cost += IncDebt;
	}

	NSString *message = [NSString stringWithFormat:@"Mercenaries: %i cr.\nInsurance: %i cr.\nInterest: %i cr.\nWormhole Tax: %i cr.\n\nTotal: %i cr.",
						  [[[AppDelegate sharedAppDelegate]gamePlayer] mercenaryMoney], [[[AppDelegate sharedAppDelegate]gamePlayer] insuranceMoney], IncDebt,  [[[AppDelegate sharedAppDelegate]gamePlayer] wormholeTax:[[[AppDelegate sharedAppDelegate]gamePlayer]currentSystem] b:[[[AppDelegate sharedAppDelegate]gamePlayer]warpSystem]], cost];
	UIAlertView *myAlertView = [[UIAlertView alloc] initWithTitle:@"Specification" message:message delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
	
	[myAlertView show];
	[myAlertView release];
}

@end
