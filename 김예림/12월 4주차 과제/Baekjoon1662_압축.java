package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1662_압축 {
	
	static String s;
	static int idx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		
		idx = 0;
		System.out.println(sum());
	}
	
	//재귀를 이용
	public static int sum() {
		
		int cnt = 0;
		
		while(true) {
			if(idx == s.length()) break;
			
			if(s.charAt(idx) == ')') { //닫는 괄호가 나오면 cnt를 return 해서 곱하기
				return cnt;
			}else if(s.charAt(idx) == '(') { //괄호가 나오면 닫는 괄호가 나올때까지 재귀
				int tmp = idx-1; //idx가 전역변수로 변경이 되면서 움직이기 때문에 미리 곱할 숫자를 저장해둬야함!
				idx++;
				cnt--; //괄호가 나오기 전 그냥 숫자인 줄 알고 문자열길이+1 해줬던 걸 다시 뺴기
				
				if(idx-2>=0) {
					cnt += (s.charAt(tmp)-'0')*sum();
				}
				else cnt += sum();
			}else {
				cnt++; //괄호의 영향이 받지 않는 일반 문자열+1
			}
			idx++; //idx를 +1하면서 계속해서 탐색하기
		}
		return cnt;
	}
}
