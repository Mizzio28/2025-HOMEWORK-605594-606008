package testfunzioni;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class testFabbricaDiComandiFisarmonica {

	private FabbricaDiComandiFisarmonica industria;
	private IO io;
	private Comando comando;
	
	@BeforeEach
	void setUp() {
		io = new IOConsole();
		industria = new FabbricaDiComandiFisarmonica(io);
	}
	
	@Test
    void testComandoNonValido() {
		comando = new ComandoNonValido();
		assertEquals(comando.getNome(), industria.costruisciComando("prova").getNome());
    }
	
	@Test
    void testComandoParametro() {
		comando = new ComandoPrendi();
		comando.setParametro("Spada");
		Comando prova = industria.costruisciComando("Spada");
		assertEquals(comando.getNome(), prova.getNome());
		assertEquals(comando.getParametro(), prova.getParametro());
    }
	
	@Test
	public void testComandoSenzaParametro() {
		comando = new ComandoFine();
		assertEquals( comando.getNome(), industria.costruisciComando("fine").getNome());
	}

}
