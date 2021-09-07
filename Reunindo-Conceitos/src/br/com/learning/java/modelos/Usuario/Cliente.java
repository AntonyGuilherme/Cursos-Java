package br.com.learning.java.modelos.Usuario;

import br.com.learning.java.modelos.Usuario.Permissao;
import br.com.learning.java.modelos.Usuario.Usuario;

import java.util.Set;

public class Cliente extends Usuario {

    public Cliente(String nomeUsuario,String senha){
        super(nomeUsuario,senha);
    }

    @Override
    public Set<Permissao> getPermissoes() {
        return Set.of(Permissao.BUSCAR);
    }

}
