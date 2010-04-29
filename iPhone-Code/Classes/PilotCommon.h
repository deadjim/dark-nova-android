// 
//  PilotCommon.h
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

typedef enum {
	ePickupCanister,
	ePlunderShip,
	ePickItUp,
	ePickFromShip
} ePlunderMode;

typedef enum  {
	eDummy,
	eSureToFleeOrBribeAlert,
	eTradeInOrbit,
	eSellInOrbit,
	eYieldChoice,
	eSurrenderArtifact,
	eSurrender,
	eBottleGood,
	eBottleStrange,
	eBoard,
	ePlunderForm,	//10
	eBribePropsal,
	eBribeOffer,
	eSubmit,
	eEngageCaptainAdamaAlert,
	eEngageCaptainBellowsAlert,
	eEngageCaptainLynnAlert,
	eBuyEquipment,
	eSpecialEvent,
	eBrowerWeaponBuy,
	ePlunderRemoveGoods,	//20
	eUpdateSpecial,
	ePlunderShipForm,
	ePickupPassengers,
	eBuyNewShip,
	eLiteVersionNotice
} eAlertState;


struct CommonGameOptions {
	int musicEnabled;
	int soundEnabled;
};
struct CommonGameOptions options;

eAlertState currentState;

#define DEFSEEDX 521288629
#define DEFSEEDY 362436069

static UInt32 SeedX = DEFSEEDX;
static UInt32 SeedY = DEFSEEDY;

UInt16 Rand() {
	const UInt16 a = 18000;
	const UInt16 b = 30903;
	
	SeedX = a*(SeedX&MAX_WORD) + (SeedX>>16);
	SeedY = b*(SeedY&MAX_WORD) + (SeedY>>16);
	
	return ((SeedX<<16) + (SeedY&MAX_WORD));
}

void RandSeed( UInt16 seed1, UInt16 seed2 ) {
	if (seed1)
		SeedX = seed1;
	else
		SeedX = DEFSEEDX;
	
	if (seed2)
		SeedY = seed2;
	else
		SeedY = DEFSEEDY;
}


int GetRandom2(int maxVal) {
	return (int)(Rand() % maxVal);	
}

NSString *DifficultyLevel[MAXDIFFICULTY] =
{
	@"Beginner",
	@"Easy",
	@"Normal",
	@"Hard",
	@"Impossible"
};

typedef struct HighScoreType {
	char Name[NAMELEN+1];
	Byte Status;
	int Days;
	long Worth;
	Byte Difficulty;
	Byte ForFutureUse;
} HIGHSCORE;

HIGHSCORE Hscores[MAXHIGHSCORE];

typedef struct {
	char* Name;
	Byte ReactionIllegal;   
	Byte StrengthPolice;	
	Byte StrengthPirates;	
	Byte StrengthTraders;	
	Byte MinTechLevel;      
	Byte MaxTechLevel; 		
	Byte BribeLevel;		
	Boolean DrugsOk;		
	Boolean FirearmsOk;		
	int Wanted;				
} POLITICS;

