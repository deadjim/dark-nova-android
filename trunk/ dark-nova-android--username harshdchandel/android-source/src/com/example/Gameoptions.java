package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Gameoptions extends Activity {
    /** Called when the activity is first created. */
	private Button bclose;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.gameoptions);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlegameoptions);
        
        bclose=(Button)this.findViewById(R.id.gameoptionclose);
        bclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent bclose1=new Intent(Gameoptions.this,main.class);
           		startActivity(bclose1);
           		}
        });
        
    }
}