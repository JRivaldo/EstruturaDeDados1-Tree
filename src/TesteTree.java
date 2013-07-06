
public class TesteTree {
	
	public static void main(String [] args){
		
		Tree tree = new Tree();
		tree.add("C");
		tree.add("B");
		tree.add("A");
		tree.add("D");
		tree.add("F");
		tree.add("E");
		
		tree.mostrarPrefix();
						
		System.out.println("\n" + tree.contem("A"));
		
		System.out.println(tree.remover("C"));
		
		System.out.print("Mostrar prefixado: ");
		tree.mostrarPrefix();
		
		System.out.print("\nMostrar posfixado: ");
		
		tree.mostrarPosfix();
		
		System.out.print("\nMostrar ordenado: ");
		
		tree.mostrar();
	}

}
