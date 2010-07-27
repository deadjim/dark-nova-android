package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class prices extends Activity {
    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
  
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,bwarp;

	
	boolean absolutePrices;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.other);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Prices");
       
        
        bwarp=(Button)this.findViewById(R.id.ButtonWARP);
        bwarp.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		Globala.doWarp(false);
        		        	
        	}
        });
      
        String nm = Globala.getSolarSystemName(Globala.warpSystem);
		t1=(TextView)this.findViewById(R.id.TextViewTitleName);
		t1.setText(nm); 
		t1=(TextView)this.findViewById(R.id.TextInfo);
		t1.setText(Globala.getSolarSystemSpecalResources(Globala.warpSystem));
		
		t1=(TextView)this.findViewById(R.id.TextBaysValue);
		t1.setText(Globala.filledCargoBays()+"/" +Globala.totalCargoBays());
		
		t1=(TextView)this.findViewById(R.id.TextCashValue);
		t1.setText(Globala.credits);
        //put name from get name function
        
        b1=(Button)this.findViewById(R.id.ButtonWater);
        b1.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert msg
        		        	
        	}
        });
        b2=(Button)this.findViewById(R.id.ButtonFurs);
        b2.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert msg
        		        	
        	}
        });
        b3=(Button)this.findViewById(R.id.ButtonFood);
        b3.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert msg
        		        	
        	}
        });
        b4=(Button)this.findViewById(R.id.ButtonOre);
        b4.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert msg
        		        	
        	}
        });
        b5=(Button)this.findViewById(R.id.ButtonGames);
        b5.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert msg
        		        	
        	}
        });
        b6=(Button)this.findViewById(R.id.ButtonFirearms);
        b6.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert msg
        		        	
        	}
        });
        b7=(Button)this.findViewById(R.id.ButtonMedicine);
        b7.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert msg
        		        	
        	}
        });
        b8=(Button)this.findViewById(R.id.ButtonMachine);
        b8.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert msg
        		        	
        	}
        });
        b9=(Button)this.findViewById(R.id.ButtonNarcotics);
        b9.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert msg
        		        	
        	}
        });
        b10=(Button)this.findViewById(R.id.ButtonRobots);
        b10.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//alert msg
        		        	
        	}
        });
	}
	

	public void updateprices()
	{
		int tmp;
	
	    int itemPrice[] = new int[10];
		int itemMax[] = new int [10];
		int isSmart = 0;
		boolean difference = false;
	   for(int i=0;i<10;i++)
	   {
		   itemPrice[i]=0;
		   itemMax[i]=0;
	   }
		
		difference=!absolutePrices;
	
		tmp = Globala.getPriceDifference(0,difference,0, 0, isSmart);
		t1=(TextView)this.findViewById(R.id.TextWater);
		t1.setText(String.valueOf(tmp)); 
		
		tmp = Globala.getPriceDifference(1, difference, 1, 1 ,isSmart);
		t2=(TextView)this.findViewById(R.id.TextFurs);
		t2.setText(String.valueOf(tmp)); 
			
		tmp = Globala.getPriceDifference(2 ,difference, 2 ,2,isSmart);
		t3=(TextView)this.findViewById(R.id.TextFood);
		t3.setText(String.valueOf(tmp)); 
			
		tmp = Globala.getPriceDifference(3, difference,3 ,3,isSmart);
		t4=(TextView)this.findViewById(R.id.TextOre);
		t4.setText(String.valueOf(tmp)); 
		
		tmp = Globala.getPriceDifference(4 ,difference, 4 ,4, isSmart);
		t5=(TextView)this.findViewById(R.id.TextGames);
		t5.setText(String.valueOf(tmp)); 
		
		tmp = Globala.getPriceDifference(5 ,difference, 5 ,5, isSmart);
		t6=(TextView)this.findViewById(R.id.TextFirearms);
		t6.setText(String.valueOf(tmp));
		
		tmp = Globala.getPriceDifference(6 ,difference,6 ,6 ,isSmart);
		t7=(TextView)this.findViewById(R.id.TextMedicine);
		t7.setText(String.valueOf(tmp));
		
		tmp = Globala.getPriceDifference(7, difference,7 ,7,isSmart);
		t8=(TextView)this.findViewById(R.id.TextMachines);
		t8.setText(String.valueOf(tmp));
		
		tmp = Globala.getPriceDifference(8 ,difference,8 ,8 ,isSmart);
		t9=(TextView)this.findViewById(R.id.TextNarcotics);
		t9.setText(String.valueOf(tmp));
		
		tmp = Globala.getPriceDifference(9 ,difference, 9 ,9 ,isSmart);
		t10=(TextView)this.findViewById(R.id.TextRobots);
		t10.setText(String.valueOf(tmp));
		
		

	
	}

}