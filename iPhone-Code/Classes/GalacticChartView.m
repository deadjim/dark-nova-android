// 
//  GalacticChartView.m
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

#import "GalacticChartView.h"
#import "AppDelegate.h"
#import "Player.h"
#import "GalacticChartViewController.h"


@implementation GalacticChartView

@synthesize nextSystem, prevSystem, jumpButton, systemName, systemType;	
@synthesize cheatSystems, cheatQuests;

-(void)dealloc {
	
	[nextSystem release];
	[prevSystem release];
	[jumpButton release];
	[systemName release];
	[systemType release];
	[cheatQuests release];
	[cheatSystems release];

	[super dealloc];
}

-(void)WinDrawLine:(CGContextRef)context x1:(int)x1 y1:(int)y1 x2:(int)x2 y2:(int)y2 {
	CGContextMoveToPoint(context, x1, y1);
	CGContextAddLineToPoint(context, x2, y2);
	CGContextStrokePath(context);
}


-(void)drawView:(CGContextRef)context bounds:(CGRect)bounds {
	
	Index = [[[AppDelegate sharedAppDelegate]gamePlayer]currentGalaxySystem];
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]canSuperWarp])
		jumpButton.hidden = FALSE;
	else
		jumpButton.hidden = TRUE;
	
	CGContextDrawImage(context,  CGRectMake(0, 44,  backgroundSize.width, backgroundSize.height) , background);
	CGContextSetRGBStrokeColor(context, 1.0, 1.0, 1.0, 1.0);
	CGContextSetLineWidth(context, 2.0);	
	
	
	int Xs = (int)((float)[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:[[[AppDelegate sharedAppDelegate]gamePlayer]currentSystem]]*1.8)+GALAXYBOUNDSX-EXTRAERASE+greenDotSize.width/2+2;
	int Ys = (int)((float)[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:[[[AppDelegate sharedAppDelegate]gamePlayer]currentSystem]]*2.8)+GALAXYBOUNDSY-EXTRAERASE+greenDotSize.height/2+2;
	
	int fuel = [[[AppDelegate sharedAppDelegate]gamePlayer] getFuel];
	float delta = 2.2;
	if (fuel) {
		CGContextAddArc(context, Xs, Ys,  fuel * delta + 2.8, 0, 2*3.1416f, 1);
	}
	
	CGContextStrokePath(context);

	int i;
	for (i=0; i<MAXSOLARSYSTEM; ++i) {
		int Xp = (int)((float)[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:i]*1.8);
		int Yp = (int)((float)[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:i]*2.8);
		
		if ([[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemVisited:i]) {
			CGContextDrawImage(context,  CGRectMake(Xp+GALAXYBOUNDSX-EXTRAERASE, Yp+GALAXYBOUNDSY-EXTRAERASE,  blueDotSize.width, blueDotSize.height) , blueDot);
			
		} else {
			CGContextDrawImage(context,  CGRectMake(Xp+GALAXYBOUNDSX-EXTRAERASE, Yp+GALAXYBOUNDSY-EXTRAERASE, greenDotSize.width, greenDotSize.height) , greenDot);						
		}
		
		if (i == [[[AppDelegate sharedAppDelegate]gamePlayer]trackedSystem] || i == [[[AppDelegate sharedAppDelegate]gamePlayer]currentGalaxySystem])
		{
			CGContextDrawImage(context,  CGRectMake(Xp+GALAXYBOUNDSX-EXTRAERASE-4, Yp+GALAXYBOUNDSY-EXTRAERASE-4, targetDotSize.width+8, targetDotSize.height+8) , targetDot);
		}
		
		if ([[[AppDelegate sharedAppDelegate]gamePlayer] wormholeExists:i b:-1])
			CGContextDrawImage(context,  CGRectMake(Xp+GALAXYBOUNDSX-EXTRAERASE+2+WORMHOLEDISTANCE, Yp+GALAXYBOUNDSY-EXTRAERASE+1, redDotSize.width, redDotSize.height) , redDot);				

		
		CGContextStrokePath(context);		

	}
	
	long distToTracked = [[[AppDelegate sharedAppDelegate]gamePlayer] realDistance:[[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemIndex] b:[[[AppDelegate sharedAppDelegate]gamePlayer]currentGalaxySystem]];
	systemName.text = [NSString stringWithFormat:@"%@ %i parsecs",[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemName:[[[AppDelegate sharedAppDelegate]gamePlayer]currentGalaxySystem]], distToTracked];
	systemType.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getSystemTechLevel:[[[AppDelegate sharedAppDelegate]gamePlayer]currentGalaxySystem]];
	
}

