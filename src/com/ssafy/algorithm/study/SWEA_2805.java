package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2805 {
	
	// ###### Main ######
	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for (int tc = 1; tc <= T; ++tc) {
			/*** get input ***/
			int N = Integer.parseInt(br.readLine());
			
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; ++i) {
				String line = br.readLine();
				for (int j = 0; j < N; ++j)
					farm[i][j] = line.charAt(j) - '0';
			}
			
			///// end test case input /////
			
			/*** Solve! ***/
			int ans = 0;
			
			// upper triangle
			for (int r = 0; r <= N / 2; ++r) {
				int offset = N / 2 - r;
				int end = N - offset;
				
				for (int c = offset; c < end; ++c)
					ans += farm[r][c];
			}
			
			// lower triangle
			for (int r = N / 2 + 1; r < N; ++r) {
				int offset = r - N / 2;
				int end = N - offset;
				
				for (int c = offset; c < end; ++c)
					ans += farm[r][c];
			}
			
			// #### Answer
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}
	

}
