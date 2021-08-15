package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116 {

	public static int nDice;
	public static int[][] dices;
	
	public static int ans;
	
	
	public static void main(String[] args) throws IOException {
		/*** input setting ***/
		System.setIn(new FileInputStream("src/2116_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*** get input ***/
		nDice = Integer.parseInt(br.readLine());
		
		dices = new int[nDice][6];
		for (int i = 0; i < nDice; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; ++j)
				dices[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		/*** Solve! ***/
		/*
		 * dices[i][0]	~	dices[i][5]
		 * 		= A		~		= F
		 * 
		 * 			A
		 * 		B	C	D	E
		 * 			F
		 * 
		 * 반대면 관계도
		 * 			A <--> F
		 * 			B <--> D
		 * 			C <--> E
		 * 
		 * 6가지 경우의 수 - 1번 주사위가 놓이는 경우에 따라
		 * 1. A가 윗면(바닥면) - 옆면 : B C D E
		 * == 6. F가 윗면 - 옆면 : B C D E
		 * 
		 * 2. B가 윗면 - 옆면 : C A E F
		 * == 4. D가 윗면 - 옆면 : A C F E
		 * 
		 * 3. C가 윗면 - 옆면 : A B F D
		 * == 5. E가 윗면 - 옆면 : A B F D
		 */
		
		
		for (int i = 0; i < 6; ++i) { // 1번 주사위의 6개 면에 대해 확인
			int topNum = dices[0][i];
			int botNum = 0;
			
			switch (i) {
			case 0: // A --> F
				botNum = dices[0][5];
				break;
			case 1: // B --> D
				botNum = dices[0][3];
				break;
			case 2: // C --> E
				botNum = dices[0][4];
				break;
			case 3: // D --> B
				botNum = dices[0][1];
				break;
			case 4: // E --> C
				botNum = dices[0][2];
				break;
			case 5: // F --> A
				botNum = dices[0][0];
				break;
			}
			
			findMaxDice(0, topNum, botNum, 0);
		}
		
		
		// #### Answer ####
		System.out.println(ans);
		
	}
	
	public static void findMaxDice(int cnt, int top, int bot, int sum) {
		if (cnt == nDice) {
			if (ans < sum)
				ans = sum;
			return;
		}
		
		
		// 지금 쌓는 주사위 옆면의 값 중 최대값 탐색
		int maxVal = 0;
		for (int i = 0; i < 6; ++i) {
			int val = dices[cnt][i];
			if (val != top && val != bot && val > maxVal)
				maxVal = val;
		}
		
		// 주사위 윗면 탐색
		int newTop = 0;

		if (cnt < nDice - 1) {
			// 다음에 쌓을 주사위 아랫면 == 지금 쌓은 주사위의 윗면
			int idx = -1;
			for (int i = 0; i < 6; ++i) {
				int val = dices[cnt + 1][i];
				if (val == top) {
					idx = i;
					break;
				}
			}
			
			switch (idx) {
			case 0: // A --> F
				newTop = dices[cnt + 1][5];
				break;
			case 1: // B --> D
				newTop = dices[cnt + 1][3];
				break;
			case 2: // C --> E
				newTop = dices[cnt + 1][4];
				break;
			case 3: // D --> B
				newTop = dices[cnt + 1][1];
				break;
			case 4: // E --> C
				newTop = dices[cnt + 1][2];
				break;
			case 5: // F --> A
				newTop = dices[cnt + 1][0];
				break;
			}
		}
		
		findMaxDice(cnt + 1, newTop, top, sum + maxVal);
	}

}
