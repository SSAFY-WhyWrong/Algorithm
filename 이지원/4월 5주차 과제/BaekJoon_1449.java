package day_0502;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_1449 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int ans = 0;
		int tmp = 0;
		
		for(int i = 0; i < N; i++) {
			tmp = 0;
			for(int j = i + 1; j < N; j++) {
				if(arr[i] + L - 0.5 >= arr[j] + 0.5) {
					tmp++;
				} else {
					break;
				}
			}
			i += tmp;
			ans++;
		}
		System.out.println(ans);
	}
}
