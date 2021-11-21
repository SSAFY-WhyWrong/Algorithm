
### 카카오프렌즈 컬러링북
##### bfs를 이용한 탐색
```java
    public static int bfs(int i, int j, int start){
        
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(i, j));
        pic[i][j] = 0;
        
        int cnt = 1;
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            
            for(int d=0; d<4; d++){
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];
                if(ni>=0 && ni<M && nj>=0 && nj<N && pic[ni][nj]==start){
                    cnt++;
                    q.offer(new Point(ni, nj));
                    pic[ni][nj] = 0;
                }
            }
        }
        return cnt;
    }
```
##### 주의할 점
- 0인 경우는 색칠하지 않는 영역을 뜻한다.


### 중국 신분증 번호
##### 구현
##### 주의할 점
- 조건을 하나씩 잘 따져가며 코드 짜기
  - [x] 올바른 지역 코드 포함 여부
  - [x] 생일코드 범위 (1990/01/01 - 2011/12/31)
  - [x] 윤년, 각 달의 일 수 고려하기
  - [x] 순서 코드 "000" 제외
  - [x] 체크섬 코드 -> 체크섬 코드 수식의 합 mod 11 = 1
- 윤년 부분 코드
```java
int year = Integer.parseInt(all.substring(6,10));
		int month = Integer.parseInt(all.substring(10,12));
		int day = Integer.parseInt(all.substring(12,14));
		
		if(valid && year>=1900 && year<=2011) {
			if((year%4==0 && year%100!=0) || year%400==0) {
				if(month==2 && day>=1 && day<=29) {
					valid = true;
				}else if(month>=1 && month<=12) {
					if(day>=1 && day<=limit[month]) valid = true;
					else valid = false;
				}else valid = false;
			}else {
				if(month>=1 && month<=12) {
					if(day>=1 && day<=limit[month]) valid = true;
					else valid = false;
				}else valid = false;
			}
		}else valid = false;
```

### 두 동전
- 아직 미해결 문제! --진행중--
