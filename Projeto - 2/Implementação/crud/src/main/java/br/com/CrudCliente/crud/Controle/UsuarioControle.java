package br.com.CrudCliente.crud.Controle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.CrudCliente.crud.Usuario.UsuarioRepositorio;

@Controller
public class UsuarioControle {

    private UsuarioRepositorio userRepo;

    public UsuarioControle(UsuarioRepositorio userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping("/Usuario/users")
    public String users(Model model){
        model.addAttribute("listaUsers", userRepo.findAll());
        return "Usuario/users/index";
    }
}
