## 4월 5주차 과제 풀이
---
## Programmers 네트워크
### **Idea**
* 0번부터 n-1번 노드까지 BFS 탐색을 실시
* 이미 방문한 노드라면 BFS 탐색을 실시하지 않고 continue
* BFS 탐색을 시작할 때마다 result++ 해준다


### ** 핵심 부분 구현**
```java
  for(int i=0;i<n;i++){
            if(visit[i]) continue;
            bfs(i,visit,computers,n);
            answer++;
        }

```

### 정리
단순 BFS 문제 였다
