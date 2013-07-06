
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
				NoTree novo = new NoTree(valor);
				novo.setPai(no);
				no.setFilhoEsq(novo);
				System.out.println("  Inserindo " + valor + " a esquerda de " + no.getValor());
								
				return;
			}
			addRecursivo(no.getFilhoEsq(), valor);
		}
		else if(valor.compareTo(no.getValor()) > 0){
			if(no.getFilhoDir() == null){
				NoTree novo = new NoTree(valor);
				novo.setPai(no);
				no.setFilhoDir(novo);
				System.out.println("  Inserindo " + valor + " a esquerda de " + no.getValor());
								
				return;
			}
			addRecursivo(no.getFilhoDir(), valor);
		}
	}
	
	
	
	public String remover(String valor){
		String remove = null;
		if(this.raiz == null){
			throw new RuntimeException("Erro ao remover item de árvore vazia!");
		}
		remove = this.removerRecursivo(this.raiz, valor);
		if(remove == null){
			throw new RuntimeException("Valor não encontrado na árvore!");
		}	
		return remove;
	}
	
	
	
	public boolean contem(String valor){
		NoTree result;
		if(this.raiz == null){
			throw new RuntimeException("Erro: Árvore vazia!");
		}
		 result = this.buscarRecursivo(this.raiz, valor);
		if(result == null){
			throw new RuntimeException("Erro: Valor não existe na árvore!");
		}
		
		return result.getValor().equals(valor);
	}
	
	public void mostrar(){
		this.mostrarOrdem(this.raiz);
	}
	
	public void mostrarPrefix(){
		this.mostrarPrefixado(this.raiz);
	}
	
	public void mostrarPosfix(){
		this.mostrarPosfixado(this.raiz);
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
	
	private void mostrarPosfixado(NoTree no){
		if(no != null){
	        mostrarPrefixado(no.getFilhoEsq());
	        mostrarPrefixado(no.getFilhoDir());
			System.out.print(no.getValor() + " ");
		}
	}
	
//	Achei interessante a ideia desse método de busca e resolvi modificar algumas coisas nele para poder usá-lo.
//  
	private NoTree buscarRecursivo(NoTree no, String valor){
		NoTree result;
		
		if(no == null){
			return null;
		}
		else{
			if(valor.equals(no.getValor())){
				return no;
			}
			else{
				result = buscarRecursivo(no.getFilhoDir(), valor);
				if(result == null){
					result = buscarRecursivo(no.getFilhoEsq(), valor);
				}
			}
		}
		
		return result;
	}
	
//	Modifiquei o método de busca que encontrei na net para poder usar a ideia do mesmo para remover, criei 
//	um método auxiliar para poder recolocar os valores perdidos caso seja excluído um valor onde o nó
//	possua um lado esquerdo ou direito com valores.
		
	private String removerRecursivo(NoTree no, String valor){
		String result;
		NoTree pai;
		NoTree aux;
		
		if(no == null){
			return null;
		}
		else{
			if(valor.equals(no.getValor())){
				result = no.getValor();
				pai = no.getPai();
				if(pai == null){
					if(no.getFilhoDir() != null){
						aux = no.getFilhoEsq();
						this.raiz = no.getFilhoDir();
						this.raiz.setPai(null);
						this.realocarTree(aux);
					}
					else{
						aux = no.getFilhoDir();
						this.raiz = no.getFilhoDir();
						this.raiz.setPai(null);
						this.realocarTree(aux);
					}
					
					return result;
				}
				if(pai.getFilhoDir() != null){
					if(pai.getFilhoDir().getValor().equals(valor)){
						aux = no.getFilhoEsq();
						pai.setFilhoDir(no.getFilhoDir());
						this.realocarTree(aux);
					}
				}
				if(pai.getFilhoEsq() != null){
					if(pai.getFilhoEsq().getValor().equals(valor)){
						aux = no.getFilhoDir();
						pai.setFilhoEsq(no.getFilhoEsq());
						this.realocarTree(aux);
					}
				}
				
				return result;
			}
			else{
				result = removerRecursivo(no.getFilhoDir(), valor);
				if(result == null){
					result = removerRecursivo(no.getFilhoEsq(), valor);
				}
			}
		}
		
		return result;
	}
	
		
	
	private void realocarTree(NoTree no){
		if(no == null){
			return;
		}
		
		this.add(no.getValor());
		if(no.getFilhoDir() != null){
			realocarTree(no.getFilhoDir());
		}
		if(no.getFilhoEsq() != null){			
			realocarTree(no.getFilhoEsq());
		}
		
	}
		

}
