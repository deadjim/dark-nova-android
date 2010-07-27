package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class galaccticchart extends Activity {
    /** Called when the activity is first created. */
	
	Button gr,bl,rd,textcoloron,textcoloroff,backgrndmon,backgrndmoff,loadsavegon,loadsavegoff;
	Button galacclose,applicatonclose,lefthandlon,lefthandloff,talkngalrton,talkngalrtoff,gamesndon,gamesndoff;
	TextView t1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.aplicationsettings);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Galactic Chart");
        
        galacclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
        galacclose.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		Intent galacclose1=new Intent(galaccticchart.this,Gameoptions.class);
           		startActivity(galacclose1);
        	}
        });
}
}