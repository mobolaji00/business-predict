package com.example.android.businesspredict;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Created by mobolajioo on 5/30/17.
 */


public class LinearRegression {

    private static LinkedHashMap<String,double[]> data = new LinkedHashMap<String,double[]>();
    private static LinkedHashMap<String,double[]> extraneousData = new LinkedHashMap<String,double[]>();

    private final Context context;

    private final String [] namesOfExtraneousData = new String [] {"MPRID"};
    private String [] namesOfDataInOrder = new String [] {};

    private int numberOfExamples;
    private int numberOfFeaturesPlusOne;

    private double[] Y = new double[numberOfExamples];
    private double[] runningTheta;
    private double[] optimizedTheta;

    private double [][] X_by_Features;
    private double [][] X_by_Examples;

    private double[] hypothesis;
    private double cost;

    private double alpha = 0.0001;
    private final int iterations = 1500;



    public LinearRegression(Context context)
    {
        this.context = context;
        readDataFromFile();

        setY("A10_Out_Of_Business_2");
        seperateExtraneousData(namesOfExtraneousData);
        setNamesOfDataInOrder();

        numberOfExamples = Y.length;
        numberOfFeaturesPlusOne = data.size()+1;

        runningTheta = new double[numberOfFeaturesPlusOne];

        //createX();

        //optimizedTheta = optimizeTheta();

        double temp2 = predictY(runningTheta, runningTheta);
    }

    public static double[] getFeature(String featureName)
    {
        return data.get(featureName);
    }

    private double[] optimizeTheta()
    {
        for (int i = 0; i < iterations; i++)
        {
            runningTheta = gradientDescent(runningTheta, X_by_Features, Y, alpha);
        }
        return runningTheta;
    }

    private void setY(String nameOfY)
    {
        Y = data.get(nameOfY);
    }

    private void seperateExtraneousData(String [] namesOfExtraneousData)
    {
        for (String name : namesOfExtraneousData)
        {
            extraneousData.put(name,data.get(name));
            data.remove(name);
        }
    }

    private void readDataFromFile()
    {

        Resources res = context.getResources();
        InputStream inputStream = res.openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        int i = 0;

        try
        {
            while ((line = reader.readLine()) != null)//&& i < 10
            {
                String[] splitData = line.split(" ");


                String[] numberStrs = Arrays.copyOfRange(splitData, 1, splitData.length);
                double[] numbers = new double[numberStrs.length];

                for(int j = 0;j < numberStrs.length; j++)
                {
                    numbers[j] = Double.parseDouble(numberStrs[j]);
                }

                data.put(splitData[0],numbers);

                i++;
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void createX()
    {
        X_by_Features = new double[numberOfFeaturesPlusOne][numberOfExamples];
        X_by_Examples = new double[numberOfExamples][numberOfFeaturesPlusOne];

        double []examples = new double[numberOfExamples];
        for (int l = 0; l < examples.length; l++)
        {
            examples[l] = 1;
        }
        X_by_Features[0] = examples;

        ArrayList listX = new ArrayList<double[]>(data.values());

        for (int i = 1; i < numberOfFeaturesPlusOne; i++)
        {
            examples = (double[]) listX.get(i);
            X_by_Features[i] = examples;
        }


        for (int j = 0; j < numberOfFeaturesPlusOne; j++)
        {
            for (int k = 0; k < numberOfExamples; k++)
            {
                X_by_Examples[k][j] = X_by_Features[j][k];
            }
        }

    }

    private double[] getHypothesis(double [] theta, double[][] X)
    {
        double [] hypothesis = new double[numberOfExamples];

        int i = 0;
        for (double[] x_arr: X)
        {
            for (int j = 0; j < theta.length;j++)
            {
                hypothesis[i]+=theta[j]*x_arr[j];
            }
            i++;
        }

        return hypothesis;
    }

    private double costJ(double[] hypothesis, double[] Y)
    {
        double cost = 0;
        double[] cost_arr = new double[numberOfExamples];

        for (int i = 0; i < numberOfExamples; i++)
        {
            cost_arr[i] = Math.pow((hypothesis[i] - Y[i]),2);
        }

        for (int j = 0; j < numberOfExamples; j++)
        {
            cost+=cost_arr[j];
        }

        cost = cost/(2*numberOfExamples);

        return cost;
    }

    private double[] gradientDescent(double[] theta, double[][]X, double[]Y, double alpha)
    {
        double[] new_theta = new double[numberOfFeaturesPlusOne];
        double[] diffOfYAndHypothesis = new double[numberOfExamples];

        double [] holder_1;
        double [] holder_2 = new double[numberOfFeaturesPlusOne];

        double [] hypothesis = getHypothesis(theta,X);

        for (int i = 0; i < numberOfExamples; i++)
        {
            diffOfYAndHypothesis[i] = hypothesis[i] - Y[i];
        }

        for (int j = 0; j < numberOfFeaturesPlusOne; j++)
        {
            holder_1 = X[j];
            for (int k = 0; k < numberOfExamples; k++)
            {
                holder_2[j] += holder_1[k] * diffOfYAndHypothesis[k];
            }

            holder_2[j] = holder_2[j] * (alpha/numberOfExamples);
            new_theta[j] = theta[j] - holder_2[j];
        }

        return new_theta;
    }

    public double predictY(double [] X, double [] theta)
    {
        double y = 0;

        for (int i = 0; i < numberOfFeaturesPlusOne; i++)
        {
            y += X[i]*theta[i];
        }

        return y;
    }

    private void setNamesOfDataInOrder()
    {
        namesOfDataInOrder = data.keySet().toArray(new String[0]);
    }

    public String[] getNamesOfDataInOrder()
    {
        return namesOfDataInOrder;
    }

}
