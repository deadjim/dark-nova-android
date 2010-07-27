package com.example;

public class SHIELD {
	public String Name;
	public int Power,Price;
	public int TechLevel,Chance;//Chance that this is fitted in a slot

	
	SHIELD(String name,int power,int price,int tlevel,int chance)
	{
		Name=name;
		Power=power;
		Price = price;
		TechLevel=tlevel;
		Chance=chance;
	}
	SHIELD()
	{
		Name="";
		Power=0;
		Price =0;
		TechLevel=0;
		Chance=0;
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
