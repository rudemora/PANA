package ast.expresionP;

import ast.lineaP.Llamada;
import ast.lineaP.funcionP.Argumento;

import ast.lineaP.KindAsig;

import ast.Programa;
import ast.ASTNode;



import ast.tiposP.Tipo;

public class ExpLlamada extends Expresion{
	private String iden;
	private Llamada call;
	

	public ExpLlamada(Llamada call){
		this.iden = call.getName();
		this.call = call;
		this.isModifiable = true;
		this.kind = KindAsig.LLAMADA;
	}

	@Override
	public String toString(){
		return call.toString();
		
	}

	@Override
	public void binding(){
			call.binding();
			this.link = call.getLink();
		
	}

	@Override
	public void checkType(){
		if (this.link != null){
	
			setTipo(this.link.getTipo());
		}
		call.checkType();
		

	}

	@Override
	public String getName(){
		return iden;
	}


	public void generaCodigo() {

		call.setAsigned();
		call.generaCodigo();
		
	}

	public void calcularDirRelativa(){
		int dir = this.link.getDelta();
		dir += 4;
		Programa.codigo.println("\ti32.const " + dir);
			
	}

	
	
}


