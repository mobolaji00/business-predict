package com.example.android.businesspredict;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements
        DisplayResultsFragment.OnFragmentInteractionListener,
        ChooseOptionsFragment.OnFragmentInteractionListener,
        AnalyzeButtonFragment.OnFragmentInteractionListener{

    private DisplayResultsFragment drf;
    private ChooseOptionsFragment cof;
    private AnalyzeButtonFragment abf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drf = new DisplayResultsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.top_fragment, drf,"fragment_display_results").commit();

        cof = new ChooseOptionsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.middle_fragment, cof,"fragment_choose_options").commit();

        abf = new AnalyzeButtonFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.bottom_fragment, abf,"fragment_analyze_button").commit();
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
