---
## Programmers 후보키
### **Idea**
* 키의 조합을 만들어가면서 유일성 여부를 확인
* 유일성을 만족하는 키는 bit 형태로 선택된 키를 나타내어 list에 저장
* 모든 키는 유일성을 확인하기 전에 최소성을 만족하는지 & 연산을 통해 확인


### ** 핵심 부분 구현**
```java        
	static public int solution(String[][] relation) {
	        int answer = 0;
	        
	        int y = relation.length;
	        int x = relation[0].length;
	        
	        List<Integer> candidateKey = new ArrayList();	   
	        
	        for(int bit=1;bit < (1 << x);bit++) {
	        	if(!isMinimal(candidateKey,bit))
	        		continue;
	        	

	        	
	        	if(isUnique(relation,bit,x,y)) {
	        		candidateKey.add(bit);
	        		answer++;
	        	}
	        	
	        }
	        
	        System.out.println("정답 : " + answer);
	        
	        return answer;
	    }
	
	//최소성 확인
	static public boolean isMinimal(List<Integer> candidateKey , int bit) {
		for(int key : candidateKey ) {
			if((key & bit) == key)
				return false;
		}
				
		return true;
	}
	
	//유일성 확인
	static public boolean isUnique(String[][] relation, int bit, int x, int y) {
    	HashSet<String> set = new HashSet();
  
    	for(int i=0;i<y;i++) {
    		StringBuilder sb = new StringBuilder();
    		for(int j=0;j<x;j++) {
    			if((1<<j & bit)!=0) sb.append(relation[i][j]);
    		}
    		
    		if(set.contains(sb.toString()))
    			return false;
    		
    		set.add(sb.toString());
    		
    		
    	}
    	
		return true;
	}
```

### 정리

