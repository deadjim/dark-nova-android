package com.example;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

public class Globala extends Activity
{  
	
	
	public static void initialize()
	{
		
	    ShipImages[0]="nanomite";
	    ShipImages[1]="minox";
	    ShipImages[2]="spathiScout";
	    ShipImages[3]="t16Womprat";
	    ShipImages[4]="vorchan";
	    ShipImages[5]="hirogenfreighter";
	    ShipImages[6]="vorlonCruiser";
	    ShipImages[7]="yt1300";
	    ShipImages[8]="tkharuberhauler";
	    ShipImages[9]="vixdreadnaught";
	    ShipImages[10]="leviathon";
	    ShipImages[11]="korahMenace";
	    ShipImages[12]="mantis";
	    ShipImages[13]="scarab";
	    ShipImages[14]="bottle";
		

		ShipImagesBg[0] ="nanomitebg";
		ShipImagesBg[1] ="minoxbg";
		ShipImagesBg[2] ="spathiScoutbg";
		ShipImagesBg[3] ="t16Wompratbg";
		ShipImagesBg[4] ="vorchanbg";
		ShipImagesBg[5] ="hirogenFreighterbg";
		ShipImagesBg[6] ="vorlonCruiserbg";
		ShipImagesBg[7] ="yt1300bg";
		ShipImagesBg[8] ="tkharuberhaulerbg";
		ShipImagesBg[9] ="vixDreadnaughtbg";
		ShipImagesBg[10] ="leviathonbg";
		ShipImagesBg[11] ="korahMenacebg";
		ShipImagesBg[12] ="mantisbg";
		ShipImagesBg[13] ="scarabbg";
		ShipImagesBg[14] ="bottle";
		
		ShipImagesDamaged[0] ="nanomiteD";
		ShipImagesDamaged[1] ="minoxD";
		ShipImagesDamaged[2] ="spathiScoutD";
		ShipImagesDamaged[3] ="t16WompratD";
		ShipImagesDamaged[4] ="vorchanD";
		ShipImagesDamaged[5] ="hirogenFreighterD";
		ShipImagesDamaged[6] ="vorlonCruiserD";
		ShipImagesDamaged[7] ="yt1300D";
		ShipImagesDamaged[8] ="tkarUberhaulerD";
		ShipImagesDamaged[9] ="vixDreadnaughtD";
		ShipImagesDamaged[10] ="leviathonD";
		ShipImagesDamaged[11] ="korahMenaceD";
		ShipImagesDamaged[12] ="mantisD";
		ShipImagesDamaged[13] ="scarabD";
		ShipImagesDamaged[14] ="bottle";
	

		ShipImagesShield[0] ="nanomiteS";
		ShipImagesShield[1] ="minoxS";
		ShipImagesShield[2] ="spathiScoutS";
		ShipImagesShield[3] ="t16wompratS";
		ShipImagesShield[4] ="vorchanS";
		ShipImagesShield[5] ="hirogenFreighterS";
		ShipImagesShield[6] ="vorlonCruiserS";
		ShipImagesShield[7] ="yt1300S";
		ShipImagesShield[8] ="tkarUberhaulerS";
		ShipImagesShield[9] ="vixDreadnaughtS";
		ShipImagesShield[10] ="leviathonS";
		ShipImagesShield[11] ="korahMenaceS";
		ShipImagesShield[12] ="mantisS";
		ShipImagesShield[13] ="scarabS";
		ShipImagesShield[14] ="bottle";
	
	    //Special Resources
		SpecialResources[0]="Nothing special";
		SpecialResources[1]="Mineral rich";
		SpecialResources[2]="Mineral poor";
		SpecialResources[3]="Desert";
		SpecialResources[4]="Sweetwater oceans";
		SpecialResources[5]="Rich soil";
		SpecialResources[6]="Poor soil";
		SpecialResources[7]="Rich fauna";
		SpecialResources[8]="Lifeless";
		SpecialResources[9]="Weird mushrooms";
		SpecialResources[10]="Special herbs";
		SpecialResources[11]="Artistic populace";
		SpecialResources[12]="Warlike populace";
		
		//Worm Holes
		Wormhole[0]=0;
		Wormhole[1]=0;
		Wormhole[2]=0;
		Wormhole[3]=0;
		Wormhole[4]=0;
		Wormhole[5]=0;
		
		//Buy Price
		BuyPrice[0]=0;
		BuyPrice[1]=0;
		BuyPrice[2]=0;
		BuyPrice[3]=0;
		BuyPrice[4]=0;
	    BuyPrice[5]=0;
		BuyPrice[6]=0;
		BuyPrice[7]=0;
		BuyPrice[8]=0;
		BuyPrice[9]=0;
		
		//Politics
		p[0]= new Politics("Anarchy", 0, 0, 7, 1, 0, 5, 7, true,  true, 11); 
        p[1]= new Politics("Capitalist State", 2, 3, 2, 7, 4, 7,1, true,  true, 3 );
        p[2]= new Politics( "Communist State",  6, 6, 4, 4, 1, 5, 5,true, true,  0  );
        p[3]= new Politics("Confederacy",5, 4, 3, 5, 1, 6, 3, true,true,4);
        p[4]= new Politics( "Corporate State", 2, 6,2,7,4,7, 2, true,true,9 );
        p[5]= new Politics("Cybernetic State", 0, 7, 7, 5, 6, 7, 0, false, false,3 );
        p[6]= new Politics("Democracy",4, 3, 2, 5, 3, 7, 2, true,  true,  4 );
        p[7]= new Politics("Dictatorship",3, 4, 5, 3, 0, 7, 2, true,  true,  0  );
        p[8]= new Politics("Fascist State",7, 7, 7, 1, 4, 7, 0, false, true,  7 );
        p[9]= new Politics("Feudal State", 1, 1, 6, 2, 0, 3, 6, true,  true,  5 );
        p[10]= new Politics("Military State",   7, 7, 0, 6, 2, 7, 0, false, true,9 );
        p[11]= new Politics("Monarchy", 3, 4, 3, 4, 0, 5, 4, true,  true,  6  );
        p[12]= new Politics("Pacifist State",  7, 2, 1, 5, 0, 3, 1, true,  false, 0 );
        p[13]= new Politics("Socialist State", 4, 2, 5, 3, 0, 5, 6, true,  true,  0 );
        p[14]= new Politics("State of Satori",  0, 1, 1, 1, 0, 1, 0, false, false,0 );
        p[15]= new Politics("Technocracy", 1, 6, 3, 6, 4, 7, 2, true,  true,0  );
        p[16]= new Politics("Theocracy", 5, 6, 1, 4, 0, 4, 0, true,  true, 8 );
		
        //Ship type
        s[0]= new Shiptype("Nanomite", 10, 0, 0, 0, 1,20, 4,1, 2000, 5,2, 25,0,0,0,1, 0);
 	 	s[1]= new Shiptype("Minox", 15, 1,0, 1, 1, 14, 5, 2,10000, 50, 28, 100, 0, 0, 0, 1,1);
 	 	s[2]= new Shiptype("Spathi Scout", 20, 1, 1, 1, 1, 17, 5, 3, 25000, 75, 20, 100, 0, 0, 0, 1, 1);
 	 	s[3]= new Shiptype("T06 Womprat", 15, 2, 1, 1, 1, 13, 5, 5, 30000, 100, 20, 100, 0, 1, 0, 1, 1 );
 	 	s[4]= new Shiptype("Vorchan", 25, 1, 2, 2, 2, 15, 5, 7, 60000, 125, 15, 100, 1, 1, 0, 1, 2 );
 	 	s[5]= new Shiptype("Hirogen Freighter", 50, 0, 1, 1, 3, 14, 5, 10, 80000, 50, 3, 50, 0, 0, 0, 1, 2 );
 	 	s[6]= new Shiptype("Vorlon Cruiser", 20, 3, 2, 1, 2, 16, 6, 15, 100000, 200, 6, 150, 2, 3, 1, 2, 3 );
 	 	s[7]= new Shiptype("YT-1300", 30, 2, 2, 3, 3, 15, 6, 15, 150000, 300, 2, 150, 3, 4, 2, 3, 3 );
 	 	s[8]= new Shiptype("T'khar Uberhauler", 60, 1, 3, 2, 3, 13, 7, 20, 225000, 300, 2, 200, 4, 5, 3, 4, 4 );
 	 	s[9]= new Shiptype("Leviathan", 0, 3, 0, 0, 1, 1, 8, 1, 500000, 0, 0, 500, 8, 8, 8, 1, 4 );
 	 	s[10]= new Shiptype("Kor'ah Menace", 0, 2, 3, 2, 1, 1, 8, 1, 500000, 0, 0, 10, 8, 8, 8, 1, 1 );
 	 	s[11]= new Shiptype("Mantis", 0, 3, 1, 3, 3, 1, 8, 1, 500000, 0, 0, 300, 8, 8, 8, 1, 2  );
 	 	s[12]= new Shiptype("Scarab", 20, 2, 0, 0, 2, 1, 8, 1, 500000, 0, 0, 400, 8, 8, 8, 1, 3  );
 	 	s[13]= new Shiptype("Bottle", 0, 0, 0, 0, 0, 1, 8, 1, 100, 0, 0, 10, 8, 8, 8, 1, 1  );
 	 	s[14]= new Shiptype("Vix Dreadnought", 35, 3, 2, 2, 3, 14, 7, 20, 300000, 500, 2, 200, 5, 6, 4, 5, 4 );
 	 	
 	 	//Sell Price
 	 	SellPrice[0]=0;
		SellPrice[1]=0;
		SellPrice[2]=0;
		SellPrice[3]=0;
		SellPrice[4]=0;
	    SellPrice[5]=0;
		SellPrice[6]=0;
		SellPrice[7]=0;
		SellPrice[8]=0;
		SellPrice[9]=0;
 	 	
		//Buying Price
		BuyingPrice[0]=0;
		BuyingPrice[1]=0;
		BuyingPrice[2]=0;
		BuyingPrice[3]=0;
		BuyingPrice[4]=0;
		BuyingPrice[5]=0;
		BuyingPrice[6]=0;
		BuyingPrice[7]=0;
		BuyingPrice[8]=0;
		BuyingPrice[9]=0;
		
		//Trade Items
		t[0]= new Tradeitem("Water",0, 0, 2,   30,   +3,   4, 3,4, 3, 30,   50,   1 );
		t[1]= new Tradeitem("Furs", 	  0, 0, 0,  250,  +10,  10,5, 7, 8,     230,  280,   5 );
		t[2]= new Tradeitem("Food", 	  1, 0, 1,  100,   +5,   5, 6,5,6, 90,  160,   5 );
		t[3]= new Tradeitem("Ore", 	  2, 2, 3,  350,  +20,  10,  1,1,2,  350,  420,  10 );
		t[4]= new Tradeitem("Games",     3, 1, 6,  250,  -10,   5, 4, 11, -1, 160,  270, 5 );
		t[5]= new Tradeitem("Firearms",  3, 1, 5, 1250,  -75, 100, 1,12, -1, 600, 1100,  25  );
		t[6]= new Tradeitem("Medicine",  4, 1, 6,  650,  -20,  10, 2,10,    -1,  400,  700,  25 );
		t[7]= new Tradeitem("Machines",  4, 3, 5,  900,  -30,   5, 7, -1,  -1,   600,  800,  25 );
		t[8]= new Tradeitem("Narcotics", 5, 0, 5, 3500, -125, 150, 4, 9, -1,2000, 3000,  50 );
		t[9]= new Tradeitem("Robots",    6, 4, 7, 5000, -150, 100, 7, -1,  -1, 3500, 5000, 100 );
		
		//Player's Ship
		Ship = new SHIP(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,14,100,0,0,0,0,0);
	
		//Opponents Ship
		Opponent = new SHIP(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,14,100,0,0,0,0,0);
		
		//Space Monsters Ship
		SpaceMonster = new SHIP(10,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,31,0,0,1,500,0,0,0,0,0);
		
		//Scarab
		Scarab = new SHIP(13,0,0,0,0,0,0,0,0,0,0,2,2,0,0,0,0,0,0,0,0,0,0,31,0,0,1,400,0,0,0,0,0);
		
		//Dragon fly's Ship
		Dragonfly = new SHIP(11,0,0,0,0,0,0,0,0,0,0,2,0,1,2,2,2,350,350,350,1,3,0,31,0,0,1,10,0,0,0,0,0);
		
		//Police Record
		PoliceRecord[0]=new POLICERECORD("Psycho",-100);
		PoliceRecord[1]=new POLICERECORD("Villain",-70);
		PoliceRecord[2]=new POLICERECORD("Criminal",-30);
		PoliceRecord[3]=new POLICERECORD("Crook",-10);
		PoliceRecord[4]=new POLICERECORD("Dubious",-5);
		PoliceRecord[5]=new POLICERECORD("Clean",0);
		PoliceRecord[6]=new POLICERECORD("Lawful",5);
		PoliceRecord[7]=new POLICERECORD("Trusted",10);
		PoliceRecord[8]=new POLICERECORD("Liked",25);
		PoliceRecord[9]=new POLICERECORD("Hero",75);
	
		
		//Mercenary CREWMEMBERS
		for(int u=0;u<32;u++)
		{
			Mercenary[u]=new CREWMEMBER(0,0,0,0,0,0);
		}
		
		//Reputation
		Reputation[0]=new REPUTATION("Harmless",0);
		Reputation[1]=new REPUTATION("Mostly Harmless",10);
		Reputation[2]=new REPUTATION("Poor",20);
		Reputation[3]=new REPUTATION("Average",40);
		Reputation[4]=new REPUTATION("Above average",80);
		Reputation[5]=new REPUTATION("Competent",150);
		Reputation[6]=new REPUTATION("Dangerous",300);
		Reputation[7]=new REPUTATION("Deadly",600);
		Reputation[8]=new REPUTATION("Elite",1500);
		
		//Special Events
		SpecialEvent[0]=new SPECIALEVENT("Dragonfly Destroyed",	"QuestDragonflyDestroyedString",0, 0, true);
		SpecialEvent[1]=new SPECIALEVENT("Weird Ship","QuestWeirdShipString",0, 0, true);
		SpecialEvent[2]=new SPECIALEVENT("Lightning Ship","QuestLightningShipString",0, 0, true);
		SpecialEvent[3]=new SPECIALEVENT("Strange Ship","QuestStrangeShipString",0, 0,true);
		SpecialEvent[4]=new SPECIALEVENT("Monster Killed","QuestMonsterKilledString",-15000, 0, true );
		SpecialEvent[5]=new SPECIALEVENT("Medicine Delivery", "QuestMedicineDeliveredString",0, 0, true);
		SpecialEvent[6]=new SPECIALEVENT( "Retirement","QuestRetirementString",	0, 0, false);
		SpecialEvent[7]=new SPECIALEVENT("Moon For Sale",  "QuestMoonForSaleString",  COSTMOON, 4, false );
		SpecialEvent[8]=new SPECIALEVENT("Skill Increase", "QuestSkillIncreaseString",3000, 3, false );
		SpecialEvent[9]=new SPECIALEVENT("Merchant Prince",	"QuestMerchantPrinceString", 1000, 1, false);
		SpecialEvent[10]=new SPECIALEVENT("Erase Record",  "QuestEraseRecordString", 5000, 3, false);
		SpecialEvent[11]=new SPECIALEVENT("Tribble Buyer",  "QuestTribbleBuyerString", 0, 3, false );
		SpecialEvent[12]=new SPECIALEVENT( "Space Monster",  "QuestSpaceMonsterString", 0, 1, true );
		SpecialEvent[13]=new SPECIALEVENT( "Dragonfly","QuestDragonflyString", 0, 1, true );
		SpecialEvent[14]=new SPECIALEVENT("Cargo For Sale","QuestCargoForSaleString",  1000, 3, false);
		SpecialEvent[15]=new SPECIALEVENT("Lightning Shield", 		"QuestLightningShieldString",	 		0, 0, false);
		SpecialEvent[16]=new SPECIALEVENT("Japori Disease", 		"QuestJaporiDiseaseString", 			0, 1, false );
		SpecialEvent[17]=new SPECIALEVENT("Lottery Winner", 		"QuestLotteryWinnerString", 		-1000, 0, true);
		SpecialEvent[18]=new SPECIALEVENT("Artifact Delivery", 		"QuestArtifactDeliveryString",	-20000, 0, true);
		SpecialEvent[19]=new SPECIALEVENT("Alien Artifact", 		"QuestAlienArtifactString", 			0, 1, false);
		SpecialEvent[20]=new SPECIALEVENT("Ambassador Jarek", 		"QuestAmbassadorJarekString",		 	0, 1, false );
		SpecialEvent[21]=new SPECIALEVENT("Gemulon Invaded", 		"QuestGemulonInvadedString", 			0, 0, true );
		SpecialEvent[22]=new SPECIALEVENT("Fuel Compactor", 		"QuestFuelCompactorString", 			0, 0, false);
		SpecialEvent[23]=new SPECIALEVENT("Dangerous Experiment",   "QuestDangerousExperimentString",		0, 0, true);
		SpecialEvent[24]=new SPECIALEVENT("Jonathan Wild",  		"QuestJonathanWildString", 			0, 1, false);
		SpecialEvent[25]=new SPECIALEVENT("Morgan's Reactor",  		"QuestMorgansReactorString",	 		0, 0, false);
		SpecialEvent[26]=new SPECIALEVENT( "Install Morgan's Laser", "QuestInstallMorgansLaserString",	 	0, 0, false);
		SpecialEvent[27]=new SPECIALEVENT("Scarab Stolen", 		"QuestScarabStolenString",		 	0, 1, true);
		SpecialEvent[28]=new SPECIALEVENT("Upgrade Hull", 			"QuestUpgradeHullString", 			0, 0, false);
		SpecialEvent[29]=new SPECIALEVENT("Scarab Destroyed", 	"QuestScarabDestroyedString",	 	0, 0, true);
		SpecialEvent[30]=new SPECIALEVENT("Reactor Delivered",  	"QuestReactorDeliveredString", 		0, 0, true);
		SpecialEvent[31]=new SPECIALEVENT( "Jarek Gets Out",			"QuestJarekGetsOutString", 			0, 0, true );
		SpecialEvent[32]=new SPECIALEVENT("Gemulon Rescued", 		"QuestGemulonRescuedString",	 		0, 0, true);
		SpecialEvent[33]=new SPECIALEVENT("Disaster Averted",		"QuestDisasterAvertedString",			0, 0, true);
		SpecialEvent[34]=new SPECIALEVENT("Experiment Failed",		"QuestExperimentFailedString", 		0, 0, true);
		SpecialEvent[35]=new SPECIALEVENT("Wild Gets Out",			"QuestWildGetsOutString"	,	0, 0, true);
		SpecialEvent[36]=new SPECIALEVENT("Dragonfly Destroyed",	"QuestDragonflyDestroyedString",0, 0, true);
			
		//Gadget Types
		Gadgettype[0]=new GADGET("5 extra cargo bays",2500,4,35);
		Gadgettype[1]=new GADGET("Auto-repair system",7500,5,20); 
		Gadgettype[2]=new GADGET("Navigation system",15000,6,20);
		Gadgettype[3]=new GADGET("Targeting system",25000,6,20);
		Gadgettype[4]=new GADGET("Cloaking Device",7500,5,20);
		Gadgettype[5]=new GADGET("Fuel compactor",30000,8,0);
		
		//Weapon Types
		Weapontype[0]=new WEAPON("Pulse laser",PULSELASERWEAPON,2000,5,50);
		Weapontype[1]=new WEAPON("Regolian Disrupters",BEAMLASERPOWER,12500,6,35); 
		Weapontype[2]=new WEAPON("Justice Mk. V",MILITARYLASERPOWER,35000,7,15);
		Weapontype[3]=new WEAPON("BOAKYAG Laser",MORGANLASERPOWER,50000,8, 0);
		
		//Shield Types
		Shieldtype[0]=new SHIELD("Energy Shield",100,5000,5,70);
		Shieldtype[1]=new SHIELD("Reflective Shield",200,20000,6,30);
		Shieldtype[2]=new SHIELD("Lightning Shield",350,45000,8,0);
		
		//Solar Systems
		for(int i=0;i<120;i++)
		{
		     SolarSystem[i]=new SOLARSYSTEM();
		}
		
		//String Variable
		currentState="\0";
		pilotName="Jameson";
		CommanderName="";
		
		//Variable Boolean
	     gr1=false;
	     bl1=false;rd1=false;
	     autoloadsave=true;enablemusic=true;enablegamesound=true;enabletalkingalert=true;
		raided=false;						autoRepair=false;
		possibleToGoThroughRip=false;		firstEncounter=false;
		arrivedViaWormhole=false;			inspected=false;
		alwaysIgnorePolice=false;			alwaysIgnorePirates=false;
		autoFuel=false;						alwaysIgnoreTradeInOrbit=false;
		justLootedMarie=false;				bLastMessage=false;
		tribbleMessage=false;				trackAutoOff=false;
		alwaysIgnoreTraders=false;			litterWarning=false;
		canSuperWarp=false;					bWaitFinishPlunder = false;
		continuous=false;					textualEncounters = true;
		autoFlee=false;						playerShipNeedsUpdate=false;
		opponentShipNeedsUpdate=false;		autoAttack = false;
				
		//VARIABLES
		//Integer
		countsellequip1=0;
		countsellequip2=0;
		countsellequip3=0;
		countsellequip4=0;
		countsellequip5=0;
		countsellequip6=0;
		countsellequip7=0;
		countsellequip8=0;
		countsellequip9=0;
		countsellequip10=0;
		counterbuyequip0=0;
		counterbuyequip1=0;
		counterbuyequip2=0;
		counterbuyequip3=0;
		counterbuyequip4=0;
		counterbuyequip5=0;
		counterbuyequip6=0;
		counterbuyequip7=0;
		counterbuyequip8=0;
		counterbuyequip9=0;
		countsellcargo0=0;
		countsellcargo1=0;
		countsellcargo2=0;
		countsellcargo3=0;
		countsellcargo4=0;
		countsellcargo5=0;
		countsellcargo6=0;
		countsellcargo7=0;
		countsellcargo8=0;
		countsellcargo9=0;
		saveitemcounter=0;
		
		diffculty=0;
		MAXPOLICERECORD=10;					MAXSPECIALNEWSEVENTS=5;
		Gg=0;								RSHIELDPOWER    = 200;
		REFLECTIVESHIELD=1;					trackedSystem=0;
		activeTradeItem=0;					currentGalaxySystem=0;
		countDown=0;						POLICEINSPECTION =0 ;
		POLICEIGNORE   =  1 ;				MAXSKILL   =    10;
		FABRICRIPINITIALPROBABILITY =25;	SCARABTYPE=13;
		POLICE =0;							BEGINNER =0;
		EASY = 1;							NORMAL= 2;
		HARD =3;							IMPOSSIBLE   =   4;
		clicks=0;							chanceOfVeryRareEncounter=0;
		ATTACKPOLICESCORE  = -3;			DEBTTOOLARGE	=100000;
		BOTTLETYPE=14;						leaveEmpty=0;
		KILLPOLICESCORE=-6;					ATTACKTRADERSCORE  = -2;
		PLUNDERTRADERSCORE = -2;			KILLTRADERSCORE    = -4;
		ATTACKPIRATESCORE  =  0;			KILLPIRATESCORE    =  1;
		PLUNDERPIRATESCORE = -1;			TRAFFICKING        = -1;
		FLEEFROMINSPECTION = -2;			TAKEMARIENARCOTICS=-4;
		MANTISTYPE=12;						POLICEFLEE   =    3;
		MAXPOLICE   =     9;				DRAGONFLYATTACK  =  40;
		DRAGONFLYIGNORE   = 41;				MAXDRAGONFLY = 49;
		MANTIS        =     50;				SCARABATTACK  =  60;
		SCARABIGNORE   = 61;				MAXSCARAB      = 69;
		FAMOUSCAPTAIN	   		=	70;		FAMOUSCAPATTACK    	=		71;
		CAPTAINAHABENCOUNTER	=	72;		CAPTAINCONRADENCOUNTER=		73;
		CAPTAINHUIEENCOUNTER		=74;	MAXFAMOUSCAPTAIN           = 79;
		MARIECELESTEENCOUNTER	=	80;		BOTTLEOLDENCOUNTER     =     81;
		BOTTLEGOODENCOUNTER     =    82;	POSTMARIEPOLICEENCOUNTER=	83;
		SPACEMONSTERATTACK =30;				SPACEMONSTERIGNORE =31;
		MAXSPACEMONSTER   = 39;				POLICEATTACK   =  2 ;
		TRADER  =   20;						TRADERIGNORE =   20 ;
		TRADERFLEE    =  21; 				TRADERATTACK   = 22 ;
		TRADERSURRENDER =23 ;				TRADERSELL	   = 24 ;
		TRADERBUY		=25 ;				TRADERNOTRADE	=26;
		MAXTRADER      = 29;				PIRATEATTACK =   10 ;
		PIRATEFLEE    =  11;				PIRATEIGNORE  =  12;
		PIRATESURRENDER =13;				MAXPIRATE       =19;
		encounterType =0;					newsSpecialEventCount=0;
		monsterHull=0;						warpSystem=0;
		MAXSIZE =5;							UNEVENTFUL   =   0;
		MAXSTATUS=8;						MAXRESOURCES=13;
		GALAXYWIDTH	=150;					GALAXYHEIGHT =110;
		SHORTRANGEWIDTH =300;				SHORTRANGEHEIGHT =300;
		SHORTRANGEBOUNDSX =10;				GALAXYRANGEWIDTH =400;
		GALAXYRANGEHEIGHT =360;				GALAXYRANGEBOUNDSX =10;
		BOUNDSX =5;							BOUNDSY =20;
		GALAXYBOUNDSX =20;					GALAXYBOUNDSY =50;
		MINDISTANCE =6;						MINDISTANCEACTIVATE =30;
		CLOSEDISTANCE =13;					WORMHOLEDISTANCE =3;
		EXTRAERASE =3;						dragonflyStatus=0;
		saveItemIndex=0;					savePrice=0;
		saveSlot=0;							monsterStatus=0;
		MAXWORMHOLE =6;						currentsystem=0;
		MAXCREW = 3;						jarekStatus=0;
		amount=0;							ForHire = 0;
		MAXGADGET = 3;						EXTRABAYS = 0;
		japoriDiseaseStatus = 0;			UPGRADEDHULL = 50;
		COSTMOON =500000;					wildStatus=0;
		CAUGHTWITHWILDSCORE=-4;				invasionStatus=0; 
		insuranceMoney=0;					Credits=0;
		currentShipPriceWithoutCargo=0;		CLEANSCORE=0;
		poilceRecordScore=0;				MAXTRADEITEM=10;
		LIGHTNINGSHIELD = 2;				LSHIELDPOWER = 350;
		AUTOREPAIRSYSTEM = 1;				TARGETINGSYSTEM = 3;
		MAXCREWMEMBER=31;					MAXSHIPTYPE=10;
		EXTRASHIPS=5;						MAXWEAPON = 3;
		MAXSHIELD = 3;						EXTRAWEAPONS=1;
		PULSELASERWEAPON    =0;				PULSELASERPOWER    =15;
		BEAMLASERWEAPON    = 1;				BEAMLASERPOWER     =25;
		MILITARYLASERWEAPON= 2;				MILITARYLASERPOWER =35;
		MORGANLASERWEAPON	=3;				MORGANLASERPOWER   =85;
		PSYCHOPATHSCORE =-70;				VILLAINSCORE    =-30;
		CRIMINALSCORE   =-10;				DUBIOUSSCORE    =-5;
		LAWFULSCORE      =5;				TRUSTEDSCORE     =10;
		HELPERSCORE      =25;				HEROSCORE        =75;
		MAXREPUTATION =9;					HARMLESSREP         =0;
		MOSTLYHARMLESSREP   =10;			POORREP             =20;
		AVERAGESCORE        =40;			ABOVEAVERAGESCORE   =80;
		COMPETENTREP       =150;			DANGEROUSREP       =300;
		DEADLYREP          =600;			ELITESCORE        =1500;		
		experimentStatus=0;					fabricRipProbability=0;
		veryRareEncounter=0;				reactorStatus=0;
		scarabStatus=0 ;					MAXGADGETTYPE    =5;
		NAVIGATINGSYSTEM =2;				CLOAKINGDEVICE   =4;
		FUELCOMPACTOR    =5;				EXTRAGADGETS=1;
		WILDARRESTED		  = 90;			CAUGHTLITTERING		  = 91;
		EXPERIMENTPERFORMED	   =92;			ARRIVALVIASINGULARITY  =93;
		CAPTAINHUIEATTACKED   =100;			CAPTAINCONRADATTACKED =101;
		CAPTAINAHABATTACKED   =102;			CAPTAINHUIEDESTROYED  =110;
		CAPTAINCONRADDESTROYED =111;		CAPTAINAHABDESTROYED  =112;
		GEMULONSYSTEM    =32;				JAPORISYSTEM     =41;
		KRAVATSYSTEM	 =50;				MELINASYSTEM     =59;
		NIXSYSTEM		 =67;				OGSYSTEM         =70;
		REGULASSYSTEM    =82;				SOLSYSTEM        =92;
		UTOPIASYSTEM    =109;				ZALKONSYSTEM    =118;
		WATER          = 0;					FURS            =1;
		FOOD            =2;					ORE             =3;
		GAMES           =4;					FIREARMS        =5;
		FIREARMS        =5;					MEDICINE        =6;
		MACHINERY       =7;					NARCOTICS       =8;
		ROBOTS          =9;					MAXSPECIALEVENT        =37;
		ENDFIXED                =7;			MAXTEXT                 =9;
		DRAGONFLYDESTROYED      =0;			FLYBARATAS              =1;
		FLYMELINA               =2;			FLYREGULAS              =3;
		MONSTERKILLED           =4;			MEDICINEDELIVERY        =5;
		MOONBOUGHT              =6;			MOONFORSALE             =7;
		SKILLINCREASE           =8;			TRIBBLE                 =9;
		ERASERECORD            =10;			BUYTRIBBLE             =11;
		SPACEMONSTER           =12;			DRAGONFLY              =13;
		CARGOFORSALE           =14;			INSTALLLIGHTNINGSHIELD =15;
		JAPORIDISEASE          =16;			LOTTERYWINNER          =17;
		ARTIFACTDELIVERY       =18;			ALIENARTIFACT          =19;
		AMBASSADORJAREK        =20;			ALIENINVASION          =21;
		GEMULONINVADED         =22;			GETFUELCOMPACTOR       =23;
		EXPERIMENT             =24;			TRANSPORTWILD          =25;
		GETREACTOR			   =26;			GETSPECIALLASER        =27;
		SCARAB			   =28;				GETHULLUPGRADED		   =29;
		SCARABDESTROYED	   =30;				REACTORDELIVERED	   =31;
		JAREKGETSOUT           =32;			GEMULONRESCUED         =33;
		EXPERIMENTSTOPPED      =34;			EXPERIMENTNOTSTOPPED   =35;
		WILDGETSOUT			   =36;			MAXTRIBBLES=  100000;
		MAXWEAPONTYPE =      3;				TRIBBLESONSCREEN       =31;
		CHANCEOFVERYRAREENCOUNTER	=5;		MAXVERYRAREENCOUNTER		=6;
		MARIECELESTE				=0;		CAPTAINAHAB					=1;
		CAPTAINCONRAD				=2;		CAPTAINHUIE					=3;
		BOTTLEOLD					=4;		BOTTLEGOOD				    =5;
		ALREADYMARIE				=1;		ALREADYAHAB					=2;
		ALREADYCONRAD				=4;		ALREADYHUIE					=8;
		ALREADYBOTTLEOLD		   =16;		ALREADYBOTTLEGOOD          =32;
		CHANCEOFTRADEINORBIT		=100;	MAXPOLITICS  =17;
		MAXSTRENGTH  =8;					ANARCHY      =0;
		MAXTECHLEVEL =8;					MAXSOLARSYSTEM  =120;
		ACAMARSYSTEM      =0;				BARATASSYSTEM     =6;
		DALEDSYSTEM      =17;				DEVIDIASYSTEM    =22;
		pilotSkill=1;						fighterSkill = 1;
		traderSkill = 1;					engineerSkill = 1;
		gameDifficulty = 2; 				totalSkillPoints = 16;
		credits = 1000;						debt = 0;
		policeRecordScore = 0;				reputationScore = 0;
		policeKills = 0;					traderKills = 0;
		pirateKills = 0;					noClaim = 0;
		currentSystem =1;					days = 0;
		MAXSHIELDTYPE =2;					MAXSKILLTYPE  =4;
		SKILLBONUS =3;						CLOAKBONUS =2;
		ChanceOfTradeInOrbit=0;				JETTISONCARGO	=3;
		DUMPCARGO=2;						SELLCARGO=1;
		plunderItem=0;						plunderCount=0;
		MAXHIGHSCORE =10;					gesdb=0;

	}
	
