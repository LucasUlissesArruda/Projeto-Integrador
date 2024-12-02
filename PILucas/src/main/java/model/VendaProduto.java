package model;

import javax.persistence.*;

@Entity
@Table(name = "vendaproduto")
public class VendaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVendaProduto;
    private float preco, precototal;
    private int qtde, idVendas, idProdutos;

    public VendaProduto() {
    }

    public VendaProduto(float preco, float pretotal, int qtde, int idVendas, int idProdutos) {
        this.preco = preco;
        this.precototal = pretotal;
        this.qtde = qtde;
        this.idVendas = idVendas;
        this.idProdutos = idProdutos;
    }

    public int getIdVendaProduto() {
        return idVendaProduto;
    }

    public void setIdVendaProduto(int idVendaProduto) {
        this.idVendaProduto = idVendaProduto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPrecototal() {
        return precototal;
    }

    public void setPrecototal(float precototal) {
        this.precototal = precototal;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public int getIdVendas() {
        return idVendas;
    }

    public void setIdVendas(int idVendas) {
        this.idVendas = idVendas;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }
}
