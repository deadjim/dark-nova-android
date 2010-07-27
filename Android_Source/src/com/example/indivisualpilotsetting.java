package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class indivisualpilotsetting extends Activity {
    /** Called when the activity is first created. */
	
	Button fulltankon,fulltankoff ,hullreapairon,hullreapairoff,buynewson,buynewsoff;
	Button loanreminderon,loanreminderoff;
	public static boolean gr1=false,bl1=false,rd1=false,autoloadsave=true,enablemusic=true,enablegamesound=true,enabletalkingalert=true;
	TextView t1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.indivisualpilotsettings);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Indivisual Pilot Setting");
       
        Button indvclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
        indvclose.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		//setContentView(R.layout.buyequipment);
        		Intent indvcloseclose1=new Intent(indivisualpilotsetting.this,Gameoptions.class);
           		startActivity(indvcloseclose1);
        	}
        });
        fulltankon=(Button) this.findViewById(R.id.FullTankonArrivalButtonon);
        fulltankon.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.autoFuel=true;
        		fulltankon.setText("ON");
        		fulltankoff=(Button) findViewById(R.id.FullTankonArrivalButtonoff);
        		fulltankoff.setText("");
        	}
        });
        fulltankoff=(Button) this.findViewById(R.id.FullTankonArrivalButtonoff);
        fulltankoff.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.autoFuel=false;
        		 fulltankoff.setText("OFF");
        		 fulltankon=(Button) findViewById(R.id.FullTankonArrivalButtonon);
        		 fulltankon.setText("");
        	}
        });
        hullreapairon=(Button) this.findViewById(R.id.HullRepaironArrivalButtonon);
        hullreapairon.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.autoRepair=true;
        		 hullreapairon.setText("ON");
        		  hullreapairoff=(Button) findViewById(R.id.HullRepaironArrivalButtonoff);
        		  hullreapairoff.setText("");
        	}
        });
        hullreapairoff=(Button) this.findViewById(R.id.HullRepaironArrivalButtonoff);
        hullreapairoff.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.autoRepair=false;
        		hullreapairoff.setText("OFF");
        		 hullreapairon=(Button)findViewById(R.id.HullRepaironArrivalButtonon);
        		 hullreapairon.setText("");
        	}
        });
        buynewson=(Button) this.findViewById(R.id.AlwaysBuyNewson);
        buynewson.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        	
        		buynewson.setText("ON");
        		buynewsoff=(Button) findViewById(R.id.AlwaysBuyNewsoff);
        		buynewsoff.setText("");
        	}
        });
        buynewsoff=(Button) this.findViewById(R.id.AlwaysBuyNewsoff);
        buynewsoff.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        	
        		buynewsoff.setText("OFF");
        		buynewson=(Button)findViewById(R.id.AlwaysBuyNewson);
        		buynewson.setText("");
        	}
        });
 
        loanreminderon=(Button) this.findViewById(R.id.LoanReminderson);
        loanreminderon.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.remindLoans=true;
        		 loanreminderon.setText("ON");
        		 loanreminderoff=(Button) findViewById(R.id.LoanRemindersoff);
        		 loanreminderoff.setText("");
        	}
        });
        loanreminderoff=(Button) this.findViewById(R.id.LoanRemindersoff);
        loanreminderoff.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.remindLoans=false;
        		 loanreminderoff.setText("OFF");
        		 loanreminderon=(Button)findViewById(R.id.LoanReminderson);
        		 loanreminderon.setText("");
        	}
        });
        
       
    }
  }
