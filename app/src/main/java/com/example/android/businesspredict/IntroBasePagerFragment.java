package com.example.android.businesspredict;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by mobolajioo on 5/31/17.
 */

public class IntroBasePagerFragment extends Fragment {

    private IntroBasePagerFragment.OnFragmentInteractionListener mListener;
    private View view;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    public IntroBasePagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.intro_base_pager_fragment, container, false);

        ArrayList<Fragment> fragments = getIntrosFragments();
        mPagerAdapter = new MyPageAdapter(getFragmentManager(),fragments);
        mPager = (ViewPager)view.findViewById(R.id.intro_base_pager);
        mPager.setAdapter(mPagerAdapter);
        mPager.setOffscreenPageLimit(5);

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
        if (context instanceof IntroBasePagerFragment.OnFragmentInteractionListener) {
            mListener = (IntroBasePagerFragment.OnFragmentInteractionListener) context;
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
    }

    private ArrayList<Fragment> getIntrosFragments()
    {
        ArrayList<Fragment> fList = new ArrayList<Fragment>();
        fList.add(IntrosPageFragment.newInstance("intro_text"));
        fList.add(IntrosPageFragment.newInstance("intro_graph_1"));
        fList.add(IntrosPageFragment.newInstance("intro_graph_2"));
        return fList;
    }

}
