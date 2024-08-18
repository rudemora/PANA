package ast.lineaP.buclesP;

import ast.lineaP.Instruccion;


public abstract class Bucles extends Instruccion{

	public abstract String toString();
	
	@Override
	public void checkType(){
	}

	public boolean isBlock(){
		return true;
	}

}	