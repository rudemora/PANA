package ast.lineaP;

import ast.expresionP.Expresion;
import ast.expresionP.ExpreLlave;
import ast.expresionP.ExpreCorch;
import ast.expresionP.EUn;
import ast.expresionP.ExpLlamada;


import ast.tiposP.Tipo;
import ast.tiposP.TiposBasicos;
import ast.tiposP.KindTipo;
import ast.tiposP.TipoArray;

import ast.Programa;


public class Asignacion extends Declaracion{
	private Expresion exp1;
	private Expresion exp2;
	private KindAsig tipoAsig; 

	public Asignacion(Expresion exp1, Expresion exp2, KindAsig tipoAsig){
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.tipoAsig = tipoAsig;
	}

	@Override
	public String toString(){
		return "(" + tipoAsig.toString() + " (" + exp1.toString() + ", " + exp2.toString() + "))";
	}

	@Override
	public void binding(){
		exp1.binding();
		exp2.binding();
	}
	
	@Override 
	public void checkType(){
		exp1.checkType();
		if(!(exp1.getModifiable()) || (exp1.getKind().equals(KindAsig.LLAMADA))){
			System.out.println("ERROR: expresion no modificable en ASIGNACION " + this);
			Programa.setFin();
			
		}
		else{
		exp2.checkType();
		Tipo tipo1 = exp1.getTipo();
		Tipo tipo2 = exp2.getTipo();
		if(tipo1 instanceof TipoArray && (exp2.getKind().equals(KindAsig.CORCH)|| exp2.getKind().equals(KindAsig.LLAVE))){				
			TipoArray aux = (TipoArray) tipo1;
			exp2.setSize(aux.getTamanyos());
			tipo2 = exp2.getTipo();

		}
		if (tipo1 == null || tipo2 == null || !(tipo1.equals(tipo2))){
			System.out.println("ERROR: mal tipado en ASIGNACION " + this);
			Programa.setFin();
		}
		else{
		switch(tipoAsig){				
			case SUMAPREF:
			case RESTAPREF:
			case MULTIPREF:
			case DIVIPREF:
			if (!tipo1.equals("NUM") && !tipo2.equals("RIAL")){
					System.out.println("ERROR: fallo en tipo ASIGNACION" + this);
					Programa.setFin();
				}
				else{
					setTipo(tipo1);
				}
				break;
			case DIVENTPREF:
			case MODPREF:
				if (!tipo1.equals("NUM")){
					System.out.println("ERROR: fallo en tipo ASIGNACION" + this);
					Programa.setFin();
				}
				else{
					setTipo(tipo1);
				}
				break;
			default:
				setTipo(tipo2);
				break;

		}
		}
		}

		
	}


	public void generaCodigo(){
		if(!(exp2.getModifiable()) ){
			exp1.calcularDirRelativa();
			exp2.generaCodigo();
			Programa.codigo.println("\t" + exp2.getTipo().convertWasm() + ".store");
		}
		else{
		//EXPRESION EN MEMORIA
			if (exp2.getKind().equals(KindAsig.LLAMADA)){
				if (exp2.getTipo() instanceof TiposBasicos){
					exp1.calcularDirRelativa();
					exp2.generaCodigo();
					Programa.codigo.println("\t" + exp2.getTipo().convertWasm() + ".store");
				}
				else{
					exp2.generaCodigo();
					exp1.calcularDirRelativa();
					Programa.codigo.println("\ti32.const "  + (tipo.getTam()/4));
					Programa.codigo.println("\tcall $copyn");
				}
			}
			else{
				exp2.calcularDirRelativa();
				exp1.calcularDirRelativa();
				Programa.codigo.println("\ti32.const "  + (tipo.getTam()/4));
				Programa.codigo.println("\tcall $copyn");
			}

		}
		
	}

	public int getTamanyo(){
		return 0;
	}

}

