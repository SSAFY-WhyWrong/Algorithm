package 성공;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class 카카오_튜플_2019 {
	public static void main(String[] args) {
		String a = "{{123}}";
		System.out.println(Arrays.toString(solution(a)));
	}

	private static Set<Integer> set;
	private static int max=0;
	public static int[] solution(String s) {
		char[] array = s.toCharArray();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		set = new HashSet<Integer>();
		StringBuilder sb;
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i] == '{') { //여는 괄호 시작하면
				list.add(new ArrayList<Integer>());
				while (array[i + 1] != '}') { //닫는 괄호 찾을때까지
					sb = new StringBuilder(); //수만들어서 저장할려고
					while (array[i + 1] != ',') { //쉼표를 찾을때까지
						if(array[i+1]=='}') { //한 순열에 마지막이라 쉼표가 없으면 
							break;
						}
						sb.append(array[++i]);
					}
					if(array[i+1]=='}') { 
						int p = Integer.parseInt(sb.toString());
						list.get(list.size()-1).add(p);
						break;
					}
					i++;
					list.get(list.size()-1).add(Integer.parseInt(sb.toString()));
				}
				if (i != array.length - 3) {
					i += 2;
				}
			}
		}
		list.sort(new Comparator<ArrayList>() {
			@Override
			public int compare(ArrayList o1, ArrayList o2) {
				// TODO Auto-generated method stub
				max = Math.max(max, Math.max(o1.size(), o2.size()));
				return o1.size()-o2.size();
			}
		});
		if(max==0)max=1;
		int[] answer = new int[max];
		ArrayList<Integer> r;
		int size,t=0;
		for (int i = 0; i < list.size(); i++) {
			r = list.get(i);
			size = r.size();
			for (int j = 0; j < size ; j++) {
				if(!set.contains(r.get(j))) {
					set.add(r.get(j));
					answer[t++] = r.get(j);
				}
			}
		}
		return answer;
	}
}
