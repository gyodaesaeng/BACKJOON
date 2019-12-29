import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class N1717 {
	static int n, m;
	static ArrayList<Integer>[] co;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		co = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			co[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 0) {
				co[b].add(c);
				co[c].add(b);
			} else {
				if (bfs(b, c)) {
					bw.write("YES");
				} else {
					bw.write("NO");
				}
				bw.newLine();
			}
		}
		bw.flush();
	}

	static boolean bfs(int s, int e) {
		boolean[] check = new boolean[n + 1];
		Deque<Integer> queue = new ArrayDeque<Integer>();
		check[s] = true;
		queue.push(s);
		if (s == e) {
			return true;
		}
		while (!queue.isEmpty()) {
			for (int i : co[queue.peek()]) {
				if (!check[i]) {
					if (s == e) {
						return true;
					}
					check[i] = true;
					queue.push(i);
				}
			}
			queue.poll();
		}
		return false;
	}

	static void output(ArrayList<Boolean> array) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (boolean i : array) {
			if (i) {
				bw.write("YES");
			} else {
				bw.write("NO");
			}
			bw.newLine();
		}
		bw.flush();
	}
}
