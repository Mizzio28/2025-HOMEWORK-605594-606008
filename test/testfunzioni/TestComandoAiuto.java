package testfunzioni;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.comandi.ComandoAiuto;

public class TestComandoAiuto {

    private IOSimulator io;
    private String[] righeDaLeggere;

    @BeforeEach
    public void setUp() {
        righeDaLeggere = new String[]{"aiuto", "fine"};
        io = new IOSimulator(righeDaLeggere);
        DiaDia gioco = new DiaDia(io);
        gioco.gioca();
    }


    @Test
    public void testElencoComandiStampato() {
        io.nextMessaggio(); 

        for (String comando : ComandoAiuto.ELENCO_COMANDI) {
            assertTrue(io.hasNextMessaggio());
            assertEquals(comando + " ", io.nextMessaggio());
        }
    }

    @Test
    public void testMessaggioVuotoDopoElenco() {
        io.nextMessaggio();
        for (int i = 0; i < ComandoAiuto.ELENCO_COMANDI.length; i++) {
            io.nextMessaggio();
        }

        assertTrue(io.hasNextMessaggio());
        assertEquals("", io.nextMessaggio());
    }

    @Test
    public void testMessaggioFine() {
        io.nextMessaggio();
        for (int i = 0; i < ComandoAiuto.ELENCO_COMANDI.length; i++) {
            io.nextMessaggio();
        }
        io.nextMessaggio();

        assertTrue(io.hasNextMessaggio());
        assertEquals("Grazie di aver giocato!", io.nextMessaggio());
    }
}
