//  
//  GameDefines.h
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


#define EXTRAWEAPONS    4   
#define EXTRAGADGETS    1   
#define EXTRASHIELDS    3   
#define EXTRASHIPS      5   

#define MAXTRADEITEM   10   
#define MAXACTIVITY     8
#define MAXSTATUS       8

#define UNEVENTFUL      0
#define WAR             1
#define PLAGUE          2
#define DROUGHT         3
#define BOREDOM         4
#define COLD            5
#define CROPFAILURE     6
#define LACKOFWORKERS   7
#define MAXDIFFICULTY   5
#define BEGINNER        0
#define EASY            1
#define NORMAL          2
#define HARD            3
#define IMPOSSIBLE      4
#define MAXCREWMEMBER  31
#define MAXSKILL       10
#define NAMELEN        20
#define LOGLEN		   750
#define PILOTSKILL		1
#define FIGHTERSKILL	2
#define TRADERSKILL		3
#define ENGINEERSKILL	4
#define WATER           0
#define FOOD            1
#define FURS            2
#define ORE             3
#define GAMES           4
#define FIREARMS        5
#define MEDICINE        6
#define MACHINERY       7
#define NARCOTICS       8
#define ROBOTS          9

#define MAXSHIPTYPE             10
#define MAXRANGE                20
#define MANTISTYPE     			MAXSHIPTYPE+2
#define SCARABTYPE				MAXSHIPTYPE+3
#define BOTTLETYPE	   			MAXSHIPTYPE+4

#define MAXWEAPONTYPE       3
#define PULSELASERWEAPON    0
#define PULSELASERPOWER    15
#define BEAMLASERWEAPON     1
#define BEAMLASERPOWER     25
#define MILITARYLASERWEAPON 2
#define MILITARYLASERPOWER 35
#define PIRATEPULSEWEAPON	3
#define PIRATEPULSEPOWER   19
#define PIRATEBEAMWEAPON	4
#define PIRATEBEAMPOWER    31
#define PIRATELASERWEAPON	5
#define PIRATELASERPOWER   44
#define TALBOTLASERWEAPON	6
#define TALBOTLASERPOWER   85
#define MAXSHIELDTYPE    2
#define ENERGYSHIELD     0
#define ESHIELDPOWER     100
#define REFLECTIVESHIELD 1
#define RSHIELDPOWER     200
#define PIRATEENERGY     2
#define PIRATEEPOWER     125
#define PIRATEREFLECTIVE 3
#define PIRATERPOWER     250
#define QUANTUMSHIELD	 4
#define QSHIELDPOWER     350
#define UPGRADEDHULL	 50
#define MAXGADGETTYPE    5
#define EXTRABAYS        0
#define AUTOREPAIRSYSTEM 1
#define NAVIGATINGSYSTEM 2
#define TARGETINGSYSTEM  3
#define CLOAKINGDEVICE   4
#define FUELCOMPACTOR    5
#define MAXSKILLTYPE     4
#define SKILLBONUS       3
#define CLOAKBONUS       2
#define POLICE	0
#define POLICEINSPECTION 0 
#define POLICEIGNORE     1
#define POLICEATTACK     2 
#define POLICEFLEE       3 
#define MAXPOLICE        9
#define PIRATE	10
#define PIRATEATTACK    10 
#define PIRATEFLEE      11 
#define PIRATEIGNORE    12 
#define PIRATESURRENDER 13 
#define MAXPIRATE       19
#define TRADER	20
#define TRADERIGNORE    20 
#define TRADERFLEE      21 
#define TRADERATTACK    22 
#define TRADERSURRENDER 23  
#define TRADERSELL	    24 
#define TRADERBUY		25 
#define TRADERNOTRADE	26 
#define MAXTRADER       29
#define SPACEMONSTERATTACK 30
#define SPACEMONSTERIGNORE 31
#define MAXSPACEMONSTER    39
#define DRAGONFLYATTACK    40
#define DRAGONFLYIGNORE    41
#define MAXDRAGONFLY       49
#define MANTIS             50
#define SCARABATTACK    60
#define SCARABIGNORE    61
#define MAXSCARAB       69

