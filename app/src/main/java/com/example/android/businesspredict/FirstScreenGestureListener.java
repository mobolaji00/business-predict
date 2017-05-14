package com.example.android.businesspredict;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * Created by mobolajioo on 5/2/17.
 */

public class FirstScreenGestureListener extends GestureDetector.SimpleOnGestureListener
{

    private static final String DEBUG_TAG = "Gestures";
    private static final String INFO_TAG = "Gestures";

    private HorizontalScrollView hsv;
    private int scroll_adjust = 0;
    private int scroll_adjust_multiplier = 0;
    private Context context;

    private int scrollX = 0;
    private int featureWidth = 0;
    private int positionToScroll = 0;
    private int rViewScrolled = 0;

    private final int SWIPE_MIN_DISTANCE = 5;
    private final int SWIPE_THRESHOLD_VELOCITY = 300;


    public FirstScreenGestureListener(HorizontalScrollView hsv, Context context, int scroll_adjust) {
        this.hsv = hsv;
        this.context = context;
        this.scroll_adjust = scroll_adjust;
        //this.featureWidth = featureWidth;
    }

    @Override
    public boolean onDown(MotionEvent event) {
        //Log.d(DEBUG_TAG, event.toString());
        Log.d(DEBUG_TAG, "OnDown() method in FirstScreenGestureListener");
        return true;
    }

/*
    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY)
    {
        /*
        Log.d(DEBUG_TAG, event1.toString()+" & "+event2.toString());
        Log.d(DEBUG_TAG, "OnFling() method in FirstScreenGestureListener");


        Log.i("Printing Fling VelX","velocityX is "+velocityX);
        //Log.i("Printing hsv scrollX","scrollX is "+hsv.getScrollX());
        */


        //ScrollLeftOrRight slr = new ScrollLeftOrRight();
        //slr.scroll(hsv,scroll_adjust,(int) event1.getRawX(),(int)event2.getRawX(),velocityX);

        //return false;

        /*
        final int e1 = (int) event1.getRawX();
        final int e2 = (int)event2.getRawX();
        final double v = velocityX;

        hsv.post(new Runnable() {
            @Override
            public void run() {
                ScrollLeftOrRight slr = new ScrollLeftOrRight();
                slr.scroll(hsv,scroll_adjust,(int) e1, e2 , v);
            }
        });
        */

        //return true;
    // }
}

