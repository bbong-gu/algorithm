package baekjoon.boj1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17136_색종이붙이기 {

	static int length = 10;
	static int[][] area = new int[length][length];
	static int[] paperCount = new int[6];
	static boolean isBreak = false;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count = 0;
		for (int i = 0; i < length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < length; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 5; i > 0 ; i--) {
			checkArea(i);
		}
//		for (int i = 0; i < length; i++) {
//			for (int j = 0; j < length; j++) {
//				System.out.print(area[i][j]+" ");
//			}
//			System.out.println();
//		}
//		for (int i = 0; i < length; i++) {
//			for (int j = 0; j < length; j++) {
//				if(area[i][j] == 1) isBreak = true;
//			}
//		}
		if(isBreak) System.out.println("-1");
		else {
			for (int i = 0; i < paperCount.length; i++) {
				count += paperCount[i];
//				System.out.println("paper" + paperCount[i]);
			}
			System.out.println(count);
		}
	}
	private static void checkArea(int n) {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				for (int k = 4; k >= 0; k--) {
					if(paperCount[k]>5) return;
				}
				if(area[i][j] == 1) {
					checkLength(i, j, n);
				}
			}
		}
	}
	private static void checkLength(int row, int col, int n) {
		int k;
		if(n%2 == 1) {
			k = (n-1)/2;
			if(row-k < 0 || row+k >= length || col-k<0 || col+k>=length) return;
			for (int i = row-k; i <= row+k; i++) {
				for (int j = col-k; j <= col+k; j++) {
					if(area[i][j] != 1) return;
				}
			}
			for (int i = 0; i < paperCount.length; i++) {
				if(paperCount[i] == 5) isBreak = true;
			}
			if(!isBreak) {
				fillArea2(row-k, row+k, col-k, col+k);
				paperCount[n]++;				
			}
		} else {
			k = n/2;
			if(checkEven(row-k, row+k-1, col-k, col+k-1)) {
				for (int i = 0; i < paperCount.length; i++) {
					if(paperCount[i] == 5) isBreak = true;
				}
				if(!isBreak) {
					fillArea2(row-k, row+k-1, col-k, col+k-1);
					paperCount[n]++;					
				}
			}
			if(checkEven(row-k+1, row+k, col-+1, col+k)) {
				for (int i = 0; i < paperCount.length; i++) {
					if(paperCount[i] == 5) isBreak = true;
				}
				if(!isBreak) {
					fillArea2(row-k+1, row+k, col-k+1, col+k);
					paperCount[n]++;					
				}
			}
			
		}
//		System.out.println(n+" "+paperCount[n]);
		
	}
	private static boolean checkEven(int row1, int row2, int col1, int col2) {
		if(row1 < 0 || row2 >= length || col1 < 0 || col2 >= length) return false;
		for (int i = row1; i <= row2; i++) {
			for (int j = col1; j <= col2; j++) {
				if(area[i][j] != 1) return false;
			}
		}
		return true;
	}
	private static void fillArea2(int row1, int row2, int col1, int col2) {
		for (int i = row1; i <= row2; i++) {
			for (int j = col1; j <= col2; j++) {
				area[i][j] = 2;
			}
		}
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(area[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
//		System.out.println(row1+" "+row2+" "+col1+" "+col2);
		
	}

}
