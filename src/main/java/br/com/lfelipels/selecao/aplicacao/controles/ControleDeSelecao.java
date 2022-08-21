package br.com.lfelipels.selecao.aplicacao.controles;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/selecoes")
public class ControleDeSelecao {

    @GetMapping("/")
    public String index() {
        return "Selecoes";
    }
}
