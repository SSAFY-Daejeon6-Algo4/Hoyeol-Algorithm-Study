package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798 {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2798_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] cards = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			cards[i] = Integer.parseInt(st.nextToken());
		
		
		/*** Solve! ***/
		int ans = 0;
		
		for (int i = 0; i < N - 2; ++i) {
			int sum = cards[i];
			for (int j = i + 1; j < N - 1; ++j) {
				if (sum + cards[j] > M)
					continue;
				
				sum += cards[j];
				for (int k = j + 1; k < N; ++k) {
					if (sum + cards[k] > M)
						continue;
					
					sum += cards[k];
					if (ans < sum)
						ans = sum;
					
					sum -= cards[k];
				}
				sum -= cards[j];
			}
			sum -= cards[i];
		}
		
		
		// #### Answer #### //
		System.out.println(ans);
		
	}

}
