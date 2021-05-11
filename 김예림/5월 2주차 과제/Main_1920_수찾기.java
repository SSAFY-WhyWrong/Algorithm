package M05_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_수찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] find = new int[M];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<M; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		Arrays.sort(num);
		for(int i=0; i<M; i++) {
			int start = 0;
			int end = N-1;
			int mid = 0;
			while(true) {
				if(end-start == 1) {
					if(num[start]==find[i] || num[end]==find[i]) {
						sb.append(1+"\n");
						break;
					}
					sb.append(0+"\n");
					break;
				}
				
				mid = (end+start)/2;
				if(find[i]>num[mid]) start = mid;
				else if(find[i]<num[mid]) end = mid;
				else if(find[i] == num[mid]) {
					sb.append(1+"\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
