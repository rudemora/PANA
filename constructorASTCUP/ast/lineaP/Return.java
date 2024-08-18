package ast.lineaP;

import ast.expresionP.Expresion;
import ast.expresionP.ExpLlamada;

import ast.tiposP.TiposBasicos;
import ast.tiposP.KindTipo;

import ast.Programa;

public class Return extends Instruccion{
	private Expresion exp;
	
	public Return(Expresion exp){
		this.exp = exp;
	}
	
	@Override
	public String toString(){
		return "(RETURN (" + exp.toString() + "))";
	}

	@Override
	public void binding(){
		exp.binding();
		if (Programa.getSize() > 2){
			System.out.println("ERROR en RETURN " + this);
			Programa.setFin(); 
		}
	}

	@Override 
	public void checkType(){
		exp.checkType();
		Funcion fun = (Funcion) this.getLink();
		if(!(fun.getTipo().equals(exp.getTipo()))){
			System.out.println("ERROR en tipo RETURN " + this);
			Programa.setFin();
		}
	}

	@Override
	public void generaCodigo(){
		Programa.codigo.println("\tglobal.get $SP");
		Programa.codigo.println("\ti32.const " + 4);
		Programa.codigo.println("\ti32.sub");
		if (exp.getTipo() instanceof TiposBasicos){
			exp.generaCodigo();
		}
		else {
			exp.calcularDirRelativa();

		}
               Programa.codigo.println("\t" + exp.getTipo().convertWasm() + ".store");
		

		Programa.codigo.println("\tglobal.get $SP");
		Programa.codigo.println("\ti32.const " + 4);
		Programa.codigo.println("\ti32.sub");
		Programa.codigo.println("\tcall $freeStack"); 

        	Programa.codigo.println("\treturn");
	}
}