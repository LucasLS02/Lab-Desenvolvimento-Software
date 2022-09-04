package excecoes;

public class ExcecaoUsuarioJaCadastrado extends Exception{
        private static final long serialVersionUID = 1L;

		public ExcecaoUsuarioJaCadastrado(){
            super("Esse usuário já está cadastrado, então não pode ser cadastrado novamente.");
        }
    }

