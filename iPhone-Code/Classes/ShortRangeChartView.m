//
//  ShortRangeChartView.m
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

#import "ShortRangeChartView.h"
#import "AppDelegate.h"
#import "SystemInfoViewController.h"
#import "Player.h"

@interface ShortRangeChartView()

@property (nonatomic) CGPoint startTouchPosition;

@end


@interface ShortRangeChartView (PrivateMethods)
-(UILabel *) newLabelWithOffset:(float)offset numberOfLines:(NSUInteger) lines;
-(UIImageView *)newPieceViewWithImageNamed:(NSString *)imageName atPostion:(CGPoint)centerPoint;
-(void) animateFirstTouchAtPoint:(CGPoint)touchPoint forView:(UIImageView *)theView;
-(void) animateView:(UIImageView *)theView toPosition:(CGPoint) thePosition;
-(void) dispatchFirstTouchAtPoint:(CGPoint)touchPoint forEvent:(UIEvent *)event;
-(void) dispatchTouchEvent:(UIView *)theView toPosition:(CGPoint)position;
-(void) dispatchTouchEndEvent:(UIView *)theView toPosition:(CGPoint)position;
-(void) drawView:(CGContextRef)context bounds:(CGRect)bounds;
@end


@implementation ShortRangeChartView

#define STRING_INDENT 20


@synthesize startTouchPosition, targetViewController, nameOfTracked;

- (void)dealloc {
	CGImageRelease(redDot);
	CGImageRelease(blueDot);
	CGImageRelease(greenDot);
	CGImageRelease(background);
	[nameOfTracked release];
	
	[super dealloc];	
}

-(void)drawShortRange:(int)index {
	Index = index;
}

-(void) showAveragePriceInSystem {
		
}

-(void) showWarpView {
	if (!targetViewController)
		targetViewController = [[WarpViewController alloc] initWithNibName:@"Warp" bundle:nil];

	[targetViewController updateTitle];
	[[[AppDelegate sharedAppDelegate]navigationController] pushViewController:targetViewController animated:YES];
}

-(void)drawRect:(CGRect) rect {
	[self drawView:UIGraphicsGetCurrentContext() bounds:self.bounds];
}

- (void)didMoveToWindow {
	Index = -1;	
	[super didMoveToWindow];
	[self setNeedsDisplay];
}

