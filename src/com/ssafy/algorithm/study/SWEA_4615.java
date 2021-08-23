package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4615 {
	
	public static int N, M;
	public static int[][] board;
	
	
	// ###### Main ######
	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/sample_input(1).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			/*** get input ***/
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int[][] stones = new int[M][3];
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());
				stones[i][0] = Integer.parseInt(st.nextToken()); // x pos
				stones[i][1] = Integer.parseInt(st.nextToken()); // y pos
				stones[i][2] = Integer.parseInt(st.nextToken()); // color - 1 : black, 2 : white
			}
			///// end test case input /////
			
			/*** Solve! ***/
			String ans = null;
			
			board = new int[N][N];
			
			// initial state
			board[N / 2 - 1][N / 2 - 1] = 2;
			board[N / 2 - 1][N / 2] = 1;
			board[N / 2][N / 2 - 1] = 1;
			board[N / 2][N / 2] = 2;
			
			// place stones
			for (int[] stone : stones) {
				int x = stone[0] - 1;
				int y = stone[1] - 1;
				
				board[y][x] = stone[2];
				updateBoard(x, y, stone[2]);
				
				printBoard();
				System.out.println("===================");
//				break;
			}
			
			// Count & Get answer
			int[] counts = countStones(board);
			ans = counts[0] + " " + counts[1];
			
			// #### Answer
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}
	
	public static void updateBoard(int x, int y, int color) {
		int op = color == 1 ? 2 : 1; // set opponent's color
		
		// check 4 directions whether flip or not
		int[][] dPos = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, // 상 하 좌 우
							{ -1, -1 }, { 1, -1 }, { -1, 1 }, { 1, 1 } }; // 좌상 우상 좌하 우하
		for (int[] d : dPos) {
			int tx = x + d[0]; // looking target x
			int ty = y + d[1]; // looking target y
			
			if (tx >= 0 && tx < N && ty >= 0 && ty < N && board[ty][tx] == op) {
//				System.out.println("found op!");
//				System.out.println("now tx, ty : " + tx + " " + ty);
				// find end
				while (tx >= 0 && tx < N && ty >= 0 && ty < N && board[ty][tx] != color && board[ty][tx] != 0) {
					ty += d[1];
					tx += d[0];
				}
				
				// found end
				if (tx >= 0 && tx < N && ty >= 0 && ty < N && board[ty][tx] == color) {
//					System.out.println("here in");
//					System.out.println("now tx, ty : " + tx + " " + ty);
//					System.out.println("and x, y : " + x + " " + y);
					ty -= d[1];
					tx -= d[0];
//					System.out.println("now tx, ty : " + tx + " " + ty);
					while (tx != x || ty != y) {
//						System.out.println("while in");
						board[ty][tx] = color;
						ty -= d[1];
						tx -= d[0];
					}
				}
			}
			
		}
		
	}
	
	public static int[] countStones(int[][] board) {
		int black = 0;
		int white = 0;
		
		for (int[] line : board) {
			for (int elem : line) {
				switch (elem) {
				case 1:
					++black;
					break;
				case 2:
					++white;
					break;
				}
			}
		}
		
		return new int[] { black, white };
	}
	
	public static void printBoard() {
		for (int[] line : board) {
			for (int elem : line)
				System.out.print(elem + " ");
			System.out.println();
		}
	}

}
