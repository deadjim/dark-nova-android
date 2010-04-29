//
//  Player.m
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

#import "Player.h"
#include "PilotCommon.h"
#import "AppDelegate.h"
#import "EndOfGameViewController.h"
#import "EncounterViewController.h"
#import "SoundManager.h"
#import "ViewerViewController.h"


@interface Player ()

-(long) currentShipPrice:(BOOL) ForInsurance;
-(void) FrmAlert:(NSString *)MessageId;
-(void) FrmAlertWithState:(NSString *)MessageId state:(eAlertState)state;
-(void) FrmAlertWithTitle:(NSString *)MessageId Title:(NSString*)Title;
-(int) getFirstEmptySlot:( char) Slots Item:( int*) Item;
-(int)calculateTravelFee;

@end


@implementation Player

@synthesize pilotName, pilotLog, pilotSkill, fighterSkill, traderSkill, engineerSkill, gameDifficulty;
@synthesize totalSkillPoints, credits, debt, reputationScore, policeKills, traderKills, pirateKills;
@synthesize policeRecordScore, insurance, noClaim, escapePod, newsSpecialEventCount, solarSystemName;
@synthesize currentSystem, techLevel, systemSize, days, monsterStatus, dragonflyStatus, japoriDiseaseStatus;
@synthesize jarekStatus, invasionStatus, experimentStatus, fabricRipProbability, veryRareEncounter;
@synthesize browerStatus, reactorStatus, scarabStatus, warpSystem, trackedSystem, showTrackedRange;
@synthesize countDown, autoAttack, autoFlee, attackIconStatus, encounterType, textualEncounters, clicks;
@synthesize alreadyPaidForNewspaper, alreadyLoggedNews, newsAutoPay, alwaysIgnorePolice, alwaysIgnorePirates;
@synthesize currentGalaxySystem, alwaysIgnoreTraders, alwaysIgnoreTradeInOrbit, autoFuel, autoRepair;
@synthesize reserveMoney, trackAutoOff, remindLoans, leaveEmpty, canSuperWarp, gesdb, chanceOfVeryRareEncounter;
@synthesize shouldAutoFlee, shouldAutoAttack, agreedToGPTA, newestSavedGame, leftHandIsOn, numberOfPassengers;
@synthesize transportPassengers, newShip, didUsePEP, passengersDestination;
@synthesize totalPassengers, totalPEPPassengers;


BOOL bWaitFinishPlunder = FALSE;
BOOL bDummyAlert;

int *saveItem, savePrice, saveSlot, saveItemIndex;
BOOL viaSingularitySaved;
BuyEquipmentViewController *buyController;
BuyShipViewController *buyNewShipController;
SystemInfoViewController *systemInfoController;
SellCargoViewController *jettisonViewControllerInstance;
SellCargoViewController *opponentViewControllerInstance;

BOOL bLastMessage;
int plunderItem;
int plunderCount;

#pragma mark initGlobals
-(void) initGlobals {
	
	solarSystemName = [[NSArray arrayWithObjects:
						@"Acamar", //0
						@"Adahn",
						@"Alderen",
						@"Aldea",
						@"Anevian",
						@"Antidee",
						@"Balosnee",
						@"Baratas", //7
						@"Brax", 
						@"Bretel",
						@"Calondia",
						@"Capelle",
						@"Carzun",
						@"Castor",
						@"Cemper",
						@"Cestus",
						@"Cherone",
						@"Courtenee",
						@"Daled", //18
						@"Damast",
						@"Davlos",
						@"Delhem",
						@"Deneb",
						@"Deniva",
						@"Devidia", //24
						@"Dreama",
						@"Drelyn",
						@"Endore",
						@"Esmee",
						@"Exo",
						@"Feris",
						@"Feston",
						@"Formi",
						@"Frolics",
						@"Galaxia",
						@"Gemulon", //35
						@"Gwenifer",
						@"Hadees",
						@"Hamlet",
						@"Helenna",
						@"Helion Prime",
						@"Hulst",
						@"Iodine",
						@"Irailius",
						@"Ja'pori", //44
						@"Jannus",
						@"Jarada",
						@"Jason",
						@"Kaylyn",
						@"Kera",
						@"Khefka",
						@"Klautu",
						@"Klaystron",
						@"Korma",
						@"Kravat", //54
						@"Krios",
						@"Laeretes",
						@"Largo",
						@"Lave",
						@"Ligon",
						@"Lowrye",
						@"Magret",
						@"Malkoria",
						@"Melina", //63
						@"Menta",
						@"Menteka",
						@"Merik",
						@"Monta",
						@"Mordon",
						@"Murtle",
						@"NeoEM",
						@"Nix", //71
						@"Ny'on",
						@"Nyle",
						@"Odret", //74
						@"Omega",
						@"Omphalos",
						@"Opoli", //77
						@"Orrias",
						@"Othello",
						@"Panthera",
						@"Parade",
						@"Pecard",
						@"Pollux",
						@"Quator",
						@"Radran",
						@"Rakar",
						@"Rhymus",
						@"Rigulus", //88
						@"Rochanni",
						@"Rotia",
						@"Rovar",
						@"Rubikum",
						@"Satrius",
						@"Sefella",
						@"Sigma",
						@"Sloakiss", //96
						@"Somarie",
						@"Sopheton",
						@"Stakorun",
						@"Styris",
						@"T'rosa",
						@"Talonee",
						@"Tamus",
						@"Tantalous",
						@"Tarchanen",
						@"Tarnuga",
						@"Terus",
						@"Thaira",
						@"Titan",
						@"Torin",
						@"Triacus",
						@"Turkana",
						@"Umbelee",
						@"Urayo",
						@"Utopia", //115
						@"Vadra",
						@"Vagra",
						@"Vandur",
						@"Ventax",
						@"Xenon",
						@"Xerxes",
						@"Yew",
						@"Yujimbo",
						@"Zorkon", //124
						@"Zule",
						nil] retain];
	
	systemSize =[[NSArray arrayWithObjects:	@"Tiny",  @"Small", @"Medium", @"Large", @"Huge", nil] retain];	
	
	techLevel = [[NSArray arrayWithObjects: @"Pre-agricultural", @"Agricultural", @"Medieval", @"Renaissance", @"Early Industrial",
				  @"Industrial", @"Post-industrial", @"Hi-tech", nil] retain];	

}


#pragma mark initEmpty
-(id)initEmpty {
	[super init];
	
	pilotName = @"Johansen";
	pilotLog = @"";
	pilotSkill = 1;
	fighterSkill = 1;
	traderSkill = 1;
	engineerSkill = 1;
	gameDifficulty = 2;
	totalSkillPoints = 16;	
	credits = 2500;
	gesdb = 0;
	debt = 0;
	policeRecordScore = 0;
	reputationScore = 0;
	totalPassengers = 0;
	totalPEPPassengers = 0;	
	transportRatingTotal = 0;
	policeKills = 0;
	traderKills = 0;
	pirateKills = 0;
	insurance = FALSE;	
	noClaim = 0;	
	currentSystem = 1;
	days = 0;
	playerDefaults = [NSUserDefaults standardUserDefaults];
	newestSavedGame = @"";
	speechAlertsOn = [playerDefaults boolForKey:@"speechAlerts"];
	leftHandIsOn = [playerDefaults boolForKey:@"leftHandEncounter"];
	numberOfPassengers = 2;
	return self;
}

#pragma mark Ship Info
-(BOOL) AnyEmptySlots:(struct SHIP *)Ship {
	int j;
	
	for (j=0; j<Shiptype[Ship->Type].WeaponSlots; ++j) {
		if (Ship->Weapon[j] < 0) {
			return TRUE;
		}							
	}
  
	for (j=0; j<Shiptype[Ship->Type].ShieldSlots; ++j) {
		if (Ship->Shield[j] < 0) {
			return TRUE;
		}							
	}
  
	for (j=0; j<Shiptype[Ship->Type].GadgetSlots; ++j) {
		if (Ship->Gadget[j] < 0) {
			return TRUE;
		}							
	}
	
	return FALSE;
}

#pragma mark Bank & Loan
-(void) makeDeposit:(long) dep {
	gesdb += dep;
	credits -= dep;
	[[SoundManager sharedSound] playSoundWithId:kCashReg];
}

-(void) makeWithDrawl:(long) dep {
	gesdb -= dep;
	credits += dep;
	[[SoundManager sharedSound] playSoundWithId:kCashReg];
}


-(NSUInteger) currentWorth{
	NSUInteger i1 = credits - debt + [self currentShipPrice: FALSE];
	NSUInteger i2 = moonBought ? COSTMOON : 0;
	return  i1 + i2;
}
-(NSUInteger) currentNetWorth{
	return  [self currentWorth] + gesdb;
}

-(void) payInterest{
	if (debt > 0) {
		unsigned int incDebt = max(1, debt /10);
		if (credits > incDebt) {
			credits -= incDebt;
		} else {
			debt += (incDebt - credits);
		}
	}
}

-(long) maxLoan {
	return (policeRecordScore >= CLEANSCORE ? 
			min( 25000L, max( 1000L, (([self currentNetWorth] / 10L) / 500L) * 500L ) ) : 500L);
}

-(void) getLoan:(long) loan {
	long amount;
	amount = min( [self maxLoan] - debt, loan );
	credits += amount;
	debt += amount;
	[[SoundManager sharedSound] playSoundWithId:kCashReg];
}

-(void) payBack:(long) cash {
	long Amount;
	Amount = min( debt, cash );
	Amount = min( Amount, credits );
	credits -= Amount;
	debt -= Amount;
	[[SoundManager sharedSound] playSoundWithId:kCashReg];
}

inline long BaseSellPrice(int Index, int Price) {
	return (Index >= 0 ?(((float)Price * 3.0) /4.0) :0);
}

#pragma mark Ship Price
-(long) currentShipPriceWithoutCargo:(BOOL)forInsurance {
	int i;
	long CurPrice;
	
	CurPrice = 
	((Shiptype[ship.Type].Price * (ship.Tribbles > 0 && !forInsurance? 1 : 3)) / 4)
	- ([self getHullStrength] - ship.Hull) * Shiptype[ship.Type].RepairCosts 
	- (Shiptype[ship.Type].FuelTanks - [self getFuel]) * Shiptype[ship.Type].CostOfFuel;
	for (i=0; i<MAXWEAPON; ++i) {
		if (ship.Weapon[i] >= 0) {
			CurPrice += WEAPONSELLPRICE( i );
		}
	}
	
	for (i=0; i<MAXSHIELD; ++i) {
		if (ship.Shield[i] >= 0) {
			CurPrice += SHIELDSELLPRICE( i );
		}
	}
	
	for (i=0; i<MAXGADGET; ++i) {
		if (ship.Gadget[i] >= 0) {
			CurPrice += GADGETSELLPRICE( i );
		}
	}
	
	return CurPrice;
}

-(long) insuranceMoney {
	if (!insurance) {
		return 0;
	}

	return (max(1, (([self currentShipPriceWithoutCargo:TRUE] * 5) / 2000) * (100 - min(noClaim, 90)) / 100));
}

-(int) mercenaryMoney {
	int i, ToPay;
	
	ToPay = 0;
	for (i=1; i<MAXCREW; ++i) {
		if (ship.Crew[i] >= 0) {
			ToPay += MERCENARYHIREPRICE( ship.Crew[i] );
		}
	}
	return ToPay;	
}

-(char) AdaptDifficulty:( char) Level {
	if (gameDifficulty == BEGINNER || gameDifficulty == EASY)
		return (Level+1);
	else if (gameDifficulty == IMPOSSIBLE)
		return max( 1, Level-1 );
	else
		return Level;
}

-(char) TraderSkill:(struct SHIP*)Sh {
	int i;
	char MaxSkill;
	MaxSkill = Mercenary[Sh->Crew[0]].Trader;
	
	for (i=1; i<MAXCREW; ++i) {
		if (Sh->Crew[i] < 0)
			break;
		if (Mercenary[Sh->Crew[i]].Trader > MaxSkill)
			MaxSkill = Mercenary[Sh->Crew[i]].Trader;
	}
	
	if (jarekStatus >= 2)
		++MaxSkill;			
	
	return [self AdaptDifficulty:MaxSkill];
	return traderSkill;
}

-(void) RecalculateBuyPrices:(Byte)SystemID {
	int i;
	for (i=0; i<MAXTRADEITEM; ++i) {
		if (solarSystem[SystemID].TechLevel < Tradeitem[i].TechProduction)
			BuyPrice[i] = 0;
		else if (((i == NARCOTICS) && (!Politics[solarSystem[SystemID].Politics].DrugsOk)) ||
				 ((i == FIREARMS) &&	(!Politics[solarSystem[SystemID].Politics].FirearmsOk)))
			BuyPrice[i] = 0;
		else {
			if (policeRecordScore < DUBIOUSSCORE)
				BuyPrice[i] = (SellPrice[i] * 100) / 90;
			else 
				BuyPrice[i] = SellPrice[i];
			BuyPrice[i] = (BuyPrice[i] * (103 + (MAXSKILL - [self TraderSkill:&ship])) / 100);
			if (BuyPrice[i] <= SellPrice[i])
				BuyPrice[i] = SellPrice[i] + 1;
		}
	}
}

-(void) InitializeTradeItems:(int)Index {
	int i;
	for (i=0; i<MAXTRADEITEM; ++i) {
		if (((i == NARCOTICS) &&
			 (!Politics[solarSystem[Index].Politics].DrugsOk)) ||
			((i == FIREARMS) &&
			 (!Politics[solarSystem[Index].Politics].FirearmsOk)) ||
			(solarSystem[Index].TechLevel < Tradeitem[i].TechProduction)) {
			solarSystem[Index].Qty[i] = 0;
			continue;
		}
		
		solarSystem[Index].Qty[i] = 
		((9 + GetRandom( 5 )) - 
		 ABS( Tradeitem[i].TechTopProduction - solarSystem[Index].TechLevel )) * 
		(1 + solarSystem[i].Size);
		
		if (i == ROBOTS || i == NARCOTICS) 
			solarSystem[Index].Qty[i] = ((solarSystem[Index].Qty[i] * (5 - gameDifficulty)) / (6 - gameDifficulty)) + 1;
		
		if (Tradeitem[i].CheapResource >= 0)
			if (solarSystem[Index]. SpecialResources ==
				Tradeitem[i].CheapResource)
				solarSystem[Index].Qty[i] = (solarSystem[Index].Qty[i] * 4) / 3;
		
		if (Tradeitem[i].ExpensiveResource >= 0)
			if (solarSystem[Index].SpecialResources ==
				Tradeitem[i].ExpensiveResource)
				solarSystem[Index].Qty[i] = (solarSystem[Index].Qty[i] * 3) >> 2;
		
		if (Tradeitem[i].DoublePriceStatus >= 0)
			if (solarSystem[Index].Status == Tradeitem[i].DoublePriceStatus)
				solarSystem[Index].Qty[i] = solarSystem[Index].Qty[i] / 5;
		
		solarSystem[Index].Qty[i] = solarSystem[Index].Qty[i] - GetRandom( 10 ) +
		GetRandom( 10 );
		
		if (solarSystem[Index].Qty[i] < 0)
			solarSystem[Index].Qty[i] = 0;
	}
}

-(long) StandardPrice:(char)Good size:(char)Size tech:(char)Tech goverment:(char)Government resources:(int)Resources {
    long Price;
	
    if (((Good == NARCOTICS) && (!Politics[Government].DrugsOk)) ||
		((Good == FIREARMS) &&	(!Politics[Government].FirearmsOk)))
		return 0L ;
	
	Price = Tradeitem[Good].PriceLowTech + (Tech * (int)Tradeitem[Good].PriceInc);
	
	if (Politics[Government].Wanted == Good)
		Price = (Price * 4) / 3;	
	
	Price = (Price * (100 - (2 * Politics[Government].StrengthTraders))) / 100;
	
	Price = (Price * (100 - Size)) / 100;
	
	if (Resources > 0) {
		if (Tradeitem[Good].CheapResource >= 0)
			if (Resources == Tradeitem[Good].CheapResource)
				Price = (Price * 3) / 4;
		if (Tradeitem[Good].ExpensiveResource >= 0)
			if (Resources == Tradeitem[Good].ExpensiveResource)
				Price = (Price * 4) / 3;
	}
	
	if (Tech < Tradeitem[Good].TechUsage)
		return 0L;
	
	if (Price < 0)
		return 0L;
	
	return Price;
}

-(void) determinePrices:(Byte)SystemID {
	int i;
	for (i=0; i<MAXTRADEITEM; ++i) {
		BuyPrice[i] = [self StandardPrice:i size:solarSystem[SystemID].Size tech:solarSystem[SystemID].TechLevel
								goverment:solarSystem[SystemID].Politics resources:solarSystem[SystemID].SpecialResources];
		
		if (BuyPrice[i] <= 0) {
			BuyPrice[i] = 0;
			SellPrice[i] = 0;
			continue;
		}
		
		if (Tradeitem[i].DoublePriceStatus >= 0)
			if (solarSystem[SystemID].Status == Tradeitem[i].DoublePriceStatus)
				BuyPrice[i] = (BuyPrice[i] * 3) >> 1;
		
		BuyPrice[i] = BuyPrice[i] + GetRandom( Tradeitem[i].Variance ) -
		GetRandom( Tradeitem[i].Variance );
		
		if (BuyPrice[i] <= 0) {
			BuyPrice[i] = 0;
			SellPrice[i] = 0;
			continue;
		}
		
		SellPrice[i] = BuyPrice[i];
		if (policeRecordScore < DUBIOUSSCORE) {
			SellPrice[i] = (SellPrice[i] * 90) / 100;
		}
	}
	
	[self RecalculateBuyPrices:SystemID];
}

-(long) SqrDistance:(struct SOLARSYSTEM)a  b:(struct SOLARSYSTEM) b {
	return (SQR( a.X - b.X ) + SQR( a.Y - b.Y ));
}

-(long) RealDistance:(struct SOLARSYSTEM)a  b:(struct SOLARSYSTEM)b {
	return (sqrt( [self SqrDistance:a  b:b] ));
}


-(BOOL) wormholeExists:(int)a b:(int) b {
	int i;
	i = 0;
	while (i<MAXWORMHOLE) {
		if (Wormhole[i] == a)
			break;
		++i;
	}
	
	if (i < MAXWORMHOLE) {
		if (b < 0)
			return TRUE;
		else if (i < MAXWORMHOLE - 1) {
			if (Wormhole[i+1] == b)
				return TRUE;
		}
		else if (Wormhole[0] == b)
			return TRUE;
		
	}
	return FALSE;
}

-(Byte) RandomSkill {
	return 1 + GetRandom(5) + GetRandom(6);
	
}

-(BOOL) HasGadget:(struct SHIP*)Sh Gg:(Byte) Gg {
    int i;
    for (i=0; i<MAXGADGET; ++i){
	    if (Sh->Gadget[i] < 0)
	        continue;
        if (Sh->Gadget[i] == Gg)
	        return TRUE;
    }
    return FALSE;
}

-(BOOL) HasShield:( struct SHIP*) Sh Cg:(char) Gg {
    int i;
    for (i=0; i<MAXSHIELD; ++i) {
	    if (Sh->Shield[i] < 0)
	        continue;
        if (Sh->Shield[i] == Gg)
	        return TRUE;
    }
    return FALSE;
}

-(BOOL) HasWeapon:( struct SHIP*)Sh  Cg:(char)Gg exactCompare:(BOOL)exactCompare {
    int i;
    for (i=0; i<MAXWEAPON; ++i) {
	    if (Sh->Weapon[i] < 0)
	        continue;
        if ((Sh->Weapon[i] == Gg) || (Sh->Weapon[i] > Gg && !exactCompare))
	        return TRUE;
    }
    return FALSE;
}


-(Byte) getFuelTanks {
	return ([self HasGadget:&ship Gg:FUELCOMPACTOR ] ? 18 : Shiptype[ship.Type].FuelTanks);
}


-(Byte) getFuel {
	return min( ship.Fuel, [self getFuelTanks]);
}


-(void) buyFuel:(int) Amount {
	if (credits > 0) {
		int MaxFuel;
		int Parsecs;
		
		MaxFuel = ([self getFuelTanks] - [self getFuel]) * Shiptype[ship.Type].CostOfFuel;
		if (Amount > MaxFuel)
			Amount = MaxFuel;
		if (Amount > credits)
			Amount = credits;
		
		Parsecs = Amount / Shiptype[ship.Type].CostOfFuel;
		
		ship.Fuel += Parsecs;
		credits -= Parsecs * Shiptype[ship.Type].CostOfFuel;
		if (!autoFuel)
			[[SoundManager sharedSound] playSoundWithId:kRefuel];
		
	}
	else {
		[self FrmAlert:NSLocalizedString(@"NotEnoughForEventAlert", @"")];
	}
}


#pragma mark Start New Game
-(BOOL) startNewGame {
	int i, j, k, d, x, y;
	BOOL Redo, CloseFound, FreeWormhole;
		 
	i = 0;
	while (i < MAXSOLARSYSTEM) {
		if (i < MAXWORMHOLE) {
			solarSystem[i].X = (char)(((CLOSEDISTANCE>>1) - 
									   GetRandom( CLOSEDISTANCE )) + ((GALAXYWIDTH * (1 + 2*(i%3)))/6));		
			solarSystem[i].Y = (char)(((CLOSEDISTANCE>>1) - 
									   GetRandom( CLOSEDISTANCE )) + ((GALAXYHEIGHT * (i < 3 ? 1 : 3))/4));		
			Wormhole[i] = (char)i;
		}
		else {
			solarSystem[i].X = (char)(1 + GetRandom( GALAXYWIDTH - 2 ));		
			solarSystem[i].Y = (char)(1 + GetRandom( GALAXYHEIGHT - 2 ));		
		}
		
		CloseFound = FALSE;
		Redo = FALSE;
		if (i >= MAXWORMHOLE) {
			for (j=0; j<i; ++j) {
				if ([self SqrDistance:solarSystem[j] b:solarSystem[i]]  <= SQR( MINDISTANCE + 1 )) {
					Redo = TRUE;
					break;
				}
				
				if ([self SqrDistance:solarSystem[j] b:solarSystem[i]] < SQR( CLOSEDISTANCE ))
					CloseFound = TRUE;
			}
		}
		if (Redo)
			continue;
		if ((i >= MAXWORMHOLE) && !CloseFound)
			continue;
		
		solarSystem[i].TechLevel = (char)(GetRandom( MAXTECHLEVEL ));
		solarSystem[i].Politics = (char)(GetRandom( MAXPOLITICS ));
		if (Politics[solarSystem[i].Politics].MinTechLevel > solarSystem[i].TechLevel)
			continue;
		if (Politics[solarSystem[i].Politics].MaxTechLevel < solarSystem[i].TechLevel)
			continue;
		
		if (GetRandom( 5 ) >= 3)
			solarSystem[i].SpecialResources = (char)(1 + GetRandom( MAXRESOURCES - 1 ));
		else
			solarSystem[i].SpecialResources = 0;
		
		solarSystem[i].Size = (char)(GetRandom( MAXSIZE ));
		
		if (GetRandom( 100 ) < 15)
			solarSystem[i].Status = 1 + GetRandom( MAXSTATUS - 1 );
		else			
			solarSystem[i].Status = UNEVENTFUL;
		
		solarSystem[i].NameIndex = i;
		solarSystem[i].Special = -1;		
		solarSystem[i].CountDown = 0;
		solarSystem[i].Visited = FALSE;
		
		[self InitializeTradeItems: i];

		++i;

	}
	
	for (i=0; i<MAXSOLARSYSTEM; ++i) {
		d = 0;
		while (d < MAXWORMHOLE) {
			if (Wormhole[d] == i)
				break;
			++d;
		}
		j = GetRandom( MAXSOLARSYSTEM );
		if ([self wormholeExists:j b:-1])
			continue;
		x = solarSystem[i].X;
		y = solarSystem[i].Y;		
		solarSystem[i].X = solarSystem[j].X;
		solarSystem[i].Y = solarSystem[j].Y;		
		solarSystem[j].X = x;
		solarSystem[j].Y = y;		
		if (d < MAXWORMHOLE)
			Wormhole[d] = j;
	}
	
	for (i=0; i<MAXWORMHOLE; ++i) {
		j = GetRandom( MAXWORMHOLE );
		x = Wormhole[i];
		Wormhole[i] = Wormhole[j];
		Wormhole[j] = x;
	}
	
	Mercenary[0].NameIndex = 0;
	Mercenary[0].Pilot = 1;
	Mercenary[0].Fighter = 1;
	Mercenary[0].Trader = 1;
	Mercenary[0].Engineer = 1;
	
	i = 1;
	while (i <= MAXCREWMEMBER) {
		Mercenary[i].CurSystem = GetRandom( MAXSOLARSYSTEM );
		
		Redo = FALSE;
		for (j=1; j<i; ++j) {
			if (Mercenary[j].CurSystem == Mercenary[i].CurSystem) {
				Redo = TRUE;
				break;
			}
		}
		if (Mercenary[i].CurSystem == KRAVATSYSTEM)
			Redo = TRUE;
		if (Redo)
			continue;
		
		Mercenary[i].NameIndex = i;		
		Mercenary[i].Pilot = [self RandomSkill];
		Mercenary[i].Fighter = [self RandomSkill];
		Mercenary[i].Trader = [self RandomSkill];
		Mercenary[i].Engineer = [self RandomSkill];
		
		++i;
	}
    
    Mercenary[MAXCREWMEMBER-1].CurSystem = 255;
	
	solarSystem[ACAMARSYSTEM].Special  = MONSTERKILLED;
	solarSystem[BARATASSYSTEM].Special = FLYBARATAS;
	solarSystem[MELINASYSTEM].Special  = FLYMELINA;
	solarSystem[REGULASSYSTEM].Special = FLYREGULAS;
	solarSystem[ZORKONSYSTEM].Special  = DRAGONFLYDESTROYED;
	solarSystem[JAPORISYSTEM].Special  = MEDICINEDELIVERY;
	solarSystem[UTOPIASYSTEM].Special  = MOONBOUGHT;
	solarSystem[DEVIDIASYSTEM].Special = JAREKARRIVES;
	solarSystem[KRAVATSYSTEM].Special  = BROWERARRIVES;
	
	FreeWormhole = FALSE;
	k = 0;
	j = GetRandom( MAXWORMHOLE );
	while (solarSystem[Wormhole[j]].Special != -1 &&
		   Wormhole[j] != GEMULONSYSTEM && Wormhole[j] != DALEDSYSTEM && Wormhole[j] != NIXSYSTEM && k < 20) {
		j = GetRandom( MAXWORMHOLE );
		k++;
	}
    if (k < 20) {
    	FreeWormhole = TRUE;
    	solarSystem[Wormhole[j]].Special = SCARABDESTROYED;
    }
	
	d = 999;
	k = -1;
	for (i=0; i<MAXSOLARSYSTEM; ++i) {
		j = [self RealDistance:solarSystem[NIXSYSTEM] b:solarSystem[i]];
		if (j >= 70 && j < d && solarSystem[i].Special < 0 &&
		    d != GEMULONSYSTEM && d!= DALEDSYSTEM) {
			k = i;
			d = j;
		}
	}
	if (k >= 0) {
		solarSystem[k].Special = GETREACTOR;
		solarSystem[NIXSYSTEM].Special = REACTORDELIVERED;
	}
	
	i = 0;
	while (i < MAXSOLARSYSTEM) {
		d = 1 + (GetRandom( MAXSOLARSYSTEM - 1 ));
		if (solarSystem[d].Special < 0 && solarSystem[d].TechLevel >= MAXTECHLEVEL-1 &&
		    d != GEMULONSYSTEM && d != DALEDSYSTEM) {
			solarSystem[d].Special = ARTIFACTDELIVERY;
			break;
		}
		++i;
	}
	if (i >= MAXSOLARSYSTEM)
		SpecialEvent[ALIENARTIFACT].Occurrence = 0;
	
	d = 999;
	k = -1;
	for (i=0; i<MAXSOLARSYSTEM; ++i) {
		j = [ self RealDistance:solarSystem[GEMULONSYSTEM] b:solarSystem[i]];
		if (j >= 70 && j < d && solarSystem[i].Special < 0 &&
		    k != DALEDSYSTEM && k!= GEMULONSYSTEM) {
			k = i;
			d = j;
		}
	}
	if (k >= 0) {
		solarSystem[k].Special = ALIENINVASION;
		solarSystem[GEMULONSYSTEM].Special = GEMULONRESCUED;
	}
	
	d = 999;
	k = -1;
	for (i=0; i<MAXSOLARSYSTEM; ++i) {
		j =  [self RealDistance:solarSystem[DALEDSYSTEM] b:solarSystem[i]];
		if (j >= 70 && j < d && solarSystem[i].Special < 0) {
			k = i;
			d = j;
		}
	}
	if (k >= 0) {
		solarSystem[k].Special = EXPERIMENT;
		solarSystem[DALEDSYSTEM].Special = EXPERIMENTSTOPPED;
	}
	
	for (i=MOONFORSALE; i<MAXSPECIALEVENT-ENDFIXED; ++i) {
		for (j=0; j<SpecialEvent[i].Occurrence; ++j) {
			Redo = TRUE;
			while (Redo) {
				d = 1 + GetRandom( MAXSOLARSYSTEM - 1 );
				if (solarSystem[d].Special < 0) {
					if (FreeWormhole || i != SCARAB)
						solarSystem[d].Special = i;
					Redo = FALSE;
				}
			}
		}
	}
	
	for (i=0; i<200; ++i) {
		currentSystem = GetRandom( MAXSOLARSYSTEM );
		if (CURSYSTEM.Special >= 0)
			continue;
		
		if ((i < 100) && ((CURSYSTEM.TechLevel <= 0) ||
						  (CURSYSTEM.TechLevel >= 6)))
			continue;
		
		d = 0;
		for (j=0; j<MAXSOLARSYSTEM; ++j) {
			if (j == currentSystem)
				continue;
			if ([ self SqrDistance:solarSystem[j] b:CURSYSTEM] <= SQR( Shiptype[1].FuelTanks )) {
				++d;
				if (d >= 3)
					break;
			}
		}
		if (d < 3)
			continue;
		
		break;
	}
	
	credits = 2500;
	pilotLog = @"";
	debt = 0;
	days = 0;
	warpSystem = currentSystem;
	solarSystem[warpSystem].Visited = TRUE;
	policeKills = 0; 
	traderKills = 0; 
	pirateKills = 0; 
	policeRecordScore = 0;
	reputationScore = 0;
	totalPassengers = 0;
	totalPEPPassengers = 0;
	transportRatingTotal = 0;
	transporterScore = 0;
	monsterStatus = 0;
	dragonflyStatus = 0;
	scarabStatus = 0;
	japoriDiseaseStatus = 0;
	moonBought = FALSE;
	monsterHull = Shiptype[SpaceMonster.Type].HullStrength;
	escapePod = FALSE;
	insurance = FALSE;
	remindLoans = TRUE;
	noClaim = 0;
	artifactOnBoard = FALSE;
	for (i=0; i<MAXTRADEITEM; ++i)
		BuyingPrice[i] = 0;
	tribbleMessage = FALSE;
	rygellianFleasMessage = FALSE;
	jarekStatus = 0;
	invasionStatus = 0;
	experimentStatus = 0;
	fabricRipProbability = 0;
	possibleToGoThroughRip = FALSE;
	arrivedViaWormhole = FALSE;
	veryRareEncounter = 0;
	[self resetNewsEvents];
	browerStatus = 0;
	reactorStatus = 0;
	trackedSystem = -1;
	showTrackedRange = TRUE;
	justLootedMary = FALSE;
	chanceOfVeryRareEncounter = CHANCEOFVERYRAREENCOUNTER;
	alreadyPaidForNewspaper = FALSE;
	alreadyLoggedNews = FALSE;
	canSuperWarp = FALSE;
	gameLoaded = FALSE;
	leaveEmpty = 0;
	reserveMoney = FALSE;
	litterWarning= FALSE;
	agreedToGPTA = FALSE;
	encounterType = 0;
	alwaysIgnorePolice = FALSE;
	alwaysIgnorePirates = FALSE;
	alwaysIgnoreTraders = FALSE;
	alwaysIgnoreTradeInOrbit = FALSE;
	trackAutoOff = FALSE;
	chanceOfTradeInOrbit = 10;
	autoFuel = FALSE;
	autoRepair = FALSE;
	playerShipNeedsUpdate = FALSE;
	opponentShipNeedsUpdate = FALSE;
	shouldAutoAttack = FALSE;
	shouldAutoFlee = FALSE;
	textualEncounters = TRUE;
	encounterWindow = FALSE;
	transportPassengers = FALSE;
	passengersDestination = -1;
	
	ship.Type =	1;
	for (i=0; i<MAXTRADEITEM; ++i)
		ship.Cargo[i] = 0;
	ship.Weapon[0] = -1;
	for (i=1; i<MAXWEAPON; ++i)
		ship.Weapon[i] = -1;
	for (i=0; i<MAXSHIELD; ++i) {
		ship.Shield[i] = -1;
		ship.ShieldStrength[i] = 0;
	}
	for (i=0; i<MAXGADGET; ++i)
		ship.Gadget[i] = -1;
	ship.Crew[0] = 0;
	for (i=1; i<MAXCREW; ++i)
		ship.Crew[i] = -1;
	ship.Fuel = [self getFuelTanks];
	ship.Hull = Shiptype[ship.Type].HullStrength;
	ship.Tribbles = 0;
	ship.RygellianFleas = 0;
	ship.PirateHullUpgrade = FALSE;
	
	[self determinePrices:currentSystem];
	
	[self saveTheGame:@"AutoSave"];
	[self playSpeechFile:@"WelcomeCommander.caf"];
	[self updateMercenary0Data];
	return TRUE;
}

#pragma mark AlertViews
-(void)FrmAlertWithState:(NSString *)MessageId state:(eAlertState)state {
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Notice" message:NSLocalizedString(MessageId, @"") delegate:self 
										  cancelButtonTitle:@"No" otherButtonTitles:@"Yes", nil];
	[alert show];	
	[alert release];
	currentState = state;
	bLastMessage = FALSE;
}

-(void)FrmAlert:(NSString *)MessageId{
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Notice" message:NSLocalizedString(MessageId, @"") delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
	[alert show];	
	[alert release];
	currentState = eDummy;	
	bLastMessage = FALSE;
}

