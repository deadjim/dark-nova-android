package com.example;

public class WEAPON {
	
	public String Name;
	public int Power,Price;
	public int TechLevel,Chance;//Chance that this is fitted in a slot
	
	
	WEAPON(String name,int power,int price,int techlevel,int chance)
	{
		Name=name;
		Power=power;
		Price = price;
		TechLevel=techlevel;
		Chance= chance;
	}
	WEAPON()
	{
		Name="";		
		Power=0;
		Price =0;
		TechLevel=0;
		Chance=0;
	}
		/*
		if (i==0)
		{
			Name="Pulse laser";
			Power=PULSELASERWEAPON;
			Price = 2000;
			TechLevel=5;
			Chance= 50;
		}
		else if(i==1)
		{
			Name="Regolian Disrupters";
			Power=BEAMLASERPOWER;
			Price = 12500;
			TechLevel=6;
			Chance= 35;
		}
		else if(i==2)
		{
			Name="Justice Mk. V";
			Power=MILITARYLASERPOWER;
			Price = 35000;
			TechLevel=7;
			Chance= 15;
		}
		else if(i==3)
		{
			Name="BOAKYAG Laser";
			Power=MORGANLASERPOWER;
			Price = 50000;
			TechLevel=8;
			Chance= 0;
		}
		i++;*/
	
}
