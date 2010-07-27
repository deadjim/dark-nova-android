package com.example;
import java.util.Date;
import java.util.Random;

import android.app.Activity;


public class TOTAL extends Activity {
/*	public int amount;
	public  int ForHire = 0;
	public int MAXGADGET = 3;
	public int EXTRABAYS = 0;
	public int japoriDiseaseStatus = 0;
	public long UPGRADEDHULL = 50;
	public int MAXCREW = 3;
	public int jarekStatus;         // Ambassador Jarek 0=not delivered; 1=on board; 2=delivered
	public int wildStatus;			// Jonathan Wild: 0=not delivered; 1=on board; 2=delivered
	public int CAUGHTWITHWILDSCORE=-4;
	public int invasionStatus;      // Status Alien invasion of Gemulon; 0=not given yet; 1-7=days from start; 8=too late
	
	Tradeitem t[] = new Tradeitem[10];//tradeitem class array object
	Politics p[] = new Politics[17];//Politics class array objetct
	Shiptype s[] = new Shiptype[15];
	SHIP Ship = new SHIP();	 
	SHIP Opponent = new SHIP();
	SHIP SpaceMonster = new SHIP();
	SHIP Scarab = new SHIP();
	SHIP Dragonfly = new SHIP();
	 String CommanderName;
	public int insuranceMoney,Credits;	
	public int currentShipPriceWithoutCargo;
	public int CLEANSCORE;
	public int poilceRecordScore;
	int MAXTRADEITEM=10;
	int LIGHTNINGSHIELD = 2;
	long LSHIELDPOWER = 350;
	int AUTOREPAIRSYSTEM = 1;
	int TARGETINGSYSTEM = 3;
	int MAXCREWMEMBER=31,MAXSHIPTYPE=10,EXTRASHIPS=5;
	int MAXWEAPON = 3;
	int MAXSHIELD = 3;
	int EXTRAWEAPONS=1;
	public int MAXWEAPONTYPE =      3;
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
	
	POLICERECORD PoliceRecord[] = new POLICERECORD[10];
	

	//Reputation
	public int MAXREPUTATION =9;

	public int HARMLESSREP          =0;
	public int MOSTLYHARMLESSREP   =10;
	public int POORREP             =20;
	public int AVERAGESCORE        =40;
	public int ABOVEAVERAGESCORE   =80;
	public int COMPETENTREP       =150;
	public int DANGEROUSREP       =300;
	public int DEADLYREP          =600;
	public int ELITESCORE        =1500;

	REPUTATION Reputation[] = new REPUTATION[MAXREPUTATION];


	
	int experimentStatus;    // Experiment; 0=not given yet,1-11 days from start; 12=performed, 13=cancelled
	int fabricRipProbability; // if Experiment = 8, this is the probability of being warped to a random planet.
	int veryRareEncounter;     // bit map for which Very Rare Encounter(s) have taken place (see traveler.c, around line 1850)
	int reactorStatus;			// Unstable Reactor Status: 0=not encountered; 1-20=days of mission (bays of fuel left = 10 - (ReactorStatus/2); 21=delivered
	int scarabStatus ;		// Scarab: 0=not given yet, 1=not destroyed, 2=destroyed, upgrade not performed, 3=destroyed, hull upgrade performed
	 
	//for WeaponType;
	WEAPON Weapontype[] = new WEAPON[4];
	
	
	// Gadgets
	public int MAXGADGETTYPE    =5;
	public int NAVIGATINGSYSTEM =2;
	public int CLOAKINGDEVICE   =4;
	public int FUELCOMPACTOR    =5; 
	public int EXTRAGADGETS=1;// MAXGADGETTYPE + 1

	GADGET Gadgettype[]= new GADGET[MAXGADGETTYPE+EXTRAGADGETS];
	
	
	//SHield
	
	SHIELD Shieldtype[]= new SHIELD[4];
	
	SOLARSYSTEM SolarSystem[] = new SOLARSYSTEM[120];
	
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
	public int COSTMOON          =500000;
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
	
	
	 
	 public void initEmpty()
	{
		pilotName="Jameson";
		pilotSkill=1;
		fighterSkill = 1;
		traderSkill = 1;
		engineerSkill = 1;
		gameDifficulty = 2; // 'Normal'
		totalSkillPoints = 16;
		credits = 1000;
		debt = 0;
		policeRecordScore = 0;
		reputationScore = 0;
		policeKills = 0;
		traderKills = 0;
		pirateKills = 0;
		insurance = false;	
		noClaim = 0;
		currentSystem =1;
		days = 0;
		audioPlayerReleased = true;
	}
	 
	
	public long currentWorth()
	{
		boolean temp=false;
		long i1= (int) (credits-debt+ (CurrentShipPrice(temp)));
		long i2 = moonBought? COSTMOON:0;
		return i1+i2;
	}
	public void payInterest()
	{
		if(debt>0)
		{
			int incDebt = (int) max(1,debt/10);
			if( credits>incDebt)
				credits -= incDebt;
			else
				debt+= (incDebt-credits);
		}
	}
	
	
	public long maxLoan()
	{
		
		if(poilceRecordScore>=CLEANSCORE)
		{
			
			return(min(25000,max(1000,((currentWorth())/10/500)*500)));
		}
		else
			return 500;
	}
	public long  max(long a, long b)
	{
		if(a>b)
			return a;
		else
			return b;
	}
	public long min(long a,long b)
	{
		if(a>b)
			return b;
		else 
			return a;
	}
	
	public void getLoan(long loan)
	{
		long amount;
		amount = min((maxLoan()-debt),loan);
		credits = (int) (credits+ amount);
		debt = (int) (debt + amount);
	}
	
	 void payback(long cash)
	 {
		 long Amount;
		 Amount = min (debt,cash);
		 Amount = min(Amount,credits);
		 credits= (int) (credits - Amount);
		 debt = (int) (debt - Amount);
		 
	 }
	 
	 public long BaseSellPrice (int Index, int Price)
	 {
		if( Index>=0)
		{
			return (long) ((Price*3.0)/4.0);
		}
		else return 0;
	 }
	 
	 public long currentShipPriceWithoutCargo(boolean forInsurance)
	 {
		int i;
		long CurPrice;
		
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
	 
	 public int RandomSkill()
	 {
		    Random randomGenerator = new Random();

		 return 1+ randomGenerator.nextInt(5)+randomGenerator.nextInt(6);
	 }
	 
	 public int GADGETSELLPRICE(int  a )
	 {
		 return (int) (BaseSellPrice( Ship.Gadget[a], (int) Gadgettype[Ship.Gadget[a]].Price ));
	 }
	 public long SHIELDSELLPRICE(int a) {
		// TODO Auto-generated method stub
		 return (BaseSellPrice( Ship.Shield[a], (int) Shieldtype[Ship.Shield[a]].Price ));
	}

	public int WEAPONSELLPRICE(int a)
	 {
		 return (int) (BaseSellPrice( Ship.Weapon[a], (int) Weapontype[Ship.Weapon[a]].Price ));

	 }
	 public int getFuel()
	 {
		 return (int) min(Ship.Fuel,GetFuelTanks());
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
	 
	public long getSellPrice(int num)
	 {
		 return SellPrice[num];
	 }
	public long getBuyPrice(int num)
	 {
		 return BuyPrice[num];
	 }
	public long getBuyingPrice(int num)
	{
		return BuyingPrice[num];
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
	public int getWormhole(int Index)
	{
		return (int) Wormhole[Index];
	}
	public int getAmountToSell(int Index)
	{
		return Ship.Cargo[Index];
	}
	
	public int getOpponentAmountToSell( int Index)
	{
		return Opponent.Cargo[Index];
	}
	public int filledCargoBays()//Calculate total filled cargo bays
	{
		int sum, i;
		sum =0;
		for(i=0;i<MAXTRADEITEM;i++)
			sum = sum + Ship.Cargo[i];
		return sum;
	}
	
	public int GetFuelTanks() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long GetHullStrength() {
		if(scarabStatus==3)
			return  (s[Ship.Type].HullStrength+UPGRADEDHULL);
		else 
			return s[Ship.Type].HullStrength;
	}

	public long getShipHull()
	{
		return Ship.Hull;
	}
	
	public long getShipOpponentHull()
	{
		return Opponent.Hull;
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
	
	public void BuyShip(int Index)  //Buy a new ship
	{
		CreateShip(Index);
		credits -= ShipPrice[Index];
		if( scarabStatus ==3)
		{
			scarabStatus=0;
		}
	}
	
	public long CurrentShipPrice(boolean ForInsurance)   //Determine value of current ship,including good and equipment.
	{
		int i;
		long CurPrice;
		
		CurPrice =  currentShipPriceWithoutCargo(ForInsurance);
		for (i=0; i<MAXTRADEITEM; ++i)
			CurPrice += BuyingPrice[i];
		
		return CurPrice;

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
	
	public void buyRepairs(int Amount)//Repair Ship for Amount Credits
	{
		int MaxRepairs;
		int Percentage;
		MaxRepairs = (int) (( GetHullStrength()-Ship.Hull)*s[Ship.Type].RepairCosts);
		if (Amount > MaxRepairs)
			Amount = MaxRepairs;
		if (Amount > credits)
			Amount = credits;
		
		Percentage = Amount / s[Ship.Type].RepairCosts;
		
		Ship.Hull += Percentage;
		credits -= Percentage * s[Ship.Type].RepairCosts;

	}
	
	public int getFuelCost()
	{
		return s[Ship.Type].CostOfFuel;
	}
	public int getRepairCost()
	{
		return s[Ship.Type].RepairCosts;	

	}
	
	public int getShipCargoBays(int Index)
	{
		return s[Index].CargoBays;

	}
	public int getShipRange(int Index)
	{
		return s[Index].FuelTanks;	

	}
	public int getSHipHullStrength(int Index)
	{
		return (int) s[Index].HullStrength;	

	}
	public int getShipWeaponSlots(int Index)
	{
		return s[Index].WeaponSlots;	

	}
	public int getShipShieldSlots(int Index)
	{
		return s[Index].ShieldSlots;	

	}
	public int getShipGadgetSlots(int Index)
	{
		return s[Index].GadgetSlots;	

	}
	public int getShipCrewQuarters(int Index)
	{
		return s[Index].CrewQuarters;	

	}
		public long insuranceMoney()
	 {
		 boolean temp=true;
		 if(!insurance)
			 return 0;
		 return (max(1,((currentShipPriceWithoutCargo(temp)*5)/2000)*(100-min(noClaim,90))/100));
	 }
	 
	 public int AdaptDifficulty( int Level)
	 {
		 if(gameDifficulty == 1 || gameDifficulty==2)
			 return(Level+1);
		 else if (gameDifficulty==5)
			 return (int) (max(1,Level-1));
		 else
			 return Level;
	 }
	 
	 
	 //Standard Price Calculations
	 
	 public long StandardPrice(int Good,int Size,int Tech,int Government,int Resources)
	 {
		 int temp=0;
		 long Price;
		 if(((Good==NARCOTICS) && (p[Government].DrugsOk)) || ((Good==FIREARMS) && (!p[Government].FirearmsOk)))
			 	return 0;
			// Determine base price on techlevel of system
		Price = t[Good].PriceLowTech+(Tech*(int)t[Good].PriceInc);
		if(p[Government].Wanted==Good)
			Price=(Price*4)/3;
		// High trader activity decreases prices
		Price=(long) (( Price* (100- ( 2 *(long) p[Government].StrengthTraders )))/100);
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
	 
	 public int getCurrentSystemIndex()
	 {
		 return currentSystem;
	 }
	public int getCurrentShipTechLevel()
	{
		return s[0].MinTexhLevel;
	}
	public int getWarmhole(int Index){
		return (int) Wormhole[Index];// return where warmhole is present
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
		encounterWindow = false;	
	//	 SaveGame("Autosave");
	//	if (arrivedViaWormhole)
		//	[self playSound:eWormholeJump];

	}

	public void DeterminePrices(int currentSystem) {
		// TODO Auto-generated method stub
		
	}

	public void ShuffleStatus() {
		// TODO Auto-generated method stub
		
	}

	public long TotalShieldStrength (SHIP Sh){
		int i;
		long k;
		k=0;
		for(i=0;i<MAXSHIELD;++i)
		{
			if(Sh.Shield[i]<0)
				break;
			k+=Sh.ShieldStrength[i];
		}
		return k;
	}
	public long BASESHIPPRICE(int  a )
	{
		return (((s[a].Price * (100 - TraderSkill(Ship)) / 100))); 
	}
	public void DetermineShipPrices()
	{
		//DETERMINE SHIP PRICES DEPENDING ON TECH LEVEL OF CURRENT SYSTEM
		int i;
		boolean temp=false;
		for(i=0;i<MAXSHIPTYPE;++i)
		{
			if(s[i].MinTexhLevel<=SolarSystem[currentSystem].TechLevel)
			{
				ShipPrice[i]=(BASESHIPPRICE(i)-CurrentShipPrice(temp));
			     if(ShipPrice[i]==0)
			     {
			    	 ShipPrice[i]=1; 
			     }  
			}
			else
				ShipPrice[i]=0;
				
		}
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
    	    addNewsEvent(WILDARRESTED);
    	    wildStatus=0;
    	} 
    	if(Ship.Tribbles>0)
    	{
    		Ship.Tribbles=0;
    	}
    	if(insurance)
           credits+=currentShipPriceWithoutCargo(true);
           
    }
    
    
    public void addNewsEvent(int wILDARRESTED) {
		// TODO Auto-generated method stub
		
	}
    public int FABRICRIPINITIALPROBABILITY =25;
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
    			FrmAlert("ExperimentPerformedAlert");
    			addNewsEvent(EXPERIMENTPERFORMED);			
    		}
    	}
    	else if (experimentStatus == 12 && fabricRipProbability > 0)
    	{
    		fabricRipProbability -= Amount;
    	}
    }


	
 public void FrmAlert(String string) {
		// TODO Auto-generated method stub
		
	}

// Calculate total possible weapon strength
 // Modified to allow an upper and lower limit on which weapons work.
 // Weapons equal to or between minWeapon and maxWeapon (e.g., PULSELASERWEAPON)
 // will do damage. Use -1 to allow damage from any weapon, which is almost
 // always what you want. SjG
 // 
    public long TotalWeapons(SHIP Sh,int minWeapon,int maxWeapon)
    {
    	
    	int i;
    	long j;
    	
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
    
    public void Arrested(){
    	long Fine,Imprisonment;
    	int i;
    	Fine=((1+(((currentWorth() * min(80,-policeRecordScore))/100)/500))*500);
    	if(wildStatus==1)
    	{
    		Fine*=1.05;
    	}
    	Imprisonment=max(30,-policeRecordScore);
    	
    	if(Ship.Cargo[NARCOTICS]>0 || Ship.Cargo[FIREARMS]>0)
    	{
    		Ship.Cargo[NARCOTICS]=0;
    		Ship.Cargo[FIREARMS]=0;
    	}
    	if(insurance)
    	{
    	 insurance=false;
    	 noClaim=0;
    	}
    	if(Ship.Crew[1] >=0 )
    		for(i=1;i<MAXCREW;++i)
    			Ship.Crew[i]=-1;
    	if(japoriDiseaseStatus==1)
    		japoriDiseaseStatus=2;
    	if(jarekStatus==1)
    		jarekStatus=0;
    	if(wildStatus==1)
    	  wildStatus=0;
    	if(reactorStatus >0 &&reactorStatus<21)
    	   reactorStatus=0;
    	
    	Arrival();
    	IncDays((int) Imprisonment);
    	if(credits>=Fine)
    	{
    		credits-=Fine;
    	}
    	else
    	{
    		credits+=CurrentShipPrice(true);
    	  if(credits>=Fine)
    	   credits-=Fine;
    	  else
    		  credits=0;
    	  if(Ship.Tribbles>0)
    	    Ship.Tribbles=0;
    	  
    	  CreateFlea();
    	}
    	policeRecordScore=DUBIOUSSCORE;
         if(debt>0)
         {
        	 if(credits>=debt)
        	 {
        		 credits-=debt;
        	     debt=0;
         }
         else
         {
        	 debt-=credits;
        	 credits=0;
         }
     }  	 
        	for(i=0;i<Imprisonment;i++) 
        	 payInterest();
        	
    }
    CREWMEMBER Mercenary[] = new CREWMEMBER[MAXCREWMEMBER +1];
    public int MAXSKILLTYPE     =4;
    public int SKILLBONUS       =3;
    public int CLOAKBONUS       =2;

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
    
    public boolean HasGadget(SHIP Sh, int TARGETINGSYSTEM) {
		
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
	public int BEGINNER        =0;
	public int EASY            =1;
	public int NORMAL          =2;
	public int HARD            =3;
	public int IMPOSSIBLE      =4;
	public int MANTISTYPE=	MAXSHIPTYPE+2;
	public int SCARABTYPE	=MAXSHIPTYPE+3;
	public int BOTTLETYPE=	MAXSHIPTYPE+4;

 public boolean ExecuteAttack(SHIP Attacker,SHIP Defender ,boolean Flees,boolean CommanderUnderAttack)
    {
    	long Damage, prevDamage;
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
 
 public int EngineerSkill(SHIP Attacker) {
	// TODO Auto-generated method stub
	return 0;
}

public long EnemyShipPrice ( SHIP Sh )
 {
 	int i;
 	long CurPrice;
 	
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
//Calculate Bounty
 
 public long GetBounty(SHIP Sh)
 {
 	long Bounty =  EnemyShipPrice(Sh);
 	
 	Bounty /= 200;
 	Bounty /= 25;	
 	Bounty *= 25;
 	if (Bounty <= 0)
 		Bounty = 25;
 	if (Bounty > 2500)
 		Bounty = 2500;
 	
 	return Bounty;
 }
 public int plunderItem;
 public int plunderCount;

 public void  plunderItems(int index ,int count)
 {
 	plunderItem = index;
 	plunderCount = count;
 }
 

 public void finishPlunder()
 {
 	if (ENCOUNTERPIRATE( encounterType ) && Opponent.Type != MANTISTYPE && policeRecordScore >= DUBIOUSSCORE)
 	{
 	//	String str = String stringWithFormat:@"You earned a bounty of %i cr.", [self GetBounty:&Opponent]];
 	//	[self FrmAlert:str];
 	}
 	else
 	{
 	//	[self FrmAlert:@"OpponentDestroyedAlert"];
 	}
 	
 	bWaitFinishPlunder = false;			
 	 Travel();
 //	[encounterViewControllerInstance showEncounterWindow];			
 	
 	
 }
 public boolean bWaitFinishPlunder = false;

 public int POLICE =0;
 public int POLICEINSPECTION =0; // Police asks to submit for inspection
 public int POLICEIGNORE     =1; // Police just ignores you
 public int POLICEATTACK     =2; // Police attacks you (sometimes on sight)
 public int POLICEFLEE       =3; // Police is fleeing
 public int MAXPOLICE        =9;

 public boolean ENCOUNTERPIRATE(int a) {
	// TODO Auto-generated method stub
	 if(a >= POLICE && a <= MAXPOLICE)
		 return true;
	 
	return false;
}
/*
public void  showPlunderForm(ePlunderMode pickup)//eplunder is enum type yet to be defined
 {
 	// TODO:!!!!!!!!!	
 	if (clicks <= 0)
 		return;
 	bWaitFinishPlunder = true;
 	if (pickup == ePickupCannister) {
 		currentState = ePlunderForm;		
 		plunderCount = 1;
 		String  message;
 		if (/*pickup == ePickupCannistertrue) {
 			plunderItem = GetRandom(MAXTRADEITEM);
 		//	message = [NSString stringWithFormat:@"A cannister from the destroyed ship, labelled %@, drifts within range of your scoops.", [NSString stringWithCString:Tradeitem[plunderItem].Name]];
 		}
 		else {
 			
 		}
 	//	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Scoop Canister" message: message
 	//																	delegate:self cancelButtonTitle:0 otherButtonTitles:@"Let it go", @"Pick it up",0];
 		
 						
 		bLastMessage = false;
 		
 	}
 	else    
 		if (pickup == ePlunderShip) {
 			currentState = ePlunderShipForm;
 			//UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Plunder Ship" message: @"Do you really want to plunder this ship?"
 			//													  delegate:self cancelButtonTitle:0 otherButtonTitles:@"Let it go", @"Plunder it",0];
 			
 							
 			bLastMessage = false;
 			
 		}
 	else 
 	{
 		if ((totalCargoBays - filledCargoBays) >= plunderCount) 
 		{

 			Ship.Cargo[plunderItem] += plunderCount;
 			 finishPlunder();
 		}
 		else {
 			currentState = ePlunderRemoveGoods;
 			UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"No Room To Scoop" message: @"You don't have any room in your cargo holds. Do you wish to jettison goods to make room, or just let it go."
 																			delegate:self cancelButtonTitle:@"Let it go" otherButtonTitles:@"Make Room", 0];
 			
 			[myAlertView show];
 			[myAlertView release];				// free place
 			bLastMessage = false;
 		}
 	}
 }

 public void continuePlunder()
 {
 	bWaitFinishPlunder = false;
 	showPlunderForm (ePickItUp);	
 }


 


 public void Scoop()
 {
 //	 showPlunderForm(ePickupCannister);
 	//int d, ret;
 	
 	// Chance 50% to pick something up on Normal level, 33% on Hard level, 25% on
 	// Impossible level, and 100% on Easy or Beginner
 	//if (gameDifficulty >= NORMAL)
 	//	if (GetRandom( gameDifficulty ) != 1)
 	//		return;
 	
 	// More chance to pick up a cheap good
 	//d = GetRandom( MAXTRADEITEM );
 	//if (d >= 5)
 	//	d = GetRandom( MAXTRADEITEM );
 	
 	//TODO: frm = FrmInitForm( PickCannisterForm );
 	
 	//TODO:[header appendString:@"ship, labeled " );
 	//TODO:StrCat( SBuf, Tradeitem[d].Name );
 	//TODO:StrCat( SBuf, ", drifts" );
 	//TODO:setLabelText( frm, PickCannisterCannisterLabel, SBuf );
 	
 	//TODO:ret = FrmDoDialog( frm );
 	//TODO:FrmDeleteForm( frm ); 
 	
 	//if (ret == /*PickCannisterPickItUpButton1)
 	//{
 	//	if ([self filledCargoBays] >= [self totalCargoBays])
 	//	{
 			//TODO:if (FrmAlert( NoRoomToScoopAlert ) == NoRoomToScoopLetitgo)
 	//		return;
 			
 			//TODO:frm = FrmInitForm( DumpCargoForm );
 			//TODO:FrmSetEventHandler( frm, DiscardCargoFormHandleEvent );
 			//TODO:FrmDoDialog( frm );
 			//TODO:FrmDeleteForm( frm ); 
 	//	}
 		
 	//	if ([self filledCargoBays] < [self totalCargoBays])
 	//		++Ship.Cargo[d];
 	//	else
 			//TODO:FrmAlert( NoDumpNoScoopAlert );
 	//		;
 	//}
 	/*
 }
//A fight round
//Return value indicates whether fight continues into another round
 /*
public boolean ENCOUNTERFAMOUS(int a )
{
	if(a >= FAMOUSCAPTAIN && a <= MAXFAMOUSCAPTAIN)
		return true;
	else
		return false;
	
}
public boolean ENCOUNTERPOLICE(int a )
{
	if(a >= POLICE && a <= MAXPOLICE)
		return true;
	else 
		return	false;
}
//Pirate Actions
public int PIRATE =10;
public int PIRATEATTACK    =10; // Pirate attacks
public int PIRATEFLEE      =11; // Pirate flees
public int PIRATEIGNORE    =12; // Pirate ignores you (because of cloak)
public int PIRATESURRENDER =13; // Pirate surrenders
public int MAXPIRATE       =19;


 public boolean ExecuteAction(boolean CommanderFlees)
 {
 	//FormPtr frmP;
	 Random GetRandom = new Random();
 	boolean CommanderGotHit, OpponentGotHit;
 	long OpponentHull, ShipHull;
 	//int y, i, objindex;
 	int PrevencounterType;
 	//ControlPtr cp;
 	//Random GetRandom = new Random();
 	CommanderGotHit = false;
 	OpponentHull = Opponent.Hull;
 	ShipHull = Ship.Hull;
 	SHIP Defender;
 	// Fire shots
 	/*
 	if (encounterType == PIRATEATTACK || encounterType == POLICEATTACK ||
 		encounterType == TRADERATTACK || encounterType == SPACEMONSTERATTACK ||
 		encounterType == DRAGONFLYATTACK || encounterType == POSTMARIEPOLICEENCOUNTER ||
 		encounterType == SCARABATTACK || encounterType == FAMOUSCAPATTACK)
 	{
 	//	CommanderGotHit =  ExecuteAttack( Opponent, Defender , CommanderFlees, CommanderUnderAttack);
 	}
 	
 	OpponentGotHit = false;
 	
 	if (!CommanderFlees)
 	{
 		if (encounterType == POLICEFLEE || encounterType == TRADERFLEE || encounterType == PIRATEFLEE)	
 		{
 			Flees=true; 
 			CommanderUnderAttack=false;
 		OpponentGotHit =  ExecuteAttack(Ship, Opponent , Flees, CommanderUnderAttack);
 		}
 		else
 		{
 			Flees=false;
 			CommanderUnderAttack=false;
 			OpponentGotHit =  ExecuteAttack(Ship ,Opponent, Flees, CommanderUnderAttack);
 		}
 	}
 	
 	if (CommanderGotHit)
 	{
 		playerShipNeedsUpdate = true;
 	//	[self playSound:eCommanderHit];		
 	}
 	if (OpponentGotHit)
 	{
 		opponentShipNeedsUpdate = true;
 		//[self playSound:eFireOpponent];
 	}
 	
 	// Determine whether someone gets destroyed
 	if (Ship.Hull <= 0 && Opponent.Hull <= 0)
 	{
 		autoAttack = false;
 		autoFlee = false;
 		
 		if (escapePod)
 		{
 			 EscapeWithPod();
 			return( true );
 		}
 		else
 		{
 			// TODO: 
 			//could not understand		[self FrmAlert:@"BothDestroyedAlert"];
 			//could not understand      [self showDestroyedShipWindow];
 			//CurForm = DestroyedForm;
 			//FrmGotoForm( CurForm );
 		}
 		return false;
 	}
 	else if (Opponent.Hull <= 0)
 	{
 		autoAttack = false;
 		autoFlee = false;
 		
 		if (ENCOUNTERPIRATE( encounterType ) && Opponent.Type != MANTISTYPE && policeRecordScore >= DUBIOUSSCORE)
 		{
 			//could not understand	String str = String stringWithFormat:@"You earned a bounty of %i cr.", [self GetBounty:&Opponent]];
 			//could not understand	[self FrmAlert:str];
 		}
 		else
 		{
 			//could not understand[self FrmAlert:@"OpponentDestroyedAlert"];
 		}
 		
 		if (ENCOUNTERFAMOUS( encounterType))
 		{
 			++policeKills;
 			policeRecordScore += KILLPOLICESCORE;
 		}
 		else if (ENCOUNTERPOLICE( encounterType))
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
 			// (replaceNewsEvent(latestNewsEvent) replacementEventFlag(latestNewsEvent()) + 10);
 			
 		}
 		else if (ENCOUNTERPIRATE( encounterType ))
 		{
 			if (Opponent.Type != MANTISTYPE)
 			{
 				//				Credits += s[Opponent.Type].Bounty;
 				//could not understand	credits += GetBounty:&Opponent];
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
 		return false;
 	}
 	else if (Ship.Hull <= 0)
 	{
 		autoAttack = false;
 		autoFlee = false;
 		
 		if (escapePod)
 		{
 			EscapeWithPod();
 			return( true );
 		}
 		else
 		{
 		//	[self FrmAlert:@"ShipDestroyedAlert"];
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
 			
 			//[self FrmAlert: @"YouEscapedAlert"];

 			if (ENCOUNTERMONSTER( encounterType ))
 				monsterHull = (int) Opponent.Hull;
 			
 			return false;
 		}
 		//could not understandelse if ((GetRandom( 7 ) + (PilotSkill: &ship] / 3)) * 2 >= 
 				 GetRandom.nextInt( PilotSkill(Opponent )  * (2 + gameDifficulty));
 		{
 			autoAttack = false;
 			autoFlee = false;
 			if (CommanderGotHit)
 			{
 				//could not understand		[self ShowShip:&ship offset:6 commandersShip:true];
 				// TODO: frmP = FrmGetActiveForm();
 				//for (i=0; i<TRIBBLESONSCREEN; ++i)
 				//{
 				//	objindex = FrmGetObjectIndex( frmP, EncounterTribble0Button + i );
 				//	cp = (ControlPtr)FrmGetObjectPtr( frmP, objindex );
 				//	CtlDrawControl( cp );
 				//}
 			//	[self FrmAlert:@"YouEscapedWithDamageAlert"];

 			}
 			else

 				//[self FrmAlert:@"YouEscapedAlert"];
 			;
 			if (ENCOUNTERMONSTER( encounterType ))
 				monsterHull = (int) Opponent.Hull;
 			
 			return false;
 		}
 	}
 	else if (encounterType == POLICEFLEE || encounterType == TRADERFLEE ||
 			 encounterType == PIRATEFLEE || encounterType == TRADERSURRENDER ||
 			 encounterType == PIRATESURRENDER)	
 	{
 		if (4*GetRandom.nextInt( PilotSkill(Ship) ) <= 
 			GetRandom.nextInt( (07 + ( PilotSkill(Opponent) / 3))) * 2)
 		{
 			autoAttack = false;
 			autoFlee = false;

 			//[self FrmAlert:@"OpponentEscapedAlert"];
 			return false;
 		}
 	}
 	
 	// Determine whether the opponent's actions must be changed
 	PrevencounterType = encounterType;
 	
 	if (Opponent.Hull < OpponentHull)
 	{
 		if (ENCOUNTERPOLICE( encounterType ))
 		{
 			if (Opponent.Hull < OpponentHull >> 1)
 				if (Ship.Hull < ShipHull >> 1)
 				{
 					if (GetRandom.nextInt( 10 ) > 5)
 						encounterType = POLICEFLEE;
 				}	
 				else
 					encounterType = POLICEFLEE;
 		}
 		else if (encounterType == POSTMARIEPOLICEENCOUNTER)
 		{
 			encounterType = POLICEATTACK;
 		}
 		else if (ENCOUNTERPIRATE( encounterType ))
 		{
 			if (Opponent.Hull < (OpponentHull * 2) / 3)
 			{
 				if (Ship.Hull < (ShipHull * 2) / 3)
 				{
 					if (GetRandom.nextInt( 10 ) > 3)
 						encounterType = PIRATEFLEE;
 				}
 				else
 				{
 					
 					encounterType = PIRATEFLEE;
 					if (GetRandom.nextInt( 10 ) > 8 && Opponent.Type < MAXSHIPTYPE)
 						encounterType = PIRATESURRENDER;
 				}
 			}
 		}
 		else if (ENCOUNTERTRADER( encounterType ))
 		{
 			if (Opponent.Hull < (OpponentHull * 2) / 3)
 			{
 				if (GetRandom.nextInt( 10 ) > 3)
 					encounterType = TRADERSURRENDER;
 				else
 					encounterType = TRADERFLEE;
 			}
 			else if (Opponent.Hull < (OpponentHull * 9) / 10)
 			{
 				if (Ship.Hull < (ShipHull * 2) / 3)
 				{
 					// If you get damaged a lot, the trader tends to keep shooting
 					if (GetRandom.nextInt( 10 ) > 7)
 						encounterType = TRADERFLEE;
 				}
 				else if (Ship.Hull < (ShipHull * 9) / 10)
 				{
 					if (GetRandom.nextInt( 10 ) > 3)
 						encounterType = TRADERFLEE;
 				}
 				else
 					encounterType = TRADERFLEE;
 			}
 		}
 	}
 	
 	if (PrevencounterType != encounterType)
 	{
 		if (!(autoAttack &&   (encounterType == TRADERFLEE || encounterType == PIRATEFLEE || encounterType == POLICEFLEE)))
 			autoAttack = false;
 		autoFlee = false;
 	}
 	String str;
 
 	if (ENCOUNTERPOLICE( PrevencounterType ))
 	 	str ="police ship";
 	else if (ENCOUNTERPIRATE( PrevencounterType ))
 	{
 		if (Opponent.Type == MANTISTYPE)
 	 		str ="alien ship";
 		else	
 	 		str ="pirate ship";
 	}
 	else if (ENCOUNTERTRADER( PrevencounterType ))
 	 	str ="trader ship";
 	else if (ENCOUNTERMONSTER( PrevencounterType ))
 	 	str ="monster";
 	else if (ENCOUNTERDRAGONFLY( PrevencounterType ))
 	 	str ="Dragonfly";
 	else if (ENCOUNTERSCARAB( PrevencounterType ))
 	 	str ="Scarab";
 	else if (ENCOUNTERFAMOUS( PrevencounterType))
 	 	str ="Captain";
 	
 	// TODO: y = 75;
 	String  Final, final1, final2;
 	Final ="";
 	final1 ="";
 	final2 ="";	
 	if (CommanderGotHit)
 	{
 		final1 ="The %@ hits you.";
 	} 
 	
 	if (!(PrevencounterType == POLICEFLEE || PrevencounterType == TRADERFLEE ||
 		  PrevencounterType == PIRATEFLEE) && !CommanderGotHit)
 	{
 		final1 = "The %@ missed you.";		
 	}
 	
 	if (OpponentGotHit)
 	{//TODO:
 		final1 = "You hit the %@.";
 		
 	}
 	
 	if (!CommanderFlees && !OpponentGotHit)
 	{
 		final1 ="You missed the %@.";		
 		
 	}
 	
 	if (PrevencounterType == POLICEFLEE || PrevencounterType == TRADERFLEE ||
 		PrevencounterType == PIRATEFLEE)	
 	{
 		final2 = "The %@ didn't get away.";
 		
 	}
 	
 	if (CommanderFlees)
 	{
 		final2 = "The %@ is still following you.";
 		
 	}
 	
 //	Final = "%@\n%@\n%@.", final1, Final, final2];
 	
 	// EncounterDisplayNextAction( false);
 //	encounterViewControllerInstance SetLabelText:final;

 	return true;
 }


//Trader Actions
 public int TRADER          =20;
 public int TRADERIGNORE    =20; // Trader passes
 public int TRADERFLEE      =21; // Trader flees
 public int TRADERATTACK    =22; // Trader is attacking (after being provoked)
 public int TRADERSURRENDER =23; // Trader surrenders 
 public int TRADERSELL	    =24; // Trader will sell products in orbit
 public int TRADERBUY		=25; // Trader will buy products in orbit
 public int TRADERNOTRADE	=26; // Player has declined to transact with Trader
 public int MAXTRADER       =29;

public boolean HasTradeableItems( SHIP sh  ,int theSystem ,int Operation)
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

// Repair Ship for Amount credits
/*
public void  showJettisonForm()
{
	if (jettisonViewControllerInstance == 0) {
		jettisonViewControllerInstance = [[sellCargoViewController alloc] initWithNibName:@"sellCargo" bundle:nil];
		//S1AppDelegate * app = (S1AppDelegate *)[[UIApplication sharedApplication] delegate];
		/*
	//could not understand	[app.window addSubview:[jettisonViewControllerInstance view]];
		
		[jettisonViewControllerInstance setJettisonType];
	} else {
		S1AppDelegate * app = (S1AppDelegate *)[[UIApplication sharedApplication] delegate];
		
		[app.window addSubview:[jettisonViewControllerInstance view]];
		
	}
}
/*
public void showOpponentForm()
{
	if (opponentViewControllerInstance == 0) {
		//opponentViewControllerInstance = [[sellCargoViewController alloc] initWithNibName:@"sellCargo" bundle:nil];
	//	S1AppDelegate * app = (S1AppDelegate *)[[UIApplication sharedApplication] delegate];
		
	//	[app.window addSubview:[opponentViewControllerInstance view]];
		
	//	[opponentViewControllerInstance setOpponentType];
	} else {
	//	S1AppDelegate * app = (S1AppDelegate *)[[UIApplication sharedApplication] delegate];
		
	//	[app.window addSubview:[opponentViewControllerInstance view]];
		
	}
}

/*
public void showEncounteredWindow()
{
	if (bWaitFinishPlunder) 
		return;
	// show encounter window
	if (!encounterWindow) {
		if (encounterViewControllerInstance == 0)
	//		encounterViewControllerInstance = [[encounterViewController alloc] initWithNibName:@"encounter" bundle:nil];
	//	S1AppDelegate * app = (S1AppDelegate *)[[UIApplication sharedApplication] delegate];
	//	[app.window addSubview:[encounterViewControllerInstance view]];
		encounterWindow = true;
	}
}

 /*
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



public String getShipName(int index) {
	return  stringWithCString(s[index].Name);	
}






/*


public int getShipHullStrength(int index) {
	return (int) s[index].HullStrength;	
}








///////////
//Create a new ship.
/*
public void createShip(int Index) 
{
	int i;
	Ship.Type = Index;
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

/*
//Buy a new ship.
public void  buyShip (int Index) 
{
	 createShip(Index);
	credits -= ShipPrice[Index];
	if (scarabStatus == 3)
		scarabStatus = 0;
	//[self playSound:eBuyNewShip];	
}

public String getShipPriceStr(int index){
	if (ShipPrice[index] == 0 )
		return  (String) stringWithCString("not sold") ;
	
	if (index == Ship.Type )
		return  (String) stringWithCString("got one");
	return null
	//return  (ShipPrice[index]);/*[NSString stringWithFormat:@"%i cr.", ShipPrice[index]] 
	/*;//ShipPrice[index];
}
/*
public int getShipPriceInt(int index){
	return (int) ShipPrice[index];
}

public boolean HasWeapon( SHIP Sh,  int Gg,boolean exactCompare)
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

public int getCurrentShipType() {
	return Ship.Type;
}

public boolean canBuyShip(int index) {
	int j = 0;
	for (int i = 0; i < MAXCREW; ++i) 
		if (Ship.Crew[i] >= 0)
			++j;
	if ((jarekStatus == 1) && (s[index].CrewQuarters < 2)) {
		
	//	[self FrmAlert:@"Ambassador Jarek needs Quarters"];
		return false;
	}
	
	if ((wildStatus == 1) && (s[index].CrewQuarters < 2)) {
	//	[self FrmAlert:@"Jonathan Wild needs Quarters"];		
		return false;
	}
	
	if (reactorStatus > 0 && reactorStatus < 21) {
	//	[self FrmAlert:@"Can't sell ship with reactor"];		
		return false;
	}
	
	
	long extra = 0;
	boolean hasLightning = false;
	boolean hasCompactor = false;
	boolean hasMorganLaser = false;
	boolean addLightning = false;
	boolean addCompactor = false;
	boolean addMorganLaser = false;
	
	if ( HasShield(Ship,LIGHTNINGSHIELD))//HasShield:&ship Cg:LIGHTNINGSHIELD]
	{
		
		if (s[index].ShieldSlots == 0)
		{
			//[self FrmAlert:@"Can't transfer the Lighting Shield"];		
		}
		hasLightning = true;
		extra += 30000;
	}
	
	if (HasGadget(Ship,FUELCOMPACTOR))//Gg:FUELCOMPACTOR
	{
		if (s[index].GadgetSlots == 0)
		{
		//	[self FrmAlert:@"Can't transfer the Fuel Compactor"];					
		}
		hasCompactor = true;
		extra += 20000;
	}
	boolean exactCompare=true;
	if (HasWeapon(Ship,MORGANLASERWEAPON, exactCompare))
	{
		if (s[index].WeaponSlots == 0)
		{
		//	[self FrmAlert:@"Can't transfer the Lighting Shield"];		
			//TODO: can't transfer the Laser
			//FrmCustomAlert(CantTransferSlotAlert, s[eventP->data.ctlSelect.controlID - 
			//											   BuyShipBuy0Button].Name, "Morgan's Laser", "Weapon");
		}
		extra += 33333;
		hasMorganLaser = true;
	}
	
	if (ShipPrice[index] + extra >  toSpend())
		// TODO:FrmCustomAlert( CantBuyShipWithEquipmentAlert, SBuf, NULL, NULL );
		;
	
	extra = 0;
	
	if (hasLightning && s[index].ShieldSlots > 0)
	{
		if (ShipPrice[index] + extra <=  toSpend())
		{
			// TODO: d = FrmAlert( TransferLightningShieldAlert );
			int d = 1;
			if (d == 0)
			{
				addLightning = true;
				extra += 30000;
			}
		}
		else
		{
			// TODO: FrmCustomAlert ( CantTransferAlert, "Lightning Shield", NULL, NULL );
		}
	}
	
	if (hasCompactor && s[index].GadgetSlots > 0)
	{
		if (ShipPrice[index] + extra <=  toSpend())
		{
			// TODO: d = FrmAlert( TransferFuelCompactorAlert );
			int d = 1;
			if (d == 0)
			{
				addCompactor = true;
				extra += 20000;
			}
		}
		else
		{
			//TODO: FrmCustomAlert( CantTransferAlert, "Fuel Compactor", NULL, NULL);
		}
	}
	
	if (hasMorganLaser && s[index].WeaponSlots > 0)
	{
		if (ShipPrice[index] + extra <=  toSpend())
		{
			//TODO: d = FrmAlert( TransferMorganLaserAlert );
			int d = 1;
			if (d == 0)
			{
				addMorganLaser = true;
				extra += 33333;
			}
		}
		else
		{
			//TODO: FrmCustomAlert( CantTransferAlert, "Morgan's Laser", NULL, NULL);
		}
	}
	
	
	/*
	 if (ShipPrice[index] + extra > ToSpend())
	 FrmCustomAlert( CantBuyShipWithEquipmentAlert, SBuf, NULL, NULL );
	 
	
	if (j > s[index].CrewQuarters)
	{
		//[self FrmAlert:@"TooManyCrewmembersAlert"];
	}	
	else
	{
		/*
		 frmP = FrmInitForm( TradeInShipForm );
		 [header appendString:@s[Ship.Type].Name );
		 StrCat( SBuf, " for a new " );
		 StrCat( SBuf, s[eventP->data.ctlSelect.controlID - 
		 BuyShipBuy0Button].Name );
		 StrCat( SBuf, "?" );
		 setLabelText( frmP, TradeInShipTradeInShipLabel, SBuf );
		 
		 d = FrmDoDialog( frmP );
		 
		 FrmDeleteForm( frmP );
		
		if (addCompactor || addLightning || addMorganLaser)
		{
			//TODO: StrCopy(SBuf, ", and transfer your unique equipment to the new ship?");
		}
		else
		{
			//TODO: StrCopy(SBuf, "?");
		}
		
		//TODO: d = FrmCustomAlert( TradeShipAlert, s[Ship.Type].Name,
		//		   s[eventP->data.ctlSelect.controlID -  BuyShipBuy0Button].Name,
		//		   SBuf);
		
		/*
		 if (d == TradeShipYes)
		 {
		 BuyShip( index );
		 Credits -= extra;
		 if (addCompactor)
		 Ship.Gadget[0] = FUELCOMPACTOR;
		 if (addLightning)
		 Ship.Shield[0] = LIGHTNINGSHIELD;
		 if (addMorganLaser)
		 Ship.Weapon[0] = MORGANLASERWEAPON;
		 Ship.Tribbles = 0;
		 CurForm = BuyShipForm;
		 FrmGotoForm( CurForm );
		 }
		 
	}
	

	
	
	return true;
}

public boolean HasShield( SHIP Sh ,int Gg) 
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


public boolean isShipCloaked()
{
	
	return Cloaked(Ship ,Opponent);
}

public int getShipOpponentType()
{
	return Opponent.Type;
}


//Determine if ship is cloaked
public boolean  Cloaked(SHIP Sh,  SHIP Opp )
{
	return (HasGadget(Sh ,CLOAKINGDEVICE)  && ( EngineerSkill(Sh) > EngineerSkill( Opp)));
}


public boolean attack()
{
	
	int minWeapon=-1;
	int maxWeapon=-1;
	Random GetRandom = new Random();
	if (TotalWeapons(Ship, minWeapon, maxWeapon) <= 0)
	{
		//[self FrmAlert: @"NoWeaponsAlert"];
		return true;
	}
	
	if (encounterType == POLICEINSPECTION && Ship.Cargo[FIREARMS] <= 0 &&
		Ship.Cargo[NARCOTICS] <= 0)
	{
		//TODO:!!!!!!!!!!!!
		//if (FrmAlert( SureToFleeOrBribeAlert ) == SureToFleeOrBribeOKIwont)
		//	return true;
	}
	
	if (ENCOUNTERPOLICE( encounterType ) || encounterType == POSTMARIEPOLICEENCOUNTER)
	{
		// TODO:!!!!!!
		if (policeRecordScore > CRIMINALSCORE)// &&
		//	[self FrmAlert:@"AttackByAccidentAlert"];// == AttackByAccidentNo)
		return true;
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
	else if (ENCOUNTERTRADER(encounterType ))
	{
		if (encounterType == TRADERIGNORE || encounterType == TRADERBUY ||
			encounterType == TRADERSELL)
		{
			if (policeRecordScore >= CLEANSCORE)
			{
				//if (FrmAlert( AttackTraderAlert ) == AttackTraderNo)
				//	return true;
				policeRecordScore = DUBIOUSSCORE;
			}
			else
				policeRecordScore += ATTACKTRADERSCORE;
		}
		if (encounterType != TRADERFLEE)
		{
			minWeapon=-1; maxWeapon=-1;
			if (TotalWeapons(Opponent ,minWeapon, maxWeapon) <= 0)
				encounterType = TRADERFLEE;
			else if (GetRandom.nextInt( ELITESCORE ) <= (reputationScore * 10) / (1 + Opponent.Type))
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
		//	FrmAlert( SureToAttackFamousAlert ) == SureToAttackFamousOKIWont)
		//	return true;
		if (policeRecordScore > VILLAINSCORE)
			policeRecordScore = VILLAINSCORE;
		policeRecordScore += ATTACKTRADERSCORE;
		if (encounterType == CAPTAINHUIEENCOUNTER)
			// addNewsEvent(CAPTAINHUIEATTACKED);
			
		 if (encounterType == CAPTAINAHABENCOUNTER)
			//[self addNewsEvent:CAPTAINAHABATTACKED];
			
		 if (encounterType == CAPTAINCONRADENCOUNTER)
		//	[self addNewsEvent:CAPTAINCONRADATTACKED];
		
		encounterType = FAMOUSCAPATTACK;
		
	}
	if (continuous)
		autoAttack = true;
	if ( ExecuteAction(false))
		return true;
	if (Ship.Hull <= 0)
		return true;
	 Travel();
	
	return false;
}


//Scarab Actions
public int  SCARABATTACK    =60;
public int  SCARABIGNORE    =61;
public int  MAXSCARAB       =69;

public boolean ENCOUNTERSCARAB(int a )
{
	if(a >= SCARABATTACK && a <= MAXSCARAB)
		return true;
	else return false;
	
}


//Space Monster Actions
public int  SPACEMONSTERATTACK =30;
public int  SPACEMONSTERIGNORE =31;
public int  MAXSPACEMONSTER    =39;
//Dragonfly Actions
public int  DRAGONFLYATTACK    =40;
public int  DRAGONFLYIGNORE    =41;
public int  MAXDRAGONFLY       =49;


public boolean ENCOUNTERDRAGONFLY( int a )
{
	if(a >= DRAGONFLYATTACK && a <= MAXDRAGONFLY)
		return true;
	else
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

public boolean ENCOUNTERTRADER(int a )
{
	if(a >= TRADER && a <= MAXTRADER)
		return true;
	else
		return false;
}


public int MAXPOLICERECORD    = 10;
public int ATTACKPOLICESCORE   =-3;
public int KILLPOLICESCORE     =-6;
public int ATTACKTRADERSCORE   =-2;
public int PLUNDERTRADERSCORE  =-2;
public int KILLTRADERSCORE     =-4;
public int ATTACKPIRATESCORE   = 0;
public int KILLPIRATESCORE     = 1;
public int PLUNDERPIRATESCORE  =-1;
public int TRAFFICKING         =-1;
public int FLEEFROMINSPECTION  =-2;
public int TAKEMARIENARCOTICS	=-4;


public boolean flee()
{
	autoAttack = false;
	autoFlee = false;
	
	if (encounterType == POLICEINSPECTION && Ship.Cargo[FIREARMS] <= 0 &&
		Ship.Cargo[NARCOTICS] <= 0 && wildStatus != 1 && (reactorStatus == 0 || reactorStatus == 21))
	{
		// TODO:!!!
		//if (FrmAlert( SureToFleeOrBribeAlert ) == SureToFleeOrBribeOKIwont)
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
		//if (FrmAlert( SureToFleePostMarieAlert ) != SureToFleePostMarieOKIwont)
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
	boolean temp=true;
	if (ExecuteAction( temp))
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
	//[encounterViewControllerInstance showEncounterWindow];
	
	return false;
}

public int STRENGTHPOLICE(int  a )
{
	if(policeRecordScore < PSYCHOPATHSCORE )
		return 3 * p[SolarSystem[a].Politics].StrengthPolice;
	else if(policeRecordScore < VILLAINSCORE)
	return	2 * p[SolarSystem[a].Politics].StrengthPolice;
	else return p[SolarSystem[a].Politics].StrengthPolice;	
			
//	else return false;
}
public void Travel() 
{
	int EncounterTest, StartClicks, i, j, Repairs, FirstEmptySlot, rareEncounter;
	boolean Pirate, Trader, Police, Mantis, TryAutoRepair, FoodOnBoard, EasterEgg;
	boolean HaveMilitaryLaser, HaveReflectiveShield;
	long previousTribbles;
	Random GetRandom = new Random();
	if (bWaitFinishPlunder)
		return;
	
	if (clicks < 0)
		return;
	//bLastMessage = true;
	Pirate = false;
	Trader = false;
	Police = false;
	Mantis = false;
//	exactCompare=true;
//	HaveMilitaryLaser =  HasWeapon(Ship ,MILITARYLASERWEAPON, exactCompare);
	HaveReflectiveShield =  HasShield(Ship,REFLECTIVESHIELD);
	
	// if timespace is ripped, we may switch the warp system here.
	if (possibleToGoThroughRip &&
	    experimentStatus == 12 && fabricRipProbability > 0 && (GetRandom.nextInt(100) < fabricRipProbability || fabricRipProbability == 25))
	{
		//[self FrmAlert:@"FlyInFabricRipAlert"];
		warpSystem = GetRandom.nextInt(MAXSOLARSYSTEM);
	}
	
	possibleToGoThroughRip=false;
	
	StartClicks = clicks;
	--clicks;
	firstEncounter = true;
	
	
	while (clicks > 0)
	{
		// Engineer may do some repairs
		Repairs = GetRandom.nextInt( EngineerSkill(Ship) ) >> 1;
		Ship.Hull += Repairs;
		if (Ship.Hull >  GetHullStrength())
		{
			Repairs = (int) (Ship.Hull -  GetHullStrength());
			Ship.Hull =  GetHullStrength();
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
				Repairs = (int) (Ship.ShieldStrength[i] - Shieldtype[Ship.Shield[i]].Power);
				Ship.ShieldStrength[i] = Shieldtype[Ship.Shield[i]].Power;
			}
			else
				Repairs = 0;
		}
		
		// Encounter with space monster
		if ((clicks == 1) && (warpSystem == ACAMARSYSTEM) && (monsterStatus == 1))
		{
			//MemMove( &Opponent, &SpaceMonster, sizeof( Opponent ) );
		//	memcpy(Opponent, SpaceMonster, sizeof(SHIP));
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
			
			//[self showEncounteredWindow];
			return;
		}
		
		// Encounter with the stolen Scarab
		if (clicks == 20 && SolarSystem[warpSystem].Special == SCARABDESTROYED &&
			scarabStatus == 1 && arrivedViaWormhole)
 		{
			//MemMove( &Opponent, &Scarab, sizeof( Opponent ) );
		//	memcpy(Opponent, Scarab, sizeof( Opponent ) );
			Mercenary[Opponent.Crew[0]].Pilot = 5 + gameDifficulty;
			Mercenary[Opponent.Crew[0]].Fighter = 6 + gameDifficulty;
			Mercenary[Opponent.Crew[0]].Trader = 1;
			Mercenary[Opponent.Crew[0]].Engineer = 6 + gameDifficulty;
			if ( Cloaked(Ship ,Opponent))
				encounterType = SCARABIGNORE;
			else
				encounterType = SCARABATTACK;

			return;
		} 
		// Encounter with stolen Dragonfly
		if ((clicks == 1) && (warpSystem == ZALKONSYSTEM) && (dragonflyStatus == 4))
		{
			//MemMove( &Opponent, &Dragonfly, sizeof( Opponent ) );
			//memcpy( Opponent, Dragonfly, sizeof( Opponent ) );
			
			Mercenary[Opponent.Crew[0]].Pilot = 4 + gameDifficulty;
			Mercenary[Opponent.Crew[0]].Fighter = 6 + gameDifficulty;
			Mercenary[Opponent.Crew[0]].Trader = 1;
			Mercenary[Opponent.Crew[0]].Engineer = 6 + gameDifficulty;
			if ( Cloaked(Ship ,Opponent))
				encounterType = DRAGONFLYIGNORE;
			else
				encounterType = DRAGONFLYATTACK;
			//[self showEncounteredWindow];
			return;
		}
		
		if (warpSystem == GEMULONSYSTEM && invasionStatus > 7)
		{
			if (GetRandom.nextInt( 10 ) > 4)
				Mantis = true;
		}
		else
		{
			// Check if it is time for an encounter
			EncounterTest = GetRandom.nextInt( 44 - (2 * gameDifficulty) );
			
			// encounters are half as likely if you're in a flea.
			if (Ship.Type == 0)
				EncounterTest *= 2;
			
			if (EncounterTest < p[SolarSystem[warpSystem].Politics].StrengthPirates &&
				!raided) // When you are already raided, other pirates have little to gain
				Pirate = true;
			else if (EncounterTest <  p[SolarSystem[warpSystem].Politics].StrengthPirates +
					 STRENGTHPOLICE( warpSystem ))
				// StrengthPolice adapts itself to your criminal record: you'll
				// encounter more police if you are a hardened criminal.
				Police = true;
			else if (EncounterTest < 
					 p[SolarSystem[warpSystem].Politics].StrengthPirates +
					 STRENGTHPOLICE( warpSystem ) +
					 p[SolarSystem[warpSystem].Politics].StrengthTraders)
				Trader = true;
			else if (wildStatus == 1 && warpSystem == KRAVATSYSTEM)
			{
				// if you're coming in to Kravat & you have Wild onboard, there'll be swarms o' cops.
				rareEncounter = GetRandom.nextInt(100);
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
				if (artifactOnBoard && GetRandom.nextInt( 20 ) <= 3)
					Mantis = true;
		}
		
		// Encounter with police
		if (Police)
		{
			if (firstEncounter) {
				//[self playSound:ePoliceEncounter];
				firstEncounter = false;
			}

//			 GenerateOpponent( POLICE );
			encounterType = POLICEIGNORE;
			// If you are cloaked, they don't see you
			if (Cloaked(Ship ,Opponent))
				encounterType = POLICEIGNORE;
			else if (policeRecordScore < DUBIOUSSCORE)
			{
				// If you're a criminal, the police will tend to attack
				int minWeapon=-1 ;
				int maxWeapon=-1;
				if ( TotalWeapons(Opponent, minWeapon, maxWeapon) <= 0)
				{
					if ( Cloaked(Opponent ,Ship))
						encounterType = POLICEIGNORE;
					else
						encounterType = POLICEFLEE;
				}
				if (reputationScore < AVERAGESCORE)
					encounterType = POLICEATTACK;
				else if (GetRandom.nextInt( ELITESCORE ) > (reputationScore / (1 + Opponent.Type)))
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
				if (GetRandom.nextInt( 12 - gameDifficulty ) < 1 && !inspected)
				{
					encounterType = POLICEINSPECTION;
					inspected = true;
				}
			}
			else
			{
				// If your record indicates you are a lawful trader, the chance on inspection drops to 2.5%
				if (GetRandom.nextInt( 40 ) == 1 && !inspected)
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
			if (encounterType == POLICEIGNORE && Cloaked(Opponent ,Ship))
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
			
		//	[self showEncounteredWindow];
			return;
		}
		// Encounter with pirate
		else if (Pirate || Mantis)
		{
			if (Mantis)
			{
			//	[self GenerateOpponent:MANTIS];
			}
			else
			//	[self GenerateOpponent:PIRATE];
			
			// If you have a cloak, they don't see you
			if (Cloaked(Ship ,Opponent))
				encounterType = PIRATEIGNORE;
			
			// Pirates will mostly attack, but they are cowardly: if your rep is too high, they tend to flee
			else if (Opponent.Type >= 7 ||
					 GetRandom.nextInt( ELITESCORE ) > (reputationScore * 4) / (1 + Opponent.Type))
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
			if ((encounterType == PIRATEIGNORE || encounterType == PIRATEFLEE) && Cloaked(Opponent ,Ship))
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
			// showEncounteredWindow();
			return;
		}
		// Encounter with trader
		else if (Trader)
		{	
		//	 GenerateOpponent( TRADER);
			encounterType = TRADERIGNORE;
			// If you are cloaked, they don't see you
			if ( Cloaked(Ship ,Opponent))
				encounterType = TRADERIGNORE;
			// If you're a criminal, traders tend to flee if you've got at least some reputation
			else if (policeRecordScore <= CRIMINALSCORE)
			{
				if (GetRandom.nextInt( ELITESCORE ) <= (reputationScore * 10) / (1 + Opponent.Type))
				{
					if ( Cloaked(Opponent ,Ship))
						encounterType = TRADERIGNORE;
					else
						encounterType = TRADERFLEE;
				}
			}
			
			// Will there be trade in orbit?
			if (encounterType == TRADERIGNORE && (GetRandom.nextInt(1000) < ChanceOfTradeInOrbit))
			{
				if ( filledCargoBays() < totalCargoBays() &&  HasTradeableItems(Opponent ,warpSystem ,TRADERSELL))
					encounterType = TRADERSELL;
				
				// we fudge on whether the trader has capacity to carry the stuff he's buying.
				if ( HasTradeableItems(Opponent ,warpSystem ,TRADERBUY) && encounterType != TRADERSELL)
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
			if (alwaysIgnoreTraders && (encounterType == TRADERIGNORE ||
										encounterType == TRADERFLEE))
			{
				--clicks;
				continue;
			}
			// pay attention to user's prefs with regard to ignoring trade in orbit
			if (alwaysIgnoreTradeInOrbit && (encounterType == TRADERBUY ||
											 encounterType == TRADERSELL))
			{
				--clicks;
				continue;
			}
			
			//[self showEncounteredWindow];
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
		else if ((days > 10) && (GetRandom.nextInt(1000) < chanceOfVeryRareEncounter ))
		{
			rareEncounter = GetRandom.nextInt(MAXVERYRAREENCOUNTER);
			/*
			switch (rareEncounter)
			{
				case MARIECELESTE:
					if ((!veryRareEncounter) &&(! ALREADYMARIE))
					{
						veryRareEncounter += ALREADYMARIE;
						encounterType = MARIECELESTEENCOUNTER;
				//		 GenerateOpponent(TRADER);
						for (i=0;i<MAXTRADEITEM;i++)
						{
							Opponent.Cargo[i]=0;
						}
						Opponent.Cargo[NARCOTICS] = (int) min(s[Opponent.Type].CargoBays,5);
					//	[self showEncounteredWindow];
						return;
					}
					break;
					
				case CAPTAINAHAB:
					if (HaveReflectiveShield && pilotSkill < 10 &&
					    policeRecordScore > CRIMINALSCORE &&
					    !(veryRareEncounter & (Byte)ALREADYAHAB))
					{
						veryRareEncounter += ALREADYAHAB;
						encounterType = CAPTAINAHABENCOUNTER;
					 GenerateOpponent(FAMOUSCAPTAIN);
						//[self showEncounteredWindow];
						return;
					}
					break;
					
				case CAPTAINCONRAD:
					if (HaveMilitaryLaser && engineerSkill < 10 &&
						policeRecordScore > CRIMINALSCORE &&
					    !(veryRareEncounter & (Byte)ALREADYCONRAD))
					{
						veryRareEncounter += ALREADYCONRAD;
						encounterType = CAPTAINCONRADENCOUNTER;
						 GenerateOpponent(FAMOUSCAPTAIN);
						//[self showEncounteredWindow];
						return;
					}
					break;
					
				case CAPTAINHUIE:
					if (HaveMilitaryLaser && traderSkill < 10 &&
						policeRecordScore > CRIMINALSCORE &&
					    !(veryRareEncounter & (Byte)ALREADYHUIE))
					{
						veryRareEncounter = veryRareEncounter | ALREADYHUIE;
						encounterType = CAPTAINHUIEENCOUNTER;
						 GenerateOpponent(FAMOUSCAPTAIN);
			//			[self showEncounteredWindow];
						return;
					}
					break;
				case BOTTLEOLD:
					if  (!(veryRareEncounter & (Byte)ALREADYBOTTLEOLD))
					{
						veryRareEncounter = veryRareEncounter | ALREADYBOTTLEOLD;
						encounterType = BOTTLEOLDENCOUNTER;
						 GenerateOpponent(TRADER);
						Opponent.Type = BOTTLETYPE;
						Opponent.Hull = 10;
						//[self showEncounteredWindow];
						return;
					}
					break;
				case BOTTLEGOOD:
					if  (!(veryRareEncounter & (Byte)ALREADYBOTTLEGOOD))
					{
						veryRareEncounter = veryRareEncounter | ALREADYBOTTLEGOOD;
						encounterType = BOTTLEGOODENCOUNTER;
						 GenerateOpponent(TRADER);
						Opponent.Type = BOTTLETYPE;
						Opponent.Hull = 10;
						//[self showEncounteredWindow];
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
		// GenerateOpponent(POLICE);
		encounterType = POSTMARIEPOLICEENCOUNTER;
		justLootedMarie = false;
		clicks++;
		//[self showEncounteredWindow];
		return;
	}
	
	//if(bLastMessage)
	//	[self FrmAlert: (StartClicks > 20) ? @"UneventfulTripAlert" : @"ArrivalAlert"];
	
	if (debt >= 75000 ) //[self FrmAlert:@"DebtWarningAlert"];
	
	// Debt Reminder
	if (debt > 0 && remindLoans && days % 5 == 0)
	{
		//StrIToA(SBuf2, Debt);
		//TODO:FrmCustomAlert( LoanAmountAlert, SBuf2, " ", " ");
	}
	
	 Arrival();
	
	// Reactor warnings:	
	// now they know the quest has a time constraint!
	if (reactorStatus == 2)// [self FrmAlert:@"ReactorConsumeAlert"];
	{
	// better deliver it soon!
	}
	else if (reactorStatus == 16) //[self FrmAlert:@"ReactorNoiseAlert"];
	{
	// last warning!
	}
	else if (reactorStatus == 18)// [self FrmAlert:@"ReactorSmokeAlert"];
	
	if (reactorStatus == 20)
	{
		//[self FrmAlert:@"ReactorMeltdownAlert"];
		reactorStatus = 0;
		if (escapePod)
		{
			 EscapeWithPod();
			return;
		}
		else
		{
		//	[self FrmAlert:@"ShipDestroyedAlert"];
	//		[self showDestroyedShipWindow];

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
		//	[self FrmAlert:@"TribblesAllIrradiatedAlert"];
		}
		else
		{
		//	[self FrmAlert:@"TribblesIrradiatedAlert"];
		}
	}
	else if (Ship.Tribbles > 0 && Ship.Cargo[NARCOTICS] > 0)
	{
		Ship.Tribbles = 1 + GetRandom( 3 );
		j = 1 + GetRandom( 3 );
		i = (int) min( j, Ship.Cargo[NARCOTICS] );
		BuyingPrice[NARCOTICS] = (BuyingPrice[NARCOTICS] * 
								  (Ship.Cargo[NARCOTICS] - i)) / Ship.Cargo[NARCOTICS];
		Ship.Cargo[NARCOTICS] -= i;
		Ship.Cargo[FURS] += i;
//		[self FrmAlert:@"TribblesAteNarcoticsAlert"];
	}
	else if (Ship.Tribbles > 0 && Ship.Cargo[FOOD] > 0)
	{
		Ship.Tribbles += 100 + GetRandom( Ship.Cargo[FOOD] * 100 );
		i = GetRandom( Ship.Cargo[FOOD] );
		BuyingPrice[FOOD] = (BuyingPrice[FOOD] * i) / Ship.Cargo[FOOD];
		Ship.Cargo[FOOD] = i; 
	//	[self FrmAlert:@"TribblesAteFoodAlert"];
		FoodOnBoard = true;
	}
	
	if (Ship.Tribbles > 0 && Ship.Tribbles < MAXTRIBBLES)
		Ship.Tribbles += 1 + GetRandom.nextInt( (int) max( 1, (Ship.Tribbles >> (FoodOnBoard ? 0 : 1)) ) );
	
	if (Ship.Tribbles > MAXTRIBBLES)
		Ship.Tribbles = MAXTRIBBLES;
	
	if ((previousTribbles < 100 && Ship.Tribbles >= 100) ||
		(previousTribbles < 1000 && Ship.Tribbles >= 1000) ||
		(previousTribbles < 10000 && Ship.Tribbles >= 10000) ||
		(previousTribbles < 50000 && Ship.Tribbles >= 50000))
	{
		//[self playSound:eTribble];
		//TODO:if (Ship.Tribbles >= MAXTRIBBLES)
		//TODO:	[header appendString:@"a dangerous number of" );
		//TODO:else
		//TODO:	StrPrintF(SBuf, "%ld", Ship.Tribbles);
		//TODO:FrmCustomAlert( TribblesOnBoardAlert, SBuf, NULL, NULL);
	}
	
	tribbleMessage = false;
	
	Ship.Hull += GetRandom( EngineerSkill(Ship) );
	if (Ship.Hull >  GetHullStrength())
		Ship.Hull =  GetHullStrength();
	
	TryAutoRepair = true;
	if (autoFuel)
	{
		 BuyFuel(999);
		if ( getFuel() <  GetFuelTanks())
		{
			if (autoRepair && Ship.Hull <  GetHullStrength())
			{
				//[self FrmAlert:@"NoFullTanksOrRepairsAlert"];
				TryAutoRepair = false;
			}
			else
			//	[self FrmAlert:@"NoFullTanksAlert"];
			;
		}
	}
	
	if (autoRepair && TryAutoRepair)
	{	
		 buyRepairs(9999);
		if (Ship.Hull <   GetHullStrength())
		{
			//[self FrmAlert:@"NoFullRepairsAlert"];
		}
	}
	
    /* This Easter Egg gives the commander a Lighting Shield 
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
 		  //  [self FrmAlert:@"EggAlert"];
			
		    FirstEmptySlot = GetFirstEmptySlot( s[Ship.Type].ShieldSlots,Ship.Shield);
			
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
	}
	
	// It seems a glitch may cause cargo bays to become negative - no idea how...
	//for (i=0; i<MAXTRADEITEM; ++i)
	//	if (Ship.Cargo[i] < 0)
	//		Ship.Cargo[i] = 0;
	
	//	if (clicks > 0) {
	/*
	S1AppDelegate * app = (S1AppDelegate *)[[UIApplication sharedApplication] delegate];
	UIViewController * targetViewController = [[SystemInfoViewController alloc] initWithNibName:@"systemInfo" bundle:nil];
	[[app navigationController] popViewControllerAnimated:NO];
	encounterWindow = false;	
	//[encounterViewControllerInstance release];
	[[app navigationController] pushViewController:targetViewController animated:NO];	
	
	[self SaveGame:@"Autosave"];
	
	
	//	}
}

// 
//Travelling to the target system


//*************************************************************************
//Returns the index of a trade good that is on a given ship that can be
//sold in a given system.
//*************************************************************************
public int GetRandomTradeableItem( SHIP sh ,int Operation)
{
	boolean looping = true;
	int i=0, j = 0;
	Random r = new Random();
	while (looping && i < 10) 
	{
		j = r.nextInt(MAXTRADEITEM);
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

//*************************************************************************
//Increase one of the skills of the commander
//*************************************************************************
public void IncreaseRandomSkill()
{
	boolean Redo;
	int d=0, oldtraderskill;
	
	if (pilotSkill >= MAXSKILL && traderSkill >= MAXSKILL && fighterSkill >= MAXSKILL && engineerSkill >= MAXSKILL)
		return;
	
	oldtraderskill = TraderSkill(Ship);
	
	Redo = true;
	while (Redo)
	{
		d = (GetRandom( MAXSKILLTYPE ));
		if ((d == 0 && pilotSkill < MAXSKILL) ||
			(d == 1 && fighterSkill < MAXSKILL) ||
			(d == 2 && traderSkill < MAXSKILL) ||
			(d == 3 && engineerSkill < MAXSKILL))
			Redo = false;
	}
	if (d == 0)
		pilotSkill += 1;
	else if (d == 1)
		fighterSkill += 1;
	else if (d == 2)
	{
		traderSkill += 1;
		if (oldtraderskill !=  TraderSkill(Ship))
		 RecalculateBuyPrices(currentSystem);
	}
	else 
		engineerSkill += 1;
	//[self updateMercenary0Data];
}

public int GetRandom(int mAXSKILLTYPE2) {
	// TODO Auto-generated method stub
	return 0;
}
//*************************************************************************
//Decrease one of the skills of the commander
//*************************************************************************

//Extra Crewmembers who won't be found randomly
public int  MAXSKILL       =10;
public int  NAMELEN        =20;

public void DecreaseRandomSkill(int amount) 
{
	boolean Redo;
	int d = 0, oldtraderskill;
	Random GetRandom = new Random();
	if (pilotSkill >= MAXSKILL && traderSkill >= MAXSKILL && fighterSkill >= MAXSKILL && engineerSkill >= MAXSKILL)
		return;
	
	oldtraderskill =  TraderSkill(Ship);
	
	Redo = true;
	while (Redo)
	{
		d = GetRandom.nextInt( MAXSKILLTYPE );
		if ((d == 0 && pilotSkill > amount) ||(d == 1 && fighterSkill > amount) ||(d == 2 && traderSkill > amount) ||(d == 3 && engineerSkill > amount))
			Redo = false;
	}
	if (d == 0)
		pilotSkill -= amount;
	else if (d == 1)
		fighterSkill -= amount;
	else if (d == 2)
	{
		traderSkill -= amount;
		if (oldtraderskill !=  TraderSkill(Ship))
			 RecalculateBuyPrices(currentSystem);
	}
	else 
		engineerSkill -= amount;
	updateMercenary0Data();
}
public void updateMercenary0Data()
{
	
	Mercenary[0].Trader = traderSkill;
	Mercenary[0].Engineer = engineerSkill;
	Mercenary[0].Fighter = fighterSkill;
	Mercenary[0].Pilot = pilotSkill;
	

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



//*************************************************************************
//Randomly tweak one of the skills of the commander
//*************************************************************************
public void TonicTweakRandomSkill()
{
	int oldPilot, oldFighter, oldTrader, oldEngineer;
	oldPilot = pilotSkill;
	oldFighter = fighterSkill;
	oldTrader = traderSkill;
	oldEngineer = engineerSkill;
	
	if (gameDifficulty < HARD)
	{
		// add one to a random skill, subtract one from a random skill
		while (	oldPilot == pilotSkill &&
			   oldFighter == fighterSkill &&
			   oldTrader == traderSkill &&
			   oldEngineer == engineerSkill)
		{
			 IncreaseRandomSkill();
		     DecreaseRandomSkill(1);
		}
	}
	else
	{
		// add one to two random skills, subtract three from one random skill
		 IncreaseRandomSkill();
		 IncreaseRandomSkill();
		 DecreaseRandomSkill(3);
	}
	 updateMercenaryData();
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
		
		//[self FrmAlert:@"YieldNarcoticsAlert"];
	}
	
           Travel();
	//[encounterViewControllerInstance showEncounterWindow];
	
	return false;
}


public void sellCheapestGood()
{
	int lowestPrice = 10000000;
	int index = 0;
	for (int i = 0; i < MAXTRADEITEM; ++i )
	{
		if (Ship.Cargo[i] > 0 && SellPrice[i] < lowestPrice) {
			lowestPrice = (int) SellPrice[i];
			index = i;
		}
	}
	
	Ship.Cargo[index] -=1 ;
	// showPlunderForm(ePickItUp);
}
/*
- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex  // after animation
{
	bLastMessage = true;
	int button = buttonIndex;
	
	if (currentState == eTradeInOrbit) {
		
		//		S1AppDelegate * app = (S1AppDelegate *)[[UIApplication sharedApplication] delegate];	
		int j = 0;
		if (button == 1) {
			// Ok.
			
			NSString * value = [[(AlertModalWindow*)alertView myTextField] text];
			unsigned int val = value.intValue;
			j = max(0, min(Ship.Cargo[activeTradeItem], val));
		} else if (button == 2) {
			
			j = Ship.Cargo[activeTradeItem];
		}
		
		j = min( j, s[Opponent.Type].CargoBays );
		if (j > 0)
		{
			BuyingPrice[activeTradeItem] = BuyingPrice[activeTradeItem]*(Ship.Cargo[activeTradeItem]-j)/Ship.Cargo[activeTradeItem];
			Ship.Cargo[activeTradeItem] -= j;
			Opponent.Cargo[activeTradeItem] = j;
			credits += j * SellPrice[activeTradeItem];
			//FrmCustomAlert(OrbitTradeCompletedAlert,"Thanks for selling us the", Tradeitem[i].Name, " ");
			[self FrmAlertWithTitle:[NSString stringWithFormat:@"Thanks for selling us the %@.", Tradeitem[activeTradeItem].Name ] Title:@"Trade Completed"];
			
		}
		[self Travel];
		[encounterViewControllerInstance showEncounterWindow];
		
	} else
		
		if (currentState == eSellInOrbit) {
			
			int i = activeTradeItem;
			int j = 0;
			if (button == 1) {
				// Ok
				
				NSString * value = [[(AlertModalWindow*)alertView myTextField] text];
				unsigned int val = value.intValue;
				j = max(0, min(Opponent.Cargo[i], val));;
			} else if (button == 2) {
				
				j = min(Opponent.Cargo[i], ([self totalCargoBays]-[self filledCargoBays]));
			}
			
			j = min ( j, (credits / BuyPrice[i]));
			if (j > 0)
			{
				Ship.Cargo[i] += j;
				Opponent.Cargo[i] -= j;
				BuyingPrice[i] += (j * BuyPrice[i]);
				credits -= (j * BuyPrice[i]);
				[self FrmAlertWithTitle:[NSString stringWithFormat:@"Thanks for buying the %@.", Tradeitem[activeTradeItem].Name ] Title:@"Trade Completed"];
			}
			
			[self Travel];
			[encounterViewControllerInstance showEncounterWindow];
		} else
			
			
			if (currentState == eYieldChoice) {
				
				if (button == 1) {
					[self yieldContinue];
				}
			}
	
	if (currentState == eSurrender) {
		
		if (button == 0) {
			[self Arrested];
		//	[self Travel];
		//	[encounterViewControllerInstance showEncounterWindow];			
		}
		
	}
	
	if (currentState == eSurrenderArtifact) {
		if (button == 1) {
			artifactOnBoard = 0;
			[self playSound:eAlienReturnArtifact];
		}
	
		[self Travel];
		[encounterViewControllerInstance showEncounterWindow];
	}
	
	if (currentState == eBottleGood){
		
		if (button == 1)
		{
			// two points if you're on beginner-normal, one otherwise
			[self IncreaseRandomSkill];
			if (gameDifficulty < HARD)
				[self IncreaseRandomSkill];
			[self FrmAlert:@"GoodDrinkAlert"];

		}
		[self Travel];
		[encounterViewControllerInstance showEncounterWindow];		
	}
	
	if (currentState == eBottleStrange){
		
		currentState = eBottleStrange;		
		if (button == 1)
		{
			// two points if you're on beginner-normal, one otherwise
			[self TonicTweakRandomSkill];
			[self FrmAlert:@"StrangeDrinkAlert"];
			
		}
		[self Travel];
		[encounterViewControllerInstance showEncounterWindow];		
	}
	
	if (currentState == eBoard) {
		if (button == 1) {
			//currentState = ePlunderForm;
			[self showPlunderForm:ePlunderShip];
		}
		/*
		 if (FrmAlert( EngageMarieAlert ) == EngageMarieYesTakeCargo)
		 {
		 CurForm = PlunderForm;
		 FrmGotoForm( CurForm );
		 return true;
		 }
		 
	}
	
	if (currentState == ePlunderForm) {
		//[self showJettisonForm];
		if (button == 0) {
			bWaitFinishPlunder = false;
			[self Travel];
			[encounterViewControllerInstance showEncounterWindow];
		} else 
			[self showPlunderForm:ePickItUp];
		
	}
	else
		if (currentState == ePlunderShipForm) {
			//[self showJettisonForm];
			if (button == 0) {
				bWaitFinishPlunder = false;
				[self Travel];
				[encounterViewControllerInstance showEncounterWindow];
			} else {
				bWaitFinishPlunder = true;
				[self showOpponentForm];
				//[self showPlunderForm:ePickFromShip];
			}
				//
			
		}
		else		
	if (currentState == ePlunderRemoveGoods) {
		
		if (button == 1) {
			bWaitFinishPlunder = true;
			[self showJettisonForm];
		}
		else //	[self sellCheapestGood]; 
		{
			bWaitFinishPlunder = false;
			[self Travel];
			[encounterViewControllerInstance showEncounterWindow];
		}
		
	}
	
	if (currentState == eBribePropsal && button == 1) {
		
		button = -1;
		[self bribeContinue];
	}
	
	if (currentState == eBribeOffer && button == 0) 
	{
		if (credits < Bribe)
		{
			[self FrmAlert:@"NoMoneyForBribeAlert"];
			return;
		}
		
		credits -= Bribe;
		
		[self Travel];
		[encounterViewControllerInstance showEncounterWindow];
		button = -1;
		return;
	}
	
	if (currentState == eSubmit && button == 1)
		[self submitContinue];
	if (currentState == eSubmit && button == 0)
	{
		[self Travel];
		[encounterViewControllerInstance showEncounterWindow];
	}
	
	if (currentState == eEngageCaptainAhabAlert && button == 1)
	{
		// remove the last reflective shield
		int i=MAXSHIELD - 1;
		while (i >= 0)
		{
			if (Ship.Shield[i] == REFLECTIVESHIELD)
			{
				for (int m=i+1; m<MAXSHIELD; ++m)
				{
					Ship.Shield[m-1] = Ship.Shield[m];
					Ship.ShieldStrength[m-1] = Ship.ShieldStrength[m];
				}
				Ship.Shield[MAXSHIELD-1] = -1;
				Ship.ShieldStrength[MAXSHIELD-1] = 0;
				i = -1;
			}
			i--;
		}
		// add points to piloting skill
		// two points if you're on beginner-normal, one otherwise
		if (gameDifficulty < HARD)
			pilotSkill += 2;
		else
			pilotSkill += 1;
		
		if (pilotSkill > MAXSKILL)
		{
			pilotSkill = MAXSKILL;
		}
		[self FrmAlert:@"TrainingCompletedAlert"];
		
		[self Travel];
		[encounterViewControllerInstance showEncounterWindow];
		[self updateMercenary0Data];
		return;
	}
	
	
	// Trade a military laser for skill points in engineering?
	if (currentState == eEngageCaptainConradAlert && button == 1)
	{
		// remove the last military laser
		int i=MAXWEAPON - 1;
		while (i>=0)
		{
			if (Ship.Weapon[i] == MILITARYLASERWEAPON)
			{
				for (int m=i+1; m<MAXWEAPON; ++m)
				{
					Ship.Weapon[m-1] = Ship.Weapon[m];
				}
				Ship.Weapon[MAXWEAPON-1] = -1;
				i = -1;
			}
			i--;
		}
		// add points to engineering skill
		// two points if you're on beginner-normal, one otherwise
		if (gameDifficulty < HARD)
			engineerSkill += 2;
		else
			engineerSkill += 1;
		
		if (engineerSkill > MAXSKILL)
		{
			engineerSkill = MAXSKILL;
		}
		[self FrmAlert:@"TrainingCompletedAlert"];
		
		[self Travel];
		[encounterViewControllerInstance showEncounterWindow];
		[self updateMercenary0Data];
		return;
		
	}
	
	if (currentState == eEngageCaptainHuieAlert && button == 1)
	{
		// remove the last military laser
		int i=MAXWEAPON - 1;
		while (i>=0)
		{
			if (Ship.Weapon[i] == MILITARYLASERWEAPON)
			{
				for (int m=i+1; m<MAXWEAPON; ++m)
				{
					Ship.Weapon[m-1] = Ship.Weapon[m];
				}
				Ship.Weapon[MAXWEAPON-1] = -1;
				i = -1;
			}
			i--;
		}
		// add points to trading skill
		// two points if you're on beginner-normal, one otherwise
		if (gameDifficulty < HARD)
			traderSkill += 2;
		else
			traderSkill += 1;
		
		if (traderSkill > MAXSKILL)
		{
			traderSkill = MAXSKILL;
		}
		[self RecalculateBuyPrices:currentSystem];
		[self FrmAlert:@"TrainingCompletedAlert"];
		
		[self Travel];
		[encounterViewControllerInstance showEncounterWindow];
		[self updateMercenary0Data];
		return;		
	}
	
	if (currentState == eBuyEquipment && button == 1) {
		saveItem[saveSlot] = saveItemIndex;
		credits -= savePrice;
		[self playSound:eBuyShipUpgardes];
		[buyController UpdateView];
	}
	
	if (currentState== eSpecialEvent && (button == 1 || SpecialEvent[SolarSystem[currentSystem].Special].JustAMessage)) {
				[systemInfoController UpdateView];
		[self specialEventFormHandleEvent];
				[systemInfoController UpdateView];
	}
	
	if (currentState== eWildWeaponBuy && button == 1) {
		wildStatus = 0;
		[self FrmAlert:@"WildLeavesShipAlert"];
		[self doWarp:viaSingularitySaved];
	}	
	
	if (currentState == eUpdateSpecial) {
		[systemInfoController UpdateView];
	}
}


public boolean trade() 
{
	if (encounterType == TRADERBUY)
	{				
		int i =   GetRandomTradeableItem(Ship ,TRADERBUY);
		
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
		
		SellPrice[i] /=t[i].Roundoff;
		++SellPrice[i];
		SellPrice[i] *= t[i].Roundoff;
		if (SellPrice[i] < t[i].MinTradePrice)
			SellPrice[i] = t[i].MinTradePrice;
		if (SellPrice[i] > t[i].MaxTradePrice)
			SellPrice[i] = t[i].MaxTradePrice;
		
		
		
	//	currentState = eTradeInOrbit;
		activeTradeItem = i;
		// could not understand NSString * message = [NSString stringWithFormat:@"The trader wants to buy %@, and offers %i  cr. each. You have %i unit(s) available. \n \
		// could not understand 					  You paid about %i  cr. per unit. How many do you wish to sell?\n\n", Tradeitem[i].Name,SellPrice[i], Ship.Cargo[i],
		//					  BuyingPrice[i] / Ship.Cargo[i]];
		
	/*	
		AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Trade in Orbit" yoffset:90 message:message  
																		delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Ok"  thirdButtonTitle:@"All"];
		
		[myAlertView show];
		[myAlertView release];		
		
	}
	else if (encounterType == TRADERSELL)
	{				
		int i =  GetRandomTradeableItem(Opponent ,TRADERSELL);
		
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
			BuyPrice[i] =t[i].MinTradePrice;
		if (BuyPrice[i] >t[i].MaxTradePrice)
			BuyPrice[i] = t[i].MaxTradePrice;
		
		
	//	currentState = eSellInOrbit;
		activeTradeItem = i;
	//// could not understand 	NSString * message = [NSString stringWithFormat:@"The trader wants to sell %@, for the price of %i  cr. each. The trader has %i unit(s) for sale. \n \
		// could not understand 						  You can afford %i unit(s). How many do you wish to buy?\n\n", Tradeitem[i].Name, BuyPrice[i],  Opponent.Cargo[i],
			//				  credits / BuyPrice[i]];
		
		/*
		AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:@"Trade in Orbit" yoffset:90 message:message  
																		delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Ok"  thirdButtonTitle:@"All"];
		
		[myAlertView show];
		[myAlertView release];		
	
		
	}
	
	return false;
}

public boolean yield()
{
	if (wildStatus == 1)
	{
	//	currentState = eYieldChoice;
		//if (FrmCustomAlert( WantToSurrenderAlert, "You have Jonathan Wild on board! ", "Wild will be arrested, too. ", NULL ) == WantToSurrenderNo)
		//	return true;
	/*	AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:@"You have Jonathan Wild on board!" yoffset:90 message:@"Wild will be arrested, too."  
																		delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Yield"  thirdButtonTitle:nil];
		
			
		return true;
		
	}
	else if (reactorStatus > 0 && reactorStatus < 21)
	{
	//	currentState = eYieldChoice;		
		//		currentState = eSellInOrbit;
		//		if (FrmCustomAlert( WantToSurrenderAlert, "You have an illegal Reactor on board! ", "They will destroy the reactor. ", NULL) == WantToSurrenderNo)
		//			return true;
	//	currentState = eYieldChoice;		
	/*	AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:@"You have an illegal Reactor on board!" yoffset:90 message:@"They will destroy the reactor."  
																		delegate:self cancelButtonTitle:@"Cancel" okButtonTitle:@"Yeild"  thirdButtonTitle:nil];
		

		return true;
		
	}
	
	return  yieldContinue();
}


public boolean surrender ()
{
	autoAttack = false;
	autoFlee = false;
	
	
	if (Opponent.Type == MANTISTYPE)
	{
		if (artifactOnBoard)
		{
			/*
			 if (FrmAlert( WantToSurrenderToAliensAlert ) == WantToSurrenderToAliensNo)
			 return true;
			 else
			 {
			 [self FrmAlert( ArtifactStolenAlert );
			 ArtifactOnBoard = 0;
			 }
			 
	//		currentState = eSurrenderArtifact;		
	/*		UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Surrender!" message:NSLocalizedString(@"WantToSurrenderToAliensAlert", @"")  
																			delegate:self cancelButtonTitle:@"Surrender" otherButtonTitles:@"Cancel",nil];
			
			[myAlertView show];
			[myAlertView release];		
	//		bLastMessage = false;
		}
		else
		{
//			[self FrmAlert:@"NoSurrenderAlert"];
			return true;
		}
	}
	else if (ENCOUNTERPOLICE( encounterType ))
	{
		if (policeRecordScore <= PSYCHOPATHSCORE)
		{
	//		[self FrmAlert:@"NoSurrenderAlert"];
			return true;
		}
		else
		{
			if (wildStatus == 1)
			{
			//	currentState = eSurrender;		
				
		/*		UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"You have Jonathan Wild on board!" message:@"Wild will be arrested, too."  
																				delegate:self cancelButtonTitle:@"Surrender" otherButtonTitles:@"Cancel", nil];
			
				[myAlertView show];
				[myAlertView release]; 		
		//		bLastMessage = false;
				
				//				if (FrmCustomAlert( WantToSurrenderAlert, "You have Jonathan Wild on board! ", "Wild will be arrested, too. ", NULL ) == WantToSurrenderNo)
				return true;
			}
			else if (reactorStatus > 0 && reactorStatus < 21)
			{
				//				if (FrmCustomAlert( WantToSurrenderAlert, "You have an illegal Reactor on board! ", "They will destroy the reactor. ", NULL) == WantToSurrenderNo)
		//		currentState = eSurrender;		
			/*	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"You have an illegal Reactor on board!" message:@"They will destroy the reactor."  
																				delegate:self cancelButtonTitle:@"Surrender" otherButtonTitles:@"Cancel", nil];
				
				[myAlertView show];
				[myAlertView release];		
	//			bLastMessage = false;
				return true;
			}
			else
			{
				//	if (FrmCustomAlert( WantToSurrenderAlert, NULL, NULL, NULL ) == WantToSurrenderNo)
	//			currentState = eSurrender;						
/*				UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Surrender!" message:NSLocalizedString(@"WantToSurrenderAlert", @"")  
																				delegate:self cancelButtonTitle:@"Surrender" otherButtonTitles:@"Cancel", nil];
				
				[myAlertView show];
				[myAlertView release];		
	//			bLastMessage = false;
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
			int Blackmail = (int) min( 25000, max( 500, currentWorth() / 20 ) );
			//[self FrmAlert:@"PiratesFindNoCargoAlert"];
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
			
	//		[self FrmAlert:@"PiratesPlunderAlert"];									
			
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
		//	[self FrmAlert:@"WildGoesWithPiratesAlert"];
		}
		else if (wildStatus == 1)
		{
			// no room on pirate ship
		//	[self FrmAlert:@"WildStaysAboardAlert"];
		}
		if (reactorStatus > 0 && reactorStatus < 21)
		{
			// pirates puzzled by reactor
		//	[self FrmAlert:@"PiratesDontStealReactorAlert"];
		}
	}
	
	 Travel();
	//[encounterViewControllerInstance showEncounterWindow];
	
	return false;
}

public boolean bribeContinue()
{
	// Bribe depends on how easy it is to bribe the police and commander's current worth
	Bribe =  (int) (currentWorth() / ((10 + 5 * (IMPOSSIBLE - gameDifficulty)) * p[SolarSystem[warpSystem].Politics].BribeLevel));
	if (Bribe % 100 != 0)
		Bribe += (100 - (Bribe % 100));
	if (wildStatus == 1 || (reactorStatus > 0 && reactorStatus < 21))
	{
		if (gameDifficulty <= NORMAL)
			Bribe *= 2;
		else
			Bribe *= 3;
	}
	Bribe = (int) max( 100, min( Bribe, 10000 ) );
	
	
	// could not understand 	NSString* str = [NSString stringWithFormat:@"The Police officers are willing to forego inspection for amount of %i credits.", Bribe];
	
//	currentState = eBribeOffer;			
	// take the cargo of the Marie Celeste?
/*	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Bribe" message:str
																	delegate:self cancelButtonTitle:@"Bribe" otherButtonTitles:@"Cancel",nil];
	
	[myAlertView show];
	[myAlertView release];		
	//bLastMessage = false;
	return true;	
	
}

public int MARIECELESTEENCOUNTER		=80;
public int BOTTLEOLDENCOUNTER          =81;
public int BOTTLEGOODENCOUNTER         =82;
public int POSTMARIEPOLICEENCOUNTER	=83;



public boolean bribe()
{
	autoAttack = false;
	autoFlee = false;
	
	if (p[SolarSystem[warpSystem].Politics].BribeLevel <= 0)
	{
	//	[self FrmAlert:@"CantBeBribedAlert"];
		return true;
	}
	
	if (encounterType == POSTMARIEPOLICEENCOUNTER)
	{
//		[self FrmAlert:@"MarieCantBeBribedAlert"];
		return true;
	}
	
	if (encounterType == POLICEINSPECTION && Ship.Cargo[FIREARMS] <= 0 &&
		Ship.Cargo[NARCOTICS] <= 0 && wildStatus != 1)
	{
		//currentState = eBribePropsal;			
		// take the cargo of the Marie Celeste?
	/*	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Bribe" message:
										  NSLocalizedString(@"SureToFleeOrBribeAlert", @"") delegate:self cancelButtonTitle:@"Cancel" otherButtonTitles:@"Bribe", nil];
		
		[myAlertView show];
		[myAlertView release];		
	//	bLastMessage = false;
		return true;
	}
	
	return bribeContinue();
	
}


public boolean submit() 
{
	
	autoAttack = false;
	autoFlee = false;
	
	String str,str2;
	
	if (encounterType == POLICEINSPECTION && (Ship.Cargo[FIREARMS] > 0 ||
											  Ship.Cargo[NARCOTICS] > 0 || wildStatus == 1 ||
											  (reactorStatus > 1 && reactorStatus < 21)))
	{
		if (wildStatus == 1)
		{
			if (Ship.Cargo[FIREARMS] > 0 || Ship.Cargo[NARCOTICS] > 0)
			{
				str = "Jonathan Wild and illegal goods";
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
		
//		currentState = eSubmit;			
		// take the cargo of the Marie Celeste?
	/*	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Encounter" message:
										  NSLocalizedString(@"SureToSubmitAlert", @"") delegate:self cancelButtonTitle:@"Cancel" otherButtonTitles:@"Take Cargo",nil];
		
		[myAlertView show];
		[myAlertView release];		
//		bLastMessage = false;		
		//		if (FrmCustomAlert( SureToSubmitAlert, SBuf, SBuf2, NULL ) == SureToSubmitNo)
		return true;
		
	}
	return submitContinue();	
}

public boolean submitContinue()
{
	
	if ((Ship.Cargo[FIREARMS] > 0) || (Ship.Cargo[NARCOTICS] > 0))
	{
		// If you carry illegal goods, they are impounded and you are fined
		Ship.Cargo[FIREARMS] = 0;
		BuyingPrice[FIREARMS] = 0;
		Ship.Cargo[NARCOTICS] = 0;
		BuyingPrice[NARCOTICS] = 0;
		int Fine = (int) (currentWorth() / ((IMPOSSIBLE+2-gameDifficulty) * 10));
		if (Fine % 50 != 0)
			Fine += (50 - (Fine % 50));
		Fine = (int) max( 100, min( Fine, 10000 ) );
		if (credits >= Fine)
			credits -= Fine;
		else
		{
			debt += (Fine - credits);
			credits = 0;
		}
		
		
		
	//	NSString* str = [NSString stringWithFormat:@"The Police discovers illegal goods in your cargo holds. These goods will be impounded and you are fined of %i credits.", Fine];
	//	[self FrmAlert:str];		
		
		policeRecordScore += TRAFFICKING;
	}
	else if (wildStatus != 1)
	{
		// If you aren't carrying illegal goods, the police will increase your lawfulness record
	//	[self FrmAlert:@"NoIllegalGoodsAlert"];
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
	//	[self FrmAlert:@"PoliceConfiscateReactorAlert"];
		reactorStatus = 0;
		
	}	
	
	
	
	 Travel();
	//[encounterViewControllerInstance showEncounterWindow];
	
	return false;
	
}

public boolean plunder()
{
	boolean autoAttack = false;
	boolean autoFlee = false;
	
	if (ENCOUNTERTRADER( encounterType ))
		policeRecordScore += PLUNDERTRADERSCORE;
	else
		policeRecordScore += PLUNDERPIRATESCORE;
	
	// showPlunderForm(ePlunderShip);
	
	return true;
}

public boolean interrupt ()
{
	autoFlee = false;
	autoAttack = false;
	//[self Travel];
	//[encounterViewControllerInstance showEncounterWindow];
	
	return false;	
}

//abcdefg

public int FAMOUSCAPTAIN	   			=70;
public int FAMOUSCAPATTACK    			=71;
public int CAPTAINAHABENCOUNTER		=72;
public int CAPTAINCONRADENCOUNTER		=73;
public int CAPTAINHUIEENCOUNTER		=74;
public int MAXFAMOUSCAPTAIN            =79;


public boolean meet() {
	
	
	//"Meet Captain Ahab", "Captain Ahab is in need of a spare shield for an upcoming mission. He offsers to trade you some piloting lessons for ypur reflective shild. Do you wish to trade?", "YEs, Trdae shield", "No"
	
	if (encounterType == CAPTAINAHABENCOUNTER)
	{
		
	//	currentState = eEngageCaptainAhabAlert;
	//could not understand	[self FrmAlertWithState:@"EngageCaptainAhabAlert" state:eEngageCaptainAhabAlert];
		// Trade a reflective shield for skill points in piloting?
	}
	else if (encounterType == CAPTAINCONRADENCOUNTER)
	{
		
	//	currentState = eEngageCaptainConradAlert;
		//could not understand	[self FrmAlertWithState:@"EngageCaptainConradAlert"  state:eEngageCaptainConradAlert];
	}
	else if (encounterType == CAPTAINHUIEENCOUNTER)
	{
	//	currentState = eEngageCaptainHuieAlert;
		//could not understand	[self FrmAlertWithState:@"EngageCaptainHuieAlert" state:eEngageCaptainHuieAlert];
		// Trade a military laser for skill points in trading?
	}
	
	
	
	
	
	return true;
}

public boolean board() {
	
	if (encounterType == MARIECELESTEENCOUNTER)
	{
		//currentState = eBoard;			
		// take the cargo of the Marie Celeste?
		//could not understand	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Encounter"  message:
									//	  NSLocalizedString(@"EngageMarieAlert", @"") delegate:self cancelButtonTitle:@"Take Cargo" otherButtonTitles:@"Take Cargo",nil];
		
		
	//	bLastMessage = false;
		return true;
		
	}
	else {
		 Travel();
	//	encounterViewControllerInstance(showEncounterWindow);
		
		return false;			
	}	
}

public boolean drink() {
	
	if (encounterType == BOTTLEGOODENCOUNTER)
	{
		// Quaff the good bottle of Skill Tonic?
		//could not understand[self playSound:eBottleEncounter];
	//	currentState = eBottleGood;		
	}
	else if (encounterType == BOTTLEOLDENCOUNTER)
	{
		// Quaff the out of date bottle of Skill Tonic?
		//could not understand[self playSound:eBottleEncounter];		
	//	currentState = eBottleStrange;		
		
	} else {
		Travel();
	//	encounterViewControllerInstance(showEncounterWindow);
		
		return false;			
	}
	
	//could not understand	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:@"Encounter" message:NSLocalizedString(@"EngageBottleAlert", @"") 
						//								  delegate:self cancelButtonTitle:@"Yes" otherButtonTitles:@"No", nil];
	
		
//	bLastMessage = false;
	return true;
}


// Returns number of open quests.
public int monsterStatus;       // 0 = Space monster isn't available, 1 = Space monster is in Acamar system, 2 = Space monster is destroyed
public int dragonflyStatus;     // 0 = Dragonfly not available, 1 = Go to Baratas, 2 = Go to Melina, 3 = Go to Regulas, 4 = Go to Zalkon, 5 = Dragonfly destroyed
public int[] saveItem;
public int saveItemIndex;
public long savePrice;
public int saveSlot;

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




/*
public String drawQuestsForm(SystemInfoViewController controller)
{
	systemInfoController = controller;
	return  drawQuestsForm();
}

public void setInfoViewController(SystemInfoViewController controller)
{
	systemInfoController = controller;
}

public String drawSpecialCargoForm()
{
	
	//	NSMutableString * header=[NSString alloc];
	//could not unders	NSMutableString *header = [[[NSMutableString alloc] init] retain];
	bool bSpecialItem = false;
	
	if (Ship.Tribbles > 0)
	{
		if (Ship.Tribbles >= MAXTRIBBLES)
		{
	//		[header appendString:@"An infestation of tribbles.\n"];
		}
			else
		{
			//could not unders	NSString * t = [NSString stringWithFormat:@"%i cute, furry tribble.\n", Ship.Tribbles];
		//	[header appendString:t];		
		}
		bSpecialItem = true;
	}
	
	if (japoriDiseaseStatus == 1)
	{
		bSpecialItem = true;	
		[header appendString:@"10 bays of antidote.\n"];
	}
	if (artifactOnBoard)
	{
		bSpecialItem = true;		
		[header appendString:@"An alien artifact.\n"];
	}
	if (jarekStatus == 2)
	{
		bSpecialItem = true;		
		[header appendString:@"A haggling computer.\n"];
	}
	if (reactorStatus > 0 && reactorStatus < 21)
	{
		bSpecialItem = true;		
		[header appendString:@"An unstable reactor taking up 5 bays."];
		NSString * t = [NSString stringWithFormat:@"%i bay of enriched fuel.\n", 10 - ((reactorStatus - 1) / 2)];
		[header appendString:t];
	}
	
	if (canSuperWarp)
	{
		bSpecialItem = true;
		[header appendString:@"A Portable Singularity.\n"];
	}
	
	
	if (!bSpecialItem)
	{
		[header appendString:@"No special items."];
	}
	
	return header;
}

//Add Ships, Weapons, Shields, and Gadgets that don't show up normally


public int  EXTRASHIELDS    =1;   // Number of Shields over standard


public String  drawCurrentShipForm()
{
	
	int i, j, k, FirstEmptySlot;
	
	
//	NSMutableString *header = [[[NSMutableString alloc] init] retain];		
	
	
	String	header ="\n";

	for (i=0; i<MAXWEAPONTYPE+EXTRAWEAPONS; ++i)
	{
		j = 0;
		for (k=0; k<MAXWEAPON; ++k)
		{
			if (Ship.Weapon[k] == i)
				++j;
		}
		if (j > 0)
		{
			//SBuf[0] = '\0';
			for (; j >0; --j) {
				
				
		//		[header appendString:[NSString stringWithCString:Weapontype[i].Name]];
		//String	header ="\n";
			}
		}
	}
	
	for (i=0; i<MAXSHIELDTYPE+EXTRASHIELDS; ++i)
	{
		int shieldQty = 0;
		for (k=0; k<MAXSHIELD; ++k)
		{
			if (Ship.Shield[k] == i)
				++shieldQty;
		}
		if (shieldQty > 0)
		{ 
			/*[header appendString:[NSString stringWithCString:Shieldtype[i].Name]];
			[header appendString:[NSString stringWithFormat:@" (%i)", shieldQty]];
			[header appendString:@"\n"];
		}
	}
	
	for (i=0; i<MAXGADGETTYPE+EXTRAGADGETS; ++i)
	{
		j = 0;
		for (k=0; k<MAXGADGET; ++k)
		{
			if (Ship.Gadget[k] == i)
				++j;
		}
		if (j > 0)
		{
			if (i == EXTRABAYS)
			{
				j = j*5;
		//		[header appendString:[NSString stringWithFormat:@"%i extra cargo bays\n", j]];
				
			}
			else
			{
			/*	[header appendString:[NSString stringWithCString:Gadgettype[i].Name]];
				[header appendString:@"\n"];			
			}
		}
	}
	
	if (escapePod)
	{
//		[header appendString:@"an escape pod\n"];			
	}
	
	if ( AnyEmptySlots(Ship))
	{			
	//	[header appendString:@"Unfilled:\n"];			
		
		
		FirstEmptySlot =  GetFirstEmptySlot(s[Ship.Type].WeaponSlots,  Ship.Weapon);
		if (FirstEmptySlot >= 0)
		{
		//	[header appendString:[NSString stringWithFormat:@"%i weapon slot(s)\n",s[Ship.Type].WeaponSlots - FirstEmptySlot]];
			
			
		}
		
		FirstEmptySlot = GetFirstEmptySlot(s[Ship.Type].ShieldSlots, Ship.Shield);
		if (FirstEmptySlot >= 0)
		{
			//[header appendString:[NSString stringWithFormat:@"%i shield slot(s)\n",s[Ship.Type].ShieldSlots - FirstEmptySlot]];
			
		}
		
		FirstEmptySlot =  GetFirstEmptySlot(s[Ship.Type].GadgetSlots,Ship.Gadget);
		if (FirstEmptySlot >= 0)
		{
		//	[header appendString:[NSString stringWithFormat:@"%i gadget slot(s)\n",s[Ship.Type].GadgetSlots - FirstEmptySlot]];
		}
	}
	
	return header;
	
}

public boolean  AnyEmptySlots(SHIP Ship) 
{
	int j;
	
	for (j=0; j<s[Ship.Type].WeaponSlots; ++j)
	{
		if (Ship.Weapon[j] < 0)
		{
			return true;
		}							
	}
	for (j=0; j<s[Ship.Type].ShieldSlots; ++j)
	{
		if (Ship.Shield[j] < 0)
		{
			return true;
		}							
	}
	for (j=0; j<s[Ship.Type].GadgetSlots; ++j)
	{
		if (Ship.Gadget[j] < 0)
		{
			return true;
		}							
	}
	
	return false;
}


public String getEquipmentName(int index)
{
	
	if (index < MAXWEAPONTYPE)
		return (Weapontype[index].Name);	
	else
		if (index < MAXWEAPONTYPE + MAXSHIELDTYPE) {
			return  (Shieldtype[index - MAXWEAPONTYPE].Name);				
		} else {
			return (Gadgettype[index - MAXWEAPONTYPE - MAXSHIELDTYPE].Name);							
		}
}


public String stringWithCString(String name) {
	// TODO Auto-generated method stub
	return null;
}

public String getShipEquipmentName(int index)
{
	
	if (index < MAXWEAPON && Ship.Weapon[index] >= 0)
		return  stringWithCString(Weapontype[Ship.Weapon[index]].Name) ;	
	else
		if (index < MAXWEAPON + MAXSHIELD && Ship.Shield[index - MAXWEAPON] >=0 ) {
			return  stringWithCString(Shieldtype[Ship.Shield[index - MAXWEAPON]].Name );				
		} else {
			if (Ship.Gadget[index - MAXWEAPON - MAXSHIELD] >= 0)
			return  stringWithCString(Gadgettype[Ship.Gadget[index - MAXWEAPON - MAXSHIELD]].Name);							
		}
	return "";
}



// *************************************************************************
// Determine base price of item
// *************************************************************************
public long BasePrice(int techLevel2 , long Price)
{
	return ((techLevel2 > SolarSystem[currentSystem].TechLevel) ? 0 : 
			((Price * (100 -  TraderSkill(Ship))) / 100));
}

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


public int getSellEquipmentPrice(int index)
{
	if (index < MAXWEAPON)
		return WEAPONSELLPRICE(index);	
	else
		if (index < MAXWEAPON + MAXSHIELD) {
			return (int) SHIELDSELLPRICE(index - MAXWEAPON);				
		} else {
			return GADGETSELLPRICE(index - MAXWEAPON - MAXSHIELD);							
		}	
}



// *************************************************************************
// Buy an item: Slots is the number of slots, Item is the array in the
// Ship record which contains the item type, Price is the costs,
// Name is the name of the item and ItemIndex is the item type number
// *************************************************************************

public long toSpend()
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
public int MERCENARYHIREPRICE(int  a )
{
	return (a < 0 || (a >= MAXCREWMEMBER && wildStatus == 2) ? 0 : ((Mercenary[a].Pilot + Mercenary[a].Fighter + Mercenary[a].Trader + Mercenary[a].Engineer) * 3));
}

public void BuyItem(int weaponSlots  ,int[] weapon , long Price, String name,int ItemIndex)
{
	int FirstEmptySlot;
	
	FirstEmptySlot = GetFirstEmptySlot(weaponSlots, weapon);
	
	if (Price <= 0)
	{
		//[self FrmAlert:@"ItemNotSoldAlert"];
	}
	else if (debt > 0)
	{
		//	[self FrmAlert:@"YoureInDebtAlert"];
	}
		else if (Price > toSpend())
		{
	//	[self FrmAlert:@"CantBuyItemAlert"];
         }
			else if (FirstEmptySlot < 0)
			{
				//	[self FrmAlert:@"NotEnoughSlotsAlert"];
			}
	else
	{
		//currentState = eBuyEquipment;
		
		//NSString* str = [NSString stringWithFormat:@"Do you wish to buy this item for %i credits?", Price];
		//[self FrmAlert:str];
		//NSString* name = [NSString stringWithFormat:@"Buy %@", [NSString stringWithCString:Name]];
		
	//	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:name message:str delegate:self cancelButtonTitle:@"Cancel" otherButtonTitles:@"Ok",nil];	
			
		//bLastMessage = false;
		
		saveItem = weapon;
		saveItemIndex= ItemIndex;
		savePrice = Price;
		saveSlot = FirstEmptySlot;
		
		
		
	}
}

public long BASEWEAPONPRICE(int a )
{
	return BasePrice(Weapontype[a].TechLevel, Weapontype[a].Price);
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

public long BASESHIELDPRICE(int  a )
{
	return(BasePrice(Shieldtype[a].TechLevel, Shieldtype[a].Price));
}
public long BASEGADGETPRICE(int a )
{
	return BasePrice(Gadgettype[a].TechLevel, Gadgettype[a].Price);
}



//Shields
public int  MAXSHIELDTYPE    =2;
public int  ENERGYSHIELD     =0;
public int  ESHIELDPOWER     =100;
public int  REFLECTIVESHIELD =1;
public int  RSHIELDPOWER     =200;
public void sellEquipment(int index)
{
	if (index < MAXWEAPON)
	{
		credits += WEAPONSELLPRICE(index);
		for (int i = index + 1; i < MAXWEAPON; ++i)
			Ship.Weapon[i-1] = Ship.Weapon[i];
		Ship.Weapon[MAXWEAPON - 1] = -1;
	} else 
	if (index < MAXWEAPON + MAXSHIELD) 
	{
		index =index - MAXWEAPON;
		credits += WEAPONSELLPRICE(index);
		for (int i = index + 1; i < MAXSHIELD; ++i) {
			Ship.Shield[i-1] = Ship.Shield[i];
			Ship.ShieldStrength[i-1] = Ship.ShieldStrength[i];	
		}
		Ship.Shield[MAXSHIELD - 1] = -1;
		Ship.ShieldStrength[MAXSHIELD - 1] = -1;		
	}
	else
	{
		index = index - MAXWEAPON - MAXSHIELD;
		
		if (filledCargoBays() >  totalCargoBays() - 5)
		{
			//[self FrmAlert:@"CargoBaysFullAlert"];
		}
			else
		{
			credits += GADGETSELLPRICE(index);
			for (int i = index + 1; i < MAXGADGET; ++i)
				Ship.Gadget[i-1] = Ship.Gadget[i];
			Ship.Gadget[MAXGADGET - 1] = -1;		
		}
	}	
}

/*public void DrawMercenary(int index ,personellRosterViewController controller,  name:(UILabel*)name cost:(UILabel*)cost pilot:(UILabel*)pilot trader:(UILabel*)trader
			  fighter:(UILabel*)fighter engineer:(UILabel*)engineer
{
	[controller.view addSubview:name];
	[controller.view addSubview:cost];
	[controller.view addSubview:pilot];
	[controller.view addSubview:trader];
	[controller.view addSubview:fighter];
	[controller.view addSubview:engineer];
	

	name.text = [NSString stringWithCString:MercenaryName[Mercenary[index].NameIndex]];
	cost.text = [NSString stringWithFormat:@"Costs: %i cr. daily", MERCENARYHIREPRICE(index)];
	pilot.text = [NSString stringWithFormat:@"Pilot: %i", Mercenary[index].Pilot];
	trader.text = [NSString stringWithFormat:@"Trader: %i", Mercenary[index].Trader];
	fighter.text = [NSString stringWithFormat:@"Fighter: %i", Mercenary[index].Fighter];
	engineer.text = [NSString stringWithFormat:@"Engineer: %i", Mercenary[index].Engineer];	
}

// *************************************************************************
// Determine which mercenary is for hire in the current system
// *************************************************************************
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


public void updateRosterWindow(/*personellRosterViewController controller )
{
	int i = 0;
	//for (i=0; i<2; ++i)
	{
		if (i == s[Ship.Type].CrewQuarters-2 && (jarekStatus == 1 || wildStatus == 1))
		{
			if (jarekStatus == 1) {
		//		controller.Vacancy0.text = "Jarek's quarters.";
	//			controller.view addSubview:controller.Vacancy0];
			}
				//;DrawChars( "Jarek's quarters", 30, 30 + i*45 );
			else {
			//	controller.Vacancy0.text = "Wild's quarters.";
				//[controller.view addSubview:controller.Vacancy0];

			}
	//		continue;
		} else
		
		if (s[Ship.Type].CrewQuarters <= i+1)
		{
		//	controller.Vacancy0.text = "No quarters available.";
			//[controller.view addSubview:controller.Vacancy0];

		} else
		
		if (Ship.Crew[i+1] < 0)
		{
		//	controller.Vacancy0.text = "Vacancy";
	//		[controller.view addSubview:controller.Vacancy0];

		}
		else {
	//		[self DrawMercenary:Ship.Crew[i+1] controller:controller name:controller.PilotName0 cost:controller.Price0 pilot:controller.Pilot0 trader:controller.Trader0 fighter:controller.Fighter0
		//			   engineer:controller.Engineer0];
		//	[controller.view addSubview:controller.fire0];	
		}	
	}

	{
		//int i = 1;
		if (i == s[Ship.Type].CrewQuarters-2 && (jarekStatus == 1 || wildStatus == 1))
		{
			if (jarekStatus == 1) {
	//			controller.Vacancy0.text = @"Jarek's quarters.";
		//		[controller.view addSubview:controller.Vacancy0];
			}
			//;DrawChars( "Jarek's quarters", 30, 30 + i*45 );
			else {
			//	controller.Vacancy1.text = @"Wild's quarters.";
			//	[controller.view addSubview:controller.Vacancy0];
				
			}
			//		continue;
		} else
			
			if (s[Ship.Type].CrewQuarters <= i+1)
			{
				//controller.Vacancy1.text = @"No quarters available.";
				//[controller.view addSubview:controller.Vacancy1];
				
			} else
				
				if (Ship.Crew[i+1] < 0)
				{
				//	controller.Vacancy1.text = @"Vacancy";
					//[controller.view addSubview:controller.Vacancy1];
					
				}
				else {
				//	[self DrawMercenary:Ship.Crew[i+1] controller:controller name:controller.PilotName1 cost:controller.Price1 pilot:controller.Pilot1 trader:controller.Trader0 
				//				fighter:controller.Fighter1   engineer:controller.Engineer1];
				//	[controller.view addSubview:controller.fire1];	
				}	
	}

	
	
	
//	int ForHire = [self GetForHire];
	if (ForHire < 0)
	{
	//	controller.Vacancy2.text = @"No one for hire";
	//	[controller.view addSubview:controller.Vacancy2];	

	}
	else
	{	
	//	[self DrawMercenary:ForHire controller:controller name:controller.PilotName2 cost:controller.Price2 pilot:controller.Pilot2 trader:controller.Trader2 fighter:controller.Fighter2
	//			   engineer:controller.Engineer2];
	//	[controller.view addSubview:controller.fire2];	
		
//		FrmShowObject( frmP, FrmGetObjectIndex( frmP, PersonnelRosterHire0Button ) );
//		DrawMercenary( ForHire, 107 );		
	}
	
}

public void fireMercenary(int index) {
	int oldTraderSkill = TraderSkill(Ship);
	if (index == 1)
	{
		Ship.Crew[1] = Ship.Crew[2];
	}
//	else 
//		Ship.Crew[1] = -1;
	
	Ship.Crew[2] = -1;
	
	if (oldTraderSkill != TraderSkill(Ship))
		 RecalculateBuyPrices(currentSystem);
	
	//[self playSound:eFireMercenary];
}

public int AvailableQuarters()
{
	return s[Ship.Type].CrewQuarters - (jarekStatus == 1 ? 1 : 0) -
	(wildStatus == 1 ? 1 : 0);
}

public void hireMercenaryFromRoster() {
	int oldTraderSkill;
	oldTraderSkill =  TraderSkill(Ship);
	int ForHire =  GetForHire();
	
	int FirstFree = -1;
	if (Ship.Crew[1] == -1)
		FirstFree = 1;
	else if (Ship.Crew[2] == -1)
		FirstFree = 2;
	if (FirstFree < 0 ||  AvailableQuarters() <= FirstFree) {
		//[self FrmAlert:@"NoFreeQuartersAlert"];
	} else {
		Ship.Crew[FirstFree] = ForHire;
		if (oldTraderSkill !=  TraderSkill(Ship))
			RecalculateBuyPrices(currentSystem);
		
	}

}





// *************************************************************************
// Square of the distance between two solar systems
// *************************************************************************


// *************************************************************************
// Distance between two solar systems
// *************************************************************************
public long RealDistance(int a  , int b)
{
	return (long) (Math.sqrt(  SqrDistance(SolarSystem[a] ,SolarSystem[ b] )));
}
public long SqrDistance( SOLARSYSTEM a  , SOLARSYSTEM b)
{
	return (SQR( a.X - b.X ) + SQR( a.Y - b.Y ));
}

public int SQR(int a )
{
	return (a * a);
}


// *************************************************************************
// Temporary implementation of square root
// *************************************************************************

 

public String getPriceDifference (int itemIndex, boolean difference, int realPrice,int maxCount,int isSmart)
{
	int price = (int) StandardPrice(itemIndex ,SolarSystem[warpSystem].Size,SolarSystem[warpSystem].TechLevel ,SolarSystem[warpSystem].Politics ,SolarSystem[warpSystem].Visited ? SolarSystem[warpSystem].SpecialResources : -1);
	if (price > BuyPrice[itemIndex] && BuyPrice[itemIndex] > 0 && SolarSystem[currentSystem].Qty[itemIndex] > 0)
		isSmart = 1;
	else
		isSmart = 0;
	realPrice = price;
	if (BuyPrice[itemIndex] > 0)
		maxCount = (int) (credits / BuyPrice[itemIndex]);
	else
		maxCount = 0;
	if (price <= 0 || (difference && BuyPrice[itemIndex] <= 0))
		return ("---");// [[NSString stringWithFormat:@""] retain];
	if (difference) 
	{
		//return [[NSString stringWithFormat:@"%@%i cr.", price > BuyPrice[itemIndex] ? @"+" : @"", price - BuyPrice[itemIndex]] retain];
	}
	return null;
		
/*	else
	{
	//	return [[NSString stringWithFormat:@"%i cr.", price] retain];
	}
}
		
public void SQR(long i)
{
	long a;
	a=i*i;
	i=a;
}
/*
public long SqrDistance(SOLARSYSTEM a ,   SOLARSYSTEM b)
{
	return (SQR( a.X - b.X ) + SQR( a.Y - b.Y ));
}


public long realDistance(int a , int b)
{
	return (sqrt(SqrDistance(SolarSystem[ a] ,SolarSystem [b])));
	//	return [RealDistance:solarSystem[a] b:solarSystem[b]];
}
public int sqrt( long a )
{
int i;

i = 0;
while (SQR( i ) < a)
++i;
if (i > 0)
if ((SQR( i ) - a) > (a - SQR( i-1 )))
--i;
return( i );
}


// *************************************************************************
// Determine next system withing range
// *************************************************************************
public int nextSystemWithinRange(int Current, boolean Back) 
{
	int i = Current;
	
	if(Back)
	{
		--i;
	}
	else
		++i;
	
	while (true)
	{
		if (i < 0)
			i = MAXSOLARSYSTEM - 1;
		else if (i >= MAXSOLARSYSTEM)
			i = 0;
		if (i == Current)
			break;
		
		if (wormholeExists(currentSystem,i))
			return i;
		else if ( RealDistance( currentSystem,i)  <= getFuel() && RealDistance(currentSystem,i)  > 0)
			return i;
		
		if(Back) 
			--i; 
			else
			++i;
	}
	
	return i;
}

//Returns true if there exists a wormhole from a to b. 
//If b < 0, then return true if there exists a wormhole 
//at all from a.

//Wormholes
public int MAXWORMHOLE =6;

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

public int getCurrentSystemPirateLevel()
{
	return (int) p[SolarSystem[currentSystem].Politics].StrengthPirates;
}

public boolean canUpgradeHull() {/*
	if (Ship.PirateHullUpgrade > 0) 
		return false;
	
	return true;	
}
public boolean maxWeaponUpgradePrice() {
	if (Ship.Weapon[0] >= 2) {
		return true;
	}
	return false;
}
public boolean maxShieldUpgradePrice() {
	if (Ship.Shield[0] >= 1) {
		return true;
	}
	return false;
}



/* typedef struct 
	{
		long CurrentSystem;
		long Credits;
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
		Boolean APLscreen;
		int LeaveEmpty;
		Boolean TribbleMessage;
		Boolean AlwaysInfo;
		Boolean AlwaysIgnorePolice;
		Boolean AlwaysIgnorePirates;
		Boolean TextualEncounters;
		Byte JarekStatus;
		Byte InvasionStatus;
		Boolean Continuous;
		Boolean AttackFleeing;
		Byte ExperimentStatus;
		Byte WildStatus;
		Byte FabricRipProbability;
		Byte VeryRareEncounter;
		Byte BooleanCollection;
		Byte ReactorStatus;
		int TrackedSystem;
		Byte ScarabStatus;
		Boolean AlwaysIgnoreTradeInOrbit;
		Boolean AlreadyPaidForNewspaper;
		Boolean GameLoaded;
		int Shortcut1;
		int Shortcut2;
		int Shortcut3;
		int Shortcut4;
		Boolean LitterWarning;
		Boolean SharePreferences;
		Boolean IdentifyStartup;
		Boolean RectangularButtonsOn;
		Boolean newsAutoPay;
		Boolean showTrackedRange;
		Boolean justLootedMarie;
		Boolean arrivedViaWormhole;
		Boolean trackAutoOff;
		Boolean remindLoans;
		Boolean canSuperWarp;
		Boolean musicEnabled;
		Byte ForFutureUse[MAXFORFUTUREUSE]; // Make sure this is properly adapted or savegames won't work after an upgrade!
	} SAVEGAMETYPE;




public void LoadBinaryOptions (String name) 
{/*
	options.musicEnabled = 1;
	options.soundEnabled = 1;
	
	NSArray *filePaths =	NSSearchPathForDirectoriesInDomains (																 
																 NSDocumentDirectory, 
																 NSUserDomainMask,
																 YES
																 ); 
	
	NSString* recordingDirectory = [filePaths objectAtIndex: 0];
	
	NSString* fileName = [NSString stringWithFormat:@"%@/%@.opt", recordingDirectory, name];
	
	NSData* data;
	data =[[NSData alloc] initWithContentsOfFile:fileName];
	
	memcpy(&options, [data bytes], [data length]);
	[data release];	
}

public void SaveOptions(String name)
{/*
	//NSData* data;
	
	//NSArray *filePaths =	NSSearchPathForDirectoriesInDomains (
																 
																 NSDocumentDirectory, 
																 NSUserDomainMask,
																 YES
																 ); 
	
	NSString* recordingDirectory = [filePaths objectAtIndex: 0];
	
	NSString* fileName = [NSString stringWithFormat:@"%@/%@.opt", recordingDirectory, name];
	data = [[NSData alloc] initWithBytes:&options length:(NSUInteger)sizeof(options) ];
	[data writeToFile:fileName atomically:FALSE];	
	[data release];
	
}

public void LoadBinaryHighScore(String name)
{
	
	/*NSArray *filePaths =	NSSearchPathForDirectoriesInDomains (																 
																 NSDocumentDirectory, 
																 NSUserDomainMask,
																 YES
																 ); 
	
	NSString* recordingDirectory = [filePaths objectAtIndex: 0];
	
	NSString* fileName = [NSString stringWithFormat:@"%@/%@.hscr", recordingDirectory, name];
	
	NSData* data;
	data =[[NSData alloc] initWithContentsOfFile:fileName];
	
	memcpy(sg, [data bytes], [data length]);
	[data release];
}

public void eraseAutoSave()
{
	/*
	
	NSArray *filePaths =	NSSearchPathForDirectoriesInDomains (
																 
																 NSDocumentDirectory, 
																 NSUserDomainMask,
																 YES
																 ); 
	
	NSString* recordingDirectory = [filePaths objectAtIndex: 0];
	
	NSString* fileName = [NSString stringWithFormat:@"%@/Autosave.save", recordingDirectory];	
	NSFileManager *fileManager = [NSFileManager defaultManager];	
	[fileManager removeItemAtPath:fileName error:NULL];
}


public void SaveHighScore(String name)
{
	NSData* data;
	
	NSArray *filePaths =	NSSearchPathForDirectoriesInDomains (
																 
																 NSDocumentDirectory, 
																 NSUserDomainMask,
																 YES
																 ); 
	
	NSString* recordingDirectory = [filePaths objectAtIndex: 0];
	
	NSString* fileName = [NSString stringWithFormat:@"%@/%@.hscr", recordingDirectory, name];
	data = [[NSData alloc] initWithBytes:&Hscores length:(NSUInteger)sizeof(Hscores) ];
	[data writeToFile:fileName atomically:FALSE];	
	[data release];	
}


public void SaveGame(String name)
{
	 data;

	NSArray *filePaths =	NSSearchPathForDirectoriesInDomains (NSDocumentDirectory,NSUserDomainMask,YES); 
	
	NSString* recordingDirectory = [filePaths objectAtIndex: 0];
	
	NSString* fileName = [NSString stringWithFormat:@"%@/%@.save", recordingDirectory, name];
	SAVEGAMETYPE saveGame, * sg = &saveGame;
	
	// Copying all members to the save game structure
	int i;
	sg->PilotSkill = pilotSkill;
	sg->FighterSkill = fighterSkill;
	sg->TraderSkill = traderSkill;
	sg->EngineerSkill = engineerSkill;
	
	sg->CurrentSystem = currentSystem;	
	sg->Credits = credits;
	sg->Debt = debt;
	sg->Days = days;
	sg->WarpSystem = warpSystem;
//	sg->SelectedShipType = selectedShipType;
	for (i=0; i<MAXTRADEITEM; ++i)
	{
		sg->BuyPrice[i] = BuyPrice[i];
		sg->SellPrice[i] = SellPrice[i];
	}
	for (i=0; i<MAXSHIPTYPE; ++i)
		sg->ShipPrice[i] = ShipPrice[i];
	//sg->musicEnabled = musicEnabled;
   	sg.GalacticChartSystem = galacticChartSystem;
	sg.PoliceKills = policeKills;
	sg.TraderKills = traderKills;
	sg.PirateKills = pirateKills;
	sg.PoliceRecordScore = policeRecordScore;
	sg.ReputationScore = reputationScore;
	sg.AutoFuel = autoFuel;
	sg.AutoRepair = autoRepair;
	sg.Clicks = clicks;
	sg.EncounterType = encounterType;
	sg.Raided = raided;
	sg.MonsterStatus = monsterStatus;
	sg.DragonflyStatus = dragonflyStatus;
	sg.JaporiDiseaseStatus = japoriDiseaseStatus;
	sg.MoonBought = moonBought;
	sg.MonsterHull = monsterHull;
	maxLength=NAMELEN+1;
	pilotName( getCString(sg.NameCommander ,maxLength, encoding);
//	sg->CurForm = CurForm;
	memmove(sg.Ship),Ship, sizeof( sg.Ship ) );
	
	
	memmove( &(sg->Opponent), &Opponent, sizeof( sg->Opponent ) );
	for (i=0; i<MAXCREWMEMBER+1; ++i)
		memmove( &(sg->Mercenary[i]), &Mercenary[i], sizeof( sg->Mercenary[i] ) );
	for (i=0; i<MAXSOLARSYSTEM; ++i)
		memmove( &(sg->SolarSystem[i]), &SolarSystem[i], sizeof( sg->SolarSystem[i] ) );
	for (i=0; i<MAXFORFUTUREUSE; ++i)
		sg->ForFutureUse[i] = 0;
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
	// changed from 3 to 4. SjG
	sg->VersionMinor = 4;
	for (i=0; i<MAXWORMHOLE; ++i)
		sg->Wormhole[i] = Wormhole[i];
	for (i=0; i<MAXTRADEITEM; ++i)
		sg->BuyingPrice[i] = BuyingPrice[i];
	sg->ArtifactOnBoard = artifactOnBoard;
	sg->ReserveMoney = reserveMoney;
//	sg->PriceDifferences = priceDifferences;
//	sg->APLscreen = APLscreen;
	sg->TribbleMessage = tribbleMessage;
	sg->AlwaysInfo = alwaysInfo;
	sg->LeaveEmpty = leaveEmpty;
	sg->TextualEncounters = textualEncounters;
	sg->JarekStatus = jarekStatus;
	sg->InvasionStatus = invasionStatus;
	sg->Continuous = continuous;
//	sg->AttackFleeing = attackFleeing;
	sg->ExperimentStatus =experimentStatus;
	sg->WildStatus = wildStatus;
	sg->FabricRipProbability = fabricRipProbability;
	sg->VeryRareEncounter = veryRareEncounter;
	sg->newsAutoPay = newsAutoPay;
	sg->showTrackedRange = showTrackedRange;
	sg->justLootedMarie = justLootedMarie;
	sg->arrivedViaWormhole = arrivedViaWormhole;
	sg->trackAutoOff = trackAutoOff;
	sg->remindLoans = remindLoans;
	sg->canSuperWarp = canSuperWarp;
    sg->ReactorStatus = reactorStatus;
    sg->TrackedSystem = trackedSystem;
    sg->ScarabStatus = scarabStatus;
 	sg->AlwaysIgnoreTradeInOrbit = alwaysIgnoreTradeInOrbit;
	sg->AlreadyPaidForNewspaper = alreadyPaidForNewspaper;
	sg->GameLoaded = gameLoaded;
//	sg->SharePreferences = sharePreferences;
//	sg->IdentifyStartup = identifyStartup;
//	sg->Shortcut1 = Shortcut1;
//	sg->Shortcut2 = Shortcut2;
//	sg->Shortcut3 = Shortcut3;
//	sg->Shortcut4 = Shortcut4;
	
	
	
	
	data = [[NSData alloc] initWithBytes:&saveGame length:(NSUInteger)sizeof(saveGame) ];
	[data writeToFile:fileName atomically:FALSE];		
		
}

public String convertDateLocaleString(Date date)
{
	return null;/*
	[NSDateFormatter setDefaultFormatterBehavior:NSDateFormatterBehavior10_4];
	NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
	[dateFormatter setDateStyle:NSDateFormatterShortStyle];
	[dateFormatter setTimeStyle:NSDateFormatterMediumStyle];
	NSString *dateStr = [dateFormatter stringFromDate:theDate];
	[dateFormatter release];
	return dateStr;
}

public void LoadBinaryData(String name,  String time )
{
	
	/*NSArray *filePaths =	NSSearchPathForDirectoriesInDomains (																 
																 NSDocumentDirectory, 
																 NSUserDomainMask,
																 YES
																 ); 
	
	NSString* recordingDirectory = [filePaths objectAtIndex: 0];
	
	NSString* fileName = [NSString stringWithFormat:@"%@/%@.save", recordingDirectory, name];
	
	NSData* data;
	data =[[NSData alloc] initWithContentsOfFile:fileName];

	memcpy(sg, [data bytes], [data length]);
	[data dealloc];
	
	if (time != nil) {
		NSFileManager *fileManager = [NSFileManager defaultManager];		
		NSDictionary *fsAttributes =
        [fileManager fileAttributesAtPath:fileName traverseLink:NO];
		//*time = [[fsAttributes objectForKey:NSFileModificationDate] retain];
		*time = [self convertDateLocaleString:[fsAttributes objectForKey:NSFileModificationDate]];
		
		
	}
	
}


public void LoadGame(char name)
{
	/*
	SAVEGAMETYPE   saveGame, * sg = &saveGame;
	[self LoadBinaryData:name time:nil data:&saveGame];
	// restore all members frm save game
	int i;
	currentSystem = sg->CurrentSystem;
	credits = sg->Credits;
	debt = sg->Debt;
	days = sg->Days;
	warpSystem = sg->WarpSystem;
	pilotSkill = sg->PilotSkill;
	fighterSkill = sg->FighterSkill;
	traderSkill = sg->TraderSkill;
	engineerSkill = sg->EngineerSkill;
	
	//	sg->SelectedShipType = selectedShipType;
	for (i=0; i<MAXTRADEITEM; ++i)
	{
		BuyPrice[i] = sg->BuyPrice[i];
		SellPrice[i] = sg->SellPrice[i];
	}
	for (i=0; i<MAXSHIPTYPE; ++i)
		ShipPrice[i] = sg->ShipPrice[i];
	//musicEnabled = sg->musicEnabled;
	galacticChartSystem= sg->GalacticChartSystem ;
	policeKills = sg->PoliceKills;
	traderKills = sg->TraderKills;
	pirateKills = sg->PirateKills;
	policeRecordScore = sg->PoliceRecordScore;
	reputationScore = sg->ReputationScore;
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
	pilotName = [[NSString stringWithCString:sg->NameCommander length:strlen(sg->NameCommander)] retain];	//	sg->CurForm = CurForm;
	memmove(&ship, &(sg->Ship),  sizeof( sg->Ship ) );
	
	
	memmove( &Opponent,&(sg->Opponent),  sizeof( sg->Opponent ) );
	for (i=0; i<MAXCREWMEMBER+1; ++i)
		memmove(&Mercenary[i], &(sg->Mercenary[i]),  sizeof( sg->Mercenary[i] ) );
	for (i=0; i<MAXSOLARSYSTEM; ++i)
		memmove(&SolarSystem[i], &(sg->SolarSystem[i]),  sizeof( sg->SolarSystem[i] ) );
	
//	for (i=0; i<MAXFORFUTUREUSE; ++i)
//		sg->ForFutureUse[i] = 0;
	escapePod = sg->EscapePod;
	insurance= sg->Insurance ;
	noClaim = sg->NoClaim;
	inspected = sg->Inspected;
	litterWarning = sg->LitterWarning;
	alwaysIgnoreTraders = sg->AlwaysIgnoreTraders;
	alwaysIgnorePolice = sg->AlwaysIgnorePolice;
	alwaysIgnorePirates = sg->AlwaysIgnorePirates;
	gameDifficulty = sg->Difficulty;
//	sg->VersionMajor = 1;
	// changed from 3 to 4. SjG
//	sg->VersionMinor = 4;
	for (i=0; i<MAXWORMHOLE; ++i)
		Wormhole[i] = sg->Wormhole[i];
	for (i=0; i<MAXTRADEITEM; ++i)
		BuyingPrice[i] = sg->BuyingPrice[i];
	artifactOnBoard = sg->ArtifactOnBoard;
	reserveMoney = sg->ReserveMoney;
	//	sg->PriceDifferences = priceDifferences;
	//	sg->APLscreen = APLscreen;
	tribbleMessage = sg->TribbleMessage;
	alwaysInfo = sg->AlwaysInfo;
	leaveEmpty = sg->LeaveEmpty;
	textualEncounters = sg->TextualEncounters;
	jarekStatus = sg->JarekStatus;
	invasionStatus = sg->InvasionStatus;
	continuous = sg->Continuous;
	//	sg->AttackFleeing = attackFleeing;
	experimentStatus = sg->ExperimentStatus;
	wildStatus = sg->WildStatus;
	fabricRipProbability = sg->FabricRipProbability;
	veryRareEncounter = sg->VeryRareEncounter;
	newsAutoPay = sg->newsAutoPay;
	showTrackedRange = sg->showTrackedRange;
	justLootedMarie = sg->justLootedMarie;
	arrivedViaWormhole = sg->arrivedViaWormhole;
	trackAutoOff = sg->trackAutoOff;
	remindLoans = sg->remindLoans;
	canSuperWarp = sg->canSuperWarp;
    reactorStatus = sg->ReactorStatus;
    trackedSystem = sg->TrackedSystem;
    scarabStatus = sg->ScarabStatus;
 	alwaysIgnoreTradeInOrbit = sg->AlwaysIgnoreTradeInOrbit;
	alreadyPaidForNewspaper = sg->AlreadyPaidForNewspaper;
	gameLoaded = sg->GameLoaded ;	
	
	
	
	S1AppDelegate * app = (S1AppDelegate *)[[UIApplication sharedApplication] delegate];
	[app switchBarToGame];
	[app commandCommand];
	[self updateMercenary0Data];
//	if (musicEnabled)
//		[self playMusic];
	
	//[self showJettisonForm];

		
}
/*
-(void)ShowSaveGames:(NSMutableArray*)array name:(NSMutableArray*)name additional:(NSMutableArray*)additional
{
	
	NSArray *filePaths =	NSSearchPathForDirectoriesInDomains (
																 
																 NSDocumentDirectory, 
																 NSUserDomainMask,
																 YES
																 ); 
	
	NSString* recordingDirectory = [filePaths objectAtIndex: 0];
	
	NSDirectoryEnumerator *direnum = [[NSFileManager defaultManager]
									  enumeratorAtPath:recordingDirectory];
	NSString *pname;
	while (pname = [direnum nextObject])
	{
		if ([[pname pathExtension] isEqualToString:@"rtfd"])
		{
			/* don’t enumerate this directory 
			[direnum skipDescendents];
		}
		else
		{
			if ([[pname pathExtension] isEqualToString:@"save"]) {
				NSString * nameFile = [[pname stringByDeletingPathExtension] retain]; 
				[array addObject:nameFile];
				SAVEGAMETYPE save;
				NSString * time;
				[self LoadBinaryData:nameFile time:&time data:&save ];

				[name addObject:[[NSString stringWithFormat:@"%@ (%@)", [NSString stringWithCString:save.NameCommander], nameFile] retain]];
				[nameFile release];
				[additional addObject:[[NSString stringWithFormat:@"Time:%@\n System:%@ Credits:%i", time, [self getSolarSystemName:save.CurrentSystem], save.Credits] retain ]];				
			}
			...process file here... 
		}
	}	
}

public long getShipShield()

{
	return TotalShieldStrength(Ship);
}

public long getShipOpponentShield()
{
	return TotalShieldStrength(Opponent);
}

public long getShipShieldMax()
{
	return TotalShields(Ship);
}
public long TotalShields(SHIP Sh) 
{
	int i;
	long j;
	
	j = 0;
	for (i=0; i<MAXSHIELD; ++i)
	{
		if (Sh.Shield[i] < 0)
			break;
		j += Shieldtype[Sh.Shield[i]].Power;
	}
	
	return j;
}

public long getShipOpponentShieldMax()
{
	return TotalShields(Opponent);
}

public long getShipHullMax()
{
	return  GetHullStrength();
}

public long getShipOpponentHullMax()
{
	return s[Opponent.Type].HullStrength;
}

public boolean IsNewsExist()
{
	alreadyPaidForNewspaper = false;
	if (SolarSystem[currentSystem].Special > -1)
	{
		if (SolarSystem[currentSystem].Special == MONSTERKILLED && monsterStatus == 2)
		{
			//[self addNewsEvent:MONSTERKILLED];
		}
		else if (SolarSystem[currentSystem].Special == DRAGONFLY)
		{
			//[self addNewsEvent:DRAGONFLY];
		}
		else if (SolarSystem[currentSystem].Special == SCARAB)
		{
			// [self addNewsEvent:SCARAB];
		}
		else if (SolarSystem[currentSystem].Special == SCARABDESTROYED && scarabStatus == 2)
		{
		//	 [self addNewsEvent:SCARABDESTROYED];
		}
		else if (SolarSystem[currentSystem].Special == FLYBARATAS && dragonflyStatus == 1)
		{
		//	 [self addNewsEvent:FLYBARATAS];
		}
			 else if (SolarSystem[currentSystem].Special == FLYMELINA && dragonflyStatus == 2)
			 {
			//	 [self addNewsEvent:FLYMELINA];
			 }
		else if (SolarSystem[currentSystem].Special == FLYREGULAS && dragonflyStatus == 3)
		{
			 //[self addNewsEvent:FLYREGULAS];
		}
		else if (SolarSystem[currentSystem].Special == DRAGONFLYDESTROYED && dragonflyStatus == 5)
		{ 
			//[self addNewsEvent:DRAGONFLYDESTROYED];
		}
			else if (SolarSystem[currentSystem].Special == MEDICINEDELIVERY && japoriDiseaseStatus == 1)
			{
				//[self addNewsEvent:MEDICINEDELIVERY];
			}
				else if (SolarSystem[currentSystem].Special == ARTIFACTDELIVERY && artifactOnBoard)
				{
				//	[self addNewsEvent:ARTIFACTDELIVERY];
				}
		else if (SolarSystem[currentSystem].Special == JAPORIDISEASE && japoriDiseaseStatus == 0)
		{
		//	[self addNewsEvent:JAPORIDISEASE];
		}
		else if (SolarSystem[currentSystem].Special == JAREKGETSOUT && jarekStatus == 1)
		{
		//	 [self addNewsEvent:JAREKGETSOUT];
		}
		else if (SolarSystem[currentSystem].Special == WILDGETSOUT && wildStatus == 1)
		{
			// [self addNewsEvent:WILDGETSOUT];
		}
		else if (SolarSystem[currentSystem].Special == GEMULONRESCUED && invasionStatus > 0 && invasionStatus < 8)
		{ 
			//[self addNewsEvent:GEMULONRESCUED];
		}
		else if (SolarSystem[currentSystem].Special == ALIENINVASION)
		{
		//	 [self addNewsEvent:ALIENINVASION];
		}
		else if (SolarSystem[currentSystem].Special == EXPERIMENTSTOPPED && experimentStatus > 0 && experimentStatus < 12) {
			{
			experimentStatus = 13;
			
			// [self addNewsEvent:EXPERIMENTSTOPPED];
			}
		}
		else if (SolarSystem[currentSystem].Special == EXPERIMENTNOTSTOPPED)
		{ 
			//[self addNewsEvent:EXPERIMENTNOTSTOPPED];
		}
	}

	return true;
}
			
public void payForNewsPaper(int sum)
{
	sum = gameDifficulty + 1;
	credits -= sum;
	alreadyPaidForNewspaper = true;
}

			
public boolean IsHireExist()
{
		
	
	
	return  GetForHire() >= 0;
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

/*
-(void)playMusic
{
	
	[self LoadBinaryOptions:@"options"];
	
//	options.musicEnabled = 0;
	
	NSString* songFile1 = [[NSBundle mainBundle] pathForResource:[NSString stringWithCString:"Resonance"] ofType:@"m4a"];
	
	//audioPlayer = nil;
	
	if (audioPlayerReleased && options.musicEnabled == 1) {
		
		// before instantiating the playback audio queue object, 
		//        set the audio session category
		UInt32 sessionCategory = kAudioSessionCategory_MediaPlayback;
		AudioSessionSetProperty (
								 kAudioSessionProperty_AudioCategory,
								 sizeof (sessionCategory),
								 &sessionCategory
								 );
		audioPlayerReleased = false;
		
		audioPlayer = [[AudioPlayer alloc] initWithURL: [NSURL fileURLWithPath: songFile1]];
		
		if (audioPlayer) {
			[audioPlayer setNotificationDelegate: self];        // sets up the playback object to receive property change notifications from the playback audio queue object
			
			// activate the audio session immmediately before playback starts
			AudioSessionSetActive (true);
			NSLog (@"sending play message to play object.");
			[audioPlayer play];
		}
	}
	
}

-(void)stopMusic
{
	if (!audioPlayerReleased) {
		[audioPlayer stop];
		[audioPlayer release];	
		audioPlayerReleased = true;
		//audioPlayer = 0;
	}
}

-(void)startStopMusic: (NSTimer *) timer {
	
	//[timer release];
	[self stopMusic];
	[self playMusic];
}


-(void)restartMusic {
	/*NSTimer * timer = [NSTimer scheduledTimerWithTimeInterval:	1.0		// seconds
														  target:		self
													 selector:	@selector (startStopMusic:)
														userInfo:	0		// makes the currently-active audio queue (record or playback) available to the updateBargraph method
														 repeats:	NO];	
//	[timer release];
}

-(void)disableMusic
{
	options.musicEnabled = 0;
	[self SaveOptions:@"options"];
	[self stopMusic];
}

-(void)enableMusic
{
	options.musicEnabled = 1;
	[self SaveOptions:@"options"];
	[self playMusic];
}
-(void)disableSound {
	options.soundEnabled = 0;
	[self SaveOptions:@"options"];

}

public void enableSound()
{
	options.soundEnabled = 1;
	[self SaveOptions:@"options"];

}

public boolean isSoundEnabled()
{
	return options.soundEnabled  == 1;
}

/*
 enum eSystemSound 
 {
 eAlienEncounter,
 eAlienReturnArtifact,
 eBeginGame,
 eBottleEncounter,
 eBuyInsurance,
 eBuyNewShip,
 eBuyShipUpgardes,
 eCantSelectAnything,
 eFireMercenary,
 eFireOpponent,
 eGetGas,
 eGetLoan,
 eHirMercenary,
 ePoliceEncounter,
 eTribble,
 eWormholeJump,
 eYouAreDestroyed,
 eYouLose,
 eYouRetirelavishly,
 eYouRetirePoorly
 };	
 
 
NSString * SoundsList[] = {
@"alien_encounter",
@"alien_return_artifact",
@"begin_game_welcome_aboard_captain",
@"bottle_encounter",
@"buy_insurance",
@"buy_new_ship",
@"buy_ship_upgrades",
@"cant_select_anything",
@"fire_mercenary",
@"fire_on_opponent",
@"get_gas",
@"get_loan",
@"hire_mercenary",
@"police_encounter",
@"st_tribble",
@"wormhole_jump",
@"you_are_destroyed",
@"you_lose",
@"you_retire_lavishly",
@"you_retire_poorly"
};

-(void) initSounds
{
	for (int i =0; i < 19; ++i)
	{
		id sndpath = [[NSBundle mainBundle] pathForResource:SoundsList[i] ofType:@"caf" inDirectory:@"/"];
		CFURLRef baseURL = (CFURLRef)[[NSURL alloc] initFileURLWithPath:sndpath];
		AudioServicesCreateSystemSoundID (baseURL, &sound[i]);				
	}
	sound[19] = kSystemSoundID_Vibrate;

}

-(void)playSound:(enum eSystemSound)soundType
{
	if (options.soundEnabled)
	AudioServicesPlaySystemSound (sound[(int)soundType]);
}

public String drawNewspaperForm()
{
    //Boolean shown[MAXSTORIES];
    Boolean realNews = false;
	NSMutableString* headLine = [[[NSMutableString alloc] init] retain];
	/*
	i = warpSystem % MAXMASTHEADS;
	SysStringByIndex(AnarchyMastheadsStringList + SolarSystem[currentSystem].Politics * 100,i,SBuf2,50);
	if (StrNCompare(SBuf2,"*",1) == 0)
	{
		StrCopy(SBuf,"The ");
		StrCat(SBuf, SolarSystemName[SolarSystem[currentSystem].NameIndex]);
		StrCat(SBuf, SBuf2 + 1);
		//DrawCharsCentered(SBuf, line, true);
		setCurrentWinTitle(SBuf);
		
	}
	else if (StrNCompare(SBuf2,"+",1) == 0)
	{
		StrCopy(SBuf, SolarSystemName[SolarSystem[currentSystem].NameIndex]);
		StrCat(SBuf, SBuf2 + 1);
		//DrawCharsCentered(SBuf, line, true);
		setCurrentWinTitle(SBuf);
		
	}
	else
	{
		//DrawCharsCentered(SBuf2, line, true);
		setCurrentWinTitle(SBuf2);
	}
	 
	
	RandSeed( warpSystem, days );
	
	// Special Events get to go first, crowding out other news
	if  ([self isNewsEvent:CAPTAINHUIEATTACKED])
	{
		[headLine appendString:@"Famed Captain Huie Attacked by Brigand!\n"];
	}
	if  ([self isNewsEvent:EXPERIMENTPERFORMED])
	{
		[headLine appendString:@"Travelers Report Timespace Damage, Warp Problems!\n"];
	}
	if  ([self isNewsEvent:CAPTAINHUIEDESTROYED])
	{
		[headLine appendString:@"Citizens Mourn Destruction of Captain Huie's Ship!\n"];
	}
	if  ([self isNewsEvent:CAPTAINAHABATTACKED])
	{
		[headLine appendString:@"Thug Assaults Captain Ahab!\n"];
	}
	if  ([self isNewsEvent:CAPTAINAHABDESTROYED])
	{
		[headLine appendString:@"Destruction of Captain Ahab's Ship Causes Anger!\n"];
	}
	if  ([self isNewsEvent:CAPTAINCONRADATTACKED])
	{
		[headLine appendString:@"Captain Conrad Comes Under Attack By Criminal!\n"];
	}
	if  ([self isNewsEvent:CAPTAINCONRADDESTROYED])
	{
		[headLine appendString:@"Captain Conrad's Ship Destroyed by Villain!\n"];
	}
	if  ([self isNewsEvent:MONSTERKILLED])
	{
		[headLine appendString:@"Hero Slays Space Monster! Parade, Honors Planned for Today.\n"];
	}
	if  ([self isNewsEvent:WILDARRESTED])
	{
		[headLine appendString:@"Notorious Criminal Jonathan Wild Arrested!\n"];
	}
	if  (SolarSystem[currentSystem].Special == MONSTERKILLED &&  monsterStatus == 1)
	{
		[headLine appendString:@"Space Monster Threatens Homeworld!\n"];
	}
	if  (SolarSystem[currentSystem].Special == SCARABDESTROYED &&  scarabStatus == 1)
	{
		[headLine appendString:@"Wormhole Travelers Harassed by Unusual Ship!\n"];
	}
	if ([self isNewsEvent:EXPERIMENTSTOPPED])
	{
		[headLine appendString:@"Scientists Cancel High-profile Test! Committee to Investigate Design.\n"];
	}
	if ([self isNewsEvent:EXPERIMENTNOTSTOPPED])
	{
		[headLine appendString:@"Huge Explosion Reported at Research Facility.\n"];
	}
	if ([self isNewsEvent:DRAGONFLY])
	{
		[headLine appendString:@"Experimental Craft Stolen! Critics Demand Security Review.\n"];
	}
	if ([self isNewsEvent:SCARAB])
	{
		[headLine appendString:@"Security Scandal: Test Craft Confirmed Stolen.\n"];
	}
	if ([self isNewsEvent:FLYBARATAS])
	{
		[headLine appendString:@"Investigators Report Strange Craft.\n"];
	}
	if ([self isNewsEvent:FLYMELINA])
	{
		[headLine appendString:@"Rumors Continue: Melina Orbitted by Odd Starcraft.\n"];
	}
	if ([self isNewsEvent:FLYREGULAS])
	{
		[headLine appendString:@"Strange Ship Observed in Regulas Orbit.\n"];
	}
	if (SolarSystem[currentSystem].Special == DRAGONFLYDESTROYED && dragonflyStatus == 4 &&
	    ![self isNewsEvent:DRAGONFLYDESTROYED])
	{
		[headLine appendString:@"Unidentified Ship: A Threat to Zalkon?\n"];
	}
	if ([self isNewsEvent:DRAGONFLYDESTROYED])
	{
		[headLine appendString:@"Spectacular Display as Stolen Ship Destroyed in Fierce Space Battle.\n"];
	}
	if ([self isNewsEvent:SCARABDESTROYED])
	{
		[headLine appendString:@"Wormhole Traffic Delayed as Stolen Craft Destroyed.\n"];
	}
	if ([self isNewsEvent:MEDICINEDELIVERY])
	{
		[headLine appendString:@"Disease Antidotes Arrive! Health Officials Optimistic.\n"];
	}
	if ([self isNewsEvent:JAPORIDISEASE])
	{
		[headLine appendString:@"Editorial: We Must Help Japori!\n"];
	}
	if ([self isNewsEvent:ARTIFACTDELIVERY])
	{
		[headLine appendString:@"Scientist Adds Alien Artifact to Museum Collection.\n"];
	}
	if ([self isNewsEvent:JAREKGETSOUT])
	{
		[headLine appendString:@"Ambassador Jarek Returns from Crisis.\n"];
	} 
	if ([self isNewsEvent:WILDGETSOUT])
	{
		[headLine appendString:@"Rumors Suggest Known Criminal J. Wild May Come to Kravat!\n"];
	} 
	if ([self isNewsEvent:GEMULONRESCUED])
	{
		[headLine appendString:@"Invasion Imminent! Plans in Place to Repel Hostile Invaders.\n"];
	}
	if (SolarSystem[currentSystem].Special == GEMULONRESCUED && ![self isNewsEvent:GEMULONRESCUED])
	{
		[headLine appendString:@"Alien Invasion Devastates Planet!\n"];
	}
	if ([self isNewsEvent:ALIENINVASION])
	{
		[headLine appendString:@"Editorial: Who Will Warn Gemulon?\n"];
	}
	if ([self isNewsEvent:ARRIVALVIASINGULARITY])
	{
		[headLine appendString:@"Travelers Claim Sighting of Ship Materializing in Orbit!\n"];
	}
	
	
	// local system status information
	if (SolarSystem[currentSystem].Status > 0)
	{
		switch (SolarSystem[currentSystem].Status)
		{
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
	
	// character-specific news.
	if (policeRecordScore <= VILLAINSCORE)
	{
		int j = GetRandom2(4);
		switch (j)
		{
			case 0:
				[headLine appendString:[NSString stringWithFormat:@"Police Warning: %@ Will Dock At %@!\n", pilotName, [self getSolarSystemName:SolarSystem[currentSystem].NameIndex]]];
				break;
			case 1:
				[headLine appendString:[NSString stringWithFormat:@"Notorious Criminal %@ Sighted in %@!\n", pilotName, [self getSolarSystemName:SolarSystem[currentSystem].NameIndex]]];
					break;
			case 2:
				[headLine appendString:[NSString stringWithFormat:@"Locals Rally to Deny Spaceport Access to %@!\n", pilotName]];


				break;
			case 3:
				[headLine appendString:[NSString stringWithFormat:@"Terror Strikes Locals on Arrival of %@!\n", pilotName]];

				break;
		}
	}
	
	if (policeRecordScore == HEROSCORE)
	{
		int j = GetRandom2(3);
		switch (j)
		{
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
	
	// caught littering?
	if  ([self isNewsEvent:CAUGHTLITTERING])
	{
		[headLine appendString:[NSString stringWithFormat:@"Police Trace Orbiting Space Litter to %@!\n", pilotName]];		

	}
	
	
	// and now, finally, useful news (if any)
	// base probability of a story showing up is (50 / MAXTECHLEVEL) * Current Tech Level
	// This is then modified by adding 10% for every level of play less than Impossible
	for (int i=0; i < MAXSOLARSYSTEM; i++)
	{
		if (i != currentSystem &&
		    (([self realDistance:currentSystem b:i] <= s[Ship.Type].FuelTanks)
			 ||
			[self wormholeExists:currentSystem b:i])
		    &&
		    SolarSystem[i].Status > 0)
		    
		{
			// Special stories that always get shown: moon, millionaire
			if (SolarSystem[i].Special == MOONFORSALE)
			{
				[headLine appendString:[NSString stringWithFormat:@"Seller in %@ System has Utopian Moon available.\n", [self getSolarSystemName:i]]];				

			}
			if (SolarSystem[i].Special == BUYTRIBBLE)
			{
				[headLine appendString:[NSString stringWithFormat:@"Collector in %@ System seeks to purchase Tribbles.\n", [self getSolarSystemName:i]]];						
			}
			
			// And not-always-shown stories
			if (GetRandom2(100) <= STORYPROBABILITY * SolarSystem[currentSystem].TechLevel + 10 * (5 - gameDifficulty))
			{
				int j = GetRandom2(6);
				switch (j)
				{
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

				switch (SolarSystem[i].Status)
				{
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
				realNews = true;
			}
		}
	}
	
	// if there's no useful news, we throw up at least one
	// headline from our canned news list.
	//int count = 0 ;
	if (! realNews)
	{
		[headLine appendString:[NSString stringWithFormat:@"No news in the %@ System.\n ", [self getSolarSystemName:currentSystem]]];
		
	}
	/*
		for (int i=0; i< MAXSTORIES; i++)
		{
			shown[i]= false;
		}
		for (int i=0; i <=GetRandom2(MAXSTORIES); i++)
		{
			int j = GetRandom2(MAXSTORIES);
			if (!shown[j] && line <= 150) 
			{
				SysStringByIndex(AnarchyHeadlinesStringList + SolarSystem[currentSystem].Politics * 100,j,SBuf,63);
				[headLine appendString:@SBuf;
				shown[j] = true;
			}
		}
	}
	
	
	return headLine;
}
*/

public void showSpecialEvent()
{
	/*
	String title = ( stringWithCString(SpecialEvent(SolarSystem(currentSystem).Special).Title);
	String  text =( stringWithCString:SpecialEvent(SolarSystem(currentSystem).Special.QuestStringID), @"")	;

	AlertModalWindow * myAlertView;
	if (SpecialEvent[SolarSystem[currentSystem].Special].JustAMessage)
	{
		myAlertView = [[UIAlertView alloc] initWithTitle:title message:
										  text delegate:self cancelButtonTitle:nil otherButtonTitles:@"Ok",nil];	
		
	} else 
	{
		myAlertView = [[UIAlertView alloc] initWithTitle:title  message:
					   text delegate:self cancelButtonTitle:@"No" otherButtonTitles:@"Yes",nil];	
				
	}
	
	bLastMessage = false;
	[myAlertView show];
	[myAlertView release];		
	currentState = eSpecialEvent;
	
}

// *************************************************************************
// After erasure of police record, selling prices must be recalculated
// *************************************************************************
public void RecalculateSellPrices()
{
	int i;
	
	for (i=0; i<MAXTRADEITEM; ++i)
		SellPrice[i] = (SellPrice[i] * 100) / 90;
}

// *************************************************************************
// NthLowest Skill. Returns skill with the nth lowest score
// (i.e., 2 is the second worst skill). If there is a tie, it will return
// in the order of Pilot, Fighter, Trader, Engineer.
// *************************************************************************
public int PILOTSKILL		=1;
public int FIGHTERSKILL	=2;
public int TRADERSKILL		=3;
public int ENGINEERSKILL	=4;

public int NthLowestSkill(SHIP Sh,  int n) 
{   
	int i = 0, lower = 1, retVal=0;
	boolean looping = true;
	while (looping)
	{
		retVal = 0;
		if (Mercenary[Sh.Crew[0]].Pilot == i)
		{
			if (lower == n)
			{
				looping = false;
				retVal = PILOTSKILL;
			}
			
			lower++;
		}
		if (Mercenary[Sh.Crew[0]].Fighter == i)
		{
			if (lower == n)
			{
				looping = false;
				retVal = FIGHTERSKILL;
			}
			
			lower++;
		}
		if (Mercenary[Sh.Crew[0]].Trader == i)
		{
			if (lower == n)
			{
				looping = false;
				retVal = TRADERSKILL;
			}
			
			lower++;
		}
		if (Mercenary[Sh.Crew[0]].Engineer == i)
		{
			if (lower == n)
			{
				looping = false;
				retVal = ENGINEERSKILL;
			}
			
			lower++;
		}
		i++;
	}
	return retVal;
}

SPECIALEVENT SpecialEvent[] = new SPECIALEVENT[MAXSPECIALEVENT];
public int FirstEmptySlot;
public void specialEventFormHandleEvent()
{
	
	Boolean handled = false;
	int i;
	
	
	if ( toSpend() < SpecialEvent[SolarSystem[currentSystem].Special].Price)
	{
		 FrmAlert("NotEnoughForEventAlert");
		handled = true;
	//	[systemInfoController UpdateView];
		return;
	}
	
	credits -= SpecialEvent[SolarSystem[currentSystem].Special].Price;
	/*
	switch (SolarSystem[currentSystem].Special)
	{
			
		case GETREACTOR:
			//currentState = eUpdateSpecial;
			if (filledCargoBays() > totalCargoBays() - 15)
			{
				 FrmAlert("NotEnoughBaysAlert");
				handled = true;
				break;
			}
			else if (wildStatus == 1)
			{
	//			if (FrmCustomAlert(WildWontStayOnboardAlert, SolarSystemName[SolarSystem[currentSystem].NameIndex],
	//							   NULL, NULL) == WildWontStayOnboardSayGoodbyetoWild)
	//			{
					wildStatus = 0;
			//	FrmAlert("WildLeavesShipAlert");
					//FrmCustomAlert( WildLeavesShipAlert,SolarSystemName[SolarSystem[currentSystem].NameIndex],
					//			   NULL, NULL);
	//			}
	//			else
	//			{
	//				handled = true;
	//				break;
	//			}
				
			}
		//	 FrmAlert("ReactorAlert");
			reactorStatus = 1;
			break;
			
		case REACTORDELIVERED:
			SolarSystem[currentSystem].Special = GETSPECIALLASER;
			reactorStatus = 21;
			handled = true;
		//	currentState = eUpdateSpecial;			
			break;	
			
		case MONSTERKILLED:
			if (monsterStatus == 2) {
				SolarSystem[currentSystem].Special = 0;
				monsterStatus = 0;
			}
		//	return;
			break;
			
		case SCARAB:
			scarabStatus = 1;
			break;
			
		case SCARABDESTROYED:
			scarabStatus = 2;
			SolarSystem[currentSystem].Special = GETHULLUPGRADED;
			handled = true;
			break;	
			
		case GETHULLUPGRADED:
			FrmAlert("HullUpgradeAlert");
			//  currentState = eUpdateSpecial;			
			Ship.Hull += UPGRADEDHULL;
			scarabStatus = 3;
			handled = true;
			break;	
			
		case EXPERIMENT:
			experimentStatus = 1;
			break;
			
		case EXPERIMENTSTOPPED:
			experimentStatus = 13;
			canSuperWarp = true;
			break;
			
		case EXPERIMENTNOTSTOPPED:
			break;
			
		case ARTIFACTDELIVERY:
			artifactOnBoard = false;
			break;
			
		case ALIENARTIFACT:
			artifactOnBoard = true;
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
			/*SolarSystem[currentSystem].SpecialSolarSystem[ZALKONSYSTEM].Special = INSTALLLIGHTNINGSHIELD;
		/*	handled = true;
			break;
			
		case GEMULONRESCUED:
			/*SolarSystem[currentSystem].SpecialSolarSystem[GEMULONSYSTEM].Special = GETFUELCOMPACTOR;
		/*	invasionStatus = 0;
			handled = true;
			break;
		
		case MEDICINEDELIVERY:
			japoriDiseaseStatus = 2;
			IncreaseRandomSkill();
			IncreaseRandomSkill();
			break;
			
		case MOONFORSALE:
			FrmAlert("BoughtMoonAlert");
			//  currentState = eUpdateSpecial;			
			moonBought = true;
			break;
			
		case MOONBOUGHT:
			// TODO:!!!
			//EraseRectangle( 0, 0, 160, 160 );
			//CurForm = UtopiaForm;
			//FrmGotoForm( UtopiaForm );
		//	[self showUtopiaWindow];
		//	return ;
			break;
			
		case SKILLINCREASE:
			FrmAlert("SkillIncreaseAlert");
			//  currentState = eUpdateSpecial;			
			 IncreaseRandomSkill();
			break;
			
		case TRIBBLE:
		//	[self FrmAlert:@"YouHaveATribbleAlert"];	
		//	//  currentState = eUpdateSpecial;			
			Ship.Tribbles = 1;
			break;
			
		case BUYTRIBBLE:
		//	[self FrmAlert:@"BeamOverTribblesAlert"];
		//	//  currentState = eUpdateSpecial;			
			credits += (Ship.Tribbles >> 1);
			Ship.Tribbles = 0;
			break;
			
		case ERASERECORD:
		//	[self FrmAlert:@"CleanRecordAlert"];
		//	//  currentState = eUpdateSpecial;			
			policeRecordScore = CLEANSCORE;
			 RecalculateSellPrices();
			break;
			
		case SPACEMONSTER:
			monsterStatus = 1;
			for (i=0; i<MAXSOLARSYSTEM; ++i)
				if (SolarSystem[i].Special == SPACEMONSTER)
					SolarSystem[i].Special = -1;
			break;
			
		case DRAGONFLY:
			dragonflyStatus = 1;
			for (i=0; i<MAXSOLARSYSTEM; ++i)
				if (SolarSystem[i].Special == DRAGONFLY)
					SolarSystem[i].Special = -1;
			break;
			
		case AMBASSADORJAREK:
			if (Ship.Crew[s[Ship.Type].CrewQuarters-1] >= 0)
			{
				//FrmCustomAlert( NoQuartersAvailableAlert, "Ambassador Jarek", NULL, NULL );
			//	[self FrmAlert:@"NoQuartersAvailableAlert"];
				////  currentState = eUpdateSpecial;				
				handled = true;
				break;
			}
			//FrmCustomAlert( PassengerTakenOnBoardAlert, "Ambassador Jarek", NULL, NULL );
	//		[self FrmAlert:@"PassengerTakenOnBoardAlert"];
		//	//  currentState = eUpdateSpecial;
			jarekStatus = 1;
			break;
			
		case TRANSPORTWILD:
			
			if (Ship.Crew[s[Ship.Type].CrewQuarters-1] >= 0)
			{
				//FrmCustomAlert( NoQuartersAvailableAlert, "Jonathan Wild", NULL, NULL );
		//		[self FrmAlert:@"NoQuartersAvailableAlert"];
			//	//  currentState = eUpdateSpecial;
				handled = true;
				break;
			}
	boolean 	exactCompare=false;
			if ( HasWeapon(Ship ,BEAMLASERWEAPON ,exactCompare))
				
			{
				//[self FrmAlert:@"WildWontGetAboardAlert"];
				////  currentState = eUpdateSpecial;
				handled = true;
				break;
			}
			if (reactorStatus > 0 && reactorStatus < 21)
			{
				//[self FrmAlert:@"WildAfraidOfReactorAlert"];
			//	//  currentState = eUpdateSpecial;
				handled = true;
				break;
			}
//			FrmCustomAlert( PassengerTakenOnBoardAlert, "Jonathan Wild", NULL, NULL );
			//[self FrmAlert:@"PassengerTakenOnBoardAlert"];
			////  currentState = eUpdateSpecial;
			wildStatus = 1;
			break;
			
			
		case ALIENINVASION:
			invasionStatus = 1;
			break;
			
		case JAREKGETSOUT:
			jarekStatus = 2;
	//		[self RecalculateBuyPrices:currentSystem];
			break;
			
		case WILDGETSOUT:
			wildStatus = 2;
			Mercenary[MAXCREWMEMBER-1].CurSystem = KRAVATSYSTEM;
			// Zeethibal has a 10 in player's lowest score, an 8
			// in the next lowest score, and 5 elsewhere.
			Mercenary[MAXCREWMEMBER-1].Pilot = 5;
			Mercenary[MAXCREWMEMBER-1].Fighter = 5;
			Mercenary[MAXCREWMEMBER-1].Trader = 5;
			Mercenary[MAXCREWMEMBER-1].Engineer = 5;
			int n=0;
			switch (n)///* NthLowestSkill:&ship n:1
	/*	{
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
			switch (n )//NthLowestSkill:&ship n:2]
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
	//		[self FrmAlert:@"SealedCannistersAlert"];
	//		//  currentState = eUpdateSpecial;
		//	i = GetRandom( MAXTRADEITEM );
			Ship.Cargo[i] += 3;
			BuyingPrice[i] += SpecialEvent[SolarSystem[currentSystem].Special].Price;
			break;
			
		case INSTALLLIGHTNINGSHIELD:
//			FirstEmptySlot = [self GetFirstEmptySlot:s[Ship.Type].ShieldSlots Item:Ship.Shield];
//			//  currentState = eUpdateSpecial;
			if (FirstEmptySlot < 0)
			{
	//			[self FrmAlert:@"NotEnoughSlotsAlert"];
				handled = true;
			}
			else
			{
	//			[self FrmAlert:@"LightningShieldAlert"];
				Ship.Shield[FirstEmptySlot] = LIGHTNINGSHIELD;
				Ship.ShieldStrength[FirstEmptySlot] = Shieldtype[LIGHTNINGSHIELD].Power;
			}
			break;
			
		case GETSPECIALLASER:
	//		FirstEmptySlot =[self  GetFirstEmptySlot:s[Ship.Type].WeaponSlots Item:Ship.Weapon ];
			if (FirstEmptySlot < 0)
			{
	//			[self FrmAlert:@"NotEnoughSlotsAlert"];
				handled = true;
			}
			else
			{
	//			[self FrmAlert:@"MorganLaserAlert"];
				Ship.Weapon[FirstEmptySlot] = MORGANLASERWEAPON;
			}
			//  currentState = eUpdateSpecial;
			break;
			
		case GETFUELCOMPACTOR:
			//  currentState = eUpdateSpecial;
		//	FirstEmptySlot = [self GetFirstEmptySlot:s[Ship.Type].GadgetSlots Item:Ship.Gadget];
			if (FirstEmptySlot < 0)
			{
		//	[self FrmAlert:@"NotEnoughSlotsAlert"];
				handled = true;
			}
			else
			{
		//		[self FrmAlert:@"FuelCompactorAlert"];
				Ship.Gadget[FirstEmptySlot] = FUELCOMPACTOR;
		//		Ship.Fuel = [self GetFuelTanks];
			}
			break;
			
		case JAPORIDISEASE:
			//  currentState = eUpdateSpecial;
			if (filledCargoBays() >  totalCargoBays() - 10)
			{
				//[self FrmAlert:@"NotEnoughBaysAlert"];
				handled = true;
			}
			else
			{
	//			[self FrmAlert:@"AntidoteAlert"];
				japoriDiseaseStatus = 1;
			}
			break;
			
	}
	if (!handled)				
		SolarSystem[currentSystem].Special = -1;
	
	//[systemInfoController UpdateView];	
//	return handled;
}

// *************************************************************************
// Calculate the score
// *************************************************************************
public int  KILLED =0;
public int  RETIRED =1;
public int  MOON =2;


public long GetScore( int EndStatus, int Days, long Worth, int Level )
{
	long d;
	
	Worth = (Worth < 1000000 ? Worth : 1000000 + ((Worth - 1000000) / 10) );
	
	if (EndStatus == KILLED)
		return (Level+1)*(long)((Worth * 90) / 50000);
	else if (EndStatus == RETIRED)
		return (Level+1)*(long)((Worth * 95) / 50000);
	else
	{
		d = ((Level+1)*100) - Days;
		if (d < 0)
			d = 0;
		return (Level+1)*(long)((Worth + (d * 1000)) / 500);
	}
} 

// *************************************************************************
// Initializing the high score table
// *************************************************************************
 void InitHighScores ()
{
 	int i;
 	
	for (i=0; i<MAXHIGHSCORE; ++i)
	{
		Hscores[i].Name[0] = "\0";
		Hscores[i].Status = 0;
		Hscores[i].Days = 0;
		Hscores[i].Worth =  0;
		Hscores[i].Difficulty = 0;
		Hscores[i].ForFutureUse = 0;
	}
}

public void clearHighScores() {
	InitHighScores();
}

String DifficultyLevel[] ={"Beginner","Easy","Normal","Hard","Impossible"};


public void fillHighScores(/*NSMutableArray array )
{
	 LoadBinaryHighScore("scores" );
	int i;
	long Percentage;
	
	for (i=0; i<MAXHIGHSCORE; ++i)
	{
		if (Hscores[i].Name[0] == "\0")
		{
			continue;
		}

		Percentage = GetScore( Hscores[i].Status, Hscores[i].Days, Hscores[i].Worth,
							  Hscores[i].Difficulty );

	//	NSString * type, *level= DifficultyLevel[Hscores[i].Difficulty];
	/*	if (Hscores[i].Status == MOON)
		{
		//	type ="Claimed moon";
		}
			else if (Hscores[i].Status == RETIRED)
			{
			type ="Retired";
			}
		else
			type="Was killed";

		
	//	[array addObject:[NSDictionary dictionaryWithObjectsAndKeys:
		//					 [NSString stringWithFormat:@"%@    Finished:%i.%i%%", [NSString stringWithCString:Hscores[i].Name], (Percentage / 50L), ((Percentage%50L) / 5)], @"title",
			//				 [NSString stringWithFormat:@"%@ in %i days, worth %i credits on %@ level", type, Hscores[i].Days, Hscores[i].Worth, level ], @"line",
				//			 nil]];	

	}
}
// *************************************************************************
// Handling of endgame: highscore table
// *************************************************************************
public int MAXHIGHSCORE=10;
HIGHSCORE Hscores[] = new HIGHSCORE[MAXHIGHSCORE];
public boolean EndOfGame( int EndStatus)
{
	int i, j;
	boolean Scored;
	long a, b;

	
	Scored = false;
	i = 0;
	while (i<MAXHIGHSCORE)
	{
		a = GetScore( EndStatus, days, currentWorth(), gameDifficulty );
		
		b =	GetScore( Hscores[i].Status, Hscores[i].Days, Hscores[i].Worth, Hscores[i].Difficulty);
		
		if ((a > b) || (a == b &&  currentWorth() > Hscores[i].Worth) ||
			(a == b &&  currentWorth() == Hscores[i].Worth && days > Hscores[i].Days) ||Hscores[i].Name[0] == "\0")
		{
			for (j=MAXHIGHSCORE-1; j>i; --j)
			{
				 Hscores[j].Name= Hscores[j-1].Name ;
				Hscores[j].Status = Hscores[j-1].Status;
				Hscores[j].Days = Hscores[j-1].Days;
				Hscores[j].Worth = Hscores[j-1].Worth;
				Hscores[j].Difficulty = Hscores[j-1].Difficulty;
			}
			int maxLength=NAMELEN+1;
		    // getCString(Hscores[i].Name, maxLength, encoding);

			Hscores[i].Status = EndStatus;
			Hscores[i].Days = days;
			Hscores[i].Worth = (int) currentWorth();
			Hscores[i].Difficulty = gameDifficulty;
	//		 SaveHighScore("scores");
			Scored = true;
			break;
		}
		
		++i;
	}
	
	long Percentage = GetScore( Hscores[i].Status, Hscores[i].Days, Hscores[i].Worth, Hscores[i].Difficulty );	
	//NSString * fs;
	if (Scored)
	{
	//	fs = "Congratulations! You have made the high-score list!";
	}
	else
	{
		
	}
	//	fs ="Alas! This is not enough to enter the high-score list.";
	//NSString * final = [NSString stringWithFormat:@"%@\nYou achieved a score of %i.%i%%.", fs,  (Percentage / 50L), ((Percentage%50L) / 5)];
	// FrmAlert(final);

	
	return Scored;
}
/*
public boolean isMusicEnabled()
{
//	return options[musicEnabled] != 0;
}

public void updateMercenaryData()
{
	
	Mercenary[0].Trader = traderSkill;
	Mercenary[0].Engineer = engineerSkill;
	Mercenary[0].Fighter = fighterSkill;
	Mercenary[0].Pilot = pilotSkill;
	

}


public int adaptPilotSkill()
{
	return PilotSkill(Ship);
	//	return pilotSkill;
}

public int adaptTraderSkill() {
	return TraderSkill(Ship);
//	return traderSkill;
}

public int adaptFighterSkill() {
	return FighterSkill(Ship);
//	return fighterSkill;
}

public int adaptEngineerSkill()
{
	return  EngineerSkill(Ship);
//	return engineerSkill;
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
	
	return  AdaptDifficulty(MaxSkill);
	
	
	//return traderSkill;
}





	/*Given By Harsh
	
	
	
	
public	int	pilotSkill;
public	int	fighterSkill;
public	int	traderSkill;
public	int	engineerSkill;
public	String	pilotName;
public	int	gameDifficulty;
public	int	totalSkillPoints;
public	int	credits;
public	int	debt;
public	int	policeRecordScore;
public	int	reputationScore;
public	int	policeKills;
public	int	traderKills;
public	int	pirateKills;
public	int  noClaim;
public	int  newsSpecialEventCount;
public	int	currentSystem;
public	int	days;	
	
public	int	solarSystemName,systemSize, techLevel;
public	boolean		insurance;
public	boolean		escapePod;
public	boolean		moonBought;
public	boolean		remindLoans;
public	boolean		artifactOnBoard;
public	boolean		tribbleMessage;
public	boolean		possibleToGoThroughRip;
public	boolean		arrivedViaWormhole;
public	int			trackedSystem;
public	boolean		showTrackedRange;
public	boolean		justLootedMarie;
public	int			chanceOfVeryRareEncounter;
public	boolean		alreadyPaidForNewspaper;
//	boolean		canSuperWarp;
public	boolean		gameLoaded;
public	int			monsterHull;
public	int			galacticChartSystem;
//	boolean		attackFleeing;
public	boolean		newsAutoPay;
public	int	warpSystem;
public	int leaveEmpty;
public	boolean reserveMoney;
public	boolean litterWarning;
public	boolean alwaysInfo;
public	int countDown;
public	int clicks;
public	boolean raided;
public	boolean inspected;
public	int encounterType;
public	boolean alwaysIgnorePolice;
public	boolean alwaysIgnorePirates;
public	boolean alwaysIgnoreTraders;
public	boolean alwaysIgnoreTradeInOrbit;
public	boolean trackAutoOff;
public	int ChanceOfTradeInOrbit;
public	boolean autoFuel;
public	boolean autoRepair;
public	boolean playerShipNeedsUpdate;
public	boolean opponentShipNeedsUpdate;
public	boolean autoAttack;
public	boolean autoFlee;
public	boolean attackIconStatus;
public	boolean textualEncounters;
public	boolean continuous;
public	boolean encounterWindow;
public	int activeTradeItem;
public int Bribe;
public	boolean canSuperWarp;
//	bool musicEnabled;
public	int currentGalaxySystem;
public	boolean firstEncounter;
//	boolean lastMessage;
	
public	boolean audioPlayerReleased;

long BuyPrice[];    // Price list current system
long BuyingPrice[]; // Total price paid for trade goods
long SellPrice[];   // Price list current system
long ShipPrice[];    // Price list current system (recalculate when buy ship screen is entered)
long Wormhole[];




	



 public String SystemSize[] ={"Tiny","Small","Medium","Large","Huge"};

 public String TechLevel[] ={"Pre-agricultural","Agricultural","Medieval","Renaissance","Early Industrial","Industrial","Post-industrial","Hi-tech"};

 public String Activity[] ={"Absent","Minimal","Few","Some","Moderate","Many","Abundant","Swarms"};







 public String SpecialResources[] ={"Nothing special","Mineral rich","Mineral poor","Desert","Sweetwater oceans","Rich soil","Poor soil","Rich fauna","Lifeless","Weird mushrooms","Special herbs","Artistic populace","Warlike populace"};

//const char* Status[MAXSTATUS] =
//{
//"under no particular pressure", 	  // Uneventful
//"at war",						  // Ore and Weapons in demand
//"ravaged by a plague",			  // Medicine in demand
//"suffering from a drought",		  // Water in demand
//"suffering from extreme boredom",  // Games and Narcotics in demand
//"suffering from a cold spell",	  // Furs in demand
//"suffering from a crop failure",	  // Food in demand
//"lacking enough workers"			  // Machinery and Robots in demand
//};

 public String Status[] ={"under no particular pressure","at war","ravaged by a plague","suffering from a drought","suffering from extreme boredom","suffering from a cold spell","suffering from a crop failure","lacking enough workers"};

String MercenaryName[] = {	"NameCommander","Alyssa","Armatur","Bentos","C2U2","Chi'Ti","Crystal","Dane","Deirdre","Doc","Draco","Iranda","Jeremiah","Jujubal","Krydon","Luis","Mercedez","Milete","Muri-L","Mystyc","Nandi","Orestes","Pancho","PS37","Quarck","Sosumi","Uma","Wesley","Wonton","Yorvick","Zeethibal" /* anagram for Elizabeth*/ };
 
}



