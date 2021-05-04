import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_2583 {
	
	static class Node {
		int i,j;
		Node(){}
		Node(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	
	static boolean visit[][];
	static int M,N,K;	
	static PriorityQueue<Integer> result = new PriorityQueue();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken(" "));
		N = Integer.parseInt(st.nextToken(" "));
		K = Integer.parseInt(st.nextToken(" "));
		
		visit = new boolean[M][N];
		
		int x1,y1 ,x2,y2;
		
		for(int n=0;n<K;n++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken(" "));
			y1 = Integer.parseInt(st.nextToken(" "));
			x2 = Integer.parseInt(st.nextToken(" "));
			y2 = Integer.parseInt(st.nextToken(" "));
			
			for(int i=y1;i<y2;i++) {
				for(int j=x1;j<x2;j++) {
					visit[i][j] = true;
				}
			}
						
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) BFS(i,j);
			}
		}
		
		
		System.out.println(result.size());
		while(!result.isEmpty()) {
			System.out.print(result.poll()+" ");
		}
		
		
	}
	
	static void BFS(int start_i, int start_j) {
		int ni[] = {-1,1,0,0};
		int nj[] = {0,0,-1,1};
		
		Queue<Node> q = new LinkedList();
		
		int cnt = 1;
		visit[start_i][start_j] = true;
		q.add(new Node(start_i, start_j));
		
		
		int x,y;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int d=0;d<4;d++) {
				x = node.i + ni[d];
				y = node.j + nj[d];
				
				if(x< 0 || y<0 || x>=M || y>=N || visit[x][y]) continue;
				
				visit[x][y] = true;
				cnt++;
				q.add(new Node(x,y));
				
			}
		}
		
		result.add(cnt);
		
	}
	
}
