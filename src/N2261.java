import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2261 {
	public static void main(String[] args) throws IOException {
		input();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Dot[] dots = new Dot[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			dots[i] = new Dot(x, y);
		}
	}
}

class Dot {
	int x, y;

	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getLength(Dot dot) {
		return (x - dot.x) * (x - dot.x) + (y - dot.y) * (y - dot.y);
	}
}