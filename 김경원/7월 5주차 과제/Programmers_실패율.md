---
## Programmers 실패율
### **Idea**
* 각 스테이지에 도달한 최고 플레이어 수와 누적 플레이어 수를 계산
* 그 후 스테이지별로 실패율을 계산하여 정렬


### ** 핵심 부분 구현**
```java        
      static public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        //실패율 = 스테이지에 도달했으나 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
        //N+1은 마지막 스테이지까지 클리어한 사람 수
        
        int cnt[] = new int[N+2]; //도달한 플레이어 수
        int best[] = new int[N+2]; //최고 스테이지 수
        
        for(int i=0;i<stages.length;i++) {
        	cnt[stages[i]]++;
        	best[stages[i]]++;
        }
        
        for(int i=N+1;i>1;i--) {
        	cnt[i-1] += cnt[i];
        }
        
    
        
        List<Node> list = new ArrayList();
        
        for(int i=1;i<=N;i++) {
        	double failure_late;
        	if(cnt[i]==0)
        		failure_late = 0;
        	else
        		failure_late = (double)best[i] / cnt[i];
        	        	
        	list.add(new Node(failure_late,i));
        }
        
        Collections.sort(list);
        answer = new int[N];
        for(int i=0;i<list.size();i++) {
        	answer[i] = list.get(i).stage_no;
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
```

### 정리

