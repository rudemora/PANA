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


public class Llamada extends Instruccion{
	private String idenFun;
	private List<Expresion> largs;

	private boolean asigned;

	public Llamada(){

	}

	public Llamada(String iden, List<Expresion> largs){
		this.idenFun = iden;
		this.largs = largs;
		this.asigned = false;
	}

	public Llamada(String iden, Expresion exp){
		this.idenFun = iden;
		this.largs = new ArrayList<Expresion>();
		this.largs.add(exp);
		this.asigned = false;
	}

	@Override
	public String toString(){
		return 	"(CALL (" + idenFun + ", " + largs.toString() + "))";	
	}

	@Override
	public void binding(){
		ASTNode node = Programa.searchId(idenFun);
		if (node != null){
			this.link = node;
		}
		else{
			System.out.println("ERROR: funcion " + idenFun + " no declarada LLAMADA");
			Programa.setFin();
		}
		if (largs != null){
			for(Expresion arg: largs){
				arg.binding(); 
			}
		}
	}

	public String getName(){
		return idenFun;
	}

	@Override
	public void checkType(){
		if (!(this.getLink() instanceof Funcion)){
			System.out.println("ERROR en Llamada " + this);
			Programa.setFin();
		}
		else{	Funcion fun = (Funcion) this.getLink();
			List<Argumento> listFunArgs = fun.getArgs();
			if (listFunArgs.size() != largs.size()){

				System.out.println("ERROR en Llamada " + this);
				Programa.setFin();
			}
			else{

				for(int i = 0; i < listFunArgs.size(); i++){
					largs.get(i).checkType();
					Argumento argu = listFunArgs.get(i);
					if (!(largs.get(i).getTipo().equals(argu.getTipo()))){

						System.out.println("ERROR en Llamada " + this);
						Programa.setFin();
					}

					if (argu.getRef() == 1){//ref	
						if (!(largs.get(i).getModifiable())){ //TODO EXPMOD
							System.out.println("ERROR en Llamada " + this);
							Programa.setFin();
						}
					}
					
				}
			}
		} 
	}

	public void generaCodigo(){
		
		int delta = 0;
		Funcion fun = (Funcion) this.getLink();
		List<Argumento> listFunArgs = fun.getArgs();
		int pos = 0;
		for(Expresion exp : largs){
			delta += exp.getTipo().getTam();
			if (!(exp.getModifiable())){
				Programa.codigo.println("\tglobal.get $SP");
				Programa.codigo.println("\ti32.const " + delta);
				Programa.codigo.println("\ti32.add");
				exp.generaCodigo();

				Programa.codigo.println("\t" + exp.getTipo().convertWasm() + ".store");

			}
			else{
				if (listFunArgs.get(pos).getRef() == 0){
					exp.calcularDirRelativa();
					Programa.codigo.println("\tglobal.get $SP");
					Programa.codigo.println("\ti32.const " + listFunArgs.get(pos).getDelta() + 4);
					Programa.codigo.println("\ti32.add");
					Programa.codigo.println("\ti32.const " + (exp.getTipo().getTam()/4));
					Programa.codigo.println("\tcall $copyn");
					
				}
				else{
					Programa.codigo.println("\tglobal.get $SP");
					delta -= exp.getTipo().getTam();
					delta += 4;
					Programa.codigo.println("\ti32.const " + listFunArgs.get(pos).getDelta() + 4);
					Programa.codigo.println("\ti32.add");
					exp.calcularDirRelativa();
					Programa.codigo.println("\t" + exp.getTipo().convertWasm() + ".store");

				}
			}			
			pos += 1;
		}
		Programa.codigo.println("\tcall $" + idenFun);
		if(!this.asigned && (!(this.link.getTipo().equals(new TiposBasicos(KindTipo.VOID))))){
			Programa.codigo.println("\tdrop");
		}
		else if (!(this.link.getTipo().equals(new TiposBasicos(KindTipo.VOID)))){
			Programa.codigo.println("\t" + getLink().getTipo().convertWasm() + ".load");

		}

	}

	public void setAsigned(){
		this.asigned = true;
	}
	
}