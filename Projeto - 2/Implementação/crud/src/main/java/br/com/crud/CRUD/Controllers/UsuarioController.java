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

import br.com.crud.CRUD.DTO.RequisicaoNovoUsuario;
import br.com.crud.CRUD.Models.Usuario;
import br.com.crud.CRUD.Repositories.UsuarioRepository;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuario")
    public ModelAndView index(){
        List<Usuario> usuarios = this.usuarioRepository.findAll();

        ModelAndView mv = new ModelAndView("usuario/index");
        mv.addObject("usuarios", usuarios);
        return mv;
    }

    @GetMapping("/usuario/new")
    public String nnew(RequisicaoNovoUsuario requisicao){
        return "usuario/new";
    }

    @PostMapping("/usuario")
    public ModelAndView create(@Valid RequisicaoNovoUsuario requisicao, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("usuario/new");
            return mv;
        }else{
            Usuario usuario = requisicao.toUsuario();
            this.usuarioRepository.save(usuario);
    
            return new ModelAndView("redirect:/usuario/" + usuario.getId());
        }
        
    }

    @GetMapping("/usuario/{id}")
    public ModelAndView show(@PathVariable Long id){
        Optional<Usuario> optional = this.usuarioRepository.findById(id);

        if(optional.isPresent()){
            Usuario usuario = optional.get();

            ModelAndView mv = new ModelAndView("usuario/show");
            mv.addObject("usuario", usuario);

            return mv;
        }
        else{
            return new ModelAndView("redirect:/usuario");
        }

    } 

    @GetMapping("/usuario/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, RequisicaoNovoUsuario requisicao) {
        Optional<Usuario> optional = this.usuarioRepository.findById(id);

        if (optional.isPresent()) {
            Usuario usuario = optional.get();
            requisicao.fromUsuario(usuario);

            ModelAndView mv = new ModelAndView("usuario/edit");
            mv.addObject("usuarioId", usuario.getId());

            return mv;

        }
        // não achou um registro na tabela Professor com o id informado
        else {
            ModelAndView mv = new ModelAndView("redirect:/usuario");
            mv.addObject("mensagem", "EDIT ERROR: Usuário #" + id + " não encontrado!");
            mv.addObject("erro", true);
            return mv;
        }
    }

    @PostMapping("/usuario/{id}")
    public ModelAndView update(@PathVariable Long id, @Valid RequisicaoNovoUsuario requisicao, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("usuario/edit");
            mv.addObject("usuarioId", id);
            /* ModelAndView mv = new ModelAndView("usuario/new"); */
            return mv;
        }else{
            Optional<Usuario> optional = this.usuarioRepository.findById(id);
            
            if(optional.isPresent()){
                Usuario usuario = requisicao.toUsuario(optional.get());
                this.usuarioRepository.save(usuario);

                return new ModelAndView("redirect:/usuario/" + usuario.getId());
            }else{
                ModelAndView mv = new ModelAndView("redirect:/usuario");
                mv.addObject("mensagem", "UPDATE ERROR: Usuário #" + id + " não encontrado!");
                mv.addObject("erro", true);
                return mv;
            }
        }
    }

    @GetMapping("/usuario/{id}/delete")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("redirect:/usuario");

        try{
            this.usuarioRepository.deleteById(id);
            mv.addObject("mensagem", "Usuário #" + id + " deletado com sucesso!");
            mv.addObject("erro", false);
        }
        catch(EmptyResultDataAccessException e){
            System.out.println(e);
            mv.addObject("mensagem", "Usuário #" + id + " não encontrado!");
            mv.addObject("erro", true);
        }
        return mv;
        
    }

}
