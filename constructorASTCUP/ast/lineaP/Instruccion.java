package ast.lineaP;

import ast.ASTNode;
import ast.NodeKind;

public abstract class Instruccion extends ASTNode{

	public abstract String toString();
	

	@Override
	public NodeKind nodeKind(){
		return NodeKind.INSTRUCCION;
	}

	
	public abstract void binding();
	public abstract void checkType();
	
	public String getName(){
		return "";
	}

	public void generaCodigo(){
	}

	public int maxMemory(){
		return 0;
	}

}