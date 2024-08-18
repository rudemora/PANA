package ast.tiposP;

import ast.ASTNode;
import ast.NodeKind;

import ast.expresionP.Ent;
import java.util.List;

public abstract class Tipo extends ASTNode{

	public abstract String toString();
	
	@Override
	public NodeKind nodeKind(){
		return NodeKind.TIPO;
	}

	public String getName(){
		return "";
	} 
	
	public void checkType(){
	}

	@Override
	public boolean equals(Object o){
		if (this == null || o == null){
			return false;
		}
		if (o.toString().equals(this.toString())){
			return true;
		}
		return false;
	}

	@Override
	public void binding(){

	}

	public ASTNode getLink(){
		return this.link;
	}

	public abstract int getTam();

	public String convertWasm(){
		if (this.equals(new TiposBasicos(KindTipo.RIAL))){
			return "f32";
		}
		return "i32";
	}

	public int getNumElems(){
		return 0;
	}
	public Tipo getTipoBasico(){
		return this;
	}

	public List<Ent> getTamanyos(){
		return null;
	}

	public Tipo reduceAlias(){
		return this;
	}

}