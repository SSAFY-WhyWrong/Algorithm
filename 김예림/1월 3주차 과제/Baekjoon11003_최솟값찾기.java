package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon11003_최솟값찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] num = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Deque<Number> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());

			while(!dq.isEmpty() && dq.peekLast().val>num[i]) {
				dq.removeLast(); //제일 큰 값은 빼기
			}

			dq.addLast(new Number(i, num[i]));
			if(dq.peekFirst().idx < i-(L-1)) dq.removeFirst();
			
			sb.append(dq.peekFirst().val+" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	static class Number{
		int idx; 
		int val;
		public Number(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
}
