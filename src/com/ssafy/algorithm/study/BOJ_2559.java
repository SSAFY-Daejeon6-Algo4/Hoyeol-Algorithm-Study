package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2559_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] temps = new int[N];
		for (int i = 0; i < N; ++i)
			temps[i] = Integer.parseInt(st.nextToken());
		
		
		/*** Solve! ***/
		int ans = 0;
		
//		int max = 0;
//		for (int i = 0; i < K; ++i)
//			max += temps[i];
//		
//		for (int i = 1; i <= N - K; ++i) { // 특정 날짜로부터
//			int sum = 0;
//			for (int n = i; n < i + K; ++n) { // K일 동안의 온도합 계산
//				sum += temps[n];
//			}
//
//			if (sum > max)
//				max = sum;
//		}
//		
//		ans = max;
		
		
		// ## partial sum applied solution
		int[] partial = new int[N];
		
		int sum = 0;
		for (int i = 0; i < N; ++i) {
			sum += temps[i];
			partial[i] = sum;
		}
		
		// find best answer
		int max = partial[K - 1];
		
		for (int i = K; i < N; ++i) {
			if (max < partial[i] - partial[i - K])
				max = partial[i] - partial[i - K];
		}
		
		ans = max;
		
		
		// #### Answer ####
		System.out.println(ans);
		
	}
	
}
