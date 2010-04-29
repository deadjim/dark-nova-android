//
//  StartGameViewController.h
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

@interface StartGameViewController : UIViewController <UITextViewDelegate, UIAlertViewDelegate> {

    IBOutlet UILabel *difficultyLevel;
    IBOutlet UILabel *skillPoints;
    IBOutlet UILabel *pilotPointsLabel;	
    IBOutlet UILabel *fighterPointsLabel;	
    IBOutlet UILabel *traderPointsLabel;	
    IBOutlet UILabel *engineerPointsLabel;
	IBOutlet UITextField *pilotName;
	IBOutlet UIButton *pilot;
	IBOutlet UIButton *fighter;
	IBOutlet UIButton *trader;
	IBOutlet UIButton *engineer;
	NSString *message;
	
	IBOutlet UISlider *pilotSkill;
	IBOutlet UISlider *fighterSkill;
	IBOutlet UISlider *traderSkill;
	IBOutlet UISlider *engineerSkill;
	IBOutlet UISlider *gameDifficulty;

}

@property (nonatomic, retain) NSString *message;
@property (nonatomic, retain) IBOutlet UIButton *pilot;
@property (nonatomic, retain) IBOutlet UIButton *fighter;
@property (nonatomic, retain) IBOutlet UIButton *trader;
@property (nonatomic, retain) IBOutlet UIButton *engineer;
@property (nonatomic, retain) IBOutlet UITextField *pilotName;
@property (nonatomic, retain) IBOutlet UILabel *difficultyLevel;
@property (nonatomic, retain) IBOutlet UILabel *skillPoints;
@property (nonatomic, retain) IBOutlet UILabel *pilotPointsLabel;
@property (nonatomic, retain) IBOutlet UILabel *fighterPointsLabel;
@property (nonatomic, retain) IBOutlet UILabel *traderPointsLabel;
@property (nonatomic, retain) IBOutlet UILabel *engineerPointsLabel;


- (IBAction)sliderAction:(UISlider*)sender;
- (IBAction)setDifficulty;
- (IBAction)startGame;
- (IBAction)sliderStopped;
- (IBAction)pilotInfo;
- (IBAction)fighterInfo;
- (IBAction)traderInfo;
- (IBAction)engineerInfo;

@end
