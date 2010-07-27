package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class credits extends Activity {
    /** Called when the activity is first created. */
	private Button bclose;
	
	TextView t1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.credits);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Credits");
         
        bclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
        bclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		
        		Intent b1=new Intent(credits.this,Gameoptions.class);
           		startActivity(b1);
        	}
        });
        
     
        
    }
  }
