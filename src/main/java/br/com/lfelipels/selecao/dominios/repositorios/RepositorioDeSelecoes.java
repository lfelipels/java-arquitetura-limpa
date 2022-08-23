package br.com.lfelipels.selecao.dominios.repositorios;

import br.com.lfelipels.selecao.dominios.entidades.Selecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDeSelecoes extends JpaRepository<Selecao, Integer> {
    public default void salvar(Selecao selecao) {
        this.save(selecao);
    }
}
