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
import android.widget.SeekBar;
import android.widget.TextView;

public class galacticbank extends Activity {
    /*Called when the activity is first created. */
	public Button bwithdrawcash,b1,b2;
	
	private Button bgalacticbank,alertyes;
	private AlertDialog alertDialog1,alertDialog;
	TextView t1,t2,t3,t4;
	SeekBar s1;
	public int a,b;
	
	int getloanval,insuranceval,paybackloanval,depositcashval,withdrawcashval;
	 
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.galacticbank);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Galactic Bank");
        
        updateView();
        
       
       
        final Button getloan = (Button)this.findViewById(R.id.getloan);
        getloan.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
   		     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
   		     	alertDialog1 = new AlertDialog.Builder(galacticbank.this).setView(aview).create();
   		     	alertDialog1.show();
   		     	t1= (TextView)aview.findViewById(R.id.SeekLine1);
   		     	t1.setText("You can borrow up to "+String.valueOf(Globala.maxLoan())+" cr.");
   		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
   		     	t2.setText("How much do you want");
   		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
   		     	t4.setText(String.valueOf(Globala.maxLoan()));
   		        alertyes=(Button)aview.findViewById(R.id.Seekalertyes);
   		        alertyes.setText("Ok");
      			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
      			s1.setMax(Globala.maxLoan());
      			s1.setProgress(Globala.maxLoan());
      			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
   			    {
   				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
   				    {
   				    // TODO Auto-generated method stub
   				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
   				    	alertval.setText(String.valueOf(progress));
   				    	getloanval=progress;
   				    }
   				    public void onStartTrackingTouch(SeekBar seekBar)
   				    {
   				    // TODO Auto-generated method stub
   				    }
   				    public void onStopTrackingTouch(SeekBar seekBar) 
   				    {
   				    // TODO Auto-generated method stub
   				    }
   			    });
   			
      			Button borrow = (Button)aview.findViewById(R.id.Seekalertyes);
      			borrow.setOnClickListener(new OnClickListener() 
      			{
      				public void onClick(View v)
      				{
      					if(getloanval>Globala.maxLoan())
      					{
      						getloanval=Globala.maxLoan();
      					}
      					Globala.getLoan(getloanval);
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
        });
        
        final Button payloan = (Button)this.findViewById(R.id.paybank);
        payloan.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
   		     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
   		     	alertDialog1 = new AlertDialog.Builder(galacticbank.this).setView(aview).create();
   		     	alertDialog1.show();
   		     	t1= (TextView)aview.findViewById(R.id.SeekLine1);
   		     	t1.setText("You have a debt "+Globala.debt+" cr.");
   		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
   		     	t2.setText("How much do you payback?");
   		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
   		     	t4.setText(String.valueOf(Globala.debt));
   		        alertyes=(Button)aview.findViewById(R.id.Seekalertyes);
		        alertyes.setText("Ok");
      			s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
      			s1.setMax(Globala.debt);
      			s1.setProgress(Globala.debt);
      			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
   			    {
   				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
   				    {
   				    // TODO Auto-generated method stub
   				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
   				    	alertval.setText(String.valueOf(progress));
   				    	paybackloanval=progress;
   				    }
   				    public void onStartTrackingTouch(SeekBar seekBar)
   				    {
   				    // TODO Auto-generated method stub
   				    }
   				    public void onStopTrackingTouch(SeekBar seekBar) 
   				    {
   				    // TODO Auto-generated method stub
   				    }
   			    });
   			
      			Button borrow = (Button)aview.findViewById(R.id.Seekalertyes);
      			borrow.setOnClickListener(new OnClickListener() 
      			{
      				public void onClick(View v)
      				{
      					
      					Globala.payback(paybackloanval);
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
        });
        
        
      
        final Button insurance = (Button)this.findViewById(R.id.buyinsurance);
        insurance.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		String harsh=(String) insurance.getText();
        		if(harsh=="Get Insurance") 
        		{
        			if(Globala.escapePod==false)
        			{
        				     				
        				alertDialog = new AlertDialog.Builder(galacticbank.this).create();
        				alertDialog.setTitle("No escape pod");
        				alertDialog.setMessage("Insurance isn't available for you, since you don't have an escape pod.");
        				alertDialog.setButton("Dismiss", new DialogInterface.OnClickListener() {
        		             public void onClick(DialogInterface dialog, int which) {
        		            	 return;
        		             }
        		         }); 
        				alertDialog.show();
        			}
        					
        			else
        			{
        				//	Globala.playSound:eBuyInsurance];
        				Globala.insurance = true;
        				insurance.setText("Stop insuarance");
        				//updateView();
        			}
        		}
        		else if(harsh=="Stop insurance")
        		{
        			alertDialog = new AlertDialog.Builder(galacticbank.this).create();
    				alertDialog.setTitle("Stop Insurance");
    				alertDialog.setMessage("Do you really wish to stop your insurance and lose your no-claim?");
    				alertDialog.setButton("No", new DialogInterface.OnClickListener() {
    		             public void onClick(DialogInterface dialog, int which) {
    		            	 return;
    		             }
    		         }); 
    				alertDialog.setButton("Yes", new DialogInterface.OnClickListener() {
   		             public void onClick(DialogInterface dialog, int which) {
   		            	Globala.insurance=false;
						alertDialog.cancel();
						insurance.setText("Buy insurance");
						//updateView();
   		         
   		             }
   		         }); 
    				alertDialog.show();
        			
        		}
        	}
       });
        
        
        bgalacticbank=(Button)this.findViewById(R.id.ButtonTitleCLose);
        bgalacticbank.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent bgalacticbank1=new Intent(galacticbank.this,main.class);
           		startActivity(bgalacticbank1);
        	}
        });
      
        
        
       final Button deposit = (Button)this.findViewById(R.id.depositcash);
        deposit.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		if(Globala.credits>0)
        		{
        			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        			final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
   		     		alertDialog1 = new AlertDialog.Builder(galacticbank.this).setView(aview).create();
   		     		alertDialog1.show();
   		     		t1= (TextView)aview.findViewById(R.id.SeekLine1);
   		     		t1.setText("How much do you want to deposit");
   		     		t2 = (TextView)aview.findViewById(R.id.SeekLine2);
   		     		t2.setText("into your GESDB?");
   		     		t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
   		     		t4.setText(String.valueOf(Globala.credits*0.9));
   		     	    alertyes=(Button)aview.findViewById(R.id.Seekalertyes);
   		            alertyes.setText("Ok");
   		     		SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
   		     		s1.setMax((int) (Globala.credits*0.9));
   		     		s1.setProgress((int) (Globala.credits*0.9));
   		     		s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
   		     		{
   		     			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
   		     			{
   		     				// 	TODO Auto-generated method stub
   		     				TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
   		     				alertval.setText(String.valueOf(progress));
   		     				b=progress;
   		     			}
   		     			public void onStartTrackingTouch(SeekBar seekBar)
   		     			{
   		     				// TODO Auto-generated method stub
   		     			}
   		     			public void onStopTrackingTouch(SeekBar seekBar) 
   		     			{
   		     				// TODO Auto-generated method stub
   		     			}
   		     		});
   			
   		     		Button borrow = (Button)aview.findViewById(R.id.Seekalertyes);
   		     		borrow.setOnClickListener(new OnClickListener() 
   		     		{
   		     			public void onClick(View v)
   		     			{
   		     				Globala.makeDeposit(b);   		     				
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
        			deposit.setVisibility(View.INVISIBLE);
        		}
        	}
        });
             
             
        final Button withdraw = (Button)this.findViewById(R.id.withdrawcash);
        withdraw.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v)
        	{
        		
        		LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        		final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
   		     	alertDialog1 = new AlertDialog.Builder(galacticbank.this).setView(aview).create();
   		     	alertDialog1.show();
   		     	t1= (TextView)aview.findViewById(R.id.SeekLine1);
   		     	t1.setText("How much do you want to withdraw");
   		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
   		     	t2.setText("into your GESDB?");
   		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
   		     	t4.setText(String.valueOf(Globala.gesdb));
   		        alertyes=(Button)aview.findViewById(R.id.Seekalertyes);
		        alertyes.setText("Ok");
   		     	SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
   		     	s1.setMax(Globala.gesdb);
   		     	s1.setProgress(Globala.gesdb);
   		     	s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
   		     	{
   		     		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
   		     		{
   		     			// 	TODO Auto-generated method stub
   		     			TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
   		     			alertval.setText(String.valueOf(progress));
   		     			a=progress;
   		     		}
   		     		public void onStartTrackingTouch(SeekBar seekBar)
   		     		{
   		     			// TODO Auto-generated method stub
   		     		}
   		     		public void onStopTrackingTouch(SeekBar seekBar) 
   		     		{
   		     			// TODO Auto-generated method stub
   		     		}
   		     	});
   		       
   		 
   		    	Button borrow = (Button)aview.findViewById(R.id.Seekalertyes);
   		    	borrow.setOnClickListener(new OnClickListener() 
   		    	{
   		    		public void onClick(View v)
   		    		{
      					Globala.makeWithDrawl(a);
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
        });
       
    }
    public void updateView()
    {
    	
    	if (Globala.gesdb <= 0)
    	{
    		Button withdraw = (Button)this.findViewById(R.id.withdrawcash);
    		withdraw.setVisibility(View.INVISIBLE);
    		TextView amount = (TextView)this.findViewById(R.id.TextViewCurrentAmountText);
            amount.setText("0 cr");
    	}
    	else {
    		Button withdraw = (Button)this.findViewById(R.id.withdrawcash);
    		withdraw.setVisibility(View.VISIBLE);
    		TextView amount = (TextView)this.findViewById(R.id.TextViewCurrentAmountText);
            amount.setText(String.valueOf(Globala.gesdb)+" cr");
    	}
    	if(Globala.credits<=0)
    	{
    		Button deposit =(Button)this.findViewById(R.id.depositcash);
    		deposit.setVisibility(View.INVISIBLE);
    		
    	}
    	else
    	{
    		Button deposit =(Button)this.findViewById(R.id.depositcash);
    		deposit.setVisibility(View.VISIBLE);
    	}


    	 if(Globala.debt<=0)
         {
         	Button paybackloan = (Button)this.findViewById(R.id.paybank);
         	paybackloan.setVisibility(View.INVISIBLE);
         	Button getloan = (Button)this.findViewById(R.id.getloan);
         	getloan.setVisibility(View.VISIBLE);
         }
         else
         {
         	Button paybackloan = (Button)this.findViewById(R.id.paybank);
         	paybackloan.setVisibility(View.VISIBLE);
         	if (Globala.debt >= Globala.maxLoan())
         	{
    			      	Button getloan = (Button)this.findViewById(R.id.getloan);
    			      	getloan.setVisibility(View.INVISIBLE);
         	}
         }
         if(Globala.insurance)
         {
         	Button getinsurance = (Button)this.findViewById(R.id.buyinsurance);
         	getinsurance.setVisibility(View.VISIBLE);
         	getinsurance.setText("Stop insurance");
         	
         }
         else
         {
         	Button getinsurance = (Button)this.findViewById(R.id.buyinsurance);
         	getinsurance.setVisibility(View.VISIBLE);
         	getinsurance.setText("Get Insurance");
         	
         }
         TextView amount = (TextView)this.findViewById(R.id.TextViewCurrentAmountText);
         amount.setText(String.valueOf(Globala.gesdb));
       
         TextView debt = (TextView)this.findViewById(R.id.TextViewCurrentDebtText);
         debt.setText(String.valueOf(Globala.debt)+" cr");
         
         TextView maxloan=(TextView)this.findViewById(R.id.TextViewMaximumLoanText);
         maxloan.setText(" "+String.valueOf(Globala.maxLoan())+" cr");
         boolean temp=true;
         int cost= Globala.currentShipPriceWithoutCargo(temp);
         
         TextView currentshipcost =(TextView)this.findViewById(R.id.TextViewCurrentShipCostText);
         currentshipcost.setText(" "+String.valueOf(cost)+" cr");
         
         int noclaim= Globala.min(Globala.noClaim,90);
         TextView claim = (TextView)this.findViewById(R.id.TextViewNoClaimText);
         
         if(noclaim==90)
         {
         	claim.setText(" Maximum");
         }
         else
         {
         	claim.setText(" "+String.valueOf(noclaim)+" cr");
         }
         
         TextView insmoney = (TextView)this.findViewById(R.id.TextViewInsuranceCostText);
         insmoney.setText(" "+String.valueOf(Globala.insuranceMoney())+"  ");
         
         TextView currentcash = (TextView)this.findViewById(R.id.TextViewCurrentCashText);
         currentcash.setText(String.valueOf(Globala.credits)+"cr");
    }
             
	   
}