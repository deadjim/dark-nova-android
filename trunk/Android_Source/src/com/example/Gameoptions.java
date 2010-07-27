package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Gameoptions extends Activity {
    /** Called when the activity is first created. */
	private Button bclose,bquick,buser,bcredits,applset,indvps;
	TextView t1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.gameoptions);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Game Options");
       
        
        
        bclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
        bclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent bclose1=new Intent(Gameoptions.this,main.class);
           		startActivity(bclose1);
           		}
        });
        
        applset=(Button)this.findViewById(R.id.ApplicationButton01);
        applset.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent appset1=new Intent(Gameoptions.this,Applicationsetting.class);
           		startActivity(appset1);
           		}
        });
        
        indvps=(Button)this.findViewById(R.id.IndivisualButton);
        indvps.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent indvps1=new Intent(Gameoptions.this,indivisualpilotsetting.class);
           		startActivity(indvps1);
           		}
        });
        
        bquick= (Button)this.findViewById(R.id.ButtonQuickStartGuide);
        bquick.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		Intent bquick1 = new Intent(Gameoptions.this,QuickStart.class);
        		startActivity(bquick1);
        	}
        });
        buser= (Button)this.findViewById(R.id.userButton06);
        buser.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		Intent buser1 = new Intent(Gameoptions.this,userguide.class);
        		startActivity(buser1);
        	}
        });
        bcredits= (Button)this.findViewById(R.id.CreditsButton08);
        bcredits.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		Intent bcredits1 = new Intent(Gameoptions.this,credits.class);
        		startActivity(bcredits1);
        	}
        });
        Button ret =(Button)this.findViewById(R.id.retireButton04);
        ret.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		Intent retir1 = new Intent(Gameoptions.this,retire.class);
        		startActivity(retir1);
        	}
        });
    }
}