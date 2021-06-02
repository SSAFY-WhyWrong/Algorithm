package M05_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N];
		int maxtree = 0; //제일 높은 나무 높이
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			
			maxtree = Math.max(maxtree, tree[i]);
		}
		
		int start = 0; 
		int end = maxtree;
		while(true) {
			if(end-start == 1) break;
			
			int mid = (start+end)/2;
			
			long total = 0;
			for(int i=0; i<N; i++) {
				if(tree[i]>mid) total += tree[i]-mid; 
			}
			
			if(total<M) end = mid;
			else start = mid;
		}
		System.out.println(start);
	}
}
