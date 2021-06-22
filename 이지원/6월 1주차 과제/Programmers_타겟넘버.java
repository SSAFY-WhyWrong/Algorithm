package day_0608;

public class Programmers_타겟넘버 {
	static int ans;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(0, numbers, target, 0);
        answer = ans;
        return answer;
    }
    static void dfs(int i, int[] numbers, int target, int sum){
        if(i == numbers.length){
            if(target == sum){
                ans++;
            }
            return;
        }
        
        dfs(i + 1, numbers, target, sum + numbers[i]);
        dfs(i + 1, numbers, target, sum - numbers[i]);
    }
}
