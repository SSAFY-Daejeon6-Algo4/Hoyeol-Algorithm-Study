package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1859 {
	
	// ###### Main ######
	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			/*** get input ***/
			int N = Integer.parseInt(br.readLine());
			
			int[] prices = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i)
				prices[i] = Integer.parseInt(st.nextToken());
			///// end test case input /////
			
			/*** Solve! ***/
			long ans = 0;
			
			int max = findMax(prices);
			
			ArrayList<Integer> buyList = new ArrayList<>();
			for (int i = 0; i < N; ++i) {
				if (prices[i] == max) {
					while (buyList.size() > 0)
						ans += max - buyList.remove(0);
					max = findMax(Arrays.copyOfRange(prices, i + 1, prices.length));
				}
				else
					buyList.add(prices[i]);
			}
			
			// #### Answer
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}
	
	
	public static int findMax(int[] prices) {
		int len = prices.length;
		
		int max = 0;
		for (int i = 0; i < len; ++i) {
			if (max < prices[i])
				max = prices[i];
		}
		
		return max;
	}
	
}
