package ast.lineaP;

import java.util.List;
import java.util.ArrayList;

import ast.lineaP.funcionP.Argumento;

import ast.expresionP.Bool;
import ast.expresionP.Real;
import ast.expresionP.Ent;
import ast.expresionP.Unitario;
import ast.expresionP.Expresion;
import ast.tiposP.TipoArray;
import ast.ASTNode;
import ast.Programa;
import ast.tiposP.Tipo;
import ast.tiposP.TiposBasicos;
import ast.tiposP.KindTipo;


public class Writes extends Llamada{
	private String idenFun;
	private Expresion arg;
	private boolean asigned;

	public Writes(String iden, Tipo tipo, Expresion arg){
		this.idenFun = iden;
		this.tipo = tipo;
		this.arg = arg;
		this.asigned = false;
	}

	@Override
	public String toString(){
		return 	"(CALL (" + idenFun + ", [" + arg.toString() + "]))";	
	}

	@Override
	public void binding(){
		ASTNode node = Programa.searchId(idenFun);
		if (node != null){
			this.link = node;
		}
		else{
			System.out.println("ERROR: funcion " + idenFun + " no declarada WRITES");
			Programa.setFin();
		}
		arg.binding(); 
	}

	public String getName(){
		return idenFun;
	}

	@Override
	public void checkType(){
		arg.checkType();
		if (!arg.getTipo().equals(tipo)){
			System.out.println("ERROR en tipado Writes");
			Programa.setFin();
		}
	}

	public void generaCodigo(){//TODO print decimales
		arg.generaCodigo();
		Programa.codigo.println("\tcall $print" + tipo.convertWasm());
		
	}

	public void setAsigned(){
		this.asigned = true;
	}
	
}