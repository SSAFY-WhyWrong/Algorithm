## 5월 3주차 과제 풀이
---
## Programmers 단체사진 찍기
### **Idea**
* 8명의 프렌즈가 서는 경우의 수에서 조건을 만족하는 경우만 센다.
* ACFJMNRT를 0~7의 값으로 매핑하여 관리
* 각각의 프렌즈가 어느 위치에 있는지 배열에 저장 (인덱스는 위의 매핑값을 이용)
* 순서 순열을 만든 뒤, 조건에 어긋나지 않는지 확인
* 조건의 첫 번째 프렌즈와 두 번째 프렌즈의 위치의 간격을 구해준 뒤, 조건에 어긋나는지 확인 


### ** 핵심 부분 구현**
```java
	private static boolean pos_check(int n, String[] data) {
		int a,b;
		char token;
		int value;
		
		for(int i=0;i<n;i++) {
			a = map.get(data[i].charAt(0)); //매핑된 정보로 a의 위치가 있는 index 확인
			b = map.get(data[i].charAt(2)); //매핑된 정보로 b의 위치가 있는 index 확인
			token = data[i].charAt(3);
			value = data[i].charAt(4) - '0' +1 ; //둘 사이의 간격을 구해주는 것이므로 +1
					
			if(pos[a] == 0 || pos[b] ==0 ) continue;
            
			if(token == '=') {
				if(Math.abs(pos[a] - pos[b]) != value) //a와 b의 간격의 절대값으로 계산
					return false;
				
			}else if(token == '<') {
				if(Math.abs(pos[a] - pos[b]) >= value)
					return false;
					
			}else if(token =='>'){
				if(Math.abs(pos[a] - pos[b]) <= value)
					return false;
			}
			
		}
		
		
		return true;
	}

```

### 정리
처음에는 순열을 만든 다음에 조건에 부합하는지 확인 하였었는데

순열을 만드는 과정에서 지금의 선택이 조건에 부합하는지를 확인하는 것이 좀 더 시간이 빠르게 나옴

