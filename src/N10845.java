import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		N10845.ListQueue listQueue = new N10845().new ListQueue();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				listQueue.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (listQueue.empty()) {
					bw.write("-1");
					bw.newLine();
				} else {
					bw.write(Integer.toString((int) listQueue.pop()));
					bw.newLine();
				}
				break;
			case "size":
				bw.write(Integer.toString(listQueue.size()));
				bw.newLine();
				break;
			case "empty":
				if (listQueue.empty()) {
					bw.write('1');
				} else {
					bw.write('0');
				}
				bw.newLine();
				break;
			case "front":
				if (listQueue.empty()) {
					bw.write("-1");
				} else {
					bw.write(Integer.toString((int) listQueue.front()));
				}
				bw.newLine();
				break;
			case "back":
				if (listQueue.empty()) {
					bw.write("-1");
				} else {
					bw.write(Integer.toString((int) listQueue.back()));
				}
				bw.newLine();
				break;
			}
		}
		bw.flush();
	}

	class ListQueue {

		private class Node {
			private Object data;
			private Node nextNode;

			Node(Object data) {
				this.data = data;
				this.nextNode = null;
			}
		}

		private Node front;
		private Node back;

		public ListQueue() {
			this.front = null;
			this.back = null;
		}

		public boolean empty() {
			return (front == null);
		}

		public void push(Object item) {

			Node node = new Node(item);
			node.nextNode = null;

			if (empty()) {

				back = node;
				front = node;

			} else {

				back.nextNode = node;
				back = node;

			}
		}

		public Object peek() {
			if (empty())
				throw new ArrayIndexOutOfBoundsException();
			return front.data;
		}

		public Object pop() {

			Object item = peek();
			front = front.nextNode;

			if (front == null) {
				back = null;
			}

			return item;
		}

		public int size() {
			int n = 0;
			if (!empty()) {
				n++;
				Node nowNode = front;
				while (nowNode != back) {
					nowNode = nowNode.nextNode;
					n++;
				}
			}
			return n;
		}

		public Object front() {
			return front.data;
		}

		public Object back() {
			return back.data;
		}
	}

}
