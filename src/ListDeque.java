
public class ListDeque {
	private class Node {
		private Object data;
		private Node prevNode;
		private Node nextNode;

		Node(Object data) {
			this.data = data;
			this.prevNode = null;
			this.nextNode = null;
		}
	}

	private Node front;
	private Node back;
	private int size;

	public ListDeque() {
		front = null;
		back = null;
		size = 0;
	}

	public boolean empty() {
		return (front == null);
	}

	public void pushFront(Object data) {
		Node node = new Node(data);
		if (empty()) {
			front = node;
			back = node;
		} else {
			front.prevNode = node;
			node.nextNode = front;
			front = node;
		}
		size++;
	}

	public void pushBack(Object data) {
		Node node = new Node(data);
		if (empty()) {
			front = node;
			back = node;
		} else {
			back.nextNode = node;
			node.prevNode = back;
			back = node;
		}
		size++;
	}

	public Object popFront() {
		Object data = front.data;
		front = front.nextNode;
		if (front == null) {
			back = null;
		} else {
			front.prevNode = null;
		}
		size--;
		return data;
	}

	public Object popBack() {
		Object data = back.data;
		back = back.prevNode;
		if (back == null) {
			front = null;
		} else {
			back.nextNode = null;
		}
		size--;
		return data;
	}

	public Object peekFront() {
		return front.data;
	}

	public Object peekBack() {
		return back.data;
	}

	public int size() {
		return size;
	}
}
