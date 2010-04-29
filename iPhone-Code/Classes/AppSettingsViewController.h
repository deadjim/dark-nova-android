//
//  AppSettingsViewController.h
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

@protocol AppSettingsViewControllerDelegate;


@interface AppSettingsViewController : UIViewController <UITableViewDelegate, UITableViewDataSource, UIAlertViewDelegate> {
	id <AppSettingsViewControllerDelegate> delegate;

	NSString *deviceType;
	BOOL _soundsIsOn;
	NSArray *tableList;
	IBOutlet UITableView *myTableView;

	IBOutlet UITableViewCell			*cell00;
	IBOutlet UITableViewCell			*cell0;
	IBOutlet UITableViewCell			*cell0a;
	IBOutlet UITableViewCell			*cell1;
	IBOutlet UITableViewCell			*cell2;
	IBOutlet UITableViewCell			*cell3;
	IBOutlet UITableViewCell			*cell1a;
	
	IBOutlet UISwitch		*autoLoadGameSwitch;
	IBOutlet UISlider		*backgroundVolumeSlider;
	IBOutlet UISegmentedControl	*textColorControl;
	IBOutlet UISwitch		*backgroundMusicSwitch;
	IBOutlet UISwitch		*gameSoundsSwitch;
	IBOutlet UISwitch		*leftHandEncountersSwitch;
	IBOutlet UISwitch		*encounterTextColorSwitch;
	IBOutlet UISwitch		*speechAlertsSwitch;
		
	NSUserDefaults *defaults;
	IBOutlet UILabel *myVolume;
	IBOutlet UILabel *textColor;
	BOOL didShowNotice;

}

@property (nonatomic, retain) NSString *deviceType;
@property (nonatomic, retain) NSArray *tableList;
@property (nonatomic, retain) UITableView *myTableView;
@property (nonatomic, retain) IBOutlet UILabel *myVolume;
@property (nonatomic, retain) IBOutlet UILabel *textColor;

@property (nonatomic, retain) IBOutlet UITableViewCell *cell00;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell0;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell0a;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell1;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell2;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell3;
@property (nonatomic, retain) IBOutlet UITableViewCell *cell1a;


@property (assign) UISlider *backgroundVolumeSlider;
@property (assign) UISegmentedControl *textColorControl;

@property (assign) IBOutlet UISwitch *autoLoadGameSwitch;
@property (assign) IBOutlet UISwitch *backgroundMusicSwitch;
@property (assign) IBOutlet UISwitch *gameSoundsSwitch;
@property (assign) IBOutlet UISwitch *leftHandEncountersSwitch;
@property (assign) IBOutlet UISwitch *encounterTextColorSwitch;
@property (assign) IBOutlet UISwitch *speechAlertsSwitch;

@property (nonatomic, assign) id <AppSettingsViewControllerDelegate> delegate;

- (IBAction)autoLoadGameSwitch:(id)sender;
- (IBAction)backgroundVolumeSlider:(id)sender;
- (IBAction)gameSoundsSwitch:(id)sender;
- (IBAction)speechAlertsSwitch:(id)sender;
- (IBAction)leftHandEncountersSwitch:(id)sender;
- (IBAction)encounterTextColorSwitch:(id)sender;
- (IBAction)backgroundMusicSwitch:(id)sender;
- (IBAction)textColorSegment:(id)sender;
- (IBAction)done;

@end

@protocol AppSettingsViewControllerDelegate
- (void)appSettingsViewControllerDidFinish:(AppSettingsViewController *)controller;
@end

