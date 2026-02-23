import java.util.Date;

/**
 * Rappresenta un singolo blocco della catena.
 * Ogni blocco contiene dati e un legame con il blocco precedente.
 */
public class Block {
    public String hash;
    public String previousHash;
    public String data;
    public long timeStamp;
    public int nonce;

    /**
     * Crea un nuovo blocco e ne calcola l'hash iniziale.
     */
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculate();
    }

    /**
     * Unisce i pezzi del blocco e li trasforma in un hash unico.
     */
    public String calculate() {
        // Uniamo tutti i dati del blocco in una stringa e passiamola al calcolatore
        String temp = CalculateHash.applySha256(previousHash + timeStamp + nonce + data);
        return temp;
    }

    /**
     * Cerca un hash che inizi con un certo numero di zeri (Mining).
     */
    public void mine(int difficulty) {
        // Creiamo la stringa di zeri che vogliamo trovare (es. "00")
        String target = "";
        for(int i=0; i<difficulty; i++)
            target += "0";

        // Finché l'hash non inizia con gli zeri del target, riprova cambiando il nonce
        while(!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculate();
        }
        System.out.println("Blocco Creato: " + hash);
    }
}