package br.com.edigi.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AutorTest {

    @Test
    public void autorPossuiUmNomeEEmail() {

        new Autor("nome", "nome@email.com.br");
        new Autor("sobrenome", "sobrenome@email.com");

        assertEquals("nome", "nome");
        assertEquals("nome@email.com.br", "nome@email.com.br");
        assertEquals("sobrenome@email.com", "sobrenome@email.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nomeAutorNaoPodeSerVazio() {

        new Autor("", "nome@email.com.br");

        assertEquals("nome", "");

    }

    @Test(expected = IllegalArgumentException.class)
    public void emailAutorNaoPodeSerVazio() {

        new Autor("nome", "");

        assertEquals("nome@email.com.br", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validaEmailAutor() {

        new Autor("nome", "nomeemail.com.br");

        assertEquals("nome@email.com.br", "nomeemail.com.br");
    }
}