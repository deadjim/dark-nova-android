package com.example;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class davlosgame extends Activity {
    /** Called when the activity is first created. */
	
	private TextView t1;
	private TextView t2;
	private TextView t3;
	private TextView t4;
	private Button bsurrender;
	private Button bflee;
	private Button bignore;
	private int ignore;
	public int haede;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.encounter);
     //   getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
      
        	
            t1=(TextView)this.findViewById(R.id.line1);
        	t1.setText("At 19 clicks from davlos you");
        	t2=(TextView)this.findViewById(R.id.line2);
        	t2.setText("encounter a police Spathi Scout");
            t3=(TextView) this.findViewById(R.id.line3);
        	t3.setText("the police  summon you to submit");
        	t4=(TextView) this.findViewById(R.id.line4);
        	t4.setText("to a inspection");
        	
        	
            
            bsurrender=(Button) this.findViewById(R.id.surrender);
            bsurrender.setVisibility(View.VISIBLE);
            bsurrender.setText("Bribe");
            
            bflee=(Button) this.findViewById(R.id.flee);
            bflee.setVisibility(View.VISIBLE);
            bflee.setText("Submit");
            
            bignore=(Button) this.findViewById(R.id.ignore);
            bignore.setVisibility(View.VISIBLE);
            bignore.setText("Flee");
                
            bignore=(Button) this.findViewById(R.id.ignore);
            bignore.setOnClickListener(new OnClickListener() {
            	public void onClick(View v){
            		
            		if( ignore==0)
            		{
            		
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("The pirate ship hits you.");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("The police ship is still following you");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("The police hail they want you to ");
                        t4=(TextView) findViewById(R.id.line4);
                    	t4.setText("surrender");
                	
                	bflee=(Button)findViewById(R.id.flee);
                    bflee.setVisibility(View.VISIBLE);
                	bflee.setText("Surrender");
            		ignore=1;
            		 bsurrender=(Button) findViewById(R.id.surrender);
                     bsurrender.setVisibility(View.INVISIBLE);
            		
            		}
            		else if(ignore ==1)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("The police ship missed you.");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("the police ship is still following you");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("The police hail they want you to ");
                        t4=(TextView) findViewById(R.id.line4);
                    	t4.setText("surrender");
                    	
                		ignore=2;
            		}
            		else if (ignore == 2 )
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 18 clicks from davlos you");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("encounter a trader Nonamite");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("You are hailed with an offer to");
                        t4=(TextView) findViewById(R.id.line4);
                    	t4.setText("trade goods");
                    	
                    	bflee=(Button) findViewById(R.id.flee);
                        bflee.setVisibility(View.VISIBLE);
                        bflee.setText("Trade");
                        
                        bignore=(Button) findViewById(R.id.ignore);
                        bignore.setVisibility(View.VISIBLE);
                        bignore.setText("Ignore");
                    	
                    	ignore = 3;
            			
            		}
            		else if (ignore==3)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 17 clicks from davlos you");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("encounter police T-16 womprat");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("the police hail they want you to ");
                        t4=(TextView) findViewById(R.id.line4);
                    	t4.setText("surrender");
                    	
                    	bflee=(Button)findViewById(R.id.flee);
                        bflee.setVisibility(View.VISIBLE);
                    	bflee.setText("Surrender");
                    	ignore = 4;
                    	
                    	bflee=(Button) findViewById(R.id.flee);
                        bflee.setVisibility(View.VISIBLE);
                    	bflee.setText("Flee");
            		}
            		else if (ignore == 4)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("The police ship missed you.");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("the police ship is still following you");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("The police hail they want you to ");
                        t4=(TextView) findViewById(R.id.line4);
                    	t4.setText("surrender");
                        
                       
                        ignore=10;
                        
            		}
            		else if (ignore==10)
            		{
            			t1=(TextView) findViewById(R.id.line1);
                    	t1.setText("At 14 clicks from davlos you");
                    	t2=(TextView) findViewById(R.id.line2);
                    	t2.setText("encounter a police Minox");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("The police hail they want you to ");
                        t4=(TextView) findViewById(R.id.line4);
                    	t4.setText("surrender");
                    	 
                    	ignore =5;
            		}
            		else if(ignore==5)
            		{
            			t1=(TextView) findViewById(R.id.line1);
                    	t1.setText("At 13 clicks from davlos you");
                    	t2=(TextView) findViewById(R.id.line2);
                    	t2.setText("encounter a trader Vorchan");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("You are hailedwith an offfer to ");
                        t4=(TextView) findViewById(R.id.line4);
                    	t4.setText("trade goods");
                    	bflee=(Button)findViewById(R.id.flee);
                        bflee.setVisibility(View.VISIBLE);
                        
                        bflee=(Button) findViewById(R.id.flee);
                        bflee.setVisibility(View.VISIBLE);
                        bflee.setText("Trade");
                        
                        bignore=(Button) findViewById(R.id.ignore);
                        bignore.setVisibility(View.VISIBLE);
                        bignore.setText("Ignore");
                    	
                    	ignore =6;
                    	
            		}
            		else if(ignore==6)
            		{
            			t1=(TextView) findViewById(R.id.line1);
                    	t1.setText("At 10 clicks from davlos you");
                    	t2=(TextView) findViewById(R.id.line2);
                    	t2.setText("encounter a police Spathi Scout");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("The police hail they want you to ");
                        t4=(TextView) findViewById(R.id.line4);
                    	t4.setText("surrender");
                        
                        
                        
                        bignore=(Button) findViewById(R.id.ignore);
                        bignore.setVisibility(View.VISIBLE);
                        bignore.setText("Flee");
                        bflee=(Button)findViewById(R.id.flee);
                        bflee.setVisibility(View.VISIBLE);
                    	bflee.setText("Surrender");
            
                        ignore =7;
            		}
            		
            		else if(ignore==7)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 6 clicks from davlos");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("you encounter a police T-16 Womprat");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("The police hail they want you to ");
                        t4=(TextView) findViewById(R.id.line4);
                        t4.setText("surrender");
                    
                        ignore=9;
            		} 
                        
            		else if(ignore==9)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 5 clicks from davlos");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("you encounter a trader Spathi Scout");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("It ignores you");
                        
                        bflee=(Button) findViewById(R.id.flee);
                        bflee.setVisibility(View.INVISIBLE);
                       
                        
                        bignore=(Button) findViewById(R.id.ignore);
                        bignore.setVisibility(View.VISIBLE);
                        bignore.setText("Ignore");
                        ignore =11;
            		}
            		else if(ignore==11)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 3 clicks from davlos");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("you encounter a trader vorchan");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("It ignores you");
                       
                        ignore =13;
            		}
            		
            		
            	}
            });
             
    }
}