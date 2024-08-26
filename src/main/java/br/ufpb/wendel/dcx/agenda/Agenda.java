package br.ufpb.wendel.dcx.agenda;

import java.io.IOException;
import java.util.Collection;

public interface Agenda {
    public boolean cadastraContato(String nome, int dia, int mes);
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes);
    public boolean removeContato(String nome) throws ContatoInexistenteException;
    public void salvarDados(String nomeArquivo) throws IOException;
    public void recuperarDados(String nomeArquivo) throws IOException;
}
