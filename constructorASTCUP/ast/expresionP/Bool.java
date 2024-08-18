package ast.expresionP;

import ast.tiposP.TiposBasicos;
import ast.tiposP.KindTipo;
import ast.tiposP.Tipo;
import ast.lineaP.KindAsig;


import ast.Programa;

public class Bool extends Constante{
	private boolean is;


	public Bool(String is){
		if (is.equals("fact")){
			this.is = true;
		}
		else{
			this.is = false;
		}
		this.kind = KindAsig.BOOL;
	}

	@Override
	public String toString(){
		if (is){
			return "fact";
		}
		return "infact";
	}

	@Override
	public void binding(){
	}

	public Tipo getTipo(){
		return new TiposBasicos(KindTipo.BOOL);
	}

	@Override
	public void checkType(){
		setTipo(getTipo());
	}

	public int getValue(){
		if (is){
			return 1;
		}
		return 0;
	}

	public void generaCodigo(){
		Programa.codigo.println("\ti32.const " + getValue());
	}
}