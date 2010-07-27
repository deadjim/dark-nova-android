package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class quests extends Activity {
    /** Called when the activity is first created. */
	private Button bactivequestsclose;
	private Button bstatus2;
	private Button bcargo2;
	private Button bshipinfo2;
	private Button bgpta2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activequests);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        TextView t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Quests");
       
    
        bactivequestsclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
        bactivequestsclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent bactivequests1=new Intent(quests.this,main.class);
           		startActivity(bactivequests1);
        	}
        });
        
        bstatus2=(Button)this.findViewById(R.id.status02);
        bstatus2.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent bstatus11=new Intent(quests.this,Commanderstaus.class);
           		startActivity(bstatus11);
           		}
        });
        bcargo2=(Button)this.findViewById(R.id.cargo02);
        bcargo2.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent bcargo1=new Intent(quests.this,cargo.class);
           		startActivity(bcargo1);
        	}
        });
        bshipinfo2=(Button)this.findViewById(R.id.shipinfo02);
        bshipinfo2.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent shipinfo1=new Intent(quests.this,ShipInfo.class);
           		startActivity(shipinfo1);
        	}
        });
        bgpta2=(Button)this.findViewById(R.id.gpta02);
        bgpta2.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent gpta1=new Intent(quests.this,gpta.class);
           		startActivity(gpta1);
        	}
        });
        TextView t3=(TextView)this.findViewById(R.id.questsTextView);
        t3.setText(Globala.drawQuestsForm());
        
    }
  }
