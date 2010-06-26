package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class gamename extends Activity {
    /** Called when the activity is first created. */
	private Button gameback;
	private Button warp1;
	TextView t1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.other);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Game Names");
       
      
        gameback=(Button)this.findViewById(R.id.ButtonTitleCLose);
        gameback.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent gameback1=new Intent(gamename.this,shortrangechart.class);
           		startActivity(gameback1);
        	}
        });
        warp1=(Button)this.findViewById(R.id.ButtonWARP);
        warp1.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent gameback1=new Intent(gamename.this,encounter.class);
           		startActivity(gameback1);
        	}
        });
        
    }
}