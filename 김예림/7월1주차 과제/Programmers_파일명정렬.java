package M07_1;

import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] files) {
        int size = files.length;
        
        String[] answer = new String[size];
        
        Name[] sortFile = new Name[size];
        for(int s=0; s<size; s++){
            String head = "";
            String number = "";
            String tail = "";
            
            int idx = 0;
            for(; idx<files[s].length(); idx++){
                char c = files[s].charAt(idx);
                if(48 > c || c > 57) {
                    head += c;
                } else break;
            }
            for(; idx<files[s].length(); idx++){
                char c = files[s].charAt(idx);
                if(48 <= c && c <= 57) {
                    number += c;
                } else break;
            }
            for(; idx<files[s].length(); idx++){
                tail += files[s].charAt(idx);
            }
            sortFile[s] = new Name(head,number,tail);
        }
        Arrays.sort(sortFile);
        
        for(int i=0; i<size; i++){
            answer[i] = sortFile[i].head + sortFile[i].number + sortFile[i].tail;
        }
        
        return answer;
    }
    
    static class Name implements Comparable<Name>{
		String head;
		String number;
        String tail;
        public Name(String head, String number, String tail) {
			super();
			this.head = head;
			this.number = number;
            this.tail = tail;
		}
		@Override
		public int compareTo(Name o) {
			if(this.head.compareToIgnoreCase(o.head) == 0){
                int a = Integer.parseInt(this.number);
                int b = Integer.parseInt(o.number);
				return a-b;
            } 
			else return this.head.compareToIgnoreCase(o.head);
		}
	}
    
}
