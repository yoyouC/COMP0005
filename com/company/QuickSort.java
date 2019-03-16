package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuickSort {
    public static long swap = 0;
    public static long comparison = 0;

    public static int partition(ArrayList<Integer> array, int p, int r) {
        int x = array.get(r);
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (array.get(j) <= x) {
                i = i + 1;
                Collections.swap(array, i, j);
                swap++;
            }
            comparison = comparison + 2;
        }
        comparison++;
        Collections.swap(array, i + 1, r);
        swap++;
        return i + 1;
    }

    public static void quickSort(ArrayList<Integer> array, int p, int r) {
        comparison++;
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
    }
}

