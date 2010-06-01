package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Buycargo extends Activity {
    /** Called when the activity is first created. */
	private Button buycargoclose;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.buycargo);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebuycargo);
      
        buycargoclose=(Button)this.findViewById(R.id.sellequipmentclose);
        buycargoclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent buycargo1=new Intent(Buycargo.this,main.class);
           		startActivity(buycargo1);
        	}
        });
    }
}