	//Integer Variables
	public  static int saveitemcounter;
	public  static int JETTISONCARGO,DUMPCARGO,SELLCARGO,plunderItem,plunderCount,MAXHIGHSCORE,gesdb;
	public static int MAXSHIELDTYPE,MAXSKILLTYPE,SKILLBONUS,CLOAKBONUS,ChanceOfTradeInOrbit;  
	public static int CHANCEOFTRADEINORBIT,MAXPOLITICS,MAXSTRENGTH,ANARCHY,MAXTECHLEVEL,MAXSOLARSYSTEM;
	public static int ACAMARSYSTEM,BARATASSYSTEM,DALEDSYSTEM,DEVIDIASYSTEM,pilotSkill,fighterSkill;
	public static int traderSkill,engineerSkill,gameDifficulty,totalSkillPoints,credits,debt,policeRecordScore;
	public static int reputationScore,policeKills,traderKills,pirateKills,noClaim,currentSystem,days;
	public static int TRIBBLESONSCREEN,CHANCEOFVERYRAREENCOUNTER,MAXVERYRAREENCOUNTER,MARIECELESTE,CAPTAINAHAB;
	public static int CAPTAINCONRAD,CAPTAINHUIE,BOTTLEOLD,BOTTLEGOOD,ALREADYMARIE,ALREADYAHAB,ALREADYCONRAD;
	public static int ALREADYHUIE,ALREADYBOTTLEOLD,ALREADYBOTTLEGOOD;
	public static int MAXSPECIALEVENT,ENDFIXED,MAXTEXT,DRAGONFLYDESTROYED,FLYBARATAS,FLYMELINA,FLYREGULAS;
	public static int MONSTERKILLED,MEDICINEDELIVERY,MOONBOUGHT,MOONFORSALE,SKILLINCREASE,TRIBBLE,ERASERECORD;
	public static int BUYTRIBBLE,SPACEMONSTER,DRAGONFLY,CARGOFORSALE,INSTALLLIGHTNINGSHIELD,JAPORIDISEASE;
	public static int LOTTERYWINNER,ARTIFACTDELIVERY,ALIENARTIFACT,AMBASSADORJAREK,ALIENINVASION,GEMULONINVADED ;
	public static int GETFUELCOMPACTOR,EXPERIMENT,TRANSPORTWILD,GETREACTOR,GETSPECIALLASER,SCARAB,GETHULLUPGRADED;
	public static int SCARABDESTROYED,REACTORDELIVERED,JAREKGETSOUT,GEMULONRESCUED,EXPERIMENTSTOPPED,EXPERIMENTNOTSTOPPED ;
	public static int WILDGETSOUT,MAXTRIBBLES,MAXWEAPONTYPE,COMPETENTREP,DANGEROUSREP,DEADLYREP,ELITESCORE;
	public static int WATER,FURS,FOOD,ORE,GAMES,FIREARMS,MEDICINE,MACHINERY,NARCOTICS,ROBOTS;
	public static int WILDARRESTED,CAUGHTLITTERING,EXPERIMENTPERFORMED,ARRIVALVIASINGULARITY,CAPTAINHUIEATTACKED;
	public static int CAPTAINCONRADATTACKED,CAPTAINAHABATTACKED,CAPTAINHUIEDESTROYED,CAPTAINCONRADDESTROYED;
	public static int CAPTAINAHABDESTROYED,GEMULONSYSTEM,JAPORISYSTEM,KRAVATSYSTEM,MELINASYSTEM,NIXSYSTEM;
	public static int OGSYSTEM,REGULASSYSTEM,SOLSYSTEM,UTOPIASYSTEM,ZALKONSYSTEM;
	public static int MAXGADGETTYPE, NAVIGATINGSYSTEM,CLOAKINGDEVICE ,FUELCOMPACTOR, EXTRAGADGETS;
	public static int experimentStatus,fabricRipProbability,veryRareEncounter,reactorStatus,scarabStatus;
	public static int MAXPOLICERECORD,MAXSPECIALNEWSEVENTS,Gg, RSHIELDPOWER,REFLECTIVESHIELD,newsSpecialEventCount;
	public static int trackedSystem, activeTradeItem,currentGalaxySystem,countDown,encounterType;
	public static int POLICEINSPECTION,POLICEIGNORE,MAXSKILL,FABRICRIPINITIALPROBABILITY,SCARABTYPE;		
	public static int POLICE,BEGINNER,EASY,NORMAL,HARD,IMPOSSIBLE,clicks,chanceOfVeryRareEncounter;
	public static int ATTACKPOLICESCORE,DEBTTOOLARGE,BOTTLETYPE,leaveEmpty,PIRATEATTACK,PIRATEFLEE;
	public static int KILLPOLICESCORE,ATTACKTRADERSCORE,PLUNDERTRADERSCORE,KILLTRADERSCORE,ATTACKPIRATESCORE;
	public static int KILLPIRATESCORE,PLUNDERPIRATESCORE,TRAFFICKING,FLEEFROMINSPECTION,TAKEMARIENARCOTICS;
	public static int MANTISTYPE,POLICEFLEE,MAXPOLICE, DRAGONFLYATTACK,DRAGONFLYIGNORE,MAXDRAGONFLY;
	public static int POLICEATTACK,TRADER,TRADERIGNORE,TRADERFLEE,TRADERATTACK,MANTIS,SCARABATTACK,SCARABIGNORE;
	public static int MAXSCARAB,TRADERSURRENDER,TRADERSELL,TRADERBUY,TRADERNOTRADE,MAXTRADER,MAXPIRATE;
	public static int FAMOUSCAPTAIN, FAMOUSCAPATTACK, CAPTAINAHABENCOUNTER, CAPTAINCONRADENCOUNTER,CAPTAINHUIEENCOUNTER,MAXFAMOUSCAPTAIN;
	public static int MARIECELESTEENCOUNTER,BOTTLEOLDENCOUNTER,BOTTLEGOODENCOUNTER,POSTMARIEPOLICEENCOUNTER;
	public static int SPACEMONSTERATTACK,SPACEMONSTERIGNORE,MAXSPACEMONSTER,PIRATEIGNORE,PIRATESURRENDER;
	public static int monsterHull,warpSystem,MAXSIZE,UNEVENTFUL,MAXSTATUS,MAXRESOURCES,GALAXYRANGEHEIGHT;
	public static int GALAXYWIDTH,GALAXYHEIGHT,SHORTRANGEWIDTH,SHORTRANGEHEIGHT,SHORTRANGEBOUNDSX,GALAXYRANGEWIDTH;
	public static int GALAXYRANGEBOUNDSX,BOUNDSX,BOUNDSY,GALAXYBOUNDSX,GALAXYBOUNDSY,MINDISTANCE,AUTOREPAIRSYSTEM;
	public static int MINDISTANCEACTIVATE,CLOSEDISTANCE,WORMHOLEDISTANCE,EXTRAERASE,dragonflyStatus;
	public static int saveItemIndex,savePrice,saveSlot,monsterStatus,MAXWORMHOLE,currentsystem,TARGETINGSYSTEM;
	public static int MAXCREW,jarekStatus,amount,ForHire,MAXGADGET,EXTRABAYS,japoriDiseaseStatus,UPGRADEDHULL,COSTMOON;
	public static int wildStatus,CAUGHTWITHWILDSCORE,invasionStatus,LIGHTNINGSHIELD,LSHIELDPOWER; 
	public static int insuranceMoney,Credits,currentShipPriceWithoutCargo,CLEANSCORE,poilceRecordScore,MAXTRADEITEM=10;
    public static int MAXCREWMEMBER,MAXSHIPTYPE,EXTRASHIPS,MAXWEAPON,MAXSHIELD,EXTRAWEAPONS;
	public static int PULSELASERWEAPON,PULSELASERPOWER,BEAMLASERWEAPON,BEAMLASERPOWER,MILITARYLASERWEAPON;
	public static int MILITARYLASERPOWER,MORGANLASERWEAPON,MORGANLASERPOWER,PSYCHOPATHSCORE,VILLAINSCORE;
	public static int CRIMINALSCORE,DUBIOUSSCORE,LAWFULSCORE,TRUSTEDSCORE,HELPERSCORE,HEROSCORE;
	public static int MAXREPUTATION,HARMLESSREP,MOSTLYHARMLESSREP,POORREP,AVERAGESCORE,ABOVEAVERAGESCORE;
	public static boolean gr1,bl1,rd1,autoloadsave,enablemusic,enablegamesound,enabletalkingalert;
	public static String Name=null;
	public static int countsellequip0,countsellequip1,countsellequip2,countsellequip3,countsellequip4,countsellequip5,countsellequip6,countsellequip7,countsellequip8,countsellequip9,countsellequip10;
	public static int counterbuyequip0,counterbuyequip1,counterbuyequip2,counterbuyequip3,counterbuyequip4,counterbuyequip5,counterbuyequip6,counterbuyequip7,counterbuyequip8,counterbuyequip9,counterbuyequip10;
	public static int countsellcargo0,countsellcargo1,countsellcargo2,countsellcargo3,countsellcargo4,countsellcargo5,countsellcargo6,countsellcargo7,countsellcargo8,countsellcargo9,countsellcargo10;
	
	public static int diffculty;
	//Array of Objects
	public static int NewsEvents[]=new int [5];
	public static int Wormhole[]=new int[6];
	public static int saveitem[] =new int[10];
	public static int BuyPrice[]=new int [10];
	public static int SellPrice[]=new int[10];
	public static int BuyingPrice[]=new int[10];	
	public static Tradeitem t[] = new Tradeitem[10];
	public static Politics p[] = new Politics[17];
	public static Shiptype s[] = new Shiptype[15];
	public static POLICERECORD[] PoliceRecord = new POLICERECORD[10];
	public static CREWMEMBER Mercenary[] = new CREWMEMBER[32];
	public static WEAPON Weapontype[] = new WEAPON[4];
	public static REPUTATION Reputation[] = new REPUTATION[9];
	public static SPECIALEVENT SpecialEvent[]=new SPECIALEVENT[37];
	public static GADGET Gadgettype[]= new GADGET[6];
	public static SHIELD Shieldtype[]= new SHIELD[4];
	public static SOLARSYSTEM SolarSystem[] = new SOLARSYSTEM[120];
	public static String[] ShipImages = new String[15];
	public static String[] ShipImagesBg = new String[15];
	public static String[] ShipImagesDamaged= new String[15];
	public static String[] ShipImagesShield= new String[15];
	//Boolean Variable
	public static boolean raided,autoRepair, bWaitFinishPlunder,continuous,textualEncounters;
	public static boolean possibleToGoThroughRip,firstEncounter,arrivedViaWormhole,inspected,alwaysIgnorePolice,alwaysIgnorePirates;
	public static boolean autoFuel,alwaysIgnoreTradeInOrbit,justLootedMarie,bLastMessage,tribbleMessage,trackAutoOff,alwaysIgnoreTraders;
	public static boolean litterWarning,canSuperWarp;
	public static boolean autoFlee,playerShipNeedsUpdate,opponentShipNeedsUpdate,autoAttack;
	public static boolean remindLoans=false,moonBought=false;
	public static boolean escapePod;
	public static boolean artifactOnBoard=false;
	public static boolean alreadyPaidForNewspaper=false;
	public static boolean reserveMoney=false;
	public static boolean Flees;
	public static boolean audioPlayerReleased = true;
	public static boolean insurance = false;
	public static boolean CommanderUnderAttack=false;
	public static boolean encounterWindow;
	public static boolean showTrackedRange;
	public static boolean gameLoaded;
	public static boolean alwaysInfo;
	//String Variables
	public static String[] SpecialResources = new String[13];
	public static String pilotName;
	public static  String CommanderName;
	public static String currentState;
	public static String solarSystemName[]={"Zule",
		"Acamar", //0
		"Adahn",
		"Alderen",
		"Aldea",
		"Anevian",
		"Antidee",
		"Balosnee",
		"Baratas", //7
		"Brax", 
		"Bretel",
		"Calondia",
		"Capelle",
		"Carzun",
		"Castor",
		"Cemper",
		"Cestus",
		"Cherone",
		"Courtenee",
		"Daled", //18
		"Damast",
		"Davlos",
		"Delhem",
		"Deneb",
		"Deniva",
		"Devidia", //24
		"Dreama",
		"Drelyn",
		"Endore",
		"Esmee",
		"Exo",
		"Feris",
		"Feston",
		"Formi",
		"Frolics",
		"Galaxia",
		"Gemulon", //35
		"Gwenifer",
		"Hadees",
		"Hamlet",
		"Helenna",
		"Helion Prime",
		"Hulst",
		"Iodine",
		"Irailius",
		"Ja'pori", //44
		"Jannus",
		"Jarada",
		"Jason",
		"Kaylyn",
		"Kera",
		"Khefka",
		"Klautu",
		"Klaystron",
		"Korma",
		"Kravat", //54
		"Krios",
		"Laeretes",
		"Largo",
		"Lave",
		"Ligon",
		"Lowrye",
		"Magret",
		"Malkoria",
		"Melina", //63
		"Menta",
		"Menteka",
		"Merik",
		"Monta",
		"Mordon",
		"Murtle",
		"NeoEM",
		"Nix", //71
		"Ny'on",
		"Nyle",
		"Odret", //74
		"Omega",
		"Omphalos",
		"Opoli", //77
		"Orrias",
		"Othello",
		"Panthera",
		"Parade",
		"Pecard",
		"Pollux",
		"Quator",
		"Radran",
		"Rakar",
		"Rhymus",
		"Rigulus", //88
		"Rochanni",
		"Rotia",
		"Rovar",
		"Rubikum",
		"Satrius",
		"Sefella",
		"Sigma",
		"Sloakiss", //96
		"Somarie",
		"Sopheton",
		"Stakorun",
		"Styris",
		"T'rosa",
		"Talonee",
		"Tamus",
		"Tantalous",
		"Tarchanen",
		"Tarnuga",
		"Terus",
		"Thaira",
		"Titan",
		"Torin",
		"Triacus",
		"Turkana",
		"Umbelee",
		"Urayo",
		"Utopia", //115
		"Vadra",
		"Vagra",
		"Vandur",
		"Ventax",
		"Xenon",
		"Xerxes",
		"Yew",
		"Yujimbo",
		"Zorkon", //124
};
	public static enum EAlertState {
		eDummy,	eSureToFleeOrBribeAlert,eTradeInOrbit,eSellInOrbit,eYieldChoice,eSurrenderArtifact,
		eSurrender,eBottleGood,eBottleStrange,eBoard,ePlunderForm,eBribePropsal,eBribeOffer,eSubmit,
		eEngageCaptainAhabAlert,eEngageCaptainConradAlert,eEngageCaptainHuieAlert,eBuyEquipment,eSpecialEvent,
		eWildWeaponBuy,ePlunderRemoveGoods,eUpdateSpecial,ePlunderShipForm	
	} ;

	EAlertState eAlertState;
	
	
	public static SHIP Ship;	 
	public static SHIP Opponent;
	public static SHIP SpaceMonster;
	public static SHIP Scarab;
	public static SHIP Dragonfly;
	
	
	
	
	
	
    
     
	public static int getEquipmentPrice(int index)
	{
		if (index < MAXWEAPONTYPE)
			return (int) BASEWEAPONPRICE(index);	
		else
			if (index < MAXWEAPONTYPE + MAXSHIELDTYPE) {
				return (int) BASESHIELDPRICE(index - MAXWEAPONTYPE);				
			} else {
				return (int) BASEGADGETPRICE(index - MAXWEAPONTYPE - MAXSHIELDTYPE);							
			}	
	}
	
	public static int BASEWEAPONPRICE(int a )
	{
		return (int) BasePrice(Weapontype[a].TechLevel, Weapontype[a].Price);
	}

	public static int BASESHIELDPRICE(int  a )
	{
		return(BasePrice(Shieldtype[a].TechLevel, Shieldtype[a].Price));
	}
	
	public static int BASEGADGETPRICE(int a )
	{
		return BasePrice(Gadgettype[a].TechLevel, Gadgettype[a].Price);
	}
	public static int BasePrice(int techLevel2 , int Price)
	{
		if(techLevel2 > SolarSystem[currentSystem].TechLevel)
			return 0; 
		else 
			return	(Price * (100 -  TraderSkill(Ship)) / 100);
	}
	public static int TraderSkill( SHIP Sh)
	{
		int i;
		char MaxSkill;
		MaxSkill = (char) Mercenary[Sh.Crew[0]].Trader;
		for (i=1; i<MAXCREW; ++i)
		{
			if (Sh.Crew[i] < 0)
				break;
			if (Mercenary[Sh.Crew[i]].Trader > MaxSkill)
				MaxSkill = (char) Mercenary[Sh.Crew[i]].Trader;
		}
		
	
		if (jarekStatus >= 2)
			++MaxSkill;			
		
		return AdaptDifficulty(MaxSkill);
	}	
		 public static int AdaptDifficulty( int Level)
		 {
			 if(gameDifficulty == 1 || gameDifficulty==2)
				 return(Level+1);
			 else if (gameDifficulty==5)
				 return (max(1,Level-1));
			 else
				 return Level;
		 }
		public static int max(int i,int j)
		{
			if(i>j)
				return i;
			return j;
		}
	
