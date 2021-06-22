package day_0615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_16197 {
	static int N, M;
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		Queue<pos> q = new LinkedList<>();
	}
	
	
	static class pos{
		int i, j;
		public pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
