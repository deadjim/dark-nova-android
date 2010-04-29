//
//  BankViewController.h
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

#define GETLOANACTION		1
#define PAYBACKLOANACTION	2
#define BUYINSURANCE		3
#define STOPINSURANCE		4
#define MAKEDEPOSIT			5
#define MAKEWITHDRAWL		6

@interface BankViewController : UIViewController <UIAlertViewDelegate> {
	IBOutlet UIButton *getLoan;
	IBOutlet UIButton *paybackLoan;
	IBOutlet UIButton *makeDeposit;
	IBOutlet UIButton *makeWithdrawl;
	IBOutlet UIButton *getInsurance;
	IBOutlet UIButton *stopInsurance;
	
	IBOutlet UILabel	*currentDeposit;
	IBOutlet UILabel	*currentDebt;
	IBOutlet UILabel	*maximumLoan;
	IBOutlet UILabel	*currentShipCost;
	IBOutlet UILabel	*noClaim;
	IBOutlet UILabel	*insuranceCosts;
	IBOutlet UILabel	*currentCash;
	
	int			actionMode;
}

@property (nonatomic, retain) IBOutlet UIButton *makeDeposit;
@property (nonatomic, retain) IBOutlet UIButton *makeWithdrawl;
@property (nonatomic, retain) IBOutlet UIButton *getLoan;
@property (nonatomic, retain) IBOutlet UIButton *paybackLoan;
@property (nonatomic, retain) IBOutlet UIButton *getInsurance;
@property (nonatomic, retain) IBOutlet UIButton *stopInsurance;
@property (nonatomic, retain) IBOutlet UILabel *currentDeposit;
@property (nonatomic, retain) IBOutlet UILabel *currentDebt;
@property (nonatomic, retain) IBOutlet UILabel *maximumLoan;
@property (nonatomic, retain) IBOutlet UILabel *currentShipCost;
@property (nonatomic, retain) IBOutlet UILabel *noClaim;
@property (nonatomic, retain) IBOutlet UILabel *insuranceCosts;
@property (nonatomic, retain) IBOutlet UILabel *currentCash;

@property int actionMode;

-(void)updateView;

-(IBAction)makeDepositAction;
-(IBAction)makeWithdrawlAction;
-(IBAction)getLoanAction;
-(IBAction)paybackLoanAction;
-(IBAction)getInsuranceAction;
-(IBAction)stopInsuranceAction;
-(IBAction)closeViewAction;

@end