const POLITICS Politics[MAXPOLITICS] =
{
	{ "Anarchy",          0, 0, 7, 1, 0, 5, 7, TRUE,  TRUE,  FOOD },
	{ "Capitalist State", 2, 3, 2, 7, 4, 7, 1, TRUE,  TRUE,  ORE },
	{ "Communist State",  6, 6, 4, 4, 1, 5, 5, TRUE,  TRUE,  -1 },
	{ "Confederacy",      5, 4, 3, 5, 1, 6, 3, TRUE,  TRUE,  GAMES },
	{ "Corporate State",  2, 6, 2, 7, 4, 7, 2, TRUE,  TRUE,  ROBOTS },
	{ "Cybernetic State", 0, 7, 7, 5, 6, 7, 0, FALSE, FALSE, ORE },
	{ "Democracy",        4, 3, 2, 5, 3, 7, 2, TRUE,  TRUE,  GAMES },
	{ "Dictatorship",     3, 4, 5, 3, 0, 7, 2, TRUE,  TRUE,  -1 },
	{ "Fascist State",    7, 7, 7, 1, 4, 7, 0, FALSE, TRUE,  MACHINERY },
	{ "Feudal State",     1, 1, 6, 2, 0, 3, 6, TRUE,  TRUE,  FIREARMS },
	{ "Military State",   7, 7, 0, 6, 2, 7, 0, FALSE, TRUE,  ROBOTS },
	{ "Monarchy",         3, 4, 3, 4, 0, 5, 4, TRUE,  TRUE,  MEDICINE },
	{ "Pacifist State",   7, 2, 1, 5, 0, 3, 1, TRUE,  FALSE, -1 },
	{ "Socialist State",  4, 2, 5, 3, 0, 5, 6, TRUE,  TRUE,  -1 },
	{ "State of Satori",  0, 1, 1, 1, 0, 1, 0, FALSE, FALSE, -1 },
	{ "Technocracy",      1, 6, 3, 6, 4, 7, 2, TRUE,  TRUE,  WATER },
	{ "Theocracy",        5, 6, 1, 4, 0, 4, 0, TRUE,  TRUE,  NARCOTICS }
};

typedef struct {
	char* Name;
	int MinScore;
} POLICERECORD;


typedef struct {
	char* Name;
	int MinScore;
} REPUTATION;

const POLICERECORD PoliceRecord[MAXPOLICERECORD] =
{
	{ "Psycho",   -100 },
	{ "Villain",  PSYCHOPATHSCORE },
	{ "Criminal", VILLAINSCORE },
	{ "Crook",    CRIMINALSCORE },
	{ "Dubious",  DUBIOUSSCORE },
	{ "Clean",    CLEANSCORE },
	{ "Lawful",   LAWFULSCORE },
	{ "Trusted",  TRUSTEDSCORE },
	{ "Liked",    HELPERSCORE },
	{ "Hero",     HEROSCORE }
};

const REPUTATION Reputation[MAXREPUTATION] =
{
	{ "Harmless",        HARMLESSREP },
	{ "Mostly harmless", MOSTLYHARMLESSREP },
	{ "Poor",            POORREP },
	{ "Average",         AVERAGESCORE },
	{ "Above average",   ABOVEAVERAGESCORE },
	{ "Competent",       COMPETENTREP },
	{ "Dangerous",       DANGEROUSREP },
	{ "Deadly",          DEADLYREP },
	{ "Elite",           ELITESCORE } 
};

typedef struct {
	char* Name;
	Byte TechProduction; 	
	Byte TechUsage;			
	Byte TechTopProduction;	
	int PriceLowTech;		
	int PriceInc;			
	int Variance;			
	int DoublePriceStatus;	
	int CheapResource;		
	int ExpensiveResource; 
	int MinTradePrice;		
	int MaxTradePrice;		
	int RoundOff;		
} TRADEITEM;

const TRADEITEM Tradeitem[MAXTRADEITEM] =
{
	{ "Water",     0, 0, 2,   30,   +3,   4, DROUGHT,       LOTSOFWATER,    DESERT,        30,   50,   1 },
	{ "Food", 	  1, 0, 1,  100,   +5,   5, CROPFAILURE,   RICHSOIL,       POORSOIL,      90,  160,   5 },
	{ "Furs", 	  0, 0, 0,  250,  +10,  10, COLD,          RICHFAUNA,      LIFELESS,     230,  280,   5 },
	{ "Ore", 	  2, 2, 3,  350,  +20,  10, WAR,           MINERALRICH,    MINERALPOOR,  350,  420,  10 },
	{ "Games",     3, 1, 6,  250,  -10,   5, BOREDOM,       ARTISTIC,       -1,           160,  270,   5 },
	{ "Firearms",  3, 1, 5, 1250,  -75, 100, WAR,           WARLIKE,        -1,           600, 1100,  25 },
	{ "Medicine",  4, 1, 6,  650,  -20,  10, PLAGUE,        LOTSOFHERBS,    -1,           400,  700,  25 },
	{ "Machines",  4, 3, 5,  900,  -30,   5, LACKOFWORKERS, -1,             -1,           600,  800,  25 },
	{ "Narcotics", 5, 0, 5, 3500, -125, 150, BOREDOM,       WEIRDMUSHROOMS, -1,          2000, 3000,  50 },
	{ "Robots",    6, 4, 7, 5000, -150, 100, LACKOFWORKERS, -1,             -1,          3500, 5000, 100 }
};

