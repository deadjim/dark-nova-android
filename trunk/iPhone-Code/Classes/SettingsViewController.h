//
//  SettingsViewController.h
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

@protocol SettingsViewControllerDelegate;


@interface SettingsViewController : UIViewController <UITableViewDelegate, UITableViewDataSource, UIAlertViewDelegate> {
	id <SettingsViewControllerDelegate> delegate;

	NSString *deviceType;
	BOOL _extraSoundsOn;
	BOOL _soundsDisabled;
	NSArray *tableList;
	IBOutlet UITableView *myTableView;

	IBOutlet UITableViewCell			*cell4;
	IBOutlet UITableViewCell			*cell5;
	IBOutlet UITableViewCell			*cell6;
	IBOutlet UITableViewCell			*cell7;
	IBOutlet UITableViewCell			*cell8;
	IBOutlet UITableViewCell			*cell9;
	IBOutlet UITableViewCell			*cell10;
	IBOutlet UITableViewCell			*cell11;
	IBOutlet UITableViewCell			*cell12;
	IBOutlet UITableViewCell			*cell13;
	IBOutlet UITableViewCell			*cell14;
	IBOutlet UITableViewCell			*cell15;
	IBOutlet UITableViewCell			*cell16;
	IBOutlet UITableViewCell			*cell17;
	IBOutlet UITableViewCell			*cell18;
	
	IBOutlet UISlider		*emptyCargoBaysSlider;
	IBOutlet UISwitch		*fullTankSwitch;
	IBOutlet UISwitch		*hullRepairSwitch;
	IBOutlet UISwitch		*buyNewsSwitch;
	IBOutlet UISwitch		*loanRemindersSwitch;
	IBOutlet UISwitch		*reserveWarpSwitch;
	IBOutlet UISwitch		*alwaysPoliceSwitch;
	IBOutlet UISwitch		*alwaysPiratesSwitch;
	IBOutlet UISwitch		*alwaysTradersSwitch;
	IBOutlet UISwitch		*ignoreDealersSwitch;
	IBOutlet UISwitch		*continuousFleeingSwitch;
	IBOutlet UISwitch		*continuousFightingSwitch;
	IBOutlet UISwitch		*stopTrackingSwitch;
	IBOutlet UISwitch		*rangeToTrackedSwitch;
	
	NSUserDefaults *defaults;
	IBOutlet UILabel *myEmpty;

}

@property (nonatomic, retain) NSString *deviceType;
@property (nonatomic, retain) NSArray *tableList;
@property (nonatomic, retain) UITableView *myTableView;
@property (nonatomic, retain) IBOutlet UILabel *myEmpty;

@property (nonatomic, retain) IBOutlet UITableViewCell *cell4;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell5;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell6;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell7;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell8;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell9;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell10;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell11;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell12;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell13;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell14;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell15;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell16;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell17;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell18;

@property (assign) IBOutlet UISlider		*emptyCargoBaysSlider;

@property (assign) IBOutlet UISwitch		*fullTankSwitch;
@property (assign) IBOutlet UISwitch		*hullRepairSwitch;
@property (assign) IBOutlet UISwitch		*buyNewsSwitch;
@property (assign) IBOutlet UISwitch		*loanRemindersSwitch;
@property (assign) IBOutlet UISwitch		*reserveWarpSwitch;
@property (assign) IBOutlet UISwitch		*alwaysPoliceSwitch;
@property (assign) IBOutlet UISwitch		*alwaysPiratesSwitch;
@property (assign) IBOutlet UISwitch		*alwaysTradersSwitch;
@property (assign) IBOutlet UISwitch		*ignoreDealersSwitch;
@property (assign) IBOutlet UISwitch		*continuousFleeingSwitch;
@property (assign) IBOutlet UISwitch		*continuousFightingSwitch;
@property (assign) IBOutlet UISwitch		*stopTrackingSwitch;
@property (assign) IBOutlet UISwitch		*rangeToTrackedSwitch;

@property (nonatomic, assign) id <SettingsViewControllerDelegate> delegate;

- (IBAction)emptyCargoBaysSlider:(id)sender;

- (IBAction)fullTankSwitch:(id)sender;
- (IBAction)hullRepairSwitch:(id)sender;
- (IBAction)buyNewsSwitch:(id)sender;
- (IBAction)loanRemindersSwitch:(id)sender;
- (IBAction)reserveWarpSwitch:(id)sender;
- (IBAction)alwaysPoliceSwitch:(id)sender;
- (IBAction)alwaysPiratesSwitch:(id)sender;
- (IBAction)alwaysTradersSwitch:(id)sender;
- (IBAction)ignoreDealersSwitch:(id)sender;
- (IBAction)continuousFightingSwitch:(id)sender;
- (IBAction)continuousFleeingSwitch:(id)sender;
- (IBAction)stopTrackingSwitch:(id)sender;
- (IBAction)rangeToTrackedSwitch:(id)sender;

- (IBAction)done;

@end

@protocol SettingsViewControllerDelegate
- (void)settingsViewControllerDidFinish:(SettingsViewController *)controller;
@end

