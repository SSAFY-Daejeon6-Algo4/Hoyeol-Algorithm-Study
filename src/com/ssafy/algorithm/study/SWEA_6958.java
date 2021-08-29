package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6958 {
	
	public static int N, M;
	public static int[][] solved;
	
	
	// ###### Main ######
	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/s_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			/*** get input ***/
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			solved = new int[N][M];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; ++j)
					solved[i][j] = Integer.parseInt(st.nextToken()); 
			}
			///// end test case input /////
			
			/*** Solve! ***/
			String ans = null;
			
			StringBuilder sb = new StringBuilder();
			
			int max = 0;	// max count of # of solved problems
			int count = 0;	// counts # of person solved max count of problems
			
			for (int i = 0; i < N; ++i) {
				int solved_cnt = 0;
				for (int solve : solved[i]) {
					if (solve == 1)
						++solved_cnt;
				}
				
				if (solved_cnt == max)
					++count;
				else if (solved_cnt > max) {
					max = solved_cnt;
					count = 1;
				}
			}
			
			sb.append(count).append(" ").append(max);
			
			ans = sb.toString();
			
			// #### Answer
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}

}
