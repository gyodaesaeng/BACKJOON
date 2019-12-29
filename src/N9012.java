import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			boolean vps = true;
			ListStack listStack = new ListStack();
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == '(') {
					listStack.push(true);
				} else {
					if (listStack.empty()) {

						vps = false;
						break;
					} else {
						listStack.pop();
					}
				}
			}
			if (vps && (listStack.empty())) {
				bw.write("YES");
			} else {
				bw.write("NO");
			}
			bw.newLine();
		}
		bw.flush();
	}
}
