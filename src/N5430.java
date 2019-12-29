import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N5430 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			ListDeque listDeque = new ListDeque();
			for (int j = 0; j < n; j++) {
				listDeque.pushBack(Integer.parseInt(st.nextToken()));
			}
			boolean forward = true;
			boolean error = false;
			int k = p.length();
			for (int j = 0; j < k; j++) {
				if (p.charAt(j) == 'R') {
					forward = !forward;
				} else {
					if (listDeque.empty()) {
						error = true;
						break;
					} else {
						if (forward) {
							listDeque.popFront();
						} else {
							listDeque.popBack();
						}
					}
				}
			}
			if (error) {
				bw.write("error");
			} else {
				bw.write('[');
				k = listDeque.size();
				if (forward) {
					for (int j = 0; j < k; j++) {
						bw.write(Integer.toString((int) listDeque.popFront()));
						if (j < k - 1) {
							bw.write(',');
						}
					}
				} else {
					for (int j = 0; j < k; j++) {
						bw.write(Integer.toString((int) listDeque.popBack()));
						if (j < k - 1) {
							bw.write(',');
						}
					}
				}
				bw.write(']');
			}
			bw.newLine();
		}
		bw.flush();
	}
}
