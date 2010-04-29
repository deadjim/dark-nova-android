// 
//  EncounterViewController.h
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

@protocol EncounterViewControllerDelegate;

@interface EncounterViewController : UIViewController {

	id <EncounterViewControllerDelegate> delegate;

	IBOutlet UIButton    *close;
	IBOutlet UIButton    *attackButton;
	IBOutlet UIButton    *surrenderButton;
	IBOutlet UIButton    *ignoreButton;	
	IBOutlet UIButton    *fleeButton;
	IBOutlet UIButton    *submitButton;
	IBOutlet UIButton    *bribeButton;
	IBOutlet UIButton    *plunderButton;
	IBOutlet UIButton    *interruptButton;
	IBOutlet UIButton    *drinkButton;	
	IBOutlet UIButton    *boardButton;
	IBOutlet UIButton    *meetButton;
	IBOutlet UIButton    *yieldButton;
	IBOutlet UIButton    *tradeButton;
	IBOutlet UIImageView *attackImage;	
	IBOutlet UIImageView *attackImage2;
	IBOutlet UIImageView *encounterTypeImage;	
	IBOutlet UILabel     *message1Label;
	IBOutlet UILabel     *message1Labe2;
	IBOutlet UILabel     *autoPilotMessage;
	
	IBOutlet UILabel     *distanceLabel;
	IBOutlet UIProgressView *progressToPlanet;
	
	IBOutlet UILabel     *sliderLabel;
	
	NSTimer				*gameTimer;
	int					loopCounter;
	BOOL				interruptIsActive;
	BOOL				isAPirate;
	BOOL				hullNotice;
	BOOL				shieldNotice;

}

@property (nonatomic, assign) id <EncounterViewControllerDelegate> delegate;

@property (nonatomic, retain) IBOutlet UIButton    *close;
@property (nonatomic, retain) IBOutlet UIButton    *attackButton;
@property (nonatomic, retain) IBOutlet UIButton    *surrenderButton;
@property (nonatomic, retain) IBOutlet UIButton    *ignoreButton;	
@property (nonatomic, retain) IBOutlet UIButton    *fleeButton;
@property (nonatomic, retain) IBOutlet UIButton    *submitButton;
@property (nonatomic, retain) IBOutlet UIButton    *bribeButton;
@property (nonatomic, retain) IBOutlet UIButton    *plunderButton;
@property (nonatomic, retain) IBOutlet UIButton    *interruptButton;
@property (nonatomic, retain) IBOutlet UIButton    *drinkButton;	
@property (nonatomic, retain) IBOutlet UIButton    *boardButton;
@property (nonatomic, retain) IBOutlet UIButton    *meetButton;
@property (nonatomic, retain) IBOutlet UIButton    *yieldButton;
@property (nonatomic, retain) IBOutlet UIButton    *tradeButton;
@property (nonatomic, retain) IBOutlet UIImageView *attackImage;	
@property (nonatomic, retain) IBOutlet UIImageView *attackImage2;
@property (nonatomic, retain) IBOutlet UIImageView *encounterTypeImage;	
@property (nonatomic, retain) IBOutlet UILabel     *message1Label;
@property (nonatomic, retain) IBOutlet UILabel     *message1Labe2;
@property (nonatomic, retain) IBOutlet UILabel     *autoPilotMessage;
@property (nonatomic, retain) IBOutlet UILabel     *distanceLabel;
@property (nonatomic, retain) IBOutlet UILabel     *sliderLabel;
@property (nonatomic, retain) IBOutlet UIProgressView *progressToPlanet;
@property (nonatomic, retain) NSTimer *gameTimer;
@property int loopCounter;

-(void) showEncounterWindow;
-(void) SetLabelText:(NSString*)text;
-(IBAction) doClose;
-(IBAction) attack;
-(IBAction) flee;
-(IBAction) ignore;
-(IBAction) trade;
-(IBAction) yield;
-(IBAction) surrender;
-(IBAction) bribe; 
-(IBAction) submit; 
-(IBAction) plunder; 
-(IBAction) interrupt; 
-(IBAction) meet; 
-(IBAction) board; 
-(IBAction) drink;

@end 

@protocol EncounterViewControllerDelegate
- (void)encounterViewControllerDidFinish:(EncounterViewController *)controller;
@end
