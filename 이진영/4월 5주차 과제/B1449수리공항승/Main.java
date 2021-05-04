package B1449수리공항승;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int r, len;
	static int []arr;
	static int []dp;
	static boolean []ch;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		len = Integer.parseInt(st.nextToken());
		arr = new int[r + 1];
		ch = new boolean[2001];
		st = new StringTokenizer(br.readLine());
		for(int i =1; i <= r; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int res = 0;
		int current = 0;
		for(int i = 1; i <= r; i++) {
			int x = arr[i];
			if(ch[x])continue;
			for(int j = x; j < x + len; j++) {
				ch[j] = true;
			}
			res++;
		}
		System.out.println(res);
	}
}
