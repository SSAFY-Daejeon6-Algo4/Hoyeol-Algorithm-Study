package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578 {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2578_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		int[][] board = new int[5][5];
		for (int i = 0; i < 5; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; ++j)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] calls = new int[5][5];
		for (int i = 0; i < 5; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; ++j)
				calls[i][j] = Integer.parseInt(st.nextToken());
		}
				
		
		/*** Solve! ***/
		int answer;
		int bingo_cnt = 0;
		boolean[][] checked = new boolean[5][5];
		
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				int[] pos = find(board, calls[i][j]);
				if (pos != null) { // the number is in my board!
					checked[pos[0]][pos[1]] = true;
					
					int count = checkBingo(checked, pos[0], pos[1]);
					bingo_cnt += count;
					
					if (bingo_cnt >= 3) {
						System.out.println(i * 5 + j + 1);
						return;
					}
				}
			}
		}
		
		// #### Answer #### //
		
	}
	
	
	public static int[] find(int[][] board, int call) {
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				if (board[i][j] == call) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}
	
	
	public static int checkBingo(boolean[][] checked, int r, int c) {
		int count = 0;
		boolean bingo = false;
		
		// check row bingo
		for (int col = 0; col < 5; ++col) {
			if (!checked[r][col]) {
				bingo = false;
				break;
			}
			bingo = true;
		}
		
		if (bingo)
			++count;
		
		// check column bingo
		for (int row = 0; row < 5; ++row) {
			if (!checked[row][c]) {
				bingo = false;
				break;
			}
			bingo = true;
		}
		
		if (bingo)
			++count;
		
		// check diagonal bingo
		if (r == c) {
			for (int rc = 0; rc < 5; ++rc) { // right down diagonal
				if (!checked[rc][rc]) {
					bingo = false;
					break;
				}
				bingo = true;
			}
			
			if (bingo)
				++count;
		}
		
		if (r + c == 4) {
			for (int rc = 0; rc < 5; ++rc) { // left down diagonal
				if (!checked[rc][4 - rc]) {
					bingo = false;
					break;
				}
				bingo = true;
			}
			
			if (bingo)
				++count;
		}
		
		return count;
	}

}
