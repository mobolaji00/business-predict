package com.example.android.businesspredict;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by mobolajioo on 5/22/17.
 */

public class UserInputCheck {

    private LinkedHashMap<String,View> answers;
    private LinkedHashMap<String,View> questions;

    private HashMap<String,String> checkedAnswers = new HashMap<String, String>();
    private double[] answersAsDoubles;

    private Context context;

    private int red = 0;
    private int black = 0;


    public UserInputCheck()
    {

    }

    public UserInputCheck(LinkedHashMap<String,View> answers, LinkedHashMap<String,View> questions, Context context)
    {
        this.context = context;

        this.answers = answers;
        this.questions = questions;

        red = ContextCompat.getColor(context,R.color.red);
        black = ContextCompat.getColor(context,R.color.black);

        answersAsDoubles = new double[answers.size()];
    }

    public boolean areAllQuestionsAnswered()
    {
        EditText et;

        RadioGroup rg;
        RadioButton rb;
        int rbid;

        TextView tv;
        Spinner s;

        String answerText;

        for (HashMap.Entry<String, View> entry : answers.entrySet())
        {
            String k = entry.getKey();
            View v = entry.getValue();

            if (v instanceof EditText)
            {
                et = (EditText)v;
                answerText = et.getText().toString().trim();

                if(answerText.isEmpty() || answerText.length() == 0 || answerText.equals("") || answerText == null)
                    changeQuestionTextColor(k,red);
                else
                {
                    changeQuestionTextColor(k, black);
                    checkedAnswers.put(k,answerText);
                }

            }

            else if (v instanceof RadioGroup)
            {
                rg = (RadioGroup) v;
                rbid = rg.getCheckedRadioButtonId();

                if (rbid == -1)
                    changeQuestionTextColor(k,red);
                else
                {
                    changeQuestionTextColor(k, black);
                    rb = (RadioButton) rg.findViewById(rbid);
                    answerText = rb.getText().toString();
                    checkedAnswers.put(k,answerText);
                }
            }

            else if (v instanceof Spinner)
            {
                s = (Spinner) v;
                tv = (TextView) s.getSelectedView();
                answerText = tv.getText().toString().trim();

                if(answerText.isEmpty() || answerText.length() == 0 || answerText.equals("") || answerText == null)
                    changeQuestionTextColor(k,red);
                else
                {
                    changeQuestionTextColor(k, black);
                    checkedAnswers.put(k,answerText);
                }
            }

        }


        for (HashMap.Entry<String, String> entry : checkedAnswers.entrySet())
        {
            String k = entry.getKey();
            String v = entry.getValue();

            if (v.isEmpty() || v.length() == 0 || v.equals("") || v == null)
                return false;
        }

        return true;
    }

    private void changeQuestionTextColor(String k,int color)
    {
        TextView tv = (TextView) questions.get(k);
        tv.setTextColor(color);
    }

    public boolean doAnswersMakeSense()
    {
        int perc_sales_indiv = Integer.parseInt(checkedAnswers.get("perc_sales_indiv"));
        int perc_sales_bus = Integer.parseInt(checkedAnswers.get("perc_sales_bus"));
        int perc_sales_govt = Integer.parseInt(checkedAnswers.get("perc_sales_govt"));

        if(perc_sales_indiv+perc_sales_bus+perc_sales_govt > 100)
        {
            changeQuestionTextColor("perc_sales_indiv",red);
            changeQuestionTextColor("perc_sales_bus",red);
            changeQuestionTextColor("perc_sales_govt",red);
            return false;
        }
        else
            return true;
    }

    public double[] getCheckedAnswers(String[] namesOfDataInOrder)
    {





        for (int i = 0; i < answersAsDoubles.length; i++)
        {
           // answersAsDoubles[i] =
        }


        //return new double [] {checkedAnswers.values()};

        return new double[] {0};
    }

}
