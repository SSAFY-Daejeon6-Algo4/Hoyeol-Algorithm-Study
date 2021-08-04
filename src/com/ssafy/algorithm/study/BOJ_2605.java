package com.ssafy.algorithm.study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2605 {

	public static void main(String[] args) throws FileNotFoundException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2605_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		/*** get input ***/
		int n = sc.nextInt();
		int[] nums = new int[n];
		
		for (int i = 0; i < n; ++i)
			nums[i] = sc.nextInt();
		
		
		/*** Solve! ***/
		ArrayList<Integer> lineup = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			int stdNo = i + 1;
			
			if (nums[i] == 0)
				lineup.add(stdNo);
			else
				lineup.add(lineup.size() - nums[i], stdNo);
		}
		
		
		// #### Answer #### //
		for (int student : lineup)
			System.out.print(student + " ");
		
	}

}
