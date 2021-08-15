package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2628 {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2628_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int nLine = Integer.parseInt(br.readLine());
		int[][] lines = new int[nLine][2];
		for (int i = 0; i < nLine; ++i) {
			st = new StringTokenizer(br.readLine());
			lines[i][0] = Integer.parseInt(st.nextToken()); // 0 : horizontal line, 1 : vertical line
			lines[i][1] = Integer.parseInt(st.nextToken()); // index
		}
		
		
		/*** Solve! ***/
		int ans = 0;
		
		// draw lines on paper
		int[][] paper = new int[R][C];
		for (int[] line : lines) {
			if (line[0] == 0) { // horizontal line
				int r = line[1];
				for (int c = 0; c < C; ++c)
					paper[r][c] += -1;
			}
			else if (line[0] == 1) {
				int c = line[1];
				for (int r = 0; r < R; ++r)
					paper[r][c] += -2;
			}
		}
//		print(paper, R, C);
//		System.out.println("==========================================");
		
		// partial area sum
		int[][] partialArea = new int[R][C];
		
		for (int i = 0; i < R; ++i) {
			int count = 1;
			for (int j = 0; j < C; ++j) {
				if (paper[i][j] == -2 || paper[i][j] == -3)
					count = 1;
				partialArea[i][j] = count++;
			}
		}
//		print(partialArea, R, C);
		
		for (int j = 0; j < C; ++j) {
			int mul = 1;
			for (int i = 0; i < R; ++i) {
				if (paper[i][j] == -1 || paper[i][j] == -3)
					mul = 1;
				partialArea[i][j] *= mul++;
			}
		}
//		System.out.println("--------------------------------------");
//		print(partialArea, R, C);
		
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (partialArea[i][j] > ans)
					ans = partialArea[i][j];
			}
		}
		
		// #### Answer ####
		System.out.println(ans);
		
	}

	public static void print(int[][] board, int R, int C) {
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j)
				System.out.printf("%3d ", board[i][j]);
			System.out.println();
		}
	}
}
