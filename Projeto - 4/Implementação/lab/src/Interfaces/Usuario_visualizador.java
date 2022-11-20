package Interfaces;

import Excecoes.ExcecaoIdIncorreta;
import TransacoesEVantagens.Transacao;

public interface Usuario_visualizador {

    public String visualizar_extrato();
    public Transacao visualizar_transacao(int id_transacao) throws ExcecaoIdIncorreta;
}
