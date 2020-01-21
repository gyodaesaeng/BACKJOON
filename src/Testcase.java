import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Testcase {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Test.in"));
		bw.write("1000000\n");
		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j <= 1000; j++) {
				bw.write(i + " " + j + "\n");
			}
		}
		bw.flush();
	}
}
