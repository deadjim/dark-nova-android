package com.example;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class encounter extends Activity {
    private TextView t1;
    Boolean b=false;
	private TextView t3;
	private TextView t4;
	private Button b1,b2,b3,b4;
	
	
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.encounter);
       // Intent intent = getIntent();
        //Globala.Name =(String)intent.getStringExtra("GameName");
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleactivequests);
        t1=(TextView)this.findViewById(R.id.TextViewTitleName);
        t1.setText("Encounter");
        Button cl=(Button) this.findViewById(R.id.ButtonTitleCLose);
        cl.setVisibility(View.INVISIBLE);
        Globala.doWarp(false);
        showEncounterWindow();
        
        
       
        b1=(Button)this.findViewById(R.id.encounterbutton1);
        b1.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		if(Globala.clicks>0)
        		{
        			b1=(Button)findViewById(R.id.encounterbutton1);
        		    String  a=(String) b1.getText();
        		    b=onbuttonpress(a);
        		    showEncounterWindow();
        		    Log.v("clicks",""+Globala.clicks);
        		}
        		else
        		{
        			Intent bb1=new Intent(encounter.this,shortrangechart.class);
               		startActivity(bb1);
        		}
        	}
        });
        b2=(Button)this.findViewById(R.id.encounterbutton2);
        b2.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		if(Globala.clicks>0)
        		{
        		 b2=(Button)findViewById(R.id.encounterbutton2);
        		 String  a=(String) b2.getText();
        		 Log.v("LOG_TAG" ,"b2"+Globala.clicks );
        		 b= onbuttonpress(a);
        		   showEncounterWindow();
        		}
        		else
        		{
        			Intent bb2=new Intent(encounter.this,shortrangechart.class);
               		startActivity(bb2);
        		}
        	}
        });
        b3=(Button)this.findViewById(R.id.encounterbutton3);
        b3.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		if(Globala.clicks>0)
        		{
        		 b3=(Button)findViewById(R.id.encounterbutton3);
        		 String  a=(String) b3.getText();
        		 Log.v("LOG_TAG" ,"b3"+Globala.clicks );
        		 b= onbuttonpress(a);
       		     showEncounterWindow();
        		}
        		else
        		{
        			Intent bb3=new Intent(encounter.this,shortrangechart.class);
               		startActivity(bb3);
        		}
        	}
        });
        b4=(Button)this.findViewById(R.id.encounterbutton4);
        b4.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		if(Globala.clicks>0){
        		 b4=(Button)findViewById(R.id.encounterbutton4);
        		 String  a=(String) b4.getText();
        		 Log.v("LOG_TAG" ,"b4"+Globala.clicks );
        		 b=  onbuttonpress(a);
        		 showEncounterWindow();
        		}
        		else
        		{
        			Intent bb4=new Intent(encounter.this,shortrangechart.class);
               		startActivity(bb4);
        		}
        	}
        });
	  
	}
	 public void drawShips(){
		 drawShip(true);
		 drawShip(false);
	 }
	
  public void drawShip(boolean player)
        {
           int  hull, shield, maxShield, hullMax;	
           String tmp1=null,tmp2=null;
        	if (player) {
        		hull =Globala.getShipHull();
        		shield = Globala.getShipShield() ;
        		maxShield =Globala.getShipShieldMax() ;
        		hullMax = Globala.getShipHullMax();
        	}
        	else {
        		hull = Globala.getShipOpponentHull();
        		shield =  Globala.getShipOpponentShield();		
        		maxShield =  Globala.getShipShieldMax() 	;
        		hullMax =  Globala.getShipOpponentHullMax();
        	}

        	
        	float currentHullAspect = (float)hull/(float)hullMax;
        	float currentShieldAspect = 0.0f;
        	if (maxShield > 0)
        		currentShieldAspect =  (float)shield/(float)maxShield;

        	float aspect;
        	if (currentShieldAspect > 0.0f)
        	{
        		aspect = currentShieldAspect;
        		if (player)
        		{
        			tmp1 = Globala.getShipImageName(Globala.getCurrentShipType());
        		    
        			//	tmp = Globala.getShipShieldImageName(Globala.getCurrentShipType));
        			
        		}
        		else
        		{
        			tmp1 = Globala.getShipImageName(Globala.getShipOpponentType());
        		//	fullDamage = [UIImage imageNamed:tmp];
        		//	[tmp release];
        			tmp2 = Globala.getShipShieldImageName(Globala.getShipOpponentType());
        			//fullHull = [UIImage imageNamed:tmp];
        			//[tmp release];
        		}
        		
        	}
        	else
        	{
        		aspect = currentHullAspect;
        		if (player)
        		{
        			tmp2 = Globala.getShipImageName(Globala.getCurrentShipType());
        		//	fullHull = [UIImage imageNamed:tmp];
        		//	[tmp release];			
        			tmp1 = Globala.getShipDamagedImageName(Globala.getCurrentShipType());
        		//	fullDamage = [UIImage imageNamed:tmp];
        		//	[tmp release];			
        		}
        		else
        		{
        			tmp2 = Globala.getShipImageName(Globala.getShipOpponentType());
        		//	fullHull = [UIImage imageNamed:tmp];
        		//	[tmp release];			
        			tmp1 = Globala.getShipDamagedImageName(Globala.getShipOpponentType());
        		//	fullDamage = [UIImage imageNamed:tmp];
        		//	[tmp release];	
        		}
        		
        	}
        	

        	drawimages(tmp1,tmp2);

       /* 	CGSize size = CGSizeMake(fullHull.size.width, fullHull.size.height);;
        	
        	UIGraphicsBeginImageContext(size);
        	
        	
        	int startfullHullPos = aspect * fullHull.size.width;

        	CGContextRef context = UIGraphicsGetCurrentContext();	
        	
        	CGRect myImageArea = CGRectMake (fullHull.size.width - startfullHullPos, 0,
        							  startfullHullPos, fullHull.size.height);
        	
        	CGImageRef img = CGImageRetain(fullHull.CGImage);
        	CGImageRef mySubimage = CGImageCreateWithImageInRect (img, myImageArea);
        	CGContextDrawImage(context, myImageArea, mySubimage);

        	CGRect myImageArea2 = CGRectMake (0, 0,
        									 fullDamage.size.width - startfullHullPos, fullHull.size.height);
        	
        	CGImageRef img2 = CGImageRetain(fullDamage.CGImage);
        	CGImageRef mySubimage2 = CGImageCreateWithImageInRect (img2, myImageArea2);
        	CGContextDrawImage(context, myImageArea2, mySubimage2);
        	

        	UIImage * destImage;	
        	destImage = UIGraphicsGetImageFromCurrentImageContext();
        	UIGraphicsEndImageContext();
        	CGImageRelease(mySubimage);
        	CGImageRelease(mySubimage2);
        	CGImageRelease(img);
        	CGImageRelease(img2);
        	

        	
        	return destImage;*/
        }
	
  public void updateButtons()
  {
	 drawShips();
	 boolean attackIconStatus = false  ;
	    if (Globala.autoAttack || Globala.autoFlee) 
	    {
		//	[self.view addSubview:interruptButton];
		 
			 attackIconStatus = !attackIconStatus;
			if (attackIconStatus)
			{
				//[self.view addSubview:attackImage];
			}
			else
			{
			//	[self.view addSubview:attackImage2];
			}
		}
		
		int encounterType = Globala.encounterType;
		if (encounterType == Globala.POLICEINSPECTION)
		{
		    b1=(Button)this.findViewById(R.id.encounterbutton4);			
			b1.setText("Attack");
			b2=(Button)this.findViewById(R.id.encounterbutton3);			
			b2.setText("Flee");
			
		    
			b3=(Button)this.findViewById(R.id.encounterbutton2);	
			b3.setText("Submit");
			
			b4=(Button)this.findViewById(R.id.encounterbutton1);		
			b4.setText("Bribe");
			
		} 
		else if (encounterType == Globala.POSTMARIEPOLICEENCOUNTER) 
		{
			
			    b1=(Button)this.findViewById(R.id.encounterbutton4);			
				b1.setText("Attack");
				
				b2=(Button)this.findViewById(R.id.encounterbutton3);			
				b2.setText("Flee");
				
			    
				b3=(Button)this.findViewById(R.id.encounterbutton2);	
				b3.setText("Yield");
				
				b4=(Button)this.findViewById(R.id.encounterbutton1);		
				b4.setText("Bribe");
				
				//[self.view addSubview:attackButton];		
				//[self.view addSubview:fleeButton];
				//[self.view addSubview:yieldButton];
				//[self.view addSubview:bribeButton];
			}
		else if (encounterType == Globala.POLICEFLEE || encounterType == Globala.TRADERFLEE || encounterType == Globala.PIRATEFLEE )
		{
				    b1=(Button)this.findViewById(R.id.encounterbutton4);			
					b1.setText("Attack");
					
					b2=(Button)this.findViewById(R.id.encounterbutton3);			
					b2.setText("Ignore");
					
				    
					b3=(Button)this.findViewById(R.id.encounterbutton2);	
					b3.setVisibility(View.INVISIBLE);
					
					b4=(Button)this.findViewById(R.id.encounterbutton1);		
					b4.setVisibility(View.INVISIBLE);
				//[self.view addSubview:attackButton];		
					//[self.view addSubview:ignoreButton];
	   }
			else if (encounterType == Globala.POLICEATTACK || encounterType ==Globala.PIRATEATTACK || encounterType == Globala.SCARABATTACK )
			{
					b1=(Button)this.findViewById(R.id.encounterbutton4);			
					b1.setText("Attack");
					
					b2=(Button)this.findViewById(R.id.encounterbutton3);			
					b2.setText("Flee");
					
				    
					b3=(Button)this.findViewById(R.id.encounterbutton2);	
					b3.setText("Surrender");
					
					b4=(Button)this.findViewById(R.id.encounterbutton1);		
					b4.setVisibility(View.INVISIBLE);
					//	[self.view addSubview:attackButton];		
					//	[self.view addSubview:fleeButton];
					//	[self.view addSubview:surrenderButton];
			}
			else if (encounterType ==Globala.FAMOUSCAPATTACK ) 
			       {
						b1=(Button)this.findViewById(R.id.encounterbutton4);			
						b1.setText("Attack");
						
						b2=(Button)this.findViewById(R.id.encounterbutton3);			
						b2.setText("Flee");
						b3=(Button)this.findViewById(R.id.encounterbutton2);	
						b3.setVisibility(View.INVISIBLE);
						
						b4=(Button)this.findViewById(R.id.encounterbutton1);		
						b4.setVisibility(View.INVISIBLE);
						//	[self.view addSubview:attackButton];		
						//	[self.view addSubview:fleeButton];
						}
			      else if (encounterType == Globala.TRADERATTACK || encounterType == Globala.SPACEMONSTERATTACK || encounterType == Globala.DRAGONFLYATTACK ) {
								//[self.view addSubview:attackButton];		
								//[self.view addSubview:fleeButton];
							b1=(Button)this.findViewById(R.id.encounterbutton4);			
							b1.setText("Attack");
							
							b2=(Button)this.findViewById(R.id.encounterbutton3);			
							b2.setText("Flee");
							b3=(Button)this.findViewById(R.id.encounterbutton2);	
							b3.setVisibility(View.INVISIBLE);
							
							b4=(Button)this.findViewById(R.id.encounterbutton1);		
							b4.setVisibility(View.INVISIBLE);
							}
		
							else if (encounterType == Globala.TRADERIGNORE || encounterType == Globala.POLICEIGNORE || encounterType == Globala.PIRATEIGNORE  ||
									encounterType == Globala.SPACEMONSTERIGNORE || encounterType == Globala.DRAGONFLYIGNORE || encounterType == Globala.SCARABIGNORE)
							{
									//[self.view addSubview:attackButton];		
									//[self.view addSubview:ignoreButton];
								b1=(Button)this.findViewById(R.id.encounterbutton4);			
								b1.setText("Attack");
								
								b2=(Button)this.findViewById(R.id.encounterbutton3);			
								b2.setText("Ignore");
								b3=(Button)this.findViewById(R.id.encounterbutton2);	
								b3.setVisibility(View.INVISIBLE);
								
								b4=(Button)this.findViewById(R.id.encounterbutton1);		
								b4.setVisibility(View.INVISIBLE);
								}
								else if(encounterType == Globala.TRADERSURRENDER || encounterType == Globala.PIRATESURRENDER )
								{
									
									b1=(Button)this.findViewById(R.id.encounterbutton4);			
									b1.setText("Attack");
									
									b2=(Button)this.findViewById(R.id.encounterbutton3);			
									b2.setText("Ignore");
									b3=(Button)this.findViewById(R.id.encounterbutton2);	
									b2.setText("Plunder");
									
									b4=(Button)this.findViewById(R.id.encounterbutton1);		
									b4.setVisibility(View.INVISIBLE);
									//	[self.view addSubview:attackButton];		
									//	[self.view addSubview:plunderButton];
										//[self.view addSubview:ignoreButton];
									}
								else if (encounterType == Globala.MARIECELESTEENCOUNTER )
								{
									b1=(Button)this.findViewById(R.id.encounterbutton4);			
									b1.setText("Board");
									
									b2=(Button)this.findViewById(R.id.encounterbutton3);			
									b2.setText("Ignore");
									b3=(Button)this.findViewById(R.id.encounterbutton2);	
									b3.setVisibility(View.INVISIBLE);
									
									b4=(Button)this.findViewById(R.id.encounterbutton1);		
									b4.setVisibility(View.INVISIBLE);
									//		[self.view addSubview:boardButton];		
									//		[self.view addSubview:ignoreButton];
								}
									else if (Globala.ENCOUNTERFAMOUS(encounterType))
									{
										b1=(Button)this.findViewById(R.id.encounterbutton4);			
										b1.setText("Attack");
										
										b2=(Button)this.findViewById(R.id.encounterbutton3);			
										b2.setText("Ignore");
										b3=(Button)this.findViewById(R.id.encounterbutton2);	
										b3.setText("Meet");
										
										b4=(Button)this.findViewById(R.id.encounterbutton1);		
										b4.setVisibility(View.INVISIBLE);
											//	[self.view addSubview:attackButton];		
											//	[self.view addSubview:ignoreButton];
											//	[self.view addSubview:meetButton];
											}
										else if (encounterType == Globala.BOTTLEGOODENCOUNTER || encounterType == Globala.BOTTLEOLDENCOUNTER) 
										{
											b1=(Button)this.findViewById(R.id.encounterbutton4);			
											b1.setText("Drink");
											
											b2=(Button)this.findViewById(R.id.encounterbutton3);			
											b2.setText("Ignore");
											b3=(Button)this.findViewById(R.id.encounterbutton2);	
											b3.setVisibility(View.INVISIBLE);
											
											b4=(Button)this.findViewById(R.id.encounterbutton1);		
											b4.setVisibility(View.INVISIBLE);
											    //	[self.view addSubview:drinkButton];		
												//	[self.view addSubview:ignoreButton];
										}
										else if (encounterType == Globala.TRADERSELL || encounterType == Globala.TRADERBUY)
										{
											b1=(Button)this.findViewById(R.id.encounterbutton4);			
											b1.setText("Attack");
											
											b2=(Button)this.findViewById(R.id.encounterbutton3);			
											b2.setText("Ignore");
											b3=(Button)this.findViewById(R.id.encounterbutton2);	
											b3.setText("Trade");
											
											b4=(Button)this.findViewById(R.id.encounterbutton1);		
											b4.setVisibility(View.INVISIBLE);
											       //	[self.view addSubview:attackButton];		
													//	[self.view addSubview:ignoreButton];
													//	[self.view addSubview:tradeButton];
										}
		if (Globala.textualEncounters) {
			
		//	[message1Labe2 removeFromSuperview];
		//	[message1Label removeFromSuperview]; 
		}
		
	
	}
	
 public void encounterDisplayNextAction(boolean  FirstDisplay)
  {
	 
   	int encounterType = Globala.encounterType;
  	
  	if (Globala.encounterType == Globala.POLICEINSPECTION)
  	{
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("The police summon you to submit to an inspection");
  		//message1Labe2.text = @"The police summon you to submit to an inspection";
  	}
  	else if (Globala.encounterType == Globala.POSTMARIEPOLICEENCOUNTER)
  	{
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("We know you removed illegal goods from the Marie Celeste.");
  		t4=(TextView)this.findViewById(R.id.line4);
  		t4.setText(" You must give them up at once!");
  		//message1Labe2.text = @"We know you removed illegal goods from the Marie Celeste. You must give them up at once!";
  	}
  	else if (FirstDisplay && Globala.encounterType == Globala.POLICEATTACK &&  Globala.policeRecordScore > Globala.CRIMINALSCORE)
  	{
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("The police hail they want you to surrender.");
  		//message1Labe2.text = @"The police hail they want you to surrender.";
  	}
  	else if (encounterType == Globala.POLICEFLEE || encounterType == Globala.TRADERFLEE ||
  			encounterType == Globala.PIRATEFLEE)
  	{
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("Your opponent is fleeing");
  		//message1Labe2.text = @"Your opponent is fleeing.";
  	}
  		else if (encounterType == Globala.PIRATEATTACK || encounterType == Globala.POLICEATTACK ||
  				encounterType == Globala.TRADERATTACK || encounterType == Globala.SPACEMONSTERATTACK ||
  				encounterType == Globala.DRAGONFLYATTACK || encounterType == Globala.SCARABATTACK ||
  				encounterType == Globala.FAMOUSCAPATTACK)
  		{
  			t3=(TextView)this.findViewById(R.id.line3);
  	  		t3.setText("Your opponent attacks.");
  		//message1Labe2.text = @ "Your opponent attacks.";
  		}
  	else if (encounterType == Globala.TRADERIGNORE || encounterType == Globala.POLICEIGNORE ||
  			encounterType == Globala.SPACEMONSTERIGNORE || encounterType == Globala.DRAGONFLYIGNORE || 
  			encounterType == Globala.PIRATEIGNORE || encounterType == Globala.SCARABIGNORE)
  	{
  		if (Globala.isShipCloaked())
  		{
  			t3=(TextView)this.findViewById(R.id.line3);
  	  		t3.setText("It doesn't notice you");	
  			//message1Labe2.text = @"It doesn't notice you.";
  		}
  		else
  		{
  			t3=(TextView)this.findViewById(R.id.line3);
  	  		t3.setText("It ignores you.");	
  		//	message1Labe2.text = @"It ignores you.";
  		}
  	}
  	else if (Globala.encounterType == Globala.TRADERSELL || Globala.encounterType == Globala.TRADERBUY)
  	{
  	//	[self.view addSubview:encounterTypeImage];
  	//	encounterTypeImage.image = [UIImage imageNamed:@"trader.png"];
  		t3=(TextView)this.findViewById(R.id.line3);
	  		t3.setText("You are hailed with an offer to trade goods.");
  		//message1Labe2.text = "You are hailed with an offer to trade goods.";
  	}
  	else if (Globala.encounterType == Globala.TRADERSURRENDER || Globala.encounterType == Globala.PIRATESURRENDER)
  	{ 
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("Your opponent hails that he surrenders to you.");
  		
  		//[self.view addSubview:encounterTypeImage];
  	//	encounterTypeImage.image = [UIImage imageNamed:@"trader.png"];		
  	//	message1Labe2.text = @"Your opponent hails that he surrenders to you.";
  	}
  	else if (encounterType == Globala.MARIECELESTEENCOUNTER)
  	{
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("The Marie Celeste appears to be completely abandoned.");
  	//	message1Labe2.text = @ "The Marie Celeste appears to be completely abandoned.";
  	}
  	else if (Globala.ENCOUNTERFAMOUS(encounterType) && Globala.encounterType != Globala.FAMOUSCAPATTACK)
  	{
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("The Captain requests a brief meeting with you.");
  		//message1Labe2.text = @"The Captain requests a brief meeting with you.";
  	}
  	else if (encounterType == Globala.BOTTLEOLDENCOUNTER || encounterType == Globala.BOTTLEGOODENCOUNTER)
  	{
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("It appears to be a rare bottle of Captain Marmoset's Skill Tonic!");
  		//message1Labe2.text = @"It appears to be a rare bottle of Captain Marmoset's Skill Tonic!";
    }
  	
  }
  
