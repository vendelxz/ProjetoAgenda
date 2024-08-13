package br.ufpb.wendel.dcx.agenda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContatoTest {

    @Test
    public void TestaConstrutor(){
        Contato c1 = new Contato("Wendel",2,4);
        assertEquals(2, c1.getDiaAniversario());
        assertEquals("Wendel", c1.getNome());
    }
}
