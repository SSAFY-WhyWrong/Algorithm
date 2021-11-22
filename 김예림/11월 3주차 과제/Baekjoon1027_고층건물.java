package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1027_고층건물 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long[] building = new long[N];
		for(int i=0; i<N; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		
		for(int i=0; i<N; i++) {
			int x1 = i;
			long y1 = building[i];
			int cnt = 0;
			
			double pre1 = 0.0;
			double pre2 = 0.0;
			
			if(i-1 > 0) {
				pre1 = (double)y1-building[i-1];
				cnt++;
				int idx1 = i-2;
				while(true) {
					if(idx1 < 0) break;
					
					double inc = (double)(y1-building[idx1])/(x1-idx1);
					
					if(inc < pre1) {
						cnt++;
						pre1 = inc;
					}
					idx1--;
				}
			}
			
			if(i+1 < N) {
				pre2 = (double)building[i+1]-y1;
				cnt++;
				int idx2 = i+2;
				while(true) {
					if(idx2>=N) break;
					
					double inc = (double)(building[idx2]-y1)/(idx2-x1);
					
					if(inc > pre2) {
						cnt++;
						pre2 = inc;
					}
					idx2++;
				}
			}
			max = max<cnt?cnt:max;
		}
		System.out.println(max);
		//왜,,,,98퍼센트에서 틀리는거야...?
	}
}
/*
5
5 1 10 1 5

4

5
6 2 6 2 7

4

4
9 7 1 7

3
*/
