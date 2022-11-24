package Usuario;

public class Usuario_login extends Usuario {

    private boolean is_looged;
    private String username;
    private String senha;

    protected Usuario_login(String nome, String email, String cpf, String rg, String endereco, String username,
            String senha) {
        super(nome, email, cpf, rg, endereco);
        setUsername(username);
        setSenha(senha);
        setIs_looged(false);
    }

    public static Usuario_login realizar_cadastro(String nome, String email, String cpf, String rg, String endereco,
            String username, String senha) {
        return new Usuario_login(nome, email, cpf, rg, endereco, username, senha);
    }

    public String realizar_login(String username, String senha) {
        String response = "";
        if (isIs_looged()) {
            response = "Usuário já está logado";
        } else {
            if (getUsername().equals(username) && getSenha().equals(senha)) {
                setIs_looged(true);
                response = "Usuário logou com sucesso";
            } else {
                response = "Usuário ou senha incorreto";
            }
        }
        return response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Usuario_login that))
            return false;
        if (!super.equals(o))
            return false;

        if (is_looged != that.is_looged)
            return false;
        if (!username.equals(that.username))
            return false;
        return senha.equals(that.senha);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (is_looged ? 1 : 0);
        result = 31 * result + username.hashCode();
        result = 31 * result + senha.hashCode();
        return result;
    }

    public boolean isIs_looged() {
        return is_looged;
    }

    public void setIs_looged(boolean is_looged) {
        this.is_looged = is_looged;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Usuario_login{" +
                "is_looged=" + is_looged +
                ", username='" + username + '\'' +
                ", senha='" + senha + '\'' +
                "} ";
    }
}
