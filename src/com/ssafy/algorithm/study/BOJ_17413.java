package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17413 {
	
	public static void main(String[] args) throws IOException {
		
		/*** input setting ***/
		System.setIn(new FileInputStream("src/17413_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		String S = br.readLine();
		
		/*** Solve! ***/
		String ans = "";
		
		StringBuilder sb = new StringBuilder();
		
		int len = S.length();
		for (int i = 0; i < len; ++i) {
			// tag?
			if (S.charAt(i) == '<') {
				while (S.charAt(i) != '>')
					sb.append(S.charAt(i++));
				sb.append(S.charAt(i));
			}
			// just blank?
			else if (S.charAt(i) == ' ')
				sb.append(S.charAt(i));
			// word?
			else {
				StringBuilder reverse = new StringBuilder();
				while (i < len && S.charAt(i) != ' ' && S.charAt(i) != '<')
					reverse.append(S.charAt(i++));
				for (int idx = reverse.length() - 1; idx >= 0; --idx)
					sb.append(reverse.charAt(idx));
				
				--i;
			}
		}
		
		
		ans = sb.toString();
		
		// #### Answer
		System.out.println(ans);
		
	}
	
}
