
public class 카카오_코테 {
//	static char[][] number = { { 'z', 'e', 'r', 'o' }, { 'o', 'n', 'e' }, { 't', 'w', 'o' },
//			{ 't', 'h', 'r', 'e', 'e' }, { 'f', 'o', 'u', 'r' }, { 'f', 'i', 'v', 'e' }, { 's', 'i', 'x' },
//			{ 's', 'e', 'v', 'e', 'n' }, { 'e', 'i', 'g', 'h', 't' }, { 'n', 'i', 'n', 'e' } };

	public static void main(String[] args) {
		String s = "123";
		int len = s.length();
		int idx = 0;
		StringBuilder sb = new StringBuilder();
		while (idx < len) {
			char tmp = s.charAt(idx);
			if ('0' <= tmp && tmp <= '9') {
				sb.append(tmp);
				idx += 1;
			} else if ('a' <= tmp && tmp <= 'z') {
				if (tmp == 'z') {
					sb.append(0);
					idx += 4;
				} else if (tmp == 'o') {
					sb.append(1);
					idx += 3;
				} else if (tmp == 't') {
					if (s.charAt(idx + 1) == 'w') {
						sb.append(2);
						idx += 3;
					} else if (s.charAt(idx + 1) == 'h') {
						sb.append(3);
						idx += 5;
					}
				} else if (tmp == 'f') {
					if (s.charAt(idx + 1) == 'o') {
						sb.append(4);
						idx += 4;
					} else if (s.charAt(idx + 1) == 'i') {
						sb.append(5);
						idx += 4;
					}
				} else if (tmp == 's') {
					if (s.charAt(idx + 1) == 'i') {
						sb.append(6);
						idx += 3;
					} else if (s.charAt(idx + 1) == 'e') {
						sb.append(7);
						idx += 5;
					}
				} else if (tmp == 'e') {
					sb.append(8);
					idx += 5;
				} else if (tmp == 'n') {
					sb.append(9);
					idx += 4;
				}
			}
		}
//		int answer=Integer.parseInt(sb.toString());
		long answer=Long.parseLong(sb.toString());
		System.out.println(answer);
	}
}

//카카오 여름인턴 문제 였다. 문자열을 숫자로 바꾸는 파싱 문제였다.
