package com.example;

public class REPUTATION {
	public String Name;
	public int MinScore;
	static int i=0;
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
	
	REPUTATION(String name,int mins)
	{
		Name=name;
		MinScore=mins;
	}/*
		if(i==0)
		{
			Name=;
			MinScore=HARMLESSREP  ;
		}
		if(i==1)
		{
			Name=;
			MinScore=MOSTLYHARMLESSREP ;
		}
		if(i==2)
		{
			Name=;
			MinScore=POORREP  ;
		}
		if(i==3)
		{
			Name=;
			MinScore=AVERAGESCORE  ;
		}
		if(i==4)
		{
			Name=;
			MinScore=ABOVEAVERAGESCORE  ;
		}
		if(i==5)
		{
			Name=;
			MinScore=COMPETENTREP  ;
		}
		if(i==6)
		{
			Name=;
			MinScore=DANGEROUSREP  ;
		}
		if(i==7)
		{
			Name=;
			MinScore=DEADLYREP  ;
		}
		if(i==8)
		{
			Name=;
			MinScore=ELITESCORE ;
		}
		i++;
	}*/

}
