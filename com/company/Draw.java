package com.company;


import org.knowm.xchart.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Creates a simple Chart using QuickChart
 */
public class Draw{

    private model model;

    public Draw(model model)
    {
        this.model = model;

    }

    private void draw_graph(Integer n) throws IOException {
        ArrayList<Long> HeapSortTime = model.HeapSort_time_list.get(n);
        ArrayList<Long> QuickSortTime = model.QuickSort_time_list.get(n);

        ArrayList<Long> HeapSortSwapAndComp = model.HeapSort_swapAndcomp_list.get(n);
        ArrayList<Long> QuickSortSwapAndComp= model.QuickSort_swapAndcomp_list.get(n);

        ArrayList<Long> HeapSortSwap = model.HeapSort_swap_list.get(n);
        ArrayList<Long> QuickSortSwap = model.QuickSort_swap_list.get(n);

        ArrayList<Long> HeapSortComparison = model.HeapSort_comparison_list.get(n);
        ArrayList<Long> QuickSortComparison = model.QuickSort_comparison_list.get(n);

        ArrayList<Long> Size = model.size;

        n++;
        XYChart Time_Chart = new XYChartBuilder().width(800).height(600).title("Time Chart No." + n.toString()).xAxisTitle("Size of Array").yAxisTitle("Time taken to sort in milliseconds").build();
        Time_Chart.addSeries("Heapsort", Size, HeapSortTime);
        Time_Chart.addSeries("Quicksort", Size, QuickSortTime);
        Time_Chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        BitmapEncoder.saveBitmap(Time_Chart, "C:\\Users\\Yoyou\\OneDrive\\Desktop\\Charts\\TimeChart" + n.toString(), BitmapEncoder.BitmapFormat.PNG);

        XYChart SwapAndComp_Chart = new XYChartBuilder().width(800).height(600).title("Comparisons and exchanges chart No. "+ n.toString()).xAxisTitle("Size of Array").yAxisTitle("Total number of comparisons and swaps").build();
        SwapAndComp_Chart.addSeries("Heapsort", Size, HeapSortSwapAndComp);
        SwapAndComp_Chart.addSeries("Quicksort", Size, QuickSortSwapAndComp);
        SwapAndComp_Chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        BitmapEncoder.saveBitmap( SwapAndComp_Chart, "C:\\Users\\Yoyou\\OneDrive\\Desktop\\Charts\\Swap and Comparison Chart" + n.toString(), BitmapEncoder.BitmapFormat.PNG);

        XYChart Swap_Chart = new XYChartBuilder().width(800).height(600).title("Swap chart No. "+ n.toString()).xAxisTitle("Size of Array").yAxisTitle("Total number of swaps").build();
        Swap_Chart.addSeries("Heapsort", Size, HeapSortSwap);
        Swap_Chart.addSeries("Quicksort", Size, QuickSortSwap);
        Swap_Chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        BitmapEncoder.saveBitmap( Swap_Chart, "C:\\Users\\Yoyou\\OneDrive\\Desktop\\Charts\\Swap Chart" + n.toString(), BitmapEncoder.BitmapFormat.PNG);

        XYChart Comparison_Chart = new XYChartBuilder().width(800).height(600).title("Comparisons chart No. "+ n.toString()).xAxisTitle("Size of Array").yAxisTitle("Total number of comparisons").build();
        Comparison_Chart.addSeries("Heapsort", Size, HeapSortComparison);
        Comparison_Chart.addSeries("Quicksort", Size, QuickSortComparison);
        Comparison_Chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        BitmapEncoder.saveBitmap( Comparison_Chart, "C:\\Users\\Yoyou\\OneDrive\\Desktop\\Charts\\Comparison Chart" + n.toString(), BitmapEncoder.BitmapFormat.PNG);
    }

