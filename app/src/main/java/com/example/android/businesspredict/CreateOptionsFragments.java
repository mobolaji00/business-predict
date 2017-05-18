package com.example.android.businesspredict;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mobolajioo on 5/18/17.
 */


public class CreateOptionsFragments extends Fragment {

    public static final String FRAG_NUM = "FRAG_NUM";

    public static final CreateOptionsFragments newInstance(String frag_num)
    {
        CreateOptionsFragments f = new CreateOptionsFragments();
        Bundle bdl = new Bundle(1);
        bdl.putString(FRAG_NUM, frag_num);
        f.setArguments(bdl);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        String frag_num = getArguments().getString(FRAG_NUM);
        int frag_res_id = getContext().getResources().getIdentifier(frag_num,"layout", getContext().getPackageName());

        View view = inflater.inflate(frag_res_id,container, false);

        /*
        View v = view.findViewById(R.id.test3);
        InitialViewSetup ivs = new InitialViewSetup();
        ivs.surroundViewWithBorder(v);
        */

        return view;
    }

}



