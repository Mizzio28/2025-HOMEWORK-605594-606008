package testfunzioni;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class testStanza {

	private Stanza stanza1;
    private Stanza stanza2;
    private Attrezzo attrezzo1;
    private Attrezzo attrezzo2;
    
    //Tutti i prossimi commenti con @ sono come li vuole il prof, sta scritto sul powerpoint 8

    @BeforeEach
    void setUp() {
        // Crea stanze per i test
        stanza1 = new Stanza("Stanza 1");
        stanza2 = new Stanza("Stanza 2");

        // Crea alcuni attrezzi
        attrezzo1 = new Attrezzo("Spada", 1);
        attrezzo2 = new Attrezzo("Scudo", 2);
    }

    @Test
    void testCreazioneStanza() {
        // Testa la creazione della stanza
        assertEquals("Stanza 1", stanza1.getNome());
    }

    @Test
    void testAggiungiAttrezzo() {
        // Testa che un attrezzo venga aggiunto correttamente
        assertTrue(stanza1.addAttrezzo(attrezzo1));
        assertTrue(stanza1.hasAttrezzo("Spada"));
    }

    @Test
    void testAggiungiAttrezziLimite() {
        // Testa il limite massimo di attrezzi
        for (int i = 0; i < 10; i++) {
            stanza1.addAttrezzo(new Attrezzo("Attrezzo" + i, i));
        }
        // Se il limite è 10, allora non dovrebbe poter aggiungere un altro attrezzo
        assertFalse(stanza1.addAttrezzo(new Attrezzo("Attrezzo11", 11)));
    }

    @Test
    void testGetAttrezzo() {
        // Testa che l'attrezzo venga correttamente restituito
        stanza1.addAttrezzo(attrezzo1);
        Attrezzo attrezzoRestituito = stanza1.getAttrezzo("Spada");
        assertNotNull(attrezzoRestituito);
        assertEquals("Spada", attrezzoRestituito.getNome());
    }

    @Test
    void testImpostaStanzaAdiacente() {
        // Testa che la stanza adiacente venga impostata correttamente
        stanza1.impostaStanzaAdiacente("nord", stanza2);
        Stanza stanzaAdiacente = stanza1.getStanzaAdiacente("nord");
        assertNotNull(stanzaAdiacente);
        assertEquals("Stanza 2", stanzaAdiacente.getNome());
    }

    @Test
    void testGetDirezioni() {
        // Testa che le direzioni siano correttamente memorizzate
        stanza1.impostaStanzaAdiacente("nord", stanza2);
        String[] direzioni = stanza1.getDirezioni();
        assertEquals(1, direzioni.length);
        assertEquals("nord", direzioni[0]);
    }

    @Test
    void testHasAttrezzo() {
        // Testa che la funzione hasAttrezzo funzioni correttamente
        stanza1.addAttrezzo(attrezzo1);
        assertTrue(stanza1.hasAttrezzo("Spada"));
        assertFalse(stanza1.hasAttrezzo("Scudo"));
    }

}
