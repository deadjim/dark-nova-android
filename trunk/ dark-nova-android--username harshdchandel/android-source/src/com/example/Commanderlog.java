package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Commanderlog extends Activity {
    /** Called when the activity is first created. */
	private Button bclose;
	private Button bedit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.commanderlog);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlecommanderlog);
        
        bclose=(Button)this.findViewById(R.id.commanderlogclose);
        bclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent bclose1=new Intent(Commanderlog.this,Commanderstaus.class);
           		startActivity(bclose1);
           		}
        });
        bedit=(Button)this.findViewById(R.id.commanderlogedit);
        bedit.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		
           		}
        });
    }
}