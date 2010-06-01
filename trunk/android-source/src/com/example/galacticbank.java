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

public class galacticbank extends Activity {
    /** Called when the activity is first created. */
	private Button bwithdrawcash;
	private Button bbankloan;
	private Button bdepositcash;
	private Button bgalacticbank;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.galacticbank);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlegbank);
        main m1=new main();
        
        bgalacticbank=(Button)this.findViewById(R.id.galacticbankclose);
        bgalacticbank.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent bgalacticbank1=new Intent(galacticbank.this,main.class);
           		startActivity(bgalacticbank1);
        	}
        });
   //     if(m1.currentcash==0){
	//	    bdepositcash=(Button) findViewById(R.id.depositcash);
	//        bdepositcash.setVisibility(View.INVISIBLE);
	//	}
        if(m1.bankdeposit==0){
		    bwithdrawcash=(Button) findViewById(R.id.withdrawcash);
	        bwithdrawcash.setVisibility(View.INVISIBLE);
		}
		if(m1.bankloan==0){
		    bbankloan=(Button) findViewById(R.id.paybank);
	        bbankloan.setVisibility(View.INVISIBLE);
		}
		if(m1.bankloan!=0){
		    bbankloan=(Button) findViewById(R.id.getloan);
	        bbankloan.setVisibility(View.INVISIBLE);
		}
        
		bdepositcash=(Button)this.findViewById(R.id.depositcash);
        bdepositcash.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		AlertDialog.Builder alt_bld = new AlertDialog.Builder(galacticbank.this);
        		alt_bld.setMessage("How much you want to deposit into your GSEDB ? Selected amount")  
        	       .setTitle("Notice")  
        	       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {  
        	        public void onClick(DialogInterface dialog, int id) {  
        	        // Action for 'Yes' Button  
        	         }  
        	         })  
        	         .setNegativeButton("No", new DialogInterface.OnClickListener() {  
        	         public void onClick(DialogInterface dialog, int id) {  
        	         //  Action for 'NO' Button  
        	         dialog.cancel();  
        	         }  
        	         });  
        	         AlertDialog alert = alt_bld.create();  
        	        // Title for AlertDialog  
        	         alert.setTitle("Notice");  
        	         // Icon for AlertDialog   
        	         alert.show();  
        	         }  
        	        
        	
        });
    }
}