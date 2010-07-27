package com.example;

public class SPECIALEVENT {
	
	public String Title,QuestStringID;
	public int Price;
	public int Occurence;
	public boolean JustAMessage;
	
	
	SPECIALEVENT(String title,String qid,int price,int occ,boolean just)
	{
		Title=title;
		QuestStringID=qid;
		Price=price;
		Occurence =occ;
		JustAMessage=just;
		
	}
	SPECIALEVENT()
	{
		Title=" ";
		QuestStringID=" ";
		Price=0;
		Occurence =0;
		JustAMessage=false;
	}
	
	//char* Title;
	//char* QuestStringID;
	//int QuestStringID;
	//long Price;
	//Byte Occurrence;
	//Boolean JustAMessage;
	//} SPECIALEVENT;

/*
	String SpecialEvent1[][] ={{ "Dragonfly Destroyed",	"QuestDragonflyDestroyedString","0", "0", "true" },
	{ "Weird Ship",				"QuestWeirdShipString",				"0", "0", "true" },
	{ "Lightning Ship",			"QuestLightningShipString",			"0", "0", "true" },
	{ "Strange Ship",			"QuestStrangeShipString",				"0", "0"," true "},
	{ "Monster Killed", 		"QuestMonsterKilledString", 	   "-15000", "0", "true" },
	{ "Medicine Delivery", 		"QuestMedicineDeliveredString",		"0", "0", "true" },
	{ "Retirement",     		"QuestRetirementString",				"0", "0", "false" },
	{ "Moon For Sale",  		"QuestMoonForSaleString", 	 "COSTMOON", "4", "false" },
	{ "Skill Increase", 		"QuestSkillIncreaseString",		 "3000", "3", "false" },
	{ "Merchant Prince",		"QuestMerchantPrinceString",		 "1000", "1", "false" },
	{ "Erase Record",   		"QuestEraseRecordString",			 "5000", "3", "false" },
	{ "Tribble Buyer",  		"QuestTribbleBuyerString", 			"0", "3", "false "},
	{ "Space Monster",  		"QuestSpaceMonsterString", 			"0", "1", "true "},
	{ "Dragonfly",      		"QuestDragonflyString", 				"0", "1"," true "},
	{ "Cargo For Sale", 		"QuestCargoForSaleString", 	 	 "1000", "3", "false" },
	{ "Lightning Shield", 		"QuestLightningShieldString",	 		"0"," 0"," false" },
	{ "Japori Disease", 		"QuestJaporiDiseaseString", 			"0", "1", "false "},
	{ "Lottery Winner", 		"QuestLotteryWinnerString", 		"-1000", "0", "true" },
	{ "Artifact Delivery", 		"QuestArtifactDeliveryString",	"-20000", "0", "true" },
	{ "Alien Artifact", 		"QuestAlienArtifactString", 		"	0", "1", "false" },
	{ "Ambassador Jarek", 		"QuestAmbassadorJarekString",		 	"0", "1"," false "},
	{ "Gemulon Invaded", 		"QuestGemulonInvadedString", 			"0", "0", "true" },
	{ "Fuel Compactor", 		"QuestFuelCompactorString", 			"0", "0", "false" },
	{ "Dangerous Experiment",   "QuestDangerousExperimentString",		"0", "0", "true" },
	{ "Jonathan Wild",  		"QuestJonathanWildString", 			"0", "1", "false" },
	{ "Morgan's Reactor",  		"QuestMorgansReactorString",	 		"0", "0", "false" },
	{ "Install Morgan's Laser", "QuestInstallMorgansLaserString",	 	"0", "0", "false" },
	{ "Scarab Stolen", 		"QuestScarabStolenString",		 	"0"," 1", "true"},
	{ "Upgrade Hull", 			"QuestUpgradeHullString", 			"0", "0", "false"},
	{ "Scarab Destroyed", 	"QuestScarabDestroyedString",	 	"0", "0", "true"},
	{ "Reactor Delivered",  	"QuestReactorDeliveredString", 		"0"," 0", "true" },
	{ "Jarek Gets Out",			"QuestJarekGetsOutString", 			"0", "0", "true" },
	{ "Gemulon Rescued", 		"QuestGemulonRescuedString",	 		"0", "0", "true" },
	{ "Disaster Averted",		"QuestDisasterAvertedString",			"0", "0", "true" },
	{ "Experiment Failed",		"QuestExperimentFailedString", 		"0", "0", "true" },
	{ "Wild Gets Out",			"QuestWildGetsOutString",				"0", "0", "true" }};
*/
}
