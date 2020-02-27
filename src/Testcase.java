import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Testcase {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Test.in"));
		bw.write("20000 300000\n1\n");
		Random random = new Random();
		for (int i = 0; i < 300000; i++) {
			int u = Math.abs(random.nextInt()) % 20000+1;
			int v = Math.abs(random.nextInt()) % 20000+1;
			while (u == v) {
				v = Math.abs(random.nextInt()) % 20000+1;
			}
			int w = Math.abs(random.nextInt()) % 10+1;
			bw.write(u + " " + v + " " + w + "\n");
		}
		bw.flush();
	}
}
