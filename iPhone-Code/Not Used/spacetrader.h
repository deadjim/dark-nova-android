/***********************************************************************
 *
 * SPACE TRADER 1.2.0
 *
 * Spacetrader.h
 *
 * Copyright (C) 2000-2002 Pieter Spronck, All Rights Reserved
 *
 * Additional coding by Sam Anderson (rulez2@home.com)
 * Additional coding by Samuel Goldstein (palm@fogbound.net)
 *
 * Some code of Matt Lee's Dope Wars program has been used.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 * You can contact the author at space_trader@hotmail.com
 *
 * For those who are familiar with the classic game Elite: many of the
 * ideas in Space Trader are heavily inspired by Elite.
 *
 **********************************************************************/
//
// Space Trader Main Include 
//

#ifndef SPACETRADER_H
#define SPACETRADER_H
#define appFileCreator				'STra'
#define appVersionNum              	0x01
#define appPrefID                  	0x00
#define appPrefVersionNum          	0x01

// Special Enables                  // Comment these out to disable code
#define _STRA_CHEAT_                // Cheat Enable
#define _STRA_SHIPYARDCREDITS_      // Display Trade Credits in Ship Yard
#define _INCLUDE_DEBUG_DIALOGS_		// Include code for displaying Debug Alerts

// Add Ships, Weapons, Shields, and Gadgets that don't show up normally
#define EXTRAWEAPONS    1   // Number of weapons over standard
#define EXTRAGADGETS    1   // Number of Gadgets over standard
#define EXTRASHIELDS    1   // Number of Shields over standard
#define EXTRASHIPS      5   // Number of Ships over standard

// Tradeable items
#define MAXTRADEITEM   10   // Number of items traded 
#define MAXDIGITS       8   // Maximum amount of cash 99,999,999
#define MAXPRICEDIGITS  5   // Maximum price 99,999.
#define MAXQTYDIGITS    3   // Maximum quantity 999

// Activity level of police, traders or pirates
#define MAXACTIVITY     8
#define MAXSTATUS       8

// System status: normally this is uneventful, but sometimes a system has a 
// special event occurring. This influences some prices.
#define UNEVENTFUL      0
#define WAR             1
#define PLAGUE          2
#define DROUGHT         3
#define BOREDOM         4
#define COLD            5
#define CROPFAILURE     6
#define LACKOFWORKERS   7

// Difficulty levels
#define MAXDIFFICULTY   5
#define BEGINNER        0
#define EASY            1
#define NORMAL          2
#define HARD            3
#define IMPOSSIBLE      4

// Crewmembers. The commander is always the crewmember with index 0.
// Zeethibal is always the last
#define MAXCREWMEMBER  31

// Extra Crewmembers who won't be found randomly
#define MAXSKILL       10
#define NAMELEN        20

// Skills
#define PILOTSKILL		1
#define FIGHTERSKILL	2
#define TRADERSKILL		3
#define ENGINEERSKILL	4

// Tradeitems
#define WATER           0
#define FURS            1
#define FOOD            2
#define ORE             3
#define GAMES           4
#define FIREARMS        5
#define MEDICINE        6
#define MACHINERY       7
#define NARCOTICS       8
#define ROBOTS          9

// Ship types
#define MAXSHIPTYPE             10
#define MAXRANGE                20
#define MAXRANGEGALACTIC        60
#define MANTISTYPE     			MAXSHIPTYPE+2
#define SCARABTYPE				MAXSHIPTYPE+3
#define BOTTLETYPE	   			MAXSHIPTYPE+4

// Weapons
#define MAXWEAPONTYPE       3
#define PULSELASERWEAPON    0
#define PULSELASERPOWER    15
#define BEAMLASERWEAPON     1
#define BEAMLASERPOWER     25
#define MILITARYLASERWEAPON 2
#define MILITARYLASERPOWER 35
#define MORGANLASERWEAPON	3
#define MORGANLASERPOWER   85 // fixme!

// Shields
#define MAXSHIELDTYPE    2
#define ENERGYSHIELD     0
#define ESHIELDPOWER     100
#define REFLECTIVESHIELD 1
#define RSHIELDPOWER     200
#define LIGHTNINGSHIELD  2
#define LSHIELDPOWER     350

// Hull Upgrade
#define UPGRADEDHULL	 50

// Gadgets
#define MAXGADGETTYPE    5
#define EXTRABAYS        0
#define AUTOREPAIRSYSTEM 1
#define NAVIGATINGSYSTEM 2
#define TARGETINGSYSTEM  3
#define CLOAKINGDEVICE   4
#define FUELCOMPACTOR    5  // MAXGADGETTYPE + 1

// Skills
#define MAXSKILLTYPE     4
#define SKILLBONUS       3
#define CLOAKBONUS       2

// Police Action 
#define POLICE 0
#define POLICEINSPECTION 0 // Police asks to submit for inspection
#define POLICEIGNORE     1 // Police just ignores you
#define POLICEATTACK     2 // Police attacks you (sometimes on sight)
#define POLICEFLEE       3 // Police is fleeing
#define MAXPOLICE        9

// Pirate Actions
#define PIRATE 10
#define PIRATEATTACK    10 // Pirate attacks
#define PIRATEFLEE      11 // Pirate flees
#define PIRATEIGNORE    12 // Pirate ignores you (because of cloak)
#define PIRATESURRENDER 13 // Pirate surrenders
#define MAXPIRATE       19

// Trader Actions
#define TRADER          20
#define TRADERIGNORE    20 // Trader passes
#define TRADERFLEE      21 // Trader flees
#define TRADERATTACK    22 // Trader is attacking (after being provoked)
#define TRADERSURRENDER 23 // Trader surrenders 
#define TRADERSELL	    24 // Trader will sell products in orbit
#define TRADERBUY		25 // Trader will buy products in orbit
#define TRADERNOTRADE	26 // Player has declined to transact with Trader
#define MAXTRADER       29

// Space Monster Actions
#define SPACEMONSTERATTACK 30
#define SPACEMONSTERIGNORE 31
#define MAXSPACEMONSTER    39

// Dragonfly Actions
#define DRAGONFLYATTACK    40
#define DRAGONFLYIGNORE    41
#define MAXDRAGONFLY       49

#define MANTIS             50

// Scarab Actions
#define SCARABATTACK    60
#define SCARABIGNORE    61
#define MAXSCARAB       69

// Famous Captain
#define FAMOUSCAPTAIN	   			70
#define FAMOUSCAPATTACK    			71
#define CAPTAINAHABENCOUNTER		72
#define CAPTAINCONRADENCOUNTER		73
#define CAPTAINHUIEENCOUNTER		74
#define MAXFAMOUSCAPTAIN            79

// Other Special Encounters
#define MARIECELESTEENCOUNTER		80
#define BOTTLEOLDENCOUNTER          81
#define BOTTLEGOODENCOUNTER         82
#define POSTMARIEPOLICEENCOUNTER	83


// The commander's ship
#define MAXWEAPON         3
#define MAXSHIELD         3
#define MAXGADGET         3
#define MAXCREW           3
#define MAXTRIBBLES  100000

// Solar systems
#define MAXSOLARSYSTEM  120
#define ACAMARSYSTEM      0
#define BARATASSYSTEM     6
#define DALEDSYSTEM      17
#define DEVIDIASYSTEM    22
#define GEMULONSYSTEM    32
#define JAPORISYSTEM     41
#define KRAVATSYSTEM	 50
#define MELINASYSTEM     59
#define NIXSYSTEM		 67
#define OGSYSTEM         70
#define REGULASSYSTEM    82
#define SOLSYSTEM        92
#define UTOPIASYSTEM    109
#define ZALKONSYSTEM    118

