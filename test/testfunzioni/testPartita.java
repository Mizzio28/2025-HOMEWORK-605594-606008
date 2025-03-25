package testfunzioni;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class testPartita {
	private Partita partita;
    private Stanza stanzaIniziale;
    private Stanza stanzaVincente;

    @BeforeEach
    void setUp() {
        partita = new Partita();
        stanzaIniziale = partita.getStanzaCorrente();
        stanzaVincente = partita.getStanzaVincente();
    }

    @Test
    void testCreazionePartita() {
        assertNotNull(partita);
        assertEquals(stanzaIniziale, partita.getStanzaCorrente());
        assertEquals(stanzaVincente, partita.getStanzaVincente());
    }

    @Test
    void testVittoria() {
        partita.setStanzaCorrente(stanzaVincente);
        assertTrue(partita.vinta());  
        Stanza altraStanza = new Stanza("Altra Stanza");
        partita.setStanzaCorrente(altraStanza);
        assertFalse(partita.vinta());  
    }

    @Test
    void testIsFinita() {
        partita.setCfu(0);  
        assertTrue(partita.isFinita());  

        partita.setCfu(10);  
        partita.setStanzaCorrente(stanzaVincente);  
        assertTrue(partita.isFinita());  
    }

    @Test
    void testModificaCfu() {
        int cfuIniziali = partita.getCfu();
        partita.setCfu(cfuIniziali - 1); 
        assertEquals(cfuIniziali - 1, partita.getCfu()); 

        partita.setCfu(cfuIniziali);  
        assertEquals(cfuIniziali, partita.getCfu());  
    }

    @Test
    void testSetFinita() {
        partita.setFinita();
        assertTrue(partita.isFinita());  
    }

}
