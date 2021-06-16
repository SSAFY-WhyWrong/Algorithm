
public class Programmers_징검다리_건너기 {
	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}; 
		int k = 3;
		
		int result = solution(stones, k);
		System.out.println(result);
	}
	
    static public int solution(int[] stones, int k) {
        int answer = 0;
        
        int low=0, high = 400000000;
        int mid;
        int cnt=0;
        int length = stones.length;
        while(low<=high) {
        	mid = (low+high)/2;
        	cnt = 0;
        	for(int i=0;i<length;i++) {
        		if(stones[i] < mid) {
        			cnt++;
        		}else {
        			cnt = 0;
        		}
        		
        		if(cnt >= k) {
        			high = mid-1;
        			break;
        		}
        	}
        	if(cnt < k) {
        		low = mid+1;
        		answer = Math.max(answer, mid);
        	}
        }
        
        
        return answer;
    }
}
