
public class Programmers_카펫 {
	public static void main(String[] args) {
		
		int brown = 8;
		int yellow = 1;
		
		
		int answer[] = solution(brown, yellow);
		System.out.println(answer[0]+" "+answer[1]);
		
	}
	
	
	
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        int brown_cnt=0, yellow_cnt=0;
        
       
        for(int i=3;i<=sum/3;i++){
        	//i는 최소3 이상
        	if(sum % i != 0) continue; // 현재 지정한 i로 나누었을 때 나머지가 0이 아니면 애초에 개수가 안 맞으니깐 패스        	
        	int j = sum/i;
        	brown_cnt = i *2 + j*2 - 4; //테두리 개수 계산
        	yellow_cnt = (i-2)*(j-2); //내부 개수 계산
        	if(brown_cnt == brown && yellow_cnt == yellow) {
        		answer[0] = j;
            	answer[1] = i;
        		break;
        	}
        	
        }
        
        
        
        return answer;
    }
}
