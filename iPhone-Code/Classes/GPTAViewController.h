// 
//  GPTAViewController.h
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

@interface GPTAViewController : UIViewController {
    IBOutlet UITextView *text;
	IBOutlet UIButton *agreeToTermsButton;
	IBOutlet UIButton *fingerScanner;
	IBOutlet UILabel *scanText;
	IBOutlet UILabel *scannerButtonText;

}

@property (nonatomic, retain) IBOutlet IBOutlet UIButton *agreeToTermsButton;
@property (nonatomic, retain) IBOutlet IBOutlet UIButton *fingerScanner;
@property (nonatomic, retain) IBOutlet UITextView *text;
@property (nonatomic, retain) IBOutlet UILabel *scanText;
@property (nonatomic, retain) IBOutlet UILabel *scannerButtonText;

-(IBAction)agreeToTerms;
-(IBAction)closeViewAction;
-(IBAction)holdFingerPad;
-(IBAction)pressedFingerPad;


@end
