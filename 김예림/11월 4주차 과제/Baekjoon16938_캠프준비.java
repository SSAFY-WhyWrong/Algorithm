package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16938_캠프준비 {
	
	static int N, L, R, X, ans;
	static boolean[] isSelected;
	static int[] question;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken()); //문제수
		L = Integer.parseInt(st.nextToken()); //문제 전체 난이도, L보다 크거나 같고
		R = Integer.parseInt(st.nextToken()); //문제 전체 난이도, R보다 작거나 같다
		X = Integer.parseInt(st.nextToken()); //난이도 최솟값과 최댓값의 차이는 X보다 크거나 같다.
		
		isSelected = new boolean[N];
		question = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			question[i] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
		Subset(0);
		System.out.println(ans);
	}
	
	private static void Subset(int cnt) {
		
		if(cnt == N) {
			int min = Integer.MAX_VALUE;
			int max = 0;
			int tot = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					min = min>question[i]?question[i]:min;
					max = max<question[i]?question[i]:max;
					tot += question[i];
				}
			}
			if(tot<L || tot>R) return;
			if((max-min)<X) return;
			ans++;
			return;
		}
		
		isSelected[cnt] = true;
		Subset(cnt+1);
		
		isSelected[cnt] = false;
		Subset(cnt+1);
		
	}
	
}
