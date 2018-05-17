/**
 * Just a quick exercise about how to create 
 * a simple post suffix evaluator in Java.
 * 
 * @author Hussama Ismail
 */
import java.util.Stack;

public class MySimplePostSuffixEvaluator {

	static Stack<String> opStack = new Stack<String>();
	final static String OPERATORS_REGXP = "\\*|\\+|-|/";

	public static void main(final String[] args) {
		String expression = "2 3 1 * + 9 -";
		String[] tokens = expression.split(" ");
		int numberOfTokens = tokens.length;

		for (int i = 0; i < numberOfTokens; i++) {
			String token = tokens[i];
			if (token.matches(OPERATORS_REGXP)) {
				double operand2 = Double.valueOf(opStack.pop());
				double operand1 = Double.valueOf(opStack.pop());
				if (token.equals("+")) {
					opStack.push(String.valueOf(operand1 + operand2));
				} else if (token.equals("-")) {
					opStack.push(String.valueOf(operand1 - operand2));
				} else if (token.equals("*")) {
					opStack.push(String.valueOf(operand1 * operand2));
				} else {
					opStack.push(String.valueOf(operand1 / operand2));
				}
			} else {
				opStack.push(token);
			}
		}
		System.out.println("The final answer is: " + opStack.pop());
	}
}
