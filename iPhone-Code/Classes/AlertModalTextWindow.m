//
//  AlertModalTextWindow.m
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

#import "AlertModalTextWindow.h"


@implementation AlertModalTextWindow

@synthesize myTextField, pressedButton;

+(void)initialize {
	[super initialize];
}

- (id)initWithTitle:(NSString *)title yoffset:(int)yoffset  message:(NSString *)message delegate:(id)delegate cancelButtonTitle:(NSString *)cancelButtonTitle okButtonTitle:(NSString *)okButtonTitle thirdButtonTitle:(NSString*)thirdButtonTitle {
	[self initWithTitle:title message:message delegate:delegate cancelButtonTitle:cancelButtonTitle otherButtonTitles:okButtonTitle, thirdButtonTitle, nil];
	myTextField = [[UITextField alloc] initWithFrame:CGRectMake(12.0, yoffset, 260.0, 25.0)];
	[myTextField setBackgroundColor:[UIColor whiteColor]];
	
	myTextField.returnKeyType = UIReturnKeyDone;
	myTextField.keyboardAppearance = UIKeyboardAppearanceAlert;
	myTextField.keyboardType = UIKeyboardTypeAlphabet;
	myTextField.delegate = self;
	
	myTextField.autocorrectionType = UITextAutocorrectionTypeNo;
	myTextField.enablesReturnKeyAutomatically = TRUE;
	
	[self addSubview:myTextField];
	
	[myTextField becomeFirstResponder];
	
	[myTextField release];
	
	CGAffineTransform myTransform = CGAffineTransformMakeTranslation(0.0, 50.0);
	[self setTransform:myTransform];	
	
	return self;
}


-(void)dealloc {
	[super dealloc];
}

-(void)okayToDismiss {
	[myTextField resignFirstResponder];
	[myTextField removeFromSuperview];
}

-(void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
	[myTextField resignFirstResponder];
	[myTextField removeFromSuperview];	
	pressedButton = buttonIndex;
}


- (BOOL)textFieldShouldReturn:(UITextField *)aTextField {
	[myTextField resignFirstResponder];
	return YES;
}

@end
