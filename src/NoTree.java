
public class NoTree {
	
	private NoTree pai;
	private NoTree filhoEsq;
	private NoTree filhoDir;
	private String valor;
	
	public NoTree(String valor){
		this.setValor(valor);
	}

	public NoTree getPai() {
		return pai;
	}

	public void setPai(NoTree pai) {
		this.pai = pai;
	}

	public NoTree getFilhoDir() {
		return filhoDir;
	}

	public void setFilhoDir(NoTree filhoDir) {
		this.filhoDir = filhoDir;
	}

	public NoTree getFilhoEsq() {
		return filhoEsq;
	}

	public void setFilhoEsq(NoTree filhoEsq) {
		this.filhoEsq = filhoEsq;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	

}
