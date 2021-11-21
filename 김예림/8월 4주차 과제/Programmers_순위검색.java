package M08_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_순위검색 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = 6;

		String[] info = new String[n];
		String[] query = new String[n];

		for(int i=0; i<n; i++) {
			info[i] = br.readLine();
		}
		for(int i=0; i<n; i++) {
			query[i] = br.readLine();
		}

		int[] answer = solution(info, query);

		for(int i=0; i<n; i++) {
			System.out.print(answer[i]+" ");
		}
	}
	public static int[] solution(String[] info, String[] query) {

		//지원자들의 모든 경우의 수 16가지에 점수를 넣는다.
		Map<String, List<Integer>> infos = new HashMap<>();
		
		for(String in : info) {
			String[] split = in.split(" ");
			int score = Integer.parseInt(split[4]); //점수는 따로 계산
			//지원자들의 조건 조합하여 모든 경우의 수 만들기
			for(int i=0; i<(1<<4); i++) { //(ex)i가 1001이면 0번과 3번의 조건이 선택되어 조합을 만들게 된다.짱신기
				StringBuilder key = new StringBuilder();
				for(int j=0; j<4; j++) { //j자리를 하나씩 옮겨가면서 i에 1과 일치하는 애들은 append
					if((i & (1 << j)) > 0) key.append(split[j]);
				}
				//(key, value) -> (조합된 문자열, 점수)
				//computeAbsent()=>value가 없다면 새로운 arraylist생성, 있으면 add(score)
				infos.computeIfAbsent(key.toString(),s -> new ArrayList<>()).add(score);
			}
		}
		//모든 map의 key에 대해서 순회하면서 오름차순 정렬
		List<Integer> empty = new ArrayList<>(); 
		for(Map.Entry<String, List<Integer>> entry : infos.entrySet()) 
			entry.getValue().sort(null);
		
		//query에서 '-'를 제외한 조건으로 key를 만들고 점수 List를 가져온다.
		//query마다 받은 조건을 통해 key를 생성해주고 key에 해당하는 List를 받아온다.
		int[] answer = new int[query.length];
		for(int i=0; i<query.length; i++) {
			String[] split = query[i].replaceAll("-", "").split(" and | ");
			String key = String.join("", split[0], split[1], split[2], split[3]);
			int score = Integer.parseInt(split[4]);
			
			//key가 기존에 없던 새로운 조건들로만 이루어졌다면 null이 반환되기 때문에 빈 list반환시키기
			List<Integer> list = infos.getOrDefault(key, empty);
			
			//이분탐색을 통해 
			int start = 0, end = list.size();
			
			//lower_bound(값이 일치하는 인덱스 중 가장 작은 값)를 찾는다.
			while(start < end) {
				int mid = (start + end) / 2;
				
				if(list.get(mid) < score) start = mid + 1;
				else end = mid;
			}
			answer[i] = list.size() - start;
		}
		return answer;
	}

}
/*
java backend junior pizza 150
python frontend senior chicken 210
python frontend senior chicken 150
cpp backend senior pizza 260
java backend junior chicken 80
python backend senior chicken 50
java and backend and junior and pizza 100
python and frontend and senior and chicken 200
cpp and - and senior and pizza 250
- and backend and senior and - 150
- and - and - and chicken 100
- and - and - and - 150
 */
