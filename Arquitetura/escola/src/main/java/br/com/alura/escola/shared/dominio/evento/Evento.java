package br.com.alura.escola.shared.dominio.evento;

import java.time.LocalDateTime;
import java.util.Map;

public interface Evento {
	
	LocalDateTime momento();
	TipoEvento getTipoDoEvento();
	Map<String,Object> informacoes();

}