    private void draw_average_graph() throws IOException {
        ArrayList<Long> HeapSortAverageTime = model.HeapSort_average_time;
        ArrayList<Long> QuickSortAverageTime = model.QuickSort_average_time;
        ArrayList<Long> HeapSortAverageSwapAndComp = model.HeapSort_average_SwapAndComp;
        ArrayList<Long> QuickSortAverageSwapAndComp= model.QuickSort_average_SwapAndComp;
        ArrayList<Long> HeapSortAverageSwap = model.HeapSort_average_swap;
        ArrayList<Long> QuickSortAverageSwap = model.QuickSort_average_swap;
        ArrayList<Long> HeapSortAverageComparison = model.HeapSort_average_comparison;
        ArrayList<Long> QuickSortAverageComparison = model.QuickSort_average_comparison;

        ArrayList<Long> QuickSortTimeSD = model.QuickSort_Time_SD;
        ArrayList<Long> HeapSortTimeSD = model.HeapSort_Time_SD;
        ArrayList<Long> HeapSort_swapAndcompSD = model.HeapSort_swapAndcomp_SD;
        ArrayList<Long> QuickSort_swapAndcompSD = model.QuickSort_swapAndcomp_SD;
        ArrayList<Long> HeapSort_SwapSD = model.HeapSort_Swap_SD;
        ArrayList<Long> QuickSort_SwapSD = model.QuickSort_Swap_SD;
        ArrayList<Long> HeapSort_ComparisonSD = model.HeapSort_Comparison_SD;
        ArrayList<Long> QuickSort_ComparisonSD = model.QuickSort_Comparison_SD;

        ArrayList<Long> Size = model.size;

        XYChart Average_Time_Chart = new XYChartBuilder().width(800).height(600).title("Average time chart").xAxisTitle("Size of Array").yAxisTitle("Average time taken to sort in milliseconds").build();
        Average_Time_Chart.addSeries("Heapsort", Size, HeapSortAverageTime, HeapSortTimeSD);
        Average_Time_Chart.addSeries("Quicksort", Size, QuickSortAverageTime, QuickSortTimeSD);
        Average_Time_Chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        BitmapEncoder.saveBitmap(Average_Time_Chart, "C:\\Users\\Yoyou\\OneDrive\\Desktop\\Charts\\Average Time Chart", BitmapEncoder.BitmapFormat.PNG);

        XYChart Average_SwapAndComp_Chart = new XYChartBuilder().width(800).height(600).title("Average comparisons and exchanges chart").xAxisTitle("Size of Array").yAxisTitle("Average Total number of comparisons and swaps").build();
        Average_SwapAndComp_Chart.addSeries("Heapsort", Size, HeapSortAverageSwapAndComp, HeapSort_swapAndcompSD);
        Average_SwapAndComp_Chart.addSeries("Quicksort", Size, QuickSortAverageSwapAndComp, QuickSort_swapAndcompSD);
        Average_SwapAndComp_Chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        BitmapEncoder.saveBitmap( Average_SwapAndComp_Chart, "C:\\Users\\Yoyou\\OneDrive\\Desktop\\Charts\\Average Swap and Comparison Chart", BitmapEncoder.BitmapFormat.PNG);

        XYChart Average_Swap_Chart = new XYChartBuilder().width(800).height(600).title("Average swap chart").xAxisTitle("Size of Array").yAxisTitle("Average swaps taken to sort").build();
        Average_Swap_Chart.addSeries("Heapsort", Size, HeapSortAverageSwap, HeapSort_SwapSD);
        Average_Swap_Chart.addSeries("Quicksort", Size, QuickSortAverageSwap, QuickSort_SwapSD);
        Average_Swap_Chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        BitmapEncoder.saveBitmap(Average_Swap_Chart, "C:\\Users\\Yoyou\\OneDrive\\Desktop\\Charts\\Average Swap Chart", BitmapEncoder.BitmapFormat.PNG);

        XYChart Average_Comparison_Chart = new XYChartBuilder().width(800).height(600).title("Average comparison chart").xAxisTitle("Size of Array").yAxisTitle("Average comparisons taken to sort").build();
        Average_Comparison_Chart.addSeries("Heapsort", Size, HeapSortAverageComparison, HeapSort_ComparisonSD);
        Average_Comparison_Chart.addSeries("Quicksort", Size, QuickSortAverageComparison, QuickSort_ComparisonSD);
        Average_Comparison_Chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        BitmapEncoder.saveBitmap(Average_Comparison_Chart, "C:\\Users\\Yoyou\\OneDrive\\Desktop\\Charts\\Average Comparison Chart", BitmapEncoder.BitmapFormat.PNG);
    }



    public static void main(String[] args) throws Exception {
        model model = new model();
        Draw draw = new Draw(model);
        model.run_10();
        model.getAverage();
        model.get_SD();
        for(int n = 0; n < 10; n++)
        {
            draw.draw_graph(n);
        }
    }
}