-(void)FrmAlertWithTitle:(NSString *)MessageId Title:(NSString*)Title{
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:Title message:NSLocalizedString(MessageId, @"") delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
	[alert show];	
	[alert release];
	currentState = eDummy;	
	bLastMessage = FALSE;
}


-(void) IncDays:(int) Amount {
	days += Amount;
	if (invasionStatus > 0 && invasionStatus < 8) {
		invasionStatus += Amount;
		if (invasionStatus >= 8) {
			solarSystem[GEMULONSYSTEM].Special = GEMULONINVADED;
			solarSystem[GEMULONSYSTEM].TechLevel = 0;
			solarSystem[GEMULONSYSTEM].Politics = ANARCHY;
		}
	}
	
	if (reactorStatus > 0 && reactorStatus < 21) {
		reactorStatus += Amount;
		if (reactorStatus > 20)
			reactorStatus = 20;
		
	}
	
	if (experimentStatus > 0 && experimentStatus < 12) {
		experimentStatus += Amount;
		if (experimentStatus > 11) {
			fabricRipProbability = FABRICRIPINITIALPROBABILITY;
			solarSystem[DALEDSYSTEM].Special = EXPERIMENTNOTSTOPPED;
			experimentStatus = 12;
			
			[self 	FrmAlert:NSLocalizedString(@"ExperimentPerformedAlert",@"")];
			[self addNewsEvent:EXPERIMENTPERFORMED];			
		}
	}
	else if (experimentStatus == 12 && fabricRipProbability > 0) {
		fabricRipProbability -= Amount;
	}
}

-(long)getSellPrice:(int)num {
	return SellPrice[num];
}

-(long)getBuyPrice:(int)num {
	return BuyPrice[num];
}

-(long)getBuyingPrice:(int)num {
	return BuyingPrice[num];
}

-(void) ShuffleStatus {
	int i;
	
	for (i=0; i<MAXSOLARSYSTEM; ++i) {
		if (solarSystem[i].Status > 0) {
			if (GetRandom( 100 ) < 15)
				solarSystem[i].Status = UNEVENTFUL;
		}
		else if (GetRandom( 100 ) < 15)
			solarSystem[i].Status = 1 + GetRandom( MAXSTATUS - 1 );
	}
}

-(int) totalCargoBays {
	int Bays;
	int i;
	Bays = Shiptype[ship.Type].CargoBays;
	for (i=0; i<MAXGADGET; ++i)
		if (ship.Gadget[i] == EXTRABAYS)
			Bays += 5;
	if (japoriDiseaseStatus == 1)
		Bays -= 10;
	if (reactorStatus > 0 && reactorStatus < 21)
		Bays -= (5 + 10 - (reactorStatus - 1)/2);
	
	if (transportPassengers) {
		Bays -= (numberOfPassengers * BAYSPERPASSNGR);
	}
	
	return Bays;
}


-(long) wormholeTax:(int)a b:(int) b {
	if ([self wormholeExists:a b:b])
		return( Shiptype[ship.Type].CostOfFuel * 25L );
	
	return 0L;
}

#pragma mark Handle Arrival
- (void)encounterViewControllerDidFinish:(EncounterViewController *)controller {
	[[[AppDelegate sharedAppDelegate]navigationController]dismissModalViewControllerAnimated:YES];
	[encounterViewControllerInstance release];
}

-(void)closeTheEncounterView {
	[self encounterViewControllerDidFinish:encounterViewControllerInstance];
}

static void planetNameCompletionCallback(SystemSoundID mySSID, void* myself) {
	AudioServicesRemoveSystemSoundCompletion(mySSID);
}

-(void) playThePlanetSoundFile {
	AudioServicesPlaySystemSound(planetNameSoundID);		
	AudioServicesAddSystemSoundCompletion(planetNameSoundID, NULL, NULL, planetNameCompletionCallback, (void*) self);
}

-(void) planetNameSoundIsDone {
	nameSoundIsDone = TRUE;
}

-(void) playPassengersBoardedNotice {
	[self playSpeechFile:@"PassengersBoarded.caf"];
}	

-(void) playWelcomeAnnouncement {
	if (speechAlertsOn) {
		NSString *filePath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:[NSString stringWithFormat:@"Systems/System%i.caf", currentSystem]];
		NSURL *url = [NSURL fileURLWithPath:filePath];
		
		AudioServicesCreateSystemSoundID ((CFURLRef)url, &planetNameSoundID);
		[[SoundManager sharedSound] playSoundWithId:kWelcomeTo];
		[self performSelector:@selector(playThePlanetSoundFile) withObject:self afterDelay:0.87];
		[self performSelector:@selector(planetNameSoundIsDone) withObject:self afterDelay:1.2];		
	}	
}

-(void) showPassengerDebarkNotice {
	[self FrmAlert:NSLocalizedString(@"PassengersHaveDisembarked", @"")];
	[self playSpeechFile:@"PassengersDisembarked.caf"];
}

#pragma mark Arrival
-(void) Arrival {
	self.currentSystem = warpSystem;
	CURSYSTEM.Visited = TRUE;
	[self ShuffleStatus];
	[self determinePrices:currentSystem];
	self.alreadyPaidForNewspaper = FALSE;
	self.alreadyLoggedNews = FALSE;
	float delayAmount;
	if (encounterWindow) {
		[self performSelector:@selector(closeTheEncounterView) withObject:self afterDelay:1.0];
		encounterWindow = FALSE;		
	}

	if (arrivedViaWormhole)
		[[SoundManager sharedSound] playSoundWithId:kWormJumpArrive];
	
	delayAmount = 1.2f;
	if ((currentSystem == passengersDestination) && transportPassengers) {
		bLastMessage = FALSE;
		credits += (int)([self calculateTravelFee] * .80);
		totalPassengers += numberOfPassengers;
		transportRatingTotal += numberOfPassengers;
		transportPassengers = FALSE;
		trackedSystem = -1;
		didUsePEP = FALSE;
		[self performSelector:@selector(showPassengerDebarkNotice) withObject:self afterDelay:delayAmount];
		delayAmount += 2.0f;
	}
	if (!transportPassengers) {
		self.numberOfPassengers = [self getNumOfPassengers];
		passengersDestination = [self getPassengerPlanet];		
	}

	[[[AppDelegate sharedAppDelegate]commandView] systemInformation];
	
	[self performSelector:@selector(playWelcomeAnnouncement) withObject:self afterDelay:delayAmount];
	
	[[SoundManager sharedSound] playSoundWithId:kPowerDown];
	[[AppDelegate sharedAppDelegate]switchTrack];

}

-(int) filledCargoBays {
	int sum, i;
	sum = 0;
	for (i=0; i<MAXTRADEITEM; ++i)
		sum = sum + ship.Cargo[i];
	
	return sum;
}

-(void)FrmAlertOkCancel:(NSString *)MessageId state:(eAlertState)state {
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Alert" message:NSLocalizedString(MessageId, @"") delegate:self cancelButtonTitle:@"Cancel" otherButtonTitles:@"Ok"];
	[alert show];
	[alert release];
	currentState = state;
	bLastMessage = FALSE;
}

-(long) toSpend {
	if (!reserveMoney)
		return credits;
	return max( 0,  credits - [self mercenaryMoney] - [self insuranceMoney] - [self wormholeTax:currentSystem  b:warpSystem] );
}


-(void) buyCargo:(int)Index  Amount:(int)Amount {
	int ToBuy;
    if (debt > DEBTTOOLARGE) {
		[self FrmAlert:NSLocalizedString(@"DebtTooLargeForBuyAlert", @"")];
        return;
    }
	
	if (CURSYSTEM.Qty[Index] <= 0 || BuyPrice[Index] <= 0) {
		[self FrmAlert:NSLocalizedString(@"NothingAvailableAlert", @"")];
		return;
	}
	
	if ([self totalCargoBays] - [self filledCargoBays] - leaveEmpty <= 0) {
		[self FrmAlert:NSLocalizedString(@"NoEmptyBaysAlert", @"")];
		return;
	}
	
	if ([self toSpend] < BuyPrice[Index] ) {
		[self FrmAlert:NSLocalizedString(@"CantAffordAlert", @"")];
		return;
	}
	ToBuy = min( Amount, CURSYSTEM.Qty[Index] );
	ToBuy = min( ToBuy, [self totalCargoBays] - [self filledCargoBays] - leaveEmpty );
	ToBuy = min( ToBuy, [self toSpend] / BuyPrice[Index] );
	
	ship.Cargo[Index] += ToBuy;
	credits -= ToBuy * BuyPrice[Index];
	BuyingPrice[Index] += ToBuy * BuyPrice[Index];
	CURSYSTEM.Qty[Index] -= ToBuy;
}

-(int)getAmountToBuy:(int)Index {
	
	if (BuyPrice[Index] <= 0 || CURSYSTEM.Qty[Index]  <= 0) {
		return 0;
	}
	long count = min([self toSpend] / BuyPrice[Index],  CURSYSTEM.Qty[Index]);
	
	return count;
}

-(int)getAmountToSell:(int)Index {
	return 	ship.Cargo[Index];
}

-(int)getOpponentAmountToSell:(int)Index {
	return 	Opponent.Cargo[Index];
}

#pragma mark Sell Cargo
-(void) sellCargo:(int)Index  Amount:(int)Amount Operation:(Byte)Operation {
	
	if (Operation == JETTISONCARGO) {
		if (policeRecordScore > DUBIOUSSCORE && !litterWarning) {
			litterWarning = TRUE;
		}
	}
	
	int ToSell = min(Amount, ship.Cargo[Index]);
	
	BuyingPrice[Index] = (BuyingPrice[Index] * (ship.Cargo[Index] - ToSell)) / ship.Cargo[Index];
	if (SellPrice[Index] > 0) {
		if(Operation == SELLCARGO)
			credits += ToSell * SellPrice[Index];
		else
			if (Operation == DUMPCARGO)
				credits -= ToSell * 5 * (gameDifficulty + 1);
			else {
				if (GetRandom(10) < gameDifficulty + 1) {
					if (policeRecordScore > DUBIOUSSCORE)
						policeRecordScore = DUBIOUSSCORE;
					else
						policeRecordScore -= 1;  
					[self addNewsEvent:CAUGHTLITTERING];
				}
			}
		ship.Cargo[Index] -= ToSell;
	}
	if (Operation == DUMPCARGO) {
		ship.Cargo[Index] -= ToSell;
	}
	
}

-(int) getSolarSystemX:(int)Index {
	return solarSystem[Index].X;
}

-(int) getSolarSystemY:(int)Index {
	return solarSystem[Index].Y;
}

-(BOOL) getSolarSystemVisited:(int)Index {
	return solarSystem[Index].Visited;
}

-(NSString*)getSolarSystemName:(int)Index {
	return [[self solarSystemName] objectAtIndex:Index];	
}
-(int)getCurrentSystemIndex {
	return currentSystem;
}

-(Byte)getCurrentSystemTechLevelInt {
	return solarSystem[currentSystem].TechLevel;
}

-(Byte)getCurrentShipTechLevel {
	return Shiptype[0].MinTechLevel;
}

-(long) realDistance:(int)a  b:(int)b {
	return (sqrt( [self SqrDistance:solarSystem[a]  b:solarSystem[b]] ));
}

#pragma mark doWarp
-(void) doWarp:(BOOL)viaSingularity {
	int i, Distance;
	
	if( currentSystem == warpSystem) {
		UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Invalid Destination" message:NSLocalizedString(@"You are already here.", @"")  
															  delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
		
		[myAlertView show];
		[myAlertView release];
		[self showUserNotice:aAlert];
		bLastMessage = FALSE;
		return;		    
	} 
	
	Distance = [self realDistance: currentSystem b:warpSystem] ;
	if (Distance > [self getFuel] && !viaSingularity &&![self wormholeExists:currentSystem b:warpSystem]) {
		UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Insufficient Fuel" message:@"Not enough fuel for this warp."  
															  delegate:self cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
		
		[myAlertView show];
		[myAlertView release];		
		[self showUserNotice:aAlert];
		bLastMessage = FALSE;
		return;		
	}
	if (browerStatus == 1) {	
		if (! [self HasWeapon:&ship Cg:BEAMLASERWEAPON exactCompare:FALSE]) { 
			viaSingularitySaved = viaSingularity;
			
			currentState = eBrowerWeaponBuy;
			
			AlertModalTextWindow *myAlertView = [[AlertModalTextWindow alloc] initWithTitle:@"Alert" yoffset:90 message:NSLocalizedString(@"BrowerWontGetAboardAlert", @"") 
																			delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Say Goodbye"  thirdButtonTitle:nil];
			
			[myAlertView show];
			[myAlertView release];					
		}
	}
	if (debt > DEBTTOOLARGE) {
	    [self FrmAlert:NSLocalizedString(@"DebtTooLargeForTravelAlert", @"")];
		[self showUserNotice:aAlert];
		bLastMessage = FALSE;
	    return;
	}
	if ([self mercenaryMoney] > credits) {
		[self FrmAlert:NSLocalizedString(@"MustPayMercenariesAlert", @"")];
		[self showUserNotice:aAlert];
		bLastMessage = FALSE;
		return; 
	}
	if (insurance) {
		if ([self insuranceMoney] + [self mercenaryMoney] > credits) {
			[self FrmAlert:NSLocalizedString(@"CantPayInsuranceAlert", @"")];
			[self showUserNotice:aAlert];
			bLastMessage = FALSE;
			return;
		}
	}
	if ([self insuranceMoney] + [self mercenaryMoney] + [self wormholeTax:currentSystem  b:warpSystem] > credits) {
		[self showUserNotice:aAlert];
		[self FrmAlert:NSLocalizedString(@"CantPayWormholeAlert", @"")];
		bLastMessage = FALSE;
		return;
	}
	
	if (! viaSingularity) {
		credits -= [self wormholeTax:currentSystem b:warpSystem];
		credits -= [self mercenaryMoney];						
		credits -= [self insuranceMoney];
	}
	
	for (i=0; i<MAXSHIELD; ++i) {
		if (ship.Shield[i] < 0)
			break;
		ship.ShieldStrength[i] = Shieldtype[ship.Shield[i]].Power;
	}
	
	countDown = STARTCOUNTDOWN;
	if ([self wormholeExists:currentSystem b:warpSystem]  || viaSingularity) {
		arrivedViaWormhole = TRUE;
	} else {
		Distance = [self realDistance: currentSystem b:warpSystem] ;
		ship.Fuel -= min( Distance, [self getFuel] );
		arrivedViaWormhole = FALSE;
	}
	
	[self resetNewsEvents];
	if (!viaSingularity) {
		[self payInterest];
		[self IncDays:1];
		if (insurance)
			++noClaim;
	} else {
		[self addNewsEvent:ARRIVALVIASINGULARITY];
	}
	
	clicks = 21;
	raided = FALSE;
	inspected = FALSE;
	litterWarning = FALSE;
	encounterWindow = FALSE;
	
	monsterHull = (monsterHull * 105) / 100;
	if (monsterHull > Shiptype[SpaceMonster.Type].HullStrength) {
		monsterHull = Shiptype[SpaceMonster.Type].HullStrength;
	}
	
	if (days%3 == 0) {
		if (policeRecordScore > CLEANSCORE)
			--policeRecordScore;
	}
	
	if (policeRecordScore < DUBIOUSSCORE)
		if (gameDifficulty <= NORMAL)
			++policeRecordScore;
		else if (days%gameDifficulty == 0)
			++policeRecordScore;
	
	possibleToGoThroughRip=TRUE;
	
	[self determinePrices:warpSystem];
	if(arrivedViaWormhole)
		[[SoundManager sharedSound] playSoundWithId:kWormJump];
	else 
		[[SoundManager sharedSound] playSoundWithId:kHyperWarp];
		
	[[AppDelegate sharedAppDelegate]switchTrack];

	[self travel];
}

-(Byte)getWormhole:(int)Index {
	return Wormhole[Index];
}

-(char) EngineerSkill:(struct SHIP *) Sh {
	int i;
	char MaxSkill;
	
	MaxSkill = Mercenary[Sh->Crew[0]].Engineer;
	
	for (i=1; i<MAXCREW; ++i) {
		if (Sh->Crew[i] < 0) {
			break;
		}
		if (Mercenary[Sh->Crew[i]].Engineer > MaxSkill) {
			MaxSkill = Mercenary[Sh->Crew[i]].Engineer;      
		}
	}
	
	if ([self HasGadget:Sh Gg:AUTOREPAIRSYSTEM])
		MaxSkill += SKILLBONUS;			
	
	return [self AdaptDifficulty:MaxSkill];
}


-(void) GenerateOpponent:( char) Opp {
	BOOL Redo;
	int i, j, sum, Tries;
	long d, e, f, k, m;
	int Bays;
	
	[encounterViewControllerInstance SetLabelText:@""];
	Tries = 1;
	
	if (Opp == FAMOUSCAPTAIN) {
		Opponent.Type = MAXSHIPTYPE - 1;
		for (i=0;i<MAXSHIELD;i++) {
			Opponent.Shield[i] = REFLECTIVESHIELD; 
			Opponent.ShieldStrength[i]= RSHIELDPOWER;
		}
    
		for (i=0;i<MAXWEAPON;i++) {
			Opponent.Weapon[i] = MILITARYLASERWEAPON; 
		}
    
		Opponent.Gadget[0]=TARGETINGSYSTEM;
		Opponent.Gadget[1]=NAVIGATINGSYSTEM;
		Opponent.Hull = Shiptype[MAXSHIPTYPE - 1].HullStrength;
		Opponent.Crew[0] = MAXCREWMEMBER;
		Mercenary[Opponent.Crew[0]].Pilot = MAXSKILL;
		Mercenary[Opponent.Crew[0]].Fighter = MAXSKILL;
		Mercenary[Opponent.Crew[0]].Trader = MAXSKILL;
		Mercenary[Opponent.Crew[0]].Engineer = MAXSKILL;
		return;
	}
	
	if (Opp == MANTIS) {
		Tries = 1+gameDifficulty;
	}
	
	if (Opp == POLICE) {
		if (policeRecordScore < VILLAINSCORE && browerStatus != 1) {
			Tries = 3;
    } else if (policeRecordScore < PSYCHOPATHSCORE || browerStatus == 1) {
			Tries = 5;
    }

		Tries = max( 1, Tries + gameDifficulty - NORMAL );
	}
	
	if (Opp == PIRATE) {
		Tries = 1 + ([self currentNetWorth] / 100000L);
		Tries = max( 1, Tries + gameDifficulty - NORMAL );
	}
	
	j = 0;
	if (Opp == TRADER)
		Opponent.Type = 0;
	else
		Opponent.Type = 1;
	
	k = (gameDifficulty >= NORMAL ? gameDifficulty - NORMAL : 0);
	
	while (j < Tries) {
		Redo = TRUE;
		
		while (Redo) {
			d = GetRandom( 100 );
			i = 0;
			sum = Shiptype[0].Occurrence;
			
			while (sum < d) {
				if (i >= MAXSHIPTYPE-1) {
					break;
				}
				++i;
				sum += Shiptype[i].Occurrence;
			}
			
			if (Opp == POLICE && (Shiptype[i].Police < 0 || Politics[solarSystem[warpSystem].Politics].StrengthPolice + k < Shiptype[i].Police)) {
				continue;
			}
			
			if (Opp == PIRATE && (Shiptype[i].Pirates < 0 || Politics[solarSystem[warpSystem].Politics].StrengthPirates + k < Shiptype[i].Pirates)) {
				continue;
			}
			
			if (Opp == TRADER && (Shiptype[i].Traders < 0 || Politics[solarSystem[warpSystem].Politics].StrengthTraders + k < Shiptype[i].Traders)) {
				continue;
			}
			
			Redo = FALSE;
		}
		
		if (i > Opponent.Type) {
			Opponent.Type = i;
		}
		
		++j;
	}
	
	if (Opp == MANTIS) {
		Opponent.Type = MANTISTYPE;
	} else {
		Tries = max( 1, ([self currentNetWorth] / 150000L) + gameDifficulty - NORMAL );    
	}	
	
	if (Shiptype[Opponent.Type].GadgetSlots <= 0) {
		d = 0;
	} else if (gameDifficulty <= HARD) {
		d = GetRandom( Shiptype[Opponent.Type].GadgetSlots + 1 );
		if (d < Shiptype[Opponent.Type].GadgetSlots) {
			if (Tries > 4) {
				++d;
			} else if (Tries > 2) {
				d += GetRandom( 2 );
			}
		}
	} else {
		d = Shiptype[Opponent.Type].GadgetSlots;
	}
	
	for (i=0; i<d; ++i) {
		e = 0;
		f = 0;
		while (e < Tries) {
			k = GetRandom( 100 );
			j = 0;
			sum = Gadgettype[0].Chance;
			while (k < sum) {
				if (j >= MAXGADGETTYPE - 1) {
					break;
				}
				++j;
				sum += Gadgettype[j].Chance;
			}
			
			if (![self HasGadget:&Opponent Gg:j]) {
				if (j > f) {
					f = j;
				}
			}
			++e;
		}
		Opponent.Gadget[i] = f;
	}
	
	for (i=d; i<MAXGADGET; ++i)
		Opponent.Gadget[i] = -1;
	
	Bays = Shiptype[Opponent.Type].CargoBays;
	for (i=0; i<MAXGADGET; ++i)
		if (Opponent.Gadget[i] == EXTRABAYS)
			Bays += 5;
	
	for (i=0; i<MAXTRADEITEM; ++i)
		Opponent.Cargo[i] = 0;
	
	if (Bays > 5) {
		if (gameDifficulty >= NORMAL) {
			m = 3 + GetRandom( Bays - 5 );
			sum = min( m, 15 );
		}
		else
			sum = Bays;
		if (Opp == POLICE)
			sum = 0;
		if (Opp == PIRATE) {
			if (gameDifficulty < NORMAL)
				sum = (sum * 4) / 5;
			else
				sum = sum / gameDifficulty;
		}
		if (sum < 1)
			sum = 1;
		
		i = 0;
		while (i < sum) {
			j = GetRandom( MAXTRADEITEM );
			k = 1 + GetRandom( 10 - j );
			if (i + k > sum)
				k = sum - i;
			Opponent.Cargo[j] += k;
			i += k;
		}
	}
	
	Opponent.Fuel = Shiptype[Opponent.Type].FuelTanks;
	
	Opponent.Tribbles = 0;
	
	if (Shiptype[Opponent.Type].WeaponSlots <= 0)
		d = 0;
	else if (Shiptype[Opponent.Type].WeaponSlots <= 1)
		d = 1;
	else if (gameDifficulty <= HARD) {
		d = 1 + GetRandom( Shiptype[Opponent.Type].WeaponSlots );
		if (d < Shiptype[Opponent.Type].WeaponSlots)
			if (Tries > 4 && gameDifficulty >= HARD)
				++d;
			else if (Tries > 3 || gameDifficulty >= HARD)
				d += GetRandom( 2 );
	}
	else
		d = Shiptype[Opponent.Type].WeaponSlots;
	for (i=0; i<d; ++i) {
		e = 0;
		f = 0;
		while (e < Tries) {
			k = GetRandom( 100 );
			j = 0;
			sum = Weapontype[0].Chance;
			while (k < sum) {
				if (j >= MAXWEAPONTYPE - 1)
					break;
				++j;
				sum += Weapontype[j].Chance;
			}
			if (j > f)
				f = j;
			++e;
		}
		Opponent.Weapon[i] = f;
	}
	for (i=d; i<MAXWEAPON; ++i)
		Opponent.Weapon[i] = -1;
	
	if (Shiptype[Opponent.Type].ShieldSlots <= 0)
		d = 0;
	else if (gameDifficulty <= HARD) {
		d = GetRandom( Shiptype[Opponent.Type].ShieldSlots + 1 );
		if (d < Shiptype[Opponent.Type].ShieldSlots)
			if (Tries > 3)
				++d;
			else if (Tries > 1)
				d += GetRandom( 2 );
	}
	else
		d = Shiptype[Opponent.Type].ShieldSlots;
	for (i=0; i<d; ++i) {
		e = 0;
		f = 0;
		while (e < Tries) {
			k = GetRandom( 100 );
			j = 0;
			sum = Shieldtype[0].Chance;
			while (k < sum)
			{
				if (j >= MAXSHIELDTYPE - 1)
					break;
				++j;
				sum += Shieldtype[j].Chance;
			}
			if (j > f)
				f = j;
			++e;
		}
		Opponent.Shield[i] = f;
		
		j = 0;
		k = 0;
		while (j < 5) {
			e = 1 + GetRandom( Shieldtype[Opponent.Shield[i]].Power );
			if (e > k)
				k = e;
			++j;
		}
		Opponent.ShieldStrength[i] = k;			
	}
	for (i=d; i<MAXSHIELD; ++i) {
		Opponent.Shield[i] = -1;
		Opponent.ShieldStrength[i] = 0;
	}
	
	i = 0;
	k = 0;
	if (Opponent.Shield[0] >= 0 && GetRandom( 10 ) <= 7)
		Opponent.Hull = Shiptype[Opponent.Type].HullStrength;
	else {
		while (i < 5) {
			d = 1 + GetRandom( Shiptype[Opponent.Type].HullStrength );
			if (d > k)
				k = d;
			++i;
		}
		Opponent.Hull = k;			
	}
	
	if (Opp == MANTIS || Opp == FAMOUSCAPTAIN)
		Opponent.Hull = Shiptype[Opponent.Type].HullStrength;
	
	Opponent.Crew[0] = MAXCREWMEMBER;
	Mercenary[Opponent.Crew[0]].Pilot = 1 + GetRandom( MAXSKILL );
	Mercenary[Opponent.Crew[0]].Fighter = 1 + GetRandom( MAXSKILL );
	Mercenary[Opponent.Crew[0]].Trader = 1 + GetRandom( MAXSKILL );
	Mercenary[Opponent.Crew[0]].Engineer = 1 + GetRandom( MAXSKILL );
	if (warpSystem == KRAVATSYSTEM && browerStatus == 1 && (GetRandom(10)<gameDifficulty + 1)) {
		Mercenary[Opponent.Crew[0]].Engineer = MAXSKILL;
	}
	if (gameDifficulty <= HARD) {
		d = 1 + GetRandom( Shiptype[Opponent.Type].CrewQuarters );
		if (gameDifficulty >= HARD && d < Shiptype[Opponent.Type].CrewQuarters)
			++d;
	}
	else
		d = Shiptype[Opponent.Type].CrewQuarters;
	for (i=1; i<d; ++i)
		Opponent.Crew[i] = GetRandom( MAXCREWMEMBER );
	for (i=d; i<MAXCREW; ++i)
		Opponent.Crew[i] = -1;
}

-(BOOL) Cloaked:(struct SHIP*) Sh b:(struct SHIP*) Opp {
	return ([self HasGadget:Sh Gg:CLOAKINGDEVICE]  && ([self EngineerSkill:Sh] > [self EngineerSkill: Opp]));
}

-(long) getHullStrength {
	if (scarabStatus == 3)
		return Shiptype[ship.Type].HullStrength + UPGRADEDHULL;
	else
		return Shiptype[ship.Type].HullStrength + ship.PirateHullUpgrade;
}

-(long) getShipHull {
	return ship.Hull;
}

-(long) getShipOpponentHull {
	return Opponent.Hull;
}

-(long) TotalShields:(struct SHIP*) Sh {
	int i;
	long j;
	
	j = 0;
	for (i=0; i<MAXSHIELD; ++i) {
		if (Sh->Shield[i] < 0)
			break;
		j += Shieldtype[Sh->Shield[i]].Power;
	}
	return j;
}


-(long) TotalShieldStrength:(struct SHIP*) Sh {
	int i;
	long k;
	k = 0;
	for (i=0; i<MAXSHIELD; ++i) {
		if (Sh->Shield[i] < 0)
			break;
		k += Sh->ShieldStrength[i];
	}
	return k;
}


-(long) currentShipPrice:(BOOL) ForInsurance {
	int i;
	long CurPrice;
	
	CurPrice = [self currentShipPriceWithoutCargo:ForInsurance];
	for (i=0; i<MAXTRADEITEM; ++i)
		CurPrice += BuyingPrice[i];
	
	return CurPrice;
}	

-(void) determineShipPrices {
	int i;
	
	for (i=0; i<MAXSHIPTYPE; ++i) {
		if (Shiptype[i].MinTechLevel <= CURSYSTEM.TechLevel)
		{
			ShipPrice[i] = BASESHIPPRICE( i ) - [self currentShipPrice:FALSE];
			if (ShipPrice[i] == 0) 
				ShipPrice[i] = 1;
		}
		else
			ShipPrice[i] = 0;
	}
}

#pragma mark Create New Ship
-(void)createShip:(int) Index {
	int i;
	ship.Type = Index;
	for (i=0; i<MAXWEAPON; ++i) {
		ship.Weapon[i] = -1;
    }
	
	for (i=0; i<MAXSHIELD; ++i) {
		ship.Shield[i] = -1;
		ship.ShieldStrength[i] = 0;
    }
	
	for (i=0; i<MAXGADGET; ++i) {
		ship.Gadget[i] = -1;
    }
	
	for (i=0; i<MAXTRADEITEM; ++i) {
		ship.Cargo[i] = 0;
		BuyingPrice[i] = 0;
	}
	ship.PirateHullUpgrade = 0;
	ship.Fuel = [self getFuelTanks];
	ship.Hull = Shiptype[ship.Type].HullStrength;
}


-(void) buyShip:(int) Index {
	[self createShip:Index];
	if (credits < ShipPrice[Index]) {
		gesdb -= (ShipPrice[Index] - credits);
		credits = 0;
	}
	else {
		credits -= ShipPrice[Index];
	}
	if (scarabStatus == 3)
		scarabStatus = 0;
	[[SoundManager sharedSound] playSoundWithId:kCashReg];
}


-(void) CreateFlea {
	int i;
	
	[self createShip:0];
	
	for (i=1; i<MAXCREW; ++i)
		ship.Crew[i] = -1;
	
	escapePod = FALSE;
	noClaim = 0;
}

#pragma mark EscapeWithPod
-(void) EscapeWithPod {
	if (credits > 500)
		credits -= 500;
	else {
		debt += (500 - credits);
		credits = 0;
	}
	
	[self IncDays: 3 ];		
		
	if (scarabStatus == 3)
		scarabStatus = 0;
	
	[self Arrival];
	
	if (reactorStatus > 0 && reactorStatus < 21) {
		[self FrmAlert:NSLocalizedString(@"ReactorDestroyedAlert", @"")];
		reactorStatus = 0;
	}
	
	if (japoriDiseaseStatus == 1) {
		[self FrmAlert:NSLocalizedString(@"AntidoteDestroyedAlert", @"")];
		japoriDiseaseStatus = 0;
	}
	
	if (artifactOnBoard) {
		[self FrmAlert:NSLocalizedString(@"ArtifactNotSavedAlert", @"")];
		artifactOnBoard = FALSE;
	}
	
	if (jarekStatus == 1) {
		[self FrmAlert:NSLocalizedString(@"JarekTakenHomeAlert", @"")];
		jarekStatus = 0;
	}
	
	if (browerStatus == 1) {
		[self FrmAlert:NSLocalizedString(@"BrowerArrestedAlert", @"")];
		policeRecordScore += CAUGHTWITHBROWERSCORE;
		[self addNewsEvent:BROWERARRESTED];
		browerStatus = 0;
	}
	
	if (ship.Tribbles > 0) {
		[self FrmAlert:NSLocalizedString(@"TribbleSurvivedAlert", @"")];
		ship.Tribbles = 0;
	}
	
	if (insurance) {
		[self FrmAlert:NSLocalizedString(@"InsurancePaysAlert", @"")];
		credits += [self currentShipPriceWithoutCargo: TRUE ];
		insurance = FALSE;
	}
	
	if (transportPassengers) {
		[self passengersUsePEP];
	}
	
	[self FrmAlert:NSLocalizedString(@"NaniteBuiltAlert", @"")];
	[self FrmAlert:NSLocalizedString(@"EscapePodActivatedAlert", @"")];
	[self playSoundFile:@"Destroyed.caf"];
	[self CreateFlea];
	[self saveTheGame:@"AutoSave"];
	
}

-(long) TotalWeapons:(struct SHIP*) Sh  minWeapon:(int) minWeapon  maxWeapon:(int) maxWeapon {
    int i;
    long j;
	
    j = 0;
    for (i=0; i<MAXWEAPON; ++i) {
	    if (Sh->Weapon[i] < 0)
	        break;
		
		if ((minWeapon != -1 && Sh->Weapon[i] < minWeapon) ||
		    (maxWeapon != -1 && Sh->Weapon[i] > maxWeapon))
			continue;
		
	    j += Weapontype[Sh->Weapon[i]].Power;
    }
    return j;
}

-(void) Arrested {
	long Fine, Imprisonment;
	int i;
	Fine = ((1 + ((([self currentNetWorth] * min( 80, -policeRecordScore )) / 100) / 500)) * 500);
	if (browerStatus == 1) {
		Fine *= 1.05;
	}
	Imprisonment = max( 30, -policeRecordScore );
	
	[self FrmAlert:NSLocalizedString(@"ArrestedAlert", @"")];
		
	if (ship.Cargo[NARCOTICS] > 0 || ship.Cargo[FIREARMS] > 0) {
		[self FrmAlert:NSLocalizedString(@"ImpoundAlert", @"")];
		ship.Cargo[NARCOTICS] = 0;
		ship.Cargo[FIREARMS] = 0;
	}
	
	if (insurance) {
		[self FrmAlert:NSLocalizedString(@"InsuranceLostAlert", @"")];
		insurance = FALSE;
		noClaim = 0;
	}
	
	if (ship.Crew[1] >= 0) {
		[self  FrmAlert:NSLocalizedString(@"MercenariesLeaveAlert", @"")];
		for (i=1; i<MAXCREW; ++i)
			ship.Crew[i] = -1;
	}
	
	if (japoriDiseaseStatus == 1) {
		[self FrmAlert:NSLocalizedString(@"AntidoteRemovedAlert", @"")];
		japoriDiseaseStatus = 2;
	}
	
	if (jarekStatus == 1) {
		[self FrmAlert:NSLocalizedString(@"JarekTakenHomeAlert", @"")];
		jarekStatus = 0;
	}
	
	if (browerStatus == 1) {
		[self FrmAlert:NSLocalizedString(@"BrowerArrestedAlert", @"")];
		[self addNewsEvent:BROWERARRESTED];
		browerStatus = 0;
	}
	
	if (reactorStatus > 0 && reactorStatus < 21) {
		[self FrmAlert:NSLocalizedString(@"PoliceConfiscateReactorAlert", @"")];
		reactorStatus = 0; 
	}
	
	[self Arrival];
	
	[self IncDays:Imprisonment];
	
	if (credits >= Fine)
		credits -= Fine;
	else if ([self currentNetWorth] >= Fine) {
		gesdb += credits;	
		credits = 0;		
		gesdb -= Fine;		
	}
	else {
		credits += [self currentShipPrice: TRUE];
		if (credits >= Fine)
			credits -= Fine;
		else {
			credits = 0;
			gesdb = 0;
		}
		
		[self FrmAlert:NSLocalizedString(@"ShipSoldAlert", @"")];
		if (ship.Tribbles > 0) {
			[self FrmAlert:NSLocalizedString(@"TribblesSoldAlert", @"")];
			ship.Tribbles = 0;
		}
		
		[self FrmAlert:NSLocalizedString(@"NaniteReceivedAlert", @"")];
		[self CreateFlea];
	}
	
	policeRecordScore = DUBIOUSSCORE;
	
	if (debt > 0) {
		if (credits >= debt) {
			credits -= debt;
			debt = 0;
		}
		else {
			debt -= credits;
			credits = 0;
		}
	}
	
	for (i=0; i<Imprisonment; ++i)
		[self payInterest];
	
	[self Arrival];
}

-(char) FighterSkill:(struct SHIP*) Sh {
	int i;
	char MaxSkill;
	
	MaxSkill = Mercenary[Sh->Crew[0]].Fighter;
	
	for (i=1; i<MAXCREW; ++i) {
		if (Sh->Crew[i] < 0)
			break;
		if (Mercenary[Sh->Crew[i]].Fighter > MaxSkill)
			MaxSkill = Mercenary[Sh->Crew[i]].Fighter;
	}
	
	if ([self HasGadget:Sh Gg:TARGETINGSYSTEM])
		MaxSkill += SKILLBONUS;			
	
	return [self AdaptDifficulty:MaxSkill];
}

-(char) PilotSkill:(struct SHIP*) Sh {
	int i;
	char MaxSkill;
	
	MaxSkill = Mercenary[Sh->Crew[0]].Pilot;
	
	for (i=1; i<MAXCREW; ++i) {
		if (Sh->Crew[i] < 0)
			break;
		if (Mercenary[Sh->Crew[i]].Pilot > MaxSkill)
			MaxSkill = Mercenary[Sh->Crew[i]].Pilot;
	}
	
	if ([self HasGadget:Sh Gg:NAVIGATINGSYSTEM])
		MaxSkill += SKILLBONUS;			
	if ([self HasGadget:Sh Gg:CLOAKINGDEVICE])
		MaxSkill += CLOAKBONUS;			
	
	return [self AdaptDifficulty:MaxSkill];
}

-(BOOL) ExecuteAttack:(struct SHIP*) Attacker Defender:(struct SHIP*) Defender Flees:(BOOL)Flees CommanderUnderAttack:(BOOL) CommanderUnderAttack {
	long Damage, prevDamage;
	int i;
	
	if (gameDifficulty == BEGINNER && CommanderUnderAttack && Flees)
		return FALSE;
	
	if (GetRandom([self FighterSkill: Attacker] + Shiptype[Defender->Type].Size ) < 
		(Flees ? 2 : 1) * GetRandom( 5 + ([self PilotSkill:Defender] >> 1) ))
		return FALSE;
	
	if ([self TotalWeapons:Attacker minWeapon: -1 maxWeapon: -1] <= 0)
		Damage = 0L;
	else if (Defender->Type == SCARABTYPE) {
		if ([self TotalWeapons:Attacker minWeapon:PULSELASERWEAPON maxWeapon:PULSELASERWEAPON]  <= 0 &&
		    [self TotalWeapons:Attacker minWeapon: TALBOTLASERWEAPON maxWeapon:TALBOTLASERWEAPON]  <= 0)
			Damage = 0L;
		else 
			Damage =  GetRandom( (([self TotalWeapons:Attacker minWeapon:PULSELASERWEAPON maxWeapon:PULSELASERWEAPON]  +
								   [self TotalWeapons:Attacker  minWeapon:TALBOTLASERWEAPON maxWeapon:TALBOTLASERWEAPON] ) * (100 + 2*[self EngineerSkill:Attacker] ) / 100) );
	}
	else
		Damage = GetRandom( ([self TotalWeapons:Attacker minWeapon:-1 maxWeapon: -1] * (100 + 2*[self EngineerSkill:Attacker]) / 100) );
	
	if (Damage <= 0L)
		return FALSE;
	
	if (CommanderUnderAttack && reactorStatus > 0 && reactorStatus < 21) {
		if (gameDifficulty < NORMAL)
			Damage *= 1 + (gameDifficulty + 1)*0.25;
		else
			Damage *= 1 + (gameDifficulty + 1)*0.33;
	}
	
	for (i=0; i<MAXSHIELD; ++i) {
		if (Defender->Shield[i] < 0)
			break;
		if (Damage <= Defender->ShieldStrength[i]) {
			Defender->ShieldStrength[i] -= Damage;
			Damage = 0;
			break;
		}
		Damage -= Defender->ShieldStrength[i];
		Defender->ShieldStrength[i] = 0;
	}
	
	prevDamage = Damage;
	
	if (Damage > 0) {
		Damage -= GetRandom( [self EngineerSkill: Defender] );
		if (Damage <= 0)
			Damage = 1;
		if (CommanderUnderAttack && scarabStatus == 3)
			Damage = min( Damage, ([self getHullStrength]/
								   (CommanderUnderAttack ? max( 1, (IMPOSSIBLE-gameDifficulty) ) : 2)) );
		else
			Damage = min( Damage, (Shiptype[Defender->Type].HullStrength/
								   (CommanderUnderAttack ? max( 1, (IMPOSSIBLE-gameDifficulty) ) : 2)) );
		Defender->Hull -= Damage;
		if (Defender->Hull < 0)
			Defender->Hull = 0;
	}
	
	if (Damage != prevDamage) {
		if (CommanderUnderAttack) {
			playerShipNeedsUpdate = TRUE;
		}
		else {
			opponentShipNeedsUpdate = TRUE;
		}
	}
	
	return TRUE;
}

-(long) EnemyShipPrice:(struct SHIP*) Sh {
	int i;
	long CurPrice;
	
	CurPrice = Shiptype[Sh->Type].Price;
	for (i=0; i<MAXWEAPON; ++i)
		if (Sh->Weapon[i] >= 0)
			CurPrice += Weapontype[Sh->Weapon[i]].Price;
	for (i=0; i<MAXSHIELD; ++i)
		if (Sh->Shield[i] >= 0)
			CurPrice += Shieldtype[Sh->Shield[i]].Price;
	
	CurPrice = CurPrice * (2 * [self PilotSkill: Sh] + [self EngineerSkill: Sh] + 3 * [self FighterSkill: Sh])	/ 60;
	return CurPrice;
}

-(long) GetBounty:(struct SHIP*) Sh {
	long Bounty = [self EnemyShipPrice:Sh];
	
	Bounty /= 150;
	if (Bounty <= 100)
		Bounty = 125;
	if (Bounty > 3500)
		Bounty = 3500;
	
	return Bounty;
}

-(void)plunderItems:(int) index count:(int)count {
	plunderItem = index;
	plunderCount = count;
}

-(void)finishPlunder {
	if (ENCOUNTERPIRATE( encounterType ) && Opponent.Type != MANTISTYPE && policeRecordScore >= DUBIOUSSCORE) {
		NSString * str = [NSString stringWithFormat:@"You earned a bounty of %i cr.", [self GetBounty:&Opponent]];
		[self FrmAlert:str];
	}
	else {
		if (encounterType == MARYCOCHRANENCOUNTER) {
			[self FrmAlert:NSLocalizedString(@"MaryCochranBoardedAlert", @"")];
		}
		else {
			[self FrmAlert:NSLocalizedString(@"OpponentBoardedAlert", @"")];
		}

	}
	
	bWaitFinishPlunder = FALSE;			
	[self travel];
	[encounterViewControllerInstance showEncounterWindow];
	
}

-(void) showPlunderForm:(ePlunderMode)pickup {

	if (clicks <= 0)
		return;

	bWaitFinishPlunder = TRUE;

	if (pickup == ePickupCanister) {
		currentState = ePlunderForm;		
		plunderCount = 1;
		NSString *message;
		plunderItem = GetRandom(MAXTRADEITEM);
		message = [NSString stringWithFormat:@"A canister from the destroyed ship, labelled %@, drifts within range of your scoops.", [NSString stringWithFormat:@"%s", Tradeitem[plunderItem].Name]];
		UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Scoop Canister" message: message
															  delegate:self cancelButtonTitle:0 otherButtonTitles:@"Let it go", @"Pick it up",0];
		
		[myAlertView show];
		[myAlertView release];				
		bLastMessage = FALSE;
		
	}
	else {
		if (pickup == ePlunderShip) {
			currentState = ePlunderShipForm;
			[self showUserNotice:aWarning];
			UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Plunder Ship" message: @"This will effect your Police Record, do you really want to plunder it?"
																  delegate:self cancelButtonTitle:0 otherButtonTitles:@"Let it go", @"Plunder it",0];
			
			[myAlertView show];
			[myAlertView release];				
			bLastMessage = FALSE;
			
		}
		else {
			if ([self totalCargoBays] -  [self filledCargoBays] >= plunderCount) {
				ship.Cargo[plunderItem] += plunderCount;
				[self finishPlunder];
			}
			else {
				currentState = ePlunderRemoveGoods;
				[self showUserNotice:aAlert];
				UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"No Room To Scoop" message: @"You don't have any room in your cargo bays. Do you wish to jettison some goods to make room, or just let it go? If you choose Make Room, you must jettison some of your cargo. So make sure the plundered items are worth it."
																	  delegate:self cancelButtonTitle:@"Let it go" otherButtonTitles:@"Make Room", 0];
				
				[myAlertView show];
				[myAlertView release];
				bLastMessage = FALSE;
			}
		}
	}
}

