package testfunzioni;

import it.uniroma3.diadia.giocatore.Giocatore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class testGiocatore {
	private Giocatore giocatore;
	private int cfu; 
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp(){
		giocatore = new Giocatore(20);
		cfu = giocatore.getCfu();	
		attrezzo = new Attrezzo("Spada", 1);
	}
	@Test
	void testCreazioneGiocatore() {
		assertNotNull(giocatore);
		assertEquals(cfu, giocatore.getCfu());
	}

	@Test
    void testAggiungiAttrezzo1() {
        
        assertTrue(giocatore.addAttrezzo(attrezzo));
        assertTrue(giocatore.hasAttrezzo("Spada"));
    }
	
	@Test
    void testAggiungiAttrezzo2() {
        assertTrue(giocatore.addAttrezzo(attrezzo));
        assertFalse(giocatore.hasAttrezzo("Scudo"));
    }
	
	@Test
	void testHasAttrezzo1() {
        giocatore.addAttrezzo(attrezzo);
        assertTrue(giocatore.hasAttrezzo("Spada"));
    }
	
	@Test 
	void testHasAttrezzo2() {
		giocatore.addAttrezzo(attrezzo);
		assertFalse(giocatore.hasAttrezzo("Scudo"));
	}
	
	
	@Test 
	 void testRemoveAttrezzo() {
        giocatore.addAttrezzo(attrezzo);
        assertTrue(giocatore.hasAttrezzo("Spada"));
        Boolean removed = giocatore.removeAttrezzo("Spada");
        assertNotNull(removed);
        assertFalse(giocatore.hasAttrezzo("Spada"));
    }
}
