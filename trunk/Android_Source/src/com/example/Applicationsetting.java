package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Applicationsetting extends Activity {
    /** Called when the activity is first created. */
	
	Button gr,bl,rd,textcoloron,textcoloroff,backgrndmon,backgrndmoff,loadsavegon,loadsavegoff;
	Button applicatonclose,lefthandlon,lefthandloff,talkngalrton,talkngalrtoff,gamesndon,gamesndoff;
	
	TextView t1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.aplicationsettings);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
       t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Application Settings");
        
        applicatonclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
        applicatonclose.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		//setContentView(R.layout.buyequipment);
        		Intent Applicationsettingclose1=new Intent(Applicationsetting.this,Gameoptions.class);
           		startActivity(Applicationsettingclose1);
        	}
        });
       
        textcoloron=(Button) this.findViewById(R.id.EncounterTextColoron);
        textcoloron.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		
        		gr=(Button) findViewById(R.id.buttongreen);
        		gr.setVisibility(View.VISIBLE);
        		Globala.gr1=true;
        		bl=(Button) findViewById(R.id.buttonblue);
        		bl.setVisibility(View.VISIBLE);
        		Globala.bl1=true;
        		rd=(Button) findViewById(R.id.buttonred);
        		rd.setVisibility(View.VISIBLE);
        		Globala.rd1=true;
        	}
        });
       
        textcoloroff=(Button) this.findViewById(R.id.EncounterTextColoroff);
        textcoloroff.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		
        		gr=(Button) findViewById(R.id.buttongreen);
        		gr.setVisibility(View.INVISIBLE);
        		Globala.gr1=false;
        		bl=(Button) findViewById(R.id.buttonblue);
        		bl.setVisibility(View.INVISIBLE);
        		Globala.bl1=false;
        		rd=(Button) findViewById(R.id.buttonred);
        		rd.setVisibility(View.INVISIBLE);
        		Globala.rd1=false;
        	}
        });
        loadsavegon=(Button) this.findViewById(R.id.AutoLoadSaveGameButtonon);
        loadsavegon.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.autoloadsave=true;
        		loadsavegon.setText("ON");
        		loadsavegoff=(Button) findViewById(R.id.AutoLoadSaveGameButtonoff);
        		loadsavegoff.setText("");
        	}
        });
        loadsavegoff=(Button) this.findViewById(R.id.AutoLoadSaveGameButtonoff);
        loadsavegoff.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.autoloadsave=false;
        		loadsavegoff.setText("OFF");
        		 loadsavegon=(Button) findViewById(R.id.AutoLoadSaveGameButtonon);
        		 loadsavegon.setText("");
        	}
        });
        backgrndmon=(Button) this.findViewById(R.id.EnableBackgroundMusicButtonon);
        backgrndmon.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.enablemusic=true;
        		 backgrndmon.setText("ON");
        		  backgrndmoff=(Button) findViewById(R.id.EnableBackgroundMusicButtoff);
        		  backgrndmoff.setText("");
        	}
        });
        backgrndmoff=(Button) this.findViewById(R.id.EnableBackgroundMusicButtoff);
        backgrndmoff.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.enablemusic=false;
        		backgrndmoff.setText("OFF");
        		 backgrndmon=(Button)findViewById(R.id.EnableBackgroundMusicButtonon);
        		 backgrndmon.setText("");
        	}
        });
        gamesndon=(Button) this.findViewById(R.id.EnableGameSoundson);
        gamesndon.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.enablegamesound=true;
        		gamesndon.setText("ON");
        		gamesndoff=(Button) findViewById(R.id.EnableGameSoundsoff);
        		gamesndoff.setText("");
        	}
        });
        gamesndoff=(Button) this.findViewById(R.id.EnableGameSoundsoff);
        gamesndoff.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.enablegamesound=false;
        		gamesndoff.setText("OFF");
        		gamesndon=(Button)findViewById(R.id.EnableGameSoundson);
        		gamesndon.setText("");
        	}
        });
 
        talkngalrton=(Button) this.findViewById(R.id.EnableTalkingAlertson);
        talkngalrton.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.enabletalkingalert=true;
        		 talkngalrton.setText("ON");
        		 talkngalrtoff=(Button) findViewById(R.id.EnableTalkingAlertsoff);
        		 talkngalrtoff.setText("");
        	}
        });
        talkngalrtoff=(Button) this.findViewById(R.id.EnableTalkingAlertsoff);
        talkngalrtoff.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.enabletalkingalert=false;
        		 talkngalrtoff.setText("OFF");
        		 talkngalrton=(Button)findViewById(R.id.EnableTalkingAlertson);
        		 talkngalrton.setText("");
        	}
        });
        
        lefthandlon=(Button) this.findViewById(R.id.LeftHandLayouton);
        lefthandlon.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.enabletalkingalert=true;
        		 lefthandlon.setText("ON");
        		 lefthandloff=(Button) findViewById(R.id.LeftHandLayoutoff);
        		 lefthandloff.setText("");
        	}
        });
        lefthandloff=(Button) this.findViewById(R.id.LeftHandLayoutoff);
        lefthandloff.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.enabletalkingalert=false;
        		 lefthandloff.setText("OFF");
        		 lefthandlon=(Button)findViewById(R.id.LeftHandLayouton);
        		 lefthandlon.setText("");
        	}
        });
    }
  }
