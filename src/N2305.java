import java.util.Scanner;

public class N2305 {
	static long[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		memo = new long[41];
		memo[0] = 1;
		memo[1] = 1;
		long sum = dp(k - 1) * dp(n - k);
		for (int i = 1; i < k; i++) {
			sum += dp(i - 1) * dp(k - i - 1) * dp(n - k);
			for (int j = 1; j < i; j++) {
				sum += dp(i - j - 1) * dp(k - i - 1) * dp(n - k);
			}
			for (int j = i + 1; j < k; j++) {
				sum += dp(i - 1) * dp(k - j - 1) * dp(n - k);
			}
		}
		for (int i = k + 1; i <= n; i++) {
			sum += dp(k - 1) * dp(i - k - 1) * dp(n - i);
			for (int j = k + 1; j < i; j++) {
				sum += dp(k - 1) * dp(j - k - 1) * dp(n - i);
			}
			for (int j = i + 1; j <= n; j++) {
				sum += dp(i - 1) * dp(i - k - 1) * dp(n - j);
			}
		}
		System.out.print(sum);
	}

	static long dp(int n) {
		if (memo[n] > 0) {
			return memo[n];
		}
		return memo[n] = dp(n - 1) + dp(n - 2);
	}
}
