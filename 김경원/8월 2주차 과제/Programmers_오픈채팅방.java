import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Programmers_오픈채팅방 {
	public static void main(String[] args) {

		String record[] = { "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

		String answer[] = solution(record);
		
		for(String str : answer) {
			System.out.println(str);
		}
	}

	static class Node {
		int idx;
		String order;

		Node(int idx, String order) {
			this.idx = idx;
			this.order = order;
		}
	}

	static public String[] solution(String[] record) {
		String[] answer = {};
		String[] nickname = new String[record.length];
		HashMap<String, Integer> map = new HashMap();
		int idx = 0;

		
		
		String[] order = new String[3];
		List<Node> list = new ArrayList();

		for (String str : record) {
			order = str.split(" ");

			if (order[0].equals("Change")) {
				nickname[map.get(order[1])] = order[2];
			}else if(order[0].equals("Enter")) {
				if (!map.containsKey(order[1])) {
					map.put(order[1], idx);
					nickname[idx] = order[2];
					list.add(new Node(idx++, order[0]));
				} else {					
					nickname[map.get(order[1])] = order[2];
					list.add(new Node(map.get(order[1]), order[0]));
				}
			}else {
				list.add(new Node(map.get(order[1]),order[0]));
			}

		}
		
		answer = new String[list.size()];
		
		int ans_idx=0;
		for(Node node : list) {
			if(node.order.equals("Enter")) {
				answer[ans_idx++] = nickname[node.idx] +"님이 들어왔습니다.";
			}else {
				answer[ans_idx++] = nickname[node.idx] +"님이 나갔습니다.";
			}
		}
		

		return answer;
	}
}
