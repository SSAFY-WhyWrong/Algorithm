package day_0711;

import java.util.*;

public class Programmers_가장먼노드 {
	class Solution {
		public int solution(int n, int[][] edge) {
			int answer = 0;
			boolean[][] visited = new boolean[n][n];
			boolean[] vertex = new boolean[n];
			for (int i = 0; i < edge.length; i++) {
				visited[edge[i][0] - 1][edge[i][1] - 1] = true;
				visited[edge[i][1] - 1][edge[i][0] - 1] = true;
			}
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			vertex[0] = true;
			int size = 0;
			while (!q.isEmpty()) {
				size = q.size();
				for (int s = 0; s < size; s++) {
					int cur = q.poll();
					for (int i = 0; i < n; i++) {
						if (vertex[i])
							continue;
						if (!visited[cur][i])
							continue;
						q.add(i);
						vertex[i] = true;
						visited[cur][i] = true;
					}
				}
			}
			answer = size;
			return answer;
		}
	}
}
