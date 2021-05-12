package M05_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Programmers_완주하지못한선수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] participant = new String[3];
		for(int i=0; i<3; i++) {
			participant[i] = br.readLine();
		}
		String[] completion = new String[2];
		for(int i=0; i<2; i++) {
			completion[i] = br.readLine();
		}
	}
	
    public String solution(String[] participant, String[] completion) {
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
               return participant[i]; 
            }
        }
        
        return participant[participant.length-1];
    }

}