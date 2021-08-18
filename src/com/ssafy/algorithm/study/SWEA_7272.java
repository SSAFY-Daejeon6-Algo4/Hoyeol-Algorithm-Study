package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7272 {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/s_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			
			/*** Solve! ***/
			String ans = "SAME";
			
			String noHole = "CEFGHIJKLMNSTUVWXYZ";
			String oneHole = "ADOPQR";
			String twoHole = "B";
			
			if (str1.length() != str2.length())
				ans = "DIFF";
			else {
				int len = str1.length();
				for (int i = 0; i < len; ++i) {
					char ch1 = str1.charAt(i);
					char ch2 = str2.charAt(i);
					
					if (noHole.indexOf(ch1) != -1) {
						if (noHole.indexOf(ch2) == -1) {
							ans = "DIFF";
							break;
						}
					}
					else if (oneHole.indexOf(ch1) != -1) {
						if (oneHole.indexOf(ch2) == -1) {
							ans = "DIFF";
							break;
						}
					}
					else if (twoHole.indexOf(ch1) != -1) {
						if (twoHole.indexOf(ch2) == -1) {
							ans = "DIFF";
							break;
						}
					}
				}
			}
			
			
			// #### Answer ####
			System.out.println("#" + tc + " " + ans);
			
		}
	}

}
