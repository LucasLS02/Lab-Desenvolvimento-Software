package Interfaces;


import Transacao.Transacao;

import java.util.List;

import Excecoes.ExcecaoIdIncorreta;

public interface Usuario_visualizador {

    public String visualizar_extrato();
    public Transacao visualizar_transacao(int id_transacao) throws ExcecaoIdIncorreta;
}
