package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vendas")
public class Vendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idvendas;
    private float frete;
    @Column (name = "dataVendas")
    private LocalDate dataVenda;
    private int idClientes, idDesconto, idFormaPagamento;

    public Vendas() {
    }

    public Vendas(float frete, LocalDate dataVenda, int idClientes, int idDesconto, int idFormaPagamento) {
        this.frete = frete;
        this.dataVenda = dataVenda;
        this.idClientes = idClientes;
        this.idDesconto = idDesconto;
        this.idFormaPagamento = idFormaPagamento;
    }

    public int getIdvendas() {
        return idvendas;
    }

    public void setIdvendas(int idvendas) {
        this.idvendas = idvendas;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public float getFrete() {
        return frete;
    }

    public void setFrete(float frete) {
        this.frete = frete;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public int getIdDesconto() {
        return idDesconto;
    }

    public void setIdDesconto(int idDesconto) {
        this.idDesconto = idDesconto;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }
}
