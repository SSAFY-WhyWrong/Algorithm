import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Backjoon_2671 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String pattern = "(100+1+|01)+";
		
		if(Pattern.matches(pattern, str)) 
			System.out.println("SUBMARINE");
		else
			System.out.println("NOISE");
		
		
		
	}
}
