package com.example;

import java.math.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class encounter extends Activity {
    private TextView t1;
	private TextView t2;
	private TextView t3;
	private TextView t4;
	private Button bsurrender,b1,b2,b3,b4;
	private Button bflee;
	private Button bignore;
	private Button battack;
	private int flee;
	private int ignore=0,trade=0;
	Globala gbuy=new Globala();
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.encounter);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titleencounter);
      
	}
  /*public void drawShip(boolean player)
        {
           int  hull, shield, maxShield, hullMax;	
        	if (player) {
        		hull =gbuy.getShipHull();
        		shield = gbuy.getShipShield() ;
        		maxShield =gbuy.getShipShieldMax() ;
        		hullMax = gbuy.getShipHullMax();
        	}
        	else {
        		hull = gbuy.getShipOpponentHull();
        		shield =  gbuy.getShipOpponentShield();		
        		maxShield =  gbuy.getShipShieldMax() 	;
        		hullMax =  gbuy.getShipOpponentHullMax();
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
        		//	tmp = gbuy.getShipImageName(gbuy.getCurrentShipType));
        		//	tmp = gbuy.getShipShieldImageName(gbuy.getCurrentShipType));
        			
        		}
        		else
        		{
        		//	tmp = gbuy.getShipImageName(gbuy.getShipOpponentType);
        		//	fullDamage = [UIImage imageNamed:tmp];
        		//	[tmp release];
        		//	tmp = gbuy.getShipShieldImageName(gbuy.getShipOpponentType());
        			//fullHull = [UIImage imageNamed:tmp];
        			//[tmp release];
        		}
        		
        	}
        	else
        	{
        		aspect = currentHullAspect;
        		if (player)
        		{
        			//tmp = [app.gamePlayer getShipImageName:[app.gamePlayer getCurrentShipType]];
        		//	fullHull = [UIImage imageNamed:tmp];
        		//	[tmp release];			
        		//	tmp = [app.gamePlayer getShipDamagedImageName:[app.gamePlayer getCurrentShipType]];
        		//	fullDamage = [UIImage imageNamed:tmp];
        		//	[tmp release];			
        		}
        		else
        		{
        		//	tmp = [app.gamePlayer getShipImageName:[app.gamePlayer getShipOpponentType]];
        		//	fullHull = [UIImage imageNamed:tmp];
        		//	[tmp release];			
        		//	tmp = [app.gamePlayer getShipDamagedImageName:[app.gamePlayer getShipOpponentType]];
        		//	fullDamage = [UIImage imageNamed:tmp];
        		//	[tmp release];	
        		}
        		
        	}
        	

        	if (aspect > 1.0f)
        		aspect = 1.0f;

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
        	

        	
        	return destImage;
        }*/
  public void updtButtons()
  {
	 boolean attackIconStatus = false  ;
	 if (gbuy.autoAttack || gbuy.autoFlee) {
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
		
		int encounterType = gbuy.encounterType;
		if (encounterType == gbuy.POLICEINSPECTION)
		{
		    b1=(Button)this.findViewById(R.id.encounterbutton4);			
			b1.setText("Attack");
			b2=(Button)this.findViewById(R.id.encounterbutton3);			
			b2.setText("Flee");
			
		    
			b3=(Button)this.findViewById(R.id.encounterbutton2);	
			b3.setText("Submit");
			
			b4=(Button)this.findViewById(R.id.encounterbutton1);		
			b4.setText("Submit");
			
		} else if (encounterType == gbuy.POSTMARIEPOLICEENCOUNTER) 
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
			}else if (encounterType == gbuy.POLICEFLEE || encounterType == gbuy.TRADERFLEE || encounterType == gbuy.PIRATEFLEE ) {
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
				}else if (encounterType == gbuy.POLICEATTACK || encounterType ==gbuy.PIRATEATTACK || encounterType == gbuy.SCARABATTACK ) {
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
					}else if (encounterType ==gbuy.FAMOUSCAPATTACK ) {
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
						}else if (encounterType == gbuy.TRADERATTACK || encounterType == gbuy.SPACEMONSTERATTACK || encounterType == gbuy.DRAGONFLYATTACK ) {
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
							else if (encounterType == gbuy.TRADERIGNORE || encounterType == gbuy.POLICEIGNORE || encounterType == gbuy.PIRATEIGNORE  ||
									encounterType == gbuy.SPACEMONSTERIGNORE || encounterType == gbuy.DRAGONFLYIGNORE || encounterType == gbuy.SCARABIGNORE)
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
								else if(encounterType == gbuy.TRADERSURRENDER || encounterType == gbuy.PIRATESURRENDER ) {
									
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
								else if (encounterType == gbuy.MARIECELESTEENCOUNTER ) {
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
									else if (gbuy.ENCOUNTERFAMOUS(encounterType)) {
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
										else if (encounterType == gbuy.BOTTLEGOODENCOUNTER || encounterType == gbuy.BOTTLEOLDENCOUNTER) {
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
										else if (encounterType == gbuy.TRADERSELL || encounterType == gbuy.TRADERBUY) {
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
		if (gbuy.textualEncounters) {
			
		//	[message1Labe2 removeFromSuperview];
		//	[message1Label removeFromSuperview]; 
		}
	
	}
	
 public void encounterDisplayNextAction(boolean  FirstDisplay)
  {
   	int encounterType = gbuy.encounterType;
  	
  	if (gbuy.encounterType == gbuy.POLICEINSPECTION)
  	{
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("The police summon you to submit to an inspection");
  		//message1Labe2.text = @"The police summon you to submit to an inspection";
  	}
  	else if (gbuy.encounterType == gbuy.POSTMARIEPOLICEENCOUNTER)
  	{
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("We know you removed illegal goods from the Marie Celeste.");
  		t4=(TextView)this.findViewById(R.id.line4);
  		t4.setText(" You must give them up at once!");
  		//message1Labe2.text = @"We know you removed illegal goods from the Marie Celeste. You must give them up at once!";
  	}
  	else if (FirstDisplay && gbuy.encounterType == gbuy.POLICEATTACK &&  gbuy.policeRecordScore > gbuy.CRIMINALSCORE)
  	{
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("The police hail they want you to surrender.");
  		//message1Labe2.text = @"The police hail they want you to surrender.";
  	}
  	else if (encounterType == gbuy.POLICEFLEE || encounterType == gbuy.TRADERFLEE ||
  			encounterType == gbuy.PIRATEFLEE)
  	{
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("Your opponent is fleeing");
  		//message1Labe2.text = @"Your opponent is fleeing.";
  	}
  		else if (encounterType == gbuy.PIRATEATTACK || encounterType == gbuy.POLICEATTACK ||
  				encounterType == gbuy.TRADERATTACK || encounterType == gbuy.SPACEMONSTERATTACK ||
  				encounterType == gbuy.DRAGONFLYATTACK || encounterType == gbuy.SCARABATTACK ||
  				encounterType == gbuy.FAMOUSCAPATTACK)
  		{
  			t3=(TextView)this.findViewById(R.id.line3);
  	  		t3.setText("Your opponent attacks.");
  		//message1Labe2.text = @ "Your opponent attacks.";
  		}
  	else if (encounterType == gbuy.TRADERIGNORE || encounterType == gbuy.POLICEIGNORE ||
  			encounterType == gbuy.SPACEMONSTERIGNORE || encounterType == gbuy.DRAGONFLYIGNORE || 
  			encounterType == gbuy.PIRATEIGNORE || encounterType == gbuy.SCARABIGNORE)
  	{
  		if (gbuy.isShipCloaked())
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
  	else if (gbuy.encounterType == gbuy.TRADERSELL || gbuy.encounterType == gbuy.TRADERBUY)
  	{
  	//	[self.view addSubview:encounterTypeImage];
  	//	encounterTypeImage.image = [UIImage imageNamed:@"trader.png"];
  		t3=(TextView)this.findViewById(R.id.line3);
	  		t3.setText("You are hailed with an offer to trade goods.");
  		//message1Labe2.text = "You are hailed with an offer to trade goods.";
  	}
  	else if (gbuy.encounterType == gbuy.TRADERSURRENDER || gbuy.encounterType == gbuy.PIRATESURRENDER)
  	{ 
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("Your opponent hails that he surrenders to you.");
  		
  		//[self.view addSubview:encounterTypeImage];
  	//	encounterTypeImage.image = [UIImage imageNamed:@"trader.png"];		
  	//	message1Labe2.text = @"Your opponent hails that he surrenders to you.";
  	}
  	else if (encounterType == gbuy.MARIECELESTEENCOUNTER)
  	{
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("The Marie Celeste appears to be completely abandoned.");
  	//	message1Labe2.text = @ "The Marie Celeste appears to be completely abandoned.";
  	}
  	else if (gbuy.ENCOUNTERFAMOUS(encounterType) && gbuy.encounterType != gbuy.FAMOUSCAPATTACK)
  	{
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("The Captain requests a brief meeting with you.");
  		//message1Labe2.text = @"The Captain requests a brief meeting with you.";
  	}
  	else if (encounterType == gbuy.BOTTLEOLDENCOUNTER || encounterType == gbuy.BOTTLEGOODENCOUNTER)
  	{
  		t3=(TextView)this.findViewById(R.id.line3);
  		t3.setText("It appears to be a rare bottle of Captain Marmoset's Skill Tonic!");
  		//message1Labe2.text = @"It appears to be a rare bottle of Captain Marmoset's Skill Tonic!";
    }
  	
  }
  
public void  showEncounterWindow()
{
		 updtButtons();
		 encounterDisplayNextAction(true);
		int EncounterType = gbuy.encounterType;
		
		if (EncounterType == gbuy.POSTMARIEPOLICEENCOUNTER) 
		{
			t1=(TextView)this.findViewById(R.id.line1);
	  		t1.setText("You encounter the Customs Police.");
			//message1Label.text = @"You encounter the Customs Police.";
		} 
		else 
		{
			String shipName = gbuy.getShipName(gbuy.getShipOpponentType());
			if (gbuy.ENCOUNTERPOLICE( EncounterType )) {
				t1=(TextView)this.findViewById(R.id.line1);
		  		t1.setText("a police");
				
			//	[self.view addSubview:encounterTypeImage];
				//encounterTypeImage.image = [UIImage imageNamed:@"Police.png"];		
			//	shipType =@"a police";
			} else if (gbuy.ENCOUNTERPIRATE( EncounterType ))
			{
				
				//[self.view addSubview:encounterTypeImage];
				//encounterTypeImage.image = [UIImage imageNamed:@"Pirate.png"];			
				if (gbuy.getShipOpponentType() == gbuy.MANTISTYPE)
				{
					//shipType =@"an alien";
				}
				else{
					//shipType =@"a pirate";
				}
			} 
			else if (gbuy.ENCOUNTERTRADER( EncounterType ))
			{
				//[self.view addSubview:encounterTypeImage];
				//encounterTypeImage.image = [UIImage imageNamed:@"trader.png"];		
			//	shipType =@"a trader";
			} else if (gbuy.ENCOUNTERMONSTER( EncounterType ))
			{
				//shipType =@" ";
			}
			else if (EncounterType ==gbuy.MARIECELESTEENCOUNTER)
			{
				//shipType =@"a drifting ship";
			}
			else if (EncounterType == gbuy.CAPTAINAHABENCOUNTER)
			{
			//	shipType =@"the famous Captain Ahab";
			}
			else if (EncounterType == gbuy.CAPTAINCONRADENCOUNTER)
				{
			//	shipType =@"Captain Conrad";
				}
			else if (EncounterType == gbuy.CAPTAINHUIEENCOUNTER)
				{
			//	shipType =@"Captain Huie";
				}
			else if (EncounterType == gbuy.BOTTLEOLDENCOUNTER || EncounterType == gbuy.BOTTLEGOODENCOUNTER)
				{
			//	shipType =@"a floating bottle.";
				}
			else
				{
			//	shipType =@"a stolen";
				}
			
			t1=(TextView)this.findViewById(R.id.line1);
	  		t1.setText("At"+ gbuy.clicks +  "clicks from "+  gbuy.getSolarSystemName(gbuy.warpSystem) + "you encounter" + gbuy.s[gbuy.warpSystem].Name);
			// message1Label.text = [NSString  stringWithFormat:@"At %i clicks from %@ you encounter %@ %@.", pPlayer.clicks, [pPlayer getSolarSystemName:pPlayer.warpSystem], shipType, shipName]; 
			
		
		}			

	}

   public void onbuttonpress()
   {
	   String a;
	   b1=(Button)this.findViewById(R.id.encounterbutton1);
	   a=(String) b1.getText();
	   if(a=="Attack")
	   {
		   gbuy.attack(); 
	   }
	   if(a=="Flee")
	   {
		   gbuy.flee(); 
	   }
	   if(a=="Ignore")
	   {
		   gbuy.ignore(); 
	   }
	   if(a=="Trade")
	   {
		   gbuy.trade(); 
	   }
	   if(a=="Yeild")
	   {
		   gbuy.yield(); 
	   }
	   if(a=="Surrender")
	   {
		   gbuy.surrender(); 
	   }
	   if(a=="Bribe")
	   {
		   gbuy.bribe(); 
	   }
	   if(a=="Submit")
	   {
		   gbuy.submit(); 
	   }
	   if(a=="Plunder")
	   {
		   gbuy.plunder(); 
	   }
	   if(a=="Interupt")
	   {
		   gbuy.interrupt(); 
	   }
	   if(a=="Meet")
	   {
		   gbuy.meet(); 
	   }
	   if(a=="Board")
	   {
		   gbuy.board(); 
	   }
	   if(a=="Drink")
	   {
		   gbuy.drink(); 
	   }
   }
  




}