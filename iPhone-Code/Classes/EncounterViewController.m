// 
//  EncounterViewController.m
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

#import "EncounterViewController.h"
#import "AppDelegate.h"
#import "Player.h"
#import "SoundManager.h"

#import "math.h"

#define PI					3.14159265
#define ROTATE_VIEW_TAG		999
#define WARNINGLEVEL		0.32	// used for damage alert
#define CRITICALLEVEL		0.42	// used for damage alert

@interface EncounterViewController ()

-(void) SetLabel2Text:(NSString*)text;
-(void) distanceToPlanet: (float)progress;

@end

@implementation EncounterViewController

@synthesize delegate, close, attackButton, surrenderButton, ignoreButton, fleeButton, loopCounter;
@synthesize submitButton, bribeButton, plunderButton, interruptButton, drinkButton, gameTimer, progressToPlanet;	
@synthesize boardButton, meetButton, yieldButton, tradeButton, attackImage, attackImage2, autoPilotMessage;
@synthesize encounterTypeImage, message1Label, message1Labe2, distanceLabel, sliderLabel;


-(void)dealloc {
	
	[close release];
	[attackButton release];
	[surrenderButton release];
	[ignoreButton release];	
	[fleeButton release];
	[submitButton release];
	[bribeButton release];
	[plunderButton release];
	[interruptButton release];
	[drinkButton release];	
	[boardButton release];
	[meetButton release];
	[yieldButton release];
	[tradeButton release];
	[attackImage release];	
	[attackImage2 release];
	[encounterTypeImage release];	
	[message1Label release];
	[message1Labe2 release];
	[autoPilotMessage release];
	[distanceLabel release];
	[sliderLabel release];
	
	[super dealloc];
}

-(IBAction) doClose {
	[self.delegate encounterViewControllerDidFinish:self];
	[self dismissModalViewControllerAnimated:YES];
	attackImage.image = nil;
	attackImage2.image = nil;	
	[[[AppDelegate sharedAppDelegate]gamePlayer] travel];
}

-(void)viewDidDisappear:(BOOL)animated {
	
	[[AppDelegate sharedAppDelegate]updateToolBar];
	
}

typedef enum {
	ALPHA = 0,
	BLUE = 1,
	GREEN = 2,
	RED = 3
} PIXELS;

- (UIImage *)convertToGrayscale:(UIImage *)source {
	CGSize size = [source size];
	int width = size.width;
	int height = size.height;
	
	uint32_t *pixels = (uint32_t *) malloc(width * height * sizeof(uint32_t));
	
	memset(pixels, 0, width * height * sizeof(uint32_t));
	
	CGColorSpaceRef colorSpace = CGColorSpaceCreateDeviceRGB();
	
	CGContextRef context = CGBitmapContextCreate(pixels, width, height, 8, width * sizeof(uint32_t), colorSpace, kCGBitmapByteOrder32Little | kCGImageAlphaPremultipliedLast);
	
	CGContextDrawImage(context, CGRectMake(0, 0, width, height), source.CGImage);
	
	for(int y = 0; y < height; y++) {
		for(int x = 0; x < width; x++) {
			uint8_t *rgbaPixel = (uint8_t *) &pixels[y * width + x];
			
			uint32_t gray = 0.3 * rgbaPixel[RED] + 0.59 * rgbaPixel[GREEN] + 0.11 * rgbaPixel[BLUE];
			
			rgbaPixel[RED] = gray;
			rgbaPixel[GREEN] = gray;
			rgbaPixel[BLUE] = gray;
		}
	}
	
	CGImageRef image = CGBitmapContextCreateImage(context);
	
	CGContextRelease(context);
	CGColorSpaceRelease(colorSpace);
	free(pixels);
	
	UIImage *resultUIImage = [UIImage imageWithCGImage:image];
	
	CGImageRelease(image);
	
	return resultUIImage;
}

-(void) distanceToPlanet: (float)progress {
	progressToPlanet.progress = progress/20.0f;
}

