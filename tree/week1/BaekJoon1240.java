import java.util.*;
import java.io.*;

public class BaekJoon1240 {
	
	static List<Edge>[] nodeList;
	static int[][] distance;
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nodeList = new ArrayList[N + 1];
		distance = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			nodeList[a].add(new Edge(b, dist));
			nodeList[b].add(new Edge(a, dist));
		}
		
		for (int i = 1; i <= N; i++) {
			find(i);
		}
		
		// M은 1000번 이내
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(distance[a][b] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

		
	
	}
	
	static void find(int a) {
		Queue<Edge> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		for (Edge edge : nodeList[a]) {
			distance[a][edge.end] = edge.dist;
			queue.add(edge);
		}
		
		while (!queue.isEmpty()) {
			Edge cur = queue.poll();
			visited[cur.end] = true; // 방문처리
			// 다음 노드와 이어져있는 Edge
			for (Edge next : nodeList[cur.end]) {
				// 방문하지 않았다면...
				if (!visited[next.end]) {
					distance[a][next.end] = cur.dist + next.dist;
					distance[next.end][a] = cur.dist + next.dist;
					queue.add(new Edge(next.end, cur.dist + next.dist));
				}
			}
		}
		
	}
	
	
	
}

class Edge {
	int end;
	int dist;
	
	public Edge(int end, int dist) {
		this.end = end;
		this.dist = dist;
	}
	
}
