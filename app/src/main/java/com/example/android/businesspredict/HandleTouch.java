package com.example.android.businesspredict;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * Created by mobolajioo on 5/2/17.
 */

public class HandleTouch implements View.OnTouchListener
{
    private static final String DISPLAY_TOUCHED_FLING = "Touched - Fling";
    private static final String DISPLAY_TOUCHED_NO_FLING = "Touched - NoFling";
    private static final String EVENT_NOT_HANDLED = "Event Not Handled";

    private static final String DEBUG_TAG = "Touch";

    private GestureDetectorCompat mDetector;
    private MainActivity ma;

    private int scroll_adjust = 0;
    private int scroll_adjust_multiplier = 0;
    private Context context;

    private double movementStartPositon;
    private double movementEndPositon;

    private long movementStartTime = 0;
    private long movementEndTime = 0;

    private double velocity;

    final private double velocityThreshold = 8;


    public HandleTouch(GestureDetectorCompat mDetector, MainActivity ma, Context context, int scroll_adjust)
    {
        this.mDetector = mDetector;
        this.ma = ma;
        this.context = context;
        this.scroll_adjust = scroll_adjust;
    }

    public boolean onTouch(View view, MotionEvent event)
    {

        //Try to handle using fling gesture
        if (mDetector.onTouchEvent(event))
        {
            movementStartPositon = event.getRawX();
            movementStartTime = System.currentTimeMillis();
            //Log.d(DISPLAY_TOUCHED_FLING,"Fling: " + event.toString());
            Log.d(DEBUG_TAG, event.toString());
            Log.d(DEBUG_TAG, "OnTouch() method in HandleTouch - Send to Gestures");
            return ma.onTouchEvent(event);
        }

        //Try to handle using events
        else if(event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL )
        //else if(event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_MOVE || event.getAction() == MotionEvent.ACTION_CANCEL )
        {
            movementEndPositon = event.getRawX();
            movementEndTime = System.currentTimeMillis();

            velocity = Math.abs(movementEndPositon-movementStartPositon)/(movementEndTime-movementStartTime);

            //if (velocity < velocityThreshold) {
            if (true) {
            /*int imagePosition = scrollX%(featureWidth/2);*/
                //Log.d(DISPLAY_TOUCHED_NO_FLING, event.toString());
                Log.d(DEBUG_TAG, "OnTouch() method in HandleTouch - Handle in this class");

                final HorizontalScrollView hsv = (HorizontalScrollView) view;
                hsv.post(new Runnable() {
                    @Override
                    public void run() {
                        ScrollLeftOrRight slr = new ScrollLeftOrRight();
                        slr.scroll(hsv, scroll_adjust);
                    }
                });

                Log.d(DEBUG_TAG, event.toString());
            }
            return true;
        }
/*
        else if(event.getAction() == MotionEvent.ACTION_MOVE)
        {
            Log.d(DEBUG_TAG, event.toString());
            return true;
        }
*/
        else
        {
            Log.d(DEBUG_TAG, event.toString());
            //return true;
            return false;
        }

    }
}
