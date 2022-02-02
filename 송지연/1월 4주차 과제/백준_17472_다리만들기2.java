import java.util.*;
import java.io.*;

public class 백준_17472_다리만들기2 {

	private static int N, M;
	private static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
	private static int[][] board;
	private static boolean[][] visit;
	private static PriorityQueue<Node> pq;
	private static ArrayList<Node>[] bridges;
	
	private static class Node implements Comparable<Node> {
		int edge;
		int weight;
		
		public Node(int edge, int weight) {
			this.edge = edge;
			this.weight = weight;
		}
		
		
		@Override
		public String toString() {
			return "Node [edge=" + edge + ", weight=" + weight + "]";
		}


		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 1;
		visit = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] != 0 && !visit[i][j]) {
					markIsland(i, j, cnt);
					cnt++;
				}
			}
		}
		
		pq = new PriorityQueue<>();
		bridges = new ArrayList[cnt];
		for(int i=0;i<cnt;i++) {
			bridges[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] != 0) {
					makeBridge(i, j);
				}
			}
		}
		
		
		System.out.println(mst(cnt));
	}
	
	private static int mst(int cnt) {
		int answer = 0;
		boolean[] visit = new boolean[cnt];
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visit[now.edge]) continue;
			
			answer += now.weight;
			visit[now.edge] = true;
			
			for(int i=0;i<bridges[now.edge].size();i++) {
				Node next = bridges[now.edge].get(i);
				
				if(!visit[next.edge]) {
					pq.add(next);
				}
			}
		}
		
		for(int i=1;i<cnt;i++) {
			if(!visit[i]) return -1;
		}
		
		if(answer == 0) answer = -1;
		return answer;
	}

	public static void makeBridge(int x, int y) {
		for(int d=0;d<4;d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			int cnt = 0;
			
			while(true) {
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
				if(board[nx][ny] == board[x][y]) break;
				
				if(board[nx][ny] != 0) {
					if(cnt >= 2) {
						bridges[board[x][y]].add(new Node(board[nx][ny], cnt));
					}
					break;
				}
				
				nx += dx[d];
				ny += dy[d];
				cnt++;
			}
		}
	}
	
	public static void markIsland(int x, int y, int mark) {
		board[x][y] = mark;
		
		for(int d=0;d<4;d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if(board[nx][ny] == 0 || visit[nx][ny]) continue;
			
			visit[nx][ny] = true;
			markIsland(nx, ny, mark);
		}
	}
}
