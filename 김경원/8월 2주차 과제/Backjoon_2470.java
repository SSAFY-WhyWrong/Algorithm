import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon_2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long arr[] = new long[N];
		
		st = new StringTokenizer(br.readLine());
		
		
		
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(st.nextToken(" "));
		}
		Arrays.sort(arr);
		
		int start = 0;
		int end = N-1;
		long result = Long.MAX_VALUE;
		long num1=0, num2=0;
		while(start < end) {
			long sum = arr[start] + arr[end];
			
			if(Math.abs(sum) < result) {
				num1 = arr[start];
				num2 = arr[end];
				result = Math.abs(sum);
			}
			
			if(sum > 0)
				end--;
			
			else
				start++;
			
			
		}	
		
		
		
		System.out.println(num1+" "+num2);
	}
	

}
