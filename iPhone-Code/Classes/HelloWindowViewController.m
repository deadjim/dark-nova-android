// 
//  HelloWindowViewController.m
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

#import "HelloWindowViewController.h"
#import "StartGameViewController.h"
#import "AppDelegate.h"
#import "Player.h"
#import "SaveGameViewController.h"


@implementation HelloWindowViewController

@synthesize versionText;

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {
		self.title = NSLocalizedString(@"Welcome", @"");
	}
	return self;
}

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}

-(void)viewDidLoad {
	[super viewDidLoad];
	NSString *version = [[[NSBundle mainBundle] infoDictionary] objectForKey:@"CFBuildVersion"];
	versionText.text = [NSString stringWithFormat:@"Build: %@\n©2010 Dead Jim Studios", version];
	
}	

-(void)dealloc {
	[versionText release];
	[super dealloc];
}
@end
