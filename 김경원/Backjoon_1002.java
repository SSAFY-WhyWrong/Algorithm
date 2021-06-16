
// 백준 1002 터렛
// 주소 : https://www.acmicpc.net/problem/1002


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1002 {
	static boolean visit[][] = new boolean[10000][10000];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int x1,y1,r1, x2,y2,r2;
		double distance;
		int r_sum, r_sub;
		
		
		int t_case;
		st = new StringTokenizer(br.readLine());
		t_case = Integer.parseInt(st.nextToken(" "));
		
		for(int t=0;t<t_case;t++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken(" "));
			y1 = Integer.parseInt(st.nextToken(" "));
			r1 = Integer.parseInt(st.nextToken(" "));
			x2 = Integer.parseInt(st.nextToken(" "));
			y2 = Integer.parseInt(st.nextToken(" "));
			r2 = Integer.parseInt(st.nextToken(" "));
			
			distance = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2, 2));
			r_sum = r1+r2;
			r_sub = Math.abs(r1-r2);
			
			if(distance == 0) {
				if(r1==r2) System.out.println(-1);
				else System.out.println(0);
			} else if(distance < r_sub || distance > r_sum) {
				System.out.println(0);
			} else if(distance == r_sub || distance == r_sum) {
				System.out.println(1);
			} else if(distance > r_sub || distance <r_sum) {
				System.out.println(2);
			}		
			
		}
		
		
	}
}