typedef struct {
	char* Name;
	Byte CargoBays;		
	Byte WeaponSlots;	
	Byte ShieldSlots;	
	Byte GadgetSlots;	
	Byte CrewQuarters;	
	Byte FuelTanks;		
	Byte MinTechLevel;	
	Byte CostOfFuel;	
	long Price;			
	int Bounty;			
	int Occurrence;		
	long HullStrength;	
	int Police;			
	int Pirates;		
	int Traders;		
	Byte RepairCosts;	
	Byte Size;			
} SHIPTYPE;


const SHIPTYPE Shiptype[MAXSHIPTYPE+EXTRASHIPS] =
{ 
	{ "Nanite", 10, 0, 0, 0, 1,		MAXRANGE,	4,	1,		3000,	25, 2, 50, -1, -1, 0, 1, 0 },
	{ "Firefly", 15, 0, 1, 1, 1,	15,			5,	2,		7500,	50, 28, 75, 0, 0, 0, 1, 1 },
	{ "Stinger", 20, 1, 1, 1, 1,	17,			5,	3,		15000,  75, 20, 95, 0, 0, 0, 1, 1 },
	{ "Scorpion", 15, 2, 1, 1, 1,	14,			5,	5,		20000, 100, 20, 110, 0, 1, 0, 1, 1 },
	{ "Firespark", 25, 1, 2, 2, 2,	15,			5,	7,		40000, 125, 15, 135, 1, 1, 0, 1, 2 },
	{ "Ru'Transport", 60, 0, 2, 1, 3, 13,		5,	10,		60000, 150, 3, 100, -1, -1, 0, 1, 2 },
	{ "Hornet", 20, 3, 2, 1, 2,		15,			6,	15,		80000, 200, 6, 150, 2, 3, 1, 2, 3 },
	{ "Star Hopper", 40, 2, 2, 3, 3, 16,		6,	15,		120000, 300, 2, 175, 3, 4, 2, 3, 3 },
	{ "Prax-T", 60, 1, 3, 2, 3,		13,			7,	20,		175000, 400, 2, 200, 4, 5, 3, 4, 4 },
	{ "Dreadnought", 35, 3, 2, 2, 3, 15,		7,	20,		200000, 500, 2, 225, 5, 6, 4, 5, 4 },
	{ "Pirates", 0, 3, 0, 0, 1,	1,			8,	1,		500000, 0, 0, 500, 8, 8, 8, 1, 4 },
	{ "Dragonfly", 0, 2, 3, 2, 1, 1,		8,	1,		500000, 0, 0, 10, 8, 8, 8, 1, 1 },
	{ "Mantis", 0, 3, 1, 3, 3,		1,			8,	1,		500000, 0, 0, 300, 8, 8, 8, 1, 2 },
	{ "Scarab", 20, 2, 0, 0, 2,		1,			8,	1,		500000, 0, 0, 400, 8, 8, 8, 1, 3 },
	{ "Bottle", 0, 0, 0, 0, 0,		1,			8,	1,		100,	0, 0, 10, 8, 8, 8, 1, 1 }
};


const char * ShipImages[MAXSHIPTYPE+EXTRASHIPS] =
{
	"1-Ship128.png",
	"2-Ship128.png",
	"3-Ship128.png",
	"4-Ship128.png",
	"5-Ship128.png",
	"6-Ship128.png",
	"7-Ship128.png",
	"8-Ship128.png",
	"9-Ship128.png",
	"10-Ship128.png",
	"14-Ship128.png",
	"11-Ship128.png",
	"12-Ship128.png",
	"13-Ship128.png",
	"15-Bottle.png"
};

