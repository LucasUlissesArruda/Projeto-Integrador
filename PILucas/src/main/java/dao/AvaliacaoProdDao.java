package dao;


import model.AvaliacaoProd;

import javax.persistence.EntityManager;
import java.util.List;

public class AvaliacaoProdDao {
    private static EntityManager em;

    public AvaliacaoProdDao (EntityManager em){
        this.em = em;
    }

    public void cadastrar(AvaliacaoProd avaliacaoProd) {
        this.em.persist(avaliacaoProd);
    }

    public List<AvaliacaoProd> buscarTodos (){
        String jpql = "SELECT c FROM AvaliacaoProd c";
        return em.createQuery(jpql,AvaliacaoProd.class).getResultList();
    }

    public AvaliacaoProd buscarPorId(int id){
        return em.find(AvaliacaoProd.class, id);
    }

    public void excluir (AvaliacaoProd avaliacaoProd){
        em.merge(avaliacaoProd);
        this.em.remove(avaliacaoProd);
    }

    public void alterar(AvaliacaoProd avaliacaoProd){
        em.merge(avaliacaoProd);
    }
}
