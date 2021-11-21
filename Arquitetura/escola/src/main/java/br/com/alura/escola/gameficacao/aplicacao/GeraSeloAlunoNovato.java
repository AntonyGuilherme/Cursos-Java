package br.com.alura.escola.gameficacao.aplicacao;

import br.com.alura.escola.gameficacao.dominio.selo.AdicionaSeloAluno;
import br.com.alura.escola.gameficacao.dominio.selo.AdicionaSeloDTO;
import br.com.alura.escola.gameficacao.dominio.selo.RepositorioDeSelo;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.TipoEvento;

public class GeraSeloAlunoNovato extends Ouvinte {

    private final RepositorioDeSelo repositorioDeSelo;


    public GeraSeloAlunoNovato(RepositorioDeSelo repositorioDeSelo) {
        this.repositorioDeSelo = repositorioDeSelo;
    }

    @Override
    protected void reageAo(Evento evento) {
        
        CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
        AdicionaSeloAluno adicionaSeloAluno = new AdicionaSeloAluno(repositorioDeSelo);
        AdicionaSeloDTO adicionaSeloNovatoDTO = new AdicionaSeloDTO("Novato", cpfDoAluno);
        adicionaSeloAluno.adicionarSelo(adicionaSeloNovatoDTO);
        
    }

    @Override
    protected Boolean deveProcessar(Evento evento) {

        return evento.getTipoDoEvento() == TipoEvento.ALUNO_MATRICULADO;
    }
    
}
