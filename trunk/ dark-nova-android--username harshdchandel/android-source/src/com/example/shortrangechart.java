package com.example;


import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

public class shortrangechart extends Activity {
    /** Called when the activity is first created. */
	private Button bcclose;
	Globala gbuy=new Globala();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        drawshortrangechart qwe=new drawshortrangechart(this);
        setContentView(qwe);
        
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleshortrangechart);
 
            }
}