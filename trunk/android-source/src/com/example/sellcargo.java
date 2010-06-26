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

public class sellcargo extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	private Button bcommand;
	private Button bshipyard;
	private Button bsysteminfo;
	private Button bsellcargoclose;
	private Button bwarp;
	private TextView t1,t2,t3,t4,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
	private Button buy1,buy2,buy3,buy4,buy5,buy6,buy7,buy8,buy9,buy10,buy11,buy12,buy13,buy14,buy15,buy16,buy17,buy18,buy19,buy20;
	public boolean bOpponent,bJettison;
	AlertDialog alertDialog1;
	public int val;
	Globala gbuy=new Globala();
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.sellcargo);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        TextView t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Sell Cargo");
       
      
        bcommand=(Button)this.findViewById(R.id.command03);
        bcommand.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		Intent command1=new Intent(sellcargo.this,main.class);
           		startActivity(command1);
           	}
       });
       bshipyard=(Button)this.findViewById(R.id.shipyard03);
       bshipyard.setOnClickListener(new OnClickListener() 
       {
        	public void onClick(View v)
        	{
        		Intent ishipyard1=new Intent(sellcargo.this,shipyard.class);
           		startActivity(ishipyard1);
        	}
        });
        bsysteminfo=(Button)this.findViewById(R.id.systeminfo03);
        bsysteminfo.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		Intent systeminfo1=new Intent(sellcargo.this,systeminfo.class);
           		startActivity(systeminfo1);
        	}
        });
        bsellcargoclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
        bsellcargoclose.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		Intent sellcargoclose1=new Intent(sellcargo.this,main.class);
           		startActivity(sellcargoclose1);
        	}
        });
        bwarp=(Button)this.findViewById(R.id.warp03);
        bwarp.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		Intent warp1=new Intent(sellcargo.this,shortrangechart.class);
           		startActivity(warp1);
        	}
        });
        buy1=(Button) this.findViewById(R.id.SellButton01);
        buy1.setOnClickListener(this);
        buy11=(Button) this.findViewById(R.id.SellButton11);
        buy11.setOnClickListener(this);
        buy2=(Button) this.findViewById(R.id.SellButton02);
        buy2.setOnClickListener(this);
        buy12=(Button) this.findViewById(R.id.SellButton12);
        buy12.setOnClickListener(this);
        buy3=(Button) this.findViewById(R.id.SellButton03);
        buy3.setOnClickListener(this);
        buy13=(Button) this.findViewById(R.id.SellButton13);
        buy13.setOnClickListener(this);
        buy4=(Button) this.findViewById(R.id.SellButton04);
        buy4.setOnClickListener(this);
        buy14=(Button) this.findViewById(R.id.SellButton14);
        buy14.setOnClickListener(this);
        buy5=(Button) this.findViewById(R.id.SellButton05);
        buy5.setOnClickListener(this);
        buy15=(Button) this.findViewById(R.id.SellButton15);
        buy15.setOnClickListener(this);
        buy6=(Button) this.findViewById(R.id.SellButton06);
        buy6.setOnClickListener(this);
        buy16=(Button) this.findViewById(R.id.SellButton16);
        buy16.setOnClickListener(this);
        buy7=(Button) this.findViewById(R.id.SellButton07);
        buy7.setOnClickListener(this);
        buy17=(Button) this.findViewById(R.id.SellButton17);
        buy17.setOnClickListener(this);
        buy8=(Button) this.findViewById(R.id.SellButton08);
        buy8.setOnClickListener(this);
        buy18=(Button) this.findViewById(R.id.SellButton18);
        buy18.setOnClickListener(this);
        buy9=(Button) this.findViewById(R.id.SellButton09);
        buy9.setOnClickListener(this);
        buy19=(Button) this.findViewById(R.id.SellButton19);
        buy19.setOnClickListener(this);
        buy10=(Button) this.findViewById(R.id.SellButton10);
        buy10.setOnClickListener(this);
        buy20=(Button) this.findViewById(R.id.SellButton20);
        buy20.setOnClickListener(this);
    }
   public void updateView()
    {
    	if(gbuy.getSellPrice(0) > 0 )
        {    
        	if(bOpponent)
        	{
    	           buy1=(Button) this.findViewById(R.id.SellButton01);
    	           buy1.setText(String.valueOf(gbuy.getAmountToSell(0)));
    	           
        	}
        	else{
        		buy1=(Button) this.findViewById(R.id.SellButton01);
 	           buy1.setText(String.valueOf(gbuy.getOpponentAmountToSell(0)));
        	}
        	 t11=(TextView) this.findViewById(R.id.SellTextView11);
    		 t11.setText(String.valueOf(gbuy.getSellPrice(0)));
    		 buy11 =(Button)this.findViewById(R.id.SellButton11);
    	        buy11.setVisibility(View.VISIBLE);
        }
    	else
    	{
    		buy1=(Button) this.findViewById(R.id.SellButton01);
   	        buy1.setVisibility(View.INVISIBLE);
   	        buy11 =(Button)this.findViewById(R.id.SellButton11);
   	        buy11.setVisibility(View.INVISIBLE);
    		t11=(TextView) this.findViewById(R.id.SellTextView11);
    		t11.setText("no trade");
    	}
    	if(gbuy.getSellPrice(1) > 0 )
    	{    
        	if(bOpponent)
        	{
    	           buy2=(Button) this.findViewById(R.id.SellButton02);
    	           buy2.setText(String.valueOf(gbuy.getAmountToSell(0)));
        	}
        	else{
        		buy2=(Button) this.findViewById(R.id.SellButton02);
 	           buy2.setText(String.valueOf(gbuy.getOpponentAmountToSell(0)));
        	}
        	 buy12 =(Button)this.findViewById(R.id.SellButton12);
 	        buy12.setVisibility(View.VISIBLE);
        	 t12=(TextView) this.findViewById(R.id.SellTextView12);
    		 t12.setText(String.valueOf(gbuy.getSellPrice(0)));
        }
    	else
    	{
    		buy2=(Button) this.findViewById(R.id.SellButton02);
   	        buy2.setVisibility(View.INVISIBLE);
   	        buy12 =(Button)this.findViewById(R.id.SellButton12);
	        buy12.setVisibility(View.INVISIBLE);
    		t12=(TextView) this.findViewById(R.id.SellTextView12);
    		t12.setText("no trade");
    	}
    	
    	if(gbuy.getSellPrice(2) > 0 )	
    	{    
        	if(bOpponent)
        	{
    	           buy3=(Button) this.findViewById(R.id.SellButton03);
    	           buy3.setText(String.valueOf(gbuy.getAmountToSell(0)));
        	}
        	else{
        		buy3=(Button) this.findViewById(R.id.SellButton03);
 	           buy3.setText(String.valueOf(gbuy.getOpponentAmountToSell(0)));
        	}
        	 buy13 =(Button)this.findViewById(R.id.SellButton13);
 	        buy13.setVisibility(View.VISIBLE);
        	 t13=(TextView) this.findViewById(R.id.SellTextView13);
    		 t13.setText(String.valueOf(gbuy.getSellPrice(0)));
        }
    	else
    	{
    		buy3=(Button) this.findViewById(R.id.SellButton03);
   	        buy3.setVisibility(View.INVISIBLE);
   	        buy13 =(Button)this.findViewById(R.id.SellButton13);
	        buy13.setVisibility(View.INVISIBLE);
    		t13=(TextView) this.findViewById(R.id.SellTextView13);
    		t13.setText("no trade");
    	}
    	if(gbuy.getSellPrice(3) > 0 )
    	{    
        	if(bOpponent)
        	{
    	           buy4=(Button) this.findViewById(R.id.SellButton04);
    	           buy4.setText(String.valueOf(gbuy.getAmountToSell(0)));
        	}
        	else{
        		buy4=(Button) this.findViewById(R.id.SellButton04);
 	           buy4.setText(String.valueOf(gbuy.getOpponentAmountToSell(0)));
        	}
        	 buy14 =(Button)this.findViewById(R.id.SellButton14);
 	        buy14.setVisibility(View.VISIBLE);
        	 t14=(TextView) this.findViewById(R.id.SellTextView14);
    		 t14.setText(String.valueOf(gbuy.getSellPrice(0)));
        }
    	else
    	{
    		buy4=(Button) this.findViewById(R.id.SellButton04);
   	        buy4.setVisibility(View.INVISIBLE);
   	     buy14 =(Button)this.findViewById(R.id.SellButton14);
	        buy12.setVisibility(View.INVISIBLE);
    		t14=(TextView) this.findViewById(R.id.SellTextView14);
    		t14.setText("no trade");
    	}
    	if(gbuy.getSellPrice(4) > 0 )
    	{    
        	if(bOpponent)
        	{
    	           buy5=(Button) this.findViewById(R.id.SellButton05);
    	           buy5.setText(String.valueOf(gbuy.getAmountToSell(0)));
        	}
        	else{
        		buy5=(Button) this.findViewById(R.id.SellButton05);
 	           buy5.setText(String.valueOf(gbuy.getOpponentAmountToSell(0)));
        	}
        	 buy15 =(Button)this.findViewById(R.id.SellButton15);
 	        buy15.setVisibility(View.VISIBLE);
        	 t15=(TextView) this.findViewById(R.id.SellTextView15);
    		 t15.setText(String.valueOf(gbuy.getSellPrice(0)));
        }
    	else
    	{
    		buy5=(Button) this.findViewById(R.id.SellButton05);
   	        buy5.setVisibility(View.INVISIBLE);
   	        buy15 =(Button)this.findViewById(R.id.SellButton15);
	        buy15.setVisibility(View.INVISIBLE);
    		t15=(TextView) this.findViewById(R.id.SellTextView15);
    		t15.setText("no trade");
    	}
    	if(gbuy.getSellPrice(5) > 0 )
    	{    
        	if(bOpponent)
        	{
    	           buy6=(Button) this.findViewById(R.id.SellButton06);
    	           buy6.setText(String.valueOf(gbuy.getAmountToSell(0)));
        	}
        	else{
        		buy6=(Button) this.findViewById(R.id.SellButton06);
 	           buy6.setText(String.valueOf(gbuy.getOpponentAmountToSell(0)));
        	}
        	 buy16 =(Button)this.findViewById(R.id.SellButton16);
 	        buy16.setVisibility(View.VISIBLE);
        	 t16=(TextView) this.findViewById(R.id.SellTextView16);
    		 t16.setText(String.valueOf(gbuy.getSellPrice(0)));
        }
    	else
    	{
    		buy6=(Button) this.findViewById(R.id.SellButton06);
   	        buy6.setVisibility(View.INVISIBLE);
   	     buy16 =(Button)this.findViewById(R.id.SellButton16);
	        buy16.setVisibility(View.INVISIBLE);
    		t16=(TextView) this.findViewById(R.id.SellTextView16);
    		t16.setText("no trade");
    	}
    		
    	if(gbuy.getSellPrice(6) > 0 )
    	{    
        	if(bOpponent)
        	{
    	           buy7=(Button) this.findViewById(R.id.SellButton07);
    	           buy7.setText(String.valueOf(gbuy.getAmountToSell(0)));
        	}
        	else{
        		buy7=(Button) this.findViewById(R.id.SellButton07);
 	           buy7.setText(String.valueOf(gbuy.getOpponentAmountToSell(0)));
        	}
        	 buy17 =(Button)this.findViewById(R.id.SellButton17);
 	        buy17.setVisibility(View.VISIBLE);
        	 t17=(TextView) this.findViewById(R.id.SellTextView17);
    		 t17.setText(String.valueOf(gbuy.getSellPrice(0)));
        }
    	else
    	{
    		buy7=(Button) this.findViewById(R.id.SellButton07);
   	        buy7.setVisibility(View.INVISIBLE);
   	     buy17 =(Button)this.findViewById(R.id.SellButton17);
	        buy17.setVisibility(View.INVISIBLE);
    		t17=(TextView) this.findViewById(R.id.SellTextView17);
    		t17.setText("no trade");
    	}
    		
    	if(gbuy.getSellPrice(7) > 0 )
    	{
    		    
            	if(bOpponent)
            	{
        	           buy8=(Button) this.findViewById(R.id.SellButton08);
        	           buy8.setText(String.valueOf(gbuy.getAmountToSell(0)));
            	}
            	else{
            		buy8=(Button) this.findViewById(R.id.SellButton08);
     	           buy8.setText(String.valueOf(gbuy.getOpponentAmountToSell(0)));
            	}
            	 buy18 =(Button)this.findViewById(R.id.SellButton18);
     	        buy18.setVisibility(View.VISIBLE);
            	 t18=(TextView) this.findViewById(R.id.SellTextView18);
        		 t18.setText(String.valueOf(gbuy.getSellPrice(0)));
            }
        	else
        	{
        		buy8=(Button) this.findViewById(R.id.SellButton08);
       	        buy8.setVisibility(View.INVISIBLE);
       	     buy18 =(Button)this.findViewById(R.id.SellButton18);
 	        buy18.setVisibility(View.INVISIBLE);
        		t18=(TextView) this.findViewById(R.id.SellTextView18);
        		t18.setText("no trade");
        	}
    	
       
    	if(gbuy.getSellPrice(8) > 0 )
    	{    
        	if(bOpponent)
        	{
    	           buy9=(Button) this.findViewById(R.id.SellButton09);
    	           buy9.setText(String.valueOf(gbuy.getAmountToSell(0)));
        	}
        	else{
        		buy9=(Button) this.findViewById(R.id.SellButton09);
 	           buy9.setText(String.valueOf(gbuy.getOpponentAmountToSell(0)));
        	}
        	 buy19 =(Button)this.findViewById(R.id.SellButton19);
 	        buy19.setVisibility(View.VISIBLE);
        	 t19=(TextView) this.findViewById(R.id.SellTextView19);
    		 t19.setText(String.valueOf(gbuy.getSellPrice(0)));
        }
    	else
    	{
    		buy9=(Button) this.findViewById(R.id.SellButton09);
   	        buy9.setVisibility(View.INVISIBLE);
   	     buy19 =(Button)this.findViewById(R.id.SellButton19);
	        buy19.setVisibility(View.INVISIBLE);
    		t19=(TextView) this.findViewById(R.id.SellTextView19);
    		t19.setText("no trade");
    	}
    	if(gbuy.getSellPrice(9) > 0 )
    	{    
        	if(bOpponent)
        	{
    	           buy10=(Button) this.findViewById(R.id.SellButton10);
    	           buy10.setText(String.valueOf(gbuy.getAmountToSell(0)));
        	}
        	else{
        		buy10=(Button) this.findViewById(R.id.SellButton10);
 	           buy10.setText(String.valueOf(gbuy.getOpponentAmountToSell(0)));
        	}
        	 buy20 =(Button)this.findViewById(R.id.SellButton20);
 	        buy20.setVisibility(View.VISIBLE);
        	 t20=(TextView) this.findViewById(R.id.SellTextView20);
    		 t20.setText(String.valueOf(gbuy.getSellPrice(0)));
        }
    	else
    	{
    		buy10=(Button) this.findViewById(R.id.SellButton10);
   	        buy10.setVisibility(View.INVISIBLE);
   	     buy20 =(Button)this.findViewById(R.id.SellButton20);
	        buy20.setVisibility(View.INVISIBLE);
    		t20=(TextView) this.findViewById(R.id.SellTextView20);
    		t20.setText("no trade");
    	}
    	

    	if (bOpponent)
    	{
    		for (int i = 0; i < gbuy.MAXTRADEITEM; ++i)
    			sellCargoViewValue[i] = gbuy.getOpponentAmountToSell(i);
    	}
    	else {
    	for (int i = 0; i < gbuy.MAXTRADEITEM; ++i)
    		sellCargoViewValue[i] = gbuy.getAmountToSell(i);
    	}
    	
    	t1=(TextView)this.findViewById(R.id.TextSellCargoCashValue);
    	t1.setText(String.valueOf(gbuy.credits));
    	
    	t1=(TextView)this.findViewById(R.id.TextSellCargoBaysValue);
    	t1.setText(String.valueOf(gbuy.filledCargoBays())+"/"+String.valueOf(gbuy.totalCargoBays()));
        
    }
    
    int sellCargoViewValue[] = new int [gbuy.MAXTRADEITEM];
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		if(v==this.buy11)
		{
			if(bJettison)
			{
				gbuy.sellCargo(0,sellCargoViewValue[0],gbuy.SELLCARGO);
				gbuy.continuePlunder();
			}
			else
			{
				if (bOpponent)
				{
					
					gbuy.plunderItems(0, sellCargoViewValue[0]);
					gbuy.continuePlunder();		
				}
				else
				{
				gbuy.sellCargo(0, sellCargoViewValue[0], gbuy.SELLCARGO);
				updateView();		
				}
			}

		}
		if(v==this.buy12)
		{
			if(bJettison)
			{
				gbuy.sellCargo(1,sellCargoViewValue[1],gbuy.SELLCARGO);
				gbuy.continuePlunder();
			}
			else
			{
				if (bOpponent)
				{
					
					gbuy.plunderItems(1, sellCargoViewValue[1]);
					gbuy.continuePlunder();		
				}
				else
				{
				gbuy.sellCargo(1, sellCargoViewValue[1], gbuy.SELLCARGO);
				updateView();		
				}
			}
		}
		if(v==this.buy13)
		{
			if(bJettison)
			{
				gbuy.sellCargo(2,sellCargoViewValue[2],gbuy.SELLCARGO);
				gbuy.continuePlunder();
			}
			else
			{
				if (bOpponent)
				{
					
					gbuy.plunderItems(2, sellCargoViewValue[2]);
					gbuy.continuePlunder();		
				}
				else
				{
				gbuy.sellCargo(2, sellCargoViewValue[2], gbuy.SELLCARGO);
				updateView();		
				}
			}
		}
		if(v==this.buy14)
		{
			if(bJettison)
			{
				gbuy.sellCargo(3,sellCargoViewValue[3],gbuy.SELLCARGO);
				gbuy.continuePlunder();
			}
			else
			{
				if (bOpponent)
				{
					
					gbuy.plunderItems(0, sellCargoViewValue[0]);
					gbuy.continuePlunder();		
				}
				else
				{
				gbuy.sellCargo(3, sellCargoViewValue[3], gbuy.SELLCARGO);
				updateView();		
				}
			}
		}
		if(v==this.buy15)
		{
			if(bJettison)
			{
				gbuy.sellCargo(4,sellCargoViewValue[4],gbuy.SELLCARGO);
				gbuy.continuePlunder();
			}
			else
			{
				if (bOpponent)
				{
					
					gbuy.plunderItems(4, sellCargoViewValue[4]);
					gbuy.continuePlunder();		
				}
				else
				{
				gbuy.sellCargo(4, sellCargoViewValue[4], gbuy.SELLCARGO);
				updateView();		
				}
			}
		}
		if(v==this.buy16)
		{
			if(bJettison)
			{
				gbuy.sellCargo(5,sellCargoViewValue[5],gbuy.SELLCARGO);
				gbuy.continuePlunder();
			}
			else
			{
				if (bOpponent)
				{
					
					gbuy.plunderItems(5, sellCargoViewValue[5]);
					gbuy.continuePlunder();		
				}
				else
				{
				gbuy.sellCargo(5, sellCargoViewValue[5], gbuy.SELLCARGO);
				updateView();		
				}
			}
		}
		if(v==this.buy17)
		{
			if(bJettison)
			{
				gbuy.sellCargo(6,sellCargoViewValue[6],gbuy.SELLCARGO);
				gbuy.continuePlunder();
			}
			else
			{
				if (bOpponent)
				{
					
					gbuy.plunderItems(6, sellCargoViewValue[6]);
					gbuy.continuePlunder();		
				}
				else
				{
				gbuy.sellCargo(6, sellCargoViewValue[6], gbuy.SELLCARGO);
				updateView();		
				}
			}
		}
		if(v==this.buy18)
		{
			if(bJettison)
			{
				gbuy.sellCargo(7,sellCargoViewValue[7],gbuy.SELLCARGO);
				gbuy.continuePlunder();
			}
			else
			{
				if (bOpponent)
				{
					
					gbuy.plunderItems(7, sellCargoViewValue[7]);
					gbuy.continuePlunder();		
				}
				else
				{
				gbuy.sellCargo(7, sellCargoViewValue[7], gbuy.SELLCARGO);
				updateView();		
				}
			}
		}
		if(v==this.buy19)
		{
			if(bJettison)
			{
				gbuy.sellCargo(8,sellCargoViewValue[8],gbuy.SELLCARGO);
				gbuy.continuePlunder();
			}
			else
			{
				if (bOpponent)
				{
					
					gbuy.plunderItems(8, sellCargoViewValue[8]);
					gbuy.continuePlunder();		
				}
				else
				{
				gbuy.sellCargo(8, sellCargoViewValue[8], gbuy.SELLCARGO);
				updateView();		
				}
			}
		}
		if(v==this.buy20)
		{
			if(bJettison)
			{
				gbuy.sellCargo(9,sellCargoViewValue[9],gbuy.SELLCARGO);
				gbuy.continuePlunder();
			}
			else
			{
				if (bOpponent)
				{
					
					gbuy.plunderItems(9, sellCargoViewValue[9]);
					gbuy.continuePlunder();		
				}
				else
				{
				gbuy.sellCargo(9, sellCargoViewValue[9], gbuy.SELLCARGO);
				updateView();		
				}
			}
		}
		
		if(v==this.buy1)
		{
			 
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(sellcargo.this).setView(aview).create();
	     	alertDialog1.show();
			if(bJettison)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can jettison up to "+String.valueOf(sellCargoViewValue[0])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("You paid about "+String.valueOf(gbuy.getBuyPrice(0))+" cr. per unit .nHow many will you dump");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[0]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Discard items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[0]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(0, val, gbuy.SELLCARGO);
	  					gbuy.continuePlunder();
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
			if(bOpponent)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[0])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("How many do you want to plunder?");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[0]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Plunder items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[0]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(0, val, gbuy.SELLCARGO);
	  					
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
			else
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[0])+" at cr. each.You paid about "+gbuy.getBuyPrice(0)+" cr. pre unit");
		     	String str;
		     	if(gbuy.getBuyPrice(0)/sellCargoViewValue[0]>gbuy.getBuyPrice(0))
		     	{
		     		str="profit";
		     	}
		     	else
		     		str="loss";
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("Your "+str+" per unit is "+String.valueOf(gbuy.getBuyPrice(0)/sellCargoViewValue[0]-gbuy.getSellPrice(0)));
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[0]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Sell items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[0]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(0, val, gbuy.SELLCARGO);
	  					
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
		}
		if(v==this.buy2)
		{
			 
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(sellcargo.this).setView(aview).create();
	     	alertDialog1.show();
			if(bJettison)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can jettison up to "+String.valueOf(sellCargoViewValue[1])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("You paid about "+String.valueOf(gbuy.getBuyPrice(1))+" cr. per unit .nHow many will you dump");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[1]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Discard items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[1]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(1, val, gbuy.SELLCARGO);
	  					gbuy.continuePlunder();
	  					updateView();
	  					alertDialog1.cancel();
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
			if(bOpponent)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[1])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("How many do you want to plunder?");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[1]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Plunder items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[1]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(1, val, gbuy.SELLCARGO);
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
			else
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[1])+" at cr. each.You paid about "+gbuy.getBuyPrice(1)+" cr. pre unit");
		     	String str;
		     	if(gbuy.getBuyPrice(1)/sellCargoViewValue[1]>gbuy.getBuyPrice(1))
		     	{
		     		str="profit";
		     	}
		     	else
		     		str="loss";
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("Your "+str+" per unit is "+String.valueOf(gbuy.getBuyPrice(1)/sellCargoViewValue[1]-gbuy.getSellPrice(1)));
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[1]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Sell items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[1]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(1, val, gbuy.SELLCARGO);
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
		}
		if(v==this.buy3)
		{
			 
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(sellcargo.this).setView(aview).create();
	     	alertDialog1.show();
			if(bJettison)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can jettison up to "+String.valueOf(sellCargoViewValue[2])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("You paid about "+String.valueOf(gbuy.getBuyPrice(2))+" cr. per unit .nHow many will you dump");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[2]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Discard items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[2]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(2, val, gbuy.SELLCARGO);
	  					gbuy.continuePlunder();
	  					updateView();
	  					alertDialog1.cancel();
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
			if(bOpponent)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[2])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("How many do you want to plunder?");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[2]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Plunder items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[2]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(2, val, gbuy.SELLCARGO);
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
			else
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[2])+" at cr. each.You paid about "+gbuy.getBuyPrice(2)+" cr. pre unit");
		     	String str;
		     	if(gbuy.getBuyPrice(2)/sellCargoViewValue[2]>gbuy.getBuyPrice(2))
		     	{
		     		str="profit";
		     	}
		     	else
		     		str="loss";
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("Your "+str+" per unit is "+String.valueOf(gbuy.getBuyPrice(2)/sellCargoViewValue[2]-gbuy.getSellPrice(2)));
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[2]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Sell items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[2]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(2, val, gbuy.SELLCARGO);
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
		}
		if(v==this.buy4)
		{
			 
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(sellcargo.this).setView(aview).create();
	     	alertDialog1.show();
			if(bJettison)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can jettison up to "+String.valueOf(sellCargoViewValue[3])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("You paid about "+String.valueOf(gbuy.getBuyPrice(3))+" cr. per unit .nHow many will you dump");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[3]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Discard items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[3]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(3, val, gbuy.SELLCARGO);
	  					gbuy.continuePlunder();
	  					updateView();
	  					alertDialog1.cancel();
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
			if(bOpponent)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[3])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("How many do you want to plunder?");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[3]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Plunder items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[3]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(3, val, gbuy.SELLCARGO);
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
			else
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[3])+" at cr. each.You paid about "+gbuy.getBuyPrice(3)+" cr. pre unit");
		     	String str;
		     	if(gbuy.getBuyPrice(3)/sellCargoViewValue[3]>gbuy.getBuyPrice(3))
		     	{
		     		str="profit";
		     	}
		     	else
		     		str="loss";
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("Your "+str+" per unit is "+String.valueOf(gbuy.getBuyPrice(3)/sellCargoViewValue[3]-gbuy.getSellPrice(3)));
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[3]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Sell items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[3]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(3, val, gbuy.SELLCARGO);
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
		}
		if(v==this.buy5)
		{
			 
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(sellcargo.this).setView(aview).create();
	     	alertDialog1.show();
			if(bJettison)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can jettison up to "+String.valueOf(sellCargoViewValue[4])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("You paid about "+String.valueOf(gbuy.getBuyPrice(4))+" cr. per unit .nHow many will you dump");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[4]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Discard items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[4]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(4, val, gbuy.SELLCARGO);
	  					gbuy.continuePlunder();
	  					updateView();
	  					alertDialog1.cancel();
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
			if(bOpponent)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[4])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("How many do you want to plunder?");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[4]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Plunder items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[4]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(4, val, gbuy.SELLCARGO);
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
			else
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[4])+" at cr. each.You paid about "+gbuy.getBuyPrice(4)+" cr. pre unit");
		     	String str;
		     	if(gbuy.getBuyPrice(4)/sellCargoViewValue[4]>gbuy.getBuyPrice(4))
		     	{
		     		str="profit";
		     	}
		     	else
		     		str="loss";
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("Your "+str+" per unit is "+String.valueOf(gbuy.getBuyPrice(4)/sellCargoViewValue[4]-gbuy.getSellPrice(4)));
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[4]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Sell items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[4]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(4, val, gbuy.SELLCARGO);
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
		}
		if(v==this.buy6)
		{
			 
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(sellcargo.this).setView(aview).create();
	     	alertDialog1.show();
			if(bJettison)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can jettison up to "+String.valueOf(sellCargoViewValue[5])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("You paid about "+String.valueOf(gbuy.getBuyPrice(5))+" cr. per unit .nHow many will you dump");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[5]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Discard items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[5]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(5, val, gbuy.SELLCARGO);
	  					gbuy.continuePlunder();
	  					updateView();
	  					alertDialog1.cancel();
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
			if(bOpponent)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[5])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("How many do you want to plunder?");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[5]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Plunder items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[5]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(5, val, gbuy.SELLCARGO);
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
			else
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[5])+" at cr. each.You paid about "+gbuy.getBuyPrice(5)+" cr. pre unit");
		     	String str;
		     	if(gbuy.getBuyPrice(5)/sellCargoViewValue[5]>gbuy.getBuyPrice(5))
		     	{
		     		str="profit";
		     	}
		     	else
		     		str="loss";
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("Your "+str+" per unit is "+String.valueOf(gbuy.getBuyPrice(5)/sellCargoViewValue[5]-gbuy.getSellPrice(5)));
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[5]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Sell items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[5]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(5, val, gbuy.SELLCARGO);
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
			
		}
		if(v==this.buy7)
		{
			 
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(sellcargo.this).setView(aview).create();
	     	alertDialog1.show();
			if(bJettison)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can jettison up to "+String.valueOf(sellCargoViewValue[6])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("You paid about "+String.valueOf(gbuy.getBuyPrice(6))+" cr. per unit .nHow many will you dump");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[6]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Discard items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[6]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(6, val, gbuy.SELLCARGO);
	  					gbuy.continuePlunder();
	  					updateView();
	  					alertDialog1.cancel();
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
			if(bOpponent)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[6])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("How many do you want to plunder?");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[6]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Plunder items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[6]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(6, val, gbuy.SELLCARGO);
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
			else
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[6])+" at cr. each.You paid about "+gbuy.getBuyPrice(6)+" cr. pre unit");
		     	String str;
		     	if(gbuy.getBuyPrice(6)/sellCargoViewValue[6]>gbuy.getBuyPrice(6))
		     	{
		     		str="profit";
		     	}
		     	else
		     		str="loss";
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("Your "+str+" per unit is "+String.valueOf(gbuy.getBuyPrice(6)/sellCargoViewValue[6]-gbuy.getSellPrice(6)));
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[6]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Sell items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[6]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(6, val, gbuy.SELLCARGO);
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
		}
		if(v==this.buy8)
		{
			 
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(sellcargo.this).setView(aview).create();
	     	alertDialog1.show();
			if(bJettison)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can jettison up to "+String.valueOf(sellCargoViewValue[7])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("You paid about "+String.valueOf(gbuy.getBuyPrice(7))+" cr. per unit .nHow many will you dump");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[7]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Discard items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[7]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(7, val, gbuy.SELLCARGO);
	  					gbuy.continuePlunder();
	  					updateView();
	  					alertDialog1.cancel();
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
			if(bOpponent)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[7])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("How many do you want to plunder?");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[7]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Plunder items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[7]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(7, val, gbuy.SELLCARGO);
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
			else
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[7])+" at cr. each.You paid about "+gbuy.getBuyPrice(7)+" cr. pre unit");
		     	String str;
		     	if(gbuy.getBuyPrice(7)/sellCargoViewValue[7]>gbuy.getBuyPrice(7))
		     	{
		     		str="profit";
		     	}
		     	else
		     		str="loss";
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("Your "+str+" per unit is "+String.valueOf(gbuy.getBuyPrice(7)/sellCargoViewValue[7]-gbuy.getSellPrice(7)));
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[7]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Sell items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[7]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(7, val, gbuy.SELLCARGO);
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
		}
		if(v==this.buy9)
		{
			 
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(sellcargo.this).setView(aview).create();
	     	alertDialog1.show();
			if(bJettison)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can jettison up to "+String.valueOf(sellCargoViewValue[8])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("You paid about "+String.valueOf(gbuy.getBuyPrice(8))+" cr. per unit .nHow many will you dump");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[8]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Discard items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[8]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(8, val, gbuy.SELLCARGO);
	  					gbuy.continuePlunder();
	  					updateView();
	  					alertDialog1.cancel();
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
			if(bOpponent)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[8])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("How many do you want to plunder?");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[8]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Plunder items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[8]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(8, val, gbuy.SELLCARGO);
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
			else
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[8])+" at cr. each.You paid about "+gbuy.getBuyPrice(8)+" cr. pre unit");
		     	String str;
		     	if(gbuy.getBuyPrice(8)/sellCargoViewValue[8]>gbuy.getBuyPrice(8))
		     	{
		     		str="profit";
		     	}
		     	else
		     		str="loss";
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("Your "+str+" per unit is "+String.valueOf(gbuy.getBuyPrice(8)/sellCargoViewValue[8]-gbuy.getSellPrice(8)));
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[8]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Sell items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[8]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(8, val, gbuy.SELLCARGO);
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
		}
		if(v==this.buy10)
		{
			 
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(sellcargo.this).setView(aview).create();
	     	alertDialog1.show();
			if(bJettison)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can jettison up to "+String.valueOf(sellCargoViewValue[9])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("You paid about "+String.valueOf(gbuy.getBuyPrice(9))+" cr. per unit .nHow many will you dump");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[9]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Discard items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[9]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(9, val, gbuy.SELLCARGO);
	  					gbuy.continuePlunder();
	  					updateView();
	  					alertDialog1.cancel();
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
			if(bOpponent)
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[9])+" at cr. each.");
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("How many do you want to plunder?");
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[9]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Plunder items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[9]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(9, val, gbuy.SELLCARGO);
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
			else
			{
				t1= (TextView)aview.findViewById(R.id.SeekLine1);
		     	t1.setText("You can sell up to "+String.valueOf(sellCargoViewValue[9])+" at cr. each.You paid about "+gbuy.getBuyPrice(9)+" cr. pre unit");
		     	String str;
		     	if(gbuy.getBuyPrice(9)/sellCargoViewValue[9]>gbuy.getBuyPrice(9))
		     	{
		     		str="profit";
		     	}
		     	else
		     		str="loss";
		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
		     	t2.setText("Your "+str+" per unit is "+String.valueOf(gbuy.getBuyPrice(9)/sellCargoViewValue[9]-gbuy.getSellPrice(9)));
		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
		     	t4.setText(String.valueOf(sellCargoViewValue[9]));
		     	t1 =(TextView)aview.findViewById(R.id.Seekheading);
		     	t1.setText("Sell items");
		
	  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
	  			s1.setProgress(sellCargoViewValue[9]);
	  			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			    {
				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
				    {
				    
				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
				    	alertval.setText(String.valueOf(progress));
				    	val=progress;
				    }
					public void onStartTrackingTouch(SeekBar seekBar)
					{
					    
					}
					public void onStopTrackingTouch(SeekBar seekBar) 
					{
					   
					}
			    });
				
	  			Button ok = (Button)aview.findViewById(R.id.Seekalertyes);
	  			ok.setText("OK");
	  			ok.setOnClickListener(new OnClickListener() 
	  			{
	  				public void onClick(View v)
	  				{
	  					gbuy.sellCargo(9, val, gbuy.SELLCARGO);
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
		}
	}
}