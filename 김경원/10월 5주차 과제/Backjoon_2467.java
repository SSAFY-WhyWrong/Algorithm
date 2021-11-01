import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2467 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		
		int p1=0, p2=N-1;
		int a = num[p1],b = num[p2];
		int sum = Math.abs(a+b);
		
		
		while(p1<p2) {
			int temp = num[p1] + num[p2];
			
			if(sum > Math.abs(temp)) {
				a = num[p1];
				b = num[p2];
				sum = Math.abs(temp);
			}	
			
			
			if(temp > 0)
				p2--;			
			
			if(temp <0)
				p1++;
			
			if(temp ==0)
				break;
			
			
		}
		System.out.println(a+" "+b);
		
	}
}
