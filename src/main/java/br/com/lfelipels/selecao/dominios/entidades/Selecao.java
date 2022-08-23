package br.com.lfelipels.selecao.dominios.entidades;

import br.com.lfelipels.selecao.dominios.Comum.Excecoes.DominioException;
import br.com.lfelipels.selecao.dominios.enums.StatusSelecao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "selecoes", schema = "selecao")
public class Selecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String nome;

    @Column(nullable = true)
    private String resumo;

    @Column
    private StatusSelecao status;

    @Column(nullable = true)
    private LocalDate dataTermino;

    @Column(nullable = true)
    private LocalDate dataInicio;

    @Transient
    private List<OfertaCurso> ofertas;

    public Selecao() {
        this.ofertas = new ArrayList<>();
        this.status = StatusSelecao.PARAMETRIZACAO;
    }

    public Selecao(String nome) {
        this();
        this.nome = nome;
    }

    public Selecao(String nome, String resumo) {
        this(nome);
        this.resumo = resumo;
    }

    public void iniciar() throws DominioException {
        LocalDate localDate = LocalDate.now();
        this.iniciar(dataInicio);
    }

    public void iniciar(LocalDate dataInicio) throws DominioException{

        if(this.ofertas == null || this.ofertas.isEmpty()){
            throw new DominioException("Não é possível iniciar uma selecao sem oferta de curso");
        }

        this.status = StatusSelecao.INICIADA;
        this.dataInicio = dataInicio;
    }

    public boolean estarIniciada(){
        return this.status == StatusSelecao.INICIADA;
    }

    public boolean estarFinalizada() {
        return this.status == StatusSelecao.FINALIZADA;
    }

    public boolean estarEmParametrizacao() {
        return this.status == StatusSelecao.PARAMETRIZACAO;
    }

    public void addOferta(Curso curso, int vagas, Ingresso ingresso, LocalOferta local) {
        this.ofertas.add(new OfertaCurso(this, curso, vagas, ingresso, local));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getResumo() {
        return resumo;
    }

    public StatusSelecao getStatus() {
        return status;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public int getId() {
        return id;
    }

    public List<OfertaCurso> getOfertas() {
        return ofertas;
    }
}
