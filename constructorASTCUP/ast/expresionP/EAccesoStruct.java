package ast.expresionP;

import ast.lineaP.KindAsig;
import ast.tiposP.Tipo;
import ast.tiposP.TipoArray;
import ast.Programa;
import ast.ASTNode;
import ast.lineaP.Registro;
import java.util.List;

public class EAccesoStruct extends Expresion{
	private Expresion exp1;
	private Expresion exp2;


	public EAccesoStruct(Expresion exp1, Expresion exp2, KindAsig kind){
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.kind = kind;
		this.isModifiable = true;
	}

	@Override
	public String toString(){
		return "(ACCESO (" + exp1.toString() + ", " + exp2.toString() + "))"; 
	}

	@Override
	public void binding(){
		exp1.binding();
	}

	@Override
	public void checkType(){
		exp1.checkType();

		Tipo t = exp1.getTipo();
				
		if (t == null){
			System.out.println("ERROR: fallo en struct EBIN" + this);
			Programa.setFin();
		}
		else{
			Registro node = (Registro) t.getLink();
			Tipo tipoCampo = node.getTipoCampo(exp2.getName());
			if (tipoCampo == null){
				System.out.println("ERROR: fallo en tipo EBIN" + this);
				Programa.setFin();
			}	
			else{
				setTipo(tipoCampo);
			}
		}

	}

	public void generaCodigo(){
		calcularDirRelativa();
		Programa.codigo.println("\t" + exp1.getTipo().convertWasm() + ".load");
	}

	public void calcularDirRelativa(){
		exp1.calcularDirRelativa();
		Registro node = (Registro) exp1.getTipo().getLink();
		int deltaCampo = node.getDeltaCampo(exp2.getName());
		Programa.codigo.println("\ti32.const " + deltaCampo);
		Programa.codigo.println("\ti32.add");

	}
}