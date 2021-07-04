---
## Baekjoon 14499 주사위 굴리기
### **Idea**
* 주사위를 동서로 굴릴 떄와 남북으로 굴릴 때 사용하는 면이 다르다.
* 주사위를 굴릴 때마다 값을 하나씩 미뤄줌
* 시뮬레이션 구현이 정확하게 될 수 있도록 신경 써주는 것이 중요


### ** 핵심 부분 구현**
```java
	if(order[i]==0) {
				int temp = dice_left;
				dice_left = dice[2];
				dice[2] = dice_right;
				dice_right = dice[0];
				dice[0] = temp;
			}else if(order[i]==1) {
				int temp = dice_right;
				dice_right = dice[2];
				dice[2] = dice_left;
				dice_left = dice[0];
				dice[0] = temp;
			}else if(order[i]==2) {
				int temp = dice[0];
				dice[0] = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[3];
				dice[3] = temp;
			}else if(order[i]==3) {
				int temp = dice[0];
				dice[0] = dice[3];
				dice[3] = dice[2];
				dice[2] = dice[1];
				dice[1] = temp;
			}
						
			if(arr[x][y] == 0) {
				arr[x][y] = dice[2];
			}else {
				dice[2] = arr[x][y];
				arr[x][y] = 0;
			}
```

### 정리
단순 시뮬레이션 문제

주사위 굴리는 것을 좀 더 깔끔하게 표현할 수 있는 방법을 생각 해봐야 할 거같다.
