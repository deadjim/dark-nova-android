package com.example;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class daledgame extends Activity {
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
        	t1.setText("At 20 clicks from daled you");
        	t2=(TextView)this.findViewById(R.id.line2);
        	t2.setText("encounter a police spathi scout");
            t3=(TextView) this.findViewById(R.id.line3);
        	t3.setText("The police hail they want you to ");
        	t4=(TextView) this.findViewById(R.id.line4);
        	t4.setText("surrender");
        	
        	
            
            bsurrender=(Button) this.findViewById(R.id.surrender);
            bsurrender.setVisibility(View.VISIBLE);
            
            bflee=(Button) this.findViewById(R.id.flee);
            bflee.setVisibility(View.VISIBLE);
            
            
            bignore=(Button) this.findViewById(R.id.ignore);
            bignore.setVisibility(View.INVISIBLE);
                
            bignore=(Button) this.findViewById(R.id.ignore);
            bignore.setOnClickListener(new OnClickListener() {
            	public void onClick(View v){
            		
            		if( ignore==0)
            		{
            		
            		t1=(TextView) findViewById(R.id.line1);
                	t1.setText("At 19 clicks from daled you");
                	t2=(TextView) findViewById(R.id.line2);
                	t2.setText("encounter a Trade Minox");
                	t3=(TextView) findViewById(R.id.line3);
                    t3.setText("It ignores you ");
                    
                	
                	bflee=(Button)findViewById(R.id.flee);
                    bflee.setVisibility(View.INVISIBLE);
                	
            		ignore=1;
            		
            		}
            		else if(ignore ==1)
            		{
            			t1=(TextView) findViewById(R.id.line1);
                    	t1.setText("At 18 clicks from daled you");
                    	t2=(TextView) findViewById(R.id.line2);
                    	t2.setText("encounter a police T-16 Womprat");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("The Police hail they want you to");
                        t4=(TextView) findViewById(R.id.line4);
                        t4.setText("surrender");
                        bflee=(Button) findViewById(R.id.flee);
                        bflee.setVisibility(View.VISIBLE);
                        bsurrender=(Button) findViewById(R.id.surrender);
                        bsurrender.setVisibility(View.VISIBLE);
                		ignore=2;
            		}
            		else if (ignore == 2 )
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 16 clicks from daled you");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("encounter a pirate Vorchan");
                    	t3=(TextView) findViewById(R.id.line3);
                    	t3.setText("Your opponent attacks");
                    	ignore = 3;
            			
            		}
            		else if (ignore==3)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 15 clicks from daled you");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("encounter police Minox");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("The police hail they want you to");
                        t4=(TextView) findViewById(R.id.line4);
                    	t4.setText("surrender");
                    	
                    	bflee=(Button)findViewById(R.id.flee);
                        bflee.setVisibility(View.VISIBLE);
                    	
                    	ignore = 4;
                    	bsurrender=(Button)findViewById(R.id.surrender);
                        bsurrender.setVisibility(View.VISIBLE);
                    	
                    	
            		}
            		else if (ignore == 4)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("The police ship missed you");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("The police ship is still folllowing you ");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("The police hail they want you to ");
                        t4=(TextView) findViewById(R.id.line4);
                        t4.setText("surrender");
                        
                        bsurrender=(Button) findViewById(R.id.surrender);
                        bsurrender.setVisibility(View.VISIBLE);
                        
                        bignore = (Button) findViewById(R.id.ignore);
                        bignore.setText("Flee");
                        ignore=10;
                        
                                            
                        
            		}
            		else if (ignore==10)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 13 clicks from daled you");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("encounter a trader Minox");
                    	t3=(TextView) findViewById(R.id.line3);
                    	t3.setText("It ignores you");
                    	 bignore = (Button) findViewById(R.id.ignore);
                         bignore.setText("Ignore");
                         bsurrender=(Button) findViewById(R.id.surrender);
                         bsurrender.setVisibility(View.INVISIBLE);
                         bflee=(Button) findViewById(R.id.flee);
                         bflee.setVisibility(View.INVISIBLE);
                    	ignore =5;
            		}
            		else if(ignore==5)
            		{
            			t1=(TextView) findViewById(R.id.line1);
                    	t1.setText("At 7 clicks from daled you");
                    	t2=(TextView) findViewById(R.id.line2);
                    	t2.setText("encounter a pirate Minox");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("Your opponent attacks");
                        t4=(TextView) findViewById(R.id.line4);
                    	t4.setText("surrender");
                    	bflee=(Button)findViewById(R.id.flee);
                        bflee.setVisibility(View.VISIBLE);
                    	
                        bsurrender=(Button) findViewById(R.id.surrender);
                        bsurrender.setVisibility(View.VISIBLE);
                    	ignore =6;
            		}
            		else if(ignore==6)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 6 clicks from daled you");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("encounter a pirate spathi scout");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("Your opponent attacks ");
                       
                        
                        bsurrender=(Button) findViewById(R.id.surrender);
                        bsurrender.setVisibility(View.VISIBLE);
                        
                        bignore=(Button) findViewById(R.id.ignore);
                        bignore.setVisibility(View.VISIBLE);
                        bignore.setText("Flee");
            
                        ignore =7;
            		}
            		
            		else if(ignore==7)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 5 clicks from daled");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("you encounter a police Minox");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("The police hail they want you to ");
                        t4=(TextView) findViewById(R.id.line4);
                        t4.setText("surrender");
                        
                        bsurrender=(Button) findViewById(R.id.surrender);
                        bsurrender.setVisibility(View.VISIBLE);
                        
                        bignore=(Button) findViewById(R.id.ignore);
                        bignore.setVisibility(View.VISIBLE);
                        bignore.setText("Flee");
                        
                        ignore=9;
            		} 
                        
            		else if(ignore==9)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 4 clicks from daled");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("you encounter a police Minox");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("The police hail they want you to ");
                        t4=(TextView) findViewById(R.id.line4);
                        t4.setText("surrender");
                        
                        bsurrender=(Button) findViewById(R.id.surrender);
                        bsurrender.setVisibility(View.VISIBLE);
                        
                        bignore=(Button) findViewById(R.id.ignore);
                        bignore.setVisibility(View.VISIBLE);
                        bignore.setText("Flee");
            
                        ignore =11;
            		}
            		else if(ignore==11)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("The police ship missed you");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("The police ship is still following you");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("The police hail they want you to ");
                        t4=(TextView) findViewById(R.id.line4);
                        t4.setText("surrender");
                        
                        bsurrender=(Button) findViewById(R.id.surrender);
                        bsurrender.setVisibility(View.VISIBLE);
                        
                        bignore=(Button) findViewById(R.id.ignore);
                        bignore.setVisibility(View.VISIBLE);
                        bignore.setText("Flee");
            
                        ignore =13;
            		}
            		else if(ignore==13)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 3 clicks from Daled");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("you encounter a police Spathi Scout");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("The police hail they want you to ");
                        t4=(TextView) findViewById(R.id.line4);
                        t4.setText("surrender");
                        
                        bsurrender=(Button) findViewById(R.id.surrender);
                        bsurrender.setVisibility(View.VISIBLE);
                        
                        bignore=(Button) findViewById(R.id.ignore);
                        bignore.setVisibility(View.VISIBLE);
                        bignore.setText("Flee");
            
                        ignore =14;
            		}
            		
            		else if(ignore==14)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 1 clicks from daled");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("you encounter a police Minox");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("The police hail they want you to ");
                        t4=(TextView) findViewById(R.id.line4);
                        t4.setText("surrender");
                        
                        bsurrender=(Button) findViewById(R.id.surrender);
                        bsurrender.setVisibility(View.VISIBLE);
                        
                        bignore=(Button) findViewById(R.id.ignore);
                        bignore.setVisibility(View.VISIBLE);
                        bignore.setText("Flee");
            
                        ignore =11;
            		}
            	}
            });
             
    }
}