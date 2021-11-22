import java.util.*;

class Solution {
    
    int[] dx = {1, -1, 0, 0, 2, -2, 0, 0, 1, 1, -1, -1};
    int[] dy = {0, 0, 1, -1, 0, 0, 2, -2, 1, -1, 1, -1};
    char[][] map;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0;i<places.length;i++) {
            // map 초기화
            map = new char[5][5];
            
            // map에 채워넣기
            insertMap(places[i]);
            
            // map 탐색하기 & answer 배열에 값 저장
            answer[i] = bruteForce();
        }
        
        return answer;
    }
    
    public void insertMap(String[] place) {
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                map[i][j] = place[i].charAt(j); 
            }
        }
    }
    
    public int bruteForce() {
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                if(map[i][j] == 'P' && isOk(i, j)) {
                    return 0;
                }
            }
        }
        
        return 1;
    }
    
    public boolean isOk(int x, int y) {
        // 거리 1
        for(int d=0;d<4;d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx<0 || nx>=5 || ny<0 || ny>=5) continue;
            if(map[nx][ny] == 'P') {
                System.out.println("1");
                return true;
        
            }
        }
        
        // 거리 2
        for(int d=4;d<8;d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx<0 || nx>=5 || ny<0 || ny>=5) continue;
            if(map[nx][ny] == 'P') {
                if(x+dx[d-4]>=0 && x+dx[d-4]<5 && y+dy[d-4]>=0 && y+dy[d-4]<5 && 
                   map[x+dx[d-4]][y+dy[d-4]] != 'X') {
                    System.out.println("2");
                    return true;
                }
            }
        }
        
        // 대각선
        for(int d=8;d<12;d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx<0 || nx>=5 || ny<0 || ny>=5) continue;
            if(map[nx][ny] == 'P') {
                if(!(map[x][ny]=='X' && map[nx][y]=='X')){
                    System.out.println("3");
                    return true;
                }
            }
        }
        
        return false;
    }
}