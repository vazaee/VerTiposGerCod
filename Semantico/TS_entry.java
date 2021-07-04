/**
 * Write a description of class Paciente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TS_entry
{
   private String id;
   private ClasseID classe;  
   private TS_entry tipo;

   // para arrays 
   private int nroElementos;
   private TS_entry tipoBase;

   private TabSimb locais;
   // private ArrayList<TS_entry> locais;


   // construtor para arrays
   public TS_entry(String umId, TS_entry umTipo, ClasseID umaClasse) {
      this(umId, umTipo, umaClasse, 0, null);
   }

   public TS_entry(String umId, TS_entry umTipo, ClasseID umaClasse, int elems, TS_entry tp) {
      id = umId;
      tipo = umTipo;
      classe = umaClasse;
      nroElementos = elems;
      tipoBase = tp;
   }


   public String getId() {
       return id; 
   }

   public TS_entry getTipo() {
       return tipo; 
   }

   public ClasseID getClasse() {
      return classe; 
   }
   
   public TS_entry getTipoBase() {
       return tipoBase; 
   }
   
    
   public String toString() {
       StringBuilder aux = new StringBuilder("");
        
       aux.append("Id: ");
       aux.append(String.format("%-15s", id));

       aux.append("\tClasse: ");
       aux.append(classe);
       aux.append("\tTipo: "); 
       aux.append(tipo2str(this.tipo)); 
       
      return aux.toString();

   }

  public String getTipoStr() {
       return tipo2str(this); 
   }

    public String tipo2str(TS_entry tipo) {
      if (tipo == null)  return "null"; 
      else if (tipo==Parser.Tp_INT)    return "int"; 
      else if (tipo==Parser.Tp_BOOL)   return "boolean"; 
      else if (tipo==Parser.Tp_DOUBLE)  return "double";
      //Para poder aparecer 'void' na tabela quando uma funcao for declarada como VOID
      else if (tipo.getId().equals("void")) return "void";
      else if (tipo.getTipo() != null) return  String.format("array(%d,%s)",
                                                   tipo.nroElementos, 
                                                    tipo2str(tipo.tipoBase));
      else if (tipo.getClasse().equals(ClasseID.NomeStruct)) return tipo.getId();

      else if (tipo==Parser.Tp_ERRO)  return  "_erro_";
      else                             return "erro/tp";
   }

}