// Special events
#define COSTMOON          500000L
#define MAXSPECIALEVENT        37
#define ENDFIXED                7
#define MAXTEXT                 9
#define DRAGONFLYDESTROYED      0
#define FLYBARATAS              1
#define FLYMELINA               2
#define FLYREGULAS              3
#define MONSTERKILLED           4
#define MEDICINEDELIVERY        5
#define MOONBOUGHT              6
// ----- fixed locations precede
#define MOONFORSALE             7
#define SKILLINCREASE           8
#define TRIBBLE                 9
#define ERASERECORD            10
#define BUYTRIBBLE             11
#define SPACEMONSTER           12
#define DRAGONFLY              13
#define CARGOFORSALE           14
#define INSTALLLIGHTNINGSHIELD 15
#define JAPORIDISEASE          16
#define LOTTERYWINNER          17
#define ARTIFACTDELIVERY       18
#define ALIENARTIFACT          19
#define AMBASSADORJAREK        20
#define ALIENINVASION          21
#define GEMULONINVADED         22
#define GETFUELCOMPACTOR       23
#define EXPERIMENT             24
#define TRANSPORTWILD          25
#define GETREACTOR			   26
#define GETSPECIALLASER        27
#define SCARAB			   28
#define GETHULLUPGRADED		   29
// ------ fixed locations follow
#define SCARABDESTROYED	   30
#define REACTORDELIVERED	   31
#define JAREKGETSOUT           32
#define GEMULONRESCUED         33
#define EXPERIMENTSTOPPED      34
#define EXPERIMENTNOTSTOPPED   35
#define WILDGETSOUT			   36

// Max Number of Tribble Buttons
#define TRIBBLESONSCREEN       31

// Other special events (Encounters)
// First is probability in 1000 that one could happen at all:
#define CHANCEOFVERYRAREENCOUNTER	5
#define MAXVERYRAREENCOUNTER		6
#define MARIECELESTE				0
#define CAPTAINAHAB					1
#define CAPTAINCONRAD				2
#define CAPTAINHUIE					3
#define BOTTLEOLD					4
#define BOTTLEGOOD				    5
// Already done this encounter?
#define ALREADYMARIE				1
#define ALREADYAHAB					2
#define ALREADYCONRAD				4
#define ALREADYHUIE					8
#define ALREADYBOTTLEOLD		   16
#define ALREADYBOTTLEGOOD          32

// Propability in 1000 that a trader will make offer while in orbit
#define CHANCEOFTRADEINORBIT		100

// Political systems (governments)
#define MAXPOLITICS  17
#define MAXSTRENGTH  8
#define ANARCHY      0

// Tech levels. 
#define MAXTECHLEVEL 8


// Cargo Dumping Codes. These identify the operation so we can reuse
// some of the Sell Cargo code.
// SELL is obvious, Dump is when in dock, Jettison is when in space.
#define SELLCARGO		1
#define	DUMPCARGO		2
#define JETTISONCARGO	3

// System sizes (influences the number of goods available)
#define MAXSIZE 5

// Newspaper Defines
// Newspaper Mastheads and Headlines have been moved into String Resources, where
// they belong. Mastheads starting with codes will have the codes replaced as follows:
// + -> System Name
// * -> The System Name
#define MAXMASTHEADS		3	// number of newspaper names per Political situation
#define MAXSTORIES			4 	// number of canned stories per Political situation
#define NEWSINDENT1			5	// pixels to indent 1st line of news story
#define NEWSINDENT2			5	// pixels to indent 2nd line of news story

#define STORYPROBABILITY	50/MAXTECHLEVEL	// probability of a story being shown
#define MAXSPECIALNEWSEVENTS		5		// maximum number of special news events to keep for a system

// News Events that don't exactly match special events
#define WILDARRESTED		   90
#define CAUGHTLITTERING		   91
#define EXPERIMENTPERFORMED	   92
#define ARRIVALVIASINGULARITY  93
#define CAPTAINHUIEATTACKED   100
#define CAPTAINCONRADATTACKED 101
#define CAPTAINAHABATTACKED   102
#define CAPTAINHUIEDESTROYED  110
#define CAPTAINCONRADDESTROYED 111
#define CAPTAINAHABDESTROYED  112


// Police record
#define MAXPOLICERECORD     10
#define ATTACKPOLICESCORE   -3
#define KILLPOLICESCORE     -6
#define CAUGHTWITHWILDSCORE	-4
#define ATTACKTRADERSCORE   -2
#define PLUNDERTRADERSCORE  -2
#define KILLTRADERSCORE     -4
#define ATTACKPIRATESCORE    0
#define KILLPIRATESCORE      1
#define PLUNDERPIRATESCORE  -1
#define TRAFFICKING         -1
#define FLEEFROMINSPECTION  -2
#define TAKEMARIENARCOTICS	-4

// Police Record Score
#define PSYCHOPATHSCORE -70
#define VILLAINSCORE    -30
#define CRIMINALSCORE   -10
#define DUBIOUSSCORE    -5
#define CLEANSCORE       0
#define LAWFULSCORE      5
#define TRUSTEDSCORE     10
#define HELPERSCORE      25
#define HEROSCORE        75

// Reputation (depends on number of kills)
#define MAXREPUTATION 9

#define HARMLESSREP          0
#define MOSTLYHARMLESSREP   10
#define POORREP             20
#define AVERAGESCORE        40
#define ABOVEAVERAGESCORE   80
#define COMPETENTREP       150
#define DANGEROUSREP       300
#define DEADLYREP          600
#define ELITESCORE        1500


// Debt Control
#define DEBTWARNING		 75000
#define DEBTTOOLARGE	100000

// Resources. Some systems have special resources, which influences some prices.
#define MAXRESOURCES 13

#define NOSPECIALRESOURCES 0
#define MINERALRICH 1
#define MINERALPOOR 2
#define DESERT 3
#define LOTSOFWATER 4
#define RICHSOIL 5
#define POORSOIL 6
#define RICHFAUNA 7
#define LIFELESS 8
#define WEIRDMUSHROOMS 9
#define LOTSOFHERBS 10
#define ARTISTIC 11
#define WARLIKE 12

// Wormholes
#define MAXWORMHOLE 6

#define GALAXYWIDTH	150
#define GALAXYHEIGHT 110
#define SHORTRANGEWIDTH 300
#define SHORTRANGEHEIGHT 300
#define SHORTRANGEBOUNDSX 10

#define GALAXYRANGEWIDTH 400
#define GALAXYRANGEHEIGHT 360
#define GALAXYRANGEBOUNDSX 10


#define BOUNDSX 5
#define BOUNDSY 20
#define GALAXYBOUNDSX 20
#define GALAXYBOUNDSY 50
#define MINDISTANCE 6
#define MINDISTANCEACTIVATE 30
#define CLOSEDISTANCE 13
#define WORMHOLEDISTANCE 3
#define EXTRAERASE 3
// (There are new functions for crunching down booleans and
//  nibbles, which gain us a little room...)
#define MAXFORFUTUREUSE 96

// this is in percentage, and will decrease by one every day.
#define FABRICRIPINITIALPROBABILITY 25

#define MAXHIGHSCORE 10
#define KILLED 0
#define RETIRED 1
#define MOON 2

// size of a UInt16
#define MAX_WORD 65535

// these have been added to avoid tracking down the math library.
#define min( a, b ) ( (a) <= (b) ? (a) : (b) )
#define max( a, b ) ( (a) >= (b) ? (a) : (b) )

long BaseSellPrice(int Index, int Price);

