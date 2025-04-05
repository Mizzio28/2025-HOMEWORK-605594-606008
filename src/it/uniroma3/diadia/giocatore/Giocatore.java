package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Giocatore {
	private int cfu;
    private Borsa borsa;

    public Giocatore(int cfu) {
        this.cfu = cfu;
        this.borsa = new Borsa();
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public Borsa getBorsa() {
        return borsa;
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        return borsa.addAttrezzo(attrezzo);
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
        return borsa.hasAttrezzo(nomeAttrezzo);
    }

    public boolean removeAttrezzo(String nomeAttrezzo) {
        return borsa.removeAttrezzo(nomeAttrezzo) != null;
    }

    
    //Da decidere se mettere questo messaggio
    /*
    public String toString() {
        return "Giocatore con " + cfu + " CFU e " + borsa.toString();
    }
    */

}
