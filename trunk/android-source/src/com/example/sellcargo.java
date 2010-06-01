package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class sellcargo extends Activity {
    /** Called when the activity is first created. */
	private Button bcommand;
	private Button bshipyard;
	private Button bsysteminfo;
	private Button bsellcargoclose;
	private Button bwarp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.sellcargo);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlesellcargo);
      
        bcommand=(Button)this.findViewById(R.id.command03);
        bcommand.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent command1=new Intent(sellcargo.this,main.class);
           		startActivity(command1);
           		}
        });
        bshipyard=(Button)this.findViewById(R.id.shipyard03);
        bshipyard.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent ishipyard1=new Intent(sellcargo.this,shipyard.class);
           		startActivity(ishipyard1);
        	}
        });
        bsysteminfo=(Button)this.findViewById(R.id.systeminfo03);
        bsysteminfo.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent systeminfo1=new Intent(sellcargo.this,systeminfo.class);
           		startActivity(systeminfo1);
        	}
        });
        bsellcargoclose=(Button)this.findViewById(R.id.sellcargoclose);
        bsellcargoclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent sellcargoclose1=new Intent(sellcargo.this,main.class);
           		startActivity(sellcargoclose1);
        	}
        });
        bwarp=(Button)this.findViewById(R.id.warp03);
        bwarp.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent warp1=new Intent(sellcargo.this,shortrangechart.class);
           		startActivity(warp1);
        	}
        });
    }
}