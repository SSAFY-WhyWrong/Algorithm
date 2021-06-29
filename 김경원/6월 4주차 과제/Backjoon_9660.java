import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//백준 9660 돌 게임 6
public class Backjoon_9660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
				
		long num = (N-2)%7 + 2;
		
		if(num == 2 || num == 7)
			System.out.println("CY");
		else
			System.out.println("SK");
		
	
		
	}
}
