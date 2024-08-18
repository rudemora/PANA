package ast.lineaP;

import ast.lineaP.Declaracion;
import ast.tiposP.Tipo;
import ast.tiposP.TipoArray;

import ast.tiposP.TiposBasicos;
import ast.tiposP.KindTipo;
import ast.tiposP.TipoNombre;
import ast.tiposP.TipoPuntero;


import ast.expresionP.Expresion;
import ast.expresionP.ExpreLlave;
import ast.expresionP.ExpreCorch;
import ast.expresionP.ExpLlamada;
import ast.expresionP.Dinamica;

import ast.Programa;
import ast.ASTNode;

public class Creacion extends Declaracion{
	//private Tipo tipo;
	private String name;
	private Expresion exp;
	private boolean global = false;	
	private int deltaReg = -1;

	public Creacion(){
	}

	public Creacion(Tipo tipo, String name){
		this.tipo = tipo;
		this.name = name;	
	}

	public Creacion(Tipo tipo, String name, Expresion exp){
		this.tipo = tipo;
		this.name = name;
		this.exp = exp;	
		
	}

	@Override
	public String toString(){
		if (exp == null){
			return "(" + tipo.toString() + " " + name.toString() + ")";
		}
			return  "(ASIG ((" + tipo.toString() + " " + name.toString() + "), " + exp.toString() + "))";
		
	}

	@Override
	public void binding(){
		tipo.binding();
		ASTNode node = Programa.searchIdLastFun(name);
		if (node == null){
			if(Programa.getSize() == 1){
				global = true;
			}
			Programa.insertar(name, this);
		}
		else{
			System.out.println("ERROR: identificador en CREACION " + name + " no se puede utilizar en " + this);
			Programa.setFin();
		}
		if (exp != null){
			exp.binding();
		}
		
	}
	@Override 
	public void checkType(){
		this.tipo = tipo.reduceAlias();
		if (exp != null){
			exp.checkType();
			Tipo tipoExp = exp.getTipo();
			if(tipo instanceof TipoArray){				
				TipoArray aux = (TipoArray) tipo;
				exp.setSize(aux.getTamanyos());
				tipoExp = exp.getTipo();

			}
			if (tipo == null || !(tipo.equals(tipoExp))){
				System.out.println("ERROR: mal tipado en CREACION " + this);
				Programa.setFin();
			}
		}
	}
		

	public String getName(){
		return name;
	}

	public Tipo getTipo(){
		return tipo;
	}

	public void generaCodigo(){
		if(exp != null){
	
			if(!(exp.getModifiable())){//TODO EXPMOD

				if (exp.getKind().equals(KindAsig.LLAVE)|| exp.getKind().equals(KindAsig.CORCH)){
					calcularDirRelativa();
					exp.generaCodigo();
				}	
				else{

					calcularDirRelativa();

					exp.generaCodigo();

					Programa.codigo.println("\t" + exp.getTipo().convertWasm() + ".store");

				}

			}
			else {

				if (exp.getKind().equals(KindAsig.LLAMADA)){
					if (exp.getTipo() instanceof TiposBasicos){
						calcularDirRelativa();
						exp.generaCodigo();
						Programa.codigo.println("\t" + exp.getTipo().convertWasm() + ".store");
					}
					else{
						exp.generaCodigo();
						calcularDirRelativa();
						Programa.codigo.println("\ti32.const "  + (tipo.getTam()/4));
						Programa.codigo.println("\tcall $copyn");
					}

				}
				else{
					System.out.println("aedaw");
					exp.calcularDirRelativa();
					calcularDirRelativa();	
					Programa.codigo.println("\ti32.const "  + (tipo.getTam()/4));
					Programa.codigo.println("\tcall $copyn");
				}	
			}
			
		}
		else if (tipo instanceof TipoNombre){ //REG

			TipoNombre tipoN = (TipoNombre) this.getTipo();
			Registro registro = (Registro) tipoN.getLink();
			registro.calcularDirRelativa();
			calcularDirRelativa();
			Programa.codigo.println("\ti32.const " + getTamanyo()/4);
			Programa.codigo.println("\tcall $copyn");
		}
		else if (tipo instanceof TipoArray && tipo.getTipoBasico() instanceof TipoNombre){ //ARRAY DE REGS
			TipoNombre tipoN = (TipoNombre) this.getTipo().getTipoBasico();
			Registro registro = (Registro) tipoN.getLink();
			for(int i = 0; i < this.getTipo().getNumElems(); i++){
				registro.calcularDirRelativa();
				calcularDirRelativa();
				Programa.codigo.println("\ti32.const " + getTamanyo()*i);
				Programa.codigo.println("\ti32.add");
				Programa.codigo.println("\ti32.const " + getTamanyo()/4);
				Programa.codigo.println("\tcall $copyn");
			}
		}

	}

	public void calcularDirRelativa(){
		if (deltaReg != -1){
			if (global){
				Programa.codigo.println("\ti32.const " + (deltaReg + delta + 4));
			}
			else{
				Programa.codigo.println("\ti32.const " + (deltaReg + delta));
				Programa.codigo.println("\tlocal.get $localsStart");
        			Programa.codigo.println("\ti32.add");
			}
		}
		else if (global){
			Programa.codigo.println("\ti32.const " + (delta + 4));
		}
		else{
			Programa.codigo.println("\ti32.const " + delta);
        		Programa.codigo.println("\tlocal.get $localsStart");
        		Programa.codigo.println("\ti32.add");


		}
	}

	@Override
	public void setPos(){
		setDelta();
	}

	public boolean getGlobal(){
		return global;
	}

	public void setDeltaReg(int delta){
		this.deltaReg = delta;
	}
	
}