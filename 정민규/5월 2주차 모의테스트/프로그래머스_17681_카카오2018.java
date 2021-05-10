import java.util.*;
class Solution {
    static char[][] map;
    static StringBuilder sb;
    static String[] memory;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer=new String[n];
        map=new char[n][n];
        memory=new String[n];
        change(arr1,n);
        change(arr2,n);
        for(int i=0;i<n;i++){
            sb=new StringBuilder();
            for(int j=n-1;j>=0;j--){
                sb.append(map[i][j]);
            }
            answer[i]=sb.toString();
        }
        return answer;
    }
    static void change(int[] arr,int n){
        for(int i=0;i<n;i++){
            sb=new StringBuilder();
            int tmp=arr[i];
            int rest;
            while(tmp>=2){
                rest=tmp%2;
                tmp=tmp/2;
                sb.append(rest); //거꾸로
            }
            sb.append(tmp);
            while(sb.length()<n){
                sb.append(0);
            }
            memory[i]=sb.toString();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(memory[i].charAt(j)=='1'||map[i][j]=='#'){
                    map[i][j]='#';
                }else{
                    map[i][j]=' ';
                }
            }
        }
    }
}