package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1940 {
	
	// ###### Main ######
	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			/*** get input ***/
			int N = Integer.parseInt(br.readLine());
			
			int[][] commands = new int[N][2];
			for (int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				commands[i][0] = Integer.parseInt(st.nextToken()); // command - 0 : keep, 1 : accel, 2 : decel
				if (commands[i][0] == 0)
					continue;
				commands[i][1] = Integer.parseInt(st.nextToken()); // acceleration
			}
			///// end test case input /////
			
			/*** Solve! ***/
			int ans = 0;
			
			int dist = 0;
			int speed = 0;
			for (int[] command : commands) {
				switch (command[0]) {
				case 0:
				case 1:
					speed += command[1];
					dist += speed;
					break;
				case 2:
					speed -= command[1];
					if (speed < 0)
						speed = 0;
					dist += speed;
					break;
				}
			}
			
			ans = dist;
			
			// #### Answer
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}
	
}
