import java.util.*;
import java.io.*;

public class 백준_2887_행성터널 {
	
	static int[][] location;
	static Planet[] planet;
	static int[] parent;
	static int result, N;
	static PriorityQueue<Edge> q;
	
	public static class Planet {
		int idx;
		int x;
		int y;
		int z;
		
		public Planet(int idx, int x, int y, int z) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static class Edge implements Comparable<Edge>{ // 간선 정보
        int s;
        int e;
        int cost;
        
        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
 
        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		planet = new Planet[N];

		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			planet[i] = new Planet(i, x, y, z); 
		}
		
		q = new PriorityQueue<>();
        
        Arrays.sort(planet, (o1, o2) -> o1.x - o2.x);
        for(int i=0;i<N-1;i++) {
            q.offer(new Edge(planet[i].idx, planet[i + 1].idx, Math.abs(planet[i].x - planet[i + 1].x)));
        }
        
        Arrays.sort(planet, (o1, o2) -> o1.y - o2.y);
        for(int i=0;i<N-1;i++) {
            q.offer(new Edge(planet[i].idx, planet[i + 1].idx, Math.abs(planet[i].y - planet[i + 1].y)));
        }
        
        Arrays.sort(planet, (o1, o2) -> o1.z - o2.z);
        for(int i=0;i<N-1;i++) {
            q.offer(new Edge(planet[i].idx, planet[i + 1].idx, Math.abs(planet[i].z - planet[i + 1].z)));
        }
        
        parent = new int[N];
        kruskal();
        System.out.println(result);
	}
	
	public static void kruskal() {
        for(int i=0; i<N; i++) {
            parent[i] = i;
        }
        
        while(!q.isEmpty()) {
            Edge edge = q.poll();
            int p1 = find(edge.s);
            int p2 = find(edge.e);
            
            if(p1 != p2) {
                union(p1, p2);
                result += edge.cost;
            }
        }
    }
    
    public static void union(int a, int b) {
        parent[a] = b;
    }
    
    public static int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
	
}
