package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6730 {
	
	public static int N;
	
	
	// ###### Main ######
	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/s_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			/*** get input ***/
			N = Integer.parseInt(br.readLine());
			
			int[] blocks = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i)
				blocks[i] = Integer.parseInt(st.nextToken());
			///// end test case input /////
			
			/*** Solve! ***/
			String ans = null;
			
			StringBuilder sb = new StringBuilder();
			
			int maxUp = 0;
			int maxDown = 0;
			
			for (int i = 0; i < N - 1; ++i) {
				int diff = blocks[i + 1] - blocks[i];
				
				if (diff > 0 && diff > maxUp)
					maxUp = diff;
				else if (diff < 0 && diff < maxDown)
					maxDown = diff;
			}
			maxDown *= (-1);
			sb.append(maxUp).append(" ").append(maxDown);
			
			ans = sb.toString();
			
			// #### Answer
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}

}
