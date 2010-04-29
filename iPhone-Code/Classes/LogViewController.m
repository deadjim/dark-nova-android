// 
//  LogViewController.m
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

#import "LogViewController.h"
#import "AppDelegate.h"
#import "Player.h"


@implementation LogViewController

@synthesize text, sizeOftext, saveBar, viewBar;

-(void)dealloc {

	[text release];
	[sizeOftext release];
	[saveBar release];
	[viewBar release];
	
	[super dealloc];
}

-(void)viewDidLoad {
	[super viewDidLoad];
	
	self.text.font = [UIFont systemFontOfSize:15.0];
	self.text.text = [[[AppDelegate sharedAppDelegate]gamePlayer] pilotLog];
	self.sizeOftext.text = [NSString stringWithFormat:@"Current Size: %i", [text.text length]];	
	
}

- (void)viewDidAppear:(BOOL)animated {	
	[super viewDidAppear:animated];
	
}

-(IBAction)enableEditMode {
	self.text.editable = TRUE;
	[self.text becomeFirstResponder];
	self.text.frame = CGRectMake(5.0, 49.0, 310.0, 188.0);
	self.viewBar.hidden = TRUE;
	self.saveBar.hidden = FALSE;

}

-(IBAction)saveLogFile {
	self.text.editable = FALSE;
	[self.text resignFirstResponder];
	self.text.frame = CGRectMake(5.0, 49.0, 310.0, 350.0);
	self.viewBar.hidden = FALSE;
	self.saveBar.hidden = TRUE;
	if ([self.text.text length] > 750) {
		self.text.text = [[text.text substringToIndex:750] retain]; 
	}
	[[[AppDelegate sharedAppDelegate]gamePlayer]setPilotLog:text.text];
	self.sizeOftext.text = [NSString stringWithFormat:@"Current Size: %i", [text.text length]];
}

-(IBAction)closeViewAction {
	[self dismissModalViewControllerAnimated:YES];
}

-(void)viewDidDisappear:(BOOL)animated {
	[super viewDidDisappear:YES];
	self.text.text = nil;
}

-(void)textFieldDidBeginEditing:(UITextField *)textField {
	//NSLog(@"didBeginEditing");
	self.viewBar.hidden = TRUE;
	self.saveBar.hidden = FALSE;
}

-(void)textFieldDidEndEditing:(UITextField *)textField {
	self.viewBar.hidden = FALSE;
	self.saveBar.hidden = TRUE;
}

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}


@end
