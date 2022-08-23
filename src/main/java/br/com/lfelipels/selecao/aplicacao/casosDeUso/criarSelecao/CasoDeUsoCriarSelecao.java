package br.com.lfelipels.selecao.aplicacao.casosDeUso.criarSelecao;

import br.com.lfelipels.selecao.dominios.entidades.Selecao;
import br.com.lfelipels.selecao.dominios.repositorios.RepositorioDeSelecoes;
import org.springframework.stereotype.Service;

@Service
public class CasoDeUsoCriarSelecao {
    private RepositorioDeSelecoes repositorioDeSelecoes;

    public CasoDeUsoCriarSelecao(RepositorioDeSelecoes repositorioDeSelecoes) {
        this.repositorioDeSelecoes = repositorioDeSelecoes;
    }

    public void executar(CriarSelecaoDto dadosSelecao) {
        Selecao selecao = new Selecao(dadosSelecao.getNome());
        if (dadosSelecao.getResumo() != null) {
            selecao.setResumo(dadosSelecao.getResumo());
        }
        this.repositorioDeSelecoes.salvar(selecao);
    }
}
