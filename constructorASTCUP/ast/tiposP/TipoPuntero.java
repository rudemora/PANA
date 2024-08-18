package ast.tiposP;

import ast.expresionP.Expresion;
import ast.tiposP.TiposBasicos;

import java.util.ArrayList;
import java.util.List;

public class TipoPuntero extends Tipo{
	
	private Tipo tipoBasico;

	public TipoPuntero(Tipo tipoBasico){
		this.tipoBasico = tipoBasico;
	}	


	@Override
	public String toString(){
		return tipoBasico.toString() + " POINTER";
	}

	public Tipo getTipoBasico(){
		return tipoBasico;
	}

	@Override
	public void binding(){
		tipoBasico.binding();
	}

	public int getTam(){
		return 4;
	}

	public Tipo reduceAlias(){
		this.tipoBasico = tipoBasico.reduceAlias();
		return this;
	}

	
}