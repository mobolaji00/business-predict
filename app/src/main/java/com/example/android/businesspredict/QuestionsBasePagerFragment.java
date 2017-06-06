package com.example.android.businesspredict;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedHashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestionsBasePagerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class QuestionsBasePagerFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private View view;

    private ViewPager mPager;
    private MyPageAdapter mPagerAdapter;

    private LinkedHashMap<String,Fragment> fMap;

    private String pg1;
    private String pg2;
    private String pg3;
    private String pg4;
    private String pg5;
    private String pg6;
    private String pg7;
    private String pg8;
    private String pg9;
    private String pg10;
    private String pg11;
    private String pg12;

    private String pg_1_spin_id_1;
    private String pg_1_spin_id_2;

    public QuestionsBasePagerFragment() {
        // Required empty public constructor
    }

    private void initializeResourceNames()
    {
        pg1 = getResources().getString(R.string.page_1);
        pg2 = getResources().getString(R.string.page_2);
        pg3 = getResources().getString(R.string.page_3);
        pg4 = getResources().getString(R.string.page_4);
        pg5 = getResources().getString(R.string.page_5);
        pg6 = getResources().getString(R.string.page_6);
        pg7 = getResources().getString(R.string.page_7);
        pg8 = getResources().getString(R.string.page_8);
        pg9 = getResources().getString(R.string.page_9);
        pg10 = getResources().getString(R.string.page_10);
        pg11 = getResources().getString(R.string.page_11);
        pg12 = getResources().getString(R.string.page_12);

        pg_1_spin_id_1 = "number_of_owners_spinner";
        pg_1_spin_id_2 = "number_of_owner_operators_spinner";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.questions_base_pager_fragment, container, false);

        initializeResourceNames();

        ArrayList<Fragment> fragments = getQuestionsFragments();
        mPagerAdapter = new MyPageAdapter(getChildFragmentManager(),fragments);
        mPager = (ViewPager)view.findViewById(R.id.questions_base_pager);
        mPager.setAdapter(mPagerAdapter);
        mPager.setOffscreenPageLimit(11);

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

    private ArrayList<Fragment> getQuestionsFragments()
    {
        fMap = new LinkedHashMap<String, Fragment>();

        fMap.put(pg1, QandAPageFragment.newInstance(pg1,new String[] {pg_1_spin_id_1,pg_1_spin_id_2}));
        fMap.put(pg2, QandAPageFragment.newInstance(pg2,new String[] {}));
        fMap.put(pg3, QandAPageFragment.newInstance(pg3,new String[] {}));
        fMap.put(pg4, QandAPageFragment.newInstance(pg4,new String[] {}));
        fMap.put(pg5, QandAPageFragment.newInstance(pg5,new String[] {}));
        fMap.put(pg6, QandAPageFragment.newInstance(pg6,new String[] {}));
        fMap.put(pg7, QandAPageFragment.newInstance(pg7,new String[] {}));
        fMap.put(pg8, QandAPageFragment.newInstance(pg8,new String[] {}));
        fMap.put(pg9, QandAPageFragment.newInstance(pg9,new String[] {}));
        fMap.put(pg10, QandAPageFragment.newInstance(pg10,new String[] {}));
        fMap.put(pg11, QandAPageFragment.newInstance(pg11,new String[] {}));
        fMap.put(pg12, QandAPageFragment.newInstance(pg12,new String[] {}));

        return new ArrayList<Fragment>(fMap.values());
    }

    public LinkedHashMap<String,View> getViewsFromFragments(String viewTag)
    {
        ArrayList<QandAPageFragment> childrenFragments = mPagerAdapter.getFragments();
        LinkedHashMap<String,View> views = new LinkedHashMap<String,View>();

        for (QandAPageFragment child : childrenFragments)
        {
            views.putAll(child.getQuestionsViewsFromPage(viewTag));
        }

        return views;
    }

}
