package br.curtaja.com.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class Pessoa {
	
	Result result;
	
	@Inject
	public Pessoa(Result result){
		this.result = result;
	}
	
	@Path("/teste")
	public void teste(){
		//result.include("var", "Teste.\n Esse é um teste apenas para comprovar a eficácia do vRaptor!");
		result.include("string", "string testando meu vraptor!");
		
	}

}
