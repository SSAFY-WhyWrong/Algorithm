package AlgorithmStudy;

import java.util.Arrays;

public class Programmers_전화번호목록 {
	public static void main(String[] args) {
		String[] phone_book = {"12","123","1235","567","88"};
		
		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {

		boolean answer = true;

		int size = phone_book.length;
		Arrays.sort(phone_book);

		for(int i=0; i<size-1; i++){
			int len1 = phone_book[i].length();
			char pre = phone_book[i].charAt(0);
			for(int j=i+1; j<size; j++){
				if(pre != phone_book[j].charAt(0)) break;
				int len2 = phone_book[j].length();
				if(len1<len2){
					if(phone_book[i].equals(phone_book[j].substring(0,len1))){
						answer = false;
						break;
					}
				}else break; //이거 한 줄로 효율성 3,4 해결,,
			}
			if(!answer) break;
		}
		return answer;
	}
}


