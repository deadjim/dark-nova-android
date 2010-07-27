package com.example;

public class SOLARSYSTEM {

	public int NameIndex;
	public int TechLevel;
	public int Politics;
	public int Status;
	public int X,Y,SpecialResources,Size;
	public int Qty[]=new int[10];
	public int CountDown=0,Special=0;
	public boolean Visited;
	
	SOLARSYSTEM()
	{
		NameIndex=0;
		TechLevel=0;
		Politics=0;
		Status=0;
		X=0;
		Y=0;
		SpecialResources=0;
		Size=0;
		for(int t=0;t<10;t++)
		Qty[t]=0;
		
		CountDown=0;
		Special=0;
		Visited=false;
	}
	
}
