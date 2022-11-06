package Transacao;

public class Transacao {
    private static int ID = 0;
    private int id_transacao;
    private String usuario_remetente;
    private String usuario_destinatario;
    private int quantidade_moedas;

    public int getId_transacao() {
        return id_transacao;
    }

    public void setId_transacao(String id_transacao) {
        this.id_transacao = Integer.parseInt(id_transacao);
    }

    public String getUsuario_remetente() {
        return usuario_remetente;
    }

    public void setUsuario_remetente(String usuario_remetente) {
        this.usuario_remetente = usuario_remetente;
    }

    public String getUsuario_destinatario() {
        return usuario_destinatario;
    }

    public void setUsuario_destinatario(String usuario_destinatario) {
        this.usuario_destinatario = usuario_destinatario;
    }

    public int getQuantidade_moedas() {
        return quantidade_moedas;
    }

    public void setQuantidade_moedas(int quantidade_moedas) {
        this.quantidade_moedas = quantidade_moedas;
    }

    public Transacao(String usuario_remetente, String usuario_destinatario, int quantidade_moedas) {
        ID = ID + 1;
        setId_transacao(String.valueOf(ID));
        setUsuario_remetente(usuario_remetente);
        setUsuario_destinatario(usuario_destinatario);
        setQuantidade_moedas(quantidade_moedas);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transacao transacao)) return false;

        if (quantidade_moedas != transacao.quantidade_moedas) return false;
        if (!usuario_remetente.equals(transacao.usuario_remetente)) return false;
        return usuario_destinatario.equals(transacao.usuario_destinatario);
    }

    @Override
    public int hashCode() {
        int result = usuario_remetente.hashCode();
        result = 31 * result + usuario_destinatario.hashCode();
        result = 31 * result + quantidade_moedas;
        return result;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id_transacao=" + id_transacao +
                ", usuario_remetente='" + usuario_remetente + '\'' +
                ", usuario_destinatario='" + usuario_destinatario + '\'' +
                ", quantidade_moedas=" + quantidade_moedas +
                '}';
    }
}
