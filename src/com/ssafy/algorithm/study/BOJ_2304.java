package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2304 {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2304_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		int N = Integer.parseInt(br.readLine());
		
		int[][] pillars = new int[N][2];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pillars[i][0] = Integer.parseInt(st.nextToken()); // position
			pillars[i][1] = Integer.parseInt(st.nextToken()); // height
		}
		
		
		/*** Solve! ***/
		int ans = 0;
		
		if (N == 1)
			ans = pillars[0][1];
		else {
			Arrays.sort(pillars, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			ans = calculateArea(pillars, N);
		}
		
		
		// #### Answer ####
		System.out.println(ans);
		
	}
	
	public static int calculateArea(int[][] list, int size) {
		int start = list[0][0]; // starting x position
		int end = list[size - 1][0]; // ending x position
		
		int mid = 0; // highest position
		int highest = 0; // highest height
		
		// mark pillars' position & find highest
		int[] ground = new int[end + 1];
		for (int[] pillar : list) {
			ground[ pillar[0]] = pillar[1];
			if (pillar[1] > highest) {
				highest = pillar[1];
				mid = pillar[0];
			}
		}
		
		
		int area = 0;
		// calculate area from left to middle
		int height = list[0][1];
		for (int i = start; i < mid; ++i) {
			if (height < ground[i])
				height = ground[i];
			area += height;
		}
		
		// calculate area from right to middle
		height = list[size - 1][1];
		for (int i = end; i > mid; --i) {
			if (height < ground[i])
				height = ground[i];
			area += height;
		}
		
		area += highest;
		return area;
	}
	
}
