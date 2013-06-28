import java.util.ArrayList;


public class Tree {
	
	private NoTree raiz;
	private ArrayList<String> lista = new ArrayList<String>();
	
		
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
	
	public String remover(String valor){
		String remove;
		if(this.raiz == null){
			throw new RuntimeException("Erro ao remover item de árvore vazia!");
		}
		remove = this.removerRecursivo(this.raiz, valor);
		if(remove == null){
			throw new RuntimeException("Valor não encontrado na árvore!");
		}	
		return remove;
	}
	
	public String buscar(String valor){
		String result;
		if(this.raiz == null){
			throw new RuntimeException("Erro: Árvore vazia!");
		}
		result = this.buscarRecursivo(this.raiz, valor);
		if(result == null){
			throw new RuntimeException("Erro: Valor não existe na árvore!");
		}
		
		return result;
	}
	
	public void mostrar(){
		this.mostrarOrdem(this.raiz);
	}
	
	public void mostrarPrefix(){
		this.mostrarPrefixado(this.raiz);
	}
	
	private void mostrarOrdem(NoTree no){
		if(no != null){
			mostrarOrdem(no.getFilhoEsq());
			System.out.print(no.getValor() + " ");
			mostrarOrdem(no.getFilhoDir());
		}
	}
	
	private void mostrarPrefixado(NoTree no) {
	    if(no != null){
	        System.out.print(no.getValor() + " ");
	        mostrarPrefixado(no.getFilhoEsq());
	        mostrarPrefixado(no.getFilhoDir());
	    }
	}

	private String buscarRecursivo(NoTree no, String valor){
		if(valor.equals(this.raiz.getValor())){
			return no.getValor();
		}
		
		if(valor.compareTo(no.getValor()) < 0){
			if(no.getFilhoEsq() == null){
				return null;
			}
			else if(no.getFilhoEsq().getValor().equals(valor)){
				return no.getFilhoEsq().getValor();
			}
			buscarRecursivo(no.getFilhoEsq(), valor);
		}
		else if(valor.compareTo(no.getValor()) > 0){
			if(no.getFilhoDir() == null){
				return null;
			}
			else if(no.getFilhoDir().getValor().equals(valor)){
				return no.getFilhoDir().getValor();
			}
			buscarRecursivo(no.getFilhoDir(), valor);
		}
		return null;
	}
	
	private String removerRecursivo(NoTree no, String valor){
		String remover;
		if(valor.equals(raiz.getValor())){
			remover = this.raiz.getValor();
			NoTree temp = this.raiz.getFilhoEsq();
			this.raiz = this.raiz.getFilhoDir();
			this.varrer(temp);
			for(int i = 0; i < this.lista.size(); i++){
				this.add(this.lista.get(i));
			}
			this.lista = new ArrayList<String>();
			return remover;
			
		}
		if(valor.compareTo(no.getValor()) < 0){
			if(no.getFilhoEsq() == null){
				return null;
			}
			else if(no.getFilhoEsq().getValor().equals(valor)){
				remover = no.getFilhoEsq().getValor();
				NoTree temp = no.getFilhoEsq().getFilhoDir();
				no.setFilhoEsq(no.getFilhoEsq().getFilhoEsq());
				this.varrer(temp);
				for(int i = 0; i < this.lista.size(); i++){
					this.add(this.lista.get(i));
				}
				this.lista = new ArrayList<String>();
				return remover;
			}
			buscarRecursivo(no.getFilhoEsq(), valor);
		}
		
		else if(valor.compareTo(no.getValor()) > 0){
			if(no.getFilhoDir() == null){
				return null;
			}
			else if(no.getFilhoDir().getValor().equals(valor)){
				remover = no.getFilhoDir().getValor();
				NoTree temp = no.getFilhoDir().getFilhoEsq();
				no.setFilhoDir(no.getFilhoDir().getFilhoDir());
				this.varrer(temp);
				for(int i = 0; i < this.lista.size(); i++){
					this.add(this.lista.get(i));
				}
				this.lista = new ArrayList<String>();
				return remover;
			}
			buscarRecursivo(no.getFilhoDir(), valor);
		}
		return null;
	}
	
	private void varrer(NoTree no){
		if(no != null){
			this.lista.add(no.getValor());
			varrer(no.getFilhoEsq());
			varrer(no.getFilhoDir());
		}		
	}

}
