package com.example;

public class Tradeitem {

	public String Name;
	public int TechProduction,TechUsage,TechTopProduction;
	public int PriceLowTech,PriceInc;
	public int Variance;
	public int DoublePriceStatus;
	public int CheapResource;
	public int ExpensiveResource;
	public int MinTradePrice;
	public int MaxTradePrice;
	public int Roundoff;

	 public Tradeitem()
	 {
		 Name=" ";
			TechProduction=0;
			TechUsage=0;
			TechTopProduction=0;
			PriceLowTech=0;
			PriceInc=0;
			Variance=0;
			DoublePriceStatus=0;
			CheapResource=0;
			ExpensiveResource=0;
			MinTradePrice=0;
			MaxTradePrice=0;
			Roundoff=0;
	 }
	 public Tradeitem(String name,int techp,int techu,int techtopp,int pricel,int priceinc,int variance,int doublep,int cheapr,int expensiver,int mint,int maxt,int roundf)
		{
			Name=name;
			TechProduction=techp;
			TechUsage=techu;
			TechTopProduction=techtopp;
			PriceLowTech=pricel;
			PriceInc=priceinc;
			Variance=variance;
			DoublePriceStatus=doublep;
			CheapResource=cheapr;
			ExpensiveResource=expensiver;
			MinTradePrice=mint;
			MaxTradePrice=maxt;
			Roundoff=roundf;
			
		}
	
}
	 /*
	//char* Name;
	//Byte TechProduction; 	// Tech level needed for production
	//Byte TechUsage;			// Tech level needed to use
	//Byte TechTopProduction;	// Tech level which produces this item the most
	//int PriceLowTech;		// Medium price at lowest tech level			
	//int PriceInc;			// Price increase per tech level
	//int Variance;			// Max percentage above or below calculated price
	//int DoublePriceStatus;	// Price increases considerably when this event occurs
	//int CheapResource;		// When this resource is available, this trade item is cheap
	//int ExpensiveResource;  // When this resource is available, this trade item is expensive
	//int MinTradePrice;		// Minimum price to buy/sell in orbit
	//int MaxTradePrice;		// Minimum price to buy/sell in orbit
	//int RoundOff;			// Roundoff price for trade in orbit

	
	String Trade[][]={{ "Water","0", "0","2","30","3","4","3","4", "3"," 30",  "50","1" },
	{ "Furs","0"," 0","0",  "250",  "+10", "10", "5", "7"," 8"," 230", " 280",   "5"},
	{ "Food","1"," 0","1",  "100",   "5",   "5", "6",   "5","6","90",  "160","5" },
	{ "Ore","2", "2", "3", " 350",  "+20", " 10", "1","1",    "2", " 350", " 420", " 10" },
	{ "Games", "3", "1", "6", " 250",  "-10",   "5", "4",      " 11",       "-1",       " 160",  "270","   5" },
	{ "Firearms","  3"," 1"," 5"," 1250", " -75"," 100"," 1","12","-1", "600", "1100",  "25 "},
	{ "Medicine","  4"," 1"," 6", " 650", " -20", " 10", "2","10",  "  -1", "400", " 700",  "25 "},
	{ "Machines", " 4"," 3"," 5", " 900", " -30", "  5", "7", "-1", "-1", "600", " 800",  "25 "},
	{ "Narcotics"," 5", "0", "5"," 3500","-125","150", "4", "9"," -1", "2000", "3000",  "50" },
	{ "Robots", "6"," 4"," 7"," 5000","-150"," 100", "7"," -1","-1","3500"," 5000", "100" }};

	*/

