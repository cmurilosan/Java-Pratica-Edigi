package br.com.edigi.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoriaTest {

    @Test
    public void categoriaPossuiUmNome() {

        Categoria programação = new Categoria("Programação");

        assertEquals("Programação", programação.getNome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nomeCategoriaNaoPodeSerVazio() {

        new Categoria("");

    }


}