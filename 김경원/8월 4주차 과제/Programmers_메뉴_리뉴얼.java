import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Programmers_메뉴_리뉴얼 {
	public static void main(String[] args) {
		String orders[] = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
		int course[] = { 2, 3, 5 };

		solution(orders, course);

	}

	static public String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		HashMap<String, Integer> map;
		String strs[] = new String[orders.length];
		List<String> list = new ArrayList();
		int[] max = new int[1];

		for (int i = 0; i < orders.length; i++) {
			char arr[] = orders[i].toCharArray();
			Arrays.sort(arr);
			strs[i] = String.copyValueOf(arr);
		}

		for (int i = 0; i < course.length; i++) {
			map = new HashMap();
			max[0] = 0;			
			for (int j = 0; j < strs.length; j++) {
				DFS("", 0, course[i], 0, strs[j], map, max);
			}
			if (max[0] > 1) {
				for (String s : map.keySet()) {
					if (map.get(s) == max[0])
						list.add(s);					
				}
			}

		}
		
		Collections.sort(list);
		answer = list.toArray(new String[list.size()]);
		for(String s: answer) {
			System.out.println(s);
		}
		
		return answer;
	}

	static void DFS(String now, int cnt, int len, int idx, String order, HashMap<String, Integer> map, int[] max) {
		if (cnt == len) {
			char[] arr = now.toCharArray();
			String s = String.copyValueOf(arr);
			Arrays.sort(arr);
			map.put(s, map.getOrDefault(s, 0) + 1);
			max[0] = Math.max(max[0], map.get(s));
			
			
			return;
		}

		if (idx >= order.length())
			return;

		DFS(now + order.charAt(idx), cnt + 1, len, idx + 1, order, map, max);
		DFS(now, cnt, len, idx + 1, order, map, max);

	}
}
