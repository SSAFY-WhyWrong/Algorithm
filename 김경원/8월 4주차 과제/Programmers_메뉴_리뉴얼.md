---
## Programmers 메뉴 리뉴얼
### **Idea**
* 사람들이 주문한 주문 내용을 문자열로 바꾼 뒤 사전 순서대로 정렬
* 새로 만들어진 주문 내용을 순서대로 읽어가며 Course 값과 같은 길이의 조합을 만든다.
* HashMap으로 만들어진 조합과 반복된 수를 기록
* Java는 C++과 다르게 포인터 개념이 없어 주소 자체를 넘길 수 없으므로 max값을 일부러 배열 형태로 만들어서 관리했음 -> 딱히 좋아보이진 않음 
* course 값과 같은 길이를 가지는 조합을 만들어서 가장 많이 중복되는 경우를 찾는다.


### ** 핵심 부분 구현**
```java        
	static void DFS(String now, int cnt, int len, int idx, String order, HashMap<String, Integer> map, int[] max) {
		if (cnt == len) {
			char[] arr = now.toCharArray();
			String s = String.copyValueOf(arr);
			Arrays.sort(arr);
			map.put(s, map.getOrDefault(s, 0) + 1);
			max[0] = Math.max(max[0], map.get(s));
			
			
			return;
		}

		if (idx >= order.length())
			return;

		DFS(now + order.charAt(idx), cnt + 1, len, idx + 1, order, map, max);
		DFS(now, cnt, len, idx + 1, order, map, max);
	}        
```

### 정리
최적의 방법이라곤 생각 안 한다.

빠르게 푸는데 집중했더니 낭비되는 곳이 있다. (길이 2,3이 있을 때 2의 길이의 조합을 만들고 그 다음에 또 3의 길이를 만들면서 이전에 한 행위를 반복함)

JAVA에서 static을 사용하지 않고 기본형 타입의 변수들을 넘기는 다른 방법을 생각해봐야 할 것 같음
