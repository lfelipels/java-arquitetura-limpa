package br.com.lfelipels.selecao.aplicacao.casosDeUso.criarSelecao;

public class CriarSelecaoDto {
    private String nome;
    private String resumo = "";


    public CriarSelecaoDto(String nome) {
        this.nome = nome;
    }

    public CriarSelecaoDto(String nome, String resumo) {
        this(nome);
        this.resumo = resumo;
    }

    public String getNome() {
        return nome;
    }

    public String getResumo() {
        return resumo;
    }
}
