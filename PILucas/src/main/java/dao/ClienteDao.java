package dao;
import model.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao{
    private static EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente tipoCliente) {
        this.em.persist(tipoCliente);
    }

    public List<Cliente> buscarTodos (){
        String jpql = "SELECT c FROM Cliente c";
        return em.createQuery(jpql,Cliente.class).getResultList();
    }

    public static Cliente buscarPorId(int id){
        return em.find(Cliente.class, id);
    }

    public void excluir (Cliente cliente){
        em.merge(cliente);
        this.em.remove(cliente);
    }

    public void alterar(Cliente cliente){
        em.merge(cliente);
    }

}
