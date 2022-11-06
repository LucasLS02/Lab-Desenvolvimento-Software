package Interfaces;


import Transacao.Transacao;

import java.util.List;

public interface Usuario_visualizador {

    public List<Transacao> visualizar_extrato(String username);
    public Transacao visualizar_transacao(String id_transacao);
}
