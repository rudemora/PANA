package ast.lineaP.buclesP;

import java.util.List;


import ast.expresionP.Expresion;
import ast.lineaP.Instruccion;
import ast.lineaP.Declaracion;
import ast.lineaP.Creacion;

import ast.Programa;

public class Loop extends Bucles{
	private Expresion exp;
	private List<Instruccion> decfun;
	
	public Loop(Expresion exp, List<Instruccion> decfun) {
		this.exp = exp;
		this.decfun = decfun;
	}

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

		return "(LOOP (" + exp.toString() + ", (" + s + ")))";
	}

	@Override
	public void binding(){
		exp.binding();
		Programa.abrirBloque();
		for(Instruccion ins: decfun){
			ins.binding();
		}	
		Programa.print();
		Programa.cerrarBloque();
	}
	
	@Override
	public void checkType(){
		exp.checkType();
		if(!exp.getTipo().equals("NUM")){
			System.out.println("ERROR: mal tipado en LOOP " + this);
			Programa.setFin();
		}
		else{
			for(Instruccion ins: decfun){
				ins.checkType();
			}
		}
	}

	public void setPos(int delta) {
		int loopDelta = delta + 4;

		for(Instruccion ins : decfun){
			ins.delta = loopDelta;
			ins.setPos(loopDelta);
			loopDelta += ins.getTamanyo();
		}

	}

	public void generaCodigo(){
		Programa.codigo.println("\tlocal.get $localsStart");
		Programa.codigo.println("\ti32.const " + delta);
		Programa.codigo.println("\t" + exp.getTipo().convertWasm().toString() + ".add");
		exp.generaCodigo();
		Programa.codigo.println("\t" + exp.getTipo().convertWasm().toString() + ".store");
		Programa.codigo.println("\tblock");
		Programa.codigo.println("\t loop");

		Programa.codigo.println("\tlocal.get $localsStart");
		Programa.codigo.println("\ti32.const " + delta);
		Programa.codigo.println("\t" + exp.getTipo().convertWasm().toString() + ".add");

		Programa.codigo.println("\t" + exp.getTipo().convertWasm().toString() + ".load");
		Programa.codigo.println("\t i32.eqz");
        	Programa.codigo.println("\t br_if 1");
		for (Instruccion ins : decfun){
            		ins.generaCodigo();
        	}

		Programa.codigo.println("\tlocal.get $localsStart");
		Programa.codigo.println("\ti32.const " + delta);
		Programa.codigo.println("\ti32.add");
		Programa.codigo.println("\tlocal.get $localsStart");
		Programa.codigo.println("\ti32.const " + delta);	
		Programa.codigo.println("\t" + exp.getTipo().convertWasm().toString() + ".add");
		Programa.codigo.println("\t" + exp.getTipo().convertWasm().toString() + ".load");
		Programa.codigo.println("\ti32.const 1");
		
		Programa.codigo.println("\t" + exp.getTipo().convertWasm().toString() + ".sub");
		Programa.codigo.println("\t" +exp.getTipo().convertWasm().toString() + ".store");
		

		Programa.codigo.println("\t br 0");
        	Programa.codigo.println("\t end");
        	Programa.codigo.println("\tend");
 

	}

	public int maxMemory(){
		int max = 0;
		int c = 0;
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
		return max + 4;
	} 




}