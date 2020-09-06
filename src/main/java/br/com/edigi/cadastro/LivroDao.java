package br.com.edigi.cadastro;

import br.com.edigi.modelo.Livro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LivroDao {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("edigi");

    public void insereLivro(Livro livro) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(livro);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Livro> buscaPorTitulo(String palavra) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        if (palavra.length() < 2){
                throw new IllegalArgumentException(palavra + " é insuficiente para a pesquisa");
            }

        return entityManager.createQuery("select l from Livro l", Livro.class).getResultList();

    }

    public boolean contem(Livro livro) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("select l from Livro l", Livro.class).equals(livro);
    }

    public List<Livro> getListaDeLivros() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("select l from Livro l", Livro.class).getResultList();
    }
}