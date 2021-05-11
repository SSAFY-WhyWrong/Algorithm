1. 프로그래머스 네트워크

Idea
- 각각의 네트워크를 대상으로 BFS 탐색
- 방문한 적이 있다면 BFS 하지 않고 방문하지 않았으면 BFS 탐색
- 연결되어 있는 네트워크를 모두 탐색한 뒤에 answer를 증가해서 네트워크 개수 카운트


모든 네트워크를 탐색하기 위한 main<br>
![image](https://user-images.githubusercontent.com/48550373/117811605-b74ec580-b29b-11eb-8ebb-4f7462a4088e.png)

BFS 탐색을 위한 메소드<br>
![image](https://user-images.githubusercontent.com/48550373/117811639-c0d82d80-b29b-11eb-8445-92065f8a5c6f.png)
