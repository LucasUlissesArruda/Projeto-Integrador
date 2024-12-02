package dao;

import model.Desconto;

import javax.persistence.EntityManager;
import java.util.List;

public class DescontoDao {
    private static EntityManager em;

    public DescontoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Desconto desconto) {
        this.em.persist(desconto);
    }

    public List<Desconto> buscarTodos (){
        String jpql = "SELECT c FROM Desconto c";
        return em.createQuery(jpql,Desconto.class).getResultList();
    }

    public static Desconto buscarPorId(int id){
        return em.find(Desconto.class, id);
    }

    public void excluir (Desconto desconto){
        em.merge(desconto);
        this.em.remove(desconto);
    }

    public void alterar(Desconto desconto){
        em.merge(desconto);
    }
}
