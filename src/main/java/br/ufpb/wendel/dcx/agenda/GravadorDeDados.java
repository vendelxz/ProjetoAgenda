package br.ufpb.wendel.dcx.agenda;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    private static final String ARQUIVO_CONTATOS = "contatos.dat";

    public HashMap<String, Contato> recuperaContatos() throws IOException {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTATOS))){
            return (HashMap<String, Contato>) in.readObject();

        } catch (ClassNotFoundException e){
            throw new IOException("Arquivo .dat não existe");

        } catch (IOException e){
            throw new IOException(e);
        }

    }
    public void salvarContatos(HashMap<String, Contato> contatos) throws IOException{
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTATOS)){
            out.writeObject(contatos);

        } catch(IOException e ){
            throw new IOException(e);
        }
    }
}