-(void)continuePlunder {
	bWaitFinishPlunder = FALSE;
	[self showPlunderForm:ePickItUp];	
}

-(void) Scoop {
	[self showPlunderForm:ePickupCanister];	
}

-(void) ShowShip:(struct SHIP*)Sh offset:(int)offset commandersShip:(BOOL)commandersShip {

}


#pragma mark EndofGame Views
-(void) showDestroyedShipWindow {
	[self encounterViewControllerDidFinish:encounterViewControllerInstance];
	[[AppDelegate sharedAppDelegate]switchTrack];
	EndOfGameViewController *endGame = [[EndOfGameViewController alloc] initWithNibName:@"EndGame" bundle:nil];
	[[[AppDelegate sharedAppDelegate]window] addSubview:[endGame view]];
	[endGame showShipDestroyedImage];
	encounterWindow = FALSE;
}

-(void) showUtopiaWindow {
	EndOfGameViewController *endGame = [[EndOfGameViewController alloc] initWithNibName:@"EndGame" bundle:nil];
	[[[AppDelegate sharedAppDelegate]window] addSubview:[endGame view]];	
	[endGame showHappyEndImage];	
	encounterWindow = FALSE;
}

-(void)showRetiredForm {
	EndOfGameViewController *endGame = [[EndOfGameViewController alloc] initWithNibName:@"EndGame" bundle:nil];
	[[[AppDelegate sharedAppDelegate]window] addSubview:[endGame view]];	
	[endGame showPoorEndGameImage];	
	encounterWindow = FALSE;
}


-(BOOL) HasTradeableItems: (struct SHIP*)sh  theSystem: (Byte) theSystem Operation:(Byte) Operation {
	int i;
	Boolean ret = FALSE, thisRet;
	for (i = 0; i< MAXTRADEITEM; i++) {
		thisRet = FALSE;
		if (sh->Cargo[i] > 0 && Operation == TRADERSELL && BuyPrice[i] > 0) {
			thisRet = TRUE;
		}
		else if (sh->Cargo[i] > 0 && Operation == TRADERBUY && SellPrice[i] > 0) {
			thisRet = TRUE;
		}
		if (policeRecordScore < DUBIOUSSCORE && i != FIREARMS && i != NARCOTICS)
		    thisRet = FALSE;
		else if (policeRecordScore >= DUBIOUSSCORE && (i == FIREARMS || i == NARCOTICS))
		    thisRet = FALSE;
		
		if (thisRet)
			ret = TRUE;
				
	}
	return ret;
}

-(void) buyRepairs:( int) Amount  {
	if(credits > 0) {
		int MaxRepairs;
		int Percentage;
		
		MaxRepairs = ([self getHullStrength] - ship.Hull) * 
		Shiptype[ship.Type].RepairCosts;
		if (Amount > MaxRepairs)
			Amount = MaxRepairs;
		if (Amount > credits)
			Amount = credits;
		
		Percentage = Amount / Shiptype[ship.Type].RepairCosts;
		
		ship.Hull += Percentage;
		credits -= Percentage * Shiptype[ship.Type].RepairCosts;
		if(!autoRepair)
			[[SoundManager sharedSound] playSoundWithId:kAirWrench];
	}
	else {
		[self FrmAlert:NSLocalizedString(@"NotEnoughForEventAlert", @"")];
	}
	
}

-(void) showJettisonForm {
	if (!jettisonViewControllerInstance) {
		jettisonViewControllerInstance = [[SellCargoViewController alloc] initWithNibName:@"SellCargo" bundle:nil];
		[[[AppDelegate sharedAppDelegate]window] addSubview:[jettisonViewControllerInstance view]];		
		[jettisonViewControllerInstance setJettisonViewType];
	} else {
		[[[AppDelegate sharedAppDelegate]window] addSubview:[jettisonViewControllerInstance view]];		
	}
}

-(void) showOpponentForm {
	if (!opponentViewControllerInstance) {
		opponentViewControllerInstance = [[SellCargoViewController alloc] initWithNibName:@"SellCargo" bundle:nil];
		[[[AppDelegate sharedAppDelegate]window] addSubview:[opponentViewControllerInstance view]];		
		[opponentViewControllerInstance setOpponentViewType];
	} else {
		[[[AppDelegate sharedAppDelegate]window] addSubview:[opponentViewControllerInstance view]];		
	}
}

#pragma mark Encounter View
-(void) showEncounteredWindow {
	if (bWaitFinishPlunder) 
		return;
	
	if (!encounterWindow) {
		if ([playerDefaults boolForKey:@"leftHandEncounter"]) {
			encounterViewControllerInstance = [[[EncounterViewController alloc] initWithNibName:@"EncounterLeft" bundle:nil] retain];			
		}
		else {
			encounterViewControllerInstance = [[[EncounterViewController alloc] initWithNibName:@"EncounterRight" bundle:nil] retain];
		}
		[[[AppDelegate sharedAppDelegate]navigationController] presentModalViewController:encounterViewControllerInstance animated:YES];
		encounterWindow = TRUE;
	}
}

#pragma mark Travel Loop
-(void) travel {
	int EncounterTest, i, j, Repairs, FirstEmptySlot, rareEncounter; 
	Boolean Pirate, Trader, Police, Mantis, TryAutoRepair, FoodOnBoard, EasterEgg;
	Boolean HaveMilitaryLaser, HaveReflectiveShield, FursOnBoard;
	long previousTribbles, previousFleas;
	
	if (bWaitFinishPlunder)
		return;
	
	if (clicks < 0)
		return;
	autoFlee = FALSE;
	autoAttack = FALSE;
	Pirate = FALSE;
	Trader = FALSE;
	Police = FALSE;
	Mantis = FALSE;
	HaveMilitaryLaser = [self HasWeapon:&ship Cg:MILITARYLASERWEAPON exactCompare:TRUE];
	HaveReflectiveShield = [self HasShield:&ship Cg:REFLECTIVESHIELD];
	
	if (possibleToGoThroughRip &&
	    experimentStatus == 12 && fabricRipProbability > 0 &&
	    (GetRandom(100) < fabricRipProbability || fabricRipProbability == 25)) {
		[self FrmAlert:NSLocalizedString(@"FlyInFabricRipAlert", @"")];
		warpSystem = GetRandom(MAXSOLARSYSTEM);
	}
	
	possibleToGoThroughRip=FALSE;
	
	--clicks;
	firstEncounter = TRUE;
	
#pragma mark Travel - Begin Loop
	while (clicks > 0) {
		Repairs = GetRandom( [self EngineerSkill:&ship] ) >> 1;
		ship.Hull += Repairs;
		if (ship.Hull > [self getHullStrength]) {
			Repairs = ship.Hull - [self getHullStrength];
			ship.Hull = [self getHullStrength];
		}
		else
			Repairs = 0;
		
		Repairs = 2 * Repairs;
		for (i=0; i<MAXSHIELD; ++i) {
			if (ship.Shield[i] < 0)
				break;
			ship.ShieldStrength[i] += Repairs;
			if (ship.ShieldStrength[i] > Shieldtype[ship.Shield[i]].Power) {
				Repairs = ship.ShieldStrength[i] - Shieldtype[ship.Shield[i]].Power;
				ship.ShieldStrength[i] = Shieldtype[ship.Shield[i]].Power;
			}
			else
				Repairs = 0;
		}
		
#pragma mark Travel - Band of Pirates
		if ((clicks == 1) && (warpSystem == ACAMARSYSTEM) && (monsterStatus == 1)) {
			memcpy(&Opponent, &SpaceMonster, sizeof( Opponent ) );
			Opponent.Hull = monsterHull;
			Mercenary[Opponent.Crew[0]].Pilot = 8 + gameDifficulty;
			Mercenary[Opponent.Crew[0]].Fighter = 8 + gameDifficulty;
			Mercenary[Opponent.Crew[0]].Trader = 1;
			Mercenary[Opponent.Crew[0]].Engineer = 1 + gameDifficulty;
			if ([self Cloaked:&ship  b:&Opponent])
				encounterType = SPACEMONSTERIGNORE;
			else
				encounterType = SPACEMONSTERATTACK;
			
			[self showEncounteredWindow];
			[encounterViewControllerInstance SetLabelText:@""];
			return;
		}
		
#pragma mark Travel - Stolen Scarab
		if (clicks == 20 && solarSystem[warpSystem].Special == SCARABDESTROYED &&
			scarabStatus == 1 && arrivedViaWormhole) {
			memcpy(&Opponent, &Scarab, sizeof( Opponent ) );
			Mercenary[Opponent.Crew[0]].Pilot = 5 + gameDifficulty;
			Mercenary[Opponent.Crew[0]].Fighter = 6 + gameDifficulty;
			Mercenary[Opponent.Crew[0]].Trader = 1;
			Mercenary[Opponent.Crew[0]].Engineer = 6 + gameDifficulty;
			if ([self Cloaked:&ship b:&Opponent])
				encounterType = SCARABIGNORE;
			else
				encounterType = SCARABATTACK;
			[self showEncounteredWindow];
			[encounterViewControllerInstance SetLabelText:@""];
			return;
		} 

#pragma mark Travel - Stolen Dragonfly
		if ((clicks == 1) && (warpSystem == ZORKONSYSTEM) && (dragonflyStatus == 4)) {
			memcpy( &Opponent, &Dragonfly, sizeof( Opponent ) );
			
			Mercenary[Opponent.Crew[0]].Pilot = 4 + gameDifficulty;
			Mercenary[Opponent.Crew[0]].Fighter = 6 + gameDifficulty;
			Mercenary[Opponent.Crew[0]].Trader = 1;
			Mercenary[Opponent.Crew[0]].Engineer = 6 + gameDifficulty;
			if ([self Cloaked:&ship b:&Opponent])
				encounterType = DRAGONFLYIGNORE;
			else
				encounterType = DRAGONFLYATTACK;
			[self showEncounteredWindow];
			[encounterViewControllerInstance SetLabelText:@""];
			return;
		}
		
#pragma mark Travel - Check Gemulon Invasion Status
		if (warpSystem == GEMULONSYSTEM && invasionStatus > 7) {
			if (GetRandom( 10 ) > 4)
				Mantis = TRUE;
		}
		else {
			EncounterTest = GetRandom( 44 - (2 * gameDifficulty) );
			
			if (ship.Type == 0)
				EncounterTest *= 2;
			
			if (EncounterTest < Politics[solarSystem[warpSystem].Politics].StrengthPirates &&
				!raided)
				Pirate = TRUE;
			else if (EncounterTest < 
					 Politics[solarSystem[warpSystem].Politics].StrengthPirates +
					 STRENGTHPOLICE( warpSystem ))
				Police = TRUE;
			else if (EncounterTest < 
					 Politics[solarSystem[warpSystem].Politics].StrengthPirates +
					 STRENGTHPOLICE( warpSystem ) +
					 Politics[solarSystem[warpSystem].Politics].StrengthTraders)
				Trader = TRUE;
			else if (browerStatus == 1 && warpSystem == KRAVATSYSTEM) {
				rareEncounter = GetRandom(100);
				if (gameDifficulty <= EASY && rareEncounter < 25) {
					Police = TRUE;
				}
				else if (gameDifficulty == NORMAL && rareEncounter < 33) {
					Police = TRUE;
				}
				else if (gameDifficulty > NORMAL && rareEncounter < 50) {
					Police = TRUE;
				}
			}	
			if (!(Trader || Police || Pirate))
				if (artifactOnBoard && GetRandom( 20 ) <= 3)
					Mantis = TRUE;
		}
		
#pragma mark Travel - Police Encounter
		if (Police) {
			if (firstEncounter) {
				[[SoundManager sharedSound] playSoundWithId:kPoliceEncounter];
				firstEncounter = FALSE;
			}
			
			[self GenerateOpponent: POLICE ];
			encounterType = POLICEIGNORE;
			if ([self Cloaked:&ship b:&Opponent])
				encounterType = POLICEIGNORE;
			else if (policeRecordScore < DUBIOUSSCORE) {
				if ([self TotalWeapons:&Opponent minWeapon:-1 maxWeapon:-1] <= 0) {
					if ([self Cloaked:&Opponent b:&ship])
						encounterType = POLICEIGNORE;
					else
						encounterType = POLICEFLEE;
				}
				if (reputationScore < AVERAGESCORE)
					encounterType = POLICEATTACK;
				else if (GetRandom( ELITESCORE ) > (reputationScore / (1 + Opponent.Type)))
					encounterType = POLICEATTACK;
				else if ([self Cloaked:&Opponent b:&ship])
					encounterType = POLICEIGNORE;
				else
					encounterType = POLICEFLEE;
			}
			else if (policeRecordScore >= DUBIOUSSCORE && 
					 policeRecordScore < CLEANSCORE && !inspected) {
				encounterType = POLICEINSPECTION;
				inspected = TRUE;
			}
			else if (policeRecordScore < LAWFULSCORE) {
				if (GetRandom( 12 - gameDifficulty ) < 1 && !inspected) {
					encounterType = POLICEINSPECTION;
					inspected = TRUE;
				}
			}
			else {
				if (GetRandom( 40 ) == 1 && !inspected) {
					encounterType = POLICEINSPECTION;
					inspected = TRUE;
				}
			}
			
			if (encounterType == POLICEFLEE && Opponent.Type > ship.Type) {
				if (policeRecordScore < DUBIOUSSCORE) {
					encounterType = POLICEATTACK;
				}
				else {
					encounterType = POLICEINSPECTION;
				}
			}
			
			if (encounterType == POLICEIGNORE && [self Cloaked:&Opponent b:&ship]) {
				--clicks;
				continue;
			}
			
			
			if (alwaysIgnorePolice && (encounterType == POLICEIGNORE || 
									   encounterType == POLICEFLEE)) {
				--clicks;
				continue;
			}
			
			[self showEncounteredWindow];
			return;
		}
		
#pragma mark Travel - Pirate Encounter		
		else if (Pirate || Mantis) {
			if (Mantis)
				[self GenerateOpponent:MANTIS];
			else
				[self GenerateOpponent:PIRATE];
			
			if ([self Cloaked:&ship b:&Opponent])
				encounterType = PIRATEIGNORE;
			
			else if (Opponent.Type >= 7 ||
					 GetRandom( ELITESCORE ) > (reputationScore * 4) / (1 + Opponent.Type))
				encounterType = PIRATEATTACK;
			else
				encounterType = PIRATEFLEE;
			
			if (Mantis)
				encounterType = PIRATEATTACK;
			
			if (encounterType == PIRATEFLEE && Opponent.Type > ship.Type) {
				encounterType = PIRATEATTACK;
			}
			
			if ((encounterType == PIRATEIGNORE || encounterType == PIRATEFLEE) && 
				[self Cloaked:&Opponent b:&ship]) {
				--clicks;
				continue;
			}
			if (alwaysIgnorePirates && (encounterType == PIRATEIGNORE ||
										encounterType == PIRATEFLEE)) {
				--clicks;
				continue;
			}
			[self showEncounteredWindow];
			return;
		}
		
#pragma mark Travel - Trader Encounter		
		else if (Trader) {	
			[self GenerateOpponent: TRADER];
			encounterType = TRADERIGNORE;
			if ([self Cloaked:&ship b:&Opponent])
				encounterType = TRADERIGNORE;
			else if (policeRecordScore <= CRIMINALSCORE) {
				if (GetRandom( ELITESCORE ) <= (reputationScore * 10) / (1 + Opponent.Type)) {
					if ([self Cloaked:&Opponent b:&ship])
						encounterType = TRADERIGNORE;
					else
						encounterType = TRADERFLEE;
				}
			}
			
			if (encounterType == TRADERIGNORE) {				
				if ([self filledCargoBays] < [self totalCargoBays] && 
				    [self HasTradeableItems:&Opponent theSystem:warpSystem Operation:TRADERSELL])
					encounterType = TRADERSELL;
				
				if ([self HasTradeableItems:&ship theSystem:warpSystem Operation:TRADERBUY] && encounterType != TRADERSELL)
					encounterType = TRADERBUY;
			}
			
			if ((encounterType == TRADERIGNORE || encounterType == TRADERFLEE ||
				 encounterType == TRADERSELL || encounterType == TRADERBUY) && 
				[self Cloaked:&Opponent b:&ship]) {
				--clicks;
				continue;
			}
			if (alwaysIgnoreTraders && (encounterType == TRADERIGNORE ||
										encounterType == TRADERFLEE)) {
				--clicks;
				continue;
			}
			if (alwaysIgnoreTradeInOrbit && (encounterType == TRADERBUY ||
											 encounterType == TRADERSELL)) {
				--clicks;
				continue;
			}
			
			[self showEncounteredWindow];
			return;
		}
		else if ((days > 10) && (GetRandom(1000) < chanceOfVeryRareEncounter )) {
			rareEncounter = GetRandom(MAXVERYRAREENCOUNTER);
			
			switch (rareEncounter) {
				case MARYCOCHRAN:
					if (!(veryRareEncounter & (Byte)ALREADYMARY)) {
						veryRareEncounter += ALREADYMARY;
						encounterType = MARYCOCHRANENCOUNTER;
						[self GenerateOpponent:TRADER];
						for (i=0;i<MAXTRADEITEM;i++) {
							Opponent.Cargo[i]=0;
						}
						Opponent.Cargo[NARCOTICS] = min(Shiptype[Opponent.Type].CargoBays,5);
						[self showEncounteredWindow];
						return;
					}
					break;
					
				case CAPTAINADAMA:
					if (HaveReflectiveShield && pilotSkill < 10 &&
					    policeRecordScore > CRIMINALSCORE &&
					    !(veryRareEncounter & (Byte)ALREADYADAMA)) {
						veryRareEncounter += ALREADYADAMA;
						encounterType = CAPTAINADAMAENCOUNTER;
						[self GenerateOpponent:FAMOUSCAPTAIN];
						[self showEncounteredWindow];
						return;
					}
					break;
					
				case CAPTAINBELLOWS:
					if (HaveMilitaryLaser && engineerSkill < 10 &&
						policeRecordScore > CRIMINALSCORE &&
					    !(veryRareEncounter & (Byte)ALREADYBELLOWS)) {
						veryRareEncounter += ALREADYBELLOWS;
						encounterType = CAPTAINBELLOWSENCOUNTER;
						[self GenerateOpponent:FAMOUSCAPTAIN];
						[self showEncounteredWindow];
						return;
					}
					break;
					
				case CAPTAINLYNN:
					if (HaveMilitaryLaser && traderSkill < 10 &&
						policeRecordScore > CRIMINALSCORE &&
					    !(veryRareEncounter & (Byte)ALREADYLYNN)) {
						veryRareEncounter = veryRareEncounter | ALREADYLYNN;
						encounterType = CAPTAINLYNNENCOUNTER;
						[self GenerateOpponent:FAMOUSCAPTAIN];
						[self showEncounteredWindow];
						return;
					}
					break;
				case BOTTLEOLD:
					if  (!(veryRareEncounter & (Byte)ALREADYBOTTLEOLD)) {
						veryRareEncounter = veryRareEncounter | ALREADYBOTTLEOLD;
						encounterType = BOTTLEOLDENCOUNTER;
						[self GenerateOpponent:TRADER];
						Opponent.Type = BOTTLETYPE;
						Opponent.Hull = 10;
						[self showEncounteredWindow];
						return;
					}
					break;
				case BOTTLEGOOD:
					if  (!(veryRareEncounter & (Byte)ALREADYBOTTLEGOOD)) {
						veryRareEncounter = veryRareEncounter | ALREADYBOTTLEGOOD;
						encounterType = BOTTLEGOODENCOUNTER;
						[self GenerateOpponent:TRADER];
						Opponent.Type = BOTTLETYPE;
						Opponent.Hull = 10;
						[self showEncounteredWindow];
						return;
					}
					break;
			}
		}
		
		--clicks;
	}
	
	if (justLootedMary) {			
		[self GenerateOpponent:POLICE];
		encounterType = POSTMARYPOLICEENCOUNTER;
		justLootedMary = FALSE;
		clicks++;
		[self showEncounteredWindow];
		return;
	}
	
	if (debt >= 75000 ) 
		[self FrmAlert:NSLocalizedString(@"DebtWarningAlert", @"")];
	
	[self Arrival];
	
	if (reactorStatus == 2) [self FrmAlert:NSLocalizedString(@"ReactorConsumeAlert", @"")];
	else if (reactorStatus == 16) [self FrmAlert:NSLocalizedString(@"ReactorNoiseAlert", @"")];
	else if (reactorStatus == 18) [self FrmAlert:NSLocalizedString(@"ReactorSmokeAlert", @"")];
	
	if (reactorStatus == 20) {
		[self FrmAlert:NSLocalizedString(@"ReactorMeltdownAlert", @"")];
		reactorStatus = 0;
		if (escapePod) {
			[self EscapeWithPod];
			return;
		}
		else {
			[self FrmAlert:NSLocalizedString(@"ShipDestroyedAlert", @"")];
			[self showDestroyedShipWindow];
			return;
		}
	}
	
	if (trackAutoOff && trackedSystem == currentSystem) {
		trackedSystem = -1;
	}
	
	FoodOnBoard = FALSE;
	previousTribbles = ship.Tribbles;
	
	if (ship.Tribbles > 0 && reactorStatus > 0 && reactorStatus < 21) {
		ship.Tribbles /= 2;
		if (ship.Tribbles < 10) {
			ship.Tribbles = 0;
			[self FrmAlert:NSLocalizedString(@"TribblesAllIrradiatedAlert", @"")];
		}
		else {
			[self FrmAlert:NSLocalizedString(@"TribblesIrradiatedAlert", @"")];
		}
	}
	else if (ship.Tribbles > 0 && ship.Cargo[NARCOTICS] > 0) {
		ship.Tribbles = 1 + GetRandom( 3 );
		j = 1 + GetRandom( 3 );
		i = min( j, ship.Cargo[NARCOTICS] );
		BuyingPrice[NARCOTICS] = (BuyingPrice[NARCOTICS] * 
								  (ship.Cargo[NARCOTICS] - i)) / ship.Cargo[NARCOTICS];
		ship.Cargo[NARCOTICS] -= i;
		ship.Cargo[FURS] += i;
		[self FrmAlert:NSLocalizedString(@"TribblesAteNarcoticsAlert", @"")];
	}
	else if (ship.Tribbles > 0 && ship.Cargo[FOOD] > 0) {
		ship.Tribbles += 100 + GetRandom( ship.Cargo[FOOD] * 100 );
		i = GetRandom( ship.Cargo[FOOD] );
		BuyingPrice[FOOD] = (BuyingPrice[FOOD] * i) / ship.Cargo[FOOD];
		ship.Cargo[FOOD] = i; 
		[self FrmAlert:NSLocalizedString(@"TribblesAteFoodAlert", @"")];
		FoodOnBoard = TRUE;
	}
	
	if (ship.Tribbles > 0 && ship.Tribbles < MAXTRIBBLES)
		ship.Tribbles += 1 + GetRandom( max( 1, (ship.Tribbles >> (FoodOnBoard ? 0 : 1)) ) );
	
	if (ship.Tribbles > MAXTRIBBLES)
		ship.Tribbles = MAXTRIBBLES;
	
	if ((previousTribbles < 100 && ship.Tribbles >= 100) ||
		(previousTribbles < 1000 && ship.Tribbles >= 1000) ||
		(previousTribbles < 10000 && ship.Tribbles >= 10000) ||
		(previousTribbles < 50000 && ship.Tribbles >= 50000)) {
		[[SoundManager sharedSound] playSoundWithId:kTribble];
	}
	
	tribbleMessage = FALSE;
	
	FursOnBoard = FALSE;
	previousFleas = ship.RygellianFleas;

	if (ship.RygellianFleas > 0 && reactorStatus > 0 && reactorStatus < 21) {
		ship.RygellianFleas /= 2;
		if (ship.RygellianFleas < 10) {
			ship.RygellianFleas = 0;
			[self FrmAlert:NSLocalizedString(@"RyFleasAllIrradiatedAlert", @"")];
		}
		else {
			[self FrmAlert:NSLocalizedString(@"RyFleasIrradiatedAlert", @"")];
		}
	}
	else if (ship.RygellianFleas > 0 && ship.Cargo[NARCOTICS] > 0) {
		ship.RygellianFleas = 1 + GetRandom( 3 );
		j = 1 + GetRandom( 3 );
		i = min( j, ship.Cargo[NARCOTICS] );
		BuyingPrice[NARCOTICS] = (BuyingPrice[NARCOTICS] * 
								  (ship.Cargo[NARCOTICS] - i)) / ship.Cargo[NARCOTICS];
		ship.Cargo[NARCOTICS] -= i;
		ship.Cargo[FURS] += i;
		[self FrmAlert:NSLocalizedString(@"RyFleasInfectedNarcoticsAlert", @"")];
	}
	else if (ship.RygellianFleas > 0 && ship.Cargo[FURS] > 0) {
		ship.RygellianFleas += 100 + GetRandom( ship.Cargo[FURS] * 100 );
		i = GetRandom( ship.Cargo[FURS] );
		BuyingPrice[FURS] = (BuyingPrice[FURS] * i) / ship.Cargo[FURS];
		ship.Cargo[FURS] = i; 
		[self FrmAlert:NSLocalizedString(@"RyFleasInfectedFursAlert", @"")];
		FursOnBoard = TRUE;
	}
	
	if (ship.RygellianFleas > 0 && ship.RygellianFleas < MAXTRIBBLES)
		ship.RygellianFleas += 1 + GetRandom( max( 1, (ship.RygellianFleas >> (FursOnBoard ? 0 : 1)) ) );
	
	if (ship.RygellianFleas > MAXTRIBBLES)
		ship.RygellianFleas = MAXTRIBBLES;
	
	if ((previousFleas < 100 && ship.RygellianFleas >= 100) ||
		(previousFleas < 1000 && ship.RygellianFleas >= 1000) ||
		(previousFleas < 10000 && ship.RygellianFleas >= 10000) ||
		(previousFleas < 50000 && ship.RygellianFleas >= 50000)) {
		[[SoundManager sharedSound] playSoundWithId:kTribble];
	}
	
	rygellianFleasMessage = FALSE;
	
	ship.Hull += GetRandom([self  EngineerSkill: &ship]);
	if (ship.Hull > [self getHullStrength])
		ship.Hull = [self getHullStrength];
	
	TryAutoRepair = TRUE;
	if (autoFuel) {
		[self buyFuel:9999];
		if ([self getFuel] < [self getFuelTanks]) {
			if (autoRepair && ship.Hull < [self getHullStrength]) {
				[self FrmAlert:NSLocalizedString(@"NoFullTanksOrRepairsAlert", @"")];
				TryAutoRepair = FALSE;
			}
			else
				[self FrmAlert:NSLocalizedString(@"NoFullTanksAlert", @"")];
		}
	}
	
	if (autoRepair && TryAutoRepair) {	
		[self buyRepairs:9999];
		if (ship.Hull < [self  getHullStrength])
			[self FrmAlert:NSLocalizedString(@"NoFullRepairsAlert", @"")];
	}
	
	if (currentSystem == OPOLISYSTEM) {
		i = 0;
		EasterEgg = FALSE;
		while (i < MAXTRADEITEM) {
			if (ship.Cargo[i] != 1)
				break;
			++i;
		}
		if (i >= MAXTRADEITEM) { 
		    FirstEmptySlot = [self getFirstEmptySlot: Shiptype[ship.Type].ShieldSlots Item:ship.Shield];
            if (FirstEmptySlot >= 0) {
		      	ship.Shield[FirstEmptySlot] = QUANTUMSHIELD;  
			  	ship.ShieldStrength[FirstEmptySlot] = Shieldtype[QUANTUMSHIELD].Power;
				[self FrmAlert:NSLocalizedString(@"QuantumShieldAlert", @"")];
		      	EasterEgg = TRUE;
		    }
		    if (EasterEgg) {
			  	for (i=0; i<MAXTRADEITEM; ++i) {
				 	ship.Cargo[i] = 0;
				 	BuyingPrice[i] = 0;
				}
            }			
		}
	}
	
	if (currentSystem == SLOAKISSSYSTEM) {
		i = 0;
		EasterEgg = FALSE;
		while (i < MAXTRADEITEM) {
			if (ship.Cargo[i] != 1)
				break;
			++i;
		}
		if (i >= MAXTRADEITEM) { 
		    FirstEmptySlot = [self getFirstEmptySlot: Shiptype[ship.Type].WeaponSlots Item:ship.Weapon];
            if (FirstEmptySlot >= 0) {
		      	ship.Weapon[FirstEmptySlot] = TALBOTLASERWEAPON;
				[self FrmAlert:NSLocalizedString(@"TalbotLaserAlert", @"")];
		      	EasterEgg = TRUE;
		    }
		    if (EasterEgg) {
			  	for (i=0; i<MAXTRADEITEM; ++i) {
				 	ship.Cargo[i] = 0;
				 	BuyingPrice[i] = 0;
				}
            }			
		}
	}
	
	if(bLastMessage)
		[self FrmAlert:NSLocalizedString(@"ArrivalAlert", @"")];
		
	[self saveTheGame:@"AutoSave"];
}


