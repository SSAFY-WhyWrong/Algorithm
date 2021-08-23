package day_0823;

import java.util.*;

public class Programmers_여행경로 {
	static ArrayList<String> ans = new ArrayList<>();
	static boolean[] visited;

	class Solution {
		public String[] solution(String[][] tickets) {
			String[] answer = {};
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = 0; i < tickets.length; i++) {
				if (tickets[i][0].equals("ICN")) {
					al.add(i);
				}
			}

			for (int i = 0; i < al.size(); i++) {
				visited = new boolean[tickets.length];
				visited[al.get(i)] = true;
				dfs(al.get(i), tickets, "ICN ", 1);
			}
			Collections.sort(ans);
			answer = ans.get(0).split(" ");
			return answer;
		}

	}

	static void dfs(int start, String[][] tickets, String temp, int cnt) {
		if (cnt == tickets.length) {
			temp += tickets[start][1];
			ans.add(temp);
			return;
		}
		for (int i = 0; i < tickets.length; i++) {
			if (visited[i])
				continue;
			if (tickets[start][1].equals(tickets[i][0])) {
				visited[i] = true;
				dfs(i, tickets, temp + tickets[i][0] + " ", cnt + 1);
				visited[i] = false;
			}
		}
	}
}
