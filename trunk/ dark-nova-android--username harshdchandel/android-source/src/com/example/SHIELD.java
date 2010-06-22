package com.example;

public class SHIELD {
	public String Name;
	public int Power,Price;
	public int TechLevel,Chance;//Chance that this is fitted in a slot
public 	static int i=0;
	int ESHIELDPOWER=100;
	int RSHIELDPOWER=200;
	int ISHIELDPOWER=350;
	
	SHIELD(String name,int power,int price,int tlevel,int chance)
	{
		Name=name;
		Power=power;
		Price = price;
		TechLevel=tlevel;
		Chance=chance;
	}
		/*
	}
		if(i==0)
		{
			Name="Energy Shield";
			Power=ESHIELDPOWER;
			Price = 5000;
			TechLevel=5;
			Chance=70;
			
		}
		else if(i==1)
		{
			Name="Reflective Shield";
			Power=RSHIELDPOWER;
			Price = 20000;
			TechLevel=6;
			Chance=30;
			
		}
		else if(i==2)
		{
			Name="Lightning Shield";
			Power=ISHIELDPOWER;
			Price = 45000;
			TechLevel=8;
			Chance=0;
		}
		i++;
	}*/

}
