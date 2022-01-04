import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class 백준_2226_이진수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger length = new BigInteger("1");
		BigInteger zeroCnt = new BigInteger("0");
		
		for(int i=2;i<=N;i++) {
			zeroCnt = length.subtract(zeroCnt);
			length = length.multiply(new BigInteger("2"));
		}
		
		System.out.println(zeroCnt);

	}

}
