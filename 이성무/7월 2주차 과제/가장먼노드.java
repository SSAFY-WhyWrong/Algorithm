package 실패;

import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		System.out.println(solution(6, edge));
	}

	private static Queue<Integer> queue;

	// 노드가 간선보다 비교적 커서 연결리스트 사용
	private static class node {
		int val;
		node next;

		public node(int val, node next) {
			this.val = val;
			this.next = next;
		}

		public node(int val) {
			super();
			this.val = val;
		}
	}

	public static int solution(int n, int[][] edge) {
		int answer = 0, index, size;
		node[] array = new node[n + 1];
		// 양방향 으로 세팅
		for (int i = 0; i < edge.length; i++) {
			index = edge[i][0];
			array[index] = array[index] == null ? new node(edge[i][1]) : new node(edge[i][1], array[index]);
			index = edge[i][1];
			array[index] = array[index] == null ? new node(edge[i][0]) : new node(edge[i][0], array[index]);
		}
		// bfs로 처리하기 위한 queue
		queue = new LinkedList<>();
		queue.add(1);
		int cnt = 0;
		// 방문처리를 위한 배열
		boolean[] bool = new boolean[n + 1];
		// 1번 방문처리
		bool[1] = true;
		// 큐가 빌때까지
		while (!queue.isEmpty()) {
			size = queue.size();
			cnt = 0;
			// 최대로 가는 갯수를 세기 위해 이동 횟수 별로 처리
			for (int i = 0; i < size; i++) {
				index = queue.poll();
				for (node j = array[index]; j != null; j = j.next) {
					if (!bool[j.val]) {
						bool[j.val] = true;
						cnt++;
						queue.add(j.val);
					}
				}
			}
			// 마지막 처리를 제외하고 answer 갱신
			if (cnt != 0) {
				answer = cnt;
			}
		}
		return answer;
	}
}
