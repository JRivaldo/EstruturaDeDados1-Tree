
public class TesteTree {
	
	public static void main(String [] args){
		
		Tree tree = new Tree();
		tree.add("C");
		tree.add("B");
		tree.add("A");
		tree.add("D");
		tree.add("F");
		
		tree.mostrarPrefix();
		
		//System.out.println("\n" + tree.remover("D"));
		
		//tree.add("D");
		tree.add("E");
		
		System.out.println(tree.remover("C"));
		
		tree.mostrarPrefix();
	}

}
