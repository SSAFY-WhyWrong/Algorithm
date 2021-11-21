package 실패;

import java.util.LinkedList;
import java.util.Queue;

public class 캐시 {
	public static void main(String[] args) {
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(cacheSize, cities));
	
	}

	public static int solution(int cacheSize, String[] cities) {
		int answer = 0,size = cities.length;
		String k;
		Queue<String> queue = new LinkedList<>();
		if(cacheSize==0)return size*5;
		for (int i = 0; i < size; i++) {
			k = cities[i].toLowerCase();
			if(queue.contains(k)) {
				queue.remove(k);
				answer++;
			}else {
				answer+=5;
			}
			queue.add(k);
			if(queue.size()>cacheSize) {
				queue.poll();
			}
		}
		return answer;
	}
}