#define FAMOUSCAPTAIN	   			70
#define FAMOUSCAPATTACK    			71
#define CAPTAINADAMAENCOUNTER		72
#define CAPTAINBELLOWSENCOUNTER		73
#define CAPTAINLYNNENCOUNTER		74
#define MAXFAMOUSCAPTAIN            79
#define MARYCOCHRANENCOUNTER		80
#define BOTTLEOLDENCOUNTER          81
#define BOTTLEGOODENCOUNTER         82
#define POSTMARYPOLICEENCOUNTER	83
#define MAXWEAPON         3
#define MAXSHIELD         3
#define MAXGADGET         3
#define MAXCREW           3
#define MAXTRIBBLES  100000
#define TRANSPORTFEE    300			
#define RESCUEFEE		150			
#define BAYSPERPASSNGR    3
#define TRIPDISTANCE     15
#define MAXSOLARSYSTEM  126
#define ACAMARSYSTEM      0
#define BARATASSYSTEM     7
#define DALEDSYSTEM      18
#define DEVIDIASYSTEM    24
#define GEMULONSYSTEM    35
#define JAPORISYSTEM     44
#define KRAVATSYSTEM	 54
#define MELINASYSTEM     63
#define NIXSYSTEM		 71
#define OPOLISYSTEM      77
#define REGULASSYSTEM    88
#define SLOAKISSSYSTEM   96	
#define UTOPIASYSTEM    115
#define ZORKONSYSTEM    124

#define COSTMOON          500000L
#define MAXSPECIALEVENT        39
#define ENDFIXED                7
#define MAXTEXT                 9
#define DRAGONFLYDESTROYED      0
#define FLYBARATAS              1
#define FLYMELINA               2
#define FLYREGULAS              3
#define MONSTERKILLED           4
#define MEDICINEDELIVERY        5
#define MOONBOUGHT              6
#define MOONFORSALE             7
#define SKILLINCREASE           8
#define TRIBBLE                 9
#define ERASERECORD            10
#define BUYTRIBBLE             11
#define SPACEMONSTER           12
#define DRAGONFLY              13
#define CARGOFORSALE           14
#define INSTALLQUANTUMSHIELD   15
#define JAPORIDISEASE          16
#define LOTTERYWINNER          17
#define ARTIFACTDELIVERY       18
#define ALIENARTIFACT          19
#define AMBASSADORJAREK        20
#define ALIENINVASION          21
#define GEMULONINVADED         22
#define GETFUELCOMPACTOR       23
#define EXPERIMENT             24
#define TRANSPORTBROWER        25
#define GETREACTOR			   26
#define GETSPECIALLASER        27
#define SCARAB				   28
#define GETHULLUPGRADED		   29
#define RYFLEAS                30
#define EXTRYFLEAS             31
#define SCARABDESTROYED		   32
#define REACTORDELIVERED	   33
#define JAREKARRIVES           34
#define GEMULONRESCUED         35
#define EXPERIMENTSTOPPED      36
#define EXPERIMENTNOTSTOPPED   37
#define BROWERARRIVES		   38
#define CHANCEOFVERYRAREENCOUNTER	5
#define MAXVERYRAREENCOUNTER		6
#define MARYCOCHRAN					0
#define CAPTAINADAMA				1
#define CAPTAINBELLOWS				2
#define CAPTAINLYNN					3
#define BOTTLEOLD					4
#define BOTTLEGOOD				    5
#define ALREADYMARY					1
#define ALREADYADAMA				2
#define ALREADYBELLOWS				4
#define ALREADYLYNN					8
#define ALREADYBOTTLEOLD		   16
#define ALREADYBOTTLEGOOD          32
#define CHANCEOFTRADEINORBIT		100

#define MAXPOLITICS  17
#define MAXSTRENGTH  8
#define ANARCHY      0
#define MAXTECHLEVEL 8
#define SELLCARGO		1
#define	DUMPCARGO		2
#define JETTISONCARGO	3
#define MAXSIZE 5
#define STORYPROBABILITY	50/MAXTECHLEVEL
#define MAXSPECIALNEWSEVENTS		5
#define BROWERARRESTED				90
#define CAUGHTLITTERING				91
#define EXPERIMENTPERFORMED			92
#define ARRIVALVIASINGULARITY		93
#define CAPTAINLYNNATTACKED			100
#define CAPTAINBELLOWSATTACKED		101
#define CAPTAINADAMAATTACKED		102
#define CAPTAINLYNNDESTROYED		110
#define CAPTAINBELLOWSDESTROYED		111
#define CAPTAINADAMADESTROYED		112

#define MAXPOLICERECORD     10
#define ATTACKPOLICESCORE   -3
#define KILLPOLICESCORE     -6
#define CAUGHTWITHBROWERSCORE	-4
#define ATTACKTRADERSCORE   -2
#define PLUNDERTRADERSCORE  -2
#define KILLTRADERSCORE     -4
#define ATTACKPIRATESCORE    0
#define KILLPIRATESCORE      1
#define PLUNDERPIRATESCORE  -1
#define TRAFFICKING         -1
#define FLEEFROMINSPECTION  -2
#define TAKEMARYNARCOTICS	-4

