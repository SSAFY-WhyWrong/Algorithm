package 실패;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카카오_2018_1차_비밀지도 {
	static int n;
	static int[] arr1, arr2, plus;
	static String[] answer;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr1 = new int[n];
		arr2 = new int[n];
		plus = new int[n];
		answer = new String[n];
		Arrays.fill(answer, "");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < n; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			plus[i] = arr1[i] | arr2[i];
		}
		System.out.println(Arrays.toString(plus));
		int a;
		for (int i = 0; i < n; i++) {
			a=plus[i];
			for (int j = 0; j < n; j++) {
				if((a & 1<<j)!=0) {
					answer[i]="#"+answer[i];
				}else {
					answer[i]=" "+answer[i];					
				}
			}
		}
		System.out.println(Arrays.toString(answer));
	}

}