#define GetRandom( a ) (random()%(a))
#define TOLOWER( a ) ((a) >= 'A' && (a) <= 'Z' ? (a) - 'A' + 'a' : (a))
//#define ABS( a ) ((a) < 0 ? (-(a)) : (a))
#define SQR( a ) ((a) * (a))
//#define COMMANDER Mercenary[0]
#define CURSYSTEM solarSystem[currentSystem]
#define BASEWEAPONPRICE( a ) ([self BasePrice:Weapontype[a].TechLevel Price:Weapontype[a].Price])
#define BASESHIELDPRICE( a ) ([self BasePrice:Shieldtype[a].TechLevel Price:Shieldtype[a].Price])
#define BASEGADGETPRICE( a ) ([self BasePrice:Gadgettype[a].TechLevel Price:Gadgettype[a].Price])
#define BASESHIPPRICE( a ) (((Shiptype[a].Price * (100 - [self TraderSkill: &ship ])) / 100) /* * (Difficulty < 3 ? 1 : (Difficulty + 3)) / (Difficulty < 3 ? 1 : 5)*/)
#define WEAPONSELLPRICE( a ) (BaseSellPrice( ship.Weapon[a], Weapontype[ship.Weapon[a]].Price ))
#define SHIELDSELLPRICE( a ) (BaseSellPrice( ship.Shield[a], Shieldtype[ship.Shield[a]].Price ))
#define GADGETSELLPRICE( a ) (BaseSellPrice( ship.Gadget[a], Gadgettype[ship.Gadget[a]].Price ))
#define MERCENARYHIREPRICE( a ) (a < 0 || (a >= MAXCREWMEMBER && wildStatus == 2) ? 0 : ((Mercenary[a].Pilot + Mercenary[a].Fighter + Mercenary[a].Trader + Mercenary[a].Engineer) * 3))
#define ENCOUNTERPOLICE( a ) ((a) >= POLICE && (a) <= MAXPOLICE)
#define ENCOUNTERPIRATE( a ) ((a) >= PIRATE && (a) <= MAXPIRATE)
#define ENCOUNTERTRADER( a ) ((a) >= TRADER && (a) <= MAXTRADER)
#define ENCOUNTERMONSTER( a ) ((a) >= SPACEMONSTERATTACK && (a) <= MAXSPACEMONSTER)
#define ENCOUNTERDRAGONFLY( a ) ((a) >= DRAGONFLYATTACK && (a) <= MAXDRAGONFLY)
#define ENCOUNTERSCARAB( a ) ((a) >= SCARABATTACK && (a) <= MAXSCARAB)
#define ENCOUNTERFAMOUS( a )  ((a) >= FAMOUSCAPTAIN && (a) <= MAXFAMOUSCAPTAIN)
#define STRENGTHPOLICE( a ) (policeRecordScore < PSYCHOPATHSCORE ? 3 * Politics[solarSystem[a].Politics].StrengthPolice : (policeRecordScore < VILLAINSCORE ? 2 * Politics[solarSystem[a].Politics].StrengthPolice : Politics[solarSystem[a].Politics].StrengthPolice))
#define STARTCOUNTDOWN (3 + gameDifficulty)

#define BELOW50	(romVersion < sysMakeROMVersion( 5, 0, 0, sysROMStageRelease, 0 ))				



//	Resource: tSTR 1300
#define MainString                                1300	// "While you are docked at a system, you can use the menu to access functions to buy and sell cargo, equip"

//	Resource: tSTR 1400
#define NewCommanderString                        1400	// "In the New Commander screen you can set your name, and set skill values. There are four skil"

//	Resource: tSTR 1000
#define WarpString                                1000	// "Tap the system you wish to warp to. The game will show you what is known about that system, or the average price list for that system (depending on your preferences and what you viewed last). You can warp from that screen.  On "

//	Resource: tSTR 1100
#define ExecuteWarpString                         1100	// "This screen shows information on the system you have selected. If the system is reachable by a wormhole, it says so next to "Distance". To warp through a wormhole you"

//	Resource: tSTR 1200
#define GalacticChartString                       1200	// "Tapping a system on the gal"

//	Resource: tSTR 1500
#define SystemInformationString                   1500	// "This screen shows information on the system where you are currently docked. You can click on the News button to buy a newspaper, which will have headlines about local an"

//	Resource: tSTR 1600
#define ConfirmNewString                          1600	// "Starting a new game will erase all data on your current game."

//	Resource: tSTR 1700
#define MoreSkillPointsString                     1700	// "You have 20 skill points to divide over the four commander skills. You should award them all."

//	Resource: tSTR 1800
#define BuyCargoString                            1800	// "Use this screen to buy cargo. The leftmost column shows quantities"

//	Resource: tSTR 1900
#define SellCargoString                           1900	// "Use this screen to sell cargo. The leftmost column shows quantities you have stored in your cargo holds. The second column shows the name of the goods. If the name of the goods is in bold, it means you can sell these goods with a profit. The f"

//	Resource: tSTR 2000
//#define NothingAvailableString                    2000	// "On the Buy Cargo screen, the button to the left of the goods displays the amount available. If the amount is zero, none of these goods are available."

//	Resource: tSTR 2100
#define CantAffordString                          2100	// "At the bottom of the Buy Cargo scr"

//	Resource: tSTR 2200
#define NoEmptyBaysString                         2200	// "On the screen where you can get the cargo, you see the number of cargo bays that are full, a"

//	Resource: tSTR 2300
#define AmountToBuyString                         2300	// "Specify the amount to buy and tap th"

//	Resource: tSTR 2400
#define NothingForSaleString                      2400	// "On the Sell Cargo screen, the leftmost button shows the number of cargo bays you have which contain these goods. If that amount is zero, you can't sell anything."

//	Resource: tSTR 2500
#define AmountToSellString                        2500	// "If you are selling items,"

//	Resource: tSTR 2600
#define ShipYardString                            2600	// "At the Ship Yard, you can buy fuel, get your hull repaired, buy an escape pod, or even buy a new ship. When you buy a new ship, the total worth of your current ship (including equipment and cargo) is subtracted from the"

//	Resource: tSTR 2700
#define BuyFuelString                             2700	// "Enter the amount of credits you wish to spend on fuel and tap OK. If you tap Maximum, as much as needed for a full tank will be spent, up to your total amount of cash. If you tap Nothing, you won't buy fuel."

//	Resource: tSTR 2800
#define BuyRepairsString                          2800	// "Enter the amount of credits you wish to spend on repairs and tap OK. If you tap Maximum, as much as needed for full repairs will be spent, up to your total amount of cash. If you tap Nothing, you won't buy any repairs."

//	Resource: tSTR 2900
#define NotInterestedString                       2900	// "Notice that on the Sell Cargo screen, it says "no trade" next to these goods. This means that people aren't interested in buying them, either because of their political system, or because their tech level isn't high enough to make use of them."

//	Resource: tSTR 3000
#define BuyShipString                             3000	// "Information on a ship type you can get buy tapping the Info button to the right of it. Buy a new ship by tapping the corresponding Buy button. The price quoted for the ship takes into account the discount you get for trading in your current ship, inc"

//	Resource: tSTR 3100
#define TradeShipString                           3100	// "If you say Yes, you lose your current ship, including equipment and cargo, and get a brand new ship of the indicated type, without equipment and cargo."

//	Resource: tSTR 3200
#define TooManyCrewmembersString                  3200	// "The information on a ship will show how many crew quarters it has. If there are enough to hold your current crew, they will simply be transferred to the new ship. Otherwise you have to fire as many of them as needed, before you can buy a new ship."

//	Resource: tSTR 3300
#define ShiptypeInfoString                        3300	// "The Ship Information screen shows the specs of the selected ship type. You can return to the Buy Ship screen by tapping the button at the bottom of the screen. "

//	Resource: tSTR 3400
#define CantBuyShipString                         3400	// "The ship's price "

//	Resource: tSTR 3500
#define BuyEquipmentString                        3500	// "Tap the Buy button to the left of a piece of equipment to buy it for the price to the right of it. Note that each ship typ"

//	Resource: tSTR 3600
#define SellEquipmentString                       3600	// "To sell a piece of equipment for the price indicated to the right of it, tap the Sell button to the left of it."

