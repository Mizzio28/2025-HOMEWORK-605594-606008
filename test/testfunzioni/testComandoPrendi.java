package testfunzioni;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class testComandoPrendi {

	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Partita partita;
	private IO ioTest;
	private Comando comando;
	
	@BeforeEach
	void setUp() {
		partita = new Partita();
		attrezzo1 = new Attrezzo("Spada", 1);
		attrezzo2 = new Attrezzo("Scudo", 2);
		attrezzo3 = new Attrezzo("Lingotto", 100);
		comando = new ComandoPrendi();
		ioTest = new IOConsole();
		comando.setIo(ioTest);
		
	}
	
	public boolean attrezzoPresente(String s) {
		Attrezzo[]seq = partita.getStanzaCorrente().getAttrezzi();
		for(Attrezzo a : seq) {
			if(a!=null && s.equals(a.getNome())) {
				return true;
			}
		}
		return false;
	}
	
	@Test
    void testAttrezzoPreso() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo1);
		comando.setParametro("Spada");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("Spada"));
    }
	
	@Test
    void testAttrezzoNonPreso() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo1);
		partita.getStanzaCorrente().addAttrezzo(attrezzo2);
		comando.setParametro("Scudo");
		comando.esegui(partita);
		assertTrue(attrezzoPresente("Spada"));
    }
	
	@Test
    void testAttrezziPresi() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo1);
		partita.getStanzaCorrente().addAttrezzo(attrezzo2);
		comando.setParametro("Spada");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("Spada"));
		comando.setParametro("Scudo");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("Scudo"));
    }
	
	@Test
    void testAttrezzoNonPresente() {
		comando.setParametro("Spada");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("Spada"));
    }
	
	@Test
    void testAttrezzoTroppoPesante() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo3);
		comando.setParametro("Lingotto");
		comando.esegui(partita);
		assertTrue(attrezzoPresente("Lingotto"));
    }
	
}
