package com.example.android.businesspredict;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedHashMap;

import static com.example.android.businesspredict.R.color.red;

public class MainActivity extends AppCompatActivity implements
        ResultsBasePagerFragment.OnFragmentInteractionListener,
        QuestionsBasePagerFragment.OnFragmentInteractionListener,
        AnalyzeButtonFragment.OnFragmentInteractionListener,
        IntroBasePagerFragment.OnFragmentInteractionListener{

    private ResultsBasePagerFragment rbpf;
    private QuestionsBasePagerFragment qbpf;
    private AnalyzeButtonFragment abf;
    private IntroBasePagerFragment ibpf;

    private LinearRegression lr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lr = new LinearRegression(getApplicationContext());

        ibpf = new IntroBasePagerFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.top_fragment, ibpf, "intro_text").commit();

        qbpf = new QuestionsBasePagerFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.middle_fragment, qbpf, "options_base_fragment").commit();

        abf = new AnalyzeButtonFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.bottom_fragment, abf, "analyze_button_fragment").commit();
    }


    public void onAnalyzeButtonClicked() {
        LinkedHashMap<String, View> answers = qbpf.getViewsFromFragments(this.getResources().getString(R.string.answer));
        LinkedHashMap<String, View> questions = qbpf.getViewsFromFragments(this.getResources().getString(R.string.question));


        //comment out to test on reading regression data
        UserInputCheck checkedOut = new UserInputCheck(answers, questions, getApplicationContext());
        Snackbar mySnackbar;

        /*
        if (!checkedOut.areAllQuestionsAnswered())
        {
            mySnackbar = Snackbar.make(findViewById(R.id.top_fragment), R.string.unanswered_question_message, 900);
            mySnackbar = editSnackBar(mySnackbar);
            mySnackbar.show();
        }
        else if (!checkedOut.doAnswersMakeSense()) {
            mySnackbar = Snackbar.make(findViewById(R.id.top_fragment), R.string.percentage_greater_than_100_message, 900);
            mySnackbar = editSnackBar(mySnackbar);
            mySnackbar.show();
        }
        else
        {
            rbpf = new ResultsBasePagerFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.top_fragment, rbpf, "results_base_fragment").commit();
        }
        */

        double [] checkedAnswersAsDoubles = checkedOut.getCheckedAnswers(lr.getNamesOfDataInOrder());

    }

    public Snackbar editSnackBar(Snackbar mySnackbar)
    {
        View sbView = mySnackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));

        TextView sbTextView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        sbTextView.setTextColor(ContextCompat.getColor(getApplicationContext(), red));
        sbTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        sbTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        return mySnackbar;
    }


    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }


}
