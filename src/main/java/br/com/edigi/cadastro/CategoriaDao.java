package br.com.edigi.cadastro;

import br.com.edigi.modelo.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CategoriaDao {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("edigi");

    public List<Categoria> getListaDeCategoria(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("select c from Categoria c", Categoria.class).getResultList();
    }

    public void insereCategoria(Categoria categoria){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
