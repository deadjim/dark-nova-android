package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ShipInfo extends Activity {
	private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	        setContentView(R.layout.shipinfo);
	        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
	        TextView t1=(TextView)this.findViewById(R.id.TextViewTitleName);
	        t1.setText("Ship Info");
	        
	        
	        Button bshipinfoclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
	        bshipinfoclose.setOnClickListener(new OnClickListener() {
	        	public void onClick(View v){
	        		//setContentView(R.layout.buyequipment);
	        		Intent shipinfoclose1=new Intent(ShipInfo.this,Commanderstaus.class);
	           		startActivity(shipinfoclose1);
	        	}
	        });
	        
	        Button bstatus4=(Button)this.findViewById(R.id.status04);
	        bstatus4.setOnClickListener(new OnClickListener() {
	        	public void onClick(View v){
	        		Intent bstatus11=new Intent(ShipInfo.this,Commanderstaus.class);
	           		startActivity(bstatus11);
	           		}
	        });
	        Button bquests4=(Button)this.findViewById(R.id.cargo04);
	        bquests4.setOnClickListener(new OnClickListener() {
	        	public void onClick(View v){
	        		Intent quests4=new Intent(ShipInfo.this,quests.class);
	           		startActivity(quests4);
	        	}
	        });
	        Button bcargo4=(Button)this.findViewById(R.id.shipinfo04);
	        bcargo4.setOnClickListener(new OnClickListener() {
	        	public void onClick(View v){
	        		Intent shipinfo1=new Intent(ShipInfo.this,cargo.class);
	           		startActivity(shipinfo1);
	        	}
	        });
	        Button bgpta4=(Button)this.findViewById(R.id.gpta04);
	        bgpta4.setOnClickListener(new OnClickListener() {
	        	public void onClick(View v){
	        		Intent gpta4=new Intent(ShipInfo.this,gpta.class);
	           		startActivity(gpta4);
	        	}
	        });
	       
	        t1=(TextView)this.findViewById(R.id.NameTextShip);
	        t1.setText(Globala.getShipName(1)); 
	        t2=(TextView)this.findViewById(R.id.SizeTextView);    
	    	t2.setText(String.valueOf(Globala.getShipSize(1)));
	    	t3=(TextView)this.findViewById(R.id.CargoTextView);
	    	t3.setText(String.valueOf(Globala.getShipCargoBays(1)));
	    	t4=(TextView)this.findViewById(R.id.RangeTextView);
	        t4.setText(String.valueOf( Globala.getShipRange(1)));	
	    	t5=(TextView)this.findViewById(R.id.HullTextView);
	        t5.setText(String.valueOf(Globala.getShipHullStrength(1)));	
	    	t6=(TextView)this.findViewById(R.id.WeaponTextView);
	        t6.setText(String.valueOf( Globala.getShipWeaponSlots(1)));
	    	t7=(TextView)this.findViewById(R.id.HullTextView);
	    	t7.setText(String.valueOf( Globala.getShipWeaponSlots(1)));
	    	t8=(TextView)this.findViewById(R.id.ShieldTextView);
	    	t8.setText( String.valueOf(Globala.getShipShieldSlots(1)));
	          
	    	t9=(TextView)this.findViewById(R.id.GadgetTextView);
	    	t9.setText(String.valueOf(Globala.getShipGadgetSlots(1)));
	        		
	    	t10=(TextView)this.findViewById(R.id.CrewTextView);
	    	t10.setText( String.valueOf(Globala.getShipWeaponSlots(1)));


	 }
}
