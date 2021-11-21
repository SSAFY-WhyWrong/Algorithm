package 실패;

import java.util.Arrays;

public class GPS {
	//처음과 끝은 고정 
	//2번째부터 모든 노드를 탐색하면서 각 노드에 연결된 것중에 가장 적게 변경한 노드를 골라 연결 시킨다.
	//k-1번째까지 구한 후에 마지막 노드에 연결 시킬 가장 적게 변경한 노드 연결
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edge_list = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 6 }, { 5, 6 }, { 5, 7 },
				{ 6, 7 } };
		int[] gps = { 1, 2, 3, 3, 6, 7 };
		System.out.println(solution(7, 10, edge_list, 6, gps));
	}

	private static class node {
		int vertex;
		node next;

		public node(int vertex) {
			this.vertex = vertex;
		}

		public node(int vertex, node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}

	private static node[] array;

	public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		int answer = Integer.MAX_VALUE;
		array = new node[n + 1];
		for (int i = 0; i < m; i++) {
			if (array[edge_list[i][0]] == null) {
				array[edge_list[i][0]] = new node(edge_list[i][1]);
			} else {
				array[edge_list[i][0]] = new node(edge_list[i][1], array[edge_list[i][0]]);
			}
			if (array[edge_list[i][1]] == null) {
				array[edge_list[i][1]] = new node(edge_list[i][0]);
			} else {
				array[edge_list[i][1]] = new node(edge_list[i][0], array[edge_list[i][1]]);
			}
		}
		for (int i = 1; i < n + 1; i++) {
			if (array[i] == null)
				array[i] = new node(i);
			array[i] = new node(i, array[i]);
		}
		int[][] dp = new int[k][n + 1];
		for (int i = 0; i < k; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i != 0 || j != gps_log[0]) {
					dp[i][j] = Integer.MAX_VALUE - 100;
				} else {
					dp[i][j] = 0;
				}

			}
		}
		for (int i = 1; i < k - 1; i++) { // 0번쨰부터
			for (int j = 1; j < n + 1; j++) {
				for (node l = array[j]; l != null; l = l.next) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][l.vertex]);
				}
				if (j != gps_log[i])
					dp[i][j]++;
			}
		}
		for (node l = array[gps_log[k - 1]]; l != null; l = l.next) {
			answer = Math.min(answer, dp[k - 2][l.vertex]);
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		if (answer >= Integer.MAX_VALUE - 100)
			return -1;
		return answer;
	}

}
