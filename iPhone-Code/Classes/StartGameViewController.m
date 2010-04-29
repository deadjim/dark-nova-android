//
//  StartGameViewController.m
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

#import "StartGameViewController.h"
#import "AppDelegate.h"
#import "Player.h"
#import "SoundManager.h"

@implementation StartGameViewController

@synthesize pilotName, difficultyLevel, skillPoints;
@synthesize pilotPointsLabel, fighterPointsLabel, traderPointsLabel, engineerPointsLabel;
@synthesize pilot, fighter, trader, engineer, message;


- (void)dealloc {
	[pilotName release];
	[difficultyLevel release];
	[skillPoints release];
	[pilotPointsLabel release];
	[fighterPointsLabel release];
	[traderPointsLabel release];
	[engineerPointsLabel release];
	[pilot release];
	[fighter release];
	[trader release];
	[engineer release];
	[message release];
	
	[super dealloc];
}

- (IBAction)setDifficulty {
	NSArray *names = [NSArray arrayWithObjects: @"Beginner", @"Easy", @"Normal", @"Hard", @"Impossible", nil];
	difficultyLevel.text = [names objectAtIndex:(int)gameDifficulty.value];

}

- (IBAction)sliderStopped {
	pilotSkill.value = pilotPointsLabel.text.intValue;
	traderSkill.value = traderPointsLabel.text.intValue;
	fighterSkill.value = fighterPointsLabel.text.intValue;
	engineerSkill.value = engineerPointsLabel.text.intValue;
	
	int totalSkillPoints = 0;
	totalSkillPoints += pilotPointsLabel.text.intValue;
	totalSkillPoints += traderPointsLabel.text.intValue;
	totalSkillPoints += fighterPointsLabel.text.intValue;
	totalSkillPoints += engineerPointsLabel.text.intValue;
	if (totalSkillPoints > 20) {
		for (int y = 0; y < (totalSkillPoints-20); y++) {
			if(pilotPointsLabel.text.intValue > 1)
				pilotPointsLabel.text = [NSString stringWithFormat:@"%i", pilotPointsLabel.text.intValue - 1];
			else if(traderPointsLabel.text.intValue > 1)
				traderPointsLabel.text = [NSString stringWithFormat:@"%i", traderPointsLabel.text.intValue - 1];
			else if(fighterPointsLabel.text.intValue > 1)
				fighterPointsLabel.text = [NSString stringWithFormat:@"%i", fighterPointsLabel.text.intValue - 1];
			else if(engineerPointsLabel.text.intValue > 1)
				engineerPointsLabel.text = [NSString stringWithFormat:@"%i", engineerPointsLabel.text.intValue - 1];
		}
		skillPoints.text = @"0";
	}
	if (totalSkillPoints < 20) {
		skillPoints.text = [NSString stringWithFormat:@"%i", (20 - totalSkillPoints)];
	}
	if (totalSkillPoints == 20) {
		skillPoints.text = @"0";
	}
	
}

- (IBAction)sliderAction:(UISlider*)sender {
	
	int totalPoints = skillPoints.text.intValue;
	int sliderValue = (int)[sender value];
	switch ([sender tag]) {
		case 0:
			if (pilotPointsLabel.text.intValue < sliderValue) {
				if (totalPoints > 0) {
					pilotPointsLabel.text = [NSString stringWithFormat:@"%i", sliderValue];
					skillPoints.text = [NSString stringWithFormat:@"%i", (totalPoints - 1)];
				}
			}
			if (pilotPointsLabel.text.intValue > sliderValue) {
				pilotPointsLabel.text = [NSString stringWithFormat:@"%i", sliderValue];
				skillPoints.text = [NSString stringWithFormat:@"%i", (totalPoints + 1)];
			}
			break;
		case 1:
			if (fighterPointsLabel.text.intValue < sliderValue) {
				if (totalPoints > 0) {
					fighterPointsLabel.text = [NSString stringWithFormat:@"%i", sliderValue];
					skillPoints.text = [NSString stringWithFormat:@"%i", (totalPoints - 1)];
				}
			}
			if (fighterPointsLabel.text.intValue > sliderValue) {
				fighterPointsLabel.text = [NSString stringWithFormat:@"%i", sliderValue];
				skillPoints.text = [NSString stringWithFormat:@"%i", (totalPoints + 1)];
			}
			break;
		case 2:
			if (traderPointsLabel.text.intValue < sliderValue) {
				if (totalPoints > 0) {
					traderPointsLabel.text = [NSString stringWithFormat:@"%i", sliderValue];
					skillPoints.text = [NSString stringWithFormat:@"%i", (totalPoints - 1)];
				}
			}
			if (traderPointsLabel.text.intValue > sliderValue) {
				traderPointsLabel.text = [NSString stringWithFormat:@"%i", sliderValue];
				skillPoints.text = [NSString stringWithFormat:@"%i", (totalPoints + 1)];
			}
			break;
		case 3:
			if (engineerPointsLabel.text.intValue < sliderValue) {
				if (totalPoints > 0) {
					engineerPointsLabel.text = [NSString stringWithFormat:@"%i", sliderValue];
					skillPoints.text = [NSString stringWithFormat:@"%i", (totalPoints - 1)];
				}
			}
			if (engineerPointsLabel.text.intValue > sliderValue) {
				engineerPointsLabel.text = [NSString stringWithFormat:@"%i", sliderValue];
				skillPoints.text = [NSString stringWithFormat:@"%i", (totalPoints + 1)];
			}
			break;
		default:
			break;
	}

}

