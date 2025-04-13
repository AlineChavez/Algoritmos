package Arbol;

import javax.swing.JFrame;

public class TreeMain {
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Árbol de Pitágoras");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().add(new PythagorasTree(10));
		ventana.pack();
		ventana.setLocationRelativeTo(null); 
		ventana.setVisible(true);
	}
}
