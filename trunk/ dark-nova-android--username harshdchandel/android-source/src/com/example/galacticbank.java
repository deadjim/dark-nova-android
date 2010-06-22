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

public class galacticbank extends Activity {
    /*Called when the activity is first created. */
	public Button bwithdrawcash,b1,b2;
	private Button bbankloan, bgetloan,bpayback;
	private Button bdepositcash;
	private Button bgalacticbank;
	private AlertDialog alertDialog1;
	TextView t1,t2,t3,t4;
	int getloanval,insuranceval,paybackloanval,depositcashval,withdrawcashval;
	Globala gbuy=new Globala(); 
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.galacticbank);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlegbank);
        
        if(gbuy.debt<=0)
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
        	Button getloan = (Button)this.findViewById(R.id.getloan);
        	getloan.setVisibility(View.INVISIBLE);
        }
        if(gbuy.insurance)
        {
        	Button getinsurance = (Button)this.findViewById(R.id.buyinsurance);
        	getinsurance.setVisibility(View.VISIBLE);
        	getinsurance.setText("Stop insurance");
        	gbuy.insurance=false;
        }
        else
        {
        	Button getinsurance = (Button)this.findViewById(R.id.buyinsurance);
        	getinsurance.setVisibility(View.VISIBLE);
        	getinsurance.setText("Get Insurance");
        	gbuy.insurance=true;
        }
        TextView amount = (TextView)this.findViewById(R.id.TextViewCurrentAmountText);
        amount.setText(String.valueOf(depositcashval));
      
        TextView debt = (TextView)this.findViewById(R.id.TextViewCurrentDebtText);
        debt.setText(" "+String.valueOf(gbuy.debt)+" cr");
        
        TextView maxloan=(TextView)this.findViewById(R.id.TextViewMaximumLoanText);
        maxloan.setText(" "+String.valueOf(gbuy.maxLoan())+" cr");
        
        int cost= gbuy.currentShipPriceWithoutCargo(true);
        
        TextView currentshipcost =(TextView)this.findViewById(R.id.TextViewCurrentShipCostText);
        currentshipcost.setText(" "+String.valueOf(cost)+" cr");
        
        int noclaim= gbuy.min(gbuy.noClaim,90);
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
        insmoney.setText(" "+String.valueOf(gbuy.insuranceMoney)+"  ");
        
        TextView currentcash = (TextView)this.findViewById(R.id.TextViewCurrentCashText);
        currentcash.setText(" "+String.valueOf(gbuy.Credits)+" cr" );
       
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
   		     	t1.setText("You can borrow up to "+String.valueOf(gbuy.maxLoan())+" cr.");
   		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
   		     	t2.setText("How much do you want");
   		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
   		     	t4.setText(String.valueOf(gbuy.maxLoan()));
   		
      			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
      			s1.setProgress(gbuy.maxLoan());
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
      					if(getloanval>gbuy.maxLoan())
      					{
      						getloanval=gbuy.maxLoan();
      					}
      					gbuy.getLoan(getloanval);
      					alertDialog1.cancel();
      					Button payloan1 = (Button)findViewById(R.id.paybank);
      					 payloan1.setVisibility(View.VISIBLE);
      					 getloan.setVisibility(View.INVISIBLE);
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
   		     	t1.setText("You have a debt "+gbuy.debt+" cr.");
   		     	t2 = (TextView)aview.findViewById(R.id.SeekLine2);
   		     	t2.setText("How much do you payback?");
   		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
   		     	t4.setText(String.valueOf(gbuy.debt));
   		
      			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
      			s1.setProgress(gbuy.debt);
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
      					
      					gbuy.payback(paybackloanval);
      					alertDialog1.cancel();
      					 Button getloan = (Button)findViewById(R.id.getloan);
      					 getloan.setVisibility(View.VISIBLE);
      					 payloan.setVisibility(View.INVISIBLE);
      					
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
        		if(insurance.getText()=="Buy insurance")
        		{
        			if(!gbuy.escapePod)
        			{
        				LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        				final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
        				alertDialog1 = new AlertDialog.Builder(galacticbank.this).setView(aview).create();
        				alertDialog1.show();
        				t1= (TextView)aview.findViewById(R.id.Seek1Line1);
        				t1.setText("Insurance isn't available for you,");
        				t2 = (TextView)aview.findViewById(R.id.Seek1Line2);
        				t2.setText("since you don't have an escape pod.");
        				t3 = (TextView)aview.findViewById(R.id.Seek1Line3);
        				t3.setVisibility(View.INVISIBLE);
        				t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
        				t4.setVisibility(View.INVISIBLE);
        	   		   		
        				Button borrow = (Button)aview.findViewById(R.id.Seekalertyes);
        				borrow.setText("Dismiss");
        				borrow.setOnClickListener(new OnClickListener() 
        				{
        					public void onClick(View v)
        					{
        						alertDialog1.cancel();
      				 	   	}
        				});
        		
        				Button cancel =(Button)aview.findViewById(R.id.Seekalertno);
        				cancel.setVisibility(View.GONE);
        			}
        			else
        			{
        				//	gbuy.playSound:eBuyInsurance];
        				gbuy.insurance = true;
        				Button insurance = (Button)findViewById(R.id.buyinsurance);
        				insurance.setText("Stop insurance");

        			}
        		}
        		else if(insurance.getText()=="Stop insurance")
        		{
        			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    				final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
    				alertDialog1 = new AlertDialog.Builder(galacticbank.this).setView(aview).create();
    				alertDialog1.show();
    				t1= (TextView)aview.findViewById(R.id.Seek1Line1);
    				t1.setText("Do you really wish to stop");
    				t2 = (TextView)aview.findViewById(R.id.Seek1Line2);
    				t2.setText("your insurance and lose your no-claim?");
    				t3 = (TextView)aview.findViewById(R.id.Seek1Line3);
    				t3.setVisibility(View.INVISIBLE);
    				t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
    				t4.setVisibility(View.INVISIBLE);
        				
    				Button borrow = (Button)aview.findViewById(R.id.Seekalertyes);
    				borrow.setText("Yes");
    				borrow.setOnClickListener(new OnClickListener() 
    				{
    					public void onClick(View v)
    					{
    						gbuy.insurance=false;
    						alertDialog1.cancel();
    						insurance.setText("Buy insurance");
  				 	   	}
    				});
        		}
        	}
       });
        
        
        bgalacticbank=(Button)this.findViewById(R.id.galacticbankclose);
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
        		if(gbuy.credits>0)
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
   		     		t4.setText(String.valueOf(gbuy.credits*0.9));
   		
   		     		SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
   		     		s1.setProgress((int) (gbuy.credits*0.9));
   		     		s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
   		     		{
   		     			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
   		     			{
   		     				// 	TODO Auto-generated method stub
   		     				TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
   		     				alertval.setText(String.valueOf(progress));
   		     				depositcashval=progress;
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
      					
   		     				gbuy.credits-=depositcashval;
   		     				alertDialog1.cancel();
   		     				deposit.setVisibility(View.INVISIBLE);
   		     			Button withdraw = (Button)findViewById(R.id.withdrawcash);
   		     			withdraw.setVisibility(View.VISIBLE);
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
        		if(depositcashval>0)
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
   		     		t4.setText(String.valueOf(depositcashval));
   		
   		     		SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
   		     		s1.setProgress((int) (depositcashval));
   		     		s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
   		     		{
   		     			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
   		     			{
   		     				// 	TODO Auto-generated method stub
   		     				TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
   		     				alertval.setText(String.valueOf(progress));
   		     				withdrawcashval=progress;
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
      					
   		     				gbuy.credits+=withdrawcashval;
   		     				alertDialog1.cancel();
   		     				withdraw.setVisibility(View.INVISIBLE);
   		     				deposit.setVisibility(View.VISIBLE);
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
        			withdraw.setVisibility(View.INVISIBLE);
        		}
        	}
        });
             
       
    }
             
	   
}