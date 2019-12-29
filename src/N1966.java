import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> importance = new ArrayList<Integer>();
			ListQueue listQueue = new ListQueue();
			ListStack sortedListStack = new ListStack();
			for (int j = 0; j < n; j++) {
				importance.add(Integer.parseInt(st.nextToken()));
				listQueue.push(importance.get(j));
			}
			Collections.sort(importance);
			for (int j = 0; j < n; j++) {
				sortedListStack.push(importance.get(j));
			}
			bw.write(Integer.toString(solve(n, m, listQueue, sortedListStack)));
			bw.newLine();
		}
		bw.flush();
	}

	static int solve(int n, int m, ListQueue listQueue, ListStack sortedListStack) {
		int answer = 1;
		while (!listQueue.empty()) {
			if (sortedListStack.peek() == listQueue.peek()) {
				if (m == 0) {
					return answer;
				} else {
					sortedListStack.pop();
					listQueue.pop();
					m--;
					answer++;
				}
			} else {

				listQueue.push(listQueue.pop());
				sortedListStack.push(sortedListStack.pop());
				if (m == 0) {
					m = listQueue.size() - 1;
				} else {
					m--;
				}
			}
		}
		return -1;
	}
}