-(int) getFirstEmptySlot:( char) Slots Item:( int*) Item {
	int FirstEmptySlot, j;
	FirstEmptySlot = -1;
	for (j=0; j<Slots; ++j) {
		if (Item[j] < 0)
		{
			FirstEmptySlot = j;
			break;
		}							
	}
	return FirstEmptySlot;
}

-(int)getFuelCost {
	return Shiptype[ship.Type].CostOfFuel;
}

-(int)getRepairCost {
	return Shiptype[ship.Type].RepairCosts;	
}

-(NSString*)getShipName:(Byte)index {
	return [NSString stringWithFormat:@"%s", Shiptype[index].Name];	
 }

-(NSString*)getShipImageName:(Byte)index {
	return [NSString stringWithFormat:@"%s", ShipImages[index]];		
}

-(NSString*)getShipImageNameBg:(Byte)index {
	return [NSString stringWithFormat:@"%s", ShipImagesBg[index]];			
}

-(NSString*)getShipDamagedImageName:(Byte)index;{
	return [NSString stringWithFormat:@"%s", ShipImagesDamaged[index]];			
}

-(NSString*)getShipShieldImageName:(Byte)index {
	return [NSString stringWithFormat:@"%s", ShipImagesShield[index]];			
}

-(NSString*)getShipSize:(Byte)index {
	return [NSString stringWithFormat:@"%s", SystemSize[Shiptype[index].Size]];	
}

#pragma mark Ship Info
-(int)getShipCargoBays:(Byte)index {
	return Shiptype[index].CargoBays;
}

-(int)getShipRange:(Byte)index {
	return Shiptype[index].FuelTanks;	
}

-(int)getShipHullStrength:(Byte)index {
	return Shiptype[index].HullStrength;	
}

-(int)getShipWeaponSlots:(Byte)index {
	return Shiptype[index].WeaponSlots;	
}

-(int)getShipShieldSlots:(Byte)index {
	return Shiptype[index].ShieldSlots;	
}

-(int)getShipGadgetSlots:(Byte)index {
	return Shiptype[index].GadgetSlots;	
}

-(int)getShipCrewQuarters:(Byte)index {
	return Shiptype[index].CrewQuarters;	
}

-(NSString*)getShipPriceStr:(int)index {
	if (ShipPrice[index] == 0 )
		return  [NSString stringWithFormat:@"not sold"];
	
	if (index == ship.Type )
		return  [NSString stringWithFormat:@"got one"];
	
	return 	[NSString stringWithFormat:@"%i cr.", ShipPrice[index]];
}

-(int)getShipPriceInt:(int)index {
	return ShipPrice[index];
}

-(Byte)getCurrentShipType {
	return ship.Type;
}

#pragma mark canBuyShip
-(BOOL)shouldListShip:(int)index {

	if ((int)([self toSpend] + gesdb) - [self getShipPriceInt:index] > 0 && [self getCurrentShipType] != index && [[[AppDelegate sharedAppDelegate]gamePlayer] getShipPriceInt:index] != 0) {
		return TRUE;
	}
	return FALSE;
}

-(BOOL)canBuyShip:(int)index controller:(BuyShipViewController *)controller {
	int j = 0;
	for (int i = 0; i < MAXCREW; ++i) 
		if (ship.Crew[i] >= 0)
			++j;
	if ((jarekStatus == 1) && (Shiptype[index].CrewQuarters < 2)) {
		[self FrmAlert:NSLocalizedString(@"JarekNeedsQuatersAlert", @"")];
		[self showUserNotice:aAlert];
		return FALSE;
	}
	
	if ((browerStatus == 1) && (Shiptype[index].CrewQuarters < 2)) {
		[self FrmAlert:NSLocalizedString(@"BrowerNeedsQuatersAlert", @"")];
		[self showUserNotice:aAlert];
		return FALSE;
	}
	
	if (reactorStatus > 0 && reactorStatus < 21) {
		[self FrmAlert:NSLocalizedString(@"CantSellShipWithReactor", @"")];
		[self showUserNotice:aAlert];
		return FALSE;
	}
	
	if (transportPassengers) {
		[self FrmAlert:NSLocalizedString(@"CantSellShipWithPassengers", @"")];
		[self showUserNotice:aAlert];
		return FALSE;
	}
	if (j > Shiptype[index].CrewQuarters) {
		[self FrmAlert:NSLocalizedString(@"TooManyCrewmembersAlert", @"")];
		return FALSE;
	}

	BOOL doesHaveASpecial = FALSE;
	NSMutableString *message = [[NSMutableString alloc] init];
	[message appendString:@"You can't transfer the "];
	
	if ([self HasShield:&ship Cg:QUANTUMSHIELD]) {
		doesHaveASpecial = TRUE;
		[message appendString:@"Lighting Shield"];
	}
	
	if ([self HasGadget:&ship Gg:FUELCOMPACTOR]) {
		if (doesHaveASpecial) {
			[message appendString:@" or the Fuel Compactor"];
		}
		else {
			[message appendString:@"Fuel Compactor"];
		}
		doesHaveASpecial = TRUE;
	}
	
	if ([self HasWeapon:&ship Cg:TALBOTLASERWEAPON exactCompare:TRUE]) {
		if (doesHaveASpecial) {
			[message appendString:@" or the Morgan Laser"];
		}
		else {
			[message appendString:@"Morgan Laser"];
		}
		doesHaveASpecial = TRUE;
	}
	
	if (doesHaveASpecial) {
		[message appendString:@" to a new ship. Are you sure you want to purchase this new ship?"];
		
		[self FrmAlertWithState:message state:eBuyNewShip];
		newShip = index;
		buyNewShipController = controller;
		[self showUserNotice:aAlert];
		return FALSE;
	}
	
	if (ShipPrice[index] > [self toSpend]) {
		if (ShipPrice[index] < [self currentNetWorth]) {
			[self FrmAlertWithState:@"You don't have enough cash on hand to purchase this ship. Do you want to withdraw the difference from your GESDB?" state:eBuyNewShip];
			newShip = index;
			buyNewShipController = controller;
			[self showUserNotice:aAlert];
			return FALSE;
		}
	}
	
	[message release];
	
	return TRUE;
}

-(BOOL)isShipCloaked {
	return [self Cloaked:&ship b:&Opponent];
}

-(int)getShipOpponentType{
	return Opponent.Type;
}

-(int) getRandomTradeableItem:(struct SHIP *)sh Operation:(Byte) Operation {
	Boolean looping = TRUE;
	int i=0, j;
	
	while (looping && i < 10) {
		j = GetRandom(MAXTRADEITEM);
		if ( (sh->Cargo[j] > 0 && Operation == TRADERSELL && BuyPrice[j] > 0) &&
			((policeRecordScore < DUBIOUSSCORE && (j == FIREARMS || j == NARCOTICS)) ||
			 (policeRecordScore >= DUBIOUSSCORE && j != FIREARMS && j != NARCOTICS)) ) {
				looping = FALSE;
		}
		else if ( (sh->Cargo[j] > 0 && Operation == TRADERBUY &&  SellPrice[j] > 0)  &&
				 ((policeRecordScore < DUBIOUSSCORE && (j == FIREARMS || j == NARCOTICS)) ||
				  (policeRecordScore >= DUBIOUSSCORE && j != FIREARMS && j != NARCOTICS)) ) {
					 looping = FALSE;
		}
		else {
			j = -1;
			i++;
		}
	}
	if (j == -1) {
		j = 0;
		looping = TRUE;
		while (looping) {
			if ( (((sh->Cargo[j] > 0) && (Operation == TRADERSELL) &&  (BuyPrice[j] > 0)) ||
				  ((sh->Cargo[j] > 0) && (Operation == TRADERBUY) &&  (SellPrice[j] > 0))) &&
		     	((policeRecordScore < DUBIOUSSCORE && (j == FIREARMS || j == NARCOTICS)) ||
				 (policeRecordScore >= DUBIOUSSCORE && j != FIREARMS && j != NARCOTICS)) ) {
				looping = FALSE;
			}
			else {
				j++;
				if (j == MAXTRADEITEM) {
					looping = FALSE;
				}
			}
		}
	}
	return j;
}

-(void) sellCheapestGood {
	int lowestPrice = 10000000;
	int index = 0;
	for (int i = 0; i < MAXTRADEITEM; ++i ) {
		if (ship.Cargo[i] > 0 && SellPrice[i] < lowestPrice) {
			lowestPrice = SellPrice[i];
			index = i;
		}
	}
	ship.Cargo[index] -=1 ;
	[self showPlunderForm:ePickItUp];
}

-(NSString*)getPriceDifference:(int)itemIndex difference:(BOOL)difference realPrice:(int *)realPrice maxCount:(int *)maxCount isSmart:(int *)isSmart {
	int price = [self StandardPrice:itemIndex size:solarSystem[warpSystem].Size tech:solarSystem[warpSystem].TechLevel goverment:solarSystem[warpSystem].Politics resources:solarSystem[warpSystem].Visited ? solarSystem[warpSystem].SpecialResources : -1];
	
	if (price > BuyPrice[itemIndex] && BuyPrice[itemIndex] > 0 && CURSYSTEM.Qty[itemIndex] > 0) {
		*isSmart = 1;
	} else {
		*isSmart = 0;    
	}
	*realPrice = price;
	if (BuyPrice[itemIndex] > 0) {
		*maxCount = credits / BuyPrice[itemIndex];
	} else {
		*maxCount = 0;
	}
	if (price <= 0 || (difference && BuyPrice[itemIndex] <= 0)) {
		return @"---";
	}
	if (difference)  {
		return [NSString stringWithFormat:@"%@%i cr.", price > BuyPrice[itemIndex] ? @"+" : @"", price - BuyPrice[itemIndex]];    
	} else {
		return [NSString stringWithFormat:@"%i cr.", price];
	}
}

#pragma mark Skill Increase / Decrease
-(void) IncreaseRandomSkill {
	Boolean Redo;
	int d, oldtraderskill;
	
	if (pilotSkill >= MAXSKILL && traderSkill >= MAXSKILL &&
		fighterSkill >= MAXSKILL && engineerSkill >= MAXSKILL)
		return;
	
	oldtraderskill = [self TraderSkill:&ship];
	
	Redo = TRUE;
	while (Redo) {
		d = (GetRandom( MAXSKILLTYPE ));
		if ((d == 0 && pilotSkill < MAXSKILL) ||
			(d == 1 && fighterSkill < MAXSKILL) ||
			(d == 2 && traderSkill < MAXSKILL) ||
			(d == 3 && engineerSkill < MAXSKILL))
			Redo = FALSE;
	}
	if (d == 0)
		pilotSkill += 1;
	else if (d == 1)
		fighterSkill += 1;
	else if (d == 2) {
		traderSkill += 1;
		if (oldtraderskill != [self TraderSkill:&ship])
			[self RecalculateBuyPrices:currentSystem];
	}
	else 
		engineerSkill += 1;
	[self updateMercenary0Data];
}

-(void) DecreaseRandomSkill:(int) amount {
	Boolean Redo;
	int d, oldtraderskill;
	
	if (pilotSkill >= MAXSKILL && traderSkill >= MAXSKILL &&
		fighterSkill >= MAXSKILL && engineerSkill >= MAXSKILL)
		return;
	
	oldtraderskill = [self TraderSkill:&ship];
	
	Redo = TRUE;
	while (Redo) {
		d = (GetRandom( MAXSKILLTYPE ));
		if ((d == 0 && pilotSkill > amount) ||
			(d == 1 && fighterSkill > amount) ||
			(d == 2 && traderSkill > amount) ||
			(d == 3 && engineerSkill > amount))
			Redo = FALSE;
	}
	if (d == 0)
		pilotSkill -= amount;
	else if (d == 1)
		fighterSkill -= amount;
	else if (d == 2) {
		traderSkill -= amount;
		if (oldtraderskill != [self TraderSkill:&ship])
			[self RecalculateBuyPrices:currentSystem];
	}
	else 
		engineerSkill -= amount;
	[self updateMercenary0Data];
}


-(void) TonicTweakRandomSkill {
	int oldPilot, oldFighter, oldTrader, oldEngineer;
	oldPilot = pilotSkill;
	oldFighter = fighterSkill;
	oldTrader = traderSkill;
	oldEngineer = engineerSkill;
	
	if (gameDifficulty < HARD) {
		while (	oldPilot == pilotSkill &&
			   oldFighter == fighterSkill &&
			   oldTrader == traderSkill &&
			   oldEngineer == engineerSkill) {
			[self IncreaseRandomSkill];
			[self DecreaseRandomSkill:1];
		}
	}
	else {
		[self IncreaseRandomSkill];
		[self IncreaseRandomSkill];
		[self DecreaseRandomSkill:3];
	}
	[self updateMercenary0Data];
}


#pragma mark Fight Loop
-(int) ExecuteAction:(BOOL) CommanderFlees {
	Boolean CommanderGotHit, OpponentGotHit;
	long OpponentHull, ShipHull;
	int PrevencounterType;
	
	CommanderGotHit = FALSE;
	OpponentHull = Opponent.Hull;
	ShipHull = ship.Hull;
	
	if (encounterType == PIRATEATTACK || encounterType == POLICEATTACK ||
		encounterType == TRADERATTACK || encounterType == SPACEMONSTERATTACK ||
		encounterType == DRAGONFLYATTACK || encounterType == POSTMARYPOLICEENCOUNTER ||
		encounterType == SCARABATTACK || encounterType == FAMOUSCAPATTACK) {
		CommanderGotHit = [self ExecuteAttack: &Opponent  Defender:&ship Flees:CommanderFlees CommanderUnderAttack:TRUE];
	}
	
	OpponentGotHit = FALSE;
	if (!CommanderFlees) {
		if (encounterType == POLICEFLEE || encounterType == TRADERFLEE || encounterType == PIRATEFLEE) {
			OpponentGotHit = [self ExecuteAttack:&ship Defender:&Opponent  Flees:TRUE CommanderUnderAttack:FALSE];
		} else {
			OpponentGotHit = [self ExecuteAttack:&ship Defender:&Opponent Flees:FALSE CommanderUnderAttack:FALSE];
		}
	}
	
	if (CommanderGotHit) {
		playerShipNeedsUpdate = TRUE;
		[[SoundManager sharedSound] playSoundWithId:kYourHit];
	}
	
	if (OpponentGotHit) {
		opponentShipNeedsUpdate = TRUE;
		[[SoundManager sharedSound] playSoundWithId:kFireLaser];
	}
	
	if (ship.Hull <= 0 && Opponent.Hull <= 0) {
		autoAttack = FALSE;
		autoFlee = FALSE;
		
		if (escapePod) {
			[self EscapeWithPod];
			return( TRUE );
		} else {
			[self FrmAlert:NSLocalizedString(@"BothDestroyedAlert", @"")];
			[self showDestroyedShipWindow];
		}
		return FALSE;
	} else if (Opponent.Hull <= 0) {
		autoAttack = FALSE;
		autoFlee = FALSE;
		if (ENCOUNTERPOLICE( encounterType )) {
			++policeKills;
			policeRecordScore += KILLPOLICESCORE;
		} else if (ENCOUNTERFAMOUS( encounterType)) {
			if (reputationScore < DANGEROUSREP) {
				reputationScore = DANGEROUSREP;
			} else {
				reputationScore += 100;
			}
			[self replaceNewsEvent:[self latestNewsEvent] replacementEventFlag:([self latestNewsEvent] + 10)];
		} else if (ENCOUNTERPIRATE( encounterType )) {
			if (Opponent.Type != MANTISTYPE) {
				credits += [self GetBounty:&Opponent];
				policeRecordScore += KILLPIRATESCORE;
				[self Scoop];
				reputationScore += 1 + (Opponent.Type>>1);
				return TRUE;				
			}
			++pirateKills;
		} else if (ENCOUNTERTRADER( encounterType )) {
			++traderKills;
			policeRecordScore += KILLTRADERSCORE;
			[self Scoop];
			reputationScore += 1 + (Opponent.Type>>1);
			return TRUE;
		} else if (ENCOUNTERMONSTER( encounterType )) {
			++pirateKills;
			policeRecordScore += KILLPIRATESCORE;
			monsterStatus = 2;
		} else if (ENCOUNTERDRAGONFLY( encounterType )) {
			++pirateKills;
			policeRecordScore += KILLPIRATESCORE;
			dragonflyStatus = 5;
		} else if (ENCOUNTERSCARAB( encounterType )) {
			++pirateKills;
			policeRecordScore += KILLPIRATESCORE;
			scarabStatus = 2;
		}
		[self FrmAlert:NSLocalizedString(@"OpponentDestroyedAlert", @"")];		
		reputationScore += 1 + (Opponent.Type>>1);
		return FALSE;
	} else if (ship.Hull <= 0) {
		autoAttack = FALSE;
		autoFlee = FALSE;
		
		if (escapePod) {
			[self EscapeWithPod];
			return( TRUE );
		} else {
			[self FrmAlert:NSLocalizedString(@"ShipDestroyedAlert", @"")];
			[self showDestroyedShipWindow];
			
		}
		return FALSE;
	}
	
	if (CommanderFlees) {
		if (gameDifficulty == BEGINNER) {
			autoAttack = FALSE;
			autoFlee = FALSE;
			[self FrmAlert:NSLocalizedString(@"YouEscapedAlert", @"")];
			if (ENCOUNTERMONSTER( encounterType ))
				monsterHull = Opponent.Hull;
			
			return FALSE;
		} else if ((GetRandom( 7 ) + ([self PilotSkill: &ship] / 3)) * 2 >= GetRandom( [self PilotSkill: &Opponent ] ) * (2 + gameDifficulty)) {
			autoAttack = FALSE;
			autoFlee = FALSE;
			if (CommanderGotHit) {
				[self ShowShip:&ship offset:6 commandersShip:TRUE];
				[self FrmAlert:NSLocalizedString(@"YouEscapedWithDamageAlert", @"")];
				[self playSpeechFile:@"DamageAlert.caf"];
			}
			else
				[self FrmAlert:NSLocalizedString(@"YouEscapedAlert", @"")];
			if (ENCOUNTERMONSTER( encounterType ))
				monsterHull = Opponent.Hull;
			
			return FALSE;
		}
	}
	else if (encounterType == POLICEFLEE || encounterType == TRADERFLEE || encounterType == PIRATEFLEE || encounterType == TRADERSURRENDER || encounterType == PIRATESURRENDER)	{
		if (4*GetRandom( [self PilotSkill:&ship] ) <= GetRandom( (07 + ([self PilotSkill:&Opponent] / 3))) * 2) {
			autoAttack = FALSE;
			autoFlee = FALSE;
			
			[self FrmAlert:NSLocalizedString(@"OpponentEscapedAlert", @"")];
			return FALSE;
		}
	}
	
	PrevencounterType = encounterType;
	
	if (Opponent.Hull < OpponentHull) {
		if (ENCOUNTERPOLICE( encounterType )) {
			if (Opponent.Hull < OpponentHull >> 1) {
				if (ship.Hull < ShipHull >> 1) {
					if (GetRandom( 10 ) > 5) {
						encounterType = POLICEFLEE;
					}
				}	else {
					encounterType = POLICEFLEE;
				}
			}
		} else if (encounterType == POSTMARYPOLICEENCOUNTER) {
			encounterType = POLICEATTACK;
		} else if (ENCOUNTERPIRATE( encounterType )) {
			if (Opponent.Hull < (OpponentHull * 2) / 3) {
				if (ship.Hull < (ShipHull * 2) / 3) {
					if (GetRandom( 10 ) > 3) {
						encounterType = PIRATEFLEE;
					}
				} else {
					encounterType = PIRATEFLEE;
					if (GetRandom( 10 ) > 8 && Opponent.Type < MAXSHIPTYPE) {
						encounterType = PIRATESURRENDER;
					}
				}
			}
		} else if (ENCOUNTERTRADER( encounterType )) {
			if (Opponent.Hull < (OpponentHull * 2) / 3) {
				if (GetRandom( 10 ) > 3) {
					encounterType = TRADERSURRENDER;
				} else {
					encounterType = TRADERFLEE;
				}
			} else if (Opponent.Hull < (OpponentHull * 9) / 10) {
				if (ship.Hull < (ShipHull * 2) / 3) {
					if (GetRandom( 10 ) > 7) {
						encounterType = TRADERFLEE;
					}
				} else if (ship.Hull < (ShipHull * 9) / 10) {
					if (GetRandom( 10 ) > 3) {
						encounterType = TRADERFLEE;
					}
				} else {
					encounterType = TRADERFLEE;
				}
			}
		}
	}
	
	if (PrevencounterType != encounterType) {
		if (!(autoAttack && (encounterType == TRADERFLEE || encounterType == PIRATEFLEE || encounterType == POLICEFLEE))) {
			autoAttack = FALSE;
		}
		autoFlee = FALSE;
	}
	
	NSString * str = @"";
	if (ENCOUNTERPOLICE( PrevencounterType ))
	 	str =@"police ship";
	else if (ENCOUNTERPIRATE( PrevencounterType )) {
		if (Opponent.Type == MANTISTYPE)
	 		str =@"alien ship";
		else	
	 		str =@"pirate ship";
	}
	else if (ENCOUNTERTRADER( PrevencounterType ))
	 	str =@"trader ship";
	else if (ENCOUNTERMONSTER( PrevencounterType ))
	 	str =@"band of pirates";
	else if (ENCOUNTERDRAGONFLY( PrevencounterType ))
	 	str =@"Dragonfly";
	else if (ENCOUNTERSCARAB( PrevencounterType ))
	 	str =@"Scarab";
	else if (ENCOUNTERFAMOUS( PrevencounterType))
	 	str =@"Captain";
	
	NSString *final, *final1, *final2;
	final =@"";
	final1 =@"";
	final2 =@"";	
	if (CommanderGotHit) {
		final1 = [NSString stringWithFormat:@"The %@ hits you.", str];
	} 
	
	if (!(PrevencounterType == POLICEFLEE || PrevencounterType == TRADERFLEE ||
		  PrevencounterType == PIRATEFLEE) && !CommanderGotHit) {
		final1 = [NSString stringWithFormat:@"The %@ missed you.", str];		
	}
	
	if (OpponentGotHit) {
		final = [NSString stringWithFormat:@"You hit the %@.", str];
	}
	
	if (!CommanderFlees && !OpponentGotHit) {
		final = [NSString stringWithFormat:@"You missed the %@.", str];		
	}
	
	if (PrevencounterType == POLICEFLEE || PrevencounterType == TRADERFLEE ||
		PrevencounterType == PIRATEFLEE) {
		final2 = [NSString stringWithFormat:@"The %@ didn't get away.", str];
	}
	
	if (CommanderFlees) {
		final2 = [NSString stringWithFormat:@"The %@ is still following you.", str];
	}
	
	final = [NSString stringWithFormat:@"%@\n%@\n%@", final1, final, final2];
		
	[encounterViewControllerInstance SetLabelText:final];
	
	return TRUE;
}

#pragma mark Encounter Actions
-(BOOL)attack {
	autoFlee = shouldAutoFlee;
	
	if ([self TotalWeapons:&ship minWeapon:-1 maxWeapon:-1] <= 0) {
		[self FrmAlert:NSLocalizedString(@"NoWeaponsAlert", @"")];
		[self showUserNotice:aAlert];
		return TRUE;
	}
	
	if (ENCOUNTERPOLICE( encounterType ) || encounterType == POSTMARYPOLICEENCOUNTER) {
		if (policeRecordScore > CRIMINALSCORE)// &&
			[self FrmAlert:NSLocalizedString(@"AttackByAccidentAlert", @"")];
		if (policeRecordScore > CRIMINALSCORE)
			policeRecordScore = CRIMINALSCORE;
		
		policeRecordScore += ATTACKPOLICESCORE;
		if (encounterType == POLICEIGNORE || encounterType == POLICEINSPECTION ||
			encounterType == POSTMARYPOLICEENCOUNTER) {
			encounterType = POLICEATTACK;
		}
	}
	else if (ENCOUNTERPIRATE( encounterType )) {
		if (encounterType == PIRATEIGNORE)
			encounterType = PIRATEATTACK;
	}
	else if (ENCOUNTERTRADER( encounterType )) {
		if (encounterType == TRADERIGNORE || encounterType == TRADERBUY ||
			encounterType == TRADERSELL) {
			if (policeRecordScore >= CLEANSCORE) {
				policeRecordScore = DUBIOUSSCORE;
			}
			else
				policeRecordScore += ATTACKTRADERSCORE;
		}
		if (encounterType != TRADERFLEE) {
			if ([self TotalWeapons:&Opponent minWeapon:-1 maxWeapon:-1] <= 0)
				encounterType = TRADERFLEE;
			else if (GetRandom( ELITESCORE ) <= (reputationScore * 10) / (1 + Opponent.Type))
				encounterType = TRADERFLEE;
			else
				encounterType = TRADERATTACK;
		}
	}
	else if (ENCOUNTERMONSTER( encounterType )) {
		if (encounterType == SPACEMONSTERIGNORE)
			encounterType = SPACEMONSTERATTACK;
	}
	else if (ENCOUNTERDRAGONFLY( encounterType )) {
		if (encounterType == DRAGONFLYIGNORE)
			encounterType = DRAGONFLYATTACK;
	}
	else if (ENCOUNTERSCARAB( encounterType )) {
		if (encounterType == SCARABIGNORE)
			encounterType = SCARABATTACK;
	}
	else if (ENCOUNTERFAMOUS( encounterType )) {
		if (policeRecordScore > VILLAINSCORE)
			policeRecordScore = VILLAINSCORE;
		policeRecordScore += ATTACKTRADERSCORE;
		if (encounterType == CAPTAINLYNNENCOUNTER)
			[self addNewsEvent:CAPTAINLYNNATTACKED];
		else if (encounterType == CAPTAINADAMAENCOUNTER)
			[self addNewsEvent:CAPTAINADAMAATTACKED];
		else if (encounterType == CAPTAINBELLOWSENCOUNTER)
			[self addNewsEvent:CAPTAINBELLOWSATTACKED];
		
		encounterType = FAMOUSCAPATTACK;
	}
	if (shouldAutoAttack)
		autoAttack = TRUE;
	if ([self ExecuteAction:FALSE])
		return TRUE;
	if (ship.Hull <= 0)
		return TRUE;
	[self travel];
	
	return FALSE;
}

-(BOOL) flee {
	autoAttack = FALSE;
	autoFlee = FALSE;
	
	if (encounterType == POLICEINSPECTION && ship.Cargo[FIREARMS] <= 0 &&
		ship.Cargo[NARCOTICS] <= 0 && browerStatus != 1 && (reactorStatus == 0 || reactorStatus == 21)) {
	}
	
	if (encounterType == POLICEINSPECTION) {
		encounterType = POLICEATTACK;
		if (policeRecordScore > DUBIOUSSCORE)
			policeRecordScore = DUBIOUSSCORE - (gameDifficulty < NORMAL ? 0 : 1);
		else
			policeRecordScore += FLEEFROMINSPECTION;
	}
	else if (encounterType == POSTMARYPOLICEENCOUNTER) {
		encounterType = POLICEATTACK;
		if (policeRecordScore >= CRIMINALSCORE)
			policeRecordScore = CRIMINALSCORE;
	}
	
	if (shouldAutoFlee)
		autoFlee = TRUE;
	if ([self ExecuteAction: TRUE])
		return TRUE;
	if (ship.Hull <= 0)
		return TRUE;
	
	[self travel];
	return FALSE;
}

-(BOOL) ignore {
	autoAttack = FALSE;
	autoFlee = FALSE;
	if (clicks > 0) {
		[self travel];
		[encounterViewControllerInstance showEncounterWindow];
	}
	return FALSE;
}

