package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_5432 {
	
	// ###### Main ######
	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			/*** get input ***/
			String parens = br.readLine();
			///// end test case input /////
			
			/*** Solve! ***/
			int ans = 0;
			
			parens = parens.replace("()", "L");
			int len = parens.length();
			
			int slices = 0;
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < len; ++i) {
				char ch = parens.charAt(i);
				
				if (ch == '(') {
					stack.push(0);
				}
				else if (ch == 'L') {
					if (!stack.isEmpty()) {
						stack.push( stack.pop() + 1);
					}
				}
				else if (ch == ')') {
					int nLazor = stack.pop();
					slices += nLazor + 1;
					if (!stack.isEmpty())
						stack.push( stack.pop() + nLazor);
				}
			}
			
			ans = slices;
			
			// #### Answer
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}
	
}