//	Resource: tSTR 3700
//#define CantBuyItemString                         3700	// "If you can't pay the price mentioned to the right of an item, you can't get it. If you have "Reserve Money" checked in the Options menu, the game will reserve at least enough money to pay for insurance and mercenaries."

//	Resource: tSTR 3800
//#define NotEnoughSlotsString                      3800	// "F"

//	Resource: tSTR 3900
#define NoMoreOfItemString                        3900	// "Except for extra cargo bays, of the available gadgets you only need to buy one: a second one isn't of any use."

//	Resource: tSTR 4000
//#define ItemNotSoldString                         4000	// "Each item is only available in a system which has the technological development needed to produce it."

//	Resource: tSTR 4100
//#define CargoBaysFullString                       4100	// "First you need to sell some trade goods. When you have at least 5 empty bays, you can sell the extra cargo bays."

//	Resource: tSTR 4200
#define PersonnelRosterString                     4200	// "On the Personnel Roster screen, there are three areas. The upper two are reserved for mercenaries in your service. If you have hired someone, he or she is visible in one of these areas. To fire someone in your service, just tap the"

//	Resource: tSTR 4300
//#define NoFreeQuartersString                      4300	// "If you hire someone, you must give him or her quarters on your ship. Depending on the type of ship, you can hire zero, one or two mercenaries."

//	Resource: tSTR 4400
#define SpecialEventString                        4400	// "In a special meeting, you can do something unique to this system. Usually this is a special offer or an assignment.   If it is an offer you have to agree to, there are a Yes and a No button visible. Tap Ye"

//	Resource: tSTR 4500
#define NotEnoughForEventString                   4500	// "If you don't have"

//	Resource: tSTR 4600
//#define MustPayMercenariesString                  4600	// "You must pay your mercenaries daily, that is, before you warp to another system. If you don't have the cash, you must either sell something so you have enough cash, or fire the mercenaries you can't pay. Until then, warping is out of the question."

//	Resource: tSTR 4700
#define TribblesAteFoodString                     4700	// "Alas, tribbles are hungry and fast-multiplying animals. You shouldn't expect to be able to hold them out of your cargo bays. You should find a way to get rid of them."

//	Resource: tSTR 4800
#define YouHaveATribbleString                     4800	// "The merchant prince sold you a cute, furry tribble. You can see your new acquisition on the Commander Status screen."

//	Resource: tSTR 4900
#define BeamOverTribblesString                    4900	// "No more tribbles!"

//	Resource: tSTR 5000
#define SkillIncreaseString                       5000	// "On the Commander Status screen you can see your new skill values."

//	Resource: tSTR 5100
#define CleanRecordString                         5100	// "With a clean police record, the police will usually let you slip by without searching your ship. Also, if you were a criminal before, you can now sell you goods again for full prices."

//	Resource: tSTR 5200
#define CommanderStatusString                     5200	// "On the Commander Status screen you ca"

//	Resource: tSTR 5300
#define OptionsString                             5300	// ""Always ignore when it is safe" will fly past encounters where y"

//	Resource: tSTR 5400
#define AveragePricesString                       5400	// "This screen shows the average prices you get for goods in the "

//	Resource: tSTR 5500
#define BankString                                5500	// "At the bank you can get a loan, if you are really in need o"

//	Resource: tSTR 5600
//#define YoureInDebtString                         5600	// "Before you can buy a new ship or new equipment, you must settle your debts at the bank."

//	Resource: tSTR 5700
#define GetLoanString                             5700	// "As long as your debt is below the amount the bank is willing to lend you, you can get a loan up to that amount. There is a 10% interest to be paid each day, until you ha"

//	Resource: tSTR 5800
#define PayBackString                             5800	// "Pay back your loan by specifying an amount and tapping OK. You will never pay back more than your actual debt."

//	Resource: tSTR 5900
#define DebtTooHighString                         5900	// "You can't get a loan if your debt exceeds what the bank is willing to lend you."

//	Resource: tSTR 6000
#define NoDebtString                              6000	// "You don't need to pay back anything if you have no debts. Be happy."

//	Resource: tSTR 6100
#define EncounterString                           6100	// "When you encounter another ship, your and your opponent's stats are shown at the top of the encounter screen. When in pure text mode (you can set this in the Options menu), yo"

//	Resource: tSTR 6200
#define UneventfulTripString                      6200	// "Be glad you didn't encounter any pirates."

//	Resource: tSTR 6300
#define ArrivalString                             6300	// "Another trip you have survived."

//	Resource: tSTR 6400
//#define IllegalGoodsString                        6400	// "Firearms and narcotics are illegal goods, and you lose these. You are fined a percentage of your total worth. This is subtracted from your credits. If you don't have enough credits, it increases your debt."

//	Resource: tSTR 6500
//#define NoIllegalGoodsString                      6500	// "Firearms and narcotics are illegal goods. Since you don't carry these, the police have no problems with you."

//	Resource: tSTR 6600
#define BribeString                               6600	// "If the police officers can be bribed, it depends on the type of government of the target system how much"

//	Resource: tSTR 6700
//#define CantBeBribedString                        6700	// "Certain governments have such an incorruptible police force that you can't bribe them."

//	Resource: tSTR 6800
//#define NoMoneyForBribeString                     6800	// "You can only use your cash to pay a bribe; you can't trade your goods and you can't get a loan to pay the police off."

//	Resource: tSTR 6900
//#define PiratesPlunderString                      6900	// "The pirates steal from you what they can carry, but at least you get out of it alive."

//	Resource: tSTR 7000
//#define PiratesFindNoCargoString                  7000	// "If you have nothing in your cargo holds, th"

//	Resource: tSTR 7100
//#define BothDestroyedString                       7100	// "The game is over, alas."

//	Resource: tSTR 7200
//#define OpponentDestroyedString                   7200	// "You won the fight."

//	Resource: tSTR 7300
//#define ShipDestroyedString                       7300	// "The game is over, alas."

//	Resource: tSTR 7400
//#define YouEscapedString                          7400	// "You continue your flight towards the target system."

//	Resource: tSTR 7500
#define OpponentEscapedString                     7500	// "Your opponent has flown. You can't destroy him any longer, or try to plunder him."

//	Resource: tSTR 7600
#define RetireString                              7600	// "If you retire, the game ends. You sell your ship and everything on it, and remain in the current system for the rest of your days. If applicable, your total worth will be entered in the high score table."

//	Resource: tSTR 7700
#define BountyString                              7700	// "Destroying a pirate ship awards you bounty money. The height of the sum depends on the type of ship destroyed. The reward is automatically added to your cash."

//	Resource: tSTR 7800
#define PlunderString                             7800	// "You are allowed to plunder your opponent's cargo to your heart's content. Just steal whatever is to your liking. This works exactly as the Buy Cargo option when you are docked, except that you "

//	Resource: tSTR 7900
#define NotEnoughBaysString                       7900	// "You should sell enough goods so that you have enough empty cargo bays available."

//	Resource: tSTR 8000
#define AntidoteString                            8000	// "You can't use these ten cargo bays until you have visited the Japori system and delivered them there. Note that you can't even get rid of them by selling your ship."

//	Resource: tSTR 8100
#define LightningShieldString                     8100	// "The lightning shield is a shield with a lot more power than the u"

//	Resource: tSTR 8200
#define SealedCannistersString                    8200	// "On the Sell Cargo screen you can see what you bought."

//	Resource: tSTR 8300
#define AmountToPlunderString                     8300	// "You can steal the amount you like, as long as it fits in your cargo bays. Tap Maximum to get as much as possible. Tap Nothing to return to the Plunder screen."

//	Resource: tSTR 8400
#define VictimDoesntHaveAnyString                 8400	// "You can only steal what your victim actually has."

//	Resource: tSTR 8500
#define FindSystemString                          8500	// "Type in the name of the system you are looking for and click OK. The search is case insensitive. Selecting "Track this System" will cause a arrow to be shown in the Short Range chart, pointing in the direction of the system you are looking for."

