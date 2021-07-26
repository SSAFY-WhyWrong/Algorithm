package M07_4;

import java.util.Scanner;

public class Baekjoon_1094_¸·´ë±â {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int idx = 0;
		int num = 0;
		
		while(true) {
			if(n%2 == 1)  num += (1 << idx++);
			else idx++;
			
			n /= 2;
			if(n == 0) break;
		}
		System.out.println(Integer.bitCount(num));
	}
}
