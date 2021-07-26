package day_0720;
import java.util.*;

public class Programmers_배달 {
	class Solution {
	    public int solution(int N, int[][] road, int K) {
	        int answer = 0;
	        int[][] arr = new int[N + 1][N + 1];
	        
	        for(int i = 1; i < N + 1; i++){
	            for(int j = 1; j < N + 1; j++){
	                arr[i][j] = -1;
	            }
	        }

	        for(int i = 0; i < road.length; i++){
	            int A = road[i][0];
	            int B = road[i][1];
	            int weight = road[i][2];
	            if(arr[A][B] == -1){
	                arr[A][B] = weight;
	                arr[B][A] = weight;
	            } else if(arr[A][B] > weight){
	                arr[A][B] = weight;
	                arr[B][A] = weight;
	            }
	            
	        }
	        
	        int[] distance = new int[N + 1];
	        boolean[] visited = new boolean[N + 1];
	        
	        Arrays.fill(distance, Integer.MAX_VALUE);
	        distance[1] = 0;
	        
	        PriorityQueue<Node> q = new PriorityQueue<Node>();
			q.offer(new Node(1, 0));

	        while(!q.isEmpty()){
	            Node cur = q.poll();
	            if(visited[cur.vertex]) continue;
	            
	            for(int i = 1; i < N + 1; i++){
	                if(!visited[i] && arr[cur.vertex][i] != -1 && distance[i] > cur.totalDistance + arr[cur.vertex][i]) {
	                    distance[i] = cur.totalDistance + arr[cur.vertex][i];
	                    q.offer(new Node(i, distance[i]));                
	                }
	            }
	        }
	        for(int i = 1; i < N + 1; i++){
	            if(distance[i] <= K){
	                answer++;
	            }
	        }
	        return answer;
	    }
	}
	static class Node implements Comparable<Node>{
		int vertex;
		int totalDistance;
		
		public Node(int vertex, int totalDistance) {
			this.vertex = vertex;
			this.totalDistance = totalDistance;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.totalDistance - o.totalDistance;
		}
	}
}
