package com.ssafy.algorithm.study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {

	public static int[] heights;
	public static int[] comb;
	public static int n = 9;
	public static int r = 7;
	public static int[] dwarfs;

	public static void main(String[] args) throws FileNotFoundException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2309_input.txt"));
		Scanner sc = new Scanner(System.in);

		/*** get input ***/
		heights = new int[n];
		for (int i = 0; i < 9; ++i)
			heights[i] = sc.nextInt();

		/*** Solve! ***/
		Arrays.sort(heights);

		comb = new int[r];
		makeComb(0, 0);
		
		
		// #### Answer #### //
		for (int dwarf : dwarfs)
			System.out.println(dwarf);

	}

	
	public static void makeComb(int cnt, int start) {
		if (cnt == r) {
			int sum = 0;
			for (int height : comb)
				sum += height;
			
			if (sum == 100)
				dwarfs = Arrays.copyOf(comb, r);
			return;
		}

		for (int i = start; i < n; ++i) {
			comb[cnt] = heights[i];
			makeComb(cnt + 1, i + 1);
		}
	}

}
