package model;

import javax.persistence.*;

@Entity
@Table (name = "desconto")

public class Desconto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDesconto;
    private float porcentagem;

    public Desconto() {
    }

    public Desconto(float porcentagem) {
        this.porcentagem = porcentagem;
    }

    public int getIdDesconto() {
        return idDesconto;
    }

    public void setIdDesconto(int idDesconto) {
        this.idDesconto = idDesconto;
    }

    public float getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(float porcentagem) {
        this.porcentagem = porcentagem;
    }
}
