package ast.lineaP.condicionalP;

import ast.lineaP.Instruccion;
import ast.expresionP.Expresion;
import java.util.List;
import ast.lineaP.Creacion;

import ast.Programa;

public class Condicional2 extends Instruccion{

	private Expresion exp;
	private List<Instruccion> decfun;

	public Condicional2(Expresion exp, List<Instruccion> decfun){
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
		return "(ELSE IF " + exp.toString() + " THEN (" + s + "))";
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
	}

	@Override
	public void checkType(){
		exp.checkType();
		if (!exp.getTipo().equals("BOOL")){
			System.out.println("ERROR: fallo en tipo Else If" + this);
			Programa.setFin();
		}
		else{
			for(Instruccion inst: decfun){
				inst.checkType();
			}
		}
	}

	public void setPos(int delta) {
		int elseifDelta = delta;
		for(Instruccion ins: decfun){
			ins.setPos(elseifDelta);
			elseifDelta += ins.getTamanyo();
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
		return max;
	}

	public boolean isBlock(){
		return true;
	}

	public void generaCodigo(){
		exp.generaCodigo();
		Programa.codigo.println("\tif");
		for(Instruccion ins : decfun){
			ins.generaCodigo();
		}
	}

}