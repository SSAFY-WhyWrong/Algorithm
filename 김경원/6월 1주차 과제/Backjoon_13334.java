import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Backjoon_13334 {
	static class Node implements Comparable<Node> {
		int start, end;

		Node(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Node o) {
			if (this.end == o.end)
				return this.start - o.start;

			return this.end - o.end;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N, d, max_cnt;
		int start, end;

		List<Node> list = new ArrayList();
		PriorityQueue<Integer> pq = new PriorityQueue();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken(" "));
			end = Integer.parseInt(st.nextToken(" "));
			if (start < end)
				list.add(new Node(start, end));
			else
				list.add(new Node(end, start));
		}

		d = Integer.parseInt(br.readLine());

		Collections.sort(list);

		max_cnt = 0;
		start = 100;

		for (int i = 0; i < N; i++) {
			if (list.get(i).end - list.get(i).start > d)
				continue;

			if (!pq.isEmpty() && list.get(i).end > pq.peek() + d) { // 포함할 수 없는 경우
				// 다음 목표의 end가 start + d 보다 크면 start를 새로 갱신 해 주어야함
				while (!pq.isEmpty() && list.get(i).end > pq.peek()+d) {
					pq.poll();
				}

			}

			pq.add(list.get(i).start);
			max_cnt = Math.max(max_cnt, pq.size());

		}

		System.out.println(max_cnt);

	}
}
