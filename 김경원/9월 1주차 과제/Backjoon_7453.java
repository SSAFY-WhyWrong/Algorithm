import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon_7453 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[4][N];
		int nSquare = N*N;
		int sum[][] = new int[2][nSquare];
		
		for(int j=0;j<N;j++) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sum[0][i*N+j] = arr[0][i] + arr[1][j];
				sum[1][i*N+j] = arr[2][i] + arr[3][j];
			}
		}
		
		Arrays.sort(sum[0]);
		Arrays.sort(sum[1]);
		
		int result = 0;
		
		for(int num : sum[0]) {
			int high = upper_bound(sum[1],-num);
			int low = lower_bound(sum[1],-num);
			
			result += high - low;
		}
		
		System.out.println(result);
		
	}

	private static int lower_bound(int[] arr, int num) {

		int start =0;
		int end = arr.length;
		int mid;
		while(start < end) {
			mid = (start+end)/2;
			if(arr[mid]>= num)
				end = mid;
			else
				start = mid+1;
		}
		
		
		return start;
	}

	private static int upper_bound(int[] arr, int num) {

		int start =0;
		int end = arr.length;
		int mid;
		while(start < end) {
			mid = (start+end)/2;
			if(arr[mid]<= num)
				start = mid+1;
			else
				end = mid;
		}		
		
		return start;
	
	}
}
