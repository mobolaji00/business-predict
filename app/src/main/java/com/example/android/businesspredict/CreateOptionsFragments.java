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

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    public static final CreateOptionsFragments newInstance(String message)
    {
        CreateOptionsFragments f = new CreateOptionsFragments();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.create_options_fragment, container, false);

        View v = view.findViewById(R.id.test1);
        InitialViewSetup ivs = new InitialViewSetup();
        ivs.surroundViewWithBorder(v);

        return view;
    }

}



