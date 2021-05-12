import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_3079 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N,M;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		
		int arr[] = new int[N];
		long max_time = 0;
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max_time = Math.max(max_time, arr[i]);
		}
		
		
		long low=0, high= max_time * M;
		long mid;
		long cnt;
		long result=low + high;
		
		while(low <= high) {
			mid = (low + high)/2;
			cnt = 0;
			
			for(int i=0;i<N;i++) {
				cnt += mid/arr[i];
			}
			if(cnt >= M) { 
				high = mid-1;
				result = mid;
			}
			else 
				low = mid+1;
									
		}
		
		System.out.println(result);
		
		
		
	}
}
