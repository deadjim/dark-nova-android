package com.example;




import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class loadgame extends Activity{
	Boolean bbb=true;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout lview=new LinearLayout(this);
        lview.setOrientation(1);
        if(Globala.saveitemcounter>0)
        {    	
    DBAdapter.context =this;   
    ids varibs=new ids();
	Cursor cursorGame = varibs.Selectgame();
    
    Log.v("cursorcount", cursorGame.getCount()+"");
    String gamena=null;
    cursorGame.moveToFirst();
    int k=cursorGame.getCount();
    while (k>0)
    {
    gamena=cursorGame.getString(0);
    final Button t=new Button(this);
    t.setId(k+100);
    t.setText(gamena);
    cursorGame.moveToNext();
    k--;
    lview.addView(t);
    t.setOnClickListener(new OnClickListener() {
		public void onClick(View v)
		{
		String ff=(String) t.getText();	
		loadgameacc(ff);
		}
	});
    }
        }
    
    requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
    setContentView(lview);
    getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
    TextView t1 = (TextView)this.findViewById(R.id.TextViewTitleName);
    t1.setText("Load Game");
    Button loadclose=(Button)this.findViewById(R.id.ButtonTitleCLose);
    loadclose.setOnClickListener(new OnClickListener() {
    	public void onClick(View v){
    		
    		Intent loadclose1=new Intent(loadgame.this,main.class);
       		startActivity(loadclose1);
    	}
    });
	}
	public void loadgameacc(String qwe)
    {
		ids varibs=new ids();
		Cursor cursorGame = varibs.Selectgame();
           cursorGame.moveToFirst();
          if (cursorGame.getCount()>0) {
             	int columndexName = cursorGame.getColumnIndex("gamename");   
         	 String   gamena=cursorGame.getString(0);
               	Log.v("columndexName",""+ columndexName);
             	Log.v("gamename",""+gamena);
   	    
             	cursorGame.moveToFirst();
     	
     	
     	int ccc=0;
     	
     	while(bbb)
     	{
     		gamena=cursorGame.getString(0);
     		Log.v("gamenameinwhile",gamena);
     		ccc++;
     		if(cursorGame.isLast())
     		{
     			bbb=false;
     			break;
     		}
     		Log.v("count",""+ ccc);
     		if(gamena.equals(qwe)){
     			Log.v("count","inif");
     			 bbb=false;
     	     break;
     		}
     	   cursorGame.moveToNext();
     	   
     	}
     	
     	Log.v("gamename",""+ gamena);
     	int nameindex=cursorGame.getColumnIndex("name");
     	String variablesname=cursorGame.getString(nameindex);
     	Log.v("variablesname",""+ variablesname);
     	
	
			int i=0,j=0;
			 String a=variablesname;
			 int k=a.length();
			 int pre=0;
				for(i=0;i<k;i++)
				{
					if(a.charAt(i)==',')
					{ 
						j++;
						switch(j)
						{
						  case 1:
							  Globala.credits = Integer.parseInt(a.substring(pre, i));
							  Log.v("tttttttttt", ""+Integer.parseInt(a.substring(pre, i)));							  
							break;
							
						  case 2:
							  Globala.debt  = Integer.parseInt(a.substring(pre,i));
							  Log.v("second", "case2"+Integer.parseInt(a.substring(pre,i)));							
							break;
							
						  case 3:
							  Globala.days  = Integer.parseInt(a.substring(pre,i));
							  Log.v("c", "case3");							  
							break;
							
						  case 4:
							  Globala.warpSystem = Integer.parseInt(a.substring(pre,i));
							   Log.v("d", "case4");
						       break;
                          case 5:
							//  String xy = a.substring(pre+1,i);
							 //buyprice;
							  Log.v("a", "case5");
							break;	  
                          case 6:
                        	  //Globala.SellPrice
							  Log.v("a", "case6");
							break;
                          case 7:
                        	  Globala.policeKills=Integer.parseInt(a.substring(pre,i));
                        	  Log.v("a", "case1");
                        	  	break;
                          case 8:
                        	  Globala.traderKills=Integer.parseInt(a.substring(pre,i));
                        	  Log.v("a", "case1");
                        	  break;
                          
                          case 9:             
                        	  Globala.pirateKills=Integer.parseInt(a.substring(pre,i));
                        	  Log.v("a", "case1");
                        	  break;
                          
                          case 10:
                        	  Globala.policeRecordScore = Integer.parseInt(a.substring(pre,i));
                        	  Log.v("a", "case1");
                        	  break;
                          case 11:
                        	  Globala.reputationScore = Integer.parseInt(a.substring(pre,i));
                        	  Log.v("a", "case1");
                        	  break;
                          	case 12:
                          		Globala.autoFuel = Boolean.parseBoolean(a.substring(pre,i));
                          		Log.v("a", "case1");
                          		break;
                          	case 13:
                          		Globala.autoRepair=Boolean.parseBoolean(a.substring(pre,i));
                          		Log.v("a", "case1");
                          		break;
	
                          	case 14:
                          		Globala.clicks = Integer.parseInt(a.substring(pre,i));
                          		Log.v("a", "case1");
                          		break;
                          	case 15:
                          		Globala.encounterType = Integer.parseInt(a.substring(pre,i));
                          		Log.v("a", "case1");
                          		break;
                          	case 16:
                          		Globala.raided=Boolean.parseBoolean(a.substring(pre,i));
                          		Log.v("a", "case1");
                          		break;
                          	case 17:
                          		Globala.monsterStatus = Integer.parseInt(a.substring(pre,i));
                          		Log.v("a", "case1");
                          		break;
                          	case 18:
                          		Globala.dragonflyStatus = Integer.parseInt(a.substring(pre,i));
                          		Log.v("a", "case1");
                          		break;
                          	case 19:
                          		Globala.japoriDiseaseStatus = Integer.parseInt(a.substring(pre,i));
                          		Log.v("a", "case1");
                          		break;
                          	case 20:
                          		Globala.moonBought=Boolean.parseBoolean(a.substring(pre,i));
                          		Log.v("a", "case1");
                          		break;
                          	case 21:
                          		Globala.monsterHull=Integer.parseInt(a.substring(pre,i));
                          		Log.v("a", "case1");
                          		break;
                          	case 22:
                          		Globala.CommanderName=a.substring(pre,i);
                          		Log.v("a", "case1");
                          		break;
                          	case 23:
	//Globala.Ship
                          		Log.v("a", "case1");	
                          		break;
                          	case 24:
//	Globala.Opponent
                          		Log.v("a", "case1");
                          		break;

                          	case 25:	
                          		//	Globala.Mercenary
							Log.v("a", "case1");
							break;
							case 26:
							//	Globala.SolarSystem
							Log.v("a", "case1");
							break;
							case 27:
							Globala.escapePod=Boolean.parseBoolean(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 28:
							Globala.insurance =Boolean.parseBoolean(a.substring(pre,i));
							  Log.v("a", "case1");
							break;
						case 29:
							Globala.noClaim = Integer.parseInt(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 30:
							Globala.inspected = Boolean.parseBoolean(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 31:
							Globala.alwaysIgnoreTraders = Boolean.parseBoolean(a.substring(pre,i));;
						Log.v("a", "case1");
						break;
						case 32:
							//Globala.Wormhole = 
						Log.v("a", "case1");
						break;
						case 33:
							Globala.diffculty=Integer.parseInt(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 34:
							Globala.pilotSkill=Integer.parseInt(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 35:
							 Globala.fighterSkill=Integer.parseInt(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						
						case 36:
							Globala.traderSkill=Integer.parseInt(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 37:
							Globala.engineerSkill=Integer.parseInt(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 38:
							//Globala.BuyingPrice
						Log.v("a", "case1");
						break;
						case 39:
							Globala.artifactOnBoard=Boolean.parseBoolean(a.substring(pre,i));
							  Log.v("a", "case1");
							break;
						case 40:
							 Globala.reserveMoney = Boolean.parseBoolean(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 41:
							Globala.leaveEmpty=Integer.parseInt(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 42:
							Globala.tribbleMessage=Boolean.parseBoolean(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 43:
							Globala.alwaysInfo= Boolean.parseBoolean(a.substring(pre,i));
							  
						Log.v("a", "case1");
						break;
						case 44:
							Globala.textualEncounters=Boolean.parseBoolean(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 45:
							Globala.jarekStatus=Integer.parseInt(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 46:
							Globala.invasionStatus= Integer.parseInt(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						
						case 47:
							Globala.continuous=Boolean.parseBoolean(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 48:
							Globala.experimentStatus =Integer.parseInt(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 49:
							Globala.wildStatus= Integer.parseInt(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 50:
							Globala.fabricRipProbability = Integer.parseInt(a.substring(pre,i));
							  Log.v("a", "case1");
							break;
						case 51:
							Globala.veryRareEncounter = Integer.parseInt(a.substring(pre,i));
							  Log.v("a", "case1");
							break;
						case 52:
							Globala.reactorStatus = Integer.parseInt(a.substring(pre,i));
							  Log.v("a", "case1");
							break;
						case 53:
							Globala.trackedSystem = Integer.parseInt(a.substring(pre,i));
							  Log.v("a", "case1");
							break;
						case 54:
							Globala.scarabStatus = Integer.parseInt(a.substring(pre,i));
							  Log.v("a", "case1");
							break;
						case 55:
							Globala.alwaysIgnoreTradeInOrbit = Boolean.parseBoolean(a.substring(pre,i));
							  Log.v("a", "case1");
							break;
							
						case 56:
							Globala.showTrackedRange = Boolean.parseBoolean(a.substring(pre,i));
							  Log.v("a", "case1");
							break;
						case 57:
							Globala.justLootedMarie = Boolean.parseBoolean(a.substring(pre,i));
							  Log.v("a", "case1");
							break;
						case 58:
							 Globala.arrivedViaWormhole = Boolean.parseBoolean(a.substring(pre,i));
							  Log.v("a", "case1");
							break;
						case 59:
							 Globala.trackAutoOff = Boolean.parseBoolean(a.substring(pre,i));
							  Log.v("a", "case1");
							break;
						case 60:
							Globala.remindLoans = Boolean.parseBoolean(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 61:
							Globala.canSuperWarp = Boolean.parseBoolean(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						case 62:
							Globala.enablemusic = Boolean.parseBoolean(a.substring(pre,i));
						Log.v("a", "case1");
						break;
						}
						pre=i+1;
					}
					
				}
			
	
     }  
          Globala.StartNewGame();
          Intent bb1=new Intent(loadgame.this,main.class);
  		startActivity(bb1);    
}
}
