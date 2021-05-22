package com.casacodigo.hernani.config.validation;

public class ErroDeFormularioForm {

	private String campo;
	private String erro;
	
	public ErroDeFormularioForm(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public ErroDeFormularioForm( String erro) {
		this.erro = erro;
	}
	
	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	

}