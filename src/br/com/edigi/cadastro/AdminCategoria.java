package br.com.edigi.cadastro;

import br.com.edigi.modelo.Categoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminCategoria {

    private static List<Categoria> listaDeCategoria = new ArrayList<>();

    public static List<Categoria> getListaDeCategoria(){

        return Collections.unmodifiableList(listaDeCategoria);
    }

    public void insereCategoria(Categoria categoria){
        if(AdminCategoria.listaDeCategoria.contains(categoria)){
            throw new RuntimeException("Já possuímos essa CATEGORIA em nosso cadastro");
        }
        AdminCategoria.listaDeCategoria.add(categoria);
    }
}