const char * ShipImagesBg[MAXSHIPTYPE+EXTRASHIPS] =
{
	"1-Ship128.png",
	"2-Ship128.png",
	"3-Ship128.png",
	"4-Ship128.png",
	"5-Ship128.png",
	"6-Ship128.png",
	"7-Ship128.png",
	"8-Ship128.png",
	"9-Ship128.png",
	"10-Ship128.png",
	"14-Ship128.png",
	"11-Ship128.png",
	"12-Ship128.png",
	"13-Ship128.png",
	"15-Bottle.png"
};


const char * ShipImagesDamaged[MAXSHIPTYPE+EXTRASHIPS] =
{
	"1-Ship128D.png",
	"2-Ship128D.png",
	"3-Ship128D.png",
	"4-Ship128D.png",
	"5-Ship128D.png",
	"6-Ship128D.png",
	"7-Ship128D.png",
	"8-Ship128D.png",
	"9-Ship128D.png",
	"10-Ship128D.png",
	"14-Ship128D.png",
	"11-Ship128D.png",
	"12-Ship128D.png",
	"13-Ship128D.png",
	"15-Bottle.png"
};

const char * ShipImagesShield[MAXSHIPTYPE+EXTRASHIPS] =
{
	"1-Ship128S.png",
	"2-Ship128S.png",
	"3-Ship128S.png",
	"4-Ship128S.png",
	"5-Ship128S.png",
	"6-Ship128S.png",
	"7-Ship128S.png",
	"8-Ship128S.png",
	"9-Ship128S.png",
	"10-Ship128S.png",
	"14-Ship128S.png",
	"11-Ship128S.png",
	"12-Ship128S.png",
	"13-Ship128S.png",
	"15-Bottle.png"
};


typedef struct {
	Byte NameIndex;
	Byte Pilot;
	Byte Fighter;
	Byte Trader;
	Byte Engineer;
	Byte CurSystem;
} CREWMEMBER;


char* MercenaryName[MAXCREWMEMBER] =
{
	"Donatello",
	"Magella",
	"Rafello",
	"Balmer",
	"Ippartus",
	"Jules Verona",
	"Amos Marco",
	"Orsted",
	"Romera",		
	"Galileo", //10
	"Hypogen",
	"Robbie Gerwitz",
	"Hubble",
	"Ms. Yest",
	"Astrid Flozer",
	"Techie Scott",
	"Chandra Camelion",
	"Sagan Man",
	"Einstein Helion",		
	"Jupiter Terra", //20
	"Gobos Moon",
	"Kometra",
	"Selena Badra",
	"Luna Trek",	
	"Mercury John",	
	"Sirius Vega",
	"Stella Astra",		
	"Calipson",
	"Miranda",
	"Gektor Julius", //30
	"Hera Primus"	
};


CREWMEMBER Mercenary[MAXCREWMEMBER + 1];

#pragma mark Define SpecialEvent
typedef struct {
	char* Title;
	char* QuestStringID;
	long Price;
	Byte Occurrence;
	Boolean JustAMessage;
} SPECIALEVENT;


