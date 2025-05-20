package bstreelinklistinterfgeneric;

public class Prueba{
	public static void main(String[] args) throws Exception {
		LinkedBST<Integer> bst = new LinkedBST<>();
		bst.insertar(10);
		bst.insertar(5);
		bst.insertar(15);
		bst.insertar(3);
		bst.insertar(7);

		System.out.println("Representación con paréntesis:");
		System.out.println(bst.parenthesize());
	}
}