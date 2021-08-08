package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563 {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2563_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		int N = Integer.parseInt(br.readLine());
		int[][] papers = new int[N][];
		
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			papers[i] = new int[] { x, y };
		}
		
		
		/*** Solve! ***/
		int[][] board = new int[100][100];
		int ans = 0;
		
		for (int[] coord : papers) {
			for (int x = coord[0]; x < coord[0] + 10; ++x) {
				for (int y = coord[1]; y < coord[1] + 10; ++y)
					board[x][y] = 1;
			}
		}
		
		for (int i = 0; i < 100; ++i) {
			for (int j = 0; j < 100; ++j)
				ans += board[i][j];
		}
		
		
		// #### Answer #### //
		System.out.println(ans);
		
	}
	
}
