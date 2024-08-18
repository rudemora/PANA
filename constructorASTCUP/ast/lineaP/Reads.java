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


public class Reads extends Llamada{
	private String idenFun;
	private boolean asigned;

	public Reads(String iden, Tipo tipo){
		this.idenFun = iden;
		this.tipo = tipo;
		this.asigned = false;
	}

	@Override
	public String toString(){
		return 	"(CALL (" + idenFun + ", " + "[]))";	
	}

	@Override
	public void binding(){
		ASTNode node = Programa.searchId(idenFun);
		if (node != null){
			this.link = node;
		}
		else{
			System.out.println("ERROR: funcion " + idenFun + " no declarada READS");
			Programa.setFin();
		}

	}

	public String getName(){
		return idenFun;
	}

	@Override
	public void checkType(){
	}

	public void generaCodigo(){//TODO print decimales
		Programa.codigo.println("\tcall $read" + link.getTipo().convertWasm());
		
	}

	public void setAsigned(){
		this.asigned = true;
	}
	
}