-(BOOL)trade {
	if (encounterType == TRADERBUY) {				
		int i = [self  getRandomTradeableItem:&ship Operation:TRADERBUY];
		if (i == NARCOTICS || i == FIREARMS) {
			if (GetRandom(100) <= 45)
				SellPrice[i] *= 0.8;
			else
				SellPrice[i] *= 1.2;
		}
		else {
			if (GetRandom(100) <= 10)
				SellPrice[i] *= 0.9;
			else
				SellPrice[i] *= 1.1;
		}
		
		SellPrice[i] /= Tradeitem[i].RoundOff;
		++SellPrice[i];
		SellPrice[i] *= Tradeitem[i].RoundOff;
		if (SellPrice[i] < Tradeitem[i].MinTradePrice)
			SellPrice[i] = Tradeitem[i].MinTradePrice;
		if (SellPrice[i] > Tradeitem[i].MaxTradePrice)
			SellPrice[i] = Tradeitem[i].MaxTradePrice;
		
		currentState = eTradeInOrbit;
		activeTradeItem = i;
		NSString *message = [NSString stringWithFormat:@"The trader wants to buy %@, and offers %i  cr. each. You have %i unit(s) available. "
							  "You paid about\n%i cr. per unit.\nHow many do you want to sell?\n\n\n\n", [NSString stringWithFormat:@"%s", Tradeitem[i].Name], SellPrice[i], ship.Cargo[i],
							  BuyingPrice[i] / ship.Cargo[i]];
		
		AlertModalWindow *myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Trade in Space" yoffset:60 
																	   buyValue:ship.Cargo[i] minValue:1 message:message  
																		delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Sell"];
		
		[myAlertView show];
		[myAlertView release];		
		
	}
	else if (encounterType == TRADERSELL) {				
		int i = [self getRandomTradeableItem:&Opponent Operation:TRADERSELL];
		
		if (i == NARCOTICS || i == FIREARMS) {
			if (GetRandom(100) <= 45)
				BuyPrice[i] *= 1.1;
			else
				BuyPrice[i] *= 0.8;
		}
		else {
			if (GetRandom(100) <= 10)
				BuyPrice[i] *= 1.1;
			else
				BuyPrice[i] *= 0.9;
		}
		
		BuyPrice[i] /= Tradeitem[i].RoundOff;
		BuyPrice[i] *= Tradeitem[i].RoundOff;
		if (BuyPrice[i] < Tradeitem[i].MinTradePrice)
			BuyPrice[i] = Tradeitem[i].MinTradePrice;
		if (BuyPrice[i] > Tradeitem[i].MaxTradePrice)
			BuyPrice[i] = Tradeitem[i].MaxTradePrice;
		
		currentState = eSellInOrbit;
		activeTradeItem = i;
		int emptyCargoBays = ([self totalCargoBays] - [self filledCargoBays]);
		int numOfItemsCanBuy = (credits / BuyPrice[i]);
		int minNumValue = min(numOfItemsCanBuy, emptyCargoBays);
		if (minNumValue > 0) {
			NSString *message = [NSString stringWithFormat:@"The trader wants to sell %@, for the price of %i cr. each. The trader is selling %i unit(s). "
								 "You can\nafford %i unit(s).\nHow many do you want to buy?\n\n\n\n", [NSString stringWithFormat:@"%s", Tradeitem[i].Name], BuyPrice[i],  Opponent.Cargo[i],
								 credits / BuyPrice[i]];
			
			AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Trade in Space" yoffset:60 
																			buyValue:min(minNumValue,Opponent.Cargo[i]) minValue:1 message:message  
																			delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Purchase"];
			
			[myAlertView show];
			[myAlertView release];			
		}
		else {
			[self FrmAlert:NSLocalizedString(@"CantAffordAlert", @"")];
			[self playSpeechFile:@"NotEnoughCredits.caf"];
			[self travel];
			[encounterViewControllerInstance showEncounterWindow];
		}
		
	}
	return FALSE;
}

-(BOOL)yieldContinue {
	if (browerStatus == 1 || (reactorStatus > 0 && reactorStatus < 21)) {
		[self Arrested];
	}
	else {					
		if (policeRecordScore > DUBIOUSSCORE)
			policeRecordScore = DUBIOUSSCORE;
		ship.Cargo[NARCOTICS]=0;
		ship.Cargo[FIREARMS]=0;
		
		[self FrmAlert:NSLocalizedString(@"YieldNarcoticsAlert", @"")];
	}
	[self travel];
	[encounterViewControllerInstance showEncounterWindow];
	
	return FALSE;
}

-(BOOL)yield {
	if (browerStatus == 1) {
		currentState = eYieldChoice;
		AlertModalTextWindow *myAlertView = [[AlertModalTextWindow alloc] initWithTitle:@"You have Jack Brower on board!" yoffset:90 message:@"Brower will be arrested, too."  
																		delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Yield"  thirdButtonTitle:nil];
		
		[myAlertView show];
		[myAlertView release];		
		return TRUE;
	}
	else if (reactorStatus > 0 && reactorStatus < 21) {
		currentState = eYieldChoice;		
		currentState = eYieldChoice;		
		AlertModalTextWindow *myAlertView = [[AlertModalTextWindow alloc] initWithTitle:@"You have an illegal Reactor on board!" yoffset:90 message:@"They will destroy the reactor."  
																		delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Yield"  thirdButtonTitle:nil];
		
		[myAlertView show];
		[myAlertView release];		
		return TRUE;
	}
	return [self yieldContinue];
}

-(BOOL) surrender {
	autoAttack = FALSE;
	autoFlee = FALSE;
	if (Opponent.Type == MANTISTYPE) {
		if (artifactOnBoard) {
			currentState = eSurrenderArtifact;		
			UIAlertView *myAlertView = [[UIAlertView alloc] initWithTitle:@"Surrender!" message:NSLocalizedString(@"WantToSurrenderToAliensAlert", @"")  
																 delegate:self cancelButtonTitle:@"Surrender" otherButtonTitles:@"Cancel",nil];
			
			[myAlertView show];
			[myAlertView release];		
			bLastMessage = FALSE;
		}
		else {
			[self FrmAlert:NSLocalizedString(@"NoSurrenderAlert", @"")];
			return TRUE;
		}
	}
	else if (ENCOUNTERPOLICE( encounterType )) {
		if (policeRecordScore <= PSYCHOPATHSCORE) {
			[self FrmAlert:NSLocalizedString(@"NoSurrenderAlert", @"")];
			return TRUE;
		}
		else {
			if (browerStatus == 1) {
				currentState = eSurrender;
				UIAlertView *myAlertView = [[UIAlertView alloc] initWithTitle:@"You have Jack Brower on board!" message:@"Brower will be arrested, too."  
																	 delegate:self cancelButtonTitle:@"Surrender" otherButtonTitles:@"Cancel", nil];
				
				[myAlertView show];
				[myAlertView release];		
				bLastMessage = FALSE;
				return TRUE;
			}
			else if (reactorStatus > 0 && reactorStatus < 21) {
				currentState = eSurrender;		
				UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"You have an illegal Reactor on board!" message:@"They will destroy the reactor."  
																	  delegate:self cancelButtonTitle:@"Surrender" otherButtonTitles:@"Cancel", nil];
				
				[myAlertView show];
				[myAlertView release];		
				bLastMessage = FALSE;
				return TRUE;
			}
			else {
				currentState = eSurrender;						
				UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Surrender!" message:NSLocalizedString(@"WantToSurrenderAlert", @"")  
																	  delegate:self cancelButtonTitle:@"Surrender" otherButtonTitles:@"Cancel", nil];
				
				[myAlertView show];
				[myAlertView release];		
				bLastMessage = FALSE;
				return TRUE;
			}			
			[self Arrested];
			return TRUE;
		}
	}
	else {
		raided = TRUE;		
		int TotalCargo = 0;
		int i;
		for (i=0; i<MAXTRADEITEM; ++i)
			TotalCargo += ship.Cargo[i];
		if (TotalCargo <= 0) {
			int Blackmail = min( 25000, max( 500, [self currentWorth] / 20 ) );
			[self FrmAlert:NSLocalizedString(@"PiratesFindNoCargoAlert", @"")];
			if (credits >= Blackmail)
				credits -= Blackmail;
			else {
				debt += (Blackmail - credits);
				credits = 0;
			}
		}		
		else {	
			[self FrmAlert:NSLocalizedString(@"PiratesPlunderAlert", @"")];									
			
			int Bays = Shiptype[Opponent.Type].CargoBays;
			for (i=0; i<MAXGADGET; ++i)
				if (Opponent.Gadget[i] == EXTRABAYS)
					Bays += 5;
			for (i=0; i<MAXTRADEITEM; ++i)
				Bays -= Opponent.Cargo[i];
			
			if (Bays >= TotalCargo) {
				for (i=0; i<MAXTRADEITEM; ++i) {
					ship.Cargo[i] = 0;
					BuyingPrice[i] = 0;
				}
			}		
			else {		
				while (Bays > 0) {
					i = GetRandom( MAXTRADEITEM );
					if (ship.Cargo[i] > 0) {
						BuyingPrice[i] = (BuyingPrice[i] * (ship.Cargo[i] - 1)) / ship.Cargo[i];
						--ship.Cargo[i];
						--Bays;
					}
				}
			}
		}
		if ((browerStatus == 1) && (Shiptype[Opponent.Type].CrewQuarters > 1)) {
			browerStatus = 0;
			[self FrmAlert:NSLocalizedString(@"BrowerGoesWithPiratesAlert", @"")];
		}
		else if (browerStatus == 1) {
			[self FrmAlert:NSLocalizedString(@"BrowerStaysAboardAlert", @"")];
		}
		if (reactorStatus > 0 && reactorStatus < 21) {
			[self FrmAlert:NSLocalizedString(@"PiratesDontStealReactorAlert", @"")];
		}
	}
	[self travel];
	[encounterViewControllerInstance showEncounterWindow];
	
	return FALSE;
}

-(BOOL)bribeContinue {
	bribe = [self currentWorth] / 
	((10L + 5L * (IMPOSSIBLE - gameDifficulty)) * Politics[solarSystem[warpSystem].Politics].BribeLevel);
	if (bribe % 100 != 0)
		bribe += (100 - (bribe % 100));
	if (browerStatus == 1 || (reactorStatus > 0 && reactorStatus < 21)) {
		if (gameDifficulty <= NORMAL)
			bribe *= 2;
		else
			bribe *= 3;
	}
	bribe = max( 100, min( bribe, 10000 ) );
	
	NSString* str = [NSString stringWithFormat:@"The Police are willing to forego inspection for amount of %i credits.", bribe];
	currentState = eBribeOffer;			
	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Bribe" message:str
																	delegate:self cancelButtonTitle:@"Bribe" otherButtonTitles:@"Cancel",nil];
	
	[myAlertView show];
	[myAlertView release];		
	bLastMessage = FALSE;
	return TRUE;	
	
}

-(BOOL)bribe {
	autoAttack = FALSE;
	autoFlee = FALSE;
	if (Politics[solarSystem[warpSystem].Politics].BribeLevel <= 0) {
		[self FrmAlert:NSLocalizedString(@"CantBeBribedAlert", @"")];
		return TRUE;
	}
	
	if (encounterType == POSTMARYPOLICEENCOUNTER) {
		[self FrmAlert:NSLocalizedString(@"MaryCantBeBribedAlert", @"")];
		return TRUE;
	}
	
	if (encounterType == POLICEINSPECTION && ship.Cargo[FIREARMS] <= 0 &&
		ship.Cargo[NARCOTICS] <= 0 && browerStatus != 1) {
		currentState = eBribePropsal;
		UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Bribe" message:
									 NSLocalizedString(@"SureToFleeOrBribeAlert", @"") delegate:self cancelButtonTitle:@"Cancel" otherButtonTitles:@"Bribe", nil];
		
		[myAlertView show];
		[myAlertView release];		
		bLastMessage = FALSE;
		return TRUE;
	}	
	return [self bribeContinue];	
}

-(BOOL)submit {
	autoAttack = FALSE;
	autoFlee = FALSE;
	if (encounterType == POLICEINSPECTION && (ship.Cargo[FIREARMS] > 0 ||
											  ship.Cargo[NARCOTICS] > 0 || browerStatus == 1 ||
											  (reactorStatus > 1 && reactorStatus < 21))) {

		currentState = eSubmit;
		UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Encounter" message:
										  NSLocalizedString(@"SureToSubmitAlert", @"") delegate:self cancelButtonTitle:@"Flee" otherButtonTitles:@"Submit",nil];
		
		[myAlertView show];
		[myAlertView release];		
		[self showUserNotice:aWarning];
		bLastMessage = FALSE;		
		return TRUE;		
	}
	return [self submitContinue];	
}

-(BOOL) submitContinue {
	if ((ship.Cargo[FIREARMS] > 0) || (ship.Cargo[NARCOTICS] > 0)) {
		ship.Cargo[FIREARMS] = 0;
		BuyingPrice[FIREARMS] = 0;
		ship.Cargo[NARCOTICS] = 0;
		BuyingPrice[NARCOTICS] = 0;
		int Fine = [self currentNetWorth] / ((IMPOSSIBLE+2-gameDifficulty) * 10L);
		if (Fine % 50 != 0)
			Fine += (50 - (Fine % 50));
		Fine = max( 100, min( Fine, 10000 ) );
		if (credits >= Fine)
			credits -= Fine;
		else {
			debt += (Fine - credits);
			credits = 0;
		}		
		NSString* str = [NSString stringWithFormat:@"The Police discover illegal goods in your cargo holds. These goods will be impounded and you are fined %i credits.", Fine];
		[self FrmAlert:str];		
		[self showUserNotice:aWarning];
		
		policeRecordScore += TRAFFICKING;
	}
	else if (browerStatus != 1) {
		[self FrmAlert:NSLocalizedString(@"NoIllegalGoodsAlert", @"")];
		[self playSpeechFile:@"InspectionPassed.caf"];
		policeRecordScore -= TRAFFICKING;
	}
	if (browerStatus == 1) {
		[self Arrested];
		return TRUE;
	}
	if (reactorStatus > 0 && reactorStatus < 21) {
		[self FrmAlert:NSLocalizedString(@"PoliceConfiscateReactorAlert", @"")];
		reactorStatus = 0;		
	}	
	[self travel];
	[encounterViewControllerInstance showEncounterWindow];
	return FALSE;
}

-(BOOL)plunder {
	autoAttack = FALSE;
	autoFlee = FALSE;
	if (ENCOUNTERTRADER( encounterType ))
		policeRecordScore += PLUNDERTRADERSCORE;
	else
		policeRecordScore += PLUNDERPIRATESCORE;
	
	[self showPlunderForm:ePlunderShip];
	return TRUE;
}

-(BOOL)interrupt {
	autoFlee = FALSE;
	autoAttack = FALSE;
	return FALSE;	
}

-(BOOL)meet {
	if (encounterType == CAPTAINADAMAENCOUNTER) {
		currentState = eEngageCaptainAdamaAlert;
		[self FrmAlertWithState:NSLocalizedString(@"EngageCaptainAdamaAlert", @"") state:eEngageCaptainAdamaAlert];
	}
	else if (encounterType == CAPTAINBELLOWSENCOUNTER) {
		currentState = eEngageCaptainBellowsAlert;
		[self FrmAlertWithState:NSLocalizedString(@"EngageCaptainBellowsAlert", @"")  state:eEngageCaptainBellowsAlert];
	}
	else if (encounterType == CAPTAINLYNNENCOUNTER) {
		currentState = eEngageCaptainLynnAlert;
		[self FrmAlertWithState:NSLocalizedString(@"EngageCaptainLynnAlert", @"") state:eEngageCaptainLynnAlert];
	}	
	return TRUE;
}

-(BOOL)board {
	if (encounterType == MARYCOCHRANENCOUNTER) {
		currentState = eBoard;			
		[self showUserNotice:aCaution];
		UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Encounter"  message:
										  NSLocalizedString(@"EngageMaryAlert", @"") delegate:self cancelButtonTitle:@"Cancel" otherButtonTitles:@"Take Cargo",nil];
		
		[myAlertView show];
		[myAlertView release];		
		bLastMessage = FALSE;
		return TRUE;
	}
	else {
		[self travel];
		[encounterViewControllerInstance showEncounterWindow];
		return FALSE;			
	}	
}

-(BOOL)drink {
	if (encounterType == BOTTLEGOODENCOUNTER) {
		[self playSoundFile:@"Bottle.caf"];
		currentState = eBottleGood;		
	}
	else if (encounterType == BOTTLEOLDENCOUNTER) {
		[self playSoundFile:@"Bottle.caf"];
		currentState = eBottleStrange;
	} else {
		[self travel];
		[encounterViewControllerInstance showEncounterWindow];
		return FALSE;			
	}
	UIAlertView *myAlertView = [[UIAlertView alloc] initWithTitle:@"Encounter" message:NSLocalizedString(@"EngageBottleAlert", @"") 
														  delegate:self cancelButtonTitle:@"Discard" otherButtonTitles:@"Consume", nil];
	
	[myAlertView show];
	[myAlertView release];		
	bLastMessage = FALSE;
	return TRUE;
}

#pragma mark Handle Alert View
- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
	bLastMessage = TRUE;
	int button = buttonIndex;
	if (currentState == eTradeInOrbit) {
		int j = 0;
		if (button == 1) {
			unsigned int val = (int)[[(AlertModalWindow*)alertView mySlider]value];
			j = max(0, min(ship.Cargo[activeTradeItem], val));
		} else if (button == 2) {
			j = ship.Cargo[activeTradeItem];
		}
		j = min( j, Shiptype[Opponent.Type].CargoBays );
		if (j > 0) {
			BuyingPrice[activeTradeItem] = BuyingPrice[activeTradeItem]*(ship.Cargo[activeTradeItem]-j)/ship.Cargo[activeTradeItem];
			ship.Cargo[activeTradeItem] -= j;
			Opponent.Cargo[activeTradeItem] = j;
			credits += j * SellPrice[activeTradeItem];
			[self FrmAlertWithTitle:[NSString stringWithFormat:@"Thanks for selling us the %s.", Tradeitem[activeTradeItem].Name ] Title:@"Trade Completed"];			
			[self playSpeechFile:@"TransactionComplete.caf"];
		}
		[self travel];
		[encounterViewControllerInstance showEncounterWindow];
	} else
		if (currentState == eSellInOrbit) {
			int i = activeTradeItem;
			int j = 0;
			if (button == 1) {
				unsigned int val = (int)[[(AlertModalWindow*)alertView mySlider]value];
				j = max(0, min(Opponent.Cargo[i], val));
			} else if (button == 2) {
				j = min(Opponent.Cargo[i], ([self totalCargoBays]-[self filledCargoBays]));
			}
			j = min ( j, (credits / BuyPrice[i]));
			if (j > 0) {
				ship.Cargo[i] += j;
				Opponent.Cargo[i] -= j;
				BuyingPrice[i] += (j * BuyPrice[i]);
				credits -= (j * BuyPrice[i]);
				[self FrmAlertWithTitle:[NSString stringWithFormat:@"Thanks for buying the %s.", Tradeitem[activeTradeItem].Name ] Title:@"Trade Completed"];
				[self playSpeechFile:@"TransactionComplete.caf"];
			}
			[self travel];
			[encounterViewControllerInstance showEncounterWindow];
		} else if (currentState == eYieldChoice) {
				if (button == 1) {
					[self yieldContinue];
				}
			}
	if (currentState == eSurrender) {
		if (button == 0) {
			[self Arrested];
		}		
	}	
	if (currentState == eSurrenderArtifact) {
		if (button == 1) {
			artifactOnBoard = 0;
		}
		[self travel];
		[encounterViewControllerInstance showEncounterWindow];
	}
	if (currentState == eBottleGood){
		if (button == 1) {
			[self IncreaseRandomSkill];
			if (gameDifficulty < HARD)
				[self IncreaseRandomSkill];
			[self FrmAlert:NSLocalizedString(@"GoodDrinkAlert", @"")];
			[[SoundManager sharedSound]playSoundWithId:kBuy];
		}
		[self travel];
		[encounterViewControllerInstance showEncounterWindow];		
	}
	if (currentState == eBottleStrange){
		if (button == 1) {
			[self TonicTweakRandomSkill];
			[self FrmAlert:NSLocalizedString(@"StrangeDrinkAlert", @"")];
			[[SoundManager sharedSound]playSoundWithId:kCancel];
		}
		[self travel];
		[encounterViewControllerInstance showEncounterWindow];		
	}
	if (currentState == eBoard) {
		if (button == 1) {
			currentState = ePlunderShipForm;
		}
	}
	if (currentState == ePlunderForm) {
		if (button == 0) {
			currentState = eDummy;
			bWaitFinishPlunder = FALSE;
			[self finishPlunder];
		} else 
			if (button == 1) {
				currentState = eDummy;
				[self showPlunderForm:ePickItUp];				
			}		
	}
	else if (currentState == ePlunderShipForm) {
		if (button == 0) {
			currentState = eDummy;					
			bWaitFinishPlunder = FALSE;
			[self finishPlunder];
		} else 
			if (button == 1) {
				currentState = eDummy;	
				bWaitFinishPlunder = TRUE;
				[self showOpponentForm];
			}
	}
	else if (currentState == ePlunderRemoveGoods) {
		currentState = eDummy;		
		if (button == 1) {
			bWaitFinishPlunder = TRUE;
			[self showJettisonForm];
		}
		else {
			bWaitFinishPlunder = FALSE;
			[self finishPlunder];
		}
	}
	if (currentState == eBribePropsal && button == 1) {
		button = -1;
		[self bribeContinue];
	}
	if (currentState == eBribeOffer && button == 0) {
		if (credits < bribe) {
			[self FrmAlert:NSLocalizedString(@"NoMoneyForBribeAlert", @"")];
			return;
		}
		credits -= bribe;
		[self travel];
		[encounterViewControllerInstance showEncounterWindow];
		return;
	}	
	if (currentState == eSubmit && button == 1)
		[self submitContinue];
	
	if (currentState == eSubmit && button == 0) {
		policeRecordScore += TRAFFICKING;
		[self FrmAlert:NSLocalizedString(@"PoliceHaveTicketedYou", @"")];
		[self showUserNotice:aAlert];
		[self travel];
		[encounterViewControllerInstance showEncounterWindow];
	}
	if (currentState == eEngageCaptainAdamaAlert && button == 1) {
		int i=MAXSHIELD - 1;
		while (i >= 0) {
			if (ship.Shield[i] == REFLECTIVESHIELD) {
				for (int m=i+1; m<MAXSHIELD; ++m) {
					ship.Shield[m-1] = ship.Shield[m];
					ship.ShieldStrength[m-1] = ship.ShieldStrength[m];
				}
				ship.Shield[MAXSHIELD-1] = -1;
				ship.ShieldStrength[MAXSHIELD-1] = 0;
				i = -1;
			}
			i--;
		}
		if (gameDifficulty < HARD)
			pilotSkill += 2;
		else
			pilotSkill += 1;
		
		if (pilotSkill > MAXSKILL) {
			pilotSkill = MAXSKILL;
		}
		[self FrmAlert:NSLocalizedString(@"TrainingCompletedAlert", @"")];
		[self travel];
		[encounterViewControllerInstance showEncounterWindow];
		[self updateMercenary0Data];
		return;
	}
	
	if (currentState == eEngageCaptainBellowsAlert && button == 1) {
		int i=MAXWEAPON - 1;
		while (i>=0) {
			if (ship.Weapon[i] == MILITARYLASERWEAPON) {
				for (int m=i+1; m<MAXWEAPON; ++m) {
					ship.Weapon[m-1] = ship.Weapon[m];
				}
				ship.Weapon[MAXWEAPON-1] = -1;
				i = -1;
			}
			i--;
		}
		if (gameDifficulty < HARD)
			engineerSkill += 2;
		else
			engineerSkill += 1;
		
		if (engineerSkill > MAXSKILL) {
			engineerSkill = MAXSKILL;
		}
		[self FrmAlert:NSLocalizedString(@"TrainingCompletedAlert", @"")];
		[self travel];
		[encounterViewControllerInstance showEncounterWindow];
		[self updateMercenary0Data];
		return;
	}
	if (currentState == eEngageCaptainLynnAlert && button == 1) {
		int i=MAXWEAPON - 1;
		while (i>=0) {
			if (ship.Weapon[i] == MILITARYLASERWEAPON) {
				for (int m=i+1; m<MAXWEAPON; ++m) {
					ship.Weapon[m-1] = ship.Weapon[m];
				}
				ship.Weapon[MAXWEAPON-1] = -1;
				i = -1;
			}
			i--;
		}
		if (gameDifficulty < HARD)
			traderSkill += 2;
		else
			traderSkill += 1;
		
		if (traderSkill > MAXSKILL) {
			traderSkill = MAXSKILL;
		}
		[self RecalculateBuyPrices:currentSystem];
		[self FrmAlert:NSLocalizedString(@"TrainingCompletedAlert", @"")];
		[self travel];
		[encounterViewControllerInstance showEncounterWindow];
		[self updateMercenary0Data];
		return;		
	}
	if (currentState == eBuyEquipment && button == 1) {
		saveItem[saveSlot] = saveItemIndex;
		credits -= savePrice;
		if (saveItem == ship.Weapon) {
			[self playSpeechFile:@"WeaponInstalled.caf"];
		} else if (saveItem == ship.Shield) {
			[self playSpeechFile:@"ShieldInstalled.caf"];
		} else {
			[self playSpeechFile:@"GadgetInstalled.caf"];
		}	
		[buyController updateView];
	}
	if (currentState == eSpecialEvent && (button == 1 || SpecialEvent[CURSYSTEM.Special].JustAMessage)) {
		[self specialEventFormHandleEvent];
		[systemInfoController updateInfoView];
	}
	if (currentState == eBrowerWeaponBuy && button == 1) {
		browerStatus = 0;
		[self FrmAlert:NSLocalizedString(@"BrowerLeavesShipAlert", @"")];
		[self doWarp:viaSingularitySaved];
	}	
	if (currentState == eUpdateSpecial) {
		[systemInfoController updateInfoView];
	}
	if (currentState == ePickupPassengers && button == 1) {
		credits += (int)([self calculateTravelFee] * .10);
		transportPassengers = TRUE;
		trackedSystem = passengersDestination;
		[self FrmAlert:NSLocalizedString(@"PassengersHaveBoarded", @"")];
		if (nameSoundIsDone) 
			[self playSpeechFile:@"PassengersBoarded.caf"];
		else 
			[self performSelector:@selector(playPassengersBoardedNotice) withObject:self afterDelay:1.1];
		
		[systemInfoController updateInfoView];
		didUsePEP = FALSE;
	}
	if (currentState == eBuyNewShip && button == 1) {
		[self buyShip:newShip];
		[buyNewShipController updateView];		
	}	
	if (currentState == eLiteVersionNotice && button == 1) {
		[[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"http://darknova.net/hyperwarp.html"]];
	}	
	
}

#pragma mark Commander Status Info
-(int) OpenQuests {
	int r = 0;
	if (monsterStatus == 1)
		++r;

	if (dragonflyStatus >= 1 && dragonflyStatus <= 4)
		++r;
	else if (solarSystem[ZORKONSYSTEM].Special == INSTALLQUANTUMSHIELD)
		++r;
	
	if (japoriDiseaseStatus == 1)
		++r;
	
	if (artifactOnBoard)
		++r;
	
	if (browerStatus == 1)
		++r;
	
	if (jarekStatus == 1)
		++r;
	
	if (invasionStatus >= 1 && invasionStatus < 7)
		++r;
	else if (solarSystem[GEMULONSYSTEM].Special == GETFUELCOMPACTOR)
		++r;
	
	if (experimentStatus >= 1 && experimentStatus < 11)
		++r;
	
	if (reactorStatus >= 1 && reactorStatus < 21)
		++r;
	
	if (solarSystem[NIXSYSTEM].Special == GETSPECIALLASER)
		++r;
	
	if (scarabStatus == 1)
		++r;
	
	if (ship.Tribbles > 0)
		++r;
	
	if (ship.RygellianFleas > 0)
		++r;
	if (transportPassengers)
		++r;
	
	if (moonBought)
		++r;
	
	return r;
}

-(NSString*) drawQuestsForm {
	NSMutableString *header = [[NSMutableString alloc] init];
	if([self OpenQuests])
		[header appendString:@"Quests:\n"];
	else
		[header appendString:@"There are no open quests."];
	
	if (monsterStatus == 1) {
		[header appendString:@" Kill the band of pirates at Acamar.\n"];
		
	}
	if (dragonflyStatus >= 1 && dragonflyStatus <= 4) {
		[header appendString:@" Follow the Dragonfly to "];
		if (dragonflyStatus == 1)
			[header appendString:@"Baratas.\n"];
		else if (dragonflyStatus == 2)
			[header appendString:@"Melina.\n"];
		else if (dragonflyStatus == 3)
			[header appendString:@"Rigulus.\n"];
		else if (dragonflyStatus == 4)
			[header appendString:@"Zorkon.\n"];
		
	} else if (solarSystem[ZORKONSYSTEM].Special == INSTALLQUANTUMSHIELD) {
		[header appendString:@" Get your lightning shield at Zorkon.\n"];		
	}
	if (japoriDiseaseStatus == 1) {
		[header appendString:@" Deliver antidote to Ja'pori.\n"];
	}
	if (artifactOnBoard) {
		[header appendString:@" Deliver the alien artifact to professor Digby at some hi-tech system.\n"];			
	}
	if (browerStatus == 1) {
		[header appendString:@" Smuggle Jack Brower to Kravat.\n"];
	}
	if (jarekStatus == 1) {
		[header appendString:@" Bring Ambassador Jarek to Devidia.\n"];
	}

	if (invasionStatus >= 1 && invasionStatus < 7) {
		[header appendString:@" Inform Gemulon about alien invasion"];
		if (invasionStatus == 6) {
		    [header appendString:@" by tomorrow\n"];			
		} else {
		    [header appendString:@" within "];
			NSString * t = [NSString stringWithFormat:@"%i days.\n", 7 - invasionStatus];
			[header appendString:t];
		}
	} else if (solarSystem[GEMULONSYSTEM].Special == GETFUELCOMPACTOR) {
		[header appendString:@" Get your fuel compactor at Gemulon.\n"];
	}
	if (experimentStatus >= 1 && experimentStatus < 11) {
		[header appendString:@" Stop Dr. Porter's experiment at Daled "];
		if (experimentStatus == 10) {
		    [header appendString:@"by tomorrow\n"];
			
		} else {
		    [header appendString:@"within "];
			NSString *t = [NSString stringWithFormat:@"%i day(s).\n", 11 - experimentStatus];
			[header appendString:t];
		}
	}
	if (reactorStatus >= 1 && reactorStatus < 21) {
		[header appendString:@" Deliver the unstable reactor to Nix "];
		
		if (reactorStatus < 2) {
			[header appendString:@"for Joseph Talbot.\n"];
		} else {
			[header appendString:@"before it consumes all its fuel.\n"];
		}
	}
	if (solarSystem[NIXSYSTEM].Special == GETSPECIALLASER) {
		[header appendString:@" Get your special laser at Nix.\n"];
	}
	if (scarabStatus == 1) {
		[header appendString:@" Find and destroy the Scarab (which is hiding at the exit to a wormhole).\n"];
	}
	if (ship.Tribbles > 0) {
		[header appendString:@" Get rid of those pesky tribbles.\n"];
	}
	if (ship.RygellianFleas > 0) {
		[header appendString:@" Get rid of those nasty fleas!\n"];
	}
	if (transportPassengers) {
		[header appendString:[NSString stringWithFormat:@" Deliver your passengers to %@.\n",[self getSolarSystemName:passengersDestination]]];
	}
	if (moonBought) { 
		[header appendString:@" Claim your moon at Utopia."];			
	}
	return [header autorelease];
}

-(NSString*) drawQuestsForm:(SystemInfoViewController*)controller {
	systemInfoController = controller;
	return [self drawQuestsForm];
}

-(void) setInfoViewController:(SystemInfoViewController*)controller {
	systemInfoController = controller;
}

-(NSString*) drawSpecialCargoForm {
	NSMutableString *header = [[NSMutableString alloc] init];
	BOOL bSpecialItem = FALSE;
	if (ship.Tribbles > 0) {
		if (ship.Tribbles >= MAXTRIBBLES) {
			[header appendString:@" An infestation of tribbles.\n"];
		} else {
			NSString *t = [NSString stringWithFormat:@" %i cute, furry tribble(s).\n", ship.Tribbles];
			[header appendString:t];		
		}
		bSpecialItem = TRUE;
	}
	if (ship.RygellianFleas > 0) {
		[header appendString:@" An infestation of fleas.\n"];
		bSpecialItem = TRUE;
	}
	if (japoriDiseaseStatus == 1) {
		bSpecialItem = TRUE;	
		[header appendString:@" 10 bays of antidote.\n"];
	}
	if (artifactOnBoard) {
		bSpecialItem = TRUE;		
		[header appendString:@" An alien artifact.\n"];
	}
	if (jarekStatus == 2) {
		bSpecialItem = TRUE;		
		[header appendString:@" A haggling computer.\n"];
	}
	if (reactorStatus > 0 && reactorStatus < 21) {
		bSpecialItem = TRUE;		
		[header appendString:@" An unstable reactor taking up 5 bays."];
		NSString * t = [NSString stringWithFormat:@"%i bay of enriched fuel.\n", 10 - ((reactorStatus - 1) / 2)];
		[header appendString:t];
	}
	if (canSuperWarp) {
		bSpecialItem = TRUE;
		[header appendString:@" A Portable Singularity.\n"];
	}
	if (!bSpecialItem) {
		[header appendString:@"No special items."];
	}
	return [header autorelease];
}

-(NSString*) drawCurrentShipForm {
	int i, j, k, FirstEmptySlot;
	NSMutableString *header = [[NSMutableString alloc] init];		
	[header appendString:@"Installed :\n"];			
	for (i=0; i<MAXWEAPONTYPE+EXTRAWEAPONS; ++i) {
		j = 0;
		for (k=0; k<MAXWEAPON; ++k) {
			if (ship.Weapon[k] == i) {
				++j;				
			}
		}
		if (j > 0) {
			for (; j >0; --j) {
				[header appendString:[NSString stringWithFormat:@" %s : [%i]", Weapontype[i].Name, Weapontype[i].Power]];
				[header appendString:@"\n"];
			}
		}
	}
	
	for (i=0; i<MAXSHIELDTYPE+EXTRASHIELDS; ++i) {
		j = 0;
		
		for (k=0; k<MAXSHIELD; ++k) {
			if (ship.Shield[k] == i) {
				++j;        
			}
		}
		
		if (j > 0) { 
			for (; j >0; --j) {
				[header appendString:[NSString stringWithFormat:@" %s : [%i]", Shieldtype[i].Name, Shieldtype[i].Power]];
				[header appendString:@"\n"];
			}
		}
	}
	
	for (i=0; i<MAXGADGETTYPE+EXTRAGADGETS; ++i) {
		j = 0;
		
		for (k=0; k<MAXGADGET; ++k) {
			if (ship.Gadget[k] == i) {
				++j;        
			}
		}
		
		if (j > 0) {
			if (i == EXTRABAYS) {
				j = j*5;
				[header appendString:[NSString stringWithFormat:@" %i extra cargo bays\n", j]];
			} else {
				[header appendString:[NSString stringWithFormat:@" %s", Gadgettype[i].Name]];
				[header appendString:@"\n"];			
			}
		}
	}
	
	if (escapePod) {
		[header appendString:@" Escape Pod\n"];			
	}
	
	if ([self AnyEmptySlots:&ship]) {			
		[header appendString:@"Unfilled :\n"];			
		
		FirstEmptySlot = [self getFirstEmptySlot:Shiptype[ship.Type].WeaponSlots Item: ship.Weapon];
		if (FirstEmptySlot >= 0) {
			[header appendString:[NSString stringWithFormat:@"%i weapon slot(s)\n",Shiptype[ship.Type].WeaponSlots - FirstEmptySlot]];
		}
		
		FirstEmptySlot = [self getFirstEmptySlot:Shiptype[ship.Type].ShieldSlots Item:ship.Shield];
		if (FirstEmptySlot >= 0) {
			[header appendString:[NSString stringWithFormat:@"%i shield slot(s)\n",Shiptype[ship.Type].ShieldSlots - FirstEmptySlot]];
		}
		
		FirstEmptySlot = [self  getFirstEmptySlot:Shiptype[ship.Type].GadgetSlots Item:ship.Gadget];
		if (FirstEmptySlot >= 0){
			[header appendString:[NSString stringWithFormat:@"%i gadget slot(s)\n",Shiptype[ship.Type].GadgetSlots - FirstEmptySlot]];
		}
	}
	return [header autorelease];
}

