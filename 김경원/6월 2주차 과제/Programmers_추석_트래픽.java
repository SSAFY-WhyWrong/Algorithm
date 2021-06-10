import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Programmers_추석_트래픽 {
	public static void main(String[] args) {
		
		
		//String lines[] = {"2016-09-15 01:00:04.001 2.0s","2016-09-15 01:00:07.000 2s"};
		String lines[] = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
		System.out.println(solution(lines));
	}
	
	
	static class Node implements Comparable<Node>{
		int time;
		int type;
		Node(int time, int type){
			this.time = time;
			this.type = type;
		}
		@Override
		public int compareTo(Node o) {
			if(this.time == o.time) {
				if(this.type == 1)
					return -1;
				else
					return  1;
			} else if(this.time < o.time)
				return -1;
			else
				return 1;
		}
	}
	
    static public int solution(String[] lines) {
        int answer = 0;
        
        int size = lines.length;
        
        int logs[] = new int[size];
        String hour;
        String minute;
        String second;
        String msecond;
        double duration;
        int start;
        int end;
        
        List<Node> list = new ArrayList();
        //2016-09-15 01:00:04.001 2.0s
        for(int i=0;i<size;i++) {
        	hour = lines[i].substring(11,13);
        	minute = lines[i].substring(14,16);
        	second = lines[i].substring(17,19);
        	msecond = lines[i].substring(20,23);
        	duration = Double.parseDouble(lines[i].substring(24,lines[i].length()-1));
        	end = (int)Double.parseDouble(hour)*60*60*1000;
        	end += (int)Double.parseDouble(minute)*60*1000;
        	end += (int)Double.parseDouble(second)*1000;
        	end += (int)Double.parseDouble(msecond);
        	//System.out.println(hour+":"+minute+":"+second+"."+msecond);
        	//System.out.println(duration);
        	duration *= 1000;
        	start = end - (int)duration +1;        	
        	end += 999;
        	list.add(new Node(start ,1));
        	list.add(new Node(end,-1));
        }
        
        Collections.sort(list);
        double now_time=0;
        size = list.size();       
        int cnt=0;
        
        for(int i=0;i<size;i++) {
        	cnt += list.get(i).type;
        	
        	answer = Math.max(answer, cnt);
        }        
        
        
        return answer;
    }
}
