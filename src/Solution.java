import java.io.IOException;

class Solution {
	private static final String EVEN = "EVEN";
	private static final String ODD = "ODD";
	private static final String COMPOSITE = "COMPOSITE";
	private static final String PRIME = "PRIME";
	private static final String NOT_PALINDROME = "NOT PALINDROME";
	private static final String PALINDROME = "PALINDROME";

	public static boolean checker(PerformOperation p, int num) {
		return p.operation(num);
	}

	PerformOperation isOdd() {
		return num -> (num % 2 != 0);
	}

	PerformOperation isPrime() {
		return num -> {
			if (num == 0 || num == 1) {
				return false;
			} else {
				for (int i = 2; i < num; i++) {
					if (num % i == 0) {
						return false;
					}
				}
			}
			return true;
		};
	}

	PerformOperation isPalindrome() {
		return num -> {
			StringBuilder sb = new StringBuilder(num + "");
			String normal = sb.toString();
			String reversed = sb.reverse().toString();

			return (reversed.equals(normal)) ? true : false;
		};
	}

	public static void main(String[] args) throws IOException {

		int num = new Integer(97);

		Solution solution = new Solution();
		System.out.println(num + " is " + solution.checkNumber(num, Operations.PALINDROME_CHECK));
		System.out.println(num + " is " + solution.checkNumber(num, Operations.EVEN_ODD_CHECK));
		System.out.println(num + " is " + solution.checkNumber(num, Operations.PRIME_CHECK));
		System.out.println("----------------------------");
		num = 11;
		System.out.println(num + " is " + solution.checkNumber(num, Operations.PALINDROME_CHECK));
		System.out.println(num + " is " + solution.checkNumber(num, Operations.EVEN_ODD_CHECK));
		System.out.println(num + " is " + solution.checkNumber(num, Operations.PRIME_CHECK));
		System.out.println("----------------------------");
		num = 2002;
		System.out.println(num + " is " + solution.checkNumber(num, Operations.PALINDROME_CHECK));
		System.out.println(num + " is " + solution.checkNumber(num, Operations.EVEN_ODD_CHECK));
		System.out.println(num + " is " + solution.checkNumber(num, Operations.PRIME_CHECK));
	}

	public String checkNumber(int num, Operations op) {
		PerformOperation operation;
		Solution solution = new Solution();
		boolean ret;
		String ans = "";
		if (op == Operations.EVEN_ODD_CHECK) {
			operation = solution.isOdd();
			ret = checker(operation, num);
			ans = (ret) ? ODD : EVEN;
		} else if (op == Operations.PRIME_CHECK) {
			operation = solution.isPrime();
			ret = checker(operation, num);
			ans = (ret) ? PRIME : COMPOSITE;
		} else if (op == Operations.PALINDROME_CHECK) {
			operation = solution.isPalindrome();
			ret = checker(operation, num);
			ans = (ret) ? PALINDROME : NOT_PALINDROME;
		}
		return ans;
	}

	interface PerformOperation {
		boolean operation(int a);
	}
}
