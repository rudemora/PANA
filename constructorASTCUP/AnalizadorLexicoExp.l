package alex;

import errors.GestionErroresExp;

%%
%cup
%column
%line
%class AnalizadorLexicoExp
%unicode
%public

%{
  private ALexOperations ops;
  private GestionErroresExp errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
  public void fijaGestionErrores(GestionErroresExp errores) {
   this.errores = errores;
  }
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = {digitoPositivo}{digito}*
parteDecimal = {digito}* {digitoPositivo}
numeroEntero = [\-]?{parteEntera}|[0]
numeroReal = {numeroEntero}{coma}{parteDecimal}
separador = [ \t\r\b\n]
comentario = {operadorMultiplicacion}{operadorMultiplicacion}[^\n]* 
comentarioLinea = {operadorDivision}{operadorMultiplicacion}{operadorMultiplicacion} ~ {operadorMultiplicacion}{operadorMultiplicacion}{operadorDivision}

sumaPrefijo = {operadorSuma}{operadorAsignacion}
restaPrefijo = {operadorResta}{operadorAsignacion}
multiPrefijo = {operadorMultiplicacion}{operadorAsignacion}
diviPrefijo = {operadorDivision}{operadorAsignacion}
modPrefijo = {operadorModulo}{operadorAsignacion}
divEnteraPrefijo = {operadorDivisionEntera}{operadorAsignacion}

operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = \/
operadorDivisionEntera = {operadorDivision}{operadorDivision}
operadorModulo = \%
operadorMayor = \>
operadorMenor = \<
operadorIg = \=
operadorDosPuntos = \: 
operadorAsignacion = {operadorResta}{operadorMayor}
operadorAcceso = \.
operadorExclamacion = \!
operadorAnd = \&
operadorOr = \@
operadorDollar = \$
operadorPuntoComa = \;
operadorSharp = \#

mayorIgual = {operadorMayor}{operadorIg}
menorIgual = {operadorMenor}{operadorIg}
igualIgual = {operadorIg}{operadorIg}
distinto = {operadorExclamacion}{operadorIg}





parentesisApertura = \(
parentesisCierre = \)
coma  = \,
llaveApertura = \{
llaveCierre = \}
corcheteApertura = \[
corcheteCierre = \]

as = as
num = num
bool = bool
rial = rial
fact = fact
infact = infact
pointer = pointer
list = list
if = if
else = else
fun = fun
for = for
while = while 
loop = loop
reg = reg
ref = ref
main = main
return = return
void = void
new = new
delete = delete
toFloat = toFloat
toInt = toInt
typedef = typedef


readNum = readNum
writeNum = writeNum
readRial = readRial
writeRial = writeRial
readBool = readBool	
writeBool = writeBool

identificador = {letra}({letra}|{digito})*










%%
{separador}               {}
{comentario}              {}
{comentarioLinea}	  {}
{numeroEntero}		  {return ops.unidadEntero();}
{numeroReal}		  {return ops.unidadReal();}
{sumaPrefijo}		  {return ops.unidadSumaPrefijo();}
{restaPrefijo}		  {return ops.unidadRestaPrefijo();}
{multiPrefijo}		  {return ops.unidadMultiPrefijo();}
{diviPrefijo}		  {return ops.unidadDiviPrefijo();}
{modPrefijo} 		  {return ops.unidadModPrefijo();}
{divEnteraPrefijo}	  {return ops.unidadDivEnteraPrefijo();}
{operadorSuma}            {return ops.unidadSuma();}
{operadorResta}           {return ops.unidadResta();}
{operadorMultiplicacion}  {return ops.unidadMul();}
{operadorDivision}        {return ops.unidadDiv();}
{operadorDivisionEntera}  {return ops.unidadDivEnt();}
{operadorModulo}  	  {return ops.unidadModulo();}
{operadorMayor} 	  {return ops.unidadMayor();}
{operadorMenor}  	  {return ops.unidadMenor();}
{operadorDosPuntos}	  {return ops.unidadDosPuntos();}
{operadorAsignacion}	  {return ops.unidadAsignacion();}
{operadorAcceso}	  {return ops.unidadAcceso();}
{operadorExclamacion}	  {return ops.unidadExclamacion();}
{operadorAnd}	  	  {return ops.unidadAnd();}
{operadorOr}		  {return ops.unidadOr();}
{operadorDollar} 	  {return ops.unidadDollar();}
{operadorPuntoComa} 	  {return ops.unidadPuntoComa();}
{mayorIgual}  		  {return ops.unidadMayorIg();}
{menorIgual}	 	  {return ops.unidadMenorIg();}
{igualIgual}		  {return ops.unidadIgualIgual();}
{distinto}		  {return ops.unidadDistinto();}

{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();} 
{llaveApertura}		  {return ops.unidadLlaveAp();}
{llaveCierre}		  {return ops.unidadLlaveCierre();}
{corcheteApertura}	  {return ops.unidadCorcheteAp();}
{corcheteCierre}	  {return ops.unidadCorcheteCierre();}

{as}			  {return ops.unidadAs();}
{num}			  {return ops.unidadNum();}
{bool}			  {return ops.unidadBool();}
{rial}			  {return ops.unidadRial();}
{fact}			  {return ops.unidadFact();}
{infact}		  {return ops.unidadInFact();}
{pointer}		  {return ops.unidadPointer();}
{list}			  {return ops.unidadList();}
{if}			  {return ops.unidadIf();}
{else}		          {return ops.unidadElse();}
{fun}			  {return ops.unidadFun();}
{for}			  {return ops.unidadFor();}
{while}			  {return ops.unidadWhile();}
{loop}			  {return ops.unidadLoop();}
{reg}			  {return ops.unidadReg();}
{ref}			  {return ops.unidadRef();}
{main}			  {return ops.unidadMain();}
{return}		  {return ops.unidadReturn();}
{void}			  {return ops.unidadVoid();}
{readNum}		  {return ops.unidadReadNum();}
{writeNum}		  {return ops.unidadWriteNum();}
{readRial}		  {return ops.unidadReadRial();}
{writeRial}		  {return ops.unidadWriteRial();}
{readBool}		  {return ops.unidadReadBool();}
{writeBool}		  {return ops.unidadWriteBool();}
{new}			  {return ops.unidadNew();}
{delete}	 	  {return ops.unidadDelete();}
{toFloat} 		  {return ops.unidadToFloat(); }
{toInt} 		  {return ops.unidadToInt(); }
{typedef}		  {return ops.unidadTypedef(); }


{identificador}           {return ops.unidadId();}
[^]                       {errores.errorLexico(fila(),columna(),lexema());}  
