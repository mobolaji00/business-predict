package com.example.android.businesspredict;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DisplayResultsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class DisplayResultsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private GestureDetectorCompat mDetector;
    private int mActiveFeature = 0;
    private View view;
    private MainActivity ma;
    private HorizontalScrollView hsv;
    private int results_start_adjust = 0;
    private int results_scroll_adjust = 0;

    final private int SWIPE_MIN_DISTANCE = 5;
    final private int SWIPE_THRESHOLD_VELOCITY = 300;

    public DisplayResultsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_display_results, container, false);

        // Get scroller
        //hsv = (HorizontalScrollView) view.findViewById(R.id.display_results_scroller);
        hsv = (HorizontalScrollView) view.findViewById(R.id.display_results_scroller);

        ma = (MainActivity) new cleanActivity().getActivity();

        results_scroll_adjust = (int) getResources().getDimension(R.dimen.results_scroll_adjust);

        mDetector = new GestureDetectorCompat(view.getContext(), new FirstScreenGestureListener(hsv,view.getContext(),results_scroll_adjust));

        //Set scroller on touch listener
        HandleTouch ht = new HandleTouch(mDetector, ma, view.getContext(),results_scroll_adjust);
        hsv.setOnTouchListener(ht);

        //Make changes to inital view
        ViewGroup vg = (ViewGroup) view.findViewById(R.id.results);
        InitialViewSetup ivs = new InitialViewSetup();

        ivs.surroundViewWithBorder(vg);

        results_start_adjust = (int) getResources().getDimension(R.dimen.results_start_adjust);
        ivs.scrollViewBy(hsv, results_start_adjust);

        return view;
    }

    class cleanActivity
    {
        public Activity getActivity()
        {
            Context context = view.getContext();
            while (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    return (Activity)context;
                }
                context = ((ContextWrapper)context).getBaseContext();
            }
            return null;
        }
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
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
        public void onDisplayAreaClicked();
    }

}