//	Resource: tSTR 8600
#define NoFullTanksString                         8600	// "You have checked the automatic buying of full fuel tanks in the Options menu, but you don't have enough money to buy those tanks. Don't forget to buy them as soon as you have made some money."

//	Resource: tSTR 8700
#define NoFullRepairsString                       8700	// "You have automatic full hull repairs checked in the Options menu, but you don't have the money for that. If you still want the repairs, don't forget to make them before you leave the system."

//	Resource: tSTR 8800
#define NoFullTanksOrRepairsString                8800	// "In the Options menu you have indicated that you wish to buy full tanks and full hull repairs automatically when you arrive in a new system, but you don't have the money for that. At least make sure that you buy full tanks after you have made some money."

//	Resource: tSTR 8900
#define HighScoreString                           8900	// "Your score, calculated from the way you ended the game, your total worth, and the number of days you played, is entered automatically in the high score table when you qualify. You do NOT qualify if you laded a savegame while playing the game."

//	Resource: tSTR 9000
#define HighScoreTableString                      9000	// "This screen shows the high scores. The scoring percentage is calculated as follows: if you retired through the menu, your score is your total worth / 25000, minus 5%. If you got killed, your scor"

//	Resource: tSTR 9100
#define ClearTableString                          9100	// "If you clear the high score table, your next score is certain to get entered. It's a bit of a cowardly option, though."

//	Resource: tSTR 9200
#define HowToPlayString                           9200	// "Space Trader is a strategy game in which the ultimate goal is to make enough cash to buy your own mo"

//	Resource: tSTR 9300
#define TradingString                             9300	// "Trading is the safest way to make money. You trade by buying goods at one solar system, and sell them at another solar system. Of course, you should try to make a profit. There are several ways to ensure you can indee"

//	Resource: tSTR 9400
#define TravellingString                          9400	// "To travel to another system, go to the Short Range Chart. The system where you currently are is in the centre of the screen. The wide circle shows how far you can travel on your current fuel tanks. If t"

//	Resource: tSTR 9500
#define ShipEquipmentString                       9500	// "There are several types of ships available to you. You start out in a Gnat, which is the cheapest ship but one (the cheapest is the Flea, which is mainly used if you need to jump over a large distance, since it "

//	Resource: tSTR 9600
#define SkillsString                              9600	// "As a trader, you have need of several skills. You can set your skills on the New Commander screen at the start of the game.  The Pilot skill determines how well you fly your ship. Good pilots have an easier time escaping from a fight and dod"

//	Resource: tSTR 9800
#define AcknowledgementsString                    9800	// "This first version of "Space Trader" has been designed and programmed by me, Pieter Spronck, between July and September 2000. The game has been enhanced several times since then. It has been released as freeware un"

//	Resource: tSTR 9900
#define FirstStepsString                          9900	// "Here I will describe the steps you will undertake the first days as a trader:  You start by docking on some system. The specifics of that system are shown on the System Information screen. Take special "

//	Resource: tSTR 10000
#define EggString                                 10000	// "Look up your ship's equipment."

//	Resource: tSTR 10100
//#define NoWeaponsString                           10100	// "You either are flying a ship without any weapon slots, so your only option is to flee from fights, or you haven't bought any weapons yet. Sorry, no weapons, no attacking."

//	Resource: tSTR 10200
#define BuyEscapePodString                        10200	// "When your ship has an escape pod, when it is destroyed, you are automatically ejected from it and you will be picked up by the Space Corps after a few days and dropped on a nearby system. You w"

//	Resource: tSTR 10300
#define EscapePodActivatedString                  10300	// "You have lost your ship and cargo, but your and your crew's lives are saved. The Space Corps transports you to the space port of the system where you are currently located. Your crew is returned to their home systems."

//	Resource: tSTR 10400
//#define FleaBuiltString                           10400	// "Your ship has been destroyed, but luckily, you are clever enough to convert your pod into a Flea type of ship, so you can continue your journey, or trade it in for a better ship."

//	Resource: tSTR 10500
#define InsurancePaysString                       10500	// "The bank pays you the amount your ship was worth, including equipment but excluding the cargo. Note that this is the same amount as you would have got when you would have traded the ship in."

//	Resource: tSTR 10600
#define TribbleSurvivedString                     10600	// "Don't be too sad. They were incredibly annoying, weren't they?"

//	Resource: tSTR 10700
#define AntidoteDestroyedString                   10700	// "The antidote for the Japori system was destroyed with your ship. But they probably have some new antidote in the system where you originally got it."

//	Resource: tSTR 10800
#define NoEscapePodString                         10800	// "Insurance pays out when you must escape from your ship with an escape pod. Since you don't have a pod, you can't get insurance."

//	Resource: tSTR 10900
#define StopInsuranceString                       10900	// "If you stop your insurance, your no-claim will return to 0%, even if you buy new insurance immediately."

//	Resource: tSTR 11000
//#define CantPayInsuranceString                    11000	// "You can't leave if you haven't paid your insurance. If you have no way to pay, you should stop your insurance at the bank."

//	Resource: tSTR 11100
#define OutdatedSoftwareString                    11100	// "This version of the software is a beta version, and can't be used after a certain date. To get a the latest version, go to http://go.to/spacetrader."

//	Resource: tSTR 11200
#define PickCannisterString                       11200	// "Your scoops can pick up space debris. If you want the contents of this canister, and you have room in your cargo holds, you can pick it up. If you don't have room, you can dump cargo to make room."

//	Resource: tSTR 11300
#define CurrentShipString                         11300	// "This screen shows your current ship, including equipment. "

//	Resource: tSTR 11400
#define SellItemString                            11400	// "Selling an item will return to you about 75% of what you first paid for it. If you sell a ship as a whole, all items on it will automatically be sold."

//	Resource: tSTR 11500
//#define SureToFleeOrBribeString                   11500	// "Only when you are carrying illegal goods, the police will do something you don't like, so if you aren't carrying anything illegal, you usually should just submit, and not try to attack, flee or bribe."

//	Resource: tSTR 11600
#define SureToSubmitString                        11600	// "If you are carrying illegal goods and "

//	Resource: tSTR 11700
#define BuyItemString                             11700	// "Tap Yes if you want to buy the item in the title for the price mentioned."

//	Resource: tSTR 11800
#define QuestsString                              11800	// "This screen lists the quests you are currently on."

//	Resource: tSTR 11900
#define WormholeOutOfRangeString                  11900	// "The system that owns a wormhole is shown to the left of it. You must first fly to that system, and tap the wormhole from there."

//	Resource: tSTR 12000
//#define CantPayWormholeString                     12000	// "Wormhole tax must be paid when you want to warp through a wormhole. It depends on the type of your ship."

//	Resource: tSTR 12100
#define SpecificationString                       12100	// "These are the specifications of the costs you have to pay if you are going to warp to the selected target system."

//	Resource: tSTR 12200
#define SqueekString                              12200	// "This is a cute, furry tribble."

//	Resource: tSTR 12300
//#define TribblesAteNarcoticsString                12300	// "Tribbles ate your narcotics, and it killed most of them. At least the furs remained."

//	Resource: tSTR 12400
#define MoonBoughtString                          12400	// "What are you waiting for?"

//	Resource: tSTR 12500
#define ArtifactStolenString                      12500	// "The aliens have taken the artifact from you. Well, it's rightfully theirs, so you probably shouldn't complain. You won't receive any reward from professor Berger, though."

//	Resource: tSTR 12600
//#define ArtifactNotSavedString                    12600	// "You couldn't take the artifact with you in the escape pod, so now it's lost in the wreckage. The aliens will probably pick it up there."

//	Resource: tSTR 12700
#define ShipNotWorthMuchString                    12700	// "Normally you would receive about 75% of the worth of a new ship as trade-in value, but a tribble infested ship will give you only 25%. It is a way to get rid of your tribbles, though."

