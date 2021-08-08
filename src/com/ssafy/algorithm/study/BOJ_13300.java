package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300 {
	
	public static void main(String[] args) throws IOException {
		
		/*** input setting ***/
		System.setIn(new FileInputStream("src/13300_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] students = new int[2][6];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			++students[S][Y - 1];
		}
		
		
		/*** Solve! ***/
		int ans = 0;
		
		for (int S = 0; S <= 1; ++S) {
			for (int Y = 0; Y <= 5; ++Y) {
				int num = students[S][Y];
				if (num != 0) {
					if (num % K == 0)
						ans += num / K;
					else
						ans += num / K + 1;
				}
			}
		}
		
		
		// #### Answer
		System.out.println(ans);
		
	}

}
