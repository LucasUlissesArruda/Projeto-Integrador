package model;

import javax.persistence.*;

@Entity
@Table(name = "produtoavali")
public class AvaliacaoProd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idprodutoAvali;
    private int nota, idproduto;
    private String observacao;

    public AvaliacaoProd() {
    }

    public AvaliacaoProd(int nota, int idproduto, String observacao) {
        this.nota = nota;
        this.idproduto = idproduto;
        this.observacao = observacao;
    }

    public int getIdprodutoAvali() {
        return idprodutoAvali;
    }

    public void setIdprodutoAvali(int idprodutoAvali) {
        this.idprodutoAvali = idprodutoAvali;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
