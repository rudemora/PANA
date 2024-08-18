package ast.tiposP;

import ast.expresionP.Ent;
import ast.tiposP.TipoPuntero;

import java.util.List;

public class ListPuntero extends Tipo{
	private TipoPuntero tipoPuntero;
	private List<Ent> tamanyos;

	public ListPuntero(Tipo tipo, List<Ent> tamanyos){
		this.tipoPuntero = new TipoPuntero(tipo);
		this.tamanyos = tamanyos;
	}
	
	@Override
	public String toString(){
		return tipoPuntero.toString() + " LIST " + tamanyos.toString();
	}

	@Override
	public void binding(){
		tipoPuntero.binding();
	}

	public List<Ent> getTamanyos(){
		return tamanyos;
	}

	public TipoPuntero getTipoBasico(){
		return tipoPuntero;
	}

	public int getNumElems(){
		int elems = 1;
		for(Ent e : tamanyos){
			elems *= e.getInt();
		}
		return elems;
	}

        public int getTam(){
		return tipoPuntero.getTam() * getNumElems();
	}

	
	public Tipo reduceAlias(){
		this.tipoPuntero = (TipoPuntero) tipoPuntero.reduceAlias();
		return this;
	}
	
	
}
