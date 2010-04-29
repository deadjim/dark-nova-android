//
//  BankViewController.m
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

#import "BankViewController.h"
#import "AppDelegate.h"
#import "Player.h"
#import "AlertModalWindow.h"
#import "SoundManager.h"


@implementation BankViewController

@synthesize	getLoan, makeWithdrawl, makeDeposit;
@synthesize	paybackLoan;
@synthesize	getInsurance;
@synthesize	stopInsurance;
@synthesize	currentDebt;
@synthesize	maximumLoan;
@synthesize	currentShipCost;
@synthesize	noClaim;
@synthesize	insuranceCosts, currentDeposit;
@synthesize	currentCash, actionMode;


-(void)dealloc {
	[getLoan release];
	[makeWithdrawl release];
	[makeDeposit release];
	[paybackLoan release];
	[getInsurance release];
	[stopInsurance release];
	[currentDebt release];
	[maximumLoan release];
	[currentShipCost release];
	[noClaim release];
	[insuranceCosts release];
	[currentCash release];
	[currentDeposit release];

	[super dealloc];
}

-(IBAction)closeViewAction {
	[self dismissModalViewControllerAnimated:YES];
	[[AppDelegate sharedAppDelegate]setGameMode];
}

-(void)viewDidDisappear:(BOOL)animated {
	[super viewDidDisappear:YES];
}

- (void)awakeFromNib {
	self.title = @"Bank";	
}
- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {
		self.title = @"Bank";		
	}
	
	[self updateView];
	
	return self;
}
// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad {
    [super viewDidLoad];
}

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}


