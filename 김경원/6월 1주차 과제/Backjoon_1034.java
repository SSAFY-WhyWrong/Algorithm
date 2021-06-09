import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1034 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int arr[][] = new int[51][51];
		boolean visit[] = new boolean[51];
		int N,M,K;
		int result, cnt;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		
	
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j=0;j<M;j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		K = Integer.parseInt(br.readLine());
		result = 0;
		

		
		for(int i=0;i<N;i++) {
			if(visit[i]) continue;
			visit[i] = true;
			cnt=0;
			
			//1로 바꿔야하는 열의 수 카운트
			for(int j=0;j<M;j++)
				if(arr[i][j]==0) cnt++;
			
			
			if(cnt <= K && (K-cnt)%2==0) { //바꿔야하는 0의 수가 K 이하면서 K만큼 눌른 후에 짝수 번 남는 경우만 확인 
				int temp=0;
				for(int t=i;t<N;t++) {// 위에서 같은 경우 봤으니깐 중복되는 경우는 안 봐도 됨
					if(isSame(arr[i],arr[t],M)) {
						visit[t] = true;
						temp++;
					}
				}
				result = Math.max(result,temp);
			}
			
			
		}
		
		System.out.println(result);
		
		
		
	}
	
	
	static boolean isSame(int arr1[], int arr2[], int M) {
		for(int j=0;j<M;j++)
			if(arr1[j] != arr2[j])
				return false;
		return true;
	}
	
}
