package ast.expresionP;

import java.util.List;
import ast.tiposP.*;
import ast.expresionP.Expresion;

import ast.lineaP.KindAsig;

import ast.Programa;

public class Dinamica extends Expresion{
	private Tipo tipo;
	private Expresion exp;

	public Dinamica(Tipo type){
		this.tipo = type;
		this.kind = KindAsig.DINAMICA;

	}
	public Dinamica(Tipo type, Expresion exp){
		this.tipo = type;
		this.exp = exp;
		this.kind = KindAsig.DINAMICA;
	}
	@Override
	public String toString(){
		return "(NEW " + tipo.toString() +")";		
	}

	@Override
	public void binding(){
		if(exp != null){
			exp.binding();
		}
	}
	public void setSize(List<Ent> tamanyos){
		int cont = 1;
		for(Ent en : tamanyos){
			cont *= en.getInt();
		}
		if(exp instanceof ExpreLlave){
			exp.checkType();

			ExpreLlave aux = (ExpreLlave) exp;
			if (aux.getSize() != cont){
				System.out.println("ERROR: fallo en tipado ExpreLlave" + this);
				Programa.setFin();
			}
			else{
				TipoArray tipoArray = new TipoArray(aux.getTipo().getTipoBasico(), tamanyos);
				exp.setTipo(new TipoPuntero(tipoArray));

			}
		}
		
	}

	@Override
	public void checkType(){

		TipoPuntero puntero = new TipoPuntero(tipo);
		setTipo(puntero);
		if(exp != null){
			exp.checkType();	
			if(exp.getTipo() instanceof TipoArray){	
				exp.setSize(tipo.getTamanyos());
			}
			else{
			if(!this.tipo.getTipoBasico().equals(exp.getTipo())){
				System.out.println("ERROR: fallo en DINAMICA" + this);
				Programa.setFin();
			}
			}
		}
		
	}
	
	public void generaCodigo(){
		Programa.codigo.println("\ti32.const " + tipo.getTam());
		Programa.codigo.println("\tcall $reserveHeap");
		Programa.codigo.println("\tglobal.get $NP");
		if(exp != null){
			if(exp.getKind().equals(KindAsig.LLAVE)){
				exp.generaCodigo();
				Programa.codigo.println("\tglobal.get $NP");
				//Programa.codigo.println("\ti32.const " + exp.getTamanyo());
			}
			else if(exp.getKind().equals(KindAsig.CORCH)){
				exp.generaCodigo();


				Programa.codigo.println("\tglobal.get $NP");
				//Programa.codigo.println("\ti32.const " + exp.getTamanyo());
			}
			else{	

				exp.generaCodigo();
				Programa.codigo.println("\t" + exp.getTipo().convertWasm() + ".store");
				Programa.codigo.println("global.get $NP");
			}
		}
	}
}



