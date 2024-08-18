package ast.tiposP;

public class TiposBasicos extends Tipo {
	private KindTipo tipo;

	public TiposBasicos(KindTipo tipo){
		this.tipo = tipo;
	}	

	public String toString(){
		return tipo.toString();
	}

	public int getTam(){
		int tam = 0;
		switch(tipo){
			case KindTipo.NUM:
			case KindTipo.RIAL:
			case KindTipo.BOOL:
				tam = 4;
				break;
		}
		return tam;
	}
}