		public static void buyItem(int index )
		{
			if (index < MAXWEAPONTYPE)
				 BuyItem(s[Ship.Type].WeaponSlots, Ship.Weapon,BASEWEAPONPRICE(index),Weapontype[index].Name ,index);	
			else
				if (index < MAXWEAPONTYPE + MAXSHIELDTYPE) {
					 BuyItem(s[Ship.Type].ShieldSlots, Ship.Shield,BASESHIELDPRICE(index - MAXWEAPONTYPE) ,Shieldtype[index- MAXWEAPONTYPE].Name ,(index- MAXWEAPONTYPE));				
				} else {
					 BuyItem(s[Ship.Type].GadgetSlots, Ship.Gadget ,BASEGADGETPRICE(index - MAXWEAPONTYPE - MAXSHIELDTYPE) ,Gadgettype[index - MAXWEAPONTYPE - MAXSHIELDTYPE].Name, (index - MAXWEAPONTYPE - MAXSHIELDTYPE));						
				}		
		}
		public static void BuyItem(int weaponSlots  ,int weapon[] , int Price, String name,int ItemIndex)
		{
			int FirstEmptySlot;
			
			FirstEmptySlot = GetFirstEmptySlot(weaponSlots, weapon);
			
			if (Price <= 0)
			{
				//[self FrmAlert:"ItemNotSoldAlert"];
			}
			else if (debt > 0)
			{
				//	[self FrmAlert:"YoureInDebtAlert"];
			}
				else if (Price > toSpend())
				{
			//	[self FrmAlert:"CantBuyItemAlert"];
		         }
					else if (FirstEmptySlot < 0)
					{
						//	[self FrmAlert:"NotEnoughSlotsAlert"];
					}
			else
			{
				currentState = "eBuyEquipment";
				
				//NSString* str = [NSString stringWithFormat:"Do you wish to buy this item for %i credits?", Price];
				//[self FrmAlert:str];
				//NSString* name = [NSString stringWithFormat:"Buy %", [NSString stringWithCString:Name]];
				
			//	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:name message:str delegate:self cancelButtonTitle:"Cancel" otherButtonTitles:"Ok",nil];	
					
				//bLastMessage = false;
				for (int i=0;i<10;i++)
				{
					saveitem[i] = weapon[i];
				}
				saveItemIndex= ItemIndex;
				savePrice = Price;
				saveSlot = FirstEmptySlot;
				
				
				
			}
		}
		public static int GetFirstEmptySlot( int Slots ,int Item[] )
		{
			int FirstEmptySlot, j;
			
			FirstEmptySlot = -1;
			for (j=0; j<Slots; ++j)
			{
				if (Item[j] < 0)
				{
					FirstEmptySlot = j;
					break;
				}							
			}
			
			return FirstEmptySlot;
		}
		public static int toSpend()
		{
			if (!reserveMoney)
				return credits;
			return max( 0,  credits -  mercenaryMoney() -  insuranceMoney() );
		}
		public static int mercenaryMoney()
		{
			int i, ToPay;
			
			ToPay = 0;
			for (i=1; i<MAXCREW; ++i)
				if (Ship.Crew[i] >= 0)
					ToPay += MERCENARYHIREPRICE( Ship.Crew[i] );
			
			return ToPay;	
		}
		public static int insuranceMoney()
		 {
			 boolean temp=true;
			 if(!insurance)
				 return 0;
			 return (max(1,((currentShipPriceWithoutCargo(temp)*5)/2000)*(100-min(noClaim,90))/100));
		 }
		public static int MERCENARYHIREPRICE(int  a )
		{
			return (a < 0 || (a >= MAXCREWMEMBER && wildStatus == 2) ? 0 : ((Mercenary[a].Pilot + Mercenary[a].Fighter + Mercenary[a].Trader + Mercenary[a].Engineer) * 3));
		}
		public static int currentShipPriceWithoutCargo(boolean forInsurance)
		 {
			int i;
			int CurPrice;
			
			// Trade-in value is three-fourths the original price

			CurPrice = 	((s[Ship.Type].Price * (Ship.Tribbles > 0 && !forInsurance? 1 : 3)) / 4)// subtract repair costs
			- (GetHullStrength() - Ship.Hull) * s[Ship.Type].RepairCosts 
			// subtract costs to fill tank with fuel
			- (s[Ship.Type].FuelTanks -  getFuel()) * s[Ship.Type].CostOfFuel;
			// Add 2/3 of the price of each item of equipment
			for (i=0; i<MAXWEAPON; i++)
				if (Ship.Weapon[i] >= 0)
					CurPrice += WEAPONSELLPRICE( i );
			for (i=0; i<MAXSHIELD; i++)
				if (Ship.Shield[i] >= 0)
					CurPrice += SHIELDSELLPRICE( i );
			for (i=0; i<MAXGADGET; i++)
				if (Ship.Gadget[i] >= 0)
					CurPrice += GADGETSELLPRICE( i );
			
			return CurPrice;

			 
		 }
		public static int GetHullStrength() {
			if(scarabStatus==3)
				return  (s[Ship.Type].HullStrength+UPGRADEDHULL);
			else 
				return s[Ship.Type].HullStrength;
		}
		public static int getFuel()
		 {
			 return  min(Ship.Fuel,GetFuelTanks());
		}
		public static double WEAPONSELLPRICE(int a)
		 {
			if(a<=0){
				a=0;}
			if(a>=2){
				a=2;}
			Log.v("LOG_TAG" ,"inweapon" +a);
			 return (BaseSellPrice( Ship.Weapon[a], Weapontype[Ship.Weapon[a]].Price ));

		 }
		public static double SHIELDSELLPRICE(int a) {
			
			 return (BaseSellPrice( Ship.Shield[a],  Shieldtype[Ship.Shield[a]].Price ));
		}
		public static int GetFuelTanks() {
			
			return ( HasGadget(Ship ,FUELCOMPACTOR ) ? 18 : s[Ship.Type].FuelTanks);

			
		}
		public static int min(int i,int j)
		{
			if(i<j)
				return i;
			else
                return j;
	     		
		}
		public static double BaseSellPrice (int Index, int Price)
		 {
			if( Index>=0)
			{
				double a=((Price*3.0)/4.0);
				return a; 
			}
			else return 0.0;
		 }
		
		
		
		 public static int GADGETSELLPRICE(int  a )
		 {
			 return (int) (BaseSellPrice( Ship.Gadget[a], (int) Gadgettype[Ship.Gadget[a]].Price ));
		 }
		 public static int getBuyPrice(int num)
		 {
			 return BuyPrice[num];
		 }
		 public static int getAmountToBuy(int Index) 
		 {
				
				if (BuyPrice[Index] <= 0 || SolarSystem[currentsystem].Qty[Index]  <= 0) {
					
					return 0;
				}
				int count = min( toSpend() / BuyPrice[Index],  SolarSystem[currentsystem].Qty[Index]);
				
				return count;
			}
		 public static int getSellPrice(int num)
		 {
			 return SellPrice[num];
		 }
		 public static int getAmountToSell(int Index)
			{
				return Ship.Cargo[Index];
			}
		 public static int getOpponentAmountToSell( int Index)
			{
				return Opponent.Cargo[Index];
			}
		 public static int maxLoan()
			{
				
				if(poilceRecordScore>=CLEANSCORE)
				{
					
					return(min(25000,max(1000,((currentWorth())/10/500)*500)));
				}
				else
					return 500;
			}
		 public static int currentWorth()
			{
				boolean temp=false;
				int i1= (int) (credits-debt+ (CurrentShipPrice(temp)));
				int i2 = 0 ;
				if(i2==MOONBOUGHT )
					i2=COSTMOON;
					else
						i2=0;
				return i1+i2;
			}
		 public static int CurrentShipPrice(boolean ForInsurance)   //Determine value of current ship,including good and equipment.
			{
				int i;
				int CurPrice;
				
				CurPrice =  currentShipPriceWithoutCargo(ForInsurance);
				for (i=0; i<MAXTRADEITEM; ++i)
					CurPrice += BuyingPrice[i];
				
				return (int) CurPrice;

			}
		 public static int getShipHull()
			{
				return Ship.Hull;
			}
		 public static int getCurrentSystemTechLevelInt() {
				return SolarSystem[currentSystem].TechLevel;
		 }
		 public static int getCurrentShipTechLevel() {
				return s[0].MinTechLevel;
			}
		 public static int getFuelCost()
			{
				return s[Ship.Type].CostOfFuel;
			}
			public static int getRepairCost()
			{
				return s[Ship.Type].RepairCosts;	

			}
			public static boolean IsNewsExist()
			{
				alreadyPaidForNewspaper = false;
				if (SolarSystem[currentSystem].Special > -1)
				{
					if (SolarSystem[currentSystem].Special == MONSTERKILLED && monsterStatus == 2)
					{
						 addNewsEvent(MONSTERKILLED);
					}
					else if (SolarSystem[currentSystem].Special == DRAGONFLY)
					{
						 addNewsEvent(DRAGONFLY);
					}
					else if (SolarSystem[currentSystem].Special == SCARAB)
					{
						 addNewsEvent(SCARAB);
					}
					else if (SolarSystem[currentSystem].Special == SCARABDESTROYED && scarabStatus == 2)
					{
				          addNewsEvent(SCARABDESTROYED);
					}
					else if (SolarSystem[currentSystem].Special == FLYBARATAS && dragonflyStatus == 1)
					{
					addNewsEvent(FLYBARATAS);
					}
						 else if (SolarSystem[currentSystem].Special == FLYMELINA && dragonflyStatus == 2)
						 {
						 addNewsEvent(FLYMELINA);
						 }
					else if (SolarSystem[currentSystem].Special == FLYREGULAS && dragonflyStatus == 3)
					{
						 addNewsEvent(FLYREGULAS);
					}
					else if (SolarSystem[currentSystem].Special == DRAGONFLYDESTROYED && dragonflyStatus == 5)
					{ 
						 addNewsEvent(DRAGONFLYDESTROYED);
					}
						else if (SolarSystem[currentSystem].Special == MEDICINEDELIVERY && japoriDiseaseStatus == 1)
						{
						 addNewsEvent(MEDICINEDELIVERY);
						}
							else if (SolarSystem[currentSystem].Special == ARTIFACTDELIVERY && artifactOnBoard)
							{
							addNewsEvent(ARTIFACTDELIVERY);
							}
					else if (SolarSystem[currentSystem].Special == JAPORIDISEASE && japoriDiseaseStatus == 0)
					{
					addNewsEvent(JAPORIDISEASE);
					}
					else if (SolarSystem[currentSystem].Special == JAREKGETSOUT && jarekStatus == 1)
					{
					addNewsEvent(JAREKGETSOUT);
					}
					else if (SolarSystem[currentSystem].Special == WILDGETSOUT && wildStatus == 1)
					{
					 addNewsEvent(WILDGETSOUT);
					}
					else if (SolarSystem[currentSystem].Special == GEMULONRESCUED && invasionStatus > 0 && invasionStatus < 8)
					{ 
					addNewsEvent(GEMULONRESCUED);
					}
					else if (SolarSystem[currentSystem].Special == ALIENINVASION)
					{
					addNewsEvent(ALIENINVASION);
					}
					else if (SolarSystem[currentSystem].Special == EXPERIMENTSTOPPED && experimentStatus > 0 && experimentStatus < 12) {
						{
						experimentStatus = 13;
						
						addNewsEvent(EXPERIMENTSTOPPED);
						}
					}
					else if (SolarSystem[currentSystem].Special == EXPERIMENTNOTSTOPPED)
					{ 
						addNewsEvent(EXPERIMENTNOTSTOPPED);
					}
				}

				return true;
			}
			public static void StartNewGame()
			{
				int i, j, k, d, x, y;
				boolean Redo, CloseFound, FreeWormhole;
				
				// = false;
//				[self playMusic];

//				
				 
				// Initialize Galaxy
				i = 0;
				while (i < MAXSOLARSYSTEM)
				{
					if (i < MAXWORMHOLE)
					{
						// Place the first system somewhere in the centre
						SolarSystem[i].X = (((CLOSEDISTANCE>>1) - GetRandom( CLOSEDISTANCE )) + ((GALAXYWIDTH * (1 + 2*(i%3)))/6));		
						SolarSystem[i].Y = (((CLOSEDISTANCE>>1) - GetRandom( CLOSEDISTANCE )) + ((GALAXYHEIGHT * (i < 3 ? 1 : 3))/4));		
						Wormhole[i] = i;
					}
				
					else
					{
						SolarSystem[i].X = (1 + GetRandom( GALAXYWIDTH - 2 ));		
						SolarSystem[i].Y = (1 + GetRandom( GALAXYHEIGHT - 2 ));		
					}
				
					
					CloseFound = false;
					Redo = false;
					if (i >= MAXWORMHOLE)
					{
						for (j=0; j<i; ++j)
						{
							//  Minimum distance between any two systems not to be accepted
							
							if (SqrDistance(SolarSystem[j],SolarSystem[i])  <= SQR( MINDISTANCE + 1 ))
							{
								Redo = true;
								break;
							}
							
							// There should be at least one system which is closeby enough
							if (SqrDistance(SolarSystem[j],SolarSystem[i]) < SQR( CLOSEDISTANCE ))
								CloseFound = true;
						}
					}
					
					if (Redo)
						continue;
					if ((i >= MAXWORMHOLE) && !CloseFound)
						continue;
			
						
					SolarSystem[i].TechLevel = (GetRandom( MAXTECHLEVEL ));
					SolarSystem[i].Politics = (GetRandom( MAXPOLITICS ));
					if (p[SolarSystem[i].Politics].MinTechLevel > SolarSystem[i].TechLevel)
						continue;
					if (p[SolarSystem[i].Politics].MaxTechLevel < SolarSystem[i].TechLevel)
						continue;
						
					if (GetRandom( 5 ) >= 3)
						SolarSystem[i].SpecialResources = (1 + GetRandom( MAXRESOURCES - 1 ));
					else
						SolarSystem[i].SpecialResources = 0;
					
					SolarSystem[i].Size = GetRandom( MAXSIZE );
					
					if (GetRandom( 100 ) < 15)
						SolarSystem[i].Status = 1 + GetRandom( MAXSTATUS - 1 );
					else			
						SolarSystem[i].Status = UNEVENTFUL;
					
					SolarSystem[i].NameIndex = i;
					SolarSystem[i].Special = -1;		
					SolarSystem[i].CountDown = 0;
					SolarSystem[i].Visited = false;
				
				//	InitializeTradeItems(i);
					
					i++;
				}
				
				// Randomize the system locations a bit more, otherwise the systems with the first
				// names in the alphabet are all in the centre
				for (i=0; i<MAXSOLARSYSTEM; i++)
				{
					d = 0;
					while (d < MAXWORMHOLE)
					{
						if (Wormhole[d] == i)
							break;
						d++;
					}
					j = GetRandom( MAXSOLARSYSTEM );
					int b=-1;
					if (wormholeExists(j, b))
						continue;
					x = SolarSystem[i].X;
					y = SolarSystem[i].Y;		
					SolarSystem[i].X = SolarSystem[j].X;
					SolarSystem[i].Y = SolarSystem[j].Y;		
					SolarSystem[j].X = x;
					SolarSystem[j].Y = y;		
					if (d < MAXWORMHOLE)
						Wormhole[d] = j;
				}
				
				// Randomize wormhole order
				for (i=0; i<MAXWORMHOLE; i++)
				{
					j = GetRandom( MAXWORMHOLE );
					x = Wormhole[i];
					Wormhole[i] = Wormhole[j];
					Wormhole[j] = x;
				}
				
				// Initialize mercenary list
				Mercenary[0].NameIndex = 0;
				Mercenary[0].Pilot = 1;
				Mercenary[0].Fighter = 1;
				Mercenary[0].Trader = 1;
				Mercenary[0].Engineer = 1;
				
				i = 1;
				while (i <= MAXCREWMEMBER)
				{
					Mercenary[i].CurSystem = GetRandom( MAXSOLARSYSTEM );
					
					Redo = false;
					for (j=0; j<i; j++)//j=1
					{
						// Not more than one mercenary per system
						if (Mercenary[j].CurSystem == Mercenary[i].CurSystem)
						{
							Redo = true;
							break;
						}
					}
					// can't have another mercenary on Kravat, since Zeethibal could be there
					if (Mercenary[i].CurSystem == KRAVATSYSTEM)
						Redo = true;
					if (Redo)
						continue;
					
					Mercenary[i].NameIndex = i;		
					Mercenary[i].Pilot =  RandomSkill();
					Mercenary[i].Fighter = RandomSkill();
					Mercenary[i].Trader =  RandomSkill();
					Mercenary[i].Engineer =  RandomSkill();
					
					i++;
				}
			    
			    // special individuals: Zeethibal, Jonathan Wild's Nephew
			    Mercenary[MAXCREWMEMBER-1].CurSystem = 255;
				
				// Place special events
				SolarSystem[ACAMARSYSTEM].Special  = MONSTERKILLED;
				SolarSystem[BARATASSYSTEM].Special = FLYBARATAS;
				SolarSystem[MELINASYSTEM].Special  = FLYMELINA;
				SolarSystem[REGULASSYSTEM].Special = FLYREGULAS;
				SolarSystem[ZALKONSYSTEM].Special  = DRAGONFLYDESTROYED;
				SolarSystem[JAPORISYSTEM].Special  = MEDICINEDELIVERY;
				SolarSystem[UTOPIASYSTEM].Special  = MOONBOUGHT;
				SolarSystem[DEVIDIASYSTEM].Special = JAREKGETSOUT;
				SolarSystem[KRAVATSYSTEM].Special  = WILDGETSOUT;
				
				// Assign a wormhole location endpoint for the Scarab.
				// It's possible that ALL wormhole destinations are already
				// taken. In that case, we don't offer the Scarab quest.
				FreeWormhole = false;
				k = 0;
				j = GetRandom( MAXWORMHOLE );
				while (SolarSystem[Wormhole[j]].Special != -1 &&
					   Wormhole[j] != GEMULONSYSTEM && Wormhole[j] != DALEDSYSTEM && Wormhole[j] != NIXSYSTEM && k < 20)
				{
					j = GetRandom( MAXWORMHOLE );
					k++;
				}
			    if (k < 20)
			    {
			    	FreeWormhole = true;
			    	SolarSystem[Wormhole[j]].Special = SCARABDESTROYED;
			    }
				
				d = 999;
				k = -1;
				for (i=0; i<MAXSOLARSYSTEM; ++i)
				{
					j = RealDistance(NIXSYSTEM ,i);
					if (j >= 70 && j < d && SolarSystem[i].Special < 0 &&
					    d != GEMULONSYSTEM && d!= DALEDSYSTEM)
					{
						k = i;
						d = j;
					}
				}
				if (k >= 0)
				{
					SolarSystem[k].Special = GETREACTOR;
					SolarSystem[NIXSYSTEM].Special = REACTORDELIVERED;
				}
				
				
				i = 0;
				while (i < MAXSOLARSYSTEM)
				{
					d = 1 + (GetRandom( MAXSOLARSYSTEM - 1 ));
					if (SolarSystem[d].Special < 0 && SolarSystem[d].TechLevel >= MAXTECHLEVEL-1 &&
					    d != GEMULONSYSTEM && d != DALEDSYSTEM)
					{
						SolarSystem[d].Special = ARTIFACTDELIVERY;
						break;
					}
					i++;
				}
				if (i >= MAXSOLARSYSTEM)
					SpecialEvent[ALIENARTIFACT].Occurence = 0;
				
				
				d = 999;
				k = -1;
				for (i=0; i<MAXSOLARSYSTEM; ++i)
				{
				
				
					j =RealDistance(GEMULONSYSTEM, i);
					if (j >= 70 && j < d && SolarSystem[i].Special < 0 &&
					    k != DALEDSYSTEM && k!= GEMULONSYSTEM)
					{
						k = i;
						d = j;
					}
				}
				if (k >= 0)
				{
					SolarSystem[k].Special = ALIENINVASION;
					SolarSystem[GEMULONSYSTEM].Special = GEMULONRESCUED;
				}
				
				d = 999;
				k = -1;
				for (i=0; i<MAXSOLARSYSTEM; ++i)
				{
					j =   RealDistance(DALEDSYSTEM,i);
					if (j >= 70 && j < d && SolarSystem[i].Special < 0)
					{
						k = i;
						d = j;
					}
				}
				if (k >= 0)
				{
					SolarSystem[k].Special = EXPERIMENT;
					SolarSystem[DALEDSYSTEM].Special = EXPERIMENTSTOPPED;
				}
				
				
				for (i=MOONFORSALE; i<MAXSPECIALEVENT-ENDFIXED; ++i)
				{
					for (j=0; j<SpecialEvent[i].Occurence; ++j)
					{
						Redo = true;
						while (Redo)
						{
							d = 1 + GetRandom( MAXSOLARSYSTEM - 1 );
							if (SolarSystem[d].Special < 0) 
							{
								if (FreeWormhole || i != SCARAB)
									SolarSystem[d].Special = i;
								Redo = false;
							}
						}
					}
				}
				
				// Initialize Commander
				for (i=0; i<200; i++)
				{
					currentSystem = GetRandom( MAXSOLARSYSTEM );
					//COMMANDER.CurSystem = GetRandom( MAXSOLARSYSTEM );
					if (SolarSystem[currentSystem].Special >= 0)
						continue;
					
					// Seek at least an agricultural planet as startplanet (but not too hi-tech)
					if ((i < 100) && ((SolarSystem[currentSystem].TechLevel <= 0) ||
									  (SolarSystem[currentSystem].TechLevel >= 6)))
						continue;
					
					// Make sure at least three other systems can be reached
					d = 0;
					for (j=0; j<MAXSOLARSYSTEM; ++j)
					{
						if (j == currentSystem)//COMMANDER.CurSystem)
							continue;
						if ( SqrDistance(SolarSystem[j], SolarSystem[currentSystem]) <= SQR( s[1].FuelTanks ))
						{
							d++;
							if (d >= 3)
								break;
						}
					}
					if (d < 3)
						continue;
					
					break;
				}
				
				credits = 2500;
//				credits = 9999999999999;
				debt = 0;
				days = 0;
				warpSystem = currentSystem;
				SolarSystem[warpSystem].Visited = true;
				policeKills = 0; 
				traderKills = 0; 
				pirateKills = 0; 
				policeRecordScore = 0;
				reputationScore = 0;
				monsterStatus = 0;
				dragonflyStatus = 0;
				scarabStatus = 0;
				japoriDiseaseStatus = 0;
				moonBought = false;
				monsterHull = s[SpaceMonster.Type].HullStrength;
				escapePod = false;
				insurance = false;
				remindLoans = true;
				noClaim = 0;
				artifactOnBoard = false;
				for (i=0; i<MAXTRADEITEM; ++i)
					BuyingPrice[i] = 0;
				tribbleMessage = false;
				jarekStatus = 0;
				invasionStatus = 0;
				experimentStatus = 0;
				fabricRipProbability = 0;
				possibleToGoThroughRip = false;
				arrivedViaWormhole = false;
				veryRareEncounter = 0;
				 resetNewsEvents();
				wildStatus = 0;
				reactorStatus = 0;
				trackedSystem = -1;
				showTrackedRange = true;
				justLootedMarie = false;
				chanceOfVeryRareEncounter = CHANCEOFVERYRAREENCOUNTER;
				alreadyPaidForNewspaper = false;
				canSuperWarp = false;
				gameLoaded = false;
				leaveEmpty = 0;
				reserveMoney = false;
				litterWarning= false;
				alwaysInfo = true;
				encounterType = 0;
				alwaysIgnorePolice = false;
				alwaysIgnorePirates = false;
				alwaysIgnoreTraders = false;
				alwaysIgnoreTradeInOrbit = false;
				trackAutoOff = false;
				ChanceOfTradeInOrbit = 10;
				autoFuel = false;
				autoRepair = false;
				playerShipNeedsUpdate = false;
				opponentShipNeedsUpdate = false;
				autoAttack = false;
				autoFlee = false;
				textualEncounters = true;
				continuous = false;
				encounterWindow = false;
				
				// Initialize Ship
				Ship.Type =	0;
				for (i=0; i<MAXTRADEITEM; ++i)
					Ship.Cargo[i] = 0;
				Ship.Weapon[0] = 0;
				for (i=1; i<MAXWEAPON; ++i)
					Ship.Weapon[i] = 0;
				for (i=0; i<MAXSHIELD; ++i)
				{
					Ship.Shield[i] =0;
					Ship.ShieldStrength[i] = 0;
				}
				for (i=0; i<MAXGADGET; ++i)
					Ship.Gadget[i] =0;
				Ship.Crew[0] = 0;
				for (i=1; i<MAXCREW; ++i)
					Ship.Crew[i] = 0;
				Ship.Fuel =  GetFuelTanks();
				Ship.Hull =s[Ship.Type].HullStrength;
				Ship.Tribbles = 0;

				
				DeterminePrices(currentSystem);
				
				
				//[self SaveGame:"Autosave"];
			//	[self playSound:eBeginGame];
			updateMercenary0Data();
				//return true;*/
			}
			public static int GetRandom(int a){
				   Random r=new Random();
			       int i=r.nextInt(a)%a;
			       return i;
			}
			public static int SqrDistance( SOLARSYSTEM a  , SOLARSYSTEM b)
			{
				return (SQR( a.X - b.X ) + SQR( a.Y - b.Y ));
			}
			public static int SQR(int i)
			{
				return i*i;
			}
			public static void InitializeTradeItems(int index) {
				int i;
				
				for (i=0; i<MAXTRADEITEM; i++)
				{
					if (((i == NARCOTICS) && (!p[SolarSystem[index].Politics].DrugsOk)) ||
						((i == FIREARMS) && (!p[SolarSystem[index].Politics].FirearmsOk)) ||
						(SolarSystem[index].TechLevel < t[i].TechProduction))
					{
						SolarSystem[index].Qty[i] = 0;
						//continue;
					}
					
					SolarSystem[index].Qty[i] = ((9 + GetRandom( 5 )) - ( t[i].TechTopProduction - SolarSystem[index].TechLevel )) * (1 + SolarSystem[i].Size);
					
					// Because of the enormous profits possible, there shouldn't be too many robots or narcotics available
					if (i == ROBOTS || i == NARCOTICS) 
						SolarSystem[index].Qty[i] = ((SolarSystem[index].Qty[i] * (5 - gameDifficulty)) / (6 - gameDifficulty)) + 1;
					
					if (t[i].CheapResource >= 0)
						if (SolarSystem[index]. SpecialResources ==
							t[i].CheapResource)
							SolarSystem[index].Qty[i] = (SolarSystem[index].Qty[i] * 4) / 3;
					
					if (t[i].ExpensiveResource >= 0)
						if (SolarSystem[index].SpecialResources ==t[i].ExpensiveResource)
							SolarSystem[index].Qty[i] = (SolarSystem[index].Qty[i] * 3) >> 2;
					
					if (t[i].DoublePriceStatus >= 0)
						if (SolarSystem[index].Status == t[i].DoublePriceStatus)
							SolarSystem[index].Qty[i] = SolarSystem[index].Qty[i] / 5;
					
					SolarSystem[index].Qty[i] = SolarSystem[index].Qty[i] - GetRandom( 10 ) + GetRandom( 10 );
					
					if (SolarSystem[index].Qty[i] < 0)
						SolarSystem[index].Qty[i] = 0;
				}
			}
			public static boolean wormholeExists(int a ,int b)
			{
				int i;
				
				i = 0;
				while (i<MAXWORMHOLE)
				{
					if (Wormhole[i] == a)
						break;
					++i;
				}
				
				if (i < MAXWORMHOLE)
				{
					if (b < 0)
						return true;
					else if (i < MAXWORMHOLE - 1)
					{
						if (Wormhole[i+1] == b)
							return true;
					}
					else if (Wormhole[0] == b)
						return true;
					
				}
				
				return false;
			}
			public static int RandomSkill()
			 {
				    Random randomGenerator = new Random();

				 return 1+ randomGenerator.nextInt(5)+randomGenerator.nextInt(6);
			 }
			public static int RealDistance(int solarSystem2  , int solarSystem3)
			{
				return  (int) (Math.sqrt(  SqrDistance(SolarSystem[solarSystem2] ,SolarSystem[ solarSystem3] )));
			}
			public static void resetNewsEvents()
			{
				newsSpecialEventCount = 0;
			}
			public static int IsHireExist()
			{
				return  GetForHire() ;
			}
			public static int GetForHire()
			{
				int ForHire = -1;
				int i;
				
				for (i=1; i<MAXCREWMEMBER; ++i)
				{
					if (i == Ship.Crew[1] || i == Ship.Crew[2])
						continue;
					if (Mercenary[i].CurSystem ==currentSystem)
					{
						ForHire = i;
						break;
					}
				}
				
				return ForHire;
			}
			public static boolean IsSpecialExist()
			{
				int OpenQ =  OpenQuests();

				if  ((SolarSystem[currentSystem].Special < 0) || 
					 (SolarSystem[currentSystem].Special == BUYTRIBBLE && Ship.Tribbles <= 0) ||
					 (SolarSystem[currentSystem].Special == ERASERECORD && policeRecordScore >= DUBIOUSSCORE) ||
					 (SolarSystem[currentSystem].Special == CARGOFORSALE && (filledCargoBays() >  totalCargoBays() - 3)) ||
					 ((SolarSystem[currentSystem].Special == DRAGONFLY || SolarSystem[currentSystem].Special == JAPORIDISEASE ||
					   SolarSystem[currentSystem].Special == ALIENARTIFACT || SolarSystem[currentSystem].Special == AMBASSADORJAREK ||
					   SolarSystem[currentSystem].Special == EXPERIMENT) && (policeRecordScore < DUBIOUSSCORE)) ||
					 (SolarSystem[currentSystem].Special == TRANSPORTWILD && (policeRecordScore >= DUBIOUSSCORE)) ||
					 (SolarSystem[currentSystem].Special == GETREACTOR && (policeRecordScore >= DUBIOUSSCORE || reputationScore < AVERAGESCORE || reactorStatus != 0)) ||
					 (SolarSystem[currentSystem].Special == REACTORDELIVERED && !(reactorStatus > 0 && reactorStatus < 21)) ||
					 (SolarSystem[currentSystem].Special == MONSTERKILLED && monsterStatus < 2) ||
					 (SolarSystem[currentSystem].Special == EXPERIMENTSTOPPED && !(experimentStatus >= 1 && experimentStatus < 12)) ||
					 (SolarSystem[currentSystem].Special == FLYBARATAS && dragonflyStatus < 1) ||
					 (SolarSystem[currentSystem].Special == FLYMELINA && dragonflyStatus < 2) ||
					 (SolarSystem[currentSystem].Special == FLYREGULAS && dragonflyStatus < 3) ||
					 (SolarSystem[currentSystem].Special == DRAGONFLYDESTROYED && dragonflyStatus < 5) ||
					 (SolarSystem[currentSystem].Special == SCARAB && (reputationScore < AVERAGESCORE || scarabStatus != 0)) ||
					 (SolarSystem[currentSystem].Special == SCARABDESTROYED && scarabStatus != 2) ||
					 (SolarSystem[currentSystem].Special == GETHULLUPGRADED && scarabStatus != 2) ||
					 (SolarSystem[currentSystem].Special == MEDICINEDELIVERY && japoriDiseaseStatus != 1) ||
					 (SolarSystem[currentSystem].Special == JAPORIDISEASE && (japoriDiseaseStatus != 0)) ||
					 (SolarSystem[currentSystem].Special == ARTIFACTDELIVERY && !artifactOnBoard) ||
					 (SolarSystem[currentSystem].Special == JAREKGETSOUT && jarekStatus != 1) ||
					 (SolarSystem[currentSystem].Special == WILDGETSOUT && wildStatus != 1) ||
					 (SolarSystem[currentSystem].Special == GEMULONRESCUED && !(invasionStatus >= 1 && invasionStatus <= 7)) ||
					 (SolarSystem[currentSystem].Special == MOONFORSALE && (moonBought ||  currentWorth() < (COSTMOON * 4) / 5)) ||
					 (SolarSystem[currentSystem].Special == MOONBOUGHT && moonBought != true)) 
					return false;
				else if  (OpenQ > 3 &&
				 (SolarSystem[currentSystem].Special == TRIBBLE ||
				  SolarSystem[currentSystem].Special == SPACEMONSTER ||
				  SolarSystem[currentSystem].Special == DRAGONFLY ||
				  SolarSystem[currentSystem].Special == JAPORIDISEASE ||
				  SolarSystem[currentSystem].Special == ALIENARTIFACT ||
				  SolarSystem[currentSystem].Special == AMBASSADORJAREK ||
				  SolarSystem[currentSystem].Special == ALIENINVASION ||
				  SolarSystem[currentSystem].Special == EXPERIMENT ||
				  SolarSystem[currentSystem].Special == TRANSPORTWILD ||
				  SolarSystem[currentSystem].Special == GETREACTOR ||
				  SolarSystem[currentSystem].Special == SCARAB)) 
					return false;
				else
					return true;
			}
			
