// 
//  EndOfGameViewController.m
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


#import "EndOfGameViewController.h"
#import "AppDelegate.h"
#import "StartGameViewController.h"
#import "HighScoresViewController.h"
#import "SoundManager.h"


@implementation EndOfGameViewController

@synthesize background;

-(void)viewDidLoad {
	[super viewDidLoad];
	
}

-(void)viewDidUnload {
	[super viewDidUnload];
	background.image = nil;
}

-(void)dealloc {
	[background release];
	[super dealloc];	
}

-(void)showShipDestroyedImage {
	background.image = [UIImage imageNamed:@"YouDied.jpg"];
	status = 0;
	[[[AppDelegate sharedAppDelegate] gamePlayer]playSoundFile:@"Lose.caf"];
	[[[AppDelegate sharedAppDelegate] gamePlayer] eraseAutoSave];
}

-(void)showPoorEndGameImage {
	background.image = [UIImage imageNamed:@"RetirePoorly.jpg"];
	status = 1;
	[[[AppDelegate sharedAppDelegate] gamePlayer]playSoundFile:@"RetirePoorly.caf"];
	[[[AppDelegate sharedAppDelegate] gamePlayer] eraseAutoSave];
}

-(void)showHappyEndImage {
	background.image = [UIImage imageNamed:@"RetireLavishly.jpg"];
	status = 2;
	[[[AppDelegate sharedAppDelegate] gamePlayer]playSoundFile:@"RetireLavishly.caf"];
	[[[AppDelegate sharedAppDelegate] gamePlayer] eraseAutoSave];
}

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}

-(IBAction) startNewGame {
	background.image = nil;
	[self.view removeFromSuperview];
	
	BOOL highScore = [[[AppDelegate sharedAppDelegate] gamePlayer] endOfGame:status];
	[[AppDelegate sharedAppDelegate]setFromOptions:FALSE];
	[[AppDelegate sharedAppDelegate]showStartGame];
	[[AppDelegate sharedAppDelegate]hideBadges];

	if (highScore) {
		UIViewController* highScores = [[HighScoresViewController alloc] initWithNibName:@"HighScores" bundle:nil];;
		[[[AppDelegate sharedAppDelegate] navigationController] pushViewController:highScores animated:TRUE];
		[highScores release];
	}
}

@end
