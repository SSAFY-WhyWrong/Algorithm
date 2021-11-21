package 실패;

import java.util.ArrayList;
import java.util.List;

public class 후보키 {
	public static void main(String[] args) {
		String[][] rel = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		System.out.println(solution(rel));
	}

	private static int answer, row, col;
	private static boolean[] bool;
	private static String[][] copy;
	
//boolean 배열로 인덱스별로 사용 처리했는데 그렇게하면 한번밖에 못쓸 것 같다. 그래서 틀린듯
	public static int solution(String[][] relation) {
		answer = 0;
		copy = relation;
		row = relation.length;
		col = relation[0].length;
		bool = new boolean[col];
		List<String> list;
		// 단일키 우선 확인
		for (int i = 0; i < col; i++) {
			list = new ArrayList<>();
			for (int j = 0; j < row; j++) {
				if (list.contains(relation[j][i])) {
					break;
				}
				list.add(relation[j][i]);
			}
			bool[i] = list.size() == row ? true : false;
			if (bool[i])
				answer++;
		}
		// 단일키로 후보키 불가능하면 갯수 늘려가면서 가능한 것
		for (int i = 2; i < col + 1; i++) {
			powerSet(i, 0, 0, new ArrayList<>());
		}
		return answer;
	}

	private static void powerSet(int cnt, int start, int current, List<Integer> list) {
		if (cnt == current) {
			int ind;
			StringBuilder sb;
			List<String> confirm = new ArrayList<>();
			boolean right = true;
			for (int j = 0; j < row; j++) {
				sb = new StringBuilder();
				for (int i = 0; i < list.size(); i++) {
					ind = list.get(i);
					sb.append(copy[j][ind]);
				}
				if (!confirm.contains(sb.toString())) {
					confirm.add(sb.toString());
				} else {
					right = false;
				}
			}
			if (right) {
				answer++;
				for (int i = 0; i < list.size(); i++) {
					bool[list.get(i)] = true;
				}
			}
		}

		for (int i = start; i < col; i++) {
			if (!bool[i]) {
				list.add(i);
				powerSet(cnt, i + 1, current + 1, list);
				list.remove(Integer.valueOf(i));
			}
		}

	}
}
