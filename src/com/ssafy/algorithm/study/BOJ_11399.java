package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/11399_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		int N = Integer.parseInt(br.readLine());
		
		int[] times = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			times[i] = Integer.parseInt(st.nextToken());
		
		
		/*** Solve! ***/
		int ans = 0;
		
		Arrays.sort(times);
		
		int waited = 0;
		for (int i = 0; i < N; ++i) {
			waited += times[i];
			times[i] = waited;
		}
		
		for (int time : times)
			ans += time;
		
		
		// #### Answer #### //
		System.out.println(ans);
		
	}

}
