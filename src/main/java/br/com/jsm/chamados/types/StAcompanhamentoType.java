
package br.com.jsm.chamados.types;

public enum StAcompanhamentoType {
	NOVO(1), EM_ANDAMENTO(2), ENCERRADO(3), CANCELADO(4);

	private final int value;
	
	private StAcompanhamentoType(int value) {
		this.value = value;
		// TODO Auto-generated constructor stub
	}
	
	public int getValue() {
		return this.value;
	}
}
