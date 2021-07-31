import java.util.Stack;

class Solution {

	public boolean isValid(String s) {
		Stack stack = new Stack();
		char[] arrayChar = s.toCharArray();

		if (arrayChar.length == 1) {
			return false;
		}

		else if (arrayChar.length == 0) {
			return true;
		}

		for (int i = 0; i < arrayChar.length; i++) {

			if (arrayChar[i] == '(' || arrayChar[i] == '{' || arrayChar[i] == '[') {
				stack.push(arrayChar[i]);
			}
			
			

			else if (((arrayChar[i] == ')') && (stack.size() > 0) && (stack.peek().equals('(')))
					|| ((arrayChar[i] == ']') && (stack.size() > 0) && (stack.peek().equals('[')))
					|| ((arrayChar[i] == '}') && (stack.size() > 0) && (stack.peek().equals('{'))))

			{
				stack.pop();

			}
		}

		if (stack.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}