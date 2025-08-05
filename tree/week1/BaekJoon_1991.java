import java.util.*;
import java.io.*;

public class BaekJoon_1991 {
	
	static int N;
	static Node[] tree;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		tree = new Node[N];
		
		for (int i = 0; i < N; i++) {
			tree[i] = new Node((char) ('A' + i)); // A부터 시작하는 노드 생성
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char cur = st.nextToken().charAt(0);
			
			char left = st.nextToken().charAt(0);
			if (left != '.') { // 왼쪽이 있다면
				tree[cur - 'A'].left = tree[left - 'A'];
			}
			
			char right = st.nextToken().charAt(0);
			if (right != '.') { // 오른쪽이 있다면
				tree[cur - 'A'].right = tree[right - 'A'];
			}
		}
		
		sb = new StringBuilder();
		pre(tree[0]);
		sb.append("\n");
		
		inorder(tree[0]);
		sb.append("\n");
		
		post(tree[0]);
		sb.append("\n");
		
		System.out.println(sb.toString());
		
	}
	
	static void pre(Node cur) {
		sb.append(cur.val);
		if (cur.left != null) pre(cur.left);
		if (cur.right != null) pre(cur.right);
	}
	
	static void inorder(Node cur) {
		if (cur.left != null) inorder(cur.left);
		sb.append(cur.val);
		if (cur.right != null) inorder(cur.right);
	}
	
	static void post(Node cur) {
		if (cur.left != null) post(cur.left);
		if (cur.right != null) post(cur.right);
		sb.append(cur.val);
	}
	
	
	
}

class Node {
	Node left;
	Node right;
	char val;
	
	Node (char val) {
		this.val = val;
	}
	
}