//
//  SystemInfoViewController.h
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


@interface SystemInfoViewController : UIViewController<UINavigationBarDelegate> {
	
	IBOutlet UILabel *systemName;
	IBOutlet UILabel *systemSize;
	IBOutlet UILabel *systemTechLevel;
	IBOutlet UILabel *systemGoverment;
	IBOutlet UILabel *systemResources;
	IBOutlet UILabel *systemPolice;	
	IBOutlet UILabel *systemPirates;
	IBOutlet UITextView *systemMessage;
	IBOutlet UIButton *systemNews;
	IBOutlet UIButton *systemHire;
	IBOutlet UIButton *systemSpecial;	
	IBOutlet UIButton *systemPassengers;	


}

@property (nonatomic, retain) IBOutlet UILabel *systemName;
@property (nonatomic, retain) IBOutlet UILabel *systemSize;
@property (nonatomic, retain) IBOutlet UILabel *systemTechLevel;
@property (nonatomic, retain) IBOutlet UILabel *systemGoverment;
@property (nonatomic, retain) IBOutlet UILabel *systemResources;
@property (nonatomic, retain) IBOutlet UILabel *systemPolice;	
@property (nonatomic, retain) IBOutlet UILabel *systemPirates;
@property (nonatomic, retain) IBOutlet UITextView *systemMessage;
@property (nonatomic, retain) IBOutlet UIButton *systemNews;
@property (nonatomic, retain) IBOutlet UIButton *systemHire;
@property (nonatomic, retain) IBOutlet UIButton *systemSpecial;	
@property (nonatomic, retain) IBOutlet UIButton *systemPassengers;	

-(IBAction)doQuests;
-(IBAction)showNews;
-(IBAction)showHire;
-(IBAction)showSpecial;
-(IBAction)showPassengerAction;

-(void) updateInfoView;


@end
