
public class Programmers_보행자_천국 {
	static int MOD = 20170805;
	public static void main(String[] args) {
		
		int m = 3;
		int n = 6;
		int cityMap[][] = {{0,2,0,0,0,2},{0,0,2,0,1,0},{1,0,0,2,2,0}};
		
		int result = solution(m,n,cityMap);
		System.out.println(result);
		
	}
    static public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        
        int left[][] = new int[m][n]; //좌에서 오는 가능 경로
        int up[][] = new int[m][n]; //상에서 오는 가능 경로
        
        
        left[0][0] = 1;
        up[0][0] = 1;
        
        //0 : 자유통행 , 1 : 차량 진입 금지 , 2 : 회전 금지
        for(int i=0;i<m-1;i++) {
        	if(cityMap[i][0] != 1) {
        		up[i+1][0] += up[i][0];        		
        	}
        }
        
        for(int j=0;j<n-1;j++) {
        	if(cityMap[0][j] != 1) {
        		left[0][j+1] += left[0][j];        		
        	}
        }
        
        for(int i=1;i<m;i++) {
        	for(int j=1;j<n;j++) {
        		if(cityMap[i-1][j]!=1) { //위에서 오는 경우
        			up[i][j] += up[i-1][j];
                    up[i][j] %= MOD;
        			if(cityMap[i-1][j]!=2){
        				up[i][j] += left[i-1][j];
                        up[i][j]%=MOD;
                    }
        		}
        		
        		if(cityMap[i][j-1]!=1) {
        			left[i][j] += left[i][j-1];
                    left[i][j] %= MOD;
        			if(cityMap[i][j-1]!=2) {
        				left[i][j] += up[i][j-1];
                        left[i][j]%=MOD;
        			}
        		}
        	}
        }
   
        answer = up[m-1][n-1] + left[m-1][n-1];
        answer %= MOD;        

        
        return answer;
    }
}
