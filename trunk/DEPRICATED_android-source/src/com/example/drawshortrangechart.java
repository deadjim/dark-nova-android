package com.example;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class drawshortrangechart extends View{
	Globala gbuy=new Globala();    
     private Bitmap sourceImage;
     public int index=0;
     private Paint tmpPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
     private Paint pOuterBullsEye = new Paint(Paint.ANTI_ALIAS_FLAG);
     private Paint pg = new Paint(Paint.ANTI_ALIAS_FLAG);
     
     
     
     public drawshortrangechart(Context context) 
     {
             super(context);
           
             pOuterBullsEye.setStyle(Paint.Style.STROKE);
             pOuterBullsEye.setColor(Color.GREEN);
             
             pg.setStyle(Paint.Style.STROKE);
             pg.setColor(Color.WHITE);
             
             tmpPaint.setStyle(Paint.Style.STROKE);
             tmpPaint.setTextAlign(Paint.Align.CENTER);
            
            

             
             
             
             
     }
     
     @Override
     protected void onDraw(Canvas canvas)
     {
           
             canvas.drawBitmap( sourceImage, null , new Rect(0,0,getWidth(),getHeight()),tmpPaint);
    
                           
                       //      canvas.drawCircle(10,12,  55, pOuterBullsEye);
                           
                   
          
     	int Xs = (int)((gbuy.SHORTRANGEWIDTH >> 1) + gbuy.SHORTRANGEBOUNDSX);
     	int Ys = (int)((gbuy.SHORTRANGEHEIGHT >> 1) + gbuy.BOUNDSY);
     	int delta = (gbuy.SHORTRANGEWIDTH / (20 << 1));
     	
     	
     		index = gbuy.getCurrentSystemIndex();
     	
     	// Drawing lines with a white stroke color
     	//CGContextSetRGBStrokeColor(context, 1.0, 1.0, 1.0, 1.0);
     	// Draw them with a 2.0 stroke width so they are a bit more visible.
     //	CGContextSetLineWidth(context, 2.0);	
     	
     	int fuel = gbuy.getFuel();
     	if (fuel>0)
     	{
     		canvas.drawCircle(Xs,Ys,  fuel * delta, pOuterBullsEye);
     		//CGContextAddArc(context, Xs, Ys,  fuel * delta, 0, 2*3.1416f, 1);
     	}
     	
     	
     	
     	if (gbuy.trackedSystem >= 0)
     	{
     		long distToTracked = gbuy.RealDistance(gbuy.getCurrentSystemIndex(),gbuy.trackedSystem);//   b:<#(int)b#> RealDistance(SolarSystem[COMMANDER.CurSystem], SolarSystem[TrackedSystem]);
     		if (distToTracked > 0)
     		{		
     			
     			int dX = (int) (25* (gbuy.getSolarSystemX(gbuy.getCurrentSystemIndex()) - (gbuy.getSolarSystemX(gbuy.trackedSystem )))/ distToTracked);
     			int dY = (int)(25.0 * (gbuy.getSolarSystemY(gbuy.getCurrentSystemIndex())  - (gbuy.getSolarSystemY(gbuy.trackedSystem))) / (float)distToTracked);
     			
     			// draw directional arrow from planet -- I'd do this in color if it were easier.
     			
     			int dY3 = -(int)(4.0 * (gbuy.getSolarSystemX(gbuy.getCurrentSystemIndex())  - gbuy.getSolarSystemX(gbuy.trackedSystem)) / distToTracked);		
     			int dX3 = (int)(4.0 * (gbuy.getSolarSystemY(gbuy.getCurrentSystemIndex())  - gbuy.getSolarSystemY(gbuy.trackedSystem)) / distToTracked);
     			
     			canvas.drawLine( Xs - dX,Ys - dY,  Xs - dX3,Ys - dY3, pOuterBullsEye);
     			//CGContextMoveToPoint(context,  Xs - dX,Ys - dY);
     		//	CGContextAddLineToPoint(context,Xs - dX3,Ys - dY3);
     		//	CGContextStrokePath(context);
     			canvas.drawLine( Xs - dX,Ys - dY, Xs + dX3,Ys + dY3, pOuterBullsEye);
     		//	CGContextMoveToPoint(context,  Xs - dX,Ys - dY);
     		//	CGContextAddLineToPoint(context, Xs + dX3, Ys + dY3);
     		//	CGContextStrokePath(context);
     			
     		
     		}
     	}

     	
     	
     	// Two loops: first draw the names and then the systems. The names may
     	// overlap and the systems may be drawn on the names, but at least every
     	// system is visible.
     	int j, i, Xp, Yp;
     	for (j=0; j<2; j++)
     	{
     		for (i=0; i<120; i++)
     		{
     			if ( (gbuy.getSolarSystemX(i)  - gbuy.getSolarSystemX(index) <= 20) &&	( gbuy.getSolarSystemY(i)  - gbuy.getSolarSystemY(index)) <= 20)
     			{
     				Xp = (int)((gbuy.SHORTRANGEWIDTH >> 1) +   gbuy.getSolarSystemX(i)  - gbuy.getSolarSystemX(index) * 
     						   (gbuy.SHORTRANGEWIDTH / (20 << 1)) +
     						   gbuy.SHORTRANGEBOUNDSX - gbuy.EXTRAERASE);
     				Yp = (int)((gbuy.SHORTRANGEHEIGHT >> 1) + 
     						   (gbuy.getSolarSystemY(i)  - gbuy.getSolarSystemY(index) ) * 
     						   (gbuy.SHORTRANGEHEIGHT / (20 << 1)) +
     						   gbuy.BOUNDSY - gbuy.EXTRAERASE);
     				if (j == 1)
     				{
     					if (i == gbuy.warpSystem)
     					{
     						
     						canvas.drawLine(Xp-4,Yp+7, Xp+16,Yp+7, pOuterBullsEye);
     						
     						//CGContextMoveToPoint(context, Xp-4, Yp+7);
     						//CGContextAddLineToPoint(context, Xp+16, Yp+7);
     					//	CGContextStrokePath(context);
     						canvas.drawLine(Xp+7,Yp-4, Xp+7,Yp+16, pOuterBullsEye);
     						//CGContextMoveToPoint(context, Xp+7, Yp-4);
     					//	CGContextAddLineToPoint(context, Xp+7, Yp+16);
     					//	CGContextStrokePath(context);
     					//	CGContextSetRGBStrokeColor(context, 1.0, 1.0, 1.0, 1.0);
     						
     					}
     					if (gbuy.getSolarSystemVisited(i)) {
     						//[blueDot drawAtPoint:CGPointMake(Xp, Yp)];
     						//CGContextDrawImage(context,  CGRectMake(Xp, Yp,  blueDotSize.width, blueDotSize.height) , blueDot);

     					} else {
     						//[greenDot drawAtPoint:CGPointMake(Xp, Yp)];
     						//CGContextDrawImage(context,  CGRectMake(Xp, Yp, greenDotSize.width, blueDotSize.height) , greenDot);						
     					}

     					
     					if (gbuy.wormholeExists(i ,-1 ))
     					{
     						delta = gbuy.WORMHOLEDISTANCE * (gbuy.SHORTRANGEWIDTH / (20 << 1));
     						if (gbuy.wormholeExists(i ,gbuy.warpSystem))
     						{
     						///	canvas.drawLine(Xp+delta/2-2,Yp+7+delta/2+4, Xp+18+delta/2+6,Yp+7+delta/2+4, pOuterBullsEye);
     						//	CGContextSetRGBStrokeColor(context, 0.0, 1.0, 0.0, 1.0);
     						//	CGContextMoveToPoint(context, Xp+delta/2-2, Yp+7+delta/2+4);
     						//	CGContextAddLineToPoint(context, Xp+18+delta/2+6, Yp+7+delta/2+4);
     						//	CGContextStrokePath(context);
     						///	canvas.drawLine(Xp+7+delta/2+4,Yp-4+delta/2+2,  Xp+7+delta/2+4,Yp+18+delta/2+6, pOuterBullsEye);
     							//CGContextMoveToPoint(context, Xp+7+delta/2+4, Yp-4+delta/2+2);
     						//	CGContextAddLineToPoint(context, Xp+7+delta/2+4, Yp+18+delta/2+6);
     						//	CGContextStrokePath(context);
     						//	CGContextSetRGBStrokeColor(context, 1.0, 1.0, 1.0, 1.0);	
     							
     						//	canvas.drawLine( Xp-2+delta, Yp+3, Xp+8+delta, Yp+3,pg );
    						//	canvas.drawLine( Xp+3+delta, Yp-2, Xp+3+delta, Yp+8,pg );
     						}
     					//	CGContextDrawImage(context,  CGRectMake(Xp+delta/2, Yp+delta/2, redDotSize.width, redDotSize.height) , redDot);	
     					}
     					
     				}
     				else
     				{
     				    String a1= gbuy.getSolarSystemName(i);
     					canvas.drawText(a1,Xp,Yp-12, pg);
     			     }
     		}
     	}
     	
     
     	
      	
     }
     }

}
