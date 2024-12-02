package model;

import javax.persistence.*;

@Entity
@Table(name = "produtos")

public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProdutos;
    private String descricaoProduto , nomeProduto;
    private int qtdeEstoque,idMarca, idCategoria;
    private float valor;

    public Produtos() {
    }

    public Produtos(String descricaoProduto, String nomeProduto, float valor, int qtdEstoque, int idMarca, int idCategoria) {
        this.descricaoProduto = descricaoProduto;
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.qtdeEstoque = qtdEstoque;
        this.idMarca = idMarca;
        this.idCategoria = idCategoria;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
