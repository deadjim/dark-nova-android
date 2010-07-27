package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class main extends Activity {
    /** Called when the activity is first created. */
	private Button buycargo;
	private Button bequipment;
	private Button sequipment;
	private Button gbank;
	private Button personnelr;
	private Button bcommanderstatus;
	private Button gameoption;
	private Button bshipyard;
	private Button bsellcargo;
	private Button bsysteminfo;
	private Button bwarp1,bnew;
	
	/*
	public static int currentcash=0;
	public static int  bankloan=0;
	public static int bankdeposit=0;
	
	
	
	
	public static long pulselaser=0;
	public static long disrupter=0;
	public static long justicemrk4=0;
	public static long energyshield=0;
	public static long reflectionshield=0;
	public static long extra5cargo=0;
	public static long autorepairsystem=0;
	public static long navigatingsystem=0;
	public static long targetingsystem=0;
	public static long cloakingdevice=0;
	public static long water=0;
	public static long food=0;
	public static long furs=0;
	public static long ore=0;
	public static long games=0;
	public static long firearms=0;
	public static long medicine=0;
	public static long machine=0;
	public static long narcotics=0;
	public static long robots=0;
	*/
	public int m=0;
	TextView t1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.commanderpad);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Commander Pad");
        Button b=(Button)this.findViewById(R.id.ButtonTitleCLose);
        b.setVisibility(View.INVISIBLE);
       
        TextView Name= (TextView)this.findViewById(R.id.textcommandername1);
        Name.setText(Globala.CommanderName);
         buycargo=(Button)this.findViewById(R.id.Button03);
        buycargo.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
       		setContentView(R.layout.buycargo);
       		Intent buycargo1=new Intent(main.this,Buycargo.class);
       		startActivity(buycargo1);
       		
      	}
      });
       bnew = (Button)this.findViewById(R.id.ButtonNewCommander);
       bnew.setVisibility(View.INVISIBLE);
       /* bnew.setOnClickListener(new OnClickListener() {
    	   public void onClick(View v)
    	   {
    		   setContentView(R.layout.newcommander);
    		   Intent newcom = new Intent(main.this,NewCommander1.class);
    		   startActivity(newcom);
    	   }
       });*/
        bequipment=(Button)this.findViewById(R.id.Button01);
        bequipment.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		setContentView(R.layout.buyequipment);
        		Intent buyequipment1=new Intent(main.this,Buyequip.class);
           		startActivity(buyequipment1);
        	}
        });
        
        sequipment=(Button)this.findViewById(R.id.Button02);
        sequipment.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		setContentView(R.layout.sellequipments);
        		Intent sellequipment=new Intent(main.this,Sellequip.class);
           		startActivity(sellequipment);
        	}
        });
        gbank=(Button)this.findViewById(R.id.Button04);
        gbank.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v){       		
        		Intent gbank1=new Intent(main.this,galacticbank.class);
           		startActivity(gbank1);
        	}
        });
        
        personnelr=(Button)this.findViewById(R.id.Button05);
        personnelr.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		setContentView(R.layout.personnel);
        		Intent personnelroos=new Intent(main.this,Personnel.class);
           		startActivity(personnelroos);
        	}
        });
        bcommanderstatus=(Button)this.findViewById(R.id.Button06);
        bcommanderstatus.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		setContentView(R.layout.commanderstatus);
        		Intent commander1=new Intent(main.this,Commanderstaus.class);
           		startActivity(commander1);
        	}
        });
        gameoption=(Button)this.findViewById(R.id.Button08);
        gameoption.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        	//	setContentView(R.layout.gameoptions);
        		Intent gameoption1=new Intent(main.this,Gameoptions.class);
           		startActivity(gameoption1);
        	}
        });
        bshipyard=(Button)this.findViewById(R.id.shipyard1);
        bshipyard.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent ishipyard=new Intent(main.this,shipyard.class);
           		startActivity(ishipyard);
           		}
        });
        bsellcargo=(Button)this.findViewById(R.id.sellcargo1);
        bsellcargo.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent sellcargo1=new Intent(main.this,sellcargo.class);
           		startActivity(sellcargo1);
        	}
        });
        bsysteminfo=(Button)this.findViewById(R.id.systeminfo1);
        bsysteminfo.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent systeminfo1=new Intent(main.this,systeminfo.class);
           		startActivity(systeminfo1);
        	}
        });
        bwarp1=(Button)this.findViewById(R.id.warp1);
        bwarp1.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		
        		Intent warp1=new Intent(main.this,shortrangechart.class);
           		startActivity(warp1);
        	}
        });
        Button bsave=(Button)this.findViewById(R.id.savegameButton09);
        bsave.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		
        		Intent save1=new Intent(main.this,saveitems.class);
           		startActivity(save1);
        	}
        });
        Button bload=(Button)this.findViewById(R.id.loadgameButton010);
        bload.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		
        		Intent load1=new Intent(main.this,loadgame.class);
           		startActivity(load1);
        	}
        });
      
        
    }
}