public void  showEncounterWindow()
{
	
		 updateButtons();
		 encounterDisplayNextAction(true);
		int EncounterType = Globala.encounterType;
		
		if (EncounterType == Globala.POSTMARIEPOLICEENCOUNTER) 
		{
			t1=(TextView)this.findViewById(R.id.line1);
	  		t1.setText("You encounter the Customs Police.");
			//message1Label.text = @"You encounter the Customs Police.";
		} 
		else 
		{
			String shipName =Globala.getShipName(Globala.getShipOpponentType());
			String shipType=null;
			if (Globala.ENCOUNTERPOLICE( EncounterType )) 
			{
				//t1=(TextView)this.findViewById(R.id.line1);
		  		//t1.setText("a police");
		  		
				
			//	[self.view addSubview:encounterTypeImage];
				//encounterTypeImage.image = [UIImage imageNamed:@"Police.png"];		
				shipType ="a police";
			} else if (Globala.ENCOUNTERPIRATE( EncounterType ))
			{
				
				//[self.view addSubview:encounterTypeImage];
				//encounterTypeImage.image = [UIImage imageNamed:@"Pirate.png"];			
				if (Globala.getShipOpponentType() == Globala.MANTISTYPE)
				{
					shipType ="an alien";
				}
				else{
					shipType ="a pirate";
				}
			} 
			else if (Globala.ENCOUNTERTRADER( EncounterType ))
			{
				//[self.view addSubview:encounterTypeImage];
				//encounterTypeImage.image = [UIImage imageNamed:@"trader.png"];		
				shipType ="a trader";
			} 
			else if (Globala.ENCOUNTERMONSTER( EncounterType ))
			{
				shipType =" ";
			}
			else if (EncounterType ==Globala.MARIECELESTEENCOUNTER)
			{
				shipType ="a drifting ship";
			}
			else if (EncounterType == Globala.CAPTAINAHABENCOUNTER)
			{
				shipType ="the famous Captain Ahab";
			}
			else if (EncounterType == Globala.CAPTAINCONRADENCOUNTER)
				{
				shipType ="Captain Conrad";
				}
			else if (EncounterType == Globala.CAPTAINHUIEENCOUNTER)
				{
				shipType ="Captain Huie";
				}
			else if (EncounterType == Globala.BOTTLEOLDENCOUNTER || EncounterType == Globala.BOTTLEGOODENCOUNTER)
				{
				shipType ="a floating bottle.";
				}
			else
				{
				shipType ="a stolen";
				}
			Log.v("name",""+Globala.Name);
			
			t1=(TextView)this.findViewById(R.id.line1);
			String addon=(Globala.clicks==1 ? "":"s");
	  		t1.setText("At "+ Globala.clicks +  " click " +addon+"from "+ Globala.Name + " you encounter " +shipType+" "+ shipName +" ");
			// message1Label.text = [NSString  stringWithFormat:@"At %i clicks from %@ you encounter %@ %@.", pPlayer.clicks, [pPlayer getSolarSystemName:pPlayer.warpSystem], shipType, shipName]; 
			
		
		}			
	
	}

   public Boolean onbuttonpress(String a)
   {
	  
	   if(a=="Attack")
	   {
		   
		   	if (Globala.TotalWeapons(Globala.Ship, -1, -1) <= 0)
			{
			FrmAlert( "No Weapons");
			//	return true;
			}
		   if (Globala.ENCOUNTERPOLICE( Globala.encounterType ) || Globala.encounterType == Globala.POSTMARIEPOLICEENCOUNTER)
			{
				
				if (Globala.policeRecordScore > Globala.CRIMINALSCORE)
					Globala.policeRecordScore = Globala.CRIMINALSCORE;
				
				Globala.policeRecordScore += Globala.ATTACKPOLICESCORE;
				
				if (Globala.encounterType == Globala.POLICEIGNORE || Globala.encounterType == Globala.POLICEINSPECTION ||Globala.encounterType == Globala.POSTMARIEPOLICEENCOUNTER)
				{
					Globala.encounterType = Globala.POLICEATTACK;
				}
			}
			else if (Globala.ENCOUNTERPIRATE( Globala.encounterType ))
			{
				if (Globala.encounterType == Globala.PIRATEIGNORE)
					Globala.encounterType = Globala.PIRATEATTACK;
			}
			else if (Globala.ENCOUNTERTRADER( Globala.encounterType ))
			{
				if (Globala.encounterType == Globala.TRADERIGNORE || Globala.encounterType == Globala.TRADERBUY ||
						Globala.encounterType == Globala.TRADERSELL)
				{
					if (Globala.policeRecordScore >= Globala.CLEANSCORE)
					{
						
						Globala.policeRecordScore = Globala.DUBIOUSSCORE;
					}
					else
						Globala.policeRecordScore += Globala.ATTACKTRADERSCORE;
				}
				if (Globala.encounterType != Globala.TRADERFLEE)
				{
					if (Globala.TotalWeapons(Globala.Opponent ,-1 ,-1) <= 0)
						Globala.encounterType = Globala.TRADERFLEE;
					else if (Globala.GetRandom( Globala.ELITESCORE ) <= (Globala.reputationScore * 10) / (1 + Globala.Opponent.Type))
						Globala.encounterType = Globala.TRADERFLEE;
					else
						Globala.encounterType = Globala.TRADERATTACK;
				}
			}
			else if (Globala.ENCOUNTERMONSTER( Globala.encounterType ))
			{
				if (Globala.encounterType == Globala.SPACEMONSTERIGNORE)
					Globala.encounterType = Globala.SPACEMONSTERATTACK;
			}
			else if (Globala.ENCOUNTERDRAGONFLY( Globala.encounterType ))
			{
				if (Globala.encounterType == Globala.DRAGONFLYIGNORE)
					Globala.encounterType = Globala.DRAGONFLYATTACK;
			}
			else if (Globala.ENCOUNTERSCARAB( Globala.encounterType ))
			{
				if (Globala.encounterType == Globala.SCARABIGNORE)
					Globala.encounterType = Globala.SCARABATTACK;
			}
			else if (Globala.ENCOUNTERFAMOUS( Globala.encounterType ))
			{
				//if (encounterType != FAMOUSCAPATTACK &&
				//	FrmAlert( SureToAttackFamousAlert ) == SureToAttackFamousOkIWont)
				//	return true;
				if (Globala.policeRecordScore > Globala.VILLAINSCORE)
					Globala.policeRecordScore = Globala.VILLAINSCORE;
				Globala.policeRecordScore += Globala.ATTACKTRADERSCORE;
				if (Globala.encounterType == Globala.CAPTAINHUIEENCOUNTER)
				{
					Globala.addNewsEvent(Globala.CAPTAINHUIEATTACKED);
				}
				else if (Globala.encounterType == Globala.CAPTAINAHABENCOUNTER)
				{
					Globala.addNewsEvent(Globala.CAPTAINAHABATTACKED);
				}
				else if (Globala.encounterType == Globala.CAPTAINCONRADENCOUNTER)
				{
					Globala.addNewsEvent(Globala.CAPTAINCONRADATTACKED);
				}
				Globala.encounterType = Globala.FAMOUSCAPATTACK;
				
			}
			if (Globala.continuous)
				Globala.autoAttack = true;
			boolean temp=false;
			if ( Globala.ExecuteAction(temp))
				{
				return true;
				}
			if (Globala.Ship.Hull <= 0)
				{
				return true;
				}
			Globala.Travel();
		  Log.v("LOG_TAG" ,"inonbuttonpress" + a );
	   }
	   Log.v("LOG_TAG" ,"encounterType" + Globala.encounterType );
	   if(a=="Flee")
	   {
		   Globala.autoAttack = false;
		   Globala.autoFlee = false;
			
			if (Globala.encounterType == Globala.POLICEINSPECTION && Globala.Ship.Cargo[Globala.FIREARMS] <= 0 && Globala.Ship.Cargo[Globala.NARCOTICS] <= 0 && Globala.wildStatus != 1 && (Globala.reactorStatus == 0 || Globala.reactorStatus == 21))
			{
				// TODO:!!!
				//if (FrmAlert( SureToFleeOrBribeAlert ) == SureToFleeOrBribeOkIwont)
				//	return true;
			}
			
			if (Globala.encounterType == Globala.POLICEINSPECTION)
			{
				Globala.encounterType = Globala.POLICEATTACK;
				if (Globala.policeRecordScore > Globala.DUBIOUSSCORE)
					Globala.policeRecordScore = Globala.DUBIOUSSCORE - (Globala.gameDifficulty < Globala.NORMAL ? 0 : 1);
				else
					Globala.policeRecordScore +=Globala.FLEEFROMINSPECTION;
			}
			else if (Globala.encounterType == Globala.POSTMARIEPOLICEENCOUNTER)
			{
				//TODO:!!!!
				//if (FrmAlert( SureToFleePostMarieAlert ) != SureToFleePostMarieOkIwont)
				//{
					Globala.encounterType = Globala.POLICEATTACK;
					if (Globala.policeRecordScore >= Globala.CRIMINALSCORE)
						Globala.policeRecordScore = Globala.CRIMINALSCORE;
					else
						Globala.policeRecordScore += Globala.ATTACKPOLICESCORE;
				//}
			//	else
				//{
				//	return true;
				//}
			}
	      
			if (Globala.continuous)
				Globala.autoFlee = true;
			boolean temp= true;
			if (Globala.ExecuteAction(temp))
			{
				Log.v("ExecuteAction" ,"ExecuteAction" );
				return true;
			}
			if (Globala.Ship.Hull <= 0)
			{	
				return true;
			}
			Globala.Travel();
			
			return false;
	   }
	   
	   if(a=="Ignore")
	   {
		   b= Globala.ignore(); 
		   Log.v("LOG_TAG" ,"inonbuttonpress" + a );
	   }
	   
	   if(a=="Trade")
	   {
		   
		   if (Globala.encounterType == Globala.TRADERBUY)
			{				
				int i =  Globala.GetRandomTradeableItem(Globala.Ship ,Globala.TRADERBUY);
				
				if (i == Globala.NARCOTICS || i == Globala.FIREARMS)
				{
					if (Globala.GetRandom(100) <= 45)
						Globala.SellPrice[i] *= 0.8;
					else
						Globala.SellPrice[i] *= 1.1;
				}
				else
				{
					if (Globala.GetRandom(100) <= 10)
						Globala.SellPrice[i] *= 0.9;
					else
						Globala.SellPrice[i] *= 1.1;
				}
				
				Globala.SellPrice[i] /= Globala.t[i].Roundoff;
				Globala.SellPrice[i]++;
				Globala.SellPrice[i] *= Globala.t[i].Roundoff;
				if (Globala.SellPrice[i] < Globala.t[i].MinTradePrice)
					Globala.SellPrice[i] = Globala.t[i].MinTradePrice;
				if (Globala.SellPrice[i] > Globala.t[i].MaxTradePrice)
					Globala.SellPrice[i] =Globala.t[i].MaxTradePrice;
				
				
				
				Globala.currentState ="eTradeInOrbit";
				Globala.activeTradeItem = i;
				
				LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
   		     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
   		     	final AlertDialog alertDialog1 = new AlertDialog.Builder(encounter.this).setView(aview).create();
   		     	alertDialog1.show();
   		     	t1= (TextView)aview.findViewById(R.id.SeekLine1);
   		     	t1.setText("The trader wants you to buy "+Globala.t[i].Name+", and offers "+String.valueOf(Globala.SellPrice[i])+" cr. each. you have "+String.valueOf(Globala.Ship.Cargo[i]));
   		     	t1 = (TextView)aview.findViewById(R.id.SeekLine2);
   		     	t1.setText("units available. You paid about "+String.valueOf(Globala.BuyingPrice[i]/Globala.Ship.Cargo[i])+" cr. per unit. How many do you wish to sell?");
   		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
   		     	t4.setText(String.valueOf(Globala.Ship.Cargo[i]));
   		
      			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
      			s1.setMax(Globala.Ship.Cargo[i]);
      			s1.setProgress(Globala.Ship.Cargo[i]);
      			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
   			    {
   				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
   				    {
   				    // TODO Auto-generated method stub
   				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
   				    	alertval.setText(String.valueOf(progress));
   				    	
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
      					
      					alertDialog1.cancel();
      					
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
        	
        
				//NSString * message = [NSString stringWithFormat:"The trader wants to buy %, and offers %i  cr. each. You have %i unit(s) available. \n \
						//			  You paid about %i  cr. per unit. How many do you wish to sell?\n\n", [NSString stringWithCString:Tradeitem[i].Name],SellPrice[i], ship.Cargo[i],
						//			  BuyingPrice[i] / ship.Cargo[i]];
				
				
				//AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:"Trade in Orbit" yoffset:90 message:message  
					//															delegate:self cancelButtonTitle:"Cancel" okButtonTitle:"Ok"  thirdButtonTitle:"All"];
				
					
				
			}
			else if (Globala.encounterType == Globala.TRADERSELL)
			{				
				int i = Globala.GetRandomTradeableItem(Globala.Opponent,Globala.TRADERSELL);
				
				if (i == Globala.NARCOTICS || i == Globala.FIREARMS)
				{
					if (Globala.GetRandom(100) <= 45)
						Globala.BuyPrice[i] *= 1.1;
					else
						Globala.BuyPrice[i] *= 0.8;
				}
				else
				{
					if (Globala.GetRandom(100) <= 10)
						Globala.BuyPrice[i] *= 1.1;
					else
						Globala.BuyPrice[i] *= 0.9;
				}
				
				Globala.BuyPrice[i] /= Globala.t[i].Roundoff;
				Globala.BuyPrice[i] *= Globala.t[i].Roundoff;
				if (Globala.BuyPrice[i] < Globala.t[i].MinTradePrice)
					Globala.BuyPrice[i] = Globala.t[i].MinTradePrice;
				if (Globala.BuyPrice[i] > Globala.t[i].MaxTradePrice)
					Globala.BuyPrice[i] = Globala.t[i].MaxTradePrice;
				
				
				Globala.currentState = "eSellInOrbit";
				Globala.activeTradeItem = i;
				//NSString * message = [NSString stringWithFormat:"The trader wants to sell %, for the price of %i  cr. each. The trader has %i unit(s) for sale. \n \
				//You can afford %i unit(s). How many do you wish to buy?\n\n", [NSString stringWithCString:Tradeitem[i].Name], BuyPrice[i],  Opponent.Cargo[i],
				//					  credits / BuyPrice[i]];
				
				
				//AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:"Trade in Orbit" yoffset:90 message:message  
					//															delegate:self cancelButtonTitle:"Cancel" okButtonTitle:"Ok"  thirdButtonTitle:"All"];
				
				LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
   		     	final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek, null);
   		     	final AlertDialog alertDialog1 = new AlertDialog.Builder(encounter.this).setView(aview).create();
   		     	alertDialog1.show();
   		     	t1= (TextView)aview.findViewById(R.id.SeekLine1);
   		     	t1.setText("The trader wants you to sell "+Globala.t[i].Name+", for the price of "+String.valueOf(Globala.BuyPrice[i])+" cr. each. The trader has "+String.valueOf(Globala.Opponent.Cargo[i]));
   		     	t1 = (TextView)aview.findViewById(R.id.SeekLine2);
   		     	t1.setText("units for sale. You can afford "+String.valueOf(Globala.credits/Globala.BuyPrice[i])+" How many do you wish to buy? ");
   		     	t4 =(TextView)aview.findViewById(R.id.Seekalertvalue);
   		     	t4.setText(String.valueOf(Globala.Opponent.Cargo[i]));
   		
      			SeekBar s1=(SeekBar)aview.findViewById(R.id.SeekBaramount);
      			s1.setMax(Globala.Opponent.Cargo[i]);
      			s1.setProgress(Globala.Opponent.Cargo[i]);
      			s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
   			    {
   				    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
   				    {
   				    // TODO Auto-generated method stub
   				    	TextView alertval=(TextView)aview.findViewById(R.id.Seekalertvalue);
   				    	alertval.setText(String.valueOf(progress));
   				    	
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
      					
      					alertDialog1.cancel();
      					
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
			
			

		   Log.v("LOG_TAG" ,"b1" + Globala.clicks );
	   }
	   if(a=="Yeild")
	   {
		   if (Globala.wildStatus == 1)
			{
			   Globala.currentState ="eYieldChoice";
				
				//AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:"You have Jonathan Wild on board!" yoffset:90 message:"Wild will be arrested, too."  
				//																delegate:self cancelButtonTitle:"Cancel" okButtonTitle:"Yield"  thirdButtonTitle:nil];
				
						
				//return true;
			   
			   LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
				final AlertDialog alertDialog1 = new AlertDialog.Builder(encounter.this).setView(aview).create();
			
				alertDialog1.show();
				Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
				cancel.setText("Cancel");
				cancel.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						alertDialog1.cancel();				
					}
				});
				Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
				confirm.setText("Yield");
				confirm.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						
						alertDialog1.cancel();
					}
				});
				TextView t11 = (TextView)aview.findViewById(R.id.Seek1heading);
				t11.setText("You have Jonathan Wild on board!");
				t11=(TextView)aview.findViewById(R.id.Seek1Line1);
				t11.setText("Wild will be arrested, too.");
				t11=(TextView)aview.findViewById(R.id.Seek1Line2);
				t11.setVisibility(View.GONE);
				t11 =(TextView)aview.findViewById(R.id.Seek1Line3);
				t11.setVisibility(View.GONE);
				t11 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
				t11.setVisibility(View.GONE);
			
				
			}
			else if (Globala.reactorStatus > 0 && Globala.reactorStatus < 21)
			{
				Globala.currentState = "eYieldChoice";		
						
			//	AlertModalWindow * myAlertView = [[AlertModalWindow alloc] initWithTitle:"You have an illegal Reactor on board!" yoffset:90 message:"They will destroy the reactor."  
				//																delegate:self cancelButtonTitle:"Cancel" okButtonTitle:"Yeild"  thirdButtonTitle:nil];
				
					
				//return true;
				LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
				final AlertDialog alertDialog1 = new AlertDialog.Builder(encounter.this).setView(aview).create();
			
				alertDialog1.show();
				Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
				cancel.setText("Cancel");
				cancel.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						alertDialog1.cancel();				
					}
				});
				Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
				confirm.setText("Yield");
				confirm.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						
						alertDialog1.cancel();
					}
				});
				TextView t11 = (TextView)aview.findViewById(R.id.Seek1heading);
				t11.setText("You have an illegal Reactor on board!");
				t11=(TextView)aview.findViewById(R.id.Seek1Line1);
				t11.setText("They will destroy the reactor.");
				t11=(TextView)aview.findViewById(R.id.Seek1Line2);
				t11.setVisibility(View.GONE);
				t11 =(TextView)aview.findViewById(R.id.Seek1Line3);
				t11.setVisibility(View.GONE);
				t11 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
				t11.setVisibility(View.GONE);
				
			}
			
			 Globala.yieldContinue();
		  // b=  Globala.yield(); 
		   Log.v("LOG_TAG" ,"b1" + Globala.clicks );
	   }
	   
	   if(a=="Surrender")
	   {
		   Globala.autoAttack = false;
		   Globala.autoFlee = false;
			if ( Globala.Opponent.Type ==  Globala.MANTISTYPE)
			{
				if ( Globala.artifactOnBoard)
				{
					 Globala.currentState =" eSurrenderArtifact";	
					 LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
						final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
						final AlertDialog alertDialog1 = new AlertDialog.Builder(encounter.this).setView(aview).create();
					
						alertDialog1.show();
						Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
						cancel.setText("Cancel");
						cancel.setOnClickListener(new OnClickListener() 
						{
							public void onClick(View a)
							{
								alertDialog1.cancel();				
							}
						});
						Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
						confirm.setText("Surrender");
						confirm.setOnClickListener(new OnClickListener() 
						{
							public void onClick(View a)
							{
								
								alertDialog1.cancel();
							}
						});
						TextView t11 = (TextView)aview.findViewById(R.id.Seek1heading);
						t11.setText("Surrender!");
						t11=(TextView)aview.findViewById(R.id.Seek1Line1);
						t11.setText("WantToSurrenderToAliensAlert");
						t11=(TextView)aview.findViewById(R.id.Seek1Line2);
						t11.setVisibility(View.GONE);
						t11 =(TextView)aview.findViewById(R.id.Seek1Line3);
						t11.setVisibility(View.GONE);
						t11 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
						t11.setVisibility(View.GONE);
				//	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Surrender!" message:NSLocalizedString("WantToSurrenderToAliensAlert", "")  
					//																delegate:self cancelButtonTitle:"Surrender" otherButtonTitles:"Cancel",nil];
					 Globala.bLastMessage = false;
				}
				else
				{
					FrmAlert("NoSurrenderAlert");
					//return true;
				}
			}
			else if (Globala.ENCOUNTERPOLICE( Globala.encounterType ))
			{
				if (Globala.policeRecordScore <= Globala.PSYCHOPATHSCORE)
				{
					FrmAlert("NoSurrenderAlert");
					//return true;
				}
				else
				{
					
			//		 return true;
			
					if (Globala.wildStatus == 1)
					{
						Globala.currentState = " eSurrender";		
						
					//	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"You have Jonathan Wild on board!" message:"Wild will be arrested, too."  
					//																	delegate:self cancelButtonTitle:"Surrender" otherButtonTitles:"Cancel", nil];
						LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
						final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
						final AlertDialog alertDialog1 = new AlertDialog.Builder(encounter.this).setView(aview).create();
					
						alertDialog1.show();
						Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
						cancel.setText("Cancel");
						cancel.setOnClickListener(new OnClickListener() 
						{
							public void onClick(View a)
							{
								alertDialog1.cancel();				
							}
						});
						Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
						confirm.setText("Surrender");
						confirm.setOnClickListener(new OnClickListener() 
						{
							public void onClick(View a)
							{
								
								alertDialog1.cancel();
							}
						});
						TextView t11 = (TextView)aview.findViewById(R.id.Seek1heading);
						t11.setText("You have Jonathan Wild on board!");
						t11=(TextView)aview.findViewById(R.id.Seek1Line1);
						t11.setText("Wild will be arrested, too.");
						t11=(TextView)aview.findViewById(R.id.Seek1Line2);
						t11.setVisibility(View.GONE);
						t11 =(TextView)aview.findViewById(R.id.Seek1Line3);
						t11.setVisibility(View.GONE);
						t11 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
						t11.setVisibility(View.GONE);
						Globala.bLastMessage = false;
						
						
						//return true;
					}
					
					else if (Globala.reactorStatus > 0 && Globala.reactorStatus < 21)
					{
						
						Globala.currentState =" eSurrender";		
					//	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"You have an illegal Reactor on board!" message:"They will destroy the reactor."  
					//																	delegate:self cancelButtonTitle:"Surrender" otherButtonTitles:"Cancel", nil];
						LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
						final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
						final AlertDialog alertDialog1 = new AlertDialog.Builder(encounter.this).setView(aview).create();
					
						alertDialog1.show();
						Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
						cancel.setText("Cancel");
						cancel.setOnClickListener(new OnClickListener() 
						{
							public void onClick(View a)
							{
								alertDialog1.cancel();				
							}
						});
						Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
						confirm.setText("Surrender");
						confirm.setOnClickListener(new OnClickListener() 
						{
							public void onClick(View a)
							{
								
								alertDialog1.cancel();
							}
						});
						TextView t11 = (TextView)aview.findViewById(R.id.Seek1heading);
						t11.setText("You have an illegal reactor on board!");
						t11=(TextView)aview.findViewById(R.id.Seek1Line1);
						t11.setText("They will destroy the reactor.");
						t11=(TextView)aview.findViewById(R.id.Seek1Line2);
						t11.setVisibility(View.GONE);
						t11 =(TextView)aview.findViewById(R.id.Seek1Line3);
						t11.setVisibility(View.GONE);
						t11 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
						t11.setVisibility(View.GONE);
						Globala.bLastMessage = false;
						//return true;
					}
					else
					{
						//	if (FrmCustomAlert( WantToSurrenderAlert, NULL, NULL, NULL ) == WantToSurrenderNo)
						Globala.currentState = "eSurrender";						
						//UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Surrender!" message:NSLocalizedString("WantToSurrenderAlert", "")  
						LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
						final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
						final AlertDialog alertDialog1 = new AlertDialog.Builder(encounter.this).setView(aview).create();
					
						alertDialog1.show();
						Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
						cancel.setText("Cancel");
						cancel.setOnClickListener(new OnClickListener() 
						{
							public void onClick(View a)
							{
								alertDialog1.cancel();				
							}
						});
						Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
						confirm.setText("Surrender!");
						confirm.setOnClickListener(new OnClickListener() 
						{
							public void onClick(View a)
							{
								
								alertDialog1.cancel();
							}
						});
						TextView t11 = (TextView)aview.findViewById(R.id.Seek1heading);
						t11.setText("Surrender");
						t11=(TextView)aview.findViewById(R.id.Seek1Line1);
						t11.setText("WantToSurrenderAlert");
						t11=(TextView)aview.findViewById(R.id.Seek1Line2);
						t11.setVisibility(View.GONE);
						t11 =(TextView)aview.findViewById(R.id.Seek1Line3);
						t11.setVisibility(View.GONE);
						t11 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
						t11.setVisibility(View.GONE);		//														delegate:self cancelButtonTitle:"Surrender" otherButtonTitles:"Cancel", nil];
						Globala.bLastMessage = false;
						//return true;
					}
					Globala.Arrested();
					
				}
			}

			else
			{
				Globala.raided = true;
				
				int TotalCargo = 0;
				int i;
				for (i=0; i<Globala.MAXTRADEITEM; ++i)
					TotalCargo += Globala.Ship.Cargo[i];
				if (TotalCargo <= 0)
				{
					int Blackmail = Globala.min( 25000, Globala.max( 500,  Globala.currentWorth() / 20 ) );
					FrmAlert("PiratesFindNoCargoAlert");
					if (Globala.credits >= Blackmail)
						Globala.credits -= Blackmail;
					else
					{
						
						Globala.debt += (Blackmail - Globala.credits);
						Globala.credits = 0;
					}
				}		
				else
				{	
					
					 FrmAlert("PiratesPlunderAlert");									
					
					int Bays = Globala.s[Globala.Opponent.Type].CargoBays;
					for (i=0; i<Globala.MAXGADGET; ++i)
						if (Globala.Opponent.Gadget[i] == Globala.EXTRABAYS)
							Bays += 5;
					for (i=0; i<Globala.MAXTRADEITEM; ++i)
						Bays -= Globala.Opponent.Cargo[i];
					
					// Pirates steal everything					
					if (Bays >= TotalCargo)
					{
						for (i=0; i<Globala.MAXTRADEITEM; ++i)
						{
							Globala.Ship.Cargo[i] = 0;
							Globala.BuyingPrice[i] = 0;
						}
					}		
					else
					{		
						// Pirates steal a lot
						while (Bays > 0)
						{
							i = Globala.GetRandom( Globala.MAXTRADEITEM );
							if (Globala.Ship.Cargo[i] > 0)
							{
								Globala.BuyingPrice[i] = (Globala.BuyingPrice[i] * (Globala.Ship.Cargo[i] - 1)) / Globala.Ship.Cargo[i];
								--Globala.Ship.Cargo[i];
								--Bays;
							}
						}
					}
				}
				if ((Globala.wildStatus == 1) && (Globala.s[Globala.Opponent.Type].CrewQuarters > 1))
				{
					// Wild hops onto Pirate Ship
					Globala.wildStatus = 0;
					FrmAlert("WildGoesWithPiratesAlert");
				}
				else if (Globala.wildStatus == 1)
				{
					// no room on pirate ship
					 FrmAlert("WildStaysAboardAlert");
				}
				if (Globala.reactorStatus > 0 && Globala.reactorStatus < 21)
				{
					// pirates puzzled by reactor
				FrmAlert("PiratesDontStealReactorAlert");
				}
			}
			
			Globala.Travel();
		  // b=Globala.surrender(); 
		   Log.v("LOG_TAG" ,"b1" + Globala.clicks );
	   }
	   
	   if(a=="Bribe")
	   {
		   Globala.autoAttack = false;
		   Globala.autoFlee = false;
			
			if (Globala.p[Globala.SolarSystem[Globala.warpSystem].Politics].BribeLevel <= 0)
			{
				FrmAlert("CantBeBribedAlert");
				//return true;
			}
			
			if (Globala.encounterType == Globala.POSTMARIEPOLICEENCOUNTER)
			{
				 FrmAlert("MarieCantBeBribedAlert");
				//return true;
			}
			
			if (Globala.encounterType == Globala.POLICEINSPECTION && Globala.Ship.Cargo[Globala.FIREARMS] <= 0 && Globala.Ship.Cargo[Globala.NARCOTICS] <= 0 && Globala.wildStatus != 1)
			{
				Globala.currentState = "eBribePropsal";			
				// take the cargo of the Marie Celeste?
			//	UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Bribe" message:
				//								  NSLocalizedString("SureToFleeOrBribeAlert", "") delegate:self cancelButtonTitle:"Cancel" otherButtonTitles:"Bribe", nil];
				
				LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
				final AlertDialog alertDialog1 = new AlertDialog.Builder(encounter.this).setView(aview).create();
			
				alertDialog1.show();
				Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
				cancel.setText("Cancel");
				cancel.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						alertDialog1.cancel();				
					}
				});
				Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
				confirm.setText("Bribe");
				confirm.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						
						alertDialog1.cancel();
					}
				});
				TextView t11 = (TextView)aview.findViewById(R.id.Seek1heading);
				t11.setText("Bribe");
				t11=(TextView)aview.findViewById(R.id.Seek1Line1);
				t11.setText("SureToFleeOrBribeAlert");
				t11=(TextView)aview.findViewById(R.id.Seek1Line2);
				t11.setVisibility(View.GONE);
				t11 =(TextView)aview.findViewById(R.id.Seek1Line3);
				t11.setVisibility(View.GONE);
				t11 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
				t11.setVisibility(View.GONE);		//														delegate:self cancelButtonTitle:"Surrender" otherButtonTitles:"Cancel", nil];
				Globala.bLastMessage = false;
				
				//return true;
				Globala.bribeContinue();
			}
		  // b=Globala.bribe(); 
		   Log.v("LOG_TAG" ,"b1" + Globala.clicks );
	   }
	   
	   if(a=="Submit")
	   {
		   Globala.autoAttack = false;
		   Globala.autoFlee = false;
			
			String str, str2;
			
			if (Globala.encounterType == Globala.POLICEINSPECTION && (Globala.Ship.Cargo[Globala.FIREARMS] > 0 ||  Globala.Ship.Cargo[Globala.NARCOTICS] > 0 || Globala.wildStatus == 1 || (Globala.reactorStatus > 1 && Globala.reactorStatus < 21)))
			{
				if (Globala.wildStatus == 1)
				{
					if (Globala.Ship.Cargo[Globala.FIREARMS] > 0 || Globala.Ship.Cargo[Globala.NARCOTICS] > 0)
					{
						str ="Jonathan Wild and illegal goods";
					}
					else
					{
						str = "Jonathan Wild";
					}
					str2 ="You will be arrested!";
				}
				else if (Globala.reactorStatus > 0 && Globala.reactorStatus < 21)
				{
					if (Globala.Ship.Cargo[Globala.FIREARMS] > 0 || Globala.Ship.Cargo[Globala.NARCOTICS] > 0)
					{
						str ="an illegal Ion Reactor and other illegal goods";
					}
					else
					{
						str ="an illegal Ion Reactor";
					}
					str2="You will be arrested!";
				}
				else
				{
					str="illegal goods";
				}
				// DUKE Says:  Since this is not being used maybe should take out all the stuff
				// setting it.  Don't know if there are plans for future use of the above stuff
				// so I just do a reassign to clear some warnings from clang.
				//str = str;
				//str2 = str2;
				Globala.currentState = "eSubmit";			
				// take the cargo of the Marie Celeste?
				//UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Encounter" message:
				//								  NSLocalizedString("SureToSubmitAlert", "") delegate:self cancelButtonTitle:"No" otherButtonTitles:"Submit",nil];
				
				LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
				final AlertDialog alertDialog1 = new AlertDialog.Builder(encounter.this).setView(aview).create();
			
				alertDialog1.show();
				Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
				cancel.setText("No");
				cancel.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						alertDialog1.cancel();				
					}
				});
				Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
				confirm.setText("Submit");
				confirm.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						
						alertDialog1.cancel();
					}
				});
				TextView t11 = (TextView)aview.findViewById(R.id.Seek1heading);
				t11.setText("Encounter");
				t11=(TextView)aview.findViewById(R.id.Seek1Line1);
				t11.setText("SureToSubmitAlert");
				t11=(TextView)aview.findViewById(R.id.Seek1Line2);
				t11.setVisibility(View.GONE);
				t11 =(TextView)aview.findViewById(R.id.Seek1Line3);
				t11.setVisibility(View.GONE);
				t11 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
				t11.setVisibility(View.GONE);		//														delegate:self cancelButtonTitle:"Surrender" otherButtonTitles:"Cancel", nil];
				Globala.bLastMessage = false;
				
				//return true;	
					
				//		if (FrmCustomAlert( SureToSubmitAlert, SBuf, SBuf2, NULL ) == SureToSubmitNo)
				
				
			}
			Globala.submitContinue();	
		  // b=   Globala.submit(); 
		   Log.v("LOG_TAG" ,"b1" + Globala.clicks );
	   }
	   
	   if(a=="Plunder")
	   {
		   b=  Globala.plunder(); 
	   }
	   
	   if(a=="Interupt")
	   {
		   b=Globala.interrupt(); 
	   }
	   
	   if(a=="Meet")
	   {
		 //"Meet Captain Ahab", "Captain Ahab is in need of a spare shield for an upcoming mission. He offsers to trade you some piloting lessons for ypur reflective shild. Do you wish to trade?", "YEs, Trdae shield", "No"
			
			if (Globala.encounterType == Globala.CAPTAINAHABENCOUNTER)
			{
				
				Globala.currentState =" eEngageCaptainAhabAlert";
				FrmAlert("EngageCaptainAhabAlert");
				
				// Trade a reflective shield for skill points in piloting?
			}
			else if (Globala.encounterType == Globala.CAPTAINCONRADENCOUNTER)
			{
				
				Globala.currentState = "eEngageCaptainConradAlert";
				FrmAlert("EngageCaptainConradAlert");
			
			}
			else if (Globala.encounterType == Globala.CAPTAINHUIEENCOUNTER)
			{
				Globala.currentState =" eEngageCaptainHuieAlert";
				FrmAlert("EngageCaptainHuieAlert");
				// Trade a military laser for skill points in trading?
			}
			
			
			Globala.Travel();
			//[encounterViewControllerInstance showEncounterWindow];
		  // b=   Globala.meet(); 
	   }
	   if(a=="Board")
	   {
		   if (Globala.encounterType == Globala.MARIECELESTEENCOUNTER)
			{
			   Globala.currentState = "eBoard";			
				// take the cargo of the Marie Celeste?
			   
			   LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
				final AlertDialog alertDialog1 = new AlertDialog.Builder(encounter.this).setView(aview).create();
			
				alertDialog1.show();
				Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
				cancel.setText("No");
				cancel.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						alertDialog1.cancel();				
					}
				});
				Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
				confirm.setText("Take Cargo");
				confirm.setOnClickListener(new OnClickListener() 
				{
					public void onClick(View a)
					{
						
						alertDialog1.cancel();
					}
				});
				TextView t11 = (TextView)aview.findViewById(R.id.Seek1heading);
				t11.setText("Encounter");
				t11=(TextView)aview.findViewById(R.id.Seek1Line1);
				t11.setText("EngageMarieAlert");
				t11=(TextView)aview.findViewById(R.id.Seek1Line2);
				t11.setVisibility(View.GONE);
				t11 =(TextView)aview.findViewById(R.id.Seek1Line3);
				t11.setVisibility(View.GONE);
				t11 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
				t11.setVisibility(View.GONE);
				//UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Encounter"  message:
				//								  NSLocalizedString("EngageMarieAlert", "") delegate:self cancelButtonTitle:"Cancel" otherButtonTitles:"Take Cargo",nil];
						
			   Globala.bLastMessage = false;
		    
				
			}
			else {
				Globala.Travel();
			}
		  // b=   Globala.board(); 
	   }
	   if(a=="Drink")
	   {
		   if (Globala.encounterType == Globala.BOTTLEGOODENCOUNTER)
			{
				// Quaff the good bottle of Skill Tonic?
				//[self playSound:eBottleEncounter];
			   Globala.currentState = "eBottleGood";		
			}
			else if (Globala.encounterType == Globala.BOTTLEOLDENCOUNTER)
			{
				// Quaff the out of date bottle of Skill Tonic?
			//	[self playSound:eBottleEncounter];		
				Globala.currentState = "eBottleStrange";		
				
			} 
			else {
				Globala.Travel();
				
				
				//return false;			
			}
			
			//UIAlertView * myAlertView = [[UIAlertView alloc] initWithTitle:"Encounter" message:NSLocalizedString("EngageBottleAlert", "") 
			//													  delegate:self cancelButtonTitle:"Yes" otherButtonTitles:"No", nil];
		   LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			final ViewGroup aview = (ViewGroup) inflater.inflate(R.layout.seek1, null);
			final AlertDialog alertDialog1 = new AlertDialog.Builder(encounter.this).setView(aview).create();
		
			alertDialog1.show();
			Button cancel = (Button)aview.findViewById(R.id.Seek1alertno);
			cancel.setText("No");
			cancel.setOnClickListener(new OnClickListener() 
			{
				public void onClick(View a)
				{
					alertDialog1.cancel();				
				}
			});
			Button confirm = (Button)aview.findViewById(R.id.Seek1alertyes);
			confirm.setText("Yes");
			confirm.setOnClickListener(new OnClickListener() 
			{
				public void onClick(View a)
				{
					
					alertDialog1.cancel();
				}
			});
			TextView t11 = (TextView)aview.findViewById(R.id.Seek1heading);
			t11.setText("Encounter");
			t11=(TextView)aview.findViewById(R.id.Seek1Line1);
			t11.setText("EngageBottleAlert");
			t11=(TextView)aview.findViewById(R.id.Seek1Line2);
			t11.setVisibility(View.GONE);
			t11 =(TextView)aview.findViewById(R.id.Seek1Line3);
			t11.setVisibility(View.GONE);
			t11 =(TextView)aview.findViewById(R.id.Seek1Alertvalue);
			t11.setVisibility(View.GONE);
					
		   Globala.bLastMessage = false;
		   //b=  Globala.drink(); 
	   }
	  return false;
   }
