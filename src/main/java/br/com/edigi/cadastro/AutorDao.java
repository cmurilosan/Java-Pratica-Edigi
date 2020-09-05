package br.com.edigi.cadastro;

import br.com.edigi.modelo.Autor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AutorDao {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-jpa");

    public List<Autor> getListaDeAutores() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("select a from Autor a", Autor.class).getResultList();
    }

    public void insereAutor(Autor autor) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(autor);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
