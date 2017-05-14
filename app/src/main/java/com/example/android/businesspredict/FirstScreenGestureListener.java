package com.example.android.businesspredict;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * Created by mobolajioo on 5/2/17.
 */

public class FirstScreenGestureListener extends GestureDetector.SimpleOnGestureListener {

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

}

