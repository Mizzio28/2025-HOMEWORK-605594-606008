package testfunzioni;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;

class TestComandoPosa {
	private Partita partita;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private IO io;
	private Comando comando;
	private Stanza stanza; 
	
	
	@BeforeEach
void setup() {
		this.partita = new Partita();
		Stanza stanza = new Stanza("Stanza");
		this.partita.setStanzaCorrente(stanza);
		attrezzo1 = new Attrezzo("Spada",1);
		attrezzo2 = new Attrezzo("Scudo",2);
		comando = new ComandoPosa();
		io = new IOConsole();
		comando.setIo(io);
		
	}
	
	@Test
	public void testPosaAttrezzo() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo1);
		comando.setParametro("Spada");
		comando.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("Spada"));
	}
	
	@Test
	public void tesComandoPosaNull() {
	comando.setParametro("Spada");
	comando.esegui(partita);
	assertFalse(partita.getStanzaCorrente().hasAttrezzo("Spada"));
	}
	
	
	public void creatoreAttrezzi() {	
		for(int i= 0; i<10;i++) {
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("attrezzo"+i, 1));
		}
	}
	
	@Test
	public void testTroppiAttrezzi() {
		this.creatoreAttrezzi();
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo1);
		comando.setParametro("Spada");
		comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("Spada"));
	}
	
}	
	
	
	