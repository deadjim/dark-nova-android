// 
//  BuyShipViewController.m
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

#import "BuyShipViewController.h"
#import "ShipInfoViewController.h"
#import "AppDelegate.h"


@implementation BuyShipViewController

@synthesize ship1, ship10, ship2, ship3, ship4, ship5, ship6, ship7, ship8, ship9;
@synthesize shipInfo1, shipInfo10, shipInfo2, shipInfo3, shipInfo4, shipInfo5, shipInfo6;
@synthesize shipInfo7, shipInfo8, shipInfo9, shipPrice1, shipPrice2, shipPrice3, shipPrice4;
@synthesize shipPrice5, shipPrice6, shipPrice7, shipPrice8, shipPrice9, shipPrice10;
@synthesize shipName1, shipName2, shipName3, shipName4, shipName5, shipName6;
@synthesize shipName7, shipName8, shipName9, shipName10, cash;

-(void)dealloc {
	
	[ship1 release];
	[ship10 release];
	[ship2 release];
	[ship3 release];
	[ship4 release];
	[ship5 release];
	[ship6 release];
	[ship7 release];
	[ship8 release];
	[ship9 release];
	
	[shipInfo1 release];
	[shipInfo10 release];
	[shipInfo2 release];
	[shipInfo3 release];
	[shipInfo4 release];
	[shipInfo5 release];
	[shipInfo6 release];
	[shipInfo7 release];
	[shipInfo8 release];
	[shipInfo9 release];
	
	[shipPrice1 release];
	[shipPrice10 release];
	[shipPrice2 release];
	[shipPrice3 release];
	[shipPrice4 release];
	[shipPrice5 release];
	[shipPrice6 release];
	[shipPrice7 release];
	[shipPrice8 release];
	[shipPrice9 release];
	
	[shipName1 release];
	[shipName10 release];
	[shipName2 release];
	[shipName3 release];
	[shipName4 release];
	[shipName5 release];
	[shipName6 release];
	[shipName7 release];
	[shipName8 release];
	[shipName9 release];
	[cash release];
	
	[super dealloc];
}


-(IBAction)closeViewAction {
	[self dismissModalViewControllerAnimated:YES];
}

-(void)viewDidDisappear:(BOOL)animated {
	[super viewDidDisappear:YES];
}

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
	self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
	if (self) {

	}
	return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
	[self updateView];
}


- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
}

-(void) ShowShipInfo:(int)ship {
	ShipInfoViewController *vc = [[ShipInfoViewController alloc] initWithNibName:@"ShipInfo" bundle:nil];
	[vc setShip:ship];
	[self presentModalViewController:vc animated:YES];
	[vc release];
	
}
-(IBAction) infoShip1 {
	[self ShowShipInfo:0];
}

-(IBAction) infoShip2 {
	[self ShowShipInfo:1];	
}

-(IBAction) infoShip3 {
	[self ShowShipInfo:2];	
}

-(IBAction) infoShip4 {
	[self ShowShipInfo:3];	
}

-(IBAction) infoShip5 {
	[self ShowShipInfo:4];	
}

-(IBAction) infoShip6 {
	[self ShowShipInfo:5];	
}

-(IBAction) infoShip7 {
	[self ShowShipInfo:6];	
}

-(IBAction) infoShip8 {
	[self ShowShipInfo:7];	
}

-(IBAction) infoShip9 {
	[self ShowShipInfo:8];	
}

-(IBAction) infoShip10 {
	[self ShowShipInfo:9];	
}

