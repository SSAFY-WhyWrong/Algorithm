import java.util.*;
import java.io.*;

public class 백준_14725_개미굴 {

	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		TreeMap<String, TreeMap> map = new TreeMap<>();
		int N = Integer.parseInt(st.nextToken());

		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			TreeMap target = map;
			for (int j=0;j<n;j++) {
				String name = st.nextToken();
				if (target.get(name) == null)
					target.put(name, new TreeMap<>());
				target = (TreeMap) target.get(name);
			}
		}
		
		print(map, 0);
		System.out.println(result);
	}

	static void print(TreeMap map, int depth) {

		for (Object s : map.keySet()) {
			for (int i=0;i<depth;i++)
				result.append("--");
			
			result.append(s + "\n");
			print((TreeMap) map.get(s), depth+1);
		}
	}
}
