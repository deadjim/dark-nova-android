package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class shortrangechart extends Activity {
    /**
     * Called when the activity is first created.
     */
    public Bitmap sourceImage;

    public static int ii = 0, jj = 0, Xxp = 0, Yyp = 0;
    public static int inde = 0;
    public static int butttoncount = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //   LinearLayout lmain = new LinearLayout(this);
        AbsoluteLayout lmain = new AbsoluteLayout(this);
        // lmain.setBackgroundResource(R.drawable.shortrangechart);
        //lmain.setOrientation(LinearLayout.VERTICAL);

        addCanvasBitmap(lmain, R.drawable.shortrangechart, true);

        inde = Globala.getCurrentSystemIndex();

        /*for (jj = 0; jj < 2; jj++) {
            for (ii = 0; ii < 120; ii++) {
                if ((Globala.getSolarSystemX(ii) - Globala.getSolarSystemX(inde)) <= 20 && (Globala.getSolarSystemY(ii) - Globala.getSolarSystemY(inde)) <= 20) {
                    Xxp = (int) ((Globala.SHORTRANGEWIDTH >> 1) + (Globala.getSolarSystemX(ii) - Globala.getSolarSystemX(inde))
                            * (Globala.SHORTRANGEWIDTH / (40 << 1)) + (Globala.SHORTRANGEBOUNDSX - Globala.EXTRAERASE));
                    Log.v("LOG_TAG", "Xxp" + Xxp);
                    Yyp = (int) ((Globala.SHORTRANGEHEIGHT >> 1) + (Globala.getSolarSystemY(ii) - Globala.getSolarSystemY(inde))
                            * (Globala.SHORTRANGEHEIGHT / (40 << 1)) + (Globala.BOUNDSY - Globala.EXTRAERASE));
                    Log.v("LOG_TAG", "Yyp" + Yyp);

                } else {
                    String aa= Globala.getSolarSystemName(ii);

                         final TextView t = new TextView(this);

                         t.setText(aa);
                         t.setTextSize(12);

                             t.setId(butttoncount);
                             t.setOnClickListener(new OnClickListener() {
                                 public void onClick(View v)
                                 {

                                     Globala.Name=(String) t.getText();
                                     Log.v("shortname",""+Globala.Name);
                                     Intent intent = new Intent(shortrangechart.this,encounter.class);
                                     //intent.putExtra("GameName", t.getText().toString());
                                     startActivity(intent);
                                 }
                             });
                             if(Xxp > 0 && Yyp-12 > 0 )
                             lmain.addView(t, new AbsoluteLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Xxp, Yyp-12));
                             butttoncount++;
                }
            }
        }*/

        final Button bclose = new Button(this);
        bclose.setText("close");
        bclose.setId(10001);
        bclose.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent close1 = new Intent(shortrangechart.this, main.class);
                startActivity(close1);
            }
        });

        lmain.addView(bclose, new AbsoluteLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 270, 5));


        //    Button b = new Button(this);
        //    lmain.addView(b, new AbsoluteLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 80, 80));
        //  }
        setContentView(lmain);


    }

    private void addCanvasBitmap(AbsoluteLayout lmain, int resource, boolean scale) {
        Bitmap bitmap;
        bitmap = loadAndPrintDpi(resource, scale);

        ScaledBitmapView view = new ScaledBitmapView(this, bitmap, lmain);

        view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        lmain.addView(view);
    }

    private Bitmap loadAndPrintDpi(int id, boolean scale) {
        Bitmap bitmap;
        if (scale) {
            bitmap = BitmapFactory.decodeResource(getResources(), id);
        } else {
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inScaled = false;
            bitmap = BitmapFactory.decodeResource(getResources(), id, opts);
        }
        return bitmap;
    }
}

class ScaledBitmapView extends View {
    private Bitmap mBitmap;
    public static int j = 0, i = 0, Xp = 0, Yp = 0;
    private Context context;
    private AbsoluteLayout lmain;

    public ScaledBitmapView(Context context, Bitmap bitmap, AbsoluteLayout lmain) {
        super(context);
        this.context = context;
        this.lmain = lmain;
        this.setWillNotDraw(false);
        mBitmap = bitmap;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final DisplayMetrics metrics = getResources().getDisplayMetrics();
        setMeasuredDimension(
                mBitmap.getScaledWidth(metrics),
                mBitmap.getScaledHeight(metrics));
    }

