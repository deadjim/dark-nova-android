//
//  Player.h
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
#include "GameDefines.h"
#import "EncounterViewController.h"
#import "PersonnelRosterViewController.h"
#import "BuyEquipmentViewController.h"
#import "SystemInfoViewController.h"
#import "BuyShipViewController.h"
#import <AudioToolbox/AudioToolbox.h>

enum aNoticeMode
{
	aAlert = 0,
	aCaution,
	aConfirm,
	aNotice,
	aWarning
};


@interface Player : NSObject <UIAlertViewDelegate, EncounterViewControllerDelegate> {
	
	NSUserDefaults		*playerDefaults;

	NSUInteger	pilotSkill;
	NSUInteger	fighterSkill;
	NSUInteger	traderSkill;
	NSUInteger	engineerSkill;
	NSString	*pilotName;
	NSString	*pilotLog;
	NSUInteger	gameDifficulty;
	NSUInteger	totalSkillPoints;
	NSUInteger	credits;
	NSUInteger  gesdb;
	NSUInteger	debt;
	NSInteger	policeRecordScore;
	NSInteger	reputationScore;
	NSInteger	transporterScore;	
	NSUInteger	totalPassengers;
	NSUInteger	totalPEPPassengers;
	NSUInteger	transportRatingTotal;
	NSUInteger	policeKills;
	NSUInteger	traderKills;
	NSUInteger	pirateKills;
	NSUInteger  noClaim;
	NSUInteger  newsSpecialEventCount;
	NSUInteger	currentSystem;
	NSUInteger	days;	
	
	NSArray*	solarSystemName, *systemSize, *techLevel;
	BOOL		insurance;
	BOOL		escapePod;
	BOOL		moonBought;
	BOOL		remindLoans;
	BOOL		artifactOnBoard;
	BOOL		tribbleMessage;
	BOOL		rygellianFleasMessage;
	BOOL		possibleToGoThroughRip;
	BOOL		arrivedViaWormhole;
	int			trackedSystem;
	BOOL		showTrackedRange;
	BOOL		justLootedMary;
	int			chanceOfVeryRareEncounter;
	BOOL		alreadyPaidForNewspaper;
	BOOL		alreadyLoggedNews;
	BOOL		gameLoaded;
	int			monsterHull;
	int			galacticChartSystem;
	BOOL		newsAutoPay;
	
	int			NewsEvents[MAXSPECIALNEWSEVENTS];
	NSString	*newestSavedGame;
	NSDate		*oldDate;
	NSDate		*newDate;

		
	struct SOLARSYSTEM {
		Byte NameIndex;
		Byte TechLevel;			
		Byte Politics;			
		Byte Status;			
		Byte X;					
		Byte Y;					
		Byte SpecialResources;	
		Byte Size;				
		int Qty[MAXTRADEITEM];	
		Byte CountDown;			
		Boolean Visited;		
		int Special;			
	} solarSystem[MAXSOLARSYSTEM] ;
	
	
	struct SHIP {
		Byte Type;
		int  Cargo[MAXTRADEITEM];
		int  Weapon[MAXWEAPON];
		int  Shield[MAXSHIELD];
		long ShieldStrength[MAXSHIELD];
		int  Gadget[MAXGADGET];
		int  Crew[MAXCREW];
		Byte Fuel;
		long Hull;
		long Tribbles;
		long RygellianFleas;
		int PirateHullUpgrade;
		long ForFutureUse[4];
	} ship, Opponent;
	
	long BuyPrice[MAXTRADEITEM];    
	long BuyingPrice[MAXTRADEITEM]; 
	long SellPrice[MAXTRADEITEM];   
	long ShipPrice[MAXSHIPTYPE];    
	Byte Wormhole[MAXWORMHOLE];
	
	Byte monsterStatus;       
	Byte dragonflyStatus;     
	Byte japoriDiseaseStatus; 
	Byte jarekStatus;         
	Byte invasionStatus;      
	Byte experimentStatus;    
	Byte fabricRipProbability; 
	Byte veryRareEncounter;     
	Byte browerStatus;			
	Byte reactorStatus;			
	Byte scarabStatus ;		
	BOOL transportPassengers;
	NSUInteger	warpSystem;
	int leaveEmpty;
	BOOL reserveMoney;
	BOOL litterWarning;
	BOOL agreedToGPTA;
	NSUInteger countDown;
	int clicks;
	BOOL raided;
	BOOL inspected;
	int encounterType;
	BOOL alwaysIgnorePolice;
	BOOL alwaysIgnorePirates;
	BOOL alwaysIgnoreTraders;
	BOOL alwaysIgnoreTradeInOrbit;
	BOOL trackAutoOff;
	int chanceOfTradeInOrbit;
	BOOL autoFuel;
	BOOL autoRepair;
	BOOL playerShipNeedsUpdate;
	BOOL opponentShipNeedsUpdate;
	BOOL autoAttack;
	BOOL autoFlee;
	BOOL shouldAutoAttack;
	BOOL shouldAutoFlee;
	BOOL attackIconStatus;
	BOOL textualEncounters;
	BOOL encounterWindow;
	int activeTradeItem;
	int bribe;
	BOOL canSuperWarp;
	int currentGalaxySystem;
	BOOL firstEncounter;
		
