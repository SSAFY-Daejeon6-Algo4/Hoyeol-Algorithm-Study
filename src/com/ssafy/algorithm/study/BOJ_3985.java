package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3985 {
	
	public static void main(String[] args) throws IOException {
		
		/*** input setting ***/
		System.setIn(new FileInputStream("src/3985_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[][] pks = new int[N + 1][2];
		for (int i = 1; i <= N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pks[i][0] = Integer.parseInt(st.nextToken()); // p
			pks[i][1] = Integer.parseInt(st.nextToken()); // k
		}
		
		
		/*** Solve! ***/
		int ans = 0;
		
		// find best-estimated
		int ans_est = 1;
		for (int i = 2; i <= N; ++i) {
			if (pks[i][1] - pks[i][0] > pks[ans_est][1] - pks[ans_est][0])
				ans_est = i;
		}
		
		// mark number on cake
		int[] cake = new int[L + 1];
		for (int i = 1; i <= N; ++i) {
			for (int p = pks[i][0]; p <= pks[i][1]; ++p) {
				if (cake[p] == 0)
					cake[p] = i;
			}
		}
		
		// count numbers
		int[] counts = new int[N + 1];
		for (int i = 1; i <= L; ++i)
			++counts[ cake[i]];
		
		
		// find real best
		int best = 0;
		for (int i = 1; i <= N; ++i) {
			if (counts[i] > best) {
				best = counts[i];
				ans = i;
			}
		}
		
		// #### Answer
		System.out.println(ans_est);
		System.out.println(ans);
		
	}
	
}
