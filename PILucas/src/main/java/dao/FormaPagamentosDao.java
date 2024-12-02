package dao;

import model.FormaPagamentos;

import javax.persistence.EntityManager;
import java.util.List;

public class FormaPagamentosDao {
    private static EntityManager em;

    public FormaPagamentosDao(EntityManager em){
        this.em = em;
    }
    public List<FormaPagamentos> buscarTodos () {
        String jpql = "SELECT t FROM FormaPagamentos t";
        return em.createQuery(jpql, FormaPagamentos.class).getResultList();
    }
    public static FormaPagamentos buscarPorId(int id) {
        return em.find(FormaPagamentos.class,id);
    }

}
