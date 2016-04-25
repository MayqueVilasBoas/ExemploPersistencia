package persistencia;

import br.com.persistencia.util.UnidadePersistencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.persistencia.model.Endereco;
import br.com.persistencia.model.Telefone;
import br.com.persistencia.model.Pessoa;

public class Main {

    public static void main(String[] args) {
        
        //INSTANCIAR O ENTITY MANAGER
        EntityManager em = UnidadePersistencia.createEntityManager();
        
        //CRIAR TELEFONES
        Telefone telefone1 = new Telefone("99999999", "43");
        Telefone telefone2 = new Telefone("88888888", "44");    
        
        //CRIAR ENDEREÇO
        Endereco enderecoCom = new Endereco("RUA TESTE", "999", "","VILA TESTE", "86800000");
        
        //CRIAR A PESSOA
        Pessoa pessoa = new Pessoa(  "PESSOA TESTE", "999.999.999-99", telefone1, telefone2);
        pessoa.setEnderecos(enderecoCom);
          
        try {
            //PERSISTIR NO BANCO DE DADOS
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
            
            //OBTER A PESSOA PERSISTIDA NO BANCO DE DADOS
            Pessoa find = em.find(Pessoa.class, new Long(1));
            
            //MOSTRAR
            System.out.println(find.toString());           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // SELECT PARA OBTER TODAS PESSOAS
        Query query = em.createNamedQuery("pessoa.findAll");
        
        // ATRIBUIR RESULTADO A UMA LISTA
        List<Pessoa> pessoas = query.getResultList();
        
        // LOOP NA LISTA PARA MOSTRAR O RESULTADO
        for (Pessoa p : pessoas) {
            System.out.println(p);
        }
               
        em.close();
        
        System.exit(0);
    }
    
}
