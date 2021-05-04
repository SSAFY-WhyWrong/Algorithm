package study_sovle;

import java.util.Arrays;

public class Programmers_비밀지도 {
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9, 20 ,28,18,11};
		int[] arr2 = {30,1,21,17,28};
		String[][] map1 = new String[n][n];
		String[][] map2 = new String[n][n];
		
		for(int i = 0 ; i < n; i++) {
			map1[i] = String.valueOf(jinsu(arr1[i], n)).split("");
			map2[i] = String.valueOf(jinsu(arr2[i], n)).split("");
		}
		String[] answer = new String[n];
		for(int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j< n;j++) {
				if(map1[i][j].equals("1") || map2[i][j].equals("1")) {
					sb.append("#");
				} else if(map1[i][j].equals("0") && map2[i][j].equals("0")) {
					sb.append(" ");
				}
			}
			answer[i] = String.valueOf(sb);
		}
		System.out.println(Arrays.toString(answer));
	}
	
	static StringBuilder jinsu(int num, int n) {
		StringBuilder sb = new StringBuilder();
		while(true) {
			sb.append(num%2);
			num = num/2;
			if(num == 0) {
				break;
			}
		}
		if(sb.length() < n) {
			while(true) {
				sb.append(0);
				if(sb.length() == n) {
					break;
				}
			}
		}
		sb.reverse();
		return sb;
	}
}