#pragma mark Equipment Info
-(NSString*)getEquipmentName:(int)index {
	if (index < MAXWEAPONTYPE) {
		return [NSString stringWithFormat:@"%s", Weapontype[index].Name];	    
	} else {    
		if (index < MAXWEAPONTYPE + MAXSHIELDTYPE) {
			return [NSString stringWithFormat:@"%s", Shieldtype[index - MAXWEAPONTYPE].Name];				
		} else {
			return [NSString stringWithFormat:@"%s", Gadgettype[index - MAXWEAPONTYPE - MAXSHIELDTYPE].Name];							
		}
	}
}

-(NSString*)getShipEquipmentName:(int)index {	
	if (index < MAXWEAPON && ship.Weapon[index] >= 0) {
		return [NSString stringWithFormat:@"%s", Weapontype[ship.Weapon[index]].Name];	
		
	} else {    
		if (index < MAXWEAPON + MAXSHIELD && ship.Shield[index - MAXWEAPON] >=0 ) {
			return [NSString stringWithFormat:@"%s", Shieldtype[ship.Shield[index - MAXWEAPON]].Name];				
		} else {
			if (ship.Gadget[index - MAXWEAPON - MAXSHIELD] >= 0) {
				return [NSString stringWithFormat:@"%s", Gadgettype[ship.Gadget[index - MAXWEAPON - MAXSHIELD]].Name];							
			}
		}
	}
	return @"";
}

-(long) BasePrice:(char) ItemTechLevel Price:( long) Price {
	return ((ItemTechLevel > CURSYSTEM.TechLevel) ? 0 : ((Price * (100 - [self TraderSkill:&ship])) / 100));
}

-(int)getEquipmentPrice:(int)index {
	if (index < MAXWEAPONTYPE) {
		return BASEWEAPONPRICE(index);	    
	} else {
		if (index < MAXWEAPONTYPE + MAXSHIELDTYPE) {
			return BASESHIELDPRICE(index - MAXWEAPONTYPE);				
		} else {
			return BASEGADGETPRICE(index - MAXWEAPONTYPE - MAXSHIELDTYPE);							
		}	
	}
}

-(int)getSellEquipmentPrice:(int)index {
	if (index < MAXWEAPON) {
		return WEAPONSELLPRICE(index);	
	} else {
		if (index < MAXWEAPON + MAXSHIELD) {
			return SHIELDSELLPRICE(index - MAXWEAPON);				
		} else {
			return GADGETSELLPRICE(index - MAXWEAPON - MAXSHIELD);							
		}	
	}
}

-(void) buyEquipment:(Byte) Slots  Item:(int*) Item  Price:(long) Price  Name:(char*) Name ItemIndex:(int) ItemIndex {
	int FirstEmptySlot;	
	FirstEmptySlot = [self getFirstEmptySlot:Slots Item:Item];	
	if (Price <= 0) {
		[self FrmAlert:NSLocalizedString(@"ItemNotSoldAlert", @"")];
	} else if (debt > 0) {
		[self FrmAlert:NSLocalizedString(@"YoureInDebtAlert", @"")];
	} else if (Price > [self toSpend]) {
		[self FrmAlert:NSLocalizedString(@"CantBuyEquipmentAlert", @"")];    
		[self playSpeechFile:@"NotEnoughCredits.caf"];
	} else if (FirstEmptySlot < 0) {
		[self FrmAlert:NSLocalizedString(@"NotEnoughSlotsAlert", @"")];    
	} else {
		NSString *str; 
		if (Item == ship.Weapon) {
			str = [NSString stringWithFormat:@"Equipment Specifications\nWeapon Power : [%i]\nDo you wish to buy this weapon\nfor %i credits?", Weapontype[ItemIndex].Power, Price];
		} else if (Item == ship.Shield) {
			str = [NSString stringWithFormat:@"Equipment Specifications\nShield Strength : [%i]\nDo you wish to buy this shield\nfor %i credits?", Shieldtype[ItemIndex].Power, Price];
		}
		else {
			str = [NSString stringWithFormat:@"Do you wish to buy this gadget\nfor %i credits?", Price];
		}

		currentState = eBuyEquipment;
		NSString *name = [NSString stringWithFormat:@"Buy %s", Name];
				
		UIAlertView *myAlertView = [[UIAlertView alloc] initWithTitle:name message:str delegate:self cancelButtonTitle:@"Cancel" otherButtonTitles:@"Confirm",nil];	
		[myAlertView show];
		[myAlertView release];
		
		bLastMessage = FALSE;
		saveItem = Item;
		saveItemIndex= ItemIndex;
		savePrice = Price;
		saveSlot = FirstEmptySlot;
	}
}

-(void)tryToBuyEquipment:(int)index controller:(BuyEquipmentViewController *)controller {
	if (index < MAXWEAPONTYPE) {
		[self buyEquipment:Shiptype[ship.Type].WeaponSlots Item:ship.Weapon Price:BASEWEAPONPRICE(index) Name:Weapontype[index].Name ItemIndex:index];	
	} else {
		if (index < MAXWEAPONTYPE + MAXSHIELDTYPE) {
			[self buyEquipment:Shiptype[ship.Type].ShieldSlots Item:ship.Shield Price:BASESHIELDPRICE(index - MAXWEAPONTYPE) Name:Shieldtype[index- MAXWEAPONTYPE].Name ItemIndex:(index- MAXWEAPONTYPE)];				
		} else {
			[self buyEquipment:Shiptype[ship.Type].GadgetSlots Item:ship.Gadget Price:BASEGADGETPRICE(index - MAXWEAPONTYPE - MAXSHIELDTYPE) Name:Gadgettype[index - MAXWEAPONTYPE - MAXSHIELDTYPE].Name ItemIndex:(index - MAXWEAPONTYPE - MAXSHIELDTYPE)];						
		}		
	}
	buyController = controller;
}

-(void)sellEquipment:(int)index {
	if (index < MAXWEAPON) {
		credits += WEAPONSELLPRICE(index);
		for (int i = index + 1; i < MAXWEAPON; ++i) {
			ship.Weapon[i-1] = ship.Weapon[i];      
		}
		ship.Weapon[MAXWEAPON - 1] = -1;
		[self playSpeechFile:@"EquipmentSold.caf"];
	} else if (index < MAXWEAPON + MAXSHIELD) {
		index = index - MAXWEAPON;
		credits += WEAPONSELLPRICE(index);
		for (int i = index + 1; i < MAXSHIELD; ++i) {
			ship.Shield[i-1] = ship.Shield[i];
			ship.ShieldStrength[i-1] = ship.ShieldStrength[i];	
		}
		ship.Shield[MAXSHIELD - 1] = -1;
		ship.ShieldStrength[MAXSHIELD - 1] = -1;		
		[self playSpeechFile:@"EquipmentSold.caf"];
	} else {
		index = index - MAXWEAPON - MAXSHIELD;
		if ([self filledCargoBays] > [self totalCargoBays] - 5) {
			[self FrmAlert:NSLocalizedString(@"CargoBaysFullAlert", @"")];
			[self playSpeechFile:@"AllCargoBaysAreFull.caf"];
		} else {
			credits += GADGETSELLPRICE(index);
			for (int i = index + 1; i < MAXGADGET; ++i) {
				ship.Gadget[i-1] = ship.Gadget[i];
			}
			ship.Gadget[MAXGADGET - 1] = -1;		
			[self playSpeechFile:@"EquipmentSold.caf"];
		}
	}	
}

#pragma mark Merc Info
-(void) DrawMercenary:(int)index controller:(PersonnelRosterViewController *)controller  name:(UILabel *)name cost:(UILabel *)cost pilot:(UILabel *)pilot trader:(UILabel *)trader fighter:(UILabel*)fighter engineer:(UILabel*)engineer {
	name.hidden = FALSE;
	cost.hidden = FALSE;
	pilot.hidden = FALSE;
	trader.hidden = FALSE;
	fighter.hidden = FALSE;
	engineer.hidden = FALSE;
	
	name.text = [NSString stringWithFormat:@"%s", MercenaryName[Mercenary[index].NameIndex]];
	cost.text = [NSString stringWithFormat:@"Costs: %i cr. daily", MERCENARYHIREPRICE(index)];
	pilot.text = [NSString stringWithFormat:@"Pilot: %i", Mercenary[index].Pilot];
	trader.text = [NSString stringWithFormat:@"Trader: %i", Mercenary[index].Trader];
	fighter.text = [NSString stringWithFormat:@"Fighter: %i", Mercenary[index].Fighter];
	engineer.text = [NSString stringWithFormat:@"Engineer: %i", Mercenary[index].Engineer];	
}

-(int) GetForHire {
	int ForHire = -1;
	int i;
	for (i=1; i<MAXCREWMEMBER; ++i) {
		if (i == ship.Crew[1] || i == ship.Crew[2]) {
			continue;
		}
		if (Mercenary[i].CurSystem ==currentSystem) {
			ForHire = i;
			break;
		}
	}
	
	return ForHire;
}

-(void) updateRosterWindow:(PersonnelRosterViewController *)controller {
	int i = 0;
	{
		if (i == Shiptype[ship.Type].CrewQuarters-2 && (jarekStatus == 1 || browerStatus == 1)) {
			if (jarekStatus == 1) {
				controller.Vacancy0.text = @"Jarek's quarters.";
				controller.Vacancy0.hidden = FALSE;
			} else {
				controller.Vacancy0.text = @"Brower's quarters.";
				controller.Vacancy0.hidden = FALSE;
			}
		} else if (Shiptype[ship.Type].CrewQuarters <= i+1) {
			controller.Vacancy0.text = @"No quarters available";
			controller.Vacancy0.hidden = FALSE;
			
		} else if (ship.Crew[i+1] < 0) {
			controller.Vacancy0.text = @"Vacancy";
			controller.Vacancy0.hidden = FALSE;
		} else {
			[self DrawMercenary:ship.Crew[i+1] controller:controller name:controller.PilotName0 cost:controller.Price0 pilot:controller.Pilot0 trader:controller.Trader0 fighter:controller.Fighter0 engineer:controller.Engineer0];
			controller.fire0.hidden = FALSE;
		}	
	}
	
	{
		int i = 1;
		if (i == Shiptype[ship.Type].CrewQuarters-2 && (jarekStatus == 1 || browerStatus == 1)) {
			if (jarekStatus == 1) {
				controller.Vacancy1.text = @"Jarek's quarters.";
				controller.Vacancy1.hidden = FALSE;
			} else {
				controller.Vacancy1.text = @"Brower's quarters.";
				controller.Vacancy1.hidden = FALSE;
			}
		} else if (Shiptype[ship.Type].CrewQuarters <= i+1) {
			controller.Vacancy1.text = @"No quarters available";
			controller.Vacancy1.hidden = FALSE;
		} else if (ship.Crew[i+1] < 0) {
			controller.Vacancy1.text = @"Vacancy";
			controller.Vacancy1.hidden = FALSE;
		} else {
			[self DrawMercenary:ship.Crew[i+1] controller:controller name:controller.PilotName1 cost:controller.Price1 pilot:controller.Pilot1 trader:controller.Trader1 fighter:controller.Fighter1   engineer:controller.Engineer1];
			controller.fire1.hidden = FALSE;
		}	
	}
	
	int ForHire = [self GetForHire];
	if (ForHire < 0) {
		controller.Vacancy2.text = @"No one for hire";
		controller.Vacancy2.hidden = FALSE;
		
	} else {	
		[self DrawMercenary:ForHire controller:controller name:controller.PilotName2 cost:controller.Price2 pilot:controller.Pilot2 trader:controller.Trader2 fighter:controller.Fighter2 engineer:controller.Engineer2];
		controller.fire2.hidden = FALSE;
	}
	
}

-(void) fireMercenary:(int)index {
	int oldTraderSkill = [self TraderSkill:&ship];
	if (index == 1) {
		ship.Crew[1] = ship.Crew[2];
	}	
	ship.Crew[2] = -1;
	if (oldTraderSkill != [self TraderSkill:&ship]) {
		[self RecalculateBuyPrices:currentSystem];
	}
	[self playSpeechFile:@"MercFired.caf"];
}

-(int)AvailableQuarters {
	return Shiptype[ship.Type].CrewQuarters - (jarekStatus == 1 ? 1 : 0) - (browerStatus == 1 ? 1 : 0);
}

-(void) hireMercenaryFromRoster {
	int oldTraderSkill = [self TraderSkill:&ship];
	int ForHire = [self GetForHire];
	
	int FirstFree = -1;
	if (ship.Crew[1] == -1) {
		FirstFree = 1;
	} else if (ship.Crew[2] == -1) {
		FirstFree = 2;
	}
	
	if (FirstFree < 0 || [self AvailableQuarters] <= FirstFree) {
		[self FrmAlert:NSLocalizedString(@"NoFreeQuartersAlert", @"")];
	} else {
		ship.Crew[FirstFree] = ForHire;
		if (oldTraderSkill != [self TraderSkill:&ship]) {
			[self RecalculateBuyPrices:currentSystem];		
		}
		[self playSpeechFile:@"MercHired.caf"];
	}
	
}
		

-(int) nextSystemWithinRange:(int) Current Back:(Boolean) Back {
	int i = Current;
	(Back ? --i : ++i);	
	while (TRUE) {
		if (i < 0) {
			i = MAXSOLARSYSTEM - 1;
		} else if (i >= MAXSOLARSYSTEM) {
			i = 0;
		}
		if (i == Current) {
			break;
		}
		if ([self wormholeExists:currentSystem b:i]) {
			return i;      
		} else if ([self realDistance:currentSystem b:i]  <= [self getFuel] && [self realDistance:currentSystem b:i]  > 0) {
			return i;
		}		
		(Back ? --i : ++i);
	}
	
	return i;
}
-(BOOL)doesHireExist {
	return [self GetForHire] >= 0;
}


-(void)updateMercenary0Data {
	Mercenary[0].Trader = traderSkill;
	Mercenary[0].Engineer = engineerSkill;
	Mercenary[0].Fighter = fighterSkill;
	Mercenary[0].Pilot = pilotSkill;
}

#pragma mark Get Ship Info
-(long)getShipShield {
	return [self TotalShieldStrength:&ship];
}
-(long)getShipOpponentShield {
	return [self TotalShieldStrength:&Opponent];
}
-(long)getShipShieldMax {
	return [self TotalShields:&ship];
}
-(long)getShipOpponentShieldMax {
	return [self TotalShields:&Opponent];
}
-(long)getShipHullMax {
	return [self getHullStrength];
}
-(long)getShipOpponentHullMax {
	return Shiptype[Opponent.Type].HullStrength;
}

#pragma mark Get Skills
-(NSUInteger)adaptPilotSkill {
	return [self PilotSkill:&ship];
}
-(NSUInteger)adaptTraderSkill {
	return [self TraderSkill:&ship];
}
-(NSUInteger)adaptFighterSkill {
	return [self FighterSkill:&ship];
}
-(NSUInteger)adaptEngineerSkill {
	return [self EngineerSkill:&ship];
}

-(void) RecalculateSellPrices {
	int i;
	for (i=0; i<MAXTRADEITEM; ++i) {
		SellPrice[i] = (SellPrice[i] * 100) / 90;
	}
}


-(Byte) NthLowestSkill:(struct SHIP*)Sh  n:(Byte)n {
	Byte i = 0, lower = 1, retVal;
	Boolean looping = TRUE;
	while (looping) {
		retVal = 0;
		if (Mercenary[Sh->Crew[0]].Pilot == i) {
			if (lower == n) {
				looping = FALSE;
				retVal = PILOTSKILL;
			}			
			lower++;
		}
		if (Mercenary[Sh->Crew[0]].Fighter == i) {
			if (lower == n) {
				looping = FALSE;
				retVal = FIGHTERSKILL;
			}			
			lower++;
		}
		if (Mercenary[Sh->Crew[0]].Trader == i) {
			if (lower == n) {
				looping = FALSE;
				retVal = TRADERSKILL;
			}			
			lower++;
		}    
		if (Mercenary[Sh->Crew[0]].Engineer == i) {
			if (lower == n) {
				looping = FALSE;
				retVal = ENGINEERSKILL;
			}			
			lower++;
		}
		i++;
	}
	return retVal;
}

#pragma mark SystemNews
-(void) addNewsEvent:(int) eventFlag {
	if (newsSpecialEventCount < MAXSPECIALNEWSEVENTS - 1) {
		NewsEvents[newsSpecialEventCount++] = eventFlag;
	}
}

-(void) replaceNewsEvent:(int)originalEventFlag replacementEventFlag:(int)replacementEventFlag {
	int i;
	
	if (originalEventFlag == -1) {
		[self addNewsEvent:replacementEventFlag];
	} else {
		for (i=0;i<newsSpecialEventCount; i++) {
			if (NewsEvents[i] == originalEventFlag)
				NewsEvents[i] = replacementEventFlag;
		}
	}
}

-(void) resetNewsEvents {
	newsSpecialEventCount = 0;
}

-(int) latestNewsEvent {
	if (newsSpecialEventCount == 0) {
		return -1;    
	}
	
	return NewsEvents[newsSpecialEventCount - 1];
}

-(BOOL) isNewsEvent:(int) eventFlag {
	int i;
	for (i=0;i<newsSpecialEventCount; i++) {
		if (NewsEvents[i] == eventFlag) {
			return TRUE;
		}
	}
	return FALSE;
}

-(NSString*)getCurrentSystemStatus {
	if (CURSYSTEM.Status > 0) {
		switch (CURSYSTEM.Status) {
			case WAR:
				return @"War News: Offensives Continue!";
			case PLAGUE:
				return @"Plague Spreads! Outlook Grim.";
			case DROUGHT:
				return @"No Rain in Sight!";
			case COLD:
				return @"Cold Snap Continues!";
			case CROPFAILURE:
				return @"Serious Crop Failure! Must We Ration?";
			case LACKOFWORKERS:
				return @"Jobless Rate at All-Time Low!";
		}
	}
	return @"";
}

-(BOOL)doesNewsExist {
	if (CURSYSTEM.Special > -1) {
		if (CURSYSTEM.Special == MONSTERKILLED && monsterStatus == 2) {
			[self addNewsEvent:MONSTERKILLED];
		} else if (CURSYSTEM.Special == DRAGONFLY) {
			[self addNewsEvent:DRAGONFLY];      
		} else if (CURSYSTEM.Special == SCARAB) {
			[self addNewsEvent:SCARAB];
		} else if (CURSYSTEM.Special == SCARABDESTROYED && scarabStatus == 2) {
			[self addNewsEvent:SCARABDESTROYED];
		} else if (CURSYSTEM.Special == FLYBARATAS && dragonflyStatus == 1) {
			[self addNewsEvent:FLYBARATAS];
		} else if (CURSYSTEM.Special == FLYMELINA && dragonflyStatus == 2) {
			[self addNewsEvent:FLYMELINA];
		} else if (CURSYSTEM.Special == FLYREGULAS && dragonflyStatus == 3) {
			[self addNewsEvent:FLYREGULAS];
		} else if (CURSYSTEM.Special == DRAGONFLYDESTROYED && dragonflyStatus == 5) {
			[self addNewsEvent:DRAGONFLYDESTROYED];      
		} else if (CURSYSTEM.Special == MEDICINEDELIVERY && japoriDiseaseStatus == 1) {
			[self addNewsEvent:MEDICINEDELIVERY];
		} else if (CURSYSTEM.Special == ARTIFACTDELIVERY && artifactOnBoard) {
			[self addNewsEvent:ARTIFACTDELIVERY];
		} else if (CURSYSTEM.Special == JAPORIDISEASE && japoriDiseaseStatus == 0) {
			[self addNewsEvent:JAPORIDISEASE];
		} else if (CURSYSTEM.Special == JAREKARRIVES && jarekStatus == 1) {
			[self addNewsEvent:JAREKARRIVES];
		} else if (CURSYSTEM.Special == BROWERARRIVES && browerStatus == 1) {
			[self addNewsEvent:BROWERARRIVES];
		} else if (CURSYSTEM.Special == GEMULONRESCUED && invasionStatus > 0 && invasionStatus < 8) {
			[self addNewsEvent:GEMULONRESCUED];      
		} else if (CURSYSTEM.Special == ALIENINVASION) {
			[self addNewsEvent:ALIENINVASION];
		} else if (CURSYSTEM.Special == EXPERIMENTSTOPPED && experimentStatus > 0 && experimentStatus < 12) {
			[self addNewsEvent:EXPERIMENTSTOPPED];
		} else if (CURSYSTEM.Special == EXPERIMENTNOTSTOPPED) {
			[self addNewsEvent:EXPERIMENTNOTSTOPPED];
		}		
	}
	return TRUE;
}

#pragma mark NewsPaper
-(void)cannotAffordNews {
	[self FrmAlert:NSLocalizedString(@"CantAffordPaperAlert", @"")];
	[self showUserNotice:aAlert];
}

-(void)payForNewsPaper:(int)sum {
	if (! alreadyPaidForNewspaper) {
		sum = (gameDifficulty + 1)*3;
		credits -= sum;
		alreadyPaidForNewspaper = TRUE;
	}
}

-(NSString*)drawNewspaperForm {
	Boolean realNews = FALSE;
	NSMutableString *headLine = [[NSMutableString alloc] init];	
	RandSeed( warpSystem, days );
	
	if  ([self isNewsEvent:CAPTAINLYNNATTACKED]) {
		[headLine appendString:@"Famed Captain Lynn Attacked by Brigand!\n"];
	}
	
	if  ([self isNewsEvent:EXPERIMENTPERFORMED]){
		[headLine appendString:@"Travelers Report Timespace Damage, Warp Problems!\n"];
	}
	
	if  ([self isNewsEvent:CAPTAINLYNNDESTROYED]) {
		[headLine appendString:@"Citizens Mourn Destruction of Captain Lynn's Ship!\n"];
	}
	
	if  ([self isNewsEvent:CAPTAINADAMAATTACKED]) {
		[headLine appendString:@"Thug Assaults Captain Adama!\n"];
	}
	
	if  ([self isNewsEvent:CAPTAINADAMADESTROYED]) {
		[headLine appendString:@"Destruction of Captain Adama's Ship Causes Anger!\n"];
	}
	
	if  ([self isNewsEvent:CAPTAINBELLOWSATTACKED]) {
		[headLine appendString:@"Captain Bellows Comes Under Attack By Criminal!\n"];
	}
	
	if  ([self isNewsEvent:CAPTAINBELLOWSDESTROYED]) {
		[headLine appendString:@"Captain Bellows' Ship Destroyed by Villain!\n"];
	}
	
	if  ([self isNewsEvent:MONSTERKILLED]) {
		[headLine appendString:@"Hero Slays band of Pirates! Parade, Honors Planned for Today.\n"];
	}
	
	if  ([self isNewsEvent:BROWERARRESTED]) {
		[headLine appendString:@"Notorious Criminal Jack Brower Arrested!\n"];
	}
	
	if  (CURSYSTEM.Special == MONSTERKILLED &&  monsterStatus == 1) {
		[headLine appendString:@"Band of Pirates Threatens Homeworld!\n"];
	}
	
	if  (CURSYSTEM.Special == SCARABDESTROYED &&  scarabStatus == 1) {
		[headLine appendString:@"Wormhole Travelers Harassed by Unusual Ship!\n"];
	}
	
	if ([self isNewsEvent:EXPERIMENTSTOPPED]) {
		[headLine appendString:@"Scientists Cancel High-profile Test! Committee to Investigate Design.\n"];
	}
	
	if ([self isNewsEvent:EXPERIMENTNOTSTOPPED]) {
		[headLine appendString:@"Huge Explosion Reported at Research Facility.\n"];
	}
	
	if ([self isNewsEvent:DRAGONFLY]) {
		[headLine appendString:@"Experimental Craft Stolen! Critics Demand Security Review.\n"];
	}
	
	if ([self isNewsEvent:SCARAB]) {
		[headLine appendString:@"Security Scandal: Test Craft Confirmed Stolen.\n"];
	}
	
	if ([self isNewsEvent:FLYBARATAS]) {
		[headLine appendString:@"Investigators Report Strange Craft.\n"];
	}
	
	if ([self isNewsEvent:FLYMELINA]) {
		[headLine appendString:@"Rumors Continue: Melina Orbitted by Odd Starcraft.\n"];
	}
	
	if ([self isNewsEvent:FLYREGULAS]) {
		[headLine appendString:@"Strange Ship Observed in Rigulus Orbit.\n"];
	}
	
	if (CURSYSTEM.Special == DRAGONFLYDESTROYED && dragonflyStatus == 4 && ![self isNewsEvent:DRAGONFLYDESTROYED]) {
		[headLine appendString:@"Unidentified Ship: A Threat to Zorkon?\n"];
	}
	
	if ([self isNewsEvent:DRAGONFLYDESTROYED]) {
		[headLine appendString:@"Spectacular Display as Stolen Ship Destroyed in Fierce Space Battle.\n"];
	}
	
	if ([self isNewsEvent:SCARABDESTROYED]) {
		[headLine appendString:@"Wormhole Traffic Delayed as Stolen Craft Destroyed.\n"];
	}
	
	if ([self isNewsEvent:MEDICINEDELIVERY]) {
		[headLine appendString:@"Disease Antidotes Arrive! Health Officials Optimistic.\n"];
	}
	
	if ([self isNewsEvent:JAPORIDISEASE]) {
		[headLine appendString:@"Editorial: We Must Help Ja'pori!\n"];
	}
	
	if ([self isNewsEvent:ARTIFACTDELIVERY]) {
		[headLine appendString:@"Scientist Adds Alien Artifact to Museum Collection.\n"];
	}
	
	if ([self isNewsEvent:JAREKARRIVES]) {
		[headLine appendString:@"Ambassador Jarek Returns from Crisis.\n"];
	} 
	
	if ([self isNewsEvent:BROWERARRIVES]) {
		[headLine appendString:@"Rumors Suggest Known Criminal J. Brower May Come to Kravat!\n"];
	} 
	
	if ([self isNewsEvent:GEMULONRESCUED]) {
		[headLine appendString:@"Invasion Imminent! Plans in Place to Repel Hostile Invaders.\n"];
	}
	
	if (CURSYSTEM.Special == GEMULONRESCUED && ![self isNewsEvent:GEMULONRESCUED]) {
		[headLine appendString:@"Alien Invasion Devastates Planet!\n"];
	}
	
	if ([self isNewsEvent:ALIENINVASION]) {
		[headLine appendString:@"Editorial: Who Will Warn Gemulon?\n"];
	}
	
	if ([self isNewsEvent:ARRIVALVIASINGULARITY]) {
		[headLine appendString:@"Travelers Claim Sighting of Ship Materializing in Orbit!\n"];
	}
	
	if (CURSYSTEM.Status > 0) {
		switch (CURSYSTEM.Status) {
			case WAR:
				[headLine appendString:@"War News: Offensives Continue!\n"];
				break;
			case PLAGUE:
				[headLine appendString:@"Plague Spreads! Outlook Grim.\n"];
				break;
			case DROUGHT:
				[headLine appendString:@"No Rain in Sight!\n"];
				break;
			case BOREDOM:
				[headLine appendString:@"Editors: Won't Someone Entertain Us?\n"];
				break;
			case COLD:
				[headLine appendString:@"Cold Snap Continues!\n"];
				break;
			case CROPFAILURE:
				[headLine appendString:@"Serious Crop Failure! Must We Ration?\n"];
				break;
			case LACKOFWORKERS:
				[headLine appendString:@"Jobless Rate at All-Time Low!\n"];
				break;
		}
	}
	
	if (policeRecordScore <= VILLAINSCORE) {
		int j = GetRandom2(4);
		switch (j) {
			case 0:
				[headLine appendString:[NSString stringWithFormat:@"Police Warning: %@ Will Dock At %@!\n", pilotName, [self getSolarSystemName:CURSYSTEM.NameIndex]]];
				break;
			case 1:
				[headLine appendString:[NSString stringWithFormat:@"Notorious Criminal %@ Sighted in %@!\n", pilotName, [self getSolarSystemName:CURSYSTEM.NameIndex]]];
				break;
			case 2:
				[headLine appendString:[NSString stringWithFormat:@"Locals Rally to Deny Spaceport Access to %@!\n", pilotName]];
				break;
			case 3:
				[headLine appendString:[NSString stringWithFormat:@"Terror Strikes Locals on Arrival of %@!\n", pilotName]];
				break;
		}
	}
	
	if (policeRecordScore == HEROSCORE) {
		int j = GetRandom2(3);
		switch (j) {
			case 0:
				[headLine appendString:[NSString stringWithFormat:@"Locals Welcome Visiting Hero %@!\n", pilotName]];
				break;
			case 1:
				[headLine appendString:[NSString stringWithFormat:@"Famed Hero %@ to Visit System!\n", pilotName]];				
				
				break;
			case 2:
				[headLine appendString:[NSString stringWithFormat:@"Large Turnout At Spaceport to Welcome %@!\n", pilotName]];
				break;
		}
	}
	
	if  ([self isNewsEvent:CAUGHTLITTERING]) {
		[headLine appendString:[NSString stringWithFormat:@"Police Trace Orbiting Space Litter to %@!\n", pilotName]];		
	}
	
	for (int i=0; i < MAXSOLARSYSTEM; i++) {
		if (i != currentSystem &&
		    (([self realDistance:currentSystem b:i] <= Shiptype[ship.Type].FuelTanks)
			 ||
			 [self wormholeExists:currentSystem b:i])
		    &&
		    solarSystem[i].Status > 0)
		    
		{
			if (solarSystem[i].Special == MOONFORSALE) {
				[headLine appendString:[NSString stringWithFormat:@"Seller in %@ System has Utopian Moon available.\n", [self getSolarSystemName:i]]];				
			}
			
			if (solarSystem[i].Special == BUYTRIBBLE) {
				[headLine appendString:[NSString stringWithFormat:@"Collector in %@ System seeks to purchase Tribbles.\n", [self getSolarSystemName:i]]];						
			}
			
			if (solarSystem[i].Special == EXTRYFLEAS) {
				[headLine appendString:[NSString stringWithFormat:@"Exterminator in %@ System offers special on flea removal.\n", [self getSolarSystemName:i]]];						
			}
			
			if (GetRandom2(100) <= STORYPROBABILITY * CURSYSTEM.TechLevel + 10 * (5 - gameDifficulty)) {
				int j = GetRandom2(6);
				switch (j) {
					case 0:
						[headLine appendString:@"Reports of "];
						break; 
					case 1:
						[headLine appendString:@"News of "];
						break;
					case 2:
						[headLine appendString:@"New Rumors of "];
						break;
					case 3:
						[headLine appendString:@"Sources say "];
						break;
					case 4:
						[headLine appendString:@"Notice: "];
						break;
					case 5:
						[headLine appendString:@"Evidence Suggests "];
						break;
				}
				
				switch (solarSystem[i].Status) {
					case WAR:
						[headLine appendString:@"Strife and War"];
						break;
					case PLAGUE:
						[headLine appendString:@"Plague Outbreaks"];
						break;
					case DROUGHT:
						[headLine appendString:@"Severe Drought"];
						break;
					case BOREDOM:
						[headLine appendString:@"Terrible Boredom"];
						break;
					case COLD:
						[headLine appendString:@"Cold Weather"];
						break;
					case CROPFAILURE:
						[headLine appendString:@"Crop Failures"];
						break;
					case LACKOFWORKERS:
						[headLine appendString:@"Labor Shortages"];
						break;
				}
				[headLine appendString:[NSString stringWithFormat:@" in the %@ System.\n ", [self getSolarSystemName:i]]];
				realNews = TRUE;
			}
		}
	}
	
	if (! realNews) {
		[headLine appendString:[NSString stringWithFormat:@"No news in the %@ System.\n ", [self getSolarSystemName:currentSystem]]];
	}
	
	return [headLine autorelease];
}

#pragma mark Passengers
-(int) getNumOfPassengers {
	int a;
	a = (GetRandom(5) + 0) * 2;
	return a;
}

-(int) getPassengerPlanet {
	int i, j, d;
	i = 0;
	int levelFactor = (gameDifficulty + 1) * 4; //4-20
	while (i < MAXSOLARSYSTEM) {
		d = 1 + (GetRandom( MAXSOLARSYSTEM - 1 ));
		j = [self RealDistance:solarSystem[d] b:solarSystem[currentSystem]];
		if ((j >= (TRIPDISTANCE + levelFactor) && (j <= ((TRIPDISTANCE * 2) + levelFactor)))) {
			return d;
			break;
		}
		++i;
	}
	return GetRandom(MAXSOLARSYSTEM -1);
}

-(BOOL)okayToTransportPassengers {
	if ((days > 10) && (credits >= 5000) && (policeRecordScore >= DUBIOUSSCORE)) {
		return TRUE;
	}
	return FALSE;
}

-(void) playTransportAnnouncement {
	if (speechAlertsOn) {
		NSString *filePath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:[NSString stringWithFormat:@"Systems/System%i.caf", passengersDestination]];
		NSURL *url = [NSURL fileURLWithPath:filePath];
		nameSoundIsDone = FALSE;
		AudioServicesCreateSystemSoundID ((CFURLRef)url, &planetNameSoundID);
		[[SoundManager sharedSound] playSoundWithId:kTransportTo];
		[self performSelector:@selector(playThePlanetSoundFile) withObject:self afterDelay:1.40];
		[self performSelector:@selector(planetNameSoundIsDone) withObject:self afterDelay:1.7];		
	}	
}

-(int)calculateTravelFee {
	
	return ((((MAXDIFFICULTY - gameDifficulty) * TRANSPORTFEE) + TRANSPORTFEE) * numberOfPassengers);
	
}

