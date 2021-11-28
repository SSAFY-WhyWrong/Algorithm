import java.util.Scanner;

public class Backjoon_10589 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n,m;
		n = sc.nextInt();
		m = sc.nextInt();
		
		
		System.out.println(n/2 + m/2);
		
		for(int i=1;i<m;i+=2) {
			System.out.println(1+" "+(i+1)+" "+n+" "+(i+1));
		}
		
		for(int i=1;i<n;i+=2) {
			System.out.println((i+1)+" "+1+" "+(i+1)+" "+m);
		}
		
		
		
	}
}
