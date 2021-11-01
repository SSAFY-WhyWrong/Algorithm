package M07_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_ĳ�� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int cacheSize = Integer.parseInt(st.nextToken());
		int citylen = Integer.parseInt(st.nextToken());
		
		String[] cities = new String[citylen];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<citylen; i++) {
			cities[i] = st.nextToken();
		}
		System.out.println(solution(cacheSize, cities));
	}
	
	public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> q = new LinkedList<String>();
        
        if(cacheSize==0) return cities.length*5;  
        
        for(int i=0; i<cities.length; i++){
            String str = cities[i].toLowerCase();
            if(q.isEmpty()){
            	//ť�� ��������� �׳� ä���.
               answer += 5;
               q.offer(str);
            }else {
            	//ť�� ������� �ʰ�
            	//ĳ�� �ȿ� �����Ͱ� ������
            	if(q.contains(str)) {
            		answer += 1;
            		q.remove(str);
            		q.offer(str);
            	}else {
            		//ť �ȿ� �����Ͱ� ������
            		answer += 5;
            		//ť�� ���� �� ������ �ϳ��� ���� ���� �ִ´�.
            		if(q.size()==cacheSize) q.poll();
            		q.offer(str);
            	}
            }
        }
        return answer;
    }
}
/*
3 9
Jeju Pangyo Seoul Jeju Pangyo Seoul Jeju Pangyo Seoul

5 3
Seoul Seoul Seoul
*/
