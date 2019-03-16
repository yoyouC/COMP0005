package com.company;

import java.util.ArrayList;
import java.util.Random;

public class model {
    private ArrayList<ArrayList<Integer>> list_of_array = new ArrayList<ArrayList<Integer>>();
    private long[] size_not_use = {100000, 300000, 600000, 1000000, 2000000};
    public ArrayList<Long> size = new ArrayList<>();
    private Random random = new Random();

    public ArrayList<ArrayList<Long>> QuickSort_time_list = new ArrayList<>();
    public ArrayList<ArrayList<Long>> QuickSort_swapAndcomp_list = new ArrayList<>();
    public ArrayList<ArrayList<Long>> QuickSort_swap_list = new ArrayList<>();
    public ArrayList<ArrayList<Long>> QuickSort_comparison_list = new ArrayList<>();

    public ArrayList<ArrayList<Long>> HeapSort_time_list = new ArrayList<>();
    public ArrayList<ArrayList<Long>> HeapSort_swapAndcomp_list = new ArrayList<>();
    public ArrayList<ArrayList<Long>> HeapSort_swap_list = new ArrayList<>();
    public ArrayList<ArrayList<Long>> HeapSort_comparison_list = new ArrayList<>();

    public ArrayList<Long> QuickSort_average_time = new ArrayList<>();
    public ArrayList<Long> HeapSort_average_time = new ArrayList<>();

    public ArrayList<Long> QuickSort_average_SwapAndComp = new ArrayList<>();
    public ArrayList<Long> HeapSort_average_SwapAndComp = new ArrayList<>();

    public ArrayList<Long> HeapSort_average_swap = new ArrayList<>();
    public ArrayList<Long> QuickSort_average_swap = new ArrayList<>();

    public ArrayList<Long> HeapSort_average_comparison = new ArrayList<>();
    public ArrayList<Long> QuickSort_average_comparison = new ArrayList<>();

    public ArrayList<Long> QuickSort_Time_SD = new ArrayList<>();
    public ArrayList<Long> HeapSort_Time_SD = new ArrayList<>();

    public ArrayList<Long> QuickSort_swapAndcomp_SD = new ArrayList<>();
    public ArrayList<Long> HeapSort_swapAndcomp_SD = new ArrayList<>();

    public ArrayList<Long> QuickSort_Swap_SD = new ArrayList<>();
    public ArrayList<Long> HeapSort_Swap_SD = new ArrayList<>();

    public ArrayList<Long> QuickSort_Comparison_SD = new ArrayList<>();
    public ArrayList<Long> HeapSort_Comparison_SD = new ArrayList<>();

    public void getAverage()
    {
        for(int i = 0; i < QuickSort_time_list.get(0).size(); i++)
        {
            Long average_time = 0L;
            Long average_compAndSwap = 0L;
            Long average_swap = 0L;
            Long average_comparison = 0L;
            for(ArrayList<Long> time_array : QuickSort_time_list)
            {
                average_time = average_time + time_array.get(i);
            }
            for(ArrayList<Long> compAndswapArray : QuickSort_swapAndcomp_list)
            {
                average_compAndSwap = average_compAndSwap + compAndswapArray.get(i);
            }
            for(ArrayList<Long> swapArray: QuickSort_swap_list)
            {
                average_swap = average_swap + swapArray.get(i);
            }
            for(ArrayList<Long> comparisonArray : QuickSort_comparison_list)
            {
                average_comparison = average_comparison + comparisonArray.get(i);
            }
            average_time = average_time / QuickSort_time_list.size();
            average_compAndSwap = average_compAndSwap / QuickSort_swapAndcomp_list.size();
            average_swap = average_swap / QuickSort_swap_list.size();
            average_comparison = average_comparison / QuickSort_comparison_list.size();
            QuickSort_average_time.add(average_time);
            QuickSort_average_SwapAndComp.add(average_compAndSwap);
            QuickSort_average_swap.add(average_swap);
            QuickSort_average_comparison.add(average_comparison);
        }
        for(int i = 0; i < HeapSort_time_list.get(0).size(); i++)
        {
            Long average_time = 0L;
            Long average_compAndSwap = 0L;
            Long average_swap = 0L;
            Long average_comparison = 0L;
            for(ArrayList<Long> time_array : HeapSort_time_list)
            {
                average_time = average_time + time_array.get(i);
            }
            for(ArrayList<Long> compAndswapArray : HeapSort_swapAndcomp_list)
            {
                average_compAndSwap =  average_compAndSwap + compAndswapArray.get(i);
            }
            for(ArrayList<Long> swapArray : HeapSort_swap_list)
            {
                average_swap = average_swap + swapArray.get(i);
            }
            for(ArrayList<Long> comparisonArray : HeapSort_comparison_list)
            {
                average_comparison = average_comparison + comparisonArray.get(i);
            }
            average_time = average_time / HeapSort_time_list.size();
            average_compAndSwap = average_compAndSwap / HeapSort_swapAndcomp_list.size();
            average_swap = average_swap / HeapSort_swap_list.size();
            average_comparison = average_comparison / HeapSort_comparison_list.size();
            HeapSort_average_time.add(average_time);
            HeapSort_average_SwapAndComp.add(average_compAndSwap);
            HeapSort_average_swap.add(average_swap);
            HeapSort_average_comparison.add(average_comparison);
        }
    }

