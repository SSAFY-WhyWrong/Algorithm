public class Programmers_광고_삽입 {
	public static void main(String[] args) {
		
		String play_time = "02:03:55";
		String adv_time = "00:14:15";		
		String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		solution(play_time, adv_time, logs);
	}
	static public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int playtime = Integer.parseInt(play_time.substring(0,2));
    	playtime*= 60;
    	playtime += Integer.parseInt(play_time.substring(3,5));
    	playtime*=60;
    	playtime += Integer.parseInt(play_time.substring(6,8));
        
        int advtime = Integer.parseInt(adv_time.substring(0,2));
        advtime*= 60;
        advtime += Integer.parseInt(adv_time.substring(3,5));
        advtime*=60;
        advtime += Integer.parseInt(adv_time.substring(6,8));
    	
        long cnt[] = new long[playtime+1];
        
        
        for(String str : logs) {
        	int start;
        	start = Integer.parseInt(str.substring(0,2));
        	start*= 60;
        	start += Integer.parseInt(str.substring(3,5));
        	start*=60;
        	start += Integer.parseInt(str.substring(6,8));
        	
        	int end;	        	
        	end = Integer.parseInt(str.substring(9,11));
        	end*= 60;
        	end += Integer.parseInt(str.substring(12,14));
        	end*=60;
        	end += Integer.parseInt(str.substring(15,17));
        	
        	for(int i=start;i<end;i++) {
        		cnt[i]++;
        	}
        }
        
        for(int i=1;i<cnt.length;i++) {
        	cnt[i]+=cnt[i-1];
        }
        
        
        int start = 0;
        int end = advtime;
        long maxtime = cnt[advtime-1];
        int answertime=0;
        for(int i=0; i <= playtime - advtime; i++) {
        	long time = cnt[i+advtime] - cnt[i];
        	if(maxtime < time) {
        		answertime = i+1;
        		maxtime = time;
        	}
        }

        int hour =answertime / 3600;        	
        int min = (answertime/60)%60;
        int sec = answertime%60;
        
        answer = String.format("%02d:%02d:%02d", hour,min,sec);
        System.out.println(answer);
        
        
        return answer;
	    }
}