-(void)updateView {
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]gesdb] <= 0) {
		makeWithdrawl.hidden = TRUE;
		currentDeposit.text = @"0 cr.";
	}
	else {
		makeWithdrawl.hidden = FALSE;
		currentDeposit.text = [NSString stringWithFormat:@"%i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer]gesdb]];
	}

	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]debt] <= 0) {
		paybackLoan.hidden = TRUE;
		getLoan.hidden = FALSE;
	}
	else {
		paybackLoan.hidden = FALSE;
		if ([[[AppDelegate sharedAppDelegate]gamePlayer]debt] >= [[[AppDelegate sharedAppDelegate]gamePlayer] maxLoan])
			getLoan.hidden = TRUE;
	}
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]insurance]) {
		stopInsurance.hidden = FALSE;
		getInsurance.hidden = TRUE;
	}
	else {
		getInsurance.hidden = FALSE;
		stopInsurance.hidden = TRUE;
	}

	currentDebt.text = [NSString stringWithFormat:@"%i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer]debt]];
	maximumLoan.text = [NSString stringWithFormat:@"%i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer] maxLoan]];
	NSUInteger cost = [[[AppDelegate sharedAppDelegate]gamePlayer] currentShipPriceWithoutCargo:TRUE];
	currentShipCost.text = [NSString stringWithFormat:@"%i cr.", cost ];	
	
	NSUInteger noclaim = min([[[AppDelegate sharedAppDelegate]gamePlayer]noClaim], 90);
	if (noclaim == 90)
		noClaim.text = [NSString stringWithFormat:@"% (maximum)"];				
	else
		noClaim.text = [NSString stringWithFormat:@"%i %% ",noclaim];	
	
	insuranceCosts.text = [NSString stringWithFormat:@"%i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer] insuranceMoney]];	
	currentCash.text = [NSString stringWithFormat:@"Cash: %i cr.", [[[AppDelegate sharedAppDelegate]gamePlayer]credits]];	
}

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex  {
	int button = buttonIndex;
	
	if (actionMode == GETLOANACTION) {
		if (button == 1) {
			unsigned int val = (int)[[(AlertModalWindow*)alertView mySlider]value];
			[[[AppDelegate sharedAppDelegate]gamePlayer] getLoan:val];
		}
	}
	if (actionMode == PAYBACKLOANACTION) {
		if (button == 1) {
			unsigned int val = (int)[[(AlertModalWindow*)alertView mySlider]value];
			[[[AppDelegate sharedAppDelegate]gamePlayer] payBack:val];
		} 
	}
	if(actionMode == STOPINSURANCE && button == 1) {
		[[[AppDelegate sharedAppDelegate]gamePlayer]setInsurance:FALSE];
		[[[AppDelegate sharedAppDelegate]gamePlayer]setNoClaim:0];
		[[SoundManager sharedSound] playSoundWithId:kCancel];
	}
	if(actionMode == MAKEDEPOSIT && button == 1) {
		unsigned int val = (int)[[(AlertModalWindow*)alertView mySlider]value];
		[[[AppDelegate sharedAppDelegate]gamePlayer]makeDeposit:val];
	}
	if(actionMode == MAKEWITHDRAWL && button == 1) {
		unsigned int val = (int)[[(AlertModalWindow*)alertView mySlider]value];
		[[[AppDelegate sharedAppDelegate]gamePlayer]makeWithDrawl:val];
	}
	
	[self updateView];
}

-(IBAction)makeDepositAction {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	NSString * message = [NSString stringWithFormat:@"How much do you want to deposit into your GESDB?\n\n\n\n"];
	
	AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Deposit Cash" yoffset:0 buyValue:([[[AppDelegate sharedAppDelegate]gamePlayer]credits] * .9) 
																	 minValue:([[[AppDelegate sharedAppDelegate]gamePlayer]credits] * .1) message:message  
																	delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Deposit"];
	
	actionMode = MAKEDEPOSIT;
	[myAlertView show];	
	[myAlertView release];
	
}

-(IBAction)makeWithdrawlAction {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	NSString * message = [NSString stringWithFormat:@"How much do you want to withdraw from your GESDB?\n\n\n\n"];
	
	AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Withdraw Cash" yoffset:0 buyValue:[[[AppDelegate sharedAppDelegate]gamePlayer]gesdb] 
																	 minValue:([[[AppDelegate sharedAppDelegate]gamePlayer]gesdb] * .1) message:message  
																	delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Withdraw"];
	
	actionMode = MAKEWITHDRAWL;
	[myAlertView show];	
	[myAlertView release];
	
}

-(IBAction)getLoanAction{
	[[SoundManager sharedSound] playSoundWithId:kPock];
	NSString * message = [NSString stringWithFormat:@"You can borrow up to %i cr.\nHow much do you want?\n\n\n\n", [[[AppDelegate sharedAppDelegate]gamePlayer] maxLoan]];
	
	AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Get Loan" yoffset:0 buyValue:[[[AppDelegate sharedAppDelegate]gamePlayer] maxLoan] 
																	 minValue:([[[AppDelegate sharedAppDelegate]gamePlayer] maxLoan] * .1) message:message  
																	delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Borrow"];

	actionMode = GETLOANACTION;
	[myAlertView show];	
	[myAlertView release];
}

-(IBAction)paybackLoanAction {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	NSString * message = [NSString stringWithFormat:@"You have a debt %i cr.\nHow much do you pay back?\n\n\n\n", [[[AppDelegate sharedAppDelegate]gamePlayer]debt]];
	
	AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Pay Back" yoffset:0 buyValue:[[[AppDelegate sharedAppDelegate]gamePlayer] debt] 
																	 minValue:([[[AppDelegate sharedAppDelegate]gamePlayer] debt] * .1) message:message  
																	delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Pay"];

	actionMode = PAYBACKLOANACTION;
	[myAlertView show];
	[myAlertView release];	
}

-(IBAction)getInsuranceAction {
	actionMode = BUYINSURANCE;
	[[SoundManager sharedSound] playSoundWithId:kPock];
	if (![[[AppDelegate sharedAppDelegate]gamePlayer]escapePod]) {
		UIAlertView *myAlertView = [[UIAlertView alloc] initWithTitle:@"No Escape Pod" message:@"Insurance isn't available for you, since you don't have an escape pod."  
															  delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
		
		[myAlertView show];
		[myAlertView release];			
		[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"EscapePodRequired.caf"];
	}
	else {
		UIAlertView *myAlertView = [[UIAlertView alloc] initWithTitle:@"Insurance" message:@"The daily rate will decrease with each jump, up to a maximum\nof 90% off the initial rate.\nThe No-claim amount is transferred when purchasing a new ship."  
															  delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
		
		[myAlertView show];
		[myAlertView release];			
		
		[[SoundManager sharedSound] playSoundWithId:kBuy];
		[[[AppDelegate sharedAppDelegate]gamePlayer]setInsurance:TRUE];
	}
	[self updateView];	
}

-(IBAction)stopInsuranceAction {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	actionMode = STOPINSURANCE;
	UIAlertView *myAlertView = [[UIAlertView alloc] initWithTitle:@"Stop Insurance" message:@"Do you really wish to stop your insurance and lose your No-claim?"  
																	delegate:self cancelButtonTitle:@"No" otherButtonTitles:@"Yes", nil];

	[myAlertView show];
	[myAlertView release];		
}

@end
