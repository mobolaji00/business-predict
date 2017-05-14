package com.example.android.businesspredict;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.Scroller;

/**
 * Created by mobolajioo on 5/10/17.
 */

public class HSVFling extends HorizontalScrollView {

    //private Context context;
    public HSVFling(Context context) {

        super(context);
        // TODO Auto-generated constructor stub
    }
    public HSVFling(Context context, AttributeSet attrs) {

        super(context, attrs);
        // TODO Auto-generated constructor stub
    }
    public HSVFling(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void fling(int velocity)
    {
        int scale = 1000000;
        Scroller mScroller = new Scroller(getContext());

        mScroller.forceFinished(true);
        mScroller.fling(0, 0, (int)velocity/scale, (int)velocity/scale, 0, 1000, 0, 1000);
        ViewCompat.postInvalidateOnAnimation(this);

    }
}