SPECIALEVENT SpecialEvent[MAXSPECIALEVENT] =
{
	{ "Dragonfly Destroyed",	"QuestDragonflyDestroyedString",	0, 0, TRUE },
	{ "Weird Ship",				"QuestWeirdShipString",				0, 0, TRUE },
	{ "Quantum Ship",			"QuestQuantumShipString",			0, 0, TRUE },
	{ "Strange Ship",			"QuestStrangeShipString",			0, 0, TRUE },
	{ "Pirates Killed", 		"QuestPiratesKilledString",			-15000, 0, TRUE },
	{ "Medicine Delivery", 		"QuestMedicineDeliveredString",		0, 0, TRUE },
	{ "Retirement",     		"QuestRetirementString",			0, 0, FALSE },
	{ "Moon For Sale",  		"QuestMoonForSaleString",			COSTMOON, 4, FALSE },
	{ "Skill Increase", 		"QuestSkillIncreaseString",			3000, 6, FALSE },
	{ "Merchant Prince",		"QuestMerchantPrinceString",		1000, 2, FALSE },
	{ "Erase Record",   		"QuestEraseRecordString",			5000, 3, FALSE },
	{ "Tribble Buyer",  		"QuestTribbleBuyerString", 			0, 3, FALSE },
	{ "Band of Pirates",  		"QuestPirateBandString", 			0, 1, TRUE },
	{ "Dragonfly",      		"QuestDragonflyString", 			0, 1, TRUE },
	{ "Cargo For Sale", 		"QuestCargoForSaleString",			1000, 5, FALSE },
	{ "Quantum Shield", 		"QuestQuantumShieldString",			0, 0, FALSE },
	{ "Ja'pori Disease", 		"QuestJaporiDiseaseString", 		0, 1, FALSE },
	{ "Lottery Winner", 		"QuestLotteryWinnerString", 		-1000, 0, TRUE },
	{ "Artifact Delivery", 		"QuestArtifactDeliveryString",		-20000, 0, TRUE },
	{ "Alien Artifact", 		"QuestAlienArtifactString", 		0, 1, FALSE },
	{ "Transport: Mr. Jarek", 	"QuestAmbassadorJarekString",		0, 1, FALSE },
	{ "Alien Invasion",			"QuestAlienInvasionString",		 	0, 0, TRUE },
	{ "Gemulon Invaded", 		"QuestGemulonInvadedString", 		0, 0, TRUE },
	{ "Fuel Compactor", 		"QuestFuelCompactorString", 		0, 0, FALSE },
	{ "Dangerous Experiment",   "QuestDangerousExperimentString",	0, 0, TRUE },
	{ "Transport: Jack Brower",	"QuestJackBrowerString", 			0, 1, FALSE },
	{ "Deliver Ion Reactor",  	"QuestTalbotsReactorString",	 	0, 0, FALSE },
	{ "Install Talbot's Laser", "QuestInstallTalbotsLaserString",	0, 0, FALSE },
	{ "Scarab Stolen",			"QuestScarabStolenString",		 	0, 1, TRUE},
	{ "Upgrade Hull", 			"QuestUpgradeHullString", 			0, 0, FALSE},
	{ "Desperate Trader",		"QuestRyFleasTraderString", 		100, 2, FALSE },
	{ "Flea Exterminator",  	"QuestRyFleasExterminatorString", 	1000, 3, FALSE },
	{ "Scarab Destroyed",		"QuestScarabDestroyedString",	 	0, 0, TRUE},
	{ "Reactor Delivered",  	"QuestReactorDeliveredString", 		0, 0, TRUE },
	{ "Jarek Disembarks",		"QuestJarekArrivesString", 			0, 0, TRUE },
	{ "Gemulon Rescued", 		"QuestGemulonRescuedString",	 	0, 0, TRUE },
	{ "Disaster Averted",		"QuestDisasterAvertedString",		0, 0, TRUE },
	{ "Experiment Failed",		"QuestExperimentFailedString", 		0, 0, TRUE },
	{ "Brower Disembarks",		"QuestBrowerArrivesString",			0, 0, TRUE }

};


typedef struct {
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
	Boolean PirateHullUpgrade;
	long ForFutureUse[4];
} SHIP;

typedef struct  {
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
} SOLARSYSTEMSAVE;

typedef struct {
	char* Name;
	long  Price;
	Byte  TechLevel;
	Byte  Chance;
} GADGET;


typedef struct {
	char* Name;
	long  Power;
	long  Price;
	Byte  TechLevel;
	Byte  Chance;
} WEAPON;


typedef struct {
	char* Name;
	long  Power;
	long  Price;
	Byte  TechLevel;
	Byte  Chance;
} SHIELD;


const WEAPON Weapontype[MAXWEAPONTYPE+EXTRAWEAPONS] =
{
	{ "Pulse laser", PULSELASERPOWER, 2000, 5, 50 },
	{ "Beam laser", BEAMLASERPOWER, 12500, 6, 35 },
	{ "IM Tri-laser", MILITARYLASERPOWER, 35000, 7, 15 },
	{ "Pirate Pulse", PIRATEPULSEPOWER, 2000, 5, 0 },
	{ "Pirate Beam", PIRATEBEAMPOWER, 12500, 5, 0 },
	{ "Pirate Tri-laser", PIRATELASERPOWER, 35000, 5, 0 },
	{ "Talbot laser", TALBOTLASERPOWER, 65000, 8, 0 }
};

