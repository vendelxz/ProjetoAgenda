package br.ufpb.wendel.dcx.agenda;

import java.io.*;
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
        for(String key : this.contatos.keySet()){
            if(this.contatos.get(key).equals(nome)){
                this.contatos.remove(key);
                return true;
            }
        } throw new ContatoInexistenteException("Contato não existe no banco de dados");
    }

    @Override
    public void salvarDados(String nomeArquivo) throws IOException {
    try(FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
        ObjectOutputStream out = new ObjectOutputStream(fileOut)){
            out.writeObject(contatos);
        System.out.println("Dados salvos com sucesso"+ nomeArquivo);

        }catch (IOException e){
        System.err.println("Erro ao salvar dados"+ e.getMessage());
    }
    }

    @Override
    public void recuperarDados(String nomeArquivo) throws IOException {
        try(FileInputStream FileIn = new FileInputStream(nomeArquivo);
            ObjectInputStream in = new ObjectInputStream(FileIn)){
            contatos = (HashMap<String, Contato>) in.readObject();
            System.out.println("Dados recuperados com sucesso"+ nomeArquivo);

        } catch (IOException e){
            System.err.println("Erro ao recuperar dados"+ e.getMessage());

        } catch (ClassNotFoundException e){
        System.err.println("Classe não encontrada"+ e.getMessage());
        }
    }
}
