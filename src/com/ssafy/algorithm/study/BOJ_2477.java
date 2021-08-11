package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477 {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2477_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		int K = Integer.parseInt(br.readLine());
		int[][] sides = new int[6][2];
		for (int i = 0; i < 6; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sides[i][0] = Integer.parseInt(st.nextToken()); // direction
			sides[i][1] = Integer.parseInt(st.nextToken()); // length
		}
		
		/*** Solve! ***/
		int width = 0, height = 0;
		for (int i = 0; i < 6; ++i) { // 가로, 세로 최장 길이 확인
			int direction = sides[i][0];
			int length = sides[i][1];
			
			if (direction == 1 || direction == 2) { // 동 또는 서
				if (width < length)
					width = length;
			}
			else { // 북 또는 남
				if (height < length)
					height = length;
			}
		}
		
		// 반시계방향 = 북-서-남-동 = 4-2-3-1-4-2-3-1-4-2-...
		int[] directions = { 4, 2, 3, 1 };
		int blank_area = 0;
		
		for (int n = 0; n < 2; ++n) {
			// 순회 시작 위치 조정
			int pos = 0;
			while (sides[n][0] != directions[pos])
				++pos;
			
			// 순회
			for (int k = 0; k < 6; ++k) {
				int i = (k + n) % 6;
				if (sides[i][0] != directions[pos]) {
					int len1 = sides[i][1];
					int len2 = sides[(i - 1 + 6) % 6][1];
					blank_area = len1 * len2;
					break;
				}
				
				pos = ++pos % 4;
			}
		}
		
		int ans = (width * height - blank_area) * K;
		
		// #### Answer
		System.out.println(ans);
	}

}
