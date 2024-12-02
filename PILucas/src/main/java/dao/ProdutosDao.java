package dao;
import model.Produtos;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutosDao {
    private static EntityManager em;

    public ProdutosDao (EntityManager em){
        this.em = em;
    }

    public void cadastrar(Produtos produtos) {
        this.em.persist(produtos);
    }

    public List<Produtos> buscarTodos (){
        String jpql = "SELECT c FROM Produtos c";
        return em.createQuery(jpql,Produtos.class).getResultList();
    }

    public static Produtos buscarPorId(int id){
        return em.find(Produtos.class, id);
    }

    public void excluir (Produtos produtos){
        em.merge(produtos);
        this.em.remove(produtos);
    }

    public void alterar(Produtos produtos){
        em.merge(produtos);
    }

}
