package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2991 {
	
	public static void main(String[] args) throws IOException {
		
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2991_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		int P = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		
		/*** Solve! ***/
		String ans = "";
		
		// count P
		int cnt = 0;
		int p = P;
		
		p = p % (A + B);
		if (p != 0 && p <= A)
			++cnt;
		
		p = P;
		p = p % (C + D);
		if (p != 0 && p <= C)
			++cnt;
		
		ans += cnt + "\n";

		// count M
		cnt = 0;
		int m = M;
		
		m = m % (A + B);
		if (m != 0 && m <= A)
			++cnt;
		
		m = M;
		m = m % (C + D);
		if (m != 0 && m <= C)
			++cnt;
		
		ans += cnt + "\n";

		// count N
		cnt = 0;
		int n = N;
		
		n = n % (A + B);
		if (n != 0 && n <= A)
			++cnt;
		
		n = N;
		n = n % (C + D);
		if (n != 0 && n <= C)
			++cnt;
		
		ans += cnt;
		
		
		// #### Answer
		System.out.println(ans);
		
	}
	
}
