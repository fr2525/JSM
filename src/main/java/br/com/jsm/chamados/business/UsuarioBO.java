package br.com.jsm.chamados.business;

import java.math.BigInteger;
import java.security.MessageDigest;

public class UsuarioBO {

	public String encryptPassword(String dsSenha) throws Exception {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, messageDigest.digest(dsSenha.getBytes()));
			
			return hash.toString(16);
	}

}
