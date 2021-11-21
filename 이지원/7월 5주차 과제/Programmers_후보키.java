package day_0802;
import java.util.*;

public class Programmers_후보키 {
	static int[] a;
	static int[] result;
	static boolean[] visited;
	static int ans = 0;
	static List<String> al;

	class Solution {
	    public int solution(String[][] relation) {
	        int answer = 0;
	        a = new int[relation[0].length];
	        for(int i = 0; i < a.length; i++){
	            a[i] = i;
	        }
	        al = new ArrayList<>();
	        for(int i = 1; i <= relation[0].length; i++){
	            visited = new boolean[relation[0].length];
	            comb(0, 0, i, relation);
	        }
	        answer = ans;
	        
	        return answer;
	    }
	}
	static void comb(int target, int cnt, int r, String[][] relation){
		if(cnt == r){
			String temp = "";
			for(int i = 0; i < relation[0].length; i++){
				if(visited[i]){
					temp += i;
				}
			}
			String[] tmp = temp.split("");
			int countdupli = 0;
			for(int i = 0; i < al.size(); i++){
				String[] ab = al.get(i).split("");
				List<String> al1 = Arrays.asList(tmp);
				List<String> al2 = Arrays.asList(ab);
				if(al1.containsAll(al2)){
					return;
				}
				
			}
			
			boolean chk = true;
			HashMap<String, Integer> map = new HashMap<>();
			for(int i = 0; i < relation.length; i++){
				String sum = "";
				for(int j = 0; j < tmp.length; j++){
					sum += relation[i][Integer.parseInt(tmp[j])];
				}
				if(!map.containsKey(sum)){
					map.put(sum, 1);
				} else {
					map.put(sum, map.get(sum) + 1);
				}
			}
			for(String k : map.keySet()){
				if(map.get(k) != 1){
					chk = false;
					break;
				}
			}
			if(chk){
				ans++;
				al.add(temp);
			}
			return;
		}
		
		if(target == relation[0].length){
			return;
		}
		
		visited[target] = true;
		comb(target + 1, cnt + 1, r, relation);
		visited[target] = false;
		comb(target + 1, cnt, r, relation);
	}
}
