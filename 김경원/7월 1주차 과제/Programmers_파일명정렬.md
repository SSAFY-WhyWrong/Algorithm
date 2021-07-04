---
## Programmers 파일명정렬
### **Idea**
* 숫자가 나오기 직전까지를 head로 설정
* 숫자가 나오고 나서 숫자 이외의 것이 나올 때까지를 Number로 설정
* head는 대소문자를 구분하지 않으므로 소문자로 모두 변환하여 보관
* head가 일치하는 경우, number의 숫자 크기로 정렬(012 = 12 = 000012, 모두 같은 우선 순위)
* head와 number가 모두 일치하는 경우는 원래의 순서를 유지하여야 함
* tail은 정렬에서 아무런 영향을 끼치지 않으므로 신경 쓸 필요 없음


### ** 핵심 부분 구현**
```java        
	static class Node implements Comparable<Node> {
		String name; //원래 파일명
		String head; // 헤드
		int number; // 넘버

		Node(String name) {
			int idx = 0;
			this.name = name;
			idx = getHeadIdx(name);
			this.head = name.substring(0, idx).toLowerCase();
			this.number = getNumber(name,idx);
			
		}
		int getHeadIdx(String name) {
			for (int i = 0; i < name.length(); i++) {
				if (name.charAt(i) >= '0' && name.charAt(i) <= '9') {
					return i;
				}
			}
			return 0;
		}
		
		int getNumber(String name, int idx) {
			int num=0;
			for(int i=idx;i<name.length();i++) {
				if (name.charAt(i) >= '0' && name.charAt(i) <= '9') {
					num *= 10;
					num += name.charAt(i) -'0';
				}else
					break;
			}
			
			return num;
		}
		@Override
		public int compareTo(Node o) {
			
			if(this.head.equals(o.head)) {
				return this.number - o.number;
			}
			
			return this.head.compareTo(o.head);
		}

	}
```

### 정리
head와 number가 일치하는 경우, 본래의 순서를 유지한 채로 정렬 해야하는데 number를 기준으로 정렬하면 동일한 값의 경우 원래의 순서를 유지한다.
