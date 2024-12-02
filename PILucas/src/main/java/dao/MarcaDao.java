package dao;
import model.Marca;

import javax.persistence.EntityManager;
import java.util.List;

public class MarcaDao {
    private static EntityManager em;

    public MarcaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Marca marca) {
        this.em.persist(marca);
    }

    public List<Marca> buscarTodos (){
        String jpql = "SELECT c FROM Marca c";
        return em.createQuery(jpql,Marca.class).getResultList();
    }

    public static Marca buscarPorId(int id){
        return em.find(Marca.class, id);
    }

    public void excluir (Marca marca){
        em.merge(marca);
        this.em.remove(marca);
    }

    public void alterar(Marca marca){
        em.merge(marca);
    }
}
