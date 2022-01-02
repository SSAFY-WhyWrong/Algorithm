import java.math.BigInteger;
import java.util.Scanner;

public class Backjoon_2226 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger[] dp = new BigInteger[1001];
		
		dp[0] = new BigInteger("1"); dp[1] = new BigInteger("0"); dp[2] = new BigInteger("1");
		
		for(int i=3;i<=N;i++) {
			dp[i] = dp[i-1].multiply(BigInteger.TWO).subtract(BigInteger.ONE);
			if(i%2 == 0) {
				dp[i] = dp[i].add(BigInteger.TWO);
			}
		}
		
		System.out.println(dp[N]);
		
	}
}
