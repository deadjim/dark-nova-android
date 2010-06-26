package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class endgame extends Activity {
    /** Called when the activity is first created. */
	private Button back;
	private TextView t1;
//	Globala gbuy=new Globala();
	private Button b1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.other);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("End Game");
       
        
        

/*
   public void showShipDestroyedImage()
    {
    	//self.view = shipDestroyedView;
    	
    	if (gbuy.escapePod)
    	{
    		// shipDestroyedWithPodView;
    	}
    	//[app.gamePlayer playSound:eYouLose];		
    //	[app.gamePlayer eraseAutoSave];
   
    }
    public void showPoorEndGameImage()
    {
    	//self.view = shipPoorEndGameView;
    	
    //	[app.gamePlayer playSound:eYouRetirePoorly];	
    //	[app.gamePlayer eraseAutoSave];	
    }

    public void showHappyEndImage()
    {
    	//self.view = shipHappyEndView;
    //	S1AppDelegate * app = (S1AppDelegate *)[[UIApplication sharedApplication] delegate];	
   // 	[app.gamePlayer playSound:eYouRetirelavishly];
   // 	[app.gamePlayer eraseAutoSave];	
    }


    	public void startNewGame()
    {
    	//[self.view removeFromSuperview];
   // 	S1AppDelegate * app = (S1AppDelegate *)[[UIApplication sharedApplication] delegate];
    	
    /*	int status;
    	if (view == shipDestroyedView)
    		status = 0;
    	else
    	if (view == shipPoorEndGameView)
    		status = 1;
    	else
    		status = 2;
    	*/
    	//boolean  highScore = EndOfGame(status);
    //	[app showStartGame];

   // 	if (highScore) {
    	//	UIViewController* highScores = [[highScoresViewController alloc] initWithNibName:@"highScores" bundle:nil];;
    	//	[highScores autorelease];
    	//	[app.navigationController pushViewController:highScores animated:TRUE];
    		
   // 	}*/
    }

}