package baekjoon.boj5;

import java.io.*;
import java.util.*;

public class BOJ_1927_최소힙 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer>queue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int oper = Integer.parseInt(br.readLine());
			if(oper==0) {
				if(queue.size()>0) {
					sb.append(queue.poll()+"\n");
				}
				else sb.append("0\n");
			}
			else queue.offer(oper);
		}
		System.out.println(sb);
	}
}
