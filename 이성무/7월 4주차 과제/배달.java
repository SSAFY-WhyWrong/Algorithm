package 실패;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 배달 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int k = 3;
		System.out.println(solution(N,road,k));
	}

	private static class node implements Comparable<node> {
		int e, d;

		public node(int e, int d) {
			this.e = e;
			this.d = d;
		}

		public int compareTo(node o) {
			return this.d - o.d;
		}
	}

	public static int solution(int N, int[][] road, int K) {
		int answer = 0;
		int[] ans = new int[N+1];
		boolean[] bool = new boolean[N+1];
		PriorityQueue<node> pq = new PriorityQueue<>();
		LinkedList<node>[] list = new LinkedList[N+1];
		for (int j = 1; j < N + 1; j++) {
			list[j] = new LinkedList<>();
			ans[j] = Integer.MAX_VALUE;
		}
		for (int j = 0; j < road.length; j++) {
			list[road[j][0]].add(new node(road[j][1],road[j][2]));
			list[road[j][1]].add(new node(road[j][0],road[j][2]));
		}
//		for (int i = 0; i < list[1].size(); i++) {
//			ans[list[1].get(i).e] = list[1].get(i).d;
//		}
		ans[1] = 0;
//		System.out.println(Arrays.toString(ans));
		int cnt = 1;
		pq.add(new node(1,0));
		node a,c;
		while(cnt<=N) {
			a = pq.poll();
			if(bool[a.e])continue;
			bool[a.e] = true;
			for (int i = 0; i < list[a.e].size(); i++) {
				c = list[a.e].get(i);
				if(!bool[c.e]&&ans[c.e]>ans[a.e]+c.d) {
					ans[c.e] = ans[a.e]+c.d;
					pq.add(new node(c.e,ans[c.e]));
				}
			}
			cnt++;
		}
//		System.out.println(Arrays.toString(ans));
		for (int i = 1; i < N+1; i++) {
			if(ans[i]<=K)answer++;
		}
		return answer;
	}
}
