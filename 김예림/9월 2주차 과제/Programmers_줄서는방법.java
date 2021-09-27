package M09_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programmers_줄서는방법 {
	
	static int n;
	static long k, ans;
	static int[] num, answer;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		k = Long.parseLong(br.readLine());

		int[] answer = solution(n,k);

		for(int i=0; i<n; i++) {
			System.out.print(answer[i]+" ");
		}
		System.out.println();

	}

	public static int[] solution(int n, long k) {
		
		num = new int[n];
		isSelected = new boolean[n+1];
		ans = 0;
		answer = new int[n];
		
		Permutation(0);
		
		return answer;
	}
	private static void Permutation(int cnt) {
		
		if(cnt == n) {
			ans++;
			if(ans == k) {
				for(int i=0; i<n; i++) {
					answer[i] = num[i];
				}
			}
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(isSelected[i]) continue;
			
			num[cnt] = i;
			isSelected[i] = true;
			
			Permutation(cnt+1);
			isSelected[i] = false;
		}
		
	}

}
