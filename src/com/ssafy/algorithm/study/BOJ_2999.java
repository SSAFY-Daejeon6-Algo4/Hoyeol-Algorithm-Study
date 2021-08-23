package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2999 {
	
	public static void main(String[] args) throws IOException {
		
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2999_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		String msg = br.readLine();
		
		
		/*** Solve! ***/
		String ans = "";
		
		int len = msg.length();
		
		// determine array size
		int R = (int)Math.sqrt(len);
		while (len % R != 0)
			--R;
		int C = len / R;
		
		// move to array
		char[][] arr = new char[R][C];
		int idx = 0;
		
		for (int j = 0; j < C; ++j) {
			for (int i = 0; i < R; ++i)
				arr[i][j] = msg.charAt(idx++);
		}

		// decode msg
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j)
				sb.append(arr[i][j]);
		}
		
		ans = sb.toString();
		
		// #### Answer
		System.out.println(ans);
		
	}
	
}
