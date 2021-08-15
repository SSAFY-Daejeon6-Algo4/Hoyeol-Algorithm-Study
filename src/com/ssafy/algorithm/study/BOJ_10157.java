package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157 {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/10157_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		
		/*** Solve! ***/
		if (K > R * C) { // out of range
			System.out.println("0");
		}
		else {
			int[][] stage = new int[C][R]; // 공연장
			
			int[] dr = { 0, 1, 0, -1 }; // 우 -> 하 -> 좌 -> 상
			int[] dc = { 1, 0, -1, 0 };
			
			// location traverse initialization
			int r = 0, c = 0;
			int val = 1; // value
			int d = 0; // direction
			
			stage[r][c] = val;
			while (val < K) {
				if (r + dr[d] >= 0 && r + dr[d] < C && c + dc[d] >= 0 && c + dc[d] < R
						&& stage[r + dr[d]][c + dc[d]] == 0) {
					r += dr[d];
					c += dc[d];
					++val;
					stage[r][c] = val;
				}
				else {
					d = ++d % 4; // next direction
				}
			}
			
			System.out.println((r + 1) + " " + (c + 1));
		}
		
	} // main end

}
