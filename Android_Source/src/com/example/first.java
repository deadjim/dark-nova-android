package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class first extends Activity {
    /** Called when the activity is first created. */
	TextView t1;
	Button b1,b2,b3,binv;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("WELCOME");
        binv=b1=(Button)this.findViewById(R.id.ButtonTitleCLose);
        b1.setVisibility(View.INVISIBLE);
        
        b1=(Button)this.findViewById(R.id.New01);
        b1.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//MediaPlayer mp=new MediaPlayer();
               
        		//setContentView(R.layout.buyequipment);
        		Intent new1=new Intent(first.this,NewCommander1.class);
           		startActivity(new1);
        	}
        	
        });
        b2=(Button)this.findViewById(R.id.Load01);
        b2.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent Load1=new Intent(first.this,loadgame.class);
           		startActivity(Load1);
        	}
        });
        b3=(Button)this.findViewById(R.id.Jump01);
        b3.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		//Intent Jump1=new Intent(first.this,NewCommander1.class);
           	//	startActivity(Jump1);
        	}
        });
        
    }
}