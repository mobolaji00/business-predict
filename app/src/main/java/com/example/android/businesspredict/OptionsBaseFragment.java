package com.example.android.businesspredict;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OptionsBaseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class OptionsBaseFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private View view;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;


    public OptionsBaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.options_pager_fragment, container, false);

        List<Fragment> fragments = getOptionsFragments();
        mPagerAdapter = new MyPageAdapter(getFragmentManager(),fragments);
        mPager = (ViewPager)view.findViewById(R.id.view_options_pager);
        mPager.setAdapter(mPagerAdapter);

        /*
        InitialViewSetup ivs = new InitialViewSetup();
        ivs.createSpinners(view, this.getContext());
        */

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
        public void onOptionsAreaClicked();
    }

    private List<Fragment> getOptionsFragments()
    {
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(CreateOptionsFragments.newInstance("page_1"));
        fList.add(CreateOptionsFragments.newInstance("page_1"));
        fList.add(CreateOptionsFragments.newInstance("page_1"));
        return fList;
    }

}
