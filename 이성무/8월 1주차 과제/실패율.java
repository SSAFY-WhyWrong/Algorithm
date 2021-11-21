package 실패;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 실패율 {
	public static void main(String[] args) {
		int[] rel = { 2, 1, 2, 6, 2, 4, 3, 3 };
		System.out.println(Arrays.toString(solution(5, rel)));
	}

	private static class val implements Comparable<val> {
		int index;
		double value;

		public val(int index, double value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(val o) {
			// TODO Auto-generated method stub
			return o.value - this.value > 0 ? 1 : o.value - this.value == 0 ? this.index - o.index : -1;
		}

	}

	public static int[] solution(int N, int[] stages) {
		int[][] map = new int[2][N + 2];
		for (int i = 0; i < stages.length; i++) {
			map[0][stages[i]]++;
		} // 각 번호 별로 갯수 셈
		map[1][N+1] = map[0][N+1];
		for (int i = N; i >= 0; i--) {
			map[1][i] += (map[1][i + 1] + map[0][i]);
		}
		List<val> list = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			if (map[1][i] == 0)
				list.add(new val(i, 0));
			else
				list.add(new val(i, (double) map[0][i] / map[1][i]));
		}
		Collections.sort(list);
		int[] answer = new int[list.size()];
		int index = 0;
		for (val c : list) {
			answer[index++] = c.index;
		}
		return answer;
	}
}
