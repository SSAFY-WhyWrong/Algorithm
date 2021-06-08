import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj16196 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        String area = str.substring(0, 6); // 지역코드
        boolean checkArea = false;
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            if (tmp.equals(area)) {
                checkArea = true;
                break;
            }
        }

        if (!checkArea) {
            System.out.println("I");
            return;
        }

        if (!checkBirth(str)) {
            System.out.println("I");
            return;
        }

        if (!checksum(str)) {
            System.out.println("I");
            return;
        }

        String answer = "I";
        String tmp = str.substring(14, 17);
        if (tmp.equals("000")) {
            answer = "I";
        } else if (Integer.parseInt(tmp) % 2 == 1) {
            answer = "M";
        } else {
            answer = "F";
        }

        System.out.println(answer);

    }

    private static boolean checksum(String str) {
        int sum = 0;
        if (str.charAt(17) == 'X')
            sum = 10;
        else
            sum = str.charAt(17) - '0';

        for (int i = 0; i < 17; i++) {
            sum += ((str.charAt(i) - '0') * Math.pow(2, 17 - i));
            sum %= 11;
        }

        if (sum != 1)
            return false;
        return true;

    }

    public static boolean checkBirth(String s) {
        int year = Integer.parseInt(s.substring(6, 10));
        int month = Integer.parseInt(s.substring(10, 12));
        int day = Integer.parseInt(s.substring(12, 14));
        // System.out.println("year: " + year + " , month : " + month + " , day : " +
        // day);
        int[] d = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            d[2] = 29;
        }
        if (1900 > year || year > 2011)
            return false;
        if (1 > month || month > 12)
            return false;
        if (day <= 0 || day > d[month]) {
            return false;
        }
        return true;
    }
}
