package br.com.crud.CRUD.Controllers;

/* import java.util.Arrays; */
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.crud.CRUD.DTO.RequisicaoNovoVeiculo;
import br.com.crud.CRUD.Models.Veiculo;
import br.com.crud.CRUD.Repositories.VeiculoRepository;

@Controller
public class VeiculoController {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping("/veiculo")
    public ModelAndView index(){
        List<Veiculo> veiculos = this.veiculoRepository.findAll();

        ModelAndView mv = new ModelAndView("veiculo/index");
        mv.addObject("veiculos", veiculos);
        return mv;
    }

    @GetMapping("/veiculo/new")
    public String nnew(RequisicaoNovoVeiculo requisicao){
        return "veiculo/new";
    }

    @PostMapping("/veiculo")
    public ModelAndView create(@Valid RequisicaoNovoVeiculo requisicao, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("veiculo/new");
            return mv;
        }else{
            Veiculo veiculo = requisicao.toVeiculo();
            this.veiculoRepository.save(veiculo);
    
            return new ModelAndView("redirect:/veiculo/" + veiculo.getId());
        }
        
    }

    @GetMapping("/veiculo/{id}")
    public ModelAndView show(@PathVariable Long id){
        Optional<Veiculo> optional = this.veiculoRepository.findById(id);

        if(optional.isPresent()){
            Veiculo veiculo = optional.get();

            ModelAndView mv = new ModelAndView("veiculo/show");
            mv.addObject("veiculo", veiculo);

            return mv;
        }
        else{
            return new ModelAndView("redirect:/veiculo");
        }

    } 

    @GetMapping("/veiculo/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, RequisicaoNovoVeiculo requisicao) {
        Optional<Veiculo> optional = this.veiculoRepository.findById(id);

        if (optional.isPresent()) {
            Veiculo veiculo = optional.get();
            requisicao.fromVeiculo(veiculo);

            ModelAndView mv = new ModelAndView("veiculo/edit");
            mv.addObject("veiculoId", veiculo.getId());

            return mv;

        }
        // não achou um registro na tabela Professor com o id informado
        else {
            ModelAndView mv = new ModelAndView("redirect:/veiculo");
            mv.addObject("mensagem", "EDIT ERROR: Veículo #" + id + " não encontrado!");
            mv.addObject("erro", true);
            return mv;
        }
    }

    @PostMapping("/veiculo/{id}")
    public ModelAndView update(@PathVariable Long id, @Valid RequisicaoNovoVeiculo requisicao, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("veiculo/edit");
            mv.addObject("veiculoId", id);
            /* ModelAndView mv = new ModelAndView("veiculo/new"); */
            return mv;
        }else{
            Optional<Veiculo> optional = this.veiculoRepository.findById(id);
            
            if(optional.isPresent()){
                Veiculo veiculo = requisicao.toVeiculo(optional.get());
                this.veiculoRepository.save(veiculo);

                return new ModelAndView("redirect:/veiculo/" + veiculo.getId());
            }else{
                ModelAndView mv = new ModelAndView("redirect:/veiculo");
                mv.addObject("mensagem", "UPDATE ERROR: Veículo #" + id + " não encontrado!");
                mv.addObject("erro", true);
                return mv;
            }
        }
    }

    @GetMapping("/veiculo/{id}/delete")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("redirect:/veiculo");

        try{
            this.veiculoRepository.deleteById(id);
            mv.addObject("mensagem", "Veículo #" + id + " deletado com sucesso!");
            mv.addObject("erro", false);
        }
        catch(EmptyResultDataAccessException e){
            System.out.println(e);
            mv.addObject("mensagem", "Veículo #" + id + " não encontrado!");
            mv.addObject("erro", true);
        }
        return mv;
        
    }

}