	BOOL leftHandIsOn;
	BOOL speechAlertsOn;
	SystemSoundID planetNameSoundID;
	SystemSoundID speechFileSoundID;
	SystemSoundID soundFileSoundID;
	BOOL nameSoundIsDone;
	
	int numberOfPassengers;
	int passengersDestination;
	BOOL didUsePEP;
	int newShip;

	EncounterViewController *encounterViewControllerInstance;
	
};

@property BOOL							alwaysIgnorePolice;
@property BOOL							alwaysIgnorePirates;
@property BOOL							alwaysIgnoreTraders;
@property BOOL							alwaysIgnoreTradeInOrbit;
@property BOOL							autoFuel;
@property BOOL							autoRepair;
@property BOOL							reserveMoney;
@property int							leaveEmpty;
@property  NSUInteger					pilotSkill;
@property  NSUInteger					fighterSkill;
@property  NSUInteger					traderSkill;
@property  NSUInteger					engineerSkill;
@property  NSUInteger					gameDifficulty;
@property  NSUInteger					totalSkillPoints;
@property (nonatomic, retain) NSString*	pilotName;
@property (nonatomic, retain) NSString*	pilotLog;
@property NSUInteger					noClaim;
@property NSUInteger					credits;
@property NSUInteger					debt;
@property NSUInteger					gesdb;
@property int			chanceOfVeryRareEncounter;
@property NSInteger						policeRecordScore;
@property NSInteger						reputationScore;
@property NSUInteger					policeKills;
@property NSUInteger					traderKills;
@property NSUInteger					pirateKills;
@property NSUInteger					currentSystem;
@property BOOL							insurance;
@property BOOL							escapePod;
@property NSUInteger					newsSpecialEventCount;
@property (nonatomic,copy) NSArray*		solarSystemName;
@property (nonatomic,copy) NSArray*		systemSize;
@property (nonatomic,copy) NSArray*		techLevel;
@property NSUInteger					days;
@property Byte							monsterStatus;
@property Byte							dragonflyStatus;
@property Byte							japoriDiseaseStatus;
@property Byte							jarekStatus;
@property Byte							invasionStatus; 
@property Byte							experimentStatus; 
@property Byte							fabricRipProbability;
@property Byte							veryRareEncounter; 
@property Byte							browerStatus;		
@property Byte							reactorStatus;		
@property Byte							scarabStatus ;		
@property BOOL							transportPassengers;
@property NSUInteger					warpSystem;
@property int							trackedSystem;
@property int							currentGalaxySystem;
@property BOOL							showTrackedRange;
@property NSUInteger					countDown;
@property BOOL							autoAttack;
@property BOOL							autoFlee;
@property BOOL							shouldAutoAttack;
@property BOOL							shouldAutoFlee;
@property BOOL							attackIconStatus;
@property int							encounterType;
@property BOOL							textualEncounters;
@property int							clicks;
@property BOOL							alreadyPaidForNewspaper;
@property BOOL							alreadyLoggedNews;
@property BOOL							agreedToGPTA;
@property BOOL							newsAutoPay;
@property BOOL							trackAutoOff;
@property BOOL							remindLoans;
@property BOOL							canSuperWarp;
@property (nonatomic, retain) NSString	*newestSavedGame;
@property BOOL							leftHandIsOn;
@property int							numberOfPassengers;
@property int							passengersDestination;
@property int							newShip;
@property BOOL							didUsePEP;
@property NSUInteger	totalPassengers;
@property NSUInteger	totalPEPPassengers;


