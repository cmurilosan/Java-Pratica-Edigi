package br.com.edigi.cadastro;

import br.com.edigi.modelo.Autor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminAutores {

    private static List<Autor> listaDeAutores = new ArrayList<>();

    public List<Autor> getListaDeAutores() {
        return Collections.unmodifiableList(listaDeAutores);
    }

    public void insereAutor(Autor autor) {
        if(AdminAutores.listaDeAutores.contains(autor)) {
            throw new RuntimeException("Já existe um AUTOR cadastrado em nosso sistema com esse EMAIL");
        }
        AdminAutores.listaDeAutores.add(autor);
    }

}
