package com.example;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class shipyard extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	private Button bcommand;
	TextView t1,t2,t3,t4;
	private Button bsellcargo;
	private Button bsysteminfo;
	private Button bshipyardclose;
	private Button bwarp;
	
	AlertDialog alertDialog1;
	Button fuel,fultank,repair,fulrepair,newship,shipinfo,escpod;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.shipyard);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        TextView t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Shipyard");
               
        TextView cash = (TextView)this.findViewById(R.id.TextViewShipyardCashText);
   	    cash.setText(String.valueOf(Globala.credits)+" Cr");
        fuel = (Button)this.findViewById(R.id.ButtonShipyarFuel);
        fuel.setOnClickListener(this); 
        fultank = (Button)this.findViewById(R.id.ButtonShipyardFullTank);
        fultank.setOnClickListener(this);
        repair = (Button)this.findViewById(R.id.ButtonShipyardRepair);
        repair.setOnClickListener(this);
        fulrepair= (Button)this.findViewById(R.id.ButtonShipyardFullRepair);
        fulrepair.setOnClickListener(this); 
        newship = (Button)this.findViewById(R.id.ButtonShipyardBuyNewShip);
        newship.setOnClickListener(this); 
        shipinfo = (Button)this.findViewById(R.id.ButtonShipyardShipInfo);
        shipinfo.setOnClickListener(this);
        escpod = (Button)this.findViewById(R.id.ButtonShipyardBuyEscapePod);
        escpod.setOnClickListener(this);
        
        
        bcommand=(Button)this.findViewById(R.id.command02);
        bcommand.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent command1=new Intent(shipyard.this,main.class);
           		startActivity(command1);
           		}
        });
        bsellcargo=(Button)this.findViewById(R.id.sellcargo02);
        bsellcargo.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent sellcargo1=new Intent(shipyard.this,sellcargo.class);
           		startActivity(sellcargo1);
        	}
        });
        bsysteminfo=(Button)this.findViewById(R.id.systeminfo02);
        bsysteminfo.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent systeminfo1=new Intent(shipyard.this,systeminfo.class);
           		startActivity(systeminfo1);
        	}
        });
        bshipyardclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
        bshipyardclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent bshipyardclose1=new Intent(shipyard.this,main.class);
           		startActivity(bshipyardclose1);
        	}
        });
        bwarp=(Button)this.findViewById(R.id.systeminfo02);
        bwarp.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Intent systeminfo1=new Intent(shipyard.this,systeminfo.class);
           		startActivity(systeminfo1);
        	}
        });
        
    }
    
    void updateView()
    {
    	Button fuel = (Button)this.findViewById(R.id.ButtonShipyarFuel);
        Button fultank = (Button)this.findViewById(R.id.ButtonShipyardFullTank);
        Button repair = (Button)this.findViewById(R.id.ButtonShipyardRepair);
        Button fulrepair= (Button)this.findViewById(R.id.ButtonShipyardFullRepair);
        Button newship = (Button)this.findViewById(R.id.ButtonShipyardBuyNewShip);
        Button shipinfo = (Button)this.findViewById(R.id.ButtonShipyardShipInfo);
        Button escpod = (Button)this.findViewById(R.id.ButtonShipyardBuyEscapePod);
        TextView fuelamnt=(TextView)this.findViewById(R.id.TextViewShipyardFuelAmount);
        TextView fuelcost=(TextView)this.findViewById(R.id.TextViewShipyardFuelCost);
        TextView hulstrength=(TextView)this.findViewById(R.id.TextViewShipyardHullStrength);
        TextView needrepair=(TextView)this.findViewById(R.id.TextViewShipyardNeedRepair);
        TextView newshipinfo = (TextView)this.findViewById(R.id.TextViewShipyardNewShipsInfo);
        TextView escapepod = (TextView)this.findViewById(R.id.TextViewShipyardEscapePod);
    	 TextView cash = (TextView)this.findViewById(R.id.TextViewShipyardCashText);
    	 cash.setText(String.valueOf(Globala.credits)+" Cr");
    	 
    	 if(Globala.getFuel()<Globala.GetFuelTanks())
         {
         	fuel.setVisibility(View.VISIBLE);
         	fultank.setVisibility(View.VISIBLE);
         }
         else
         {
         	fuel.setVisibility(View.INVISIBLE);
         	fultank.setVisibility(View.INVISIBLE);
         }
    	 
    	  if(Globala.getShipHull() < Globala.GetHullStrength())
          {
       
    		  repair.setVisibility(View.VISIBLE);
          	fulrepair.setVisibility(View.VISIBLE);
          
          }
          else
          {
          	repair.setVisibility(View.INVISIBLE);
          	fulrepair.setVisibility(View.INVISIBLE);
          }
    	  if(Globala.getCurrentSystemTechLevelInt()>=Globala.getCurrentShipTechLevel())
          {
          	newship.setVisibility(View.VISIBLE);
          	shipinfo.setVisibility(View.INVISIBLE);
          }
          else
          {
          	newship.setVisibility(View.INVISIBLE);
          	shipinfo.setVisibility(View.INVISIBLE);
          	
          }
    	  
    	  if((Globala.getCurrentSystemTechLevelInt()<Globala.getCurrentShipTechLevel()) || (Globala.toSpend()<2000) || (Globala.escapePod))
          {
          	escpod.setVisibility(View.INVISIBLE);
          }
          else
          {
          	escpod.setVisibility(View.VISIBLE);
          }
    	  
    	  fuelamnt.setText("You have fuel to fly "+String.valueOf(Globala.getFuel())+" parsec");
          
          if(Globala.getFuel()<Globala.GetFuelTanks())
          {
          	int cost = (Globala.GetFuelTanks()-Globala.getFuel())* Globala.getFuelCost();
          	fuelcost.setText("A full tank costs "+String.valueOf(cost)+" cr");
          }
          else
          {
          	fuelcost.setText("Your Tank can not hold more fuel");
          }
          
          float temp= (Globala.getShipHull()*100)/Globala.GetHullStrength();
          hulstrength.setText("Your hull strength is at "+String.valueOf(temp));
          
          if(Globala.getShipHull()<Globala.GetHullStrength())
          {
          	int cost = (Globala.GetHullStrength()-Globala.getShipHull())*Globala.getRepairCost();
          	needrepair.setText("Full repair will cost "+String.valueOf(cost)+" cr");
          }
          else
          {
          	needrepair.setText("No repairs are needed");
          }
          
          if(Globala.getCurrentSystemTechLevelInt()<Globala.getCurrentShipTechLevel())
          {
          	newshipinfo.setText("There are new ships for sale");
          }
          else
          {
          	newshipinfo.setText("No new ships for sale");
          }
          
          if(Globala.escapePod)
          {
          	escapepod.setText("You have an escape pod installed");
          }
          else
          {
          	if (Globala.getCurrentSystemTechLevelInt() < Globala.getCurrentShipTechLevel())
          	{
          		escapepod.setText("No escape pod for sale");
          	}
          	else if(Globala.toSpend()<2000)
          	{
          		escapepod.setText("You need 2000 cr for an escape pod");
          	}
          	else
          		escapepod.setText("You can buy an escape pod for 2000 cr");
          }
    }

	public void onClick(View v) {
		
		if(v==this.fuel)
		{
			final int temp=0;
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(shipyard.this).setView(aview).create();
	     	alertDialog1.show();
			t1= (TextView)aview.findViewById(R.id.SeekLine1);
	     	t1.setText("How much do you want to");
	     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
	     	t2.setText("spend on fuel?");
	     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
	     	t4.setText(String.valueOf((Globala.GetFuelTanks()-Globala.getFuel())* Globala.getFuelCost()));
	
  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
  			s1.setProgress((Globala.GetFuelTanks()-Globala.getFuel())* Globala.getFuelCost());
  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
		    {
			    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
			    {
			    
			    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
			    	alertval.setText(String.valueOf(progress));
			    	
			    }
				public void onStartTrackingTouch(SeekBar seekBar)
				{
				    
				}
				public void onStopTrackingTouch(SeekBar seekBar) 
				{
				   
				}
		    });
			
  			Button purchase = (Button)aview.findViewById(R.id.Seekalertyes);
  			purchase.setText("Purchase");
  			purchase.setOnClickListener(new OnClickListener() 
  			{
  				public void onClick(View v)
  				{
  					Globala.BuyFuel(temp);
  					alertDialog1.cancel();
  					updateView();
  				}
  			});
    		
  			Button cancel =(Button)aview.findViewById(R.id.Seekalertno);
  			cancel.setOnClickListener(new OnClickListener() 
  			{
  				public void onClick(View v)
  				{
  					alertDialog1.cancel();
  				}
  			});
		}
		else if(v==this.fultank)
		{
			Globala.BuyFuel(999);
			updateView();
		}
		else if(v==this.repair)
		{
			final int temp=0;
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(shipyard.this).setView(aview).create();
	     	alertDialog1.show();
			t1= (TextView)aview.findViewById(R.id.SeekLine1);
	     	t1.setText("How much do you want to");
	     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
	     	t2.setText("spend on ?");
	     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
	     	t4.setText(String.valueOf((Globala.GetHullStrength()-Globala.getShipHull())*Globala.getRepairCost()));
	
  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
  			s1.setProgress((Globala.GetHullStrength()-Globala.getShipHull())*Globala.getRepairCost());
  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
		    {
			    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
			    {
			    
			    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
			    	alertval.setText(String.valueOf(progress));
			    	
			    }
				public void onStartTrackingTouch(SeekBar seekBar)
				{
				    
				}
				public void onStopTrackingTouch(SeekBar seekBar) 
				{
				   
				}
		    });
			
  			Button purchase = (Button)aview.findViewById(R.id.Seekalertyes);
  			purchase.setText("Purchase");
  			purchase.setOnClickListener(new OnClickListener() 
  			{
  				public void onClick(View v)
  				{
  					Globala.buyRepairs(temp);
  					alertDialog1.cancel();
  					updateView();
  				}
  			});
    		
  			Button cancel =(Button)aview.findViewById(R.id.Seekalertno);
  			cancel.setOnClickListener(new OnClickListener() 
  			{
  				public void onClick(View v)
  				{
  					alertDialog1.cancel();
  				}
  			});
		}
		
		else if(v==this.fulrepair)
		{
			Globala.buyRepairs(999);
			updateView();
		}
		
		else if(v==this.newship)
		{
			//yet to be implemented
		}
		else if(v==this.shipinfo)
		{
			Intent ishipinfo = new Intent(shipyard.this,ShipInfo.class);
			startActivity(ishipinfo);
		}
		else if(v==this.escpod)
		{
			Globala.escapePod = true;	
			Globala.credits -= 2000;
			updateView();
			

		}
		
		
	}
}