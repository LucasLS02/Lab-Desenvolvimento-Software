package app.Excecoes;

public class ExcecaoUsuarioJaCadastrado extends Exception{
        public ExcecaoUsuarioJaCadastrado(){
            super("Esse usuário já está cadastrado, então não pode ser cadastrado novamente.");
        }
    }

