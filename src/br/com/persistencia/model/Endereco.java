/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.persistencia.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;
    
    @Column(length = 120, nullable = false, name = "LOGRAD")
    private String logradouro;
    
    @Column(length = 30, nullable = false, name = "NUMERO")
    private String numero;
    
    @Column(length = 30, nullable = false, name = "COMPLEMENTO")
    private String complemento;
    
    @Column(length = 30, nullable = false, name = "BAIRRO")
    private String bairro;
    
    @Column(length = 8, nullable = false, name = "CEP")
    private String cep;
    
    public Endereco(String logradouro, String numero, String complemento, String bairro, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Endereco() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }   
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "\n\tEndereco - " + "id: " + id + " - logradouro: " + logradouro + " - numero: " + numero + " - complemento: " + complemento + " - bairro: " + bairro + " - cep: " + cep;
    }

    
    
}
