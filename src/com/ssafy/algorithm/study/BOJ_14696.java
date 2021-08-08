package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696 {
	
	public static void main(String[] args) throws IOException {
		
		/*** input setting ***/
		System.setIn(new FileInputStream("src/14696_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		int N = Integer.parseInt(br.readLine());
		
		/*** Solve! ***/
		String ans = "";
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; ++i) {
			// input for A
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken()); // # of drawings on card
			
			int[] A = new int[cnt];
			for (int c = 0; c < cnt; ++c)
				A[c] = Integer.parseInt(st.nextToken());
			
			// input for B
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken()); // # of drawings on card
			
			int[] B = new int[cnt];
			for (int c = 0; c < cnt; ++c)
				B[c] = Integer.parseInt(st.nextToken());
			
			String winner = match(A, A.length, B, B.length);
			sb.append(winner + "\n");
		}
		
		ans = sb.toString();
		
		// #### Answer
		System.out.println(ans);
		
	}
	
	public static String match(int[] A, int lenA, int[] B, int lenB) {
		String winner = "";
		int[] Acomb = new int[5]; // A's combination counting. alloc 5 for no index nerve
		int[] Bcomb = new int[5]; // B's combination counting. alloc 5 for no index nerve
		
		for (int i = 0; i < lenA; ++i)
			++Acomb[ A[i]];
		for (int i = 0; i < lenB; ++i)
			++Bcomb[ B[i]];
		
		for (int i = 4; i >= 1; --i) {
			if (Acomb[i] > Bcomb[i]) {
				winner = "A";
				break;
			}
			else if (Acomb[i] < Bcomb[i]) {
				winner = "B";
				break;
			}
			else
				winner = "D";
		}
		
		return winner;
	}

}