-(void)drawView:(CGContextRef)context bounds:(CGRect)bounds {
	int Xs = (int)((SHORTRANGEWIDTH >> 1) + SHORTRANGEBOUNDSX);
	int Ys = (int)((SHORTRANGEHEIGHT >> 1) + BOUNDSY);
	int delta = (SHORTRANGEWIDTH / (MAXRANGE << 1));
	
	CGContextDrawImage(context,  CGRectMake(0, -0,  backgroundSize.width, backgroundSize.height) , background);
	
	if (Index == -1)
		Index = [[[AppDelegate sharedAppDelegate]gamePlayer]getCurrentSystemIndex];
	
	CGContextSetRGBStrokeColor(context, 1.0, 1.0, 1.0, 1.0);
	CGContextSetLineWidth(context, 2.0);	
	
	int fuel = [[[AppDelegate sharedAppDelegate]gamePlayer]getFuel];
	if (fuel) {
		CGContextAddArc(context, Xs, Ys,  fuel * delta + 3, 0, 2*3.1416f, 1);
	}
	
	self.nameOfTracked.hidden = TRUE;
	
	CGContextStrokePath(context);
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]trackedSystem] >= 0) {
		long distToTracked = [[[AppDelegate sharedAppDelegate]gamePlayer] realDistance:[[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemIndex] b:[[[AppDelegate sharedAppDelegate]gamePlayer]trackedSystem]];
		if (distToTracked > 0) {
			int dX = (int)(40.0 * ((float)[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:[[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemIndex]] - (float)[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:[[[AppDelegate sharedAppDelegate]gamePlayer]trackedSystem]]) / 
					   (float)distToTracked);
			int dY = (int)(40.0 * ((float)[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:[[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemIndex]] - (float)[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:[[[AppDelegate sharedAppDelegate]gamePlayer]trackedSystem]]) / 
					   (float)distToTracked);
			
			int dY3 = -(int)(8.0 * ((float)[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:[[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemIndex]] - (float)[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:[[[AppDelegate sharedAppDelegate]gamePlayer]trackedSystem]]) / 
						 (float)distToTracked);		
			int dX3 = (int)(8.0 * ((float)[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:[[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemIndex]] - (float)[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:[[[AppDelegate sharedAppDelegate]gamePlayer]trackedSystem]]) / 
						(float)distToTracked);
			if (dX > 0) {
				Xs += 0;
			}
			if (dY > 0) {
				Ys += 0;;
			}
			
			CGContextMoveToPoint(context,  Xs - dX, Ys - dY);
			CGContextAddLineToPoint(context, Xs - dX3, Ys - dY3);
			CGContextStrokePath(context);
			
			CGContextMoveToPoint(context,  Xs - dX, Ys - dY);
			CGContextAddLineToPoint(context, Xs + dX3, Ys + dY3);
			CGContextStrokePath(context);

			if ([[[AppDelegate sharedAppDelegate] gamePlayer]showTrackedRange]) {
				self.nameOfTracked.text = [NSString stringWithFormat:@"Tracked System: %@, %i parsecs",[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemName:[[[AppDelegate sharedAppDelegate]gamePlayer]trackedSystem]],distToTracked];
				self.nameOfTracked.hidden = FALSE;				
			}
			else {
				self.nameOfTracked.text = [NSString stringWithFormat:@"Tracked System: %@",[[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemName:[[[AppDelegate sharedAppDelegate]gamePlayer]trackedSystem]]];
				self.nameOfTracked.hidden = FALSE;
			}
		}
	}

	int j, i, Xp, Yp;
	for (j=0; j<2; ++j)
	{
		for (i=0; i<MAXSOLARSYSTEM; ++i)
		{
			if ((ABS( [[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:i]  - [[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:Index]  ) <= MAXRANGE) &&
				(ABS( [[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:i]  - [[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:Index] ) <= MAXRANGE))
			{
				Xp = (int)((SHORTRANGEWIDTH >> 1) + 
						   ([[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:i]  - [[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:Index]) * 
						   (SHORTRANGEWIDTH / (MAXRANGE << 1)) +
						   SHORTRANGEBOUNDSX - EXTRAERASE);
				Yp = (int)((SHORTRANGEHEIGHT >> 1) + 
						   ([[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:i]  - [[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:Index] ) * 
						   (SHORTRANGEHEIGHT / (MAXRANGE << 1)) +
						   BOUNDSY - EXTRAERASE);
				if (j == 1)
				{
					if (i == [[[AppDelegate sharedAppDelegate]gamePlayer] warpSystem])
					{
						CGContextSetRGBStrokeColor(context, 0.0, 1.0, 0.50, 1.0);
						CGContextMoveToPoint(context, Xp-6, Yp+10); 
						CGContextAddLineToPoint(context, Xp+26, Yp+10);
						CGContextStrokePath(context);

						CGContextMoveToPoint(context, Xp+10, Yp-6);
						CGContextAddLineToPoint(context, Xp+10, Yp+26);
						CGContextStrokePath(context);
						CGContextSetRGBStrokeColor(context, 1.0, 1.0, 1.0, 1.0);
						
					}
					if ([[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemVisited:i]) {
						CGContextDrawImage(context,  CGRectMake(Xp, Yp,  blueDotSize.width, blueDotSize.height) , blueDot);

					} else {
						CGContextDrawImage(context,  CGRectMake(Xp, Yp, greenDotSize.width, greenDotSize.height) , greenDot);						
					}
					
					if ([[[AppDelegate sharedAppDelegate]gamePlayer] wormholeExists:i b:-1 ])
					{
						delta = WORMHOLEDISTANCE * (SHORTRANGEWIDTH / (MAXRANGE << 1));
						if ([[[AppDelegate sharedAppDelegate]gamePlayer] wormholeExists:i b:[[[AppDelegate sharedAppDelegate]gamePlayer]warpSystem]])
						{
							CGContextSetRGBStrokeColor(context, 0.0, 1.0, 0.0, 1.0);
							CGContextMoveToPoint(context, Xp+delta/2-2, Yp+7+delta/2+4);
							CGContextAddLineToPoint(context, Xp+18+delta/2+6, Yp+7+delta/2+4);
							CGContextStrokePath(context);
							
							CGContextMoveToPoint(context, Xp+7+delta/2+4, Yp-4+delta/2+2);
							CGContextAddLineToPoint(context, Xp+7+delta/2+4, Yp+18+delta/2+6);
							CGContextStrokePath(context);
							CGContextSetRGBStrokeColor(context, 1.0, 1.0, 1.0, 1.0);
						}
						CGContextDrawImage(context,  CGRectMake(Xp+delta/2, Yp+delta/2, redDotSize.width, redDotSize.height) , redDot);	
					}					
				}
				else
				{
					[[UIColor whiteColor] set];
					CGPoint point = CGPointMake(Xp, Yp - 18);
					float fontSize = 13.5;
					UIFont *font = [UIFont systemFontOfSize:fontSize];

					NSString * currentDisplayString = [[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemName:i];
					[currentDisplayString drawAtPoint:point forWidth:(self.bounds.size.width-STRING_INDENT) withFont:font fontSize:fontSize lineBreakMode:UILineBreakModeMiddleTruncation baselineAdjustment:UIBaselineAdjustmentAlignBaselines]; 					
				}					
			}
		}
	}
	 	
}

- (id)initWithCoder:(NSCoder*)coder {
	if (self = [super initWithCoder:coder]) {
		
		self.backgroundColor =[UIColor blackColor];
		
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

		{
			UIImage *img = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"ShortRange.jpg" ofType:nil]];
			background = CGImageRetain(img.CGImage);
			backgroundSize = img.size;
		}
		
		Index = -1;
		[self setMultipleTouchEnabled:NO];
	}
	return self;
}


- (void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event {
	NSUInteger touchCount = 0;
	for (UITouch *touch in touches) {
		[self dispatchFirstTouchAtPoint:[touch locationInView:self] forEvent:nil];
		touchCount++;  
	}	
}

-(void) dispatchFirstTouchAtPoint:(CGPoint)touchPoint forEvent:(UIEvent *)event {
	
}

- (void)touchesMoved:(NSSet *)touches withEvent:(UIEvent *)event {  
	
	NSUInteger touchCount = 0;
	for (UITouch *touch in touches){
	 	[self dispatchTouchEvent:[touch view] toPosition:[touch locationInView:self]];
	    touchCount++;
	}
	
}

-(void) dispatchTouchEvent:(UIView *)theView toPosition:(CGPoint)position {

}


- (void)touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event {
    for (UITouch *touch in touches){
		[self dispatchTouchEndEvent:[touch view] toPosition:[touch locationInView:self]];
	}
}

-(void) dispatchTouchEndEvent:(UIView *)theView toPosition:(CGPoint)position {   
	
	int Xp, Yp, i, index;
	index = [[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentSystemIndex];
	
	i = 0;
	while (i < MAXWORMHOLE)
	{
		Xp = (int)((SHORTRANGEWIDTH >> 1) + 
				   
				   ([[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:[[[AppDelegate sharedAppDelegate]gamePlayer] getWormhole:i]] + WORMHOLEDISTANCE - [[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:index]) * 
				   (SHORTRANGEWIDTH / (MAXRANGE << 1)) +
				   SHORTRANGEBOUNDSX);
		Yp = (int)((SHORTRANGEHEIGHT >> 1) + 
				   ([[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:[[[AppDelegate sharedAppDelegate]gamePlayer] getWormhole:i]] - [[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:index]) * 
				   (SHORTRANGEHEIGHT / (MAXRANGE << 1)) +
				   BOUNDSY);
		if ((ABS( Xp - (position.x) ) <= MINDISTANCEACTIVATE) &&
			(ABS( Yp - (position.y) ) <= MINDISTANCEACTIVATE))
			break;
		++i;
	}
	if (i < MAXWORMHOLE)
	{
		if (index != [[[AppDelegate sharedAppDelegate]gamePlayer] getWormhole:i]) {
			
		}
		else {
			[[[AppDelegate sharedAppDelegate]gamePlayer] setWarpSystem:(i < MAXWORMHOLE-1 ? [[[AppDelegate sharedAppDelegate]gamePlayer] getWormhole:i+1] : [[[AppDelegate sharedAppDelegate]gamePlayer] getWormhole:0])];
			[self showWarpView];
			return;
		}
	}
		
	if ((position.x >= SHORTRANGEBOUNDSX-EXTRAERASE) &&
		(position.x <= SHORTRANGEBOUNDSX+SHORTRANGEWIDTH+EXTRAERASE) &&
		(position.y >= BOUNDSY-EXTRAERASE) &&
		(position.y <= BOUNDSY+SHORTRANGEHEIGHT+EXTRAERASE))
	{
		i = 0;

		while (i < MAXSOLARSYSTEM)
		{
			Xp = (int)((SHORTRANGEWIDTH >> 1) + 
					   ([[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:i]  - [[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemX:index]) * 
					   (SHORTRANGEWIDTH / (MAXRANGE << 1)) +
					   SHORTRANGEBOUNDSX);
			Yp = (int)((SHORTRANGEHEIGHT >> 1) + 
					   ([[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:i]  - [[[AppDelegate sharedAppDelegate]gamePlayer] getSolarSystemY:index]) * 
					   (SHORTRANGEHEIGHT / (MAXRANGE << 1)) +
					   BOUNDSY);
			if ((ABS( Xp - (position.x) ) <= MINDISTANCEACTIVATE) &&
				(ABS( Yp - (position.y) ) <= MINDISTANCEACTIVATE))
				break;
			++i;
		}
		if (i < MAXSOLARSYSTEM)
		{
			[[[AppDelegate sharedAppDelegate]gamePlayer] setWarpSystem:i];
			[self showWarpView];
		}
	}
	
}

- (void)touchesCancelled:(NSSet *)touches withEvent:(UIEvent *)event {
    for (UITouch *touch in touches){
		[self dispatchTouchEndEvent:[touch view] toPosition:[touch locationInView:self]];
	}
}


@end
