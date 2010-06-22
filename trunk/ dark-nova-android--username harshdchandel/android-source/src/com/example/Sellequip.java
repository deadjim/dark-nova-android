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
import android.widget.TextView;

public class Sellequip extends Activity implements OnClickListener  {
    /** Called when the activity is first created. */
	private Button sellequipmentclose,sell1,sell2,sell3,sell4,sell5,sell6,sell7,sell8,sell9,sell10;
	Globala gbuy=new Globala();
	AlertDialog alertDialog1;
	TextView t1,t2,t3,t4;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.sellequipments);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlesellequip);
      
        sellequipmentclose=(Button)this.findViewById(R.id.sellequipmentclose);
        sellequipmentclose.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		//setContentView(R.layout.buyequipment);
        		Intent sellequipmentclose1=new Intent(Sellequip.this,main.class);
           		startActivity(sellequipmentclose1);
        	}
        });
        
       
		 
		 if(gbuy.getSellEquipmentPrice(0) > 0 )
	     {
	 	     sell1=(Button) this.findViewById(R.id.ButtonSellPulse);
	 	     sell1.setVisibility(View.VISIBLE);
	 	     t1=(TextView)this.findViewById(R.id.PulseSellTextView01);
	 	     t1.setVisibility(View.VISIBLE);
	     	 t2=(TextView) this.findViewById(R.id.PulseSellTextView11);
	 		 t2.setText(String.valueOf(gbuy.getSellEquipmentPrice(0)));
	 		 t2.setVisibility(View.VISIBLE);
	 		 t3 = (TextView)this.findViewById(R.id.SellTextView01);
	 		t3.setVisibility(View.INVISIBLE);
	    }
	 else
	 	{

	 		  sell1=(Button) this.findViewById(R.id.ButtonSellPulse);
	  	     sell1.setVisibility(View.INVISIBLE);
	  	     t1=(TextView)this.findViewById(R.id.PulseSellTextView01);
	  	     t1.setVisibility(View.INVISIBLE);
	      	 t2=(TextView) this.findViewById(R.id.PulseSellTextView11);
	      	t2.setVisibility(View.INVISIBLE);
	 	}
		 
	     if(gbuy.getSellEquipmentPrice(1) > 0 )
	     {
	 	     sell2=(Button) this.findViewById(R.id.ButtonSellDisrupter);
	 	     sell2.setVisibility(View.VISIBLE);
	 	     t1=(TextView)this.findViewById(R.id.DisrupterSellTextView02);
	 	     t1.setVisibility(View.VISIBLE);
	     	 t2=(TextView) this.findViewById(R.id.DisrupterSellTextView12);
	 		 t2.setText(String.valueOf(gbuy.getSellEquipmentPrice(1)));
	 		 t2.setVisibility(View.VISIBLE);
	     }
	 	else
	 	{

	 		 sell2=(Button) this.findViewById(R.id.ButtonSellDisrupter);
	  	     sell2.setVisibility(View.INVISIBLE);
	  	     t1=(TextView)this.findViewById(R.id.DisrupterSellTextView02);
	  	     t1.setVisibility(View.INVISIBLE);
	      	 t2=(TextView) this.findViewById(R.id.DisrupterSellTextView12);
	  		 t2.setVisibility(View.INVISIBLE);
	 	}
    		
    		if(gbuy.getSellEquipmentPrice(2) > 0 )
            {
        	     sell3=(Button) this.findViewById(R.id.ButtonSellJustice);
        	     sell3.setVisibility(View.VISIBLE);
        	     t1=(TextView)this.findViewById(R.id.JusticeSellTextView03);
        	     t1.setVisibility(View.VISIBLE);
            	 t2=(TextView) this.findViewById(R.id.JusticeSellTextView13);
        		 t2.setText(String.valueOf(gbuy.getSellEquipmentPrice(2)));
        		
            }
        	else
        	{

        		 sell3=(Button) this.findViewById(R.id.ButtonSellJustice);
        	     sell3.setVisibility(View.INVISIBLE);
        	     t1=(TextView)this.findViewById(R.id.JusticeSellTextView03);
        	     t1.setVisibility(View.INVISIBLE);
            	 t2=(TextView) this.findViewById(R.id.JusticeSellTextView13);
        		 t2.setVisibility(View.INVISIBLE);
        	}
    		if(gbuy.getSellEquipmentPrice(3) > 0 )
            {
        	     sell4=(Button) this.findViewById(R.id.ButtonSellEnergy);
        	     sell4.setVisibility(View.VISIBLE);
        	     t1=(TextView)this.findViewById(R.id.EnergySellTextView04);
        	     t1.setVisibility(View.VISIBLE);
            	 t2=(TextView) this.findViewById(R.id.EnergySellTextView14);
        		 t2.setText(String.valueOf(gbuy.getSellEquipmentPrice(3)));
        		t3 = (TextView)this.findViewById(R.id.SellTextView02);
        		t3.setVisibility(View.INVISIBLE);
            }
    		else
    		{
    			sell4=(Button) this.findViewById(R.id.ButtonSellEnergy);
       	     sell4.setVisibility(View.INVISIBLE);
       	     t1=(TextView)this.findViewById(R.id.EnergySellTextView04);
       	     t1.setVisibility(View.INVISIBLE);
           	 t2=(TextView) this.findViewById(R.id.EnergySellTextView14);
       		 t2.setVisibility(View.INVISIBLE);
    		}
    		if(gbuy.getSellEquipmentPrice(4) > 0 )
            {
        	     sell5=(Button) this.findViewById(R.id.ButtonSellReflection);
        	     sell5.setVisibility(View.VISIBLE);
        	     t1=(TextView)this.findViewById(R.id.ReflectionSellTextView05);
        	     t1.setVisibility(View.VISIBLE);
            	 t2=(TextView) this.findViewById(R.id.ReflectionSellTextView15);
        		 t2.setText(String.valueOf(gbuy.getSellEquipmentPrice(4)));
        		
            }
    		else
    		{

    			sell5=(Button) this.findViewById(R.id.ButtonSellReflection);
       	     sell5.setVisibility(View.VISIBLE);
       	     t1=(TextView)this.findViewById(R.id.ReflectionSellTextView05);
       	     t1.setVisibility(View.VISIBLE);
           	 t2=(TextView) this.findViewById(R.id.ReflectionSellTextView15);
       		 t2.setVisibility(View.INVISIBLE);
    		}
    		if(gbuy.getSellEquipmentPrice(5) > 0 )
            {
        	     sell6=(Button) this.findViewById(R.id.ButtonSell5extracargo);
        	     sell6.setVisibility(View.VISIBLE);
        	     t1=(TextView)this.findViewById(R.id.ExtraSellTextView06);
        	     t1.setVisibility(View.VISIBLE);
            	 t2=(TextView) this.findViewById(R.id.ExtraSellTextView16);
        		 t2.setText(String.valueOf(gbuy.getSellEquipmentPrice(5)));
        		
            }
    		else
    		{
    			 sell6=(Button) this.findViewById(R.id.ButtonSell5extracargo);
        	     sell6.setVisibility(View.INVISIBLE);
        	     t1=(TextView)this.findViewById(R.id.ExtraSellTextView06);
        	     t1.setVisibility(View.INVISIBLE);
            	 t2=(TextView) this.findViewById(R.id.ExtraSellTextView16);
            	 t2.setVisibility(View.INVISIBLE);
        		 
    		}
    		
    		if(gbuy.getSellEquipmentPrice(6) > 0 )
            {
        	     sell7=(Button) this.findViewById(R.id.ButtonSellAuto);
        	     sell7.setVisibility(View.VISIBLE);
        	     t1=(TextView)this.findViewById(R.id.AutoSellTextView07);
        	     t1.setVisibility(View.VISIBLE);
            	 t2=(TextView) this.findViewById(R.id.AutoSellTextView17);
        		 t2.setText(String.valueOf(gbuy.getSellEquipmentPrice(6)));
        		t3 = (TextView)this.findViewById(R.id.TextViewNoGadegts);
        		t3.setVisibility(View.INVISIBLE);
            }
    		else
            {
        	     sell7=(Button) this.findViewById(R.id.ButtonSellAuto);
        	     sell7.setVisibility(View.INVISIBLE);
        	     t1=(TextView)this.findViewById(R.id.AutoSellTextView07);
        	     t1.setVisibility(View.INVISIBLE);
            	 t2=(TextView) this.findViewById(R.id.AutoSellTextView17);
            	 t2.setVisibility(View.INVISIBLE);
        		
            }
    		if(gbuy.getSellEquipmentPrice(7) > 0 )
            {
        	     sell8=(Button) this.findViewById(R.id.ButtonSellNavigation);
        	     sell8.setVisibility(View.VISIBLE);
        	     t1=(TextView)this.findViewById(R.id.NavigationSellTextView08);
        	     t1.setVisibility(View.VISIBLE);
            	 t2=(TextView) this.findViewById(R.id.NavigationSellTextView18);
        		 t2.setText(String.valueOf(gbuy.getSellEquipmentPrice(7)));
        		
            }
    		else
    		{
    			 sell8=(Button) this.findViewById(R.id.ButtonSellNavigation);
        	     sell8.setVisibility(View.INVISIBLE);
        	     t1=(TextView)this.findViewById(R.id.NavigationSellTextView08);
        	     t1.setVisibility(View.INVISIBLE);
            	 t2=(TextView) this.findViewById(R.id.NavigationSellTextView18);
            	 t2.setVisibility(View.INVISIBLE);
    		}
    		if(gbuy.getSellEquipmentPrice(8) > 0 )
            {
        	     sell9=(Button) this.findViewById(R.id.ButtonSellTargetting);
        	     sell9.setVisibility(View.VISIBLE);
        	     t1=(TextView)this.findViewById(R.id.TargetingSellTextView09);
        	     t1.setVisibility(View.VISIBLE);
            	 t2=(TextView) this.findViewById(R.id.TargetingSellTextView19);
        		 t2.setText(String.valueOf(gbuy.getSellEquipmentPrice(8)));
        		
            }
    		else
    		{
    			 sell9=(Button) this.findViewById(R.id.ButtonSellTargetting);
        	     sell9.setVisibility(View.INVISIBLE);
        	     t1=(TextView)this.findViewById(R.id.TargetingSellTextView09);
        	     t1.setVisibility(View.INVISIBLE);
            	 t2=(TextView) this.findViewById(R.id.TargetingSellTextView19);
        		t2.setVisibility(View.INVISIBLE);
    		}
		 sell1=(Button) this.findViewById(R.id.ButtonSellPulse);
	        this.sell1.setOnClickListener(this);
	        sell2=(Button) this.findViewById(R.id.ButtonSellDisrupter);
	        sell2.setOnClickListener(this);
	        sell3=(Button) this.findViewById(R.id.ButtonSellJustice);
	        sell3.setOnClickListener(this);
	        
	        sell4=(Button) this.findViewById(R.id.ButtonSellEnergy);
	        sell4.setOnClickListener(this);
	        sell5=(Button) this.findViewById(R.id.ButtonSellReflection);
	        sell5.setOnClickListener(this);
			 sell6=(Button) this.findViewById(R.id.ButtonSell5extracargo);
			 sell6.setOnClickListener(this);
			 sell7=(Button) this.findViewById(R.id.ButtonSellAuto);
			 sell7.setOnClickListener(this);
			 sell8=(Button) this.findViewById(R.id.ButtonSellNavigation);
			 sell8.setOnClickListener(this);
			 sell9=(Button) this.findViewById(R.id.ButtonSellTargetting);
			 sell9.setOnClickListener(this);
    	
    }
      public void onClick(View v)
     {
    	  LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
			alertDialog1 = new AlertDialog.Builder(Sellequip.this).setView(aview).create();
		
			alertDialog1.show();
			t1 = (TextView)aview.findViewById(R.id.Seek1heading);
			t1.setText("Sell Equipment");
			t2=(TextView)aview.findViewById(R.id.Seek1Line1);
			t2.setText("Are you sure you want to");
			t3=(TextView)aview.findViewById(R.id.Seek1Line2);
			t3.setText("sell this item?");
			t4 =(TextView)aview.findViewById(R.id.Seek1Line3);
			t4.setVisibility(View.INVISIBLE);
			t4 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
			t4.setVisibility(View.INVISIBLE);
		
    	 if(v==this.sell1)
    	 {
    		 	
				Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
				cancel.setText("No");
				cancel.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						alertDialog1.cancel();				
					}
				});
				Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
				confirm.setText("Yes");
				confirm.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{	
						
						gbuy.sellEquipment(0);
						alertDialog1.cancel();
						 sell1=(Button) findViewById(R.id.ButtonSellPulse);
		         	     sell1.setVisibility(View.INVISIBLE);
		         	     t1=(TextView)findViewById(R.id.PulseSellTextView01);
		         	     t1.setVisibility(View.INVISIBLE);
		             	 t2=(TextView) findViewById(R.id.PulseSellTextView11);
		             	t2.setVisibility(View.INVISIBLE);
						
					}
				});
				
			  
    	  }
    	 if(v==this.sell2)
    	 {
    		 	
				Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
				cancel.setText("No");
				cancel.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						alertDialog1.cancel();				
					}
				});
				Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
				confirm.setText("Yes");
				confirm.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{	
						
						gbuy.sellEquipment(1);
						alertDialog1.cancel();
						sell2=(Button) findViewById(R.id.ButtonSellDisrupter);
				  	     sell2.setVisibility(View.INVISIBLE);
				  	     t1=(TextView)findViewById(R.id.DisrupterSellTextView02);
				  	     t1.setVisibility(View.INVISIBLE);
				      	 t2=(TextView) findViewById(R.id.DisrupterSellTextView12);
				  		 t2.setVisibility(View.INVISIBLE);
					}
				});
				
			  
    	  }
    	 if(v==this.sell3)
    	 {
    		 	
				Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
				cancel.setText("No");
				cancel.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						alertDialog1.cancel();				
					}
				});
				Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
				confirm.setText("Yes");
				confirm.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{	
						
						gbuy.sellEquipment(2);
						alertDialog1.cancel();
						 sell3=(Button) findViewById(R.id.ButtonSellJustice);
		        	     sell3.setVisibility(View.INVISIBLE);
		        	     t1=(TextView)findViewById(R.id.JusticeSellTextView03);
		        	     t1.setVisibility(View.INVISIBLE);
		            	 t2=(TextView) findViewById(R.id.JusticeSellTextView13);
		        		 t2.setVisibility(View.INVISIBLE);
						
					}
				});
				
			  
    	  }
    	 if(v==this.sell4)
    	 {
    		 	
				Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
				cancel.setText("No");
				cancel.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						alertDialog1.cancel();				
					}
				});
				Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
				confirm.setText("Yes");
				confirm.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{	
						
						gbuy.sellEquipment(3);
						alertDialog1.cancel();

		    			sell4=(Button) findViewById(R.id.ButtonSellEnergy);
		       	     sell4.setVisibility(View.INVISIBLE);
		       	     t1=(TextView)findViewById(R.id.EnergySellTextView04);
		       	     t1.setVisibility(View.INVISIBLE);
		           	 t2=(TextView) findViewById(R.id.EnergySellTextView14);
		       		 t2.setVisibility(View.INVISIBLE);
						
					}
				});
				
			  
    	  }
    	 if(v==this.sell5)
    	 {
    		 	
				Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
				cancel.setText("No");
				cancel.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						alertDialog1.cancel();				
					}
				});
				Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
				confirm.setText("Yes");
				confirm.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{	
						
						gbuy.sellEquipment(4);
						alertDialog1.cancel();
						sell5=(Button) findViewById(R.id.ButtonSellReflection);
			       	     sell5.setVisibility(View.VISIBLE);
			       	     t1=(TextView)findViewById(R.id.ReflectionSellTextView05);
			       	     t1.setVisibility(View.VISIBLE);
			           	 t2=(TextView)findViewById(R.id.ReflectionSellTextView15);
			       		 t2.setVisibility(View.INVISIBLE);
						
					}
				});
				
			  
    	  }
    	 if(v==this.sell6)
    	 {
    		 	
				Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
				cancel.setText("No");
				cancel.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						alertDialog1.cancel();				
					}
				});
				Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
				confirm.setText("Yes");
				confirm.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{	
						
						gbuy.sellEquipment(5);
						alertDialog1.cancel();
						sell6=(Button) findViewById(R.id.ButtonSell5extracargo);
		        	     sell6.setVisibility(View.INVISIBLE);
		        	     t1=(TextView)findViewById(R.id.ExtraSellTextView06);
		        	     t1.setVisibility(View.INVISIBLE);
		            	 t2=(TextView) findViewById(R.id.ExtraSellTextView16);
		            	 t2.setVisibility(View.INVISIBLE);
						
					}
				});
				
			  
    	  }
    	 if(v==this.sell7)
    	 {
    		 	
				Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
				cancel.setText("No");
				cancel.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						alertDialog1.cancel();				
					}
				});
				Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
				confirm.setText("Yes");
				confirm.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{	
						
						gbuy.sellEquipment(6);
						alertDialog1.cancel();
						sell7=(Button) findViewById(R.id.ButtonSellAuto);
		        	     sell7.setVisibility(View.INVISIBLE);
		        	     t1=(TextView)findViewById(R.id.AutoSellTextView07);
		        	     t1.setVisibility(View.INVISIBLE);
		            	 t2=(TextView)findViewById(R.id.AutoSellTextView17);
		            	 t2.setVisibility(View.INVISIBLE);
						
					}
				});
				
			  
    	  }
    	 if(v==this.sell8)
    	 {
    		 	
				Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
				cancel.setText("No");
				cancel.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						alertDialog1.cancel();				
					}
				});
				Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
				confirm.setText("Yes");
				confirm.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{	
						
						gbuy.sellEquipment(7);
						alertDialog1.cancel();
						sell8=(Button) findViewById(R.id.ButtonSellNavigation);
		        	     sell8.setVisibility(View.INVISIBLE);
		        	     t1=(TextView)findViewById(R.id.NavigationSellTextView08);
		        	     t1.setVisibility(View.INVISIBLE);
		            	 t2=(TextView) findViewById(R.id.NavigationSellTextView18);
		            	 t2.setVisibility(View.INVISIBLE);
						
					}
				});
				
			  
    	  }
    	 if(v==this.sell9)
    	 {
    		 	
				Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
				cancel.setText("No");
				cancel.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						alertDialog1.cancel();				
					}
				});
				Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
				confirm.setText("Yes");
				confirm.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{	
						
						gbuy.sellEquipment(8);
						alertDialog1.cancel();
						 sell9=(Button) findViewById(R.id.ButtonSellTargetting);
		        	     sell9.setVisibility(View.INVISIBLE);
		        	     t1=(TextView)findViewById(R.id.TargetingSellTextView09);
		        	     t1.setVisibility(View.INVISIBLE);
		            	 t2=(TextView) findViewById(R.id.TargetingSellTextView19);
		        		t2.setVisibility(View.INVISIBLE);		
					}
				});
				
			  
    	  }
     }
  }
    
