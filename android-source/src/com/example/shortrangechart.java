package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class shortrangechart extends Activity {
    /** Called when the activity is first created. */
	private Button bcommand;
	private Button bsellcargo;
	private Button bsysteminfo;
	private Button bshipyard;
	private Button bshortrangeclose;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.shortrangechart);
     //   getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleshipyard);
      
    /*    bcommand=(Button)this.findViewById(R.id.command05);
        bcommand.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent command1=new Intent(shortrangechart.this,main.class);
           		startActivity(command1);
           		}
        });
        bsellcargo=(Button)this.findViewById(R.id.sellcargo05);
        bsellcargo.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent sellcargo1=new Intent(shortrangechart.this,sellcargo.class);
           		startActivity(sellcargo1);
        	}
        });
        bsysteminfo=(Button)this.findViewById(R.id.systeminfo05);
        bsysteminfo.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent systeminfo1=new Intent(shortrangechart.this,systeminfo.class);
           		startActivity(systeminfo1);
        	}
        });
        bshortrangeclose=(Button)this.findViewById(R.id.shortrangechartclose);
        bshortrangeclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent shortrange1=new Intent(shortrangechart.this,main.class);
           		startActivity(shortrange1);
        	}
        });
        bshipyard=(Button)this.findViewById(R.id.shipyard05);
        bshipyard.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent shipyard1=new Intent(shortrangechart.this,shipyard.class);
           		startActivity(shipyard1);
        	}
        });
        
      */  
    }
}