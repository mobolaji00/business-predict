package com.example.android.businesspredict;

import android.animation.ObjectAnimator;
import android.widget.HorizontalScrollView;

/**
 * Created by mobolajioo on 5/10/17.
 */

public class ScrollLeftOrRight {

    private int scrollX = 0;
    private int featureWidth = 0;
    private int positionToScroll = 0;
    private int rViewScrolled = 0;

    private int scroll_adjust_multiplier = 0;
    private int imageCount = 0;

    private final int SWIPE_MIN_DISTANCE = 0;//5;
    private final int SWIPE_THRESHOLD_VELOCITY = 0;// 300;


    public void scroll(HorizontalScrollView hsv, int scroll_adjust)
    {

        scrollX = hsv.getScrollX();
        featureWidth = hsv.getWidth();
        rViewScrolled = scrollX%featureWidth;


        if (0 <= scrollX && scrollX <= featureWidth)
        {
            if (rViewScrolled < featureWidth/2)
            {
                positionToScroll = 0;
            }
            else
            {
                scroll_adjust_multiplier = 3;
                positionToScroll = featureWidth;
            }
        }
        else if (featureWidth < scrollX && scrollX <= featureWidth*2)
        {
            if (rViewScrolled < featureWidth/2)
            {
                scroll_adjust_multiplier = 3;
                positionToScroll = featureWidth;
            }
            else
            {
                scroll_adjust_multiplier = 5;
                positionToScroll = featureWidth*2;
            }
        }
        else if (featureWidth*2 < scrollX && scrollX <= featureWidth*3)
        {
            if (rViewScrolled < featureWidth/2)
            {
                scroll_adjust_multiplier = 5;
                positionToScroll = featureWidth*2;
            }
            else
            {
                scroll_adjust_multiplier = 7;
                positionToScroll = featureWidth*3;
            }
        }
        else
        {
            scroll_adjust_multiplier = 7;
            positionToScroll = featureWidth*3;
        }

        ObjectAnimator.ofInt(hsv, "scrollX", positionToScroll+(scroll_adjust_multiplier*scroll_adjust)).setDuration(2000).start();
        //return true;

    }

    public void scroll(HorizontalScrollView hsv, int scroll_adjust, int e1_rawX, int e2_rawX, double velocityX)
    {


        /*
        scrollX = hsv.getScrollX();
        featureWidth = hsv.getWidth();
        Log.i("Printing Fling ScrollX","scrollX is "+scrollX);
        rViewScrolled = scrollX%featureWidth;

        if(e1_rawX > e2_rawX)
        {
            imageCount +=1;
            scrollX = imageCount * featureWidth;
        }
        else
        {
            imageCount -=1;
            scrollX = imageCount * featureWidth;
        }
        */




        /*
        if (0 <= scrollX && scrollX <= featureWidth)
        {
            if (rViewScrolled < featureWidth/2)
            {
                positionToScroll = 0;
            }
            else
            {
                scroll_adjust_multiplier = 3;
                positionToScroll = featureWidth;
            }
        }
        else if (featureWidth < scrollX && scrollX <= featureWidth*2)
        {
            if (rViewScrolled < featureWidth/2)
            {
                scroll_adjust_multiplier = 3;
                positionToScroll = featureWidth;
            }
            else
            {
                scroll_adjust_multiplier = 5;
                positionToScroll = featureWidth*2;
            }
        }
        else if (featureWidth*2 < scrollX && scrollX <= featureWidth*3)
        {
            if (rViewScrolled < featureWidth/2)
            {
                scroll_adjust_multiplier = 5;
                positionToScroll = featureWidth*2;
            }
            else
            {
                scroll_adjust_multiplier = 7;
                positionToScroll = featureWidth*3;
            }
        }
        else
        {
            scroll_adjust_multiplier = 7;
            positionToScroll = featureWidth*3;
        }
        */

        if(e1_rawX - e2_rawX > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
            //int featureWidth = getMeasuredWidth();
            //mActiveFeature = (mActiveFeature < (mItems.size() - 1))? mActiveFeature + 1:mItems.size() -1;
            //smoothScrollTo(mActiveFeature*featureWidth, 0);
            ObjectAnimator.ofInt(hsv, "scrollX", 1000).setDuration(2000).start();
            //return true;
        }



        //ObjectAnimator.ofInt(hsv, "scrollX", positionToScroll+(scroll_adjust_multiplier*scroll_adjust)).setDuration(2000).start();
        //return true;

    }
}
