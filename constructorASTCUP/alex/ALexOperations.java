package alex;

import constructorast.ClaseLexica;


public class ALexOperations {
  private AnalizadorLexicoExp alex;
  public ALexOperations(AnalizadorLexicoExp alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadId() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IDEN,
                                         alex.lexema()); 
  } 

  public UnidadLexica unidadEntero() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.ENT,alex.lexema()); 
  } 
 
  public UnidadLexica unidadReal() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.REAL,alex.lexema()); 
  } 
 
  public UnidadLexica unidadNum() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.NUM,alex.lexema()); 
  } 
 
  public UnidadLexica unidadRial() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.RIAL,alex.lexema()); 
  } 

  public UnidadLexica unidadSuma() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAS); 
  } 
  public UnidadLexica unidadResta() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MENOS); 
  } 
  public UnidadLexica unidadMul() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.POR); 
  } 
  public UnidadLexica unidadDiv() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DIV); 
  } 

  public UnidadLexica unidadDivEnt() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DIVENT); 
  } 

  public UnidadLexica unidadModulo() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MOD); 
  } 

  public UnidadLexica unidadMayor() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAYOR); 
  } 

  public UnidadLexica unidadMenor() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MENOR); 
  } 

  public UnidadLexica unidadDosPuntos() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DOSPUNTOS); 
  } 

  public UnidadLexica unidadAsignacion() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.ASIG); 
  } 

  public UnidadLexica unidadAcceso() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.ACCESO); 
  } 

  public UnidadLexica unidadExclamacion() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.EXCLAM); 
  } 

  public UnidadLexica unidadAnd() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.AND); 
  }

  public UnidadLexica unidadOr() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.OR); 
  }

  public UnidadLexica unidadDollar() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DOLLAR); 
  }

  public UnidadLexica unidadPuntoComa() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PUNTOCOMA); 
  }

  public UnidadLexica unidadMayorIg() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAYORIG); 
  }

  public UnidadLexica unidadMenorIg() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MENORIG); 
  }

  public UnidadLexica unidadIgualIgual() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IGUALIG); 
  }

  public UnidadLexica unidadDistinto() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DISTINTO); 
  }

  public UnidadLexica unidadSumaPrefijo() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.SUMAPREF); 
  }

  public UnidadLexica unidadRestaPrefijo() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.RESTAPREF); 
  }

  public UnidadLexica unidadMultiPrefijo() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MULTIPREF); 
  }

  public UnidadLexica unidadDiviPrefijo() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DIVIPREF); 
  }

  public UnidadLexica unidadModPrefijo() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MODPREF); 
  }

  public UnidadLexica unidadDivEnteraPrefijo() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DIVENTPREF); 
  }

  public UnidadLexica unidadPAp() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PAP); 
  } 
  public UnidadLexica unidadPCierre() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PCIERRE); 
  } 

  public UnidadLexica unidadLlaveAp() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.LLAVEAP); 
  }

  public UnidadLexica unidadLlaveCierre() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.LLAVECIE); 
  }

  public UnidadLexica unidadCorcheteAp() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.CORCHETEAP); 
  }

  public UnidadLexica unidadCorcheteCierre() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.CORCHETECIERRE); 
  }
  
  public UnidadLexica unidadBool() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.BOOL); 
  }

  public UnidadLexica unidadFact() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.FACT, alex.lexema()); 
  }

  public UnidadLexica unidadInFact() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.INFACT, alex.lexema()); 
  }

  public UnidadLexica unidadPointer() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.POINTER); 
  }

  public UnidadLexica unidadList() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.LIST); 
  }

  public UnidadLexica unidadIf() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IF); 
  }

  public UnidadLexica unidadElse() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.ELSE); 
  }

  public UnidadLexica unidadFun() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.FUN); 
  }

  public UnidadLexica unidadFor() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.FOR); 
  }

  public UnidadLexica unidadWhile() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.WHILE); 
  }

  public UnidadLexica unidadLoop() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.LOOP); 
  }

  public UnidadLexica unidadReg() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.REG); 
  }

  public UnidadLexica unidadRef() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.REF); 
  }

  public UnidadLexica unidadMain() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAIN); 
  }

  public UnidadLexica unidadReturn() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.RETURN); 
  }

  public UnidadLexica unidadVoid() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.VOID); 
  }

  public UnidadLexica unidadReadNum() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.READNUM, alex.lexema()); 
  }

  public UnidadLexica unidadWriteNum() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.WRITENUM, alex.lexema()); 
  }

  public UnidadLexica unidadReadRial() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.READRIAL, alex.lexema()); 
  }

  public UnidadLexica unidadWriteRial() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.WRITERIAL, alex.lexema()); 
  }
  public UnidadLexica unidadReadBool() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.READBOOL, alex.lexema()); 
  }

  public UnidadLexica unidadWriteBool() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.WRITEBOOL, alex.lexema()); 
  }

  public UnidadLexica unidadEof() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.EOF); 
  }  

  public UnidadLexica unidadNew(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.NEW); 
  }

  public UnidadLexica unidadDelete(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DELETE); 
  }

  public UnidadLexica unidadToFloat(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.TOFLOAT); 
  }

  public UnidadLexica unidadToInt(){
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.TOINT); 
  }

  public void error() {
    System.err.println("***"+alex.fila()+", "+alex.columna()+" Caracter inesperado: "+alex.lexema());
  }

  public UnidadLexica unidadAs(){
	return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.AS); 
  }

  public UnidadLexica unidadTypedef(){
	return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.TYPEDEF); 
  }
}
