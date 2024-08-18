package ast.expresionP;

import ast.lineaP.Llamada;
import ast.lineaP.funcionP.Argumento;

import ast.Programa;
import ast.ASTNode;
import ast.lineaP.KindAsig;


import ast.tiposP.Tipo;

public class Unitario extends Expresion{
	private String iden;
	
	public Unitario(){
		this.isModifiable = true;
		this.kind = KindAsig.UNITARIO;
	}

	public Unitario(String iden){
		this.iden = iden;
		this.isModifiable = true;
		this.kind = KindAsig.UNITARIO;
	}


	@Override
	public String toString(){
		return iden;
	}

	@Override
	public void binding(){

			ASTNode node = Programa.searchId(iden);
			if (node != null){
				this.link = node;
			}
			else{	
				
				System.out.println("ERROR: identificador en UNITARIO " + iden + " no se puede utilizar en " + this);
				Programa.setFin();
			}

		
	}

	@Override
	public void checkType(){
		if (this.link != null){
			setTipo(this.link.getTipo());
		}
	

	}

	@Override
	public String getName(){
		return iden;
	}



	public void generaCodigo() {

		calcularDirRelativa();
		Programa.codigo.println("\t" + this.getTipo().convertWasm() + ".load");

		
	}

	public void calcularDirRelativa(){
		int dir = this.link.getDelta();
		if (this.link.getGlobal()){	
			dir += 4;
			Programa.codigo.println("\ti32.const " + dir);
		}
		else{
			if (this.link instanceof Argumento){

				Argumento arg = (Argumento) this.link;
				if (arg.getRef() == 1){
					Programa.codigo.println("\ti32.const " + dir);
					Programa.codigo.println("\tlocal.get $localsStart");
					Programa.codigo.println("\ti32.add");
					Programa.codigo.println("\ti32.load");

				}
				else{
					Programa.codigo.println("\ti32.const " + dir);
					Programa.codigo.println("\tlocal.get $localsStart");
        				Programa.codigo.println("\ti32.add");
				}

			}
			else{
				Programa.codigo.println("\ti32.const " + dir);
				Programa.codigo.println("\tlocal.get $localsStart");
        			Programa.codigo.println("\ti32.add");
			}

		}
		
	}

	
	
}


