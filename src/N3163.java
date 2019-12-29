import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3163 {
	static BufferedReader br;
	static int n, l, k;
	static int[] a, p;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			input();
			System.out.println(solve());
		}
	}

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[n];
		p = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			a[i] = Integer.parseInt(st.nextToken());
		}
	}

	static int solve() {
		int answer = 0;
		ListStack right = new ListStack();
		ListQueue left = new ListQueue();
		ListDeque listDeque = new ListDeque();
		for (int i = 0; i < n; i++) {
			listDeque.pushBack(a[i]);
			if (a[i] > 0) {
				right.push(l - p[i]);
			} else {
				left.push(p[i]);
			}
		}
		for (int i = 1; i < k; i++) {
			if (right.empty()) {
				left.pop();
				listDeque.popFront();
				continue;
			}
			if (left.empty()) {
				right.pop();
				listDeque.popBack();
				continue;
			}
			if ((int) right.peek() == (int) left.peek()) {
				if ((int) listDeque.peekFront() < (int) listDeque.peekBack()) {
					left.pop();
					listDeque.popFront();
				} else {
					right.pop();
					listDeque.popBack();
				}
			} else {
				if ((int) right.peek() > (int) left.peek()) {
					left.pop();
					listDeque.popFront();
				} else {
					right.pop();
					listDeque.popBack();
				}
			}
		}
		if (right.empty()) {
			left.pop();
			return (int) listDeque.popFront();
		}
		if (left.empty()) {
			right.pop();
			return (int) listDeque.popBack();
		}
		if ((int) right.peek() == (int) left.peek()) {
			if ((int) listDeque.peekFront() < (int) listDeque.peekBack()) {
				left.pop();
				answer = (int) listDeque.popFront();
			} else {
				right.pop();
				answer = (int) listDeque.popBack();
			}
		} else {
			if ((int) right.peek() > (int) left.peek()) {
				left.pop();
				answer = (int) listDeque.popFront();
			} else {
				right.pop();
				answer = (int) listDeque.popBack();
			}
		}
		return answer;
	}
}
