package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class encounter extends Activity {
    /** Called when the activity is first created. */
	private Button buycargoclose;
	private TextView t1;
	private TextView t2;
	private TextView t3;
	private TextView t4;
	private Button bsurrender;
	private Button bflee;
	private Button bignore;
	private Button battack;
	private int surrender,flee;
	private int ignore=0,trade=0;
	private int haede=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.encounter);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebuycargo);
      
      
        	t1.setText("At 20 clicks from Haedees you");
        	t2.setText("encounter a police t-16 Womprat");
            t3.setText("it ignores you");
            
            bsurrender=(Button) this.findViewById(R.id.surrender);
            bsurrender.setVisibility(View.INVISIBLE);
            
            bflee=(Button) this.findViewById(R.id.flee);
            bflee.setVisibility(View.INVISIBLE);
            
            bignore=(Button) this.findViewById(R.id.ignore);
            bignore.setVisibility(View.VISIBLE);
                
            battack=(Button) this.findViewById(R.id.attack);
            battack.setVisibility(View.VISIBLE);
            
            bignore=(Button) this.findViewById(R.id.ignore);
            bignore.setOnClickListener(new OnClickListener() {
            	public void onClick(View v){
            		ignore=1;
            		
            	}
            });
            
            if(ignore==1){
            	t1.setText("At 19 clicks from Haedees you");
            	t2.setText("encounter a trade Minox");
                t3.setText("You are haied with an offer to ");
            	t4.setText("trade goods");
            	
            	bflee=(Button) this.findViewById(R.id.flee);
                bflee.setVisibility(View.VISIBLE);
                bflee.setText("Trade");
                bflee.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		trade=1;
                   	}
                });
                
                
                bignore=(Button) this.findViewById(R.id.ignore);
                bignore.setVisibility(View.VISIBLE);
                bignore.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		ignore=2;
                   	}
                });
                
                battack=(Button) this.findViewById(R.id.attack);
                battack.setVisibility(View.VISIBLE);
                battack.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		
                   	}
                });
                         	
            }
            
            if(ignore==2){
            	t1.setText("At 16 clicks from Haedees you");
            	t2.setText("encounter a YT-1300 Minox");
                t3.setText("It ignores you ");
            	
                
                bflee=(Button) this.findViewById(R.id.flee);
                bflee.setVisibility(View.INVISIBLE);
                
                
                
                bignore=(Button) this.findViewById(R.id.ignore);
                bignore.setVisibility(View.VISIBLE);
                bignore.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		ignore=3;
                   	}
                });
                
                battack=(Button) this.findViewById(R.id.attack);
                battack.setVisibility(View.VISIBLE);
                battack.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		
                   	}
                });
            }
            
            if(ignore==3){
            	t1.setText("At 14 clicks from Haedees you");
            	t2.setText("encounter a pirate Vorchan");
                t3.setText("Your opponent attacks");
            	
            	
            	bflee=(Button) this.findViewById(R.id.flee);
                bflee.setVisibility(View.VISIBLE);
                bflee.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		flee=1;
                   	}
                });
                
                
                bsurrender=(Button) this.findViewById(R.id.surrender);
                bsurrender.setVisibility(View.VISIBLE);
                bsurrender.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		surrender=1;
                   	}
                });
                
                battack=(Button) this.findViewById(R.id.attack);
                battack.setVisibility(View.VISIBLE);
                battack.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		
                   	}
                });
                         	
            }
            
            if(flee==1){
            	t1.setText("The pirate ship missed you");
            	t2.setText("The pirate ship is still following you");
                t3.setText("You are haied with an offer to ");
            	t4.setText("Your opponent attacks");
            	
            	bflee=(Button) this.findViewById(R.id.flee);
                bflee.setVisibility(View.VISIBLE);
                bflee.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		flee=2;
                   	}
                });
                
                
                bsurrender=(Button) this.findViewById(R.id.ignore);
                bsurrender.setVisibility(View.VISIBLE);
                bsurrender.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		surrender=2;
                   	}
                });
                
                battack=(Button) this.findViewById(R.id.attack);
                battack.setVisibility(View.VISIBLE);
                battack.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		
                   	}
                });
                         	
            }
            
            if(flee==2){
            	t1.setText("At 8 clicks from Haedees you");
            	t2.setText("encounter a trade Minox");
                t3.setText("You are hailed with an offer to");
            	t4.setText("trade goods");
            	
            	bflee=(Button) this.findViewById(R.id.flee);
                bflee.setVisibility(View.VISIBLE);
                bflee.setText("Trade");
                bflee.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		trade=2;
                   	}
                });
                bignore=(Button) this.findViewById(R.id.ignore);
                bignore.setVisibility(View.VISIBLE);
                bignore.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		ignore=4;
                   	}
                });
                
                battack=(Button) this.findViewById(R.id.attack);
                battack.setVisibility(View.VISIBLE);
                battack.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		
                   	}
                });
                         	
            }
            
            if(trade==1|| ignore==4){
            	t1.setText("At 6 clicks from Haedes you");
            	t2.setText("encounter a pirate T-16 Womprat");
            	t4.setText("Your opponent attacks");
            	
            	bflee=(Button) this.findViewById(R.id.flee);
                bflee.setVisibility(View.VISIBLE);
                bflee.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		flee=3;
                   	}
                });
                
                
                bsurrender=(Button) this.findViewById(R.id.ignore);
                bsurrender.setVisibility(View.VISIBLE);
                bsurrender.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		surrender=3;
                   	}
                });
                
                battack=(Button) this.findViewById(R.id.attack);
                battack.setVisibility(View.VISIBLE);
                battack.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		
                   	}
                });
                         	
            }
            
            if(flee==3){
            	t1.setText("At 4 clicks from Haedes you");
            	t2.setText("encounter a police T-16 Womprat");
            	t4.setText("It ignores you");
            	
            	bflee=(Button) this.findViewById(R.id.flee);
                bflee.setVisibility(View.INVISIBLE);
                
                
                bsurrender=(Button) this.findViewById(R.id.ignore);
                bsurrender.setVisibility(View.INVISIBLE);
                
                bignore=(Button) this.findViewById(R.id.attack);
                bignore.setVisibility(View.VISIBLE);
                bignore.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		ignore=5;
                   	}
                });
                
                battack=(Button) this.findViewById(R.id.attack);
                battack.setVisibility(View.VISIBLE);
                battack.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		
                   	}
                });
                         	
            }
            
            if(ignore==5){
            	t1.setText("At 2 clicks from Haedes you");
            	t2.setText("encounter a police Spathi Scout");
            	t4.setText("It ignores you");
            	
                           
                bignore=(Button) this.findViewById(R.id.attack);
                bignore.setVisibility(View.VISIBLE);
                bignore.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		ignore=6;
                   	}
                });
                
                battack=(Button) this.findViewById(R.id.attack);
                battack.setVisibility(View.VISIBLE);
                battack.setOnClickListener(new OnClickListener() {
                	public void onClick(View v){
                		
                   	}
                });
                         	
            }
            
            
            
        
    }
}