import java.util.Arrays;
import java.util.Scanner;

public class 백준_13904_과제 {

	static class Subject implements Comparable<Subject> {
		int days;
		int score;
		
		@Override
		public int compareTo(Subject o) {
			if(this.days == o.days) {
				return this.score - o.score;
			}
			
			return this.days - o.days;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Subject[] subjects = new Subject[N];
		
		// 입력 및 정렬
		for(int i=0;i<N;i++) {
			subjects[i] = new Subject();
			subjects[i].days = sc.nextInt();
			subjects[i].score = sc.nextInt();
		}
		
		Arrays.sort(subjects);
		
		// scores 배열 선언
		int maxDay = subjects[N-1].days;
		int[] scores = new int[maxDay+1];
		boolean[] visit = new boolean[N];
		
		for(int i=maxDay;i>=1;i--) {
			int idx = N-1, nowDay = maxDay;
			int maxScore = 0, maxIdx = 0;
			
			while(nowDay >= i) {
				if(!visit[idx] && maxScore < subjects[idx].score) {
					maxScore = subjects[idx].score;
					maxIdx = idx;
				}
				
				idx--;
				if(idx < 0) {
					nowDay = -1;
				} else {
					nowDay = subjects[idx].days;
				}
			}

			scores[i] = maxScore;
			if(maxScore != 0)
				visit[maxIdx] = true;
		}
		
		// 최대값 찾기
		int answer = 0;
		for(int i=0;i<=maxDay;i++) {
			answer += scores[i];
		}
		
		System.out.println(answer);
	}

}
