package M04_5;

import java.util.Scanner;
//이클립스 코드
public class Solution_비밀지도 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr1 = new int[n];
		for(int i=0; i<n; i++) {
			arr1[i] = sc.nextInt();
		}
		
		int[] arr2 = new int[n];
		for(int i=0; i<n; i++) {
			arr2[i] = sc.nextInt();
		}
		
		int[][] key1 = new int[n][n];
		for(int i=0; i<n; i++) {
			int tmp = arr1[i];
			for(int j=n-1; j>=0; j--) {
				key1[i][j] = tmp%2;
				tmp = tmp/2;
			}
		}
		int[][] key2 = new int[n][n];
		for(int i=0; i<n; i++) {
			int tmp = arr2[i];
			for(int j=n-1; j>=0; j--) {
				key2[i][j] = tmp%2;
				tmp = tmp/2;
			}
		}
		
		String[] answer = new String[n];
		for(int i=0; i<n; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<n; j++) {
				if(key1[i][j] == 1 || key2[i][j] == 1) sb.append("#");
				else sb.append(" ");
			}
			answer[i] = sb.toString();
		}
		
		sc.close();
	}
}
/*
5
9 20 28 18 11
30 1 21 17 28 
*/
//프로그래머스 코드
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
       int[][] key1 = new int[n][n];
		for(int i=0; i<n; i++) {
			int tmp = arr1[i];
			for(int j=n-1; j>=0; j--) {
				key1[i][j] = tmp%2;
				tmp = tmp/2;
			}
		}
		int[][] key2 = new int[n][n];
		for(int i=0; i<n; i++) {
			int tmp = arr2[i];
			for(int j=n-1; j>=0; j--) {
				key2[i][j] = tmp%2;
				tmp = tmp/2;
			}
		}
		
		for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
			for(int j=0; j<n; j++) {
				if(key1[i][j] == 1 || key2[i][j] == 1) sb.append("#");
				else sb.append(" ");
			}
            answer[i] = sb.toString();
		}
        
        return answer;
    }
}