private void FrmAlert(String string) {
	// TODO Auto-generated method stub
	
	AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
	alt_bld.setMessage(string)
	.setCancelable(false)
	.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() 
	{
		public void onClick(DialogInterface dialog, int id) 
		{
			// Action for 'Yes' Button
			dialog.cancel();
		}
	});
	AlertDialog alert = alt_bld.create();
	alert.setTitle("Alert");
	alert.show();
	
}
  
public void drawimages(String a1,String a2){
	
	
	if(a1=="nanomite"){
	ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
    img1.setBackgroundResource(R.drawable.nanomite);
	}
	if(a1=="minox"){
		ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
	    img1.setBackgroundResource(R.drawable.minox);
		}
	if(a1=="spathiScout"){
		ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
	    img1.setBackgroundResource(R.drawable.spathiscout);
		}
		if(a1=="t16Womprat"){
			ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
		    img1.setBackgroundResource(R.drawable.t16womprat);
			}
		if(a1=="vorchan"){
			ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
		    img1.setBackgroundResource(R.drawable.vorchan);
			}
			if(a1=="hirogenfreighter"){
				ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
			    img1.setBackgroundResource(R.drawable.hirogenfreighter);
				}
			if(a1=="vorlonCruiser"){
				ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
			    img1.setBackgroundResource(R.drawable.vorloncruiser);
				}
				if(a1=="yt1300"){
					ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
				    img1.setBackgroundResource(R.drawable.yt1300);
					}
				if(a1=="tkharuberhauler"){
					ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
				    img1.setBackgroundResource(R.drawable.tkharuberhauler);
					}
					if(a1=="vixdreadnaught"){
						ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
					    img1.setBackgroundResource(R.drawable.vixdreadnaught);
						}
					if(a1=="leviathon"){
						ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
					    img1.setBackgroundResource(R.drawable.leviathon);
						}
						if(a1=="korahMenace"){
							ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
						    img1.setBackgroundResource(R.drawable.korahmenace);
							}
						if(a1=="mantis"){
							ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
						    img1.setBackgroundResource(R.drawable.mantis);
							}
							if(a1=="scarab"){
								ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
							    img1.setBackgroundResource(R.drawable.scarab);
								}
							if(a1=="bottle"){
								ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
							    img1.setBackgroundResource(R.drawable.bottle);
								}
							if(a1=="nanomitebg"){
								ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
							    img1.setBackgroundResource(R.drawable.nanomitebg);
								}
								if(a1=="minoxbg"){
									ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
								    img1.setBackgroundResource(R.drawable.minoxbg);
									}
								if(a1=="spathiScoutbg"){
									ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
								    img1.setBackgroundResource(R.drawable.spathiscoutbg);
									}
									if(a1=="t16Wompratbg"){
										ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
									    img1.setBackgroundResource(R.drawable.t16wompratbg);
										}
									if(a1=="vorchanbg"){
										ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
									    img1.setBackgroundResource(R.drawable.vorchanbg);
										}
										if(a1=="hirogenfreighterbg"){
											ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
										    img1.setBackgroundResource(R.drawable.hirogenfreighterbg);
											}
										if(a1=="vorlonCruiserbg"){
											ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
										    img1.setBackgroundResource(R.drawable.vorloncruiserbg);
											}
											if(a1=="yt1300bg"){
												ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
											    img1.setBackgroundResource(R.drawable.yt1300bg);
												}
											if(a1=="tkharuberhaulerbg"){
												ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
											    img1.setBackgroundResource(R.drawable.tkharuberhaulerbg);
												}
												if(a1=="vixdreadnaughtbg"){
													ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
												    img1.setBackgroundResource(R.drawable.vixdreadnaughtbg);
													}
												if(a1=="leviathonbg"){
													ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
												    img1.setBackgroundResource(R.drawable.leviathon);
													}
													if(a1=="korahMenacebg"){
														ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
													    img1.setBackgroundResource(R.drawable.korahmenacebg);
														}
													if(a1=="mantisbg"){
														ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
													    img1.setBackgroundResource(R.drawable.mantisbg);
														}
														if(a1=="scarabbg"){
															ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
														    img1.setBackgroundResource(R.drawable.scarabbg);
															}
														if(a1=="bottle"){
															ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
														    img1.setBackgroundResource(R.drawable.bottle);
															}	
														if(a1=="nanomiteD"){
															ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
														    img1.setBackgroundResource(R.drawable.nanomited);
															}
															if(a1=="minoxD"){
																ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
															    img1.setBackgroundResource(R.drawable.minoxd);
																}
															if(a1=="spathiScoutD"){
																ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
															    img1.setBackgroundResource(R.drawable.spathiscoutd);
																}
																if(a1=="t16WompratD"){
																	ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																    img1.setBackgroundResource(R.drawable.t16wompratd);
																	}
																if(a1=="vorchanD"){
																	ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																    img1.setBackgroundResource(R.drawable.vorchand);
																	}
																	if(a1=="hirogenfreighterD"){
																		ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																	    img1.setBackgroundResource(R.drawable.hirogenfreighterd);
																		}
																	if(a1=="vorlonCruiserD"){
																		ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																	    img1.setBackgroundResource(R.drawable.vorloncruiserd);
																		}
																		if(a1=="yt1300D"){
																			ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																		    img1.setBackgroundResource(R.drawable.yt1300d);
																			}
																		if(a1=="tkharuberhaulerD"){
																			ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																		    img1.setBackgroundResource(R.drawable.tkharuberhauler);
																			}
																			if(a1=="vixdreadnaughtD"){
																				ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																			    img1.setBackgroundResource(R.drawable.vixdreadnaughtd);
																				}
																			if(a1=="leviathonD"){
																				ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																			    img1.setBackgroundResource(R.drawable.leviathon);
																				}
																				if(a1=="korahMenaceD"){
																					ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																				    img1.setBackgroundResource(R.drawable.korahmenaced);
																					}
																				if(a1=="mantisD"){
																					ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																				    img1.setBackgroundResource(R.drawable.mantisd);
																					}
																					if(a1=="scarabD"){
																						ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																					    img1.setBackgroundResource(R.drawable.scarabd);
																						}
																					if(a1=="bottle"){
																						ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																					    img1.setBackgroundResource(R.drawable.bottle);
																						}
																					if(a1=="nanomiteS"){
																						ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																					    img1.setBackgroundResource(R.drawable.nanomites);
																						}
																						if(a1=="minoxS"){
																							ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																						    img1.setBackgroundResource(R.drawable.nanomites);
																							}
																						if(a1=="spathiScoutS"){
																							ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																						    img1.setBackgroundResource(R.drawable.spathiscouts);
																							}
																							if(a1=="t16WompratS"){
																								ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																							    img1.setBackgroundResource(R.drawable.t16womprats);
																								}
																							if(a1=="vorchanS"){
																								ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																							    img1.setBackgroundResource(R.drawable.vorchans);
																								}
																								if(a1=="hirogenfreighterS"){
																									ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																								    img1.setBackgroundResource(R.drawable.hirogenfreighters);
																									}
																								if(a1=="vorlonCruiserS"){
																									ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																								    img1.setBackgroundResource(R.drawable.vorloncruisers);
																									}
																									if(a1=="yt1300S"){
																										ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																									    img1.setBackgroundResource(R.drawable.yt1300s);
																										}
																									if(a1=="tkharuberhaulerS"){
																										ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																									    img1.setBackgroundResource(R.drawable.tkaruberhaulers);
																										}
																										if(a1=="vixdreadnaughtS"){
																											ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																										    img1.setBackgroundResource(R.drawable.vixdreadnaughts);
																											}
																										if(a1=="leviathonS"){
																											ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																										    img1.setBackgroundResource(R.drawable.leviathon);
																											}
																											if(a1=="korahMenaceS"){
																												ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																											    img1.setBackgroundResource(R.drawable.korahmenaces);
																												}
																											if(a1=="mantisS"){
																												ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																											    img1.setBackgroundResource(R.drawable.mantiss);
																												}
																												if(a1=="scarabS"){
																													ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																												    img1.setBackgroundResource(R.drawable.scarabs);
																													}
																												if(a1=="bottle"){
																													ImageView img1=(ImageView) this.findViewById(R.id.encounterImageView01);
																												    img1.setBackgroundResource(R.drawable.bottle);
																													}
																												if(a2=="nanomite"){
																													ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																												    img2.setBackgroundResource(R.drawable.nanomite);
																													}
																													if(a2=="minox"){
																														ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																													    img2.setBackgroundResource(R.drawable.minox);
																														}
																													if(a2=="spathiScout"){
																														ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																													    img2.setBackgroundResource(R.drawable.spathiscout);
																														}
																														if(a2=="t16Womprat"){
																															ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																														    img2.setBackgroundResource(R.drawable.t16womprat);
																															}
																														if(a2=="vorchan"){
																															ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																														    img2.setBackgroundResource(R.drawable.vorchan);
																															}
																															if(a2=="hirogenfreighter"){
																																ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																															    img2.setBackgroundResource(R.drawable.hirogenfreighter);
																																}
																															if(a2=="vorlonCruiser"){
																																ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																															    img2.setBackgroundResource(R.drawable.vorloncruiser);
																																}
																																if(a2=="yt1300"){
																																	ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																    img2.setBackgroundResource(R.drawable.yt1300);
																																	}
																																if(a2=="tkharuberhauler"){
																																	ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																    img2.setBackgroundResource(R.drawable.tkharuberhauler);
																																	}
																																	if(a2=="vixdreadnaught"){
																																		ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																	    img2.setBackgroundResource(R.drawable.vixdreadnaught);
																																		}
																																	if(a2=="leviathon"){
																																		ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																	    img2.setBackgroundResource(R.drawable.leviathon);
																																		}
																																		if(a2=="korahMenace"){
																																			ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																		    img2.setBackgroundResource(R.drawable.korahmenace);
																																			}
																																		if(a2=="mantis"){
																																			ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																		    img2.setBackgroundResource(R.drawable.mantis);
																																			}
																																			if(a2=="scarab"){
																																				ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																			    img2.setBackgroundResource(R.drawable.scarab);
																																				}
																																			if(a2=="bottle"){
																																				ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																			    img2.setBackgroundResource(R.drawable.bottle);
																																				}
																																			if(a2=="nanomitebg"){
																																				ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																			    img2.setBackgroundResource(R.drawable.nanomitebg);
																																				}
																																				if(a2=="minoxbg"){
																																					ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																				    img2.setBackgroundResource(R.drawable.minoxbg);
																																					}
																																				if(a2=="spathiScoutbg"){
																																					ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																				    img2.setBackgroundResource(R.drawable.spathiscoutbg);
																																					}
																																					if(a2=="t16Wompratbg"){
																																						ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																					    img2.setBackgroundResource(R.drawable.t16wompratbg);
																																						}
																																					if(a2=="vorchanbg"){
																																						ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																					    img2.setBackgroundResource(R.drawable.vorchanbg);
																																						}
																																						if(a2=="hirogenfreighterbg"){
																																							ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																						    img2.setBackgroundResource(R.drawable.hirogenfreighterbg);
																																							}
																																						if(a2=="vorlonCruiserbg"){
																																							ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																						    img2.setBackgroundResource(R.drawable.vorloncruiserbg);
																																							}
																																							if(a2=="yt1300bg"){
																																								ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																							    img2.setBackgroundResource(R.drawable.yt1300bg);
																																								}
																																							if(a2=="tkharuberhaulerbg"){
																																								ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																							    img2.setBackgroundResource(R.drawable.tkharuberhaulerbg);
																																								}
																																								if(a2=="vixdreadnaughtbg"){
																																									ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																								    img2.setBackgroundResource(R.drawable.vixdreadnaughtbg);
																																									}
																																								if(a2=="leviathonbg"){
																																									ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																								    img2.setBackgroundResource(R.drawable.leviathon);
																																									}
																																									if(a2=="korahMenacebg"){
																																										ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																									    img2.setBackgroundResource(R.drawable.korahmenacebg);
																																										}
																																									if(a2=="mantisbg"){
																																										ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																									    img2.setBackgroundResource(R.drawable.mantisbg);
																																										}
																																										if(a2=="scarabbg"){
																																											ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																										    img2.setBackgroundResource(R.drawable.scarabbg);
																																											}
																																										if(a2=="bottle"){
																																											ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																										    img2.setBackgroundResource(R.drawable.bottle);
																																											}	
																																										if(a2=="nanomiteD"){
																																											ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																										    img2.setBackgroundResource(R.drawable.nanomited);
																																											}
																																											if(a2=="minoxD"){
																																												ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																											    img2.setBackgroundResource(R.drawable.minoxd);
																																												}
																																											if(a2=="spathiScoutD"){
																																												ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																											    img2.setBackgroundResource(R.drawable.spathiscoutd);
																																												}
																																												if(a2=="t16WompratD"){
																																													ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																												    img2.setBackgroundResource(R.drawable.t16wompratd);
																																													}
																																												if(a2=="vorchanD"){
																																													ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																												    img2.setBackgroundResource(R.drawable.vorchand);
																																													}
																																													if(a2=="hirogenfreighterD"){
																																														ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																													    img2.setBackgroundResource(R.drawable.hirogenfreighterd);
																																														}
																																													if(a2=="vorlonCruiserD"){
																																														ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																													    img2.setBackgroundResource(R.drawable.vorloncruiserd);
																																														}
																																														if(a2=="yt1300D"){
																																															ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																														    img2.setBackgroundResource(R.drawable.yt1300d);
																																															}
																																														if(a2=="tkharuberhaulerD"){
																																															ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																														    img2.setBackgroundResource(R.drawable.tkharuberhauler);
																																															}
																																															if(a2=="vixdreadnaughtD"){
																																																ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																															    img2.setBackgroundResource(R.drawable.vixdreadnaughtd);
																																																}
																																															if(a2=="leviathonD"){
																																																ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																															    img2.setBackgroundResource(R.drawable.leviathon);
																																																}
																																																if(a2=="korahMenaceD"){
																																																	ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																    img2.setBackgroundResource(R.drawable.korahmenaced);
																																																	}
																																																if(a2=="mantisD"){
																																																	ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																    img2.setBackgroundResource(R.drawable.mantisd);
																																																	}
																																																	if(a2=="scarabD"){
																																																		ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																	    img2.setBackgroundResource(R.drawable.scarabd);
																																																		}
																																																	if(a2=="bottle"){
																																																		ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																	    img2.setBackgroundResource(R.drawable.bottle);
																																																		}
																																																	if(a2=="nanomiteS"){
																																																		ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																	    img2.setBackgroundResource(R.drawable.nanomites);
																																																		}
																																																		if(a2=="minoxS"){
																																																			ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																		    img2.setBackgroundResource(R.drawable.nanomites);
																																																			}
																																																		if(a2=="spathiScoutS"){
																																																			ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																		    img2.setBackgroundResource(R.drawable.spathiscouts);
																																																			}
																																																			if(a2=="t16WompratS"){
																																																				ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																			    img2.setBackgroundResource(R.drawable.t16womprats);
																																																				}
																																																			if(a2=="vorchanS"){
																																																				ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																			    img2.setBackgroundResource(R.drawable.vorchans);
																																																				}
																																																				if(a2=="hirogenfreighterS"){
																																																					ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																				    img2.setBackgroundResource(R.drawable.hirogenfreighters);
																																																					}
																																																				if(a2=="vorlonCruiserS"){
																																																					ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																				    img2.setBackgroundResource(R.drawable.vorloncruisers);
																																																					}
																																																					if(a2=="yt1300S"){
																																																						ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																					    img2.setBackgroundResource(R.drawable.yt1300s);
																																																						}
																																																					if(a2=="tkharuberhaulerS"){
																																																						ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																					    img2.setBackgroundResource(R.drawable.tkaruberhaulers);
																																																						}
																																																						if(a2=="vixdreadnaughtS"){
																																																							ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																						    img2.setBackgroundResource(R.drawable.vixdreadnaughts);
																																																							}
																																																						if(a2=="leviathonS"){
																																																							ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																						    img2.setBackgroundResource(R.drawable.leviathon);
																																																							}
																																																							if(a2=="korahMenaceS"){
																																																								ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																							    img2.setBackgroundResource(R.drawable.korahmenaces);
																																																								}
																																																							if(a2=="mantisS"){
																																																								ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																							    img2.setBackgroundResource(R.drawable.mantiss);
																																																								}
																																																								if(a2=="scarabS"){
																																																									ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																								    img2.setBackgroundResource(R.drawable.scarabs);
																																																									}
																																																								if(a2=="bottle"){
																																																									ImageView img2=(ImageView) this.findViewById(R.id.encounterImageView02);
																																																								    img2.setBackgroundResource(R.drawable.bottle);
																																																									}
}




}