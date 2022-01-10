import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_2573 {
	
	
	static class Node{
		int i,j, num;
		
		Node(int i,int j, int num){
			this.i = i;
			this.j = j;
			this.num = num;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N,M;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		
		int[][] arr = new int[N][M];
		
		Queue<Node> q = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
				if(arr[i][j] != 0) {
					q.add(new Node(i,j,arr[i][j]));
				}
			}
		}
		
	
		
		int[] ni = {-1,1,0,0};
		int[] nj = {0,0,-1,1};
		int answer = 0;
		while(!q.isEmpty()) {			
			int q_size = q.size();
			if(isDivided(q.peek(), q_size,arr, N,M)){		
				break;
			}
			for(int _q=0;_q < q_size;_q++) {
				Node node = q.poll();
				int cnt = 0;
				for(int d=0;d<4;d++) {
					int y = node.i + ni[d];
					int x = node.j + nj[d];
					
					if(x < 0 || y < 0 || x>= M || y>= N) {
						continue;
					}
					
					if(arr[y][x] == 0) {
						cnt ++;
					}
					
				}
				if(arr[node.i][node.j] > cnt) {
					q.add(new Node(node.i,node.j,node.num - cnt));
				}
				
			}
			
			int next_q = q.size();
			arr = new int[N][M];
			for(int i=0;i<next_q;i++) {
				Node node = q.poll();
				arr[node.i][node.j] = node.num;
				q.add(node);
			}
			
			
			answer++;
		}
		
		if(q.size() != 0) {
			System.out.println(answer);
		}
		else {
			System.out.println(0);
		}

		
	}
	
	
	static boolean isDivided(Node start,int total,int[][] arr, int N, int M) {
		
		int cnt = 1;
		Queue<Node> q = new LinkedList();
		q.add(start);
		
		int[] ni = {-1,1,0,0};
		int[] nj = {0,0,-1,1};
		
		boolean[][] visited = new boolean[N][M];
		visited[start.i][start.j] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int d=0;d<4;d++) {
				int y = node.i + ni[d];
				int x = node.j + nj[d];
				if(x<0 || y<0 || x>=M || y>=N || arr[y][x] == 0 || visited[y][x]) {
					continue;
				}
				cnt++;
				visited[y][x] = true;
				q.add(new Node(y,x,0));				
			}
		}
		
		if(cnt == total) {
			return false;
		}		
		
		
		return true;
	}
}
