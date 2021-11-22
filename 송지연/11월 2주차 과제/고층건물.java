import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1027_고층건물 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
         
        int N = Integer.parseInt(st.nextToken());
        int[] building = new int[N];
        st = new StringTokenizer(bf.readLine());
        
        for(int i=0;i<N;i++) {
        	building[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] count = new int[N];
        
        for(int i=0;i<N-1;i++) {
        	count[i]++;
        	count[i+1]++;
        	
        	double slope = building[i+1] - building[i];
        	for(int j=i+2;j<N;j++) {
        		
        		if(slope >= (double)(building[j]-building[i])/(j-i)) continue;
        		
        		slope = (double)(building[j]-building[i])/(j-i);
        		count[i]++;
        		count[j]++;
        	}
        }
        
        Arrays.sort(count);
        System.out.println(count[N-1]);
	}

}
