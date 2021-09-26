import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_16884 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int testCase;
        
        st = new StringTokenizer(br.readLine());
        
        testCase = Integer.parseInt(st.nextToken());
        
        for(int t=0; t<testCase;t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            
            if(N%2==0)
                System.out.println("cubelover");
            else
                System.out.println("koosaga");
            
        }
        
        
        		
	}
}
