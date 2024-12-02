package dao;
import model.Categoria;
import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    private static EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }

    public List<Categoria> buscarTodos (){
        String jpql = "SELECT c FROM Categoria c";
        return em.createQuery(jpql,Categoria.class).getResultList();
    }

    public static Categoria buscarPorId(int id){
        return em.find(Categoria.class, id);
    }

    public void excluir (Categoria categoria){
        em.merge(categoria);
        this.em.remove(categoria);
    }

    public void alterar(Categoria categoria){
        em.merge(categoria);
    }

}
