package br.com.alura.escola.academico.dominio.aluno;

public class Telefone {

	private String ddd;
	private String numero;
	
	public Telefone(String ddd, String numero) {
		this.setDD(ddd);
		this.setNumero(numero);
	}
	
	public void setDD(String ddd){
		
		if(this.isDDInvalido(ddd)) {
			throw new IllegalArgumentException("O DD eh invalido");
		}
		
		
		this.ddd = ddd;
	}
	
	private Boolean isDDInvalido(String ddd) {
		
		return !this.isItemDoTelefoneValido(ddd, "\\d{2}");
	}
	
	public void setNumero(String numero) {
		
		if(this.isNumeroInvalido(numero)) {
			throw new IllegalArgumentException("O Numero eh invalido");
		}
		
		this.numero = numero;
		
	}
	
	private Boolean isNumeroInvalido(String numero) {
		
		return !this.isItemDoTelefoneValido(numero, "\\d{8}|\\d{9}");
	}
	
	private Boolean isItemDoTelefoneValido(String item, String regex) {
		return item != null && item.matches(regex);
	}

	public String getDDD() {
		return this.ddd;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public String getTelefoneFormatado() {
		
		return String.format("(%s) %s", ddd,numero);
	}
	
}
