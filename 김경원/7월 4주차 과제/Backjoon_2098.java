import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_2098 {
	static class Node implements Comparable<Node>{
		 int idx,weight;
		 Node(int idx, int weight){
			 this.idx = idx;
			 this.weight = weight;
		 }
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	
	static final int MAX_WEIGHT = 20000000; 
	static int dist[][];
	static int edge[][];
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
				
		N = Integer.parseInt(br.readLine());
		
		
		edge = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int weight = Integer.parseInt(st.nextToken(" "));
				if(weight == 0) weight = MAX_WEIGHT;
				edge[i][j] = weight;
			}
		}
		
		
		dist = new int[N][1 << N];
		
		for(int i=0;i<N;i++)
			Arrays.fill(dist[i], MAX_WEIGHT);
		
		

		System.out.println(TSP(0,0));
		


		
		
	}
	static int TSP(int now,int bit) {
		
		
		if(bit == (1 << N) - 1) {			
			return edge[now][0];
		}
		
		
		if(dist[now][bit]!=MAX_WEIGHT)
			return dist[now][bit];
		
		for(int i=0;i<N;i++) {			
			if(edge[now][i]!=MAX_WEIGHT && (bit & (1 << i)) == 0 ) {
				dist[now][bit] = Math.min(dist[now][bit], TSP(i, bit | 1 << i) + edge[now][i]);
			}
		}
		
		
		
		return dist[now][bit];
	}
}
