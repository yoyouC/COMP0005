package com.company;

import static java.lang.Math.*;

class Algorithms {
    private static final double S = 16;
    private static final double Pd = 0.90;
    private static final double Occlusion = 16;

    public double cost(int z1,int z2)
    {
        double z = (z1 + z2) / 2;
        return ((1.0 / 2) * (z - z1) * (z - z1) / S) + ((1.0 / 2) * (z - z2) * (z - z2) / S);
    }

    public double[][] generate_cost_matrix(int[] Row1, int[] Row2)
    {
        double[][] cost_matrix = new double[Row1.length][Row2.length];
        for(int j = 0; j < Row2.length; j++)
        {
            cost_matrix[j][0] = (j * Occlusion);
        }
        for(int i = 1; i < Row1.length; i++)
        {
            cost_matrix[0][i] = i * Occlusion;
        }
        for(int i = 1; i < Row1.length; i++)
        {
            for(int j = 1; j < Row2.length; j++)
            {
                double cost = min((cost_matrix[i][j-1] + Occlusion), (cost_matrix[i-1][j] +Occlusion),
                        (cost_matrix[i-1][j-1] +  cost(Row1[i], Row2[j])));
                cost_matrix[i][j] = cost;
            }
        }
        return cost_matrix;
    }

    public double[] generatematcharr(double[][] cost_matrix){
        double[] match = new double[cost_matrix[0].length];
        int i = cost_matrix.length-1;
        int j = cost_matrix.length-1;
        while(i > 0 && j > 0)
        {
            if(cost_matrix[i][j] - Occlusion == cost_matrix[i][j-1] && !(cost_matrix[i][j] - Occlusion == cost_matrix[i-1][j]))
            {
                j = j - 1;
            }
            else if(cost_matrix[i][j] - Occlusion == cost_matrix[i-1][j] &&  !(cost_matrix[i][j] - Occlusion == cost_matrix[i][j-1]))
            {
                i = i - 1;
            }
            else
            {
                match[i] = j;
                i = i - 1;
                j = j - 1;
            }
        }
        return match;
    }

    public double[] generate_match_array(double[][] cost_matrix){
        double[] match_array = new double[cost_matrix.length];
        for(int x = 0; x < cost_matrix.length; x++)
        {
            match_array[x] = -1;
        }
        int i = cost_matrix.length-1;
        int j = cost_matrix.length-1;
        while(i > 0 && j > 0)
        {
            if(cost_matrix[i][j] - Occlusion == cost_matrix[i][j-1] && i > 0)
            {
                j = j - 1;
            }
            else if(cost_matrix[i][j] - Occlusion == cost_matrix[i-1][j] && i > 0)
            {
                i = i - 1;
            }
            else
            {
                match_array[i] = j;
                i = i - 1;
                j = j - 1;
            }
        }
        return match_array;
    }

    public double min(double x, double y ,double z){
        if (x < y && x < z){
            return x;
        }else if (y < x && y < z){
            return y;
        }
        return z;
    }

    public double[] generate_disparity_array(double[] match_array)
    {
        double[] disparity_array = new double[match_array.length];
        for(int i = 0; i < match_array.length; i++)
        {
        if( match_array[i] == -1)
            {
                disparity_array[i] = 255;
            }
            else
            {
                disparity_array[i] = abs(i - match_array[i]) * 3;
            }
        }
        return disparity_array;
    }
}

