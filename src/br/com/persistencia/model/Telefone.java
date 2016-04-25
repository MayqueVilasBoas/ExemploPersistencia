package br.com.persistencia.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Telefone implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 9, nullable = false, name = "NUMERO")
    private String numero;
    
    @Column(length = 2, nullable = false, name = "DDD")
    private String ddd;

    public Telefone() {
    }

    public Telefone(String numero, String ddd) {
        this.numero = numero;
        this.ddd = ddd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @Override
    public String toString() {
        return "\n\tNúmero: " + getNumero() +
                "\n\tDDD: " + getDdd();
    }
}