-(void)drawRect:(CGRect)rect {
	[self drawView:UIGraphicsGetCurrentContext() bounds:self.bounds];
}

- (void)didMoveToWindow {
	[super didMoveToWindow];
	[self setNeedsDisplay];
}


- (id)initWithCoder:(NSCoder*)coder 
{
	if (self = [super initWithCoder:coder]) {
		
		self.backgroundColor = [UIColor blackColor];
		{
			UIImage *img = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"Galaxy.jpg" ofType:nil]];
			background = CGImageRetain(img.CGImage);
			backgroundSize = img.size;
		}
		
		{
			UIImage *img = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"Dot_Target.png" ofType:nil]];
			targetDot = CGImageRetain(img.CGImage);
			targetDotSize = img.size;
		}

		{
			UIImage *img = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"Dot_Wormhole.png" ofType:nil]];
			redDot = CGImageRetain(img.CGImage);
			redDotSize = img.size;
		}
		
		{
			UIImage *img = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"Dot.png" ofType:nil]];
			greenDot = CGImageRetain(img.CGImage);
			greenDotSize = img.size;
		}
		
		{
			UIImage *img = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"Dot_Visited.png" ofType:nil]];
			blueDot = CGImageRetain(img.CGImage);
			blueDotSize = img.size;
		}
	
	}
	
	[[[AppDelegate sharedAppDelegate]gamePlayer]setCurrentGalaxySystem: [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemIndex]];
	return self;
}


-(void)showSystemCheat {
	self.cheatSystems.hidden = FALSE;
}
-(void)showQuestsCheat {
	self.cheatQuests.hidden = FALSE;
}

-(IBAction)selectNextSystem {
	[[[AppDelegate sharedAppDelegate]gamePlayer]setCurrentGalaxySystem: ([[[AppDelegate sharedAppDelegate]gamePlayer]currentGalaxySystem]+1)];
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]currentGalaxySystem] >= MAXSOLARSYSTEM)
		[[[AppDelegate sharedAppDelegate]gamePlayer]setCurrentGalaxySystem:0];
	
	[self setNeedsDisplay];
}

-(IBAction)selectPrevSystem {
	[[[AppDelegate sharedAppDelegate]gamePlayer]setCurrentGalaxySystem: ([[[AppDelegate sharedAppDelegate]gamePlayer]currentGalaxySystem]-1)];
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]currentGalaxySystem] < 0)
		[[[AppDelegate sharedAppDelegate]gamePlayer]setCurrentGalaxySystem: MAXSOLARSYSTEM-1];
	
	[self setNeedsDisplay];
}