//	Resource: tSTR 12800
//#define AttackByAccidentString                    12800	// "If you attack the police, they know you are a die-hard criminal and will immediately label you as such."

//	Resource: tSTR 12900
#define AttackTraderString                        12900	// "While attacking a trader is not considered to be as bad as attacking the police (since no police is present, they cannot judge the exact circumstances of the attack), it will make the police suspicious of you."

//	Resource: tSTR 13000
//#define NoSurrenderString                         13000	// "If you are too big a criminal, surrender is NOT an option anymore."

//	Resource: tSTR 13100
//#define ArrestedString                            13100	// "At least you survived."

//	Resource: tSTR 13200
//#define AntidoteRemovedString                     13200	// "At least those poor people at Japori are assisted. You couldn't help them, what with being in prison 'n all."

//	Resource: tSTR 13300
//#define TribblesSoldString                        13300	// "At least you got rid of them."

//	Resource: tSTR 13400
//#define FleaReceivedString                        13400	// "It's standard practice for the police to leave a condemned criminal with at least the means to leave the solar system."

//	Resource: tSTR 13500
#define ConvictionString                          13500	// "Your fine and number of days in prison are based on the kind of criminal you were found to be."

//	Resource: tSTR 13600
#define ShipSoldString                            13600	// "The Space Corps needs cash to make you pay for the damages you did. Your ship is the only valuable possession you have."

//	Resource: tSTR 13700
//#define InsuranceLostString                       13700	// "Too bad. Your no-claim is reset too."

//	Resource: tSTR 13800
//#define MercenariesLeaveString                    13800	// "You can't pay your mercenaries while you are imprisoned, and so they have sought new employment."

//	Resource: tSTR 13900
#define WantToSurrenderString                     13900	// "Your fine and time in prison will depend on how big a criminal you are. Your fine will b"

//	Resource: tSTR 14000
//#define ImpoundString                             14000	// "What would you expect?"

//	Resource: tSTR 14100
//#define WantToSurrenderToAliensString             14100	// "The aliens are only after the artifact. They will let you live, and even let you keep your cargo, but you won't be able to finish your quest."

//	Resource: tSTR 14200
#define RetireDestroyedUtopiaString               14200	// "Tap anywhere on the screen to continue..."

//	Resource: tSTR 14300
#define NoQuartersForJarekString                  14300	// "To be able to take a passenger on board, you must have at least one empty set of crew quarters. That means you can't take a passenger on a ship with only one set of quarters, and if you have spare quarters, there can't be a mercenary living in them."

//	Resource: tSTR 14400
#define JarekNeedsQuartersString                  14400	// "There is room for a passenger on your current ship, but not on the ship you intend to buy."

//	Resource: tSTR 14500
#define JarekTakenHomeString                      14500	// "You can't deliver Jarek home yourself now."

//	Resource: tSTR 14600
#define JarekTakenOnBoardString                   14600	// "Your passenger uses one of your crew quarters, until you have delivered him to his destination."

//	Resource: tSTR 14700
#define QuestListString                           14700	// "This form lists where all the quests start."

//	Resource: tSTR 14800
#define FuelCompactorString                       14800	// "A fuel compactor allows you to fill up your tanks so you can travel 18 parsecs. You can't buy this anywhere, though you may sell it if you like. If you upgrade ships, you can pay to have the fuel compactor installed in your new ship."

//	Resource: tSTR 14900
//#define DebtWarningString                         14900	// "You get this warning because your debt has exceeded 75000 credits. If you don't pay back quickly, you may find yourself stuck in a system with no way to leave. You have been warned."

//	Resource: tSTR 15000
//#define DebtTooLargeForBuyString                  15000	// "Your debt has exceeded 100000 credits. You're in big trouble! You cannot buy any cargo. You should have heeded the warnings!"

//	Resource: tSTR 15100
//#define DebtTooLargeForTravelString               15100	// "Your ship has been chained to the station's dock. Your debt has increased to a point where you are no longer a trusted trader. You may not leave until you can reduce it to an acceptable level. You have been warned and should have listened.."

//	Resource: tSTR 15200
#define TransferFuelCompactorString               15200	// "For the sum of 20000 credits, you get to keep your unique fuel compa"

//	Resource: tSTR 15300
#define TransferLightningShieldString             15300	// "For the sum of 30000 credits, you get to keep your unique ligh"

//	Resource: tSTR 15400
#define FireMercenaryString                       15400	// "If you fire a mercenary, he or she returns to his or her home system."

//	Resource: tSTR 15600
#define LootMarieCelesteString                    15600	// "The Marie Cel"

//	Resource: tSTR 15900
//#define TradeCaptainAhabString                    15900	// "Captain Ahab is in need of a spare shield for an upcoming mission. Since he's in a rush, he'd rather not stop to get one on-planet.  The deal he's offering is a trade, rather than cash, for the shield. He'll trade y"

//	Resource: tSTR 16000
//#define TrainingString                            16000	// "Under the watchful eye of the Captain, you demonstrate your abilities. The Captain provides some helpful pointers and tips, and teaches you a few new techniques. The few hours pass quickly, but you feel you've gained a lot from the experience."

//	Resource: tSTR 16100
//#define TradeCaptainConradString                  16100	// "Captain "

//	Resource: tSTR 16200
//#define TradeCaptainHuieString                    16200	// "Captain Huie is in need of a military laser for an upcoming mission, but would rather hold onto her cash to buy her cargo.  The deal she's offering is a trade"

//	Resource: tSTR 16300
#define DrinkOldTonicString                       16300	// "Floating in orbit, you "

//	Resource: tSTR 16600
//#define DrankGoodSkillTonicString                 16600	// "Captain Marmoset's Amazing Skill Tonic goes down very smoothly. You feel a slight tingling in your fingertips. "

//	Resource: tSTR 16700
#define DrankOldSkillTonicString                  16700	// "Captain Marmoset's Amazing Skill Tonic tasted very strange, like slightly salty red wine. You feel a bit dizzy, and your teeth itch for a while. "

//	Resource: tSTR 16900
#define BuyPaperString                            16900	// "The local newspaper is a great way to find out what's going on in the area.  You may find out about shortages, wars, or other situations at nearby systems. Then again, some will tell you that "no news is good news.""

//	Resource: tSTR 17000
#define CantBuyNewspaperString                    17000	// "If you can't pay the price of a newspaper, you can't get it. If you have "Reserve Money" checked in the Options menu, the game will reserve at least enough money to pay for insurance and mercenaries."

//	Resource: tSTR 17100
#define DumpItemString                            17100	// "On the Dump Cargo screen, the leftmost button shows the number of cargo bays you have which contain these goods. If that amount is zero, you can't dump any."

//	Resource: tSTR 17200
#define Options2String                            17200	// ""Always pay for newspaper" will allow you to automatically pay when you click on the "News" button when viewing system information. If you leave this unchec"

//	Resource: tSTR 17300
#define DumpCargoString                           17300	// "Use this screen to jettison unwanted cargo. The leftmost column shows quantities you have stored in your cargo holds. T"

//	Resource: tSTR 17400
//#define WildArrestedString                        17400	// "Jonathan Wild is arrested, and taken off to prison."

//	Resource: tSTR 17600
#define WildSwitchesShipsString                   17600	// "Jonathan Wild figures that it's probably safer to get a ride home with his old associate than stay on your ship. After all, if you surrender to pirates, what's to stop you from surrendering to the police?"

//	Resource: tSTR 17700
#define WildStaysAboardString                     17700	// "Jonathan Wild would h"

////	Resource: tSTR 17900
#define WildLeavesString                          17900	// "Since Jonathan Wild is not willing to travel under these conditions, and you're not willing to change the situation, he leaves you and goes into hiding on this system."

