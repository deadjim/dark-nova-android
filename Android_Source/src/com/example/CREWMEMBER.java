package com.example;

public class CREWMEMBER {
	public int NameIndex;
	public int Pilot;
	public int Fighter;
	public int Trader;
	public int Engineer;
	public int CurSystem;
	
	public CREWMEMBER(int a,int b,int c, int d, int e, int f)
	{
		NameIndex=a;
		Pilot=b;
		Fighter=c;
		Trader=d;
		Engineer=e;
		CurSystem=f;
	}
	CREWMEMBER()
	{
		NameIndex=0;
		Pilot=0;
		Fighter=0;
		Trader=0;
		Engineer=0;
		CurSystem=0;
	}

}
