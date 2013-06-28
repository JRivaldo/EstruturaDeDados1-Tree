
public class Tree {
	
	private NoTree raiz;
	
		
	public void add(String valor){
		if(this.raiz == null){
			this.raiz = new NoTree(valor);
			return;
		}
		this.addRecursivo(this.raiz, valor);
	}
	
	private void addRecursivo(NoTree no, String valor){
		if(valor.compareTo(no.getValor()) < 0){
			if(no.getFilhoEsq() == null){
				no.setFilhoEsq(new NoTree(valor));
				System.out.println("  Inserindo " + valor + " a esquerda de " + no.getValor());
				return;
			}
			addRecursivo(no.getFilhoEsq(), valor);
		}
		else if(valor.compareTo(no.getValor()) > 0){
			if(no.getFilhoDir() == null){
				no.setFilhoDir(new NoTree(valor));
				System.out.println("  Inserindo " + valor + " a direita de " + no.getValor());
				return;
			}
			addRecursivo(no.getFilhoDir(), valor);
		}
	}

}
