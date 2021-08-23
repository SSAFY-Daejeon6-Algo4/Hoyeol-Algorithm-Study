package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8320 {

	public static void main(String[] args) throws IOException {

		/*** input setting ***/
		System.setIn(new FileInputStream("src/8320_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*** get input ***/
		int n = Integer.parseInt(br.readLine());

		/*** Solve! ***/
		int ans = 0;

		boolean[][] check = new boolean[n + 1][n + 1];
		int cnt = 0;
		for (int i = 1; i <= n; ++i) {
			int mul = 1;
			while (i * mul <= n) {
				if (!check[mul][i]) {
					++cnt;
					check[i][mul] = true;
				}
				++mul;
			}
		}

		ans = cnt;

		// #### Answer
		System.out.println(ans);

	}

}
