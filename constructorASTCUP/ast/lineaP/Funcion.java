package ast.lineaP;

import ast.tiposP.Tipo;
import ast.lineaP.funcionP.Argumento;
import ast.expresionP.Expresion;

import ast.tiposP.TiposBasicos;
import ast.tiposP.KindTipo;

import ast.Programa;
import ast.ASTNode;

import java.util.List;
import java.util.ArrayList;

public class Funcion extends Instruccion {
	private String name;
	private Tipo tipo;
	private List<Argumento> largs;
	private List<Instruccion> decfun;
	private int numReturn;


	public Funcion(Tipo type, String name, List<Argumento> largs, List<Instruccion> decfun){
		this.name = name;
		this.tipo = type;
		this.largs = largs;
		this.decfun = decfun;
		this.numReturn = 0;
		Programa.addMain();
	}
	
	@Override
	public String toString(){
		String s = "";
		for(int i = 0; i < decfun.size();i++){
			if (decfun.get(i) == null){
				s += "\n\tnull";
			}
			else {
				s += "\n\t" + decfun.get(i).toString();
			}
		}
		return "(" + tipo.toString() + " FUN " + name.toString() + " (" + largs.toString() + ", " + s + ")\n)";
	}

	@Override
	public void binding(){
		ASTNode node = Programa.searchId(name);
			tipo.binding();
		if (node == null){
			Programa.insertar(name, this);
			Programa.abrirBloque();
			for(Argumento arg: largs){
				arg.binding();
			}
			for(Instruccion ins: decfun){
				if (ins instanceof Return){
					numReturn += 1;
					if (numReturn > 1 || (tipo.equals(new TiposBasicos(KindTipo.VOID)))){
						System.out.println("ERROR sobran returns en FUNCION " +this.name);
						Programa.setFin();
					}
					else{
						ins.setLink(this);
					}	
				}
				ins.binding();

			}
			if (numReturn == 0 && !tipo.equals(new TiposBasicos(KindTipo.VOID))){
				System.out.println("ERROR falta return en FUNCION " +this.name);
				Programa.setFin();

			}
			Programa.print();
			Programa.cerrarBloque();
		}
		else{
			System.out.println("ERROR: identificador en FUNCION " + name + " no se puede utilizar en " + this);
			Programa.setFin();
		}

	}

	@Override
	public void checkType(){
		this.tipo = tipo.reduceAlias();
		for(Argumento arg: largs){
			arg.checkType();
		}
		for(Instruccion ins: decfun){
			ins.checkType();
		}
	}

	public List<Argumento> getArgs(){
		return this.largs;
	}

	public Tipo getTipo(){
		return this.tipo;
	}

	public void generaCodigo(){

		int tam = maxMemory() + 4;

        	Programa.codigo.print("(func $" + name);
        	if (! tipo.equals(new TiposBasicos(KindTipo.VOID))){
			tam += 4;
           		Programa.codigo.print(" (result i32)");
        	}
       		Programa.codigo.println("");
        	Programa.codigo.println("\t(local $localsStart i32)");
        	Programa.codigo.println("\t(local $temp i32)");
        	Programa.codigo.println("\ti32.const " + tam); //  ;; let this be the stack size needed (params+locals+2)*4");
        	Programa.codigo.println("\tcall $reserveStack"); // ;; returns old MP (dynamic link)");
        
        	Programa.codigo.println("\tlocal.set $temp");
        	Programa.codigo.println("\tglobal.get $MP");
        	Programa.codigo.println("\tlocal.get $temp");
        	Programa.codigo.println("\ti32.store"); // Guardo el MP antiguo en mp
        	Programa.codigo.println("\tglobal.get $MP");
        	Programa.codigo.println("\ti32.const 4"); // salto el mp antiguo y el sp
        	Programa.codigo.println("\ti32.add");
        	Programa.codigo.println("\tlocal.set $localsStart\n"); // La funcion empieza aqui
        	for (Instruccion instruccion: decfun){

		    instruccion.generaCodigo(); 
		    if (instruccion instanceof Return){
			break;
		    }
		    Programa.codigo.println("");

        	}
		if (tipo.equals(new TiposBasicos(KindTipo.VOID))){
			Programa.codigo.println("call $freeStack");
		}
		Programa.codigo.println(")");

	}

	@Override
	public void setPos(){
		int funDelta = 0;
		this.delta = 0;
		for(Argumento arg : largs){
			arg.delta = funDelta;
			funDelta += arg.getTam();
		}
		for(Instruccion ins : decfun){
			ins.delta = funDelta;
			ins.setPos(funDelta);
			funDelta += ins.getTamanyo();
		}
		

	}

	public String getName(){
		return name;
	}

	public int maxMemory(){
		int max = 0;
		int c = 0;

		for(Argumento arg : largs){
			c += arg.getTam();
			max += arg.getTam();
		}
		for(Instruccion ins : decfun){
			if(ins instanceof Creacion){
				c += ins.getTamanyo();
				max += ins.getTamanyo();
			}
			else if(ins.isBlock()){
				int max1 = ins.maxMemory();
				if(c+max1 > max){
					max = c + max1;
				}
			}
		}


		return max;
	} 

	public boolean isBlock(){
		return true;
	}

}