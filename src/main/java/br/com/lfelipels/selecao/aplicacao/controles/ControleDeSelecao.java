package br.com.lfelipels.selecao.aplicacao.controles;

import br.com.lfelipels.selecao.aplicacao.casosDeUso.criarSelecao.CasoDeUsoCriarSelecao;
import br.com.lfelipels.selecao.aplicacao.casosDeUso.criarSelecao.CriarSelecaoDto;
import br.com.lfelipels.selecao.dominios.entidades.Selecao;
import br.com.lfelipels.selecao.dominios.repositorios.RepositorioDeSelecoes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/selecoes")
public class ControleDeSelecao {

    private final CasoDeUsoCriarSelecao casoDeUsoCriarSelecao;
    private final RepositorioDeSelecoes repositorioDeSelecoes;

    public ControleDeSelecao(
            CasoDeUsoCriarSelecao casoDeUsoCriarSelecao,
            RepositorioDeSelecoes repositorioDeSelecoes
    ) {
        this.casoDeUsoCriarSelecao = casoDeUsoCriarSelecao;
        this.repositorioDeSelecoes = repositorioDeSelecoes;
    }

    @GetMapping()
    public ResponseEntity index() {
        List<Selecao> selecaoList = this.repositorioDeSelecoes.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(selecaoList);
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody CriarSelecaoDto dadosSelecao) {
        try {
            this.casoDeUsoCriarSelecao.executar(dadosSelecao);
            return ResponseEntity.status(HttpStatus.OK).body("Selecao criada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não é possível realizar a operação. Tente mais tarde.");
        }
    }
}
