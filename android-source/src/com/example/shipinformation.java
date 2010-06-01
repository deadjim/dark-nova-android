package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class shipinformation extends Activity {
    /** Called when the activity is first created. */
	private Button bstatus4;
	private Button bquests4;
	private Button bcargo4;
	private Button bgpta4;
	private Button bshipinfoclose;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.shipinfo);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleshipinfo);
      
        bshipinfoclose=(Button)this.findViewById(R.id.specialcargcolose);
        bshipinfoclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent shipinfoclose1=new Intent(shipinformation.this,Commanderstaus.class);
           		startActivity(shipinfoclose1);
        	}
        });
        
        bstatus4=(Button)this.findViewById(R.id.status04);
        bstatus4.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent bstatus11=new Intent(shipinformation.this,Commanderstaus.class);
           		startActivity(bstatus11);
           		}
        });
        bquests4=(Button)this.findViewById(R.id.cargo04);
        bquests4.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent quests4=new Intent(shipinformation.this,quests.class);
           		startActivity(quests4);
        	}
        });
        bcargo4=(Button)this.findViewById(R.id.shipinfo04);
        bcargo4.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent shipinfo1=new Intent(shipinformation.this,cargo.class);
           		startActivity(shipinfo1);
        	}
        });
        bgpta4=(Button)this.findViewById(R.id.gpta04);
        bgpta4.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent gpta4=new Intent(shipinformation.this,gpta.class);
           		startActivity(gpta4);
        	}
        });
    }
}