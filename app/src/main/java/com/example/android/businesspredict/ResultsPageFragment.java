package com.example.android.businesspredict;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mobolajioo on 5/17/17.
 */

public class ResultsPageFragment extends Fragment {

    public static final String fragmentFileName = "fragmentFileName";
    private View view;

    public static final ResultsPageFragment newInstance(String fragmentFileName)
    {
        ResultsPageFragment f = new ResultsPageFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(ResultsPageFragment.fragmentFileName, fragmentFileName);
        f.setArguments(bdl);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        String fragmentFilename = getArguments().getString(fragmentFileName);
        int fragmentResourceID = getContext().getResources().getIdentifier(fragmentFilename,"layout", getContext().getPackageName());

        view = inflater.inflate(fragmentResourceID, container, false);

        double [] testDataX = new double[] {0,1,2,3,4,5,6,7,8,9};
        double [] testDataY = new double[] {10,11,12,13,14,15,16,17,18,19};

        CreateCharts cc = new CreateCharts(view);
        view = cc.setUpLineChart(testDataX,testDataY);

        return view;
    }

}


