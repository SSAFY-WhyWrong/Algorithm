package AlgorithmStudy;

public class Programmers_N_Queen {

	static int answer;
	static boolean[] straight;
	static boolean[] right;
	static boolean[] left;
	static int[] loc;

	public static void main(String[] args) {

	}

	public static int solution(int n) {
		
		loc = new int[n];
		straight = new boolean[n];
		right = new boolean[n*2-1];
		left = new boolean[n*2-1];
		
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				if(!straight[j] && !right[i-j+n-1] && !left[i+j]) {
//					
//				}
//			}
//		}
		check(0,n);
		return answer;
	}
	private static void check(int i, int n) {
		for(int j=0; j<n; j++) {
			if(!straight[j] && !right[i-j+n-1] && !left[i+j]) {
				loc[i] = j;
                if(i == n-1) {
                    answer++;
                }else {
                	straight[j] = left[i+j] = right[i-j+n-1] = true;
                    check(i+1, n);
                    straight[j] = left[i+j] = right[i-j+n-1] = false;
                }
			}
		}
	}
}
