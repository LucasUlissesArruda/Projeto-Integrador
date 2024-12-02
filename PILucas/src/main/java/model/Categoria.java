package model;

import javax.persistence.*;

@Entity
@Table (name = "categoria")

public class Categoria {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idCategoria;
    private String descricao;

    public Categoria() {

    }

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public int getIdCategorias() {
        return idCategoria;
    }

    public void setIdCategorias(int idCategorias) {
        this.idCategoria = idCategorias;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
