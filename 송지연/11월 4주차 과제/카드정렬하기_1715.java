import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기_1715 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			pq.add(Long.parseLong(bf.readLine()));
		}
		
		long answer = 0;
		while(pq.size() >= 2) {
			long a = pq.poll();
			long b = pq.poll();
			
			answer += a+b;
			pq.add(a+b);
		}
		
		System.out.println(answer);
	}

}
