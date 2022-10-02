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

import br.com.crud.CRUD.DTO.RequisicaoNovoCliente;
import br.com.crud.CRUD.Models.Cliente;
import br.com.crud.CRUD.Repositories.ClienteRepository;

@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/cliente")
    public ModelAndView index(){
        List<Cliente> clientes = this.clienteRepository.findAll();

        ModelAndView mv = new ModelAndView("cliente/index");
        mv.addObject("clientes", clientes);
        return mv;
    }

    @GetMapping("/cliente/new")
    public String nnew(RequisicaoNovoCliente requisicao){
        return "cliente/new";
    }

    @PostMapping("/cliente")
    public ModelAndView create(@Valid RequisicaoNovoCliente requisicao, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("cliente/new");
            return mv;
        }else{
            Cliente cliente = requisicao.toCliente();
            this.clienteRepository.save(cliente);
    
            return new ModelAndView("redirect:/cliente/" + cliente.getId());
        }
        
    }

    @GetMapping("/cliente/{id}")
    public ModelAndView show(@PathVariable Long id){
        Optional<Cliente> optional = this.clienteRepository.findById(id);

        if(optional.isPresent()){
            Cliente cliente = optional.get();

            ModelAndView mv = new ModelAndView("cliente/show");
            mv.addObject("cliente", cliente);

            return mv;
        }
        else{
            return new ModelAndView("redirect:/cliente");
        }

    } 

    @GetMapping("/cliente/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, RequisicaoNovoCliente requisicao) {
        Optional<Cliente> optional = this.clienteRepository.findById(id);

        if (optional.isPresent()) {
            Cliente cliente = optional.get();
            requisicao.fromCliente(cliente);

            ModelAndView mv = new ModelAndView("cliente/edit");
            mv.addObject("clienteId", cliente.getId());

            return mv;

        }
        // não achou um registro na tabela Professor com o id informado
        else {
            ModelAndView mv = new ModelAndView("redirect:/cliente");
            mv.addObject("mensagem", "EDIT ERROR: Cliente #" + id + " não encontrado!");
            mv.addObject("erro", true);
            return mv;
        }
    }

    @PostMapping("/cliente/{id}")
    public ModelAndView update(@PathVariable Long id, @Valid RequisicaoNovoCliente requisicao, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("cliente/edit");
            mv.addObject("clienteId", id);
            /* ModelAndView mv = new ModelAndView("cliente/new"); */
            return mv;
        }else{
            Optional<Cliente> optional = this.clienteRepository.findById(id);
            
            if(optional.isPresent()){
                Cliente cliente = requisicao.toCliente(optional.get());
                this.clienteRepository.save(cliente);

                return new ModelAndView("redirect:/cliente/" + cliente.getId());
            }else{
                ModelAndView mv = new ModelAndView("redirect:/cliente");
                mv.addObject("mensagem", "UPDATE ERROR: Cliente #" + id + " não encontrado!");
                mv.addObject("erro", true);
                return mv;
            }
        }
    }

    @GetMapping("/cliente/{id}/delete")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("redirect:/cliente");

        try{
            this.clienteRepository.deleteById(id);
            mv.addObject("mensagem", "Cliente #" + id + " deletado com sucesso!");
            mv.addObject("erro", false);
        }
        catch(EmptyResultDataAccessException e){
            System.out.println(e);
            mv.addObject("mensagem", "Cliente #" + id + " não encontrado!");
            mv.addObject("erro", true);
        }
        return mv;
        
    }

}
