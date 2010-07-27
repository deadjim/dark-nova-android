package com.example;

 

public class Politics {

	public String Name;
	public int ReactionIllegal;
	public int StrengthPolice;
	public int StrengthPirates;
	public int StrengthTraders;
	public int MinTechLevel;
	public int MaxTechLevel;
	public int BribeLevel;
	public boolean DrugsOk;
	public boolean FirearmsOk;
	public int Wanted;
	//public static int i=0;
	
	Politics()
	{
		Name=" ";
		 ReactionIllegal=0;
		 StrengthPolice=0;
		 StrengthPirates=0;
		 StrengthTraders=0;
		 MinTechLevel=0;
		 MaxTechLevel=0;
		 BribeLevel=0;
		 DrugsOk=false;
		 FirearmsOk=false;
		 Wanted=0;
		 
	}
	 Politics(String name,int reactioni,int strengthp,int strengthpt,int strengtht,int mint,int maxt,int bribe,boolean drugs,boolean firearms,int wanted)
	 {
		 Name=name;
		 ReactionIllegal=reactioni;
		 StrengthPolice=strengthp;
		 StrengthPirates=strengthpt;
		 StrengthTraders=strengtht;
		 MinTechLevel=mint;
		 MaxTechLevel=maxt;
		 BribeLevel=bribe;
		 DrugsOk=drugs;
		 FirearmsOk=firearms;
		 Wanted=wanted;
		 
		 
	 }
	//politics	
//  char  Name;
//	Byte ReactionIllegal;   // Reaction level of illegal goods 0 = total acceptance (determines how police reacts if they find you carry them)
//		Byte StrengthPolice;	// Strength level of police force 0 = no police (determines occurrence rate)
// 	Byte StrengthPirates;	// Strength level of pirates 0 = no pirates
//	Byte StrengthTraders;	// Strength levcel of traders 0 = no traders
//		Byte MinTechLevel;      // Mininum tech level needed
//		Byte MaxTechLevel; 		// Maximum tech level where this is found
//		Byte BribeLevel;		// Indicates how easily someone can be bribed 0 = unbribeable/high bribe costs
// 		Boolean DrugsOk;		// Drugs can be traded (if not, people aren't interested or the governemnt is too strict)
//		Boolean FirearmsOk;		// Firearms can be traded (if not, people aren't interested or the governemnt is too strict)
//		char  Wanted;				// Tradeitem requested in particular in this type of government

/*	 String p1[][]={{"Anarchy"," 0"," 0"," 7"," 1"," 0"," 5"," 7", "true",  "true","2"},	
	{ "Capitalist State", "2", "3"," 2"," 7"," 4"," 7"," 1"," true", " true", "3"},
	{ "Communist State",  "6"," 6"," 4"," 4", "1"," 5", "5"," true", "true",  "-1" },
	{ "Confederacy","5", "4", "3", "5"," 1", "6"," 3", "true","true","4" },
	{ "Corporate State", "2", "6","2","7","4","7"," 2", "true","true","9" },
	{ "Cybernetic State", "0"," 7", "7"," 5", "6"," 7"," 0"," false"," false","3" },
	{ "Democracy","4"," 3"," 2"," 5"," 3"," 7"," 2"," true","  true",  "4" },
	{ "Dictatorship","3", "4", "5", "3"," 0", "7", "2"," true","  true",  "-1" },
	{ "Fascist State","7"," 7", "7", "1"," 4"," 7"," 0", "false", "true",  "7" },
	{ "Feudal State", "1", "1", "6", "2", "0"," 3"," 6", "true",  "true",  "5"},
	{ "Military State",   "7", "7"," 0", "6", "2"," 7"," 0", "false"," true","9" },
	{ "Monarchy", "3"," 4"," 3", "4"," 0"," 5"," 4"," true","  true",  "6" },
	{ "Pacifist State",  "7", "2"," 1", "5", "0", "3"," 1", "true",  "false", "-1"},
	{ "Socialist State", "4", "2", "5", "3", "0", "5", "6", "true",  "true",  "-1"},
	{ "State of Satori",  "0", "1", "1", "1", "0", "1"," 0", "false", "false","-1" },
	{ "Technocracy", "1", "6", "3", "6", "4"," 7", "2", "true",  "true","0" },
	{ "Theocracy", "5", "6", "1", "4"," 0"," 4", "0"," true", " true", "8" }};
	
	*/
}
