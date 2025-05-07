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
import it.uniroma3.diadia.comandi.ComandoVai;

class testComandoVai {

	private Partita partita;
	private Stanza s1;
	private Stanza s2;
	private IO ioTest;
	private Comando comando;
	
	@BeforeEach
	void setUp() {
		s1 = new Stanza("aula1");
		s2 = new Stanza("aula2");
		partita = new Partita();
		comando = new ComandoVai();
		ioTest = new IOConsole();
		comando.setIo(ioTest);
	}
	
	@Test
    void testVaiStanzaDirezione() {
		partita.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("nord", s2);
		comando.setParametro("nord");
		comando.esegui(partita);
		assertEquals(s2, partita.getStanzaCorrente());
    }
	
	@Test
    void testVaiStanzaNonDirezione() {
		partita.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud", s2);
		comando.setParametro("nord");
		comando.esegui(partita);
		assertNotEquals(s2, partita.getStanzaCorrente());
    }
	
	@Test
    void testVaiNull() {
		partita.setStanzaCorrente(s1);
		comando.esegui(partita);
		assertEquals(s1, partita.getStanzaCorrente());
    }

}
