package com.example;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class Globala extends Activity
{  
	public int MAXSPECIALNEWSEVENTS	=	5	;
	private static final int Gg = 0;
	public final int RSHIELDPOWER    = 200;
	public final int REFLECTIVESHIELD =1;
	public boolean raided=false,autoRepair;
	boolean		possibleToGoThroughRip,firstEncounter,arrivedViaWormhole,inspected,alwaysIgnorePolice,alwaysIgnorePirates;
	public boolean autoFuel,alwaysIgnoreTradeInOrbit,justLootedMarie,bLastMessage,tribbleMessage,trackAutoOff,alwaysIgnoreTraders;
	public int			trackedSystem, activeTradeItem,currentGalaxySystem,countDown;
	public boolean litterWarning,canSuperWarp;
	String currentState;
	public int NewsEvents[]=new int [5];
	String SpecialResources[] ={"Nothing special","Mineral rich",
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

	
	String solarSystemName[]={"Acamar",
			"Adahn",		// The alternate personality for The Nameless One in "Planescape: Torment"
			"Aldea",
			"Andevian",
			"Antedi",
			"Balosnee",
			"Baratas",
			"Brax",			// One of the heroes in Master of Magic
			"Bretel",		// This is a Dutch device for keeping your pants up.
			"Calondia",
			"Campor",
			"Capelle",		// The city I lived in while programming this game
			"Carzon",
			"Castor",		// A Greek demi-god
			"Cestus",
			"Cheron",		
			"Courteney",	// After Courteney Cox...
			"Daled",
			"Damast",
			"Davlos",
			"Deneb",
			"Deneva",
			"Devidia",
			"Draylon",
			"Drema",
			"Endor",
			"Esmee",		// One of the witches in Pratchett's Discworld
			"Exo",
			"Ferris",		// Iron
			"Festen",		// A great Scandinavian movie
			"Fourmi",		// An ant, in French
			"Frolix",		// A solar system in one of Philip K. Dick's novels
			"Gemulon",
			"Guinifer",		// One way of writing the name of king Arthur's wife
			"Hades",		// The underworld
			"Hamlet",		// From Shakespeare
			"Helena",		// Of Troy
			"Hulst",		// A Dutch plant
			"Iodine",		// An element
			"Iralius",
			"Janus",		// A seldom encountered Dutch boy's name
			"Japori",
			"Jarada",
			"Jason",		// A Greek hero
			"Kaylon",
			"Khefka",
			"Kira",			// My dog's name
			"Klaatu",		// From a classic SF movie
			"Klaestron",
			"Korma",		// An Indian sauce
			"Kravat",		// Interesting spelling of the French word for "tie"
			"Krios",
			"Laertes",		// A king in a Greek tragedy
			"Largo",
			"Lave",			// The starting system in Elite
			"Ligon",
			"Lowry",		// The name of the "hero" in Terry Gilliam's "Brazil"
			"Magrat",		// The second of the witches in Pratchett's Discworld
			"Malcoria",
			"Melina",
			"Mentar",		// The Psilon home system in Master of Orion
			"Merik",
			"Mintaka",
			"Montor",		// A city in Ultima III and Ultima VII part 2
			"Mordan",
			"Myrthe",		// The name of my daughter
			"Nelvana",
			"Nix",			// An interesting spelling of a word meaning "nothing" in Dutch
			"Nyle",			// An interesting spelling of the great river
			"Odet",
			"Og",			// The last of the witches in Pratchett's Discworld
			"Omega",		// The end of it all
			"Omphalos",		// Greek for navel
			"Orias",
			"Othello",		// From Shakespeare
			"Parade",		// This word means the same in Dutch and in English
			"Penthara",
			"Picard",		// The enigmatic captain from ST:TNG
			"Pollux",		// Brother of Castor
			"Quator",
			"Rakhar",
			"Ran",			// A film by Akira Kurosawa
			"Regulas",
			"Relva",
			"Rhymus",
			"Rochani",
			"Rubicum",		// The river Ceasar crossed to get into Rome
			"Rutia",
			"Sarpeidon",
			"Sefalla",
			"Seltrice",
			"Sigma",
			"Sol",			// That's our own solar system
			"Somari",
			"Stakoron",
			"Styris",
			"Talani",
			"Tamus",
			"Tantalos",		// A king from a Greek tragedy
			"Tanuga",
			"Tarchannen",
			"Terosa",
			"Thera",		// A seldom encountered Dutch girl's name
			"Titan",		// The largest moon of Jupiter
			"Torin",		// A hero from Master of Magic
			"Triacus",
			"Turkana",
			"Tyrus",
			"Umberlee",		// A god from AD&D, which has a prominent role in Baldur's Gate
			"Utopia",		// The ultimate goal
			"Vadera",
			"Vagra",
			"Vandor",
			"Ventax",
			"Xenon",
			"Xerxes",		// A Greek hero
			"Yew",			// A city which is in almost all of the Ultima games
            "Yojimbo",		// A film by Akira Kurosawa
			"Zalkon",
			"Zuul",			// From the first Ghostbusters movie

			
	};
	public enum EAlertState {
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
		ePlunderForm,
		eBribePropsal,
		eBribeOffer,
		eSubmit,
		eEngageCaptainAhabAlert,
		eEngageCaptainConradAlert,
		eEngageCaptainHuieAlert,
		eBuyEquipment,
		eSpecialEvent,
		eWildWeaponBuy,
		ePlunderRemoveGoods,
		eUpdateSpecial,
		ePlunderShipForm
		
	} ;

	EAlertState eAlertState;
	boolean bWaitFinishPlunder = false;
	public 	int clicks=0,chanceOfVeryRareEncounter;
	public final int ATTACKPOLICESCORE  = -3;
    public boolean continuous=false;
	public final int DEBTTOOLARGE	=100000,BOTTLETYPE=14;
	public int leaveEmpty=0;
	public	boolean		textualEncounters = true;
	public final int POLICEINSPECTION =0 ;
	public final int POLICEIGNORE   =  1 ;
	public final int MAXSKILL   =    10;
	public final int FABRICRIPINITIALPROBABILITY =25;
	public final int SCARABTYPE=13;		
	public int POLICE =0;
	public final int BEGINNER   =     0;
	public final int EASY       =     1;
	public final int NORMAL      =    2;
	public final int HARD        =    3;
	public final int IMPOSSIBLE   =   4;
//	public final int PIRATESURRENDER =13 ;
	public final int KILLPOLICESCORE  =   -6;
	//public final int ALREADYAHAB	=2;
	public final int ATTACKTRADERSCORE  = -2;
	public final int PLUNDERTRADERSCORE = -2;
	public final int KILLTRADERSCORE    = -4;
	public final int ATTACKPIRATESCORE  =  0;
	public final int KILLPIRATESCORE    =  1;
	public final int PLUNDERPIRATESCORE = -1;
	public final int TRAFFICKING        = -1;
	public final int FLEEFROMINSPECTION = -2;
	public final int TAKEMARIENARCOTICS=-4;

	boolean autoFlee=false;
	boolean playerShipNeedsUpdate=false,opponentShipNeedsUpdate=false,autoAttack = false;
	public final int MANTISTYPE=12;
	public final int POLICEFLEE   =    3; // Police is fleeing
	public final int MAXPOLICE   =     9;

	 public final int DRAGONFLYATTACK  =  40;
	 public final int DRAGONFLYIGNORE   = 41;
	 public final int MAXDRAGONFLY   =    49;

	 public final int MANTIS        =     50;

	 // Scarab Actions
	 public final int SCARABATTACK  =  60;
	 public final int SCARABIGNORE   = 61;
	 public final int MAXSCARAB      = 69;

	 // Famous Captain;
	 public final int FAMOUSCAPTAIN	   		=	70;
	 public final int FAMOUSCAPATTACK    	=		71;
	 public final int CAPTAINAHABENCOUNTER	=	72;
	 public final int CAPTAINCONRADENCOUNTER=		73;
	 public final int CAPTAINHUIEENCOUNTER		=74;
	 public final int MAXFAMOUSCAPTAIN           = 79;

	 // Other Special Encounters
	 public final int MARIECELESTEENCOUNTER	=	80;
	 public final int BOTTLEOLDENCOUNTER     =     81;
	 public final int BOTTLEGOODENCOUNTER     =    82;
	 public final int POSTMARIEPOLICEENCOUNTER=	83;


	public final int SPACEMONSTERATTACK =30;
	public final int SPACEMONSTERIGNORE =31;
	public final int MAXSPACEMONSTER   = 39;


	public  final int POLICEATTACK   =  2 ;
	public final int TRADER  =   20;
	public final int TRADERIGNORE =   20 ;// Trader passes
	public final int TRADERFLEE    =  21; // Trader flees
	public final int TRADERATTACK   = 22 ;// Trader is attacking (after being provoked)
	public final int TRADERSURRENDER =23 ;// Trader surrenders 
	public final int TRADERSELL	   = 24 ;// Trader will sell products in orbit
	public final int TRADERBUY		=25 ;// Trader will buy products in orbit
	public final int TRADERNOTRADE	=26; // Player has declined to transact with Trader
	public final int MAXTRADER      = 29;

	public  final int PIRATEATTACK =   10 ;// Pirate attacks
	public  final int PIRATEFLEE    =  11; // Pirate flees
	public final int PIRATEIGNORE  =  12; // Pirate ignores you (because of cloak)
	public final int PIRATESURRENDER =13; // Pirate surrenders
	public final int MAXPIRATE       =19;

	public int encounterType =0;
	public int newsSpecialEventCount=0;
	public boolean remindLoans=false;
	public int monsterHull=0;
	public boolean moonBought=false;
	public int warpSystem=0;
	public int MAXSIZE =5;
	public int UNEVENTFUL   =   0;
	public int MAXSTATUS=8;
	public int MAXRESOURCES=13;
	
	public int GALAXYWIDTH	=150;
	public int GALAXYHEIGHT =110;
	public int SHORTRANGEWIDTH =300;
	public int SHORTRANGEHEIGHT =300;
	public int SHORTRANGEBOUNDSX =10;

	public int GALAXYRANGEWIDTH =400;
	public int GALAXYRANGEHEIGHT =360;
	public int GALAXYRANGEBOUNDSX =10;
	public int BOUNDSX =5;
	public int BOUNDSY =20;
	public int GALAXYBOUNDSX =20;
	public int GALAXYBOUNDSY =50;
	public int MINDISTANCE =6;
	public int MINDISTANCEACTIVATE =30;
	public int CLOSEDISTANCE =13;
	public int WORMHOLEDISTANCE =3;
	public int EXTRAERASE =3;
	public	boolean		artifactOnBoard=false;
	public int dragonflyStatus=0;     // 0 = Dragonfly not available, 1 = Go to Baratas, 2 = Go to Melina, 3 = Go to Regulas, 4 = Go to Zalkon, 5 = Dragonfly destroyed
	public int Wormhole[]=new int[6];
	{
		
		Wormhole[0]=0;
		Wormhole[1]=0;
		Wormhole[2]=0;
		Wormhole[3]=0;
		Wormhole[4]=0;
		Wormhole[5]=0;
		   
		
	}
	public int saveitem[] =new int[10];
	public int saveItemIndex=0;
	public int savePrice=0;
	public int saveSlot=0;
	public int monsterStatus=0;
	public boolean alreadyPaidForNewspaper=false;
	public int MAXWORMHOLE =6;
	public int currentsystem=0;
	public int BuyPrice[]=new int [10];
	{
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
	}
	public int SellPrice[]=new int[10];
	{
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
	}
	public int BuyingPrice[]=new int[10];
	{
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
	}
	public	boolean		escapePod;
	public int MAXCREW = 3;
	public int jarekStatus=0;
	public int amount=0;
    public  int ForHire = 0;
	public int MAXGADGET = 3;
	public int EXTRABAYS = 0;
	public int japoriDiseaseStatus = 0;
	public int UPGRADEDHULL = 50;
	public final int COSTMOON          =500000;
	
	
	         // Ambassador Jarek 0=not delivered; 1=on board; 2=delivered
	public int wildStatus;			// Jonathan Wild: 0=not delivered; 1=on board; 2=delivered
	public int CAUGHTWITHWILDSCORE=-4;
	public int invasionStatus;      // Status Alien invasion of Gemulon; 0=not given yet; 1-7=days from start; 8=too late
	
	
	
	
	Tradeitem t[] = new Tradeitem[10];
	{
		
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
			 
	}
	
	Politics p[] = new Politics[17];
	{  
	 	 p[0]= new Politics("Anarchy", 0, 0, 7, 1, 0, 5, 7, true,  true, 11); 
	         p[1]= new Politics("Capitalist State", 2, 3, 2, 7, 4, 7,1, true,  true, 3 );
                 p[2]= new Politics( "Communist State",  6, 6, 4, 4, 1, 5, 5,true, true,  -1  );
                 p[3]= new Politics("Confederacy",5, 4, 3, 5, 1, 6, 3, true,true,4);
                 p[4]= new Politics( "Corporate State", 2, 6,2,7,4,7, 2, true,true,9 );
                 p[5]= new Politics("Cybernetic State", 0, 7, 7, 5, 6, 7, 0, false, false,3 );
                 p[6]= new Politics("Democracy",4, 3, 2, 5, 3, 7, 2, true,  true,  4 );
                 p[7]= new Politics("Dictatorship",3, 4, 5, 3, 0, 7, 2, true,  true,  -1  );
			p[8]= new Politics("Fascist State",7, 7, 7, 1, 4, 7, 0, false, true,  7 );
			p[9]= new Politics("Feudal State", 1, 1, 6, 2, 0, 3, 6, true,  true,  5 );
			p[10]= new Politics("Military State",   7, 7, 0, 6, 2, 7, 0, false, true,9 );
			p[11]= new Politics("Monarchy", 3, 4, 3, 4, 0, 5, 4, true,  true,  6  );
			p[12]= new Politics("Pacifist State",  7, 2, 1, 5, 0, 3, 1, true,  false, -1 );
			p[13]= new Politics("Socialist State", 4, 2, 5, 3, 0, 5, 6, true,  true,  -1 );
			p[14]= new Politics("State of Satori",  0, 1, 1, 1, 0, 1, 0, false, false,-1 );
			p[15]= new Politics("Technocracy", 1, 6, 3, 6, 4, 7, 2, true,  true,0  );
			p[16]= new Politics("Theocracy", 5, 6, 1, 4, 0, 4, 0, true,  true, 8 );   

     

          }
	
	Shiptype s[] = new Shiptype[15];
	{
	 	s[0]= new Shiptype("Nanomite", 10, 0, 0, 0, 1,20, 4,1, 2000, 5,2, 25,-1,-1,0,1, 0);
	 	s[1]= new Shiptype("Minox", 15, 1,0, 1, 1, 14, 5, 2,10000, 50, 28, 100, 0, 0, 0, 1,1);
	 	s[2]= new Shiptype("Spathi Scout", 20, 1, 1, 1, 1, 17, 5, 3, 25000, 75, 20, 100, 0, 0, 0, 1, 1);
	 	s[3]= new Shiptype("T-16 Womprat", 15, 2, 1, 1, 1, 13, 5, 5, 30000, 100, 20, 100, 0, 1, 0, 1, 1 );
	 	s[4]= new Shiptype("Vorchan", 25, 1, 2, 2, 2, 15, 5, 7, 60000, 125, 15, 100, 1, 1, 0, 1, 2 );
	 	s[5]= new Shiptype("Hirogen Freighter", 50, 0, 1, 1, 3, 14, 5, 10, 80000, 50, 3, 50, -1, -1, 0, 1, 2 );
	 	s[6]= new Shiptype("Vorlon Cruiser", 20, 3, 2, 1, 2, 16, 6, 15, 100000, 200, 6, 150, 2, 3, 1, 2, 3 );
	 	s[7]= new Shiptype("YT-1300", 30, 2, 2, 3, 3, 15, 6, 15, 150000, 300, 2, 150, 3, 4, 2, 3, 3 );
	 	s[8]= new Shiptype("T'khar Uberhauler", 60, 1, 3, 2, 3, 13, 7, 20, 225000, 300, 2, 200, 4, 5, 3, 4, 4 );
	 	s[9]= new Shiptype("Leviathan", 0, 3, 0, 0, 1, 1, 8, 1, 500000, 0, 0, 500, 8, 8, 8, 1, 4 );
	 	s[10]= new Shiptype("Kor'ah Menace", 0, 2, 3, 2, 1, 1, 8, 1, 500000, 0, 0, 10, 8, 8, 8, 1, 1 );
	 	s[11]= new Shiptype("Mantis", 0, 3, 1, 3, 3, 1, 8, 1, 500000, 0, 0, 300, 8, 8, 8, 1, 2  );
	 	s[12]= new Shiptype("Scarab", 20, 2, 0, 0, 2, 1, 8, 1, 500000, 0, 0, 400, 8, 8, 8, 1, 3  );
	 	s[13]= new Shiptype("Bottle", 0, 0, 0, 0, 0, 1, 8, 1, 100, 0, 0, 10, 8, 8, 8, 1, 1  );
	 	s[14]= new Shiptype("Vix Dreadnought", 35, 3, 2, 2, 3, 14, 7, 20, 300000, 500, 2, 200, 5, 6, 4, 5, 4 );
	}
	
	SHIP Ship = new SHIP(1,0,0,0,0,0,0,0,0,0,0,0,-1,-1,-1,-1,-1,0,0,0,-1,-1,-1,0,-1,-1,14,100,0,0,0,0,0);	 
	SHIP Opponent = new SHIP(1,0,0,0,0,0,0,0,0,0,0,0,-1,-1,-1,-1,-1,0,0,0,-1,-1,-1,1,-1,-1,14,100,0,0,0,0,0);
	SHIP SpaceMonster = new SHIP(10,0,0,0,0,0,0,0,0,0,0,2,2,2,-1,-1,-1,0,0,0,-1,-1,-1,31,-1,-1,1,500,0,0,0,0,0);
	SHIP Scarab = new SHIP(13,0,0,0,0,0,0,0,0,0,0,2,-2,-1,-1,-1,-1,0,0,0,-1,-1,-1,31,-1,-1,1,400,0,0,0,0,0);
	SHIP Dragonfly = new SHIP(11,0,0,0,0,0,0,0,0,0,0,2,0,1,2,2,2,350,350,350,1,3,-1,31,-1,-1,1,10,0,0,0,0,0);
	public	boolean reserveMoney=false;
	public String CommanderName="";
	public int insuranceMoney=0,Credits=0;	
	public int currentShipPriceWithoutCargo=0;
	public int CLEANSCORE=0;
	public int poilceRecordScore=0;
	public int MAXTRADEITEM=10;
    public 	int LIGHTNINGSHIELD = 2;
    public 	int LSHIELDPOWER = 350;
    public 	int AUTOREPAIRSYSTEM = 1;
    public 	int TARGETINGSYSTEM = 3;
    public 	int MAXCREWMEMBER=31,MAXSHIPTYPE=10,EXTRASHIPS=5;
    public 	int MAXWEAPON = 3;
    public 	int MAXSHIELD = 3;
    public 	int EXTRAWEAPONS=1;
	
	public int PULSELASERWEAPON    =0;
	public int PULSELASERPOWER    =15;
	public int BEAMLASERWEAPON    = 1;
	public int BEAMLASERPOWER     =25;
	public int MILITARYLASERWEAPON= 2;
	public int MILITARYLASERPOWER =35;
	public int MORGANLASERWEAPON	=3;
	public int MORGANLASERPOWER   =85; 
	// Police Record Score
	public int PSYCHOPATHSCORE =-70;
	public int VILLAINSCORE    =-30;
	public int CRIMINALSCORE   =-10;
	public int DUBIOUSSCORE    =-5;
	public int LAWFULSCORE      =5;
	public int TRUSTEDSCORE     =10;
	public int HELPERSCORE      =25;
	public int HEROSCORE        =75;

	 POLICERECORD[] PoliceRecord = new POLICERECORD[10];
	 {
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
	
	 }	
	CREWMEMBER Mercenary[] = new CREWMEMBER[32];
	{
		for(int i=0;i<32;i++)
		{
			Mercenary[i]=new CREWMEMBER();
		}
	}

	//Reputation
	public int MAXREPUTATION =9;

	public int HARMLESSREP         =0;
	public int MOSTLYHARMLESSREP   =10;
	public int POORREP             =20;
	public int AVERAGESCORE        =40;
	public int ABOVEAVERAGESCORE   =80;
	public int COMPETENTREP       =150;
	public int DANGEROUSREP       =300;
	public int DEADLYREP          =600;
	public int ELITESCORE        =1500;

		REPUTATION Reputation[] = new REPUTATION[9];
    
	{
		Reputation[0]=new REPUTATION("Harmless",0);
		Reputation[1]=new REPUTATION("Mostly Harmless",10);
		Reputation[2]=new REPUTATION("Poor",20);
		Reputation[3]=new REPUTATION("Average",40);
		Reputation[4]=new REPUTATION("Above average",80);
		Reputation[5]=new REPUTATION("Competent",150);
		Reputation[6]=new REPUTATION("Dangerous",300);
		Reputation[7]=new REPUTATION("Deadly",600);
		Reputation[8]=new REPUTATION("Elite",1500);
   }	
	
		
	public 	int experimentStatus=0;    // Experiment; 0=not given yet,1-11 days from start; 12=performed, 13=cancelled
	public 	int fabricRipProbability=0; // if Experiment = 8, this is the probability of being warped to a random planet.
	public 	int veryRareEncounter=0;     // bit map for which Very Rare Encounter(s) have taken place (see traveler.c, around line 1850)
	public 	int reactorStatus=0;			// Unstable Reactor Status: 0=not encountered; 1-20=days of mission (bays of fuel left = 10 - (ReactorStatus/2); 21=delivered
	public 	int scarabStatus=0 ;		// Scarab: 0=not given yet, 1=not destroyed, 2=destroyed, upgrade not performed, 3=destroyed, hull upgrade performed
	 
	//for WeaponType;
		WEAPON Weapontype[] = new WEAPON[4];
	{
		Weapontype[0]=new WEAPON("Pulse laser",PULSELASERWEAPON,2000,5,50);
		 Weapontype[1]=new WEAPON("Regolian Disrupters",BEAMLASERPOWER,12500,6,35); 
		 Weapontype[2]=new WEAPON("Justice Mk. V",MILITARYLASERPOWER,35000,7,15);
		 Weapontype[3]=new WEAPON("BOAKYAG Laser",MORGANLASERPOWER,50000,8, 0);
	}
		SPECIALEVENT SpecialEvent[]=new SPECIALEVENT[37];
	{
		
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
			
	}
		
	// Gadgets
	public int MAXGADGETTYPE    =5;
	public int NAVIGATINGSYSTEM =2;
	public  final int CLOAKINGDEVICE   =4;
	public int FUELCOMPACTOR    =5; 
	public int EXTRAGADGETS=1;// MAXGADGETTYPE + 1

			GADGET Gadgettype[]= new GADGET[6];
	{
	 Gadgettype[0]=new GADGET("5 extra cargo bays",2500,4,35);
	 Gadgettype[1]=new GADGET("Auto-repair system",7500,5,20); 
	 Gadgettype[2]=new GADGET("Navigation system",15000,6,20);
	 Gadgettype[3]=new GADGET("Targeting system",25000,6,20);
	 Gadgettype[4]=new GADGET("Cloaking Device",7500,5,20);
	 Gadgettype[5]=new GADGET("Fuel compactor",30000,8,0);
	}
	//SHield
	
		SHIELD Shieldtype[]= new SHIELD[4];
	{
		Shieldtype[0]=new SHIELD("Energy Shield",100,5000,5,70);
		Shieldtype[1]=new SHIELD("Reflective Shield",200,20000,6,30);
		Shieldtype[2]=new SHIELD("Lightning Shield",350,45000,8,0);
		
	}
	SOLARSYSTEM SolarSystem[] = new SOLARSYSTEM[120];
	{ 
		for(int i=0;i<120;i++)
	          SolarSystem[i]=new SOLARSYSTEM();
	}   
	
	
	// News Events that don't exactly match special events
	public int WILDARRESTED		  = 90;
	public int CAUGHTLITTERING		  = 91;
	public int EXPERIMENTPERFORMED	   =92;
	public int ARRIVALVIASINGULARITY  =93;
	public int CAPTAINHUIEATTACKED   =100;
	public int CAPTAINCONRADATTACKED =101;
	public int CAPTAINAHABATTACKED   =102;
	public int CAPTAINHUIEDESTROYED  =110;
	public int CAPTAINCONRADDESTROYED =111;
	public int CAPTAINAHABDESTROYED  =112;
	
	public int GEMULONSYSTEM    =32;
	public int JAPORISYSTEM     =41;
	public int KRAVATSYSTEM	 =50;
	public int MELINASYSTEM     =59;
	public int NIXSYSTEM		 =67;
	public int OGSYSTEM         =70;
	public int REGULASSYSTEM    =82;
	public int SOLSYSTEM        =92;
	public int UTOPIASYSTEM    =109;
	public int ZALKONSYSTEM    =118;

	public int WATER          = 0;
	public int FURS            =1;
	public int FOOD            =2;
	public int ORE             =3;
	public int GAMES           =4;
	public int FIREARMS        =5;
	public int MEDICINE        =6;
	public int MACHINERY       =7;
	public int NARCOTICS       =8;
	public int ROBOTS          =9;

	// Special events
	
	public int MAXSPECIALEVENT        =37;
	public int ENDFIXED                =7;
	public int MAXTEXT                 =9;
	public int DRAGONFLYDESTROYED      =0;
	public int FLYBARATAS              =1;
	public int FLYMELINA               =2;
	public int FLYREGULAS              =3;
	public int MONSTERKILLED           =4;
	public int MEDICINEDELIVERY        =5;
	public int MOONBOUGHT              =6;
	// ----- fixed locations precede
	public int MOONFORSALE             =7;
	public int SKILLINCREASE           =8;
	public int TRIBBLE                 =9;
	public int ERASERECORD            =10;
	public int BUYTRIBBLE             =11;
	public int SPACEMONSTER           =12;
	public int DRAGONFLY              =13;
	public int CARGOFORSALE           =14;
	public int INSTALLLIGHTNINGSHIELD =15;
	public int JAPORIDISEASE          =16;
	public int LOTTERYWINNER          =17;
	public int ARTIFACTDELIVERY       =18;
	public int ALIENARTIFACT          =19;
	public int AMBASSADORJAREK        =20;
	public int ALIENINVASION          =21;
	public int GEMULONINVADED         =22;
	public int GETFUELCOMPACTOR       =23;
	public int EXPERIMENT             =24;
	public int TRANSPORTWILD          =25;
	public int GETREACTOR			   =26;
	public int GETSPECIALLASER        =27;
	public int SCARAB			   =28;
	public int GETHULLUPGRADED		   =29;
	// ------ fixed locations follow
	public int SCARABDESTROYED	   =30;
	public int REACTORDELIVERED	   =31;
	public int JAREKGETSOUT           =32;
	public int GEMULONRESCUED         =33;
	public int EXPERIMENTSTOPPED      =34;
	public int EXPERIMENTNOTSTOPPED   =35;
	public int WILDGETSOUT			   =36;
	public int MAXTRIBBLES=  100000;
	public int MAXWEAPONTYPE =      3;
	// Max Number of Tribble Buttons
	public int TRIBBLESONSCREEN       =31;

	// Other special events (Encounters)
	// First is probability in 1000 that one could happen at all:
	public int CHANCEOFVERYRAREENCOUNTER	=5;
	public int MAXVERYRAREENCOUNTER		=6;
	public int MARIECELESTE				=0;
	public int CAPTAINAHAB					=1;
	public int CAPTAINCONRAD				=2;
	public int CAPTAINHUIE					=3;
	public int BOTTLEOLD					=4;
	public int BOTTLEGOOD				    =5;
	// Already done this encounter?
	public int ALREADYMARIE				=1;
	public int ALREADYAHAB					=2;
	public int ALREADYCONRAD				=4;
	public int ALREADYHUIE					=8;
	public int ALREADYBOTTLEOLD		   =16;
	public int ALREADYBOTTLEGOOD          =32;

	// Propability in 1000 that a trader will make offer while in orbit
	public int CHANCEOFTRADEINORBIT		=100;

	// Political systems (governments)
	public int MAXPOLITICS  =17;
	public int MAXSTRENGTH  =8;
	public int ANARCHY      =0;

	// Tech levels. 
	public int MAXTECHLEVEL =8;

	// Solar systems
	public int MAXSOLARSYSTEM  =120;
	public int ACAMARSYSTEM      =0;
	public int BARATASSYSTEM     =6;
	public int DALEDSYSTEM      =17;
	public int DEVIDIASYSTEM    =22;

	
	public Boolean Flees;
	public boolean CommanderUnderAttack;
	public String pilotName="Jameson";
	public int	pilotSkill=1;
	public int	fighterSkill = 1;
	public int	traderSkill = 1;
	public int	engineerSkill = 1;
	
	public int	gameDifficulty = 2; // 'Normal'
	public int	totalSkillPoints = 16;
	public int	credits = 1000;
	public int	debt = 0;
	public int	policeRecordScore = 0;
	public int	reputationScore = 0;
	public int	policeKills = 0;
	public int	traderKills = 0;
	public int	pirateKills = 0;
	public boolean	insurance = false;	
	public int	noClaim = 0;
	public int currentSystem =1;
	public int days = 0;
	public boolean audioPlayerReleased = true;
	
	public int MAXSHIELDTYPE =2;
	public int MAXSKILLTYPE  =4;
    public int SKILLBONUS =3;
    public int CLOAKBONUS =2;
  
    
     
	public int getEquipmentPrice(int index)
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
	
	public int BASEWEAPONPRICE(int a )
	{
		return (int) BasePrice(Weapontype[a].TechLevel, Weapontype[a].Price);
	}

	public int BASESHIELDPRICE(int  a )
	{
		return(BasePrice(Shieldtype[a].TechLevel, Shieldtype[a].Price));
	}
	
	public int BASEGADGETPRICE(int a )
	{
		return BasePrice(Gadgettype[a].TechLevel, Gadgettype[a].Price);
	}
	public int BasePrice(int techLevel2 , int Price)
	{
		if(techLevel2 > SolarSystem[currentSystem].TechLevel)
			return 0; 
		else 
			return	(Price * (100 -  TraderSkill(Ship)) / 100);
	}
	public int TraderSkill( SHIP Sh)
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
		 public int AdaptDifficulty( int Level)
		 {
			 if(gameDifficulty == 1 || gameDifficulty==2)
				 return(Level+1);
			 else if (gameDifficulty==5)
				 return (max(1,Level-1));
			 else
				 return Level;
		 }
		public int max(int i,int j)
		{
			if(i>j)
				return i;
			return j;
		}
	
		public void buyItem(int index )
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
		public void BuyItem(int weaponSlots  ,int weapon[] , int Price, String name,int ItemIndex)
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
		public int GetFirstEmptySlot( int Slots ,int Item[] )
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
		public int toSpend()
		{
			if (!reserveMoney)
				return credits;
			return max( 0,  credits -  mercenaryMoney() -  insuranceMoney() );
		}
		public int mercenaryMoney()
		{
			int i, ToPay;
			
			ToPay = 0;
			for (i=1; i<MAXCREW; ++i)
				if (Ship.Crew[i] >= 0)
					ToPay += MERCENARYHIREPRICE( Ship.Crew[i] );
			
			return ToPay;	
		}
		public int insuranceMoney()
		 {
			 boolean temp=true;
			 if(!insurance)
				 return 0;
			 return (max(1,((currentShipPriceWithoutCargo(temp)*5)/2000)*(100-min(noClaim,90))/100));
		 }
		public int MERCENARYHIREPRICE(int  a )
		{
			return (a < 0 || (a >= MAXCREWMEMBER && wildStatus == 2) ? 0 : ((Mercenary[a].Pilot + Mercenary[a].Fighter + Mercenary[a].Trader + Mercenary[a].Engineer) * 3));
		}
		public int currentShipPriceWithoutCargo(boolean forInsurance)
		 {
			int i;
			int CurPrice;
			
			// Trade-in value is three-fourths the original price

			CurPrice = 	((s[Ship.Type].Price * (Ship.Tribbles > 0 && !forInsurance? 1 : 3)) / 4)// subtract repair costs
			- (GetHullStrength() - Ship.Hull) * s[Ship.Type].RepairCosts 
			// subtract costs to fill tank with fuel
			- (s[Ship.Type].FuelTanks -  getFuel()) * s[Ship.Type].CostOfFuel;
			// Add 2/3 of the price of each item of equipment
			for (i=0; i<MAXWEAPON; ++i)
				if (Ship.Weapon[i] >= 0)
					CurPrice += WEAPONSELLPRICE( i );
			for (i=0; i<MAXSHIELD; ++i)
				if (Ship.Shield[i] >= 0)
					CurPrice += SHIELDSELLPRICE( i );
			for (i=0; i<MAXGADGET; ++i)
				if (Ship.Gadget[i] >= 0)
					CurPrice += GADGETSELLPRICE( i );
			
			return CurPrice;

			 
		 }
		public int GetHullStrength() {
			if(scarabStatus==3)
				return  (s[Ship.Type].HullStrength+UPGRADEDHULL);
			else 
				return s[Ship.Type].HullStrength;
		}
		public int getFuel()
		 {
			 return (int) min(Ship.Fuel,GetFuelTanks());
		}
		public int WEAPONSELLPRICE(int a)
		 {
			 return (int) (BaseSellPrice( Ship.Weapon[a], (int) Weapontype[Ship.Weapon[a]].Price ));

		 }
		public int SHIELDSELLPRICE(int a) {
			// TODO Auto-generated method stub
			 return (BaseSellPrice( Ship.Shield[a], (int) Shieldtype[Ship.Shield[a]].Price ));
		}
		public int GetFuelTanks() {
			// TODO Auto-generated method stub
			return 0;
		}
		public int min(int i,int j)
		{
			if(i<j)
				return i;
			else
                return j;
	     		
		}
		public int BaseSellPrice (int Index, int Price)
		 {
			if( Index>=0)
			{
				return (int) ((Price*3.0)/4.0);
			}
			else return 0;
		 }
		
		
		
		 public int GADGETSELLPRICE(int  a )
		 {
			 return (int) (BaseSellPrice( Ship.Gadget[a], (int) Gadgettype[Ship.Gadget[a]].Price ));
		 }
		 public int getBuyPrice(int num)
		 {
			 return BuyPrice[num];
		 }
		 public int getAmountToBuy(int Index) 
		 {
				
				if (BuyPrice[Index] <= 0 || SolarSystem[currentsystem].Qty[Index]  <= 0) {
					
					return 0;
				}
				int count = min( toSpend() / BuyPrice[Index],  SolarSystem[currentsystem].Qty[Index]);
				
				return count;
			}
		 public int getSellPrice(int num)
		 {
			 return SellPrice[num];
		 }
		 public int getAmountToSell(int Index)
			{
				return Ship.Cargo[Index];
			}
		 public int getOpponentAmountToSell( int Index)
			{
				return Opponent.Cargo[Index];
			}
		 public int maxLoan()
			{
				
				if(poilceRecordScore>=CLEANSCORE)
				{
					
					return(min(25000,max(1000,((currentWorth())/10/500)*500)));
				}
				else
					return 500;
			}
		 public int currentWorth()
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
		 public int CurrentShipPrice(boolean ForInsurance)   //Determine value of current ship,including good and equipment.
			{
				int i;
				int CurPrice;
				
				CurPrice =  currentShipPriceWithoutCargo(ForInsurance);
				for (i=0; i<MAXTRADEITEM; ++i)
					CurPrice += BuyingPrice[i];
				
				return (int) CurPrice;

			}
		 public int getShipHull()
			{
				return Ship.Hull;
			}
		 public int getCurrentSystemTechLevelInt() {
				return SolarSystem[currentSystem].TechLevel;
		 }
		 public int getCurrentShipTechLevel() {
				return s[0].MinTechLevel;
			}
		 public int getFuelCost()
			{
				return s[Ship.Type].CostOfFuel;
			}
			public int getRepairCost()
			{
				return s[Ship.Type].RepairCosts;	

			}
			public boolean IsNewsExist()
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
			public boolean StartNewGame()
			{
				int i, j, k, d, x, y;
				boolean Redo, CloseFound, FreeWormhole;
				
				// = false;
//				[self playMusic];

//				srandom(4);
				 
				// Initialize Galaxy
				i = 0;
				while (i < MAXSOLARSYSTEM)
				{
					if (i < MAXWORMHOLE)
					{
						// Place the first system somewhere in the centre
						SolarSystem[i].X = (char)(((CLOSEDISTANCE>>1) - 
												   GetRandom( CLOSEDISTANCE )) + ((GALAXYWIDTH * (1 + 2*(i%3)))/6));		
						SolarSystem[i].Y = (char)(((CLOSEDISTANCE>>1) - 
												   GetRandom( CLOSEDISTANCE )) + ((GALAXYHEIGHT * (i < 3 ? 1 : 3))/4));		
						Wormhole[i] = (char)i;
					}
					else
					{
						SolarSystem[i].X = (char)(1 + GetRandom( GALAXYWIDTH - 2 ));		
						SolarSystem[i].Y = (char)(1 + GetRandom( GALAXYHEIGHT - 2 ));		
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
					
					SolarSystem[i].TechLevel = (char)(GetRandom( MAXTECHLEVEL ));
					SolarSystem[i].Politics = (char)(GetRandom( MAXPOLITICS ));
					if (p[SolarSystem[i].Politics].MinTechLevel > SolarSystem[i].TechLevel)
						continue;
					if (p[SolarSystem[i].Politics].MaxTechLevel < SolarSystem[i].TechLevel)
						continue;
					
					if (GetRandom( 5 ) >= 3)
						SolarSystem[i].SpecialResources = (char)(1 + GetRandom( MAXRESOURCES - 1 ));
					else
						SolarSystem[i].SpecialResources = 0;
					
					SolarSystem[i].Size = (char)(GetRandom( MAXSIZE ));
					
					if (GetRandom( 100 ) < 15)
						SolarSystem[i].Status = 1 + GetRandom( MAXSTATUS - 1 );
					else			
						SolarSystem[i].Status = UNEVENTFUL;
					
					SolarSystem[i].NameIndex = i;
					SolarSystem[i].Special = -1;		
					SolarSystem[i].CountDown = 0;
					SolarSystem[i].Visited = false;
					
					 InitializeTradeItems(i);
					
					++i;
				}
				
				// Randomize the system locations a bit more, otherwise the systems with the first
				// names in the alphabet are all in the centre
				for (i=0; i<MAXSOLARSYSTEM; ++i)
				{
					d = 0;
					while (d < MAXWORMHOLE)
					{
						if (Wormhole[d] == i)
							break;
						++d;
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
				for (i=0; i<MAXWORMHOLE; ++i)
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
					for (j=1; j<i; ++j)
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
					
					++i;
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
					++i;
				}
				if (i >= MAXSOLARSYSTEM)
					SpecialEvent[ALIENARTIFACT].Occurence = 0;
				
				
				d = 999;
				k = -1;
				for (i=0; i<MAXSOLARSYSTEM; ++i)
				{
					int a1,b1;
				
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
				for (i=0; i<200; ++i)
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
							++d;
							if (d >= 3)
								break;
						}
					}
					if (d < 3)
						continue;
					
					break;
				}
				
				credits = 1000;
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
				for (i=0; i<MAXTRADEITEM; i++)
					BuyingPrice[i] = 0;
				boolean tribbleMessage = false;
				jarekStatus = 0;
				invasionStatus = 0;
				experimentStatus = 0;
				fabricRipProbability = 0;
			boolean 	possibleToGoThroughRip = false;
				boolean arrivedViaWormhole = false;
				veryRareEncounter = 0;
				 resetNewsEvents();
				wildStatus = 0;
				reactorStatus = 0;
		int		trackedSystem = -1;
		boolean		showTrackedRange = true;
		boolean		justLootedMarie = false;
			int	chanceOfVeryRareEncounter = 5;
				boolean		alreadyPaidForNewspaper = false;
				boolean		canSuperWarp = false;
				boolean		gameLoaded = false;
			int 	leaveEmpty = 0;
				boolean	reserveMoney = false;
				boolean	litterWarning= false;
				boolean	alwaysInfo = true;
				int	encounterType = 0;
				boolean	alwaysIgnorePolice = false;
				boolean alwaysIgnorePirates = false;
				boolean	alwaysIgnoreTraders = false;
				boolean	alwaysIgnoreTradeInOrbit = false;
				boolean	trackAutoOff = false;
		int		ChanceOfTradeInOrbit = 10;
				boolean	autoFuel = false;
				boolean	autoRepair = false;
				boolean	playerShipNeedsUpdate = false;
				boolean		opponentShipNeedsUpdate = false;
				boolean		autoAttack = false;
				boolean		autoFlee = false;
				boolean		textualEncounters = true;
				boolean		continuous = false;
				boolean		encounterWindow = false;
				
				// Initialize Ship
				Ship.Type =	0;
				for (i=0; i<MAXTRADEITEM; ++i)
					Ship.Cargo[i] = 0;
				Ship.Weapon[0] = -1;
				for ( i=1; i<MAXWEAPON; i++)
					Ship.Weapon[i] = -1;
				for (i=0; i<MAXSHIELD; ++i)
				{
					Ship.Shield[i] = -1;
					Ship.ShieldStrength[i] = 0;
				}
				for (i=0; i<MAXGADGET; ++i)
					Ship.Gadget[i] = -1;
				Ship.Crew[0] = 0;
				for (i=1; i<MAXCREW; ++i)
					Ship.Crew[i] = -1;
				Ship.Fuel =  GetFuelTanks();
				Ship.Hull = s[Ship.Type].HullStrength;
				Ship.Tribbles = 0;
				int DeterminePrices;
				DeterminePrices=currentSystem;
				
				
				//[self SaveGame:"Autosave"];
			//	[self playSound:eBeginGame];
			updateMercenary0Data();
				return true;
			}
			public int GetRandom(int a){
				   Random r=new Random();
			       int i=r.nextInt(a)%a;
			       return i;
			}
			public int SqrDistance( SOLARSYSTEM a  , SOLARSYSTEM b)
			{
				return (SQR( a.X - b.X ) + SQR( a.Y - b.Y ));
			}
			public int SQR(int i)
			{
				return i*i;
			}
			public void InitializeTradeItems(int index) {
				int i;
				
				for (i=0; i<MAXTRADEITEM; ++i)
				{
					if (((i == NARCOTICS) &&
						 (!p[SolarSystem[index].Politics].DrugsOk)) ||
						((i == FIREARMS) &&
						 (!p[SolarSystem[index].Politics].FirearmsOk)) ||
						(SolarSystem[index].TechLevel < t[i].TechProduction))
					{
						SolarSystem[index].Qty[i] = 0;
						continue;
					}
					
					SolarSystem[index].Qty[i] = 
					((9 + GetRandom( 5 )) - 
					( t[i].TechTopProduction - SolarSystem[index].TechLevel )) * 
					(1 + SolarSystem[i].Size);
					
					// Because of the enormous profits possible, there shouldn't be too many robots or narcotics available
					if (i == ROBOTS || i == NARCOTICS) 
						SolarSystem[index].Qty[i] = ((SolarSystem[index].Qty[i] * (5 - gameDifficulty)) / (6 - gameDifficulty)) + 1;
					
					if (t[i].CheapResource >= 0)
						if (SolarSystem[index]. SpecialResources ==
							t[i].CheapResource)
							SolarSystem[index].Qty[i] = (SolarSystem[index].Qty[i] * 4) / 3;
					
					if (t[i].ExpensiveResource >= 0)
						if (SolarSystem[index].SpecialResources ==
							t[i].ExpensiveResource)
							SolarSystem[index].Qty[i] = (SolarSystem[index].Qty[i] * 3) >> 2;
					
					if (t[i].DoublePriceStatus >= 0)
						if (SolarSystem[index].Status == t[i].DoublePriceStatus)
							SolarSystem[index].Qty[i] = SolarSystem[index].Qty[i] / 5;
					
					SolarSystem[index].Qty[i] = SolarSystem[index].Qty[i] - GetRandom( 10 ) +
					GetRandom( 10 );
					
					if (SolarSystem[index].Qty[i] < 0)
						SolarSystem[index].Qty[i] = 0;
				}
			}
			public boolean wormholeExists(int a ,int b)
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
			public int RandomSkill()
			 {
				    Random randomGenerator = new Random();

				 return 1+ randomGenerator.nextInt(5)+randomGenerator.nextInt(6);
			 }
			public int RealDistance(int solarSystem2  , int solarSystem3)
			{
				return  (int) (Math.sqrt(  SqrDistance(SolarSystem[solarSystem2] ,SolarSystem[ solarSystem3] )));
			}
			public void resetNewsEvents()
			{
				newsSpecialEventCount = 0;
			}
			public int IsHireExist()
			{
				return  GetForHire() ;
			}
			public int GetForHire()
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
			public boolean IsSpecialExist()
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
			
			public int totalCargoBays()  //Calculate total cargo bays
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
			public int filledCargoBays()//Calculate total filled cargo bays
			{
				int sum, i;
				sum =0;
				for(i=0;i<MAXTRADEITEM;i++)
					sum = sum + Ship.Cargo[i];
				return sum;
			}
			public int OpenQuests()
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
			
			public int ExecuteAction(boolean CommanderFlees)
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
					SHIP Defender = null;
					CommanderGotHit =  ExecuteAttack(Opponent,Defender, CommanderFlees ,CommanderUnderAttack);
				}
				
				OpponentGotHit = false;
				
				if (!CommanderFlees)
				{
					if (encounterType == POLICEFLEE || encounterType == TRADERFLEE ||
						encounterType == PIRATEFLEE)	
					{
						Flees=true;
						CommanderUnderAttack=false;
						SHIP Defender = null;
						OpponentGotHit = ExecuteAttack(Defender,Opponent , Flees, CommanderUnderAttack);
					}
					else
					{
						Flees=false;
					    CommanderUnderAttack=false;
					    SHIP Defender = null;
						OpponentGotHit = ExecuteAttack( Defender,Opponent ,Flees, CommanderUnderAttack);
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
					 
						return  1 ;
					}
					else
					{
						
				//		[self FrmAlert:"BothDestroyedAlert"];
				//		[self showDestroyedShipWindow];
						
					}
					return 0;
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
						++policeKills;
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
					//	[self replaceNewsEvent:[self latestNewsEvent] replacementEventFlag:([self latestNewsEvent] + 10)];
						
					}
					
					else if (ENCOUNTERPIRATE( encounterType ))
					{
						if (Opponent.Type != MANTISTYPE)
						{
						    credits +=  GetBounty(Opponent);
							policeRecordScore += KILLPIRATESCORE;
						    Scoop();
						}
						++pirateKills;
					}
					else if (ENCOUNTERTRADER( encounterType ))
					{
						++traderKills;
						policeRecordScore += KILLTRADERSCORE;
						Scoop();
					}
					else if (ENCOUNTERMONSTER( encounterType ))
					{
						++pirateKills;
						policeRecordScore += KILLPIRATESCORE;
						monsterStatus = 2;
					}
					else if (ENCOUNTERDRAGONFLY( encounterType ))
					{
						++pirateKills;
						policeRecordScore += KILLPIRATESCORE;
						dragonflyStatus = 5;
					}
					else if (ENCOUNTERSCARAB( encounterType ))
					{
						++pirateKills;
						policeRecordScore += KILLPIRATESCORE;
						scarabStatus = 2;
					}
					reputationScore += 1 + (Opponent.Type>>1);
					return 0;
				}
				else if (Ship.Hull <= 0)
				{
					autoAttack = false;
					autoFlee = false;
					
					if (escapePod)
					{
						 EscapeWithPod();
						return( 1 );
					}
					else
					{
				//		[self FrmAlert:"ShipDestroyedAlert"];
				//		[self showDestroyedShipWindow];

					}
					return 0;
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
						
						return 0;
					}
					else if ((GetRandom( 7 ) + ( PilotSkill(Ship) / 3)) * 2 >=  GetRandom( PilotSkill(Opponent ) ) * (2 + gameDifficulty))
				    {
						autoAttack = false;
						autoFlee = false;
						if (CommanderGotHit)
						{
						int	offset=6;
						boolean commandersShip=true;
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
						return 0;
					}
				}
			else if (encounterType == POLICEFLEE || encounterType ==TRADERFLEE || encounterType == PIRATEFLEE || encounterType == TRADERSURRENDER || encounterType == PIRATESURRENDER)	
				{
					if (4*GetRandom(  PilotSkill(Ship) ) <= GetRandom( (07 + ( PilotSkill(Opponent) / 3))) * 2)
					{
						autoAttack = false;
						autoFlee = false;

					//	[self FrmAlert:"OpponentEscapedAlert"];
						return 0;
					}
				}
				// Determine whether the opponent's actions must be changed
				PrevencounterType = encounterType;
				
				if (Opponent.Hull < OpponentHull)
				{
					if (ENCOUNTERPOLICE( encounterType ))
					{
						if (Opponent.Hull < (OpponentHull *2))
							if (Ship.Hull < (ShipHull *2))
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
						int xyz=0;
						xyz=(OpponentHull * 2) / 3;
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
					if (!(autoAttack &&
						  (encounterType == TRADERFLEE || encounterType == PIRATEFLEE || encounterType == POLICEFLEE)))
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

				return 1;
			}
public int getSellEquipmentPrice(int index)
{
	if (index < MAXWEAPON)
		return WEAPONSELLPRICE(index);	
	else
		if (index < MAXWEAPON + MAXSHIELD) {
			return (int) SHIELDSELLPRICE(index - MAXWEAPON);				
		} 
		else {
			return GADGETSELLPRICE(index - MAXWEAPON - MAXSHIELD);							
		}	
}
	public boolean ENCOUNTERPOLICE(int a )
	{
		if(a >= POLICE && a <= MAXPOLICE)
			return true;
		else 
			return	false;
	}
	public boolean ENCOUNTERTRADER(int a )
	{
		if(a >= TRADER && a <= MAXTRADER)
			return true;
		else
			return false;
	}
	public boolean ENCOUNTERPIRATE(int a) {
		// TODO Auto-generated method stub
		 if(a >= POLICE && a <= MAXPOLICE)
			 return true;
		 
		return false;
	}
	public int PilotSkill(SHIP Sh)
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
	public  boolean HasGadget( SHIP Sh ,int Gg)
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
	public boolean ENCOUNTERMONSTER(int  a )
	{
		if(a >= SPACEMONSTERATTACK && a <= MAXSPACEMONSTER)
		{
			return true;
		}
		else return false;
	}
	public boolean ENCOUNTERSCARAB(int a )
	{
		if(a >= SCARABATTACK && a <= MAXSCARAB)
			return true;
		else return false;
		
	}
	public boolean ENCOUNTERDRAGONFLY( int a )
	{
		if(a >= DRAGONFLYATTACK && a <= MAXDRAGONFLY)
			return true;
		else
			return false;
	}
	public boolean ENCOUNTERFAMOUS(int a )
	{
		if(a >= FAMOUSCAPTAIN && a <= MAXFAMOUSCAPTAIN)
			return true;
		else
			return false;
		
	}
	public boolean ExecuteAttack(SHIP Attacker,SHIP Defender ,boolean Flees,boolean CommanderUnderAttack)
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
	public  int EngineerSkill(SHIP Sh) 
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
	 public int FighterSkill (SHIP Sh){
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
	 public int TotalWeapons(SHIP Sh,int minWeapon,int maxWeapon)
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
	 public int GetBounty(SHIP Sh)
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
	 public int EnemyShipPrice ( SHIP Sh )
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
	
	public void Scoop()
	 {
	 //	[self showPlunderForm:ePickupCannister];
	 	 	
	 }
	public void EscapeWithPod(){
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
	public void IncDays(int Amount)
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
	public void CreateFlea()
	{
		int i;
		CreateShip(0);
		for (i=1; i<MAXCREW; ++i)
			Ship.Crew[i] = -1;
		
		escapePod = false;
		insurance = false;
		noClaim = 0;

	}
	void CreateShip(int Index)
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
	public void Arrival()
	{
		currentSystem = warpSystem;
		SolarSystem[currentSystem].Visited = true;
		ShuffleStatus();
		//ChangeQuantities();
		DeterminePrices(currentSystem);
		alreadyPaidForNewspaper = false;
	//	[encounterViewControllerInstance.view removeFromSuperview];
	//	encounterWindow = false;	
	//	 SaveGame("Autosave");
	//	if (arrivedViaWormhole)
		//	[self playSound:eWormholeJump];

	}
	public void ShuffleStatus()
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
	public void DeterminePrices(int SystemID )
	{
		int i;
		
		for (i=0; i<MAXTRADEITEM; ++i)
		{
			BuyPrice[i] = (int) StandardPrice(i,SolarSystem[SystemID].Size ,SolarSystem[SystemID].TechLevel,	SolarSystem[SystemID].Politics ,SolarSystem[SystemID].SpecialResources);
			
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
	public int StandardPrice(int Good,int Size,int Tech,int Government,int Resources)
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
	public void RecalculateBuyPrices(int SystemID)
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
	public boolean isShipCloaked() {
		return Cloaked(Ship ,Opponent);
	}
	public boolean  Cloaked(SHIP Sh , SHIP Opp )
	{ 
		
		return  HasGadget(Sh,CLOAKINGDEVICE) ;// &&  EngineerSkill(Sh);
	}
	public void payback(int cash)
	 {
		 int  Amount;
		 Amount = min (debt,cash);
		 Amount = min(Amount,credits);
		 credits= (int) (credits - Amount);
		 debt = (int) (debt - Amount);
		 
	 }
	public void buyCargo(int index , int Amount)  
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
	public int getPriceDifference(int itemIndex,boolean difference ,int realPrice, int maxCount,int isSmart)
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
			
	public void BuyFuel(int Amount)
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
	public boolean attack()
	{
		
		if (TotalWeapons(Ship, -1, -1) <= 0)
		{
		//	[self FrmAlert: "NoWeaponsAlert"];
			return true;
		}
		
		
		if (ENCOUNTERPOLICE( encounterType ) || encounterType == POSTMARIEPOLICEENCOUNTER)
		{
			
			if (policeRecordScore > CRIMINALSCORE)
				policeRecordScore = CRIMINALSCORE;
			
			policeRecordScore += ATTACKPOLICESCORE;
			
			if (encounterType == POLICEIGNORE || encounterType == POLICEINSPECTION ||
				encounterType == POSTMARIEPOLICEENCOUNTER)
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
		if ( ExecuteAction(false)>0)
			return true;
		if (Ship.Hull <= 0)
			return true;
		 Travel();
		
		return false;
	}
public void  Travel()
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
				
				//Opponent = SpaceMonster;
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

			//	[self GenerateOpponent: POLICE ];
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
					continue;
				}
				
				
				// If you automatically don't want to confront someone who ignores you, the
				// encounter may not take place
				if (alwaysIgnorePolice && (encounterType == POLICEIGNORE || 
										   encounterType == POLICEFLEE))
				{
					--clicks;
					continue;
				}
				
				
				return;
			}
			// Encounter with pirate
			else if (Pirate || Mantis)
			{
				if (Mantis)
				{
					String m="MANTI";
					 GenerateOpponent(m);
				}
				else
				{
					 String p="PIRAT";
					 GenerateOpponent("PIRAT");
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
					continue;
				}
				if (alwaysIgnorePirates && (encounterType == PIRATEIGNORE ||
											encounterType == PIRATEFLEE))
				{
					--clicks;
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
					continue;
				}
				// pay attention to user's prefs with regard to ignoring traders
				if (alwaysIgnoreTraders && (encounterType == TRADERIGNORE ||encounterType == TRADERFLEE))
				{
					--clicks;
					continue;
				}
				// pay attention to user's prefs with regard to ignoring trade in orbit
				if (alwaysIgnoreTradeInOrbit && (encounterType == TRADERBUY || encounterType == TRADERSELL))
				{
					--clicks;
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

public boolean HasWeapon( SHIP Sh ,int Gg, boolean exactCompare)
{
    int i;
	
    for (i=0; i<MAXWEAPON; ++i)
    {
	    if (Sh.Weapon[i] < 0)
	        continue;
        if ((Sh.Weapon[i] == Gg) || (Sh.Weapon[i] > Gg && !exactCompare))
	        return true;
    }
	
    return false;
}
public void GenerateOpponent(String Opp) {
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
public void buyRepairs( int Amount )
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




public boolean HasShield( SHIP Sh ,char Gg )
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

public boolean HasTradeableItems( SHIP sh  ,int theSystem, int Operation)
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
public int getShipOpponentType(){
	return Opponent.Type;
}
String getShipName(int index ){
	return s[index].Name;	
}

public boolean flee()
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
	if (ExecuteAction( true)>0)
		return true;
	if (Ship.Hull <= 0)
		return true;
	
	 Travel();
	
	return false;
}

public boolean ignore()
{
	autoAttack = false;
	autoFlee = false;
	 Travel();
	
	
	return false;
}
public boolean trade()
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

public boolean yield()
{
	if (wildStatus == 1)
	{
		currentState =" eYieldChoice";
		
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


public boolean surrender()
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
			return true;
		}
	}
	else if (ENCOUNTERPOLICE( encounterType ))
	{
		if (policeRecordScore <= PSYCHOPATHSCORE)
		{
			//[self FrmAlert:"NoSurrenderAlert"];
			return true;
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
				return true;
			}
			
			else if (reactorStatus > 0 && reactorStatus < 21)
			{
				//				if (FrmCustomAlert( WantToSurrenderAlert, "You have an illegal Reactor on board! ", "They will destroy the reactor. ", NULL) == WantToSurrenderNo)
				currentState =" eSurrender";		
			//	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"You have an illegal Reactor on board!" message:"They will destroy the reactor."  
			//																	delegate:self cancelButtonTitle:"Surrender" otherButtonTitles:"Cancel", nil];
				
				bLastMessage = false;
				return true;
			}
			else
			{
				//	if (FrmCustomAlert( WantToSurrenderAlert, NULL, NULL, NULL ) == WantToSurrenderNo)
				currentState = "eSurrender";						
				//UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Surrender!" message:NSLocalizedString("WantToSurrenderAlert", "")  
						//														delegate:self cancelButtonTitle:"Surrender" otherButtonTitles:"Cancel", nil];
				bLastMessage = false;
				return true;
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

public boolean bribeContinue()
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


public boolean bribe() {
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
	
	if (encounterType == POLICEINSPECTION && Ship.Cargo[FIREARMS] <= 0 &&
		Ship.Cargo[NARCOTICS] <= 0 && wildStatus != 1)
	{
		currentState = "eBribePropsal";			
		// take the cargo of the Marie Celeste?
	//	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Bribe" message:
		//								  NSLocalizedString("SureToFleeOrBribeAlert", "") delegate:self cancelButtonTitle:"Cancel" otherButtonTitles:"Bribe", nil];
		
		
		bLastMessage = false;
		return true;
	}
	
	return  bribeContinue();
	
}


public boolean submit() {
	
	autoAttack = false;
	autoFlee = false;
	
	String str, str2;
	
	if (encounterType == POLICEINSPECTION && (Ship.Cargo[FIREARMS] > 0 ||
											  Ship.Cargo[NARCOTICS] > 0 || wildStatus == 1 ||
											  (reactorStatus > 1 && reactorStatus < 21)))
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
			//str="illegal goods";
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

boolean  submitContinue()
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

public boolean plunder()
{
	autoAttack = false;
	autoFlee = false;
	
	if (ENCOUNTERTRADER( encounterType ))
		policeRecordScore += PLUNDERTRADERSCORE;
	else
		policeRecordScore += PLUNDERPIRATESCORE;
	
	 
	
	return true;
}

public boolean interrupt()
{
	autoFlee = false;
	autoAttack = false;
	//[self Travel];
	//[encounterViewControllerInstance showEncounterWindow];
	
	return false;	
}

public boolean meet() {
	
	
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

public boolean board() {
	
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
public void getLoan(long loan) 
{
	long amount;
	amount = min( maxLoan() - debt, (int)loan );
	credits += amount;
	debt += amount;
//	[self playSound:eGetLoan];
}

public boolean drink (){
	
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
		
	} else {
	 Travel();
		
		
		return false;			
	}
	
	//UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Encounter" message:NSLocalizedString("EngageBottleAlert", "") 
	//													  delegate:self cancelButtonTitle:"Yes" otherButtonTitles:"No", nil];
	
			
	bLastMessage = false;
	return true;
}


// Returns number of open quests.









public int GetRandomTradeableItem( SHIP sh ,int Operation)
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


public boolean yieldContinue()
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



public void Arrested()
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

public void payInterest(){
	
	if (debt > 0) {
		 int incDebt = max(1, debt /10);
		if (credits > incDebt) {
			credits -= incDebt;
    } else {
			debt += (incDebt - credits);
    }
	}
}


public String getSolarSystemName(int Index ){
	return  solarSystemName[Index]; 
}
public void addNewsEvent(int eventFlag)
{
	if (newsSpecialEventCount < MAXSPECIALNEWSEVENTS - 1)
		NewsEvents[newsSpecialEventCount++] = eventFlag;
}
public void sellEquipment(int index) {
	if (index < MAXWEAPON) {
		credits += WEAPONSELLPRICE(index);
		for (int i = index + 1; i < MAXWEAPON; ++i) {
			Ship.Weapon[i-1] = Ship.Weapon[i];      
    }
		Ship.Weapon[MAXWEAPON - 1] = -1;
	} else if (index < MAXWEAPON + MAXSHIELD) {
		index =index - MAXWEAPON;
		credits += WEAPONSELLPRICE(index);
		for (int i = index + 1; i < MAXSHIELD; ++i) {
			Ship.Shield[i-1] = Ship.Shield[i];
			Ship.ShieldStrength[i-1] = Ship.ShieldStrength[i];	
		}
		Ship.Shield[MAXSHIELD - 1] = -1;
		Ship.ShieldStrength[MAXSHIELD - 1] = -1;		
	} else {
		index = index - MAXWEAPON - MAXSHIELD;
		
		if ( filledCargoBays() >  totalCargoBays() - 5) {
			//[self FrmAlert:@"CargoBaysFullAlert"];      
    } else {
			credits += GADGETSELLPRICE(index);
			for (int i = index + 1; i < MAXGADGET; ++i) {
				Ship.Gadget[i-1] = Ship.Gadget[i];
      }
			Ship.Gadget[MAXGADGET - 1] = -1;		
		}
	}	
}
public String getSolarSystemSpecalResources(int index ){
	if (SolarSystem[warpSystem].Visited)
		return  SpecialResources[SolarSystem[index].SpecialResources] ;
	else
		return "Special resources unknown";
}

public int getSolarSystemX(int Index ){
	return SolarSystem[Index].X;

}
public int getSolarSystemY(int Index ){
	return SolarSystem[Index].Y;
}
public boolean getSolarSystemVisited(int Index) {
	
	return SolarSystem[Index].Visited;
}

public int getCurrentSystemIndex() {
	return currentSystem;
}
public void doWarp(boolean viaSingularity) {
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
public int  WormholeTax(int a ,int b)
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
public int JETTISONCARGO	=3;
public int DUMPCARGO=2;
public int SELLCARGO=1;
private int plunderItem;
private int plunderCount;
public void sellCargo(int Index,int Amount,int Operation)
{
	
	if (Operation == JETTISONCARGO) {
		if (policeRecordScore > DUBIOUSSCORE && !litterWarning) {
			
			litterWarning = true;
			// TODO!!!!!
			//if (FrmAlert(SpaceLitteringString) 
		}
	}
	
	int ToSell = min(Amount, Ship.Cargo[Index]);
	
	if (Operation == DUMPCARGO) {
		
		ToSell = min(ToSell,  toSpend() / 5 * (gameDifficulty + 1));
	}
	
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
public void continuePlunder()
{
	bWaitFinishPlunder = false;
//	[self showPlunderForm:ePickItUp];	
}
public void plunderItems(int index, int count)
{
	plunderItem = index;
	plunderCount = count;
}
public int STARTCOUNTDOWN(){
	return gameDifficulty+3;
}
public void updateMercenary0Data()
{
	
	Mercenary[0].Trader = traderSkill;
	Mercenary[0].Engineer = engineerSkill;
	Mercenary[0].Fighter = fighterSkill;
	Mercenary[0].Pilot = pilotSkill;
	

}
}