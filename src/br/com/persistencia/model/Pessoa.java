package br.com.persistencia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
@NamedQueries({
    @NamedQuery(name = "pessoa.findAll",   query = "SELECT p FROM Pessoa p"                   ),
    @NamedQuery(name = "pessoa.findbyId",  query = "SELECT p FROM Pessoa p WHERE p.id  = :id" ),
    @NamedQuery(name = "pessoa.findbyCPF", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf")
})
public class Pessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPessoa;
    
    @Column
    private String nome;
    
    @Column
    private String cpf;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_FONE_COM")
    private Telefone foneCom;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_FONE_RES")
    private Telefone foneRes;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<Endereco>();

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, Telefone foneCom, Telefone foneRes) {
        this.nome = nome;
        this.cpf = cpf;
        this.foneCom = foneCom;
        this.foneRes = foneRes;
    }
    
    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Telefone getFoneCom() {
        return foneCom;
    }

    public void setFoneCom(Telefone foneCom) {
        this.foneCom = foneCom;
    }

    public Telefone getFoneRes() {
        return foneRes;
    }

    public void setFoneRes(Telefone foneRes) {
        this.foneRes = foneRes;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco endereco) {
        enderecos.add( endereco );
    }        

    @Override
    public String toString() {
        return  "\n\nId: " + getIdPessoa() +
                "\nNome: " + getNome() + 
                "\nCPF: " + getCpf() + 
                "\nTelefone Com: " + getFoneCom().toString() +
                "\nTelefone Res: " + getFoneRes().toString() +
                "\nEndereços: " + getEnderecos();
    }
    
}
