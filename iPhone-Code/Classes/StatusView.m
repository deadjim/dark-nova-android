//
//  StatusView.m
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

#import "StatusView.h"
#import "AppDelegate.h"
#import "Player.h"


@implementation StatusView

@synthesize pilotName, pilotSkill, traderSkill, fighterSkill, engineerSkill, kills, time;
@synthesize cash, debt, netWorth, reputation, policeRecord, difficulty, transport;
@synthesize totalPEPPassengers, totalPassengers;


-(void)dealloc {

	[pilotName release];
	[pilotSkill release];
	[traderSkill release];
	[fighterSkill release];
	[engineerSkill release];
	[kills release];
	[time release];
	[cash release];
	[debt release];
	[netWorth release];
	[reputation release];
	[policeRecord release];
	[difficulty release];
	[transport release];
	[totalPassengers release];
	[totalPEPPassengers release];
	
	[super dealloc];
	
}

	
-(void)updateView {
	
	self.pilotName.text = [[[AppDelegate sharedAppDelegate]gamePlayer]pilotName];
	self.pilotSkill.text = 	[NSString stringWithFormat:@"%i[%i]", [[[AppDelegate sharedAppDelegate]gamePlayer]pilotSkill], [[[AppDelegate sharedAppDelegate]gamePlayer] adaptPilotSkill]];
	self.traderSkill.text = 	[NSString stringWithFormat:@"%i[%i]", [[[AppDelegate sharedAppDelegate]gamePlayer]traderSkill], [[[AppDelegate sharedAppDelegate]gamePlayer] adaptTraderSkill]];
	self.fighterSkill.text = 	[NSString stringWithFormat:@"%i[%i]", [[[AppDelegate sharedAppDelegate]gamePlayer]fighterSkill], [[[AppDelegate sharedAppDelegate]gamePlayer] adaptFighterSkill]];
	self.engineerSkill.text = 	[NSString stringWithFormat:@"%i[%i]", [[[AppDelegate sharedAppDelegate]gamePlayer]engineerSkill], [[[AppDelegate sharedAppDelegate]gamePlayer] adaptEngineerSkill]];						 
	self.cash.text = [NSString stringWithFormat:@"%i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer]credits]];
	self.debt.text = [NSString stringWithFormat:@"%i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer]debt]];
	self.kills.text = [NSString stringWithFormat:@"%i", [[[AppDelegate sharedAppDelegate]gamePlayer]policeKills] + [[[AppDelegate sharedAppDelegate]gamePlayer]traderKills] + [[[AppDelegate sharedAppDelegate]gamePlayer]pirateKills]];
	self.time.text = [NSString stringWithFormat:@"%i days", [[[AppDelegate sharedAppDelegate]gamePlayer]days]];						 
	NSArray * names = [NSArray arrayWithObjects: @"Beginner", @"Easy", @"Normal", @"Hard", @"Impossible", nil];
	self.difficulty.text = [names objectAtIndex:[[[AppDelegate sharedAppDelegate]gamePlayer]gameDifficulty]];
	self.netWorth.text = [NSString stringWithFormat:@"%i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer] currentNetWorth]];
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] okayToTransportPassengers])
		self.transport.text = @"Valid";
	else 
		self.transport.text = @"Invalid";
		
	self.totalPassengers.text = [NSString stringWithFormat:@"%i", [[[AppDelegate sharedAppDelegate]gamePlayer] totalPassengers]];							 
	self.totalPEPPassengers.text = [NSString stringWithFormat:@"%i", [[[AppDelegate sharedAppDelegate]gamePlayer] totalPEPPassengers]];							 

	self.reputation.text = [[[AppDelegate sharedAppDelegate]gamePlayer] currentReputation];							 
	self.policeRecord.text = [[[AppDelegate sharedAppDelegate]gamePlayer] currentPoliceRecord];							 
}


-(void)viewDidAppear {
	[self updateView];
	
}

- (void)didMoveToWindow {
	[super didMoveToWindow];
	[self updateView];
}
@end
