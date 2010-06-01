package com.example;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Buyequip extends Activity {
    /** Called when the activity is first created. */
	private Button bequipmentclose;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.buyequipment);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebuyequip);
    
        bequipmentclose=(Button)this.findViewById(R.id.buyequipmentclose);
        bequipmentclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent buyequipmentclose1=new Intent(Buyequip.this,main.class);
           		startActivity(buyequipmentclose1);
        	}
        });
    }
  }
