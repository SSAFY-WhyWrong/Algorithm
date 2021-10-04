---
## Baekjoon 16197 행성 터널
### **Idea**
* MST를 구하는 문제
* 행성 간의 거리를 모두 구하게 되면 N^2개 나오게 되어 메모리를 초과하게 됨
* x, y, z 각 좌표 별로 정렬을 하여 가까운 것 끼리의 거리만 구함

### ** 핵심 부분 구현**
```java
		Collections.sort(nodes, (node1, node2)-> node1.x - node2.x);
		for(int i=0;i<N-1;i++) {
			System.out.println(nodes.get(i).num+" "+nodes.get(i+1).num);
			edges.add(new Edge(nodes.get(i).num,nodes.get(i+1).num,Math.abs(nodes.get(i).x - nodes.get(i+1).x)));
		}
		
		Collections.sort(nodes, (node1, node2)-> node1.y - node2.y);
		for(int i=0;i<N-1;i++) {
			edges.add(new Edge(nodes.get(i).num,nodes.get(i+1).num,Math.abs(nodes.get(i).y - nodes.get(i+1).y)));
		}
		
        Collections.sort(nodes, (node1, node2)-> node1.z - node2.z);
		for(int i=0;i<N-1;i++) {			
			edges.add(new Edge(nodes.get(i).num,nodes.get(i+1).num,Math.abs(nodes.get(i).z - nodes.get(i+1).z)));
		}
```

### 정리
- 메모리를 생각하지 못하여 처음에 맞추지 못하였다.

- 하나의 좌표만으로 계산을 하기 때문에 1차원으로 두고 생각하여 문제를 접근하여 불필요한 계산을 줄이도록 하는 문제였다.

