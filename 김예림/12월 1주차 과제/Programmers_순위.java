package M12_1;

public class Programmers_순위 {
	public static void main(String[] args) {
		
		int n = 5;
		int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
		
		System.out.println(solution(n,results));
	}
	
	public static int solution(int n, int[][] results) {
		
		boolean[][] check = new boolean[n][n];
		int answer = 0;
		
		for(int i=0; i<results.length; i++) {
			int x = results[i][0]-1;
			int y = results[i][1]-1;
			
			check[x][y] = true;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(check[j][i]&&check[i][k]) check[j][k] = true;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			int cnt = 0;
			for(int j=0; j<n; j++) {
				if(check[i][j] || check[j][i]) cnt++;
			}
			if(cnt == n-1) answer++;
		}
		
		return answer;
	}
}
