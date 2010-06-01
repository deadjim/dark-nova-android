package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

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
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlecommanderstatus);
        
        bcommanderlog=(Button)this.findViewById(R.id.Button01);
        bcommanderlog.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		setContentView(R.layout.commanderlog);
        		Intent commanderlog1=new Intent(Commanderstaus.this,Commanderlog.class);
           		startActivity(commanderlog1);
        	}
        });
        bcommanderclose=(Button)this.findViewById(R.id.commanderstatusclose);
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
        		Intent bquests1=new Intent(Commanderstaus.this,main.class);
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
        		Intent shipinfo1=new Intent(Commanderstaus.this,shipinformation.class);
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
    }
}