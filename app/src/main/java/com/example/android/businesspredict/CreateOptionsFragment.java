package com.example.android.businesspredict;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by mobolajioo on 5/18/17.
 */


public class CreateOptionsFragment extends Fragment {

    public static final String FRAG_NUM = "FRAG_NUM";
    public static final String SPIN_IDS = "SPIN_IDS";
    private View view;

    public static final CreateOptionsFragment newInstance(String frag_num, String[] spin_ids)
    {
        CreateOptionsFragment f = new CreateOptionsFragment();
        Bundle bdl = new Bundle(2);
        bdl.putString(FRAG_NUM, frag_num);
        bdl.putStringArray(SPIN_IDS, spin_ids);
        f.setArguments(bdl);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        String frag_num = getArguments().getString(FRAG_NUM);
        int frag_res_id = getContext().getResources().getIdentifier(frag_num,"layout", getContext().getPackageName());

        view = inflater.inflate(frag_res_id,container, false);

        changesToViewAtStart(frag_res_id,frag_num,view,getArguments().getStringArray(SPIN_IDS));

        return view;
    }

    public void changesToViewAtStart(int frag_res_id, String frag_num,View view, String[] spin_ids)
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
            spinner.setSelection(spinner_adapter.getPosition("1"));
        }

    }

    public ArrayList<View> usersInput()
    {
        ViewGroup vg = (ViewGroup) view.findViewWithTag("input");
        View v;
        ArrayList<View> inputViews = new ArrayList<View>();

        for (int i = 0;i < vg.getChildCount(); i++)
        {
            v = vg.getChildAt(i);
            inputViews.add(v);
        }

        return inputViews;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}



