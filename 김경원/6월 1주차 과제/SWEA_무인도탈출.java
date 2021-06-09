import java.util.Scanner;
 
public class SWEA_무인도탈출 {
    static class Cube {
        int n, m, h;
 
        Cube(int n, int m, int h) {
            this.n = n;
            this.m = m;
            this.h = h;
        }
    }
 
    static Cube block[];
    static int dp[][][] = new int[20][3][1<<20];
    static int result;
    public static void main(String[] args) {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
//      int bit=0;
//      bit = 0 | 1 << 0;
//      System.out.println(Integer.toBinaryString(bit));
//      bit = bit | 1 << 2;
//      System.out.println(Integer.toBinaryString(bit));
        //int test_case = Integer.parseInt(br.readLine());
        int test_case = sc.nextInt();
 
        int N;
        int n, m, h;
        int temp_n, temp_m, temp_h;
 
        for (int t = 1; t <= test_case; t++) {
            //N = Integer.parseInt(br.readLine());
            N = sc.nextInt();
            block = new Cube[N];
            for(int i=0;i<N;i++) {
                for(int j=0;j< (1<< N);j++) {
                    dp[i][0][j] = 0;
                    dp[i][1][j] = 0;
                    dp[i][2][j] = 0;
                }
            }
 
             
            for (int i = 0; i < N; i++) {
                //st = new StringTokenizer(br.readLine());
//              temp_n = Integer.parseInt(st.nextToken(" "));
//              temp_m = Integer.parseInt(st.nextToken(" "));
//              temp_h = Integer.parseInt(st.nextToken(" "));
                temp_n = sc.nextInt();
                temp_m = sc.nextInt();
                temp_h = sc.nextInt();
                n = temp_h;
                if(temp_n < temp_h) n = temp_n;
                if(temp_m < n) n = temp_m;
                 
                h = temp_h;
                if(temp_n > temp_h) h = temp_n;
                if(temp_m > h ) h = temp_m;
               
                 
                m = temp_n + temp_m + temp_h - n - h; 
                //System.out.println(n+" "+m+" "+h);
                block[i] = new Cube(h,m,n);
            }
            result = 0;
            result = choice_block(N,0,0,10000,10000,0);
            System.out.println("#"+t+" "+result);
        
            //sb.append("#").append(t).append(" ").append(result).append("\n");
             
        }
        ///System.out.println(sb);
        sc.close();
 
    }
 
    private static int choice_block(int N, int bit,int now, int x,int y,int way) {
        //System.out.println(bit);
        if(dp[now][way][bit] != 0)
            return dp[now][way][bit];
         
        int height=0;
        int temp;
        for(int i=0;i<N;i++) {
            if((bit  & (1 << (i))) !=0) continue;
             
             
            if(x >= block[i].n && y>= block[i].m) {
                temp = choice_block(N,bit | (1 << (i)),i,block[i].n,block[i].m,0) + block[i].h; 
                if(height < temp) height =temp;;
            }
            if(x >= block[i].n && y>= block[i].h) {
                temp =choice_block(N,bit | (1 << (i)),i,block[i].n,block[i].h,1) + block[i].m;
                if(height < temp) height = temp;
            }
             
            if(x >= block[i].m && y>= block[i].h) {
                temp = choice_block(N,bit | (1 << (i)),i,block[i].m,block[i].h,2) + block[i].n;
                if(height < temp) height = temp;
            }
             
        }
         
        return dp[now][way][bit] = height;
    }
     
     
     
}