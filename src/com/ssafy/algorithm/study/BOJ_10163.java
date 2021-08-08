package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163 {
	
	public static void main(String[] args) throws IOException {
		
		/*** input setting ***/
		System.setIn(new FileInputStream("src/10163_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[1001][1001];
		int[][] papers = new int[N][4];
		
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			papers[i][0] = Integer.parseInt(st.nextToken());
			papers[i][1] = Integer.parseInt(st.nextToken());
			papers[i][2] = papers[i][0] + Integer.parseInt(st.nextToken());
			papers[i][3] = papers[i][1] + Integer.parseInt(st.nextToken());
		}
		
		
		/*** Solve! ***/
		// numbering on board
		for (int i = 0; i < N; ++i) {
			for (int x = papers[i][0]; x < papers[i][2]; ++x) {
				for (int y = papers[i][1]; y < papers[i][3]; ++y)
					board[x][y] = i + 1;
			}
		}
		
		String ans = "";
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; ++i) {
			int area = 0;
			for (int x = papers[i][0]; x < papers[i][2]; ++x) {
				for (int y = papers[i][1]; y < papers[i][3]; ++y) {
					if (board[x][y] == i + 1)
						++area;
				}
			}
			
			sb.append(area + "\n");
		}
		ans = sb.toString();
		
		// #### Answer
		System.out.println(ans);
		
	}

}
