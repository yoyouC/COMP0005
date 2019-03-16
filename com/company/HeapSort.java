package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class HeapSort {
    public static long swap = 0;
    public static long comparison = 0;

    public static void heapify(ArrayList<Integer> array, int n, int i) {
        int max, child;
        child = 2 * i + 1;
        max = i;
        comparison++;
        if (child < n) {
            comparison++;
            if (array.get(child) > array.get(max))
                max = child;
        }
        comparison++;
        if (child + 1 < n) {
            comparison++;
            if (array.get(child + 1) > array.get(max))
                max = child + 1;
        }
        comparison++;
        if (max != i) {
            Collections.swap(array, max, i);
            swap++;
            heapify(array, n, max);
        }
    }

    public static void buildheap(ArrayList<Integer> array) {
        for (int i = array.size() / 2 - 1; i >= 0; i--) {
            comparison++;
            heapify(array, array.size(), i);
        }
        comparison++;
    }

    public static void heap(ArrayList<Integer> array) {
        buildheap(array);
        for (int i = array.size() - 1; i >= 1; i--) {
            Collections.swap(array, i, 0);
            swap++;
            comparison++;
            heapify(array, i, 0);
        }
        comparison++;
    }
}