package br.edu.ifsp.PayNow.web.controller;

import br.com.caelum.vraptor.*;
import javax.inject.Inject;
import static java.util.Arrays.asList;
import br.edu.ifsp.PayNow.model.repository.PagadorRepository;
import br.edu.ifsp.PayNow.model.entity.Pagador;

@Controller
public class PagadorController {

    @Inject
    private Result result;

    @Inject
    PagadorRepository paganteRepository;

    public void lista() {
        result.include("pagandores", paganteRepository.todas());
    }

    public void adiciona() {

    }
    
    public void salva(Pagador pagador) {
        paganteRepository.salvar(pagador);
        result.redirectTo(PagadorController.class).resumo(pagador);
    }

    public void resumo(Pagador pagador) {
        result.include("resumo", pagador);
    }

    public String index() {
        return "ok";
    }
}
