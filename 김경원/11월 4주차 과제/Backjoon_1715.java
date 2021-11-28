import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Backjoon_1715 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N;
		int sum = 0;
		
		
		N = Integer.parseInt(br.readLine());
		
		
		
		for(int i=0;i<N;i++) {			
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		while(!pq.isEmpty()) {
			int a = pq.poll();
			if(!pq.isEmpty()) {
				int b = pq.poll();
				sum += a+b;
				pq.add(a+b);
			}
		}
		
		System.out.println(sum);
	}
	
}
