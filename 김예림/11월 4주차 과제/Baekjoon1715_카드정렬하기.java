package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon1715_카드정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		int tot = 0;
		//제일 앞에 두 개 빼서 더하고 넣기
		for(int i=1; i<N; i++) {
			int num = pq.poll()+pq.poll();
			
			pq.offer(num);
			tot += num;
		}
		System.out.println(tot);
	}
}
/*
10
10
10
10
10
10
10
10
10
10
10
340

4
10
10
10
100
180

*/
