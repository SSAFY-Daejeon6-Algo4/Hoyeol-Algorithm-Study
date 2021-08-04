package com.ssafy.algorithm.study;

import java.util.Arrays;

public class CombinationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		input = new int[] { 1, 4, 7, 10, 12, 13, 15, 19, 22 };
		numbers = new int[R];
		
		combination(0, 0);
	}

	public static int N = 9;
	public static int R = 7;
	static int[] input;
	static int[] numbers;
	
	public static void combination(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i < N; ++i) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}
	}
}
