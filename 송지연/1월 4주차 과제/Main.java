import java.util.*;

public class Main {

	static class Brick implements Comparable<Brick> {
		int idx; // 번호
		int area; // 넓이
		int height; // 높이
		int weight; // 무게
		
		public Brick(int idx, int area, int height, int weight) {
			super();
			this.idx = idx;
			this.area = area;
			this.height = height;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Brick [idx=" + idx + ", area=" + area + ", height=" + height + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Brick o) {
			return o.weight - this.weight;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Brick[] bricks = new Brick[N+1];
		bricks[0] = new Brick(0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
		
		// 값 저장 및 정렬
		for(int i=1;i<N+1;i++) {
			int area = sc.nextInt();
			int height = sc.nextInt();
			int weight = sc.nextInt();
			
			bricks[i] = new Brick(i, area, height, weight);
		}
		
		Arrays.sort(bricks);
		
		// dp 저장
		int[] dp = new int[N+1];
		for(int i=1;i<N+1;i++) {
			dp[i] = bricks[i].height;
			for(int j=1;j<i;j++) {
				if(bricks[i].area < bricks[j].area) {
					dp[i] = Math.max(dp[i], dp[j] + bricks[i].height);
				}
			}
		}
		
		// 최대 높이 값 찾기
		int maxHeight = 0;
		for(int i=1;i<N+1;i++) {
			maxHeight = Math.max(maxHeight, dp[i]);
		}
		
		// 쌓인 벽돌 찾기
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=N;i>=1;i--) {
			if(dp[i] == maxHeight) {
				answer.add(bricks[i].idx);
				maxHeight -= bricks[i].height;
			}
		}
	
		// 출력
		System.out.println(answer.size());
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
	}

}