-(void)updateView {
	[[[AppDelegate sharedAppDelegate]gamePlayer] determineShipPrices];
	
	shipPrice1.text = [NSString stringWithFormat:@"%@", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipPriceStr:0]];
	shipPrice2.text = [NSString stringWithFormat:@"%@", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipPriceStr:1]];
	shipPrice3.text = [NSString stringWithFormat:@"%@", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipPriceStr:2]];
	shipPrice4.text = [NSString stringWithFormat:@"%@", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipPriceStr:3]];
	shipPrice5.text = [NSString stringWithFormat:@"%@", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipPriceStr:4]];
	shipPrice6.text = [NSString stringWithFormat:@"%@", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipPriceStr:5]];
	shipPrice7.text = [NSString stringWithFormat:@"%@", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipPriceStr:6]];
	shipPrice8.text = [NSString stringWithFormat:@"%@", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipPriceStr:7]];
	shipPrice9.text = [NSString stringWithFormat:@"%@", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipPriceStr:8]];
	shipPrice10.text = [NSString stringWithFormat:@"%@", [[[AppDelegate sharedAppDelegate]gamePlayer] getShipPriceStr:9]];
	
	cash.text = [NSString stringWithFormat:@"Cash : %i cr", [[[AppDelegate sharedAppDelegate]gamePlayer]credits]];
	
	shipName1.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipName:0]; 
	shipName2.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipName:1]; 
	shipName3.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipName:2]; 
	shipName4.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipName:3]; 
	shipName5.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipName:4]; 
	shipName6.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipName:5]; 
	shipName7.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipName:6]; 
	shipName8.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipName:7]; 
	shipName9.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipName:8]; 
	shipName10.text = [[[AppDelegate sharedAppDelegate]gamePlayer] getShipName:9]; 
	
	ship1.hidden = TRUE;
	ship2.hidden = TRUE;
	ship3.hidden = TRUE;
	ship4.hidden = TRUE;
	ship5.hidden = TRUE;
	ship6.hidden = TRUE;
	ship7.hidden = TRUE;
	ship8.hidden = TRUE;
	ship9.hidden = TRUE;
	ship10.hidden = TRUE;
	
	int i = 0;
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] shouldListShip:i])
		ship1.hidden = FALSE;
	i++;
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] shouldListShip:i])
		ship2.hidden = FALSE;
	i++;
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] shouldListShip:i])
		ship3.hidden = FALSE;
	i++;
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] shouldListShip:i])
		ship4.hidden = FALSE;
	i++;
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] shouldListShip:i])
		ship5.hidden = FALSE;
	i++;
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] shouldListShip:i])
		ship6.hidden = FALSE;
	i++;
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] shouldListShip:i])
		ship7.hidden = FALSE;
	i++;
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] shouldListShip:i])
		ship8.hidden = FALSE;
	i++;
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] shouldListShip:i])
		ship9.hidden = FALSE;
	i++;
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] shouldListShip:i])
		ship10.hidden = FALSE;
		
}

- (void)viewDidAppear:(BOOL)animated  {

}

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
	int button = buttonIndex;
	
	if (button == 1) {
		[[[AppDelegate sharedAppDelegate]gamePlayer] buyShip:activeShipItem];	
		[self updateView];
	} 
}


-(void) confirmNewShip:(int)index {
	NSString *message = [[NSString alloc] initWithFormat:@"Are you sure you want to buy\na new %@?",[[[AppDelegate sharedAppDelegate]gamePlayer] getShipName:activeShipItem]];
	UIAlertView * view = [[UIAlertView alloc] initWithTitle:@"Please Confirm" message:message delegate:self cancelButtonTitle:@"No" otherButtonTitles:@"Yes", nil];
	[view show];
	[view release];
	[[[AppDelegate sharedAppDelegate]gamePlayer] playSpeechFile:@"PleaseConfirm.caf"];
	[message release];
}

-(void) buyShip:(int)index {
	
	if ([[[AppDelegate sharedAppDelegate]gamePlayer] canBuyShip:index controller:self]) {
		activeShipItem = index;
		[self confirmNewShip:activeShipItem];
	}
	
}

-(IBAction) buyShip1 {
	
	[self buyShip:0];
	[self updateView];
}

-(IBAction) buyShip2 {
	
	[self  buyShip:1];
	[self updateView];
}

-(IBAction) buyShip3 {
	
	[self  buyShip:2];
	[self updateView];
	
}

-(IBAction) buyShip4 {
	
	[self  buyShip:3];
	[self updateView];
}

-(IBAction) buyShip5 {
	
	[self  buyShip:4];
	[self updateView];
}

-(IBAction) buyShip6 {
	
	[self  buyShip:5];
	[self updateView];
}

-(IBAction) buyShip7 {
	
	[self  buyShip:6];
	[self updateView];
	
}

-(IBAction) buyShip8 {
	
	[self  buyShip:7];
	[self updateView];
}

-(IBAction) buyShip9 {
	
	[self  buyShip:8];
	[self updateView];
}

-(IBAction) buyShip10 {
	
	[self  buyShip:9];
	[self updateView];
}

@end
