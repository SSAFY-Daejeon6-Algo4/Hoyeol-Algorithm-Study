/*
 * This is not my code
 * (https://lovelyunsh.tistory.com/25)
 */

package com.ssafy.algorithm.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158 {
	
	static int dr[] = {1,1,-1,-1};
	static int dc[] = {1,-1,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken()); //q가 컬럼
		int p = Integer.parseInt(st.nextToken()); //p가 로우
		int t = Integer.parseInt(br.readLine());
		int x = (q+t)%(2*W);
		int y = (p+t)%(2*H);
		
		x = W - Math.abs(W-x);
		y = H - Math.abs(H-y);
		
		//System.out.println(x+" "+y);
        sb.append(x).append(" ").append(y);
        System.out.println(sb.toString());
	}

}