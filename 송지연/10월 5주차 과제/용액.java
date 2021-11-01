import java.util.Scanner;

public class 백준_2467_용액 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		
		for(int i=0;i<N;i++) {
			num[i] = sc.nextInt();
		}
		
		int start = 0, end = N-1, ans = Integer.MAX_VALUE, ansA = -1, ansB = -1;
		while(start < end) {
			int sumAB = num[start] + num[end];
			
			if(Math.abs(sumAB) <= ans) {
				ans = Math.abs(sumAB);
				ansA = start;
				ansB = end;
			}
			
			if(sumAB >= 0) {
				end--;
			} else {
				start++;
			}
		}
		
		System.out.println(num[ansA] + " " + num[ansB]);
	}

}
