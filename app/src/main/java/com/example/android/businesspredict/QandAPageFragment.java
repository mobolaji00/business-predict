package com.example.android.businesspredict;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.HashMap;

/**
 * Created by mobolajioo on 5/18/17.
 */


public class QandAPageFragment extends Fragment {

    public static final String fragmentFilename = "fragmentFilename";
    public static final String spinnerIDs = "spinnerIDs";

    private View view;
    private String fragmentName = "unknown for now";

    public static final QandAPageFragment newInstance(String fragmentFilename, String[] spinnerIDs)
    {
        QandAPageFragment f = new QandAPageFragment();
        Bundle bdl = new Bundle(2);
        bdl.putString(QandAPageFragment.fragmentFilename, fragmentFilename);
        bdl.putStringArray(QandAPageFragment.spinnerIDs, spinnerIDs);
        f.setArguments(bdl);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        String fragmentFilename = getArguments().getString(QandAPageFragment.fragmentFilename);
        int fragmentResourceID = getContext().getResources().getIdentifier(fragmentFilename,"layout", getContext().getPackageName());

        view = inflater.inflate(fragmentResourceID,container, false);

        makeChangesToView(fragmentResourceID,fragmentFilename,view,getArguments().getStringArray(spinnerIDs));
        fragmentName = fragmentFilename;

        return view;
    }

    public void makeChangesToView(int frag_res_id, String frag_num, View view, String[] spin_ids)
    {
        switch(frag_num)
        {
            case "page_1":

                createSpinners(frag_res_id, view, this.getContext(),spin_ids);
                break;

            default:
                break;
        }

    }

    public void createSpinners(int frag_res_id, View view, Context context,String[] spin_ids)
    {

        for (String spin_id: spin_ids)
        {
            int spin_res_id = getContext().getResources().getIdentifier(spin_id, "id", getContext().getPackageName());

            Spinner spinner = (Spinner) view.findViewById(spin_res_id);
            ArrayAdapter<CharSequence> spinner_adapter = ArrayAdapter.createFromResource(context,
                    R.array.array_1_to_10, android.R.layout.simple_spinner_item);

            spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(spinner_adapter);
            spinner.setSelection(spinner_adapter.getPosition(""));
        }

    }

    public HashMap<String,View> getQuestionsViewsFromPage(String viewTag)
    {
        HashMap<String,View> viewsOnPage = new HashMap<String,View>();
        Log.i(viewTag,fragmentName);

        ViewGroup vg = ((ViewGroup) view);
        GetViewsFromPage gvop = new GetViewsFromPage();
        viewsOnPage = gvop.getViewsOnPage(vg,viewTag);

        return viewsOnPage;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}



