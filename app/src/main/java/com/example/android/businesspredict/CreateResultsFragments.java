package com.example.android.businesspredict;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mobolajioo on 5/17/17.
 */

public class CreateResultsFragments extends Fragment {

    public static final String FRAG_NUM = "FRAG_NUM";

    public static final CreateResultsFragments newInstance(String frag_num)
    {
        CreateResultsFragments f = new CreateResultsFragments();
        Bundle bdl = new Bundle(1);
        bdl.putString(FRAG_NUM, frag_num);
        f.setArguments(bdl);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        String frag_num = getArguments().getString(FRAG_NUM);

        View view = inflater.inflate(R.layout.create_results_fragment, container, false);

        TextView textRegion = (TextView) view.findViewById(R.id.introduction);
        textRegion.setGravity(Gravity.CENTER);

        TextView textRegion2 = (TextView) view.findViewById(R.id.introduction_title);
        textRegion2.setGravity(Gravity.CENTER);


        return view;
    }

}


