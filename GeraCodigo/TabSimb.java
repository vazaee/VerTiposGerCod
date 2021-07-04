//Alunos: Gabriel Vaz, Márcio Góes, Matheus Zanon
//Matriculas: 17111238, 16105078, 16105090
//Email: {Gabriel.vaz, Marcio.goes, Matheus.zanon}@edu.pucrs.br


import java.util.ArrayList;
import java.util.Iterator;


public class TabSimb
{
    private ArrayList<TS_entry> lista;
    
    public TabSimb( )
    {
        lista = new ArrayList<TS_entry>();
    }
    
    public void insert( TS_entry nodo ) {
      lista.add(nodo);
    }    
    
    public void listar() {
      int cont = 0;  
      System.out.println("\n\n# Listagem da tabela de simbolos:\n");
      for (TS_entry nodo : lista) {
          System.out.println("# " + nodo);
      }
    }
      
    public TS_entry pesquisa(String umId) {
      for (TS_entry nodo : lista) {
          if (nodo.getId().equals(umId)) {
	      return nodo;
            }
      }
      return null;
    }

	public void geraGlobais() {
          // assume que todas variáveis são globais e inteiras.
	      for (TS_entry nodo : lista) {
	            	System.out.println("_"+nodo.getId()+":"+"	.zero 4");
	            }
	      }
	     


}



