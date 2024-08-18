package ast.lineaP;

import java.util.List;

import ast.Programa;
import ast.ASTNode;
import ast.tiposP.Tipo;

public class Registro extends Creacion{
	
	private String iden;
	private List<Creacion> lcampos;
	private boolean global = false;

	public Registro(String iden, List<Creacion> lcampos, Creacion camp){
		this.iden = iden;
		this.lcampos = lcampos;
		this.lcampos.add(camp);
	}


	/*@Override
	public String getName(){
		return iden;
	}*/

	@Override
	public String toString(){
		return "(REG (" + iden + ", " + lcampos.toString() + "))";
	}

	@Override
	public void binding(){

		ASTNode node = Programa.searchId(iden);
		if (node == null){
			if(Programa.getSize() == 1){
				global = true;
			}
			Programa.insertar(iden, this);
			Programa.abrirBloque();
			for(Creacion camp : lcampos){	
				camp.binding();
			}
			Programa.cerrarBloque();
			
		}
		else{
			System.out.println("ERROR: identificador en REGISTRO " + iden + " no se puede utilizar en " + this);
			Programa.setFin();
		}
	} 

	@Override 
	public void checkType(){
		for(Creacion camp: lcampos){
			camp.checkType();
		}
	}

	public Tipo getTipoCampo(String name){
		for(Creacion camp : lcampos){
			if (camp.getName().equals(name)){
				return camp.getTipo();
			}
		}
		return null;
	}

	public int getDeltaCampo(String name){
		int sol = 0;
		for(Creacion camp : lcampos){
			if (camp.getName().equals(name)){
				sol = camp.getDelta();
				break;
			}
		}
		return sol;
	}

	@Override
	public void setPos(){
		int structDelta = 0;
		this.delta = Programa.pila.getDelta();
		for(Creacion camp : lcampos){
			
			camp.delta = structDelta;
			structDelta += camp.getTamanyo();
		}
		Programa.pila.updateDelta(getTamanyo());

	}
	public void setPos(int funDelta){
		int structDelta = 0;
		this.delta = funDelta;
		for(Creacion camp : lcampos){
			
			camp.delta = structDelta;
			structDelta += camp.getTamanyo();
		}
		Programa.pila.updateDelta(getTamanyo());

	}

	public int getTamanyo(){
		int sol = 0;
		for(Creacion cre : lcampos){
			sol += cre.getTamanyo();
		}
		return sol;
	}

	public void calcularDirRelativa(){
		if (global){
			Programa.codigo.println("\ti32.const " + (delta + 4));
		}
		else{
			Programa.codigo.println("\ti32.const " + delta);
        		Programa.codigo.println("\tlocal.get $localsStart");
        		Programa.codigo.println("\ti32.add");


		}

	}

	public void generaCodigo(){
		for(Creacion cre : lcampos){
			cre.setDeltaReg(delta);
			cre.generaCodigo();
		}
	}
	
	
}