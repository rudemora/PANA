package ast.lineaP.funcionP;

import ast.tiposP.Tipo;
import ast.tiposP.TipoNombre;

import ast.Programa;
import ast.ASTNode;
import ast.NodeKind;

public class Argumento extends ASTNode{
	private Tipo tipo;
	private String name;
	private int ref;//1 ref, 0 no ref

	public Argumento(Tipo tipo, String name, int ref){
		this.tipo = tipo;
		this.name = name;
		this.ref = ref;
		
	}

	@Override
	public String toString(){
		if (ref == 0){
			return "(" + tipo.toString() + " " + name + ")";
		}
		else{
			return "(" + tipo.toString() + " REF " + name + ")";
		}
	}

	@Override
	public NodeKind nodeKind(){
		return NodeKind.ARGUMENTO;
	}

	@Override
	public void binding(){
		ASTNode node = Programa.searchIdLastFun(name);
		if (node == null){
			tipo.binding();
			
			Programa.insertar(name, this);
			
		}
		else{
			System.out.println("ERROR: identificador ARG" + name + " no se puede utilizar en " + this);
			Programa.setFin();
		}
	}

	public String getName(){
		return "";
	} 
	
	public void checkType(){
		this.tipo = tipo.reduceAlias();
	}
	
	public int getRef(){
		return this.ref;
	}

	public Tipo getTipo(){
		return this.tipo;
	}

	public int getTam(){
		if (ref == 0){
			return tipo.getTam();
		}
		return 4;
	}


}	