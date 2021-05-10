package M05_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//eclipse용 코드
public class Programmers_Network {
	
	static int n;
	static int[] root;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		int[][] computers = new int[n][n];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				computers[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0; i<n; i++) {
			root[i] = i;
		}
		
		System.out.println(solution(n,computers));
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;

		root = new int[n+1];
		//makeset
		for(int i=0; i<n; i++){
			root[n] = i;
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(i != j && computers[i][j]==1){
					if(unionSet(i, j))
						answer++;
				}
			}
		}

		return answer;
	}
	//findset
	private static int findSet(int a){
		if(root[a]==a) return a;
		return root[a] = findSet(root[a]);
	}      
	//unionset
	private static boolean unionSet(int a, int b){
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) return false;

		root[bRoot] = aRoot;
		return true;
	}
}

///////////////////////////////////////////////////////////////////////////////////////////
//programmers용 코드
class Solution {
    
    static int[] root;
    
    public int solution(int n, int[][] computers) {
        int answer = n;
        
        root = new int[n];
        //makeset
        for(int i=0; i<n; i++){
            root[i] = i;
        }
       for(int i=0; i<n; i++){
           for(int j=0; j<n; j++){
               if(i != j && computers[i][j]==1){
                   if(unionSet(i, j))
                       answer--;
               }
           }
       }
        
        return answer;
    }
    //findset
    private static int findSet(int a){
        if(root[a]==a) return a;
        return root[a] = findSet(root[a]);
    }      
    //unionset
    private static boolean unionSet(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot==bRoot) return false;
        
        root[bRoot] = aRoot;
        return true;
    }
}