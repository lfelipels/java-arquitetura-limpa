package br.com.lfelipels.selecao.units.dominios.entidades;

import br.com.lfelipels.selecao.dominios.entidades.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OfertaCursoTests {
    @Test
    void criarOfertaDeCurso() {
        Selecao selecao = new Selecao();
        Ingresso ingresso = new Ingresso();
        LocalOferta local = new LocalOferta();
        Curso curso = new Curso();
        OfertaCurso oferta = new OfertaCurso(selecao, curso, 3, ingresso, local);
        assertEquals(3, oferta.getVagas());
    }

    @Test
    void naoCriarOfertaSemVaga() {
        Selecao selecao = new Selecao();
        Ingresso ingresso = new Ingresso();
        LocalOferta local = new LocalOferta();
        Curso curso = new Curso();
        assertThrows(IllegalArgumentException.class, () -> {
            OfertaCurso oferta = new OfertaCurso(selecao, curso, 0, ingresso, local);
        });
    }
}
