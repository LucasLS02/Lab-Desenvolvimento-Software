package Usuario;

public class Usuario {

    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private String endereco;

    protected Usuario(String nome, String email, String cpf, String rg, String endereco) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Usuario.Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;

        if (!nome.equals(usuario.nome)) return false;
        if (!email.equals(usuario.email)) return false;
        if (!cpf.equals(usuario.cpf)) return false;
        if (!rg.equals(usuario.rg)) return false;
        return endereco.equals(usuario.endereco);
    }

    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + cpf.hashCode();
        result = 31 * result + rg.hashCode();
        result = 31 * result + endereco.hashCode();
        return result;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}

