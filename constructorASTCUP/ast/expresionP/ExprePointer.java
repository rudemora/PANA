package ast.expresionP;

import ast.lineaP.KindAsig;

import ast.tiposP.Tipo;
import ast.tiposP.TipoArray;
import ast.tiposP.TipoPuntero;
import ast.tiposP.ListPuntero;

import ast.expresionP.Ent;

import java.util.List;
import java.util.ArrayList;
import ast.Programa;


public class ExprePointer extends Expresion{
	private Expresion exp;
	
	public ExprePointer(Expresion exp, KindAsig kind){
		this.exp = exp;
		this.kind = kind;
		this.isModifiable = true;

	}

	public String toString(){
		return "(POINTER " + exp.toString() + ")";
	}

	@Override
	public void binding(){
		exp.binding();
	}

	@Override
	public void checkType(){
		exp.checkType();
		Tipo t = exp.getTipo();

			if (t == null){
					System.out.println("ERROR: fallo en puntero EUN" + this);
					Programa.setFin();
				}
				else{
					if (!(t instanceof TipoPuntero || t instanceof ListPuntero)){
						System.out.println("ERROR: fallo en tipo EUN" + this);
						Programa.setFin();
					}	
					else{
						if(t instanceof TipoPuntero){
							TipoPuntero tipoP = (TipoPuntero) t;
							setTipo(tipoP.getTipoBasico());

						}
						else{
							ListPuntero tipoP = (ListPuntero) t;
							setTipo(new TipoArray(tipoP.getTipoBasico(), tipoP.getTamanyos()));

						}

					}
				}

	}

	public void generaCodigo(){
          	exp.generaCodigo();
		Programa.codigo.println("\t" + this.getTipo().convertWasm() + ".load");	
	}

	public void calcularDirRelativa(){
		exp.generaCodigo();
	}

}

