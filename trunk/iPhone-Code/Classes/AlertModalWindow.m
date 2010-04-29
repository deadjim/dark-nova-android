//
//  AlertModalWindow.m
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

#import "AlertModalWindow.h"


@implementation AlertModalWindow

@synthesize pressedButton, myLabel, mySlider, sliderValue;

+(void)initialize
{
	[super initialize];
}

- (void)sliderAction:(UISlider*)sender {
	myLabel.text = [NSString stringWithFormat:@"Selected Amount: %i", (int)[sender value]];
}


- (id)initWithTitle:(NSString *)title yoffset:(int)yoffset buyValue:(int)buyValue minValue:(int)minValue message:(NSString *)message delegate:(id)delegate cancelButtonTitle:(NSString *)cancelButtonTitle okButtonTitle:(NSString *)okButtonTitle {
	[self initWithTitle:title message:message delegate:delegate cancelButtonTitle:cancelButtonTitle otherButtonTitles:okButtonTitle, nil];
	
	mySlider = [[UISlider alloc] initWithFrame:CGRectMake(30, yoffset+100, 220, 50)];
	mySlider.minimumValue = (float)minValue;
	
	mySlider.maximumValue = (float)buyValue;
	mySlider.tag = 0;
	if (yoffset == 23) {
		mySlider.value = 0;
	}
	else {
		mySlider.value = mySlider.maximumValue;
	}
	
	mySlider.continuous = YES;
	[mySlider addTarget:self action:@selector(sliderAction:) forControlEvents:UIControlEventValueChanged];
	
	myLabel = [[UILabel alloc] initWithFrame:CGRectMake(20, yoffset+88, 240, 22)];
	myLabel.backgroundColor = [UIColor clearColor];
	myLabel.textColor = [UIColor whiteColor];
	myLabel.font = [UIFont systemFontOfSize:16];
	myLabel.textAlignment = UITextAlignmentCenter;
	if (yoffset == 23) {
		myLabel.text = [NSString stringWithFormat:@"Selected Amount: %i", mySlider.value];
	}
	else {
		myLabel.text = [NSString stringWithFormat:@"Selected Amount: %i", buyValue];
	}
	[self addSubview: mySlider];
	[self addSubview:myLabel];
	
	[myLabel release];
	[mySlider release];
	
	return self;
}

-(void)dealloc {
	[super dealloc];
}


- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
	pressedButton = buttonIndex;
}


@end
