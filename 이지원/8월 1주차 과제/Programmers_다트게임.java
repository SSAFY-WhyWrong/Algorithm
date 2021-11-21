package day_0809;

public class Programmers_다트게임 {
	class Solution {
	    public int solution(String dartResult) {
	        int answer = 0;
	        char[] arr = dartResult.toCharArray();
	        int[] sum = new int[3];
	        int idx = 0;
	        Dart[] d = new Dart[3];
	        for(int i = 1; i < arr.length; i++) {
	            int num = arr[i - 1] - '0';
	            if(arr[i] == '0'){
	                num = 10;
	                i++;
	            }
	            char area = arr[i];
	            char price = '-';
	            if(i + 1 < arr.length && (arr[i + 1] == '#' || arr[i + 1] == '*')){
	                if(arr[i + 1] == '#'){
	                    price = '#';
	                } else {
	                    price = '*';
	                }
	                i++;
	            }
	            i++;
	            d[idx++] = new Dart(num, area, price);
	        }
	        idx = 0;
	        while(true) {
	            Dart cur = d[idx];
	            sum[idx] = cur.num;
	            if(cur.area == 'S'){
	                sum[idx] = sum[idx];
	            } else if(cur.area == 'D'){
	                sum[idx] = sum[idx] * sum[idx];
	            } else if(cur.area == 'T'){
	                sum[idx] = sum[idx] * sum[idx] * sum[idx];
	            }
	            if(cur.price == '*'){
	                for(int i = idx - 1; i < idx + 1; i++){
	                    if(i < 0) {
	                        continue;
	                    }
	                    sum[i] = sum[i] * 2;
	                }
	            } else if(cur.price == '#'){
	                sum[idx] = sum[idx] * (-1);
	            }
	            idx++;
	            if(idx >= 3){
	                break;
	            }
	        }
	        for(int i = 0; i < 3; i++){
	            answer += sum[i];
	        }
	        return answer;
	    }
	    
	}
	static class Dart {
		int num;
		char area;
		char price;
		public Dart(int num, char area, char price){
			this.num = num;
			this.area = area;
			this.price = price;
		}
	}
}
