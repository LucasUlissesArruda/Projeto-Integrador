package model;

import javax.persistence.*;

@Entity
@Table(name = "formapagamento")

public class FormaPagamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormaPagamento;
    private String descPagamento;

    public FormaPagamentos() {
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getDescPagamento() {
        return descPagamento;
    }

    public void setDescPagamento(String descPagamento) {
        this.descPagamento = descPagamento;
    }
}
