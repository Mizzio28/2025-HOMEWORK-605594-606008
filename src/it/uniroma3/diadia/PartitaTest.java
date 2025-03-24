package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	private Partita partita;
    private Stanza stanzaIniziale;
    private Stanza stanzaVincente;

    @BeforeEach
    void setUp() {
        // Prima di ogni test, creiamo una nuova partita
        partita = new Partita();
        // Otteniamo la stanza iniziale e quella vincente
        stanzaIniziale = partita.getStanzaCorrente();
        stanzaVincente = partita.getStanzaVincente();
    }

    @Test
    void testCreazionePartita() {
        // Verifica che la partita venga creata correttamente
        assertNotNull(partita);
        // Verifica che la stanza corrente sia la stanza iniziale
        assertEquals(stanzaIniziale, partita.getStanzaCorrente());
        // Verifica che la stanza vincente sia correttamente impostata
        assertEquals(stanzaVincente, partita.getStanzaVincente());
    }

    @Test
    void testVittoria() {
        // Testa la logica di vittoria
        // Se la stanza corrente è la stessa della stanza vincente, la partita è vinta
        partita.setStanzaCorrente(stanzaVincente);
        assertTrue(partita.vinta());  // Dovrebbe essere vera se siamo nella stanza vincente

        // Se siamo in una stanza diversa dalla vincente, non è vinta
        Stanza altraStanza = new Stanza("Altra Stanza");
        partita.setStanzaCorrente(altraStanza);
        assertFalse(partita.vinta());  // Dovrebbe essere falsa
    }

    @Test
    void testIsFinita() {
        // Verifica che la partita finisca correttamente in base alla logica
        partita.setCfu(0);  // Imposta CFU a 0
        assertTrue(partita.isFinita());  // La partita dovrebbe essere finita quando i CFU sono 0

        partita.setCfu(10);  // Rimuove il flag della fine partita
        partita.setStanzaCorrente(stanzaVincente);  // Simula la vittoria
        assertTrue(partita.isFinita());  // La partita è finita anche se vinta
    }

    @Test
    void testModificaCfu() {
        // Testa la modifica dei CFU
        int cfuIniziali = partita.getCfu();
        partita.setCfu(cfuIniziali - 1);  // Decrementa i CFU
        assertEquals(cfuIniziali - 1, partita.getCfu());  // Verifica che i CFU siano diminuiti

        partita.setCfu(cfuIniziali);  // Riporta i CFU al valore iniziale
        assertEquals(cfuIniziali, partita.getCfu());  // Verifica che i CFU siano uguali al valore iniziale
    }

    @Test
    void testSetFinita() {
        // Testa che il metodo setFinita() imposti correttamente lo stato della partita
        partita.setFinita();
        assertTrue(partita.isFinita());  // La partita dovrebbe essere finita
    }

}
