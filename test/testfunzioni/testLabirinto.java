package testfunzioni;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class testLabirinto {
	private Labirinto labirinto;
    private Stanza atrio;
    private Stanza aulaN11;
    private Stanza aulaN10;
    private Stanza laboratorio;
    private Stanza biblioteca;
    private Attrezzo lanterna;
    private Attrezzo osso;

    @BeforeEach
    void setUp() {
        labirinto = new Labirinto();
        
        atrio = new Stanza("Atrio");
        aulaN11 = new Stanza("Aula N11");
        aulaN10 = new Stanza("Aula N10");
        laboratorio = new Stanza("Laboratorio Campus");
        biblioteca = new Stanza("Biblioteca");
        lanterna = new Attrezzo("lanterna", 3);
        osso = new Attrezzo("osso", 1);
    }

    @Test
    void testStanzeCollegateCorrettamente() {
        assertEquals(biblioteca, atrio.getStanzaAdiacente("nord"));
        assertEquals(aulaN11, atrio.getStanzaAdiacente("est"));
        assertEquals(aulaN10, atrio.getStanzaAdiacente("sud"));
        assertEquals(laboratorio, atrio.getStanzaAdiacente("ovest"));
        assertEquals(laboratorio, aulaN11.getStanzaAdiacente("est"));
        assertEquals(atrio, aulaN11.getStanzaAdiacente("ovest"));
        assertEquals(atrio, aulaN10.getStanzaAdiacente("nord"));
        assertEquals(aulaN11, aulaN10.getStanzaAdiacente("est"));
        assertEquals(laboratorio, aulaN10.getStanzaAdiacente("ovest"));
        assertEquals(atrio, laboratorio.getStanzaAdiacente("est"));
        assertEquals(aulaN11, laboratorio.getStanzaAdiacente("ovest"));
        assertEquals(atrio, biblioteca.getStanzaAdiacente("sud"));
    }

    @Test
    void testAttrezziNelleStanze() {
        assertTrue(aulaN10.hasAttrezzo("lanterna"));
        assertTrue(atrio.hasAttrezzo("osso"));
    }

    @Test
    void testStanzaInizialeEFinale() {
        assertEquals(atrio, labirinto.getStanzaIniziale());
        assertEquals(biblioteca, labirinto.getStanzaFinale());
    }

    @Test
    void testCollegamentiAdiacenti() {
        atrio.impostaStanzaAdiacente("nord", aulaN11);
        assertEquals(aulaN11, atrio.getStanzaAdiacente("nord"));
    }

}
