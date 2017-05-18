package com.example.android.businesspredict;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements
        ResultsBaseFragment.OnFragmentInteractionListener,
        OptionsBaseFragment.OnFragmentInteractionListener,
        AnalyzeButtonFragment.OnFragmentInteractionListener{

    private ResultsBaseFragment drf;
    private OptionsBaseFragment cof;
    private AnalyzeButtonFragment abf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drf = new ResultsBaseFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.top_fragment, drf,"results_pager_fragment").commit();

        cof = new OptionsBaseFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.middle_fragment, cof,"options_pager_fragment").commit();

        abf = new AnalyzeButtonFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.bottom_fragment, abf,"analyze_button_fragment").commit();
    }

    public void onDisplayAreaClicked()
    {


    }

    public void onOptionsAreaClicked()
    {


    }

    public void onAnalyzeButtonClicked()
    {


    }


    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }
}
