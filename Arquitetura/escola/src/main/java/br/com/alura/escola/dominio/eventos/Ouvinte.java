package br.com.alura.escola.dominio.eventos;

public abstract class Ouvinte {

	
	public void processa(Evento evento) {
		
		if(!this.deveProcessar(evento)) return;
		
		this.processa(evento);
	}

	protected abstract void reageAo(Evento evento);
	protected abstract Boolean deveProcessar(Evento evento);
	
	
}
