package com.example;

public class HIGHSCORE {
	
	public int NAMELEN;
	public String Name;
	public int Status;// 0 = killed, 1 = Retired, 2 = Bought moon
	public int Days;
	public int Worth;
	public int Difficulty;
	public int ForFutureUse;
	
	HIGHSCORE()
	{
		NAMELEN=20;
		Name="Johnason";
		Status=0;
		Days=0;
		Worth=0;
		Difficulty=0;
		ForFutureUse=0;
	}
	

}
