public class ListQueue {

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
