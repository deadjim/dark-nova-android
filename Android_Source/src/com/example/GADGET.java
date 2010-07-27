package com.example;

public class GADGET {
	
	public String Name;
	public int Price;
	public int TechLevel;
	public int Chance;
	
	GADGET(String name,int price,int techlevel,int chance)
	{
		Name=name;
		Price=price;
		TechLevel=techlevel;
		Chance=chance;
	}
	GADGET()
	{
		Name=" ";
		Price=0;
		TechLevel=0;
		Chance=0;
	}
		/*
		{
			Name="5 extra cargo bays";
			Price=2500;
			TechLevel=4;
			Chance=35;
			//5 extra holds
		}
		else if(i==1)
		{
			Name="Auto-repair system";
			Price=7500;
			TechLevel=5;
			Chance=20; // Increases engineer's effectivity

		}
		else if(i==2)
		{
			Name="Navigation system";
			Price=15000;
			TechLevel=6;
			Chance=20;// Increases pilot's effectivity

		}
		else if(i==3)
		{
			Name="Targeting system";
			Price=25000;
			TechLevel=6;
			Chance=20;// Increases fighter's effectivity

		}
		else if(i==4)
		{
			Name="Cloaking Device";
			Price=7500;
			TechLevel=5;
			Chance=20;// If you have a good engineer, nor pirates nor police will notice you
			// The gadgets below can't be bought

		}
		else if(i==5)
		{
			Name="Fuel compactor";
			Price=30000;
			TechLevel=8;
			Chance=0;
		}
	}
*/
}
