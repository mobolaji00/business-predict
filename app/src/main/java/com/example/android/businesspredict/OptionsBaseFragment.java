package com.example.android.businesspredict;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    private MyPageAdapter mPagerAdapter;

    private HashMap<String,Fragment> fMap;

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

    private String pg_1_spin_id_1;
    private String pg_1_spin_id_2;

    public OptionsBaseFragment() {
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

        pg_1_spin_id_1 = "number_of_owners_spinner";
        pg_1_spin_id_2 = "number_of_owner_operators_spinner";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.options_pager_fragment, container, false);

        initializeResourceNames();

        List<Fragment> fragments = getOptionsFragments();
        mPagerAdapter = new MyPageAdapter(getChildFragmentManager(),fragments);
        mPager = (ViewPager)view.findViewById(R.id.options_pager);
        mPager.setAdapter(mPagerAdapter);

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
        public ArrayList provideUsersInput();
    }

    private List<Fragment> getOptionsFragments()
    {
        fMap = new HashMap<String, Fragment>();

        fMap.put(pg1, CreateOptionsFragment.newInstance(pg1,new String[] {pg_1_spin_id_1,pg_1_spin_id_2}));
        fMap.put(pg2, CreateOptionsFragment.newInstance(pg2,new String[] {}));
        fMap.put(pg3, CreateOptionsFragment.newInstance(pg3,new String[] {}));
        fMap.put(pg4, CreateOptionsFragment.newInstance(pg4,new String[] {}));
        fMap.put(pg5, CreateOptionsFragment.newInstance(pg5,new String[] {}));
        fMap.put(pg6, CreateOptionsFragment.newInstance(pg6,new String[] {}));
        fMap.put(pg7, CreateOptionsFragment.newInstance(pg7,new String[] {}));
        fMap.put(pg8, CreateOptionsFragment.newInstance(pg8,new String[] {}));
        fMap.put(pg9, CreateOptionsFragment.newInstance(pg9,new String[] {}));
        fMap.put(pg10, CreateOptionsFragment.newInstance(pg10,new String[] {}));
        fMap.put(pg11, CreateOptionsFragment.newInstance(pg11,new String[] {}));

        return new ArrayList<Fragment>(fMap.values());
    }

    private void childFragments()
    {
        /*
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        int index = 0;

        for (Map.Entry<String, Fragment> entry : fMap.entrySet())
        {
            String key = entry.getKey();
            Fragment value = (CreateOptionsFragment) entry.getValue();

            int frag_res_id = getContext().getResources().getIdentifier(key,"layout", getContext().getPackageName());

            transaction.add(frag_res_id, value);

            CreateOptionsFragment fragment = (CreateOptionsFragment) mPagerAdapter.getRegisteredFragment(index);

            index = index + 1;

        }

        transaction.commit();
        */

        int index = 0;

        for (Map.Entry<String, Fragment> entry : fMap.entrySet())
        {
            //CreateOptionsFragment fragment = (CreateOptionsFragment) mPagerAdapter.getRegisteredFragment(index);

            CreateOptionsFragment f = (CreateOptionsFragment) mPagerAdapter.getFragments().get(index);
            index = index + 1;

        }

    }


    /*
    public ArrayList<View> getT()
    {

    }
    */

    public ArrayList<View> getInputsFromFragments()
    {
        ArrayList<View> inputs = new ArrayList<View>();
        childFragments();


        /*
        int frag_res_id = getContext().getResources().getIdentifier("options_pager","layout", getContext().getPackageName());

        CreateOptionsFragment cof = (CreateOptionsFragment) getActivity().getSupportFragmentManager().findFragmentById(frag_res_id);


        for (Fragment f: obf.fMap.values())
        {
            inputs.addAll(f.usersInput());
        }
        */

        /*
        for (Map.Entry<String, Fragment> entry : fMap.entrySet())
        {
            String key = entry.getKey();
            Fragment value = (CreateOptionsFragment) entry.getValue();

            int frag_res_id = getContext().getResources().getIdentifier(key,"layout", getContext().getPackageName());
            //int frag_res_id = getContext().getResources().getIdentifier("options_pager","layout", getContext().getPackageName());

            //CreateOptionsFragment cof = (CreateOptionsFragment) getActivity().getSupportFragmentManager().findFragmentById(frag_res_id);

            OptionsBaseFragment obf = (OptionsBaseFragment) getChildFragmentManager().findFragmentById(frag_res_id);

            int i = 9;

            //inputs.addAll(obf.usersInput());

        }
        */

        return inputs;
    }

}
