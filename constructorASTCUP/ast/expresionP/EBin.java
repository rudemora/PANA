package ast.expresionP;

import ast.lineaP.KindAsig;
import ast.ASTNode;
import ast.Programa;
import ast.tiposP.Tipo;
import ast.lineaP.Registro;

import ast.tiposP.KindTipo;
import ast.tiposP.TiposBasicos;

public class EBin extends Expresion {
	private Expresion exp1;
	private Expresion exp2;


	public EBin(Expresion exp1, Expresion exp2, KindAsig kind){
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.kind = kind;
	}

	@Override
	public String toString(){
		return "(" + kind.toString() + " (" + exp1.toString() + ", " + exp2.toString() + "))"; 
	}

	@Override
	public void binding(){
		exp1.binding();
		if (!kind.equals(KindAsig.ACCESO)){
			exp2.binding();
		}
	}
	
	@Override
	public void checkType(){
		exp1.checkType();
		exp2.checkType();
		setTipo(exp2.getTipo());
		switch(kind){				
			case POR: 
			case MAS: 
			case MENOS:
			case DIV:
				if (!(exp1.getTipo().equals(exp2.getTipo()) && (exp1.getTipo().equals("NUM") || exp1.getTipo().equals("RIAL")))){
					System.out.println("ERROR: fallo en tipo EBIN" + this);
					Programa.setFin();
				}
				break;
			case MOD:
				if (!(exp1.getTipo().equals(exp2.getTipo()) && exp1.getTipo().equals("NUM"))){
					System.out.println("ERROR: fallo en tipo EBIN" + this);
					Programa.setFin();
				}
				break;
			case MAYORIG:
			case MENORIG:
			case MAYOR:
			case MENOR:
				if (!(exp1.getTipo().equals(exp2.getTipo()) && !exp1.getTipo().equals("BOOL"))){
					System.out.println("ERROR: fallo en tipo EBIN" + this);
					Programa.setFin();
				}
				setTipo(new TiposBasicos(KindTipo.BOOL));
				break;
			case IGUALIG:
			case DISTINTO:
				if (!(exp1.getTipo().equals(exp2.getTipo()))){
					System.out.println("ERROR: fallo en tipo EBIN" + this);
					Programa.setFin();
				}
				setTipo(new TiposBasicos(KindTipo.BOOL));

				break;
			case AND:
			case OR:
				if (!(exp1.getTipo().equals(exp2.getTipo()) && exp1.getTipo().equals("BOOL"))){
					System.out.println("ERROR: fallo en tipo EBIN" + this);
					Programa.setFin();
				}
				break;
			default:
				break;
			
		}
	}

  public void generaCodigo() {
    exp1.generaCodigo();
    exp2.generaCodigo();
    switch (kind) {
      case MAS:
	Programa.codigo.println("\t" + exp1.getTipo().convertWasm() + ".add");
        break;
      case MENOS:
	Programa.codigo.println("\t" + exp1.getTipo().convertWasm() + ".sub");
        break;
      case POR:
	Programa.codigo.println("\t" + exp1.getTipo().convertWasm() + ".mul");
        break;
      case DIV:
	if(exp1.getTipo().equals(new TiposBasicos(KindTipo.RIAL))){
		Programa.codigo.println("\tf32.div");

	}
	else{
		Programa.codigo.println("\ti32.div_s");
	}
        break;
      case DIVENT:
        Programa.codigo.println("\ti32.div_s");
        break;
      case MOD:
        Programa.codigo.println("\ti32.rem_s");
        break;
      case MENOR:
        if (exp1.getTipo().equals(new TiposBasicos(KindTipo.RIAL))){
		Programa.codigo.println("\tf32.lt");
	}
	else{
        Programa.codigo.println("\ti32.lt_s");
	}
        break;
      case MAYOR:
        if (exp1.getTipo().equals(new TiposBasicos(KindTipo.RIAL))){
		Programa.codigo.println("\tf32.gt");
	}
	else{
        Programa.codigo.println("\ti32.gt_s");
	}
        break;
      case AND:
        Programa.codigo.println("\ti32.and");
        break;
      case OR:
        Programa.codigo.println("\ti32.or");
        break;
      case IGUALIG:
	Programa.codigo.println("\t" + exp1.getTipo().convertWasm() + ".eq");
        break;
      case DISTINTO:
	Programa.codigo.println("\t" + exp1.getTipo().convertWasm() + ".ne");
        break;
      case MAYORIG:
        if (exp1.getTipo().equals(new TiposBasicos(KindTipo.RIAL))){
		Programa.codigo.println("\tf32.ge");
	}
	else{
        Programa.codigo.println("\ti32.ge_s");
	}
        break;
      case MENORIG:
        if (exp1.getTipo().equals(new TiposBasicos(KindTipo.RIAL))){
		Programa.codigo.println("\tf32.le");
	}
	else{
        Programa.codigo.println("\ti32.le_s");
	}
        break;
      default:
    }
  }

}