			public static int totalCargoBays()  //Calculate total cargo bays
			{
				int Bays;
				int i;
				Bays=s[Ship.Type].CargoBays;
				for(i=0;i<MAXGADGET;++i)
				{
					if(Ship.Gadget[i]==EXTRABAYS)
						Bays +=5;
				}
					if(japoriDiseaseStatus ==1)
						Bays-=10;
					// since the quest ends when the reactor
					if (reactorStatus > 0 && reactorStatus < 21)
						Bays -= (5 + 10 - (reactorStatus - 1)/2);
					
					return Bays;
					
			}
			public static int filledCargoBays()//Calculate total filled cargo bays
			{
				int sum, i;
				sum =0;
				for(i=0;i<MAXTRADEITEM;i++)
					sum = sum + Ship.Cargo[i];
				return sum;
			}
			public static int OpenQuests()
			{
				int r = 0;
				
				if (monsterStatus == 1)
					++r;
				
				if (dragonflyStatus >= 1 && dragonflyStatus <= 4)
					++r;
				else if (SolarSystem[ZALKONSYSTEM].Special == INSTALLLIGHTNINGSHIELD)
					++r;
				
				if (japoriDiseaseStatus == 1)
					++r;
				
				if (artifactOnBoard)
					++r;
				
				if (wildStatus == 1)
					++r;
				
				if (jarekStatus == 1)
					++r;
				
				if (invasionStatus >= 1 && invasionStatus < 7)
					++r;
				else if (SolarSystem[GEMULONSYSTEM].Special == GETFUELCOMPACTOR)
					++r;
				
				if (experimentStatus >= 1 && experimentStatus < 11)
					++r;
				
				if (reactorStatus >= 1 && reactorStatus < 21)
					++r;
				
				if (SolarSystem[NIXSYSTEM].Special == GETSPECIALLASER)
					++r;
				
				if (scarabStatus == 1)
					++r;
				
				if (Ship.Tribbles > 0)
					++r;
				
				if (moonBought)
					++r;
				
				return r;
			}
			
			public static boolean ExecuteAction(boolean CommanderFlees)
			{
				Boolean CommanderGotHit, OpponentGotHit;
				int OpponentHull=0;
				int ShipHull=0;
			
				int PrevencounterType;
				
				
				CommanderGotHit = false;
				OpponentHull = Opponent.Hull;
				ShipHull = Ship.Hull;
				
				// Fire shots
				if (encounterType == PIRATEATTACK || encounterType == POLICEATTACK ||
					encounterType == TRADERATTACK || encounterType == SPACEMONSTERATTACK ||
					encounterType == DRAGONFLYATTACK || encounterType == POSTMARIEPOLICEENCOUNTER ||
					encounterType == SCARABATTACK || encounterType == FAMOUSCAPATTACK)
				{
					CommanderUnderAttack=true;
					CommanderGotHit =  ExecuteAttack(Opponent,Ship, CommanderFlees ,CommanderUnderAttack);
				}
				
				OpponentGotHit = false;
				
				if (!CommanderFlees)
				{
					if (encounterType == POLICEFLEE || encounterType == TRADERFLEE ||
						encounterType == PIRATEFLEE)	
					{
						Flees=true;
						CommanderUnderAttack=false;
						
						OpponentGotHit = ExecuteAttack(Ship,Opponent , Flees, CommanderUnderAttack);
					}
					else
					{
						Flees=false;
					    CommanderUnderAttack=false;
					    
						OpponentGotHit = ExecuteAttack( Ship,Opponent ,Flees, CommanderUnderAttack);
					}
				}
				
				if (CommanderGotHit)
				{
					playerShipNeedsUpdate = true;
					//[self playSound:eCommanderHit];		
				}
				if (OpponentGotHit)
				{
					opponentShipNeedsUpdate = true;
			//		[self playSound:eFireOpponent];
				}
				
				// Determine whether someone gets destroyed
				if (Ship.Hull <= 0 && Opponent.Hull <= 0)
				{
					autoAttack = false;
					autoFlee = false;
					
					if (escapePod)
					{
					 EscapeWithPod();
					 
						return  true ;
					}
					else
					{
						
				//		[self FrmAlert:"BothDestroyedAlert"];
				//		[self showDestroyedShipWindow];
						
					}
					return false;
				}
				else if (Opponent.Hull <= 0)
				{
					autoAttack = false;
					autoFlee = false;
					
					if (ENCOUNTERPIRATE( encounterType ) && Opponent.Type != MANTISTYPE && policeRecordScore >= DUBIOUSSCORE)
					{
						//NSString * str = [NSString stringWithFormat:"You earned a bounty of %i cr.", [self GetBounty:&Opponent]];
					//	[self FrmAlert:str];
					}
					else
					{
					//	[self FrmAlert:"OpponentDestroyedAlert"];
					}
					if (ENCOUNTERPOLICE( encounterType ))
					{
						policeKills++;
						policeRecordScore += KILLPOLICESCORE;
					}
			
					else if (ENCOUNTERFAMOUS( encounterType))
					{
						if (reputationScore < DANGEROUSREP)
						{
							reputationScore = DANGEROUSREP;
						}
						else
						{
							reputationScore += 100;
						}
						// bump news flag from attacked to ship destroyed
						replaceNewsEvent(latestNewsEvent(), (latestNewsEvent() + 10));
						
					}
					
					else if (ENCOUNTERPIRATE( encounterType ))
					{
						if (Opponent.Type != MANTISTYPE)
						{
						    credits +=  GetBounty(Opponent);
							policeRecordScore += KILLPIRATESCORE;
						    Scoop();
						}
						pirateKills++;
					}
					else if (ENCOUNTERTRADER( encounterType ))
					{
						traderKills++;
						policeRecordScore += KILLTRADERSCORE;
						Scoop();
					}
					else if (ENCOUNTERMONSTER( encounterType ))
					{
						pirateKills++;
						policeRecordScore += KILLPIRATESCORE;
						monsterStatus = 2;
					}
					else if (ENCOUNTERDRAGONFLY( encounterType ))
					{
						pirateKills++;
						policeRecordScore += KILLPIRATESCORE;
						dragonflyStatus = 5;
					}
					else if (ENCOUNTERSCARAB( encounterType ))
					{
						pirateKills++;
						policeRecordScore += KILLPIRATESCORE;
						scarabStatus = 2;
					}
					reputationScore += 1 + (Opponent.Type>>1);
					return false;
				}
				else if (Ship.Hull <= 0)
				{
					autoAttack = false;
					autoFlee = false;
					
					if (escapePod)
					{
						 EscapeWithPod();
						return true;
					}
					else
					{
				//		[self FrmAlert:"ShipDestroyedAlert"];
				//		[self showDestroyedShipWindow];

					}
					return false;
				}
				
				// Determine whether someone gets away.
				if (CommanderFlees)
				{
					if (gameDifficulty == BEGINNER)
					{
						autoAttack = false;
						autoFlee = false;
						
						//[self FrmAlert: "YouEscapedAlert"];

						if (ENCOUNTERMONSTER( encounterType ))
							monsterHull = Opponent.Hull;
						
						return false;
					}
					else if ((GetRandom( 7 ) + ( PilotSkill(Ship) / 3)) * 2 >=  GetRandom( PilotSkill(Opponent ) ) * (2 + gameDifficulty))
				    {
						autoAttack = false;
						autoFlee = false;
						if (CommanderGotHit)
						{
					//	int	offset=6;
					//	boolean commandersShip=true;
						}
						// ShowShip(Ship ,offset, commandersShip);
							
					//		[self FrmAlert:"YouEscapedWithDamageAlert"];

					
						else
						{
					//		[self FrmAlert:"YouEscapedAlert"];
						}
						if (ENCOUNTERMONSTER( encounterType ))
						{
							monsterHull = Opponent.Hull;
						}
						return false;
					}
				}
			else if (encounterType == POLICEFLEE || encounterType ==TRADERFLEE || encounterType == PIRATEFLEE || encounterType == TRADERSURRENDER || encounterType == PIRATESURRENDER)	
				{
					if (4*GetRandom(  PilotSkill(Ship) ) <= GetRandom( (07 + ( PilotSkill(Opponent) / 3))) * 2)
					{
						autoAttack = false;
						autoFlee = false;

					//	[self FrmAlert:"OpponentEscapedAlert"];
						return false;
					}
				}
				// Determine whether the opponent's actions must be changed
				PrevencounterType = encounterType;
				
				if (Opponent.Hull < OpponentHull)
				{
					if (ENCOUNTERPOLICE( encounterType ))
					{
						if (Opponent.Hull < (OpponentHull >>1))
							if (Ship.Hull < (ShipHull >>1))
							{
								if (GetRandom( 10 ) > 5)
									encounterType = POLICEFLEE;
							}	
							else
							{
								encounterType = POLICEFLEE;
					         }
					}
				}
					else if (encounterType == POSTMARIEPOLICEENCOUNTER)
					{
						encounterType = POLICEATTACK;
					}
					else if (ENCOUNTERPIRATE( encounterType ))
					{
						if (Opponent.Hull < ((OpponentHull * 2) / 3))
						{
							if (Ship.Hull < (ShipHull * 2) / 3)
							{
								if (GetRandom( 10 ) > 3)
									encounterType = PIRATEFLEE;
							}
							else
							{
								
								encounterType = PIRATEFLEE;
								if (GetRandom( 10 ) > 8 && Opponent.Type < MAXSHIPTYPE)
									encounterType = PIRATESURRENDER;
							}
						}
					}
					else if (ENCOUNTERTRADER( encounterType ))
					{
						
						if (Opponent.Hull < (OpponentHull * 2) / 3)
						{
							if (GetRandom( 10 ) > 3)
								encounterType = TRADERSURRENDER;
							else
								encounterType = TRADERFLEE;
						}
						else if (Opponent.Hull < ((OpponentHull * 9) / 10))
						{
							if (Ship.Hull < (ShipHull * 2) / 3)
							{
								// If you get damaged a lot, the trader tends to keep shooting
								if (GetRandom( 10 ) > 7)
									encounterType = TRADERFLEE;
							}
							else if (Ship.Hull < (ShipHull * 9) / 10)
							{
								if (GetRandom( 10 ) > 3)
									encounterType = TRADERFLEE;
							}
							else
								encounterType = TRADERFLEE;
						}
					}
				
				
				if (PrevencounterType != encounterType)
				{
					if (!(autoAttack && (encounterType == TRADERFLEE || encounterType == PIRATEFLEE || encounterType == POLICEFLEE)))
						autoAttack = false;
					autoFlee = false;
				}
				
			 String  str;
				if (ENCOUNTERPOLICE(PrevencounterType)==true)
				{
				 	str ="police ship";
				}
					else if (ENCOUNTERPIRATE( PrevencounterType ))
				{
					if (Opponent.Type == MANTISTYPE)
					{
				 		str ="alien ship";
					}
					else	
					{
				 		str ="pirate ship";
						
					}
				}
				else if (ENCOUNTERTRADER( PrevencounterType ))
				{
				 	str ="trader ship";
				}
					else if (ENCOUNTERMONSTER( PrevencounterType ))
					{
						str ="monster";
					}
						else if (ENCOUNTERDRAGONFLY( PrevencounterType ))
						{
				 	str ="Dragonfly";
						}
				else if (ENCOUNTERSCARAB( PrevencounterType ))
				{
				 	str ="Scarab";
				}
					else if (ENCOUNTERFAMOUS( PrevencounterType))
					{
				 	str ="Captain";
					}
				
				//NSString * final, *final1, *final2;
				//final ="";
			//	final1 ="";
				//final2 ="";	
				if (CommanderGotHit)
				{
					//final1 = [NSString stringWithFormat:"The % hits you.", str];
				} 
				
				if (!(PrevencounterType == POLICEFLEE || PrevencounterType == TRADERFLEE ||
					  PrevencounterType == PIRATEFLEE) && !CommanderGotHit)
				{
					//final1 = [NSString stringWithFormat:"The % missed you.", str];		
				}
				
				if (OpponentGotHit)
				{//TODO:
					
					//final = [NSString stringWithFormat:"You hit the %.", str];
					
				}
				
				if (!CommanderFlees && !OpponentGotHit)
				{
				//	final = [NSString stringWithFormat:"You missed the %.", str];		
					
				}
				
				if (PrevencounterType == POLICEFLEE || PrevencounterType == TRADERFLEE ||
					PrevencounterType == PIRATEFLEE)	
				{
					//final2 = [NSString stringWithFormat:"The % didn't get away.", str];
					
				}
				
				if (CommanderFlees)
				{
					//final2 = [NSString stringWithFormat:"The % is still following you.", str];
					
				}
				
				//final = [NSString stringWithFormat:"%\n%\n%.", final1, final, final2];
				
				//[self EncounterDisplayNextAction: false];
				//[encounterViewControllerInstance SetLabelText:final];

				return true;
			}
public static double getSellEquipmentPrice(int index)
{
	if (index < MAXWEAPON){
		Log.v("LOG_TAG" ,"index" +index);
		return WEAPONSELLPRICE(index);	
	}
	else if (index < MAXWEAPON + MAXSHIELD) {
			return  SHIELDSELLPRICE(index - MAXWEAPON);				
		} 
		else {
			return GADGETSELLPRICE(index - MAXWEAPON - MAXSHIELD);							
		}	
}
	public static boolean ENCOUNTERPOLICE(int a )
	{
		if(a >= POLICE && a <= MAXPOLICE)
			return true;
		else 
			return	false;
	}
	public static boolean ENCOUNTERTRADER(int a )
	{
		if(a >= TRADER && a <= MAXTRADER)
			return true;
		else
			return false;
	}
	public static boolean ENCOUNTERPIRATE(int a) {
		// TODO Auto-generated method stub
		 if(a >= POLICE && a <= MAXPOLICE)
			 return true;
		 
		return false;
	}
	public static int PilotSkill(SHIP Sh)
    {	
    	int i;
    	int MaxSkill;
    	
    	MaxSkill = Mercenary[Sh.Crew[0]].Pilot;
    	
    	for (i=1; i<MAXCREW; ++i)
    	{
    		if (Sh.Crew[i] < 0)
    			break;
    		if (Mercenary[Sh.Crew[i]].Pilot > MaxSkill)
    			MaxSkill = Mercenary[Sh.Crew[i]].Pilot;
    	}
    	
    	if (HasGadget(Sh,NAVIGATINGSYSTEM))
    		MaxSkill += SKILLBONUS;			
    	if (HasGadget(Sh,CLOAKINGDEVICE))
    		MaxSkill += CLOAKBONUS;			
    	
    	return  AdaptDifficulty(MaxSkill);
    }
	public static  boolean HasGadget( SHIP Sh ,int Gg)
	{
	    int i;	
	    for (i=0; i<MAXGADGET; ++i)
	    {
		    if (Sh.Gadget[i] < 0)
		        continue;
	        if (Sh.Gadget[i] == Gg)
		        return true;
	    }
		
	    return false;
	}
	public static boolean ENCOUNTERMONSTER(int  a )
	{
		if(a >= SPACEMONSTERATTACK && a <= MAXSPACEMONSTER)
		{
			return true;
		}
		else return false;
	}
	public static boolean ENCOUNTERSCARAB(int a )
	{
		if(a >= SCARABATTACK && a <= MAXSCARAB)
			return true;
		else return false;
		
	}
	public static boolean ENCOUNTERDRAGONFLY( int a )
	{
		if(a >= DRAGONFLYATTACK && a <= MAXDRAGONFLY)
			return true;
		else
			return false;
	}
	public static boolean ENCOUNTERFAMOUS(int a )
	{
		if(a >= FAMOUSCAPTAIN && a <= MAXFAMOUSCAPTAIN)
			return true;
		else
			return false;
		
	}
	public static boolean ExecuteAttack(SHIP Attacker,SHIP Defender ,boolean Flees,boolean CommanderUnderAttack)
    {
    	int Damage, prevDamage;
    	int i;
    	Random GetRandom = new Random();
    	// On beginner level, if you flee, you will escape unharmed.
    	if (gameDifficulty == BEGINNER && CommanderUnderAttack && Flees)
    		return false;
    	
    	// Fighterskill attacker is pitted against pilotskill defender; if defender
    	// is fleeing the attacker has a free shot, but the chance to hit is smaller
    	if (GetRandom.nextInt( FighterSkill( Attacker) + s[Defender.Type].Size ) < (Flees ? 2 : 1) * GetRandom.nextInt( 5 + ( PilotSkill(Defender)) >> 1) )
    		// Misses
    		return false;
    	
    	if (TotalWeapons(Attacker, -1, -1) <= 0)
    		Damage = 0;
    	else if (Defender.Type == SCARABTYPE)
    	{
    		if ( TotalWeapons(Attacker,PULSELASERWEAPON, PULSELASERWEAPON)  <= 0 &&
    		     TotalWeapons(Attacker,MORGANLASERWEAPON,MORGANLASERWEAPON)  <= 0)
    			Damage = 0;
    		else 
    			Damage =  GetRandom.nextInt((int) ((TotalWeapons(Attacker,PULSELASERWEAPON,PULSELASERWEAPON)  +
    								   TotalWeapons(Attacker,MORGANLASERWEAPON,MORGANLASERWEAPON) ) * (100 + 2*( EngineerSkill(Attacker ) / 100)) ));
    	}
    	else
    		Damage = GetRandom.nextInt( (int) ( TotalWeapons(Attacker, -1,-1) * (100 + 2*( EngineerSkill(Attacker)) / 100) ));
    	
    	if (Damage <= 0)
    		return false;
    	
    	// Reactor on board -- damage is boosted!
    	if (CommanderUnderAttack && reactorStatus > 0 && reactorStatus < 21)
    	{
    		if (gameDifficulty < NORMAL)
    			Damage *= 1 + (gameDifficulty + 1)*0.25;
    		else
    			Damage *= 1 + (gameDifficulty + 1)*0.33;
    	}
    	
    	// First, shields are depleted
    	for (i=0; i<MAXSHIELD; ++i)
    	{
    		if (Defender.Shield[i] < 0)
    			break;
    		if (Damage <= Defender.ShieldStrength[i])
    		{
    			Defender.ShieldStrength[i] -= Damage;
    			Damage = 0;
    			break;
    		}
    		Damage -= Defender.ShieldStrength[i];
    		Defender.ShieldStrength[i] = 0;
    	}
    	
    	prevDamage = Damage;
    	
    	// If there still is damage after the shields have been depleted, 
    	// this is subtracted from the hull, modified by the engineering skill
    	// of the defender.
    	if (Damage > 0)
    	{
    		Damage -= GetRandom.nextInt(  EngineerSkill( Defender) );
    		if (Damage <= 0)
    			Damage = 1;
    		// At least 2 shots on Normal level are needed to destroy the hull 
    		// (3 on Easy, 4 on Beginner, 1 on Hard or Impossible). For opponents,
    		// it is always 2.
    		if (CommanderUnderAttack && scarabStatus == 3)
    			Damage = min( Damage, ( GetHullStrength()/
    								   (CommanderUnderAttack ? max( 1, (IMPOSSIBLE-gameDifficulty) ) : 2)) );
    		else
    			Damage = min( Damage, (s[Defender.Type].HullStrength/
    								   (CommanderUnderAttack ? max( 1, (IMPOSSIBLE-gameDifficulty) ) : 2)) );
    		Defender.Hull -= Damage;
    		if (Defender.Hull < 0)
    			Defender.Hull = 0;
    	}
    	
    	if (Damage != prevDamage)
    	{
    		if (CommanderUnderAttack)
    		{
    			playerShipNeedsUpdate = true;
    		}
    		else
    		{
    			opponentShipNeedsUpdate = true;
    		}
    	}
    	
    	return true;
    }
	public static  int EngineerSkill(SHIP Sh) 
	{
		int i;
		char MaxSkill;
		
		MaxSkill = (char) Mercenary[Sh.Crew[0]].Engineer;
		
		for (i=1; i<MAXCREW; ++i)
		{
			if (Sh.Crew[i] < 0)
				break;
			if (Mercenary[Sh.Crew[i]].Engineer > MaxSkill)
				MaxSkill = (char) Mercenary[Sh.Crew[i]].Engineer;
		}
		
		if ( HasGadget(Sh ,AUTOREPAIRSYSTEM))
			MaxSkill += SKILLBONUS;			
		
		return  AdaptDifficulty(MaxSkill);
	}
	 public static int FighterSkill (SHIP Sh){
	    	int i;
	    	int MaxSkill;
	    	MaxSkill=Mercenary[Sh.Crew[0]].Fighter;
	    	for(i=1;i<MAXCREW;i++)
	    	{
	    		if(Sh.Crew[i]<0)
	    	     break;
	    		if (Mercenary[Sh.Crew[i]].Fighter > MaxSkill)
	    			MaxSkill = Mercenary[Sh.Crew[i]].Fighter;
	    	}
	    	if ( HasGadget(Sh,TARGETINGSYSTEM))
	    		MaxSkill += SKILLBONUS;			
	    	
	    	return  AdaptDifficulty(MaxSkill);
	    	
	    }
	 public static int TotalWeapons(SHIP Sh,int minWeapon,int maxWeapon)
	    {
	    	
	    	int i;
	    	int j;
	    	
	    	j=0;
	    	
	    	for(i=0;i<MAXWEAPON;++i)
	    	{
	    		if(Sh.Weapon[i]<0)
	    			break;
	    		if((minWeapon!=-1 &&Sh.Weapon[i]<minWeapon)|| maxWeapon!=-1 && Sh.Weapon[i]>maxWeapon)
	                continue;	
	    		j+=Weapontype[Sh.Weapon[i]].Power;
	    	}
	    	return j;
	    }
	 public static int GetBounty(SHIP Sh)
	 {
	 	int Bounty =  EnemyShipPrice(Sh);
	 	
	 	Bounty /= 200;
	 	Bounty /= 25;	
	 	Bounty *= 25;
	 	if (Bounty <= 0)
	 		Bounty = 25;
	 	if (Bounty > 2500)
	 		Bounty = 2500;
	 	
	 	return Bounty;
	 }
	 public static int EnemyShipPrice ( SHIP Sh )
	 {
	 	int i;
	 	int CurPrice;
	 	
	 	CurPrice = s[Sh.Type].Price;
	 	for (i=0; i<MAXWEAPON; ++i)
	 		if (Sh.Weapon[i] >= 0)
	 			CurPrice += Weapontype[Sh.Weapon[i]].Price;
	 	for (i=0; i<MAXSHIELD; ++i)
	 		if (Sh.Shield[i] >= 0)
	 			CurPrice += Shieldtype[Sh.Shield[i]].Price;
	 	// Gadgets aren't counted in the price, because they are already taken into account in
	 	// the skill adjustment of the price.
	 	
	 	CurPrice = CurPrice * (2 *  PilotSkill( Sh) +  EngineerSkill(Sh) + 3 *  FighterSkill (Sh)	)/ 60;
	 	
	 	return CurPrice;
	 }	
	
