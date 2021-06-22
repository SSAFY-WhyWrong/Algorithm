import java.io.*;
import java.util.*;

class boj3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] up = new int[H+1];
        int[] down = new int[H+1];
        int[] sum = new int[H+1];

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(i%2 == 0) {
                down[H-num]++;
            } else {
                up[num-1]++;
            }
        }
        
        for(int i=1; i<=H; i++) {
            down[i] = down[i] + down[i-1];
        }
        for(int i=H-1; i>0; i--) {
            up[i] = up[i] + up[i+1];
        }

        for(int i=1; i<H+1; i++) {
            sum[i] = up[i] + down[i];
        }
        
        Arrays.sort(sum);

        int cnt = 0;
        for(int i=1; i<H+1; i++) {
            if(sum[i] == sum[1]) cnt++;
            else break;
        }
        bw.write(sum[1] + " " + cnt + "\n");
        bw.close();
    }
}