//	Resource: tSTR 17800
//#define WildWontGoString                          17800	// "Jonathan Wild is being hunted by the police. They're serious about capturing him, and he doesn't wish to be captured. He'd rather take his chances hiding out on this system than facing swarms of police without any weapons."

//	Resource: tSTR 18000
//#define ReactorUsingFuelString                    18000	// "The Reactor was unstable to begin with. Now, it seems that it's rapidly consuming fuel. It is not clear what will happen if it runs out -- but you have no reason to suspect it will be anything good."

//	Resource: tSTR 18100
//#define ReactorSelfDestructString                 18100	// "The Reactor has undergone unplanned energetic self-disassembly."

//	Resource: tSTR 18200
#define ReactorOnBoardString                      18200	// "You can't use the five cargo bays containing the reactor until"

//	Resource: tSTR 18300
#define MorganLaserInstallString                  18300	// "Henry Morgan's Special Laser is a more powerful version of the Military laser. It uses advanced thermal coherence, which "

//	Resource: tSTR 18400
#define ReactorTakenString                        18400	// "The bad news is that you've lost the Ion Reactor. The good news is that you no longer have to worry about managing its depleting fuel store."

//	Resource: tSTR 18500
#define ReactorNotTakenString                     18500	// "The good news is that you still have the Ion Reactor. The bad news is that you still have to worry about managing its depleting fuel store."

//	Resource: tSTR 18600
#define CantTransferString                        18600	// "When trading ships, you will only be able to transfer an item from your old ship to the new ship if there is capacity for that item on the new ship,"

//	Resource: tSTR 18700
#define TransferMorgansLaserString                18700	// "For the sum of 33333 credits, you get to keep the laser given to you by"

//	Resource: tSTR 18800
#define CantTransferAllString                     18800	// "The ship's price takes into account the trade-in value of your current ship. You have to pay the remaining price, and the price of transferring your unique equipment, with y"

//	Resource: tSTR 18900
#define TribbleNoticeString                       18900	// "You might want to do something about those Tribbles..."

//	Resource: tSTR 19000
#define CantSellShipWithReactorString             19000	// "You can't sell your ship as long as you have an Ion Reactor on board. Deliver the Reactor to Nix, and then you'll be able to get a new ship."

//	Resource: tSTR 19100
#define IrradiatedTribblesString                  19100	// "Radiation poisoning seems particularly effective in killing Tribbles. Unfortunately, their fur falls out when they're irradiated, so you can't salvage anything to sell."

//	Resource: tSTR 19200
#define WildWontGoWithReactorString               19200	// "The Ion Reactor is known to be unstable, and Jonathan Wild is trying to get to safety. He's not willing to get on the ship while the Reactor's on board."

//	Resource: tSTR 19300
#define NewspaperHelpString                       19300	// "The local newspaper gives you information about what's happening on this and nearby systems. On higher-tech systems, you'll probably get better news about neighboring systems than you would on a low-tech system."

//	Resource: tSTR 19400
#define TrackSystemString                         19400	// "Tracking a system will modify the Sh"

//	Resource: tSTR 19500
#define DumpAllString                             19500	// "You"

//	Resource: tSTR 19600
#define FleePostMarieString                       19600	// "Even if you get away, the Customs Police know that you've engaged in criminal activity, and your police record will reflect this fact."

//	Resource: tSTR 19700
#define CustomsPoliceConfiscatedString            19700	// "The Customs Police took all the illegal goods from your ship, and sent you on your way. "

//	Resource: tSTR 30000
#define QuestDragonflyDestroyedString             30000	// "Hello, "

//	Resource: tSTR 30100
#define QuestLightningShipString                  30100	// "A ship with shields that seemed to be like lightning recently fought many other ships in our system. I have never seen anything like it before. After it left, I heard it went to the Regulas system."

//	Resource: tSTR 30200
#define QuestMonsterKilledString                  30200	// "We thank you for destroying the space monster that circled our system for so long. Please accept 15000 credits as reward for your heroic deed."

//	Resource: tSTR 30300
#define QuestRetirementString                     30300	// "Welcome to the Utopia system. Your own moon is available for you to retire to it, if you feel inclined to do that. Are you ready to retire and lead a happy, peaceful, and wealthy life?"

//	Resource: tSTR 30400
#define QuestSkillIncreaseString                  30400	// "An alien with a fast-learning machine offers to increase one of your skills for the reasonable sum of 3000 credits. You won't be able to pick that skill, though. Do you accept his offer?"

//	Resource: tSTR 30500
#define QuestEraseRecordString                    30500	// "A hacker conveys to you that he has cracked the passwords to the galaxy-wide police computer network, and that he can erase your police record for the sum of 5000 credits. Do you want him to do that?"

//	Resource: tSTR 30600
#define QuestSpaceMonsterString                   30600	// "A space monster has invaded the Acamar system and is disturbing the trade routes. You'll be rewarded handsomely if you manage to destroy it."

//	Resource: tSTR 30700
#define QuestCargoForSaleString                   30700	// "A trader in second-hand goods offers you 3 sealed cargo canisters for the sum of 1000 credits. It could be a good deal: they could contain robots. Then again, it might just be water. Do you want the canisters?"

//	Resource: tSTR 30800
#define QuestJaporiDiseaseString                  30800	// "A strange disease has invaded the Japori system. We would like you to deliver these ten canisters of special antidote to Japori. Note that, if you accept, ten of your cargo bays will remain in use on your way to Japori. Do you accept this mission?"

//	Resource: tSTR 30900
#define QuestArtifactDeliveryString               30900	// "This is professor Berger. I thank you for delivering the alien artifact to me. I hope the aliens weren't too much of a nuisance. I have transferred 20000 credits to your account, which I assume compensates for your troubles."

//	Resource: tSTR 31000
#define QuestAmbassadorJarekString                31000	// "A recent change in the political climate of this solar system has forced ambassador Jarek to flee back to his home system, Devidia. Would you be willing to give him a lift?"

//	Resource: tSTR 31100
#define QuestGemulonInvadedString                 31100	// "Alas, Gemulon has been invaded by aliens, which has thrown us back to pre-agricultural times. If only we had known the exact coordinates where they first arrived at our system, we might have prevented this tragedy from happening."

//	Resource: tSTR 31200
#define QuestDangerousExperimentString            31200	// "While reviewing the plans for Dr. Fehler's new space-warping drive, Dr. Lowenstam discovered a critical error. If you don't go to Daled and stop the experiment within ten days, the time-space continuum itself could be damaged!"

//	Resource: tSTR 31300
#define QuestMorgansReactorString                 31300	// "Galactic criminal Henry Morgan wants this illegal ion reac"

//	Resource: tSTR 31400
#define QuestScarabStolenString                   31400	// "Captain Renwick developed a new organic hull material for h"

//	Resource: tSTR 30050
#define QuestWeirdShipString                      30050	// "A small ship of a weird design docked here recently for repairs. The engineer who worked on it said that it had a weak hull, but incredibly strong shields. I heard it took off in the direction of the Melina system."

//	Resource: tSTR 30150
#define QuestStrangeShipString                    30150	// "A small ship with shields like I have never seen before was here a few days ago. It destroyed at least ten police ships! Last thing I heard was that it went to the Zalkon system."

//	Resource: tSTR 30250
#define QuestMedicineDeliveredString              30250	// "Thank you for delivering the medicine to us. We don't have any money to reward you, but we do have an alien fast-learning machine with which we will increase your skills."

//	Resource: tSTR 30350
#define QuestMoonForSaleString                    30350	// "There is a small but habitable moon for sale in the Utopia system, for the very reasonable sum of half a million credits. If you accept it, you can retire to it and live a peaceful, happy, and wealthy life. Do you wish to buy it?"

//	Resource: tSTR 30450
#define QuestMerchantPrinceString                 30450	// "A merchant prince offers you a very special and wondrous item for the sum of 1000 credits. Do you accept?"

