import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon_1300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		long K = Long.parseLong(br.readLine());
		
		
		
		long result = 0;
		long low,mid,high;
		
		low = 1;
		high = N*N;
		
		
		while(low<=high) {
			long cnt = 0;
			
			mid = (low+high)/2;
			
			for(int i=1;i<=N;i++) {
				cnt += Math.min(mid /i, N);
			}
			
			
			if(cnt >= K) {
				result = mid;
				high = mid-1;
			}else {
				low = mid+1;
			}
			
			
		}
		
		System.out.println(result);
	}
}
