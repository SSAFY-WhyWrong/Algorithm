* PriorityQueue를 사용해서 스코빌이 제일 낮은 음식을 먼저 오게 한다.
* 차례대로 poll하면서 계산식 ``` 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)``` 을 구하고 다시 우선순위 큐에 넣는다.
* 모든 스코빌 지수가 K 보다 커질 때까지 반복한다.
* 만들 수 없는 경우라면 -1을 리턴한다.
