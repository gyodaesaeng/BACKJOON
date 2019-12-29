import java.util.Scanner;

public class N2753 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.println(solve(n));
	}

	static int solve(int n) {
		if (n % 4 == 0) {
			if (n % 100 == 0) {
				if (n % 400 == 0) {
					return 1;
				}
			} else {
				return 1;
			}
		}
		return 0;
	}

}
