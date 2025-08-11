import java.util.*;
import java.io.*;

public class BaekJoon_2492 {
	
	static int width, height, total, len;
	static int[] xList;
	static int[] yList;
	static Set<Integer> xSet = new HashSet<>();
	static Set<Integer> ySet = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		total = Integer.parseInt(st.nextToken());
		len = Integer.parseInt(st.nextToken());
		
		xList = new int[total];
		yList = new int[total];
		xSet.add(0);
		ySet.add(0);
		
		for (int i = 0; i < total; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			xList[i] = x;
			yList[i] = y;
			xSet.add(x);
//			xSet.add(x - len);
			ySet.add(y);
//			ySet.add(y - len);
		}
		
		int answer = 0;
		int answerX = -1;
		int answerY = -1;
		
		for (int x : xSet) {
			for (int y : ySet) {
				int cnt = 0;
				if (x < 0) x = 0;
				if (y < 0) y = 0;
				
				if (x + len > width || y + len > height) continue;
				for (int k = 0; k < total; k++) {
					int checkX = xList[k];
					int checkY = yList[k];
					if (checkX <= x + len && checkX >= x && checkY <= y + len && checkY >= y) cnt++;
				}
				
				if (cnt > answer) {
					answer = cnt;
					answerX = x;
					answerY = y + len;
				}
			
			}
		}
		
		System.out.println(answerX + " " + answerY);
		System.out.println(answer);
		
	}
}
