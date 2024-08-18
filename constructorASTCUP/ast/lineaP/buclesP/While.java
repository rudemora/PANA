package ast.lineaP.buclesP;

import java.util.List;


import ast.expresionP.Expresion;
import ast.lineaP.Instruccion;
import ast.lineaP.Declaracion;
import ast.lineaP.Creacion;

import ast.Programa;


public class While extends Bucles{
	private Expresion exp;
	private List<Instruccion> decfun;
	
	public While(Expresion exp, List<Instruccion> decfun) {
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
		return "(WHILE (" + exp.toString() + ", (" + s + ")))";
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
		if(!exp.getTipo().equals("BOOL")){
			System.out.println("ERROR: mal tipado en WHILE " + this);
			Programa.setFin();
		}
		else{
			for(Instruccion ins: decfun){
				ins.checkType();
			}
		}
	}

	public void setPos(int delta) {
		int whileDelta = delta;
		for(Instruccion ins : decfun){
			ins.delta = whileDelta;
			ins.setPos(whileDelta);
			whileDelta += ins.getTamanyo();
		}

	}

	public void generaCodigo(){
       
        	Programa.codigo.println("\tblock");
        	Programa.codigo.println("\t  loop");

        	exp.generaCodigo();
        
        	Programa.codigo.println("\t i32.eqz");
        	Programa.codigo.println("\t br_if 1");
        
        	for (Instruccion ins : decfun){
            		ins.generaCodigo();
        	}

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
		return max;
	} 
}