import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] cnt = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int start = 0; // 수열 시작 인덱스
        int end = 0; // 수열 끝 인덱스

        while (true) {
            if (start > end || N < end)
                break;
            
            cnt[arr[start]]++;
            for (int i=0; ; i++) {
                end += i;

                if (N < end || cnt[arr[end]] > K) {
                    for(int j=start; j<end; j++) {
                        cnt[arr[j]]--;
                    }
                    start = end;
                    break;
                }

                cnt[arr[end]]++;
                if (ans < end - start + 1)
                    ans = end - start + 1;
            }
        }

        System.out.println(ans);
    }
}