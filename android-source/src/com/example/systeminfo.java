package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class systeminfo extends Activity {
    /** Called when the activity is first created. */
	private Button bcommand;
	private Button bsellcargo;
	private Button bshipyard;
	private Button bsysteminfoclose;
	private Button bwarp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.systeminfo);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlesysteminfo);
        
        bcommand=(Button)this.findViewById(R.id.command04);
        bcommand.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent command1=new Intent(systeminfo.this,main.class);
           		startActivity(command1);
           		}
        });
        bshipyard=(Button)this.findViewById(R.id.shipyard04);
        bshipyard.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent ishipyard1=new Intent(systeminfo.this,shipyard.class);
           		startActivity(ishipyard1);
        	}
        });
        bsellcargo=(Button)this.findViewById(R.id.sellcargo04);
        bsellcargo.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent sellcargo1=new Intent(systeminfo.this,sellcargo.class);
           		startActivity(sellcargo1);
        	}
        });
        bsysteminfoclose=(Button)this.findViewById(R.id.systeminfoclose);
        bsysteminfoclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent systeminfoclose1=new Intent(systeminfo.this,main.class);
           		startActivity(systeminfoclose1);
        	}
        });
        bwarp=(Button)this.findViewById(R.id.warp04);
        bwarp.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent warp1=new Intent(systeminfo.this,shortrangechart.class);
           		startActivity(warp1);
        	}
        });
    }
}