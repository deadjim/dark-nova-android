package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class shipinformation extends Activity {
    /** Called when the activity is first created. */
	private Button bstatus4;
	private Button bquests4;
	private Button bcargo4;
	private Button bgpta4;
	private Button bshipinfoclose;
	private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.shipinfo);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        TextView t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Ship Information");
       
      
        bshipinfoclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
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
        Globala gbuy=new Globala();
        t1=(TextView)this.findViewById(R.id.TextViewName);
     //     t1.setText(gbuy.getShipName(shipindex)); 
        t2=(TextView)this.findViewById(R.id.SizeTextView);    
    //	t2.setText(getShipSize(shipIndex));
    	t3=(TextView)this.findViewById(R.id.CargoTextView);
    	//t3.setText(getShipCargoBays(shipIndex));
    	t4=(TextView)this.findViewById(R.id.RangeTextView);
        //  t4.setText( getShipRange(shipIndex));	
    	t5=(TextView)this.findViewById(R.id.HullTextView);
    //  t4.setText(getShipHullStrength:shipIndex]];	
    	t6=(TextView)this.findViewById(R.id.WeaponTextView);
        //  t4.setText( getShipWeaponSlots:shipIndex]];
    	//t7=(TextView)this.findViewById(R.id.HullTextView);
        //  
    	t8=(TextView)this.findViewById(R.id.ShieldTextView);
    	//t4.setText( getShipShieldSlots:shipIndex]];
        //  
    	t9=(TextView)this.findViewById(R.id.GadgetTextView);
    	//t4.setText(getShipGadgetSlots:shipIndex]];
        		
    	t10=(TextView)this.findViewById(R.id.CrewTextView);
    //  t4.setText(getShipCrewQuarters:shipIndex]];	
        //  t4.setText(getShipImageNameBg:shipIndex]];


    }
}