package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Personnel extends Activity {
    /** Called when the activity is first created. */
	private Button bpersonnel;
	TextView t1,t2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.personnel);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Peronnel Rooster");
       
        
        bpersonnel=(Button)this.findViewById(R.id.ButtonTitleCLose);
        bpersonnel.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent bg1=new Intent(Personnel.this,main.class);
           		startActivity(bg1);
        	}
        });
        t2=(TextView)this.findViewById(R.id.creditTextView06);
        t2.setText(String.valueOf(Globala.credits));
    }
}