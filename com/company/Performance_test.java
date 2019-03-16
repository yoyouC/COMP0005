package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Performance_test {
    private ArrayList<ArrayList<Integer>> list_of_array = new ArrayList<ArrayList<Integer>>();
    public long[] size = {100000, 300000, 600000, 1000000, 2000000, 4000000, 6000000, 8000000, 10000000};
    public ArrayList<Long> size_ = new ArrayList<>();
    private Random random = new Random();

    private void initialize_size()
    {
        for(long i : size)
        {
            size_.add(i);
        }
    }

    public void generate_array()
    {
        initialize_size();
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

    private void run_Quicksort()
    {
        System.out.println("Quick Sort");
        System.out.println("----------------------------------------");
    }

    private void run_Heapsort()
    {
        System.out.println("Heap Sort");
        System.out.println("----------------------------------------");
    }

    public ArrayList<Long> generate_Quicksort_time_array()
    {
        ArrayList<Long> QuickSortTime = new ArrayList<>();

        return QuickSortTime;
    }

    public ArrayList<Long> generate_HeapSort_time_array()
    {
        ArrayList<Long> HeapSortTime = new ArrayList<>();
        return HeapSortTime;
    }

    public void run()
    {
        for(int counter = 0; counter < 10 ; counter++)
        {
            generate_array();
            run_Quicksort();
            run_Heapsort();
            list_of_array.clear();
        }
    }

    public static void main (String arg[])
    {
        Performance_test test = new Performance_test();
        test.run();
    }

}