-(UIImage*) drawShip:(BOOL)player {

	long hull, shield, maxShield, hullMax;
	
	if (player) {
		hull = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipHull];
		shield = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipShield];
		maxShield = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipShieldMax];
		hullMax = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipHullMax];
	} else {
		hull = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipOpponentHull];
		shield = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipOpponentShield];		
		maxShield = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipShieldMax];
		hullMax = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipOpponentHullMax];
	}
	
	float currentHullAspect = (float)hull/(float)hullMax;
	if (player && (currentHullAspect < 0.9))
		[[[AppDelegate sharedAppDelegate]gamePlayer]passengersUsePEP];
	
	float currentShieldAspect = 0.0f;
	if (maxShield > 0)
		currentShieldAspect =  (float)shield/(float)maxShield;

	UIImage *fullHull, *fullDamage ;

	NSString *tmp;
	float aspect;
	if (currentShieldAspect > 0.0f) {
		aspect = currentShieldAspect;
		if (player) {
			tmp = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipImageName:[[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentShipType]];
			fullDamage = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:tmp ofType:nil]];
			tmp = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipShieldImageName:[[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentShipType]];
			fullHull = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:tmp ofType:nil]];
			if ((currentShieldAspect < WARNINGLEVEL) && (! shieldNotice)) {
				[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"ShieldsLow.caf"];
				shieldNotice = TRUE;
			}
		} else {
			tmp = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipImageName:[[[AppDelegate sharedAppDelegate]gamePlayer] getShipOpponentType]];
			if (isAPirate) {
				fullDamage = [self convertToGrayscale:[UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:tmp ofType:nil]]];
			}
			else {
				fullDamage = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:tmp ofType:nil]];
			}
			tmp = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipShieldImageName:[[[AppDelegate sharedAppDelegate]gamePlayer] getShipOpponentType]];
			if (isAPirate) {
				fullHull = [self convertToGrayscale:[UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:tmp ofType:nil]]];
			}
			else {
				fullHull = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:tmp ofType:nil]];
			}
		}
	} else {
		aspect = currentHullAspect;
		if (player) {
			tmp = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipImageName:[[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentShipType]];
			fullHull = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:tmp ofType:nil]];
			tmp = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipDamagedImageName:[[[AppDelegate sharedAppDelegate]gamePlayer] getCurrentShipType]];
			fullDamage = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:tmp ofType:nil]];
			if ((currentHullAspect < CRITICALLEVEL) && (! hullNotice)) {
				[[[AppDelegate sharedAppDelegate]gamePlayer]playSpeechFile:@"HullCritical.caf"];
				hullNotice = TRUE;
			}
		} else {
			tmp = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipImageName:[[[AppDelegate sharedAppDelegate]gamePlayer] getShipOpponentType]];
			if (isAPirate)
				fullHull = [self convertToGrayscale:[UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:tmp ofType:nil]]];
			else 
				fullHull = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:tmp ofType:nil]];				
			tmp = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipDamagedImageName:[[[AppDelegate sharedAppDelegate]gamePlayer] getShipOpponentType]];
			fullDamage = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:tmp ofType:nil]];
		}
	}
	
	if (aspect > 1.0f)
		aspect = 1.0f;

	CGSize size = CGSizeMake(fullHull.size.width, fullHull.size.height);;
	UIGraphicsBeginImageContext(size);
	
	int startfullHullPos = aspect * fullHull.size.width;

	CGContextRef context = UIGraphicsGetCurrentContext();	
	
	CGRect myImageArea = CGRectMake (fullHull.size.width - startfullHullPos, 0,
							  startfullHullPos, fullHull.size.height);
	
	CGImageRef img = CGImageRetain(fullHull.CGImage);
	CGImageRef mySubimage = CGImageCreateWithImageInRect (img, myImageArea);
	CGContextDrawImage(context, myImageArea, mySubimage);

	CGRect myImageArea2 = CGRectMake (0, 0,
									 fullDamage.size.width - startfullHullPos, fullHull.size.height);
	
	CGImageRef img2 = CGImageRetain(fullDamage.CGImage);
	CGImageRef mySubimage2 = CGImageCreateWithImageInRect (img2, myImageArea2);
	CGContextDrawImage(context, myImageArea2, mySubimage2);
	
	UIImage *destImage;	
	destImage = UIGraphicsGetImageFromCurrentImageContext();
	UIGraphicsEndImageContext();
	CGImageRelease(mySubimage);
	CGImageRelease(mySubimage2);
	CGImageRelease(img);
	CGImageRelease(img2);
	
	return destImage;
}


