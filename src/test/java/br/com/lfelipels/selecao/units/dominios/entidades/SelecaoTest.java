package br.com.lfelipels.selecao.units.dominios.entidades;

import br.com.lfelipels.selecao.dominios.Comum.Excecoes.DominioException;
import br.com.lfelipels.selecao.dominios.entidades.Curso;
import br.com.lfelipels.selecao.dominios.entidades.Ingresso;
import br.com.lfelipels.selecao.dominios.entidades.LocalOferta;
import br.com.lfelipels.selecao.dominios.entidades.Selecao;
import br.com.lfelipels.selecao.dominios.enums.StatusSelecao;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SelecaoTest {

    @Test
    void aoCriarUmaSelecaoOStatusDeveSerParametrizacao() {
        Selecao selecao = new Selecao("Selecao 01");
        assertEquals(StatusSelecao.PARAMETRIZACAO, selecao.getStatus());
        assertTrue(selecao.getOfertas().isEmpty());
        assertNull(selecao.getDataInicio());
        assertFalse(selecao.estarIniciada());
        assertNull(selecao.getDataTermino());
        assertFalse(selecao.estarFinalizada());
        assertTrue(selecao.estarEmParametrizacao());
    }

    @Test
    void addOfertaParaUmaSelecao() {
        Selecao selecao = new Selecao("Selecao 01");
        Ingresso ingresso = new Ingresso();
        LocalOferta local = new LocalOferta();
        Curso curso = new Curso();
        selecao.addOferta(curso, 4, ingresso, local);

        assertFalse(selecao.getOfertas().isEmpty());
        assertEquals(1, selecao.getOfertas().size());
    }

    @Test
    void iniciarSelecao() throws DominioException {

        Selecao selecao = new Selecao("Selecao 01");
        LocalDate inicio = LocalDate.now();
        Ingresso ingresso = new Ingresso();
        LocalOferta local = new LocalOferta();
        Curso curso = new Curso();
        selecao.addOferta(curso, 4, ingresso, local);

        selecao.iniciar(inicio);
        assertTrue(selecao.estarIniciada());
        assertTrue(selecao.getDataInicio().equals(inicio));
    }

    @Test
    void naoIniciarUmSelecaoSemOfertaDeCurso() {
        Selecao selecao = new Selecao("Selecao 01");
        assertThrows(DominioException.class, () -> {
            selecao.iniciar();
        });
    }

    /**
     * @TODO testar remoção de oferta
     * @TODO testar duplicação de oferta para um mesmo curso, ingresso e local
     * @TODO testar finalizar selecao
     */
}