//	Resource: tSTR 30550
#define QuestTribbleBuyerString                   30550	// "An eccentric alien billionaire wants to buy your collection of tribbles and offers half a credit for each of them. Do you accept his offer?"

//	Resource: tSTR 30650
#define QuestDragonflyString                      30650	// "This is colonel Jackson of the Space Corp"

//	Resource: tSTR 30750
#define QuestLightningShieldString                30750	// "Colonel Jackson here. Do you want us to install a lightning shield on your current ship?"

//	Resource: tSTR 30850
#define QuestLotteryWinnerString                  30850	// "You are lucky! While docking on the space port, you receive a message that you won 1000 credits in a lottery. The prize had been added to your account."

//	Resource: tSTR 30950
#define QuestAlienArtifactString                  30950	// "This alien artifact should be delivered to"

//	Resource: tSTR 31050
#define QuestAlienInvasionString                  31050	// "We received word that alie"

//	Resource: tSTR 31150
#define QuestFuelCompactorString                  31150	// "Do you wish us to install the fuel compactor on your current ship? (You need a free gadget slot)"

//	Resource: tSTR 31250
#define QuestJonathanWildString                   31250	// "Law Enforcement is closing in on notorious criminal kingpin Jonathan Wild. He would reward you handsomely for smuggling him home to Kravat. You'd have to avoid capture by the Police on the way. Are you willing to give him a berth?"

//	Resource: tSTR 31350
#define QuestInstallMorgansLaserString            31350	// "Morgan's technicians are standing by with something that looks a lot like a military laser -- if you ignore the additional cooling vents and anodized ducts. Do you want them to install Morgan's special laser?"

//	Resource: tSTR 31500
#define QuestScarabDestroyedString                31500	// "Space Corps is "

//	Resource: tSTR 31450
#define QuestUpgradeHullString                    31450	// "The organic hull used in the Scarab is still not ready for day-to-day use. But Captain Renwick can certainly upgrade your hull with some of his retrofit technology. It's light stuff, and won't reduce your ship's range. Should he upgrade your ship?"

//	Resource: tSTR 31600
#define QuestJarekGetsOutString                   31600	// "Ambassador Jarek is very grateful to you for delivering him back to Devidia. As a reward, he gives you an experimental handheld haggling computer, which allows you to gain larger discounts when purchasing goods and equipment."

//	Resource: tSTR 31550
#define QuestReactorDeliveredString               31550	// "Henry Mo"

//	Resource: tSTR 31700
#define QuestDisasterAvertedString                31700	// "Upon your warning, Dr. Fehler calls off "

//	Resource: tSTR 31650
#define QuestGemulonRescuedString                 31650	// "This in"

//	Resource: tSTR 31800
#define QuestWildGetsOutString                    31800	// "Jonathan Wild is most"

//	Resource: tSTR 31750
#define QuestExperimentFailedString               31750	// "Dr. Fehler can't understand why the experiment failed. But the failure has had a dramatic and disastrous effect on the fabric of space-time itself. It seems that Dr. Fehler won't be getting tenure any time soon... and you may have trouble when you warp!"

//	Resource: tSTR 19800
#define HullReinforcedString                      19800	// "Technicians spent the day replacing welds and bolts, and adding materials to your ship. When they're done, they tell you your ship should be significantly sturdier."

//	Resource: tSTR 19900
#define TradeInOrbitString                        19900	// "If you are selling items, specify the amount to sell an"

//	Resource: tSTR 9700
#define MarieCantBribeString                      9700	// "Certain governments have such an incorruptible police force that you can't bribe them. Other times, the police are corruptible, but their supervisors know what's going on, so they won't risk it."

//	Resource: tSTR 20000
#define AttackGreatCaptainString                  20000	// "You grew up on stories of the adventures of the Great Captains. You heard how they explored the galaxy, invented technologies ... and destroyed man, many pirates and villains in combat. Are you sure you want to attack one of these greats?"

//	Resource: tSTR 15500
#define ErrGraphicsSupportString                  15500	// "There are four versions of Space Trader:  1) SpaceTr"

//	Resource: tSTR 15700
#define CreditsString                             15700	// "Space Trader  Copyright � 2000-2002 by Pieter Spron"

//	Resource: tSTR 20100
#define LoanReminderString                        20100	// "The Bank Officer will contact you every five days to remind you of your debt. You can turn off these warnings on the second page of Game Options."

//	Resource: tSTR 20200
#define SingularityString                         20200	// "To use the Portable Singularity in the Galactic Chart, select your destination system by tracking it, then Jump by clicking  the "J" button. Voila! You will travel through the Singularity and arrive instananeously at your destination."

//	Resource: tSTR 15800
#define NoDumpNoScoopString                       15800	// "If you wanted to pick up the floating canister, you had to dump something from your cargo holds."

//	Resource: tSTR 16400
#define CannotSaveString                          16400	// "There was an error trying to create the savegame file. This may be due to a lack of system resources."

//	Resource: tSTR 16500
#define CannotLoadString                          16500	// "No savegame file was found to load. You must first create a savegame file with the menu choice "Save game"."

//	Resource: tSTR 16800
#define ReallyLoadString                          16800	// "Loading a savegame will remove your current game from memory and restore an earlier situation."

//	Resource: tSTR 17500
#define DisableScoringString                      17500	// "Only a game played without loading previously saved games will be taken into account for the high score table. So you can load a game, but you won't score anymore, until you start a new game."

//	Resource: tSTR 20300
#define GameSavedString                           20300	// "Snapshots are meant"

//	Resource: tSTR 20400
#define ShortcutPrefsString                       20400	// "On this page you can set your preferences for the rectangularshortcut buttons used when you're in the dock.  Use the pulldowns to assign the function to each navigation button. Shortcut 1 is the leftmost shortcut, while Shortcut 4 is the rightmost."

//	Resource: tSTR 20500
#define SpaceLitteringString                      20500	// "Space litterers will at least be considered dubious. If you are already a dubious character, space littering will only add to your list of offences. However, the police must of course be able to track the litter to you, which they often are not."

//	Resource: tSTR 20600
#define SwitchGameString                          20600	// "You can play two parallel games of Space Trader on your Palm. You switch between them by using the "Switch Game" option. This allows you to try two different styles"

//	Resource: tSTR 20700
#define CannotSwitchString                        20700	// "Switching to a parallel game failed. This is usually due to a lack of space on your Palm."

//	Resource: tSTR 20800
#define SwitchedString                            20800	// "A parallel game has been loaded. You can switch back to the previous game by using the option "Switch Game" again."

//	Resource: tSTR 20900
#define SwitchToNewString                         20900	// "You can play two parallel games on a Palm. You can switch between them with the "Switch Game" function. You best give the commander in each of the games a different name, which makes it easier to recognize them."

//	Resource: tSTR 21000
#define HelpOnMenuString                          21000	// "The menu consists of"

//	Resource: tSTR 21100
#define IdentifyStartupString                     21100	// "This information box shows the name of the commander playing the current game. This is useful if two switched games are played in parallel. You can turn this notification off in the Options."

//	Resource: tSTR 21200
#define RectangularButtonsOnString                21200	// "Space Trader by default uses rectangular buttons for shortcuts and on several screens. Before the release of Palm OS 5.0 it was possible to change the frame of a button from rounded into rectangular by directly acce"

//	Resource: tSTR 21300
#define AttemptRectangularString                  21300	// "After you leave the Options, if the current game screen shown contains buttons that normally are rectangular, the change will be visible when you leave the screen and come back to it later."

//	Resource: tSTR 21400
#define NoJumpToCurSystemString                   21400	// "Track another system than the one where you are currently are located, then tap the Singularity button to jump."



#define __SPACETRADER_INC__
#endif

// Always include DataTypes after all maximum definitions have occured.

//#include "DataTypes.h"  // Structure Definitions
//#include "Prototype.h"  // Function Prototypes
