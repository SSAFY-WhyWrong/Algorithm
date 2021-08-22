import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Programmers_여행경로 {
	public static void main(String[] args) {
		String tickets[][] = { {"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}};
		
		solution(tickets);
		
	}

	static class Node implements Comparable<Node> {
		String name;
		int idx;
		int num;

		Node(String name, int idx, int num) {
			this.name = name;
			this.idx = idx;
			this.num = num;
		}

		@Override
		public int compareTo(Node o) {
			return this.name.compareTo(o.name);
		}

	}
	static String route[];
	static List<Node> list[];
	static boolean used[];
	static boolean isFinish;
	static public String[] solution(String[][] tickets) {
		String[] answer = {};
		
		int ticketCnt = tickets.length;
		isFinish = false;
		used = new boolean[ticketCnt];
		HashMap<String, Integer> map = new HashMap();
		list  = new ArrayList[10000];
		int idx = 0;
		for (int i = 0; i < ticketCnt; i++) {

			String from = tickets[i][0];
			String to = tickets[i][1];
			int fromIdx;
			int toIdx;

			if (!map.containsKey(from)) {
				map.put(from,idx);
				list[idx] = new ArrayList();
				fromIdx = idx++;
			} else {
				fromIdx = map.get(from);
			}

			if (!map.containsKey(to)) {
				map.put(to, idx);
				list[idx] = new ArrayList();
				toIdx = idx++;
			} else {
				toIdx = map.get(to);
			}

			list[fromIdx].add(new Node(to, toIdx, i));

		}
		System.out.println(idx);
		for (int i = 0; i < idx; i++) {
			Collections.sort(list[i]);
		}

		int start = map.get("ICN");

		answer = new String[ticketCnt + 1];
		answer[0] = "ICN";
		int usedCnt = 0;
		
		route = new String[ticketCnt +1];
		route[0] = "ICN";
		DFS(ticketCnt, 1,start);
		for(String str : route)
			System.out.println(str);
		
		return answer;
	}
	
	static void DFS(int ticketCnt, int cnt, int now){
		
		if(cnt > ticketCnt) {
			isFinish = true;
			return;
		}
		
		
		for(Node node : list[now]) {
			if(used[node.num]) continue;
			
			used[node.num] = true;
			route[cnt] = node.name;			
			DFS(ticketCnt, cnt+1, node.idx);
			if(isFinish) return;
			
			used[node.num] = false;
		}
		
	}
	
}
