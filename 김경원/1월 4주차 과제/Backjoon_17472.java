
// 백준 17472 다리 만들기 2
// 주소 : https://www.acmicpc.net/problem/17472


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_17472 {
	static class Node {
		int i, j;

		Node() {
		}

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		Edge() {
		}

		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
	}

	static int N, M;
	static int map[][] = new int[10][10];
	static boolean visit[][] = new boolean[10][10];
	static int island_cnt;
	static Queue<Node> q = new LinkedList();
	static List<Node> island[] = new ArrayList[7];
	static List<Edge> edge = new ArrayList();
	static int ni[] = { -1, 1, 0, 0 };
	static int nj[] = { 0, 0, -1, 1 };
	
	static int parent[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));

		for (int i = 1; i <= 6; i++)
			island[i] = new ArrayList();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken(" "));
				if (map[i][j] == 1)
					q.add(new Node(i, j));

			}
		}
		find_island();
		find_edge();
		kruskal();
		
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
//		
//		
//		for(int i=0;i<edge.size();i++) {
//				System.out.println(edge.get(i).from+" -> "+edge.get(i).to+" = "+edge.get(i).weight);
//		}
		

	}

	static void find_island() {
		int x, y;
	
		Node node;
		Queue<Node> nq = new LinkedList();

		while (!q.isEmpty()) {
			node = q.poll();
			if (visit[node.i][node.j])
				continue;
			island_cnt++;
			visit[node.i][node.j] = true;
			map[node.i][node.j] = island_cnt;
			island[island_cnt].add(new Node(node.i, node.j));
			nq.add(node);
			while (!nq.isEmpty()) {
				node = nq.poll();

				for (int d = 0; d < 4; d++) {
					x = node.i + ni[d];
					y = node.j + nj[d];
					if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] == 0 || visit[x][y])
						continue;

					visit[x][y] = true;
					map[x][y] = island_cnt;
					island[island_cnt].add(new Node(x, y));
					nq.add(new Node(x, y));
				}

			}

		}
		

	}
	static void find_edge() {

		Node node;
		int from, to, weight;
		int x, y;

		for (int i = 1; i <= island_cnt; i++) {
			for (int j = 0; j < island[i].size(); j++) {
				node = island[i].get(j);
				for (int d = 0; d < 4; d++) {
					x = node.i;
					y = node.j;
					from = i;
					to = 0;
					weight= 0;
					while (true) {
						x+= ni[d];
						y+= nj[d];
						if(x <0 || y< 0|| x>=N || y>=M || map[x][y]==i) break;
						
						if(map[x][y]!=0) {
							to = map[x][y];
							break;
						}
						weight++;
					}
					if(to!=0 && weight >= 2) 
						edge.add(new Edge(from,to,weight));
					
				}
			}
		}

	}
	static void kruskal() {
		
		int cnt=0;
		int result=0;		
		parent = new int[island_cnt+1];		
		for(int i=1;i<=island_cnt;i++) {
			parent[i]=i;
		}
		
		Collections.sort(edge);
		
		
		for(int i=0;i<edge.size() && cnt!=island_cnt-1;i++) {
			if(union(edge.get(i).from,edge.get(i).to)) {
			//	System.out.println(edge.get(i).from+" -> "+edge.get(i).to+" = "+edge.get(i).weight);
				result+= edge.get(i).weight;
				cnt++;
			}
		}
		if(cnt == island_cnt-1)
			System.out.println(result);
		else
			System.out.println(-1);
		
		
	}
	
	static int findSet(int n) {
		if(parent[n]==n)
			return n;
		return parent[n] = findSet(parent[n]);
	}
	
	static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot==bRoot)
			return false;
		
		parent[bRoot]=aRoot;
		
		return true;
	}
	
}
