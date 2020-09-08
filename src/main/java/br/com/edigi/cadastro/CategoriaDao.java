package br.com.edigi.cadastro;

import br.com.edigi.modelo.Categoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoriaDao {

    private static List<Categoria> listaDeCategoria = new ArrayList<>();

    public List<Categoria> getListaDeCategoria(){
        return Collections.unmodifiableList(listaDeCategoria);
    }

    public void insereCategoria(Categoria categoria){
        if(CategoriaDao.listaDeCategoria.contains(categoria)){
            throw new RuntimeException("Já possuímos essa CATEGORIA em nosso cadastro");
        }
        CategoriaDao.listaDeCategoria.add(categoria);
    }
}
