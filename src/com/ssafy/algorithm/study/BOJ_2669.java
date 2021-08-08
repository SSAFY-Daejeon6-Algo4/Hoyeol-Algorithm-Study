package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2669 {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2669_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		int[][] squares = new int[4][4];
		
		for (int i = 0; i < 4; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; ++j)
				squares[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		/*** Solve! ***/
		int[][] board = new int[100][100];
		int ans = 0;
		
		for (int[] coord : squares) {
			int x1 = coord[0];
			int y1 = coord[1];
			int x2 = coord[2];
			int y2 = coord[3];
			
			for (int i = x1; i < x2; ++i) {
				for (int j = y1; j < y2; ++j)
					board[i][j] = 1;
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
