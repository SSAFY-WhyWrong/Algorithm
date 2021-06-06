import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_16196 {
	public static void main(String[] args) throws IOException {
		
		check_licence();
		
		
	}
	
	static void check_licence() throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String licence; // 신분증 번호
		int cnt; //지역번호 수
		int region; //지역 코드
		int year, month, day; //생년월일
		int order=0; //순서 코드
		int checksum; //체크섬 코드
		boolean region_check = false;
		int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		
		
		licence = br.readLine();
		cnt = Integer.parseInt(br.readLine());
		
		region = Integer.parseInt(licence.substring(0,6));
		
		for(int i=0;i<cnt;i++) {
			int input_region = Integer.parseInt(br.readLine());
			if(input_region == region) {
				region_check = true;
				break;
			}
		}
		
		if(!region_check) {
			System.out.println("I");
			return;
		}
		
		year = Integer.parseInt(licence.substring(6,10));
		month = Integer.parseInt(licence.substring(10,12));
		day = Integer.parseInt(licence.substring(12,14));
		
		
		if(year < 1900 || year > 2011) {
			System.out.println("I");
			return;
		}
		
		if(month < 1 || month > 12) {
			System.out.println("I");
			return;
		}
		
		if(day < 1 ) {
			System.out.println("I");
			return;
		}
		
		if(year%4==0 && year!=1900 && month==2) { //윤년인데 2월인 경우
			if(day>29) {
				System.out.println("I");
				return;
			}
		}else {
			if(day > days[month]) {
				System.out.println("I");
				return;
			}
		}
		
		order = Integer.parseInt(licence.substring(14,17));
		if(order == 0) {
			System.out.println("I");
			return;
		}
		
		if(licence.charAt(17)=='X')
			checksum = 10;
		else {
			checksum = licence.charAt(17) - '0';
		}
		
		int temp=1;
		for(int i=16;i>=0;i--) {
			temp*= 2;
			checksum += ((licence.charAt(i) -'0') ) * temp;
		}
		
		if(checksum%11 == 1) {
			if(order %2 == 1) {
				System.out.println("M");
				return;
			}else {
				System.out.println("F");
				return;
			}
		}else {
			System.out.println("I");
			return;
		}
			
		
	}
	
}
