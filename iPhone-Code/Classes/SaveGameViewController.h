//
//  SaveGameViewController.h
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


@interface SaveGameViewController : UIViewController <UITableViewDelegate, UITableViewDataSource, UIAlertViewDelegate> {
	

	NSMutableArray			*menuList;  
	NSMutableArray			*menuName;  	
	NSMutableArray			*menuListAdditional;  
	IBOutlet UIBarButtonItem	*addNewButton;
	IBOutlet UIBarButtonItem	*doneButton;
	IBOutlet UITableView		*myTableView;
	IBOutlet UINavigationBar	*saveBar;
	IBOutlet UINavigationBar	*loadBar;

	BOOL didLoadOrSave;
	BOOL isAutoSaveFile;
	BOOL loadMode;
	BOOL isEditing;
	int activeSaveNumber;
	
}


@property (nonatomic, retain) IBOutlet UITableView *myTableView;
@property (nonatomic, retain) IBOutlet UIBarButtonItem	*addNewButton;
@property (nonatomic, retain) IBOutlet UIBarButtonItem	*doneButton;
@property (nonatomic, retain) IBOutlet UINavigationBar	*saveBar;
@property (nonatomic, retain) IBOutlet UINavigationBar	*loadBar;

-(void)setSaveGameMode;
-(void)setLoadGameMode;
-(void)setRetireMode;

-(IBAction)closeViewAction;
-(IBAction)action:(id)sender;
-(IBAction)editButton;


@end
