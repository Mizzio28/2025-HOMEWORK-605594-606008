package testfunzioni;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
class testStanzaBloccata {

	private Stanza s;
	private StanzaBloccata sb;
	private Attrezzo a;
	
	@BeforeEach
    void setUp() {
        s = new Stanza("aula1");
        sb = new StanzaBloccata("StanzaB", "est", "piedediporco");
        a = new Attrezzo("piedediporco", 1);
        sb.impostaStanzaAdiacente("est", s);
    }
	
	@Test
    void testGetStanzaAdiacenteDirezione() {
        assertEquals(s, sb.getStanzaAdiacente("est"));
    }
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(s, sb.getStanzaAdiacente("est"));
		
	}
	
	@Test
    public void testGetStanzaAdiacenteDirezioneSbloccataFalso() {
        sb.addAttrezzo(a);
        assertNull(sb.getStanzaAdiacente("ovest"));
    }

}
