// 
//  GPTAViewController.m
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

#import "GPTAViewController.h"
#import "AppDelegate.h"
#import "Player.h"
#import "SoundManager.h"


@implementation GPTAViewController

@synthesize text, agreeToTermsButton, fingerScanner, scanText, scannerButtonText;

-(void)dealloc {

	[text release];
	[agreeToTermsButton release];
	[fingerScanner release];
	[scanText release];
	[scannerButtonText release];
	
	[super dealloc];
}

-(void)compressTheView {
	self.scannerButtonText.hidden = FALSE;
	self.agreeToTermsButton.hidden = TRUE;
	self.fingerScanner.hidden = FALSE;
	self.text.font = [UIFont systemFontOfSize:12.5];
	self.scanText.text = @"Notice: Fingerprint scan is required";
}	
	
-(void)expandTheView {
	self.scannerButtonText.hidden = TRUE;
	self.agreeToTermsButton.hidden = TRUE;
	self.fingerScanner.hidden = TRUE;
	self.scanText.text = @"Notice: Fingerprint scan on file";
	self.text.frame = CGRectMake(5.0, 3.0, 310.0, 335.0);
	self.text.font = [UIFont systemFontOfSize:14.0];
}	

-(void)viewDidLoad {
	[super viewDidLoad];
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] agreedToGPTA]) {
		[self expandTheView];
	}
	else {
		[self compressTheView];
	}	
}

- (void)viewDidAppear:(BOOL)animated {	
	[super viewDidAppear:animated];
	
}

-(void)unHideButton {
	self.agreeToTermsButton.hidden = FALSE;
	[[SoundManager sharedSound] playSoundWithId:kBuy];
	
}

-(IBAction)pressedFingerPad {
	[NSObject cancelPreviousPerformRequestsWithTarget:self selector:@selector(unHideButton) object:nil];

}

-(IBAction)holdFingerPad {
	[self performSelector:@selector(unHideButton) withObject:nil afterDelay:0.9];
	[[SoundManager sharedSound] playSoundWithId:kTribble];
}

-(IBAction)agreeToTerms {
	[[[AppDelegate sharedAppDelegate]gamePlayer] setAgreedToGPTA:TRUE];
	[[SoundManager sharedSound] playSoundWithId:kCancel];
	[self expandTheView];
//	[self dismissModalViewControllerAnimated:YES];
}

-(IBAction)closeViewAction {
	//[self dismissModalViewControllerAnimated:YES];
}


- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}


@end
