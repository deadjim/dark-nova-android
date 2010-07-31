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
	public  int a=1,b=1,c=1,d=1;
	public  int points=16,temp=0;
	public AlertDialog alertDialog;
	public Button alertbtn;
	public TextView t1;
	
	 @Override
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.newcommander);
	        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
	      //  t1=(TextView)this.findViewById(R.id.TextViewTitleName);
	      // t1.setText("New Commander");
	       
	        difficultybar = (SeekBar)this.findViewById(R.id.SeekBarDifficulty);
	   	 	difficultybar.setOnSeekBarChangeListener(this);
	   	 	difficultybar.setMax(5);
	   	 	
	   	 	engineerbar=(SeekBar)this.findViewById(R.id.SeekBarEngineer);
	   	 	engineerbar.setOnSeekBarChangeListener(this);
	   	 	
	   	 	traderbar=(SeekBar)this.findViewById(R.id.SeekBarTrader);
	   	 	traderbar.setOnSeekBarChangeListener(this);
	   	 	
	   	 	fighterbar=(SeekBar)this.findViewById(R.id.SeekBarFighter);
	   	 	fighterbar.setOnSeekBarChangeListener(this);
	   	 	
	   	 	pilotbar=(SeekBar)this.findViewById(R.id.SeekBarPilot);
	   	 	pilotbar.setOnSeekBarChangeListener(this);
	   	 	
	   	 alertbtn = (Button)this.findViewById(R.id.ButtonStart);
	   	alertbtn.setOnClickListener(this);
	   //	points=16;
}
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		
		if(seekBar==difficultybar)
		{
			diffval = (TextView)this.findViewById(R.id.TextViewDifficultyLevel);
			if(progress<2)
			{
				diffval.setText("Beginner");
			}
			else if(progress==2)
			{
				diffval.setText("Easy");
			}	
			else if(progress==3)
			{
				diffval.setText("Normal");
			}
			else if(progress==4)
			{
				diffval.setText("Hard");
			}
			else if(progress==5)
			{
				diffval.setText("Impossible");
			}
		}
		else if(seekBar==this.pilotbar){
			
			if( points == 0 && progress > a) {
                pilotbar.setProgress(a);
            }  else {
                pilotval=(TextView)this.findViewById(R.id.TextViewPilotValue);
                String str= Integer.toString(progress);
                a=progress;
                pilotval.setText(str);
            }
		}
		else if(seekBar==this.engineerbar)
		{
			if( points == 0 && progress > b) {
                engineerbar.setProgress(b);
            } else {
                enggval=(TextView)this.findViewById(R.id.TextViewEngineerValue);
                String str= Integer.toString(progress);
                b=progress;
                enggval.setText(str);
                Globala.engineerSkill=b;
                Globala.pilotSkill=a;
            }
		}
		else if(seekBar==this.fighterbar)
		{
            if( points == 0 && progress > c) {
                fighterbar.setProgress(c);
            } else {
                fighterval=(TextView)this.findViewById(R.id.TextViewFighterValue);
                String str= Integer.toString(progress);
                c=progress;
                fighterval.setText(str);
            }
			}
		else if (seekBar==this.traderbar)
		{
            if( points == 0 && progress > d) {
                traderbar.setProgress(d);
            } else {
                traderval=(TextView)this.findViewById(R.id.TextViewTraderValue);
                String str= Integer.toString(progress);
                d=progress;
                traderval.setText(str);
            }
		}
		temp=a+b+c+d;
		if(temp<20)
		{
			points=20-temp;
			
		}
		else if(temp==20)
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
	public void onClick(View view)
	{
		
		if(view == this.alertbtn){
			if(temp<20)
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
		else if(temp==20)
		{
			
			Globala.initialize();
			Globala.traderSkill=d;
			Globala.fighterSkill=c;
			Globala.engineerSkill=b;
			Globala.pilotSkill=a;
			Globala.StartNewGame();
			TextView Name=(TextView)this.findViewById(R.id.EditTextJohansen);
			Globala.CommanderName=Name.getText().toString();
			
			//setContentView(R.layout.commanderpad);
			Intent intent = new Intent(NewCommander1.this,main.class);
			startActivity(intent);
		}
		else if(temp>20)
		{
			alertDialog = new AlertDialog.Builder(this).create();
			alertDialog.setTitle(" Skill Points");
			alertDialog.setMessage("You have awarded more than 20 skill points" +
					"Please select only 20 skill points");
			alertDialog.setButton("Dismiss", new DialogInterface.OnClickListener() {
	             public void onClick(DialogInterface dialog, int which) {
	                     return;
	             }
	         }); 
			alertDialog.show();
		}
		
		}

	}
	
}