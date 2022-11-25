package TransacoesEVantagens;

import java.io.IOException;

import Arquivos.ManipuladorArquivo;
import Usuario.Usuario;

public class Transacao {
    private static int ID = 0;
    private int id_transacao;
    private Usuario usuario_remetente;
    private Usuario usuario_destinatario;
    private int quantidade_moedas;
    private String motivoTransacao;

    public Transacao(Usuario usuario_remetente, Usuario usuario_destinatario, int quantidade_moedas, String motivoTransacao) throws IOException {
        ID = ID + 1;
        setId_transacao(String.valueOf(ID));
        setUsuario_remetente(usuario_remetente);
        setUsuario_destinatario(usuario_destinatario);
        setQuantidade_moedas(quantidade_moedas);
        setMotivoTransacao(motivoTransacao);
        ManipuladorArquivo.escritor("/Users/lucas/Desktop/Faculdade/4 Período/Laboratorio de desenvolvimento de software/Lab-Desenvolvimento-Software/Projeto - 4/vantagens.txt", this.toString(), true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transacao transacao)) return false;

        if (quantidade_moedas != transacao.quantidade_moedas) return false;
        if (!usuario_remetente.getNome().equals(transacao.usuario_remetente.getNome())) return false;
        return usuario_destinatario.getNome().equals(transacao.usuario_destinatario.getNome());
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
                ", usuario_remetente='" + usuario_remetente.getNome() + '\'' +
                ", usuario_destinatario='" + usuario_destinatario.getNome() + '\'' +
                ", quantidade_moedas=" + quantidade_moedas +
                ", motivoTransacao='" + motivoTransacao + '\'' +
                '}';
    }

    public int getId_transacao() {
        return id_transacao;
    }

    public void setId_transacao(String id_transacao) {
        this.id_transacao = Integer.parseInt(id_transacao);
    }

    public Usuario getUsuario_remetente() {
        return usuario_remetente;
    }

    public void setUsuario_remetente(Usuario usuario_remetente) {
        this.usuario_remetente = usuario_remetente;
    }

    public Usuario getUsuario_destinatario() {
        return usuario_destinatario;
    }

    public void setUsuario_destinatario(Usuario usuario_destinatario) {
        this.usuario_destinatario = usuario_destinatario;
    }

    public int getQuantidade_moedas() {
        return quantidade_moedas;
    }

    public void setQuantidade_moedas(int quantidade_moedas) {
        this.quantidade_moedas = quantidade_moedas;
    }

	public String getMotivoTransacao() {
		return motivoTransacao;
	}

	public void setMotivoTransacao(String motivoTransacao) {
		this.motivoTransacao = motivoTransacao;
	}
}
