package com.example;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ligongame extends Activity {
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
        	t1.setText("At 17 clicks from ligon you");
        	t2=(TextView)this.findViewById(R.id.line2);
        	t2.setText("encounter a prate Spathi Scout");
            t3=(TextView) this.findViewById(R.id.line3);
        	t3.setText("Your opponent attacks");
            
            bsurrender=(Button) this.findViewById(R.id.surrender);
            bsurrender.setVisibility(View.INVISIBLE);
            
            bflee=(Button) this.findViewById(R.id.flee);
            bflee.setVisibility(View.VISIBLE);
            bflee.setText("Surrender");
            
            bignore=(Button) this.findViewById(R.id.ignore);
            bignore.setVisibility(View.VISIBLE);
            bignore.setText("Flee");
                
            bignore=(Button) this.findViewById(R.id.ignore);
            bignore.setOnClickListener(new OnClickListener() {
            	public void onClick(View v){
            		
            		if( ignore==0)
            		{
            		
            		t1=(TextView) findViewById(R.id.line1);
                	t1.setText("At 16 clicks from ligon you");
                	t2=(TextView) findViewById(R.id.line2);
                	t2.setText("encounter a police Vorchan");
                	t3=(TextView) findViewById(R.id.line3);
                    t3.setText("The police hail they want you to ");
                    t4=(TextView) findViewById(R.id.line4);
                	t4.setText("surrender");
                	
                	
            		ignore=1;
            		
            		}
            		else if(ignore ==1)
            		{
            			t1=(TextView) findViewById(R.id.line1);
                    	t1.setText("At 13 clicks from ligon you");
                    	t2=(TextView) findViewById(R.id.line2);
                    	t2.setText("encounter a police Minox");
                    	t3=(TextView) findViewById(R.id.line3);
                    	t3.setText("The police hail they want you to ");
                        t4=(TextView) findViewById(R.id.line4);
                    	t4.setText("surrender");
                       
                		ignore=2;
            		}
            		else if (ignore == 2 )
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 12 clicks from ligon you");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("encounter a police Vorchan");
                    	t3=(TextView) findViewById(R.id.line3);
                    	t3.setText("It ignores you");
                    	ignore = 3;
            			
            		}
            		else if (ignore==3)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("At 3 clicks from ligon you");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("encounter Pirate Vorchon");
                    	t3=(TextView) findViewById(R.id.line3);
                        t3.setText("your opponent attacks");
                  
                    	ignore = 4;
            		}
            		else if (ignore == 4)
            		{
            			t1=(TextView)findViewById(R.id.line1);
                    	t1.setText("The pirate ship missed you.");
                    	t2=(TextView)findViewById(R.id.line2);
                    	t2.setText("the pirate ship is still following you");
                    	t3=(TextView) findViewById(R.id.line3);
                    	t3.setText("your opponent attacks");
                    	
                        ignore=10;
                        
            		}
            
            	}
            });
             
    }
}