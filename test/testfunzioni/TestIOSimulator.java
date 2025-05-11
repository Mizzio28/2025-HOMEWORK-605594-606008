package testfunzioni;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.IOSimulator;

class TestIOSimulator {

    private IOSimulator ioSimulator;

    @BeforeEach
    void setUp() {
        String[] righeDaLeggere = {"Comando 1", "Comando 2", "Comando 3"};
        ioSimulator = new IOSimulator(righeDaLeggere);
    }

    @Test
    void testLeggiRiga() {
        assertEquals("Comando 1", ioSimulator.leggiRiga());
        assertEquals("Comando 2", ioSimulator.leggiRiga());
        assertEquals("Comando 3", ioSimulator.leggiRiga());
    }

    @Test
    void testMostraMessaggio() { 
        ioSimulator.mostraMessaggio("Messaggio 1");
        ioSimulator.mostraMessaggio("Messaggio 2"); 
        assertEquals("Messaggio 1", ioSimulator.nextMessaggio());
        assertEquals("Messaggio 2", ioSimulator.nextMessaggio());
    }

    @Test
    void testHasNextMessaggio() {
        ioSimulator.mostraMessaggio("Messaggio 1");       
        assertTrue(ioSimulator.hasNextMessaggio());
        ioSimulator.nextMessaggio();
        assertFalse(ioSimulator.hasNextMessaggio());
    }
}