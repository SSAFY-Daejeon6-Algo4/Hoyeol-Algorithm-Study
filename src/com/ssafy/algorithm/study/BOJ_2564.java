package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2564 {

	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2564_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		int nStore = Integer.parseInt(br.readLine());
//		Map<Integer, ArrayList<Integer>> stores = new HashMap<>();
		
		
		int[][] stores = new int[nStore][2];
		for (int i = 0; i < nStore; ++i) {
			st = new StringTokenizer(br.readLine());
			stores[i][0] = Integer.parseInt(st.nextToken()); // direction
			stores[i][1] = Integer.parseInt(st.nextToken()); // distance
		}
		
		int[] dong = new int[2];
		st = new StringTokenizer(br.readLine());
		dong[0] = Integer.parseInt(st.nextToken());
		dong[1] = Integer.parseInt(st.nextToken());
		
		
		/*** Solve! ***/
		int ans = 0;
		
		int[][] town = new int[4][101];
		for (int i = 0; i < nStore; ++i) {
			int direction = stores[i][0] - 1;
			int distance = stores[i][1];
			++town[direction][distance];
		}
		
		Arrays.sort(stores, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		
		
		// Count
		int step = 1;
		int direction = dong[0];
		int distance = dong[1] % 100 + 1;
		
		if (distance == 1)
			direction = (direction + 1) % 4;
		
		int[] storeDist = new int[nStore];
		int idx = 0; // index for storeDist
		
		while (direction != dong[0] && distance != dong[1]) { // 자기 자리로 돌아올 때까지
			
			if (town[direction][distance] != 0) { // 상점이 있는 곳이라면
				storeDist[idx++] = step;
				--nStore;
			}
			
			if (nStore == 0) // 다 계산함
				break;
			else { // 더 찾으러...
				++step;
				distance = (distance + 1) % 100;
				
				if (distance == 0) {
					distance = 1;
					direction = (direction + 1) % 4;
				}
			}
		}
		
		
		for (int i = 0; i < idx; ++i) {
			
		}
		
		
		
		
		
		
		
//		int[] dist = new int[nStore];
//		int peri = width * 2 + height * 2;
//		
//		int walks = 0;
//		while (walks < peri) {
//			--dong[1];
//			++walks;
//			
//			
//		}
		
		
		// #### Answer #### //
		System.out.println(ans);
		
	}
	
}
