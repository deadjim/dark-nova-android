package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class gpta extends Activity {
    /** Called when the activity is first created. */
	private Button bgptaclose;
	private Button bstatus5;
	private Button bquests5;
	private Button bshipinfo5;
	private Button bcargo5;
	TextView t1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.gpta);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("GPTA");
       
    
        bgptaclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
        bgptaclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent gpta1=new Intent(gpta.this,Commanderstaus.class);
           		startActivity(gpta1);
        	}
        });
        
        bstatus5=(Button)this.findViewById(R.id.status05);
        bstatus5.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent bstatus11=new Intent(gpta.this,Commanderstaus.class);
           		startActivity(bstatus11);
           		}
        });
        bquests5=(Button)this.findViewById(R.id.quests05);
        bquests5.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent quests5=new Intent(gpta.this,quests.class);
           		startActivity(quests5);
        	}
        });
        bshipinfo5=(Button)this.findViewById(R.id.shipinfo05);
        bshipinfo5.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent shipinfo5=new Intent(gpta.this,shipinformation.class);
           		startActivity(shipinfo5);
        	}
        });
        bcargo5=(Button)this.findViewById(R.id.cargo05);
        bcargo5.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent cargo5=new Intent(gpta.this,cargo.class);
           		startActivity(cargo5);
        	}
        });
    }
  }
