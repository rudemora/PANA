package ast.expresionP;

import ast.lineaP.KindAsig;

import ast.tiposP.Tipo;
import ast.tiposP.TipoArray;

import ast.expresionP.Ent;

import java.util.List;
import java.util.ArrayList;
import ast.Programa;


public class ExpreLlave extends Expresion{
	private List<Expresion> exp;
	
	public ExpreLlave(List<Expresion> exp, KindAsig kind){
		this.exp = exp;
		this.kind = kind;
	}

	public String toString(){
		return "(INILIST " + exp.toString() + ")";
	}

	@Override
	public void binding(){
		for(Expresion e: exp){
			e.binding();
		}
	}

	@Override
	public void checkType(){
		Expresion e0 = exp.get(0);
		e0.checkType();
		Tipo tipo = e0.getTipo();
		List<Ent> tams = new ArrayList<Ent>();
		setTipo(new TipoArray(tipo, tams));
		for(Expresion e: exp){
			e.checkType();
			if(!tipo.equals(e.getTipo())){
				System.out.println("ERROR: fallo en ExpreLlave" + this);
				Programa.setFin();
				setTipo(null);
				break;
			}
		}
	}

	public void setSize(List<Ent> tamanyos){
		int cont = 1;
		for(Ent en : tamanyos){
			cont *= en.getInt();
		}
		if (exp.size() != cont){
			System.out.println("ERROR: fallo en tipado ExpreLlave" + this);
			Programa.setFin();
		}
		else{
			TipoArray tipoArray = new TipoArray(exp.get(0).getTipo(), tamanyos);
			setTipo(tipoArray);
		}
		
	}

	public void generaCodigo(){
		for(int i = 0; i < exp.size(); i++){
			Programa.codigo.println("");
			Programa.codigo.println("\tcall $repeat");
			Programa.codigo.println("\ti32.const " + i*4);
			Programa.codigo.println("\ti32.add");
			exp.get(i).generaCodigo();
			Programa.codigo.println("\t" + exp.get(i).getTipo().convertWasm() + ".store");
			Programa.codigo.println("");
			
		}
		Programa.codigo.println("\tdrop");
		
	}
	public int getSize(){
		return exp.size();
	}

		


}

