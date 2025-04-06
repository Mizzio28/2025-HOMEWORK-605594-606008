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
        partita.getGiocatore().setCfu(0);  
        assertTrue(partita.isFinita());   
    }
    
    @Test 
    void testIsFinita2()
    {  
        partita.setStanzaCorrente(stanzaVincente);  
        assertTrue(partita.isFinita()); 
    }
    @Test
    void testSetFinita() {
        partita.setFinita();
        assertTrue(partita.isFinita());  
    }

}
