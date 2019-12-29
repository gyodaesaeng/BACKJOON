import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class N1260 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int startVertex = Integer.parseInt(st.nextToken());
		N1260.Graph graph = new N1260().new Graph(n);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.addNode(a, b);
			graph.addNode(b, a);
		}
		graph.endAddNode();
		ArrayList<Integer> dfsRoute = dfs(graph, n, startVertex);
		for (int i = 0; i < dfsRoute.size(); i++) {
			bw.write(Integer.toString(dfsRoute.get(i)) + " ");
		}
		bw.newLine();
		ArrayList<Integer> bfsRoute = bfs(graph, n, startVertex);
		for (int i = 0; i < dfsRoute.size(); i++) {
			bw.write(Integer.toString(bfsRoute.get(i)) + " ");
		}
		bw.newLine();
		bw.flush();
	}

	static ArrayList<Integer> dfs(Graph graph, int n, int startVertex) {
		ListStack listStack = new ListStack();
		boolean[] passedVertex = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			passedVertex[i] = false;
		}
		ArrayList<Integer> route = new ArrayList<Integer>();
		listStack.push(startVertex);
		route.add(startVertex);
		passedVertex[startVertex] = true;
		ArrayList<Integer> node;
		while (!listStack.empty()) {
			node = graph.getNode((int) listStack.peek());
			int index = 0;
			boolean hasNextRoute = true;
			if (node.size() > 0) {
				while (passedVertex[node.get(index++)]) {
					if (index == node.size()) {
						listStack.pop();
						hasNextRoute = false;
						break;
					}
				}
			} else {
				listStack.pop();
				hasNextRoute = false;
			}
			if (hasNextRoute) {
				int nextVertex = node.get(index - 1);
				listStack.push(nextVertex);
				route.add(nextVertex);
				passedVertex[nextVertex] = true;
			}
		}
		return route;
	}

	static ArrayList<Integer> bfs(Graph graph, int n, int startVertex) {
		ListQueue listQueue = new ListQueue();
		boolean[] passedVertex = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			passedVertex[i] = false;
		}
		ArrayList<Integer> route = new ArrayList<Integer>();
		listQueue.push(startVertex);
		route.add(startVertex);
		passedVertex[startVertex] = true;
		ArrayList<Integer> node;
		while (!listQueue.empty()) {
			node = graph.getNode((int) listQueue.peek());
			int index = 0;
			boolean hasNextRoute = true;
			if (node.size() > 0) {
				while (passedVertex[node.get(index++)]) {
					if (index == node.size()) {
						listQueue.pop();
						hasNextRoute = false;
						break;
					}
				}
			} else {
				listQueue.pop();
				hasNextRoute = false;
			}
			if (hasNextRoute) {
				int nextVertex = node.get(index - 1);
				listQueue.push(nextVertex);
				route.add(nextVertex);
				passedVertex[nextVertex] = true;
			}
		}
		return route;
	}

	class Graph {
		int nVertex;
		ArrayList<ArrayList<Integer>> nodeList = new ArrayList<ArrayList<Integer>>();

		public Graph(int n) {
			this.nVertex = n;
			for (int i = 0; i <= n; i++) {
				nodeList.add(new ArrayList<Integer>());
			}
		}

		public void addNode(int start, int to) {
			nodeList.get(start).add(to);
		}

		public ArrayList<Integer> getNode(int a) {
			return nodeList.get(a);
		}

		public void endAddNode() {
			for (int i = 0; i <= nVertex; i++) {
				Collections.sort(nodeList.get(i));
			}
		}
	}

}
