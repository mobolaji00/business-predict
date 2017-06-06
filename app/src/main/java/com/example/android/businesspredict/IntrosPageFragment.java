package com.example.android.businesspredict;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mobolajioo on 5/31/17.
 */

public class IntrosPageFragment extends Fragment {

    public static final String fragmentFileName = "fragmentFileName";
    private View view;

    public static final IntrosPageFragment newInstance(String fragmentFileName)
    {
        IntrosPageFragment f = new IntrosPageFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(IntrosPageFragment.fragmentFileName, fragmentFileName);
        f.setArguments(bdl);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        String fragmentFileName = getArguments().getString(IntrosPageFragment.fragmentFileName);
        int fragmentResourceID = getContext().getResources().getIdentifier(fragmentFileName,"layout", getContext().getPackageName());

        view = inflater.inflate(fragmentResourceID, container, false);

        CreateCharts cc = new CreateCharts(view);

        if (fragmentFileName.equals("intro_text"))
            styleIntroText();
        else if (fragmentFileName.equals("intro_graph_1"))
        {
            double [] y = LinearRegression.getFeature("C2_Owners_2");

            double [] x = new double[y.length];
            for (int i=0; i <x.length; i++)
            {
                x[i]=i+1;
            }

            view = cc.setUpLineChart(x,y);
        }

        else if (fragmentFileName.equals("intro_graph_2"))
        {
            double [] y = LinearRegression.getFeature("Tot_Revenue_R_2");

            double [] x = new double[y.length];
            for (int i=0; i <x.length; i++)
            {
                x[i]=i+1;
            }

            view = cc.setUpScatterChart(x,y);
        }

        return view;
    }

    private void styleIntroText()
    {
        TextView textRegion = (TextView) view.findViewById(R.id.introduction);
        textRegion.setGravity(Gravity.CENTER);

        TextView textRegion2 = (TextView) view.findViewById(R.id.introduction_title);
        textRegion2.setGravity(Gravity.CENTER);
    }

}
