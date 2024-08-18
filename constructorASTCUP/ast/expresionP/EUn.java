package ast.expresionP;

import ast.lineaP.KindAsig;
import ast.tiposP.Tipo;
import ast.tiposP.TipoPuntero;
import ast.tiposP.TipoArray;

import ast.tiposP.KindTipo;
import ast.tiposP.TiposBasicos;

import ast.tiposP.ListPuntero;

import ast.Programa;
import ast.ASTNode;

public class EUn extends Expresion {
	private Expresion exp;


	public EUn(Expresion exp, KindAsig kind){
		this.exp = exp;
		this.kind = kind;
	}

	@Override
	public String toString(){
		return "(" + kind.toString() + " (" + exp.toString() + "))";
	}

	@Override
	public void binding(){
		exp.binding();
	}

	@Override
	public void checkType(){
		exp.checkType();
		Tipo t = exp.getTipo();

		switch(kind){				
			/*case POINTER: 	

				if (t == null){
					System.out.println("ERROR: fallo en puntero EUN" + this);
					Programa.setFin();
				}
				else{
					if (!(t instanceof TipoPuntero || t instanceof ListPuntero)){
						System.out.println("ERROR: fallo en tipo EUN" + this);
						Programa.setFin();
					}	
					else{
						if(t instanceof TipoPuntero){
							TipoPuntero tipoP = (TipoPuntero) t;
							setTipo(tipoP.getTipoBasico());

						}
						else{
							ListPuntero tipoP = (ListPuntero) t;
							setTipo(new TipoArray(tipoP.getTipoBasico(), tipoP.getTamanyos()));

						}

					}
				}

				break;*/
			case DOLLAR: 		
				if (t == null){
					System.out.println("ERROR: fallo en puntero EUN" + this);
					Programa.setFin();
				}
				else{
					setTipo(new TipoPuntero(t));	
				}

				break;


			case EXCLAM:
				if (!(t.equals("BOOL"))){
					System.out.println("ERROR: fallo en tipo EUN" + this);
					Programa.setFin();
				}
				else{
					setTipo(exp.getTipo());
				}
				break;

			case PARE:
				setTipo(t);
				break;
			case TOFLOAT:
				if (!(t.equals("NUM"))){
					System.out.println("ERROR: fallo en tipo EUN" + this);
					Programa.setFin();
				}
				else{
					setTipo(new TiposBasicos(KindTipo.RIAL));
				}
				break;
			case TOINT:
				if (!(t.equals("RIAL"))){
					System.out.println("ERROR: fallo en tipo EUN" + this);
					Programa.setFin();
				}
				else{
					setTipo(new TiposBasicos(KindTipo.NUM));
				}
				break;
			default:
				break;
			
		}


	}



	public void generaCodigo(){
		switch (kind) {
	        case EXCLAM:
        	 	exp.generaCodigo();
			Programa.codigo.println("\ti32.load");
          		Programa.codigo.println("\ti32.eqz");
			Programa.codigo.println("\tif (result i32)");
			Programa.codigo.println("\ti32.const 1");
			Programa.codigo.println("\telse");
			Programa.codigo.println("\ti32.const 0");
			Programa.codigo.println("\tend");
         		break;
        	/*case POINTER:
          		exp.generaCodigo();
			Programa.codigo.println("\t" + this.getTipo().convertWasm() + ".load");
    			break;*/
		case DOLLAR:
			exp.calcularDirRelativa();
			break;
		case TOFLOAT:
			exp.generaCodigo();
			Programa.codigo.println("\tcall $intToDec");
			break;
		case TOINT:
			exp.generaCodigo();
			Programa.codigo.println("\tcall $decToInt");
			break;
		case PARE:
			exp.generaCodigo();
			break;
        	default:
      		}
    	}
	public void calcularDirRelativa(){
		switch (kind) {
	        case EXCLAM:
        	 	exp.calcularDirRelativa();
         		break;
        	/*case POINTER:
          		exp.generaCodigo();
    			break;*/
		case DOLLAR:
			break;
		case TOFLOAT:
			break;
		case TOINT:
			break;
		case PARE:
			exp.calcularDirRelativa();
			break;
        	default:
      		}
    	}


	@Override
	public boolean getModifiable(){
		if(!kind.equals(KindAsig.EXCLAM) && !kind.equals(KindAsig.TOINT) && !kind.equals(KindAsig.TOINT)){
			return exp.getModifiable();

		}
		return false;
	}
	

}
