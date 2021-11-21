package 실패;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1963 {
	private static int T;
	private static int[][] array;
	private static int[] answer;
	private static Queue<Integer> queue;
	private static boolean[] bool;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		array = new int[T][2];
		answer = new int[10001];
		for (int i = 2; i < 10001; i++) {
			answer[i] = i;
		}
		for (int i = 2; i <= 5000; i++) {
			if (answer[i] != i)
				continue;
			for (int j = 2; j <= 10000 / i; j++) {
				answer[i * j] = 0;
			}
		}
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			array[t][0] = Integer.parseInt(st.nextToken());
			array[t][1] = Integer.parseInt(st.nextToken());
		}
		int val=0;
		for (int i = 0; i < T; i++) {
			bool = new boolean[10001];
			val = swap(array[i][0], array[i][1]);
			if(val==-1)sb.append("impossible"+"\n");
			else
			sb.append(val + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static int swap(int before, int after) {
		if(before==after)return 0;
		queue = new LinkedList<>();
		queue.add(before);
		Integer a;
		int k = 0, l, size = 0,cnt=0;
		while (!queue.isEmpty()) {
			size = queue.size();
			for (int c = 0; c < size; c++) {
				a = queue.poll();
				for (int i = 0; i < 4; i++) {
					k = (int) (a / Math.pow(10, i));
					if(k>9)k%=10;
					for (int j = 0; j < 10; j++) {
						if (k == j)
							continue;
						if (i == 3 && j == 0)
							continue;
						l = a - (int) (k * Math.pow(10, i));
						if (j != 0) {
							l += j * Math.pow(10, i);
						}
						if (!bool[l]&&answer[l]!=0) {
							queue.add(l);
							bool[l] = true;
							if (l == after)
								return ++cnt;
						}
					}
				}
			}
			cnt++;
		}
		return -1;
	}

}
