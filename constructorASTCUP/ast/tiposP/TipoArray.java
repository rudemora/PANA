package ast.tiposP;

import ast.expresionP.Expresion;
import ast.expresionP.Ent;
import ast.tiposP.*;

import ast.Programa;

import java.util.List;



public class TipoArray extends Tipo{
	
	private Tipo tipoBasico;
	private List<Ent> tamanyos;

	public TipoArray (Tipo tipoBasico, List<Ent> valors){
		this.tipoBasico = tipoBasico;
		this.tamanyos = valors;
		for(Ent in : valors){
			if(in.getInt() <= 0){
				System.out.println("ERROR array no declarado correctamente ");
				Programa.setFin();
				break;
			}
		}
	}

	@Override
	public String toString(){
		return tipoBasico.toString() + " LIST " + tamanyos.toString();
	}

	public List<Ent> getTamanyos(){
		return tamanyos;
	}

	@Override
	public void binding(){
		tipoBasico.binding();
	}

	public Tipo getTipoBasico(){
		return tipoBasico;
	}
	
	public int getNumElems(){
		int elems = 1;
		for(Ent e : tamanyos){
			elems *= e.getInt();
		}
		return elems;
	}

	public int getTam(){
		return tipoBasico.getTam() * getNumElems();
	}

	public Tipo reduceAlias(){
		this.tipoBasico = tipoBasico.reduceAlias();
		return this;
	}
	
}