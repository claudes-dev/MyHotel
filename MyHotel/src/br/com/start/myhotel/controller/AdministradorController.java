package br.com.start.myhotel.controller;

import br.com.start.myhotel.model.Administrador;


public class AdministradorController {
	
	public boolean ValidarInclusaoAdm(Administrador administrador) {
		boolean retorno = true;
		
		if(administrador.getCpf()=="") {
			retorno = false;
		}if(administrador.getSenha() == "") {
			retorno = false;
		}if(administrador.getNome() == "") {
			retorno = false;
		}
		
		return retorno;
	}
	public boolean ValidarExclusaoAdm(Administrador administrador) {
		boolean retorno = true;
		
		if(administrador.getId_adm() == 0) {
			retorno = false;
		}
		return retorno;
	}
	
	
}
