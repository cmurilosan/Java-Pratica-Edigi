package br.com.edigi.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AutorTest {

    @Test
    public void autorDeveTerNomeEEmail() {

        Autor nome = new Autor("Nome e Sobrenome", "nome@email.com.br");

        assertEquals("Nome e Sobrenome", nome.getNome());
        assertEquals("nome@email.com.br", nome.getEmail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nomeAutorNaoPodeSerVazio() {

        new Autor("", "nome@email.com.br");

    }

    @Test(expected = IllegalArgumentException.class)
    public void emailAutorNaoPodeSerVazio() {

        new Autor("nome", "");

    }

    @Test(expected = IllegalArgumentException.class)
    public void emailAutorDeSerValidado() {

        new Autor("nome", "nomeemail.com.br");

    }
}