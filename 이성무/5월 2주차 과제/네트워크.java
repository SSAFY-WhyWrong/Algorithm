package 성공;

public class 네트워크 {

	private static int[] net;
	//DisjointSet
	//모두 자기 자신을 갖게 만들어준다.
	private void makeSet(int n) {
		net = new int[n];
		for (int i = 0; i < n; i++) {
			net[i] = i;
		}
	}
	//자기 자신을 가지고 있는 모체를 찾는다.
	private int findSet(int n) {
		if (net[n] == n) {
			return n;
		}
		//찾으면서 모체를 갖게 해준다.
		return net[n] = findSet(net[n]);
	}
	//내 모체가 상대 모체를 가지게 한다.
	private void union(int x, int y) {
		int yroot = findSet(y);
		int xroot = findSet(x);
		if(yroot<xroot)net[yroot] = net[xroot];
		else net[xroot] = net[yroot];

	}

	public int solution(int n, int[][] computers) {
		int answer = 0;
		makeSet(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (computers[i][j] == 1) {
					union(i, j);
				}
			}
		}
		//자기 자신이 배열값이면 자기가 모체이므로 모체 갯수를 카운트
		for (int i = 0; i < n; i++) {
			if (net[i] == i) {
				answer++;
			}
		}
		return answer;
	}

}
