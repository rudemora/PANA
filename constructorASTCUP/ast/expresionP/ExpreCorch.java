package ast.expresionP;

import ast.lineaP.KindAsig;
import ast.tiposP.TipoArray;
import ast.tiposP.Tipo;


import java.util.List;
import java.util.ArrayList;


import ast.Programa;

public class ExpreCorch extends Expresion{
	private Expresion exp;
	
	public ExpreCorch(Expresion exp, KindAsig kind){
		this.exp = exp;
		this.kind = kind;
	}

	public String toString(){
		return "(INILIST " + exp.toString() + ")";
	}

	@Override
	public void binding(){
		exp.binding();
	}

	@Override
	public void checkType(){
		exp.checkType();
		Tipo tipo = exp.getTipo();
		List<Ent> tams = new ArrayList<Ent>();
		setTipo(new TipoArray(tipo, tams));

	}

	public void setSize(List<Ent> tamanyos){
		TipoArray tipoArray = new TipoArray(exp.getTipo(), tamanyos);
		setTipo(tipoArray);


	}

	public void generaCodigo(){
		for(int i = 0; i < this.getTipo().getNumElems(); i++){
			Programa.codigo.println("");
			Programa.codigo.println("\tcall $repeat");
			Programa.codigo.println("\ti32.const " + i*4);
			Programa.codigo.println("\ti32.add");
			this.exp.generaCodigo();
			if(exp.getModifiable()){
				Programa.codigo.println("\t" + exp.getTipo().convertWasm() + ".load");

			}
			Programa.codigo.println("\t" + exp.getTipo().convertWasm() + ".store");
			Programa.codigo.println("");
			
		}
		Programa.codigo.println("\tdrop");
		
	}

	
}

