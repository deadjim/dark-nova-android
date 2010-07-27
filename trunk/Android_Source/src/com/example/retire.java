package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class retire extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.retire);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        TextView t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("End Game");

        Button bc=(Button)this.findViewById(R.id.endgameButton01);
        bc.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent bclose1=new Intent(retire.this,NewCommander1.class);
           		startActivity(bclose1);
           		}
        });
}
}