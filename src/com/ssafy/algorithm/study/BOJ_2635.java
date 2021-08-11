package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2635 {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2635_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		int first = Integer.parseInt(br.readLine());
		
		/*** Solve! ***/
		int ans = 0;
		
		int best = 0;
		int max_len = 0;
		for (int second = first; second >= first / 2; --second) {
			int[] arr = { first, second };
			int len = 2;
			
			int third = arr[0] - arr[1];
			while (third >= 0) {
				arr[0] = arr[1];
				arr[1] = third;
				++len;
				third = arr[0] - arr[1];
			}
			
			if (len > max_len) {
				max_len = len;
				best = second;
			}
		}
		
		ans = max_len;
		
		// #### Answer
		System.out.println(ans);
		
		int[] arr = { first, best };
		System.out.print(arr[0] + " " + arr[1] + " ");
		int third = arr[0] - arr[1];
		while (third >= 0) {
			System.out.print(third + " ");
			arr[0] = arr[1];
			arr[1] = third;
			third = arr[0] - arr[1];
		}
	}

}
