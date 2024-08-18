package ast.expresionP;

import ast.lineaP.KindAsig;
import ast.tiposP.KindTipo;

import ast.tiposP.Tipo;
import ast.tiposP.TiposBasicos;

import ast.tiposP.TipoArray;
import ast.tiposP.ListPuntero;

import ast.expresionP.Ent;

import ast.Programa;
import ast.ASTNode;



import java.util.List;

public class EAcceso extends Expresion {
	private Expresion exp1;
	private List<Expresion> exp2;


	public EAcceso(Expresion exp1, List<Expresion> exp2, KindAsig kind){
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.kind = kind;
		this.isModifiable = true;

	}

	@Override
	public String toString(){
		return "(POSICION (" + exp1.toString() + ", " + exp2.toString() + "))"; 
	}

	@Override
	public void binding(){
		exp1.binding();
		for(Expresion e: exp2){
			e.binding();
		}
	}

	@Override
	public void checkType(){
		exp1.checkType();
		Tipo tipo1 = exp1.getTipo();
		if (tipo1 == null){
			System.out.println("ERROR: fallo en puntero EACCESO" + this);
			Programa.setFin();
		}
		else{
			if (!(tipo1 instanceof TipoArray || tipo1 instanceof ListPuntero)){
				System.out.println("ERROR: fallo en tipo EACCESO" + this);
					Programa.setFin();
			}	
			else{
				if (tipo1 instanceof TipoArray){
				TipoArray tipoA = (TipoArray) tipo1; 
				setTipo(tipoA.getTipoBasico());
				if(tipoA.getTamanyos().size() != exp2.size()){
					System.out.println("ERROR: fallo en tipo EACCESO" + this);
					Programa.setFin();
				}
				}
				else{
				ListPuntero tipoA = (ListPuntero) tipo1; 
				setTipo(tipoA.getTipoBasico());
				if(tipoA.getTamanyos().size() != exp2.size()){
					System.out.println("ERROR: fallo en tipo EACCESO" + this);
					Programa.setFin();
				}
				}
				for (Expresion e: exp2){
					e.checkType();
					if (!e.getTipo().equals(new TiposBasicos(KindTipo.NUM))){	
						System.out.println("ERROR: fallo en tipo EACCESO" + this);
						Programa.setFin();
					}
				}

			}
		}

	}

	public void calcularDirRelativa(){

		comprobarRangos();

		exp1.calcularDirRelativa();
		List<Ent> listTamanyos = exp1.getTipo().getTamanyos();
		int total = exp1.getTipo().getNumElems();
		for(int i = 0 ; i < listTamanyos.size(); i++){

			total = total / listTamanyos.get(i).getInt();
			Programa.codigo.println("\ti32.const " + total);
			exp2.get(i).generaCodigo();
			Programa.codigo.println("\ti32.const 1");
			Programa.codigo.println("\ti32.sub");
			Programa.codigo.println("\ti32.mul");
			Programa.codigo.println("\ti32.const " + exp1.getTipo().getTipoBasico().getTam());
			Programa.codigo.println("\ti32.mul");
			Programa.codigo.println("\ti32.add");
		}

		
	}

	public void comprobarRangos(){
		List<Ent> listTamanyos = exp1.getTipo().getTamanyos();
		for(int i = 0 ; i < listTamanyos.size(); i++){
			exp2.get(i).generaCodigo();
			Programa.codigo.println("\ti32.const " + listTamanyos.get(i).getInt());
			Programa.codigo.println("\ti32.gt_s");
			Programa.codigo.println("\tif");
			Programa.codigo.println("\ti32.const 1");
			Programa.codigo.println("\tcall $exception");
			Programa.codigo.println("\tend");
			exp2.get(i).generaCodigo();
			Programa.codigo.println("\ti32.const 1");
			Programa.codigo.println("\ti32.lt_s");
			Programa.codigo.println("\tif");
			Programa.codigo.println("\ti32.const 2");
			Programa.codigo.println("\tcall $exception");
			Programa.codigo.println("\tend");

		}

	}

	public void generaCodigo(){
		calcularDirRelativa();
		Programa.codigo.println("\t" + exp1.getTipo().getTipoBasico().convertWasm() + ".load");
	}

	
}

