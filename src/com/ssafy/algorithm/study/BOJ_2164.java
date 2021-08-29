package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164 {
	
	public static void main(String[] args) throws IOException {
		
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2164_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		int N = Integer.parseInt(br.readLine());
		
		
		/*** Solve! ***/
		int ans = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; ++i)
			queue.offer(i);
		
		while (queue.size() != 1) {
			queue.poll();
			queue.offer( queue.poll());
		}
		
		ans = queue.poll();
		
		// #### Answer
		System.out.println(ans);
		
	}
	
}
