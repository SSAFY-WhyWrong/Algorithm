### 11003 최솟값 찾기

- PQ를 사용하여 offer와 remove반복으로 풀었을 때 시간 초과
  - pq.remove(Object O) 가 오래 걸리거나, PriorityQueue자체가 시간이 오래 걸리는 듯
- Deque을 이용하여 앞에 작은 값을 두고, 뒤에 큰 값을 둬서 판단
  - 제일 큰 값은 필요 없음 -> 값이 들어올 때 마다 갱신
  - 제일 앞에 값의 index를 검사하여 빼야할 때 빼주기





### 1756 피자굽기

- 깊이가 깊은 오븐은 넓더라도 앞쪽의 오븐이 좁으면 좁은 입구 크기의 피자만 들어올 수 있음
- 들어올 수 있는 피자 크기를 정리하면 정렬된 배열이 만들어짐
- 정렬된 배열에서 해당하는 값 찾기 => 이분 탐색
- 인덱스 관리 잘하기