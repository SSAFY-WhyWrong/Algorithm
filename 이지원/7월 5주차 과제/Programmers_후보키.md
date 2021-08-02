# 7월 5주차 과제 풀이

## Programmers_후보키

### Idea
#### 조합으로 가능한 후보키 목록을 모두 받아옴
#### HashMap을 통해 후보키가 가능한지 여부를 판단(모든 데이터가 1이면 가능 하나라도 2 이상이면 불가능)
#### containsAll이라는 함수를 통해 이미 후보키로 판단된 컬럼이 포함되어 있는지를 판단

### 핵심 부분 구현
![image](https://user-images.githubusercontent.com/48550373/127804706-8d6204d9-e877-47e2-83f4-67952947d3ca.png)

![image](https://user-images.githubusercontent.com/48550373/127804690-6e924d05-b1e8-4da6-91e5-d509f573eb66.png)
