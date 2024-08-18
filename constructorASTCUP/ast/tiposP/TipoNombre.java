package ast.tiposP;

import ast.ASTNode;
import ast.Programa;
import ast.lineaP.Registro;

import ast.lineaP.Alias;

public class TipoNombre extends Tipo{
	private String tipo;

	public TipoNombre (String tipo) {
		this.tipo = tipo;
	}

	public String toString(){
		return tipo;
	}

	@Override 
	public void binding(){
		ASTNode node = Programa.searchId(tipo);
		if(node == null){
			System.out.println("ERROR en TipoNombre " + this);
			Programa.setFin();
		}
		else{
			this.link = node;
		}
	}

	@Override
	public void checkType(){
		if(!(this.link instanceof Registro)){
			System.out.println("ERROR en TipoNombre " + this);
			Programa.setFin();
		}
		
	}

	public int getTam(){
		Registro reg = (Registro) this.link;
		int sol = reg.getTamanyo();
		return reg.getTamanyo();
	}
	
	public Tipo reduceAlias(){
		if(this.link instanceof Alias){
			return link.getTipo();
		}
		return this;
	}

}