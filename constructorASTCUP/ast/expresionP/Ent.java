package ast.expresionP;

import ast.tiposP.TiposBasicos;
import ast.tiposP.KindTipo;
import ast.tiposP.Tipo;
import ast.Programa;
import ast.lineaP.KindAsig;


public class Ent extends Constante{
	private int n;
	
	public Ent(String num){
		this.n = Integer.parseInt(num);
		this.kind = KindAsig.ENT;
	}
	
	public String toString(){
		return "" + n;
	}

	@Override
	public void binding(){
	}

	public Tipo getTipo(){
		return new TiposBasicos(KindTipo.NUM);
	}

	@Override
	public void checkType(){
		setTipo(getTipo());
	}

	public int getInt(){
		return this.n;
	}

	public void generaCodigo(){
		Programa.codigo.println("\ti32.const " + n);
	}

}	