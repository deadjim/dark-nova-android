package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Commanderstaus extends Activity {
    /** Called when the activity is first created. */
	private Button bcommanderlog;
	private Button bcommanderclose;
	private Button bquests;
	private Button bcargo;
	private Button bshipinfo;
	private Button bgpta;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.commanderstatus);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        TextView t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Commander Log");
       
        
        bcommanderlog=(Button)this.findViewById(R.id.logButton01);
        bcommanderlog.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		setContentView(R.layout.commanderlog);
        		Intent commanderlog1=new Intent(Commanderstaus.this,Commanderlog.class);
           		startActivity(commanderlog1);
        	}
        });
        bcommanderclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
        bcommanderclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent bg1=new Intent(Commanderstaus.this,main.class);
           		startActivity(bg1);
        	}
        });
        bquests=(Button)this.findViewById(R.id.quests01);
        bquests.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent bquests1=new Intent(Commanderstaus.this,quests.class);
           		startActivity(bquests1);
           		}
        });
        bcargo=(Button)this.findViewById(R.id.cargo01);
        bcargo.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent bcargo1=new Intent(Commanderstaus.this,cargo.class);
           		startActivity(bcargo1);
        	}
        });
        bshipinfo=(Button)this.findViewById(R.id.shipinfo01);
        bshipinfo.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent shipinfo1=new Intent(Commanderstaus.this,ShipInfo.class);
           		startActivity(shipinfo1);
        	}
        });
        bgpta=(Button)this.findViewById(R.id.gpta01);
        bgpta.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent gpta1=new Intent(Commanderstaus.this,gpta.class);
           		startActivity(gpta1);
        	}
        });
        
        updateView();
        
    }
    
    public void updateView()
    {
    	TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    	
    	t1 = (TextView)this.findViewById(R.id.TextViewStatusName);
    	t1.setText(Globala.CommanderName);
    	
    	t2 = (TextView)this.findViewById(R.id.TextViewStatusPilotValue);
    	t2.setText(String.valueOf(Globala.pilotSkill)+" ["+String.valueOf(Globala.adaptPilotSkill())+"]");
    	
    	t3 =(TextView)this.findViewById(R.id.TextViewStatusKillsValue);
    	t3.setText(String.valueOf(Globala.policeKills+Globala.traderKills+Globala.pirateKills));
    	
    	t4=(TextView)this.findViewById(R.id.TextViewStatusFighterValue);
    	t4.setText(String.valueOf(Globala.fighterSkill)+" ["+String.valueOf(Globala.adaptFighterSkill())+"]");
    	
    	t5=(TextView)this.findViewById(R.id.TextViewStatusTimeValue);
    	t5.setText(String.valueOf(Globala.days)+" days");
    	
    	t6=(TextView)this.findViewById(R.id.TextViewStatusTraderValue);
    	t6.setText(String.valueOf(Globala.traderSkill)+" ["+String.valueOf(Globala.adaptTraderSkill())+"]");
    	
    	t7=(TextView)this.findViewById(R.id.TextViewStatusCashValue);
    	t7.setText(String.valueOf(Globala.credits));
    	
    	t8=(TextView)this.findViewById(R.id.TextViewStatusEngineerValue);
    	t8.setText(String.valueOf(Globala.engineerSkill)+" ["+String.valueOf(Globala.adaptEngineerSkill())+"]");
    	
    	t9=(TextView)this.findViewById(R.id.TextViewStatusDebtValue);
    	t9.setText(String.valueOf(Globala.debt));
    	
    	t10=(TextView)this.findViewById(R.id.TextViewStatusNetWorth);
    	t10.setText(String.valueOf(Globala.currentWorth())+" cr");
    	
    	t11=(TextView)this.findViewById(R.id.TextViewStatusReputation);
    	t11.setText(String.valueOf(Globala.currentReputation()));
    	
    	t12=(TextView)this.findViewById(R.id.TextViewStatusPoliceRecord);
    	t12.setText(String.valueOf(Globala.currentPoliceRecord()));
    	
    	t13=(TextView)this.findViewById(R.id.TextViewStatusDifficulty);
    	t13.setText(String.valueOf(Globala.gameDifficulty));
    	
    	
    	
    }
    
}