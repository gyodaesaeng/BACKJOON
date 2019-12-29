import java.io.*;
import java.util.StringTokenizer;

public class N15552 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int sum[] = new int[t];
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sum[i] = Integer.parseInt(st.nextToken());
			sum[i] += Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < t; i++) {
			bw.write(sum[i] + "\n");
		}
		bw.flush();
	}
}
