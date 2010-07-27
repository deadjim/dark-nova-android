package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Commanderlog extends Activity {
    /** Called when the activity is first created. */
	private Button bclose;
	private Button bedit;
	TextView t1;
	EditText e1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.commanderlog);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlesecond);
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Commander Log");
        bedit=(Button)this.findViewById(R.id.ButtonTitleedit);
        bedit.setText("Edit");
        
        bclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
        bclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent bclose1=new Intent(Commanderlog.this,Commanderstaus.class);
           		startActivity(bclose1);
           		}
        });
        bedit=(Button)this.findViewById(R.id.ButtonTitleedit);
        bedit.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		updtbutton();
           		}
        });
    }
        public void updtbutton()
        {
        	 bedit=(Button)this.findViewById(R.id.ButtonTitleedit);
        	 String a;
        	 a=(String) bedit.getText();
        	 if(a=="Save")
        	 {
        		 e1=(EditText)this.findViewById(R.id.EditTextlog);
        		 e1.setVisibility(View.VISIBLE);
     	        		bedit.setText("Edit");
     	        		
        	 }
        	 if(a=="Edit" )
        	 {
        		 Log.v("LOG_TAG" ,"text "+a);
        		 e1=(EditText)this.findViewById(R.id.EditTextlog);
        		 e1.setVisibility(View.INVISIBLE);
            		bedit.setText("Save");
        	    
        	 }
        }
        	
        	
}