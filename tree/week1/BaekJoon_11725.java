import java.util.*;
import java.io.*;


public class BaekJoon_11725 {

	static int N;
	static List<Integer>[] nodes;
	static int[] parent;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		nodes = new ArrayList[N + 1];
		parent = new int[N + 1];
		// 트리의 루트는 무조건 1
		
		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[a].add(b);
			nodes[b].add(a);
			
		}
		
		bfs();
		
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i] + "\n");
		}
		
		System.out.println(sb.toString());
		
		
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int next : nodes[cur]) {
				if (parent[next] != 0) continue;
				parent[next] = cur;
				queue.add(next);
			}
			
		}
		
	}
	

}
