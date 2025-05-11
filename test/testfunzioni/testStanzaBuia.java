package testfunzioni;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.StanzaBuia;
class testStanzaBuia {

	private StanzaBuia sb;
	private Attrezzo al;
	
	@BeforeEach
	public void setUp() throws Exception {
		sb = new StanzaBuia("StanzaBuia", "lumino");
		al = new Attrezzo("lumino", 1);
	}

	@Test
	public void testGetDescrizioneConAttrezzo() {
		sb.addAttrezzo(al);
		assertEquals(sb.toString(), sb.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		String e = "qui c'è un buio pesto";
		assertEquals(e, sb.getDescrizione());
	}

}