-(void)drawShips {
	if ([[NSUserDefaults standardUserDefaults] boolForKey:@"leftHandEncounter"]) {
		UIImage *i1 = [self drawShip:TRUE];
		attackImage.image = i1;
		attackImage.tag = ROTATE_VIEW_TAG;
		UIImage *i2 = [self drawShip:FALSE];
		attackImage2.image = i2;
	}
	else { 
		UIImage *i1 = [self drawShip:TRUE];
		attackImage.image = i1;
		UIImage *i2 = [self drawShip:FALSE];
		attackImage2.image = i2;
		attackImage2.tag = ROTATE_VIEW_TAG;
	}

	CGAffineTransform transform = CGAffineTransformMakeRotation(PI);	
	
	[[self.view viewWithTag:ROTATE_VIEW_TAG] setTransform:transform];	
}

-(void)setTextColor {
	
	UIColor *myTextColor;
	int colorValue = ([[NSUserDefaults standardUserDefaults] integerForKey:@"encounterTextColorValue"]);
	if (! colorValue) {
		colorValue = 0;
	}
	
	if ([[NSUserDefaults standardUserDefaults] integerForKey:@"useCustomTextColor"]) {
		switch (colorValue) {
			case 0:
				myTextColor = [UIColor greenColor];
				break;
			case 1:
				myTextColor = [UIColor blueColor];
				break;
			case 2:
				myTextColor = [UIColor redColor];
			default:
				break;
		}
	} else {
		myTextColor = [UIColor whiteColor];
	}
	
	self.message1Labe2.textColor = myTextColor;
	self.message1Label.textColor = myTextColor;	
}	
	
-(void)hideAllButInterrupt {
	attackButton.hidden = TRUE;
	surrenderButton.hidden = TRUE;
	ignoreButton.hidden = TRUE;
	fleeButton.hidden = TRUE;
	submitButton.hidden = TRUE;
	bribeButton.hidden = TRUE;
	plunderButton.hidden = TRUE;
	interruptButton.hidden = FALSE;
	drinkButton.hidden = TRUE;
	boardButton.hidden = TRUE;
	meetButton.hidden = TRUE;
	yieldButton.hidden = TRUE;
	tradeButton.hidden = TRUE;
	
}


-(void)encounterButtons {
	
	Player *pPlayer = [[AppDelegate sharedAppDelegate]gamePlayer];
	[self distanceToPlanet:(float)(20-[[[AppDelegate sharedAppDelegate]gamePlayer]clicks])];
	
	attackButton.hidden = TRUE;
	surrenderButton.hidden = TRUE;
	ignoreButton.hidden = TRUE;
	fleeButton.hidden = TRUE;
	submitButton.hidden = TRUE;
	bribeButton.hidden = TRUE;
	plunderButton.hidden = TRUE;
	interruptButton.hidden = TRUE;
	drinkButton.hidden = TRUE;
	boardButton.hidden = TRUE;
	meetButton.hidden = TRUE;
	yieldButton.hidden = TRUE;
	tradeButton.hidden = TRUE;
	
	if (interruptIsActive) {
		interruptButton.hidden = FALSE;
	}
	else {
		interruptButton.hidden = TRUE;
		isAPirate = FALSE;
		
		int encounterType = pPlayer.encounterType;
		if (encounterType == POLICEINSPECTION) {
			attackButton.hidden = FALSE;
			fleeButton.hidden = FALSE;
			submitButton.hidden = FALSE;
			bribeButton.hidden = FALSE;
		} else 
			if (encounterType == POSTMARYPOLICEENCOUNTER) {
				attackButton.hidden = FALSE;
				fleeButton.hidden = FALSE;
				yieldButton.hidden = FALSE;
				bribeButton.hidden = FALSE;
			}else 
				if (encounterType == POLICEFLEE || encounterType == TRADERFLEE || encounterType == PIRATEFLEE ) {
					attackButton.hidden = FALSE;
					ignoreButton.hidden = FALSE;
					if(encounterType == PIRATEFLEE)
						isAPirate = TRUE;
				}else 
					if (encounterType == POLICEATTACK || encounterType == PIRATEATTACK || encounterType == SCARABATTACK ) {
						attackButton.hidden = FALSE;
						fleeButton.hidden = FALSE;
						surrenderButton.hidden = FALSE;
						if(encounterType == PIRATEATTACK) {
							isAPirate = TRUE;
							if ([pPlayer getShipOpponentType] == MANTISTYPE)
								isAPirate = FALSE;
						}		
					}else 
						if (encounterType ==FAMOUSCAPATTACK ) {
							attackButton.hidden = FALSE;
							fleeButton.hidden = FALSE;
						}else 
							if (encounterType == TRADERATTACK || encounterType == SPACEMONSTERATTACK || encounterType == DRAGONFLYATTACK ) {
								attackButton.hidden = FALSE;
								fleeButton.hidden = FALSE;
							}else 
								if (encounterType == TRADERIGNORE || encounterType == POLICEIGNORE || encounterType == PIRATEIGNORE  ||
									encounterType == SPACEMONSTERIGNORE || encounterType == DRAGONFLYIGNORE || encounterType == SCARABIGNORE) {
									attackButton.hidden = FALSE;
									ignoreButton.hidden = FALSE;
									if(encounterType == PIRATEIGNORE)
										isAPirate = TRUE;
								}else 
									if (encounterType == TRADERSURRENDER || encounterType == PIRATESURRENDER ) {
										attackButton.hidden = FALSE;
										plunderButton.hidden = FALSE;
										if(encounterType == PIRATESURRENDER)
											isAPirate = TRUE;
									}else 
										if (encounterType == MARYCOCHRANENCOUNTER ) {
											boardButton.hidden = FALSE;
											ignoreButton.hidden = FALSE;
										}else 
											if (ENCOUNTERFAMOUS(encounterType)) {
												attackButton.hidden = FALSE;
												ignoreButton.hidden = FALSE;
												meetButton.hidden = FALSE;
											}else 
												if (encounterType == BOTTLEGOODENCOUNTER || encounterType == BOTTLEOLDENCOUNTER) {
													drinkButton.hidden = FALSE;
													ignoreButton.hidden = FALSE;
												}else 
													if (encounterType == TRADERSELL || encounterType == TRADERBUY) {
														attackButton.hidden = FALSE;
														ignoreButton.hidden = FALSE;
														tradeButton.hidden = FALSE;
													}
		
	}
	
	[self drawShips];
	
	if (!pPlayer.textualEncounters) {
		self.message1Labe2.hidden = TRUE;
		self.message1Label.hidden = TRUE;
	}
	
	progressToPlanet.hidden = FALSE;
	distanceLabel.hidden = FALSE;
	sliderLabel.hidden = FALSE;
}


