class programmers_N으로표현하기 {
    static int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        if (answer > 8)
            answer = -1;
        return answer;
    }

    static void dfs(int N, int number, int idx, int sum) {
        if (idx > 8)
            return;
        if (sum == number) {
            answer = Math.min(idx, answer);
        }
        int temp = 0;
        for (int i = 1; i <= 8; i++) {
            temp = temp * 10 + N;
            dfs(N, number, idx + i, sum + temp);
            dfs(N, number, idx + i, sum - temp);
            dfs(N, number, idx + i, sum / temp);
            dfs(N, number, idx + i, sum * temp);
        }
    }
}
