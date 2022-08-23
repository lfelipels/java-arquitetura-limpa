package br.com.lfelipels.selecao.units.aplicao.casosDeUso;

import br.com.lfelipels.selecao.aplicacao.casosDeUso.criarSelecao.CasoDeUsoCriarSelecao;
import br.com.lfelipels.selecao.aplicacao.casosDeUso.criarSelecao.CriarSelecaoDto;
import br.com.lfelipels.selecao.dominios.entidades.Selecao;
import br.com.lfelipels.selecao.dominios.repositorios.RepositorioDeSelecoes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CasoDeUsoCriarSelecaoTest {

    private RepositorioDeSelecoes mockRepoSelecoes;
    private CasoDeUsoCriarSelecao casoDeUsoCriarSelecao;

    @BeforeEach
    void setUp() {
        this.mockRepoSelecoes = mock(RepositorioDeSelecoes.class);
        this.casoDeUsoCriarSelecao = new CasoDeUsoCriarSelecao(this.mockRepoSelecoes);
    }

    @Test
    void criarUmaSelecao() {
        Selecao selecao = mock(Selecao.class);
        CriarSelecaoDto dadosSelecao = new CriarSelecaoDto("Selecao de teste");

        this.casoDeUsoCriarSelecao.executar(dadosSelecao);

        verify(this.mockRepoSelecoes, times(1)).salvar(isA(Selecao.class));
    }
}