-(void) encounterDisplayNextAction:(BOOL) FirstDisplay {
	Player *pPlayer = [[AppDelegate sharedAppDelegate]gamePlayer];
	int EncounterType = pPlayer.encounterType;
	
	if (EncounterType == POLICEINSPECTION) {
		self.message1Labe2.text = @"The police summon you to submit to an inspection";
	} else if (EncounterType == POSTMARYPOLICEENCOUNTER) {
		self.message1Labe2.text = @"We know you removed illegal goods from the Mary Cochran. You must give them up at once!";
	} else if (FirstDisplay && EncounterType == POLICEATTACK && pPlayer.policeRecordScore > CRIMINALSCORE) {
		self.message1Labe2.text = @"The police hail they want you to surrender.";
	} else if (EncounterType == POLICEFLEE || EncounterType == TRADERFLEE || EncounterType == PIRATEFLEE)
		self.message1Labe2.text = @"Your opponent is fleeing.";
	else if (EncounterType == PIRATEATTACK || EncounterType == POLICEATTACK || EncounterType == TRADERATTACK || EncounterType == SPACEMONSTERATTACK || EncounterType == DRAGONFLYATTACK || EncounterType == SCARABATTACK || EncounterType == FAMOUSCAPATTACK)
		self.message1Labe2.text = @ "Your opponent attacks.";
	else if (EncounterType == TRADERIGNORE || EncounterType == POLICEIGNORE || EncounterType == SPACEMONSTERIGNORE || EncounterType == DRAGONFLYIGNORE || EncounterType == PIRATEIGNORE || EncounterType == SCARABIGNORE) {
		if ([pPlayer isShipCloaked])
			self.message1Labe2.text = @"It doesn't notice you.";
		else
			self.message1Labe2.text = @"It ignores you.";
	} else if (EncounterType == TRADERSELL || EncounterType == TRADERBUY) {
		self.message1Labe2.text = @"You are hailed with an offer to trade goods.";
	} else if (EncounterType == TRADERSURRENDER || EncounterType == PIRATESURRENDER) {
		self.message1Labe2.text = @"Your opponent hails that he surrenders to you.";
	} else if (EncounterType == MARYCOCHRANENCOUNTER) {
		self.message1Labe2.text = @ "The Mary Cochran appears to be completely abandoned.";
	} else if (ENCOUNTERFAMOUS(EncounterType) && EncounterType != FAMOUSCAPATTACK) {
		self.message1Labe2.text = @"The Captain requests a brief meeting with you.";
	} else if (EncounterType == BOTTLEOLDENCOUNTER || EncounterType == BOTTLEGOODENCOUNTER) {
		self.message1Labe2.text = @"It appears to be a rare bottle of Captain Conner's Skill Tonic!";
  }
	
}

