package M08_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Programmers_메뉴리뉴얼2 {
	public static void main(String[] args) {
		String[] orders = {"ABCD", "ABCD", "ABCD"};
		int[] course = {2,3,4};

//		solution(orders, course);
		String[] answer = solution(orders, course);

		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}

	}
	public static String[] solution(String[] orders, int[] course) {

		Map<String, Integer> cases = new HashMap<>();

		for(int i=0; i<orders.length; i++) {
			for(int j=i+1; j<orders.length; j++) {
				String temp = "";
				String[] split = orders[i].split("");
				for(int k=0; k<split.length; k++) {
					if(orders[j].contains(split[k])) temp += split[k];
				}
				//일치하는 문자들을 하나하나 조합
				String[] comb = temp.split("");
				Arrays.sort(comb);

				for(int n=0; n<course.length; n++) {
					if(course[n]<=temp.length()) {
						for(int m=0; m<(1<<course[n]); m++) {
							StringBuilder sb = new StringBuilder();
							for(int k=0; k<course[n]; k++) {
								if((m & (1 << k)) > 0) sb.append(comb[k]);
							}
							if(sb.length()>1 && !cases.containsKey(sb.toString())) {
								cases.put(sb.toString(), 0);
							}
						}
					}
				}
			}
		}
		
		for(String key : cases.keySet()) {
			for(int i=0; i<orders.length; i++) {
				boolean flag = true;
				String[] match = key.split("");
				for(String m : match) {
					if(!orders[i].contains(m)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					cases.replace(key, cases.get(key)+1);
				}
			}
		}
		
		int[] maxNum = new int[course.length];
		for(int i=0; i<course.length; i++) {
			int max = 0;
			for(String key : cases.keySet()) {
				if(key.length() == course[i] && max < cases.get(key)) max = cases.get(key);
			}
			maxNum[i] = max;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<maxNum.length; i++) {
			for(String key : cases.keySet()) {
				if(key.length() == course[i] && maxNum[i]==cases.get(key)) sb.append(key+"\n");
			}
		}
		
		String[] answer = sb.toString().split("\n");
		Arrays.sort(answer);
		return answer;
	}
}
