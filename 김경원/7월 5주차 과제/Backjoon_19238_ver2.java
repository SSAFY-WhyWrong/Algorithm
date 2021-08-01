import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_19238_ver2 {

	static public class Client implements Comparable<Client> {
		int pos_x, pos_y;
		int target_x, target_y;
		int way_len;

		Client(int pos_x, int pos_y, int target_x, int target_y) {
			this.pos_x = pos_x;
			this.pos_y = pos_y;
			this.target_x = target_x;
			this.target_y = target_y;
		}

		@Override
		public int compareTo(Client o) {
			if (this.way_len == o.way_len) {
				if (this.pos_x == o.pos_x)
					return this.pos_y - o.pos_y;
				return this.pos_x - o.pos_x;

			}

			return this.way_len - o.way_len;
		}

	}

	static public class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N, M, fuel;
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		fuel = Integer.parseInt(st.nextToken(" "));

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}

		int car_x, car_y;
		st = new StringTokenizer(br.readLine());
		car_x = Integer.parseInt(st.nextToken(" ")) - 1;
		car_y = Integer.parseInt(st.nextToken(" ")) - 1;

		int cli_x, cli_y;

		int target_x, target_y;

		List<Client> list = new ArrayList();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			cli_x = Integer.parseInt(st.nextToken(" ")) - 1;
			cli_y = Integer.parseInt(st.nextToken(" ")) - 1;
			target_x = Integer.parseInt(st.nextToken(" ")) - 1;
			target_y = Integer.parseInt(st.nextToken(" ")) - 1;
			list.add(new Client(cli_x, cli_y, target_x, target_y));
		}

		int cnt = 0;

		int[] ni = { -1, 1, 0, 0 };
		int[] nj = { 0, 0, -1, 1 };

		int[][] way = new int[N][N];

		boolean isFail = false;

		while (list.size() > 0) {
			getWay(way, car_x, car_y, N);

			for (int i = 0; i < list.size(); i++) {
				Client client = list.get(i);
				if (way[client.pos_x][client.pos_y] == -1)
					client.way_len = Integer.MAX_VALUE;
				else
					client.way_len = way[client.pos_x][client.pos_y];
			}
			// 거리 구하기 끝

			Collections.sort(list);
			Client client = list.get(0);
			fuel -= client.way_len;

			if (fuel < 0) {
				isFail = true;
				break;
			}

			int dist = getDist(N, client);

			if (dist > fuel) {
				isFail = true;
				break;
			}

			fuel += dist;
			
			car_x = client.target_x;
			car_y = client.target_y;
			list.remove(0);
		}

		if (isFail)
			System.out.println(-1);
		else
			System.out.println(fuel);

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(way[i][j] + " ");
//			}
//			System.out.println();
//		}

	}

	static void getWay(int[][] way, int car_x, int car_y, int N) {
		int[] ni = { -1, 1, 0, 0 };
		int[] nj = { 0, 0, -1, 1 };
		int time = 0;

		for (int i = 0; i < N; i++)
			Arrays.fill(way[i], -1);
		way[car_x][car_y] = 0;

		Queue<Node> q = new LinkedList();
		q.add(new Node(car_x, car_y));

		while (!q.isEmpty()) {
			int q_size = q.size();
			Node node;
			for (int _q = 0; _q < q_size; _q++) {
				node = q.poll();

				for (int d = 0; d < 4; d++) {
					int x = node.x + ni[d];
					int y = node.y + nj[d];
					if (x < 0 || y < 0 || x >= N || y >= N || way[x][y] != -1 || map[x][y] == 1)
						continue;

					way[x][y] = time + 1;
					q.add(new Node(x, y));

				}

			}
			time++;
		}
	}

	static int getDist(int N, Client client) {
		int dist = 0;
		boolean visit[][] = new boolean[N][N];
		int[] ni = { -1, 1, 0, 0 };
		int[] nj = { 0, 0, -1, 1 };

		Queue<Node> q = new LinkedList();
		q.add(new Node(client.pos_x, client.pos_y));
		visit[client.pos_x][client.pos_y] = true;

		while (!q.isEmpty()) {
			int q_size = q.size();
			for (int _q = 0; _q < q_size; _q++) {
				Node node = q.poll();

				for (int d = 0; d < 4; d++) {
					int x = node.x + ni[d];
					int y = node.y + nj[d];
					if (x < 0 || y < 0 || x >= N || y >= N || visit[x][y] || map[x][y] == 1)
						continue;

					visit[x][y] = true;
					q.add(new Node(x, y));
				}
			}
			dist++;
			if (visit[client.target_x][client.target_y])
				break;
		}

		if (visit[client.target_x][client.target_y])
			return dist;
		else
			return Integer.MAX_VALUE;
	}

}