-(void) showEncounterWindow {
	[self encounterButtons];
	[self encounterDisplayNextAction:TRUE];
	
	Player *pPlayer = [[AppDelegate sharedAppDelegate]gamePlayer];
	int EncounterType = pPlayer.encounterType;

	if (EncounterType == POSTMARYPOLICEENCOUNTER) {
		self.message1Label.text = @"You encounter the Customs Police.";
	} else {
		NSString *shipType;
		NSString *shipName = [pPlayer getShipName:[pPlayer getShipOpponentType]];
		
		if (ENCOUNTERPOLICE( EncounterType )) {
			encounterTypeImage.image = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"EncounterPolice.png" ofType:nil]];
			shipType =@"a police";
		} else if (ENCOUNTERPIRATE( EncounterType )) {
			encounterTypeImage.image = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"EncounterPirate.png" ofType:nil]];
			if ([pPlayer getShipOpponentType] == MANTISTYPE) {
				shipType =@"an alien";
				encounterTypeImage.image = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"EncounterAlien.png" ofType:nil]];
			}
			else
				shipType =@"a pirate";
		} else if (ENCOUNTERTRADER( EncounterType )){
			encounterTypeImage.image = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"EncounterMerchant.png" ofType:nil]];
			shipType =@"a trader"; /// added 03-20-2010
		} else if (ENCOUNTERMONSTER( EncounterType )) {
			encounterTypeImage.image = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"EncounterPirate.png" ofType:nil]];
			shipType =@"a band of";
		}
		else if (EncounterType == MARYCOCHRANENCOUNTER) {
			shipType =@"a drifting ship";
			encounterTypeImage.image = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"EncounterAlien.png" ofType:nil]];
		}
		else if (EncounterType == CAPTAINADAMAENCOUNTER) {
			shipType =@"the famous Captain Adama";
			encounterTypeImage.image = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"EncounterAlien.png" ofType:nil]];
		}
		else if (EncounterType == CAPTAINBELLOWSENCOUNTER) {
			shipType =@"Captain Bellows";
			encounterTypeImage.image = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"EncounterAlien.png" ofType:nil]];
		}
		else if (EncounterType == CAPTAINLYNNENCOUNTER) {
			shipType =@"Captain Lynn";
			encounterTypeImage.image = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"EncounterAlien.png" ofType:nil]];
		}
		else if (EncounterType == BOTTLEOLDENCOUNTER || EncounterType == BOTTLEGOODENCOUNTER) {
			shipType =@"a floating";
			encounterTypeImage.image = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"EncounterAlien.png" ofType:nil]];
		}
		else {
			shipType =@"a stolen";
			encounterTypeImage.image = [UIImage imageWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"EncounterAlien.png" ofType:nil]];
		}

		if (message1Label.text.length == 0) {
			self.message1Label.text = [NSString  stringWithFormat:@"At %i click%@ from %@ you encounter %@ %@.", pPlayer.clicks,(pPlayer.clicks == 1 ? @"" : @"s"), [pPlayer getSolarSystemName:pPlayer.warpSystem], shipType, shipName];
			if (ENCOUNTERMONSTER( EncounterType ))
				[[SoundManager sharedSound] playSoundWithId:kLedLum];
		}
		
	}			

}

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}


- (void)viewDidAppear:(BOOL)animated {
	hullNotice = FALSE;
	shieldNotice = FALSE;
	
	[super viewDidAppear:animated];
	[self setTextColor];
	[self SetLabelText:@""];
	[self showEncounterWindow];
}

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {
		self.title = NSLocalizedString(@"Encounter", @"");
	}
	return self;
}

-(void)contAttack {
	if([[[AppDelegate sharedAppDelegate]gamePlayer]autoAttack]) {
		if(loopCounter > 2)
			self.autoPilotMessage.hidden = TRUE;
		if(loopCounter == 4) {
			self.autoPilotMessage.hidden = FALSE;
			loopCounter = 0;
			[[[AppDelegate sharedAppDelegate]gamePlayer]attack];	
			[self showEncounterWindow];
		}
		else
			++loopCounter;
	}
	else {
		self.autoPilotMessage.hidden = TRUE;
		interruptIsActive = FALSE;
		[self.gameTimer invalidate];
		self.gameTimer = nil;
		[self showEncounterWindow];
	}
	
}

