package com.example.android.businesspredict;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.HashMap;

/**
 * Created by mobolajioo on 5/24/17.
 */

public class GetViewsFromPage {

    public HashMap<String,View> getViewsOnPage(ViewGroup vg, String tagToSearchFor)
    {
        HashMap<String,View> views = new HashMap<String,View>();

        for (int i = 0; i < vg.getChildCount(); i++)
        {
            View v = vg.getChildAt(i);

            if (v instanceof ViewGroup)
            {
                views.putAll(getViewsOnPage((ViewGroup) v,tagToSearchFor));
            }

            final String viewTag = (String) v.getTag();

            if (viewTag != null && viewTag.equals(tagToSearchFor))
            {
                String fullId = (String)v.getResources().getResourceName(v.getId());
                String[] splitId = fullId.split("[id][\\/]");
                String id = splitId[1];

                if(v instanceof RadioGroup)
                    id =  splitId[1].split("_rad_grp$")[0];

                if(v instanceof Spinner)
                    id =  splitId[1].split("_spinner$")[0];

                if(tagToSearchFor.equals(v.getResources().getString(R.string.question)))
                    id =  splitId[1].split("_question$")[0];

                views.put(id,v);
            }
        }

        return views;
    }


}