- (IBAction)startGame {
	
	if ((skillPoints.text.intValue == 0) && ![pilotName.text isEqualToString:@""]) {
		[[[AppDelegate sharedAppDelegate]gamePlayer] setPilotName:pilotName.text];
		[[[AppDelegate sharedAppDelegate]gamePlayer] setTraderSkill:traderPointsLabel.text.intValue];
		[[[AppDelegate sharedAppDelegate]gamePlayer] setEngineerSkill:engineerPointsLabel.text.intValue];
		[[[AppDelegate sharedAppDelegate]gamePlayer] setFighterSkill:fighterPointsLabel.text.intValue];
		[[[AppDelegate sharedAppDelegate]gamePlayer] setPilotSkill:pilotPointsLabel.text.intValue];
		[[[AppDelegate sharedAppDelegate]gamePlayer] setTotalSkillPoints:0];
		[[[AppDelegate sharedAppDelegate]gamePlayer] setGameDifficulty:(int)gameDifficulty.value];
		
		[[AppDelegate sharedAppDelegate] switchBarToGame];
		[[[AppDelegate sharedAppDelegate] gamePlayer] startNewGame];
		[[AppDelegate sharedAppDelegate] setCommandView:0];
		[[AppDelegate sharedAppDelegate] commandCommand];

	}
	else {
		if (skillPoints.text.intValue != 0) {
			UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Unused Skill Points" message:@"You haven't awarded all 20 skill points yet."
													   delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles: nil];
			[alert show];
			[alert release];
		}
		else {
			UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Commander Name" message:@"Please enter a commander name."
															delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles: nil];
			[alert show];
			[alert release];
		}
		[[SoundManager sharedSound] playSoundWithId:kCancel];

	}
	
}

-(void)skillAlert {
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Skill Points" message:message
													delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles: nil];
	[alert show];
	[alert release];
}

- (IBAction)pilotInfo {
	message = @"The PILOT skill determines how well you pilot your ship. A high piloting skill will enable you to flee from attacks easily, dodge attacks and to stay on the tail of fleeing ships if you want to keep attacking them. This makes the piloting skill important to traders, transporters and pirates. A navigating system will enhance your piloting capabilities.";
	[self skillAlert];
}

- (IBAction)fighterInfo {
	message = @"The FIGHTER skill determines how well you handle your weapons, in particular, how easy it is for you hit another ship. A trader who isn't interested in a pirating or bounty hunting career hasn't that much use of this skill, but for a pirate it is an absolute must. A targeting system will enhance your fighting capabilities.";
	[self skillAlert];
}

- (IBAction)traderInfo {
	message = @"The TRADER skill determines what prices you must pay for trade goods, ships and equipment. A good trader can reduce prices up to 10%. This makes a high trader skill invaluable for traders, while pirates have less use for it. In the early stages of your life as a trader you might have a hard time getting any money if you work with low trading capabilities.";
	[self skillAlert];
}

- (IBAction)engineerInfo {
	message = @"The ENGINEER skill determines how well you keep your ship in shape. A good engineer may keep your hull and shields intact during a fight, will repair them quicker while traveling and may even enhance your weaponry a bit so it does more damage. This makes the engineer skill important for both traders and pirates. An auto-repair system will enhance the engineering capabilities.";
	[self skillAlert];
}

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}


- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {
		[self.navigationController setNavigationBarHidden:TRUE];
		self.title = @"New Commander";
		
	}
	
	return self;
}

-(void)showCurrentPlayerData {
	
	difficultyLevel.text =@"Normal";
	
	pilotPointsLabel.text = @"1";
	traderPointsLabel.text = @"1";
	engineerPointsLabel.text = @"1";
	fighterPointsLabel.text = @"1";
	skillPoints.text = @"16";
	
}


- (void)viewDidAppear:(BOOL)animated {
	self.title = @"New Commander";

}

- (BOOL)textFieldShouldReturn:(UITextField *)aTextField {
	[pilotName resignFirstResponder];
	return YES;
}

- (void)viewDidLoad {
	[super viewDidLoad];
	[self showCurrentPlayerData];
}
	
@end
