package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class jason extends Activity {
    /** Called when the activity is first created. */
	private Button back;
	private TextView t1;
	
	private Button b1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.other);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlegame);
      
        back=(Button)this.findViewById(R.id.gameback);
        back.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		//setContentView(R.layout.buyequipment);
        		Intent back=new Intent(jason.this,shortrangechart.class);
           		startActivity(back);
        	}
        });
        
       t1=(TextView) this.findViewById(R.id.TextWater);
       t1.setText("+1 cr");
       
       t1=(TextView) this.findViewById(R.id.TextFirearms);
       t1.setText("-229 cr");
       
       t1=(TextView) this.findViewById(R.id.TextFood);
       t1.setText("-8 cr");
       
       t1=(TextView) this.findViewById(R.id.TextMedicine);
       t1.setText("-95 cr");
       
       t1=(TextView) this.findViewById(R.id.TextFurs);
       t1.setText("-5 cr");
       
       t1=(TextView) this.findViewById(R.id.TextMachines);
       t1.setText("-141 cr");
       
       t1=(TextView) this.findViewById(R.id.TextOre);
       t1.setText("-16 cr");
       
       t1=(TextView) this.findViewById(R.id.TextNarcotics);
       t1.setText("---");
       
       t1=(TextView) this.findViewById(R.id.TextGames);
       t1.setText("+9 cr");
       
       t1=(TextView) this.findViewById(R.id.TextRobots);
       t1.setText("---");
       
       t1=(TextView) this.findViewById(R.id.TextBaysValue);
       t1.setText("0/15");
       
       t1=(TextView) this.findViewById(R.id.TextCashValue);
       t1.setText("2500 cr");
           
       b1=(Button)this.findViewById(R.id.ButtonNext);
       b1.setOnClickListener(new OnClickListener() {
       	public void onClick(View v){
       		//setContentView(R.layout.buyequipment);
       	//	Intent buyequipmentclose1=new Intent(davlos.this,esmee.class);
          //		startActivity(buyequipmentclose1);
       	}
       });
    }
}