    protected void dispatchDraw(Canvas canvas) {

        super.dispatchDraw(canvas);
        this.setWillNotDraw(false);


        int index = 0;
        Paint pb = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint pw = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint pg = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint pr = new Paint(Paint.ANTI_ALIAS_FLAG);
        pb.setStyle(Paint.Style.STROKE);
        pb.setColor(Color.BLUE);

        pw.setStyle(Paint.Style.STROKE);
        pw.setColor(Color.WHITE);
        pr.setStyle(Paint.Style.STROKE);
        pr.setColor(Color.RED);
        pg.setStyle(Paint.Style.STROKE);
        pg.setColor(Color.GREEN);

        //      canvas.drawCircle(10,12,  55, pOuterBullsEye);

        Bitmap sourceImage = BitmapFactory.decodeResource(getResources(), R.drawable.shortrangechart);
        canvas.drawBitmap(sourceImage, null, new Rect(0, 0, getWidth(), getHeight()), pw);

        //	int Xs = (int)((Globala.SHORTRANGEWIDTH >> 1) + Globala.SHORTRANGEBOUNDSX);
        int Xs = (int) ((Globala.SHORTRANGEWIDTH >> 1) + Globala.SHORTRANGEBOUNDSX);
        //	int Ys = (int)((Globala.SHORTRANGEHEIGHT >> 1) + Globala.BOUNDSY);
        int Ys = (int) ((Globala.SHORTRANGEHEIGHT >> 1) + Globala.BOUNDSY);
        int delta = (Globala.SHORTRANGEWIDTH / (20 << 1));


        index = Globala.getCurrentSystemIndex();

        // Drawing lines with a white stroke color
        //CGContextSetRGBStrokeColor(context, 1.0, 1.0, 1.0, 1.0);
        // Draw them with a 2.0 stroke width so they are a bit more visible.
        //	CGContextSetLineWidth(context, 2.0);

        int fuel = Globala.getFuel();

        if (fuel > 0) {
            canvas.drawCircle(Xs, Ys, fuel * delta + 3, pw);
            //CGContextAddArc(context, Xs, Ys,  fuel * delta, 0, 2*3.1416f, 1);
        }


        if (Globala.trackedSystem >= 0) {
            long distToTracked = Globala.RealDistance(Globala.getCurrentSystemIndex(), Globala.trackedSystem);//   b:<#(int)b#> RealDistance(SolarSystem[COMMANDER.CurSystem], SolarSystem[TrackedSystem]);
            if (distToTracked > 0) {

                int dX = (int) (25 * (Globala.getSolarSystemX(Globala.getCurrentSystemIndex()) - (Globala.getSolarSystemX(Globala.trackedSystem))) / distToTracked);

                int dY = (int) (25.0 * (Globala.getSolarSystemY(Globala.getCurrentSystemIndex()) - (Globala.getSolarSystemY(Globala.trackedSystem))) / distToTracked);


                // draw directional arrow from planet -- I'd do this in color if it were easier.

                int dY3 = -(int) (4.0 * (Globala.getSolarSystemX(Globala.getCurrentSystemIndex()) - Globala.getSolarSystemX(Globala.trackedSystem)) / distToTracked);
                int dX3 = (int) (4.0 * (Globala.getSolarSystemY(Globala.getCurrentSystemIndex()) - Globala.getSolarSystemY(Globala.trackedSystem)) / distToTracked);

                canvas.drawLine(Xs - dX, Ys - dY, Xs - dX3, Ys - dY3, pw);
                //CGContextMoveToPoint(context,  Xs - dX,Ys - dY);
                //	CGContextAddLineToPoint(context,Xs - dX3,Ys - dY3);
                //	CGContextStrokePath(context);
                canvas.drawLine(Xs - dX, Ys - dY, Xs + dX3, Ys + dY3, pw);
                //	CGContextMoveToPoint(context,  Xs - dX,Ys - dY);
                //	CGContextAddLineToPoint(context, Xs + dX3, Ys + dY3);
                //	CGContextStrokePath(context);


            }
        }


        // Two loops: first draw the names and then the systems. The names may
        // overlap and the systems may be drawn on the names, but at least every
        // system is visible.
        int butttoncount = 0;

        for (j = 0; j < 2; j++) {
            for (i = 0; i < 120; i++) {
                if (Math.abs(Globala.getSolarSystemX(i) - Globala.getSolarSystemX(index)) <= 20 &&
                        Math.abs(Globala.getSolarSystemY(i) - Globala.getSolarSystemY(index)) <= 20) {
                    Xp = (Globala.SHORTRANGEWIDTH >> 1) + (Globala.getSolarSystemX(i) - Globala.getSolarSystemX(index))
                            * (Globala.SHORTRANGEWIDTH / (40 << 1)) + (Globala.SHORTRANGEBOUNDSX - Globala.EXTRAERASE);

                    Yp = (Globala.SHORTRANGEHEIGHT >> 1) + (Globala.getSolarSystemY(i) - Globala.getSolarSystemY(index))
                            * (Globala.SHORTRANGEHEIGHT / (40 << 1)) + (Globala.BOUNDSY - Globala.EXTRAERASE);

                    if (j == 1) {
                        if (i == Globala.warpSystem) {

                            //	canvas.drawLine(Xp-4,Yp+7, Xp+16,Yp+7, pw);

                            //CGContextMoveToPoint(context, Xp-4, Yp+7);
                            //CGContextAddLineToPoint(context, Xp+16, Yp+7);
                            //	CGContextStrokePath(context);
                            //	canvas.drawLine(Xp+7,Yp-4, Xp+7,Yp+16, pw);
                            //CGContextMoveToPoint(context, Xp+7, Yp-4);
                            //	CGContextAddLineToPoint(context, Xp+7, Yp+16);
                            //	CGContextStrokePath(context);
                            //	CGContextSetRGBStrokeColor(context, 1.0, 1.0, 1.0, 1.0);


                            canvas.drawLine(Xp - 6, Yp + 10, Xp + 26, Yp + 10, pw);
//                         CGContextSetRGBStrokeColor(context, 0.0, 1.0, 0.50, 1.0);
//						CGContextMoveToPoint(context, Xp-6, Yp+10);
//						CGContextAddLineToPoint(context, Xp+26, Yp+10);
//						CGContextStrokePath(context);

                            canvas.drawLine(Xp + 10, Yp - 6, Xp + 10, Yp + 26, pw);
//						CGContextMoveToPoint(context, Xp+10, Yp-6);
//						CGContextAddLineToPoint(context, Xp+10, Yp+26);
//						CGContextStrokePath(context);
//						CGContextSetRGBStrokeColor(context, 1.0, 1.0, 1.0, 1.0);


                        }
                        if (Globala.getSolarSystemVisited(i)) {
                            canvas.drawCircle(Xp - 4, Yp - 4, 4, pb);
                            //[blueDot drawAtPoint:CGPointMake(Xp, Yp)];
                            //CGContextDrawImage(context,  CGRectMake(Xp, Yp,  blueDotSize.width, blueDotSize.height) , blueDot);

                        } else {
                            canvas.drawCircle(Xp - 4, Yp - 4, 4, pg);
                            //[greenDot drawAtPoint:CGPointMake(Xp, Yp)];
                            //CGContextDrawImage(context,  CGRectMake(Xp, Yp, greenDotSize.width, blueDotSize.height) , greenDot);
                        }


                        if (Globala.wormholeExists(i, -1)) {
                            delta = Globala.WORMHOLEDISTANCE * (Globala.SHORTRANGEWIDTH / (20 << 1));
                            if (Globala.wormholeExists(i, Globala.warpSystem)) {
                                canvas.drawLine(Xp + (delta / 2) - 2, Yp + 7 + (delta / 2) + 4, Xp + 18 + (delta / 2) + 6, Yp + 7 + (delta / 2) + 4, pw);
                                //	CGContextSetRGBStrokeColor(context, 0.0, 1.0, 0.0, 1.0);
                                //	CGContextMoveToPoint(context, Xp+delta/2-2, Yp+7+delta/2+4);
                                //	CGContextAddLineToPoint(context, Xp+18+delta/2+6, Yp+7+delta/2+4);
                                //	CGContextStrokePath(context);
                                canvas.drawLine(Xp + 7 + (delta / 2) + 4, Yp - 4 + (delta / 2) + 2, Xp + 7 + (delta / 2) + 4, Yp + 18 + (delta / 2) + 6, pw);
                                //CGContextMoveToPoint(context, Xp+7+delta/2+4, Yp-4+delta/2+2);
                                //	CGContextAddLineToPoint(context, Xp+7+delta/2+4, Yp+18+delta/2+6);
                                //	CGContextStrokePath(context);
                                //	CGContextSetRGBStrokeColor(context, 1.0, 1.0, 1.0, 1.0);

                                canvas.drawLine(Xp - 2 + delta, Yp + 3, Xp + 8 + delta, Yp + 3, pg);
                                canvas.drawLine(Xp + 3 + delta, Yp - 2, Xp + 3 + delta, Yp + 8, pg);
                            }
                            canvas.drawCircle((Xp + delta / 2) - 4, (Yp + delta / 2) - 4, 4, pr);
                            //	CGContextDrawImage(context,  CGRectMake(Xp+delta/2, Yp+delta/2, redDotSize.width, redDotSize.height) , redDot);
                        }

                    } else {

                        String aa = Globala.getSolarSystemName(i);
                        //canvas.drawText(aa,Xp,Yp-12, pg);

                        final TextView t = new TextView(context);

                        t.setText(aa);
                        t.setTextSize(12);

                        t.setId(butttoncount);
                        t.setOnClickListener(new OnClickListener() {
                            public void onClick(View v) {

                                Globala.Name = (String) t.getText();
                                Log.v("shortname", "" + Globala.Name);
                                Intent intent = new Intent(context, encounter.class);
                                //intent.putExtra("GameName", t.getText().toString());
                                context.startActivity(intent);
                            }
                        });
                        if (Xp > 0 && Yp - 12 > 0) {
                            lmain.addView(t, new AbsoluteLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Xp, Yp - 12));
                        }
                        butttoncount++;

                    }
                }
            }


        }


    }

}