package br.com.alura.escola.infra.aluno;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.alura.escola.dominio.aluno.CifradorDeSenha;

public class CifradorDeSenhaComMD5 implements CifradorDeSenha {

	@Override
	public String cifrarSenha(String senha) {
		
		try {
		
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			
			for(int i =0; i <bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff)));
			}
			
			return sb.toString();
		
		} catch (NoSuchAlgorithmException e) {
			
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Boolean validarSenhaCifrada(String senhaCifrada, String senha) {

		return this.cifrarSenha(senha).equals(senhaCifrada);
	}

}