-(IBAction)attack {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	if([[[AppDelegate sharedAppDelegate]gamePlayer]shouldAutoAttack]) {
		[[[AppDelegate sharedAppDelegate]gamePlayer]attack];
		loopCounter = 0;
		interruptIsActive = TRUE;
		[self hideAllButInterrupt];
		self.gameTimer = [NSTimer scheduledTimerWithTimeInterval:0.25 target:self selector:@selector(contAttack) userInfo:nil repeats:YES];
		self.autoPilotMessage.text = @"Auto Pilot Attack Mode: Active!";
		self.autoPilotMessage.hidden = FALSE;
	}
	else {
		interruptIsActive = FALSE;
		self.autoPilotMessage.hidden = TRUE;
		[[[AppDelegate sharedAppDelegate]gamePlayer]attack];	
		[self showEncounterWindow];
	}
}

-(void)contFlee {
	if([[[AppDelegate sharedAppDelegate]gamePlayer]autoFlee]) {
		if(loopCounter > 2)
			self.autoPilotMessage.hidden = TRUE;
		if(loopCounter == 4) {
			self.autoPilotMessage.hidden = FALSE;
			loopCounter = 0;
			[[[AppDelegate sharedAppDelegate]gamePlayer]flee];	
			[self showEncounterWindow];
			[self hideAllButInterrupt];
		}
		else
			++loopCounter;
	}
	else {
		interruptIsActive = FALSE;
		self.interruptButton.hidden = TRUE;
		self.autoPilotMessage.hidden = TRUE;
		[self.gameTimer invalidate];
		self.gameTimer = nil;
		[self showEncounterWindow];
	}
}

-(IBAction)flee {

	if([[[AppDelegate sharedAppDelegate]gamePlayer]shouldAutoFlee]) {
		[[[AppDelegate sharedAppDelegate]gamePlayer]flee];
		loopCounter = 0;
		interruptIsActive = TRUE;
		self.gameTimer = [NSTimer scheduledTimerWithTimeInterval:0.25 target:self selector:@selector(contFlee) userInfo:nil repeats:YES];
		[self hideAllButInterrupt];
		self.autoPilotMessage.text = @"Auto Pilot Flee Mode: Active!";
		self.autoPilotMessage.hidden = FALSE;
	}
	else {
		interruptIsActive = FALSE;
		self.autoPilotMessage.hidden = TRUE;
		[[[AppDelegate sharedAppDelegate]gamePlayer]flee];	
		[self showEncounterWindow];
	}
	
}

-(IBAction)ignore {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	self.ignoreButton.hidden = TRUE;
	[[[AppDelegate sharedAppDelegate]gamePlayer]ignore];	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer]clicks] <= 0) {
		[self hideAllButInterrupt];
		self.interruptButton.hidden = YES;
	}
}

-(void) SetLabelText:(NSString*)text {
	self.message1Label.text = text;
}

-(void) SetLabel2Text:(NSString*)text {
	self.message1Labe2.text = text;
}

-(IBAction)trade {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	[[[AppDelegate sharedAppDelegate]gamePlayer]trade];	
}

-(IBAction)yield {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	[[[AppDelegate sharedAppDelegate]gamePlayer]yield];	
}

-(IBAction)surrender {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	[[[AppDelegate sharedAppDelegate]gamePlayer]surrender];	
}

-(IBAction)bribe {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	[[[AppDelegate sharedAppDelegate]gamePlayer]bribe];	
}

-(IBAction)submit {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	[[[AppDelegate sharedAppDelegate]gamePlayer]submit];	
}

-(IBAction)plunder {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	[[[AppDelegate sharedAppDelegate]gamePlayer]plunder];	
}

-(IBAction)interrupt {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	[self.gameTimer invalidate];
	self.gameTimer = nil;
	interruptIsActive = FALSE;
	self.autoPilotMessage.hidden = TRUE;
	self.interruptButton.hidden = TRUE;
	[[[AppDelegate sharedAppDelegate]gamePlayer]interrupt];
	[self showEncounterWindow];	
}

-(IBAction)meet {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	[[[AppDelegate sharedAppDelegate]gamePlayer]meet];	
}

-(IBAction)board {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	[[[AppDelegate sharedAppDelegate]gamePlayer]board];	
}

-(IBAction)drink {
	[[SoundManager sharedSound] playSoundWithId:kPock];
	[[[AppDelegate sharedAppDelegate]gamePlayer]drink];	
}


@end
