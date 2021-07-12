import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_17822 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N,M,T;
		int ni[] = {-1,1,0,0};
		int nj[] = {0,0,-1,1};
		
		double test = 0;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		T = Integer.parseInt(st.nextToken(" "));
		
		int circle[][] = new int[N+1][M];
		
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				circle[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}
		
		
		int xi,d,k;
		
		
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			
			xi = Integer.parseInt(st.nextToken(" "));
			d = Integer.parseInt(st.nextToken(" "));
			k = Integer.parseInt(st.nextToken(" "));
			
			//회전 start
			for(int i=1;i*xi<=N;i++) {
				int[] arr = new int[M];
				if(d == 0) { //시계방향
					for(int j=0;j<M;j++) {
						arr[(j+k)%M] = circle[i*xi][j];
					}
					for(int j=0;j<M;j++) {
						circle[i*xi][j] = arr[j];
					}
					
				}else { //반 시계방향
					for(int j=0;j<M;j++) {
						arr[(j+(M-k))%M] = circle[i*xi][j];
					}
					for(int j=0;j<M;j++) {
						circle[i*xi][j] = arr[j];
					}
				}
			}
			
			//회전 end
			
	
			//인근 숫자 확인 start
			
			boolean isChange = false;
			boolean isSame;
			int sum = 0;
			int cnt =0;
			int temp[][] = new int[N+1][M];
			
			for(int i=1;i<=N;i++) {
				for(int j=0;j<M;j++) {
					if(circle[i][j] ==0) continue;
					sum += circle[i][j];
					cnt++;
					
					int x,y;
					for(int dir=0;dir<4;dir++) {
						x = i + ni[dir];
						y = (M+j + nj[dir])%M;
						if(x < 1 || x>N ) continue;
						
						if(circle[i][j] == circle[x][y]) {
							temp[i][j] = circle[i][j];
							isChange = true;
							break;							
						}
						
					}
				}
			}			
			
			//인근 숫자 확인 end
			
			if(isChange) {
				for(int i=1;i<=N;i++) {
					for(int j=0;j<M;j++) {
						if(circle[i][j] == temp[i][j])
							circle[i][j] = 0;
					}
				}
			}else {
				double avg = (double)sum / cnt;
				for(int i=1;i<=N;i++) {
					for(int j=0;j<M;j++) {
						if(circle[i][j] == 0 ) continue;
						
						
						if(circle[i][j] > avg)
							circle[i][j]--;
						else if(circle[i][j] < avg)
							circle[i][j]++;
					}
				}
			}
			

						
			
		}
//		for(int i=1;i<=N;i++) {
//			for(int j=0;j<M;j++) {
//				System.out.print(circle[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		int sum = 0;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<M;j++) {
				sum += circle[i][j];
			}
		}
		
		System.out.println(sum);
		
	}
}

