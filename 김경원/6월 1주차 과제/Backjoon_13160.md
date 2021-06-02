---
## Backjoon 13160 최대 클리크 구하기
### **Idea**
* 구간이 가장 많이 겹치는 구간을 찾는다
* 구간의 시작일 때 +, 구간의 끝일 때 - 하면서 최대 클리크 값을 찾는다
* 최대 클리크 값 갱신마다 point를 갱신 해준다
* point를 포함하는 클리크는 모두 최대 클리크에 포함된다

### ** 핵심 부분 구현**
```java
		for(Node node : line) {
			now_cnt += node.type;
			if(now_cnt > max_cnt) { //최대 클리크 갱신
				max_cnt = now_cnt;
				point = node.num; //최대 클리크일 때 point, num이 오름차순으로 정렬되어있으니 무조건 num은 start 기준 최대값 , end 기준 최소값
			}
		}
		int idx =0 ;
		sb.append(max_cnt).append("\n");
		for(Graph graph : list) {
			idx++;
			if(graph.i <= point && graph.j >= point) { //point를 포함하는 그래프는 모두 최대 클리크에 포함된다
				sb.append(idx).append(" ");
			}
		}

```

### 정리
처음에 정렬하는데 O(n log n), 최대 클리크를 찾는데 O(2*n) = O(n), 최대 클리크에 포함되는 그래프를 찾는데 O(n)의 시간이 소모된다.

