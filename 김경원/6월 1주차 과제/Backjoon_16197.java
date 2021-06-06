import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_16197 {
	static class Node{
		int i,j;
		Node(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	static char map[][] = new char[20][20];
	static int N,M; //세로N 가로M
	static int result;
	static int ni[] = {-1,1,0,0};
	static int nj[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Node> q = new LinkedList();
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		
		String s;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken(" ");
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] =='o') {
					q.add(new Node(i,j));
					map[i][j] = '.';
				}
			}
		}
		
		result = 11;
		simulate(1, q);
		if(result!=11)
			System.out.println(result);
		else
			System.out.println(-1);
		
	}
	private static void simulate(int time, Queue<Node> q) {
				
		if(time >= result)
			return;
		
		
		for(int d=0;d<4;d++) {
			Node coin[] = new Node[2];
			int x,y;
			int drop=0;
			for(int i=0;i<2;i++) {
				coin[i] = q.poll();
				x = coin[i].i + ni[d];
				y = coin[i].j + nj[d];
				
				if(x<0 || x>= N || y<0 || y>=M) {
					drop++;
					continue;
				}
				
				
				if(map[x][y] == '#') {
					x -= ni[d];
					y -= nj[d];
				}
				q.add(new Node(x,y));
			}
			
			if(drop==0) {
				boolean isSame = true;
				for(int i=0;i<2;i++) {
					Node node = q.poll();
					if(node.i != coin[i].i || node.j != coin[i].j)
						isSame = false;
					q.add(node);
				}
				if(!isSame)
					simulate(time+1, q);
			}
			else if(drop==1) {
				result = Math.min(result, time);
				return;
			}		
			q.clear();
			for(int i=0;i<2;i++) {
				q.add(coin[i]);
			}
			
			
		}
		
		
	}
}
