package ast.lineaP;

import ast.tiposP.Tipo;

public abstract class Declaracion extends Instruccion{
	
	@Override
	public abstract String toString();



	@Override
	public void binding(){

	}
	@Override 
	public void checkType(){
	}

}