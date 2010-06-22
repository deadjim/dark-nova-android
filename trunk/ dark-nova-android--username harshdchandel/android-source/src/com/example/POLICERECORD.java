package com.example;

public class POLICERECORD {
	public String Name;
	public int MinScore;
//	static int i=0;
	// Police Record Score
	public int PSYCHOPATHSCORE =-70;
	public int VILLAINSCORE    =-30;
	public int CRIMINALSCORE   =-10;
	public int DUBIOUSSCORE    =-5;
	public int CLEANSCORE       =0;
	public int LAWFULSCORE      =5;
	public int TRUSTEDSCORE     =10;
	public int HELPERSCORE      =25;
	public int HEROSCORE        =75;

	POLICERECORD(String name,int minscore)
	{
		Name=name;
		MinScore=minscore;
     }
}