package Actividad1;

public class Test {
	public static void main(String[] args) {
		Stack<Integer> pilaEnteros =new StackArray<>(5);
		Stack<String> pilaStrings =new StackArray<>(3);
		
		try {
			pilaEnteros.push(10);
			pilaEnteros.push(30);
			pilaEnteros.push(20);
			System.out.println(pilaEnteros);
			System.out.println("Top: "+pilaEnteros.top());
			System.out.println("Pop: "+pilaEnteros.pop());
			
			pilaStrings.push("Blacks");
			pilaStrings.push("Estrella");
			System.out.println(pilaStrings);
			System.out.print("Top: "+pilaStrings.top());
			pilaStrings.pop();
			pilaStrings.pop();
			System.out.println(" ¿Esta vacia?: "+pilaStrings.isEmpty());
		
		}catch (ExceptionIsEmpty e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}
