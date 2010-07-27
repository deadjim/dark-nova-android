package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class QuickStart extends Activity {
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	        setContentView(R.layout.quickstart);
	        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
	        TextView t1=(TextView)this.findViewById(R.id.TextViewTitleName);
	        t1.setText("Quick Start Guide");
	       
	       
	        Button bcargoclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
	        bcargoclose.setOnClickListener(new OnClickListener() {
	        	public void onClick(View v){
	        		//setContentView(R.layout.buyequipment);
	        		Intent ibcargo1=new Intent(QuickStart.this,Gameoptions.class);
	           		startActivity(ibcargo1);
	        	}
	        });
	 }
}
