package ast.expresionP;

import ast.ASTNode;
import ast.NodeKind;

import ast.lineaP.KindAsig;

import ast.expresionP.Ent;
import java.util.List;


public abstract class Expresion extends ASTNode {
	public boolean isModifiable = false;
        public KindAsig kind;

	public abstract String toString();

	@Override
	public NodeKind nodeKind(){
		return NodeKind.EXPRESION;
	}

	
	
	public String getName(){
		return "";
	}
	
	
	public abstract void binding();
	public abstract void checkType();

	public void setSize(List<Ent> tamanyos){

	}

	public boolean checkModifiable(){
		return true;
	}

	public void generaCodigo(){

	}

	public void calcularDirRelativa(){

	}

	public KindAsig getKind(){
		return kind;
	}

	public boolean getModifiable(){
		return isModifiable;
	}	
}