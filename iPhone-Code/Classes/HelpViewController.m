// 
//  HelpViewController.m
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

#import "HelpViewController.h"
#import "AppDelegate.h"

@implementation HelpViewController

@synthesize navBar, webView, location, theTitle, fullSize;

-(IBAction)closeViewAction {
	[self dismissModalViewControllerAnimated:YES];
}

-(void)viewDidDisappear:(BOOL)animated {
	[super viewDidDisappear:YES];
}

-(void)dealloc {
	[navBar release];
	[webView release];
	[location release];
	[theTitle release];
	
	[super dealloc];	
}

-(void)viewDidLoad {
	[super viewDidLoad];

	if(![[AppDelegate sharedAppDelegate]fromOptions]) {
		self.navBar.hidden = TRUE;
		self.webView.frame = CGRectMake(0.0, 0.0, 320.0, 418.0);
	}
	[webView loadRequest:[NSURLRequest requestWithURL:location]];

}


- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}

@end
