package com.example;

public class SHIP {
	
	public int Type;
	public int Cargo[]=new int[10];
	public int Weapon[]= new int [3];
	public int Shield[]= new int [3];
	public int ShieldStrength[]= new int [3];
	public int Gadget[]= new int [3];
	public int Crew[]= new int [3];
	public int Fuel;
	public int Hull;
	public int Tribbles;
	public int ForFutureUse[]= new int [4];

	SHIP(int type,int c0,int c1,int c2,int c3,int c4,int c5,int c6,int c7,int c8,int c9,int w0,int w1,int w2,int s0,int s1,int s2,int ss0,int ss1,int ss2,int g0,int g1,int g2,int cr0,int cr1,int cr2,int f,int h,int t,int fu0,int fu1,int fu2,int fu3)
	{
		Type=type;
		Cargo[0]=c0;
		Cargo[1]=c1;
		Cargo[2]=c2;
		Cargo[3]=c3;
		Cargo[4]=c4;
		Cargo[5]=c5;
		Cargo[6]=c6;
		Cargo[7]=c7;
		Cargo[8]=c8;
		Cargo[9]=c9;
		Weapon[0]=w0;
		Weapon[1]=w1;
		Weapon[2]=w2;
		Shield[0]=s0;
		Shield[1]=s1;
		Shield[2]=s2;
		ShieldStrength[0]=ss0;
		ShieldStrength[1]=ss1;
		ShieldStrength[2]=ss2;
		Gadget[0]=g0;
		Gadget[1]=g1;
		Gadget[2]=g2;
		Crew[0]=cr0;
		Crew[1]=cr1;
		Crew[2]=cr2;
		Fuel=f;
		Hull=h;
		Tribbles=t;
		ForFutureUse[0]=fu0;
		ForFutureUse[1]=fu1;
		ForFutureUse[2]=fu2;
		ForFutureUse[3]=fu3;
	}
	SHIP()
	{
		Type=0;
		for(int i=0;i<10;i++)
		{
			Cargo[i]=0;
		}
		for(int i=0;i<3;i++)
		{
			Weapon[i]=0;
			Shield[i]=0;
			ShieldStrength[i]=0;
			Gadget[i]=0;
			Crew[i]=0;
		}
		Fuel=0;
		Hull=0;
		Tribbles=0;
		for(int i=0;i<4;i++)
		{
			ForFutureUse[i]=0;
		}
		
	}
	/*if(i==0)
		{
			Type=1;
			Cargo[0]=0;
			Cargo[1]=0;
			Cargo[2]=0;
			Cargo[3]=0;
			Cargo[4]=0;
			Cargo[5]=0;
			Cargo[6]=0;
			Cargo[7]=0;
			Cargo[8]=0;
			Cargo[9]=0;
			Weapon[0]=0;
			Weapon[1]=-1;
			Weapon[2]=-1;
			Shield[0]=-1;
			Shield[1]=-1;
			Shield[2]=-1;
			ShieldStrength[0]=0;
			ShieldStrength[1]=0;
			ShieldStrength[2]=0;
			Gadget[0]=-1;
			Gadget[1]=-1;
			Gadget[2]=-1;
			Crew[0]=0;
			Crew[1]=-1;
			Crew[2]=-1;
			Fuel=14;
			Hull=100;
			Tribbles=0;
			ForFutureUse[0]=0;
			ForFutureUse[1]=0;
			ForFutureUse[2]=0;
			ForFutureUse[3]=0;
			
			
			
		}
		else if(i==1)//for opponent ship
		{
			Type=1;
			Cargo[0]=0;
			Cargo[1]=0;
			Cargo[2]=0;
			Cargo[3]=0;
			Cargo[4]=0;
			Cargo[5]=0;
			Cargo[6]=0;
			Cargo[7]=0;
			Cargo[8]=0;
			Cargo[9]=0;
			Weapon[0]=0;
			Weapon[1]=-1;
			Weapon[2]=-1;
			Shield[0]=-1;
			Shield[1]=-1;
			Shield[1]=-1;
			ShieldStrength[0]=0;
			ShieldStrength[1]=0;
			ShieldStrength[2]=0;
			Gadget[0]=-1;
			Gadget[1]=-1;
			Gadget[2]=-1;
			Crew[0]=1;
			Crew[1]=-1;
			Crew[2]=-1;
			Fuel=14;
			Hull=100;
			Tribbles=0;
			ForFutureUse[0]=0;
			ForFutureUse[1]=0;
			ForFutureUse[2]=0;
			ForFutureUse[3]=0;
		}
		else if (i==2)// for space monster
		{
			Type=MAXSHIPTYPE;
			Cargo[0]=0;
			Cargo[1]=0;
			Cargo[2]=0;
			Cargo[3]=0;
			Cargo[4]=0;
			Cargo[5]=0;
			Cargo[6]=0;
			Cargo[7]=0;
			Cargo[8]=0;
			Cargo[9]=0;
			Weapon[0]=2;
			Weapon[1]=2;
			Weapon[2]=2;
			Shield[0]=-1;
			Shield[1]=-1;
			Shield[1]=-1;
			ShieldStrength[0]=0;
			ShieldStrength[1]=0;
			ShieldStrength[2]=0;
			Gadget[0]=-1;
			Gadget[1]=-1;
			Gadget[2]=-1;
			Crew[0]=MAXCREWMEMBER;
			Crew[1]=-1;
			Crew[2]=-1;
			Fuel=1;
			Hull=500;
			Tribbles=0;
			ForFutureUse[0]=0;
			ForFutureUse[1]=0;
			ForFutureUse[2]=0;
			ForFutureUse[3]=0;
		}
		else if(i==3)//for ship Scarab
		{
			Type=MAXSHIPTYPE+3;
			Cargo[0]=0;
			Cargo[1]=0;
			Cargo[2]=0;
			Cargo[3]=0;
			Cargo[4]=0;
			Cargo[5]=0;
			Cargo[6]=0;
			Cargo[7]=0;
			Cargo[8]=0;
			Cargo[9]=0;
			Weapon[0]=2;
			Weapon[1]=-2;
			Weapon[2]=-1;
			Shield[0]=-1;
			Shield[1]=-1;
			Shield[1]=-1;
			ShieldStrength[0]=0;
			ShieldStrength[1]=0;
			ShieldStrength[2]=0;
			Gadget[0]=-1;
			Gadget[1]=-1;
			Gadget[2]=-1;
			Crew[0]=MAXCREWMEMBER;
			Crew[1]=-1;
			Crew[2]=-1;
			Fuel=1;
			Hull=400;
			Tribbles=0;
			ForFutureUse[0]=0;
			ForFutureUse[1]=0;
			ForFutureUse[2]=0;
			ForFutureUse[3]=0;
		}
		else if(i==4)//for dragon fly
		{
			Type=MAXSHIPTYPE+1;
			Cargo[0]=0;
			Cargo[1]=0;
			Cargo[2]=0;
			Cargo[3]=0;
			Cargo[4]=0;
			Cargo[5]=0;
			Cargo[6]=0;
			Cargo[7]=0;
			Cargo[8]=0;
			Cargo[9]=0;
			Weapon[0]=2;
			Weapon[1]=0;
			Weapon[2]=1;
			Shield[0]=LIGHTNINGSHIELD;//three lightning shields
			Shield[1]=LIGHTNINGSHIELD;
			Shield[1]=LIGHTNINGSHIELD;
			ShieldStrength[0]=LSHIELDPOWER;
			ShieldStrength[1]=LSHIELDPOWER;
			ShieldStrength[2]=LSHIELDPOWER;
			Gadget[0]=AUTOREPAIRSYSTEM;
			Gadget[1]=TARGETINGSYSTEM;
			Gadget[2]=-1;
			Crew[0]=MAXCREWMEMBER;
			Crew[1]=-1;
			Crew[2]=-1;
			Fuel=1;
			Hull=10;
			Tribbles=0;
			ForFutureUse[0]=0;
			ForFutureUse[1]=0;
			ForFutureUse[2]=0;
			ForFutureUse[3]=0;
			
		}
		i++;*/
}
