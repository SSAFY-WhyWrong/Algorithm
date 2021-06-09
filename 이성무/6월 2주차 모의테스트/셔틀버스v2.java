package 실패;

import java.util.ArrayList;
import java.util.Arrays;

public class 셔틀버스v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 9시부터 n회 t분 간격으로 역에 도착
		// 셔틀운행횟수 , 셔틀운행간격, 한 셔틀에 탈 수 있는 최대 크루 수
		int n = 10, t = 60, m = 45;
		// 크루가 대기열에 도착하는 시각
		String[] timetable = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};

		System.out.println(solution(n, t, m, timetable));
	}

	public static String solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		String k;
		int num = 0;
		int[] table = new int[timetable.length];
		// 시간 저장
		for (int i = 0; i < timetable.length; i++) {
			k = timetable[i];
			num = 0;
			num += (k.charAt(0) - '0') * 1000;
			num += (k.charAt(1) - '0') * 100;
			num += (k.charAt(3) - '0') * 10;
			num += (k.charAt(4) - '0') * 1;
			table[i] = num;
		}
		Arrays.sort(table); // 시간 순으로 오름차순
		ArrayList<Integer> list = new ArrayList<>();
		int ho = 9, mi = 0; // 9시정각 부터 셔틀 시작
		list.add(900);
		for (int i = 0; i < n - 1; i++) { // n번 있는 셔틀이 오는 시간을 구해서 저장
			num = 0;
			mi += t;
			if (mi >= 60) {
				ho += (mi / 60);
				mi %= 60;
			}
			num += ho * 100;
			num += mi;
			list.add(num);
		}
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		// 빨리 온 순서대로 채워넣었음
		ArrayList<Integer>[] listArray = new ArrayList[list.size()];
		int time, current = 0, maximum = 0;
		for (int i = 0; i < list.size(); i++) {
			time = list.get(i);
			maximum = 0;
			for (int j = current; j < table.length; j++) {
				if (time >= table[j]) {
					if (listArray[i] == null)
						listArray[i] = new ArrayList<>();
					listArray[i].add(table[j]);
					current++;
					maximum++;
					if (maximum == m)
						break;
				}
			}
		}

//		if (current != table.length) { // 마지막 사람까지 다 안탔으면
//			maximum = table[current];
//		}
		// 막차 타야지
		if (listArray[listArray.length - 1] == null) {
			
			answer = toAnswer(list.get(list.size() - 1));
		} else {
			if (listArray[listArray.length - 1].size() == m) { // 막차가 꽉차있네
				int minimum = Integer.MAX_VALUE, max = 0;
				for (int i = 0; i < listArray[listArray.length - 1].size(); i++) {
					minimum = Math.min(minimum, listArray[listArray.length - 1].get(i));
					max = Math.max(max, listArray[listArray.length - 1].get(i));
				}
				answer = toAnswer(timeController(max, -1));
			} else { // 막차가 좀 비어있음
				answer = toAnswer(list.get(list.size() - 1));
			}
		}
		return answer;
	}

	private static String toAnswer(Integer integer) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		String a = integer.toString();
		if (integer >= 1000) {
			sb.append(a.charAt(0));
			sb.append(a.charAt(1));
			sb.append(":");
			sb.append(a.charAt(2));
			sb.append(a.charAt(3));
		} else {
			if (integer >= 100) {
				sb.append("0");
				sb.append(a.charAt(0) + ":" + a.charAt(1) + a.charAt(2));
			} else if (integer >= 10) {
				sb.append("00:");
				sb.append(a.charAt(0) + a.charAt(1));
			} else {
				sb.append("00:0");
				sb.append(a.charAt(0));
			}
		}
		return sb.toString();
	}

	private static int timeController(int time, int con) {
		int k;
		if (con > 0) {
			k = time + con;
			if (k % 100 >= 60) {
				k += 100;
				k /= 100;
			}
		} else {
			if (time % 100 == 0) {
				k = time;
				k -= 100;
				k += 60 + con;
			} else {
				k = time + con;
			}

		}
		return k;
	}
}
