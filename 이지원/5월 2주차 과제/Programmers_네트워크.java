package day_0505;
import java.util.*;

public class Programmers_네트워크 {
	static boolean[] visited;
	public int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				answer++;
				bfs(i, n, computers);
			}
		}

		return answer;
	}

	static void bfs(int i, int n, int[][] arr) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		visited[i] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int d = 0; d < n; d++) {
				if (visited[d])
					continue;
				if (arr[cur][d] == 0)
					continue;
				q.add(d);
				visited[d] = true;
			}
		}
	}
}
