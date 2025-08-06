import java.util.*;
import java.io.*;

public class BaekJoon_4803 {

	static int N, M;
	static List<Integer>[] tree;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = 1;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			tree = new ArrayList[N + 1];
			
			if (N == 0) break;
			
			sb.append("Case ").append(test++).append(": ");
			for (int i = 1; i <= N; i++) {
				tree[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				tree[a].add(b);
				tree[b].add(a);	
			}
			
			visited = new boolean[N + 1];
			int cnt = 0;
			
			for (int i = 1; i <= N; i++) {
				if (visited[i]) continue;
				cnt += bfs(i);
			}
			
			if (cnt == 0) {
				sb.append("No trees.\n");
			} else if (cnt == 1) {
				sb.append("There is one tree.\n");
			} else {
				sb.append("A forest of ").append(cnt).append(" trees.\n");
			}
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	static int bfs(int start) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {start, 0});
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int cur = info[0];
			int parent = info[1];
			for (Integer next : tree[cur]) {
				// 양방향 간선이기 때문에 부모로 들어가는건 사이클이 아님
				if (next == parent) continue;
				if (visited[next]) return 0;
				visited[next] = true;
				queue.add(new int[] {next, cur});
			}
		}
		
		return 1;
		
	}
	

}
