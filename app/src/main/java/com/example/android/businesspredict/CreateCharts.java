package com.example.android.businesspredict;

import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.businesspredict.R.color.black;
import static com.example.android.businesspredict.R.color.red;


/**
 * Created by mobolajioo on 5/31/17.
 */

public class CreateCharts {

    private View view;

    public CreateCharts()
    {

    }

    public CreateCharts(View view)
    {

        this.view = view;
    }

    public View setUpLineChart(double[] X, double[] Y)
    {
        LineChart chart = (LineChart) view.findViewById(R.id.chart_1);

        List<Entry> entries = new ArrayList<Entry>();

        for (int i = 0; i < X.length; i++)
        {
            entries.add(new Entry((float)X[i], (float)Y[i]));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Label");
        dataSet.setColor(red);
        dataSet.setValueTextColor(black);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate();

        return view;
    }

    public View setUpScatterChart(double[] X, double[] Y)
    {
        ScatterChart chart = (ScatterChart) view.findViewById(R.id.chart_1);

        List<Entry> entries = new ArrayList<Entry>();

        for (int i = 0; i < X.length; i++)
        {
            entries.add(new Entry((float)X[i], (float)Y[i]));
        }

        ScatterDataSet dataSet = new ScatterDataSet(entries, "Label");
        dataSet.setColor(red);
        dataSet.setValueTextColor(black);

        ScatterData lineData = new ScatterData(dataSet);
        chart.setData(lineData);
        chart.invalidate();

        return view;
    }

}
