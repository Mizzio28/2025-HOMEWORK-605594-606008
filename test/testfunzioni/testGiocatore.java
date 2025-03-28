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
		// creo un giocatore da testare
		giocatore = new Giocatore();
		//prendiamo i cfu iniziali del giocatore
		cfu = giocatore.getCfu();	
		//creo un attrezzo da far gestire al giocatore
		attrezzo = new Attrezzo("Spada", 1);
	}
	@Test
	void testCreazioneGiocatore() {
		//verifica della partita creata correttamente 
		assertNotNull(giocatore);
		//verifica condizioni iniziali cfu giocatore
		assertEquals(cfu, giocatore.getCfu());
	}
	//test set e get cfu già fatti in partita
	@Test
    void testAggiungiAttrezzo() {
        // Testa che un attrezzo venga aggiunto correttamente
        assertTrue(giocatore.addAttrezzo(attrezzo));
        assertTrue(giocatore.hasAttrezzo("Spada"));
    }
	@Test
	void testHasAttrezzo() {
        // Testa che la funzione hasAttrezzo funzioni correttamente
        giocatore.addAttrezzo(attrezzo);
        assertTrue(giocatore.hasAttrezzo("Spada"));
        assertFalse(giocatore.hasAttrezzo("Scudo"));
    }
	@Test 
	 void testRemoveAttrezzo() {
        giocatore.addAttrezzo(attrezzo);
        assertTrue(giocatore.hasAttrezzo("Spada"));
        
        Boolean removed = giocatore.removeAttrezzo("Spada");
        assertEquals(attrezzo, removed);
        assertFalse(giocatore.hasAttrezzo("Spada"));
    }
}
