package br.com.lfelipels.selecao.dominios.enums;

public enum StatusSelecao {
    PARAMETRIZACAO(1),
    INICIADA(1),
    FINALIZADA(3);

    private final int valor;

    StatusSelecao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
