package com.example.android.businesspredict;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

/**
 * Created by mobolajioo on 5/2/17.
 */

public class InitialViewSetup {

    private View view;
    private HorizontalScrollView hsv;


    public void surroundViewWithBorder(final View v)
    {
        final int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;

        ViewGroup.LayoutParams params = v.getLayoutParams();
        params.width = screenWidth;
        v.setLayoutParams(params);
        v.setBackgroundResource(R.drawable.text_background);

    }

    public void scrollViewBy(final HorizontalScrollView hsv, final int adjust){

        final int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        final int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

        // Scroll by adjust
        hsv.post(new Runnable() {
            @Override
            public void run() {
                hsv.smoothScrollBy((adjust), 0);
                Log.i("SELECTED", "Margin is "+adjust);
                Log.i("SELECTED", "Width is "+screenWidth);
                Log.i("SELECTED", "Height is "+screenHeight);
            }
        });

    }

    public void createSpinners(int frag_res_id, View view, Context context)
    {
        /*
        Spinner owner_spinner = (Spinner) view.findViewById(R.id.spinner_owner);
        ArrayAdapter<CharSequence> owner_adapter = ArrayAdapter.createFromResource(context,
                R.array.array_1_to_10, android.R.layout.simple_spinner_item);

        owner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        owner_spinner.setAdapter(owner_adapter);
        owner_spinner.setSelection(owner_adapter.getPosition("1"));

        Spinner owner_operator_spinner = (Spinner) view.findViewById(R.id.spinner_owner_operator);
        ArrayAdapter<CharSequence> owner_operator_adapter = ArrayAdapter.createFromResource(context,
                R.array.array_1_to_10, android.R.layout.simple_spinner_item);

        owner_operator_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        owner_operator_spinner.setAdapter(owner_operator_adapter);
        owner_operator_spinner.setSelection(owner_operator_adapter.getPosition("1"));
        */

    }

}
