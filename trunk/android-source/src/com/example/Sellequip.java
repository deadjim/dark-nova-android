package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Sellequip extends Activity {
    /** Called when the activity is first created. */
	private Button sellequipmentclose;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.sellequipments);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlesellequip);
      
        sellequipmentclose=(Button)this.findViewById(R.id.sellequipmentclose);
        sellequipmentclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent sellequipmentclose1=new Intent(Sellequip.this,main.class);
           		startActivity(sellequipmentclose1);
        	}
        });
    }
}