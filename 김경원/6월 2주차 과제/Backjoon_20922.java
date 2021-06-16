import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_20922 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num[] = new int[200000];
		int cnt[] = new int[100001];
		int N,K;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" "));
		K = Integer.parseInt(st.nextToken(" "));
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken(" "));
		}		
		
		int head=0, tail=0;
		int result=0;
		while(head<N && tail < N) {
			cnt[num[tail]]++;
			if(cnt[num[tail]] > K) {				
				while(cnt[num[tail]]>K) {
					cnt[num[head]]--;
					head++;
				}
			}
			result = Math.max(result, tail-head+1);
			tail++;
		}
		
		System.out.println(result);
		
		
		
	}
}