const SHIELD Shieldtype[MAXSHIELDTYPE+EXTRASHIELDS] =
{
	{ "Energy shield",      ESHIELDPOWER,  5000, 5, 70 },
	{ "Reflection shield",  RSHIELDPOWER, 20000, 6, 30 },
	{ "Pirate Energy",      PIRATEEPOWER,  5000, 5, 0 },
	{ "Pirate Reflection",  PIRATERPOWER, 20000, 5, 0 },
	{ "Quantum shield",   QSHIELDPOWER, 40000, 8, 0 }
};

const GADGET Gadgettype[MAXGADGETTYPE+EXTRAGADGETS] =
{
	{ "5 extra cargo bays", 	2500, 4, 35 }, 
	{ "Auto-repair system",     7500, 5, 20 }, 
	{ "Navigating system", 	   15000, 6, 20 }, 
	{ "Targeting system",	   25000, 6, 20 }, 
	{ "Cloaking device",      100000, 7, 5  }, 
	{ "Fuel compactor",        30000, 8, 0  }
};


SHIP SpaceMonster =
{ 
	MAXSHIPTYPE,                           
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },      
	{  2,  2,  2 },                        
	{ -1, -1, -1 }, { 0, 0, 0 },           
	{ -1, -1, -1 },                        
	{ MAXCREWMEMBER, -1, -1 },             
	1,                                     
	500,                                   
	0,                                     
	0,                                     
	0,                                     
	{ 0, 0, 0, 0 }                         
};

SHIP Scarab =
{ 
	MAXSHIPTYPE+3,                         
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },       
	{  2,  2,  -1 },                       
	{ -1, -1, -1 }, { 0, 0, 0 },           
	{ -1, -1, -1 },                        
	{ MAXCREWMEMBER, -1, -1 },             
	1,                                     
	400,                                   
	0,                                     
	0,                                     
	0,                                     
	{ 0, 0, 0, 0 }                         
};

SHIP Dragonfly =
{ 
	MAXSHIPTYPE+1,                         
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },       
	{  2,  0, -1 },                        
	{  QUANTUMSHIELD,  QUANTUMSHIELD,  QUANTUMSHIELD }, 
	{  QSHIELDPOWER,    QSHIELDPOWER,    QSHIELDPOWER },     
	{  AUTOREPAIRSYSTEM, TARGETINGSYSTEM, -1 }, 
	{  MAXCREWMEMBER, -1, -1 },             
	1,                                      
	10,                                     
	0,                                      
	0,										
	0,                                      
	{ 0, 0, 0, 0 }                          
};


const char* SpecialResources[MAXRESOURCES] =
{
	"Nothing special",
	"Mineral rich",
	"Mineral poor",
	"Desert",
	"Sweetwater oceans",
	"Rich soil",
	"Poor soil",
	"Rich fauna",
	"Lifeless",
	"Weird mushrooms",
	"Special herbs",
	"Artistic populace",
	"Warlike populace"
};


const char* Status[MAXSTATUS] =
{
	"under no particular pressure",			
	"at war",								
	"ravaged by a plague",					
	"suffering from a drought",				
	"suffering from extreme boredom",		
	"suffering from a cold spell",			
	"suffering from a crop failure",		
	"lacking enough workers"				
};


const char* Activity[MAXACTIVITY] =
{
	"Absent",
	"Minimal",
	"Few",
	"Some",
	"Moderate",
	"Many",
	"Abundant",
	"Swarms"
};

const char* SystemSize[MAXSIZE] =
{
	"Tiny",
	"Small",
	"Medium",
	"Large",
	"Huge"
};


const char* TechLevel[MAXTECHLEVEL] =
{
	"Pre-agricultural",
	"Agricultural",
	"Medieval",
	"Renaissance",
	"Early Industrial",
	"Industrial",
	"Post-industrial",
	"Hi-tech"
};