-(IBAction)findSystem {
	AlertModalTextWindow *myAlertView = [[AlertModalTextWindow alloc] initWithTitle:@"Find System" yoffset:70 message:@"Which system are you looking for?\n\n"  
																		   delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Search"  thirdButtonTitle:@"Track System"];
	
	[myAlertView show];
	[myAlertView release];
	skipAlert = FALSE;
	[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"EnterSearchParamters.caf"];

}


- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
	int button = buttonIndex;	
	int index = -1;

	NSString *value = @"";
	if(!skipAlert)
		value = [[(AlertModalTextWindow*)alertView myTextField] text];
	
	for (int i = 0; i < MAXSOLARSYSTEM;++i) {
		
		if ([[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemName:i] compare:value options:NSCaseInsensitiveSearch] == NSOrderedSame) {
			
			index = i;
			break;
		}
	}
	
	BOOL showBonusAlert = FALSE;
	if (button == 1) {
		if (index !=-1) {
			[[[AppDelegate sharedAppDelegate]gamePlayer]setCurrentGalaxySystem:index];
			[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"SystemLocated.caf"];
		}
	
		if ([value length] > 0) {
			if ([value compare:@"moolah" options:NSCaseInsensitiveSearch] == NSOrderedSame) {
				[[[AppDelegate sharedAppDelegate]gamePlayer]setCredits: ([[[AppDelegate sharedAppDelegate]gamePlayer]credits] + 50000)];
				showBonusAlert = TRUE;
			}
			if (showBonusAlert) {
				UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Code Accepted" message:@"The predefined amount of credits have been deposited into your account." delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
				[alert show];
				[alert release];
				skipAlert = TRUE;
			}
						
			if ([value hasPrefix:@"Quest:"]) {
				if ([value compare:@"Quest:List" options:NSLiteralSearch] == NSOrderedSame) {
					[self showQuestsCheat];
					showBonusAlert = TRUE;
				}
			}		
			if ([value hasPrefix:@"System:"]) {
				if ([value compare:@"System:List" options:NSLiteralSearch] == NSOrderedSame) {
					[self showSystemCheat];
					showBonusAlert = TRUE;
				}
			}
			if (skipAlert || showBonusAlert) {
				[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"CheatCodeAccepted.caf"];
				showBonusAlert = TRUE;
			}
		}
	}
	
	if (button == 2) {
		if (index !=-1) {
			if (index == [[[AppDelegate sharedAppDelegate]gamePlayer]trackedSystem]) {
				UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"System Tracking" message:@"You are no longer tracking any systems." delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
				[alert show];
				[alert release];
				skipAlert = TRUE;				
				[[[AppDelegate sharedAppDelegate]gamePlayer]setTrackedSystem:-1];				
			}
			else {
				[[[AppDelegate sharedAppDelegate]gamePlayer]setTrackedSystem:index];				
			}			
			[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"SystemLocated.caf"];
		}
	}
	
	[self setNeedsDisplay];
	if ((index == -1) && (button != 0)) {
		if(!skipAlert && !showBonusAlert)
			[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"SystemNotFound.caf"];
	}
}


-(void) dispatchFirstTouchAtPoint:(CGPoint)touchPoint forEvent:(UIEvent *)event {
	
}

- (void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event {
	NSUInteger touchCount = 0;
	for (UITouch *touch in touches) {
		[self dispatchFirstTouchAtPoint:[touch locationInView:self] forEvent:nil];
		touchCount++;  
	}	
}

-(void) dispatchTouchEvent:(UIView *)theView toPosition:(CGPoint)position {
	
}


- (void)touchesMoved:(NSSet *)touches withEvent:(UIEvent *)event {  
	
	NSUInteger touchCount = 0;
	for (UITouch *touch in touches){
	 	[self dispatchTouchEvent:[touch view] toPosition:[touch locationInView:self]];
	    touchCount++;
	}
	
}


-(void) dispatchTouchEndEvent:(UIView *)theView toPosition:(CGPoint)position {   
	
	int i;
	
	{
		i = 0;
		
		while (i < MAXSOLARSYSTEM) {
			int Xp = (int)((float)[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:i]*1.8) +GALAXYBOUNDSX-EXTRAERASE;
			int Yp = (int)((float)[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:i]*2.8) +GALAXYBOUNDSY-EXTRAERASE;

			if ((ABS( Xp - (position.x) ) <= MINDISTANCEACTIVATE) &&
				(ABS( Yp - (position.y) ) <= MINDISTANCEACTIVATE))
				break;
			++i;
		}
		if (i < MAXSOLARSYSTEM) {
			[[[AppDelegate sharedAppDelegate]gamePlayer]setCurrentGalaxySystem:i];
			[self setNeedsDisplay];
		}
	}
	
}

- (void)touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event {
    for (UITouch *touch in touches){
		[self dispatchTouchEndEvent:[touch view] toPosition:[touch locationInView:self]];
	}
}


- (void)touchesCancelled:(NSSet *)touches withEvent:(UIEvent *)event {
    for (UITouch *touch in touches){
		[self dispatchTouchEndEvent:[touch view] toPosition:[touch locationInView:self]];
	}
}


@end
