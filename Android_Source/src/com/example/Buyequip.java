package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Buyequip extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	private Button bequipmentclose;
	private TextView t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,buycash;
	 
	private Button buy1,buy2,buy3,buy4,buy5,buy6,buy7,buy8,buy9,buy10;
	private AlertDialog alertDialog1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.buyequipment);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t11 = (TextView)this.findViewById(R.id.TextViewTitleName);
        t11.setText("Buy Equipment");
    
        bequipmentclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
        bequipmentclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent buyequipmentclose1=new Intent(Buyequip.this,main.class);
           		startActivity(buyequipmentclose1);
        	}
        });
 
        buycash=(TextView) this.findViewById(R.id.CashbuyeTextView);
        buycash.setText(String.valueOf(Globala.credits));
        
        buy1=(Button) this.findViewById(R.id.ButtonBuyPulse);
        this.buy1.setOnClickListener(this);
        buy5 = (Button)this.findViewById(R.id.ButtonReflection);
        this.buy5.setOnClickListener(this);
        buy2 = (Button)this.findViewById(R.id.ButtonBuyDisrupter);
        this.buy2.setOnClickListener(this);
        buy3 = (Button)this.findViewById(R.id.ButtonJustice);
        this.buy3.setOnClickListener(this);
        buy4 = (Button)this.findViewById(R.id.ButtonEnergy);
        this.buy4.setOnClickListener(this);
        buy6 = (Button)this.findViewById(R.id.Button5extracargo);
        this.buy6.setOnClickListener(this);
        buy7 = (Button)this.findViewById(R.id.ButtonAuto);
        this.buy7.setOnClickListener(this);
        buy8 = (Button)this.findViewById(R.id.ButtonNavigation);
        this.buy8.setOnClickListener(this);
        buy9 = (Button)this.findViewById(R.id.ButtonTargetting);
        this.buy9.setOnClickListener(this);
        buy10 = (Button)this.findViewById(R.id.ButtonCloak);
        this.buy10.setOnClickListener(this);
   
   
       if(Globala.getEquipmentPrice(0) > 0 && Globala.counterbuyequip0==0)
        {
    	     buy1=(Button) this.findViewById(R.id.ButtonBuyPulse);
    	     buy1.setVisibility(View.VISIBLE);
    	   //on click buy1 call  buyStuff(0);
    	     
    	   
    	 
    	 
    	    		 
        	 t11=(TextView) this.findViewById(R.id.PulseTextView11);
    		t11.setText(String.valueOf(Globala.getEquipmentPrice(0)));
        }
    	else
    	{
    		buy1=(Button) this.findViewById(R.id.ButtonBuyPulse);
   	        buy1.setVisibility(View.INVISIBLE);
    		t11=(TextView) this.findViewById(R.id.PulseTextView11);
    		t11.setText("not sold");
    	}
    	if(Globala.getEquipmentPrice(1) > 0 && Globala.counterbuyequip1==0)
    	{
    		buy2=(Button) this.findViewById(R.id.ButtonBuyDisrupter);
    		buy2.setVisibility(View.VISIBLE);
    		// buyStuff(1);
    		 t12 = (TextView) this.findViewById(R.id.DisrupterTextView12);
    		 t12.setText(String.valueOf(Globala.getEquipmentPrice(1)));
    	}
    	else
    	{
    		buy2=(Button) this.findViewById(R.id.ButtonBuyDisrupter);
        	buy2.setVisibility(View.INVISIBLE);		
    		t12=(TextView) this.findViewById(R.id.DisrupterTextView12);
    		t12.setText("not sold");	
    	}
    	
    	if(Globala.getEquipmentPrice(2) > 0 && Globala.counterbuyequip2==0 )	
    	{
    		t13=(TextView) this.findViewById(R.id.JusticeTextView13);
    		t13.setText(String.valueOf(Globala.getEquipmentPrice(2)));
    		// buyStuff(2);
    		buy3=(Button) this.findViewById(R.id.ButtonJustice);
    		buy3.setVisibility(View.VISIBLE);
    	}
    	else
    	{
    		buy3=(Button) this.findViewById(R.id.ButtonJustice);
    		buy3.setVisibility(View.INVISIBLE);
    		t13=(TextView) this.findViewById(R.id.JusticeTextView13);
    		t13.setText("not sold");
    	}
    	if(Globala.getEquipmentPrice(3) > 0 && Globala.counterbuyequip3==0 )
    	{
    		buy4=(Button) this.findViewById(R.id.ButtonEnergy);
    		buy4.setVisibility(View.VISIBLE);
    		 //buyStuff(3);
    		t14=(TextView) this.findViewById(R.id.EnergyTextView14);
    		t14.setText(String.valueOf(Globala.getEquipmentPrice(3)));
    	}
    	else
    	{
    		buy4=(Button) this.findViewById(R.id.ButtonEnergy);
    		buy4.setVisibility(View.INVISIBLE);
    		t14=(TextView) this.findViewById(R.id.EnergyTextView14);
    		t14.setText("not sold");
    	}	
    	
    	if(Globala.getEquipmentPrice(4) > 0 && Globala.counterbuyequip4==0)
    	{
    		buy5=(Button) this.findViewById(R.id.ButtonReflection);
    		buy5.setVisibility(View.VISIBLE);
    		// buyStuff(4);
    		t15=(TextView) this.findViewById(R.id.ReflectionTextView15);
    		t15.setText(String.valueOf(Globala.getEquipmentPrice(4)));
    	}
    	else
    	{
    		buy5=(Button) this.findViewById(R.id.ButtonReflection);
    		buy5.setVisibility(View.INVISIBLE);
    		t15=(TextView) this.findViewById(R.id.ReflectionTextView15);
    		t15.setText("not sold");
    	}
    	
    	if(Globala.getEquipmentPrice(5) > 0 && Globala.counterbuyequip5==0)
    	{
    		buy6=(Button) this.findViewById(R.id.Button5extracargo);
    		buy6.setVisibility(View.VISIBLE);
    	//	 buyStuff(5);
    		t16=(TextView) this.findViewById(R.id.ExtraTextView16);
    		t16.setText(String.valueOf(Globala.getEquipmentPrice(5)));
    	}
    	else
    	{
    		buy6=(Button) this.findViewById(R.id.Button5extracargo);
    		buy6.setVisibility(View.INVISIBLE);
    		t16=(TextView) this.findViewById(R.id.ExtraTextView16);
    		t16.setText("not sold");
    	}
    		
    	if(Globala.getEquipmentPrice(6) > 0 && Globala.counterbuyequip6==0)
    		{
    		 buy7=(Button) this.findViewById(R.id.ButtonAuto);
    		 buy7.setVisibility(View.VISIBLE);
    		// buyStuff(6);
    		 t17=(TextView) this.findViewById(R.id.AutoTextView17);
    		t17.setText(String.valueOf(Globala.getEquipmentPrice(6)));
    		}
    	else
    		{
    		 buy7=(Button) this.findViewById(R.id.ButtonAuto);
    		 buy7.setVisibility(View.INVISIBLE);
    		 t17=(TextView) this.findViewById(R.id.AutoTextView17);
    		t17.setText("not sold");
    		}
    		
    	if(Globala.getEquipmentPrice(7) > 0 && Globala.counterbuyequip7==0)
    	{
    		buy8=(Button) this.findViewById(R.id.ButtonNavigation);
    		buy8.setVisibility(View.VISIBLE);
    		// buyStuff(7);
    		t18=(TextView) this.findViewById(R.id.NavigationTextView18);
    		t18.setText(String.valueOf(Globala.getEquipmentPrice(7)));
    	}
    	else
    	{
    		buy8=(Button) this.findViewById(R.id.ButtonNavigation);
    		buy8.setVisibility(View.INVISIBLE);
    		t18=(TextView) this.findViewById(R.id.NavigationTextView18);
    		t18.setText("not sold");
    	}
    	
        
        
       

        
       
    	if(Globala.getEquipmentPrice(8) > 0 && Globala.counterbuyequip8==0)
    	{
    		buy9=(Button) this.findViewById(R.id.ButtonTargetting);
    		buy9.setVisibility(View.VISIBLE);
    		// buyStuff(8);
    		t19=(TextView) this.findViewById(R.id.TargetingTextView19);
    		t19.setText(String.valueOf(Globala.getEquipmentPrice(8)));
    	}
    	else
    	{
    		buy9=(Button) this.findViewById(R.id.ButtonTargetting);
    		buy9.setVisibility(View.INVISIBLE);
    		t19=(TextView) this.findViewById(R.id.TargetingTextView19);
    		t19.setText("not sold");
    	}
    	if(Globala.getEquipmentPrice(9) > 0 && Globala.counterbuyequip9==0)
    	{
    		buy10=(Button) this.findViewById(R.id.ButtonCloak);
    		buy10.setVisibility(View.VISIBLE);
    		// buyStuff(9);
    		t20=(TextView) this.findViewById(R.id.CloakingTextView20);
    		t20.setText(String.valueOf(Globala.getEquipmentPrice(9)));
    	}
    		else
    		{    buy10=(Button) this.findViewById(R.id.ButtonCloak);
    		     buy10.setVisibility(View.INVISIBLE);
    			t20=(TextView) this.findViewById(R.id.CloakingTextView20);
    			t20.setText("not sold");
    		}
    	 
   	}
    public void buyStuff(int index)
 	  {
 		 Globala.buyItem(index);
 	  }
    public void onClick(View v)
    {
    	if(Globala.debt>0)
		{
			AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
			alt_bld.setMessage("Before you can buy a new ship or new equipment, you must settle your debts at the bank")
			.setCancelable(false)
			.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() 
			{
				public void onClick(DialogInterface dialog, int id) 
				{
					// Action for 'Yes' Button
					dialog.cancel();
				}
			});
			AlertDialog alert = alt_bld.create();
			alert.setTitle("Notice");
			alert.show();

		}
		else
		{
			if(v==this.buy1)
			{
				if(Globala.credits< Globala.getEquipmentPrice(0))
				{
					AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
					alt_bld.setMessage("You don't have enough cash to pay for this item.Check your GESDB as you may have to make a withdrawl")
					.setCancelable(false)
					.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() 
					{
						public void onClick(DialogInterface dialog, int id)
						{
							dialog.cancel();
						}
					});
					AlertDialog alert = alt_bld.create();
					alert.setTitle("Notice");
					alert.show();
				}
				else
				{
					LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
					alertDialog1 = new AlertDialog.Builder(Buyequip.this).setView(aview).create();
				
					alertDialog1.show();
					Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
					cancel.setText("Cancel");
					cancel.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							alertDialog1.cancel();				
						}
					});
					Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
					confirm.setText("Confirm");
					confirm.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							Globala.credits-=Globala.getEquipmentPrice(0);
							buycash=(TextView) findViewById(R.id.CashbuyeTextView);
					        buycash.setText(String.valueOf(Globala.credits));
							buyStuff(0);
							alertDialog1.cancel();
							buy1=(Button) findViewById(R.id.ButtonBuyPulse);
							buy1.setVisibility(View.INVISIBLE);
							Globala.counterbuyequip0=1;
						}
					});
					t11 = (TextView)aview.findViewById(R.id.Seek1heading);
					t11.setText("Pulse Laser");
					t12=(TextView)aview.findViewById(R.id.Seek1Line1);
					t12.setText("Do you wish to buy this Gadget");
					t13=(TextView)aview.findViewById(R.id.Seek1Line2);
					t13.setText("for "+String.valueOf(Globala.getEquipmentPrice(0))+" credits?");
					t14 =(TextView)aview.findViewById(R.id.Seek1Line3);
					t14.setVisibility(View.INVISIBLE);
					t14 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
					t14.setVisibility(View.INVISIBLE);
				
				}
			}
			if(v==this.buy2)
			{
				if(Globala.credits< Globala.getEquipmentPrice(1))
				{
					AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
					alt_bld.setMessage("You don't have enough cash to pay for this item.Check your GESDB as you may have to make a withdrawl")
					.setCancelable(false)
					.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() 
					{
						public void onClick(DialogInterface dialog, int id)
						{
							dialog.cancel();
						}
					});
					AlertDialog alert = alt_bld.create();
					alert.setTitle("Notice");
					alert.show();
				}
				else
				{
					LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
					alertDialog1 = new AlertDialog.Builder(Buyequip.this).setView(aview).create();
				
					alertDialog1.show();
					Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
					cancel.setText("Cancel");
					cancel.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							alertDialog1.cancel();				
						}
					});
					Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
					confirm.setText("Confirm");
					confirm.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							Globala.credits-=Globala.getEquipmentPrice(1);
							buycash=(TextView) findViewById(R.id.CashbuyeTextView);
					        buycash.setText(String.valueOf(Globala.credits));
							buyStuff(1);
							alertDialog1.cancel();
							buy2=(Button) findViewById(R.id.ButtonBuyDisrupter);
				    		buy2.setVisibility(View.INVISIBLE);
				    		Globala.counterbuyequip1=1;
						}
					});
					t11 = (TextView)aview.findViewById(R.id.Seek1heading);
					t11.setText("Disrupter");
					t12=(TextView)aview.findViewById(R.id.Seek1Line1);
					t12.setText("Do you wish to buy this Gadget");
					t13=(TextView)aview.findViewById(R.id.Seek1Line2);
					t13.setText("for "+String.valueOf(Globala.getEquipmentPrice(1))+" credits?");
					t14 =(TextView)aview.findViewById(R.id.Seek1Line3);
					t14.setVisibility(View.INVISIBLE);
					t14 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
					t14.setVisibility(View.INVISIBLE);
				
				}
			}
			if(v==this.buy3)
			{
				if(Globala.credits< Globala.getEquipmentPrice(2))
				{
					AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
					alt_bld.setMessage("You don't have enough cash to pay for this item.Check your GESDB as you may have to make a withdrawl")
					.setCancelable(false)
					.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() 
					{
						public void onClick(DialogInterface dialog, int id)
						{
							dialog.cancel();
						}
					});
					AlertDialog alert = alt_bld.create();
					alert.setTitle("Notice");
					alert.show();
				}
				else
				{
					LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
					alertDialog1 = new AlertDialog.Builder(Buyequip.this).setView(aview).create();
				
					alertDialog1.show();
					Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
					cancel.setText("Cancel");
					cancel.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							alertDialog1.cancel();				
						}
					});
					Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
					confirm.setText("Confirm");
					confirm.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							Globala.credits-=Globala.getEquipmentPrice(2);
							buycash=(TextView) findViewById(R.id.CashbuyeTextView);
					        buycash.setText(String.valueOf(Globala.credits));
							buyStuff(2);
							buy3=(Button) findViewById(R.id.ButtonJustice);
				    		buy3.setVisibility(View.INVISIBLE);
							alertDialog1.cancel();
							Globala.counterbuyequip2=1;
						}
					});
					t11 = (TextView)aview.findViewById(R.id.Seek1heading);
					t11.setText("Justice Mark IV");
					t12=(TextView)aview.findViewById(R.id.Seek1Line1);
					t12.setText("Do you wish to buy this Gadget");
					t13=(TextView)aview.findViewById(R.id.Seek1Line2);
					t13.setText("for "+String.valueOf(Globala.getEquipmentPrice(2))+" credits?");
					t14 =(TextView)aview.findViewById(R.id.Seek1Line3);
					t14.setVisibility(View.INVISIBLE);
					t14 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
					t14.setVisibility(View.INVISIBLE);
				
				}
			}
			if(v==this.buy4)
			{
				if(Globala.credits< Globala.getEquipmentPrice(3))
				{
					AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
					alt_bld.setMessage("You don't have enough cash to pay for this item.Check your GESDB as you may have to make a withdrawl")
					.setCancelable(false)
					.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() 
					{
						public void onClick(DialogInterface dialog, int id)
						{
							dialog.cancel();
						}
					});
					AlertDialog alert = alt_bld.create();
					alert.setTitle("Notice");
					alert.show();
				}
				else
				{
					LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
					alertDialog1 = new AlertDialog.Builder(Buyequip.this).setView(aview).create();
				
					alertDialog1.show();
					Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
					cancel.setText("Cancel");
					cancel.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							alertDialog1.cancel();				
						}
					});
					Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
					confirm.setText("Confirm");
					confirm.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							Globala.credits-=Globala.getEquipmentPrice(3);
							buycash=(TextView) findViewById(R.id.CashbuyeTextView);
					        buycash.setText(String.valueOf(Globala.credits));
							buyStuff(3);
							buy4=(Button) findViewById(R.id.ButtonEnergy);
				    		buy4.setVisibility(View.INVISIBLE);
							alertDialog1.cancel();
							Globala.counterbuyequip3=1;
						}
					});
					t11 = (TextView)aview.findViewById(R.id.Seek1heading);
					t11.setText("Energy Shield");
					t12=(TextView)aview.findViewById(R.id.Seek1Line1);
					t12.setText("Do you wish to buy this Gadget");
					t13=(TextView)aview.findViewById(R.id.Seek1Line2);
					t13.setText("for "+String.valueOf(Globala.getEquipmentPrice(3))+" credits?");
					t14 =(TextView)aview.findViewById(R.id.Seek1Line3);
					t14.setVisibility(View.INVISIBLE);
					t14 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
					t14.setVisibility(View.INVISIBLE);
				
				}
			}
			if(v==this.buy5)
			{
				if(Globala.credits< Globala.getEquipmentPrice(5))
				{
					AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
					alt_bld.setMessage("You don't have enough cash to pay for this item.Check your GESDB as you may have to make a withdrawl")
					.setCancelable(false)
					.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() 
					{
						public void onClick(DialogInterface dialog, int id)
						{
							dialog.cancel();
						}
					});
					AlertDialog alert = alt_bld.create();
					alert.setTitle("Notice");
					alert.show();
				}
				else
				{
					LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
					alertDialog1 = new AlertDialog.Builder(Buyequip.this).setView(aview).create();
				
					alertDialog1.show();
					Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
					cancel.setText("Cancel");
					cancel.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							alertDialog1.cancel();				
						}
					});
					Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
					confirm.setText("Confirm");
					confirm.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							Globala.credits-=Globala.getEquipmentPrice(4);
							buycash=(TextView) findViewById(R.id.CashbuyeTextView);
					        buycash.setText(String.valueOf(Globala.credits));
							buyStuff(4);
							buy5=(Button) findViewById(R.id.ButtonReflection);
				    		buy5.setVisibility(View.INVISIBLE);
							alertDialog1.cancel();
							Globala.counterbuyequip4=1;
						}
					});
					t11 = (TextView)aview.findViewById(R.id.Seek1heading);
					t11.setText("Reflection Shield");
					t12=(TextView)aview.findViewById(R.id.Seek1Line1);
					t12.setText("Do you wish to buy this Gadget");
					t13=(TextView)aview.findViewById(R.id.Seek1Line2);
					t13.setText("for "+String.valueOf(Globala.getEquipmentPrice(4))+" credits?");
					t14 =(TextView)aview.findViewById(R.id.Seek1Line3);
					t14.setVisibility(View.INVISIBLE);
					t14 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
					t14.setVisibility(View.INVISIBLE);
				
				}
			}
			if(v==this.buy6)
			{
				if(Globala.credits< Globala.getEquipmentPrice(5))
				{
					AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
					alt_bld.setMessage("You don't have enough cash to pay for this item.Check your GESDB as you may have to make a withdrawl")
					.setCancelable(false)
					.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() 
					{
						public void onClick(DialogInterface dialog, int id)
						{
							dialog.cancel();
						}
					});
					AlertDialog alert = alt_bld.create();
					alert.setTitle("Notice");
					alert.show();
				}
				else
				{
					LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
					alertDialog1 = new AlertDialog.Builder(Buyequip.this).setView(aview).create();
				
					alertDialog1.show();
					Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
					cancel.setText("Cancel");
					cancel.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							alertDialog1.cancel();				
						}
					});
					Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
					confirm.setText("Confirm");
					confirm.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							Globala.credits-=Globala.getEquipmentPrice(5);
							buycash=(TextView) findViewById(R.id.CashbuyeTextView);
					        buycash.setText(String.valueOf(Globala.credits));
							buyStuff(5);
							buy6=(Button) findViewById(R.id.Button5extracargo);
				    		buy6.setVisibility(View.INVISIBLE);
							alertDialog1.cancel();
							Globala.counterbuyequip5=1;
						}
					});
					t11 = (TextView)aview.findViewById(R.id.Seek1heading);
					t11.setText("Buy 5 extra cargo bays");
					t12=(TextView)aview.findViewById(R.id.Seek1Line1);
					t12.setText("Do you wish to buy this Gadget");
					t13=(TextView)aview.findViewById(R.id.Seek1Line2);
					t13.setText("for "+String.valueOf(Globala.getEquipmentPrice(5))+" credits?");
					t14 =(TextView)aview.findViewById(R.id.Seek1Line3);
					t14.setVisibility(View.INVISIBLE);
					t14 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
					t14.setVisibility(View.INVISIBLE);
				
				}
			}
			if(v==this.buy7)
			{
				if(Globala.credits< Globala.getEquipmentPrice(6))
				{
					AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
					alt_bld.setMessage("You don't have enough cash to pay for this item.Check your GESDB as you may have to make a withdrawl")
					.setCancelable(false)
					.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() 
					{
						public void onClick(DialogInterface dialog, int id)
						{
							dialog.cancel();
						}
					});
					AlertDialog alert = alt_bld.create();
					alert.setTitle("Notice");
					alert.show();
				}
				else
				{
					LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
					alertDialog1 = new AlertDialog.Builder(Buyequip.this).setView(aview).create();
				
					alertDialog1.show();
					Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
					cancel.setText("Cancel");
					cancel.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							alertDialog1.cancel();				
						}
					});
					Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
					confirm.setText("Confirm");
					confirm.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							Globala.credits-=Globala.getEquipmentPrice(6);
							buycash=(TextView) findViewById(R.id.CashbuyeTextView);
					        buycash.setText(String.valueOf(Globala.credits));
							buyStuff(6);
							buy7=(Button) findViewById(R.id.ButtonAuto);
				    		 buy7.setVisibility(View.INVISIBLE);
							alertDialog1.cancel();
							Globala.counterbuyequip6=1;
						}
					});
					t11 = (TextView)aview.findViewById(R.id.Seek1heading);
					t11.setText("Auto Repair System");
					t12=(TextView)aview.findViewById(R.id.Seek1Line1);
					t12.setText("Do you wish to buy this Gadget");
					t13=(TextView)aview.findViewById(R.id.Seek1Line2);
					t13.setText("for "+String.valueOf(Globala.getEquipmentPrice(6))+" credits?");
					t14 =(TextView)aview.findViewById(R.id.Seek1Line3);
					t14.setVisibility(View.INVISIBLE);
					t14 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
					t14.setVisibility(View.INVISIBLE);
				
				}
			}
			if(v==this.buy8)
			{
				if(Globala.credits< Globala.getEquipmentPrice(7))
				{
					AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
					alt_bld.setMessage("You don't have enough cash to pay for this item.Check your GESDB as you may have to make a withdrawl")
					.setCancelable(false)
					.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() 
					{
						public void onClick(DialogInterface dialog, int id)
						{
							dialog.cancel();
						}
					});
					AlertDialog alert = alt_bld.create();
					alert.setTitle("Notice");
					alert.show();
				}
				else
				{
					LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
					alertDialog1 = new AlertDialog.Builder(Buyequip.this).setView(aview).create();
				
					alertDialog1.show();
					Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
					cancel.setText("Cancel");
					cancel.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							alertDialog1.cancel();				
						}
					});
					Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
					confirm.setText("Confirm");
					confirm.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							Globala.credits-=Globala.getEquipmentPrice(7);
							buycash=(TextView) findViewById(R.id.CashbuyeTextView);
					        buycash.setText(String.valueOf(Globala.credits));
							buyStuff(7);
							buy8=(Button) findViewById(R.id.ButtonNavigation);
				    		buy8.setVisibility(View.INVISIBLE);
							alertDialog1.cancel();
							Globala.counterbuyequip7=1;
						}
					});
					t11 = (TextView)aview.findViewById(R.id.Seek1heading);
					t11.setText("Navigation System");
					t12=(TextView)aview.findViewById(R.id.Seek1Line1);
					t12.setText("Do you wish to buy this Gadget");
					t13=(TextView)aview.findViewById(R.id.Seek1Line2);
					t13.setText("for "+String.valueOf(Globala.getEquipmentPrice(7))+" credits?");
					t14 =(TextView)aview.findViewById(R.id.Seek1Line3);
					t14.setVisibility(View.INVISIBLE);
					t14 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
					t14.setVisibility(View.INVISIBLE);
				
				}
			}
			if(v==this.buy9)
			{
				if(Globala.credits< Globala.getEquipmentPrice(8))
				{
					AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
					alt_bld.setMessage("You don't have enough cash to pay for this item.Check your GESDB as you may have to make a withdrawl")
					.setCancelable(false)
					.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() 
					{
						public void onClick(DialogInterface dialog, int id)
						{
							dialog.cancel();
						}
					});
					AlertDialog alert = alt_bld.create();
					alert.setTitle("Notice");
					alert.show();
				}
				else
				{
					LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
					alertDialog1 = new AlertDialog.Builder(Buyequip.this).setView(aview).create();
				
					alertDialog1.show();
					Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
					cancel.setText("Cancel");
					cancel.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							alertDialog1.cancel();				
						}
					});
					Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
					confirm.setText("Confirm");
					confirm.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							Globala.credits-=Globala.getEquipmentPrice(8);
							buycash=(TextView) findViewById(R.id.CashbuyeTextView);
					        buycash.setText(String.valueOf(Globala.credits));
							buyStuff(8);
							buy9=(Button) findViewById(R.id.ButtonTargetting);
				    		buy9.setVisibility(View.INVISIBLE);
							alertDialog1.cancel();
							Globala.counterbuyequip8=1;
						}
					});
					t11 = (TextView)aview.findViewById(R.id.Seek1heading);
					t11.setText("Targetting System");
					t12=(TextView)aview.findViewById(R.id.Seek1Line1);
					t12.setText("Do you wish to buy this Gadget");
					t13=(TextView)aview.findViewById(R.id.Seek1Line2);
					t13.setText("for "+String.valueOf(Globala.getEquipmentPrice(7))+" credits?");
					t14 =(TextView)aview.findViewById(R.id.Seek1Line3);
					t14.setVisibility(View.INVISIBLE);
					t14 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
					t14.setVisibility(View.INVISIBLE);
				
				}
			}
			if(v==this.buy10)
			{
				if(Globala.credits< Globala.getEquipmentPrice(9))
				{
					AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
					alt_bld.setMessage("You don't have enough cash to pay for this item.Check your GESDB as you may have to make a withdrawl")
					.setCancelable(false)
					.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() 
					{
						public void onClick(DialogInterface dialog, int id)
						{
							dialog.cancel();
						}
					});
					AlertDialog alert = alt_bld.create();
					alert.setTitle("Notice");
					alert.show();
				}
				else
				{
					LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
					alertDialog1 = new AlertDialog.Builder(Buyequip.this).setView(aview).create();
				
					alertDialog1.show();
					Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
					cancel.setText("Cancel");
					cancel.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							alertDialog1.cancel();				
						}
					});
					Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
					confirm.setText("Confirm");
					confirm.setOnClickListener(new OnClickListener() 
					{
						public void onClick(View a)
						{
							Globala.credits-=Globala.getEquipmentPrice(9);
							buycash=(TextView) findViewById(R.id.CashbuyeTextView);
					        buycash.setText(String.valueOf(Globala.credits));
							buyStuff(9);
							buy10=(Button) findViewById(R.id.ButtonCloak);
			    		     buy10.setVisibility(View.INVISIBLE);
							alertDialog1.cancel();
							Globala.counterbuyequip9=1;
						}
					});
					t11 = (TextView)aview.findViewById(R.id.Seek1heading);
					t11.setText("Cloaking Device");
					t12=(TextView)aview.findViewById(R.id.Seek1Line1);
					t12.setText("Do you wish to buy this Gadget");
					t13=(TextView)aview.findViewById(R.id.Seek1Line2);
					t13.setText("for "+String.valueOf(Globala.getEquipmentPrice(9))+" credits?");
					t14 =(TextView)aview.findViewById(R.id.Seek1Line3);
					t14.setVisibility(View.INVISIBLE);
					t14 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
					t14.setVisibility(View.INVISIBLE);
				
				}
			}
		}
    }
}