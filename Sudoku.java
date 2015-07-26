package suraj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku {

	static boolean solve(int array[][], int i, int col) {
		if (i == 9 && col == 0)
			return true;
		if (array[i][col] == 0) {
			for (int k = 1; k <= 9; k++) {
				if (check(array, i, col, k) == true) {
					array[i][col] = k;
					boolean t;
					if (col == 8) {
						t = solve(array, i + 1, 0);
					} else
						t = solve(array, i, col + 1);
					if (t)
						return true;
				}
			}
			array[i][col] = 0;
			return false;
		} else {
			if (col == 8)
				return solve(array, i + 1, 0);
			else
				return solve(array, i, col + 1);

		}
	}

	private static boolean check(int[][] array, int row, int col, int n) {
		int grid, i = 0, j = 0;
		if (row < 3 && col < 3) {
			grid = 1;
			i = 0;
			j = 0;

		} else if (row < 3 && col < 6) {
			grid = 2;
			i = 0;
			j = 3;

		} else if (row < 3 && col < 9) {
			grid = 3;
			i = 0;
			j = 6;

		} else if (row < 6 && col < 3) {
			grid = 4;
			i = 3;
			j = 0;

		} else if (row < 6 && col < 6) {
			grid = 5;
			i = 3;
			j = 3;

		} else if (row < 6 && col < 9) {
			grid = 6;
			i = 3;
			j = 6;

		} else if (row < 9 && col < 3) {
			grid = 7;
			i = 6;
			j = 0;

		} else if (row < 9 && col < 6) {
			grid = 8;
			i = 6;
			j = 3;

		} else if (row < 9 && col < 9) {
			grid = 9;
			i = 6;
			j = 6;

		}
		for (int a = 0; a < 9; a++) {
			if (array[a][col] == n)
				return false;
		}
		for (int b = 0; b < 9; b++) {
			if (array[row][b] == n)
				return false;
		}
		for (int a = i; a < i + 3; a++) {
			for (int b = j; b < j + 3; b++) {
				if (array[a][b] == n)
					return false;
			}
		}
		return true;

	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("/home/zemoso014/workspace/suraj/src/suraj/suduko.txt"));
		int i = 0, a = 0, b = 0,g=0;
		int[][] array = new int[9][9];
		while (scan.hasNextLine()) {
			int j = 0;
			String s = scan.nextLine();
			if (i % 10 != 0) {
			
				while (j < s.length()) {
					array[a][j] = s.charAt(j) - 48;
					j++;
				}
				a++;
			}
			
			i++;

			if (a == 9) {g++;
				a = 0;
				System.out.println("\n \n\n UNSOLVED  \n"); 
				for(int z=0;z<9;z++){
					 for(int y=0;y<9;y++){
					 System.out.print(array[z][y]+ " ");
					 }
					 System.out.println();
					 }
				System.out.printf("\n\nSOLVED Grid:%d  \n\n",g);
				boolean x = solve(array, 0, 0);
				 for(int z=0;z<9;z++){
				 for(int y=0;y<9;y++){
				 System.out.print(array[z][y]+ " ");
				 }
				 System.out.println();
				 }
			}

		}

	}
}
