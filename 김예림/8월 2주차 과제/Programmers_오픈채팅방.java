package M08_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Programmers_오픈채팅방 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] str = new String[n];
		for(int i=0; i<n; i++) {
			str[i] = br.readLine();
		}
		String[] answer = solution(str);
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static String[] solution(String[] record) {
		ArrayList<Room> roomList = new ArrayList<>();
		
		Map<String, String> userList = new HashMap<>();
		
		int size = record.length;
		for(int i=0; i<size; i++) {
			String[] str = record[i].split(" ");
			switch (str[0]) {
			case "Enter":
				roomList.add(new Room(1,str[1]));
				if(userList.containsKey(str[0])) {
					userList.replace(str[1], str[2]);
				}else userList.put(str[1], str[2]);
				break;
			case "Leave":
				roomList.add(new Room(0, str[1]));
				break;
			case "Change":
				userList.replace(str[1], str[2]);
				break;
			}
		}
		int ansLen = roomList.size();
		
		String[] answer = new String[ansLen];
		
		for(int i=0; i<ansLen; i++) {
			int active = roomList.get(i).active;
			String uid = roomList.get(i).userid;
			
			answer[i] = userList.get(uid);
			
			if(active == 1) answer[i] += "님이 들어왔습니다.";
			else answer[i] += "님이 나갔습니다.";
		}
		
		return answer;
	}
	
	static class Room{
		int active; //입장하면 1, 퇴장하면 0
		String userid;
		public Room(int active, String userid) {
			this.active = active;
			this.userid = userid;
		}
	}
}
/*
5
Enter uid1234 Muzi
Enter uid4567 Prodo
Leave uid1234
Enter uid1234 Prodo
Change uid4567 Ryan
*/