#define PSYCHOPATHSCORE -70
#define VILLAINSCORE    -30
#define CRIMINALSCORE   -10
#define DUBIOUSSCORE    -5
#define CLEANSCORE       0
#define LAWFULSCORE      5
#define TRUSTEDSCORE     10
#define HELPERSCORE      25
#define HEROSCORE        75

#define UNTRUSTTRANS    -2
#define DUBIOUSTRANS    -1
#define CLEANTRANS       0
#define LAWFULTRANS      1
#define TRUSTEDTRANS     2
#define HELPFULTRANS     3
#define ULTIMATETRANS    4

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

#define DEBTWARNING		 75000
#define DEBTTOOLARGE	100000
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

#define MAXWORMHOLE 6

#define GALAXYWIDTH	150
#define GALAXYHEIGHT 110
#define SHORTRANGEWIDTH 300
#define SHORTRANGEHEIGHT 300
#define SHORTRANGEBOUNDSX 10
#define BOUNDSY 20
#define GALAXYBOUNDSX 20
#define GALAXYBOUNDSY 52
#define MINDISTANCE 6
#define MINDISTANCEACTIVATE 30
#define CLOSEDISTANCE 13
#define WORMHOLEDISTANCE 3
#define EXTRAERASE 3
#define MAXFORFUTUREUSE 96
#define FABRICRIPINITIALPROBABILITY 25

#define MAXHIGHSCORE 10
#define KILLED 0
#define RETIRED 1
#define MOON 2

#define MAX_WORD 65535

#define SQR( a ) ((a) * (a))
#define min( a, b ) ( (a) <= (b) ? (a) : (b) )
#define max( a, b ) ( (a) >= (b) ? (a) : (b) )
#define GetRandom( a ) (arc4random()%(a))

long BaseSellPrice(int Index, int Price);
#define CURSYSTEM solarSystem[currentSystem]
#define BASEWEAPONPRICE( a ) ([self BasePrice:Weapontype[a].TechLevel Price:Weapontype[a].Price])
#define BASESHIELDPRICE( a ) ([self BasePrice:Shieldtype[a].TechLevel Price:Shieldtype[a].Price])
#define BASEGADGETPRICE( a ) ([self BasePrice:Gadgettype[a].TechLevel Price:Gadgettype[a].Price])
#define BASESHIPPRICE( a ) (((Shiptype[a].Price * (100 - [self TraderSkill: &ship ])) / 100))
#define WEAPONSELLPRICE( a ) (BaseSellPrice( ship.Weapon[a], Weapontype[ship.Weapon[a]].Price ))
#define SHIELDSELLPRICE( a ) (BaseSellPrice( ship.Shield[a], Shieldtype[ship.Shield[a]].Price ))
#define GADGETSELLPRICE( a ) (BaseSellPrice( ship.Gadget[a], Gadgettype[ship.Gadget[a]].Price ))
#define MERCENARYHIREPRICE( a ) (a < 0 || (a == (MAXCREWMEMBER-1) && browerStatus == 2) ? 0 : ((Mercenary[a].Pilot + Mercenary[a].Fighter + Mercenary[a].Trader + Mercenary[a].Engineer) * 3))
#define ENCOUNTERPOLICE( a ) ((a) >= POLICE && (a) <= MAXPOLICE)
#define ENCOUNTERPIRATE( a ) ((a) >= PIRATE && (a) <= MAXPIRATE)
#define ENCOUNTERTRADER( a ) ((a) >= TRADER && (a) <= MAXTRADER)
#define ENCOUNTERMONSTER( a ) ((a) >= SPACEMONSTERATTACK && (a) <= MAXSPACEMONSTER)
#define ENCOUNTERDRAGONFLY( a ) ((a) >= DRAGONFLYATTACK && (a) <= MAXDRAGONFLY)
#define ENCOUNTERSCARAB( a ) ((a) >= SCARABATTACK && (a) <= MAXSCARAB)
#define ENCOUNTERFAMOUS( a )  ((a) >= FAMOUSCAPTAIN && (a) <= MAXFAMOUSCAPTAIN)
#define STRENGTHPOLICE( a ) (policeRecordScore < PSYCHOPATHSCORE ? 3 * Politics[solarSystem[a].Politics].StrengthPolice : (policeRecordScore < VILLAINSCORE ? 2 * Politics[solarSystem[a].Politics].StrengthPolice : Politics[solarSystem[a].Politics].StrengthPolice))
#define STARTCOUNTDOWN (3 + gameDifficulty)

