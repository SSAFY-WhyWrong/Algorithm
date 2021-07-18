import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Programmers_캐시 {
	public static void main(String[] args) {
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
		solution(cacheSize, cities);
	}

	static class Node implements Comparable<Node>{
		String name;
		int idx;
		
		Node(String name, int idx){
			this.name = name;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(Node o) {
			
			return this.idx - o.idx;
		}
	}
	
	static public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		
		int city_cnt = cities.length;
		int cache_cnt = 0;
		List<Node> cache = new LinkedList();
		boolean isCacheHit;
		for(int i=0;i<city_cnt;i++) {
			isCacheHit = false;
			
			for(int j=0;j<cache.size();j++) {
				if(cache.get(j).name.equals(cities[i].toLowerCase())) {
					answer += 1;
					cache.get(j).idx = i;
					isCacheHit = true;
					break;
				}
			}
			
			if(!isCacheHit) {
				answer +=5;
				if(!cache.isEmpty() && cache.size() >= cacheSize) {
					cache.remove(0);					
				}
				if(cache.size() < cacheSize)
					cache.add(new Node(cities[i].toLowerCase(),i));
			}
			
			if(!cache.isEmpty()) {
				Collections.sort(cache);
			}
			
		}
		
		System.out.println(answer);
		return answer;
	}
}
