package br.ufpb.wendel.dcx.agenda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AgendaAyla implements Agenda {
    private Map<String, Contato> contatos = new HashMap<>();

    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {
        if(contatos.containsKey(nome) & contatos.containsValue(dia) & contatos.containsValue(mes)){
            return false;

        }
        Contato contato1 = new Contato(nome, dia, mes);
        contatos.put(nome,contato1  );
        return true;
    }

    @Override
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
       Collection<Contato> achados = new ArrayList<>();
        for(String key : this.contatos.keySet()){
            if(this.contatos.get(key).getMesAniversario() == mes){
                if(this.contatos.get(key).getDiaAniversario() == dia){
                    achados.add(this.contatos.get(key));
                }

            }
        } return achados;
    }

    @Override
    public boolean removeContato(String nome) throws ContatoInexistenteException {
        return false;
    }

    @Override
    public void salvarDados() throws IOException {

    }

    @Override
    public void recuperarDados() throws IOException {

    }
}
