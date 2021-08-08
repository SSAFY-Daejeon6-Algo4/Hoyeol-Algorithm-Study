package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491 {

	public static void main(String[] args) throws IOException {
		
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2491_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			numbers[i] = Integer.parseInt(st.nextToken());
			
		
		/*** Solve! ***/
		int maxAscend = getMaxLength(numbers, N, "ascending");
		int maxDescend = getMaxLength(numbers, N, "descending");
		
		int ans = maxAscend >= maxDescend ? maxAscend : maxDescend;
		
		
		// ### Answer
		System.out.println(ans);
		
	}
	
	public static int getMaxLength(int[] numbers, int size, String mode) {
		int len = 1;
		int max = 1;
		
		if (mode.equals("ascending")) {
			for (int i = 0; i < size - 1; ++i) {
				if (numbers[i] <= numbers[i + 1])
					++len;
				else {
					if (len > max)
						max = len;
					len = 1;
				}
			}
			if (len > max)
				max = len;
		}
		else if (mode.equals("descending")) {
			for (int i = 0; i < size - 1; ++i) {
				if (numbers[i] >= numbers[i + 1])
					++len;
				else {
					if (len > max)
						max = len;
					len = 1;
				}
			}
			if (len > max)
				max = len;
		}
		
		return max;
	}

}
