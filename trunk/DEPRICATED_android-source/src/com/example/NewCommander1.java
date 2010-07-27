package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class NewCommander1 extends Activity implements OnSeekBarChangeListener, OnClickListener {
	SeekBar difficultybar,pilotbar,engineerbar,fighterbar,traderbar;
	TextView diffval,pilotval,enggval,fighterval,traderval,pointsremaining;
	public static int a,b,c,d;
	public static int points;
	private AlertDialog alertDialog;
	Button alertbtn;
	TextView t1;
	 @Override
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.newcommander);
	        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
	        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
	        t1.setText("New Commander");
	       
	        a=1;b=1;c=1;d=1;
	        this.difficultybar = (SeekBar)this.findViewById(R.id.SeekBarDifficulty);
	   	 	this.difficultybar.setOnSeekBarChangeListener(this);
	   	 	
	   	 	this.engineerbar=(SeekBar)this.findViewById(R.id.SeekBarEngineer);
	   	 	this.engineerbar.setOnSeekBarChangeListener(this);
	   	 	
	   	 	this.traderbar=(SeekBar)this.findViewById(R.id.SeekBarTrader);
	   	 	this.traderbar.setOnSeekBarChangeListener(this);
	   	 	
	   	 	this.fighterbar=(SeekBar)this.findViewById(R.id.SeekBarFighter);
	   	 	this.fighterbar.setOnSeekBarChangeListener(this);
	   	 	
	   	 	this.pilotbar=(SeekBar)this.findViewById(R.id.SeekBarPilot);
	   	 	this.pilotbar.setOnSeekBarChangeListener(this);
	   	 	
	   	 this.alertbtn = (Button)this.findViewById(R.id.ButtonStart);
	   	this.alertbtn.setOnClickListener(this);
	   	points=16;
}
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		
		if(seekBar==this.difficultybar)
		{
			diffval = (TextView)this.findViewById(R.id.TextViewDifficultyLevel);
			if(progress <10)
			{
				diffval.setText("Beginner");
			}
			else if(progress>9 && progress<20)
			{
				diffval.setText("Easy");
			}	
			else if(progress >19 && progress<30)
			{
				diffval.setText("Normal");
			}
			else if(progress >29 && progress <40)
			{
				diffval.setText("Hard");
			}
			else
			{
				diffval.setText("Impossible");
			}
		}
		else if(seekBar==this.pilotbar){
			
			pilotval=(TextView)this.findViewById(R.id.TextViewPilotValue);
			String str= Integer.toString(progress);
			a=progress;
			pilotval.setText(str);
			
			
		}
		else if(seekBar==this.engineerbar)
		{
			enggval=(TextView)this.findViewById(R.id.TextViewEngineerValue);
			String str= Integer.toString(progress);
			b=progress;
			enggval.setText(str);
		}
		else if(seekBar==this.fighterbar)
		{
			fighterval=(TextView)this.findViewById(R.id.TextViewFighterValue);
			String str= Integer.toString(progress);
			c=progress;
			fighterval.setText(str);
		}
		else if (seekBar==this.traderbar)
		{
			traderval=(TextView)this.findViewById(R.id.TextViewTraderValue);
			String str= Integer.toString(progress);
			d=progress;
			traderval.setText(str);
		}
		int temp=a+b+c+d;
		if(temp<20)
		{
			points=20-temp;
			
		}
		else
		{
			points=0;
		}
		
		if(points<=20)
		{
			pointsremaining=(TextView)this.findViewById(R.id.TextViewPointsremaining);
			String str1=Integer.toString(points);
			pointsremaining.setText(str1);
			
		}
		
	
	}
	public void onStartTrackingTouch(SeekBar seekBar) {

		
	}
	public void onStopTrackingTouch(SeekBar seekBar) {
	
	}
	public void onClick(View view) {
		// TODO Auto-generated method stub
		if(view == this.alertbtn){
			if(points!=0)
			{
			alertDialog = new AlertDialog.Builder(this).create();
			alertDialog.setTitle("Unused Skill Points");
			alertDialog.setMessage("You haven't awarded all 20 skill points yet");
			alertDialog.setButton("Dismiss", new DialogInterface.OnClickListener() {
	             public void onClick(DialogInterface dialog, int which) {
	                     return;
	             }
	         }); 
			alertDialog.show();
		}
		else if(points==0)
		{
			TextView Name=(TextView)this.findViewById(R.id.EditTextJohansen);
		//	Global.CommanderName=Name.getText().toString();
			setContentView(R.layout.commanderpad);
			Intent intent = new Intent(NewCommander1.this,main.class);
			startActivity(intent);
		}
		
		}

	}
}