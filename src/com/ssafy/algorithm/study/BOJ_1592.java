package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1592 {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/1592_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		
		/*** Solve! ***/
		int ans = 0;
		
		int[] counts = new int[N];
		int pos = 0;
		++counts[pos];
		
		while (counts[pos] < M) {
			if (counts[pos] % 2 == 1)
				pos = (pos + L) % N;
			else
				pos = (N + pos - L) % N;
			
			++counts[pos];
			++ans;
		}
		
		
		// #### Answer #### //
		System.out.println(ans);
		
	}

}
