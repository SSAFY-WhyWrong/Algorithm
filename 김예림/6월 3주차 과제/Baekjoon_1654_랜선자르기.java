package M06_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1654_랜선자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		long maxNum = 0;

		long[] lan = new long[K];
		for(int i=0; i<K; i++) {
			lan[i] = Integer.parseInt(br.readLine());

			maxNum = Math.max(maxNum, lan[i]);
		}

		long start = 1; //자연수이기 때문에 start는 1로 시작하기
		long end = maxNum;
		long ans = Long.MAX_VALUE; //범위를 잘 체크하고 int형인지, long형인지 결정하기

		while(true) {
			if(end < start) { //while문을 빠져나가는 break문 범위 설정 잘 하기
				ans = end;
				break;
			}

			long middle = (start+end)/2;
			long total = 0;

			for(int i=0; i<K; i++) {
				total += lan[i]/middle;
			}

			if(total < N) end = middle-1; //middle을 그대로 넣지 않고 조절해주기
			else start = middle+1;

		}
		System.out.println(ans);
	}
}
