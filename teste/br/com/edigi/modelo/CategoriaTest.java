package br.com.edigi.modelo;

import org.junit.Test;

import static org.junit.Assert.*;

public class CategoriaTest {

    @Test
    public void categoriaPossuiUmNome() {

        new Categoria("Programação");

        assertEquals("Programação", "Programação");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nomeCategoriaNaoPodeSerVazio() {

        new Categoria("");

        assertEquals("Nome", "");

    }


}