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

public class Buycargo extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	private Button buycargoclose;
	private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	
	private Button buy1,buy2,buy3,buy4,buy5,buy6,buy7,buy8,buy9,buy10;
	private Button buy11,buy12,buy13,buy14,buy15,buy16,buy17,buy18,buy19,buy20;
	public AlertDialog alertDialog1;
	 
	 int buyCargoViewValue[]= new int[Globala.MAXTRADEITEM];
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.buycargo);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t1 = (TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Buy Cargo");
      
        buycargoclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
        buycargoclose.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		
        		Intent buycargo1=new Intent(Buycargo.this,main.class);
           		startActivity(buycargo1);
        	}
        });
       
        
        
        buy1=(Button)this.findViewById(R.id.Buttonbuycargo1);
        buy1.setOnClickListener(this);
        buy11 =(Button)this.findViewById(R.id.Buttonbuycargo11);
        buy11.setOnClickListener(this);
        buy2=(Button) this.findViewById(R.id.Buttonbuycargo02);
        buy2.setOnClickListener(this);
        buy12=(Button) this.findViewById(R.id.Buttonbuycargo12);
        buy12.setOnClickListener(this);
        buy3=(Button) this.findViewById(R.id.Buttonbuycargo03);
        buy3.setOnClickListener(this);
    	buy13=(Button) this.findViewById(R.id.Buttonbuycargo13);
    	buy13.setOnClickListener(this);
    	buy4=(Button) this.findViewById(R.id.Buttonbuycargo04);
    	buy4.setOnClickListener(this);
    	buy14=(Button) this.findViewById(R.id.Buttonbuycargo14);
    	buy14.setOnClickListener(this);
    	buy5=(Button) this.findViewById(R.id.Buttonbuycargo05);
    	buy5.setOnClickListener(this);
    	buy15=(Button) this.findViewById(R.id.Buttonbuycargo15);
    	buy15.setOnClickListener(this);
    	buy6=(Button) this.findViewById(R.id.Buttonbuycargo06);
    	buy6.setOnClickListener(this);
    	buy16=(Button) this.findViewById(R.id.Buttonbuycargo16);
    	buy16.setOnClickListener(this);
    	buy7=(Button) this.findViewById(R.id.Buttonbuycargo07);
    	buy7.setOnClickListener(this);
    	buy17=(Button) this.findViewById(R.id.Buttonbuycargo17);
    	buy17.setOnClickListener(this);
    	buy8=(Button) this.findViewById(R.id.Buttonbuycargo08);
    	buy8.setOnClickListener(this);
    	buy18=(Button) this.findViewById(R.id.Buttonbuycargo18);
    	buy18.setOnClickListener(this);
    	buy9=(Button) this.findViewById(R.id.Buttonbuycargo09);
    	buy9.setOnClickListener(this);
    	buy19=(Button) this.findViewById(R.id.Buttonbuycargo19);
    	buy19.setOnClickListener(this);
    	buy10=(Button) this.findViewById(R.id.Buttonbuycargo10);
    	buy10.setOnClickListener(this);
    	buy20=(Button) this.findViewById(R.id.Buttonbuycargo20);
    	buy20.setOnClickListener(this);
        for(int i=0;i<Globala.MAXTRADEITEM;i++)
        {
        	buyCargoViewValue[i]=Globala.getAmountToBuy(i);
        }
        updateView();
    }    
    public void updateView()
    {
        if(Globala.getAmountToBuy(0) > 0 )
        {
    	    buy1=(Button)this.findViewById(R.id.Buttonbuycargo1);
    	    buy1.setText(String.valueOf(Globala.getAmountToBuy(0)));
    	    buy1.setVisibility(View.VISIBLE);
    	    buy11 =(Button)this.findViewById(R.id.Buttonbuycargo11);
    	    buy11.setVisibility(View.VISIBLE);
    	    t1=(TextView) this.findViewById(R.id.TextViewbuycargo11);
    		t1.setText(String.valueOf(Globala.getBuyPrice(0)));
        }
       	else
    	{
    		buy1=(Button) this.findViewById(R.id.Buttonbuycargo1);
   	        buy1.setVisibility(View.INVISIBLE);
    		buy11=(Button) this.findViewById(R.id.Buttonbuycargo11);
   		    buy11.setVisibility(View.INVISIBLE);
   		    t1=(TextView) this.findViewById(R.id.TextViewbuycargo11);
   		    t1.setText("not sold");
       	}
       	if(Globala.getAmountToBuy(1) > 0 )
    	{
    		buy2=(Button) this.findViewById(R.id.Buttonbuycargo02);
   	        buy2.setText(String.valueOf(Globala.getAmountToBuy(1)));
   	        buy2.setVisibility(View.VISIBLE);
       	    t2=(TextView) this.findViewById(R.id.TextViewbuycargo12);
   		    t2.setText(String.valueOf(Globala.getBuyPrice(1)));
   		    buy12=(Button) this.findViewById(R.id.Buttonbuycargo12);
		    buy12.setVisibility(View.VISIBLE);
    	}
    	else
    	{
    		buy2=(Button) this.findViewById(R.id.Buttonbuycargo02);
        	buy2.setVisibility(View.INVISIBLE);		
    		t2=(TextView) this.findViewById(R.id.TextViewbuycargo12);
    		t2.setText("not sold");	
    		buy12=(Button) this.findViewById(R.id.Buttonbuycargo12);
  		     buy12.setVisibility(View.INVISIBLE);
    	}
    	if(Globala.getAmountToBuy(2) > 0 )	
    	{
    		t3=(TextView) this.findViewById(R.id.TextViewbuycargo13);
    		t3.setText(String.valueOf(Globala.getBuyPrice(2)));
    		buy3=(Button) this.findViewById(R.id.Buttonbuycargo03);
    		buy3.setText(String.valueOf(Globala.getAmountToBuy(2)));
    		 buy3.setVisibility(View.VISIBLE);
    		buy13=(Button) this.findViewById(R.id.Buttonbuycargo13);
   		    buy13.setVisibility(View.VISIBLE);
    	}
    	else
    	{
    		buy3=(Button) this.findViewById(R.id.Buttonbuycargo03);
    		buy3.setVisibility(View.INVISIBLE);
    		t3=(TextView) this.findViewById(R.id.TextViewbuycargo13);
    		t3.setText("not sold");
    		buy13=(Button) this.findViewById(R.id.Buttonbuycargo13);
   		    buy13.setVisibility(View.INVISIBLE);
    	}
    	if(Globala.getAmountToBuy(3) > 0 )
    	{
    		buy4=(Button) this.findViewById(R.id.Buttonbuycargo04);
    		buy4.setText(String.valueOf(Globala.getAmountToBuy(3)));
    		 buy4.setVisibility(View.VISIBLE);
    		t4=(TextView) this.findViewById(R.id.TextViewbuycargo14);
    		t4.setText(String.valueOf(Globala.getBuyPrice(3)));
    		buy14=(Button) this.findViewById(R.id.Buttonbuycargo14);
   		    buy14.setVisibility(View.VISIBLE);
    	}
    	else
    	{
    		buy4=(Button) this.findViewById(R.id.Buttonbuycargo04);
    		buy4.setVisibility(View.INVISIBLE);
    		t4=(TextView) this.findViewById(R.id.TextViewbuycargo14);
    		t4.setText("not sold");
    		buy14=(Button) this.findViewById(R.id.Buttonbuycargo14);
   		    buy14.setVisibility(View.INVISIBLE);
    	}	
    	
    	if(Globala.getAmountToBuy(4) > 0 )
    	{
    		buy5=(Button) this.findViewById(R.id.Buttonbuycargo05);
    		buy5.setText(String.valueOf(Globala.getAmountToBuy(4)));
    		 buy5.setVisibility(View.VISIBLE);
    		t5=(TextView) this.findViewById(R.id.TextViewbuycargo15);
    		t5.setText(String.valueOf(Globala.getBuyPrice(4)));
    		buy15=(Button) this.findViewById(R.id.Buttonbuycargo15);
   		    buy15.setVisibility(View.VISIBLE);
    	}
    	else
    	{
    		buy5=(Button) this.findViewById(R.id.Buttonbuycargo05);
    		buy5.setVisibility(View.INVISIBLE);
    		t5=(TextView) this.findViewById(R.id.TextViewbuycargo15);
    		t5.setText("not sold");
    		buy15=(Button) this.findViewById(R.id.Buttonbuycargo15);
   		    buy15.setVisibility(View.INVISIBLE);
    	}	
    	if(Globala.getAmountToBuy(5) > 0 )
    	{
    		buy6=(Button) this.findViewById(R.id.Buttonbuycargo06);
    		buy6.setText(String.valueOf(Globala.getAmountToBuy(5)));
    		 buy6.setVisibility(View.VISIBLE);
    		t6=(TextView) this.findViewById(R.id.TextViewbuycargo16);
    		t6.setText(String.valueOf(Globala.getBuyPrice(5)));
    		buy16=(Button) this.findViewById(R.id.Buttonbuycargo16);
   		    buy16.setVisibility(View.VISIBLE);
    	}
    	else
    	{
    		buy6=(Button) this.findViewById(R.id.Buttonbuycargo06);
    		buy6.setVisibility(View.INVISIBLE);
    		t6=(TextView) this.findViewById(R.id.TextViewbuycargo16);
    		t6.setText("not sold");
    		buy16=(Button) this.findViewById(R.id.Buttonbuycargo16);
   		    buy16.setVisibility(View.INVISIBLE);
    	}
    	if(Globala.getAmountToBuy(6) > 0 )
    	{
    		buy7=(Button) this.findViewById(R.id.Buttonbuycargo07);
    		buy7.setText(String.valueOf(Globala.getAmountToBuy(6)));
    		buy7.setVisibility(View.VISIBLE);
    		t7=(TextView) this.findViewById(R.id.TextViewbuycargo17);
    		t7.setText(String.valueOf(Globala.getBuyPrice(6)));
    		buy17=(Button) this.findViewById(R.id.Buttonbuycargo17);
   		    buy17.setVisibility(View.VISIBLE);
    	}
    	else
    	{
    		buy7=(Button) this.findViewById(R.id.Buttonbuycargo07);
    		buy7.setVisibility(View.INVISIBLE);
    		t7=(TextView) this.findViewById(R.id.TextViewbuycargo17);
    		t7.setText("not sold");
    		buy17=(Button) this.findViewById(R.id.Buttonbuycargo17);
    		buy17.setVisibility(View.INVISIBLE);
    	}
    	if(Globala.getAmountToBuy(7) > 0 )
    	{
    		buy8=(Button) this.findViewById(R.id.Buttonbuycargo08);
    		buy8.setText(String.valueOf(Globala.getAmountToBuy(7)));
    		 buy8.setVisibility(View.VISIBLE);
    		t8=(TextView) this.findViewById(R.id.TextViewbuycargo18);
    		t8.setText(String.valueOf(Globala.getBuyPrice(7)));
    		buy18=(Button) this.findViewById(R.id.Buttonbuycargo18);
   		    buy18.setVisibility(View.VISIBLE);
    	}
    	else
    	{
    		buy8=(Button) this.findViewById(R.id.Buttonbuycargo08);
    		buy8.setVisibility(View.INVISIBLE);
    		t8=(TextView) this.findViewById(R.id.TextViewbuycargo18);
    		t8.setText("not sold");
    		buy18=(Button) this.findViewById(R.id.Buttonbuycargo18);
   		    buy18.setVisibility(View.INVISIBLE);
    	}
    	if(Globala.getAmountToBuy(8) > 0 )
    	{
    		buy9=(Button) this.findViewById(R.id.Buttonbuycargo09);
    		buy9.setText(String.valueOf(Globala.getAmountToBuy(8)));
    		 buy9.setVisibility(View.VISIBLE);
    		t9=(TextView) this.findViewById(R.id.TextViewbuycargo19);
    		t9.setText(String.valueOf(Globala.getBuyPrice(8)));
    		buy19=(Button) this.findViewById(R.id.Buttonbuycargo19);
   		    buy19.setVisibility(View.VISIBLE);
    	}
    	else
    	{
    		buy9=(Button) this.findViewById(R.id.Buttonbuycargo09);
    		buy9.setVisibility(View.INVISIBLE);
    		t9=(TextView) this.findViewById(R.id.TextViewbuycargo19);
    		t9.setText("not sold");
    		buy19=(Button) this.findViewById(R.id.Buttonbuycargo19);
   		    buy19.setVisibility(View.INVISIBLE);
    	}
    	if(Globala.getAmountToBuy(9) > 0 )
    	{
    		buy10=(Button) this.findViewById(R.id.Buttonbuycargo10);
    		buy10.setText(String.valueOf(Globala.getAmountToBuy(9)));
    		 buy10.setVisibility(View.VISIBLE);
    		t10=(TextView) this.findViewById(R.id.TextViewbuycargo20);
    		t10.setText(String.valueOf(Globala.getBuyPrice(9)));
    		buy20=(Button) this.findViewById(R.id.Buttonbuycargo20);
   		    buy20.setVisibility(View.VISIBLE);
    	}
    	else
    	{
    		buy10=(Button) this.findViewById(R.id.Buttonbuycargo10);
    		buy10.setVisibility(View.INVISIBLE);
    		t10=(TextView) this.findViewById(R.id.TextViewbuycargo20);
    		t10.setText("not sold");
    		buy20=(Button) this.findViewById(R.id.Buttonbuycargo20);
   		    buy20.setVisibility(View.INVISIBLE);
        }
    	
    	t1=(TextView)this.findViewById(R.id.TextBuyCargoBayValue);
    	t1.setText(String.valueOf(Globala.filledCargoBays())+"/"+String.valueOf(Globala.totalCargoBays()));
    	
    	t1=(TextView)this.findViewById(R.id.TextBuyCargoCashValue);
    	t1.setText(String.valueOf(Globala.credits)+" cr.");
    	
    	//ON CLICK OF BUY1 - BUY10 ALERT BOX ASKING HOW MANY YOU WANT TO BUY on click udate values call buy cargo
    	//ON CLICK MAX BUY11-BUY20 ALERT BOX UDATING VALUES  (max buttons) on click udate values call buy cargo
    	//
    	 
    } 
    
    public void onClick(View v)
    {
		
    	
		if(v==this.buy1)
		{
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(Buycargo.this).setView(aview).create();
	     	alertDialog1.show();
	     	t1= (TextView)aview.findViewById(R.id.SeekLine1);
	     	t1.setText("At "+Globala.getBuyPrice(0)+" credits each, you can afford "+buyCargoViewValue[0]);
	     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
	     	t2.setText("How much do you want to buy?");
	     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
	     	t4.setText(String.valueOf(buyCargoViewValue[0]));
	
  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
  			s1.setProgress(buyCargoViewValue[0]);
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
  					Globala.buyCargo(0,buyCargoViewValue[0]);
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
		if(v==this.buy11)
		{
			Globala.buyCargo(0,buyCargoViewValue[0]);
			updateView();
		}
		
		if(v==this.buy2)
		{
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(Buycargo.this).setView(aview).create();
	     	alertDialog1.show();
			t1= (TextView)aview.findViewById(R.id.SeekLine1);
	     	t1.setText("At "+Globala.getBuyPrice(1)+" credits each, you can afford "+buyCargoViewValue[1]);
	     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
	     	t2.setText("How much do you want to buy?");
	     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
	     	t4.setText(String.valueOf(buyCargoViewValue[1]));
	
  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
  			s1.setProgress(buyCargoViewValue[1]);
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
  					Globala.buyCargo(1,buyCargoViewValue[1]);
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
		if(v==this.buy12)
		{
			Globala.buyCargo(1,buyCargoViewValue[1]);
			updateView();
		}

		if(v==this.buy3)
		{
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(Buycargo.this).setView(aview).create();
	     	alertDialog1.show();
			t1= (TextView)aview.findViewById(R.id.SeekLine1);
	     	t1.setText("At "+Globala.getBuyPrice(2)+" credits each, you can afford "+buyCargoViewValue[2]);
	     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
	     	t2.setText("How much do you want to buy?");
	     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
	     	t4.setText(String.valueOf(buyCargoViewValue[2]));
	
  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
  			s1.setProgress(buyCargoViewValue[2]);
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
  					Globala.buyCargo(2,buyCargoViewValue[2]);
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
		if(v==this.buy13)
		{
			Globala.buyCargo(2,buyCargoViewValue[2]);
			updateView();
		}
		if(v==this.buy4)
		{
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(Buycargo.this).setView(aview).create();
	     	alertDialog1.show();
			t1= (TextView)aview.findViewById(R.id.SeekLine1);
	     	t1.setText("At "+Globala.getBuyPrice(3)+" credits each, you can afford "+buyCargoViewValue[3]);
	     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
	     	t2.setText("How much do you want to buy?");
	     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
	     	t4.setText(String.valueOf(buyCargoViewValue[3]));
	
  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
  			s1.setProgress(buyCargoViewValue[3]);
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
  					Globala.buyCargo(3,buyCargoViewValue[3]);
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
		if(v==this.buy14)
		{
			Globala.buyCargo(3,buyCargoViewValue[3]);
			updateView();
		}
		if(v==this.buy5)
		{
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(Buycargo.this).setView(aview).create();
	     	alertDialog1.show();
			t1= (TextView)aview.findViewById(R.id.SeekLine1);
	     	t1.setText("At "+Globala.getBuyPrice(4)+" credits each, you can afford "+buyCargoViewValue[4]);
	     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
	     	t2.setText("How much do you want to buy?");
	     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
	     	t4.setText(String.valueOf(buyCargoViewValue[4]));
	
  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
  			s1.setProgress(buyCargoViewValue[4]);
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
  					Globala.buyCargo(4,buyCargoViewValue[4]);
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
		if(v==this.buy15)
		{
			Globala.buyCargo(4,buyCargoViewValue[4]);
			updateView();
		}
		if(v==this.buy6)
		{
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(Buycargo.this).setView(aview).create();
	     	alertDialog1.show();
			t1= (TextView)aview.findViewById(R.id.SeekLine1);
	     	t1.setText("At "+Globala.getBuyPrice(5)+" credits each, you can afford "+buyCargoViewValue[5]);
	     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
	     	t2.setText("How much do you want to buy?");
	     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
	     	t4.setText(String.valueOf(buyCargoViewValue[5]));
	
  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
  			s1.setProgress(buyCargoViewValue[5]);
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
  					Globala.buyCargo(5,buyCargoViewValue[5]);
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
		if(v==this.buy16)
		{
			Globala.buyCargo(5,buyCargoViewValue[5]);
			updateView();
		}
		if(v==this.buy7)
		{
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(Buycargo.this).setView(aview).create();
	     	alertDialog1.show();
			t1= (TextView)aview.findViewById(R.id.SeekLine1);
	     	t1.setText("At "+Globala.getBuyPrice(6)+" credits each, you can afford "+buyCargoViewValue[6]);
	     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
	     	t2.setText("How much do you want to buy?");
	     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
	     	t4.setText(String.valueOf(buyCargoViewValue[6]));
	
  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
  			s1.setProgress(buyCargoViewValue[6]);
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
  					Globala.buyCargo(6,buyCargoViewValue[6]);
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
		if(v==this.buy17)
		{
			Globala.buyCargo(6,buyCargoViewValue[6]);
			updateView();
		}
		if(v==this.buy9)
		{
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(Buycargo.this).setView(aview).create();
	     	alertDialog1.show();
			t1= (TextView)aview.findViewById(R.id.SeekLine1);
	     	t1.setText("At "+Globala.getBuyPrice(8)+" credits each, you can afford "+buyCargoViewValue[8]);
	     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
	     	t2.setText("How much do you want to buy?");
	     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
	     	t4.setText(String.valueOf(buyCargoViewValue[8]));
	
  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
  			s1.setProgress(buyCargoViewValue[8]);
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
  					Globala.buyCargo(8,buyCargoViewValue[8]);
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
		if(v==this.buy19)
		{
			Globala.buyCargo(8,buyCargoViewValue[8]);
			updateView();
		}
		if(v==this.buy10)
		{
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
	     	alertDialog1 = new AlertDialog.Builder(Buycargo.this).setView(aview).create();
	     	alertDialog1.show();
			t1= (TextView)aview.findViewById(R.id.SeekLine1);
	     	t1.setText("At "+Globala.getBuyPrice(9)+" credits each, you can afford "+buyCargoViewValue[9]);
	     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
	     	t2.setText("How much do you want to buy?");
	     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
	     	t4.setText(String.valueOf(buyCargoViewValue[9]));
	
  			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
  			s1.setProgress(buyCargoViewValue[9]);
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
  					Globala.buyCargo(9,buyCargoViewValue[9]);
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
		if(v==this.buy20)
		{
			Globala.buyCargo(9,buyCargoViewValue[9]);
			updateView();
		}


    }
}