// 
//  GameOptionsViewController.h
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

#import <UIKit/UIKit.h>
#import "SaveGameViewController.h"


@protocol GameOptionsViewControllerDelegate;


@interface GameOptionsViewController : UIViewController <UITableViewDelegate, UITableViewDataSource, 
UIAlertViewDelegate> {
	id <GameOptionsViewControllerDelegate> delegate;

	UIAlertView				*retireAlert;
	
	NSString *deviceType;
	NSArray *tableList;
	IBOutlet UITableView *myTableView;

	IBOutlet UITableViewCell			*cell0;
	IBOutlet UITableViewCell			*cell1;
	IBOutlet UITableViewCell			*cell2;
	IBOutlet UITableViewCell			*cell3;
	IBOutlet UITableViewCell			*cell4;
	IBOutlet UITableViewCell			*cell5;
	IBOutlet UITableViewCell			*cell6;
	IBOutlet UITableViewCell			*cell7;
	

}

@property (nonatomic, retain) NSString *deviceType;
@property (nonatomic, retain) NSArray *tableList;
@property (nonatomic, retain) UITableView *myTableView;

@property (nonatomic, retain) IBOutlet UITableViewCell *cell0;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell1;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell2;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell3;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell4;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell5;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell6;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell7;

@property (nonatomic, assign) id <GameOptionsViewControllerDelegate> delegate;

- (IBAction)done;

@end

@protocol GameOptionsViewControllerDelegate
- (void)gameOptionsViewControllerDidFinish:(GameOptionsViewController *)controller;
@end