	public static void Scoop()
	 {
	 //	[self showPlunderForm:ePickupCannister];
	 	 	
	 }
	public static void EscapeWithPod(){
    	if(credits>500)
    		credits-=500;
    	else
    	{
    		debt+=(500 -credits);
    		credits=0;
    		
    	}
    	IncDays(3);
    	CreateFlea();
    	
    	if(scarabStatus==3)
    		scarabStatus=0;
    	Arrival();
    	
    	if(reactorStatus >0 &&reactorStatus<21)
           reactorStatus=0;
    	if(japoriDiseaseStatus==1)
    		japoriDiseaseStatus=0;
    	if(artifactOnBoard)
    		artifactOnBoard=false;
    	if(jarekStatus==1)
            jarekStatus=0;
    	if(wildStatus==1)
    	{
    		policeRecordScore+=CAUGHTWITHWILDSCORE;
    	   // addNewsEvent(WILDARRESTED);
    	    wildStatus=0;
    	} 
    	if(Ship.Tribbles>0)
    	{
    		Ship.Tribbles=0;
    	}
    	if(insurance)
           credits+=currentShipPriceWithoutCargo(true);
           
    }
	public static void IncDays(int Amount)
    {
    	days += Amount;
    	if (invasionStatus > 0 && invasionStatus < 8)
    	{
    		invasionStatus += Amount;
    		if (invasionStatus >= 8)
    		{
    			SolarSystem[GEMULONSYSTEM].Special = GEMULONINVADED;
    			SolarSystem[GEMULONSYSTEM].TechLevel = 0;
    			SolarSystem[GEMULONSYSTEM].Politics = ANARCHY;
    		}
    	}
    	
    	if (reactorStatus > 0 && reactorStatus < 21)
    	{
    		reactorStatus += Amount;
    		if (reactorStatus > 20)
    			reactorStatus = 20;
    		
    	}
    	
    	if (experimentStatus > 0 && experimentStatus < 12)
    	{
    		experimentStatus += Amount;
    		if (experimentStatus > 11)
    		{
    			fabricRipProbability = FABRICRIPINITIALPROBABILITY;
    			SolarSystem[DALEDSYSTEM].Special = EXPERIMENTNOTSTOPPED;
    			// in case Amount > 1
    			experimentStatus = 12;
    			
    			// TODO:!!!!!!!!
    		//	FrmAlert("ExperimentPerformedAlert");
    			addNewsEvent(EXPERIMENTPERFORMED);			
    		}
    	}
    	else if (experimentStatus == 12 && fabricRipProbability > 0)
    	{
    		fabricRipProbability -= Amount;
    	}
    }
	public static void CreateFlea()
	{
		int i;
		CreateShip(0);
		for (i=1; i<MAXCREW; ++i)
			Ship.Crew[i] = -1;
		
		escapePod = false;
		insurance = false;
		noClaim = 0;

	}
	public static void CreateShip(int Index)
	{
		int i;
		Ship.Type=Index;
		
		
		for (i=0; i<MAXWEAPON; ++i)
	    {
			Ship.Weapon[i] = -1;
	    }
		
		for (i=0; i<MAXSHIELD; ++i)
	    {
			Ship.Shield[i] = -1;
			Ship.ShieldStrength[i] = 0;
	    }
		
		for (i=0; i<MAXGADGET; ++i)
	    {
			Ship.Gadget[i] = -1;
	    }
		
		for (i=0; i<MAXTRADEITEM; ++i)
		{
			Ship.Cargo[i] = 0;
			BuyingPrice[i] = 0;
		}
		
		Ship.Fuel =  GetFuelTanks();
		Ship.Hull = s[Ship.Type].HullStrength;
	
	}
	public static void Arrival()
	{
		//currentSystem = warpSystem;
		//SolarSystem[currentSystem].Visited = true;
	//	ShuffleStatus();
		//ChangeQuantities();
	//	DeterminePrices(currentSystem);
	//	alreadyPaidForNewspaper = false;
	//	[encounterViewControllerInstance.view removeFromSuperview];
	//	encounterWindow = false;	
	//	 SaveGame("Autosave");
	//	if (arrivedViaWormhole)
		//	[self playSound:eWormholeJump];

	}
	public static void ShuffleStatus()
	{
		int i;
		
		for (i=0; i<MAXSOLARSYSTEM; ++i)
		{
			if (SolarSystem[i].Status > 0)
			{
				if (GetRandom( 100 ) < 15)
					SolarSystem[i].Status = UNEVENTFUL;
			}
			else if (GetRandom( 100 ) < 15)
				SolarSystem[i].Status = 1 + GetRandom( MAXSTATUS - 1 );
		}
	}
	public static void DeterminePrices(int SystemID )
	{
		int i;
		
		for (i=0; i<MAXTRADEITEM; ++i)
		{
			BuyPrice[i] =  StandardPrice(i,SolarSystem[SystemID].Size ,SolarSystem[SystemID].TechLevel,	SolarSystem[SystemID].Politics ,SolarSystem[SystemID].SpecialResources);
			
			if (BuyPrice[i] <= 0)
			{
				BuyPrice[i] = 0;
				SellPrice[i] = 0;
				continue;
			}
			
			// In case of a special status, adapt price accordingly
			if (t[i].DoublePriceStatus >= 0)
				if (SolarSystem[SystemID].Status == t[i].DoublePriceStatus)
					BuyPrice[i] = (BuyPrice[i] * 3) >> 1;
			
			// Randomize price a bit
			BuyPrice[i] = BuyPrice[i] + GetRandom( t[i].Variance ) -GetRandom( t[i].Variance );
			
			// Should never happen
			if (BuyPrice[i] <= 0)
			{
				BuyPrice[i] = 0;
				SellPrice[i] = 0;
				continue;
			}
			
			SellPrice[i] = BuyPrice[i];
			if (policeRecordScore < DUBIOUSSCORE)
			{
				// Criminals have to pay off an intermediary
				SellPrice[i] = (SellPrice[i] * 90) / 100;
			}
		}
		
		 RecalculateBuyPrices(SystemID);
	}
	public static int StandardPrice(int Good,int Size,int Tech,int Government,int Resources)
	 {
		 int temp=0;
		 int Price;
		 if(((Good==NARCOTICS) && (p[Government].DrugsOk)) || ((Good==FIREARMS) && (!p[Government].FirearmsOk)))
			 	return 0;
			// Determine base price on techlevel of system
		Price = t[Good].PriceLowTech+(Tech*(int)t[Good].PriceInc);
		if(p[Government].Wanted>1)
			Price=(Price*4)/3;
		// High trader activity decreases prices
		Price= (int) (( Price* (100- ( 2 *(long) p[Government].StrengthTraders )))/100);
		// Large system = high production decreases prices
		Price=(Price*(100-Size))/100;
		
		// Special resources price adaptation		

		if(Resources>0)
		{
			if(t[Good].CheapResource>=0)
			{
				if(Resources==t[temp].CheapResource)
				{
					Price=(Price*3)/4;
				}
			}
			if(t[Good].ExpensiveResource>=0)
			{
				if(Resources==t[Good].ExpensiveResource)
				{
					Price=(Price*4)/3;
				}
			}
			
					
		}
		// If a system can't use something, its selling price is zero.
		if(Tech<t[Good].TechUsage)
		{
			return 0;
			
		}
		if(Price<0)
		{
			return 0;
		}
		return Price;
	 }
	public static void RecalculateBuyPrices(int SystemID)
	{
		int i;
		
		for (i=0; i<MAXTRADEITEM; ++i)
		{
			if (SolarSystem[SystemID].TechLevel < t[i].TechProduction)
				BuyPrice[i] = 0;
			else if (((i == NARCOTICS) && (!p[SolarSystem[SystemID].Politics].DrugsOk)) ||
					 ((i == FIREARMS) &&	(!p[SolarSystem[SystemID].Politics].FirearmsOk)))
				BuyPrice[i] = 0;
			else
			{
				if (policeRecordScore < DUBIOUSSCORE)
					BuyPrice[i] = (SellPrice[i] * 100) / 90;
				else 
					BuyPrice[i] = SellPrice[i];
				// BuyPrice = SellPrice + 1 to 12% (depending on trader skill (minimum is 1, max 12))
				BuyPrice[i] = (BuyPrice[i] * (103 + (MAXSKILL -  TraderSkill(Ship)) / 100));
				if (BuyPrice[i] <= SellPrice[i])
					BuyPrice[i] = SellPrice[i] + 1;
			}
		}
	}
	public static boolean isShipCloaked() {
		return Cloaked(Ship ,Opponent);
	}
	public static boolean  Cloaked(SHIP Sh , SHIP Opp )
	{ 
		
		return  HasGadget(Sh,CLOAKINGDEVICE) ;// &&  EngineerSkill(Sh);
	}
	public static void payback(int cash)
	 {
		 int  Amount;
		 Amount = min (debt,cash);
		 Amount = min(Amount,credits);
		 credits=  credits - Amount;
		 debt =  debt - Amount;
		 
	 }
	public static void buyCargo(int index , int Amount)  
	 {
	 	int ToBuy;
	 	
	     if (debt > DEBTTOOLARGE)
	     {
	      //   [self FrmAlert:"DebtTooLargeForBuyAlert"];
	         return;
	     }
	 	
	 	if (SolarSystem[currentSystem].Qty[index] <= 0 || BuyPrice[index] <= 0)
	 	{
	 		//		FrmAlert( NothingAvailableAlert );
	 		//[self FrmAlert:"NothingAvailableAlert" ];
	 		return;
	 	}
	 	
	 	if ( totalCargoBays() -  filledCargoBays() - leaveEmpty <= 0)
	 	{
	 		//FrmAlert( NoEmptyBaysAlert );
	 	//	[self FrmAlert: "NoEmptyBaysAlert" ];
	 		return;
	 	}
	 	
	 	if ( toSpend() < BuyPrice[index] )
	 	{
	 		//FrmAlert( CantAffordAlert );
	 	//	[self FrmAlert:"CantAffordAlert"];
	 		return;
	 	}
	 	
	 	ToBuy = min( Amount, SolarSystem[currentSystem].Qty[index] );
	 	ToBuy = min( ToBuy, totalCargoBays() - filledCargoBays() - leaveEmpty );
	 	ToBuy = min( ToBuy,  toSpend() / BuyPrice[index] );
	 	
	 	Ship.Cargo[index] += ToBuy;
	 	credits -= ToBuy * BuyPrice[index];
	 	BuyingPrice[index] += ToBuy * BuyPrice[index];
	 	SolarSystem[currentSystem].Qty[index] -= ToBuy;
	 }
	public static int getPriceDifference(int itemIndex,boolean difference ,int realPrice, int maxCount,int isSmart)
	{
		int price =  StandardPrice(itemIndex ,SolarSystem[warpSystem].Size ,SolarSystem[warpSystem].TechLevel, SolarSystem[warpSystem].Politics ,(SolarSystem[warpSystem].Visited ? SolarSystem[warpSystem].SpecialResources : -1));
		if (price > BuyPrice[itemIndex] && BuyPrice[itemIndex] > 0 && SolarSystem[currentSystem].Qty[itemIndex] > 0)
			isSmart = 1;
		else
			isSmart = 0;
		realPrice = price;
		if (BuyPrice[itemIndex] > 0)
			maxCount = credits / BuyPrice[itemIndex];
		else
			maxCount = 0;
		if (price <= 0 || (difference && BuyPrice[itemIndex] <= 0))
			return 0;
		if (difference) 
			return  (price > BuyPrice[itemIndex] ? 0  : price - BuyPrice[itemIndex]);
		else
			return  price;
	}
			