-(void)showPassengers {
	NSString *title = [NSString stringWithFormat:@"Ferry Passengers"];
	if(passengersDestination == -1) {
		passengersDestination = [self getPassengerPlanet];		
	}
	AlertModalWindow *myAlertView;
	if (numberOfPassengers == 0) {
		myAlertView = [[UIAlertView alloc] initWithTitle:title message:@"At this time, there are no passengers to transport. Please check again on your next visit." delegate:self cancelButtonTitle:nil otherButtonTitles:@"Dismiss",nil];	
		[self showUserNotice:aNotice];
	}	
	else if ((ship.Shield[0] < 0)) {
		myAlertView = [[UIAlertView alloc] initWithTitle:title message:@"According to GPTA rules, your ship must have a shield installed to transport passengers." delegate:self cancelButtonTitle:nil otherButtonTitles:@"Dismiss",nil];	
		[self showUserNotice:aAlert];
	}
	else {
		int travelDistance = [self RealDistance:solarSystem[passengersDestination] b:solarSystem[currentSystem]];
		NSString *text = [NSString stringWithFormat:@"Will you transport %i passengers\nto %@ (%i parsecs away)\nfor a fee of %i credits?\n(All GPTA rules apply)", numberOfPassengers, [self getSolarSystemName:passengersDestination], travelDistance, [self calculateTravelFee]];
		myAlertView = [[UIAlertView alloc] initWithTitle:title  message:text delegate:self cancelButtonTitle:@"No" otherButtonTitles:@"Yes",nil];	
		[self playTransportAnnouncement];
	}	
	bLastMessage = FALSE;
	[myAlertView show];
	[myAlertView release];		
	currentState = ePickupPassengers;
}

-(BOOL) shipIsInfected {
	
	if ((ship.Tribbles > 0) || (ship.RygellianFleas > 0)) {
		return TRUE;
	}
	return FALSE;
}

-(void) passengersUsePEP {
	if(transportPassengers) {
		if(!didUsePEP) {
			[self FrmAlert:NSLocalizedString(@"PassengersUsedPEP", @"")];
			[self playSpeechFile:@"PassengersAutoEject.caf"];
			if (credits > (int)(numberOfPassengers * RESCUEFEE))
				credits -= (int)(numberOfPassengers * RESCUEFEE);
			else {
				debt += ((int)(numberOfPassengers * RESCUEFEE) - credits);
				credits = 0;
			}
			transportRatingTotal = 0;
			totalPEPPassengers += numberOfPassengers;
			passengersDestination = -1;
			transportPassengers = FALSE;
			numberOfPassengers = 0;
			trackedSystem = -1;
			didUsePEP = TRUE;
		}
	}
}

#pragma mark SpecialEvents
-(void)showSpecialEvent {
	NSString *title = [NSString stringWithFormat:@"%s", SpecialEvent[CURSYSTEM.Special].Title];
	NSString *text = NSLocalizedString(([NSString stringWithFormat:@"%s", SpecialEvent[CURSYSTEM.Special].QuestStringID]), @"");
	
	AlertModalWindow *myAlertView;
	if (SpecialEvent[CURSYSTEM.Special].JustAMessage) {
		myAlertView = [[UIAlertView alloc] initWithTitle:title message:text delegate:self cancelButtonTitle:nil otherButtonTitles:@"Dismiss",nil];	
	} else {
		myAlertView = [[UIAlertView alloc] initWithTitle:title  message:text delegate:self cancelButtonTitle:@"No" otherButtonTitles:@"Yes",nil];	
	}	
	bLastMessage = FALSE;
	[myAlertView show];
	[myAlertView release];		
	currentState = eSpecialEvent;
}

-(BOOL)doesSpecialExist {
	int OpenQ = [self OpenQuests];
	if (currentSystem == ACAMARSYSTEM && CURSYSTEM.Special == 0)
		return FALSE;
	
	if  ((CURSYSTEM.Special < 0) || 
		 (CURSYSTEM.Special == BUYTRIBBLE && ship.Tribbles <= 0) ||
		 (CURSYSTEM.Special == EXTRYFLEAS && ship.RygellianFleas <= 0) ||
		 (CURSYSTEM.Special == ERASERECORD && policeRecordScore >= DUBIOUSSCORE) ||
		 (CURSYSTEM.Special == CARGOFORSALE && ([self filledCargoBays] > [self totalCargoBays] - 3)) ||
		 ((CURSYSTEM.Special == DRAGONFLY || CURSYSTEM.Special == JAPORIDISEASE ||
		   CURSYSTEM.Special == ALIENARTIFACT || CURSYSTEM.Special == AMBASSADORJAREK ||
		   CURSYSTEM.Special == EXPERIMENT) && (policeRecordScore <= DUBIOUSSCORE)) ||
		 (CURSYSTEM.Special == TRANSPORTBROWER && (policeRecordScore >= DUBIOUSSCORE)) ||
		 (CURSYSTEM.Special == GETREACTOR && (policeRecordScore >= DUBIOUSSCORE || reputationScore <= AVERAGESCORE || reactorStatus != 0)) ||
		 (CURSYSTEM.Special == REACTORDELIVERED && !(reactorStatus > 0 && reactorStatus < 21)) ||
		 (CURSYSTEM.Special == MONSTERKILLED && monsterStatus < 2) ||
		 (CURSYSTEM.Special == EXPERIMENTSTOPPED && !(experimentStatus >= 1 && experimentStatus < 12)) ||
		 (CURSYSTEM.Special == FLYBARATAS && dragonflyStatus < 1) ||
		 (CURSYSTEM.Special == FLYMELINA && dragonflyStatus < 2) ||
		 (CURSYSTEM.Special == FLYREGULAS && dragonflyStatus < 3) ||
		 (CURSYSTEM.Special == DRAGONFLYDESTROYED && dragonflyStatus < 5) ||
		 (CURSYSTEM.Special == SCARAB && (reputationScore < AVERAGESCORE || scarabStatus != 0)) ||
		 (CURSYSTEM.Special == SCARABDESTROYED && scarabStatus != 2) ||
		 (CURSYSTEM.Special == GETHULLUPGRADED && scarabStatus != 2) ||
		 (CURSYSTEM.Special == MEDICINEDELIVERY && japoriDiseaseStatus != 1) ||
		 (CURSYSTEM.Special == JAPORIDISEASE && (japoriDiseaseStatus != 0)) ||
		 (CURSYSTEM.Special == ARTIFACTDELIVERY && !artifactOnBoard) ||
		 (CURSYSTEM.Special == JAREKARRIVES && jarekStatus != 1) ||
		 (CURSYSTEM.Special == BROWERARRIVES && browerStatus != 1) ||
		 (CURSYSTEM.Special == GEMULONRESCUED && !(invasionStatus >= 1 && invasionStatus <= 7)) ||
		 (CURSYSTEM.Special == MOONFORSALE && (moonBought || [self currentNetWorth] < (COSTMOON * 4) / 5)) ||
		 (CURSYSTEM.Special == MOONBOUGHT && moonBought != TRUE)) 
		return FALSE;
	else if  (OpenQ > 3 &&
			  (CURSYSTEM.Special == TRIBBLE ||
			   CURSYSTEM.Special == RYFLEAS ||
			   CURSYSTEM.Special == SPACEMONSTER ||
			   CURSYSTEM.Special == DRAGONFLY ||
			   CURSYSTEM.Special == JAPORIDISEASE ||
			   CURSYSTEM.Special == ALIENARTIFACT ||
			   CURSYSTEM.Special == AMBASSADORJAREK ||
			   CURSYSTEM.Special == ALIENINVASION ||
			   CURSYSTEM.Special == EXPERIMENT ||
			   CURSYSTEM.Special == TRANSPORTBROWER ||
			   CURSYSTEM.Special == GETREACTOR ||
			   CURSYSTEM.Special == SCARAB)) 
		return FALSE;
	else
		return TRUE;
}

-(void) specialEventFormHandleEvent {
	Boolean handled = FALSE;
	int i, FirstEmptySlot;
	if ([self toSpend] < SpecialEvent[CURSYSTEM.Special].Price) {
		[self FrmAlert:NSLocalizedString(@"NotEnoughForEventAlert", @"")];
		[self playSpeechFile:@"NotEnoughCredits.caf"];
		[systemInfoController updateInfoView];
		return;
	}
	credits -= SpecialEvent[CURSYSTEM.Special].Price;
	switch (CURSYSTEM.Special) {			
		case GETREACTOR:
			currentState = eUpdateSpecial;
			if ([self filledCargoBays] > [self totalCargoBays] - 15) {
				[self FrmAlert:NSLocalizedString(@"NotEnoughBaysAlert", @"")];
				handled = TRUE;
				break;
			} else if (browerStatus == 1) {
				browerStatus = 0;
				[self FrmAlert:NSLocalizedString(@"BrowerLeavesShipAlert", @"")];				
			}
			[self FrmAlert:NSLocalizedString(@"ReactorAlert", @"")];
			reactorStatus = 1;
			break;
			
		case REACTORDELIVERED:
			CURSYSTEM.Special = GETSPECIALLASER;
			reactorStatus = 21;
			handled = TRUE;
			currentState = eUpdateSpecial;			
			break;	
			
		case MONSTERKILLED:
			if (monsterStatus == 2) {
				CURSYSTEM.Special = 0;
				monsterStatus = 0;
			}
			return;
			break;
			
		case SCARAB:
			scarabStatus = 1;
			break;
			
		case SCARABDESTROYED:
			scarabStatus = 2;
			CURSYSTEM.Special = GETHULLUPGRADED;
			handled = TRUE;
			break;	
			
		case GETHULLUPGRADED:
			[self FrmAlert:NSLocalizedString(@"HullUpgradeAlert", @"")];
			currentState = eUpdateSpecial;			
			ship.Hull += UPGRADEDHULL;
			scarabStatus = 3;
			handled = TRUE;
			break;	
			
		case EXPERIMENT:
			experimentStatus = 1;
			break;
			
		case EXPERIMENTSTOPPED:
			experimentStatus = 13;
			canSuperWarp = TRUE;
			break;
			
		case EXPERIMENTNOTSTOPPED:
			break;
			
		case ARTIFACTDELIVERY:
			artifactOnBoard = FALSE;
			break;
			
		case ALIENARTIFACT:
			artifactOnBoard = TRUE;
			break;
			
		case FLYBARATAS:
			++dragonflyStatus;
			break;
			
		case FLYMELINA:
			++dragonflyStatus;
			break;
			
		case FLYREGULAS:
			++dragonflyStatus;
			break;
			
		case DRAGONFLYDESTROYED:
			solarSystem[ZORKONSYSTEM].Special = INSTALLQUANTUMSHIELD;
			handled = TRUE;
			break;
			
		case GEMULONRESCUED:
			solarSystem[GEMULONSYSTEM].Special = GETFUELCOMPACTOR;
			invasionStatus = 0;
			handled = TRUE;
			break;
			
		case MEDICINEDELIVERY:
			japoriDiseaseStatus = 2;
			[self IncreaseRandomSkill];
			[self IncreaseRandomSkill];
			break;
			
		case MOONFORSALE:
			[self FrmAlert:NSLocalizedString(@"BoughtMoonAlert", @"")];
			currentState = eUpdateSpecial;			
			moonBought = TRUE;
			break;
			
		case MOONBOUGHT:
			[self showUtopiaWindow];
			return ;
			break;
			
		case SKILLINCREASE:
			[self FrmAlert:NSLocalizedString(@"SkillIncreaseAlert", @"")];
			currentState = eUpdateSpecial;			
			[self IncreaseRandomSkill];
			break;
			
		case TRIBBLE:
			[self FrmAlert:NSLocalizedString(@"YouHaveATribbleAlert", @"")];	
			currentState = eUpdateSpecial;			
			ship.Tribbles = 1;
			break;
			
		case BUYTRIBBLE:
			[self FrmAlert:NSLocalizedString(@"BeamOverTribblesAlert", @"")];
			currentState = eUpdateSpecial;			
			credits += (ship.Tribbles >> 1);
			ship.Tribbles = 0;
			break;
			
		case RYFLEAS:
			[self FrmAlert:NSLocalizedString(@"YouHaveRyFleasAlert", @"")];	
			[self showUserNotice:aAlert];
			currentState = eUpdateSpecial;
			ship.RygellianFleas = 10;
			break;
			
		case EXTRYFLEAS:
			[self FrmAlert:NSLocalizedString(@"ExterminatedRyFleasAlert", @"")];
			currentState = eUpdateSpecial;			
			ship.RygellianFleas = 0;
			break;
			
		case ERASERECORD:
			[self FrmAlert:NSLocalizedString(@"CleanRecordAlert", @"")];
			currentState = eUpdateSpecial;			
			policeRecordScore = CLEANSCORE;
			[self RecalculateSellPrices];
			break;
			
		case SPACEMONSTER:
			monsterStatus = 1;
			for (i=0; i<MAXSOLARSYSTEM; ++i)
				if (solarSystem[i].Special == SPACEMONSTER)
					solarSystem[i].Special = -1;
			break;
			
		case DRAGONFLY:
			dragonflyStatus = 1;
			for (i=0; i<MAXSOLARSYSTEM; ++i)
				if (solarSystem[i].Special == DRAGONFLY)
					solarSystem[i].Special = -1;
			break;
			
		case AMBASSADORJAREK:
			if (ship.Crew[Shiptype[ship.Type].CrewQuarters-1] >= 0) {
				[self FrmAlert:NSLocalizedString(@"NoQuartersAvailableAlert", @"")];
				currentState = eUpdateSpecial;				
				[self showUserNotice:aAlert];
				handled = TRUE;
				break;
			}
			[self FrmAlert:NSLocalizedString(@"PassengerTakenOnBoardAlert", @"")];
			currentState = eUpdateSpecial;
			jarekStatus = 1;
			break;
			
		case TRANSPORTBROWER:
			if (ship.Crew[Shiptype[ship.Type].CrewQuarters-1] >= 0) {
				[self FrmAlert:NSLocalizedString(@"NoQuartersAvailableAlert", @"")];
				currentState = eUpdateSpecial;
				[self showUserNotice:aAlert];
				handled = TRUE;
				break;
			}
			if (![self HasWeapon:&ship Cg:BEAMLASERWEAPON exactCompare:FALSE]) {
				[self FrmAlert:NSLocalizedString(@"BrowerWontGetAboardAlert", @"")];
				[self showUserNotice:aAlert];
				currentState = eUpdateSpecial;
				handled = TRUE;
				break;
			}
			if (reactorStatus > 0 && reactorStatus < 21) {
				[self FrmAlert:NSLocalizedString(@"BrowerAfraidOfReactorAlert", @"")];
				[self showUserNotice:aAlert];
				currentState = eUpdateSpecial;
				handled = TRUE;
				break;
			}
			[self FrmAlert:NSLocalizedString(@"PassengerTakenOnBoardAlert", @"")];
			currentState = eUpdateSpecial;
			browerStatus = 1;
			break;
			
		case ALIENINVASION:
			invasionStatus = 1;
			break;
			
		case JAREKARRIVES:
			jarekStatus = 2;
			[self RecalculateBuyPrices:currentSystem];
			break;
			
		case BROWERARRIVES:
			browerStatus = 2;
			Mercenary[MAXCREWMEMBER-1].CurSystem = KRAVATSYSTEM;
			
			Mercenary[MAXCREWMEMBER-1].Pilot = 5;
			Mercenary[MAXCREWMEMBER-1].Fighter = 5;
			Mercenary[MAXCREWMEMBER-1].Trader = 5;
			Mercenary[MAXCREWMEMBER-1].Engineer = 5;
			switch ([self NthLowestSkill:&ship n:1])
		{
			case PILOTSKILL:
				Mercenary[MAXCREWMEMBER-1].Pilot = 10;
				break;
			case FIGHTERSKILL:
				Mercenary[MAXCREWMEMBER-1].Fighter = 10;
				break;
			case TRADERSKILL:
				Mercenary[MAXCREWMEMBER-1].Trader = 10;
				break;
			case ENGINEERSKILL:
				Mercenary[MAXCREWMEMBER-1].Engineer = 10;
				break;
		}
			switch ([self NthLowestSkill:&ship n:2])
		{
			case PILOTSKILL:
				Mercenary[MAXCREWMEMBER-1].Pilot = 8;
				break;
			case FIGHTERSKILL:
				Mercenary[MAXCREWMEMBER-1].Fighter = 8;
				break;
			case TRADERSKILL:
				Mercenary[MAXCREWMEMBER-1].Trader = 8;
				break;
			case ENGINEERSKILL:
				Mercenary[MAXCREWMEMBER-1].Engineer = 8;
				break;
		}			
			if (policeRecordScore < CLEANSCORE)
				policeRecordScore = CLEANSCORE;
			break;
			
		case CARGOFORSALE:
			[self FrmAlert:NSLocalizedString(@"SealedCanistersAlert", @"")];
			currentState = eUpdateSpecial;
			i = GetRandom( MAXTRADEITEM );
			ship.Cargo[i] += 3;
			BuyingPrice[i] += SpecialEvent[CURSYSTEM.Special].Price;
			break;
			
		case INSTALLQUANTUMSHIELD:
			NSLog(@"installlingshield");
			FirstEmptySlot = [self getFirstEmptySlot:Shiptype[ship.Type].ShieldSlots Item:ship.Shield];
			currentState = eUpdateSpecial;
			if (FirstEmptySlot < 0) {
				[self FrmAlert:NSLocalizedString(@"NotEnoughSlotsAlert", @"")];
				handled = TRUE;
			} else {
				[self FrmAlert:NSLocalizedString(@"QuantumShieldAlert", @"")];
				ship.Shield[FirstEmptySlot] = QUANTUMSHIELD;
				ship.ShieldStrength[FirstEmptySlot] = Shieldtype[QUANTUMSHIELD].Power;
			}
			break;
			
		case GETSPECIALLASER:
			FirstEmptySlot =[self  getFirstEmptySlot:Shiptype[ship.Type].WeaponSlots Item:ship.Weapon ];
			if (FirstEmptySlot < 0) {
				[self FrmAlert:NSLocalizedString(@"NotEnoughSlotsAlert", @"")];
				handled = TRUE;
			} else {
				[self FrmAlert:NSLocalizedString(@"TalbotLaserAlert", @"")];
				ship.Weapon[FirstEmptySlot] = TALBOTLASERWEAPON;
			}
			currentState = eUpdateSpecial;
			break;
			
		case GETFUELCOMPACTOR:
			currentState = eUpdateSpecial;
			FirstEmptySlot = [self getFirstEmptySlot:Shiptype[ship.Type].GadgetSlots Item:ship.Gadget];
			if (FirstEmptySlot < 0) {
				[self FrmAlert:NSLocalizedString(@"NotEnoughSlotsAlert", @"")];
				handled = TRUE;
			} else {
				[self FrmAlert:NSLocalizedString(@"FuelCompactorAlert", @"")];
				ship.Gadget[FirstEmptySlot] = FUELCOMPACTOR;
				ship.Fuel = [self getFuelTanks];
			}
			break;
			
		case JAPORIDISEASE:
			currentState = eUpdateSpecial;
			if ([self filledCargoBays] > [self totalCargoBays] - 10) {
				[self FrmAlert:NSLocalizedString(@"NotEnoughBaysAlert", @"")];
				handled = TRUE;
			} else {
				[self FrmAlert:NSLocalizedString(@"AntidoteAlert", @"")];
				japoriDiseaseStatus = 1;
			}
			break;
	}
	
	if (!handled) {
		CURSYSTEM.Special = -1;
	}
	
	[systemInfoController updateInfoView];	
}

#pragma mark Pirate Upgrades
-(BOOL) canUpgradeHull {
	if (ship.PirateHullUpgrade > 0) {
		return FALSE;
	}
	return TRUE;	
}
-(void) pirateUpgradeHull:(int)amount cost:(int)fee {
	if ([self toSpend] < fee) {
		[self FrmAlert:NSLocalizedString(@"NotEnoughForEventAlert", @"")];
		[self playSpeechFile:@"NotEnoughCredits.caf"];
		return;
	}
	credits -= fee;
	ship.Hull += amount;
	[self FrmAlert:NSLocalizedString(@"PirateUpgradeInstalled", @"")];	
	[self playSpeechFile:@"PirateUpgradeInstalled.caf"];
	ship.PirateHullUpgrade += amount;
}

-(BOOL) maxShieldUpgradePrice {
	if (ship.Shield[0] >= 1) {
		return TRUE;
	}
	return FALSE;
}

-(BOOL) canUpgradeShield {
	if ((ship.Shield[0] >= 0) && (ship.Shield[0] < 2)) {
		return TRUE;
	}
	return FALSE;	
}
-(void) pirateUpgradeShield:(int)amount cost:(int)fee {
	if ([self toSpend] < fee) {
		[self FrmAlert:NSLocalizedString(@"NotEnoughForEventAlert", @"")];
		[self playSpeechFile:@"NotEnoughCredits.caf"];
		return;
	}
	if (ship.Shield[0] == -1) {
		[self FrmAlert:NSLocalizedString(@"NoShieldToUpgrade", @"")];
		[self showUserNotice:aAlert];
		return;
	}
	if (ship.Shield[0] > 1) {
		[self FrmAlert:NSLocalizedString(@"CantUpgradeQuantum", @"")];
		[self showUserNotice:aAlert];
		return;
	}	
	ship.Shield[0] = ship.Shield[0]+2;
	[self FrmAlert:NSLocalizedString(@"PirateUpgradeInstalled", @"")];	
	[self playSpeechFile:@"PirateUpgradeInstalled.caf"];
	credits -= fee;	
}

-(BOOL) maxWeaponUpgradePrice {
	if (ship.Weapon[0] >= 2) {
		return TRUE;
	}
	return FALSE;
}

-(BOOL) canUpgradeWeapon {
	if ((ship.Weapon[0] >= 0) && (ship.Weapon[0] < 3)) {
		return TRUE;
	}
	return FALSE;	
}

-(void) pirateUpgradeWeapon:(int)amount cost:(int)fee {
	if ([self toSpend] < fee) {
		[self FrmAlert:NSLocalizedString(@"NotEnoughForEventAlert", @"")];
		[self playSpeechFile:@"NotEnoughCredits.caf"];
		return;
	}
	if ([self TotalWeapons:&ship minWeapon:-1 maxWeapon:-1] <= 0) {
		[self FrmAlert:NSLocalizedString(@"NoWeaponToUpgrade", @"")];
		[self showUserNotice:aAlert];
		return;
	}
	if (ship.Weapon[0] > 2) {
		[self FrmAlert:NSLocalizedString(@"CantUpgradeTalbot", @"")];
		[self showUserNotice:aAlert];
		return;
	}
	[self FrmAlert:NSLocalizedString(@"PirateUpgradeInstalled", @"")];	
	[self playSpeechFile:@"PirateUpgradeInstalled.caf"];
	ship.Weapon[0] = ship.Weapon[0]+3;
	credits -= fee;	
}

#pragma mark --------
#pragma mark GameData
typedef struct 
	{
		long CurrentSystem;
		long Credits;
		long Deposit;
		long Debt;
		int Days;
		int WarpSystem;
		int SelectedShipType;
		long BuyPrice[MAXTRADEITEM];
		long SellPrice[MAXTRADEITEM];
		long ShipPrice[MAXSHIPTYPE];
		int GalacticChartSystem;
		long PoliceKills;
		long TraderKills;
		long PirateKills;
		long PoliceRecordScore;
		long ReputationScore;
		long TransporterScore;
		long TotalPassengers;
		long TotalPEPPassengers;
		long TransportRatingTotal;
		Boolean AutoFuel;
		Boolean AutoRepair;
		Boolean Clicks;
		int EncounterType;
		Boolean Raided;
		Byte MonsterStatus;
		Byte DragonflyStatus;
		Byte JaporiDiseaseStatus;
		Boolean MoonBought;
		long MonsterHull;
		char NameCommander[NAMELEN+1];
		char LogCommander[LOGLEN+1];
		int CurForm;
		SHIP Ship;
		SHIP Opponent;
		CREWMEMBER Mercenary[MAXCREWMEMBER+1];
		SOLARSYSTEMSAVE SolarSystem[MAXSOLARSYSTEM];
		Boolean EscapePod;
		Boolean Insurance;
		int NoClaim;
		Boolean Inspected;
		Boolean AlwaysIgnoreTraders;
		Byte Wormhole[MAXWORMHOLE];
		Byte Difficulty;
		Byte VersionMajor;
		Byte VersionMinor;
		Byte PilotSkill;
		Byte FighterSkill;
		Byte TraderSkill;
		Byte EngineerSkill;
		long BuyingPrice[MAXTRADEITEM];
		Boolean ArtifactOnBoard;
		Boolean ReserveMoney;
		Boolean PriceDifferences;
		int LeaveEmpty;
		Boolean TribbleMessage;
		Boolean RygellianFleasMessage;
		Boolean AlwaysIgnorePolice;
		Boolean AlwaysIgnorePirates;
		Boolean AgreedToGPTA;
		Boolean TextualEncounters;
		Byte JarekStatus;
		Byte InvasionStatus;
		Byte ExperimentStatus;
		Byte BrowerStatus;
		Byte FabricRipProbability;
		Byte VeryRareEncounter;
		Byte ReactorStatus;
		int TrackedSystem;
		Byte ScarabStatus;
		Boolean AlwaysIgnoreTradeInOrbit;
		Boolean AlreadyPaidForNewspaper;
		Boolean AlreadyLoggedNews;
		Boolean GameLoaded;
		Boolean LitterWarning;
		Boolean NewsAutoPay;
		Boolean ShowTrackedRange;
		Boolean JustLootedMary;
		Boolean ArrivedViaWormhole;
		Boolean TrackAutoOff;
		Boolean RemindLoans;
		Boolean CanSuperWarp;
		Boolean ShouldAutoFlee;
		Boolean ShouldAutoAttack;
		Boolean TransportPassengers;
		int PassengersDestination;
		Byte ForFutureUse[MAXFORFUTUREUSE];
	} SAVEGAMETYPE;

#pragma mark LoadOptions
-(void)LoadBinaryOptions:(NSString *)name {
	
	NSArray *filePaths =	NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES); 
	NSString *recordingDirectory = [filePaths objectAtIndex: 0];	
	NSString *fileName = [NSString stringWithFormat:@"%@/%@.opt", recordingDirectory, name];
	NSData *data;
	data =[[NSData alloc] initWithContentsOfFile:fileName];
	
	memcpy(&options, [data bytes], [data length]);
	[data release];	
}

#pragma mark SaveOptions
-(void)SaveOptions:(NSString*)name {
	NSData *data;
	NSArray *filePaths = NSSearchPathForDirectoriesInDomains (NSDocumentDirectory, NSUserDomainMask, YES); 
	NSString *recordingDirectory = [filePaths objectAtIndex: 0];
	NSString *fileName = [NSString stringWithFormat:@"%@/%@.opt", recordingDirectory, name];
	data = [[NSData alloc] initWithBytes:&options length:(NSUInteger)sizeof(options) ];
	[data writeToFile:fileName atomically:FALSE];	
	[data release];
	
}

-(void)LoadBinaryHighScore:(NSString*)name data:(HIGHSCORE *)sg {
	NSArray *filePaths = NSSearchPathForDirectoriesInDomains (NSDocumentDirectory, NSUserDomainMask, YES); 
	NSString *recordingDirectory = [filePaths objectAtIndex: 0];
	NSString *fileName = [NSString stringWithFormat:@"%@/%@.hscr", recordingDirectory, name];
	NSData* data;
	data =[[NSData alloc] initWithContentsOfFile:fileName];
	
	memcpy(sg, [data bytes], [data length]);
	[data release];
}

#pragma mark Erase AutoSave
-(void)eraseAutoSave {
	NSArray *filePaths = NSSearchPathForDirectoriesInDomains (NSDocumentDirectory, NSUserDomainMask,YES); 
	NSString *recordingDirectory = [filePaths objectAtIndex: 0];
	NSString *fileName = [NSString stringWithFormat:@"%@/AutoSave.save", recordingDirectory];	
	NSFileManager *fileManager = [NSFileManager defaultManager];	
	[fileManager removeItemAtPath:fileName error:NULL];
}

-(void)eraseSaveFile: (NSString *)fileToBeRemoved {
	NSArray *filePaths = NSSearchPathForDirectoriesInDomains (NSDocumentDirectory, NSUserDomainMask,YES); 
	NSString *recordingDirectory = [filePaths objectAtIndex: 0];
	NSLog(@"Removing: %@/%@.save",recordingDirectory, fileToBeRemoved);
	NSString *fileName = [NSString stringWithFormat:@"%@/%@.save", recordingDirectory, fileToBeRemoved];	
	NSFileManager *fileManager = [NSFileManager defaultManager];	
	[fileManager removeItemAtPath:fileName error:NULL];
}

-(void)SaveHighScore:(NSString *)name {
	NSData* data;
	NSArray *filePaths = NSSearchPathForDirectoriesInDomains (NSDocumentDirectory, NSUserDomainMask, YES); 
	NSString *recordingDirectory = [filePaths objectAtIndex: 0];
	NSString *fileName = [NSString stringWithFormat:@"%@/%@.hscr", recordingDirectory, name];
	data = [[NSData alloc] initWithBytes:&Hscores length:(NSUInteger)sizeof(Hscores)];
	[data writeToFile:fileName atomically:FALSE];	
	[data release];	
}

-(void)appendPilotLog: (NSString *)text {	
	if (! alreadyLoggedNews) {
		pilotLog = [NSString stringWithFormat:@"---\n%@ System News\n%@%@", [self getCurrentSystemName], text, pilotLog];
		if([pilotLog length] > 750)
			pilotLog = [pilotLog substringToIndex:750]; 
		[pilotLog retain];
		alreadyLoggedNews = TRUE;
	}
}
	
#pragma mark saveTheGame
-(void)saveTheGame:(NSString*)name {
	
	NSData *data;
	NSArray *filePaths = NSSearchPathForDirectoriesInDomains (NSDocumentDirectory, NSUserDomainMask, YES); 
	NSString *recordingDirectory = [filePaths objectAtIndex: 0];
	NSString *fileName = [NSString stringWithFormat:@"%@/%@.save", recordingDirectory, name];
	SAVEGAMETYPE saveGame, *sg = &saveGame;
	
	int i;
	sg->PilotSkill = pilotSkill;
	sg->FighterSkill = fighterSkill;
	sg->TraderSkill = traderSkill;
	sg->EngineerSkill = engineerSkill;
	
	sg->CurrentSystem = currentSystem;	
	sg->Credits = credits;
	sg->Debt = debt;
	sg->Deposit = gesdb;
	sg->Days = days;
	sg->WarpSystem = warpSystem;

	for (i=0; i<MAXTRADEITEM; ++i) {
		sg->BuyPrice[i] = BuyPrice[i];
		sg->SellPrice[i] = SellPrice[i];
	}
  
	for (i=0; i<MAXSHIPTYPE; ++i) {
		sg->ShipPrice[i] = ShipPrice[i];
	}

	sg->GalacticChartSystem = galacticChartSystem;
	sg->PoliceKills = policeKills;
	sg->TraderKills = traderKills;
	sg->PirateKills = pirateKills;
	sg->PoliceRecordScore = policeRecordScore;
	sg->ReputationScore = reputationScore;
	sg->TransporterScore = 0;
	sg->TotalPassengers = totalPassengers;
	sg->TotalPEPPassengers = totalPEPPassengers;
	sg->TransportRatingTotal = 0;
	sg->AutoFuel = autoFuel;
	sg->AutoRepair = autoRepair;
	sg->Clicks = clicks;
	sg->EncounterType = encounterType;
	sg->Raided = raided;
	sg->MonsterStatus = monsterStatus;
	sg->DragonflyStatus = dragonflyStatus;
	sg->JaporiDiseaseStatus = japoriDiseaseStatus;
	sg->MoonBought = moonBought;
	sg->MonsterHull = monsterHull;
	[pilotName getCString:sg->NameCommander maxLength:(NAMELEN+1) encoding:NSUTF8StringEncoding];
	[pilotLog getCString:sg->LogCommander maxLength:(LOGLEN+1) encoding:NSUTF8StringEncoding];	
	memmove( &(sg->Ship), &ship, sizeof( sg->Ship ) );
	memmove( &(sg->Opponent), &Opponent, sizeof( sg->Opponent ) );

	for (i=0; i<MAXCREWMEMBER+1; ++i) {
		memmove( &(sg->Mercenary[i]), &Mercenary[i], sizeof( sg->Mercenary[i] ) );
	}

	for (i=0; i<MAXSOLARSYSTEM; ++i) {
		memmove( &(sg->SolarSystem[i]), &solarSystem[i], sizeof( sg->SolarSystem[i] ) );
	}

	for (i=0; i<MAXFORFUTUREUSE; ++i) {
		sg->ForFutureUse[i] = 0;
	}

	sg->EscapePod = escapePod;
	sg->Insurance = insurance;
	sg->NoClaim = noClaim;
	sg->Inspected = inspected;
	sg->LitterWarning = litterWarning;
	sg->AlwaysIgnoreTraders = alwaysIgnoreTraders;
	sg->AlwaysIgnorePolice = alwaysIgnorePolice;
	sg->AlwaysIgnorePirates = alwaysIgnorePirates;
	sg->Difficulty = gameDifficulty;
	sg->VersionMajor = 1;
	sg->VersionMinor = 0;

	for (i=0; i<MAXWORMHOLE; ++i) {
		sg->Wormhole[i] = Wormhole[i];
	}

	for (i=0; i<MAXTRADEITEM; ++i) {
		sg->BuyingPrice[i] = BuyingPrice[i];    
	}  
	sg->ArtifactOnBoard = artifactOnBoard;
	sg->ReserveMoney = reserveMoney;
	sg->TribbleMessage = tribbleMessage;
	sg->RygellianFleasMessage = rygellianFleasMessage;
	sg->LeaveEmpty = leaveEmpty;
	sg->TextualEncounters = textualEncounters;
	sg->JarekStatus = jarekStatus;
	sg->InvasionStatus = invasionStatus;
	sg->ExperimentStatus =experimentStatus;
	sg->BrowerStatus = browerStatus;
	sg->FabricRipProbability = fabricRipProbability;
	sg->VeryRareEncounter = veryRareEncounter;
	sg->NewsAutoPay = newsAutoPay;
	sg->AgreedToGPTA = agreedToGPTA;
	sg->ShowTrackedRange = showTrackedRange;
	sg->JustLootedMary = justLootedMary;
	sg->ArrivedViaWormhole = arrivedViaWormhole;
	sg->TrackAutoOff = trackAutoOff;
	sg->RemindLoans = remindLoans;
	sg->CanSuperWarp = canSuperWarp;
	sg->ReactorStatus = reactorStatus;
	sg->TrackedSystem = trackedSystem;
	sg->ScarabStatus = scarabStatus;
 	sg->AlwaysIgnoreTradeInOrbit = alwaysIgnoreTradeInOrbit;
	sg->AlreadyPaidForNewspaper = alreadyPaidForNewspaper;
	sg->AlreadyLoggedNews = alreadyLoggedNews;
	sg->GameLoaded = gameLoaded;
	sg->ShouldAutoAttack = shouldAutoAttack;
	sg->ShouldAutoFlee = shouldAutoFlee;
	sg->TransportPassengers = transportPassengers;
	sg->PassengersDestination = passengersDestination;
	
	data = [[NSData alloc] initWithBytes:&saveGame length:(NSUInteger)sizeof(saveGame)];
	[data writeToFile:fileName atomically:FALSE];
	[data release];	
}

