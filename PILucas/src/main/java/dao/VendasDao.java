package dao;

import model.Vendas;

import javax.persistence.EntityManager;
import java.util.List;

public class VendasDao {
    private static EntityManager em;

    public VendasDao (EntityManager em){
        this.em = em;
    }

    public void cadastrar(Vendas vendas) {
        this.em.persist(vendas);
    }

    public List<Vendas> buscarTodos (){
        String jpql = "SELECT c FROM Vendas c";
        return em.createQuery(jpql,Vendas.class).getResultList();
    }

    public static Vendas buscarPorId(int id){
        return em.find(Vendas.class, id);
    }

    public void excluir (Vendas vendas){
        em.merge(vendas);
        this.em.remove(vendas);
    }

    public void alterar(Vendas vendas){
        em.merge(vendas);
    }

}
