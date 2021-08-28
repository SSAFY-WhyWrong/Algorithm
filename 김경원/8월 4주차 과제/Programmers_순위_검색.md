---
## Programmers 순위 검색
### **Idea**
* 상관 없는 경우를 포함하여 언어(4가지), 포지션(3가지), 경력(3가지), 소울푸드(3가지)해서 총 4*3*3*3 = 108개의 리스트를 만들어준다.
* 리스트는 HashMap<String, List<Integer>> 형태로 관리
* 하나의 info에 접근하는데 16(2^4)가지의 방법이 있음
* 리스트는 점수 순으로 정렬하며, 그 점수에 해당하는 위치를 찾을 때는 이분 탐색을 이용


### ** 핵심 부분 구현**
```java
	HashMap<String, ArrayList<Integer>> map = new HashMap();
	String language[] = { "cpp", "java", "python", "-" };
	String position[] = { "backend", "frontend", "-" };
	String career[] = { "junior", "senior", "-" };
	String soulfood[] = { "chicken", "pizza", "-" };        
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				for (int l = 0; l < 3; l++) {
					map.put(language[i] + position[j] + career[k] + soulfood[l], new ArrayList<Integer>());
				}
			}
		}
	}
```

### 정리
경우의 수를 만들 때 처음에 하드코딩으로 했더니 실수가 있었다.

빠르게 푸는 것도 중요하지만, 하드 코딩하지 않도록 하자.

