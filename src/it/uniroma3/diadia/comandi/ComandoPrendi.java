package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "prendi";

	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(partita.getGiocatore().getBorsa().getPesoRimanente(a)) {
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getStanzaCorrente().removeAttrezzo(a);
			io.mostraMessaggio("Attrezzo messo nella borsa!");
		} 
		else {
			io.mostraMessaggio("Questo attrezzo non è nella stanza o è troppo pesante per la tua borsa!");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo  = parametro;

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	
	//Override
	public String getNome() {
		return NOME;
	}
}


/*
 * if (attrezzo != null) {
            if (partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
                stanza.removeAttrezzo(attrezzo);
                System.out.println("Hai inserito nella borsa l'attrezzo: " + attrezzo.getNome());
            } else {
                System.out.println("Purtroppo non hai più spazio nella borsa!");
            }
        } else {
            System.out.println("Purtroppo questo attrezzo non è presente nella stanza");
        }
        System.out.println("La tua borsa al momento pesa: " + partita.getGiocatore().getBorsa().getPeso() + "Kg");
 */
