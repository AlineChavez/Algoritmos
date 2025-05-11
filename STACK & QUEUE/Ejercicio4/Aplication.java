package Ejercicio4;
import Actividad1.ExceptionIsEmpty;
import Ejercicio1.StackLink;

public class Aplication {
   // Verifica si los símbolos están balanceados
	public static boolean symbolBalancing(String s) throws ExceptionIsEmpty {
		StackLink<Character> stack = new StackLink<>();
      
       // Recorre cada carácter
		for (char c : s.toCharArray()) {
           // Si es símbolo de apertura, lo apila
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
           // Si es cierre, verifica el par
			} else if (c == ')' || c == ']' || c == '}') {
				if (stack.isempty()) return false;
				char top = stack.pop();
				if (!isMatchingPair(top, c)) return false;
			}
		}
       // Si la pila está vacía, está balanceado
		return stack.isempty();
	}
   // Verifica si el par es válido
	private static boolean isMatchingPair(char open, char close) {
		return (open == '(' && close == ')') ||
			   (open == '[' && close == ']') ||
			   (open == '{' && close == '}');
	}
}
