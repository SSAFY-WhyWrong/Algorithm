---
## Programmers N으로 표현
### **Idea**
* dp 배열을 2종류 만들어서 관리
* 하나는 왼쪽에서 오는 것만 저장하고, 하나는 위에서 오는 경우만 저장해준다. (left[i][j] = left[i][j-1]+up[i][j-1])
* 왼쪽 표지판이 회전 금지인 경우 같은 방향만 더 해준다 (left[i][j] = left[i][j-1])
* 연산을 해줄 때마다 결과에 mod를 해준다. 
* 최종 도착지는 left와 up의 합을 출력해준다


### ** 핵심 부분 구현**
```java        
 		left[0][0] = 1;
        up[0][0] = 1;
        //0 : 자유통행 , 1 : 차량 진입 금지 , 2 : 회전 금지
        for(int i=0;i<m-1;i++) {
        	if(cityMap[i][0] != 1) {
        		up[i+1][0] += up[i][0];        		
        	}
        }
        
        for(int j=0;j<n-1;j++) {
        	if(cityMap[0][j] != 1) {
        		left[0][j+1] += left[0][j];        		
        	}
        }
        
        for(int i=1;i<m;i++) {
        	for(int j=1;j<n;j++) {
        		if(cityMap[i-1][j]!=1) { //위에서 오는 경우
        			up[i][j] += up[i-1][j];
                    up[i][j] %= MOD;
        			if(cityMap[i-1][j]!=2){
        				up[i][j] += left[i-1][j];
                        up[i][j]%=MOD;
                    }
        		}
        		
        		if(cityMap[i][j-1]!=1) {
        			left[i][j] += left[i][j-1];
                    left[i][j] %= MOD;
        			if(cityMap[i][j-1]!=2) {
        				left[i][j] += up[i][j-1];
                        left[i][j]%=MOD;
        			}
        		}
        	}
        }
   
        answer = up[m-1][n-1] + left[m-1][n-1];
        answer %= MOD;  
```

### 정리
dp 배열을 행열을 하나씩 더해줘서 현재 dp값으로 다음 dp 값에 더하는 방식으로 해줘도 되지만

늘리기 싫어서 현재 dp 값을 구하기 위해 이전 dp값에서 더하는 방식으로 했다.
