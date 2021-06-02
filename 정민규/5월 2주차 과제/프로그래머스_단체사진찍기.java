import java.util.Map;
import java.util.HashMap;

public class 프로그래머스_단체사진찍기 {
	static Map<Character, Integer> map = new HashMap<>();
	static int[] position = new int[8];
	static int answer;

	public static void main(String[] args) {
		String[] data = { "N~F=0", "R~T>2" };
		System.out.println(solution(2, data));
	}

	public static int solution(int n, String[] data) {
		answer = 0;
		map.put('A', 0);
		map.put('C', 1);
		map.put('F', 2);
		map.put('J', 3);
		map.put('M', 4);
		map.put('N', 5);
		map.put('R', 6);
		map.put('T', 7);

		dfs(n, data, 0);
		return answer;
	}

	static void dfs(int n, String[] data, int cnt) {
		if (cnt == 8) {
			if (check(n, data))
				answer += 1;
			return;
		}
		for (int i = 0; i < 8; i++) {
			if (position[i] != 0)
				continue;
			position[i] = cnt + 1;
			// if(check(n,data))
			dfs(n, data, cnt + 1);
			position[i] = 0;
		}
	}

	static boolean check(int n, String[] data) {
		int person1, person2;
		char token;
		int value;
		for (int i = 0; i < n; i++) {
			person1 = map.get(data[i].charAt(0));
			person2 = map.get(data[i].charAt(2));
			token = data[i].charAt(3);
			value = data[i].charAt(4) - '0' + 1;
			if (position[person1] == 0 || position[person2] == 0)
				continue;
			else if (token == '=') {
				if (Math.abs(position[person1] - position[person2]) != value) {
					return false;
				}
			} else if (token == '>') {
				if (Math.abs(position[person1] - position[person2]) <= value)
					return false;
			} else if (token == '<') {
				if (Math.abs(position[person1] - position[person2]) >= value)
					return false;
			}
		}
		return true;
	}
}
