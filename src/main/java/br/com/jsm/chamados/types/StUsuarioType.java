
package br.com.jsm.chamados.types;

public enum StUsuarioType {
	SELECIONE(0),ATIVO(1), INATIVO(2), BLOQUEADO(3);

	private final int value;
	
	private StUsuarioType(int value) {
		this.value = value;
		// TODO Auto-generated constructor stub
	}
	
	public int getValue() {
		return this.value;
	}
}
