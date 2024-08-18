package ast.expresionP;

import java.util.Arrays;
import java.util.List;

import ast.tiposP.TiposBasicos;
import ast.tiposP.KindTipo;
import ast.tiposP.Tipo;
import ast.Programa;
import ast.lineaP.KindAsig;


public class Real extends Constante{
	private float n;
	
	public Real(String num){
		List<String> iden = Arrays.asList(num.split(","));
		String numerin = iden.get(0) + "." + iden.get(1);
		this.n = Float.parseFloat(numerin);
		this.kind = KindAsig.REAL;
	}

	@Override	
	public String toString(){
		return "" + n;
	}
	
	@Override
	public void binding(){
	}

	public Tipo getTipo(){
		return new TiposBasicos(KindTipo.RIAL);
	}

	@Override
	public void checkType(){
		setTipo(getTipo());
	}

	public void generaCodigo(){
		Programa.codigo.println("\tf32.const " + n);
	}
	
}	