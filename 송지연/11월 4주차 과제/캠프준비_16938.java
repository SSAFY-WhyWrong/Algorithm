import java.util.*;
import java.io.*;

public class 캠프준비_16938 {

	static int N, L, R, X, answer;
	static int[] level;
	static boolean[] select;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		X = sc.nextInt();
		level = new int[N];
		select = new boolean[N];
		
		for(int i=0;i<N;i++) {
			level[i] = sc.nextInt();
		}
	
		answer = 0;
		powerSet(0);
		
		System.out.println(answer);
	}

	public static void powerSet(int now) {
		if(now == N) {
			if(isPossible()) {
				answer++;
			}
			
			return;
		}
		
		select[now] = true;
		powerSet(now+1);
		
		select[now] = false;
		powerSet(now+1);
	}
	
	public static boolean isPossible() {
		int sum = 0;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		
		for(int i=0;i<N;i++) {
			if(select[i]) {
				sum += level[i];
				min = Math.min(min, level[i]);
				max = Math.max(max, level[i]);
			}
		}
		
		if(sum >= L && sum <= R && (max-min) >= X) {
			return true;
		}
		
		
		return false;
	}
}
