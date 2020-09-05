package br.com.edigi.cadastro;

import br.com.edigi.modelo.Categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class AdminCategoria {

    @Id
    @Column
    private static List<Categoria> listaDeCategoria = new ArrayList<>();

    public List<Categoria> getListaDeCategoria(){
        return Collections.unmodifiableList(listaDeCategoria);
    }

    public void insereCategoria(Categoria categoria){
        if(AdminCategoria.listaDeCategoria.contains(categoria)){
            throw new RuntimeException("Já possuímos essa CATEGORIA em nosso cadastro");
        }
        AdminCategoria.listaDeCategoria.add(categoria);
    }
}
