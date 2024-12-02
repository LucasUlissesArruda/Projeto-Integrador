package dao;

import model.VendaProduto;

import javax.persistence.EntityManager;
import java.util.List;

    public class VendaProdutoDao {
        private static EntityManager em;

        public VendaProdutoDao (EntityManager em){
        this.em = em;
        }

        public void cadastrar(VendaProduto vendaProduto) {
            this.em.persist(vendaProduto);
        }

        public List<VendaProduto> buscarTodos (){
            String jpql = "SELECT c FROM VendaProduto c";
            return em.createQuery(jpql,VendaProduto.class).getResultList();
        }

        public static VendaProduto buscarPorId(int id){
            return em.find(VendaProduto.class, id);
        }

        public void excluir (VendaProduto vendaProduto){
            em.merge(vendaProduto);
            this.em.remove(vendaProduto);
        }

        public void alterar(VendaProduto vendaProduto){
            em.merge(vendaProduto);
        }
}