    public void get_SD()
    {
        for(int i = 0; i < QuickSort_time_list.get(0).size(); i++)
        {
            Long Time_SD = 0L;
            Long swapAndcomp_SD = 0L;
            Long Swap_SD = 0L;
            Long Comparison_SD = 0L;
            for(ArrayList<Long> time_array : QuickSort_time_list)
            {
                Time_SD = Time_SD + (time_array.get(i) - QuickSort_average_time.get(i)) * (time_array.get(i) - QuickSort_average_time.get(i));
            }
            for(ArrayList<Long> swapAndcomp_array : QuickSort_swapAndcomp_list)
            {
                swapAndcomp_SD = swapAndcomp_SD + (swapAndcomp_array.get(i) - QuickSort_average_SwapAndComp.get(i)) * (swapAndcomp_array.get(i) - QuickSort_average_SwapAndComp.get(i));
            }
            for(ArrayList<Long> Swap_array : QuickSort_swap_list)
            {
                Swap_SD = Swap_SD + (Swap_array.get(i) - QuickSort_average_swap.get(i)) * (Swap_array.get(i) - QuickSort_average_swap.get(i));
            }
            for(ArrayList<Long> Comparison_array : QuickSort_comparison_list)
            {
                Comparison_SD = Comparison_SD + (Comparison_array.get(i) - QuickSort_average_comparison.get(i)) * (Comparison_array.get(i) - QuickSort_average_comparison.get(i));
            }
            Time_SD = Math.round(Math.sqrt(Time_SD / QuickSort_time_list.size()));
            swapAndcomp_SD = Math.round((Math.sqrt(swapAndcomp_SD/QuickSort_swapAndcomp_list.size())));
            Swap_SD = Math.round(Math.sqrt(Swap_SD/QuickSort_swap_list.size()));
            Comparison_SD = Math.round(Math.sqrt(Comparison_SD/QuickSort_comparison_list.size()));
            QuickSort_Time_SD.add(Time_SD);
            QuickSort_swapAndcomp_SD.add(swapAndcomp_SD);
            QuickSort_Swap_SD.add(Swap_SD);
            QuickSort_Comparison_SD.add(Comparison_SD);
        }
        for(int i = 0; i < HeapSort_time_list.get(0).size(); i++)
        {
            Long SD = 0L;
            Long swapAndcomp_SD = 0L;
            Long Swap_SD = 0L;
            Long Comparison_SD = 0L;
            for(ArrayList<Long> time_array : HeapSort_time_list)
            {
                SD = SD + (time_array.get(i) - HeapSort_average_time.get(i)) * (time_array.get(i) - HeapSort_average_time.get(i));
            }
            for(ArrayList<Long> swapAndcomp_array : HeapSort_swapAndcomp_list)
            {
                swapAndcomp_SD = swapAndcomp_SD + (swapAndcomp_array.get(i) - HeapSort_average_SwapAndComp.get(i)) * (swapAndcomp_array.get(i) - HeapSort_average_SwapAndComp.get(i));
            }
            for(ArrayList<Long> Swap_array : HeapSort_swap_list)
            {
                Swap_SD = Swap_SD + (Swap_array.get(i) - HeapSort_average_swap.get(i)) * (Swap_array.get(i) - HeapSort_average_swap.get(i));
            }
            for(ArrayList<Long> Comparison_array : HeapSort_comparison_list)
            {
                Comparison_SD = Comparison_SD + (Comparison_array.get(i) - HeapSort_average_comparison.get(i)) * (Comparison_array.get(i) - HeapSort_average_comparison.get(i));
            }
            SD = Math.round(Math.sqrt(SD / HeapSort_time_list.size()));
            swapAndcomp_SD = Math.round(Math.sqrt(swapAndcomp_SD/HeapSort_swapAndcomp_list.size()));
            Swap_SD = Math.round(Math.sqrt(Swap_SD/HeapSort_swap_list.size()));
            Comparison_SD = Math.round(Math.sqrt(Comparison_SD/HeapSort_comparison_list.size()));
            HeapSort_Time_SD.add(SD);
            HeapSort_swapAndcomp_SD.add(swapAndcomp_SD);
            HeapSort_Swap_SD.add(Swap_SD);
            HeapSort_Comparison_SD.add(Comparison_SD);
        }
    }

