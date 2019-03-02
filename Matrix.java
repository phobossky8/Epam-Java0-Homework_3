package by.ldu.task.ex2;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class Matrix {

	public static void main(String[] args) {
		double[][] arr = initRandomMatrix();

		findMaxElement(arr);
		findMinElement(arr);
		averageValues(arr);
		System.out.println("----------------------------------");
		transposeMatrix(arr);
	}

	public static double[][] initRandomMatrix() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter first size of Matrix, N:");
		byte N = in.nextByte();
		System.out.print("Enter second size of Matrix, M:");
		byte M = in.nextByte();		
		
		Random rand = new Random();
		
		double[][] arr = new double[N][M];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = rand.nextInt(100);
				System.out.print(arr[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		return arr;
	}

	// finding maximum element of Matrix
	public static void findMaxElement(double[][] arr) {
		double max = arr[0][0];
		for (double[] preArray : arr) {
			for (double Array : preArray) {
				if (Array > max) {
					max = Array;
				}
			}
		}
		System.out.println(max);
	}

	// finding minimum element of Matrix
	public static void findMinElement(double[][] arr) {
		double min = arr[0][0];
		for (double[] preArray : arr) {
			for (double Array : preArray) {
				if (Array < min) {
					min = Array;
				}
			}
		}
		System.out.println(min);
	}
	
	//finding arithmetical and geometric averages
	public static void averageValues(double[][] array) {
        int avg = 0;
        int count = 0;
        BigDecimal big = new BigDecimal(1);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                avg += array[i][j];
                big = big.multiply(BigDecimal.valueOf(array[i][j]));
                count++;
            }
        }

        System.out.println("Arithmetical average is :" + (double) avg / count);
        System.out.println("Geometric average is: " + Math.pow(big.doubleValue(), 1.0 / count));
}

	// transposing Matrix
	public static void transposeMatrix(double[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0 + i; j < arr[i].length; j++) {
				double temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
