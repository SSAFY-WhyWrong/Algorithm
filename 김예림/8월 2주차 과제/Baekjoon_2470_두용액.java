package M08_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_2470_두용액 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Liquid[] list = new Liquid[n];
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			int check = -1;
			if(tmp>0) check = 1;

			list[i] = new Liquid(Math.abs(tmp), check);
		}
		Arrays.sort(list);
		int min = Integer.MAX_VALUE;

		int n1 = 0, n2 = 0;
		int minNum1 = 0, minNum2 = 0;

		for(int i=1; i<n; i++) {
			n1 = list[i-1].num * list[i-1].checked;
			n2 = list[i].num * list[i].checked;
			
			if(Math.abs(n1+n2)-0<=min) {
				min = Math.abs(n1+n2)-0; //이 부분에서 계속 오류났었네,,
				minNum1 = n1;
				minNum2 = n2;
			}
		}
		int[] answer = new int[2];
		answer[0] = minNum1;
		answer[1] = minNum2;
		Arrays.sort(answer);

		System.out.println(answer[0]+" "+answer[1]);

	}

	static class Liquid implements Comparable<Liquid>{
		int num;
		int checked; //1이면 양수, -1이면 음수
		public Liquid(int num, int checked) {
			this.num = num;
			this.checked = checked;
		}
		@Override
		public int compareTo(Liquid o) {
			return this.num-o.num;
		}
	}
}
