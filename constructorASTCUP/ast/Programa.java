package ast;


import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ast.lineaP.Instruccion;
import ast.tiposP.Tipo;

import ast.lineaP.funcionP.Argumento;
import ast.tiposP.KindTipo;
import ast.tiposP.TiposBasicos;
import ast.lineaP.Funcion;

import ast.lineaP.Asignacion;
import ast.lineaP.Creacion;
import ast.lineaP.Registro;


public class Programa extends ASTNode {
	private List<Instruccion> lgobs;
	
	public static PilaTablaSimbolos pila;//de momento no estatico
	//public static HashMap<String, HashMap<String, Tipo>> types;	


	private static int fin = 0;	

	private static int numMain = 0;

	public static PrintWriter codigo;

	public Programa(List<Instruccion> lgobs){
		this.lgobs = lgobs;
		this.pila = new PilaTablaSimbolos();
	}
	

	private void inicializarFunciones(){
		List<Argumento> largs = new ArrayList<Argumento>();
		largs.add(new Argumento(new TiposBasicos(KindTipo.NUM), "x", 0));
		pila.insertar("writeNum", new Funcion(new TiposBasicos(KindTipo.VOID), "writeNum", largs,new ArrayList<Instruccion>()));
		List<Argumento> largs1 = new ArrayList<Argumento>();
		largs1.add(new Argumento(new TiposBasicos(KindTipo.BOOL), "x", 0));
		pila.insertar("writeBool", new Funcion(new TiposBasicos(KindTipo.VOID), "writeBool", largs1, new ArrayList<Instruccion>()));
		List<Argumento> largs2 = new ArrayList<Argumento>();
		largs2.add(new Argumento(new TiposBasicos(KindTipo.RIAL), "x", 0));
		pila.insertar("writeRial", new Funcion(new TiposBasicos(KindTipo.VOID), "writeRial",largs2, new ArrayList<Instruccion>()));
		pila.insertar("readNum", new Funcion(new TiposBasicos(KindTipo.NUM), "readNum", new ArrayList<Argumento>(), new ArrayList<Instruccion>()));
		pila.insertar("readBool", new Funcion(new TiposBasicos(KindTipo.BOOL), "readBool", new ArrayList<Argumento>(),new ArrayList<Instruccion>()));
		pila.insertar("readRial", new Funcion(new TiposBasicos(KindTipo.RIAL), "readRial", new ArrayList<Argumento>(),new ArrayList<Instruccion>()));

	}

	public void binding(){
		pila.abrirBloque();
		inicializarFunciones();
		for (int i = 0; i < lgobs.size(); i++){
			lgobs.get(i).binding();
		}
		if (numMain == 0){
			System.out.println("ERROR no hay ningun main en PROGRAMA "); 
		}
		pila.print();
		pila.cerrarBloque();
	}

	public void checkType(){
		for(int i = 0; i < lgobs.size(); i++){
			lgobs.get(i).checkType();
		}
	}

	public static void insertar(String name, ASTNode node){
		pila.insertar(name, node);
	}

	public static void abrirBloque(){
		pila.abrirBloque();
	}

	public static void cerrarBloque(){
		pila.cerrarBloque();
	}

	public static ASTNode searchId(String name){
		return pila.searchId(name);
	}
	
	public static ASTNode searchIdLastFun(String name){
		return pila.searchIdLastFun(name);
	}

	public static void print(){
		pila.print();
	}	

	public static void printAll(){
		pila.printAll();
	}

	public String toString(){
		String s = "";
		for(int i = 0; i < lgobs.size(); i++){
			if (lgobs.get(i) == null){
				s += "null" + "\n";
			}
			else {
				s += lgobs.get(i).toString() + "\n";
			}
		}
		return "PROGRAMA\n" + s;
	}

	@Override
	public NodeKind nodeKind(){
		return NodeKind.PROGRAMA;
	}

	public int getFin(){
		return this.fin;
	}	

	public static void setFin(){
		fin = 1;
	}

	public static void addMain(){
		numMain += 1;
	}

	public String getName(){
		return "";
	}



	
	private void calcularDeltas(){
		for(Instruccion ins: lgobs){
			ins.setPos();
		}
	
	} 


	public void generaCodigo(){
		try{

		calcularDeltas();
		codigo = new PrintWriter(new FileWriter("codigo.wat"));
		FileReader inicio = new FileReader("generacion/inicio.wat");
		inicio.transferTo(codigo);
		//inicio.close();
		codigo.println("\ti32.const " + maxMemory());
		codigo.println("\tcall $reserveStack");
		codigo.println("\tlocal.set $temp");
		codigo.println("\tglobal.get $MP");
		codigo.println("\tlocal.get $temp");
		codigo.println("\ti32.store");
		codigo.println("\tglobal.get $MP");
		codigo.println("\ti32.const 4");
		codigo.println("\ti32.add");
		codigo.println("\tlocal.set $localsStart\n");
		Instruccion insMain = null;
		for(Instruccion ins : lgobs){
			if (ins instanceof Creacion || ins instanceof Asignacion){
				ins.generaCodigo();
			}
			else if (ins instanceof Funcion){
				Funcion fun = (Funcion) ins;
				if (fun.getName().equals("main")){
					insMain = ins;
				}
			}
			Programa.codigo.println("");
		}
		codigo.println("\tcall $main");
		codigo.println("\ti32.load");
		codigo.println("\tcall $printi32");
		codigo.println("\tcall $freeStack");
		codigo.println(")");
		insMain.generaCodigo();
		Programa.codigo.println("");
		for(Instruccion ins : lgobs){
			if (!(ins instanceof Creacion) && !(ins instanceof Asignacion) && !(ins.equals(insMain))){
				ins.generaCodigo();
				Programa.codigo.println("");
			}
		}
	
		inicio = new FileReader("generacion/final.wat");
		codigo.println("\n\n\n ;;FUNCIONES DEFINIDAS");
		inicio.transferTo(codigo);
		inicio.close();
          	codigo.close();
		} catch(Exception e){
			Programa.setFin();
			
		}
	}

	public static int getSize(){
		return pila.getSize();
	}

	public void updateDelta(int tam){
		pila.updateDelta(tam);
	}

	public int maxMemory(){
		int max = 0;
		for(Instruccion ins : lgobs){
			if(ins instanceof Creacion || ins instanceof Registro){
				max += ins.getTamanyo();
			}
		}
		return max + 4;
		
	}

}