package br.com.learning.java.modelos.Usuario;

import java.util.Objects;
import java.util.Set;

public abstract class Usuario {

   private String nomeUsuario;
   private String senha;

   public abstract Set<Permissao> getPermissoes();

    public Usuario(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return nomeUsuario.equals(usuario.nomeUsuario) && senha.equals(usuario.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeUsuario, senha);
    }

    @Override
    public String toString() {
        return String.format(
                "Usuario : %s",
                this.getNomeUsuario()
        );
    }
}