- (NSString*) convertDateLocaleString:(NSDate *)theDate {
	[NSDateFormatter setDefaultFormatterBehavior:NSDateFormatterBehavior10_4];
	NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
	[dateFormatter setDateStyle:NSDateFormatterShortStyle];
	[dateFormatter setTimeStyle:NSDateFormatterMediumStyle];
	NSString *dateStr = [dateFormatter stringFromDate:theDate];
	[dateFormatter release];
	return dateStr;
}

#pragma mark Score
long GetScore( char EndStatus, int Days, long Worth, char Level ) {
	long d;
	
	Worth = (Worth < 1000000 ? Worth : 1000000 + ((Worth - 1000000) / 10) );
	
	if (EndStatus == KILLED)
		return (Level+1L)*(long)((Worth * 90) / 50000);
	else if (EndStatus == RETIRED)
		return (Level+1L)*(long)((Worth * 95) / 50000);
	else
	{
		d = ((Level+1L)*100) - Days;
		if (d < 0)
			d = 0;
		return (Level+1L)*(long)((Worth + (d * 1000)) / 500);
	}
} 

void InitHighScores (void) {
 	int i;
	for (i=0; i<MAXHIGHSCORE; ++i) {
		Hscores[i].Name[0] = '\0';
		Hscores[i].Status = 0;
		Hscores[i].Days = 0;
		Hscores[i].Worth = 0;
		Hscores[i].Difficulty = 0;
		Hscores[i].ForFutureUse = 0;
	}
}

-(void)clearHighScores {
	InitHighScores();
	[self SaveHighScore:@"scores"];
}


-(void)fillHighScores:(NSMutableArray*)array {
	[self LoadBinaryHighScore:@"scores" data:Hscores];
	int i;
	long Percentage;
	
	for (i=0; i<MAXHIGHSCORE; ++i)
	{
		if (Hscores[i].Name[0] == '\0')
		{
			continue;
		}
		
		Percentage = GetScore( Hscores[i].Status, Hscores[i].Days, Hscores[i].Worth,
							  Hscores[i].Difficulty );
		
		NSString *type, *level= DifficultyLevel[Hscores[i].Difficulty];
		if (Hscores[i].Status == MOON)
			type =@"Claimed moon";
		else if (Hscores[i].Status == RETIRED)
			type =@"Retired";
		else
			type=@"Was killed";
		
		[array addObject:[NSDictionary dictionaryWithObjectsAndKeys:
						  [NSString stringWithFormat:@"%@    Finished:%i.%i%%", [NSString stringWithFormat:@"%s", Hscores[i].Name], (Percentage / 50L), ((Percentage%50L) / 5)], @"title",
						  [NSString stringWithFormat:@"%@ in %i days, worth %i credits on %@ level", type, Hscores[i].Days, Hscores[i].Worth, level ], @"line",
						  nil]];	
		
	}
}

#pragma mark EndofGame
-(BOOL) endOfGame:( char) EndStatus {
	int i, j;
	Boolean Scored;
	long a, b;
	
	Scored = FALSE;
	i = 0;
	while (i<MAXHIGHSCORE){
		a = GetScore( EndStatus, days, [self currentNetWorth], gameDifficulty );
		
		b =	GetScore( Hscores[i].Status, Hscores[i].Days, Hscores[i].Worth,
					 Hscores[i].Difficulty );
		
		if ((a > b) || (a == b && [self currentNetWorth] > Hscores[i].Worth) ||
			(a == b && [self currentNetWorth] == Hscores[i].Worth && days > Hscores[i].Days) ||
			Hscores[i].Name[0] == '\0')
		{
			for (j=MAXHIGHSCORE-1; j>i; --j)
			{
				strcpy( Hscores[j].Name, Hscores[j-1].Name );
				Hscores[j].Status = Hscores[j-1].Status;
				Hscores[j].Days = Hscores[j-1].Days;
				Hscores[j].Worth = Hscores[j-1].Worth;
				Hscores[j].Difficulty = Hscores[j-1].Difficulty;
			}
			[pilotName getCString:Hscores[i].Name maxLength:(NAMELEN+1) encoding:NSUTF8StringEncoding];
			
			Hscores[i].Status = EndStatus;
			Hscores[i].Days = days;
			Hscores[i].Worth = [self currentNetWorth];
			Hscores[i].Difficulty = gameDifficulty;
			[self SaveHighScore:@"scores"];
			Scored = TRUE;
			break;
		}
		++i;
	}
	
	long Percentage = GetScore( Hscores[i].Status, Hscores[i].Days, Hscores[i].Worth,
							   Hscores[i].Difficulty );	
	NSString * fs;
	if (Scored)
		fs = @"Congratulations! You have made the high-score list!";
	else
		fs =@"Sorry, this is not enough to enter the high-score list.";
	NSString * final = [NSString stringWithFormat:@"%@\nYou achieved a score of %i.%i%%.", fs,  (Percentage / 50L), ((Percentage%50L) / 5)];
	[self FrmAlert:final];
	
	return Scored;
}

#pragma mark loadTheGame
-(void)LoadBinaryData:(NSString*)name  time:(NSString**)time data:(SAVEGAMETYPE *)sg {	
	NSArray *filePaths = NSSearchPathForDirectoriesInDomains (NSDocumentDirectory, NSUserDomainMask, YES); 
	NSString *recordingDirectory = [filePaths objectAtIndex: 0];
	NSString *fileName = [NSString stringWithFormat:@"%@/%@.save", recordingDirectory, name];
	NSData *data;
	data = [[NSData alloc] initWithContentsOfFile:fileName];

	memcpy(sg, [data bytes], [data length]);
	[data release];
	
	if (time != nil) {
		NSFileManager *fileManager = [NSFileManager defaultManager];		
		NSDictionary *fsAttributes = [fileManager attributesOfItemAtPath:fileName error:NULL];
		*time = [self convertDateLocaleString:[fsAttributes objectForKey:NSFileModificationDate]];
	}
}

-(void)loadTheGame:(NSString *)name {
	
	SAVEGAMETYPE   saveGame, *sg = &saveGame;
	[self LoadBinaryData:name time:nil data:&saveGame];

	int i;
	currentSystem = sg->CurrentSystem;
	credits = sg->Credits;
	debt = sg->Debt;
	gesdb = sg->Deposit;
	days = sg->Days;
	warpSystem = sg->WarpSystem;
	pilotSkill = sg->PilotSkill;
	fighterSkill = sg->FighterSkill;
	traderSkill = sg->TraderSkill;
	engineerSkill = sg->EngineerSkill;
	
	for (i=0; i<MAXTRADEITEM; ++i) {
		BuyPrice[i] = sg->BuyPrice[i];
		SellPrice[i] = sg->SellPrice[i];
	}
	for (i=0; i<MAXSHIPTYPE; ++i) {
		ShipPrice[i] = sg->ShipPrice[i];
	}

	galacticChartSystem= sg->GalacticChartSystem ;
	policeKills = sg->PoliceKills;
	traderKills = sg->TraderKills;
	pirateKills = sg->PirateKills;
	policeRecordScore = sg->PoliceRecordScore;
	reputationScore = sg->ReputationScore;
	transporterScore = sg->TransporterScore;
	totalPassengers = sg->TotalPassengers;
	totalPEPPassengers = sg->TotalPEPPassengers;
	transportRatingTotal = sg->TransportRatingTotal;
	autoFuel = sg->AutoFuel;
	autoRepair = sg->AutoRepair;
	clicks = sg->Clicks;
	encounterType = sg->EncounterType;
	raided = sg->Raided;
	monsterStatus= sg->MonsterStatus ;
	dragonflyStatus = sg->DragonflyStatus;
	japoriDiseaseStatus = sg->JaporiDiseaseStatus;
	moonBought = sg->MoonBought;
	monsterHull= sg->MonsterHull ;
	pilotName = [[NSString stringWithFormat:@"%s", sg->NameCommander] retain];
	pilotLog = [[NSString stringWithFormat:@"%s", sg->LogCommander] retain];
	memmove(&ship, &(sg->Ship),  sizeof( sg->Ship ) );
	memmove( &Opponent,&(sg->Opponent),  sizeof( sg->Opponent ) );
	for (i=0; i<MAXCREWMEMBER+1; ++i) {
		memmove(&Mercenary[i], &(sg->Mercenary[i]),  sizeof( sg->Mercenary[i] ) );    
	}
	for (i=0; i<MAXSOLARSYSTEM; ++i) {
		memmove(&solarSystem[i], &(sg->SolarSystem[i]),  sizeof( sg->SolarSystem[i] ) );
	}
	
	escapePod = sg->EscapePod;
	insurance= sg->Insurance ;
	noClaim = sg->NoClaim;
	inspected = sg->Inspected;
	litterWarning = sg->LitterWarning;
	alwaysIgnoreTraders = sg->AlwaysIgnoreTraders;
	alwaysIgnorePolice = sg->AlwaysIgnorePolice;
	alwaysIgnorePirates = sg->AlwaysIgnorePirates;
	gameDifficulty = sg->Difficulty;

	for (i=0; i<MAXWORMHOLE; ++i) {
		Wormhole[i] = sg->Wormhole[i];
	}

	for (i=0; i<MAXTRADEITEM; ++i) {
		BuyingPrice[i] = sg->BuyingPrice[i];
	}

	artifactOnBoard = sg->ArtifactOnBoard;
	reserveMoney = sg->ReserveMoney;
	tribbleMessage = sg->TribbleMessage;
	rygellianFleasMessage = sg->RygellianFleasMessage;
	leaveEmpty = sg->LeaveEmpty;
	textualEncounters = sg->TextualEncounters;
	jarekStatus = sg->JarekStatus;
	invasionStatus = sg->InvasionStatus;
	experimentStatus = sg->ExperimentStatus;
	browerStatus = sg->BrowerStatus;
	fabricRipProbability = sg->FabricRipProbability;
	veryRareEncounter = sg->VeryRareEncounter;
	newsAutoPay = sg->NewsAutoPay;
	agreedToGPTA = sg->AgreedToGPTA;
	showTrackedRange = sg->ShowTrackedRange;
	justLootedMary = sg->JustLootedMary;
	arrivedViaWormhole = sg->ArrivedViaWormhole;
	trackAutoOff = sg->TrackAutoOff;
	remindLoans = sg->RemindLoans;
	canSuperWarp = sg->CanSuperWarp;
	reactorStatus = sg->ReactorStatus;
	trackedSystem = sg->TrackedSystem;
	scarabStatus = sg->ScarabStatus;
 	alwaysIgnoreTradeInOrbit = sg->AlwaysIgnoreTradeInOrbit;
	alreadyPaidForNewspaper = sg->AlreadyPaidForNewspaper;
	alreadyLoggedNews = sg->AlreadyLoggedNews;
	gameLoaded = sg->GameLoaded;
	shouldAutoFlee = sg->ShouldAutoFlee;
	shouldAutoAttack = sg->ShouldAutoAttack;
	transportPassengers = sg->TransportPassengers;
	passengersDestination = sg->PassengersDestination;
	
	[[AppDelegate sharedAppDelegate] switchBarToGame];
	[[AppDelegate sharedAppDelegate]  commandCommand];
	[self updateMercenary0Data];
}

-(void)updateFileNames {
	NSArray *filePaths = NSSearchPathForDirectoriesInDomains (NSDocumentDirectory, NSUserDomainMask, YES); 
	NSString *recordingDirectory = [filePaths objectAtIndex: 0];
	NSDirectoryEnumerator *direnum = [[NSFileManager defaultManager]enumeratorAtPath:recordingDirectory];
	NSError *error;
	NSString *pname;
	int i = 1;
	while (pname = [direnum nextObject]) {
		if ([[pname pathExtension] isEqualToString:@"rtfd"]){
			[direnum skipDescendents];
		} else {
			if ([[pname pathExtension] isEqualToString:@"save"]) {
				NSString *nameFile = [pname stringByDeletingPathExtension]; 
				if (![nameFile hasPrefix:@"AutoSave"]) {
					if (![nameFile isEqualToString:[NSString stringWithFormat:@"%i",i]]) {
						NSString *orgFileName = [NSString stringWithFormat:@"%@/%@.save", recordingDirectory, nameFile];
						NSString *newFileName = [NSString stringWithFormat:@"%@/%i.save", recordingDirectory, i];
						[[NSFileManager defaultManager] moveItemAtPath:orgFileName toPath:newFileName error:&error];
					}
					++i;
				}
			}
		}
	}	
	
}


-(void)showSavedGames:(NSMutableArray *)array name:(NSMutableArray *)name additional:(NSMutableArray *)additional {
	newestSavedGame = @"";
	NSArray *filePaths = NSSearchPathForDirectoriesInDomains (NSDocumentDirectory, NSUserDomainMask, YES); 
	NSString *recordingDirectory = [filePaths objectAtIndex: 0];
	NSDirectoryEnumerator *direnum = [[NSFileManager defaultManager]enumeratorAtPath:recordingDirectory];
	NSString *pname;
	NSArray *names = [NSArray arrayWithObjects: @"Beginner", @"Easy", @"Normal", @"Hard", @"Impossible", nil];
	NSFileManager *fileManager = [NSFileManager defaultManager];		
	while (pname = [direnum nextObject]) {
		if ([[pname pathExtension] isEqualToString:@"rtfd"]){
			[direnum skipDescendents];
		} else {
			if ([[pname pathExtension] isEqualToString:@"save"]) {
				NSString *nameFile = [pname stringByDeletingPathExtension]; 
				[array addObject:nameFile];
				SAVEGAMETYPE save;
				NSString *time;
				[self LoadBinaryData:nameFile time:&time data:&save];
				
				[name addObject:[NSString stringWithFormat:@"%@ (%@)", [NSString stringWithFormat:@"%s", save.NameCommander], nameFile]];
				[additional addObject:[NSString stringWithFormat:@"Saved On: %@ @ the %@ System.\nDifficulty: %@, Game Days: %i, Credits: %i", time, [self getSolarSystemName:save.CurrentSystem], [names objectAtIndex:save.Difficulty], save.Days, save.Credits]];				
				
				NSString *fileName = [NSString stringWithFormat:@"%@/%@.save", recordingDirectory, nameFile];
				NSDictionary *fsAttributes = [fileManager attributesOfItemAtPath:fileName error:NULL];
				newDate = [fsAttributes objectForKey:NSFileModificationDate];
				if ([newestSavedGame isEqualToString:@""]) {
					oldDate = newDate;
					newestSavedGame = [[NSString stringWithFormat:@"%@ (%@)", [NSString stringWithFormat:@"%s", save.NameCommander], nameFile]retain];
				}
				if ([newDate laterDate:oldDate] == newDate) {
					newestSavedGame = [[NSString stringWithFormat:@"%@ (%@)", [NSString stringWithFormat:@"%s", save.NameCommander], nameFile]retain];
					oldDate = newDate;
				}
			}
		}
	}	
}


-(void)LoadBinaryJumpData:(NSString*)name  time:(NSString**)time data:(SAVEGAMETYPE *)sg {	
	NSString *jumpPath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:@"Jump/"];
	NSString *fileName = [NSString stringWithFormat:@"%@/%@.jump", jumpPath, name];
	NSData *data;
	data = [[NSData alloc] initWithContentsOfFile:fileName];
	
	memcpy(sg, [data bytes], [data length]);
	[data release];
	
	if (time != nil) {
		NSFileManager *fileManager = [NSFileManager defaultManager];		
		NSDictionary *fsAttributes = [fileManager attributesOfItemAtPath:fileName error:NULL];
		*time = [self convertDateLocaleString:[fsAttributes objectForKey:NSFileModificationDate]];
	}		
}

-(void)loadJumpGame:(NSString *)name {
	
	SAVEGAMETYPE   saveGame, *sg = &saveGame;
	[self LoadBinaryJumpData:name time:nil data:&saveGame];
	
	int i;
	currentSystem = sg->CurrentSystem;
	credits = sg->Credits;
	debt = sg->Debt;
	gesdb = sg->Deposit;
	days = sg->Days;
	warpSystem = sg->WarpSystem;
	pilotSkill = sg->PilotSkill;
	fighterSkill = sg->FighterSkill;
	traderSkill = sg->TraderSkill;
	engineerSkill = sg->EngineerSkill;
	
	for (i=0; i<MAXTRADEITEM; ++i) {
		BuyPrice[i] = sg->BuyPrice[i];
		SellPrice[i] = sg->SellPrice[i];
	}
	for (i=0; i<MAXSHIPTYPE; ++i) {
		ShipPrice[i] = sg->ShipPrice[i];
	}
	
	galacticChartSystem= sg->GalacticChartSystem ;
	policeKills = sg->PoliceKills;
	traderKills = sg->TraderKills;
	pirateKills = sg->PirateKills;
	policeRecordScore = sg->PoliceRecordScore;
	reputationScore = sg->ReputationScore;
	transporterScore = sg->TransporterScore;
	totalPassengers = sg->TotalPassengers;
	totalPEPPassengers = sg->TotalPEPPassengers;
	transportRatingTotal = sg->TransportRatingTotal;
	autoFuel = sg->AutoFuel;
	autoRepair = sg->AutoRepair;
	clicks = sg->Clicks;
	encounterType = sg->EncounterType;
	raided = sg->Raided;
	monsterStatus= sg->MonsterStatus ;
	dragonflyStatus = sg->DragonflyStatus;
	japoriDiseaseStatus = sg->JaporiDiseaseStatus;
	moonBought = sg->MoonBought;
	monsterHull= sg->MonsterHull ;
	pilotName = [[NSString stringWithFormat:@"%s", sg->NameCommander] retain];
	pilotLog = [[NSString stringWithFormat:@"%s", sg->LogCommander] retain];
	memmove(&ship, &(sg->Ship),  sizeof( sg->Ship ) );
	memmove( &Opponent,&(sg->Opponent),  sizeof( sg->Opponent ) );
	for (i=0; i<MAXCREWMEMBER+1; ++i) {
		memmove(&Mercenary[i], &(sg->Mercenary[i]),  sizeof( sg->Mercenary[i] ) );    
	}
	for (i=0; i<MAXSOLARSYSTEM; ++i) {
		memmove(&solarSystem[i], &(sg->SolarSystem[i]),  sizeof( sg->SolarSystem[i] ) );
	}
	
	escapePod = sg->EscapePod;
	insurance= sg->Insurance ;
	noClaim = sg->NoClaim;
	inspected = sg->Inspected;
	litterWarning = sg->LitterWarning;
	alwaysIgnoreTraders = sg->AlwaysIgnoreTraders;
	alwaysIgnorePolice = sg->AlwaysIgnorePolice;
	alwaysIgnorePirates = sg->AlwaysIgnorePirates;
	gameDifficulty = sg->Difficulty;
	
	for (i=0; i<MAXWORMHOLE; ++i) {
		Wormhole[i] = sg->Wormhole[i];
	}
	
	for (i=0; i<MAXTRADEITEM; ++i) {
		BuyingPrice[i] = sg->BuyingPrice[i];
	}
	
	artifactOnBoard = sg->ArtifactOnBoard;
	reserveMoney = sg->ReserveMoney;
	tribbleMessage = sg->TribbleMessage;
	rygellianFleasMessage = sg->RygellianFleasMessage;
	leaveEmpty = sg->LeaveEmpty;
	textualEncounters = sg->TextualEncounters;
	jarekStatus = sg->JarekStatus;
	invasionStatus = sg->InvasionStatus;
	experimentStatus = sg->ExperimentStatus;
	browerStatus = sg->BrowerStatus;
	fabricRipProbability = sg->FabricRipProbability;
	veryRareEncounter = sg->VeryRareEncounter;
	newsAutoPay = sg->NewsAutoPay;
	agreedToGPTA = sg->AgreedToGPTA;
	showTrackedRange = sg->ShowTrackedRange;
	justLootedMary = sg->JustLootedMary;
	arrivedViaWormhole = sg->ArrivedViaWormhole;
	trackAutoOff = sg->TrackAutoOff;
	remindLoans = sg->RemindLoans;
	canSuperWarp = sg->CanSuperWarp;
	reactorStatus = sg->ReactorStatus;
	trackedSystem = sg->TrackedSystem;
	scarabStatus = sg->ScarabStatus;
 	alwaysIgnoreTradeInOrbit = sg->AlwaysIgnoreTradeInOrbit;
	alreadyPaidForNewspaper = sg->AlreadyPaidForNewspaper;
	alreadyLoggedNews = sg->AlreadyLoggedNews;
	gameLoaded = sg->GameLoaded;
	shouldAutoFlee = sg->ShouldAutoFlee;
	shouldAutoAttack = sg->ShouldAutoAttack;
	transportPassengers = sg->TransportPassengers;
	passengersDestination = sg->PassengersDestination;
	
	[[AppDelegate sharedAppDelegate] switchBarToGame];
	[[AppDelegate sharedAppDelegate]  commandCommand];
	[self updateMercenary0Data];
}

-(void)showJumpStartGames:(NSMutableArray *)array name:(NSMutableArray *)name additional:(NSMutableArray *)additional {
	NSString *jumpPath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:@"Jump/"];
	NSDirectoryEnumerator *direnum = [[NSFileManager defaultManager]enumeratorAtPath:jumpPath];
	NSString *pname;
	NSArray *names = [NSArray arrayWithObjects: @"Beginner", @"Easy", @"Normal", @"Hard", @"Impossible", nil];
	while (pname = [direnum nextObject]) {
		if ([[pname pathExtension] isEqualToString:@"rtfd"]){
			[direnum skipDescendents];
		} else {
			if ([[pname pathExtension] isEqualToString:@"jump"]) {
				NSString *nameFile = [pname stringByDeletingPathExtension]; 
				[array addObject:nameFile];
				SAVEGAMETYPE jump;
				NSString *time;
				[self LoadBinaryJumpData:nameFile time:&time data:&jump];
				[name addObject:[NSString stringWithFormat:@"%@ (%@)", [NSString stringWithFormat:@"%s", jump.NameCommander], nameFile]];
				[additional addObject:[NSString stringWithFormat:@"Saved On: %@ @ the %@ System.\nDifficulty: %@, Game Days: %i, Credits: %i", time, [self getSolarSystemName:jump.CurrentSystem], [names objectAtIndex:jump.Difficulty], jump.Days, jump.Credits]];				
								
			}
		}
	}	
}


#pragma mark --------
#pragma mark Hacks
-(void)cheatTalbotLaser {
	int FirstEmptySlot = [self getFirstEmptySlot: Shiptype[ship.Type].WeaponSlots Item:ship.Weapon];
	if (FirstEmptySlot < 0) {
		[self FrmAlert:NSLocalizedString(@"NotEnoughSlotsAlert", @"")];
	} else {
		ship.Weapon[FirstEmptySlot] = TALBOTLASERWEAPON;
		[self FrmAlert:NSLocalizedString(@"TalbotLaserAlert", @"")];
	}				
}

-(void)cheatFuelCompactor {
	int FirstEmptySlot = [self getFirstEmptySlot:Shiptype[ship.Type].GadgetSlots Item:ship.Gadget];
	if (FirstEmptySlot < 0) {
		[self FrmAlert:NSLocalizedString(@"NotEnoughSlotsAlert", @"")];
	} else {
		ship.Gadget[FirstEmptySlot] = FUELCOMPACTOR;
		ship.Fuel = [self getFuelTanks];
		[self FrmAlert:NSLocalizedString(@"FuelCompactorAlert", @"")];
	}	
}

-(void)cheatQuantumShield {
	int FirstEmptySlot = [self getFirstEmptySlot: Shiptype[ship.Type].ShieldSlots Item:ship.Shield];
	if (FirstEmptySlot < 0) {
		[self FrmAlert:NSLocalizedString(@"NotEnoughSlotsAlert", @"")];
	} else {
		ship.Shield[FirstEmptySlot] = QUANTUMSHIELD;  
		ship.ShieldStrength[FirstEmptySlot] = Shieldtype[QUANTUMSHIELD].Power;
		[self FrmAlert:NSLocalizedString(@"QuantumShieldAlert", @"")];
	}
}

-(NSString*)allSystems {
	NSMutableString *systemList = [[NSMutableString alloc] initWithString:@"Special Events:\n"];
	int oldCurrent = currentSystem;
	for (int i =0; i < MAXSOLARSYSTEM;++i) {
		currentSystem = i;
		[systemList appendString:[NSString stringWithFormat:@"Name: %@ %@\nTech: %@\nPolitics: %@\n"
								  "Pirates/Police: %@/%@\n---\n",[self getCurrentSystemName],
								  [self getCurrentSystemSize],[self getCurrentSystemTechLevel],
								  [self getCurrentSystemPolitics], [self getCurrentSystemPirates],
								  [self getCurrentSystemPolice]]];

	}
	currentSystem = oldCurrent;
	return systemList;
}

-(NSString*)allSpecialEvents {
	NSMutableString *eventsList = [[NSMutableString alloc] initWithString:@"Special Events:\n"];
	int oldCurrent = currentSystem;
	for (int i =0; i < MAXSOLARSYSTEM;++i) {
		currentSystem = i;
		NSString *title = [NSString stringWithFormat:@"%s", SpecialEvent[CURSYSTEM.Special].Title];
		[eventsList appendString:[NSString stringWithFormat:@"System: %@ - %@\n",[self getCurrentSystemName],title]];
	}
	currentSystem = oldCurrent;
	return eventsList;
}

-(void)resetVisited {
	int i;
	for (i=0; i<MAXSOLARSYSTEM; ++i) {
		solarSystem[i].Visited = FALSE;
	}
	CURSYSTEM.Visited = TRUE;
}	

#pragma mark String Functions
-(NSString*)getSolarSystemSpecalResources:(int)index {
	if (solarSystem[warpSystem].Visited)
		return [NSString stringWithFormat:@"%s", SpecialResources[solarSystem[index].SpecialResources]];
	else
		return @"Special resources unknown";
}

-(NSString*)currentPoliceRecord {
	NSInteger i = 0;
	while (i < MAXPOLICERECORD && policeRecordScore >= PoliceRecord[i].MinScore)
		++i;
	--i;
	if (i < 0)
		i = 0;
	return [NSString stringWithFormat:@"%s", PoliceRecord[i].Name];	
}

-(NSString*)currentReputation {
	NSInteger i = 0;
	while (i < MAXREPUTATION && reputationScore >= Reputation[i].MinScore)
		++i;
	--i;
	if (i < 0)
		i = 0;
	return [NSString stringWithFormat:@"%s", Reputation[i].Name];	
}

-(NSString*)getCurrentSystemName {
	return [[self solarSystemName] objectAtIndex:CURSYSTEM.NameIndex];	
}

-(NSString*)getCurrentSystemSize {
	return [[self systemSize] objectAtIndex:CURSYSTEM.Size];
}

-(NSString*)getCurrentSystemTechLevel {
	return [[self techLevel] objectAtIndex:CURSYSTEM.TechLevel];
}

-(NSString*)getSystemTechLevel:(int)index {
	return [[self techLevel] objectAtIndex:solarSystem[index].TechLevel];	
}

-(NSString*)getCurrentSystemPolitics {
	return [NSString stringWithFormat:@"%s", Politics[CURSYSTEM.Politics].Name];
}

-(NSString*)getCurrentSystemPolice {
	return [NSString stringWithFormat:@"%s", Activity[Politics[CURSYSTEM.Politics].StrengthPolice]];
}

-(NSString*)getCurrentSystemPirates {
	return [NSString stringWithFormat:@"%s", Activity[Politics[CURSYSTEM.Politics].StrengthPirates]];
}
-(int) getCurrentSystemPirateLevel {
	return (int)Politics[CURSYSTEM.Politics].StrengthPirates;
}

-(NSString*)getCurrentSystemSpecalResources {
	return [NSString stringWithFormat:@"%s", SpecialResources[CURSYSTEM.SpecialResources]];
}

-(NSString*)getWarpSystemName {
	return [[self solarSystemName] objectAtIndex:solarSystem[warpSystem].NameIndex];
}

-(NSString*)getWarpSystemSize {
	return [[self systemSize] objectAtIndex:solarSystem[warpSystem].Size];
}

-(NSString*)getWarpSystemTechLevel {
	return [[self techLevel] objectAtIndex:solarSystem[warpSystem].TechLevel];
}

-(NSString*)getWarpSystemPolitics {
	return [NSString stringWithFormat:@"%s", Politics[solarSystem[warpSystem].Politics].Name];
}

-(NSString*)getWarpSystemPolice {
	return [NSString stringWithFormat:@"%s", Activity[Politics[solarSystem[warpSystem].Politics].StrengthPolice]];
}

-(NSString*)getWarpSystemPirates {
	return [NSString stringWithFormat:@"%s", Activity[Politics[solarSystem[warpSystem].Politics].StrengthPirates]];
}

-(NSString*)getWarpSystemSpecalResources {
	return [NSString stringWithFormat:@"%s", SpecialResources[solarSystem[warpSystem].SpecialResources]];
}

#pragma mark Settings
-(void)enableLeftHandEncounter {
	[playerDefaults setBool:TRUE forKey:@"leftHandEncounter"];
	[playerDefaults synchronize];
	leftHandIsOn = TRUE;
}

-(void)disableLeftHandEncounter {
	[playerDefaults setBool:FALSE forKey:@"leftHandEncounter"];
	[playerDefaults synchronize];
	leftHandIsOn = FALSE;
}


#pragma mark Sound & Audio Stuff
static void speechCompletionCallback(SystemSoundID mySSID, void* myself) {
	AudioServicesRemoveSystemSoundCompletion(mySSID);
}

-(void) playSpeechFile: (NSString *)filename {
	if (speechAlertsOn) {
		NSString *filePath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:[NSString stringWithFormat:@"Commands/%@", filename]];
		NSURL *url = [NSURL fileURLWithPath:filePath];
		AudioServicesCreateSystemSoundID ((CFURLRef)url, &speechFileSoundID);
		AudioServicesPlaySystemSound(speechFileSoundID);		
		AudioServicesAddSystemSoundCompletion(speechFileSoundID, NULL, NULL, speechCompletionCallback, (void*) self);
	}	
}

static void soundCompletionCallback(SystemSoundID mySSID, void* myself) {
	AudioServicesRemoveSystemSoundCompletion(mySSID);
}

-(void) playSoundFile: (NSString *)filename {
	if ([playerDefaults boolForKey:@"soundEnabled"]) {
		NSString *filePath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:[NSString stringWithFormat:@"Sounds/%@", filename]];
		NSURL *url = [NSURL fileURLWithPath:filePath];		
		AudioServicesCreateSystemSoundID ((CFURLRef)url, &soundFileSoundID);
		AudioServicesPlaySystemSound(soundFileSoundID);		
		AudioServicesAddSystemSoundCompletion(soundFileSoundID, NULL, NULL, soundCompletionCallback, (void*) self);
	}	
}

-(void) showUserNotice:(int)mode {
	switch (mode) {
		case 0:
			if (speechAlertsOn) {
				[self playSpeechFile:@"Alert.caf"];
			}
			else {
				[[SoundManager sharedSound] playSoundWithId:kBuy];
			}
			break;
		case 1:
			if (speechAlertsOn) {
				[self playSpeechFile:@"Caution.caf"];
			}
			else {
				[[SoundManager sharedSound] playSoundWithId:kCancel];
			}
			break;
		case 2:
			if (speechAlertsOn) {
				[self playSpeechFile:@"PleaseConfirm.caf"];
			}
			else {
				[[SoundManager sharedSound] playSoundWithId:kBuy];
			}
			break;
		case 3:
			[[SoundManager sharedSound] playSoundWithId:kPling];
			break;
		case 4:
			if (speechAlertsOn) {
				[self playSpeechFile:@"Warning.caf"];
			}
			else {
				[[SoundManager sharedSound] playSoundWithId:kLedLum];
			}
			break;
		default:
			break;
	}
	
}

-(void)disableMusic {
	[playerDefaults setBool:FALSE forKey:@"musicEnabled"];
	[playerDefaults synchronize];
	[[AppDelegate sharedAppDelegate]stopMusic];
}

-(void)enableMusic {
	[playerDefaults setBool:TRUE forKey:@"musicEnabled"];
	[playerDefaults synchronize];
	[[AppDelegate sharedAppDelegate]startMusic];
}

-(void)disableSpeech {
	[playerDefaults setBool:FALSE forKey:@"speechAlerts"];
	[playerDefaults synchronize];
	speechAlertsOn = FALSE;
}
-(void)enableSpeech {
	[playerDefaults setBool:TRUE forKey:@"speechAlerts"];
	[playerDefaults synchronize];
	speechAlertsOn = TRUE;
}

-(void)disableSound {
	[playerDefaults setBool:FALSE forKey:@"soundEnabled"];
	[playerDefaults synchronize];
}

-(void)enableSound {
	[playerDefaults setBool:TRUE forKey:@"soundEnabled"];
	[playerDefaults synchronize];
}

-(BOOL)isSpeechEnabled {
	return [playerDefaults boolForKey:@"speechAlerts"];
}

-(BOOL)isMusicEnabled {
	return [playerDefaults boolForKey:@"musicEnabled"];
}

-(BOOL)isSoundEnabled {
	return [playerDefaults boolForKey:@"soundEnabled"];
}

@end
