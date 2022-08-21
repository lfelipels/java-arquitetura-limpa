package br.com.lfelipels.selecao.dominios.entidades;

public class OfertaCurso {

    private Selecao selecao;
    private Curso curso;
    private LocalOferta local;

    private Ingresso ingresso;
    private int vagas;

    public OfertaCurso(
            Selecao selecao,
            Curso curso,
            int vagas,
            Ingresso ingresso,
            LocalOferta local
    ) {
        this.curso = curso;
        this.setVagas(vagas);
        this.local = local;
    }

    public Selecao getSelecao() {
        return selecao;
    }

    public void setSelecao(Selecao selecao) {
        this.selecao = selecao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalOferta getLocal() {
        return local;
    }

    public void setLocal(LocalOferta local) {
        this.local = local;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        if (vagas < 1) {
            throw new IllegalArgumentException("A oferta deve possuir pelo menos uma vaga");
        }
        this.vagas = vagas;
    }
}