	public static void BuyFuel(int Amount)
	 {
		 int MaxFuel;
		 int Parsecs;
		 MaxFuel = (GetFuelTanks()-getFuel())*s[Ship.Type].CostOfFuel;
		 if(Amount>MaxFuel)
			 Amount=MaxFuel;
		 if(Amount>credits)
			 Amount=credits;
		 Parsecs = Amount/s[Ship.Type].CostOfFuel;
		 
		 Ship.Fuel+=Parsecs;
		 credits-=Parsecs*s[Ship.Type].CostOfFuel;
		 
	 }
	public static boolean attack()
	{
		
		if (TotalWeapons(Ship, -1, -1) <= 0)
		{
		//	[self FrmAlert: "NoWeaponsAlert"];
		//	return true;
		}
		
		
		if (ENCOUNTERPOLICE( encounterType ) || encounterType == POSTMARIEPOLICEENCOUNTER)
		{
			
			if (policeRecordScore > CRIMINALSCORE)
				policeRecordScore = CRIMINALSCORE;
			
			policeRecordScore += ATTACKPOLICESCORE;
			
			if (encounterType == POLICEIGNORE || encounterType == POLICEINSPECTION ||encounterType == POSTMARIEPOLICEENCOUNTER)
			{
				encounterType = POLICEATTACK;
			}
		}
		else if (ENCOUNTERPIRATE( encounterType ))
		{
			if (encounterType == PIRATEIGNORE)
				encounterType = PIRATEATTACK;
		}
		else if (ENCOUNTERTRADER( encounterType ))
		{
			if (encounterType == TRADERIGNORE || encounterType == TRADERBUY ||
				encounterType == TRADERSELL)
			{
				if (policeRecordScore >= CLEANSCORE)
				{
					
					policeRecordScore = DUBIOUSSCORE;
				}
				else
					policeRecordScore += ATTACKTRADERSCORE;
			}
			if (encounterType != TRADERFLEE)
			{
				if (TotalWeapons(Opponent ,-1 ,-1) <= 0)
					encounterType = TRADERFLEE;
				else if (GetRandom( ELITESCORE ) <= (reputationScore * 10) / (1 + Opponent.Type))
					encounterType = TRADERFLEE;
				else
					encounterType = TRADERATTACK;
			}
		}
		else if (ENCOUNTERMONSTER( encounterType ))
		{
			if (encounterType == SPACEMONSTERIGNORE)
				encounterType = SPACEMONSTERATTACK;
		}
		else if (ENCOUNTERDRAGONFLY( encounterType ))
		{
			if (encounterType == DRAGONFLYIGNORE)
				encounterType = DRAGONFLYATTACK;
		}
		else if (ENCOUNTERSCARAB( encounterType ))
		{
			if (encounterType == SCARABIGNORE)
				encounterType = SCARABATTACK;
		}
		else if (ENCOUNTERFAMOUS( encounterType ))
		{
			//if (encounterType != FAMOUSCAPATTACK &&
			//	FrmAlert( SureToAttackFamousAlert ) == SureToAttackFamousOkIWont)
			//	return true;
			if (policeRecordScore > VILLAINSCORE)
				policeRecordScore = VILLAINSCORE;
			policeRecordScore += ATTACKTRADERSCORE;
			if (encounterType == CAPTAINHUIEENCOUNTER)
			{
			 addNewsEvent(CAPTAINHUIEATTACKED);
			}
			else if (encounterType == CAPTAINAHABENCOUNTER)
			{
				addNewsEvent(CAPTAINAHABATTACKED);
			}
			else if (encounterType == CAPTAINCONRADENCOUNTER)
			{
				addNewsEvent(CAPTAINCONRADATTACKED);
			}
			encounterType = FAMOUSCAPATTACK;
			
		}
		if (continuous)
			autoAttack = true;
		boolean temp=false;
		if ( ExecuteAction(temp))
			{
			//return true;
			}
		if (Ship.Hull <= 0)
			{
			//return true;
			}
		 Travel();
		
		return false;
	}
public static void  Travel()
	{
		int EncounterTest, StartClicks, i, j, Repairs, FirstEmptySlot, rareEncounter;
		Boolean Pirate, Trader, Police, Mantis, TryAutoRepair, FoodOnBoard, EasterEgg;
		Boolean HaveMilitaryLaser, HaveReflectiveShield;
		int previousTribbles;
		
		if (bWaitFinishPlunder)
			return;
		
		if (clicks < 0)
			return;
		//bLastMessage = true;
		Pirate = false;
		Trader = false;
		Police = false;
		Mantis = false;
		HaveMilitaryLaser = HasWeapon(Ship ,MILITARYLASERWEAPON, true);
		HaveReflectiveShield = (HasShield(Ship, (char) REFLECTIVESHIELD));
		
		// if timespace is ripped, we may switch the warp system here.
		if (possibleToGoThroughRip &&    experimentStatus == 12 && fabricRipProbability > 0 &&
		    (GetRandom(100) < fabricRipProbability || fabricRipProbability == 25))
		{
			//[self FrmAlert:"FlyInFabricRipAlert"];
			warpSystem = GetRandom(MAXSOLARSYSTEM);
		}
		
		possibleToGoThroughRip=false;
		
		StartClicks = clicks;
		--clicks;
		Log.v("LOG_TAG" ,"start"+clicks );
		firstEncounter = true;
		
		
		while (clicks > 0)
		{
			// Engineer may do some repairs
			Repairs = GetRandom(EngineerSkill(Ship )*2);
			Ship.Hull += Repairs;
			if (Ship.Hull >  GetHullStrength())
			{
				Repairs = Ship.Hull - GetHullStrength();
				Ship.Hull = GetHullStrength();
			}
			else
				Repairs = 0;
			
			// Shields are easier to repair
			Repairs = 2 * Repairs;
			for (i=0; i<MAXSHIELD; ++i)
			{
				if (Ship.Shield[i] < 0)
					break;
				Ship.ShieldStrength[i] += Repairs;
				if (Ship.ShieldStrength[i] > Shieldtype[Ship.Shield[i]].Power)
				{
					Repairs = Ship.ShieldStrength[i] - Shieldtype[Ship.Shield[i]].Power;
					Ship.ShieldStrength[i] = Shieldtype[Ship.Shield[i]].Power;
				}
				else
					Repairs = 0;
			}
			
			// Encounter with space monster
			if ((clicks == 1) && (warpSystem == ACAMARSYSTEM) && (monsterStatus == 1))
			{
				//MemMove( &Opponent, &SpaceMonster, sizeof( Opponent ) );
				
				Opponent = SpaceMonster;
				Opponent.Hull = monsterHull;
				Mercenary[Opponent.Crew[0]].Pilot = 8 + gameDifficulty;
				Mercenary[Opponent.Crew[0]].Fighter = 8 + gameDifficulty;
				Mercenary[Opponent.Crew[0]].Trader = 1;
				Mercenary[Opponent.Crew[0]].Engineer = 1 + gameDifficulty;
				if (Cloaked(Ship ,Opponent))
					encounterType = SPACEMONSTERIGNORE;
				else
					encounterType = SPACEMONSTERATTACK;
				
				
				return;
			}
			
			// Encounter with the stolen Scarab
			if (clicks == 20 && SolarSystem[warpSystem].Special == SCARABDESTROYED &&
				scarabStatus == 1 && arrivedViaWormhole)
	 		{
			
				
				Mercenary[Opponent.Crew[0]].Pilot = 5 + gameDifficulty;
				Mercenary[Opponent.Crew[0]].Fighter = 6 + gameDifficulty;
				Mercenary[Opponent.Crew[0]].Trader = 1;
				Mercenary[Opponent.Crew[0]].Engineer = 6 + gameDifficulty;
				if (Cloaked(Ship,Opponent))
					encounterType = SCARABIGNORE;
				else
					encounterType = SCARABATTACK;
				// Duke changed.
			
				return;
			} 
			// Encounter with stolen Dragonfly
			if ((clicks == 1) && (warpSystem == ZALKONSYSTEM) && (dragonflyStatus == 4))
			{
				//MemMove( &Opponent, &Dragonfly, sizeof( Opponent ) );
				
				
				Mercenary[Opponent.Crew[0]].Pilot = 4 + gameDifficulty;
				Mercenary[Opponent.Crew[0]].Fighter = 6 + gameDifficulty;
				Mercenary[Opponent.Crew[0]].Trader = 1;
				Mercenary[Opponent.Crew[0]].Engineer = 6 + gameDifficulty;
				if (Cloaked(Ship ,Opponent))
					encounterType = DRAGONFLYIGNORE;
				else
					encounterType = DRAGONFLYATTACK;
		
				return;
			}
			
			if (warpSystem == GEMULONSYSTEM && invasionStatus > 7)
			{
				if (GetRandom( 10 ) > 4)
					Mantis = true;
			}
			else
			{
				// Check if it is time for an encounter
				EncounterTest = GetRandom( 44 - (2 * gameDifficulty) );
				
				// encounters are half as likely if you're in a flea.
				if (Ship.Type == 0)
					EncounterTest *= 2;
				
				if (EncounterTest < p[SolarSystem[warpSystem].Politics].StrengthPirates &&!raided) // When you are already raided, other pirates have little to gain
					Pirate = true;
				else if (EncounterTest < 
						 p[SolarSystem[warpSystem].Politics].StrengthPirates )
					// StrengthPolice adapts itself to your criminal record: you'll
					// encounter more police if you are a hardened criminal.
					Police = true;
				else if (EncounterTest < 
						 p[SolarSystem[warpSystem].Politics].StrengthPirates  +
						 p[SolarSystem[warpSystem].Politics].StrengthTraders)
					Trader = true;
				else if (wildStatus == 1 && warpSystem == KRAVATSYSTEM)
				{
					// if you're coming in to Kravat & you have Wild onboard, there'll be swarms o' cops.
					rareEncounter = GetRandom(100);
					if (gameDifficulty <= EASY && rareEncounter < 25)
					{
						Police = true;
					}
					else if (gameDifficulty == NORMAL && rareEncounter < 33)
					{
						Police = true;
					}
					else if (gameDifficulty > NORMAL && rareEncounter < 50)
					{
						Police = true;
					}
				}	
				if (!(Trader || Police || Pirate))
					if (artifactOnBoard && GetRandom( 20 ) <= 3)
						Mantis = true;
			}
			// Encounter with police
			if (Police)
			{
				if (firstEncounter) {
					//[self playSound:ePoliceEncounter];
					firstEncounter = false;
				}

			 GenerateOpponent("POLICE");
				encounterType = POLICEIGNORE;
				// If you are cloaked, they don't see you
				if (Cloaked(Ship ,Opponent))
					encounterType = POLICEIGNORE;
				else if (policeRecordScore < DUBIOUSSCORE)
				{
					// If you're a criminal, the police will tend to attack
					if ( TotalWeapons(Opponent ,-1 ,-1) <= 0)
					{
						if (Cloaked(Opponent ,Ship))
							encounterType = POLICEIGNORE;
						else
							encounterType = POLICEFLEE;
					}
					if (reputationScore < AVERAGESCORE)
						encounterType = POLICEATTACK;
					else if (GetRandom( ELITESCORE ) > (reputationScore / (1 + Opponent.Type)))
						encounterType = POLICEATTACK;
					else if (Cloaked(Opponent ,Ship))
						encounterType = POLICEIGNORE;
					else
						encounterType = POLICEFLEE;
				}
				else if (policeRecordScore >= DUBIOUSSCORE && 
						 policeRecordScore < CLEANSCORE && !inspected)
				{
					// If you're reputation is dubious, the police will inspect you
					encounterType = POLICEINSPECTION;
					inspected = true;
				}
				else if (policeRecordScore < LAWFULSCORE)
				{
					// If your record is clean, the police will inspect you with a chance of 10% on Normal
					if (GetRandom( 12 - gameDifficulty ) < 1 && !inspected)
					{
						encounterType = POLICEINSPECTION;
						inspected = true;
					}
				}
				else
				{
					// If your record indicates you are a lawful trader, the chance on inspection drops to 2.5%
					if (GetRandom( 40 ) == 1 && !inspected)
					{
						encounterType = POLICEINSPECTION;
						inspected = true;
					}
				}
				
				// if you're suddenly stuck in a lousy ship, Police won't flee even if you
				// have a fearsome reputation.
				if (encounterType == POLICEFLEE && Opponent.Type > Ship.Type)
				{
					if (policeRecordScore < DUBIOUSSCORE)
					{
						encounterType = POLICEATTACK;
					}
					else
					{
						encounterType = POLICEINSPECTION;
					}
				}
				
				// If they ignore you and you can't see them, the encounter doesn't take place
				if (encounterType == POLICEIGNORE && Cloaked(Opponent,Ship))
				{
					--clicks;
					Log.v("LOG_TAG" ,"if cond pol"+clicks );
					continue;
				}
				
				
				// If you automatically don't want to confront someone who ignores you, the
				// encounter may not take place
				if (alwaysIgnorePolice && (encounterType == POLICEIGNORE || 
										   encounterType == POLICEFLEE))
				{
					--clicks;
					Log.v("LOG_TAG" ,"lwaysIgnorePolic"+clicks );
					continue;
				}
				
				
				return;
			}
			// Encounter with pirate
			else if (Pirate || Mantis)
			{
				if (Mantis)
				{
					String m="MANTIS";
					 GenerateOpponent(m);
				}
				else
				{
					 String p="PIRATE";
					 GenerateOpponent(p);
				}
				// If you have a cloak, they don't see you
				if ( Cloaked(Ship,Opponent))
					encounterType = PIRATEIGNORE;
				
				// Pirates will mostly attack, but they are cowardly: if your rep is too high, they tend to flee
				else if (Opponent.Type >= 7 ||
						 GetRandom( ELITESCORE ) > (reputationScore * 4) / (1 + Opponent.Type))
					encounterType = PIRATEATTACK;
				else
					encounterType = PIRATEFLEE;
				
				if (Mantis)
					encounterType = PIRATEATTACK;
				
				// if Pirates are in a better ship, they won't flee, even if you have a very scary
				// reputation.
				if (encounterType == PIRATEFLEE && Opponent.Type > Ship.Type)
				{
					encounterType = PIRATEATTACK;
				}
				
				
				// If they ignore you or flee and you can't see them, the encounter doesn't take place
				if ((encounterType == PIRATEIGNORE || encounterType == PIRATEFLEE) && 
					 Cloaked(Opponent ,Ship))
				{
					--clicks;
					Log.v("LOG_TAG" ,"PIRATEIGNORE"+clicks );
					continue;
				}
				if (alwaysIgnorePirates && (encounterType == PIRATEIGNORE ||
											encounterType == PIRATEFLEE))
				{
					--clicks;
					Log.v("LOG_TAG" ,"alwaysIgnorePirates"+clicks );
					continue;
				}
				
				return;
			}
			// Encounter with trader
			else if (Trader)
			{	
				String t="TRADERS";
				 GenerateOpponent(t);
				encounterType = TRADERIGNORE;
				// If you are cloaked, they don't see you
				if ( Cloaked(Ship ,Opponent))
					encounterType = TRADERIGNORE;
				// If you're a criminal, traders tend to flee if you've got at least some reputation
				else if (policeRecordScore <= CRIMINALSCORE)
				{
					if (GetRandom( ELITESCORE ) <= (reputationScore * 10) / (1 + Opponent.Type))
					{
						if (Cloaked(Opponent ,Ship))
							encounterType = TRADERIGNORE;
						else
							encounterType = TRADERFLEE;
					}
				}
				
				// Will there be trade in orbit?
				if (encounterType == TRADERIGNORE )
				{
				//	NSLog("should be allowed to trade");
					if ( filledCargoBays() < totalCargoBays() &&
					     HasTradeableItems(Opponent, warpSystem,TRADERSELL))
						encounterType = TRADERSELL;
					
					// we fudge on whether the trader has capacity to carry the stuff he's buying.
					if (  HasTradeableItems(Opponent ,warpSystem, TRADERBUY) && encounterType != TRADERSELL)
						encounterType = TRADERBUY;
				}
				
				// If they ignore you and you can't see them, the encounter doesn't take place
				if ((encounterType == TRADERIGNORE || encounterType == TRADERFLEE ||
					 encounterType == TRADERSELL || encounterType == TRADERBUY) && 
					Cloaked(Opponent,Ship))
				{
					--clicks;
					Log.v("LOG_TAG" ,"tRADERIGNOR"+clicks );
					continue;
				}
				// pay attention to user's prefs with regard to ignoring traders
				if (alwaysIgnoreTraders && (encounterType == TRADERIGNORE ||encounterType == TRADERFLEE))
				{
					--clicks;
					Log.v("LOG_TAG" ,"many"+clicks );
					continue;
				}
				// pay attention to user's prefs with regard to ignoring trade in orbit
				if (alwaysIgnoreTradeInOrbit && (encounterType == TRADERBUY || encounterType == TRADERSELL))
				{
					--clicks;
					Log.v("LOG_TAG" ,"in orbit"+clicks );
					continue;
				}
				
				
				return;
			}
			 
			// Very Rare Random Events:
			// 1. Encounter the abandoned Marie Celeste, which you may loot.
			// 2. Captain Ahab will trade your Reflective Shield for skill points in Piloting.
			// 3. Captain Conrad will trade your Military Laser for skill points in Engineering.
			// 4. Captain Huie will trade your Military Laser for points in Trading.
			// 5. Encounter an out-of-date bottle of Captain Marmoset's Skill Tonic. This
			//    will affect skills depending on game difficulty level.
			// 6. Encounter a good bottle of Captain Marmoset's Skill Tonic, which will invoke
			//    IncreaseRandomSkill one or two times, depending on game difficulty.
			else if ((days > 10) && (GetRandom(1000) < chanceOfVeryRareEncounter ))
			{
				rareEncounter = GetRandom(MAXVERYRAREENCOUNTER);
				
				switch (rareEncounter)
				{
					case 0:
						if ((~(veryRareEncounter & ALREADYMARIE))>0)
						{
							veryRareEncounter += ALREADYMARIE;
							encounterType = MARIECELESTEENCOUNTER;
							String T = "TRADERS";
							 GenerateOpponent(T);
							for (i=0;i<MAXTRADEITEM;i++)
							{
								Opponent.Cargo[i]=0;
							}
							Opponent.Cargo[NARCOTICS] = min(s[Opponent.Type].CargoBays,5);
							
							return;
						}
						break;
						
					case 1:
						if ((HaveReflectiveShield )&&( pilotSkill < 10 )&& (policeRecordScore > CRIMINALSCORE )&&  ((~(veryRareEncounter & ALREADYAHAB))>0))
						{
							veryRareEncounter += ALREADYAHAB;
							encounterType = CAPTAINAHABENCOUNTER;
							String f="FAMOUSCAPTAIN";
							GenerateOpponent(f);
							
							return;
						}
						break;
						
					case 2:
						if ((HaveMilitaryLaser) &&( engineerSkill < 10) && (policeRecordScore > CRIMINALSCORE ))
						{
							if((~(veryRareEncounter  & ALREADYCONRAD ))>0)
									{
							
							veryRareEncounter += ALREADYCONRAD;
							encounterType = CAPTAINCONRADENCOUNTER;
							String f=" FAMOUSCAPTAIN";
							 GenerateOpponent("FAMOUSCAPTAIN");
							
							return;
						}}
						break;
						
					case 3:
						if ((HaveMilitaryLaser) && (traderSkill < 10 ))
						{
							if( policeRecordScore > CRIMINALSCORE )
							{
								if((~(veryRareEncounter & ALREADYHUIE))>0)
								{
							veryRareEncounter = veryRareEncounter | ALREADYHUIE;
							encounterType = CAPTAINHUIEENCOUNTER;
							String f="FAMOUSCAPTAIN";
							 GenerateOpponent(f);
							
							return;
						}}}
						break;
					case 4:
						if  ((~(veryRareEncounter & ALREADYBOTTLEOLD))>0)
						{
							veryRareEncounter = veryRareEncounter | ALREADYBOTTLEOLD;
							encounterType = BOTTLEOLDENCOUNTER;
							String t="TRADERS";
							 GenerateOpponent(t);
							Opponent.Type = BOTTLETYPE;
							Opponent.Hull = 10;
							 
							return;
						}
						break;
					case 5:
						if ((~(veryRareEncounter & ALREADYBOTTLEGOOD))>0)
						{
							veryRareEncounter = veryRareEncounter | ALREADYBOTTLEGOOD;
							encounterType = BOTTLEGOODENCOUNTER;
							String t="TRADERS";
							GenerateOpponent(t);
							Opponent.Type = BOTTLETYPE;
							Opponent.Hull = 10;
							
							return;
						}
						break;
				}
			}
			
			--clicks;
			Log.v("ExecuteAction" ,"execute"+ clicks);
		}
		
		// ah, just when you thought you were gonna get away with it...
		if (justLootedMarie)
		{			
			String p="POLICE";
			 GenerateOpponent(p);
			encounterType = POSTMARIEPOLICEENCOUNTER;
			justLootedMarie = false;
			clicks++;
			
			return;
		}
		
		if(bLastMessage)
			//[self FrmAlert: (StartClicks > 20) ? "UneventfulTripAlert" : "ArrivalAlert"];
		
		if (debt >= 75000 ) //[self FrmAlert:"DebtWarningAlert"];
		
		// Debt Reminder
		if (debt > 0 && remindLoans && days % 5 == 0)
		{
			
		}
		
		Arrival();
		
		// Reactor warnings:	
		// now they know the quest has a time constraint!
		if (reactorStatus == 2) //[self FrmAlert:"ReactorConsumeAlert"];
		{
		// better deliver it soon!
		}
		else if (reactorStatus == 16)// [self FrmAlert:"ReactorNoiseAlert"];
		{
		// last warning!
		}
		else if (reactorStatus == 18)// [self FrmAlert:"ReactorSmokeAlert"];
		{
			
		}
		if (reactorStatus == 20)
		{
			//[self FrmAlert:"ReactorMeltdownAlert"];
			reactorStatus = 0;
			if (escapePod)
			{
				 EscapeWithPod();
				return;
			}
			else
			{
			//	[self FrmAlert:"ShipDestroyedAlert"];
			//	[self showDestroyedShipWindow];

				return;
			}
			
		}
		
		if (trackAutoOff && trackedSystem == currentSystem)
		{
			trackedSystem = -1;
		}
		
		FoodOnBoard = false;
		previousTribbles = Ship.Tribbles;
		
		if (Ship.Tribbles > 0 && reactorStatus > 0 && reactorStatus < 21)
		{
			Ship.Tribbles /= 2;
			if (Ship.Tribbles < 10)
			{
				Ship.Tribbles = 0;
		//		[self FrmAlert:"TribblesAllIrradiatedAlert"];
			}
			else
			{
			//	[self FrmAlert:"TribblesIrradiatedAlert"];
			}
		}
		else if (Ship.Tribbles > 0 && Ship.Cargo[NARCOTICS] > 0)
		{
			Ship.Tribbles = 1 + GetRandom( 3 );
			j = 1 + GetRandom( 3 );
			i = min( j, Ship.Cargo[NARCOTICS] );
			BuyingPrice[NARCOTICS] = (BuyingPrice[NARCOTICS] * 
									  (Ship.Cargo[NARCOTICS] - i)) / Ship.Cargo[NARCOTICS];
			Ship.Cargo[NARCOTICS] -= i;
			Ship.Cargo[FURS] += i;
		//	[self FrmAlert:"TribblesAteNarcoticsAlert"];
		}
		else if (Ship.Tribbles > 0 && Ship.Cargo[FOOD] > 0)
		{
			Ship.Tribbles += 100 + GetRandom( Ship.Cargo[FOOD] * 100 );
			i = GetRandom( Ship.Cargo[FOOD] );
			BuyingPrice[FOOD] = (BuyingPrice[FOOD] * i) / Ship.Cargo[FOOD];
			Ship.Cargo[FOOD] = i; 
		//	[self FrmAlert:"TribblesAteFoodAlert"];
			FoodOnBoard = true;
		}
		
		if (Ship.Tribbles > 0 && Ship.Tribbles < MAXTRIBBLES)
			Ship.Tribbles += 1 + GetRandom( max( 1, (Ship.Tribbles >> (FoodOnBoard ? 0 : 1)) ) );
		
		if (Ship.Tribbles > MAXTRIBBLES)
			Ship.Tribbles = MAXTRIBBLES;
		
		if ((previousTribbles < 100 && Ship.Tribbles >= 100) ||
			(previousTribbles < 1000 && Ship.Tribbles >= 1000) ||
			(previousTribbles < 10000 && Ship.Tribbles >= 10000) ||
			(previousTribbles < 50000 && Ship.Tribbles >= 50000))
		{
			//[self playSound:eTribble];
			
		}
		
		tribbleMessage = false;
		
		Ship.Hull += GetRandom(EngineerSkill(Ship) );
		if (Ship.Hull >  GetHullStrength())
			Ship.Hull =  GetHullStrength();
		
		TryAutoRepair = true;
		if (autoFuel)
		{
			 BuyFuel(999);
			if ( getFuel() < GetFuelTanks())
			{
				if (autoRepair && Ship.Hull < GetHullStrength())
				{
					//[self FrmAlert:"NoFullTanksOrRepairsAlert"];
					TryAutoRepair = false;
				}
				else
				{
				//[self FrmAlert:"NoFullTanksAlert"];
				}
				;
			}
		}
		
		if (autoRepair && TryAutoRepair)
		{	
			 buyRepairs(9999);
			if (Ship.Hull <   GetHullStrength())
			{
				//FrmAlert:"NoFullRepairsAlert"];
			}
		}
		
	    /* This Easter Egg gives the commander a Lighting Shield */
		if (currentSystem == OGSYSTEM)
		{
			i = 0;
			EasterEgg = false;
			while (i < MAXTRADEITEM)		
			{
				if (Ship.Cargo[i] != 1)
					break;
				++i;
			}
			if (i >= MAXTRADEITEM)
		    {
	 		  //  [self FrmAlert:"EggAlert"];
				
			    FirstEmptySlot =  GetFirstEmptySlot( s[Ship.Type].ShieldSlots, Ship.Shield);
				
	            if (FirstEmptySlot >= 0)
	            {
			      	Ship.Shield[FirstEmptySlot] = LIGHTNINGSHIELD;  
				  	Ship.ShieldStrength[FirstEmptySlot] = Shieldtype[LIGHTNINGSHIELD].Power;
			      	EasterEgg = true;
			    }
				
				
			    if (EasterEgg)
			    {
				  	for (i=0; i<MAXTRADEITEM; ++i)
				    {
					 	Ship.Cargo[i] = 0;
					 	BuyingPrice[i] = 0;
					}
	            }			
			}
		}
		
		
		// It seems a glitch may cause cargo bays to become negative - no idea how...
		//for (i=0; i<MAXTRADEITEM; ++i)
		//	if (ship.Cargo[i] < 0)
		//		ship.Cargo[i] = 0;
		
		//	if (clicks > 0) {
		
	
		
	
		//[self SaveGame:"Autosave"];
		
		
		//	}
	}

public static boolean HasWeapon( SHIP Sh ,int Gg, boolean exactCompare)
{
    int i;
	
    for (i=0; i<MAXWEAPON; ++i)
    {
	    if (Ship.Weapon[i] < 0)
	        continue;
        if ((Ship.Weapon[i] == Gg) || (Ship.Weapon[i] > Gg && !exactCompare))
	        return true;
    }
	
    return false;
}
public static void GenerateOpponent(String Opp) {
	boolean Redo;
	int i = 0, j, sum, Tries;
	int d, e, f, k, m;
	int Bays;
	
	
	Tries = 1;
	
	if (Opp == "FAMOUSCAPTAIN") {
		// we just fudge for the Famous Captains' Ships...
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
		Opponent.Hull = s[MAXSHIPTYPE - 1].HullStrength;
		
		// these guys are bad-ass!
		Opponent.Crew[0] = MAXCREWMEMBER;
		Mercenary[Opponent.Crew[0]].Pilot = MAXSKILL;
		Mercenary[Opponent.Crew[0]].Fighter = MAXSKILL;
		Mercenary[Opponent.Crew[0]].Trader = MAXSKILL;
		Mercenary[Opponent.Crew[0]].Engineer = MAXSKILL;
		return;
	}
	
	if (Opp == "MANTI") {
		Tries = 1+gameDifficulty;
  }
	
	// The police will try to hunt you down with better ships if you are 
	// a villain, and they will try even harder when you are considered to
	// be a psychopath (or are transporting Jonathan Wild)
	
	if (Opp == "POLICE") {
		if (policeRecordScore < VILLAINSCORE && wildStatus != 1) {
			Tries = 3;
			 }
		else if (policeRecordScore < PSYCHOPATHSCORE || wildStatus == 1) {
			Tries = 5;
    }

		Tries = max( 1, Tries + gameDifficulty - NORMAL );
	}
	
	// Pirates become better when you get richer
	if (Opp =="PIRAT") {
		Tries =  (1 + ( currentWorth() / 100000));
		Tries = max( 1, Tries + gameDifficulty - NORMAL );
	}
	
	j = 0;
	if (Opp == "TRADERS")
		Opponent.Type = 0;
	else
		Opponent.Type = 1;
	
	k = (gameDifficulty >= NORMAL ? gameDifficulty - NORMAL : 0);
	
	while (j < Tries) {
		Redo = true;
		
		while (Redo) {
			d = GetRandom( 100 );
			i = 0;
			sum = s[0].Occurence;
			
			while (sum < d) {
				if (i >= MAXSHIPTYPE-1) {
					break;
        }
				++i;
				sum += s[i].Occurence;
			}
			
			if (Opp == "POLICE" && (s[i].Police < 0 || p[SolarSystem[warpSystem].Politics].StrengthPolice + k < s[i].Police)) {
				continue;
      }
			
			if (Opp == "PIRAT" && (s[i].Pirates < 0 || p[SolarSystem[warpSystem].Politics].StrengthPirates + k < s[i].Pirates)) {
				continue;
      }
			
			if (Opp == "TRADERS" && (s[i].Traders < 0 || p[SolarSystem[warpSystem].Politics].StrengthTraders + k < s[i].Traders)) {
				continue;
      }
			
			Redo = false;
		}
		
		if (i > Opponent.Type) {
			Opponent.Type = i;
    }

		++j;
	}
	
	if (Opp == "MANTI") {
		Opponent.Type = MANTISTYPE;
  } else {
		Tries = max( 1, (int)( currentWorth()/ 150000L) + gameDifficulty - NORMAL );    
  }	
	
	// Determine the gadgets
	if (s[Opponent.Type].GadgetSlots <= 0) {
		d = 0;
  } else if (gameDifficulty <= HARD) {
		d = GetRandom( s[Opponent.Type].GadgetSlots + 1 );
		if (d < s[Opponent.Type].GadgetSlots) {
			if (Tries > 4) {
				++d;
      } else if (Tries > 2) {
				d += GetRandom( 2 );
      }
    }
	} else {
		d =s[Opponent.Type].GadgetSlots;
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

			if ( HasGadget(Opponent, Gg)) {
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
	
	// Determine the number of cargo bays
	Bays =s[Opponent.Type].CargoBays;
	for (i=0; i<MAXGADGET; ++i)
		if (Opponent.Gadget[i] == EXTRABAYS)
			Bays += 5;
	
	// Fill the cargo bays
	for (i=0; i<MAXTRADEITEM; ++i)
		Opponent.Cargo[i] = 0;
	
	if (Bays > 5)
	{
		if (gameDifficulty >= NORMAL)
		{
			m = 3 + GetRandom( Bays - 5 );
			sum = min( m, 15 );
		}
		else
			sum = Bays;
		if (Opp == "POLICE")
			sum = 0;
		if (Opp == "PIRATE")
		{
			if (gameDifficulty < NORMAL)
				sum = (sum * 4) / 5;
			else
				sum = sum / gameDifficulty;
		}
		if (sum < 1)
			sum = 1;
		
		i = 0;
		while (i < sum)
		{
			j = GetRandom( MAXTRADEITEM );
			k = 1 + GetRandom( 10 - j );
			if (i + k > sum)
				k = sum - i;
			Opponent.Cargo[j] += k;
			i += k;
		}
	}
	
	// Fill the fuel tanks
	Opponent.Fuel = s[Opponent.Type].FuelTanks;
	
	// No tribbles on board
	Opponent.Tribbles = 0;
	
	// Fill the weapon slots (if possible, at least one weapon)
	if (s[Opponent.Type].WeaponSlots <= 0)
		d = 0;
	else if (s[Opponent.Type].WeaponSlots <= 1)
		d = 1;
	else if (gameDifficulty <= HARD)
	{
		d = 1 + GetRandom( s[Opponent.Type].WeaponSlots );
		if (d < s[Opponent.Type].WeaponSlots)
			if (Tries > 4 && gameDifficulty >= HARD)
				++d;
			else if (Tries > 3 || gameDifficulty >= HARD)
				d += GetRandom( 2 );
	}
	else
		d = s[Opponent.Type].WeaponSlots;
	for (i=0; i<d; ++i)
	{
		e = 0;
		f = 0;
		while (e < Tries)
		{
			k = GetRandom( 100 );
			j = 0;
			sum = Weapontype[0].Chance;
			while (k < sum)
			{
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
	
	// Fill the shield slots
	if (s[Opponent.Type].ShieldSlots <= 0)
		d = 0;
	else if (gameDifficulty <= HARD)
	{
		d = GetRandom( s[Opponent.Type].ShieldSlots + 1 );
		if (d < s[Opponent.Type].ShieldSlots)
			if (Tries > 3)
				++d;
			else if (Tries > 1)
				d += GetRandom( 2 );
	}
	else
		d = s[Opponent.Type].ShieldSlots;
	for (i=0; i<d; ++i)
	{
		e = 0;
		f = 0;
		
		while (e < Tries)
		{
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
		while (j < 5)
		{
			e = 1 + GetRandom( Shieldtype[Opponent.Shield[i]].Power );
			if (e > k)
				k = e;
			++j;
		}
		Opponent.ShieldStrength[i] = k;			
	}
	for (i=d; i<MAXSHIELD; ++i)
	{
		Opponent.Shield[i] = -1;
		Opponent.ShieldStrength[i] = 0;
	}
	
	// Set hull strength
	i = 0;
	k = 0;
	// If there are shields, the hull will probably be stronger
	if (Opponent.Shield[0] >= 0 && GetRandom( 10 ) <= 7)
		Opponent.Hull = s[Opponent.Type].HullStrength;
	else
	{
		while (i < 5)
		{
			d = 1 + GetRandom( s[Opponent.Type].HullStrength );
			if (d > k)
				k = d;
			++i;
		}
		Opponent.Hull = k;			
	}
	
	if (Opp == "MANTI" || Opp == "FAMOUSCAPTAIN")
		Opponent.Hull = s[Opponent.Type].HullStrength;
	
	
	// Set the crew. These may be duplicates, or even equal to someone aboard
	// the commander's ship, but who cares, it's just for the skills anyway.
	Opponent.Crew[0] = MAXCREWMEMBER;
	Mercenary[Opponent.Crew[0]].Pilot = 1 + GetRandom( MAXSKILL );
	Mercenary[Opponent.Crew[0]].Fighter = 1 + GetRandom( MAXSKILL );
	Mercenary[Opponent.Crew[0]].Trader = 1 + GetRandom( MAXSKILL );
	Mercenary[Opponent.Crew[0]].Engineer = 1 + GetRandom( MAXSKILL );
	if (warpSystem == KRAVATSYSTEM && wildStatus == 1 && (GetRandom(10)<gameDifficulty + 1))
	{
		Mercenary[Opponent.Crew[0]].Engineer = MAXSKILL;
	}
	if (gameDifficulty <= HARD)
	{
		d = 1 + GetRandom( s[Opponent.Type].CrewQuarters );
		if (gameDifficulty >= HARD && d < s[Opponent.Type].CrewQuarters)
			++d;
	}
	else
		d = s[Opponent.Type].CrewQuarters;
	for (i=1; i<d; ++i)
		Opponent.Crew[i] = GetRandom( MAXCREWMEMBER );
	for (i=d; i<MAXCREW; ++i)
		Opponent.Crew[i] = -1;
}
public static void buyRepairs( int Amount )
{
	int MaxRepairs;
	int Percentage;
	
	MaxRepairs = ( GetHullStrength() - Ship.Hull) * s[Ship.Type].RepairCosts;
	if (Amount > MaxRepairs)
		Amount = MaxRepairs;
	if (Amount > credits)
		Amount = credits;
	
	Percentage = Amount / s[Ship.Type].RepairCosts;
	
	Ship.Hull += Percentage;
	credits -= Percentage * s[Ship.Type].RepairCosts;
}




public static boolean HasShield( SHIP Sh ,char Gg )
{
    int i;
	
    for (i=0; i<MAXSHIELD; ++i)
    {
	    if (Sh.Shield[i] < 0)
	        continue;
        if (Sh.Shield[i] == Gg)
	        return true;
    }
	
    return false;
}

public static boolean HasTradeableItems( SHIP sh  ,int theSystem, int Operation)
{
	int i;
	Boolean ret = false, thisRet;
	for (i = 0; i< MAXTRADEITEM; i++)
	{
		// trade only if trader is selling and the item has a buy price on the
		// local system, or trader is buying, and there is a sell price on the
		// local system.
		thisRet = false;
		if (sh.Cargo[i] > 0 && Operation == TRADERSELL && BuyPrice[i] > 0)
			thisRet = true;
		else if (sh.Cargo[i] > 0 && Operation == TRADERBUY && SellPrice[i] > 0)
			thisRet = true;
		
		// Criminals can only buy or sell illegal goods, Noncriminals cannot buy
		// or sell such items.
		if (policeRecordScore < DUBIOUSSCORE && i != FIREARMS && i != NARCOTICS)
		    thisRet = false;
		else if (policeRecordScore >= DUBIOUSSCORE && (i == FIREARMS || i == NARCOTICS))
		    thisRet = false;
		
		if (thisRet)
			ret = true;
		
		
	}
	
	return ret;
}
public static int getShipOpponentType(){
	return Opponent.Type;
}
public static String getShipName(int index ){
	
	return s[index].Name;	
}

public static boolean flee()
{
	autoAttack = false;
	autoFlee = false;
	
	if (encounterType == POLICEINSPECTION && Ship.Cargo[FIREARMS] <= 0 && Ship.Cargo[NARCOTICS] <= 0 && wildStatus != 1 && (reactorStatus == 0 || reactorStatus == 21))
	{
		// TODO:!!!
		//if (FrmAlert( SureToFleeOrBribeAlert ) == SureToFleeOrBribeOkIwont)
		//	return true;
	}
	
	if (encounterType == POLICEINSPECTION)
	{
		encounterType = POLICEATTACK;
		if (policeRecordScore > DUBIOUSSCORE)
			policeRecordScore = DUBIOUSSCORE - (gameDifficulty < NORMAL ? 0 : 1);
		else
			policeRecordScore += FLEEFROMINSPECTION;
	}
	else if (encounterType == POSTMARIEPOLICEENCOUNTER)
	{
		//TODO:!!!!
		//if (FrmAlert( SureToFleePostMarieAlert ) != SureToFleePostMarieOkIwont)
		{
			encounterType = POLICEATTACK;
			if (policeRecordScore >= CRIMINALSCORE)
				policeRecordScore = CRIMINALSCORE;
			else
				policeRecordScore += ATTACKPOLICESCORE;
		}
		//else
		//{
		//	return true;
		//}
	}
	
	if (continuous)
		autoFlee = true;
	boolean temp= true;
	if (ExecuteAction(temp))
	{
		return true;
	}
	if (Ship.Hull <= 0)
	{	
		return true;
	}
	 Travel();
	
	return false;
}

public static boolean ignore()
{
	autoAttack = false;
	autoFlee = false;
	 Travel();
	
	
	return false;
}
public static boolean trade()
{
	if (encounterType == TRADERBUY)
	{				
		int i =  GetRandomTradeableItem(Ship ,TRADERBUY);
		
		if (i == NARCOTICS || i == FIREARMS)
		{
			if (GetRandom(100) <= 45)
				SellPrice[i] *= 0.8;
			else
				SellPrice[i] *= 1.1;
		}
		else
		{
			if (GetRandom(100) <= 10)
				SellPrice[i] *= 0.9;
			else
				SellPrice[i] *= 1.1;
		}
		
		SellPrice[i] /= t[i].Roundoff;
		++SellPrice[i];
		SellPrice[i] *= t[i].Roundoff;
		if (SellPrice[i] < t[i].MinTradePrice)
			SellPrice[i] = t[i].MinTradePrice;
		if (SellPrice[i] > t[i].MaxTradePrice)
			SellPrice[i] =t[i].MaxTradePrice;
		
		
		
		currentState ="eTradeInOrbit";
		activeTradeItem = i;
		//NSString * message = [NSString stringWithFormat:"The trader wants to buy %, and offers %i  cr. each. You have %i unit(s) available. \n \
				//			  You paid about %i  cr. per unit. How many do you wish to sell?\n\n", [NSString stringWithCString:Tradeitem[i].Name],SellPrice[i], ship.Cargo[i],
				//			  BuyingPrice[i] / ship.Cargo[i]];
		
		
		//AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:"Trade in Orbit" yoffset:90 message:message  
			//															delegate:self cancelButtonTitle:"Cancel" okButtonTitle:"Ok"  thirdButtonTitle:"All"];
		
			
		
	}
	else if (encounterType == TRADERSELL)
	{				
		int i = GetRandomTradeableItem(Opponent,TRADERSELL);
		
		if (i == NARCOTICS || i == FIREARMS)
		{
			if (GetRandom(100) <= 45)
				BuyPrice[i] *= 1.1;
			else
				BuyPrice[i] *= 0.8;
		}
		else
		{
			if (GetRandom(100) <= 10)
				BuyPrice[i] *= 1.1;
			else
				BuyPrice[i] *= 0.9;
		}
		
		BuyPrice[i] /= t[i].Roundoff;
		BuyPrice[i] *= t[i].Roundoff;
		if (BuyPrice[i] < t[i].MinTradePrice)
			BuyPrice[i] = t[i].MinTradePrice;
		if (BuyPrice[i] > t[i].MaxTradePrice)
			BuyPrice[i] = t[i].MaxTradePrice;
		
		
		currentState = "eSellInOrbit";
		activeTradeItem = i;
		//NSString * message = [NSString stringWithFormat:"The trader wants to sell %, for the price of %i  cr. each. The trader has %i unit(s) for sale. \n \
		//You can afford %i unit(s). How many do you wish to buy?\n\n", [NSString stringWithCString:Tradeitem[i].Name], BuyPrice[i],  Opponent.Cargo[i],
		//					  credits / BuyPrice[i]];
		
		
		//AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:"Trade in Orbit" yoffset:90 message:message  
			//															delegate:self cancelButtonTitle:"Cancel" okButtonTitle:"Ok"  thirdButtonTitle:"All"];
		
		
		
		
	}
	
	return false;
}

public static boolean yield()
{
	if (wildStatus == 1)
	{
		currentState ="eYieldChoice";
		
		//AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:"You have Jonathan Wild on board!" yoffset:90 message:"Wild will be arrested, too."  
		//																delegate:self cancelButtonTitle:"Cancel" okButtonTitle:"Yield"  thirdButtonTitle:nil];
		
				
		return true;
		
	}
	else if (reactorStatus > 0 && reactorStatus < 21)
	{
		currentState = "eYieldChoice";		
		//		currentState = eSellInOrbit;
		//		if (FrmCustomAlert( WantToSurrenderAlert, "You have an illegal Reactor on board! ", "They will destroy the reactor. ", NULL) == WantToSurrenderNo)
		//			return true;
		currentState = "eYieldChoice";		
	//	AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:"You have an illegal Reactor on board!" yoffset:90 message:"They will destroy the reactor."  
		//																delegate:self cancelButtonTitle:"Cancel" okButtonTitle:"Yeild"  thirdButtonTitle:nil];
		
			
		return true;
		
	}
	
	return  yieldContinue();
}


public static boolean surrender()
{
	autoAttack = false;
	autoFlee = false;
	if (Opponent.Type == MANTISTYPE)
	{
		if (artifactOnBoard)
		{
			currentState =" eSurrenderArtifact";		
		//	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Surrender!" message:NSLocalizedString("WantToSurrenderToAliensAlert", "")  
			//																delegate:self cancelButtonTitle:"Surrender" otherButtonTitles:"Cancel",nil];
			bLastMessage = false;
		}
		else
		{
		//	[self FrmAlert:"NoSurrenderAlert"];
			//return true;
		}
	}
	else if (ENCOUNTERPOLICE( encounterType ))
	{
		if (policeRecordScore <= PSYCHOPATHSCORE)
		{
			//[self FrmAlert:"NoSurrenderAlert"];
			//return true;
		}
		else
		{
			Arrested();
	//		 return true;
	
			if (wildStatus == 1)
			{
				currentState = " eSurrender";		
				
			//	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"You have Jonathan Wild on board!" message:"Wild will be arrested, too."  
			//																	delegate:self cancelButtonTitle:"Surrender" otherButtonTitles:"Cancel", nil];
				
				bLastMessage = false;
				
				//				if (FrmCustomAlert( WantToSurrenderAlert, "You have Jonathan Wild on board! ", "Wild will be arrested, too. ", NULL ) == WantToSurrenderNo)
				//return true;
			}
			
			else if (reactorStatus > 0 && reactorStatus < 21)
			{
				//				if (FrmCustomAlert( WantToSurrenderAlert, "You have an illegal Reactor on board! ", "They will destroy the reactor. ", NULL) == WantToSurrenderNo)
				currentState =" eSurrender";		
			//	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"You have an illegal Reactor on board!" message:"They will destroy the reactor."  
			//																	delegate:self cancelButtonTitle:"Surrender" otherButtonTitles:"Cancel", nil];
				
				bLastMessage = false;
				//return true;
			}
			else
			{
				//	if (FrmCustomAlert( WantToSurrenderAlert, NULL, NULL, NULL ) == WantToSurrenderNo)
				currentState = "eSurrender";						
				//UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Surrender!" message:NSLocalizedString("WantToSurrenderAlert", "")  
						//														delegate:self cancelButtonTitle:"Surrender" otherButtonTitles:"Cancel", nil];
				bLastMessage = false;
				//return true;
			}
			
		}
	}

	else
	{
		raided = true;
		
		int TotalCargo = 0;
		int i;
		for (i=0; i<MAXTRADEITEM; ++i)
			TotalCargo += Ship.Cargo[i];
		if (TotalCargo <= 0)
		{
			int Blackmail = min( 25000, max( 500,  currentWorth() / 20 ) );
			//[self FrmAlert:"PiratesFindNoCargoAlert"];
			if (credits >= Blackmail)
				credits -= Blackmail;
			else
			{
				
				debt += (Blackmail - credits);
				credits = 0;
			}
		}		
		else
		{	
			
		//	[self FrmAlert:"PiratesPlunderAlert"];									
			
			int Bays = s[Opponent.Type].CargoBays;
			for (i=0; i<MAXGADGET; ++i)
				if (Opponent.Gadget[i] == EXTRABAYS)
					Bays += 5;
			for (i=0; i<MAXTRADEITEM; ++i)
				Bays -= Opponent.Cargo[i];
			
			// Pirates steal everything					
			if (Bays >= TotalCargo)
			{
				for (i=0; i<MAXTRADEITEM; ++i)
				{
					Ship.Cargo[i] = 0;
					BuyingPrice[i] = 0;
				}
			}		
			else
			{		
				// Pirates steal a lot
				while (Bays > 0)
				{
					i = GetRandom( MAXTRADEITEM );
					if (Ship.Cargo[i] > 0)
					{
						BuyingPrice[i] = (BuyingPrice[i] * (Ship.Cargo[i] - 1)) / Ship.Cargo[i];
						--Ship.Cargo[i];
						--Bays;
					}
				}
			}
		}
		if ((wildStatus == 1) && (s[Opponent.Type].CrewQuarters > 1))
		{
			// Wild hops onto Pirate Ship
			wildStatus = 0;
			//[self FrmAlert:"WildGoesWithPiratesAlert"];
		}
		else if (wildStatus == 1)
		{
			// no room on pirate ship
	//		[self FrmAlert:"WildStaysAboardAlert"];
		}
		if (reactorStatus > 0 && reactorStatus < 21)
		{
			// pirates puzzled by reactor
		//	[self FrmAlert:"PiratesDontStealReactorAlert"];
		}
	}
	
	 Travel();
	
	
	return false;
}

public static boolean bribeContinue()
{
	int Bribe=0;
	// Bribe depends on how easy it is to bribe the police and commander's current worth
	 Bribe = (int) (currentWorth() / ((10L + 5L * (IMPOSSIBLE - gameDifficulty)) * p[SolarSystem[warpSystem].Politics].BribeLevel));
	if (Bribe % 100 != 0)
		Bribe += (100 - (Bribe % 100));
	if (wildStatus == 1 || (reactorStatus > 0 && reactorStatus < 21))
	{
		if (gameDifficulty <= NORMAL)
			Bribe *= 2;
		else
			Bribe *= 3;
	}
	Bribe = max( 100, min( Bribe, 10000 ) );
	
	
	//NSString* str = [NSString stringWithFormat:"The Police officers are willing to forego inspection for amount of %i credits.", Bribe];
	
	currentState = "eBribeOffer";			
	// take the cargo of the Marie Celeste?
	//UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Bribe" message:str
		//															delegate:self cancelButtonTitle:"Bribe" otherButtonTitles:"Cancel",nil];
	
			
	bLastMessage = false;
	return true;	
	
}


public static boolean bribe() {
	autoAttack = false;
	autoFlee = false;
	
	if (p[SolarSystem[warpSystem].Politics].BribeLevel <= 0)
	{
		//[self FrmAlert:"CantBeBribedAlert"];
		return true;
	}
	
	if (encounterType == POSTMARIEPOLICEENCOUNTER)
	{
		//[self FrmAlert:"MarieCantBeBribedAlert"];
		return true;
	}
	
	if (encounterType == POLICEINSPECTION && Ship.Cargo[FIREARMS] <= 0 && Ship.Cargo[NARCOTICS] <= 0 && wildStatus != 1)
	{
		currentState = "eBribePropsal";			
		// take the cargo of the Marie Celeste?
	//	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Bribe" message:
		//								  NSLocalizedString("SureToFleeOrBribeAlert", "") delegate:self cancelButtonTitle:"Cancel" otherButtonTitles:"Bribe", nil];
		
		
		bLastMessage = false;
		//return true;
	}
	
	return  bribeContinue();
	
}


public static boolean submit() {
	
	autoAttack = false;
	autoFlee = false;
	
	String str, str2;
	
	if (encounterType == POLICEINSPECTION && (Ship.Cargo[FIREARMS] > 0 ||  Ship.Cargo[NARCOTICS] > 0 || wildStatus == 1 || (reactorStatus > 1 && reactorStatus < 21)))
	{
		if (wildStatus == 1)
		{
			if (Ship.Cargo[FIREARMS] > 0 || Ship.Cargo[NARCOTICS] > 0)
			{
				str ="Jonathan Wild and illegal goods";
			}
			else
			{
				str = "Jonathan Wild";
			}
			str2 ="You will be arrested!";
		}
		else if (reactorStatus > 0 && reactorStatus < 21)
		{
			if (Ship.Cargo[FIREARMS] > 0 || Ship.Cargo[NARCOTICS] > 0)
			{
				str ="an illegal Ion Reactor and other illegal goods";
			}
			else
			{
				str ="an illegal Ion Reactor";
			}
			str2="You will be arrested!";
		}
		else
		{
			str="illegal goods";
		}
		// DUKE Says:  Since this is not being used maybe should take out all the stuff
		// setting it.  Don't know if there are plans for future use of the above stuff
		// so I just do a reassign to clear some warnings from clang.
		//str = str;
		//str2 = str2;
		currentState = "eSubmit";			
		// take the cargo of the Marie Celeste?
		//UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Encounter" message:
		//								  NSLocalizedString("SureToSubmitAlert", "") delegate:self cancelButtonTitle:"No" otherButtonTitles:"Submit",nil];
		
			
		bLastMessage = false;		
		//		if (FrmCustomAlert( SureToSubmitAlert, SBuf, SBuf2, NULL ) == SureToSubmitNo)
		return true;
		
	}
	return  submitContinue();	
}

public static boolean  submitContinue()
{
	
	if ((Ship.Cargo[FIREARMS] > 0) || (Ship.Cargo[NARCOTICS] > 0))
	{
		// If you carry illegal goods, they are impounded and you are fined
		Ship.Cargo[FIREARMS] = 0;
		BuyingPrice[FIREARMS] = 0;
		Ship.Cargo[NARCOTICS] = 0;
		BuyingPrice[NARCOTICS] = 0;
		int Fine =  (int) (currentWorth() / ((IMPOSSIBLE+2-gameDifficulty) * 10L));
		if (Fine % 50 != 0)
			Fine += (50 - (Fine % 50));
		Fine = max( 100, min( Fine, 10000 ) );
		if (credits >= Fine)
			credits -= Fine;
		else
		{
			debt += (Fine - credits);
			credits = 0;
		}
		
		
		
		//NSString* str = [NSString stringWithFormat:"The Police discovers illegal goods in your cargo holds. These goods will be impounded and you are fined of %i credits.", Fine];
		//[self FrmAlert:str];		
		
		policeRecordScore += TRAFFICKING;
	}
	else if (wildStatus != 1)
	{
		// If you aren't carrying illegal goods, the police will increase your lawfulness record
		//[self FrmAlert:"NoIllegalGoodsAlert"];
		policeRecordScore -= TRAFFICKING;
	}
	if (wildStatus == 1)
	{
		// Jonathan Wild Captured, and your status damaged.
		Arrested();
		return true;
	}
	if (reactorStatus > 0 && reactorStatus < 21)
	{
		// Police confiscate the Reactor.
		// Of course, this can only happen if somehow your
		// Police Score gets repaired while you have the
		// reactor on board -- otherwise you'll be arrested
		// before we get to this point. (no longer true - 25 August 2002)
		// FrmAlert:"PoliceConfiscateReactorAlert"];
		reactorStatus = 0;
		
	}	
	
	
	 Travel();
	
	
	return false;
	
}

public static boolean plunder()
{
	autoAttack = false;
	autoFlee = false;
	
	if (ENCOUNTERTRADER( encounterType ))
		policeRecordScore += PLUNDERTRADERSCORE;
	else
		policeRecordScore += PLUNDERPIRATESCORE;
	
	 
	
	return true;
}

public static boolean interrupt()
{
	autoFlee = false;
	autoAttack = false;
	//[self Travel];
	//[encounterViewControllerInstance showEncounterWindow];
	
	return false;	
}

public static boolean meet() {
	
	
	//"Meet Captain Ahab", "Captain Ahab is in need of a spare shield for an upcoming mission. He offsers to trade you some piloting lessons for ypur reflective shild. Do you wish to trade?", "YEs, Trdae shield", "No"
	
	if (encounterType == CAPTAINAHABENCOUNTER)
	{
		
		currentState =" eEngageCaptainAhabAlert";
		//[self FrmAlertWithState:"EngageCaptainAhabAlert" state:eEngageCaptainAhabAlert];
		// Trade a reflective shield for skill points in piloting?
	}
	else if (encounterType == CAPTAINCONRADENCOUNTER)
	{
		
		currentState = "eEngageCaptainConradAlert";
	//	[self FrmAlertWithState:"EngageCaptainConradAlert"  state:eEngageCaptainConradAlert];
	}
	else if (encounterType == CAPTAINHUIEENCOUNTER)
	{
		currentState =" eEngageCaptainHuieAlert";
		//[self FrmAlertWithState:"EngageCaptainHuieAlert" state:eEngageCaptainHuieAlert];
		// Trade a military laser for skill points in trading?
	}
	
	
	//[self Travel];
	//[encounterViewControllerInstance showEncounterWindow];
	
	return true;
}

public static boolean board() {
	
	if (encounterType == MARIECELESTEENCOUNTER)
	{
		currentState = "eBoard";			
		// take the cargo of the Marie Celeste?
		//UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Encounter"  message:
		//								  NSLocalizedString("EngageMarieAlert", "") delegate:self cancelButtonTitle:"Cancel" otherButtonTitles:"Take Cargo",nil];
				
		bLastMessage = false;
    	return true;
		
	}
	else {
		Travel();
	
		
		return false;			
	}	
}
public static void getLoan(int loan) 
{
	int amount;
	amount = min( maxLoan() - debt,loan );
	credits += amount;
	debt += amount;
//	[self playSound:eGetLoan];
}

public static boolean drink (){
	
	if (encounterType == BOTTLEGOODENCOUNTER)
	{
		// Quaff the good bottle of Skill Tonic?
		//[self playSound:eBottleEncounter];
		currentState = "eBottleGood";		
	}
	else if (encounterType == BOTTLEOLDENCOUNTER)
	{
		// Quaff the out of date bottle of Skill Tonic?
	//	[self playSound:eBottleEncounter];		
		currentState = "eBottleStrange";		
		
	} 
	else {
	 Travel();
		
		
		//return false;			
	}
	
	//UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Encounter" message:NSLocalizedString("EngageBottleAlert", "") 
	//													  delegate:self cancelButtonTitle:"Yes" otherButtonTitles:"No", nil];
	
			
	bLastMessage = false;
	return true;
}


// Returns number of open quests.









public static int GetRandomTradeableItem( SHIP sh ,int Operation)
{
	Boolean looping = true;
	int i=0, j=0;
	
	while (looping && i < 10) 
	{
		j = GetRandom(MAXTRADEITEM);
		// It's not as ugly as it may look! If the ship has a particulat item, the following
		// conditions must be met for it to be tradeable:
		// if the trader is buying, there must be a valid sale price for that good on the local system
		// if the trader is selling, there must be a valid buy price for that good on the local system
		// if the player is criminal, the good must be illegal
		// if the player is not criminal, the good must be legal 
		if ( (sh.Cargo[j] > 0 && Operation == TRADERSELL && BuyPrice[j] > 0) &&
			((policeRecordScore < DUBIOUSSCORE && (j == FIREARMS || j == NARCOTICS)) ||
			 (policeRecordScore >= DUBIOUSSCORE && j != FIREARMS && j != NARCOTICS)) )
			looping = false;
		else if ( (sh.Cargo[j] > 0 && Operation == TRADERBUY &&  SellPrice[j] > 0)  &&
				 ((policeRecordScore < DUBIOUSSCORE && (j == FIREARMS || j == NARCOTICS)) ||
				  (policeRecordScore >= DUBIOUSSCORE && j != FIREARMS && j != NARCOTICS)) )
			looping = false;
		// alles klar?
		else
		{
			j = -1;
			i++;
		}
	}
	// if we didn't succeed in picking randomly, we'll pick sequentially. We can do this, because
	// this routine is only called if there are tradeable goods.
	if (j == -1)
	{
		j = 0;
		looping = true;
		while (looping)
		{
			// see lengthy comment above.
			if ( (((sh.Cargo[j] > 0) && (Operation == TRADERSELL) &&  (BuyPrice[j] > 0)) ||
				  ((sh.Cargo[j] > 0) && (Operation == TRADERBUY) &&  (SellPrice[j] > 0))) &&
		     	((policeRecordScore < DUBIOUSSCORE && (j == FIREARMS || j == NARCOTICS)) ||
				 (policeRecordScore >= DUBIOUSSCORE && j != FIREARMS && j != NARCOTICS)) )
			    
			{
				looping = false;
			}
			else
			{
				j++;
				if (j == MAXTRADEITEM)
				{
					// this should never happen!
					looping = false;
				}
			}
		}
	}
	return j;
}


public static boolean yieldContinue()
{
	
	if (wildStatus == 1 || (reactorStatus > 0 && reactorStatus < 21))
	{
		 Arrested();
	}
	else
	{					
		// Police Record becomes dubious, if it wasn't already.
		if (policeRecordScore > DUBIOUSSCORE)
			policeRecordScore = DUBIOUSSCORE;
		Ship.Cargo[NARCOTICS]=0;
		Ship.Cargo[FIREARMS]=0;
		
		//[self FrmAlert:"YieldNarcoticsAlert"];
	}
	
	 Travel();
	//[encounterViewControllerInstance showEncounterWindow];
	
	return false;
}



public static void Arrested()
{
	
	int Fine, Imprisonment;
	int i;
	
	Fine = ((1 + ((( currentWorth() * min( 80, -policeRecordScore )) / 100) / 500)) * 500);
	if (wildStatus == 1)
	{
		Fine *= 1.05;
	}
	Imprisonment = max( 30, -policeRecordScore );
	
	//[self FrmAlert:"ArrestedAlert"];
	
	
	
	if (Ship.Cargo[NARCOTICS] > 0 || Ship.Cargo[FIREARMS] > 0)
	{
		//[self FrmAlert:"ImpoundAlert"];
		Ship.Cargo[NARCOTICS] = 0;
		Ship.Cargo[FIREARMS] = 0;
	}
	
	if (insurance)
	{
	//	[self FrmAlert:"InsuranceLostAlert"];
		insurance = false;
		noClaim = 0;
	}
	
	if (Ship.Crew[1] >= 0)
	{
		//[self  FrmAlert:"MercenariesLeaveAlert"];
		for (i=1; i<MAXCREW; ++i)
			Ship.Crew[i] = -1;
	}
	
	if (japoriDiseaseStatus == 1)
	{
		//[self FrmAlert:"AntidoteRemovedAlert"];
		japoriDiseaseStatus = 2;
	}
	
	if (jarekStatus == 1)
	{
		//[self FrmAlert:"JarekTakenHomeAlert"];
		jarekStatus = 0;
	}
	
	if (wildStatus == 1)
	{
		//[self FrmAlert:"WildArrestedAlert"];
		//[self addNewsEvent:WILDARRESTED];
		wildStatus = 0;
	}
	
	if (reactorStatus > 0 && reactorStatus < 21)
	{
		//[self FrmAlert:"PoliceConfiscateReactorAlert"];
		reactorStatus = 0; 
	}
	
	 Arrival();
	
	 IncDays(Imprisonment);
	
	if (credits >= Fine)
		credits -= Fine;
	else
	{
		credits += CurrentShipPrice( true);
		
		if (credits >= Fine)
			credits -= Fine;
		else
			credits = 0;
		
		//[self FrmAlert:"ShipSoldAlert"];
		
		if (Ship.Tribbles > 0)
		{
		//	[self FrmAlert:"TribblesSoldAlert"];
			Ship.Tribbles = 0;
		}
		
	//	[self FrmAlert:"FleaReceivedAlert"];
		
		//[self CreateFlea];
	}
	
	policeRecordScore = DUBIOUSSCORE;
	
	if (debt > 0)
	{
		if (credits >= debt)
		{
			credits -= debt;
			debt = 0;
		}
		else
		{
			debt -= credits;
			credits = 0;
		}
	}
	
	for (i=0; i<Imprisonment; ++i)
	payInterest();
	
	 Arrival();
	
}

public static void payInterest(){
	
	if (debt > 0) {
		 int incDebt = max(1, debt /10);
		if (credits > incDebt) {
			credits -= incDebt;
    } else {
			debt += (incDebt - credits);
    }
	}
}


public static String getSolarSystemName(int Index ){
	return  solarSystemName[Index]; 
}
public static void addNewsEvent(int eventFlag)
{
	if (newsSpecialEventCount < MAXSPECIALNEWSEVENTS - 1)
		NewsEvents[newsSpecialEventCount++] = eventFlag;
}
public static void sellEquipment(int index) {
	if (index < MAXWEAPON) {
		credits += WEAPONSELLPRICE(index);
		for (int i = index ; i < MAXWEAPON; i++) {
			Ship.Weapon[i] = Ship.Weapon[i];      
          }
		Ship.Weapon[MAXWEAPON - 1] =0;
	  } 
	else if (index < MAXWEAPON + MAXSHIELD)
	{
		index =index - MAXWEAPON;
		credits += WEAPONSELLPRICE(index);
		for (int i = index + 1; i < MAXSHIELD; i++)
		{
			Ship.Shield[i] = Ship.Shield[i];
			Ship.ShieldStrength[i] = Ship.ShieldStrength[i];	
		}
		Ship.Shield[MAXSHIELD - 1] = 0;
		Ship.ShieldStrength[MAXSHIELD - 1] = 0;		
	} 
	else 
	{
		index = index - MAXWEAPON - MAXSHIELD;
        Log.v("index in gadget",""+index);
		if ( filledCargoBays() >  totalCargoBays() - 5) {
			//[self FrmAlert:@"CargoBaysFullAlert"];      
           } 
		else 
		{
			credits += GADGETSELLPRICE(index);
			for (int i = index ; i < MAXGADGET; i++)
			{
				Ship.Gadget[i] = Ship.Gadget[i];
             }
			Ship.Gadget[MAXGADGET - 1] = 0;		
		}
	}	
}
public static String getSolarSystemSpecalResources(int index ){
	if (SolarSystem[warpSystem].Visited)
		return  SpecialResources[SolarSystem[index].SpecialResources] ;
	else
		return "Special resources unknown";
}

public static int getSolarSystemX(int Index ){
	
	return SolarSystem[Index].X;
    
}
public static int getSolarSystemY(int Index ){
	return SolarSystem[Index].Y;
}
public static boolean getSolarSystemVisited(int Index) {
	return SolarSystem[Index].Visited;
}

public static int getCurrentSystemIndex() {
	return currentSystem;
}
public static void doWarp(boolean viaSingularity) {
	int i, Distance;
	
	Distance =  RealDistance(currentSystem,warpSystem) ;
	if (Distance >  getFuel() && !viaSingularity &&! wormholeExists(currentSystem ,warpSystem))
	{
		//UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"No fuel!" message:NSLocalizedString(@"You have no fuel for this warp.", @"")  
			//												  delegate:self cancelButtonTitle:@"Ok" otherButtonTitles:nil];
		
				
		bLastMessage = false;
		return;		
	}

	
	// if Wild is aboard, make sure ship is armed!
	if (wildStatus == 1)
	{	
		if (! HasWeapon(Ship ,BEAMLASERWEAPON ,false))
		{ 
			boolean viaSingularitySaved = viaSingularity;
			
			currentState = "eWildWeaponBuy";
			
			//AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Alert" yoffset:90 message:NSLocalizedString(@"WildWontGoAlert", @"") 
					//														delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Say Goodbye"  thirdButtonTitle:nil];
			
								
		}
	}
	
    // Check for Large Debt
	if (debt > DEBTTOOLARGE)
	{
	  //  [self FrmAlert:@"DebtTooLargeForTravelAlert"];
			bLastMessage = false;
	    return;
	}
	
	// Check for enough money to pay Mercenaries    
	if (mercenaryMoney() > credits)
	{
		//[self FrmAlert:@"MustPayMercenariesAlert"];
			bLastMessage = false;
		return; 
	}
	
    // Check for enough money to pay Insurance
	if (insurance)
	{
		if (insuranceMoney() +  mercenaryMoney() > credits)
		{
		//[self FrmAlert:@"CantPayInsuranceAlert"];
			return;
		}
	}
	
	// Check for enough money to pay Wormhole Tax 					
	if ( insuranceMoney() +  mercenaryMoney() +  WormholeTax(currentSystem ,warpSystem) > credits)
	{
		//[self FrmAlert:@"CantPayWormholeAlert"];
		return;
	}
	
	if (! viaSingularity)
	{
		credits -=  WormholeTax(currentSystem,warpSystem);
		credits -=  mercenaryMoney();						
		credits -=  insuranceMoney();
	}
	
	for (i=0; i<MAXSHIELD; ++i)
	{
		if (Ship.Shield[i] < 0)
			break;
		Ship.ShieldStrength[i] = Shieldtype[Ship.Shield[i]].Power;
	}
	
	countDown = STARTCOUNTDOWN();
	if ( wormholeExists(currentSystem,warpSystem) || viaSingularity)
	{
		Distance = 0;
		arrivedViaWormhole = true;
	}
	else
	{
		Distance =  RealDistance( currentSystem, warpSystem) ;
		Ship.Fuel -= min( Distance, getFuel());
		arrivedViaWormhole = false;
	}
	
	resetNewsEvents();
	if (!viaSingularity)
	{
		// normal warp.
		 payInterest();
		 IncDays(1);
		if (insurance)
			++noClaim;
	}
	else
	{
		// add the singularity news story
		 addNewsEvent(ARRIVALVIASINGULARITY);
	}
	
	clicks = 21;
	Log.v("clicks" ,"b2"+clicks);
	raided = false;
	inspected = false;
	 litterWarning = false;
	monsterHull = (monsterHull * 105) / 100;
	if (monsterHull >s[SpaceMonster.Type].HullStrength)
		monsterHull = s[SpaceMonster.Type].HullStrength;
	if (days%3 == 0)
	{
		if (policeRecordScore > CLEANSCORE)
			--policeRecordScore;
	}
	if (policeRecordScore < DUBIOUSSCORE)
		if (gameDifficulty <= NORMAL)
			++policeRecordScore;
		else if (days%gameDifficulty == 0)
			++policeRecordScore;
	
	possibleToGoThroughRip=true;
	
	 DeterminePrices(warpSystem);
	 Travel();
	//	[self Arrival];
}
public static int  WormholeTax(int a ,int b)
{
	if (wormholeExists(a ,b))
		return (int) ( s[Ship.Type].CostOfFuel * 25 );
	
	return 0;
}
public void FrmAlert(String msg)
{
	AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
	alt_bld.setMessage(msg)
	.setCancelable(false)
	.setPositiveButton("Ok", new DialogInterface.OnClickListener() 
	{
		public void onClick(DialogInterface dialog, int id) 
		{
			// Action for 'Yes' Button
			dialog.cancel();
		}
	});
	AlertDialog alert = alt_bld.create();
	alert.setTitle("Alert");
	alert.show();
}

public static void sellCargo(int Index,int Amount,int Operation)
{
	
	if (Operation == JETTISONCARGO) {
		if (policeRecordScore > DUBIOUSSCORE && !litterWarning) {
			
			litterWarning = true;
			
			//if (FrmAlert(SpaceLitteringString) 
		}
	}
	
	int ToSell = min(Amount, Ship.Cargo[Index]);
	
	if (Operation == DUMPCARGO) {
		
		ToSell = min(ToSell,  toSpend() / 5 * (gameDifficulty + 1));
	}
	if(Ship.Cargo[Index]<=0)
		Ship.Cargo[Index]=1;
	BuyingPrice[Index] = (BuyingPrice[Index] * (Ship.Cargo[Index] - ToSell)) / Ship.Cargo[Index];
	
	
	
	
	if (SellPrice[Index] > 0) {
		if(Operation== SELLCARGO)
			credits += ToSell * SellPrice[Index];
		else
			if (Operation == DUMPCARGO)
				credits -= ToSell * 5 *(gameDifficulty + 1);
			else {
				if (GetRandom(10) < gameDifficulty + 1) {
					if (policeRecordScore > DUBIOUSSCORE)
						policeRecordScore = DUBIOUSSCORE;
					else
						policeRecordScore -= 1;  
					addNewsEvent(CAUGHTLITTERING);
				}
			}
		Ship.Cargo[Index] -= ToSell;
		SolarSystem[currentSystem].Qty[Index] += ToSell;
	}
}
public static void continuePlunder()
{
	bWaitFinishPlunder = false;
//	[self showPlunderForm:ePickItUp];	
}
public static void plunderItems(int index, int count)
{
	plunderItem = index;
	plunderCount = count;
}
public static int STARTCOUNTDOWN(){
	return gameDifficulty+3;
}
public static void updateMercenary0Data()
{
	
	Mercenary[0].Trader = traderSkill;
	Mercenary[0].Engineer = engineerSkill;
	Mercenary[0].Fighter = fighterSkill;
	Mercenary[0].Pilot = pilotSkill;
	

}

public static void fillHighScores(int array[]) 
{
	/*
	LoadBinaryHighScore("scores", Hscores);
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

		NSString * type, *level= DifficultyLevel[Hscores[i].Difficulty];
		if (Hscores[i].Status == MOON)
			type =@"Claimed moon";
		else if (Hscores[i].Status == RETIRED)
			type =@"Retired";
		else
			type=@"Was killed";

		
		[array addObject:[NSDictionary dictionaryWithObjectsAndKeys:
							 [NSString stringWithFormat:@"%@    Finished:%i.%i%%", [NSString stringWithCString:Hscores[i].Name], (Percentage / 50L), ((Percentage%50L) / 5)], @"title",
							 [NSString stringWithFormat:@"%@ in %i days, worth %i credits on %@ level", type, Hscores[i].Days, Hscores[i].Worth, level ], @"line",
							 nil]];	
	
	}*/
}

public static String drawSpecialCargoForm(){
	
	String header = null;
	
	boolean bSpecialItem = false;
	
	if (Ship.Tribbles > 0) {
		if (Ship.Tribbles >= MAXTRIBBLES) {
			header ="An infestation of tribbles";
		}
		else 
		{
			String  t1 =Ship.Tribbles+" cute, furry tribble.";
			header =t1;
		}
		bSpecialItem = true;
	}
	
	if (japoriDiseaseStatus == 1) {
		bSpecialItem = true;	
		header ="10 bays of antidote.";
	}
	
	if (artifactOnBoard) {
		bSpecialItem = true;		
		header ="An alien artifact.";
	}
	
	if (jarekStatus == 2) {
		bSpecialItem = true;		
		header ="A haggling computer.";
	}
	
	if (reactorStatus > 0 && reactorStatus < 21) {
		bSpecialItem = true;		
		header="An unstable reactor taking up 5 bays.";
		int ab=10 - ((reactorStatus - 1) / 2);
		String  t1 =ab+ " bay of enriched fuel." ;
		header =t1;
	}
	
	if (canSuperWarp) {
		bSpecialItem = true;
		header ="A Portable Singularity.";
	}
	
	
	if (!bSpecialItem) {
		header ="No special items.";
	}
	
	return header;
}

public static int adaptPilotSkill()
{
	return PilotSkill(Ship);
}
public static int adaptFighterSkill()
{
	return FighterSkill(Ship);
}
public static int adaptTraderSkill()
{
	return TraderSkill(Ship);
}
public static int adaptEngineerSkill()
{
	return EngineerSkill(Ship);
}

public static String currentReputation()
{
	int i = 0;
	while (i < MAXREPUTATION && reputationScore >= Reputation[i].MinScore)
		++i;
	--i;
	if (i < 0)
		i = 0;
	
	return Reputation[i].Name;	
}
public static String currentPoliceRecord()
{
	int i = 0;
	while (i < MAXPOLICERECORD && policeRecordScore >= PoliceRecord[i].MinScore)
		++i;
	--i;
	if (i < 0)
		i = 0;
	return (PoliceRecord[i].Name);	
}
public static void makeDeposit(int dep )
{
	gesdb += dep;
	credits -= dep;
	//[[SoundManager sharedSound] playSoundWithId:kCashReg];
}

public static void  makeWithDrawl(int dep )
{
	gesdb -= dep;
	credits += dep;
	//[[SoundManager sharedSound] playSoundWithId:kCashReg];
}
public static int latestNewsEvent() {
	if (newsSpecialEventCount == 0) {
		return -1;    
  }
	
	return NewsEvents[newsSpecialEventCount - 1];
}
public static void replaceNewsEvent(int originalEventFlag, int replacementEventFlag)
{
	int i;
	
	if (originalEventFlag == -1) {
		 addNewsEvent(replacementEventFlag);
	} else {
		for (i=0;i<newsSpecialEventCount; i++) {
			if (NewsEvents[i] == originalEventFlag)
				NewsEvents[i] = replacementEventFlag;
		}
	}
}

public static String getShipImageName(int index ){
	return ShipImages[index];		
}

public static String getShipImageNameBg(int index ){
	return ShipImagesBg[index];			
}

public static String getShipDamagedImageName(int index){
	return ShipImagesDamaged[index];			
}

public static String getShipShieldImageName(int index) {
	return ShipImagesShield[index];			
}
public static int getCurrentShipType() {
	return Ship.Type;
}
public static int getShipShield() {
	return  TotalShieldStrength();
}

public static int TotalShieldStrength() 
{
	int i;
	int k;
	
	k = 0;
	for (i=0; i<MAXSHIELD; i++)
	{
		if (Ship.Shield[i] < 0)
			break;
		k += Ship.ShieldStrength[i];
	}
	
	return k;
}
public static int getShipShieldMax() {
	return  TotalShields();
}
public static int TotalShields() 
{
	int i;
	int j;
	
	j = 0;
	for (i=0; i<MAXSHIELD; ++i)
	{
		if (Ship.Shield[i] < 0)
			break;
		j += Shieldtype[Ship.Shield[i]].Power;
	}
	
	return j;
}
public static int getShipHullMax() {
	return GetHullStrength();
}
public static int getShipOpponentHullMax() {
	return s[Opponent.Type].HullStrength;
}
public static int getShipOpponentHull() {
	return Opponent.Hull;
}
public static int getShipOpponentShield() {
	return TotalShieldStrength();
}

public static int getShipSize(int index) {
	return s[index].Size;	
}

public static int getShipCargoBays(int index) {
	return s[index].CargoBays;
}
public static int getShipRange(int index) {
	return s[index].FuelTanks;	
}

public static int getShipHullStrength(int index) {
	return s[index].HullStrength;	
}

public static int getShipWeaponSlots(int index) {
	return s[index].WeaponSlots;	
}

public static int getShipShieldSlots(int index) {
	return s[index].ShieldSlots;	
}

public static int getShipGadgetSlots(int index) {
	return s[index].GadgetSlots;	
}

public static int getShipCrewQuarters(int index) {
	return s[index].CrewQuarters;	
}
public static String drawQuestsForm() {

	String header=null;
	if(OpenQuests()>0)
		header="Quests:" ;
	else
		header ="There are no open quests.";
	
	if (monsterStatus == 1)
	{
		header ="Kill the space monster at Acamar.";
		
	}
	
	if (dragonflyStatus >= 1 && dragonflyStatus <= 4) {
		header ="Follow the Dragonfly to ";
		if (dragonflyStatus == 1)
			header = "Baratas";
		else if (dragonflyStatus == 2)
			header ="Melina.";
		else if (dragonflyStatus == 3)
			header ="Regulas.";
		else if (dragonflyStatus == 4)
			header ="Zalkon.";
		
	} else if (SolarSystem[ZALKONSYSTEM].Special == INSTALLLIGHTNINGSHIELD) {
		header ="Get your lightning shield at Zalkon.";		
	}
	
	if (japoriDiseaseStatus == 1) {
		header ="Deliver antidote to Japori.";
	}
	
	if (artifactOnBoard) {
		header ="Deliver the alien artifact to professor Berger at some hi-tech system";			
	}
	
	if (wildStatus == 1) {
		header ="Smuggle Jonathan Wild to Kravat.";
	}
	
	if (jarekStatus == 1) {
		header ="Bring ambassador Jarek to Devidia.";
	}
	
	// I changed this, and the reused the code in the Experiment quest.
	// I think it makes more sense to display the time remaining in
	// this fashion. SjG 10 July 2002
	if (invasionStatus >= 1 && invasionStatus < 7) {
		header ="Inform Gemulon about alien invasion";
		if (invasionStatus == 6) {
			header =" by tomorrow";			
		} else {
			header =" within ";
			String t = 7 - invasionStatus + " days";
			header =t;
		}
	} else if (SolarSystem[GEMULONSYSTEM].Special == GETFUELCOMPACTOR) {
		header ="Get your fuel compactor at Gemulon.";
	}
	
	if (experimentStatus >= 1 && experimentStatus < 11) {
		header ="Stop Dr. Fehler's experiment at Daled";
		if (experimentStatus == 10) {
			header ="by tomorrow";
			
		} else {
			header ="within ";
			String t = 11 - experimentStatus + " day.";
			header = t;
		}
	}
	
	if (reactorStatus >= 1 && reactorStatus < 21) {
		header ="Deliver the unstable reactor to Nix";
		
		if (reactorStatus < 2) {
			header ="for Henry Morgan.";
		} else {
			header ="before it consumes all its fuel.";
		}
	}
	
	if (SolarSystem[NIXSYSTEM].Special == GETSPECIALLASER) {
		header ="Get your special laser at Nix.";
	}
	
	if (scarabStatus == 1) {
		header ="Find and destroy the Scarab (which is hiding at the exit to a wormhole).";
	}
	
	if (Ship.Tribbles > 0) {
		header ="Get rid of those pesky tribbles.";
	}
	
	if (moonBought)
	{ 
		header ="Claim your moon at Utopia.";			
	}

	return header ;
	
}


}