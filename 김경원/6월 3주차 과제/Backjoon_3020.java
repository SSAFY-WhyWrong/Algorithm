import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N, H, result;
		int num;
		N = Integer.parseInt(st.nextToken(" "));
		H = Integer.parseInt(st.nextToken(" "));
		result = N;
		int up[] = new int[H+1];
		int down[] = new int[H+1];

		for (int i = 0; i < N / 2; i++) {
			num = Integer.parseInt(br.readLine());
			down[num]++;
			num = Integer.parseInt(br.readLine());
			up[H-num+1]++;			
		}

		
		for(int h=1;h<=H;h++) {
			up[h] += up[h-1];
		}
		
		for(int h=H-1;h>0;h--) {
			down[h] += down[h+1];
		}
		
//		for(int h=1;h<=H;h++) {
//			System.out.println(h+" : "+down[h]+" "+up[h]);
//		}
		
		int cnt=0;
		
		for(int h=1;h<=H;h++) {
			if(result > up[h] + down[h]){
				result = up[h] + down[h];
				cnt = 1;
			}else if(result == up[h]+down[h]) {
				cnt++;
			}
		}
		
		System.out.println(result+" "+cnt);
	}
}
