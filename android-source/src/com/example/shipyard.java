package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class shipyard extends Activity {
    /** Called when the activity is first created. */
	private Button bcommand;
	private Button bsellcargo;
	private Button bsysteminfo;
	private Button bshipyardclose;
	private Button bwarp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.shipyard);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleshipyard);
      
        bcommand=(Button)this.findViewById(R.id.command02);
        bcommand.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent command1=new Intent(shipyard.this,main.class);
           		startActivity(command1);
           		}
        });
        bsellcargo=(Button)this.findViewById(R.id.sellcargo02);
        bsellcargo.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent sellcargo1=new Intent(shipyard.this,sellcargo.class);
           		startActivity(sellcargo1);
        	}
        });
        bsysteminfo=(Button)this.findViewById(R.id.systeminfo02);
        bsysteminfo.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent systeminfo1=new Intent(shipyard.this,systeminfo.class);
           		startActivity(systeminfo1);
        	}
        });
        bshipyardclose=(Button)this.findViewById(R.id.shipyardclose);
        bshipyardclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent bshipyardclose1=new Intent(shipyard.this,main.class);
           		startActivity(bshipyardclose1);
        	}
        });
        bwarp=(Button)this.findViewById(R.id.systeminfo02);
        bwarp.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent systeminfo1=new Intent(shipyard.this,systeminfo.class);
           		startActivity(systeminfo1);
        	}
        });
        
    }
}