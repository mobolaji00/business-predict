package com.example.android.businesspredict;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnalyzeButtonFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AnalyzeButtonFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
    private View view;

    public AnalyzeButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.analyze_button_fragment, container, false);

        Button analyzeButton = (Button) view.findViewById(R.id.analyze_button);
        analyzeButton.setOnClickListener(this);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }

        else
        {
            throw new RuntimeException(context.toString()
                    + " must implement Listeners");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
        ArrayList onAnalyzeButtonClicked();
    }

    // Create an anonymous implementation of OnClickListener
        public void onClick(View v) {

            ArrayList inputContents = new ArrayList();

            mListener.onAnalyzeButtonClicked();

    CheckInputFields checkedOut = new CheckInputFields();


        }

}
