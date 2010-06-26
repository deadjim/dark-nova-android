package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class cargo extends Activity {
    /** Called when the activity is first created. */
	private Button bcargoclose;
	private Button bstatus3;
	private Button bquests3;
	private Button bshipinfo3;
	private Button bgpta3;
	TextView t1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.specialcargo);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Special Cargo");
       
    
        bcargoclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
        bcargoclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent ibcargo1=new Intent(cargo.this,Commanderstaus.class);
           		startActivity(ibcargo1);
        	}
        });
        
        bstatus3=(Button)this.findViewById(R.id.status03);
        bstatus3.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent bstatus11=new Intent(cargo.this,Commanderstaus.class);
           		startActivity(bstatus11);
           		}
        });
        bquests3=(Button)this.findViewById(R.id.cargo03);
        bquests3.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent quests3=new Intent(cargo.this,quests.class);
           		startActivity(quests3);
        	}
        });
        bshipinfo3=(Button)this.findViewById(R.id.shipinfo03);
        bshipinfo3.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent shipinfo1=new Intent(cargo.this,shipinformation.class);
           		startActivity(shipinfo1);
        	}
        });
        bgpta3=(Button)this.findViewById(R.id.gpta03);
        bgpta3.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent gpta3=new Intent(cargo.this,gpta.class);
           		startActivity(gpta3);
        	}
        });
    }
  }