-(void) updateMercenary0Data;
-(id) initEmpty;
-(NSUInteger) currentWorth;
-(NSUInteger) currentNetWorth;
-(void) payInterest;
-(long) maxLoan;
-(void) getLoan:(long) Loan;
-(void) payBack:(long) Loan;
-(long) currentShipPriceWithoutCargo:(BOOL)forInsurance;
-(long) insuranceMoney;
-(BOOL) isNewsEvent:(int) eventFlag;
-(int) latestNewsEvent;
-(void) resetNewsEvents;
-(void) replaceNewsEvent:(int)originalEventFlag replacementEventFlag:(int)replacementEventFlag;
-(void) addNewsEvent:(int) eventFlag;

-(NSString*)getCurrentSystemName;
-(NSString*)getCurrentSystemSize;
-(NSString*)getCurrentSystemTechLevel;
-(NSString*)getCurrentSystemPolitics;
-(NSString*)getCurrentSystemPolice;
-(NSString*)getCurrentSystemSpecalResources;
-(NSString*)getCurrentSystemPirates;
-(int) getCurrentSystemPirateLevel;

-(NSString*)getWarpSystemName;
-(NSString*)getWarpSystemSize;
-(NSString*)getWarpSystemTechLevel;
-(NSString*)getWarpSystemPolitics;
-(NSString*)getWarpSystemPolice;
-(NSString*)getWarpSystemSpecalResources;
-(NSString*)getWarpSystemPirates;

-(NSString*)getSystemTechLevel:(int)index;

-(NSUInteger)adaptPilotSkill;
-(NSUInteger)adaptEngineerSkill;
-(NSUInteger)adaptFighterSkill;
-(NSUInteger)adaptTraderSkill;
-(NSString*)currentPoliceRecord;
-(NSString*)currentReputation;

-(BOOL) startNewGame;
-(long) getSellPrice:(int)num;
-(long) getBuyPrice:(int)num;
-(long) getBuyingPrice:(int)num;
-(int) filledCargoBays;
-(int) totalCargoBays;
-(void) buyCargo:(int)Index  Amount:(int)Amount;
-(int) getAmountToBuy:(int)Index;
-(int) getOpponentAmountToSell:(int)Index;
-(int) getAmountToSell:(int)Index;
-(void) sellCargo:(int)Index  Amount:(int)Amount Operation:(Byte)Operation;
-(Byte) getFuel;
-(void) buyFuel:(int) Amount;
-(int) getSolarSystemX:(int)Index;
-(int) getSolarSystemY:(int)Index;
-(BOOL) getSolarSystemVisited:(int)Index;
-(NSString*)getSolarSystemName:(int)Index;
-(int) getCurrentSystemIndex;
-(Byte) getCurrentSystemTechLevelInt;
-(BOOL) wormholeExists:(int)a b:(int) b;
-(long) realDistance:(int)a  b:(int)b;
-(void) doWarp:(BOOL)viaSingularity;
-(Byte) getWormhole:(int)Index;
-(void) determinePrices:(Byte)SystemID;
-(void) buyRepairs:( int) Amount;
-(long) getHullStrength;
-(long) getShipHull;
-(Byte) getCurrentShipTechLevel;
-(Byte) getFuelTanks;
-(int) getFuelCost;
-(int) getRepairCost;
-(long) toSpend;

-(NSString*)getShipName:(Byte)index;
-(NSString*)getShipSize:(Byte)index;
-(NSString*)getShipPriceStr:(int)index;

-(int) getShipCargoBays:(Byte)index;
-(int) getShipRange:(Byte)index;
-(int) getShipHullStrength:(Byte)index;
-(int) getShipWeaponSlots:(Byte)index;
-(int) getShipShieldSlots:(Byte)index;
-(int) getShipGadgetSlots:(Byte)index;
-(int) getShipCrewQuarters:(Byte)index;
-(int) getShipPriceInt:(int)index;
-(void) buyShip:(int) Index ;
-(void) determineShipPrices;
-(Byte) getCurrentShipType;

-(void) travel;
-(BOOL) isShipCloaked;
-(int) getShipOpponentType;
-(BOOL) attack;
-(BOOL) flee;
-(BOOL) ignore;
-(BOOL) trade;
-(BOOL) yield;
-(BOOL) surrender;

-(BOOL) bribe; 
-(BOOL) submit; 
-(BOOL) plunder; 
-(BOOL) interrupt; 
-(BOOL) meet; 
-(BOOL) board; 
-(BOOL) drink;
-(BOOL) bribeContinue;
-(BOOL) submitContinue;

-(NSString*)getShipImageName:(Byte)index;
-(NSString*)getShipDamagedImageName:(Byte)index;
-(NSString*)getShipShieldImageName:(Byte)index;
-(NSString*)getShipImageNameBg:(Byte)index;

