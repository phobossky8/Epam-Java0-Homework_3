import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class Matrix {

	public static void main(String[] args) {
		double[][] arr = initRandomMatrix();

		findMaxElement(arr);
		findMinElement(arr);
		System.out.println("----------------------------------");
		averageValues(arr);
		System.out.println("----------------------------------");
		findLocalMax(arr);
		findLocalMin(arr);
		System.out.println("----------------------------------");
		transposeMatrix(arr);
	}

	public static double[][] initRandomMatrix() {
		Scanner scanner = new Scanner(System.in);
		byte N = 0, M = 0;
		System.out.print("Enter first size of Matrix, N:");
		do {
			if (scanner.hasNextByte()) {
				N = scanner.nextByte();
				if (N <= 0) {
					System.out.println("Incorrect input. Try again: ");
				}
			} else {
				System.out.println("Incorrect input. Try again: ");
				scanner.next();
			}
		} while (N <= 0);

		System.out.print("Enter second size of Matrix, M:");
		do {
			if (scanner.hasNextByte()) {
				M = scanner.nextByte();
				if (M <= 0) {
					System.out.println("Incorrect input. Try again: ");
				}
			} else {
				System.out.println("Incorrect input. Try again: ");
				scanner.next();
			}
		} while (M <= 0);

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
		System.out.println("MAX element of matrix is: " + max);
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
		System.out.println("MIN element of matrix is: " + min);
	}

	// finding arithmetical and geometric averages
	public static void averageValues(double[][] array) {
		int avg = 0;
		int count = 0;
		BigDecimal geom = new BigDecimal(1);

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				avg += array[i][j];
				geom = geom.multiply(BigDecimal.valueOf(array[i][j]));
				count++;
			}
		}
		System.out.println("Arithmetical average is :" + (double) avg / count);
		System.out.println("Geometric average is: " + Math.pow(geom.doubleValue(), 1.0 / count));
	}

	// transposing Matrix. This method working and working correctly only with
	// Matrix, who has same number of lines and columns.
	// (according to our task, which says that we shouldn't use additional memory
	// (for creating temporary variables or other arrays)
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

	// finding of first local minimum of Matrix
	public static void findLocalMin(double[][] array) {
		boolean isLocalMinFound = false;

		for (int j = 1; j < array[0].length - 1; j++) {
			if (array[0][j - 1] > array[0][j] && array[0][j + 1] > array[0][j] && array[1][j] > array[0][j]) {
				isLocalMinFound = true;
				System.out.println("Position of Local MIN is: [0][" + j + "]");
				break;
			}
		}
		if (!isLocalMinFound && array.length > 2) {
			for (int i = 1; i < array.length - 1; i++) {
				if (array[i - 1][0] > array[i][0] && array[i + 1][0] > array[i][0] && array[i][1] > array[i][0]) {
					isLocalMinFound = true;
				}
				if (!isLocalMinFound) {
					for (int j = 1; j < array[i].length - 1; j++) {
						if (array[i - 1][j] > array[i][j] && array[i + 1][j] > array[i][j]
								&& array[i][j - 1] > array[i][j] && array[i][j + 1] > array[i][j]) {
							System.out.println("Position of Local MIN is: [" + i + "][" + j + "]");
							isLocalMinFound = true;
							break;
						}
					}
				}
				if (!isLocalMinFound) {
					if (array[i - 1][array[i].length - 1] > array[i][array[i].length - 1]
							&& array[i + 1][array[i].length - 1] > array[i][array[i].length - 1]
							&& array[i][array[i].length - 2] > array[i][array[i].length - 1]) {
						isLocalMinFound = true;
					}
				}
			}
		}
		if (!isLocalMinFound) {
			for (int j = 1; j < array[array.length - 1].length - 1; j++) {
				if (array[array.length - 1][j - 1] > array[array.length - 1][j]
						&& array[array.length - 1][j + 1] > array[array.length - 1][j]
						&& array[array.length - 2][j] > array[array.length - 1][j]) {
					isLocalMinFound = true;
					System.out.println("Position of Local MIN is: [" + (array.length - 1) + "][" + j + "]");
					break;
				}

			}
		}

		if (!isLocalMinFound) {
			System.out.println("Local min = -1");
		}
	}

	// finding of first local maximum of Matrix
	public static void findLocalMax(double[][] array) {
		boolean isLocalMaxFound = false;

		for (int j = 1; j < array[0].length - 1; j++) {
			if (array[0][j - 1] < array[0][j] && array[0][j + 1] < array[0][j] && array[1][j] < array[0][j]) {
				isLocalMaxFound = true;
				System.out.println("Position of Local MAX is: [0][" + j + "]");
				break;
			}
		}
		if (!isLocalMaxFound && array.length > 2) {
			for (int i = 1; i < array.length - 1; i++) {
				if (array[i - 1][0] < array[i][0] && array[i + 1][0] < array[i][0] && array[i][1] < array[i][0]) {
					isLocalMaxFound = true;
				}
				if (!isLocalMaxFound) {
					for (int j = 1; j < array[i].length - 1; j++) {
						if (array[i - 1][j] < array[i][j] && array[i + 1][j] < array[i][j]
								&& array[i][j - 1] < array[i][j] && array[i][j + 1] < array[i][j]) {
							System.out.println("Position of Local MAX is: [" + i + "][" + j + "]");
							isLocalMaxFound = true;
							break;
						}
					}
				}
				if (!isLocalMaxFound) {
					if (array[i - 1][array[i].length - 1] < array[i][array[i].length - 1]
							&& array[i + 1][array[i].length - 1] < array[i][array[i].length - 1]
							&& array[i][array[i].length - 2] < array[i][array[i].length - 1]) {
						isLocalMaxFound = true;
					}
				}
			}
		}
		if (!isLocalMaxFound) {
			for (int j = 1; j < array[array.length - 1].length - 1; j++) {
				if (array[array.length - 1][j - 1] < array[array.length - 1][j]
						&& array[array.length - 1][j + 1] < array[array.length - 1][j]
						&& array[array.length - 2][j] < array[array.length - 1][j]) {
					isLocalMaxFound = true;
					System.out.println("Position of Local MAX is: [" + (array.length - 1) + "][" + j + "]");
					break;
				}

			}
		}

		if (!isLocalMaxFound) {
			System.out.println("Local max is -1");
		}

	}

}
