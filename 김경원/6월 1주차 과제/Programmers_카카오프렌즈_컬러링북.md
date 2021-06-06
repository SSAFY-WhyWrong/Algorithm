---
## Programmers 컬러링북
### **Idea**
* 0을 제외한 색을 발견 시 주변 상하좌우 탐색
* 이미 방문한적 있는 칸은 탐색하지 않음
* 탐색이 모두 끝나면 최대값, 영역 수 갱신


### ** 핵심 부분 구현**
```java
		boolean visit[][] = new boolean[m][n];
        int ni[] = {-1,1,0,0};
        int nj[] = {0,0,-1,1};
        
        Queue<Node> q = new LinkedList();
        
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		if(visit[i][j] || picture[i][j]==0) continue;
        		q.add(new Node(i,j));
        		int cnt=1;
        		visit[i][j] = true;
        		while(!q.isEmpty()) {
        			Node node = q.poll();
        			int x,y;
        			
        			for(int d=0;d<4;d++) {
        				x = node.i + ni[d];
        				y = node.j + nj[d];
        				if(x < 0 || y<0 || x>=m || y>=n || visit[x][y] || picture[i][j] != picture[x][y] )
        					continue;
        				
        				visit[x][y] = true;
        				cnt++;
        				q.add(new Node(x,y));
        			}        			
        		}
        		numberOfArea++;
        		maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
        		
        	}
        }
             

```

### 정리
단순한 탐색 문제

색의 원소 최대값이 (2^23) - 1 이므로 int 자료형의 범위를 넘지 않는다  

