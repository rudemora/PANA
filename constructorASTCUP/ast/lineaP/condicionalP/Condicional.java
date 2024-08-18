package ast.lineaP.condicionalP;

import java.util.List;
import ast.expresionP.Expresion;
import ast.lineaP.Instruccion;
import ast.lineaP.Creacion;

import ast.Programa;

public class Condicional extends Instruccion{

	private Expresion exp;
	private List<Instruccion> decfun;
	private List<Condicional2> lcond2;
	private Condicional3 cond3;

	public Condicional(Expresion exp, List<Instruccion> decfun, List<Condicional2> lcond2, Condicional3 cond3){
		this.exp = exp;
		this.decfun = decfun;
		this.lcond2 = lcond2;
		this.cond3 = cond3;

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
		String s2 = "";
		for(int i = 0; i < lcond2.size(); i++){
			if (lcond2.get(i) == null){
					s2 += "null";
			}
			else {
				s2 += lcond2.get(i).toString();
			}
			if (i != lcond2.size() - 1){
				s2 += ", ";
			}
		}
		if(cond3 == null && lcond2.size() == 0){
			return "(IF " + exp.toString() + " THEN (" + s + "))"; 
		}
		else if(cond3 == null && lcond2.size() > 0){
			return "((IF " + exp.toString() + " THEN (" + s + ")) " + s2 + ")"; 
		}
		else if (lcond2.size() == 0){
			return "((IF " + exp.toString() + " THEN (" + s + ")) " + cond3.toString() + ")"; 
		}
		
		else { 
			return "((IF " + exp.toString() + " THEN (" + s + ")) " + s2 + " " + cond3.toString() + ")";
		}
	}

	@Override
	public void binding(){
		exp.binding();
		Programa.abrirBloque();
		for(Instruccion inst: decfun){
			inst.binding();
		}
		Programa.print();
		Programa.cerrarBloque();
		for(Condicional2 c: lcond2){
			c.binding();
		}
		if(cond3 != null){
			cond3.binding();
		}	
		
	}

	@Override
	public void checkType(){
		exp.checkType();
		if (!exp.getTipo().equals("BOOL")){
			System.out.println("ERROR: fallo en tipo If" + this);
			Programa.setFin();
		}
		else{
			for(Instruccion inst: decfun){
				inst.checkType();
			}
			for(Condicional2 c: lcond2){
				c.checkType();
			}
			if(cond3 != null){
				cond3.checkType();
			}
		}
	}

	public void setPos(int delta) {
		int ifDelta = delta;
		for(Instruccion ins: decfun){
			ins.setPos(ifDelta);
			ifDelta += ins.getTamanyo();
		}

		for(Condicional2 c: lcond2){
			c.setPos(delta);
		}
		if(cond3 != null){
			cond3.setPos(delta);
		}

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

		for(Condicional2 cond2: lcond2){
			int maxAux = cond2.maxMemory();
			if(maxAux > max){
				max = maxAux;
			}
		}
		if (cond3 != null){
		int maxAux2 = cond3.maxMemory();
		if(maxAux2 > max){
			max = maxAux2;
		}
		}
		return max;
	} 
	public boolean isBlock(){
		return true;
	}

	
	public void recorrer(List<Condicional2> lcond2, int i){
		
		lcond2.get(i).generaCodigo();
		Programa.codigo.println("\telse");
		if (i != lcond2.size() - 1){
			recorrer(lcond2, i+1);
			Programa.codigo.println("\tend");		
		}
		else if (cond3 == null){
			Programa.codigo.println("\tend");
		}
		else{
			if (lcond2.size() == 0){
				Programa.codigo.println("\telse");		
			}
			cond3.generaCodigo();
			if (lcond2.size() != 0){
				Programa.codigo.println("\tend");		
			}
		}		
	}

	public void generaCodigo(){
		exp.generaCodigo();
		Programa.codigo.println("\tif");
		for(Instruccion ins : decfun){
			ins.generaCodigo();
		}
		Programa.codigo.println("\telse");
		if (lcond2.size() != 0){
			recorrer(lcond2, 0);
		}
		else if (cond3 != null){
			cond3.generaCodigo();
		}	
		Programa.codigo.println("\tend");		

	}


}