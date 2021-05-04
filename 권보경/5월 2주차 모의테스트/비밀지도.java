
public class 비밀지도 {
	static int size;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        size = n;
        
        for(int i=0; i<n; i++) {
            String str = makeTwo(arr1[i]);
            String str2 = makeTwo(arr2[i]);
            String tmp = "";
            for(int j=n-1; j>=0; j--){
                // System.out.print(str2.charAt(j));
                if(str.charAt(j) == '0' && str2.charAt(j) == '0') {
                    tmp += " ";
                } else {
                    tmp += "#";
                }
            }
            // System.out.println();
            answer[i] = tmp;
        }
        return answer;
    }
    
    public String makeTwo(int num) {
        String tmp = "";
        
        while(true){
            if(num == 0) break;
            else {
                tmp += Integer.toString(num%2);
                num /= 2;
            }
        }
        
        while(true) {
            if(tmp.length() ==size) break;
            tmp += "0";
        }
        return tmp;
    }
}
