package ast.lineaP.buclesP;

import java.util.List;

import ast.expresionP.Expresion;
import ast.lineaP.Instruccion;
import ast.lineaP.Declaracion;
import ast.lineaP.Asignacion;
import ast.lineaP.Creacion;

import ast.Programa;

public class For extends Bucles{
	private Declaracion dec;
	private Expresion exp;
	private List<Instruccion> decfun;
	private Asignacion asig;
	
	public For(Declaracion dec, Expresion exp, List<Instruccion> decfun, Asignacion asig) {
		this.dec = dec;
		this.exp = exp;
		this.decfun = decfun;
		this.asig = asig;
	}

	@Override
	public String toString(){
		String s = "";
		for(int i = 0; i < decfun.size(); i++){
			if (decfun.get(i) == null){
					s += "null";
			}
			else {
				s += decfun.get(i).toString();
			}

			if (i != decfun.size() - 1){
				s += ", ";
			}

		}
		return "(FOR ((" + dec.toString() + ", " + exp.toString() + ", " + asig.toString() + "), (" + s + ")))";
	}
	
	@Override
	public void binding(){
		dec.binding();
		exp.binding();
		asig.binding();
		Programa.abrirBloque();
		for(Instruccion ins : decfun){
			ins.binding();
		}
		Programa.print();
		Programa.cerrarBloque();
		
	}

	@Override
	public void checkType(){
		dec.checkType();
		exp.checkType();
		asig.checkType();
		if(!dec.getTipo().equals(asig.getTipo()) || !exp.getTipo().equals("BOOL")){
			System.out.println("ERROR: mal tipado en FOR " + this);
			Programa.setFin();
		}
		else{
			for(Instruccion ins: decfun){
				ins.checkType();
			}
		}
	}


	@Override
	public void setPos(){

	}

	public void setPos(int delta) {
		int forDelta = delta;
		dec.setPos(forDelta);
		if (dec instanceof Creacion){
			forDelta += dec.getTamanyo();
		}
		for(Instruccion ins : decfun){			
			ins.setPos(forDelta);
			forDelta += ins.getTamanyo();
		}

	}

	public void generaCodigo(){

        	dec.generaCodigo();

        	Programa.codigo.println("\tblock");
        	Programa.codigo.println("\t loop");

        	exp.generaCodigo();
        
        	Programa.codigo.println(" i32.eqz");
        	Programa.codigo.println(" br_if 1");
        
        	for (Instruccion ins : decfun){
         	   ins.generaCodigo();
        	}

        	asig.generaCodigo();

        	Programa.codigo.println("\t br 0");
        	Programa.codigo.println("\t end");
        	Programa.codigo.println("\tend");

	}

	public int maxMemory(){
		int max = 0;
		int c = 0;
		max += dec.getTamanyo();
		for(Instruccion ins : decfun){
			if(ins instanceof Creacion){
				c += ins.getTamanyo();
				max += ins.getTamanyo();
			}
			else if(ins.isBlock()){
				int max1 = ins.maxMemory();
				if(c+max1 > max){
					max = c + max1;
				}
			}
		}
		return max;
	} 
}