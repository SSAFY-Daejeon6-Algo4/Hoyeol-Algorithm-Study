package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158_failed {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/10158_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		
		/*** Solve! ***/
		t = t % (w * h); // w * h 마다 시작 상태로 돌아옴. 즉 w * h 마다 사이클,,
		
		// define moving directions
		int[][] directions = { { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };
							// 우상, 좌상, 좌하, 우하
		
		int d = 0; // initial direction
		while (--t >= 0) { // Ant moves until time stops
			p += directions[d][0];
			q += directions[d][1];
			
			// check whether change direction or not
			if (p == 0 && q == 0
					|| p == w && q == 0
					|| p == 0 && q == h
					|| p == w && q == h) { // when vertex? --> 우상 <-> 좌하, 우하 <-> 좌상
				
				d = (d + 2) % 4;
			}
			else if (p == w) { // reached right wall
				if (d == 0)
					d = 1;
				else if (d == 3)
					d = 2;
			}
			else if (q == h) { // reached top wall
				if (d == 1)
					d = 2;
				else if (d == 0)
					d = 3;
			}
			else if (q == 0) { // reached bottom wall
				if (d == 2)
					d = 1;
				else if (d == 3)
					d = 0;
			}
			else if (p == 0) { // reached left wall
				if (d == 1)
					d = 0;
				else if (d == 2)
					d = 3;
			}
		}
		
		
		// #### Answer ####
		System.out.println(p + " " + q);
	
	} // main end

}
