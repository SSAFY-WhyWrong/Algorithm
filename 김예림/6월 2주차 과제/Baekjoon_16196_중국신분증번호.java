package M06_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_16196_중국신분증번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] limit = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		boolean valid = false;
		String all = br.readLine();

		int n = Integer.parseInt(br.readLine());

		int region = Integer.parseInt(all.substring(0, 6));
		//region 맞는지 확인
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(region == tmp) {
				valid = true;
			}
		}

		//생년월일 유효성 검사
		int year = Integer.parseInt(all.substring(6,10));
		int month = Integer.parseInt(all.substring(10,12));
		int day = Integer.parseInt(all.substring(12,14));
		
		if(valid && year>=1900 && year<=2011) {
			if((year%4==0 && year%100!=0) || year%400==0) {
				if(month==2 && day>=1 && day<=29) {
					valid = true;
				}else if(month>=1 && month<=12) {
					if(day>=1 && day<=limit[month]) valid = true;
					else valid = false;
				}else valid = false;
			}else {
				if(month>=1 && month<=12) {
					if(day>=1 && day<=limit[month]) valid = true;
					else valid = false;
				}else valid = false;
			}
		}else valid = false;
		
		//순서코드 검사
		String code = all.substring(14,17);
		
		if(valid && !code.equals("000")) valid = true;
		else valid = false;
		
		int mod = 0;
		int checkSum = 0;
		
		//체크섬코드 검사
		if(all.charAt(17)=='X') checkSum = 10;
		else checkSum = all.charAt(17)-'0';
		
		mod += checkSum;
		
		for(int i=0; i<17; i++) {
			int pow = (int)Math.pow(2, 17-i);
			int num = all.charAt(i)-'0';
			mod += pow*num;
			mod %= 11;
		}
		
		if(mod%11==1 && valid) {
			int gender = Integer.parseInt(code);
			if(gender%2==0) System.out.println("F");
			else System.out.println("M");			
		}else {
			System.out.println("I");
		}
	}
}