    private void initialize_size_array()
    {
        for(long i : size_not_use)
        {
            size.add(i);
        }
    }

    public void generate_array()
    {
        for(long i : size)
        {
            ArrayList<Integer> array = new ArrayList<>();
            for(int counter = 0; counter < i; counter ++)
            {
                array.add(random.nextInt());
            }
            list_of_array.add(array);
        }
    }

    public void generate_QuickSort_array()
    {
    ArrayList<Long> QuickSort_time = new ArrayList<>();
    ArrayList<Long> QuickSort_swap = new ArrayList<>();
    ArrayList<Long> QuickSort_comparison = new ArrayList<>();
    ArrayList<Long> QuickSort_swapAndcomp = new ArrayList<>();
        for(ArrayList<Integer> array : list_of_array)
        {
            long startTime = System.currentTimeMillis();
            QuickSort.quickSort(array,0,array.size() - 1);
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime);
            QuickSort_time.add(duration);
            QuickSort_swap.add(QuickSort.swap);
            QuickSort_comparison.add(QuickSort.comparison);
            QuickSort_swapAndcomp.add(QuickSort.swap + QuickSort.comparison);
            QuickSort.swap = 0;
            QuickSort.comparison = 0;
        }
        QuickSort_time_list.add(QuickSort_time);
        QuickSort_swap_list.add(QuickSort_swap);
        QuickSort_comparison_list.add(QuickSort_comparison);
        QuickSort_swapAndcomp_list.add(QuickSort_swapAndcomp);
    }

    public void generate_HeapSort_array()
    {
        ArrayList<Long> HeapSort_time = new ArrayList<>();
        ArrayList<Long> HeapSort_swap = new ArrayList<>();
        ArrayList<Long> HeapSort_comparison = new ArrayList<>();
        ArrayList<Long> HeapSort_swapAndcomp = new ArrayList<>();
        for(ArrayList<Integer> array : list_of_array)
        {
            long startTime = System.currentTimeMillis();
            HeapSort.heap(array);
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime);
            HeapSort_time.add(duration);
            HeapSort_swap.add(HeapSort.swap);
            HeapSort_comparison.add(HeapSort.comparison);
            HeapSort_swapAndcomp.add(HeapSort.swap + HeapSort.comparison);
            HeapSort.swap = 0;
            HeapSort.comparison = 0;
        }
        HeapSort_time_list.add(HeapSort_time);
        HeapSort_swap_list.add(HeapSort_swap);
        HeapSort_comparison_list.add(HeapSort_comparison);
        HeapSort_swapAndcomp_list.add(HeapSort_swapAndcomp);
    }

    public void run_once()
    {
        generate_array();
        generate_QuickSort_array();
        generate_HeapSort_array();
        list_of_array.clear();
    }

    public void run_10()
    {
        initialize_size_array();
        for(int i = 0; i < 10; i++)
        {
            run_once();
        }
    }

    public static void main (String arg[])
    {
        model test = new model();
        test.run_once();
    }
}
