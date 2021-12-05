---
## Programmers 순위
### **Idea**
* 승리와 패배를 그래프로 표현
* 내가 승리하는 상대와 패배하는 상대의 수를 DFS로 탐색
* 승리 + 패배의 수가 n-1인 선수의 수를 반환 


### ** 핵심 부분 구현**
```java        
    public void dfs(List<Integer>[] edge, int idx, Set<Integer> set) {
    	set.add(idx);
    	for(int next : edge[idx]) {
    		if(!set.contains(next)) {
    			dfs(edge,next,set);
    		}
    		
    	}
    	
    }   
        
```


