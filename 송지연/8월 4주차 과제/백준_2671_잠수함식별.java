import java.util.Scanner;
import java.util.regex.Pattern;

public class 백준_2671_잠수함식별 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sound = sc.next();
		String pattern = "^(100+1+|01)+$"; // ^ : 행의 시작 $ : 행의 끝
		
		if(sound.matches(pattern)) {
			System.out.println("SUBMARINE");
		} else {
			System.out.println("NOISE");
		}
	}

}
