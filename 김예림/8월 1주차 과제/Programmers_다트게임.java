package M08_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programmers_다트게임 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			System.out.println(solution(str));
		}
	}
	static int preNum;
	static int curNum;
	static int total;
	
	public static int solution(String dartResult) {
        int answer = 0;
        
        curNum = 0;
        preNum = 0;
        total = 0;
        
        int len = dartResult.length();
        int idx = 0;
        while(true) {
        	
        	if(idx >= len) break;
        	
        	char c = dartResult.charAt(idx);
        	if(c>='0' && c<='9') {
        		total += preNum;
    			preNum = curNum;
        		if(c=='1' && dartResult.charAt(idx+1)=='0') {
        			idx++;
        			curNum = 10;
        		}else curNum = c-'0';
        	}else Sum(c);

        	idx++;
        }
        total = total + curNum + preNum;
        answer = total;
        
        return answer;
    }
	
	public static void Sum(char c) {
		
		switch (c) {
		case '#':
			curNum = (-1)*curNum;
			break;
		case '*':
			curNum *= 2;
			preNum *= 2;
			break;
		case 'S':
			curNum = curNum*1;
			break;
		case 'D':
			curNum = curNum*curNum;
			break;
		case 'T':
			curNum = curNum*curNum*curNum;
			break;
		}
	}
	
}
/*
7
1S2D*3T
1D2S#10S
1D2S0T
1S*2T*3S
1D#2S*3S
1T2D3D#
1D2S3T*
*/