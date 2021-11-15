import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon_1027 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N; 
		N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];		
		int count[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		
		
		for(int i=0;i<N-1;i++) {
			count[i] += 1;
			count[i+1] +=1;
			
			double slope = arr[i+1] - arr[i];
			for(int j=i+2; j<N;j++) {
				double nextSlope = (double) (arr[j]-arr[i]) / (j-i);
				if(nextSlope <= slope) continue;
				
				slope = nextSlope;
				count[i]++;
				count[j]++;
				
			}
			
			
		}
		
		Arrays.sort(count);
		System.out.println(count[N-1]);
		
		
	}

}
