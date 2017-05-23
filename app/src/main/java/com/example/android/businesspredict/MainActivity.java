package com.example.android.businesspredict;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        ResultsBaseFragment.OnFragmentInteractionListener,
        OptionsBaseFragment.OnFragmentInteractionListener,
        CreateOptionsFragment.OnFragmentInteractionListener,
        AnalyzeButtonFragment.OnFragmentInteractionListener{

    private ResultsBaseFragment rbf;
    private OptionsBaseFragment obf;
    private AnalyzeButtonFragment abf;
    private CreateOptionsFragment cof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //registerFragments();

        rbf = new ResultsBaseFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.top_fragment, rbf,"results_base_fragment").commit();

        obf = new OptionsBaseFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.middle_fragment, obf,"options_base_fragment").commit();

        abf = new AnalyzeButtonFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.bottom_fragment, abf,"analyze_button_fragment").commit();
    }

    public void onDisplayAreaClicked()
    {


    }

    public void onOptionsAreaClicked()
    {


    }

    public ArrayList<View> onAnalyzeButtonClicked()
    {
        ArrayList<View> fragmentsInputs = new ArrayList<View>();
        fragmentsInputs =  obf.getInputsFromFragments();
        return fragmentsInputs;
    }

    public ArrayList provideUsersInput()
    {
        return new ArrayList();

    }


    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

    /*
    public void registerFragments()
    {

    }
    */

}
