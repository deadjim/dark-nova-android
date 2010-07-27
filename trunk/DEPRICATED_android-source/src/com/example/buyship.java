package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


	public class buyship extends Activity {
	    /** Called when the activity is first created. */
		private Button back;
		private TextView t1;
		
		private Button b1;
		
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	        setContentView(R.layout.other);
	        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
	        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
	        t1.setText("Buy Ship");
	        
	        
}
}