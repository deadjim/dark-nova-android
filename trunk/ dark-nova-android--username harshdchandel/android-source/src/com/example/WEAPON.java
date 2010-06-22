package com.example;

public class WEAPON {
	public  int MAXWEAPONTYPE =      3;
	public int PULSELASERWEAPON    =0;
	public int PULSELASERPOWER    =15;
	public int BEAMLASERWEAPON    = 1;
	public int BEAMLASERPOWER     =25;
	public int MILITARYLASERWEAPON= 2;
	public int MILITARYLASERPOWER =35;
	public int MORGANLASERWEAPON	=3;
	public int MORGANLASERPOWER   =85; 
	public String Name;
	public int Power,Price;
	public int TechLevel,Chance;//Chance that this is fitted in a slot
	static int i=0;
	
	WEAPON(String name,int power,int price,int techlevel,int chance)
	{
		Name=name;
		Power=power;
		Price = price;
		TechLevel=techlevel;
		Chance= chance;
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
