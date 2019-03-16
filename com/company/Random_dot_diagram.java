package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Random_dot_diagram {
    Random random = new Random();

    private int[][] generate_random_dot_diagram(int y , int x)
    {
        int[][] random_dot_diagram = new int[y][x];
        for(int i = 0; i < y; i++)
        {
            for(int j = 0; j < x; j++)
            {
                if(random.nextBoolean())
                {
                    random_dot_diagram[i][j] = 255;
                }
                else
                {
                    random_dot_diagram[i][j] = 0;
                }
            }
        }
        return random_dot_diagram;
    }

    private int[][] generate_overlap_diagram(int[][] bottom_diagram, int[][] top_diagram, int x, int y)
    {
        int[][] result = new int[bottom_diagram.length][bottom_diagram[0].length];
        for(int row = 0; row < result.length; row++)
        {
            for(int column = 0; column < result[0].length; column++)
            {
                if(row >= y && row < y + top_diagram.length && column >= x && column < x + top_diagram[0].length)
                {
                    result[row][column] = top_diagram[row - y][column - x];
                }
                else
                {
                    result[row][column] = bottom_diagram[row][column];
                }
            }
        }
        return result;
    }

    public BufferedImage generate_image(double[][] matrix) {
        BufferedImage image = new BufferedImage(matrix[0].length, matrix.length, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = image.getRaster();
        for (int row = 0; row < matrix.length; row++) {
            raster.setSamples(0,row,matrix[row].length,1,0,matrix[row]);
        }
        imageIoWrite(image);
        return image;
    }

    public void imageIoWrite(BufferedImage bImage) {
        try {
            ImageIO.write(bImage, "png", new File("C:\\Users\\Yoyou\\IdeaProjects\\test\\out.png"));
        } catch (IOException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
        System.out.println("Images were written succesfully.");
    }
    public void run()
    {
        int[][] top_diagram = generate_random_dot_diagram(256, 256);
        int[][] background = generate_random_dot_diagram(512,512);
        int[][] image1 = generate_overlap_diagram(background, top_diagram,124, 128);
        int[][] image2 = generate_overlap_diagram(background, top_diagram, 132, 128);
        double[][] disparity_matrix = new double[image1.length][image1[0].length];
        Algorithms algorithms = new Algorithms();
        for(int row = 0; row < image1.length; row++)
        {
            disparity_matrix[row] = algorithms.generate_disparity_array(algorithms.generate_match_array(algorithms.generate_cost_matrix(image1[row],image2[row])));
            if(row == 150) {
                double[] a = (algorithms.generate_match_array(algorithms.generate_cost_matrix(image1[row], image2[row])));
                System.out.println(a[128]);
            }
        }
        generate_image(disparity_matrix);
    }

    public static void main(String arg[])
    {
        new Random_dot_diagram().run();
    }
}
