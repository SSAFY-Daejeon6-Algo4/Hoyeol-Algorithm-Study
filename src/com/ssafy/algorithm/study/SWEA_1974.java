package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974 {
	
	// ###### Main ######
	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			/*** get input ***/
			int[][] puzzle = new int[9][9];
			for (int i = 0; i < 9; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; ++j)
					puzzle[i][j] = Integer.parseInt(st.nextToken());
			}
			///// end test case input /////
			
			/*** Solve! ***/
			int ans = 0;
			
			for (int i = 0; i < 9; ++i) {
				if (!horizValid(puzzle, i)) {
					ans = 0;
					break;
				}
				else if (!vertiValid(puzzle, i)) {
					ans = 0;
					break;
				}
				else if (!squareValid(puzzle, i)) {
					ans = 0;
					break;
				}
				else
					ans = 1;
			}
			
			// #### Answer
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}
	
	
	public static boolean horizValid(int[][] puzzle, int row) {
		boolean valid = true;
		
		boolean[] exist = new boolean[9];
		for (int i = 0; i < 9; ++i) {
			int num = puzzle[row][i];
			exist[num - 1] = true;
		}
		
		for (int i = 0; i < 9; ++i) {
			if (!exist[i]) {
				valid = false;
				break;
			}
		}
		
		return valid;
	}
	
	public static boolean vertiValid(int[][] puzzle, int col) {
		boolean valid = true;
		
		boolean[] exist = new boolean[9];
		for (int i = 0; i < 9; ++i) {
			int num = puzzle[i][col];
			exist[num - 1] = true;
		}
		
		for (int i = 0; i < 9; ++i) {
			if (!exist[i]) {
				valid = false;
				break;
			}
		}
		
		return valid;
	}
	
	public static boolean squareValid(int[][] puzzle, int idx) {
		boolean valid = true;
		
		int row = (idx % 3) * 3;
		int col = (idx / 3) * 3;

		boolean[] exist = new boolean[9];
		for (int i = row; i < row + 3; ++i) {
			for (int j = col; j < col + 3; ++j) {
				int num = puzzle[i][j];
				exist[num - 1] = true;
			}
		}
		
		for (int i = 0; i < 9; ++i) {
			if (!exist[i]) {
				valid = false;
				break;
			}
		}
		
		return valid;
	}

}
