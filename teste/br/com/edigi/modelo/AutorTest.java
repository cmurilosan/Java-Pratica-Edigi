package br.com.edigi.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AutorTest {

    @Test
    public void autorPossuiUmNomeEEmail() {

        Autor nome = new Autor("Nome e Sobrenome", "nome@email.com.br");

        assertEquals("Nome e Sobrenome", nome.getNome());
        assertEquals("nome@email.com.br", nome.getEmail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nomeAutorNaoPodeSerVazio() {

        Autor autor = new Autor("", "nome@email.com.br");

    }

    @Test(expected = IllegalArgumentException.class)
    public void emailAutorNaoPodeSerVazio() {

        Autor autor = new Autor("nome", "");

    }

    @Test(expected = IllegalArgumentException.class)
    public void validaEmailAutor() {

        Autor autor = new Autor("nome", "nomeemail.com.br");

    }
}