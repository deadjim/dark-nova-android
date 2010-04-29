//
//  SystemInfoViewController.m
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

#import "SystemInfoViewController.h"
#import "AppDelegate.h"
#import "Player.h"
#import "CommandViewController.h"
#import "NewsViewController.h"
#import "GPTAViewController.h"

@implementation SystemInfoViewController

@synthesize systemName, systemSize, systemTechLevel, systemGoverment, systemResources, systemPolice;	
@synthesize systemPirates, systemMessage, systemNews, systemHire, systemSpecial, systemPassengers;	


-(void)dealloc {

	[systemName release];
	[systemSize release];
	[systemTechLevel release];
	[systemGoverment release];
	[systemResources release];
	[systemPolice release];
	[systemPirates release];
	[systemMessage release];
	[systemNews release];
	[systemHire release];
	[systemSpecial release];
	[systemPassengers release];
	
	[super dealloc];
}

-(void) updateInfoView {

	[[AppDelegate sharedAppDelegate]updateToolBar];

	self.systemName.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemName];
	self.systemSize.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemSize];
	self.systemTechLevel.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemTechLevel];	
	self.systemGoverment.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemPolitics];	
	self.systemPirates.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemPirates];
	self.systemPolice.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemPolice];
	self.systemResources.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemSpecalResources];
	self.systemMessage.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemStatus];
	
	self.systemNews.hidden = TRUE;
	self.systemHire.hidden = TRUE;
	self.systemSpecial.hidden = TRUE;
	self.systemPassengers.hidden = TRUE;
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] doesNewsExist])
		self.systemNews.hidden = FALSE;
		
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] doesHireExist])
		self.systemHire.hidden = FALSE;
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] doesSpecialExist])
		self.systemSpecial.hidden = FALSE;
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] okayToTransportPassengers] && ![[[AppDelegate sharedAppDelegate]gamePlayer]transportPassengers])
		self.systemPassengers.hidden = FALSE;
	
	
}

- (void)viewDidAppear:(BOOL)animated {
	[super viewDidAppear:animated];
	[self updateInfoView];
}

- (void)loadView {
	[super loadView];
	[self updateInfoView];
}

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {
		self.title = @"System Info";				
	}
	
	return self;
}

// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad {
    [super viewDidLoad];
    
    UIBarButtonItem *backBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@"Back" style:UIBarButtonItemStyleBordered target:nil action:nil];
    self.navigationItem.backBarButtonItem = backBarButtonItem;
    [backBarButtonItem release];
}

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}


-(IBAction)doQuests {
	[[[AppDelegate sharedAppDelegate]gamePlayer] drawQuestsForm:self];
}

-(void)showNewsView {	
	[[[AppDelegate sharedAppDelegate]gamePlayer] payForNewsPaper:1];
	NewsViewController *targetViewController = [[NewsViewController alloc] initWithNibName:@"News"  bundle:nil];
	[self.navigationController pushViewController:targetViewController animated:YES];
	targetViewController.text.text = [[[AppDelegate sharedAppDelegate]gamePlayer] drawNewspaperForm];
	[targetViewController release];
}


-(IBAction)showNews {
	if (![[[AppDelegate sharedAppDelegate]gamePlayer]alreadyPaidForNewspaper] && [[[AppDelegate sharedAppDelegate]gamePlayer] toSpend] < (([[[AppDelegate sharedAppDelegate]gamePlayer]gameDifficulty] + 1)*3))
		[[[AppDelegate sharedAppDelegate]gamePlayer] cannotAffordNews];
	else {
		if (![[[AppDelegate sharedAppDelegate]gamePlayer]newsAutoPay] && ![[[AppDelegate sharedAppDelegate]gamePlayer]alreadyPaidForNewspaper]) {
			UIAlertView * alert = [[UIAlertView alloc] initWithTitle:@"Purchase News?" message:[NSString stringWithFormat:@"The Local Electronic News (LEN) costs %i credits. Do you want to purchase and download a copy?", 
																								([[[AppDelegate sharedAppDelegate]gamePlayer]gameDifficulty] + 1)*3] delegate:self cancelButtonTitle:@"No" otherButtonTitles:@"Yes", nil];
			[alert setTag:1];
			[alert show];
			[alert release];
		} else 
			[self showNewsView];
	}
}


-(IBAction)showPassengerAction {
	int emptyCargoBays = ([[[AppDelegate sharedAppDelegate]gamePlayer]totalCargoBays] - [[[AppDelegate sharedAppDelegate]gamePlayer] filledCargoBays]);
	int numOfPassengers = [[[AppDelegate sharedAppDelegate]gamePlayer]numberOfPassengers];
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]agreedToGPTA]) {
		if ([[[AppDelegate sharedAppDelegate]gamePlayer]shipIsInfected]) {
			UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Ship Quarantined" 
															message:[NSString stringWithFormat:@"Your ship is infested and has been denied access to the passenger transport area. Once you remove the infestation you will be allowed access to the passenger area."] 
														   delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles: nil];
			[alert show];
			[alert release];
			[[[AppDelegate sharedAppDelegate]gamePlayer]showUserNotice:aAlert];		
		}
		else if (emptyCargoBays > (numOfPassengers * BAYSPERPASSNGR)) {
			[[[AppDelegate sharedAppDelegate]gamePlayer]showPassengers];		
			[[[AppDelegate sharedAppDelegate]gamePlayer]setInfoViewController:self];	
		}
		else {
			UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Cargo Bays" 
															message:[NSString stringWithFormat:@"You do not have enough empty cargo bays. GPTA rules state %i cargo bays per passenger. You need %i empty cargo bays to transport %i passengers.", BAYSPERPASSNGR, (numOfPassengers * BAYSPERPASSNGR), numOfPassengers] 
														   delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles: nil];
			[alert show];
			[alert release];
			[[[AppDelegate sharedAppDelegate]gamePlayer]showUserNotice:aAlert];		
		}
	}
	else {
		UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"GPTA Terms" 
														message:[NSString stringWithFormat:@"You must agree to Galactic Passenger Transport Association (GPTA) terms and conditions. The full agreement can be found under Commander Status - GPTA Agreement."] 
													   delegate:self cancelButtonTitle:@"Cancel" otherButtonTitles:@"Agree", nil];
		[alert setTag:2];
		[alert show];
		[alert release];
		[[[AppDelegate sharedAppDelegate]gamePlayer]showUserNotice:aAlert];		
	}

}

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
	
	if ([alertView tag] == 1) {    
        if (buttonIndex == 1) {    
            [self showNewsView];
        }
	}
	if ([alertView tag] == 2) {    
        if (buttonIndex == 1) {     
			[[[AppDelegate sharedAppDelegate]gamePlayer] setAgreedToGPTA:TRUE];
			[self showPassengerAction];
        }
	}
}

-(IBAction)showHire {
	[[[AppDelegate sharedAppDelegate]commandView] personnelRoster];
}

-(IBAction)showSpecial {
	[[[AppDelegate sharedAppDelegate]gamePlayer]showSpecialEvent];
	[[[AppDelegate sharedAppDelegate]gamePlayer]setInfoViewController:self];	
	[self updateInfoView];
}


@end