-(NSString*)drawQuestsForm:(SystemInfoViewController*)controller;
-(NSString*)drawSpecialCargoForm;
-(NSString*)drawCurrentShipForm;
-(NSString*)getEquipmentName:(int)index;
-(NSString*)getShipEquipmentName:(int)index; 
-(int) getEquipmentPrice:(int)index;
-(int) getSellEquipmentPrice:(int)index;
-(void) tryToBuyEquipment:(int)index controller:(BuyEquipmentViewController*)controller;
-(void) sellEquipment:(int)index;
-(void) updateRosterWindow:(PersonnelRosterViewController*)controller;
-(void) fireMercenary:(int)index; 
-(void) hireMercenaryFromRoster;

-(NSString*)getSolarSystemSpecalResources:(int)index;
-(NSString*)getPriceDifference:(int)itemIndex difference:(BOOL)difference realPrice:(int*)realPrice maxCount:(int*)maxCount  isSmart:(int*)isSmart;
-(int) mercenaryMoney;
-(long) wormholeTax:(int)a b:(int) b;
-(int) nextSystemWithinRange:(int) Current Back:(Boolean) Back;
-(void) saveTheGame:(NSString*)name;
-(void) loadTheGame:(NSString*)name;
-(void) showSavedGames:(NSMutableArray*)array name:(NSMutableArray*)name additional:(NSMutableArray*)additional;

-(long) getShipOpponentHull;
-(long) getShipShield;
-(long) getShipOpponentShield;
-(long) getShipShieldMax;
-(long) getShipOpponentShieldMax;
-(long) getShipHullMax;
-(long) getShipOpponentHullMax;

-(BOOL) doesNewsExist;
-(BOOL) doesHireExist;
-(BOOL) doesSpecialExist;
-(void) payForNewsPaper:(int)sum;

-(void) disableMusic;
-(void) enableMusic;
-(BOOL) isMusicEnabled;
-(void) disableSound;
-(void) enableSound;
-(BOOL) isSoundEnabled;

-(NSString*)getCurrentSystemStatus;
-(NSString*)drawNewspaperForm;
-(void) showSpecialEvent;
-(void) specialEventFormHandleEvent;
-(void) showRetiredForm;
-(void) clearHighScores;
-(void) fillHighScores:(NSMutableArray*)array;
-(BOOL) endOfGame:( char) EndStatus;

-(NSString*) drawQuestsForm;
-(void) initGlobals;
-(void) setInfoViewController:(SystemInfoViewController*)controller;
-(void) continuePlunder;
-(void) plunderItems:(int) index count:(int)count;

-(void) eraseAutoSave;
-(void) appendPilotLog: (NSString *)text;
-(void) eraseSaveFile: (NSString *)fileToBeRemoved;
-(void) updateFileNames;
-(NSString*)allSpecialEvents;
-(NSString*)allSystems;

-(void) makeDeposit:(long) dep;
-(void) makeWithDrawl:(long) dep;
-(void) disableLeftHandEncounter;
-(void) enableLeftHandEncounter;
-(void) cheatQuantumShield;
-(void) cheatTalbotLaser;
-(void) cheatFuelCompactor;

-(BOOL) canUpgradeShield;
-(BOOL) canUpgradeWeapon;
-(BOOL) canUpgradeHull;
-(BOOL) maxShieldUpgradePrice;
-(BOOL) maxWeaponUpgradePrice;
-(void) pirateUpgradeHull:(int)amount cost:(int)fee;
-(void) pirateUpgradeShield:(int)amount cost:(int)fee;
-(void) pirateUpgradeWeapon:(int)amount cost:(int)fee;

-(BOOL) isSpeechEnabled;
-(void) enableSpeech;
-(void) disableSpeech;
-(void) playSpeechFile: (NSString *)filename;
-(void) playSoundFile: (NSString *)filename;

-(void) showPassengers;
-(BOOL) okayToTransportPassengers;
-(int) getNumOfPassengers;
-(int) getPassengerPlanet;
-(void) passengersUsePEP;
-(BOOL) shipIsInfected;
-(void) showUserNotice:(int)mode;
-(void) cannotAffordNews;
-(BOOL) shouldListShip:(int)index;
-(BOOL) canBuyShip:(int)index controller:(BuyShipViewController *)controller;
-(void) showJumpStartGames:(NSMutableArray *)array name:(NSMutableArray *)name additional:(NSMutableArray *)additional;
-(void) loadJumpGame:(NSString *)name;
-(void) resetVisited;


@end
