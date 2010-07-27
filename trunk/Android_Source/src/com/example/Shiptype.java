package com.example;

public class Shiptype {
	
	public	String Name;
	public	int CargoBays;
	public	int WeaponSlots;
	public	int ShieldSlots;
	public	int GadgetSlots;
	public	int CrewQuarters;
	public	int FuelTanks;
	public	int MinTechLevel;
	public	int CostOfFuel;
	public	int Price;
	public	int Bounty;
	public	int Occurence;
	public	int HullStrength;
	public	int Police;
	public	int Pirates;
	public int Traders;
	public	int RepairCosts;
	public	int Size;
	
	Shiptype()
	{
		Name=" ";
		CargoBays=0;
		WeaponSlots=0;
		ShieldSlots=0;
		GadgetSlots=0;
		CrewQuarters=0;
		FuelTanks=0;
		MinTechLevel=0;
		CostOfFuel=0;
		Price=0;
		Bounty=0;
		Occurence=0;
		HullStrength=0;
		Police=0;
		Pirates=0;
		Traders=0;
		RepairCosts=0;
		Size=0;
	}
	Shiptype(String name ,int cargobays,int weaponslots,int shieldslots,int gadgetslots,int crewquaters,int fueltanks,int mintechlevel,int costoffuel,int price,int bounty,int occurrence,int hullstrngth,int police,int pirates,int traders,int repaircosts,int size)
	{
		
		Name=name;
		CargoBays=cargobays;
		WeaponSlots=weaponslots;
		ShieldSlots=shieldslots;
		GadgetSlots=gadgetslots;
		CrewQuarters=crewquaters;
		FuelTanks=fueltanks;
		MinTechLevel=mintechlevel;
		CostOfFuel=costoffuel;
		Price=price;
		Bounty=bounty;
		Occurence=occurrence;
		HullStrength=hullstrngth;
		Police=police;
		Pirates=pirates;
		Traders=traders;
		RepairCosts=repaircosts;
		Size=size;
	}
}
	//char* Name;/
	//Byte CargoBays;		// Number of cargo bays/
	//Byte WeaponSlots;	// Number of lasers possible
	//Byte ShieldSlots;	// Number of shields possible
	//Byte GadgetSlots;	// Number of gadgets possible (e.g. docking computers)
	//Byte CrewQuarters;	// Number of crewmembers possible
	//Byte FuelTanks;		// Each tank contains enough fuel to travel 10 parsecs
	//Byte MinTechLevel;	// Minimum tech level needed to build ship
	//Byte CostOfFuel;	// Cost to fill one tank with fuel
	//long Price;			// Base ship cost
	//int Bounty;			// Base bounty
	//int Occurrence;		// Percentage of the ships you meet
	//long HullStrength;	// Hull strength
	//int Police;			// Encountered as police with at least this strength
	//int Pirates;		// idem Pirates
	//int Traders;		// idem Traders
	//Byte RepairCosts;	// Repair costs for 1 point of hull strength.
	//Byte Size;			// Determines how easy it is to hit this ship
	//} SHIPTYPE;
/*
	
	 String shiptype1[][]={{ "Nanomite", "10"," 0", "0"," 0", "1","20"," 4","1"," 2000"," 5"," 2"," 25","-1", "-1","0","1", "0" },
			 { "Minox", "15", "1","0", "1"," 1"," 14", "5", "2","10000", "50", "28", "100", "0"," 0", "0"," 1","1" },
			 { "Spathi Scout", "20"," 1", "1", "1", "1", "17", "5", "3", "25000", "75"," 20", "100", "0"," 0"," 0"," 1", "1" },
			 { "T-16 Womprat", "15"," 2", "1", "1", "1", "13000", "5", "5", "30000", "100", "20", "100", "0", "1", "0", "1", "1" },
			 { "Vorchan", "25"," 1", "2"," 2", "2", "15", "5", "7", "60000", "125", "15", "100", "1", "1", "0", "1", "2" },
			 { "Hirogen Freighter", "50"," 0"," 1", "1", "3", "14", "5"," 10", "80000", "50","3", "50"," -1"," -1", "0", "1", "2" },
			 { "Vorlon Cruiser", "20", "3", "2", "1", "2", "16", "6", "15", "100000", "200", "6", "150", "2"," 3", "1", "2"," 3" },
			 { "YT-1300", "30", "2", "2", "3", "3", "15", "6", "15"," 150000", "300", "2"," 150", "3", "4"," 2"," 3", "3" },
			 { "T'khar Uberhauler", "60"," 1"," 3", "2"," 3", "13", "7", "20", "225000", "300", "2", "200", "4", "5"," 3", "4", "4" },
			 { "Vix Dreadnought", "35", "3"," 2", "2", "3", "14", "7", "20", "300000", "500", "2", "200"," 5", "6","4"," 5", "4 "},
			 // The ships below can't be bought
			 { "Leviathan"," 0", "3", "0"," 0", "1"," 1"," 8", "1"," 500000"," 0"," 0", "500", "8"," 8"," 8"," 1"," 4" },
			 { "Kor'ah Menace", "0", "2", "3", "2"," 1", "1", "8"," 1"," 500000"," 0", "0", "10", "8"," 8", "8", "1", "1" },
			 { "Mantis", "0", "3", "1", "3", "3", "1"," 8", "1"," 500000", "0", "0", "300", "8"," 8", "8", "1"," 2 "},
			 { "Scarab", "20", "2", "0", "0", "2", "1", "8", "1", "500000", "0", "0", "400", "8", "8"," 8", "1", "3" },
			 { "Bottle", "0"," 0", "0"," 0", "0","1", "8"," 1", "100", "0", "0", "10", "8"," 8", "8", "1", "1" }};


*/


