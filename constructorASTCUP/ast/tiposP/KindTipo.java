package ast.tiposP;

public enum KindTipo{
	NUM("NUM"), BOOL("BOOL"), RIAL("RIAL"), VOID("VOID");

	private final String nombre;

	private KindTipo(String nombre){
		this.nombre = nombre;
	}

	@Override
	public String toString(){
		return nombre;
	}


	
}