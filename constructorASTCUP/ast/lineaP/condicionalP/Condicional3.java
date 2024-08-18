package ast.lineaP.condicionalP;

import ast.lineaP.Instruccion;
import ast.expresionP.Expresion;
import ast.tiposP.TiposBasicos;
import ast.lineaP.Creacion;

import java.util.List;

import ast.Programa;

public class Condicional3 extends Instruccion{

	private List<Instruccion> decfun;
	
	public Condicional3(List<Instruccion> decfun){
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
		return "(ELSE (" +  s + "))";
		
	}

	@Override
	public void binding(){
		Programa.abrirBloque();
		for(Instruccion inst: decfun){
			inst.binding();
		}
		Programa.print();	
		Programa.cerrarBloque();	
	}

	@Override
	public void checkType(){
		for(Instruccion inst: decfun){
			inst.checkType();
		}
		
	}

	public void setPos(int delta) {
		int elseDelta = delta;
		for(Instruccion ins: decfun){
			ins.setPos(elseDelta);
			elseDelta += ins.getTamanyo();
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
		for(Instruccion ins : decfun){
			ins.generaCodigo();
		}
	}
}