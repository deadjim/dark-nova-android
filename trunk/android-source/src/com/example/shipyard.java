package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class shipyard extends Activity {
    /** Called when the activity is first created. */
	private Button bcommand,buyfuel,buyfullfuel,buyrepair,buyfullrepair,buynewship,buyescpaepod;
	private Button bsellcargo;
	private Button bsysteminfo;
	private Button bshipyardclose;
	private Button bwarp;
	Globala gbuy = new Globala();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.shipyard);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        TextView t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Shipyard");
       
    
        TextView cash = (TextView)this.findViewById(R.id.TextViewShipyardCashText);
  //      cash.setText(" "+Global.Credits+" cr");
        
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
       /*
        if(gbuy.getFuel()<gbuy.GetFuelTanks())
        {
        	fuel.setVisibility(View.VISIBLE);
        	fultank.setVisibility(View.VISIBLE);
        }
        else
        {
        	fuel.setVisibility(View.INVISIBLE);
        	fultank.setVisibility(View.INVISIBLE);
        }
        
        if(gbuy.getShipHull() < gbuy.GetHullStrength())
        {
        	repair.setVisibility(View.VISIBLE);
        	fulrepair.setVisibility(View.VISIBLE);
        
        }
        else
        {
        	repair.setVisibility(View.INVISIBLE);
        	fulrepair.setVisibility(View.INVISIBLE);
        }
        
       if(gbuy.getCurrentSystemTechLevelInt()>=gbuy.getCurrentShipTechLevel())
        {
        	newship.setVisibility(View.VISIBLE);
        	shipinfo.setVisibility(View.INVISIBLE);
        }
        else
        {
        	newship.setVisibility(View.INVISIBLE);
        	shipinfo.setVisibility(View.INVISIBLE);
        	
        }
        
        if((gbuy.getCurrentSystemTechLevelInt()<gbuy.getCurrentShipTechLevel()) || (gbuy.toSpend()<2000) || (gbuy.escapePod))
        {
        	escpod.setVisibility(View.INVISIBLE);
        }
        else
        {
        	escpod.setVisibility(View.VISIBLE);
        }
        	
        fuelamnt.setText("You have fuel to fly "+gbuy.getFuel()+" parsec");
        
        if(gbuy.getFuel()<gbuy.GetFuelTanks())
        {
        	int cost = (gbuy.GetFuelTanks()-gbuy.getFuel())* gbuy.getFuelCost();
        	fuelcost.setText("A full tank costs "+cost+" cr");
        }
        else
        {
        	fuelcost.setText("Your Tank can not hold more fuel");
        }
        	
        float temp= (gbuy.getShipHull()*100)/gbuy.GetHullStrength();
        hulstrength.setText("Your hull strength is at "+temp);
        
        if(gbuy.getShipHull()<gbuy.GetHullStrength())
        {
        	int cost = (gbuy.GetHullStrength()-gbuy.getShipHull())*gbuy.getRepairCost();
        	needrepair.setText("Full repair will cost "+cost+" cr");
        }
        else
        {
        	needrepair.setText("No repairs are needed");
        }
        	
        if(gbuy.getCurrentSystemTechLevelInt()<gbuy.getCurrentShipTechLevel())
        {
        	newshipinfo.setText("There are new ships for sale");
        }
        else
        {
        	newshipinfo.setText("No new ships for sale");
        }
        
        if(gbuy.escapePod)
        {
        	escapepod.setText("You have an escape pod installed");
        }
        
        else 
        	if (gbuy.getCurrentSystemTechLevelInt() < gbuy.getCurrentShipTechLevel())
        	{
        		escapepod.setText("No escape pod for sale");
        	}
        	else if(gbuy.toSpend()<2000)
        	{
        		escapepod.setText("You need 2000 cr for an escape pod");
        	}
        	else
        		escapepod.setText("You can buy an escape pod for 2000 cr");
        
        fuel = (Button)this.findViewById(R.id.ButtonShipyarFuel);
        fuel.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert
           		}
        }); 
       
        fultank = (Button)this.findViewById(R.id.ButtonShipyardFullTank);
        fultank.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		gbuy.BuyFuel(999);

           		}
        }); 
        repair = (Button)this.findViewById(R.id.ButtonShipyardRepair);
        repair.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert
           		}
        }); 
         fulrepair= (Button)this.findViewById(R.id.ButtonShipyardFullRepair);
         fulrepair.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert
           		}
        }); 
        newship = (Button)this.findViewById(R.id.ButtonShipyardBuyNewShip);
        newship.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert
           		}
        }); 
        shipinfo = (Button)this.findViewById(R.id.ButtonShipyardShipInfo);
        shipinfo.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert
           		}
        }); 
        escpod = (Button)this.findViewById(R.id.ButtonShipyardBuyEscapePod);
        escpod.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert
           		}
        }); 
        
        
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
        bshipyardclose=(Button)this.findViewById(R.id.shipyardclose);
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
        */
    }
}