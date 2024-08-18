package ast.lineaP;

import ast.expresionP.Expresion;
import ast.expresionP.Dinamica;
import ast.Programa;
import ast.tiposP.TipoPuntero;

public class Delete extends Instruccion{

	private Expresion exp;

	public Delete(Expresion exp){
		this.exp = exp;

	}

	@Override
	public String toString(){
		return "(DELETE (" + exp.toString() + "))"; 

	}

	@Override
	public void binding(){
		exp.binding();
	}

	@Override
	public void checkType(){
		exp.checkType();
		if (!(exp.getTipo() instanceof TipoPuntero) || (exp instanceof Dinamica)){
			System.out.println("ERROR mal tipado DELETE " + this); 
		}
	}
}