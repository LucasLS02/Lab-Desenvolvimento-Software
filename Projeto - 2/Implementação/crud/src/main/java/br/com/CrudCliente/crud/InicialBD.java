package br.com.CrudCliente.crud;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.CrudCliente.crud.Usuario.Usuario;
import br.com.CrudCliente.crud.Usuario.UsuarioRepositorio;

@Component
@Transactional
public class InicialBD implements CommandLineRunner{
    
    /**
     * Atribuir um objeto automaticamente com base no tipo dele
     */
    @Autowired
    private UsuarioRepositorio userRepo;

    @Override
    public void run(String... args) throws Exception{
        Usuario user1 = new Usuario("Lucas");
        user1.setUsername("lucasLS");
        user1.setSenha("123");
        Usuario user2 = new Usuario("joao");
        user2.setUsername("jaoLS");
        user2.setSenha("1234");
        Usuario user3 = new Usuario("Julia");
        user3.setUsername("juLS");
        user3.setSenha("12342");

        userRepo.save(user1);
        userRepo.save(user2);
        userRepo.save(user3);
    }
}
