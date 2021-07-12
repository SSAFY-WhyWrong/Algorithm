---
## Backjoon_16118 원판 돌리기
### **Idea**
* 원판을 돌리기, 인근 숫자 확인, 인접한 숫자들 제거 혹은 숫자 평균과 다른 숫자들 변경, 총 합 계산 순으로 진행
* 제거되는 숫자를 확인 시, 제거되는 숫자를 temp 라는 배열에 복사해서 담고 모두 확인 한 후에 제거 해준다.

### ** 핵심 부분 구현**
```java
		for(int i=1;i<=N;i++) {
				for(int j=0;j<M;j++) {
					if(circle[i][j] ==0) continue;
					sum += circle[i][j];
					cnt++;
					
					int x,y;
					for(int dir=0;dir<4;dir++) {
						x = i + ni[dir];
						y = (M+j + nj[dir])%M;
						if(x < 1 || x>N ) continue;
						
						if(circle[i][j] == circle[x][y]) {
							temp[i][j] = circle[i][j];
							isChange = true;
							break;							
						}
						
					}
				}
			}	
```

### 정리

