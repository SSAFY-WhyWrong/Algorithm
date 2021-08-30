import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_순위_검색 {
	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and senior and - 0",
				"- and - and - and - 150", "cpp and frontend and senior and pizza 100" };

		solution(info, query);
	}

	static public int[] solution(String[] info, String[] query) {
		int[] answer = {};
		HashMap<String, ArrayList<Integer>> map = new HashMap();
		String language[] = { "cpp", "java", "python", "-" };
		String position[] = { "backend", "frontend", "-" };
		String career[] = { "junior", "senior", "-" };
		String soulfood[] = { "chicken", "pizza", "-" };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						map.put(language[i] + position[j] + career[k] + soulfood[l], new ArrayList<Integer>());
					}
				}
			}
		}

		for (String str : info) {
			String[] s = str.split(" ");

			String lan[] = { s[0], "-" };
			String pos[] = { s[1], "-" };
			String car[] = { s[2], "-" };
			String food[] = { s[3], "-" };

			int score = Integer.parseInt(s[4]);

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					for (int k = 0; k < 2; k++) {
						for (int l = 0; l < 2; l++) {
							map.get(lan[i] + pos[j] + car[k] + food[l]).add(score);
						}
					}
				}
			}

		}

		answer = new int[query.length];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						Collections.sort(map.get(language[i] + position[j] + career[k] + soulfood[l]));
					}
				}
			}
		}

		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replaceAll(" and ", " ");
			String[] s = query[i].split(" ");
			int score = Integer.parseInt(s[4]);
			List<Integer> list = map.get(s[0] + s[1] + s[2] + s[3]);

			int idx = binarySearch(list, score);
			answer[i] = idx;
		}

		return answer;
	}

	static public int binarySearch(List<Integer> arr, int score) {
		int mid = 0;
		int end = arr.size();
		int start = 0;

		while (end > start) {
			mid = (start + end) / 2;
			if (arr.get(mid) >= score) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return arr.size() - start;
	}
}
