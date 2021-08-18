package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1234 {
	
	// ###### Main ######
	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for (int tc = 1; tc <= T; ++tc) {
			/*** get input ***/
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			///// end test case input /////
			
			/*** Solve! ***/
			String ans = null;
			
//			ArrayList<Character> chars
//	        = new ArrayList<>(
//	                 big_data.chars()
//	                .mapToObj(e -> (char) e)
//	                .collect(
//	                        Collectors.toList()
//	                )
//	        );
//			or
//			List<Character> list = string.chars().mapToObj((i) -> Character.valueOf((char)i)).collect(Collectors.toList());
			
			ArrayList<Character> charStr = new ArrayList<>();
			for (char ch : str.toCharArray())
				charStr.add(ch);
			
			int len = charStr.size();
			int idx = 0;
			
			while (idx < charStr.size() - 1) {
				char ch1 = charStr.get(idx);
				char ch2 = charStr.get(idx + 1);
				if (ch1 != ch2) {
					++idx;
					continue;
				}
				
				charStr.remove(idx);
				charStr.remove(idx);
				--idx;
				
				if (idx < 0)
					idx = 0;
			}
			
			StringBuilder sb = new StringBuilder();
			for (char ch : charStr) {
				if (ch != '-')
					sb.append(ch);
			}
			
			ans = sb.toString();
			
			// #### Answer
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}
	

}
