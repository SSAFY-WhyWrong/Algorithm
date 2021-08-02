package day_0802;
import java.util.*;

public class Programmers_실패율 {
	class Solution {
	    public int[] solution(int N, int[] stages) {
	        int[] answer = {};
	        int[] ing = new int[N + 2];
	        Stage[] ans = new Stage[N];
	        double[] per = new double[N + 1];
	        answer = new int[N];
	        
	        for(int i = 0; i < stages.length; i++){
	            ing[stages[i]]++;
	        }
	        
	        for(int i = 1; i < ing.length - 1; i++){
	            int sum = 0;
	            for(int j = i; j < ing.length; j++){
	                sum += ing[j];
	            }

	            if(sum == 0){
	                if(ing[i] == 0){
	                    per[i] = (double)0;
	                } else {
	                    per[i] = (double)1;
	                }
	                continue;
	            }
	            per[i] = ((double)ing[i]) / sum;
	        }
	        for(int i = 1; i < per.length; i++){
	            ans[i - 1] = new Stage(i, per[i]);
	        }
	        Arrays.sort(ans);
	        
	        for(int i = 0; i < ans.length; i++){
	            answer[i] = ans[i].stage_num;
	        }
	        
	        return answer;
	    }
	    
	}
	static class Stage implements Comparable<Stage>{
		int stage_num;
		double percent;
		public Stage (int stage_num, double percent){
			this.stage_num = stage_num;
			this.percent = percent;
		}
		@Override
		public int compareTo(Stage o){
			if (this.percent == o.percent) {
				return this.stage_num < o.stage_num ? -1 : 1;
			} else {
				return this.percent > o.percent ? -1 : 1;
			}
		}
	}
}
