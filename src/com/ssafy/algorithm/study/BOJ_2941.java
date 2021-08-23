package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941 {
	
	public static void main(String[] args) throws IOException {
		
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2941_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		String word = br.readLine();
		
		
		/*** Solve! ***/
		int ans = 0;
		
		int len = word.length();
		for (int i = 0; i < len; ++i) {
			if (i < len - 2) {
				String sub = word.substring(i, i + 3);
				
				// check length 3 Croatian alphabet
				if (sub.equals("dz=")) {
					++ans;
					i += 2;
					System.out.println(sub + " detected");
					continue;
				}
			}
			
			if (i < len - 1) {
				// check length 2 Croatian alphabet
				String sub = word.substring(i, i + 2);
				switch (sub) {
				case "c=":
				case "c-":
				case "d-":
				case "lj":
				case "nj":
				case "s=":
				case "z=":
					++ans;
					++i;
					System.out.println(sub + " detected");
					continue;
				}
			}
			
			// no Croatian alphabet detected
			++ans;
		}
		
		// #### Answer
		System.out.println(ans);
		
	}
	
}
