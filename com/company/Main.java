package com.company;


import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {

    Algorithms algorithms = new Algorithms();
    public int[][] z1c;
    public int[][] z2c;

    public void run() throws IOException {
        BufferedImage image1 = ImageIO.read(new File("C:\\BSc_Computer_Science\\Term two\\COMP0005\\Stereo Pairs\\Pair 3\\view1.png"));
        BufferedImage image2 = ImageIO.read(new File("C:\\BSc_Computer_Science\\Term two\\COMP0005\\Stereo Pairs\\Pair 3\\view2.png"));

        z1c = generate_image_array(image1);
        z2c = generate_image_array(image2);

        double[][] disparity_matrix = new double[image1.getHeight()][image1.getWidth()];
        for (int i = 0;i < image1.getHeight();i++)
        {
            disparity_matrix[i] = algorithms.generate_disparity_array(algorithms.generate_match_array(algorithms.generate_cost_matrix(z1c[i],z2c[i])));
        }
        generate_image(disparity_matrix);
    }



    public int[][] generate_image_array(BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();
        int[][] image_array = new int[height][width];
        Raster raster = img.getData();
        for (int row = 0; row < height; row++) {
            for (int coloum = 0; coloum < width; coloum++) {
                image_array[row][coloum] = raster.getSample(coloum, row, 0);
            }
        }
        return image_array;
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
            ImageIO.write(bImage, "png", new File("C:\\BSc_Computer_Science\\Term two\\COMP0005\\Stereo Pairs\\Pair 3\\out.png"));
        } catch (IOException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
        System.out.println("Images were written succesfully.");
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
