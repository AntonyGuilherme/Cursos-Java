package br.com.learning.java.modelos.Usuario;

import br.com.learning.java.modelos.Usuario.Permissao;
import br.com.learning.java.modelos.Usuario.Usuario;

import java.util.Set;

public class Administrador extends Usuario {


    public Administrador(String nomeUsuario, String senha){
        super(nomeUsuario,senha);
    }

    @Override
    public Set<Permissao> getPermissoes() {
        return Set.of(
                Permissao.BUSCAR,
                Permissao.SALVAR,
                Permissao.ATUALIZAR,
                Permissao.EXCLUIR
        );
    }



}
