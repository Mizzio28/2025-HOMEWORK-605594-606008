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
        stanza1 = new Stanza("Stanza 1");
        stanza2 = new Stanza("Stanza 2");

        attrezzo1 = new Attrezzo("Spada", 1);
        attrezzo2 = new Attrezzo("Scudo", 2);
    }

    @Test
    void testCreazioneStanza() {
        assertEquals("Stanza 1", stanza1.getNome());
    }
    
    @Test 
    void testStanzaNulla() {
    	assertNotNull(stanza1);
    }
    
    //Aggiungi attrezzo non va

    @Test
    void testAggiungiAttrezzo1() {
        // Testa che un attrezzo venga aggiunto correttamente
        assertTrue(stanza1.addAttrezzo(attrezzo1));
        assertTrue(stanza1.hasAttrezzo("Spada"));
    }
    
    @Test
    void testAggiungiAttrezzo2() {
        // Testa che un attrezzo venga aggiunto correttamente
        assertTrue(stanza1.addAttrezzo(attrezzo2));
        assertFalse(stanza1.hasAttrezzo("Spada"));
    }
    
    @Test
    void testAggiungiAttrezzo3() {
        // Testa che un attrezzo venga aggiunto correttamente
        assertTrue(stanza1.addAttrezzo(attrezzo2));
        assertTrue(stanza1.hasAttrezzo("Scudo"));
    }

    @Test
    void testAggiungiAttrezziLimite() {
        for (int i = 0; i < 10; i++) {
            stanza1.addAttrezzo(new Attrezzo("Attrezzo" + i, i));
        }
        assertFalse(stanza1.addAttrezzo(new Attrezzo("Attrezzo11", 11)));
    }
    

    @Test
    void testGetAttrezzo() {
        stanza1.addAttrezzo(attrezzo1);
        Attrezzo attrezzoRestituito = stanza1.getAttrezzo("Spada");
        assertNotNull(attrezzoRestituito);
        assertEquals("Spada", attrezzoRestituito.getNome());
    }

    @Test
    void testImpostaStanzaAdiacente() {
        stanza1.impostaStanzaAdiacente("nord", stanza2);
        Stanza stanzaAdiacente = stanza1.getStanzaAdiacente("nord");
        assertNotNull(stanzaAdiacente);
        assertEquals("Stanza 2", stanzaAdiacente.getNome());
    }

    @Test
    void testImpostaStanzaAdiacente2() {
        stanza2.impostaStanzaAdiacente("sud", stanza1);
        Stanza stanzaAdiacente = stanza2.getStanzaAdiacente("sud");
        assertNotNull(stanzaAdiacente);
        assertEquals("Stanza 1", stanzaAdiacente.getNome());
    }
    
    @Test
    void testGetDirezioni() {
        stanza1.impostaStanzaAdiacente("nord", stanza2);
        String[] direzioni = stanza1.getDirezioni();
        assertEquals(1, direzioni.length);
        assertEquals("nord", direzioni[0]);
    }
    
    @Test
    void testHasAttrezzo1() {
        // Testa che la funzione hasAttrezzo funzioni correttamente
        stanza1.addAttrezzo(attrezzo1);
        assertTrue(stanza1.hasAttrezzo("Spada"));
        assertFalse(stanza1.hasAttrezzo("Scudo"));
    }

    @Test
    void testHasAttrezzo2() {
        // Testa che la funzione hasAttrezzo funzioni correttamente
        stanza1.addAttrezzo(attrezzo2);
        assertTrue(stanza1.hasAttrezzo("Scudo"));
        assertFalse(stanza1.hasAttrezzo("Spada"));
    }
    
    @Test
    void testHasAttrezzo3() {
        // Testa che la funzione hasAttrezzo funzioni correttamente
        stanza1.addAttrezzo(attrezzo1);
        stanza2.addAttrezzo(attrezzo2);
        assertFalse(stanza1.hasAttrezzo("Scudo"));
        assertTrue(stanza1.hasAttrezzo("Spada"));
    }
}
