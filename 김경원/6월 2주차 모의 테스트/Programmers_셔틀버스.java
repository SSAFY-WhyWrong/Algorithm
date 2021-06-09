import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_셔틀버스 {
	public static void main(String[] args) {
		int n = 2;
		int t = 10;
		int m = 2;
		String[] timetable = {"08:00","09:09","09:10"};
		System.out.println(solution(n,t,m,timetable));
	}

	static public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		List<Integer> times = new ArrayList();
		int time;
		int size = timetable.length;
		for(int i=0;i<size;i++) {
			time = Integer.parseInt(timetable[i].substring(0,2))*60;
			time+= Integer.parseInt(timetable[i].substring(3,5));
			if(time == 1440) time=1439;
			times.add(time);
		}
		
		Collections.sort(times);
		
		int max_crew = m*n;
		int final_time = 9*60 + t*(n-1);
		int now_time = 9*60;
		int cnt=0;
		int result = final_time;
		int idx=0;
		
		while(true) {			
			while(idx < size) {
				if(times.get(idx) <= now_time && cnt < m) {
					cnt++;
					idx++;
				}
				else
					break;
			}
			if(now_time == final_time) break;
			cnt -= m;
			if(cnt < 0 ) cnt = 0;
			now_time += t;
					
		}

		if(cnt < m) result = final_time;
		else result = times.get(idx-1)-1;
		
		
		String hour;
		String minute;
		if(result < 600)
			hour = "0"+result/60;
		else
			hour = ""+result/60;
		
		
		if(result%60 <10)
			minute = "0"+result%60;
		else
			minute = ""+result%60;
		
		
		answer = hour+":"+minute;
		
		return answer;
	}

}
